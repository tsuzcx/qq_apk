package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.vl;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.plugin.record.model.x;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.f.a;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordMsgDetailUI
  extends RecordMsgBaseUI
{
  private com.tencent.mm.protocal.b.a.c NBI;
  private boolean NBJ;
  private String NBK;
  private String NBL;
  private boolean NBM;
  IListener<vl> NBN;
  private i NBi;
  private String NBq;
  private String NBr;
  private boolean hTH;
  private String hXv;
  private cc hzO;
  private w lKp;
  private long msgId;
  private String title;
  
  public RecordMsgDetailUI()
  {
    AppMethodBeat.i(305277);
    this.NBI = null;
    this.msgId = -1L;
    this.hXv = null;
    this.hTH = true;
    this.NBJ = false;
    this.title = "";
    this.NBK = "";
    this.NBL = "";
    this.lKp = null;
    this.NBq = "";
    this.NBr = "";
    this.NBN = new RecordMsgDetailUI.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(305277);
  }
  
  private String a(com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(27887);
    int i;
    com.tencent.mm.protocal.b.a.c localc;
    String str2;
    String str1;
    if (paramc != null)
    {
      Iterator localIterator = paramc.nUC.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (arf)localIterator.next();
        if (paramc.Zzy.ZAf.ZAT != null)
        {
          str1 = getContext().getString(R.l.record_chatroom_title);
          i = 1;
        }
        else
        {
          if (paramc.Zzy.ZAf.hQQ == null) {
            break label228;
          }
          if (str2 == null)
          {
            str2 = paramc.ZzA;
          }
          else
          {
            if (str2 == paramc.ZzA) {
              break label228;
            }
            paramc = paramc.ZzA;
            localc = paramc;
          }
        }
      }
      if ((str2 != null) && (localc == null) && (i == 0)) {
        paramc = getContext().getString(R.l.favorite_record_chatroom_title, new Object[] { str2 });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27887);
      return paramc;
      paramc = str1;
      if (str2 != null)
      {
        paramc = str1;
        if (localc != null)
        {
          paramc = str1;
          if (!str2.equals(localc))
          {
            paramc = str1;
            if (i == 0)
            {
              paramc = getContext().getString(R.l.favorite_record_chat_title, new Object[] { str2, localc });
              continue;
              label228:
              paramc = localc;
              break;
              paramc = null;
            }
          }
        }
      }
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(27888);
    f localf = new f();
    if (this.NBI != null) {
      localf.NBa = this.NBI.nUC;
    }
    localf.msgId = this.msgId;
    localf.hXv = this.hXv;
    localf.NBq = this.NBq;
    localf.NBr = this.NBr;
    localf.NBb = new x();
    if ((this.hzO != null) && (!this.NBM) && (this.hzO.field_transContent != null)) {}
    try
    {
      localf.NBb.parseFrom(this.hzO.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.gGm();
      this.NBE.a(localf);
      this.NBi = new i(this, this.NBE, localf);
      this.NBE.NBi = this.NBi;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((e)this.NBE);
      AppMethodBeat.o(27888);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.RecordMsgDetailUI", localException, "", new Object[0]);
      }
    }
  }
  
  protected final void gGm()
  {
    AppMethodBeat.i(27886);
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.hXv = getIntent().getStringExtra("record_xml");
    this.hTH = getIntent().getBooleanExtra("record_show_share", true);
    this.NBJ = getIntent().getBooleanExtra("big_appmsg", false);
    this.NBM = getIntent().getBooleanExtra("record_nest", false);
    this.NBq = getIntent().getStringExtra("pre_username");
    if (Util.isNullOrNil(this.NBq)) {
      this.NBq = getIntent().getStringExtra("msgUsername");
    }
    this.NBr = getIntent().getStringExtra("serverMsgID");
    this.NBI = q.aSH(this.hXv);
    bh.bCz();
    this.hzO = com.tencent.mm.model.c.bzD().sl(this.msgId);
    k.b localb;
    if ((this.hzO != null) && (this.NBI == null))
    {
      localb = k.b.aP(this.hzO.field_content, this.hzO.field_reserved);
      localObject = localb;
      if (localb != null) {
        this.NBI = q.aSH(localb.nRF);
      }
    }
    for (Object localObject = localb;; localObject = null)
    {
      if (this.NBI != null) {
        if (a(this.NBI) != null)
        {
          this.title = a(this.NBI);
          if (!Util.isNullOrNil(this.NBI.nUC))
          {
            this.NBK = ((arf)this.NBI.nUC.getFirst()).ZzC;
            this.NBL = ((arf)this.NBI.nUC.getLast()).ZzC;
          }
        }
      }
      for (;;)
      {
        if (this.NBI != null) {
          break label462;
        }
        gGu();
        setBackBtn(new RecordMsgDetailUI.2(this));
        if ((this.NBJ) && (as.cWJ().yi(this.msgId) != null))
        {
          bh.bCz();
          localObject = com.tencent.mm.model.c.bzD().sl(this.msgId);
          localObject = new com.tencent.mm.plugin.record.model.g(this.msgId, ((fi)localObject).field_msgSvrId, new com.tencent.mm.am.i()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, p paramAnonymousp)
            {
              AppMethodBeat.i(305296);
              if (paramAnonymousInt1 == paramAnonymousInt2)
              {
                if (RecordMsgDetailUI.b(RecordMsgDetailUI.this) != null)
                {
                  RecordMsgDetailUI.b(RecordMsgDetailUI.this).dismiss();
                  RecordMsgDetailUI.c(RecordMsgDetailUI.this);
                }
                bh.bCz();
                cc localcc = com.tencent.mm.model.c.bzD().sl(RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                paramAnonymousp = localcc.field_content;
                if (au.bwE(localcc.field_talker)) {
                  paramAnonymousp = br.JK(localcc.field_content);
                }
                paramAnonymousp = k.b.Hf(paramAnonymousp);
                if (paramAnonymousp != null)
                {
                  RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousp.nRF);
                  RecordMsgDetailUI.a(RecordMsgDetailUI.this, q.aSH(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
                  if (RecordMsgDetailUI.e(RecordMsgDetailUI.this) != null)
                  {
                    if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)) == null) {
                      break label270;
                    }
                    RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)));
                  }
                }
              }
              for (;;)
              {
                RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((arf)RecordMsgDetailUI.e(RecordMsgDetailUI.this).nUC.getFirst()).ZzC);
                RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((arf)RecordMsgDetailUI.e(RecordMsgDetailUI.this).nUC.getLast()).ZzC);
                if ((!RecordMsgDetailUI.this.isFinishing()) && (!RecordMsgDetailUI.this.isDestroyed())) {
                  com.tencent.threadpool.h.ahAA.bk(new RecordMsgDetailUI.3..ExternalSyntheticLambda0(this));
                }
                AppMethodBeat.o(305296);
                return;
                label270:
                RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
              }
            }
          });
          bh.aZW().a((p)localObject, 0);
        }
        AppMethodBeat.o(27886);
        return;
        this.title = this.NBI.title;
        break;
        if ((this.hzO != null) && (localObject != null))
        {
          this.title = ((k.b)localObject).title;
          this.lKp = w.a(this, getString(R.l.loading_tips), true, 0, null);
          Log.i("MicroMsg.RecordMsgDetailUI", "loading");
        }
      }
      label462:
      updateView();
      AppMethodBeat.o(27886);
      return;
    }
  }
  
  protected final h gGn()
  {
    AppMethodBeat.i(27889);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    locale.NBq = getIntent().getStringExtra("msgUsername");
    locale.NBs = getIntent().getIntExtra("chatTypeForAppbrand", -1);
    locale.NBt = getIntent().getStringExtra("preChatName");
    String str2 = getIntent().getStringExtra("serverMsgID");
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      String str3 = getIntent().getStringExtra("prePublishId");
      str1 = str2;
      if (!Util.isNullOrNil(str3)) {
        str1 = str3.replace("msg_", "");
      }
    }
    locale.NBr = str1;
    AppMethodBeat.o(27889);
    return locale;
  }
  
  protected final String gGo()
  {
    return this.title;
  }
  
  protected final String gGp()
  {
    return this.NBK;
  }
  
  protected final String gGq()
  {
    return this.NBL;
  }
  
  protected final void gGr()
  {
    AppMethodBeat.i(27891);
    if (!this.hTH)
    {
      AppMethodBeat.o(27891);
      return;
    }
    addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(305311);
        com.tencent.mm.modelstat.a.c(RecordMsgDetailUI.g(RecordMsgDetailUI.this), 1);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(RecordMsgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(305273);
            paramAnonymous2s.c(0, RecordMsgDetailUI.this.getString(R.l.favorite_share_with_friend));
            if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
              paramAnonymous2s.c(2, RecordMsgDetailUI.this.getString(R.l.plugin_favorite_opt));
            }
            AppMethodBeat.o(305273);
          }
        };
        paramAnonymousMenuItem.ages = new f.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(305275);
            com.tencent.mm.modelstat.a.c(RecordMsgDetailUI.g(RecordMsgDetailUI.this), 3);
            AppMethodBeat.o(305275);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(305276);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(305276);
              return;
              bh.bCz();
              if (!((Boolean)com.tencent.mm.model.c.ban().d(327714, Boolean.FALSE)).booleanValue())
              {
                bh.bCz();
                com.tencent.mm.model.c.ban().B(327714, Boolean.TRUE);
                paramAnonymous2MenuItem = new e.a(RecordMsgDetailUI.this);
                paramAnonymous2MenuItem.bDw(RecordMsgDetailUI.this.getResources().getString(R.l.gSS));
                paramAnonymous2MenuItem.bDv(RecordMsgDetailUI.this.getResources().getString(R.l.app_tip));
                paramAnonymous2MenuItem.aER(R.l.i_know_it).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(305281);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Select_Conv_Type", 3);
                    localIntent.putExtra("select_is_ret", true);
                    localIntent.putExtra("mutil_select_is_ret", true);
                    localIntent.putExtra("Retr_Msg_Type", 10);
                    if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
                      localIntent.putExtra("from_scene", 0);
                    }
                    localIntent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                    com.tencent.mm.br.c.d(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
                    paramAnonymous3DialogInterface.dismiss();
                    AppMethodBeat.o(305281);
                  }
                });
                paramAnonymous2MenuItem.jHH().show();
              }
              for (;;)
              {
                com.tencent.mm.modelstat.a.c(RecordMsgDetailUI.g(RecordMsgDetailUI.this), 2);
                AppMethodBeat.o(305276);
                return;
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                paramAnonymous2MenuItem.putExtra("select_is_ret", true);
                paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
                paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 10);
                paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
                  paramAnonymous2MenuItem.putExtra("from_scene", 0);
                }
                com.tencent.mm.br.c.d(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1001);
              }
              AppMethodBeat.o(305276);
              return;
              paramAnonymous2MenuItem = new dn();
              l.a(paramAnonymous2MenuItem, RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymous2MenuItem.hDr.hDy = 9;
              paramAnonymous2MenuItem.hDr.activity = RecordMsgDetailUI.this;
              paramAnonymous2MenuItem.publish();
            }
          }
        };
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(305311);
        return true;
      }
    });
    AppMethodBeat.o(27891);
  }
  
  protected final void i(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(27892);
    if (-1 != paramInt2)
    {
      Log.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(27892);
      return;
    }
    Object localObject;
    if (1001 == paramInt1)
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label94;
        }
      }
      label94:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        if (!Util.isNullOrNil((String)localObject)) {
          break label105;
        }
        Log.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27892);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label105:
      bh.bCz();
      final cc localcc = com.tencent.mm.model.c.bzD().sl(this.msgId);
      if ((localcc == null) || (localcc.field_msgId != this.msgId))
      {
        Log.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(27892);
        return;
      }
      final w localw = k.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(305307);
          q.a(this.hkh, paramIntent, localcc);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(305283);
              RecordMsgDetailUI.5.this.Afz.dismiss();
              AppMethodBeat.o(305283);
            }
          });
          AppMethodBeat.o(305307);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(305310);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(305310);
          return str;
        }
      });
      AppMethodBeat.o(27892);
      return;
    }
    if ((1002 == paramInt1) && (paramIntent.getBooleanExtra("kfavorite", false)))
    {
      localObject = new dn();
      l.a((dn)localObject, paramIntent);
      ((dn)localObject).hDr.activity = this;
      ((dn)localObject).hDr.hDy = 8;
      ((dn)localObject).publish();
    }
    AppMethodBeat.o(27892);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27885);
    super.onCreate(paramBundle);
    this.NBN.alive();
    AppMethodBeat.o(27885);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27890);
    super.onDestroy();
    this.NBN.dead();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((e)this.NBE);
    if (this.NBi != null)
    {
      byte[] arrayOfByte = this.NBi.gGy();
      if ((!this.NBM) && (this.hzO != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.hzO.BV(new String(arrayOfByte, Charset.forName("UTF-8")));
        bh.bCz();
        com.tencent.mm.model.c.bzD().a(this.msgId, this.hzO);
      }
    }
    AppMethodBeat.o(27890);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(305294);
    super.onPause();
    if (this.NBi != null) {
      this.NBi.NCn = false;
    }
    AppMethodBeat.o(305294);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI
 * JD-Core Version:    0.7.0.1
 */
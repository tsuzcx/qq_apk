package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.tw;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.a;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordMsgDetailUI
  extends RecordMsgBaseUI
{
  private i HDG;
  private String HDO;
  private String HDP;
  private com.tencent.mm.protocal.b.a.c HEg;
  private boolean HEh;
  private String HEi;
  private String HEj;
  private boolean HEk;
  IListener<tw> HEl;
  private boolean fNQ;
  private String fRy;
  private ca fvt;
  private s jhZ;
  private long msgId;
  private String title;
  
  public RecordMsgDetailUI()
  {
    AppMethodBeat.i(274250);
    this.HEg = null;
    this.msgId = -1L;
    this.fRy = null;
    this.fNQ = true;
    this.HEh = false;
    this.title = "";
    this.HEi = "";
    this.HEj = "";
    this.jhZ = null;
    this.HDO = "";
    this.HDP = "";
    this.HEl = new IListener() {};
    AppMethodBeat.o(274250);
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
      Iterator localIterator = paramc.lpz.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (anm)localIterator.next();
        if (paramc.SyG.Szn.SAb != null)
        {
          str1 = getContext().getString(R.l.record_chatroom_title);
          i = 1;
        }
        else
        {
          if (paramc.SyG.Szn.fLi == null) {
            break label228;
          }
          if (str2 == null)
          {
            str2 = paramc.SyI;
          }
          else
          {
            if (str2 == paramc.SyI) {
              break label228;
            }
            paramc = paramc.SyI;
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
    if (this.HEg != null) {
      localf.HDy = this.HEg.lpz;
    }
    localf.msgId = this.msgId;
    localf.fRy = this.fRy;
    localf.HDO = this.HDO;
    localf.HDP = this.HDP;
    localf.HDz = new x();
    if ((this.fvt != null) && (!this.HEk) && (this.fvt.field_transContent != null)) {}
    try
    {
      localf.HDz.parseFrom(this.fvt.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.fux();
      this.HEc.a(localf);
      this.HDG = new i(this, this.HEc, localf);
      this.HEc.HDG = this.HDG;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((e)this.HEc);
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
  
  protected final void f(int paramInt1, int paramInt2, final Intent paramIntent)
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
      bh.beI();
      final ca localca = com.tencent.mm.model.c.bbO().Oq(this.msgId);
      if (localca.field_msgId != this.msgId)
      {
        Log.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(27892);
        return;
      }
      final s locals = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217297);
          p.a(this.ffX, paramIntent, localca);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(271243);
              RecordMsgDetailUI.5.this.wJe.dismiss();
              AppMethodBeat.o(271243);
            }
          });
          AppMethodBeat.o(217297);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(217300);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(217300);
          return str;
        }
      });
      AppMethodBeat.o(27892);
      return;
    }
    if ((1002 == paramInt1) && (paramIntent.getBooleanExtra("kfavorite", false)))
    {
      localObject = new dd();
      com.tencent.mm.pluginsdk.model.j.a((dd)localObject, paramIntent);
      ((dd)localObject).fyI.activity = this;
      ((dd)localObject).fyI.fyP = 8;
      EventCenter.instance.publish((IEvent)localObject);
    }
    AppMethodBeat.o(27892);
  }
  
  protected final String fuA()
  {
    return this.HEi;
  }
  
  protected final String fuB()
  {
    return this.HEj;
  }
  
  protected final void fuC()
  {
    AppMethodBeat.i(27891);
    if (!this.fNQ)
    {
      AppMethodBeat.o(27891);
      return;
    }
    addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(225740);
        com.tencent.mm.modelstat.a.c(RecordMsgDetailUI.g(RecordMsgDetailUI.this), 1);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(283008);
            paramAnonymous2o.d(0, RecordMsgDetailUI.this.getString(R.l.favorite_share_with_friend));
            if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
              paramAnonymous2o.d(2, RecordMsgDetailUI.this.getString(R.l.plugin_favorite_opt));
            }
            AppMethodBeat.o(283008);
          }
        };
        paramAnonymousMenuItem.YmE = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(292056);
            com.tencent.mm.modelstat.a.c(RecordMsgDetailUI.g(RecordMsgDetailUI.this), 3);
            AppMethodBeat.o(292056);
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(285815);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(285815);
              return;
              bh.beI();
              if (!((Boolean)com.tencent.mm.model.c.aHp().b(327714, Boolean.FALSE)).booleanValue())
              {
                bh.beI();
                com.tencent.mm.model.c.aHp().i(327714, Boolean.TRUE);
                paramAnonymous2MenuItem = new d.a(RecordMsgDetailUI.this);
                paramAnonymous2MenuItem.bBd(RecordMsgDetailUI.this.getResources().getString(R.l.eQn));
                paramAnonymous2MenuItem.bBc(RecordMsgDetailUI.this.getResources().getString(R.l.app_tip));
                paramAnonymous2MenuItem.ayj(R.l.i_know_it).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(214008);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Select_Conv_Type", 3);
                    localIntent.putExtra("select_is_ret", true);
                    localIntent.putExtra("mutil_select_is_ret", true);
                    localIntent.putExtra("Retr_Msg_Type", 10);
                    if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
                      localIntent.putExtra("from_scene", 0);
                    }
                    localIntent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                    com.tencent.mm.by.c.d(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
                    paramAnonymous3DialogInterface.dismiss();
                    AppMethodBeat.o(214008);
                  }
                });
                paramAnonymous2MenuItem.icu().show();
              }
              for (;;)
              {
                com.tencent.mm.modelstat.a.c(RecordMsgDetailUI.g(RecordMsgDetailUI.this), 2);
                AppMethodBeat.o(285815);
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
                com.tencent.mm.by.c.d(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1001);
              }
              AppMethodBeat.o(285815);
              return;
              paramAnonymous2MenuItem = new dd();
              com.tencent.mm.pluginsdk.model.j.a(paramAnonymous2MenuItem, RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymous2MenuItem.fyI.fyP = 9;
              paramAnonymous2MenuItem.fyI.activity = RecordMsgDetailUI.this;
              EventCenter.instance.publish(paramAnonymous2MenuItem);
            }
          }
        };
        paramAnonymousMenuItem.eik();
        AppMethodBeat.o(225740);
        return true;
      }
    });
    AppMethodBeat.o(27891);
  }
  
  protected final void fux()
  {
    AppMethodBeat.i(27886);
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.fRy = getIntent().getStringExtra("record_xml");
    this.fNQ = getIntent().getBooleanExtra("record_show_share", true);
    this.HEh = getIntent().getBooleanExtra("big_appmsg", false);
    this.HEk = getIntent().getBooleanExtra("record_nest", false);
    this.HDO = getIntent().getStringExtra("pre_username");
    if (Util.isNullOrNil(this.HDO)) {
      this.HDO = getIntent().getStringExtra("msgUsername");
    }
    this.HDP = getIntent().getStringExtra("serverMsgID");
    this.HEg = p.aVz(this.fRy);
    bh.beI();
    this.fvt = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    k.b localb;
    if ((this.fvt != null) && (this.HEg == null))
    {
      localb = k.b.aG(this.fvt.field_content, this.fvt.field_reserved);
      localObject = localb;
      if (localb != null) {
        this.HEg = p.aVz(localb.lmA);
      }
    }
    for (Object localObject = localb;; localObject = null)
    {
      if (this.HEg != null) {
        if (a(this.HEg) != null)
        {
          this.title = a(this.HEg);
          if (!Util.isNullOrNil(this.HEg.lpz))
          {
            this.HEi = ((anm)this.HEg.lpz.getFirst()).SyK;
            this.HEj = ((anm)this.HEg.lpz.getLast()).SyK;
          }
        }
      }
      for (;;)
      {
        if (this.HEg != null) {
          break label462;
        }
        fuF();
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(272989);
            RecordMsgDetailUI.this.finish();
            AppMethodBeat.o(272989);
            return true;
          }
        });
        if ((this.HEh) && (com.tencent.mm.pluginsdk.model.app.ao.ctZ().TR(this.msgId) != null))
        {
          bh.beI();
          localObject = com.tencent.mm.model.c.bbO().Oq(this.msgId);
          localObject = new com.tencent.mm.plugin.record.b.f(this.msgId, ((et)localObject).field_msgSvrId, new com.tencent.mm.an.j()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, q paramAnonymousq)
            {
              AppMethodBeat.i(234694);
              if (paramAnonymousInt1 == paramAnonymousInt2)
              {
                if (RecordMsgDetailUI.b(RecordMsgDetailUI.this) != null)
                {
                  RecordMsgDetailUI.b(RecordMsgDetailUI.this).dismiss();
                  RecordMsgDetailUI.c(RecordMsgDetailUI.this);
                }
                bh.beI();
                ca localca = com.tencent.mm.model.c.bbO().Oq(RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                paramAnonymousq = localca.field_content;
                if (ab.Lj(localca.field_talker)) {
                  paramAnonymousq = bq.RM(localca.field_content);
                }
                paramAnonymousq = k.b.OQ(paramAnonymousq);
                if (paramAnonymousq != null)
                {
                  RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousq.lmA);
                  RecordMsgDetailUI.a(RecordMsgDetailUI.this, p.aVz(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
                  if (RecordMsgDetailUI.e(RecordMsgDetailUI.this) != null)
                  {
                    if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)) == null) {
                      break label260;
                    }
                    RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)));
                  }
                }
              }
              for (;;)
              {
                RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((anm)RecordMsgDetailUI.e(RecordMsgDetailUI.this).lpz.getFirst()).SyK);
                RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((anm)RecordMsgDetailUI.e(RecordMsgDetailUI.this).lpz.getLast()).SyK);
                if ((!RecordMsgDetailUI.this.isFinishing()) && (!RecordMsgDetailUI.this.isDestroyed())) {
                  RecordMsgDetailUI.f(RecordMsgDetailUI.this);
                }
                AppMethodBeat.o(234694);
                return;
                label260:
                RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
              }
            }
          });
          bh.aGY().a((q)localObject, 0);
        }
        AppMethodBeat.o(27886);
        return;
        this.title = this.HEg.title;
        break;
        if ((this.fvt != null) && (localObject != null))
        {
          this.title = ((k.b)localObject).title;
          this.jhZ = s.a(this, getString(R.l.loading_tips), true, 0, null);
          Log.i("MicroMsg.RecordMsgDetailUI", "loading");
        }
      }
      label462:
      updateView();
      AppMethodBeat.o(27886);
      return;
    }
  }
  
  protected final h fuy()
  {
    AppMethodBeat.i(27889);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    locale.HDO = getIntent().getStringExtra("msgUsername");
    locale.HDQ = getIntent().getIntExtra("chatTypeForAppbrand", -1);
    locale.HDR = getIntent().getStringExtra("preChatName");
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
    locale.HDP = str1;
    AppMethodBeat.o(27889);
    return locale;
  }
  
  protected final String fuz()
  {
    return this.title;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27885);
    super.onCreate(paramBundle);
    this.HEl.alive();
    AppMethodBeat.o(27885);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27890);
    super.onDestroy();
    this.HEl.dead();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((e)this.HEc);
    if (this.HDG != null)
    {
      byte[] arrayOfByte = this.HDG.fuI();
      if ((!this.HEk) && (this.fvt != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.fvt.Jp(new String(arrayOfByte, Charset.forName("UTF-8")));
        bh.beI();
        com.tencent.mm.model.c.bbO().a(this.msgId, this.fvt);
      }
    }
    AppMethodBeat.o(27890);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(274254);
    super.onPause();
    if (this.HDG != null) {
      this.HDG.HEL = false;
    }
    AppMethodBeat.o(274254);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI
 * JD-Core Version:    0.7.0.1
 */
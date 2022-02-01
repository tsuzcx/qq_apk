package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.d.a;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordMsgDetailUI
  extends RecordMsgBaseUI
{
  private i BHC;
  private String BHK;
  private String BHL;
  private com.tencent.mm.protocal.b.a.c BHZ;
  private boolean BIa;
  private String BIb;
  private String BIc;
  private boolean BId;
  IListener<sv> BIe;
  private ca dCM;
  private boolean dUo;
  private String dXH;
  private com.tencent.mm.ui.base.q gxX;
  private long msgId;
  private String title;
  
  public RecordMsgDetailUI()
  {
    AppMethodBeat.i(232037);
    this.BHZ = null;
    this.msgId = -1L;
    this.dXH = null;
    this.dUo = true;
    this.BIa = false;
    this.title = "";
    this.BIb = "";
    this.BIc = "";
    this.gxX = null;
    this.BHK = "";
    this.BHL = "";
    this.BIe = new RecordMsgDetailUI.1(this);
    AppMethodBeat.o(232037);
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
      Iterator localIterator = paramc.iAd.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (aml)localIterator.next();
        if (paramc.Lwh.LwO.LxA != null)
        {
          str1 = getContext().getString(2131764266);
          i = 1;
        }
        else
        {
          if (paramc.Lwh.LwO.dRL == null) {
            break label225;
          }
          if (str2 == null)
          {
            str2 = paramc.Lwj;
          }
          else
          {
            if (str2 == paramc.Lwj) {
              break label225;
            }
            paramc = paramc.Lwj;
            localc = paramc;
          }
        }
      }
      if ((str2 != null) && (localc == null) && (i == 0)) {
        paramc = getContext().getString(2131759288, new Object[] { str2 });
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
              paramc = getContext().getString(2131759287, new Object[] { str2, localc });
              continue;
              label225:
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
    localf.BHs = this.BHZ.iAd;
    localf.msgId = this.msgId;
    localf.dXH = this.dXH;
    localf.BHK = this.BHK;
    localf.BHL = this.BHL;
    localf.BHt = new x();
    if ((this.dCM != null) && (!this.BId) && (this.dCM.field_transContent != null)) {}
    try
    {
      localf.BHt.parseFrom(this.dCM.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.eIs();
      this.BHV.a(localf);
      this.BHC = new i(this, this.BHV, localf);
      this.BHV.BHC = this.BHC;
      ((a)com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().a((e)this.BHV);
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
  
  protected final void eIs()
  {
    AppMethodBeat.i(27886);
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dXH = getIntent().getStringExtra("record_xml");
    this.dUo = getIntent().getBooleanExtra("record_show_share", true);
    this.BIa = getIntent().getBooleanExtra("big_appmsg", false);
    this.BId = getIntent().getBooleanExtra("record_nest", false);
    this.BHK = getIntent().getStringExtra("pre_username");
    if (Util.isNullOrNil(this.BHK)) {
      this.BHK = getIntent().getStringExtra("msgUsername");
    }
    this.BHL = getIntent().getStringExtra("serverMsgID");
    this.BHZ = p.aKY(this.dXH);
    bg.aVF();
    this.dCM = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
    if (this.BHZ != null) {
      if (a(this.BHZ) != null)
      {
        this.title = a(this.BHZ);
        if (!Util.isNullOrNil(this.BHZ.iAd))
        {
          this.BIb = ((aml)this.BHZ.iAd.getFirst()).Lwl;
          this.BIc = ((aml)this.BHZ.iAd.getLast()).Lwl;
        }
      }
    }
    for (;;)
    {
      if ((this.dXH != null) && (this.BHZ != null)) {
        break label427;
      }
      eIA();
      setBackBtn(new RecordMsgDetailUI.2(this));
      Object localObject;
      if ((this.BIa) && (com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(this.msgId) != null))
      {
        bg.aVF();
        localObject = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
        localObject = new com.tencent.mm.plugin.record.b.f(this.msgId, ((eo)localObject).field_msgSvrId, new j()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(232029);
            if (paramAnonymousInt1 == paramAnonymousInt2)
            {
              if (RecordMsgDetailUI.b(RecordMsgDetailUI.this) != null)
              {
                RecordMsgDetailUI.b(RecordMsgDetailUI.this).dismiss();
                RecordMsgDetailUI.c(RecordMsgDetailUI.this);
              }
              bg.aVF();
              ca localca = com.tencent.mm.model.c.aSQ().Hb(RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymousq = localca.field_content;
              if (ab.Eq(localca.field_talker)) {
                paramAnonymousq = bp.Kt(localca.field_content);
              }
              paramAnonymousq = k.b.HD(paramAnonymousq);
              if (paramAnonymousq != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousq.ixl);
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, p.aKY(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
                if (RecordMsgDetailUI.e(RecordMsgDetailUI.this) != null)
                {
                  if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)) == null) {
                    break label240;
                  }
                  RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)));
                }
              }
            }
            for (;;)
            {
              RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((aml)RecordMsgDetailUI.e(RecordMsgDetailUI.this).iAd.getFirst()).Lwl);
              RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((aml)RecordMsgDetailUI.e(RecordMsgDetailUI.this).iAd.getLast()).Lwl);
              RecordMsgDetailUI.f(RecordMsgDetailUI.this);
              AppMethodBeat.o(232029);
              return;
              label240:
              RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
            }
          }
        });
        bg.azz().a((com.tencent.mm.ak.q)localObject, 0);
      }
      AppMethodBeat.o(27886);
      return;
      this.title = this.BHZ.title;
      break;
      if (this.dCM != null)
      {
        localObject = k.b.aD(this.dCM.field_content, this.dCM.field_reserved);
        if (localObject != null)
        {
          this.title = ((k.b)localObject).title;
          this.gxX = com.tencent.mm.ui.base.q.a(this, getString(2131762446), true, 0, null);
        }
      }
    }
    label427:
    updateView();
    AppMethodBeat.o(27886);
  }
  
  protected final h eIt()
  {
    AppMethodBeat.i(27889);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    locale.BHK = getIntent().getStringExtra("msgUsername");
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
    locale.BHL = str1;
    AppMethodBeat.o(27889);
    return locale;
  }
  
  protected final String eIu()
  {
    return this.title;
  }
  
  protected final String eIv()
  {
    return this.BIb;
  }
  
  protected final String eIw()
  {
    return this.BIc;
  }
  
  protected final void eIx()
  {
    AppMethodBeat.i(27891);
    if (!this.dUo)
    {
      AppMethodBeat.o(27891);
      return;
    }
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(232033);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(232030);
            paramAnonymous2m.d(0, RecordMsgDetailUI.this.getString(2131759326));
            if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
              paramAnonymous2m.d(2, RecordMsgDetailUI.this.getString(2131763947));
            }
            AppMethodBeat.o(232030);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(232032);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(232032);
              return;
              bg.aVF();
              if (!((Boolean)com.tencent.mm.model.c.azQ().get(327714, Boolean.FALSE)).booleanValue())
              {
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(327714, Boolean.TRUE);
                paramAnonymous2MenuItem = new d.a(RecordMsgDetailUI.this);
                paramAnonymous2MenuItem.boo(RecordMsgDetailUI.this.getResources().getString(2131764298));
                paramAnonymous2MenuItem.bon(RecordMsgDetailUI.this.getResources().getString(2131755998));
                paramAnonymous2MenuItem.aoV(2131761757).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(232031);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Select_Conv_Type", 3);
                    localIntent.putExtra("select_is_ret", true);
                    localIntent.putExtra("mutil_select_is_ret", true);
                    localIntent.putExtra("Retr_Msg_Type", 10);
                    localIntent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                    com.tencent.mm.br.c.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
                    paramAnonymous3DialogInterface.dismiss();
                    AppMethodBeat.o(232031);
                  }
                });
                paramAnonymous2MenuItem.hbn().show();
                AppMethodBeat.o(232032);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 10);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              com.tencent.mm.br.c.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1001);
              AppMethodBeat.o(232032);
              return;
              AppMethodBeat.o(232032);
              return;
              paramAnonymous2MenuItem = new cz();
              com.tencent.mm.pluginsdk.model.h.a(paramAnonymous2MenuItem, RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymous2MenuItem.dFZ.dGf = 9;
              paramAnonymous2MenuItem.dFZ.activity = RecordMsgDetailUI.this;
              EventCenter.instance.publish(paramAnonymous2MenuItem);
            }
          }
        };
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(232033);
        return true;
      }
    });
    AppMethodBeat.o(27891);
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
      bg.aVF();
      final ca localca = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
      if (localca.field_msgId != this.msgId)
      {
        Log.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(27892);
        return;
      }
      final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232035);
          p.a(this.dnJ, paramIntent, localca);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232034);
              RecordMsgDetailUI.5.this.tcT.dismiss();
              AppMethodBeat.o(232034);
            }
          });
          AppMethodBeat.o(232035);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(232036);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(232036);
          return str;
        }
      });
      AppMethodBeat.o(27892);
      return;
    }
    if ((1002 == paramInt1) && (paramIntent.getBooleanExtra("kfavorite", false)))
    {
      localObject = new cz();
      com.tencent.mm.pluginsdk.model.h.a((cz)localObject, paramIntent);
      ((cz)localObject).dFZ.activity = this;
      ((cz)localObject).dFZ.dGf = 8;
      EventCenter.instance.publish((IEvent)localObject);
    }
    AppMethodBeat.o(27892);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27885);
    super.onCreate(paramBundle);
    this.BIe.alive();
    AppMethodBeat.o(27885);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27890);
    super.onDestroy();
    this.BIe.dead();
    ((a)com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().b((e)this.BHV);
    if (this.BHC != null)
    {
      byte[] arrayOfByte = this.BHC.eID();
      if ((!this.BId) && (this.dCM != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.dCM.CB(new String(arrayOfByte, Charset.forName("UTF-8")));
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(this.msgId, this.dCM);
      }
    }
    AppMethodBeat.o(27890);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(232038);
    super.onPause();
    if (this.BHC != null) {
      this.BHC.BID = false;
    }
    AppMethodBeat.o(232038);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI
 * JD-Core Version:    0.7.0.1
 */
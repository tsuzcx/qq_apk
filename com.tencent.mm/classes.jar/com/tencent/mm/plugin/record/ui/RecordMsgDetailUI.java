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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.record.b.v;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d.a;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordMsgDetailUI
  extends RecordMsgBaseUI
{
  private bl dbD;
  private boolean drV = true;
  private String dvd = null;
  private p ftP = null;
  private long msgId = -1L;
  private String title = "";
  private boolean vbA;
  private i vbd;
  private com.tencent.mm.protocal.b.a.c vbw = null;
  private boolean vbx = false;
  private String vby = "";
  private String vbz = "";
  
  private String a(com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(27887);
    int i;
    com.tencent.mm.protocal.b.a.c localc;
    String str2;
    String str1;
    if (paramc != null)
    {
      Iterator localIterator = paramc.gKs.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (afy)localIterator.next();
        if (paramc.DgT.DhA.Did != null)
        {
          str1 = getContext().getString(2131762236);
          i = 1;
        }
        else
        {
          if (paramc.DgT.DhA.dpv == null) {
            break label225;
          }
          if (str2 == null)
          {
            str2 = paramc.DgV;
          }
          else
          {
            if (str2 == paramc.DgV) {
              break label225;
            }
            paramc = paramc.DgV;
            localc = paramc;
          }
        }
      }
      if ((str2 != null) && (localc == null) && (i == 0)) {
        paramc = getContext().getString(2131758964, new Object[] { str2 });
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
              paramc = getContext().getString(2131758963, new Object[] { str2, localc });
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
  
  private void cE()
  {
    AppMethodBeat.i(27888);
    f localf = new f();
    localf.vaT = this.vbw.gKs;
    localf.msgId = this.msgId;
    localf.dvd = this.dvd;
    localf.vaU = new v();
    if ((this.dbD != null) && (!this.vbA) && (this.dbD.field_transContent != null)) {}
    try
    {
      localf.vaU.parseFrom(this.dbD.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.dgk();
      this.vbs.a(localf);
      this.vbd = new i(this, this.vbs, localf);
      this.vbs.vbd = this.vbd;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((e)this.vbs);
      AppMethodBeat.o(27888);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.RecordMsgDetailUI", localException, "", new Object[0]);
      }
    }
  }
  
  protected final void dgk()
  {
    AppMethodBeat.i(27886);
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dvd = getIntent().getStringExtra("record_xml");
    this.drV = getIntent().getBooleanExtra("record_show_share", true);
    this.vbx = getIntent().getBooleanExtra("big_appmsg", false);
    this.vbA = getIntent().getBooleanExtra("record_nest", false);
    this.vbw = com.tencent.mm.plugin.record.b.n.alt(this.dvd);
    az.arV();
    this.dbD = com.tencent.mm.model.c.apO().rm(this.msgId);
    if (this.vbw != null) {
      if (a(this.vbw) != null)
      {
        this.title = a(this.vbw);
        if (!bt.gL(this.vbw.gKs))
        {
          this.vby = ((afy)this.vbw.gKs.getFirst()).DgX;
          this.vbz = ((afy)this.vbw.gKs.getLast()).DgX;
        }
      }
    }
    for (;;)
    {
      if ((this.dvd != null) && (this.vbw != null)) {
        break label375;
      }
      dgs();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27876);
          RecordMsgDetailUI.this.finish();
          AppMethodBeat.o(27876);
          return true;
        }
      });
      Object localObject;
      if ((this.vbx) && (ap.bxS().vj(this.msgId) != null))
      {
        az.arV();
        localObject = com.tencent.mm.model.c.apO().rm(this.msgId);
        localObject = new com.tencent.mm.plugin.record.b.e(this.msgId, ((du)localObject).field_msgSvrId, new com.tencent.mm.al.h()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(27877);
            if (paramAnonymousInt1 == paramAnonymousInt2)
            {
              if (RecordMsgDetailUI.a(RecordMsgDetailUI.this) != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this).dismiss();
                RecordMsgDetailUI.b(RecordMsgDetailUI.this);
              }
              az.arV();
              bl localbl = com.tencent.mm.model.c.apO().rm(RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              paramAnonymousn = localbl.field_content;
              if (w.pF(localbl.field_talker)) {
                paramAnonymousn = bi.ug(localbl.field_content);
              }
              paramAnonymousn = k.b.rx(paramAnonymousn);
              if (paramAnonymousn != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousn.gHI);
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, com.tencent.mm.plugin.record.b.n.alt(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
                if (RecordMsgDetailUI.e(RecordMsgDetailUI.this) != null)
                {
                  if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)) == null) {
                    break label242;
                  }
                  RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this)));
                }
              }
            }
            for (;;)
            {
              RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((afy)RecordMsgDetailUI.e(RecordMsgDetailUI.this).gKs.getFirst()).DgX);
              RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((afy)RecordMsgDetailUI.e(RecordMsgDetailUI.this).gKs.getLast()).DgX);
              RecordMsgDetailUI.f(RecordMsgDetailUI.this);
              AppMethodBeat.o(27877);
              return;
              label242:
              RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
            }
          }
        });
        az.aeS().a((com.tencent.mm.al.n)localObject, 0);
      }
      AppMethodBeat.o(27886);
      return;
      this.title = this.vbw.title;
      break;
      if (this.dbD != null)
      {
        localObject = k.b.ar(this.dbD.field_content, this.dbD.field_reserved);
        if (localObject != null)
        {
          this.title = ((k.b)localObject).title;
          this.ftP = p.a(this, getString(2131760709), true, 0, null);
        }
      }
    }
    label375:
    cE();
    AppMethodBeat.o(27886);
  }
  
  protected final h dgl()
  {
    AppMethodBeat.i(27889);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    AppMethodBeat.o(27889);
    return locale;
  }
  
  protected final String dgm()
  {
    return this.title;
  }
  
  protected final String dgn()
  {
    return this.vby;
  }
  
  protected final String dgo()
  {
    return this.vbz;
  }
  
  protected final void dgp()
  {
    AppMethodBeat.i(27891);
    if (!this.drV)
    {
      AppMethodBeat.o(27891);
      return;
    }
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27881);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(27878);
            paramAnonymous2l.c(0, RecordMsgDetailUI.this.getString(2131759001));
            if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
              paramAnonymous2l.c(2, RecordMsgDetailUI.this.getString(2131761941));
            }
            AppMethodBeat.o(27878);
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(27880);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(27880);
              return;
              az.arV();
              if (!((Boolean)com.tencent.mm.model.c.afk().get(327714, Boolean.FALSE)).booleanValue())
              {
                az.arV();
                com.tencent.mm.model.c.afk().set(327714, Boolean.TRUE);
                paramAnonymous2MenuItem = new d.a(RecordMsgDetailUI.this);
                paramAnonymous2MenuItem.aMg(RecordMsgDetailUI.this.getResources().getString(2131762247));
                paramAnonymous2MenuItem.aMf(RecordMsgDetailUI.this.getResources().getString(2131755906));
                paramAnonymous2MenuItem.aaB(2131760315).b(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(27879);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Select_Conv_Type", 3);
                    localIntent.putExtra("select_is_ret", true);
                    localIntent.putExtra("mutil_select_is_ret", true);
                    localIntent.putExtra("Retr_Msg_Type", 10);
                    localIntent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(RecordMsgDetailUI.this));
                    com.tencent.mm.bs.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
                    paramAnonymous3DialogInterface.dismiss();
                    AppMethodBeat.o(27879);
                  }
                });
                paramAnonymous2MenuItem.fft().show();
                AppMethodBeat.o(27880);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 10);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              com.tencent.mm.bs.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1001);
              AppMethodBeat.o(27880);
              return;
              AppMethodBeat.o(27880);
              return;
              paramAnonymous2MenuItem = new cs();
              com.tencent.mm.pluginsdk.model.g.a(paramAnonymous2MenuItem, RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              paramAnonymous2MenuItem.deQ.deW = 9;
              paramAnonymous2MenuItem.deQ.activity = RecordMsgDetailUI.this;
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2MenuItem);
            }
          }
        };
        paramAnonymousMenuItem.csG();
        AppMethodBeat.o(27881);
        return true;
      }
    });
    AppMethodBeat.o(27891);
  }
  
  protected final void e(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(27892);
    if (-1 != paramInt2)
    {
      ad.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[] { Integer.valueOf(paramInt2) });
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
          break label92;
        }
      }
      label92:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        if (!bt.isNullOrNil((String)localObject)) {
          break label103;
        }
        ad.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27892);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label103:
      az.arV();
      final bl localbl = com.tencent.mm.model.c.apO().rm(this.msgId);
      if (localbl.field_msgId != this.msgId)
      {
        ad.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(27892);
        return;
      }
      final p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27883);
          com.tencent.mm.plugin.record.b.n.a(this.cND, paramIntent, localbl);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27882);
              RecordMsgDetailUI.4.this.qcu.dismiss();
              AppMethodBeat.o(27882);
            }
          });
          AppMethodBeat.o(27883);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(27884);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(27884);
          return str;
        }
      });
      AppMethodBeat.o(27892);
      return;
    }
    if ((1002 == paramInt1) && (paramIntent.getBooleanExtra("kfavorite", false)))
    {
      localObject = new cs();
      com.tencent.mm.pluginsdk.model.g.a((cs)localObject, paramIntent);
      ((cs)localObject).deQ.activity = this;
      ((cs)localObject).deQ.deW = 8;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
    }
    AppMethodBeat.o(27892);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27885);
    super.onCreate(paramBundle);
    AppMethodBeat.o(27885);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27890);
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((e)this.vbs);
    if (this.vbd != null)
    {
      byte[] arrayOfByte = this.vbd.dgv();
      if ((!this.vbA) && (this.dbD != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.dbD.ob(new String(arrayOfByte, Charset.forName("UTF-8")));
        az.arV();
        com.tencent.mm.model.c.apO().a(this.msgId, this.dbD);
      }
    }
    AppMethodBeat.o(27890);
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
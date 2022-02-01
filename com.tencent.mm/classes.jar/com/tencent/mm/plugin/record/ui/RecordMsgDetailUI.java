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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.record.b.v;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
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
  private bo cZc;
  private boolean dpG = true;
  private String dsP = null;
  private p fxw = null;
  private long msgId = -1L;
  private String title = "";
  private i wjR;
  private com.tencent.mm.protocal.b.a.c wkk = null;
  private boolean wkl = false;
  private String wkm = "";
  private String wkn = "";
  private boolean wko;
  
  private String a(com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(27887);
    int i;
    com.tencent.mm.protocal.b.a.c localc;
    String str2;
    String str1;
    if (paramc != null)
    {
      Iterator localIterator = paramc.hkS.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (agx)localIterator.next();
        if (paramc.EzZ.EAG.EBj != null)
        {
          str1 = getContext().getString(2131762236);
          i = 1;
        }
        else
        {
          if (paramc.EzZ.EAG.dng == null) {
            break label225;
          }
          if (str2 == null)
          {
            str2 = paramc.EAb;
          }
          else
          {
            if (str2 == paramc.EAb) {
              break label225;
            }
            paramc = paramc.EAb;
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
  
  private void cL()
  {
    AppMethodBeat.i(27888);
    f localf = new f();
    localf.wjH = this.wkk.hkS;
    localf.msgId = this.msgId;
    localf.dsP = this.dsP;
    localf.wjI = new v();
    if ((this.cZc != null) && (!this.wko) && (this.cZc.field_transContent != null)) {}
    try
    {
      localf.wjI.parseFrom(this.cZc.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.dtR();
      this.wkg.a(localf);
      this.wjR = new i(this, this.wkg, localf);
      this.wkg.wjR = this.wjR;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((e)this.wkg);
      AppMethodBeat.o(27888);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.RecordMsgDetailUI", localException, "", new Object[0]);
      }
    }
  }
  
  protected final void dtR()
  {
    AppMethodBeat.i(27886);
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dsP = getIntent().getStringExtra("record_xml");
    this.dpG = getIntent().getBooleanExtra("record_show_share", true);
    this.wkl = getIntent().getBooleanExtra("big_appmsg", false);
    this.wko = getIntent().getBooleanExtra("record_nest", false);
    this.wkk = com.tencent.mm.plugin.record.b.n.aqs(this.dsP);
    az.ayM();
    this.cZc = com.tencent.mm.model.c.awD().vP(this.msgId);
    if (this.wkk != null) {
      if (a(this.wkk) != null)
      {
        this.title = a(this.wkk);
        if (!bs.gY(this.wkk.hkS))
        {
          this.wkm = ((agx)this.wkk.hkS.getFirst()).EAd;
          this.wkn = ((agx)this.wkk.hkS.getLast()).EAd;
        }
      }
    }
    for (;;)
    {
      if ((this.dsP != null) && (this.wkk != null)) {
        break label375;
      }
      dtZ();
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
      if ((this.wkl) && (com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(this.msgId) != null))
      {
        az.ayM();
        localObject = com.tencent.mm.model.c.awD().vP(this.msgId);
        localObject = new com.tencent.mm.plugin.record.b.e(this.msgId, ((dy)localObject).field_msgSvrId, new com.tencent.mm.ak.h()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(27877);
            if (paramAnonymousInt1 == paramAnonymousInt2)
            {
              if (RecordMsgDetailUI.a(RecordMsgDetailUI.this) != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this).dismiss();
                RecordMsgDetailUI.b(RecordMsgDetailUI.this);
              }
              az.ayM();
              bo localbo = com.tencent.mm.model.c.awD().vP(RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              paramAnonymousn = localbo.field_content;
              if (w.sQ(localbo.field_talker)) {
                paramAnonymousn = bi.ym(localbo.field_content);
              }
              paramAnonymousn = k.b.vA(paramAnonymousn);
              if (paramAnonymousn != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousn.hij);
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, com.tencent.mm.plugin.record.b.n.aqs(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
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
              RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((agx)RecordMsgDetailUI.e(RecordMsgDetailUI.this).hkS.getFirst()).EAd);
              RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((agx)RecordMsgDetailUI.e(RecordMsgDetailUI.this).hkS.getLast()).EAd);
              RecordMsgDetailUI.f(RecordMsgDetailUI.this);
              AppMethodBeat.o(27877);
              return;
              label242:
              RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
            }
          }
        });
        az.agi().a((com.tencent.mm.ak.n)localObject, 0);
      }
      AppMethodBeat.o(27886);
      return;
      this.title = this.wkk.title;
      break;
      if (this.cZc != null)
      {
        localObject = k.b.az(this.cZc.field_content, this.cZc.field_reserved);
        if (localObject != null)
        {
          this.title = ((k.b)localObject).title;
          this.fxw = p.a(this, getString(2131760709), true, 0, null);
        }
      }
    }
    label375:
    cL();
    AppMethodBeat.o(27886);
  }
  
  protected final h dtS()
  {
    AppMethodBeat.i(27889);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    AppMethodBeat.o(27889);
    return locale;
  }
  
  protected final String dtT()
  {
    return this.title;
  }
  
  protected final String dtU()
  {
    return this.wkm;
  }
  
  protected final String dtV()
  {
    return this.wkn;
  }
  
  protected final void dtW()
  {
    AppMethodBeat.i(27891);
    if (!this.dpG)
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
        paramAnonymousMenuItem.ISu = new n.c()
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
        paramAnonymousMenuItem.ISv = new n.d()
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
              az.ayM();
              if (!((Boolean)com.tencent.mm.model.c.agA().get(327714, Boolean.FALSE)).booleanValue())
              {
                az.ayM();
                com.tencent.mm.model.c.agA().set(327714, Boolean.TRUE);
                paramAnonymous2MenuItem = new d.a(RecordMsgDetailUI.this);
                paramAnonymous2MenuItem.aRI(RecordMsgDetailUI.this.getResources().getString(2131762247));
                paramAnonymous2MenuItem.aRH(RecordMsgDetailUI.this.getResources().getString(2131755906));
                paramAnonymous2MenuItem.acM(2131760315).b(new DialogInterface.OnClickListener()
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
                    com.tencent.mm.br.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
                    paramAnonymous3DialogInterface.dismiss();
                    AppMethodBeat.o(27879);
                  }
                });
                paramAnonymous2MenuItem.fvp().show();
                AppMethodBeat.o(27880);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 10);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              com.tencent.mm.br.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1001);
              AppMethodBeat.o(27880);
              return;
              AppMethodBeat.o(27880);
              return;
              paramAnonymous2MenuItem = new cs();
              com.tencent.mm.pluginsdk.model.g.a(paramAnonymous2MenuItem, RecordMsgDetailUI.c(RecordMsgDetailUI.this));
              paramAnonymous2MenuItem.dck.dcq = 9;
              paramAnonymous2MenuItem.dck.activity = RecordMsgDetailUI.this;
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2MenuItem);
            }
          }
        };
        paramAnonymousMenuItem.cED();
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
      ac.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[] { Integer.valueOf(paramInt2) });
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
        if (!bs.isNullOrNil((String)localObject)) {
          break label103;
        }
        ac.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27892);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label103:
      az.ayM();
      final bo localbo = com.tencent.mm.model.c.awD().vP(this.msgId);
      if (localbo.field_msgId != this.msgId)
      {
        ac.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(27892);
        return;
      }
      final p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27883);
          com.tencent.mm.plugin.record.b.n.a(this.cKY, paramIntent, localbo);
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27882);
              RecordMsgDetailUI.4.this.qLa.dismiss();
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
      ((cs)localObject).dck.activity = this;
      ((cs)localObject).dck.dcq = 8;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
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
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((e)this.wkg);
    if (this.wjR != null)
    {
      byte[] arrayOfByte = this.wjR.duc();
      if ((!this.wko) && (this.cZc != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.cZc.rh(new String(arrayOfByte, Charset.forName("UTF-8")));
        az.ayM();
        com.tencent.mm.model.c.awD().a(this.msgId, this.cZc);
      }
    }
    AppMethodBeat.o(27890);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(196071);
    super.onPause();
    if (this.wjR != null) {
      this.wjR.wkK = false;
    }
    AppMethodBeat.o(196071);
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
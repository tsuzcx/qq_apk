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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.d.a;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordMsgDetailUI
  extends RecordMsgBaseUI
{
  private boolean dCy;
  private String dFU;
  private bv dlw;
  private com.tencent.mm.ui.base.p fSP;
  private long msgId;
  private String title;
  private i xHE;
  private com.tencent.mm.protocal.b.a.c xHY;
  private boolean xHZ;
  private String xIa;
  private String xIb;
  private boolean xIc;
  com.tencent.mm.sdk.b.c<rz> xId;
  
  public RecordMsgDetailUI()
  {
    AppMethodBeat.i(186613);
    this.xHY = null;
    this.msgId = -1L;
    this.dFU = null;
    this.dCy = true;
    this.xHZ = false;
    this.title = "";
    this.xIa = "";
    this.xIb = "";
    this.fSP = null;
    this.xId = new RecordMsgDetailUI.1(this);
    AppMethodBeat.o(186613);
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
      Iterator localIterator = paramc.hFT.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (ajx)localIterator.next();
        if (paramc.GAu.GBb.GBE != null)
        {
          str1 = getContext().getString(2131762236);
          i = 1;
        }
        else
        {
          if (paramc.GAu.GBb.dzZ == null) {
            break label225;
          }
          if (str2 == null)
          {
            str2 = paramc.GAw;
          }
          else
          {
            if (str2 == paramc.GAw) {
              break label225;
            }
            paramc = paramc.GAw;
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
  
  private void updateView()
  {
    AppMethodBeat.i(27888);
    f localf = new f();
    localf.xHu = this.xHY.hFT;
    localf.msgId = this.msgId;
    localf.dFU = this.dFU;
    localf.xHv = new com.tencent.mm.plugin.record.b.x();
    if ((this.dlw != null) && (!this.xIc) && (this.dlw.field_transContent != null)) {}
    try
    {
      localf.xHv.parseFrom(this.dlw.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.dHF();
      this.xHU.a(localf);
      this.xHE = new i(this, this.xHU, localf);
      this.xHU.xHE = this.xHE;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((e)this.xHU);
      AppMethodBeat.o(27888);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.RecordMsgDetailUI", localException, "", new Object[0]);
      }
    }
  }
  
  protected final void dHF()
  {
    AppMethodBeat.i(27886);
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dFU = getIntent().getStringExtra("record_xml");
    this.dCy = getIntent().getBooleanExtra("record_show_share", true);
    this.xHZ = getIntent().getBooleanExtra("big_appmsg", false);
    this.xIc = getIntent().getBooleanExtra("record_nest", false);
    this.xHY = com.tencent.mm.plugin.record.b.p.awG(this.dFU);
    bc.aCg();
    this.dlw = com.tencent.mm.model.c.azI().ys(this.msgId);
    if (this.xHY != null) {
      if (a(this.xHY) != null)
      {
        this.title = a(this.xHY);
        if (!bu.ht(this.xHY.hFT))
        {
          this.xIa = ((ajx)this.xHY.hFT.getFirst()).GAy;
          this.xIb = ((ajx)this.xHY.hFT.getLast()).GAy;
        }
      }
    }
    for (;;)
    {
      if ((this.dFU != null) && (this.xHY != null)) {
        break label375;
      }
      dHN();
      setBackBtn(new RecordMsgDetailUI.2(this));
      Object localObject;
      if ((this.xHZ) && (ao.bJV().CZ(this.msgId) != null))
      {
        bc.aCg();
        localObject = com.tencent.mm.model.c.azI().ys(this.msgId);
        localObject = new com.tencent.mm.plugin.record.b.f(this.msgId, ((ei)localObject).field_msgSvrId, new com.tencent.mm.ak.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
          {
            AppMethodBeat.i(186605);
            if (paramAnonymousInt1 == paramAnonymousInt2)
            {
              if (RecordMsgDetailUI.b(RecordMsgDetailUI.this) != null)
              {
                RecordMsgDetailUI.b(RecordMsgDetailUI.this).dismiss();
                RecordMsgDetailUI.c(RecordMsgDetailUI.this);
              }
              bc.aCg();
              bv localbv = com.tencent.mm.model.c.azI().ys(RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymousn = localbv.field_content;
              if (com.tencent.mm.model.x.wb(localbv.field_talker)) {
                paramAnonymousn = bl.BN(localbv.field_content);
              }
              paramAnonymousn = k.b.zb(paramAnonymousn);
              if (paramAnonymousn != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousn.hDg);
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, com.tencent.mm.plugin.record.b.p.awG(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
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
              RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((ajx)RecordMsgDetailUI.e(RecordMsgDetailUI.this).hFT.getFirst()).GAy);
              RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((ajx)RecordMsgDetailUI.e(RecordMsgDetailUI.this).hFT.getLast()).GAy);
              RecordMsgDetailUI.f(RecordMsgDetailUI.this);
              AppMethodBeat.o(186605);
              return;
              label240:
              RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
            }
          }
        });
        bc.ajj().a((n)localObject, 0);
      }
      AppMethodBeat.o(27886);
      return;
      this.title = this.xHY.title;
      break;
      if (this.dlw != null)
      {
        localObject = k.b.aB(this.dlw.field_content, this.dlw.field_reserved);
        if (localObject != null)
        {
          this.title = ((k.b)localObject).title;
          this.fSP = com.tencent.mm.ui.base.p.a(this, getString(2131760709), true, 0, null);
        }
      }
    }
    label375:
    updateView();
    AppMethodBeat.o(27886);
  }
  
  protected final h dHG()
  {
    AppMethodBeat.i(27889);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    AppMethodBeat.o(27889);
    return locale;
  }
  
  protected final String dHH()
  {
    return this.title;
  }
  
  protected final String dHI()
  {
    return this.xIa;
  }
  
  protected final String dHJ()
  {
    return this.xIb;
  }
  
  protected final void dHK()
  {
    AppMethodBeat.i(27891);
    if (!this.dCy)
    {
      AppMethodBeat.o(27891);
      return;
    }
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186609);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(186606);
            paramAnonymous2l.d(0, RecordMsgDetailUI.this.getString(2131759001));
            if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
              paramAnonymous2l.d(2, RecordMsgDetailUI.this.getString(2131761941));
            }
            AppMethodBeat.o(186606);
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(186608);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(186608);
              return;
              bc.aCg();
              if (!((Boolean)com.tencent.mm.model.c.ajA().get(327714, Boolean.FALSE)).booleanValue())
              {
                bc.aCg();
                com.tencent.mm.model.c.ajA().set(327714, Boolean.TRUE);
                paramAnonymous2MenuItem = new d.a(RecordMsgDetailUI.this);
                paramAnonymous2MenuItem.aZi(RecordMsgDetailUI.this.getResources().getString(2131762247));
                paramAnonymous2MenuItem.aZh(RecordMsgDetailUI.this.getResources().getString(2131755906));
                paramAnonymous2MenuItem.afU(2131760315).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(186607);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Select_Conv_Type", 3);
                    localIntent.putExtra("select_is_ret", true);
                    localIntent.putExtra("mutil_select_is_ret", true);
                    localIntent.putExtra("Retr_Msg_Type", 10);
                    localIntent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                    com.tencent.mm.br.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
                    paramAnonymous3DialogInterface.dismiss();
                    AppMethodBeat.o(186607);
                  }
                });
                paramAnonymous2MenuItem.fQv().show();
                AppMethodBeat.o(186608);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 10);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              com.tencent.mm.br.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1001);
              AppMethodBeat.o(186608);
              return;
              AppMethodBeat.o(186608);
              return;
              paramAnonymous2MenuItem = new cw();
              com.tencent.mm.pluginsdk.model.g.a(paramAnonymous2MenuItem, RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymous2MenuItem.doL.doR = 9;
              paramAnonymous2MenuItem.doL.activity = RecordMsgDetailUI.this;
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous2MenuItem);
            }
          }
        };
        paramAnonymousMenuItem.cPF();
        AppMethodBeat.o(186609);
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
      ae.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[] { Integer.valueOf(paramInt2) });
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
        if (!bu.isNullOrNil((String)localObject)) {
          break label105;
        }
        ae.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27892);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label105:
      bc.aCg();
      final bv localbv = com.tencent.mm.model.c.azI().ys(this.msgId);
      if (localbv.field_msgId != this.msgId)
      {
        ae.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(27892);
        return;
      }
      final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186611);
          com.tencent.mm.plugin.record.b.p.a(this.cXi, paramIntent, localbv);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186610);
              RecordMsgDetailUI.5.this.rDo.dismiss();
              AppMethodBeat.o(186610);
            }
          });
          AppMethodBeat.o(186611);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(186612);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(186612);
          return str;
        }
      });
      AppMethodBeat.o(27892);
      return;
    }
    if ((1002 == paramInt1) && (paramIntent.getBooleanExtra("kfavorite", false)))
    {
      localObject = new cw();
      com.tencent.mm.pluginsdk.model.g.a((cw)localObject, paramIntent);
      ((cw)localObject).doL.activity = this;
      ((cw)localObject).doL.doR = 8;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
    }
    AppMethodBeat.o(27892);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27885);
    super.onCreate(paramBundle);
    this.xId.alive();
    AppMethodBeat.o(27885);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27890);
    super.onDestroy();
    this.xId.dead();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((e)this.xHU);
    if (this.xHE != null)
    {
      byte[] arrayOfByte = this.xHE.dHQ();
      if ((!this.xIc) && (this.dlw != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.dlw.ul(new String(arrayOfByte, Charset.forName("UTF-8")));
        bc.aCg();
        com.tencent.mm.model.c.azI().a(this.msgId, this.dlw);
      }
    }
    AppMethodBeat.o(27890);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(186614);
    super.onPause();
    if (this.xHE != null) {
      this.xHE.xIB = false;
    }
    AppMethodBeat.o(186614);
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
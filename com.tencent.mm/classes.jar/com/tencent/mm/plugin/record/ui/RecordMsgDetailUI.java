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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
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
  private boolean dBt;
  private String dEP;
  private bu dku;
  private com.tencent.mm.ui.base.p fQJ;
  private long msgId;
  private String title;
  private i xrH;
  private com.tencent.mm.protocal.b.a.c xsb;
  private boolean xsc;
  private String xsd;
  private String xse;
  private boolean xsf;
  com.tencent.mm.sdk.b.c<ry> xsg;
  
  public RecordMsgDetailUI()
  {
    AppMethodBeat.i(193338);
    this.xsb = null;
    this.msgId = -1L;
    this.dEP = null;
    this.dBt = true;
    this.xsc = false;
    this.title = "";
    this.xsd = "";
    this.xse = "";
    this.fQJ = null;
    this.xsg = new RecordMsgDetailUI.1(this);
    AppMethodBeat.o(193338);
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
      Iterator localIterator = paramc.hDb.iterator();
      i = 0;
      localc = null;
      str2 = null;
      str1 = null;
      while (localIterator.hasNext())
      {
        paramc = (ajn)localIterator.next();
        if (paramc.GhL.Gis.GiV != null)
        {
          str1 = getContext().getString(2131762236);
          i = 1;
        }
        else
        {
          if (paramc.GhL.Gis.dyU == null) {
            break label225;
          }
          if (str2 == null)
          {
            str2 = paramc.GhN;
          }
          else
          {
            if (str2 == paramc.GhN) {
              break label225;
            }
            paramc = paramc.GhN;
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
    localf.xrx = this.xsb.hDb;
    localf.msgId = this.msgId;
    localf.dEP = this.dEP;
    localf.xry = new x();
    if ((this.dku != null) && (!this.xsf) && (this.dku.field_transContent != null)) {}
    try
    {
      localf.xry.parseFrom(this.dku.field_transContent.getBytes(Charset.forName("UTF-8")));
      super.dEo();
      this.xrX.a(localf);
      this.xrH = new i(this, this.xrX, localf);
      this.xrX.xrH = this.xrH;
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((e)this.xrX);
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
  
  protected final void dEo()
  {
    AppMethodBeat.i(27886);
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dEP = getIntent().getStringExtra("record_xml");
    this.dBt = getIntent().getBooleanExtra("record_show_share", true);
    this.xsc = getIntent().getBooleanExtra("big_appmsg", false);
    this.xsf = getIntent().getBooleanExtra("record_nest", false);
    this.xsb = com.tencent.mm.plugin.record.b.p.avr(this.dEP);
    ba.aBQ();
    this.dku = com.tencent.mm.model.c.azs().xY(this.msgId);
    if (this.xsb != null) {
      if (a(this.xsb) != null)
      {
        this.title = a(this.xsb);
        if (!bt.hj(this.xsb.hDb))
        {
          this.xsd = ((ajn)this.xsb.hDb.getFirst()).GhP;
          this.xse = ((ajn)this.xsb.hDb.getLast()).GhP;
        }
      }
    }
    for (;;)
    {
      if ((this.dEP != null) && (this.xsb != null)) {
        break label375;
      }
      dEw();
      setBackBtn(new RecordMsgDetailUI.2(this));
      Object localObject;
      if ((this.xsc) && (ao.bIX().CB(this.msgId) != null))
      {
        ba.aBQ();
        localObject = com.tencent.mm.model.c.azs().xY(this.msgId);
        localObject = new com.tencent.mm.plugin.record.b.f(this.msgId, ((ei)localObject).field_msgSvrId, new com.tencent.mm.al.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
          {
            AppMethodBeat.i(193330);
            if (paramAnonymousInt1 == paramAnonymousInt2)
            {
              if (RecordMsgDetailUI.b(RecordMsgDetailUI.this) != null)
              {
                RecordMsgDetailUI.b(RecordMsgDetailUI.this).dismiss();
                RecordMsgDetailUI.c(RecordMsgDetailUI.this);
              }
              ba.aBQ();
              bu localbu = com.tencent.mm.model.c.azs().xY(RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymousn = localbu.field_content;
              if (w.vF(localbu.field_talker)) {
                paramAnonymousn = bj.Bl(localbu.field_content);
              }
              paramAnonymousn = k.b.yr(paramAnonymousn);
              if (paramAnonymousn != null)
              {
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, paramAnonymousn.hAs);
                RecordMsgDetailUI.a(RecordMsgDetailUI.this, com.tencent.mm.plugin.record.b.p.avr(RecordMsgDetailUI.d(RecordMsgDetailUI.this)));
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
              RecordMsgDetailUI.c(RecordMsgDetailUI.this, ((ajn)RecordMsgDetailUI.e(RecordMsgDetailUI.this).hDb.getFirst()).GhP);
              RecordMsgDetailUI.d(RecordMsgDetailUI.this, ((ajn)RecordMsgDetailUI.e(RecordMsgDetailUI.this).hDb.getLast()).GhP);
              RecordMsgDetailUI.f(RecordMsgDetailUI.this);
              AppMethodBeat.o(193330);
              return;
              label240:
              RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.e(RecordMsgDetailUI.this).title);
            }
          }
        });
        ba.aiU().a((n)localObject, 0);
      }
      AppMethodBeat.o(27886);
      return;
      this.title = this.xsb.title;
      break;
      if (this.dku != null)
      {
        localObject = k.b.aA(this.dku.field_content, this.dku.field_reserved);
        if (localObject != null)
        {
          this.title = ((k.b)localObject).title;
          this.fQJ = com.tencent.mm.ui.base.p.a(this, getString(2131760709), true, 0, null);
        }
      }
    }
    label375:
    updateView();
    AppMethodBeat.o(27886);
  }
  
  protected final h dEp()
  {
    AppMethodBeat.i(27889);
    e locale = new e(this, new g());
    locale.fromScene = getIntent().getIntExtra("from_scene", 0);
    AppMethodBeat.o(27889);
    return locale;
  }
  
  protected final String dEq()
  {
    return this.title;
  }
  
  protected final String dEr()
  {
    return this.xsd;
  }
  
  protected final String dEs()
  {
    return this.xse;
  }
  
  protected final void dEt()
  {
    AppMethodBeat.i(27891);
    if (!this.dBt)
    {
      AppMethodBeat.o(27891);
      return;
    }
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193334);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(193331);
            paramAnonymous2l.c(0, RecordMsgDetailUI.this.getString(2131759001));
            if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
              paramAnonymous2l.c(2, RecordMsgDetailUI.this.getString(2131761941));
            }
            AppMethodBeat.o(193331);
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(193333);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(193333);
              return;
              ba.aBQ();
              if (!((Boolean)com.tencent.mm.model.c.ajl().get(327714, Boolean.FALSE)).booleanValue())
              {
                ba.aBQ();
                com.tencent.mm.model.c.ajl().set(327714, Boolean.TRUE);
                paramAnonymous2MenuItem = new d.a(RecordMsgDetailUI.this);
                paramAnonymous2MenuItem.aXG(RecordMsgDetailUI.this.getResources().getString(2131762247));
                paramAnonymous2MenuItem.aXF(RecordMsgDetailUI.this.getResources().getString(2131755906));
                paramAnonymous2MenuItem.afl(2131760315).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(193332);
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Select_Conv_Type", 3);
                    localIntent.putExtra("select_is_ret", true);
                    localIntent.putExtra("mutil_select_is_ret", true);
                    localIntent.putExtra("Retr_Msg_Type", 10);
                    localIntent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
                    com.tencent.mm.bs.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1001);
                    paramAnonymous3DialogInterface.dismiss();
                    AppMethodBeat.o(193332);
                  }
                });
                paramAnonymous2MenuItem.fMb().show();
                AppMethodBeat.o(193333);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 10);
              paramAnonymous2MenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              com.tencent.mm.bs.d.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1001);
              AppMethodBeat.o(193333);
              return;
              AppMethodBeat.o(193333);
              return;
              paramAnonymous2MenuItem = new cv();
              com.tencent.mm.pluginsdk.model.g.a(paramAnonymous2MenuItem, RecordMsgDetailUI.a(RecordMsgDetailUI.this));
              paramAnonymous2MenuItem.dnG.dnM = 9;
              paramAnonymous2MenuItem.dnG.activity = RecordMsgDetailUI.this;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2MenuItem);
            }
          }
        };
        paramAnonymousMenuItem.cMW();
        AppMethodBeat.o(193334);
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
          break label94;
        }
      }
      label94:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        if (!bt.isNullOrNil((String)localObject)) {
          break label105;
        }
        ad.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27892);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label105:
      ba.aBQ();
      final bu localbu = com.tencent.mm.model.c.azs().xY(this.msgId);
      if (localbu.field_msgId != this.msgId)
      {
        ad.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
        AppMethodBeat.o(27892);
        return;
      }
      final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193336);
          com.tencent.mm.plugin.record.b.p.a(this.cWl, paramIntent, localbu);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193335);
              RecordMsgDetailUI.5.this.rvc.dismiss();
              AppMethodBeat.o(193335);
            }
          });
          AppMethodBeat.o(193336);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(193337);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(193337);
          return str;
        }
      });
      AppMethodBeat.o(27892);
      return;
    }
    if ((1002 == paramInt1) && (paramIntent.getBooleanExtra("kfavorite", false)))
    {
      localObject = new cv();
      com.tencent.mm.pluginsdk.model.g.a((cv)localObject, paramIntent);
      ((cv)localObject).dnG.activity = this;
      ((cv)localObject).dnG.dnM = 8;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
    }
    AppMethodBeat.o(27892);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27885);
    super.onCreate(paramBundle);
    this.xsg.alive();
    AppMethodBeat.o(27885);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27890);
    super.onDestroy();
    this.xsg.dead();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((e)this.xrX);
    if (this.xrH != null)
    {
      byte[] arrayOfByte = this.xrH.dEz();
      if ((!this.xsf) && (this.dku != null) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.dku.tQ(new String(arrayOfByte, Charset.forName("UTF-8")));
        ba.aBQ();
        com.tencent.mm.model.c.azs().a(this.msgId, this.dku);
      }
    }
    AppMethodBeat.o(27890);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(193339);
    super.onPause();
    if (this.xrH != null) {
      this.xrH.xsE = false;
    }
    AppMethodBeat.o(193339);
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
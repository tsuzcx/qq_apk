package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI
  extends RecordMsgBaseUI
{
  private boolean dBt;
  private k.a rua;
  private com.tencent.mm.plugin.fav.a.g rxY;
  private long xrE;
  private boolean xrF;
  private boolean xrG;
  private i xrH;
  
  public FavRecordDetailUI()
  {
    AppMethodBeat.i(27851);
    this.xrE = -1L;
    this.dBt = true;
    this.xrF = true;
    this.xrG = false;
    this.rua = new k.a()
    {
      public final void a(String paramAnonymousString, final m paramAnonymousm)
      {
        AppMethodBeat.i(27843);
        if (paramAnonymousm == null)
        {
          AppMethodBeat.o(27843);
          return;
        }
        if (paramAnonymousm.obj == null)
        {
          AppMethodBeat.o(27843);
          return;
        }
        long l = ((Long)paramAnonymousm.obj).longValue();
        if (l < 0L)
        {
          AppMethodBeat.o(27843);
          return;
        }
        if (FavRecordDetailUI.a(FavRecordDetailUI.this) == l)
        {
          paramAnonymousString = com.tencent.mm.plugin.record.b.h.yE(FavRecordDetailUI.a(FavRecordDetailUI.this));
          paramAnonymousm = new b();
          paramAnonymousm.prW = paramAnonymousString;
          if ((paramAnonymousString != null) && (paramAnonymousString.field_favProto != null))
          {
            paramAnonymousm.xrx = paramAnonymousString.field_favProto.nZa;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(27842);
                FavRecordDetailUI.this.xrX.a(paramAnonymousm);
                AppMethodBeat.o(27842);
              }
            });
          }
        }
        AppMethodBeat.o(27843);
      }
    };
    AppMethodBeat.o(27851);
  }
  
  protected final void dEo()
  {
    AppMethodBeat.i(27853);
    this.xrE = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.dBt = getIntent().getBooleanExtra("show_share", true);
    this.rxY = com.tencent.mm.plugin.record.b.h.yE(this.xrE);
    if (this.rxY == null)
    {
      finish();
      AppMethodBeat.o(27853);
      return;
    }
    H(this.rxY);
    Object localObject1 = new b();
    ((b)localObject1).prW = this.rxY;
    ((b)localObject1).xrx = this.rxY.field_favProto.nZa;
    ((b)localObject1).xry = new com.tencent.mm.plugin.record.b.x();
    Object localObject2 = ((b)localObject1).xrx;
    if (localObject2 == null) {
      this.xrF = false;
    }
    for (;;)
    {
      super.dEo();
      this.xrX.a((a)localObject1);
      this.xrH = new i(this, this.xrX, (a)localObject1);
      localObject1 = ((b)localObject1).xrx;
      if (localObject1 != null) {
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27850);
            if (this.xrO == null)
            {
              AppMethodBeat.o(27850);
              return;
            }
            ad.i("MicroMsg.FavRecordDetailUI", "start calc");
            Object localObject = this.xrO.iterator();
            long l1 = 0L;
            int m = 0;
            int k = 0;
            int j = 0;
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              ajn localajn = (ajn)((Iterator)localObject).next();
              if ((localajn != null) && (!FavRecordDetailUI.e(FavRecordDetailUI.this))) {
                switch (localajn.dataType)
                {
                default: 
                  m += 1;
                  break;
                case 2: 
                  j += 1;
                  break;
                case 1: 
                  i += 1;
                  if (localajn.desc != null) {}
                  for (long l2 = localajn.desc.getBytes().length;; l2 = 0L)
                  {
                    l1 = l2 + l1;
                    break;
                  }
                case 4: 
                case 15: 
                  k += 1;
                }
              }
            }
            localObject = String.format("%s:%s:%s:%s:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
            FavRecordDetailUI.a(FavRecordDetailUI.this, (String)localObject);
            ad.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", new Object[] { localObject });
            AppMethodBeat.o(27850);
          }
        }, "calc_fav_record_info");
      }
      this.xrX.xrH = this.xrH;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this.rua);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(((d)this.xrX).xrA);
      AppMethodBeat.o(27853);
      return;
      if (((List)localObject2).size() == 0)
      {
        this.xrF = false;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext()) {
            if (((ajn)((Iterator)localObject2).next()).GhZ != 0)
            {
              this.xrF = false;
              break;
            }
          }
        }
        this.xrF = true;
      }
    }
  }
  
  protected final h dEp()
  {
    AppMethodBeat.i(27854);
    d locald = new d(this, new c(this));
    AppMethodBeat.o(27854);
    return locald;
  }
  
  protected final String dEq()
  {
    AppMethodBeat.i(27858);
    Object localObject;
    if ((14 == this.rxY.field_type) && (!bt.isNullOrNil(this.rxY.field_favProto.title))) {
      localObject = this.rxY.field_favProto.title;
    }
    for (;;)
    {
      AppMethodBeat.o(27858);
      return localObject;
      akj localakj = this.rxY.field_favProto.Gjv;
      if ((localakj != null) && (!bt.isNullOrNil(localakj.GiV)))
      {
        String str1 = v.zf(localakj.GiV);
        String str2;
        if (u.aAm().equals(localakj.dyU))
        {
          str2 = com.tencent.mm.plugin.record.b.p.zg(localakj.toUser);
          localObject = str1;
          if (!bt.bI(str2, "").equals(localakj.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        for (;;)
        {
          ad.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[] { localakj.dyU, localakj.toUser });
          break;
          str2 = com.tencent.mm.plugin.record.b.p.zg(localakj.dyU);
          localObject = str1;
          if (!bt.bI(str2, "").equals(localakj.dyU)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      ad.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[] { this.rxY.field_fromUser });
      localObject = com.tencent.mm.plugin.record.b.p.zg(this.rxY.field_fromUser);
    }
  }
  
  protected final String dEr()
  {
    AppMethodBeat.i(27859);
    Object localObject = this.rxY.field_favProto.nZa;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((ajn)((LinkedList)localObject).getFirst()).GhP;
      AppMethodBeat.o(27859);
      return localObject;
    }
    AppMethodBeat.o(27859);
    return null;
  }
  
  protected final String dEs()
  {
    AppMethodBeat.i(27860);
    Object localObject = this.rxY.field_favProto.nZa;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((ajn)((LinkedList)localObject).getLast()).GhP;
      AppMethodBeat.o(27860);
      return localObject;
    }
    AppMethodBeat.o(27860);
    return null;
  }
  
  protected final void dEt()
  {
    AppMethodBeat.i(27861);
    if (!this.dBt)
    {
      AppMethodBeat.o(27861);
      return;
    }
    addIconOptionMenu(0, 2131764451, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27848);
        paramAnonymousMenuItem = new e(FavRecordDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(27844);
            ad.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[] { Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_id), Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_itemStatus) });
            if ((FavRecordDetailUI.b(FavRecordDetailUI.this).field_id > 0) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).cuT()) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).isUploadFailed()) && (FavRecordDetailUI.c(FavRecordDetailUI.this))) {
              paramAnonymous2l.c(0, FavRecordDetailUI.this.getString(2131759001));
            }
            paramAnonymous2l.c(5, FavRecordDetailUI.this.getString(2131758988));
            paramAnonymous2l.c(3, FavRecordDetailUI.this.getString(2131758875));
            paramAnonymous2l.c(2, FavRecordDetailUI.this.getString(2131755707));
            AppMethodBeat.o(27844);
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(27847);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(27847);
              return;
              if (FavRecordDetailUI.yH(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId))
              {
                paramAnonymous2Int = 2131758864;
                if (FavRecordDetailUI.b(FavRecordDetailUI.this).field_type == 18) {
                  paramAnonymous2Int = 2131758863;
                }
                com.tencent.mm.ui.base.h.cl(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(paramAnonymous2Int, new Object[] { bt.sy(com.tencent.mm.n.b.ack()) }));
                AppMethodBeat.o(27847);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId);
              com.tencent.mm.bs.d.c(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4097);
              com.tencent.mm.plugin.fav.a.h.i(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId, 1, 0);
              AppMethodBeat.o(27847);
              return;
              com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(27846);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(2131755709), false, null);
                  gw localgw = new gw();
                  localgw.dsV.type = 12;
                  localgw.dsV.dnC = FavRecordDetailUI.a(FavRecordDetailUI.this);
                  localgw.dsV.dta = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(27845);
                      paramAnonymous3DialogInterface.dismiss();
                      ad.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavRecordDetailUI.a(FavRecordDetailUI.this)) });
                      FavRecordDetailUI.this.finish();
                      AppMethodBeat.o(27845);
                    }
                  };
                  com.tencent.mm.sdk.b.a.IbL.l(localgw);
                  AppMethodBeat.o(27846);
                }
              }, null);
              AppMethodBeat.o(27847);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavRecordDetailUI.a(FavRecordDetailUI.this));
              com.tencent.mm.plugin.fav.a.b.b(FavRecordDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(27847);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 1);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavRecordDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(27847);
              return;
              j.a(FavRecordDetailUI.this, FavRecordDetailUI.a(FavRecordDetailUI.this), FavRecordDetailUI.d(FavRecordDetailUI.this));
            }
          }
        };
        paramAnonymousMenuItem.cMW();
        AppMethodBeat.o(27848);
        return true;
      }
    });
    AppMethodBeat.o(27861);
  }
  
  protected final void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27862);
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject = new gw();
      ((gw)localObject).dsV.type = 32;
      ((gw)localObject).dsV.dnC = this.xrE;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((gw)localObject).dsW.dtm)
      {
        com.tencent.mm.ui.base.h.cl(getContext(), getString(2131755010));
        AppMethodBeat.o(27862);
        return;
      }
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label230;
        }
      }
      label230:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
        gw localgw = new gw();
        localgw.dsV.type = 13;
        localgw.dsV.context = getContext();
        localgw.dsV.toUser = ((String)localObject);
        localgw.dsV.dtb = paramIntent;
        localgw.dsV.dnC = this.xrE;
        localgw.dsV.dta = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27849);
            localp.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.n(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(2131759420));
            AppMethodBeat.o(27849);
          }
        };
        com.tencent.mm.sdk.b.a.IbL.l(localgw);
        AppMethodBeat.o(27862);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
    }
    AppMethodBeat.o(27862);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27852);
    super.onCreate(paramBundle);
    AppMethodBeat.o(27852);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27857);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this.rua);
    if (this.xrX != null) {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(((d)this.xrX).xrA);
    }
    this.xrG = true;
    if (this.xrH != null) {
      this.xrH.dEz();
    }
    super.onDestroy();
    AppMethodBeat.o(27857);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(193324);
    super.onPause();
    if (this.xrH != null) {
      this.xrH.xsE = false;
    }
    AppMethodBeat.o(193324);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27855);
    super.onResume();
    Object localObject2 = (b)((d)this.xrX).xrT;
    com.tencent.mm.plugin.fav.a.g localg;
    Object localObject1;
    if (((b)localObject2).prW != null)
    {
      localg = com.tencent.mm.plugin.record.b.h.yE(((b)localObject2).prW.field_localId);
      if ((localg == null) || (localg.field_favProto == null))
      {
        AppMethodBeat.o(27855);
        return;
      }
      localObject1 = localg.field_favProto.nZa;
      localObject2 = ((b)localObject2).xrx.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((LinkedList)localObject1).contains((ajn)((Iterator)localObject2).next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new b();
        ((b)localObject1).prW = localg;
        ((b)localObject1).xrx = localg.field_favProto.nZa;
        this.xrX.a((a)localObject1);
      }
      AppMethodBeat.o(27855);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(27856);
    super.onStop();
    AppMethodBeat.o(27856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI
 * JD-Core Version:    0.7.0.1
 */
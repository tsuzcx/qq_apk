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
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private boolean dCy;
  private k.a rCm;
  private com.tencent.mm.plugin.fav.a.g rGj;
  private long xHB;
  private boolean xHC;
  private boolean xHD;
  private i xHE;
  
  public FavRecordDetailUI()
  {
    AppMethodBeat.i(27851);
    this.xHB = -1L;
    this.dCy = true;
    this.xHC = true;
    this.xHD = false;
    this.rCm = new k.a()
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
          paramAnonymousString = com.tencent.mm.plugin.record.b.h.zd(FavRecordDetailUI.a(FavRecordDetailUI.this));
          paramAnonymousm = new b();
          paramAnonymousm.pyC = paramAnonymousString;
          if ((paramAnonymousString != null) && (paramAnonymousString.field_favProto != null))
          {
            paramAnonymousm.xHu = paramAnonymousString.field_favProto.oeJ;
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(27842);
                FavRecordDetailUI.this.xHU.a(paramAnonymousm);
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
  
  protected final void dHF()
  {
    AppMethodBeat.i(27853);
    this.xHB = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.dCy = getIntent().getBooleanExtra("show_share", true);
    this.rGj = com.tencent.mm.plugin.record.b.h.zd(this.xHB);
    if (this.rGj == null)
    {
      finish();
      AppMethodBeat.o(27853);
      return;
    }
    H(this.rGj);
    Object localObject1 = new b();
    ((b)localObject1).pyC = this.rGj;
    ((b)localObject1).xHu = this.rGj.field_favProto.oeJ;
    ((b)localObject1).xHv = new com.tencent.mm.plugin.record.b.x();
    Object localObject2 = ((b)localObject1).xHu;
    if (localObject2 == null) {
      this.xHC = false;
    }
    for (;;)
    {
      super.dHF();
      this.xHU.a((a)localObject1);
      this.xHE = new i(this, this.xHU, (a)localObject1);
      localObject1 = ((b)localObject1).xHu;
      if (localObject1 != null) {
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27850);
            if (this.xHL == null)
            {
              AppMethodBeat.o(27850);
              return;
            }
            ae.i("MicroMsg.FavRecordDetailUI", "start calc");
            Object localObject = this.xHL.iterator();
            long l1 = 0L;
            int m = 0;
            int k = 0;
            int j = 0;
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              ajx localajx = (ajx)((Iterator)localObject).next();
              if ((localajx != null) && (!FavRecordDetailUI.e(FavRecordDetailUI.this))) {
                switch (localajx.dataType)
                {
                default: 
                  m += 1;
                  break;
                case 2: 
                  j += 1;
                  break;
                case 1: 
                  i += 1;
                  if (localajx.desc != null) {}
                  for (long l2 = localajx.desc.getBytes().length;; l2 = 0L)
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
            ae.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", new Object[] { localObject });
            AppMethodBeat.o(27850);
          }
        }, "calc_fav_record_info");
      }
      this.xHU.xHE = this.xHE;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this.rCm);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(((d)this.xHU).xHx);
      AppMethodBeat.o(27853);
      return;
      if (((List)localObject2).size() == 0)
      {
        this.xHC = false;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext()) {
            if (((ajx)((Iterator)localObject2).next()).GAI != 0)
            {
              this.xHC = false;
              break;
            }
          }
        }
        this.xHC = true;
      }
    }
  }
  
  protected final h dHG()
  {
    AppMethodBeat.i(27854);
    d locald = new d(this, new c(this));
    AppMethodBeat.o(27854);
    return locald;
  }
  
  protected final String dHH()
  {
    AppMethodBeat.i(27858);
    Object localObject;
    if ((14 == this.rGj.field_type) && (!bu.isNullOrNil(this.rGj.field_favProto.title))) {
      localObject = this.rGj.field_favProto.title;
    }
    for (;;)
    {
      AppMethodBeat.o(27858);
      return localObject;
      akt localakt = this.rGj.field_favProto.GCe;
      if ((localakt != null) && (!bu.isNullOrNil(localakt.GBE)))
      {
        String str1 = w.zP(localakt.GBE);
        String str2;
        if (v.aAC().equals(localakt.dzZ))
        {
          str2 = com.tencent.mm.plugin.record.b.p.zQ(localakt.toUser);
          localObject = str1;
          if (!bu.bI(str2, "").equals(localakt.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        for (;;)
        {
          ae.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[] { localakt.dzZ, localakt.toUser });
          break;
          str2 = com.tencent.mm.plugin.record.b.p.zQ(localakt.dzZ);
          localObject = str1;
          if (!bu.bI(str2, "").equals(localakt.dzZ)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      ae.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[] { this.rGj.field_fromUser });
      localObject = com.tencent.mm.plugin.record.b.p.zQ(this.rGj.field_fromUser);
    }
  }
  
  protected final String dHI()
  {
    AppMethodBeat.i(27859);
    Object localObject = this.rGj.field_favProto.oeJ;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((ajx)((LinkedList)localObject).getFirst()).GAy;
      AppMethodBeat.o(27859);
      return localObject;
    }
    AppMethodBeat.o(27859);
    return null;
  }
  
  protected final String dHJ()
  {
    AppMethodBeat.i(27860);
    Object localObject = this.rGj.field_favProto.oeJ;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((ajx)((LinkedList)localObject).getLast()).GAy;
      AppMethodBeat.o(27860);
      return localObject;
    }
    AppMethodBeat.o(27860);
    return null;
  }
  
  protected final void dHK()
  {
    AppMethodBeat.i(27861);
    if (!this.dCy)
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
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(27844);
            ae.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[] { Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_id), Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_itemStatus) });
            if ((FavRecordDetailUI.b(FavRecordDetailUI.this).field_id > 0) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).cwu()) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).isUploadFailed()) && (FavRecordDetailUI.c(FavRecordDetailUI.this))) {
              paramAnonymous2l.d(0, FavRecordDetailUI.this.getString(2131759001));
            }
            paramAnonymous2l.d(5, FavRecordDetailUI.this.getString(2131758988));
            paramAnonymous2l.d(3, FavRecordDetailUI.this.getString(2131758875));
            paramAnonymous2l.d(2, FavRecordDetailUI.this.getString(2131755707));
            AppMethodBeat.o(27844);
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
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
              if (FavRecordDetailUI.zg(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId))
              {
                paramAnonymous2Int = 2131758864;
                if (FavRecordDetailUI.b(FavRecordDetailUI.this).field_type == 18) {
                  paramAnonymous2Int = 2131758863;
                }
                com.tencent.mm.ui.base.h.cm(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(paramAnonymous2Int, new Object[] { bu.sL(com.tencent.mm.n.b.acv()) }));
                AppMethodBeat.o(27847);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId);
              com.tencent.mm.br.d.c(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4097);
              com.tencent.mm.plugin.fav.a.h.i(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId, 1, 0);
              AppMethodBeat.o(27847);
              return;
              com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(27846);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(2131755709), false, null);
                  gx localgx = new gx();
                  localgx.dub.type = 12;
                  localgx.dub.doH = FavRecordDetailUI.a(FavRecordDetailUI.this);
                  localgx.dub.dug = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(27845);
                      paramAnonymous3DialogInterface.dismiss();
                      ae.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavRecordDetailUI.a(FavRecordDetailUI.this)) });
                      FavRecordDetailUI.this.finish();
                      AppMethodBeat.o(27845);
                    }
                  };
                  com.tencent.mm.sdk.b.a.IvT.l(localgx);
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
        paramAnonymousMenuItem.cPF();
        AppMethodBeat.o(27848);
        return true;
      }
    });
    AppMethodBeat.o(27861);
  }
  
  protected final void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27862);
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject = new gx();
      ((gx)localObject).dub.type = 32;
      ((gx)localObject).dub.doH = this.xHB;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (((gx)localObject).duc.dus)
      {
        com.tencent.mm.ui.base.h.cm(getContext(), getString(2131755010));
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
        gx localgx = new gx();
        localgx.dub.type = 13;
        localgx.dub.context = getContext();
        localgx.dub.toUser = ((String)localObject);
        localgx.dub.duh = paramIntent;
        localgx.dub.doH = this.xHB;
        localgx.dub.dug = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27849);
            localp.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.n(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(2131759420));
            AppMethodBeat.o(27849);
          }
        };
        com.tencent.mm.sdk.b.a.IvT.l(localgx);
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
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this.rCm);
    if (this.xHU != null) {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(((d)this.xHU).xHx);
    }
    this.xHD = true;
    if (this.xHE != null) {
      this.xHE.dHQ();
    }
    super.onDestroy();
    AppMethodBeat.o(27857);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(186599);
    super.onPause();
    if (this.xHE != null) {
      this.xHE.xIB = false;
    }
    AppMethodBeat.o(186599);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27855);
    super.onResume();
    Object localObject2 = (b)((d)this.xHU).xHQ;
    com.tencent.mm.plugin.fav.a.g localg;
    Object localObject1;
    if (((b)localObject2).pyC != null)
    {
      localg = com.tencent.mm.plugin.record.b.h.zd(((b)localObject2).pyC.field_localId);
      if ((localg == null) || (localg.field_favProto == null))
      {
        AppMethodBeat.o(27855);
        return;
      }
      localObject1 = localg.field_favProto.oeJ;
      localObject2 = ((b)localObject2).xHu.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((LinkedList)localObject1).contains((ajx)((Iterator)localObject2).next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new b();
        ((b)localObject1).pyC = localg;
        ((b)localObject1).xHu = localg.field_favProto.oeJ;
        this.xHU.a((a)localObject1);
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
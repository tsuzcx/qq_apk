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
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI
  extends RecordMsgBaseUI
{
  private boolean BHA;
  private boolean BHB;
  private i BHC;
  private long BHz;
  private boolean dUo;
  private MStorage.IOnStorageChange tbR;
  private com.tencent.mm.plugin.fav.a.g tfP;
  
  public FavRecordDetailUI()
  {
    AppMethodBeat.i(27851);
    this.BHz = -1L;
    this.dUo = true;
    this.BHA = true;
    this.BHB = false;
    this.tbR = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, final MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(27843);
        if (paramAnonymousMStorageEventData == null)
        {
          AppMethodBeat.o(27843);
          return;
        }
        if (paramAnonymousMStorageEventData.obj == null)
        {
          AppMethodBeat.o(27843);
          return;
        }
        long l = ((Long)paramAnonymousMStorageEventData.obj).longValue();
        if (l < 0L)
        {
          AppMethodBeat.o(27843);
          return;
        }
        if (FavRecordDetailUI.a(FavRecordDetailUI.this) == l)
        {
          paramAnonymousString = com.tencent.mm.plugin.record.b.h.HT(FavRecordDetailUI.a(FavRecordDetailUI.this));
          paramAnonymousMStorageEventData = new b();
          paramAnonymousMStorageEventData.qNT = paramAnonymousString;
          if ((paramAnonymousString != null) && (paramAnonymousString.field_favProto != null))
          {
            paramAnonymousMStorageEventData.BHs = paramAnonymousString.field_favProto.ppH;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(27842);
                FavRecordDetailUI.this.BHV.a(paramAnonymousMStorageEventData);
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
  
  protected final void eIs()
  {
    AppMethodBeat.i(27853);
    this.BHz = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.dUo = getIntent().getBooleanExtra("show_share", true);
    this.tfP = com.tencent.mm.plugin.record.b.h.HT(this.BHz);
    if (this.tfP == null)
    {
      finish();
      AppMethodBeat.o(27853);
      return;
    }
    H(this.tfP);
    Object localObject1 = new b();
    ((b)localObject1).qNT = this.tfP;
    ((b)localObject1).BHs = this.tfP.field_favProto.ppH;
    ((b)localObject1).BHt = new com.tencent.mm.plugin.record.b.x();
    Object localObject2 = ((b)localObject1).BHs;
    if (localObject2 == null) {
      this.BHA = false;
    }
    for (;;)
    {
      super.eIs();
      this.BHV.a((a)localObject1);
      this.BHC = new i(this, this.BHV, (a)localObject1);
      localObject1 = ((b)localObject1).BHs;
      if (localObject1 != null) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27850);
            if (this.BHJ == null)
            {
              AppMethodBeat.o(27850);
              return;
            }
            Log.i("MicroMsg.FavRecordDetailUI", "start calc");
            Object localObject = this.BHJ.iterator();
            long l1 = 0L;
            int m = 0;
            int k = 0;
            int j = 0;
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              aml localaml = (aml)((Iterator)localObject).next();
              if ((localaml != null) && (!FavRecordDetailUI.e(FavRecordDetailUI.this))) {
                switch (localaml.dataType)
                {
                default: 
                  m += 1;
                  break;
                case 2: 
                  j += 1;
                  break;
                case 1: 
                  i += 1;
                  if (localaml.desc != null) {}
                  for (long l2 = localaml.desc.getBytes().length;; l2 = 0L)
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
            Log.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", new Object[] { localObject });
            AppMethodBeat.o(27850);
          }
        }, "calc_fav_record_info");
      }
      this.BHV.BHC = this.BHC;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this.tbR);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(((d)this.BHV).BHv);
      AppMethodBeat.o(27853);
      return;
      if (((List)localObject2).size() == 0)
      {
        this.BHA = false;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext()) {
            if (((aml)((Iterator)localObject2).next()).Lwv != 0)
            {
              this.BHA = false;
              break;
            }
          }
        }
        this.BHA = true;
      }
    }
  }
  
  protected final h eIt()
  {
    AppMethodBeat.i(27854);
    d locald = new d(this, new c(this));
    AppMethodBeat.o(27854);
    return locald;
  }
  
  protected final String eIu()
  {
    AppMethodBeat.i(27858);
    Object localObject;
    if ((14 == this.tfP.field_type) && (!Util.isNullOrNil(this.tfP.field_favProto.title))) {
      localObject = this.tfP.field_favProto.title;
    }
    for (;;)
    {
      AppMethodBeat.o(27858);
      return localObject;
      anh localanh = this.tfP.field_favProto.Lya;
      if ((localanh != null) && (!Util.isNullOrNil(localanh.LxA)))
      {
        String str1 = aa.getDisplayName(localanh.LxA);
        String str2;
        if (z.aTY().equals(localanh.dRL))
        {
          str2 = p.Is(localanh.toUser);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localanh.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[] { localanh.dRL, localanh.toUser });
          break;
          str2 = p.Is(localanh.dRL);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localanh.dRL)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      Log.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[] { this.tfP.field_fromUser });
      localObject = p.Is(this.tfP.field_fromUser);
    }
  }
  
  protected final String eIv()
  {
    AppMethodBeat.i(27859);
    Object localObject = this.tfP.field_favProto.ppH;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((aml)((LinkedList)localObject).getFirst()).Lwl;
      AppMethodBeat.o(27859);
      return localObject;
    }
    AppMethodBeat.o(27859);
    return null;
  }
  
  protected final String eIw()
  {
    AppMethodBeat.i(27860);
    Object localObject = this.tfP.field_favProto.ppH;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((aml)((LinkedList)localObject).getLast()).Lwl;
      AppMethodBeat.o(27860);
      return localObject;
    }
    AppMethodBeat.o(27860);
    return null;
  }
  
  protected final void eIx()
  {
    AppMethodBeat.i(27861);
    if (!this.dUo)
    {
      AppMethodBeat.o(27861);
      return;
    }
    addIconOptionMenu(0, 2131766795, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27848);
        paramAnonymousMenuItem = new e(FavRecordDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(27844);
            Log.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[] { Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_id), Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_itemStatus) });
            if ((FavRecordDetailUI.b(FavRecordDetailUI.this).field_id > 0) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).cUx()) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).cUy()) && (FavRecordDetailUI.c(FavRecordDetailUI.this))) {
              paramAnonymous2m.d(0, FavRecordDetailUI.this.getString(2131759326));
            }
            paramAnonymous2m.d(5, FavRecordDetailUI.this.getString(2131759313));
            paramAnonymous2m.d(3, FavRecordDetailUI.this.getString(2131759199));
            paramAnonymous2m.d(2, FavRecordDetailUI.this.getString(2131755778));
            AppMethodBeat.o(27844);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
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
              if (FavRecordDetailUI.HW(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId))
              {
                paramAnonymous2Int = 2131759187;
                if (FavRecordDetailUI.b(FavRecordDetailUI.this).field_type == 18) {
                  paramAnonymous2Int = 2131759186;
                }
                com.tencent.mm.ui.base.h.cD(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(paramAnonymous2Int, new Object[] { Util.getSizeKB(com.tencent.mm.n.c.aqu()) }));
                AppMethodBeat.o(27847);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId);
              com.tencent.mm.br.c.c(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4097);
              com.tencent.mm.plugin.fav.a.h.w(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId, 1);
              AppMethodBeat.o(27847);
              return;
              com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(2131755780), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(27846);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(2131755780), false, null);
                  hb localhb = new hb();
                  localhb.dLm.type = 12;
                  localhb.dLm.dFW = FavRecordDetailUI.a(FavRecordDetailUI.this);
                  localhb.dLm.dLr = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(27845);
                      paramAnonymous3DialogInterface.dismiss();
                      Log.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavRecordDetailUI.a(FavRecordDetailUI.this)) });
                      FavRecordDetailUI.this.finish();
                      AppMethodBeat.o(27845);
                    }
                  };
                  EventCenter.instance.publish(localhb);
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
        paramAnonymousMenuItem.dGm();
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
      Object localObject = new hb();
      ((hb)localObject).dLm.type = 32;
      ((hb)localObject).dLm.dFW = this.BHz;
      EventCenter.instance.publish((IEvent)localObject);
      if (((hb)localObject).dLn.dLD)
      {
        com.tencent.mm.ui.base.h.cD(getContext(), getString(2131755011));
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
        final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
        hb localhb = new hb();
        localhb.dLm.type = 13;
        localhb.dLm.context = getContext();
        localhb.dLm.toUser = ((String)localObject);
        localhb.dLm.dLs = paramIntent;
        localhb.dLm.dFW = this.BHz;
        localhb.dLm.dLr = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27849);
            localq.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.r(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(2131760708));
            AppMethodBeat.o(27849);
          }
        };
        EventCenter.instance.publish(localhb);
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
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this.tbR);
    if (this.BHV != null) {
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(((d)this.BHV).BHv);
    }
    this.BHB = true;
    if (this.BHC != null) {
      this.BHC.eID();
    }
    super.onDestroy();
    AppMethodBeat.o(27857);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(232023);
    super.onPause();
    if (this.BHC != null) {
      this.BHC.BID = false;
    }
    AppMethodBeat.o(232023);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27855);
    super.onResume();
    Object localObject2 = (b)((d)this.BHV).BHQ;
    com.tencent.mm.plugin.fav.a.g localg;
    Object localObject1;
    if (((b)localObject2).qNT != null)
    {
      localg = com.tencent.mm.plugin.record.b.h.HT(((b)localObject2).qNT.field_localId);
      if ((localg == null) || (localg.field_favProto == null))
      {
        AppMethodBeat.o(27855);
        return;
      }
      localObject1 = localg.field_favProto.ppH;
      localObject2 = ((b)localObject2).BHs.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((LinkedList)localObject1).contains((aml)((Iterator)localObject2).next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new b();
        ((b)localObject1).qNT = localg;
        ((b)localObject1).BHs = localg.field_favProto.ppH;
        this.BHV.a((a)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI
 * JD-Core Version:    0.7.0.1
 */
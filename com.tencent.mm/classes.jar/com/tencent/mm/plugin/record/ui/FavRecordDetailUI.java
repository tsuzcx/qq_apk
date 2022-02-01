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
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI
  extends RecordMsgBaseUI
{
  private long HDE;
  private boolean HDF;
  private i HDG;
  private boolean fNQ;
  private MStorage.IOnStorageChange wHW;
  private g wMe;
  private boolean zqo;
  
  public FavRecordDetailUI()
  {
    AppMethodBeat.i(27851);
    this.HDE = -1L;
    this.fNQ = true;
    this.HDF = true;
    this.zqo = false;
    this.wHW = new MStorage.IOnStorageChange()
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
          paramAnonymousString = com.tencent.mm.plugin.record.b.h.Po(FavRecordDetailUI.a(FavRecordDetailUI.this));
          paramAnonymousMStorageEventData = new b();
          paramAnonymousMStorageEventData.upg = paramAnonymousString;
          if ((paramAnonymousString != null) && (paramAnonymousString.field_favProto != null))
          {
            paramAnonymousMStorageEventData.HDy = paramAnonymousString.field_favProto.syG;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(27842);
                FavRecordDetailUI.this.HEc.a(paramAnonymousMStorageEventData);
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
  
  protected final void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27862);
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject = new hi();
      ((hi)localObject).fEb.type = 32;
      ((hi)localObject).fEb.fyE = this.HDE;
      EventCenter.instance.publish((IEvent)localObject);
      if (((hi)localObject).fEc.fEs)
      {
        com.tencent.mm.ui.base.h.cO(getContext(), getString(R.l.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(27862);
        return;
      }
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label229;
        }
      }
      label229:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        final s locals = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        hi localhi = new hi();
        localhi.fEb.type = 13;
        localhi.fEb.context = getContext();
        localhi.fEb.toUser = ((String)localObject);
        localhi.fEb.fEh = paramIntent;
        localhi.fEb.fyE = this.HDE;
        localhi.fEb.fEg = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27849);
            locals.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.r(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(R.l.finish_sent));
            AppMethodBeat.o(27849);
          }
        };
        EventCenter.instance.publish(localhi);
        AppMethodBeat.o(27862);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
    }
    AppMethodBeat.o(27862);
  }
  
  protected final String fuA()
  {
    AppMethodBeat.i(27859);
    Object localObject = this.wMe.field_favProto.syG;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((anm)((LinkedList)localObject).getFirst()).SyK;
      AppMethodBeat.o(27859);
      return localObject;
    }
    AppMethodBeat.o(27859);
    return null;
  }
  
  protected final String fuB()
  {
    AppMethodBeat.i(27860);
    Object localObject = this.wMe.field_favProto.syG;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((anm)((LinkedList)localObject).getLast()).SyK;
      AppMethodBeat.o(27860);
      return localObject;
    }
    AppMethodBeat.o(27860);
    return null;
  }
  
  protected final void fuC()
  {
    AppMethodBeat.i(27861);
    if (!this.fNQ)
    {
      AppMethodBeat.o(27861);
      return;
    }
    addIconOptionMenu(0, R.l.top_item_desc_more, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27848);
        paramAnonymousMenuItem = new e(FavRecordDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(27844);
            Log.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[] { Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_id), Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_itemStatus) });
            if ((FavRecordDetailUI.b(FavRecordDetailUI.this).field_id > 0) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).djD()) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).djE()) && (FavRecordDetailUI.c(FavRecordDetailUI.this))) {
              paramAnonymous2o.d(0, FavRecordDetailUI.this.getString(R.l.favorite_share_with_friend));
            }
            paramAnonymous2o.d(5, FavRecordDetailUI.this.getString(R.l.favorite_save_as_note));
            paramAnonymous2o.d(3, FavRecordDetailUI.this.getString(R.l.favorite_edit_tag_tips));
            paramAnonymous2o.d(2, FavRecordDetailUI.this.getString(R.l.app_delete));
            AppMethodBeat.o(27844);
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
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
              paramAnonymous2Int = R.l.favorite_detail_illegal_send_record_too_big;
              long l = com.tencent.mm.n.c.awN();
              if (FavRecordDetailUI.b(FavRecordDetailUI.this).field_type == 18)
              {
                paramAnonymous2Int = R.l.favorite_detail_illegal_send_note_too_big;
                l = com.tencent.mm.n.c.awO();
              }
              if (FavRecordDetailUI.aq(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId, l))
              {
                com.tencent.mm.ui.base.h.cO(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(paramAnonymous2Int, new Object[] { Util.getSizeKB(l) }));
                AppMethodBeat.o(27847);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId);
              com.tencent.mm.by.c.d(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4097);
              com.tencent.mm.plugin.fav.a.h.y(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId, 1);
              AppMethodBeat.o(27847);
              return;
              com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(R.l.app_delete_tips), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(27846);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(R.l.app_delete_tips), false, null);
                  hi localhi = new hi();
                  localhi.fEb.type = 12;
                  localhi.fEb.fyE = FavRecordDetailUI.a(FavRecordDetailUI.this);
                  localhi.fEb.fEg = new Runnable()
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
                  EventCenter.instance.publish(localhi);
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
        paramAnonymousMenuItem.eik();
        AppMethodBeat.o(27848);
        return true;
      }
    });
    AppMethodBeat.o(27861);
  }
  
  protected final void fux()
  {
    AppMethodBeat.i(27853);
    this.HDE = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.fNQ = getIntent().getBooleanExtra("show_share", true);
    this.wMe = com.tencent.mm.plugin.record.b.h.Po(this.HDE);
    if (this.wMe == null)
    {
      finish();
      AppMethodBeat.o(27853);
      return;
    }
    H(this.wMe);
    Object localObject1 = new b();
    ((b)localObject1).upg = this.wMe;
    ((b)localObject1).HDy = this.wMe.field_favProto.syG;
    ((b)localObject1).HDz = new x();
    Object localObject2 = ((b)localObject1).HDy;
    if (localObject2 == null) {
      this.HDF = false;
    }
    for (;;)
    {
      super.fux();
      this.HEc.a((a)localObject1);
      this.HDG = new i(this, this.HEc, (a)localObject1);
      localObject1 = ((b)localObject1).HDy;
      if (localObject1 != null) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27850);
            if (this.HDN == null)
            {
              AppMethodBeat.o(27850);
              return;
            }
            Log.i("MicroMsg.FavRecordDetailUI", "start calc");
            Object localObject = this.HDN.iterator();
            long l1 = 0L;
            int m = 0;
            int k = 0;
            int j = 0;
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              anm localanm = (anm)((Iterator)localObject).next();
              if ((localanm != null) && (!FavRecordDetailUI.e(FavRecordDetailUI.this))) {
                switch (localanm.dataType)
                {
                default: 
                  m += 1;
                  break;
                case 2: 
                  j += 1;
                  break;
                case 1: 
                  i += 1;
                  if (localanm.desc != null) {}
                  for (long l2 = localanm.desc.getBytes().length;; l2 = 0L)
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
      this.HEc.HDG = this.HDG;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().add(this.wHW);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(((d)this.HEc).wQR);
      AppMethodBeat.o(27853);
      return;
      if (((List)localObject2).size() == 0)
      {
        this.HDF = false;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext()) {
            if (((anm)((Iterator)localObject2).next()).SyU != 0)
            {
              this.HDF = false;
              break;
            }
          }
        }
        this.HDF = true;
      }
    }
  }
  
  protected final h fuy()
  {
    AppMethodBeat.i(27854);
    d locald = new d(this, new c(this));
    AppMethodBeat.o(27854);
    return locald;
  }
  
  protected final String fuz()
  {
    AppMethodBeat.i(27858);
    Object localObject;
    if ((14 == this.wMe.field_type) && (!Util.isNullOrNil(this.wMe.field_favProto.title))) {
      localObject = this.wMe.field_favProto.title;
    }
    for (;;)
    {
      AppMethodBeat.o(27858);
      return localObject;
      aoi localaoi = this.wMe.field_favProto.SAB;
      if ((localaoi != null) && (!Util.isNullOrNil(localaoi.SAb)))
      {
        String str1 = aa.PJ(localaoi.SAb);
        String str2;
        if (z.bcZ().equals(localaoi.fLi))
        {
          str2 = p.PK(localaoi.toUser);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localaoi.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[] { localaoi.fLi, localaoi.toUser });
          break;
          str2 = p.PK(localaoi.fLi);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localaoi.fLi)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      Log.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[] { this.wMe.field_fromUser });
      localObject = p.PK(this.wMe.field_fromUser);
    }
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
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().remove(this.wHW);
    if (this.HEc != null) {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(((d)this.HEc).wQR);
    }
    this.zqo = true;
    if (this.HDG != null) {
      this.HDG.fuI();
    }
    super.onDestroy();
    AppMethodBeat.o(27857);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(282499);
    super.onPause();
    if (this.HDG != null) {
      this.HDG.HEL = false;
    }
    AppMethodBeat.o(282499);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27855);
    super.onResume();
    Object localObject2 = (b)((d)this.HEc).HDX;
    g localg;
    Object localObject1;
    if (((b)localObject2).upg != null)
    {
      localg = com.tencent.mm.plugin.record.b.h.Po(((b)localObject2).upg.field_localId);
      if ((localg == null) || (localg.field_favProto == null))
      {
        AppMethodBeat.o(27855);
        return;
      }
      localObject1 = localg.field_favProto.syG;
      localObject2 = ((b)localObject2).HDy.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((LinkedList)localObject1).contains((anm)((Iterator)localObject2).next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new b();
        ((b)localObject1).upg = localg;
        ((b)localObject1).HDy = localg.field_favProto.syG;
        this.HEc.a((a)localObject1);
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
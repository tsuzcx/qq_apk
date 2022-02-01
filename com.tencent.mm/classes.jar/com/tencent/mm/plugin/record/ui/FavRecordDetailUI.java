package com.tencent.mm.plugin.record.ui;

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
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.plugin.record.model.x;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI
  extends RecordMsgBaseUI
{
  private MStorage.IOnStorageChange Aek;
  private g AiB;
  private boolean EsR;
  private long NBg;
  private boolean NBh;
  private i NBi;
  private boolean hTH;
  
  public FavRecordDetailUI()
  {
    AppMethodBeat.i(27851);
    this.NBg = -1L;
    this.hTH = true;
    this.NBh = true;
    this.EsR = false;
    this.Aek = new MStorage.IOnStorageChange()
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
          paramAnonymousString = com.tencent.mm.plugin.record.model.i.to(FavRecordDetailUI.a(FavRecordDetailUI.this));
          paramAnonymousMStorageEventData = new b();
          paramAnonymousMStorageEventData.xvD = paramAnonymousString;
          if ((paramAnonymousString != null) && (paramAnonymousString.field_favProto != null))
          {
            paramAnonymousMStorageEventData.NBa = paramAnonymousString.field_favProto.vEn;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(27842);
                FavRecordDetailUI.this.NBE.a(paramAnonymousMStorageEventData);
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
  
  protected final void gGm()
  {
    AppMethodBeat.i(27853);
    this.NBg = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.hTH = getIntent().getBooleanExtra("show_share", true);
    this.AiB = com.tencent.mm.plugin.record.model.i.to(this.NBg);
    if (this.AiB == null)
    {
      finish();
      AppMethodBeat.o(27853);
      return;
    }
    H(this.AiB);
    Object localObject1 = new b();
    ((b)localObject1).xvD = this.AiB;
    ((b)localObject1).NBa = this.AiB.field_favProto.vEn;
    ((b)localObject1).NBb = new x();
    Object localObject2 = ((b)localObject1).NBa;
    if (localObject2 == null) {
      this.NBh = false;
    }
    for (;;)
    {
      super.gGm();
      this.NBE.a((a)localObject1);
      this.NBi = new i(this, this.NBE, (a)localObject1);
      localObject1 = ((b)localObject1).NBa;
      if (localObject1 != null) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27850);
            if (this.NBp == null)
            {
              AppMethodBeat.o(27850);
              return;
            }
            Log.i("MicroMsg.FavRecordDetailUI", "start calc");
            Object localObject = this.NBp.iterator();
            long l1 = 0L;
            int m = 0;
            int k = 0;
            int j = 0;
            int i = 0;
            while (((Iterator)localObject).hasNext())
            {
              arf localarf = (arf)((Iterator)localObject).next();
              if ((localarf != null) && (!FavRecordDetailUI.e(FavRecordDetailUI.this))) {
                switch (localarf.dataType)
                {
                default: 
                  m += 1;
                  break;
                case 2: 
                  j += 1;
                  break;
                case 1: 
                  i += 1;
                  if (localarf.desc != null) {}
                  for (long l2 = localarf.desc.getBytes().length;; l2 = 0L)
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
      this.NBE.NBi = this.NBi;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().add(this.Aek);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(((d)this.NBE).Anv);
      AppMethodBeat.o(27853);
      return;
      if (((List)localObject2).size() == 0)
      {
        this.NBh = false;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext()) {
            if (((arf)((Iterator)localObject2).next()).ZzM != 0)
            {
              this.NBh = false;
              break;
            }
          }
        }
        this.NBh = true;
      }
    }
  }
  
  protected final h gGn()
  {
    AppMethodBeat.i(27854);
    d locald = new d(this, new c(this));
    AppMethodBeat.o(27854);
    return locald;
  }
  
  protected final String gGo()
  {
    AppMethodBeat.i(27858);
    Object localObject;
    if ((14 == this.AiB.field_type) && (!Util.isNullOrNil(this.AiB.field_favProto.title))) {
      localObject = this.AiB.field_favProto.title;
    }
    for (;;)
    {
      AppMethodBeat.o(27858);
      return localObject;
      asb localasb = this.AiB.field_favProto.ZBt;
      if ((localasb != null) && (!Util.isNullOrNil(localasb.ZAT)))
      {
        String str1 = aa.getDisplayName(localasb.ZAT);
        String str2;
        if (z.bAM().equals(localasb.hQQ))
        {
          str2 = q.IE(localasb.toUser);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localasb.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[] { localasb.hQQ, localasb.toUser });
          break;
          str2 = q.IE(localasb.hQQ);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localasb.hQQ)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      Log.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[] { this.AiB.field_fromUser });
      localObject = q.IE(this.AiB.field_fromUser);
    }
  }
  
  protected final String gGp()
  {
    AppMethodBeat.i(27859);
    Object localObject = this.AiB.field_favProto.vEn;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((arf)((LinkedList)localObject).getFirst()).ZzC;
      AppMethodBeat.o(27859);
      return localObject;
    }
    AppMethodBeat.o(27859);
    return null;
  }
  
  protected final String gGq()
  {
    AppMethodBeat.i(27860);
    Object localObject = this.AiB.field_favProto.vEn;
    if (((LinkedList)localObject).size() > 0)
    {
      localObject = ((arf)((LinkedList)localObject).getLast()).ZzC;
      AppMethodBeat.o(27860);
      return localObject;
    }
    AppMethodBeat.o(27860);
    return null;
  }
  
  protected final void gGr()
  {
    AppMethodBeat.i(27861);
    if (!this.hTH)
    {
      AppMethodBeat.o(27861);
      return;
    }
    addIconOptionMenu(0, R.l.top_item_desc_more, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27848);
        paramAnonymousMenuItem = new f(FavRecordDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(27844);
            Log.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[] { Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_id), Integer.valueOf(FavRecordDetailUI.b(FavRecordDetailUI.this).field_itemStatus) });
            if ((FavRecordDetailUI.b(FavRecordDetailUI.this).field_id > 0) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).dQo()) && (!FavRecordDetailUI.b(FavRecordDetailUI.this).dQp()) && (FavRecordDetailUI.c(FavRecordDetailUI.this))) {
              paramAnonymous2s.c(0, FavRecordDetailUI.this.getString(R.l.favorite_share_with_friend));
            }
            paramAnonymous2s.c(5, FavRecordDetailUI.this.getString(R.l.favorite_save_as_note));
            paramAnonymous2s.c(3, FavRecordDetailUI.this.getString(R.l.favorite_edit_tag_tips));
            paramAnonymous2s.c(2, FavRecordDetailUI.this.getString(R.l.app_delete));
            AppMethodBeat.o(27844);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
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
              long l = com.tencent.mm.k.c.aRn();
              if (FavRecordDetailUI.b(FavRecordDetailUI.this).field_type == 18)
              {
                paramAnonymous2Int = R.l.favorite_detail_illegal_send_note_too_big;
                l = com.tencent.mm.k.c.aRo();
              }
              if (FavRecordDetailUI.ba(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId, l))
              {
                k.cZ(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(paramAnonymous2Int, new Object[] { Util.getSizeKB(l) }));
                AppMethodBeat.o(27847);
                return;
              }
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId);
              com.tencent.mm.br.c.d(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 4097);
              com.tencent.mm.plugin.fav.a.h.I(FavRecordDetailUI.b(FavRecordDetailUI.this).field_localId, 1);
              AppMethodBeat.o(27847);
              return;
              k.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(R.l.app_delete_tips), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(27846);
                  paramAnonymous3DialogInterface = k.a(FavRecordDetailUI.this.getContext(), FavRecordDetailUI.this.getString(R.l.app_delete_tips), false, null);
                  ht localht = new ht();
                  localht.hIR.type = 12;
                  localht.hIR.hDn = FavRecordDetailUI.a(FavRecordDetailUI.this);
                  localht.hIR.hIW = new Runnable()
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
                  localht.publish();
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
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(27848);
        return true;
      }
    });
    AppMethodBeat.o(27861);
  }
  
  protected final void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27862);
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject = new ht();
      ((ht)localObject).hIR.type = 32;
      ((ht)localObject).hIR.hDn = this.NBg;
      ((ht)localObject).publish();
      if (((ht)localObject).hIS.hJi)
      {
        k.cZ(getContext(), getString(R.l.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(27862);
        return;
      }
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label224;
        }
      }
      label224:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        final w localw = k.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        ht localht = new ht();
        localht.hIR.type = 13;
        localht.hIR.context = getContext();
        localht.hIR.toUser = ((String)localObject);
        localht.hIR.hIX = paramIntent;
        localht.hIR.hDn = this.NBg;
        localht.hIR.hIW = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27849);
            localw.dismiss();
            com.tencent.mm.ui.widget.snackbar.b.u(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(R.l.finish_sent));
            AppMethodBeat.o(27849);
          }
        };
        localht.publish();
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
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().remove(this.Aek);
    if (this.NBE != null) {
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(((d)this.NBE).Anv);
    }
    this.EsR = true;
    if (this.NBi != null) {
      this.NBi.gGy();
    }
    super.onDestroy();
    AppMethodBeat.o(27857);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(305304);
    super.onPause();
    if (this.NBi != null) {
      this.NBi.NCn = false;
    }
    AppMethodBeat.o(305304);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27855);
    super.onResume();
    Object localObject2 = (b)((d)this.NBE).NBz;
    g localg;
    Object localObject1;
    if (((b)localObject2).xvD != null)
    {
      localg = com.tencent.mm.plugin.record.model.i.to(((b)localObject2).xvD.field_localId);
      if ((localg == null) || (localg.field_favProto == null))
      {
        AppMethodBeat.o(27855);
        return;
      }
      localObject1 = localg.field_favProto.vEn;
      localObject2 = ((b)localObject2).NBa.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((LinkedList)localObject1).contains((arf)((Iterator)localObject2).next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new b();
        ((b)localObject1).xvD = localg;
        ((b)localObject1).NBa = localg.field_favProto.vEn;
        this.NBE.a((a)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.a.c.g;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.tools.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  int aeIH;
  HashSet<Integer> aeJb;
  int lPs;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36588);
    this.aeJb = new HashSet();
    this.lPs = -1;
    this.aeIH = 0;
    AppMethodBeat.o(36588);
  }
  
  private boolean a(cc paramcc, g paramg)
  {
    AppMethodBeat.i(36596);
    if ((!paramcc.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(36596);
      return false;
    }
    Log.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
    paramcc = new Intent("android.intent.action.MAIN", null);
    paramcc.addCategory("android.intent.category.LAUNCHER");
    paramcc.addFlags(268435456);
    paramcc.setClassName("com.tencent.mobileqq", bH(this.mContext, "com.tencent.mobileqq"));
    paramcc.putExtra("platformId", "wechat");
    bh.bCz();
    paramg = com.tencent.mm.model.c.ban().d(9, null);
    int i;
    if ((paramg != null) && ((paramg instanceof Integer))) {
      i = ((Integer)paramg).intValue();
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramg = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int k = arrayOfByte.length;
        int j = 0;
        i = 0;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if (i >= paramg.length) {
            break;
          }
          paramg[i] = ((byte)(m ^ paramg[i]));
          j += 1;
          i += 1;
        }
        paramcc.putExtra("tencent_gif", paramg);
        label304:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.mContext;
            paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(paramcc);
            com.tencent.mm.hellhoundlib.a.a.b(paramg, paramcc.aYi(), "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)paramcc.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramg, "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(36596);
            return true;
            paramg = paramg;
            Log.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramg, "", new Object[0]);
          }
        }
        catch (Exception paramcc)
        {
          break label304;
        }
      }
    }
  }
  
  private static String bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(36597);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label101;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(36597);
    return paramContext;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(36598);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(36598);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(36598);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(36598);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(36595);
    c localc = (c)parama;
    a locala = (a)aCa(paramInt);
    boolean bool;
    if ((Util.isNullOrNil(locala.desc)) || (!Util.isNullOrNil(locala.source)))
    {
      localc.plr.setVisibility(8);
      Object localObject = r.bKa().a(locala.imagePath, com.tencent.mm.cd.a.getDensity(this.mContext), false);
      if (localObject != null)
      {
        parama = (com.tencent.mm.ui.chatting.a.c.a)localObject;
        if (!((Bitmap)localObject).isRecycled()) {
          break label367;
        }
      }
      parama = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
      if ((locala.aeJf == null) || (!locala.aeJf.aeJg)) {
        break label361;
      }
      bool = true;
      label132:
      localObject = com.tencent.mm.api.b.e(locala.imagePath, 4, bool);
      Log.v("MicroMsg.UrlHistoryListPresenter", "alvinluo fillDetail coverUrl: %s, isBizNativeVideo: %b", new Object[] { localObject, Boolean.valueOf(bool) });
      if ((parama != null) && (!parama.isRecycled())) {
        break label367;
      }
      paramInt = i;
      if (bool) {
        paramInt = 4;
      }
      parama = new com.tencent.mm.modelimage.loader.a.c.a();
      parama.oKB = R.e.chatting_item_biz_default_bg;
      parama.oKo = true;
      parama.fullPath = y.bpF((String)localObject);
      com.tencent.mm.modelimage.loader.a.c.a locala1 = parama.eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      locala1.oKe = new com.tencent.mm.pluginsdk.ui.applet.n(paramInt);
      locala1.oKN = new com.tencent.mm.pluginsdk.ui.applet.e(paramInt);
      locala1.oKn = true;
      r.bKe().a((String)localObject, localc.ttT, parama.bKx());
    }
    for (;;)
    {
      localc.Aoo.setText(Util.nullAs(locala.source, ""));
      c.i(localc.Aoo, this.aeIA.aenu);
      AppMethodBeat.o(36595);
      return;
      localc.plr.setVisibility(0);
      localc.plr.setText(Util.nullAs(locala.desc, ""));
      break;
      label361:
      bool = false;
      break label132;
      label367:
      localc.ttT.setImageBitmap(parama);
    }
  }
  
  public final RecyclerView.v af(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254362);
    paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.goK, paramViewGroup, false));
    AppMethodBeat.o(254362);
    return paramViewGroup;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(36591);
    String str = this.mContext.getString(R.l.gri);
    AppMethodBeat.o(36591);
    return str;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(36589);
    this.aeJb.add(Integer.valueOf(5));
    this.aeJb.add(Integer.valueOf(7));
    this.aeJb.add(Integer.valueOf(27));
    this.aeJb.add(Integer.valueOf(26));
    this.aeJb.add(Integer.valueOf(15));
    this.aeJb.add(Integer.valueOf(4));
    this.aeJb.add(Integer.valueOf(68));
    this.aeJb.add(Integer.valueOf(51));
    AppMethodBeat.o(36589);
    return -1;
  }
  
  public final void juR()
  {
    AppMethodBeat.i(36590);
    this.aeIz.juV();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36581);
        LinkedList localLinkedList = new LinkedList();
        bh.bCz();
        Cursor localCursor = com.tencent.mm.model.c.bzD().fT(h.this.lMU, h.this.lPs);
        if (localCursor == null)
        {
          Log.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36581);
          return;
        }
        aj localaj;
        long l1;
        if (au.bwE(h.this.lMU))
        {
          bh.bCz();
          localaj = com.tencent.mm.model.c.bzK().Ju(h.this.lMU);
          l1 = 0L;
        }
        label1028:
        for (;;)
        {
          long l2;
          try
          {
            if (!localCursor.moveToNext()) {
              break label884;
            }
            cc localcc = new cc();
            localcc.convertFrom(localCursor);
            Object localObject1 = localcc.field_content;
            if (localObject1 == null) {
              continue;
            }
            k.b localb = k.b.Hf((String)localObject1);
            if (localb == null) {
              continue;
            }
            localObject1 = h.this;
            int i = localb.type;
            ((h)localObject1).getType();
            if (!((h)localObject1).aeJb.contains(Integer.valueOf(i))) {
              continue;
            }
            localObject1 = new Date(localcc.getCreateTime());
            l2 = com.tencent.mm.ui.gridviewheaders.a.jBw().b((Date)localObject1);
            if (l1 != l2)
            {
              localLinkedList.add(new c.c(localcc.getCreateTime()));
              localObject1 = h.this;
              ((h)localObject1).aeIH += 1;
            }
            localObject1 = h.b(localcc, au.bwE(h.this.lMU));
            Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject1);
            Object localObject3 = "";
            if (localaj != null) {
              localObject3 = localaj.getDisplayName((String)localObject1);
            }
            i = com.tencent.mm.plugin.fav.ui.e.aut(localb.nRe);
            localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(h.this.mContext, localb.iaa);
            bh.bCz();
            Object localObject5 = com.tencent.mm.model.c.bzA().JE(localb.iaa);
            if ((localObject5 == null) || (!((az)localObject5).field_username.equals(localb.iaa)))
            {
              az.a.okP.a(localb.iaa, "", null);
              localObject3 = new h.a(h.this, localcc.getCreateTime(), localb.type, localb.title, localcc.field_msgId, ((az)localObject4).field_username, ((au)localObject4).aSU(), ((az)localObject4).field_conRemark, (String)localObject3);
              if (localb.type == 5)
              {
                Log.i("MicroMsg.UrlHistoryListPresenter", "alvinluo loadData type: %d", new Object[] { Integer.valueOf(localb.type) });
                localObject4 = new h.b(h.this);
                localObject5 = (com.tencent.mm.message.e)localb.aK(com.tencent.mm.message.e.class);
                if ((localObject5 == null) || (((com.tencent.mm.message.e)localObject5).nQo != 1) || (((com.tencent.mm.message.e)localObject5).nQm != 5)) {
                  break label1022;
                }
                bool = true;
                ((h.b)localObject4).aeJg = bool;
                ((h.a)localObject3).aeJf = ((h.b)localObject4);
              }
              if (!Util.isNullOrNil((String)localObject1)) {
                break label1028;
              }
              localObject1 = localb.description;
              ((h.a)localObject3).source = ((String)localObject1);
              ((h.a)localObject3).appId = localb.appId;
              if (Util.isNullOrNil(localcc.field_imgPath))
              {
                ((h.a)localObject3).imagePath = localb.thumburl;
                ((h.a)localObject3).iconRes = i;
                if (localb.type == 51)
                {
                  localObject1 = (f)localb.aK(f.class);
                  ((h.a)localObject3).title = h.this.mContext.getString(R.l.fts_info_finder_desc, new Object[] { ((f)localObject1).getNickname() });
                  if (((f)localObject1).oUc.mediaList.size() <= 0) {
                    break label874;
                  }
                  ((h.a)localObject3).imagePath = ((bvj)((f)localObject1).oUc.mediaList.getFirst()).thumbUrl;
                }
                localLinkedList.add(localObject3);
                if (localLinkedList.size() % 20 != 0) {
                  break label1016;
                }
                if ((h.this.mDataList.size() > 0) && (((c.b)h.this.mDataList.get(h.this.mDataList.size() - 1)).getType() == 2147483646)) {
                  h.this.mDataList.remove(h.this.mDataList.size() - 1);
                }
                h.this.mDataList.addAll(localLinkedList);
                h.this.mDataList.add(new c.g());
                h.this.aeIB = h.this.mDataList;
                localLinkedList.clear();
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36580);
                    if (h.this.aeIz != null) {
                      h.this.aeIz.F(h.1.this.wQx, h.this.mDataList.size());
                    }
                    AppMethodBeat.o(36580);
                  }
                });
                break label1016;
              }
            }
            else
            {
              localObject1 = ((au)localObject5).aSV();
              continue;
            }
            ((h.a)localObject3).imagePath = localcc.field_imgPath;
            continue;
            ((h.a)localObject3).imagePath = "";
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(36581);
          }
          label874:
          continue;
          label884:
          localCursor.close();
          if ((h.this.mDataList.size() > 0) && (((c.b)h.this.mDataList.get(h.this.mDataList.size() - 1)).getType() == 2147483646)) {
            h.this.mDataList.remove(h.this.mDataList.size() - 1);
          }
          h.this.mDataList.addAll(localLinkedList);
          h.this.aeIB = h.this.mDataList;
          localLinkedList.clear();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(254302);
              if (h.this.aeIz != null) {
                h.this.aeIz.F(h.1.this.wQx, h.this.mDataList.size());
              }
              AppMethodBeat.o(254302);
            }
          });
          AppMethodBeat.o(36581);
          return;
          localaj = null;
          break;
          label1016:
          l1 = l2;
          continue;
          label1022:
          boolean bool = false;
        }
      }
    });
    AppMethodBeat.o(36590);
  }
  
  public final c.e juS()
  {
    AppMethodBeat.i(36593);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36584);
        Log.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousb == null)
        {
          Log.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(36584);
          return;
        }
        paramAnonymousb = (h.a)paramAnonymousb;
        if (paramAnonymousb.getType() == 5)
        {
          h.a(h.this, paramAnonymousView, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 7)
        {
          h.a(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 15)
        {
          h.b(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 26)
        {
          h.c(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 27)
        {
          h.d(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        if (paramAnonymousb.getType() == 51)
        {
          if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(h.this.mContext))
          {
            AppMethodBeat.o(36584);
            return;
          }
          h.e(h.this, paramAnonymousb);
          AppMethodBeat.o(36584);
          return;
        }
        Log.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[] { Integer.valueOf(paramAnonymousb.getType()) });
        AppMethodBeat.o(36584);
      }
      
      public final void b(View paramAnonymousView, final int paramAnonymousInt, final c.b paramAnonymousb)
      {
        AppMethodBeat.i(36585);
        Log.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        new l(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new u.i
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36582);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(R.l.retransmits));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(R.l.chatting_fav));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(R.l.gyo));
            AppMethodBeat.o(36582);
          }
        }, new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(36583);
            if (paramAnonymousb == null)
            {
              Log.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
              AppMethodBeat.o(36583);
              return;
            }
            bh.bCz();
            paramAnonymous2MenuItem = com.tencent.mm.model.c.bzD().sl(paramAnonymousb.msgId);
            h.this.f(paramAnonymous2Int, paramAnonymous2MenuItem);
            AppMethodBeat.o(36583);
          }
        });
        AppMethodBeat.o(36585);
      }
    };
    AppMethodBeat.o(36593);
    return local2;
  }
  
  public final String juU()
  {
    AppMethodBeat.i(36592);
    String str = this.mContext.getString(R.l.gri);
    AppMethodBeat.o(36592);
    return str;
  }
  
  final class a
    extends c.b
  {
    public h.b aeJf = null;
    public String appId;
    public String desc;
    public int iconRes;
    public String imagePath;
    public String source;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean bAH(String paramString)
    {
      AppMethodBeat.i(36586);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bAI(paramString))
        {
          if ((!Util.isNullOrNil(this.source)) && (pY(paramString, this.source.toLowerCase())))
          {
            AppMethodBeat.o(36586);
            return true;
          }
        }
        else if ((!Util.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
        {
          AppMethodBeat.o(36586);
          return true;
        }
        boolean bool = super.bAH(paramString);
        AppMethodBeat.o(36586);
        return bool;
      }
      AppMethodBeat.o(36586);
      return false;
    }
  }
  
  final class b
  {
    public boolean aeJg = false;
    
    b() {}
  }
  
  final class c
    extends com.tencent.mm.ui.chatting.a.c.a
  {
    TextView Aoo;
    TextView plr;
    ImageView ttT;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(36587);
      this.ttT = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.plr = ((TextView)paramView.findViewById(R.h.fav_desc));
      this.Aoo = ((TextView)paramView.findViewById(R.h.fav_source));
      this.Aoo.setVisibility(0);
      AppMethodBeat.o(36587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.presenter.h
 * JD-Core Version:    0.7.0.1
 */
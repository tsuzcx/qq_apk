package com.tencent.mm.ui.chatting.l;

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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.a.c.g;
import com.tencent.mm.ui.chatting.f.b.b;
import com.tencent.mm.ui.tools.m;
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
  HashSet<Integer> WZB;
  int WZh;
  int jmu;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(36588);
    this.WZB = new HashSet();
    this.jmu = -1;
    this.WZh = 0;
    AppMethodBeat.o(36588);
  }
  
  private boolean a(ca paramca, g paramg)
  {
    AppMethodBeat.i(36596);
    if ((!paramca.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(36596);
      return false;
    }
    Log.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
    paramca = new Intent("android.intent.action.MAIN", null);
    paramca.addCategory("android.intent.category.LAUNCHER");
    paramca.addFlags(268435456);
    paramca.setClassName("com.tencent.mobileqq", bF(this.mContext, "com.tencent.mobileqq"));
    paramca.putExtra("platformId", "wechat");
    bh.beI();
    paramg = com.tencent.mm.model.c.aHp().b(9, null);
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
        paramca.putExtra("tencent_gif", paramg);
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
            paramca = new com.tencent.mm.hellhoundlib.b.a().bm(paramca);
            com.tencent.mm.hellhoundlib.a.a.b(paramg, paramca.aFh(), "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)paramca.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramg, "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(36596);
            return true;
            paramg = paramg;
            Log.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", paramg, "", new Object[0]);
          }
        }
        catch (Exception paramca)
        {
          break label304;
        }
      }
    }
  }
  
  private static String bF(Context paramContext, String paramString)
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.o(paramString, true, false);
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
  
  public final RecyclerView.v V(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(239918);
    paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.elG, paramViewGroup, false));
    AppMethodBeat.o(239918);
    return paramViewGroup;
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(36595);
    c localc = (c)parama;
    a locala = (a)avy(paramInt);
    boolean bool;
    if ((Util.isNullOrNil(locala.desc)) || (!Util.isNullOrNil(locala.source)))
    {
      localc.mrM.setVisibility(8);
      Object localObject = q.bmh().a(locala.imagePath, com.tencent.mm.ci.a.getDensity(this.mContext), false);
      if (localObject != null)
      {
        parama = (com.tencent.mm.ui.chatting.a.c.a)localObject;
        if (!((Bitmap)localObject).isRecycled()) {
          break label367;
        }
      }
      parama = com.tencent.mm.pluginsdk.model.app.h.c(locala.appId, 1, com.tencent.mm.ci.a.getDensity(this.mContext));
      if ((locala.WZF == null) || (!locala.WZF.WZG)) {
        break label361;
      }
      bool = true;
      label132:
      localObject = com.tencent.mm.api.b.d(locala.imagePath, 4, bool);
      Log.v("MicroMsg.UrlHistoryListPresenter", "alvinluo fillDetail coverUrl: %s, isBizNativeVideo: %b", new Object[] { localObject, Boolean.valueOf(bool) });
      if ((parama != null) && (!parama.isRecycled())) {
        break label367;
      }
      paramInt = i;
      if (bool) {
        paramInt = 4;
      }
      parama = new com.tencent.mm.ay.a.a.c.a();
      parama.lRP = R.e.chatting_item_biz_default_bg;
      parama.lRC = true;
      parama.fullPath = w.bpO((String)localObject);
      com.tencent.mm.ay.a.a.c.a locala1 = parama.dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      locala1.lRs = new com.tencent.mm.pluginsdk.ui.applet.n(paramInt);
      locala1.lSb = new com.tencent.mm.pluginsdk.ui.applet.e(paramInt);
      locala1.lRB = true;
      q.bml().a((String)localObject, localc.qps, parama.bmL());
    }
    for (;;)
    {
      localc.wRL.setText(Util.nullAs(locala.source, ""));
      c.h(localc.wRL, this.WZa.WFR);
      AppMethodBeat.o(36595);
      return;
      localc.mrM.setVisibility(0);
      localc.mrM.setText(Util.nullAs(locala.desc, ""));
      break;
      label361:
      bool = false;
      break label132;
      label367:
      localc.qps.setImageBitmap(parama);
    }
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(36591);
    String str = this.mContext.getString(R.l.eok);
    AppMethodBeat.o(36591);
    return str;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(36589);
    this.WZB.add(Integer.valueOf(5));
    this.WZB.add(Integer.valueOf(7));
    this.WZB.add(Integer.valueOf(27));
    this.WZB.add(Integer.valueOf(26));
    this.WZB.add(Integer.valueOf(15));
    this.WZB.add(Integer.valueOf(51));
    AppMethodBeat.o(36589);
    return -1;
  }
  
  public final void hRu()
  {
    AppMethodBeat.i(36590);
    this.WYZ.hRy();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36581);
        LinkedList localLinkedList = new LinkedList();
        bh.beI();
        Cursor localCursor = com.tencent.mm.model.c.bbO().fa(h.this.jkq, h.this.jmu);
        if (localCursor == null)
        {
          Log.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
          AppMethodBeat.o(36581);
          return;
        }
        ah localah;
        long l1;
        if (ab.Lj(h.this.jkq))
        {
          bh.beI();
          localah = com.tencent.mm.model.c.bbV().Rw(h.this.jkq);
          l1 = 0L;
        }
        label1025:
        label1031:
        for (;;)
        {
          long l2;
          try
          {
            if (!localCursor.moveToNext()) {
              break label887;
            }
            ca localca = new ca();
            localca.convertFrom(localCursor);
            Object localObject1 = localca.field_content;
            if (localObject1 == null) {
              continue;
            }
            k.b localb = k.b.OQ((String)localObject1);
            if (localb == null) {
              continue;
            }
            localObject1 = h.this;
            int i = localb.type;
            ((h)localObject1).getType();
            if (!((h)localObject1).WZB.contains(Integer.valueOf(i))) {
              continue;
            }
            localObject1 = new Date(localca.field_createTime);
            l2 = com.tencent.mm.ui.gridviewheaders.a.hWZ().b((Date)localObject1);
            if (l1 != l2)
            {
              localLinkedList.add(new c.c(localca.field_createTime));
              localObject1 = h.this;
              ((h)localObject1).WZh += 1;
            }
            localObject1 = h.b(localca, ab.Lj(h.this.jkq));
            Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)localObject1);
            Object localObject3 = "";
            if (localah != null) {
              localObject3 = localah.PJ((String)localObject1);
            }
            i = com.tencent.mm.plugin.fav.ui.e.aAm(localb.llY);
            localObject1 = com.tencent.mm.plugin.fav.a.b.getAppName(h.this.mContext, localb.fUd);
            bh.beI();
            Object localObject5 = com.tencent.mm.model.c.bbL().RG(localb.fUd);
            if ((localObject5 == null) || (!((ax)localObject5).field_username.equals(localb.fUd)))
            {
              az.a.ltq.a(localb.fUd, "", null);
              localObject3 = new h.a(h.this, localca.field_createTime, localb.type, localb.title, localca.field_msgId, ((ax)localObject4).field_username, ((as)localObject4).ayr(), ((ax)localObject4).field_conRemark, (String)localObject3);
              if (localb.type == 5)
              {
                Log.i("MicroMsg.UrlHistoryListPresenter", "alvinluo loadData type: %d", new Object[] { Integer.valueOf(localb.type) });
                localObject4 = new h.b(h.this);
                localObject5 = (com.tencent.mm.aj.e)localb.ar(com.tencent.mm.aj.e.class);
                if ((localObject5 == null) || (((com.tencent.mm.aj.e)localObject5).llr != 1) || (((com.tencent.mm.aj.e)localObject5).llp != 5)) {
                  break label1025;
                }
                bool = true;
                ((h.b)localObject4).WZG = bool;
                ((h.a)localObject3).WZF = ((h.b)localObject4);
              }
              if (!Util.isNullOrNil((String)localObject1)) {
                break label1031;
              }
              localObject1 = localb.description;
              ((h.a)localObject3).source = ((String)localObject1);
              ((h.a)localObject3).appId = localb.appId;
              if (Util.isNullOrNil(localca.field_imgPath))
              {
                ((h.a)localObject3).imagePath = localb.thumburl;
                ((h.a)localObject3).iconRes = i;
                if (localb.type == 51)
                {
                  localObject1 = (f)localb.ar(f.class);
                  ((h.a)localObject3).title = h.this.mContext.getString(R.l.fts_info_finder_desc, new Object[] { ((f)localObject1).mbi.nickname });
                  if (((f)localObject1).mbi.mediaList.size() <= 0) {
                    break label877;
                  }
                  ((h.a)localObject3).imagePath = ((bjc)((f)localObject1).mbi.mediaList.getFirst()).thumbUrl;
                }
                localLinkedList.add(localObject3);
                if (localLinkedList.size() % 20 != 0) {
                  break label1019;
                }
                if ((h.this.mDataList.size() > 0) && (((c.b)h.this.mDataList.get(h.this.mDataList.size() - 1)).getType() == 2147483646)) {
                  h.this.mDataList.remove(h.this.mDataList.size() - 1);
                }
                h.this.mDataList.addAll(localLinkedList);
                h.this.mDataList.add(new c.g());
                h.this.WZb = h.this.mDataList;
                localLinkedList.clear();
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36580);
                    if (h.this.WYZ != null) {
                      h.this.WYZ.H(h.1.this.tNh, h.this.mDataList.size());
                    }
                    AppMethodBeat.o(36580);
                  }
                });
                break label1019;
              }
            }
            else
            {
              localObject1 = ((as)localObject5).ays();
              continue;
            }
            ((h.a)localObject3).imagePath = localca.field_imgPath;
            continue;
            ((h.a)localObject3).imagePath = "";
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(36581);
          }
          label877:
          continue;
          label887:
          localCursor.close();
          if ((h.this.mDataList.size() > 0) && (((c.b)h.this.mDataList.get(h.this.mDataList.size() - 1)).getType() == 2147483646)) {
            h.this.mDataList.remove(h.this.mDataList.size() - 1);
          }
          h.this.mDataList.addAll(localLinkedList);
          h.this.WZb = h.this.mDataList;
          localLinkedList.clear();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(279726);
              if (h.this.WYZ != null) {
                h.this.WYZ.H(h.1.this.tNh, h.this.mDataList.size());
              }
              AppMethodBeat.o(279726);
            }
          });
          AppMethodBeat.o(36581);
          return;
          localah = null;
          break;
          label1019:
          l1 = l2;
          continue;
          boolean bool = false;
        }
      }
    });
    AppMethodBeat.o(36590);
  }
  
  public final c.e hRv()
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
        new m(paramAnonymousView.getContext()).b(paramAnonymousView, new View.OnCreateContextMenuListener()new q.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(36582);
            paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View.getContext().getString(R.l.retransmits));
            paramAnonymous2ContextMenu.add(0, 1, 0, paramAnonymous2View.getContext().getString(R.l.chatting_fav));
            paramAnonymous2ContextMenu.add(0, 2, 0, paramAnonymous2View.getContext().getString(R.l.evO));
            AppMethodBeat.o(36582);
          }
        }, new q.g()
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
            bh.beI();
            paramAnonymous2MenuItem = com.tencent.mm.model.c.bbO().Oq(paramAnonymousb.msgId);
            h.this.e(paramAnonymous2Int, paramAnonymous2MenuItem);
            AppMethodBeat.o(36583);
          }
        });
        AppMethodBeat.o(36585);
      }
    };
    AppMethodBeat.o(36593);
    return local2;
  }
  
  public final String hRx()
  {
    AppMethodBeat.i(36592);
    String str = this.mContext.getString(R.l.eok);
    AppMethodBeat.o(36592);
    return str;
  }
  
  final class a
    extends c.b
  {
    public h.b WZF = null;
    public String appId;
    public String desc;
    public int iconRes;
    public String imagePath;
    public String source;
    
    public a(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      super(paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    }
    
    public final boolean bzd(String paramString)
    {
      AppMethodBeat.i(36586);
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        if (!bze(paramString))
        {
          if ((!Util.isNullOrNil(this.source)) && (nZ(paramString, this.source.toLowerCase())))
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
        boolean bool = super.bzd(paramString);
        AppMethodBeat.o(36586);
        return bool;
      }
      AppMethodBeat.o(36586);
      return false;
    }
  }
  
  final class b
  {
    public boolean WZG = false;
    
    b() {}
  }
  
  final class c
    extends com.tencent.mm.ui.chatting.a.c.a
  {
    TextView mrM;
    ImageView qps;
    TextView wRL;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(36587);
      this.qps = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.mrM = ((TextView)paramView.findViewById(R.h.fav_desc));
      this.wRL = ((TextView)paramView.findViewById(R.h.fav_source));
      this.wRL.setVisibility(0);
      AppMethodBeat.o(36587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.h
 * JD-Core Version:    0.7.0.1
 */
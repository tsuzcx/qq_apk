package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.c;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.memory.a.b.a;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public final class f
  implements com.tencent.mm.plugin.sns.b.g
{
  private static int zgt = 0;
  private Map<Integer, WeakReference<Object>> iaj;
  public boolean zfK;
  private long zfW;
  private long zfX;
  com.tencent.mm.memory.a.b<com.tencent.mm.memory.n> zfY;
  private am<String, WeakReference<Bitmap>> zfZ;
  private Map<String, LinkedList<WeakReference<c>>> zga;
  private ConcurrentHashMap<Integer, String> zgb;
  private LinkedList<b> zgc;
  private boolean zgd;
  private HashSet<c> zge;
  public HashMap<String, Integer> zgf;
  private int zgg;
  public ab zgh;
  public long zgi;
  public long zgj;
  private int zgk;
  private int zgl;
  private HashMap<Long, Integer> zgm;
  private HashMap<Integer, Boolean> zgn;
  private HashMap<Integer, Boolean> zgo;
  private int zgp;
  private int zgq;
  private HashMap<Long, Integer> zgr;
  protected Set<String> zgs;
  
  public f()
  {
    AppMethodBeat.i(95483);
    this.zfW = 0L;
    this.zfX = 0L;
    this.iaj = new HashMap();
    this.zga = new HashMap();
    this.zgb = new ConcurrentHashMap();
    this.zgc = new LinkedList();
    this.zgd = false;
    this.zge = new HashSet();
    this.zgf = new HashMap();
    this.zgg = 4;
    this.zfK = true;
    this.zgi = 0L;
    this.zgj = 0L;
    this.zgk = 0;
    this.zgl = 0;
    this.zgm = new HashMap();
    this.zgn = new HashMap();
    this.zgo = new HashMap();
    this.zgp = 0;
    this.zgq = 0;
    this.zgr = new HashMap();
    this.zgs = new HashSet();
    com.tencent.mm.memory.a.b.a(com.tencent.mm.memory.n.class, new b.a() {});
    int i = ((ActivityManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    ad.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.zfY = new com.tencent.mm.memory.a.b(i, new com.tencent.mm.b.f.b() {}, getClass());
      this.zfZ = new am(this.zgg, new am.a()
      {
        public final boolean dG(Object paramAnonymousObject)
        {
          AppMethodBeat.i(95463);
          String str = (String)paramAnonymousObject;
          Object localObject;
          if (f.a(f.this, str)) {
            localObject = f.a(f.this);
          }
          for (;;)
          {
            try
            {
              paramAnonymousObject = ((am.b)((am)localObject).zkW.get(str)).obj;
              if (!(paramAnonymousObject instanceof Bitmap)) {
                continue;
              }
              paramAnonymousObject = (Bitmap)paramAnonymousObject;
              if ((paramAnonymousObject != null) && (!paramAnonymousObject.isRecycled()))
              {
                ad.d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
                paramAnonymousObject.recycle();
              }
            }
            catch (Exception paramAnonymousObject)
            {
              int i;
              ad.printErrStackTrace("MicroMsg.SnsLRUMap", paramAnonymousObject, "", new Object[0]);
              ad.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
              continue;
              boolean bool = false;
              continue;
            }
            i = ((am)localObject).zkW.size();
            paramAnonymousObject = ((am)localObject).zkW.remove(str);
            localObject = new StringBuilder("internalMap ").append(((am)localObject).zkW.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              ad.d("MicroMsg.SnsLRUMap", bool);
              ad.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + f.a(f.this).zkW.size() + " listPaitSize:" + f.b(f.this).size());
              AppMethodBeat.o(95463);
              return true;
              paramAnonymousObject = (WeakReference)((am.b)((am)localObject).zkW.get(str)).obj;
              if (paramAnonymousObject != null) {
                paramAnonymousObject = (Bitmap)paramAnonymousObject.get();
              }
            }
            else
            {
              AppMethodBeat.o(95463);
              return false;
            }
            paramAnonymousObject = null;
          }
        }
      });
      AppMethodBeat.o(95483);
      return;
    }
  }
  
  public static String C(byn parambyn)
  {
    AppMethodBeat.i(95541);
    if (parambyn == null)
    {
      AppMethodBeat.o(95541);
      return null;
    }
    if (parambyn.Id.startsWith("pre_temp_sns_pic")) {
      parambyn = ag.getAccSnsTmpPath() + parambyn.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(95541);
      return parambyn;
      if (parambyn.Id.startsWith("Locall_path")) {
        parambyn = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.l(parambyn);
      } else if (parambyn.Id.startsWith("pre_temp_extend_pic")) {
        parambyn = parambyn.Id.substring(19);
      } else {
        parambyn = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.c(parambyn);
      }
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, bj parambj)
  {
    AppMethodBeat.i(95538);
    if ((!paramBoolean) && (bt.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    byn localbyn = com.tencent.mm.modelsns.h.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    com.tencent.mm.plugin.sns.data.q.bZ(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = com.tencent.mm.plugin.sns.data.q.ayb(paramString1);
      if (com.tencent.mm.plugin.sns.data.q.I(paramString1))
      {
        AppMethodBeat.o(95538);
        return paramString1;
      }
      AppMethodBeat.o(95538);
      return null;
    }
    if (com.tencent.mm.plugin.sns.data.q.I(null))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.sns.data.q.k(localbyn);
    localObject = com.tencent.mm.plugin.sns.data.q.ayb(ao.jo(ag.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!com.tencent.mm.plugin.sns.data.q.I((Bitmap)localObject)) {
      paramString3 = com.tencent.mm.plugin.sns.data.q.ayb(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!bt.isNullOrNil(paramString2))) {
      ag.dTZ().a(localbyn, 3, null, parambj);
    }
    if (!com.tencent.mm.plugin.sns.data.q.I(paramString3))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    AppMethodBeat.o(95538);
    return paramString3;
  }
  
  private String a(p paramp, final byn parambyn, final bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(95531);
    if (u(parambyn))
    {
      AppMethodBeat.o(95531);
      return "";
    }
    String str1 = ao.jo(ag.getAccSnsPath(), parambyn.Id);
    String str2 = com.tencent.mm.plugin.sns.data.q.i(parambyn);
    if (i.fv(str1 + str2))
    {
      paramp = str1 + str2;
      AppMethodBeat.o(95531);
      return paramp;
    }
    if ((i.fv(str1 + com.tencent.mm.plugin.sns.data.q.o(parambyn))) && (parambyn.Id != null) && (parambyn.Id.startsWith("Locall_path")))
    {
      paramp = str1 + com.tencent.mm.plugin.sns.data.q.o(parambyn);
      AppMethodBeat.o(95531);
      return paramp;
    }
    if (!this.zfK)
    {
      AppMethodBeat.o(95531);
      return "";
    }
    ad.i("MicroMsg.LazyerImageLoader2", "push sight loader " + parambyn.Id + " url: " + parambyn.Url);
    if (paramBoolean) {
      if (b(paramp, null) == 5) {
        ag.cVf().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95470);
            ag.dTZ().a(parambyn, 4, null, parambj);
            AppMethodBeat.o(95470);
          }
        }, 0L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95531);
      return "";
      ad.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
    }
  }
  
  private void a(View paramView, String paramString, int paramInt, f.a parama)
  {
    AppMethodBeat.i(95509);
    a(paramView, paramString, true, -1, paramInt, -1, -1, parama);
    AppMethodBeat.o(95509);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95510);
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, f.a.zgQ);
    AppMethodBeat.o(95510);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95512);
    a(paramObject, paramString, false, -1, paramInt1, paramInt2, paramInt3, f.a.zgQ);
    AppMethodBeat.o(95512);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, f.a parama)
  {
    AppMethodBeat.i(95511);
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, parama);
    AppMethodBeat.o(95511);
  }
  
  private static void a(Object paramObject, String paramString, com.tencent.mm.memory.n paramn)
  {
    long l2 = 0L;
    AppMethodBeat.i(95498);
    if (paramObject == null)
    {
      AppMethodBeat.o(95498);
      return;
    }
    if (paramn != null) {
      ad.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.ayK() });
    }
    Object localObject;
    long l1;
    if ((paramObject instanceof QFadeImageView))
    {
      paramObject = (QFadeImageView)paramObject;
      localObject = paramObject.getDrawable();
      l1 = l2;
      if (!bt.isNullOrNil(paramObject.getImageKey()))
      {
        l1 = l2;
        if (paramObject.getImageKey().equals(paramString)) {
          l1 = paramObject.getStartTimeMillis();
        }
      }
      if ((localObject == null) || (!(localObject instanceof aj))) {
        break label468;
      }
      l1 = ((aj)localObject).zkO;
    }
    label454:
    label468:
    for (;;)
    {
      paramn = new aj(paramString, paramn, l1);
      paramObject.O(paramn.zkO, paramString);
      paramObject.setImageDrawable(paramn);
      paramn.invalidateSelf();
      AppMethodBeat.o(95498);
      return;
      if ((paramObject instanceof QDisFadeImageView))
      {
        paramObject = (QDisFadeImageView)paramObject;
        paramString = new com.tencent.mm.memory.b.a(paramString, paramn);
        paramObject.setImageDrawable(paramString);
        paramString.invalidateSelf();
        AppMethodBeat.o(95498);
        return;
      }
      if ((paramObject instanceof ImageView))
      {
        localObject = (ImageView)paramObject;
        paramObject = ((ImageView)localObject).getDrawable();
        if ((paramObject != null) && ((paramObject instanceof aj))) {}
        for (paramObject = new aj(paramString, paramn, ((aj)paramObject).zkO);; paramObject = new aj(paramString, paramn, 0L))
        {
          ((ImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof com.tencent.mm.plugin.sight.decode.a.a))
      {
        ad.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(paramString)));
        if ((paramObject instanceof SightPlayImageView))
        {
          localObject = (SightPlayImageView)paramObject;
          paramObject = ((SightPlayImageView)localObject).getDrawable();
          if ((paramObject == null) || (!(paramObject instanceof aj))) {
            break label361;
          }
        }
        label361:
        for (paramObject = new aj(paramString, paramn, ((aj)paramObject).zkO);; paramObject = new aj(paramString, paramn, 0L))
        {
          ((SightPlayImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof SnsAdTimelineVideoView))
      {
        ad.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setImageDrawable, key=".concat(String.valueOf(paramString)));
        localObject = (SnsAdTimelineVideoView)paramObject;
        paramObject = ((SnsAdTimelineVideoView)localObject).getThumbDrawable();
        if ((paramObject == null) || (!(paramObject instanceof aj))) {
          break label454;
        }
      }
      for (paramObject = new aj(paramString, paramn, ((aj)paramObject).zkO);; paramObject = new aj(paramString, paramn, 0L))
      {
        ((SnsAdTimelineVideoView)localObject).setThumbDrawable(paramObject);
        paramObject.invalidateSelf();
        AppMethodBeat.o(95498);
        return;
      }
    }
  }
  
  private void a(Object paramObject, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, f.a parama)
  {
    AppMethodBeat.i(95513);
    if (paramObject == null)
    {
      AppMethodBeat.o(95513);
      return;
    }
    int i = paramObject.hashCode();
    this.zge.remove(new c(null, i, 0, false));
    c localc = new c(paramString, i, paramInt2, paramBoolean);
    this.zge.add(localc);
    LinkedList localLinkedList = (LinkedList)this.zga.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.zga.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.zga.get(localObject);
      if (localLinkedList != null)
      {
        paramInt2 = 0;
        if (paramInt2 >= localLinkedList.size()) {
          break label490;
        }
        localc = (c)((WeakReference)localLinkedList.get(paramInt2)).get();
        if ((localc == null) || (localc.code != i)) {
          break label339;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != -1)
      {
        ad.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[] { localObject });
        localLinkedList.remove(paramInt2);
      }
      ((View)paramObject).setTag(2130706432, paramString);
      localObject = new WeakReference(paramObject);
      this.iaj.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label348;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == f.a.zgR) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
        {
          com.tencent.mm.sdk.platformtools.q.fke();
          AppMethodBeat.o(95513);
          return;
          label339:
          paramInt2 += 1;
          break;
          label348:
          if ((paramObject instanceof ImageView))
          {
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.cc.a.l(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.a.a)paramObject;
            if (!this.zfK) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((com.tencent.mm.plugin.sight.decode.a.a)localObject).e(null, paramBoolean, 0);
              break;
            }
          }
        }
      }
      if ((paramString != null) && (paramString.startsWith("3")) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
      {
        com.tencent.mm.sdk.platformtools.q.A((View)paramObject, paramInt3, paramInt4);
        ad.d("MicroMsg.LazyerImageLoader2", "try to setLayerType " + paramInt3 + " " + paramInt4);
      }
      AppMethodBeat.o(95513);
      return;
      label490:
      paramInt2 = -1;
    }
  }
  
  private boolean a(final int paramInt, final byn parambyn, final bj parambj)
  {
    AppMethodBeat.i(95517);
    if (!this.zfK)
    {
      if ((parambyn != null) && (!bt.isNullOrNil(parambyn.Id))) {
        ag.dTZ().ayF(parambyn.Id);
      }
      AppMethodBeat.o(95517);
      return false;
    }
    ag.dTR().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95469);
        m localm;
        b localb;
        byn localbyn;
        if (!f.a(f.this, paramInt, parambyn))
        {
          localm = new m(parambyn);
          localm.zds = paramInt;
          localm.dwW = parambyn.Id;
          localb = ag.dTZ();
          localbyn = parambyn;
          if (parambyn.nEf != 6) {
            break label97;
          }
        }
        label97:
        for (int i = 5;; i = 1)
        {
          localb.a(localbyn, i, localm, parambj);
          AppMethodBeat.o(95469);
          return;
        }
      }
    });
    AppMethodBeat.o(95517);
    return true;
  }
  
  public static boolean a(byn parambyn, bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(95540);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95540);
      return false;
    }
    Object localObject;
    if (parambyn.Id.startsWith("Locall_path"))
    {
      localObject = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.l(parambyn);
      if (i.fv((String)localObject)) {
        break label161;
      }
      localObject = ag.dTZ();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 2)
    {
      ((b)localObject).a(parambyn, i, null, parambj);
      AppMethodBeat.o(95540);
      return false;
      localObject = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.c(parambyn);
      break;
    }
    label161:
    AppMethodBeat.o(95540);
    return true;
  }
  
  private boolean a(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(95534);
    if ((paramn != null) && (paramString != null)) {
      this.zfY.put(paramString, paramn);
    }
    AppMethodBeat.o(95534);
    return true;
  }
  
  private boolean a(final List<byn> paramList, final bj parambj)
  {
    AppMethodBeat.i(95515);
    ag.dTR().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95466);
        long l = bt.HI();
        Object localObject = new m(paramList);
        ((m)localObject).dwW = com.tencent.mm.plugin.sns.data.q.fF(paramList);
        ((m)localObject).zds = this.zgv;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          byn localbyn = (byn)paramList.get(j);
          if (ag.dTZ().ayA(localbyn.Id)) {
            i = 0;
          }
          do
          {
            do
            {
              do
              {
                j += 1;
                k = i;
                break;
                i = k;
              } while (i.fv(ao.jo(ag.getAccSnsPath(), localbyn.Id) + com.tencent.mm.plugin.sns.data.q.d(localbyn)));
              i = k;
            } while (i.fv(ao.jo(ag.getAccSnsPath(), localbyn.Id) + com.tencent.mm.plugin.sns.data.q.k(localbyn)));
            i = k;
          } while (i.fv(ao.jo(ag.getAccSnsPath(), localbyn.Id) + com.tencent.mm.plugin.sns.data.q.l(localbyn)));
          b localb = ag.dTZ();
          if (localbyn.nEf == 6) {}
          for (int i = 5;; i = 1)
          {
            localb.a(localbyn, i, (m)localObject, parambj);
            i = 0;
            break;
          }
        }
        l = bt.aO(l);
        if (l > 100L) {
          ad.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.arO() + " " + ag.dUv() + " " + ((m)localObject).dwW);
        }
        if (bt.aO(f.c(f.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), ag.dUv(), com.tencent.mm.loader.j.b.arO() });
          f.a(f.this, bt.HI());
        }
        localObject = com.tencent.mm.plugin.sns.data.q.fF(paramList);
        if (k != 0) {
          ag.cVf().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95465);
              new h(com.tencent.mm.plugin.sns.data.q.bZ(0, this.LO), this.LO, f.9.this.zgM).x(new String[] { "" });
              AppMethodBeat.o(95465);
            }
          });
        }
        AppMethodBeat.o(95466);
      }
    });
    AppMethodBeat.o(95515);
    return true;
  }
  
  private boolean as(View paramView, int paramInt)
  {
    AppMethodBeat.i(95485);
    if (paramView.hashCode() == paramInt)
    {
      AppMethodBeat.o(95485);
      return true;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount();
      int j;
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (!as(paramView.getChildAt(j), paramInt));
      AppMethodBeat.o(95485);
      return true;
    }
    AppMethodBeat.o(95485);
    return false;
  }
  
  private com.tencent.mm.memory.n ayI(String paramString)
  {
    AppMethodBeat.i(95492);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.zfY.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.zfY.remove(paramString);
      AppMethodBeat.o(95492);
      return null;
    }
    AppMethodBeat.o(95492);
    return localn;
  }
  
  private com.tencent.mm.memory.n ayJ(String paramString)
  {
    AppMethodBeat.i(95493);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.zfY.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.zfY.remove(paramString);
      AppMethodBeat.o(95493);
      return null;
    }
    AppMethodBeat.o(95493);
    return localn;
  }
  
  private boolean ayK(String paramString)
  {
    AppMethodBeat.i(179083);
    if ((this.zgf.containsKey(paramString)) && (4 == ((Integer)this.zgf.get(paramString)).intValue())) {
      this.zgf.remove(paramString);
    }
    AppMethodBeat.o(179083);
    return true;
  }
  
  private void b(byn parambyn, View paramView, int paramInt, f.a parama, bj parambj)
  {
    AppMethodBeat.i(95497);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95497);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.q.bZ(5, parambyn.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = ayI(str);
    if (!com.tencent.mm.plugin.sns.data.q.b(parama))
    {
      eT(paramView);
      if (this.zgs.contains(str))
      {
        AppMethodBeat.o(95497);
        return;
      }
      a(5, parambyn, parambj);
      AppMethodBeat.o(95497);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95497);
  }
  
  private boolean dTv()
  {
    AppMethodBeat.i(95516);
    if (this.zgd)
    {
      ad.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(95516);
      return false;
    }
    ag.cVf().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95467);
        if (f.d(f.this))
        {
          ad.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
          AppMethodBeat.o(95467);
          return;
        }
        if (f.e(f.this).size() > 0)
        {
          ad.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + f.e(f.this).size());
          ((f.b)f.e(f.this).removeLast()).x(new String[] { "" });
        }
        AppMethodBeat.o(95467);
      }
    }, 0L);
    AppMethodBeat.o(95516);
    return true;
  }
  
  private static boolean eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(95523);
    paramString = bw.M(paramString, "SightDownloadControl");
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(95523);
      return true;
    }
    if (paramInt == 1)
    {
      if (bt.getInt((String)paramString.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1)
      {
        AppMethodBeat.o(95523);
        return true;
      }
      AppMethodBeat.o(95523);
      return false;
    }
    if (bt.getInt((String)paramString.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1)
    {
      AppMethodBeat.o(95523);
      return true;
    }
    AppMethodBeat.o(95523);
    return false;
  }
  
  private static void eT(View paramView)
  {
    AppMethodBeat.i(95508);
    if ((paramView instanceof QImageView))
    {
      ((QImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(2131099651)));
      AppMethodBeat.o(95508);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(2131099651)));
      AppMethodBeat.o(95508);
      return;
    }
    AppMethodBeat.o(95508);
  }
  
  public static String q(byn parambyn)
  {
    AppMethodBeat.i(95489);
    String str = ao.jo(ag.getAccSnsPath(), parambyn.Id);
    parambyn = com.tencent.mm.plugin.sns.data.q.d(parambyn);
    parambyn = str + parambyn;
    AppMethodBeat.o(95489);
    return parambyn;
  }
  
  public static String r(byn parambyn)
  {
    AppMethodBeat.i(95499);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95499);
      return null;
    }
    String str = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.d(parambyn);
    if (!i.fv(str))
    {
      parambyn = parambyn.GSI;
      AppMethodBeat.o(95499);
      return parambyn;
    }
    AppMethodBeat.o(95499);
    return str;
  }
  
  public static String s(byn parambyn)
  {
    AppMethodBeat.i(95500);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95500);
      return null;
    }
    String str = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.c(parambyn);
    if (!i.fv(str))
    {
      parambyn = parambyn.Url;
      AppMethodBeat.o(95500);
      return parambyn;
    }
    AppMethodBeat.o(95500);
    return str;
  }
  
  private void setError(String paramString)
  {
    AppMethodBeat.i(179084);
    this.zgf.put(paramString, Integer.valueOf(4));
    AppMethodBeat.o(179084);
  }
  
  public static boolean t(byn parambyn)
  {
    AppMethodBeat.i(95518);
    String str1 = ao.jo(ag.getAccSnsPath(), parambyn.Id);
    String str2 = com.tencent.mm.plugin.sns.data.q.i(parambyn);
    if (i.fv(str1 + str2))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    if ((i.fv(str1 + com.tencent.mm.plugin.sns.data.q.o(parambyn))) && (!bt.isNullOrNil(parambyn.Id)) && (parambyn.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    AppMethodBeat.o(95518);
    return false;
  }
  
  public final void A(byn parambyn)
  {
    AppMethodBeat.i(95530);
    this.zgf.put(parambyn.Id, Integer.valueOf(3));
    AppMethodBeat.o(95530);
  }
  
  public final boolean B(byn parambyn)
  {
    AppMethodBeat.i(95539);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95539);
      return false;
    }
    if (i.fv(ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.e(parambyn)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    if (i.fv(ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.d(parambyn)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    parambyn = com.tencent.mm.plugin.sns.data.q.bZ(1, parambyn.Id);
    boolean bool = com.tencent.mm.plugin.sns.data.q.b((com.tencent.mm.memory.n)this.zfY.get(parambyn));
    AppMethodBeat.o(95539);
    return bool;
  }
  
  public final int a(p paramp, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95520);
    Object localObject;
    PInt localPInt1;
    PInt localPInt2;
    if ((paramArrayOfInt != null) || (bt.aO(this.zgi) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      c.aGN();
      if (!c.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.zgk = 5;
      if (paramArrayOfInt != null) {
        if (((PInt)localObject).value != 0) {
          break label158;
        }
      }
    }
    label149:
    label158:
    for (int i = 0;; i = 1)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = localPInt1.value;
      paramArrayOfInt[2] = localPInt2.value;
      this.zgl = ((PInt)localObject).value;
      this.zgi = bt.HI();
      if ((this.zgl != 0) && (paramp != null)) {
        break label163;
      }
      i = this.zgk;
      AppMethodBeat.o(95520);
      return i;
      this.zgk = 10;
      break;
    }
    label163:
    if (this.zgm.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.zgm.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = new dgh();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.zgk;
        AppMethodBeat.o(95520);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.HuB == null) || (paramArrayOfInt.HuB.info == null))
      {
        i = this.zgk;
        AppMethodBeat.o(95520);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ad.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.zgk;
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.HuB.info;
    i = paramArrayOfInt.hashCode();
    if (this.zgl == 1)
    {
      if (!this.zgo.containsKey(Integer.valueOf(i))) {
        this.zgo.put(Integer.valueOf(i), Boolean.valueOf(eR(paramArrayOfInt, this.zgl)));
      }
      if (((Boolean)this.zgo.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ad.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.zgm.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95520);
        return i;
      }
    }
    if (!this.zgn.containsKey(Integer.valueOf(i))) {
      this.zgn.put(Integer.valueOf(i), Boolean.valueOf(eR(paramArrayOfInt, this.zgl)));
    }
    if (((Boolean)this.zgn.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(byn parambyn)
  {
    AppMethodBeat.i(95488);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95488);
      return null;
    }
    String str1 = com.tencent.mm.plugin.sns.data.q.bZ(1, parambyn.Id);
    Object localObject = ayI(str1);
    if (com.tencent.mm.plugin.sns.data.q.b((com.tencent.mm.memory.n)localObject))
    {
      parambyn = ((com.tencent.mm.memory.n)localObject).ayF();
      AppMethodBeat.o(95488);
      return parambyn;
    }
    localObject = ao.jo(ag.getAccSnsPath(), parambyn.Id);
    String str2 = com.tencent.mm.plugin.sns.data.q.d(parambyn);
    localObject = (String)localObject + str2;
    if (i.fv((String)localObject))
    {
      if (parambyn.Id.startsWith("pre_temp_extend_pic")) {}
      for (parambyn = com.tencent.mm.memory.n.D(u.aAu((String)localObject)); com.tencent.mm.plugin.sns.data.q.b(parambyn); parambyn = com.tencent.mm.plugin.sns.data.q.ayc((String)localObject))
      {
        a(str1, parambyn);
        parambyn = parambyn.ayF();
        AppMethodBeat.o(95488);
        return parambyn;
      }
      AppMethodBeat.o(95488);
      return null;
    }
    AppMethodBeat.o(95488);
    return null;
  }
  
  public final com.tencent.mm.memory.n a(byn parambyn, ImageView paramImageView, int paramInt, bj parambj)
  {
    AppMethodBeat.i(95543);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95543);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.q.bZ(0, parambyn.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = ayI(str);
    if (!com.tencent.mm.plugin.sns.data.q.b(paramImageView))
    {
      a(0, parambyn, parambj);
      AppMethodBeat.o(95543);
      return null;
    }
    AppMethodBeat.o(95543);
    return paramImageView;
  }
  
  public final void a(byn parambyn, View paramView, int paramInt1, int paramInt2, f.a parama, bj parambj)
  {
    AppMethodBeat.i(95496);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95496);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.q.bZ(0, parambyn.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = ayI(str);
    if (!com.tencent.mm.plugin.sns.data.q.b(parama))
    {
      ad.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        eT(paramView);
      }
      if (this.zgs.contains(str))
      {
        AppMethodBeat.o(95496);
        return;
      }
      a(0, parambyn, parambj);
      AppMethodBeat.o(95496);
      return;
    }
    ad.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    ag.dTZ().ayF(parambyn.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(95496);
  }
  
  public final void a(byn parambyn, View paramView, int paramInt1, int paramInt2, bj parambj)
  {
    AppMethodBeat.i(95494);
    a(parambyn, paramView, paramInt1, paramInt2, f.a.zgQ, parambj);
    AppMethodBeat.o(95494);
  }
  
  public final void a(byn parambyn, View paramView, int paramInt, f.a parama, bj parambj)
  {
    AppMethodBeat.i(95491);
    a(parambyn, paramView, -1, paramInt, parama, parambj);
    AppMethodBeat.o(95491);
  }
  
  public final void a(byn parambyn, View paramView, int paramInt, bj parambj)
  {
    AppMethodBeat.i(95501);
    b(parambyn, paramView, -1, paramInt, parambj);
    AppMethodBeat.o(95501);
  }
  
  public final void a(final byn parambyn, final View paramView, final int paramInt, final boolean paramBoolean1, final bj parambj, final boolean paramBoolean2, final e parame)
  {
    AppMethodBeat.i(95542);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95542);
      return;
    }
    final String str1 = com.tencent.mm.plugin.sns.data.q.bZ(3, parambyn.Id);
    final String str2 = C(parambyn);
    if (ag.dTZ().ayB(parambyn.Id))
    {
      ad.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + parambyn.Id);
      a(paramView, str1, paramInt, -1, -1);
      parame.al(null);
      AppMethodBeat.o(95542);
      return;
    }
    Object localObject1 = this.zfZ;
    Object localObject2 = (am.b)((am)localObject1).zkW.get(str1);
    boolean bool;
    if (localObject2 == null)
    {
      localObject1 = null;
      localObject1 = (WeakReference)localObject1;
      localObject2 = new StringBuilder("getFromWeakReference ").append(str1).append("  ");
      if (localObject1 != null) {
        break label286;
      }
      bool = true;
      label185:
      ad.i("MicroMsg.LazyerImageLoader2", bool);
      if (localObject1 != null) {
        break label292;
      }
    }
    label286:
    label292:
    for (localObject1 = null;; localObject1 = (Bitmap)((WeakReference)localObject1).get())
    {
      if (!com.tencent.mm.plugin.sns.data.q.I((Bitmap)localObject1)) {
        break label305;
      }
      ad.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
      a(paramView, str1, paramInt, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      parame.al((Bitmap)localObject1);
      AppMethodBeat.o(95542);
      return;
      ((am.b)((am)localObject1).zkW.get(str1)).dUG();
      localObject1 = ((am.b)localObject2).obj;
      break;
      bool = false;
      break label185;
    }
    label305:
    ag.dTP().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95459);
        final Bitmap localBitmap = com.tencent.mm.plugin.sns.data.q.ayb(str2);
        ag.cVf().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95458);
            if (com.tencent.mm.plugin.sns.data.q.I(localBitmap))
            {
              f.a(f.this, f.4.this.zfc, f.4.this.zgy, f.4.this.zgz, localBitmap.getWidth(), localBitmap.getHeight());
              if (!com.tencent.mm.plugin.sns.data.q.I(localBitmap)) {
                break label252;
              }
              localObject1 = f.a(f.this);
              localObject2 = f.4.this.zgy;
              localObject3 = new WeakReference(localBitmap);
              if ((am.b)((am)localObject1).zkW.get(localObject2) != null) {
                break label215;
              }
              localObject3 = new am.b((am)localObject1, localObject3);
              ((am)localObject1).zkW.put(localObject2, localObject3);
              ((am)localObject1).dUF();
            }
            label215:
            label252:
            while (!f.4.this.zgA) {
              for (;;)
              {
                Object localObject3;
                if (f.4.this.zgD != null) {
                  f.4.this.zgD.al(localBitmap);
                }
                AppMethodBeat.o(95458);
                return;
                f.a(f.this, f.4.this.zfc, f.4.this.zgy, f.4.this.zgz, -1, -1);
                break;
                ((am.b)((am)localObject1).zkW.get(localObject2)).dUG();
                ((am.b)((am)localObject1).zkW.get(localObject2)).obj = localObject3;
              }
            }
            Object localObject1 = ag.dTZ();
            Object localObject2 = f.4.this.zbm;
            if (f.4.this.zgB) {}
            for (int i = 8;; i = 2)
            {
              ((b)localObject1).a((byn)localObject2, i, null, f.4.this.zgC);
              break;
            }
          }
        });
        AppMethodBeat.o(95459);
      }
    });
    AppMethodBeat.o(95542);
  }
  
  public final void a(final String paramString, SparseArray<byn> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, final bj parambj, final int paramInt2)
  {
    AppMethodBeat.i(95495);
    ad.i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
    if ((paramSparseArray == null) || (paramSparseArray.size() <= 0))
    {
      ad.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    if ((paramSparseArray1 == null) || (paramSparseArray1.size() <= 0))
    {
      ad.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    int j = paramSparseArray.size();
    int k = paramSparseArray1.size();
    if (j == k) {}
    for (int i = j; -1 == i; i = -1)
    {
      ad.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(95495);
      return;
    }
    final SparseArray localSparseArray1 = new SparseArray();
    final SparseArray localSparseArray2 = new SparseArray();
    final SparseArray localSparseArray3 = new SparseArray();
    i = 0;
    if (i < j)
    {
      k = paramSparseArray.keyAt(i);
      byn localbyn = (byn)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = com.tencent.mm.plugin.sns.data.q.bZ(0, localbyn.Id);
      a(localView, str, -1, paramInt1, f.a.zgQ);
      com.tencent.mm.memory.n localn = ayI(str);
      if (!com.tencent.mm.plugin.sns.data.q.b(localn))
      {
        ad.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        eT(localView);
        if (!this.zgs.contains(str)) {
          localSparseArray1.put(k, localbyn);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ad.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
        a(localView, str, localn);
      }
    }
    if (localSparseArray1.size() != 0)
    {
      ad.i("MicroMsg.LazyerImageLoader2", "ok, let's download.");
      ag.dTR().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95464);
          int j = localSparseArray1.size();
          int i = 0;
          while (i < j)
          {
            int k = localSparseArray1.keyAt(i);
            byn localbyn = (byn)localSparseArray1.get(k);
            if (!f.a(f.this, 0, localbyn))
            {
              m localm = new m(localbyn);
              localm.zds = 0;
              localm.dwW = localbyn.Id;
              localSparseArray2.put(k, localm);
              localSparseArray3.put(k, localbyn);
            }
            i += 1;
          }
          if (localSparseArray3.size() > 0) {
            ag.dTZ().a(paramString, localSparseArray3, localSparseArray2, parambj, paramInt2);
          }
          AppMethodBeat.o(95464);
        }
      });
    }
    AppMethodBeat.o(95495);
  }
  
  public final void a(List<byn> paramList, View paramView, int paramInt, f.a parama, bj parambj)
  {
    AppMethodBeat.i(95545);
    a(paramList, paramView, paramInt, parama, parambj, false);
    AppMethodBeat.o(95545);
  }
  
  public final void a(List<byn> paramList, View paramView, int paramInt, f.a parama, bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(95546);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(95546);
      return;
    }
    if (paramList.size() == 1)
    {
      if (!paramBoolean)
      {
        b((byn)paramList.get(0), paramView, paramInt, parambj);
        AppMethodBeat.o(95546);
        return;
      }
      b((byn)paramList.get(0), paramView, paramInt, f.a.zgR, parambj);
      AppMethodBeat.o(95546);
      return;
    }
    String str = com.tencent.mm.plugin.sns.data.q.bZ(0, com.tencent.mm.plugin.sns.data.q.fF(paramList));
    a(paramView, str, paramInt, parama);
    parama = ayI(str);
    paramBoolean = com.tencent.mm.plugin.sns.data.q.b(parama);
    ad.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      eT(paramView);
      if (this.zgs.contains(str))
      {
        AppMethodBeat.o(95546);
        return;
      }
      new WeakReference(paramView);
      a(paramList, parambj);
      AppMethodBeat.o(95546);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95546);
  }
  
  public final boolean a(m paramm, String paramString)
  {
    AppMethodBeat.i(95535);
    Object localObject1 = (byn)paramm.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < paramm.list.size())
    {
      localObject2 = (byn)paramm.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((byn)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id);
      if (paramm.zds == 0) {
        paramString = com.tencent.mm.plugin.sns.data.q.e((byn)localObject1);
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.sns.data.q.bZ(paramm.zds, ((byn)localObject1).Id);
        if (!this.zfY.aM(str)) {
          new b(com.tencent.mm.plugin.sns.data.q.bZ(paramm.zds, ((byn)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (byn)localObject1, paramm.zds).x(new String[] { "" });
        }
        AppMethodBeat.o(95535);
        return true;
        i += 1;
        break;
        if (paramm.zds == 4) {
          paramString = com.tencent.mm.plugin.sns.data.q.f((byn)localObject1);
        } else if (paramm.zds == 5) {
          paramString = com.tencent.mm.plugin.sns.data.q.f((byn)localObject1);
        } else if (paramm.zds == 3) {
          paramString = com.tencent.mm.plugin.sns.data.q.k((byn)localObject1);
        } else {
          paramString = com.tencent.mm.plugin.sns.data.q.d((byn)localObject1);
        }
      }
    }
  }
  
  public final boolean a(p paramp, byn parambyn, SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt, bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(179081);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(179081);
      return false;
    }
    String str1 = com.tencent.mm.plugin.sns.data.q.bZ(1, parambyn.Id);
    a(paramSnsAdTimelineVideoView, str1, -1, paramInt);
    String str2 = ao.jo(ag.getAccSnsPath(), parambyn.Id);
    String str3 = com.tencent.mm.plugin.sns.data.q.d(parambyn);
    Object localObject;
    b localb;
    if (!i.fv(str2 + str3))
    {
      localObject = new m(parambyn);
      ((m)localObject).zds = 1;
      ((m)localObject).dwW = parambyn.Id;
      localb = ag.dTZ();
      if (parambyn.nEf != 6) {
        break label293;
      }
    }
    label293:
    for (paramInt = 5;; paramInt = 1)
    {
      localb.a(parambyn, paramInt, (m)localObject, parambj);
      localObject = "";
      if (paramBoolean) {
        localObject = a(paramp, parambyn, parambj, paramBoolean);
      }
      ad.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean) });
      if ((bt.isNullOrNil((String)localObject)) || (u(parambyn))) {
        break;
      }
      if (!((String)localObject).equals(paramSnsAdTimelineVideoView.getVideoPath()))
      {
        paramSnsAdTimelineVideoView.setThumbBmp(com.tencent.mm.sdk.platformtools.g.decodeFile(str2 + str3));
        ad.i("MicroMsg.SnsAdTimelineVideoView", "showVideoThumb:true");
        paramSnsAdTimelineVideoView.c(false, 0.0F);
      }
      paramSnsAdTimelineVideoView.setVideoPath((String)localObject);
      AppMethodBeat.o(179081);
      return true;
    }
    ad.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, sightPath %s", new Object[] { localObject });
    paramSnsAdTimelineVideoView.setVideoPath(null);
    paramSnsAdTimelineVideoView.clear();
    paramp = ayI(str1);
    paramBoolean = com.tencent.mm.plugin.sns.data.q.b(paramp);
    ad.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      paramSnsAdTimelineVideoView.setThumbBmp(null);
      if (this.zgs.contains(str1))
      {
        AppMethodBeat.o(179081);
        return false;
      }
      a(1, parambyn, parambj);
      AppMethodBeat.o(179081);
      return false;
    }
    a(paramSnsAdTimelineVideoView, str1, paramp);
    AppMethodBeat.o(179081);
    return true;
  }
  
  public final boolean a(p paramp, byn parambyn, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bj parambj, boolean paramBoolean)
  {
    AppMethodBeat.i(176251);
    paramBoolean = a(paramp, parambyn, paramVideoSightView, paramInt1, paramInt2, parambj, paramBoolean, false);
    AppMethodBeat.o(176251);
    return paramBoolean;
  }
  
  public final boolean a(p paramp, byn parambyn, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bj parambj, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176252);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(176252);
      return false;
    }
    String str1 = com.tencent.mm.plugin.sns.data.q.bZ(1, parambyn.Id);
    a(paramVideoSightView, str1, -1, paramInt1);
    String str2 = ao.jo(ag.getAccSnsPath(), parambyn.Id);
    String str3 = com.tencent.mm.plugin.sns.data.q.d(parambyn);
    Object localObject;
    if (!i.fv(str2 + str3))
    {
      localObject = new m(parambyn);
      ((m)localObject).zds = 1;
      ((m)localObject).dwW = parambyn.Id;
      b localb = ag.dTZ();
      if (parambyn.nEf == 6)
      {
        paramInt1 = 5;
        localb.a(parambyn, paramInt1, (m)localObject, parambj);
      }
    }
    else
    {
      localObject = "";
      if (paramBoolean1) {
        localObject = a(paramp, parambyn, parambj, paramBoolean1);
      }
      ad.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean1) });
      if ((bt.isNullOrNil((String)localObject)) || (u(parambyn))) {
        break label302;
      }
      if (!((String)localObject).equals(paramVideoSightView.getVideoPath())) {
        if (!paramBoolean2) {
          break label297;
        }
      }
    }
    label297:
    for (paramp = com.tencent.mm.sdk.platformtools.g.decodeFile(str2 + str3);; paramp = null)
    {
      paramVideoSightView.setThumbBmp(paramp);
      paramVideoSightView.setVideoPath((String)localObject);
      paramVideoSightView.setPosition(paramInt2);
      AppMethodBeat.o(176252);
      return true;
      paramInt1 = 1;
      break;
    }
    label302:
    ad.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject });
    paramVideoSightView.setVideoPath(null);
    paramVideoSightView.clear();
    paramp = ayI(str1);
    paramBoolean1 = com.tencent.mm.plugin.sns.data.q.b(paramp);
    ad.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!paramBoolean1)
    {
      paramVideoSightView.setPosition(0);
      paramVideoSightView.setThumbBmp(null);
      if (this.zgs.contains(str1))
      {
        AppMethodBeat.o(176252);
        return false;
      }
      a(1, parambyn, parambj);
      AppMethodBeat.o(176252);
      return false;
    }
    a(paramVideoSightView, str1, paramp);
    AppMethodBeat.o(176252);
    return true;
  }
  
  public final boolean a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt)
  {
    AppMethodBeat.i(179080);
    a(paramSnsAdTimelineVideoView, "", -1, paramInt);
    paramSnsAdTimelineVideoView.setThumbBmp(null);
    paramSnsAdTimelineVideoView.clear();
    AppMethodBeat.o(179080);
    return true;
  }
  
  public final boolean a(VideoSightView paramVideoSightView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176250);
    a(paramVideoSightView, "", -1, paramInt1);
    paramVideoSightView.setThumbBmp(null);
    paramVideoSightView.e(null, false, paramInt2);
    AppMethodBeat.o(176250);
    return true;
  }
  
  public final boolean a(byn parambyn, View paramView, int paramInt1, int paramInt2, bj parambj, int paramInt3)
  {
    AppMethodBeat.i(95507);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95507);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.q.bZ(paramInt3, parambyn.Id);
    a(paramView, str, paramInt1, paramInt2);
    com.tencent.mm.memory.n localn = ayI(str);
    boolean bool = com.tencent.mm.plugin.sns.data.q.b(localn);
    ad.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        eT(paramView);
      }
      if (this.zgs.contains(str))
      {
        AppMethodBeat.o(95507);
        return true;
      }
      a(paramInt3, parambyn, parambj);
      AppMethodBeat.o(95507);
      return false;
    }
    a(paramView, str, localn);
    AppMethodBeat.o(95507);
    return true;
  }
  
  public final boolean a(String paramString, com.tencent.mm.memory.n paramn, int paramInt)
  {
    AppMethodBeat.i(95533);
    a(paramInt + "-" + paramString, paramn);
    AppMethodBeat.o(95533);
    return true;
  }
  
  public final void aD(Activity paramActivity)
  {
    AppMethodBeat.i(95486);
    ad.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.iaj.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.zge.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (as(paramActivity.getWindow().getDecorView(), ((c)localObject3).code)) {
        ((List)localObject1).add(Integer.valueOf(((c)localObject3).code));
      }
    }
    localObject2 = ((List)localObject1).iterator();
    int i;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label211;
      }
      i = ((Integer)((Iterator)localObject2).next()).intValue();
      this.iaj.remove(Integer.valueOf(i));
      localObject3 = this.zge.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        c localc = (c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.zge.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.zge.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (((c)localObject3).zgU == paramActivity.hashCode()) {
        ((List)localObject1).add(Integer.valueOf(((c)localObject3).code));
      }
    }
    paramActivity = ((List)localObject1).iterator();
    for (;;)
    {
      if (!paramActivity.hasNext()) {
        break label371;
      }
      i = ((Integer)paramActivity.next()).intValue();
      this.iaj.remove(Integer.valueOf(i));
      localObject1 = this.zge.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (((c)localObject2).code != i) {
          break;
        }
        this.zge.remove(localObject2);
      }
    }
    label371:
    this.zfZ.dUF();
    ad.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.iaj.size());
    AppMethodBeat.o(95486);
  }
  
  public final void ayL(String paramString)
  {
    AppMethodBeat.i(95536);
    b(paramString, null);
    AppMethodBeat.o(95536);
  }
  
  public final com.tencent.mm.memory.n ayM(String paramString)
  {
    AppMethodBeat.i(95537);
    if (this.zfY == null)
    {
      AppMethodBeat.o(95537);
      return null;
    }
    paramString = (com.tencent.mm.memory.n)this.zfY.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95537);
    return paramString;
  }
  
  public final int b(p paramp, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95522);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (bt.aO(this.zgj) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      c.aGN();
      if (!c.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.zgp = 5;
      if (paramArrayOfInt != null) {
        if (((PInt)localObject).value != 0) {
          break label139;
        }
      }
    }
    label130:
    label139:
    for (int i = 0;; i = 1)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = localPInt.value;
      this.zgq = ((PInt)localObject).value;
      this.zgj = bt.HI();
      if ((this.zgq != 0) && (paramp != null)) {
        break label144;
      }
      i = this.zgp;
      AppMethodBeat.o(95522);
      return i;
      this.zgp = 10;
      break;
    }
    label144:
    if (this.zgr.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.zgr.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = new dgh();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.zgp;
        AppMethodBeat.o(95522);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.HuB == null) || (paramArrayOfInt.HuB.info == null))
      {
        i = this.zgk;
        AppMethodBeat.o(95522);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ad.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.zgp;
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.HuB.info;
    i = paramArrayOfInt.hashCode();
    if (this.zgq == 1)
    {
      if (!this.zgo.containsKey(Integer.valueOf(i))) {
        this.zgo.put(Integer.valueOf(i), Boolean.valueOf(eR(paramArrayOfInt, this.zgq)));
      }
      if (((Boolean)this.zgo.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ad.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.zgr.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95522);
        return i;
      }
    }
    if (!this.zgn.containsKey(Integer.valueOf(i))) {
      this.zgn.put(Integer.valueOf(i), Boolean.valueOf(eR(paramArrayOfInt, this.zgq)));
    }
    if (((Boolean)this.zgn.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final void b(byn parambyn, View paramView, int paramInt, bj parambj)
  {
    AppMethodBeat.i(95490);
    a(parambyn, paramView, -1, paramInt, parambj);
    AppMethodBeat.o(95490);
  }
  
  protected final void b(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(95547);
    com.tencent.mm.memory.n localn = paramn;
    if (!com.tencent.mm.plugin.sns.data.q.b(paramn)) {
      localn = ayJ(paramString);
    }
    if (com.tencent.mm.plugin.sns.data.q.b(localn))
    {
      if ((this.zfY != null) && (localn != null) && (paramString != null)) {
        this.zfY.put(paramString, localn);
      }
      paramn = (LinkedList)this.zga.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((c)localObject).zgV) && (paramString != null) && (paramString.equals(((c)localObject).id)))
          {
            int i = ((c)localObject).code;
            localObject = (WeakReference)this.iaj.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.zgh != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.zgh.QU(i))) {
                      continue;
                    }
                  }
                }
                if ((com.tencent.mm.plugin.sns.data.q.b(localn)) && (localObject != null))
                {
                  a(localObject, paramString, localn);
                }
                else
                {
                  boolean bool1;
                  if (localn == null)
                  {
                    bool1 = true;
                    label266:
                    if (localObject != null) {
                      break label322;
                    }
                  }
                  label322:
                  for (boolean bool2 = true;; bool2 = false)
                  {
                    ad.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.plugin.sns.data.q.b(localn)) });
                    break;
                    bool1 = false;
                    break label266;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(95547);
  }
  
  public final boolean b(byn parambyn, View paramView, int paramInt1, int paramInt2, bj parambj)
  {
    AppMethodBeat.i(95506);
    boolean bool = a(parambyn, paramView, paramInt1, paramInt2, parambj, 1);
    AppMethodBeat.o(95506);
    return bool;
  }
  
  public final void c(byn parambyn, View paramView, int paramInt, bj parambj)
  {
    AppMethodBeat.i(95505);
    if ((parambyn == null) || (parambyn.Id == null) || (parambyn.Id.equals("")))
    {
      AppMethodBeat.o(95505);
      return;
    }
    String str = com.tencent.mm.plugin.sns.data.q.bZ(4, parambyn.Id);
    a(paramView, str, -1, paramInt);
    com.tencent.mm.memory.n localn = ayI(str);
    boolean bool = com.tencent.mm.plugin.sns.data.q.b(localn);
    ad.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      eT(paramView);
      if (!this.zgs.contains(str))
      {
        a(4, parambyn, parambj);
        AppMethodBeat.o(95505);
      }
    }
    else
    {
      a(paramView, str, localn);
    }
    AppMethodBeat.o(95505);
  }
  
  public final void d(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95544);
    a(paramView, null, true, -1, paramInt3, -1, -1, f.a.zgQ);
    if (paramInt1 != -1) {
      paramView.setBackgroundResource(paramInt1);
    }
    if (paramInt2 != -1)
    {
      if ((paramView instanceof QFadeImageView))
      {
        ((QFadeImageView)paramView).setImageResource(paramInt2);
        AppMethodBeat.o(95544);
        return;
      }
      if ((paramView instanceof ImageView))
      {
        ((ImageView)paramView).setImageDrawable(com.tencent.mm.cc.a.l(paramView.getContext(), paramInt2));
        AppMethodBeat.o(95544);
      }
    }
    else
    {
      if ((paramView instanceof QFadeImageView))
      {
        ((QFadeImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(2131099651)));
        AppMethodBeat.o(95544);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(2131099651)));
      }
    }
    AppMethodBeat.o(95544);
  }
  
  public final void dSB()
  {
    AppMethodBeat.i(95548);
    dTu();
    this.zgi = 0L;
    this.zgj = 0L;
    this.zgc.clear();
    this.zgd = false;
    AppMethodBeat.o(95548);
  }
  
  public final void dTu()
  {
    AppMethodBeat.i(95484);
    if (this.zfY != null)
    {
      this.iaj.clear();
      this.zfZ.zkW.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.zfY.putCount() + ";");
      localStringBuffer.append("missCount:" + this.zfY.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.zfY.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.zfY.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.zfY.evictionCount() + ";");
      ad.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.zfY.trimToSize(-1);
    }
    this.zfZ.dUF();
    System.gc();
    AppMethodBeat.o(95484);
  }
  
  public final void eR(View paramView)
  {
    AppMethodBeat.i(95487);
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageBitmap(null);
      AppMethodBeat.o(95487);
      return;
    }
    if ((paramView instanceof QImageView))
    {
      ((QImageView)paramView).setImageBitmap(null);
      AppMethodBeat.o(95487);
      return;
    }
    AppMethodBeat.o(95487);
  }
  
  public final boolean eU(View paramView)
  {
    AppMethodBeat.i(95514);
    int i = paramView.hashCode();
    paramView = this.zge.iterator();
    while (paramView.hasNext())
    {
      c localc = (c)paramView.next();
      if (i == localc.code) {
        this.zge.remove(localc);
      }
    }
    this.iaj.remove(Integer.valueOf(i));
    AppMethodBeat.o(95514);
    return true;
  }
  
  public final boolean jl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95532);
    if ((this.zgf.containsKey(paramString1)) && (3 == ((Integer)this.zgf.get(paramString1)).intValue())) {
      this.zgf.remove(paramString1);
    }
    String str = com.tencent.mm.plugin.sns.data.q.bZ(1, paramString1);
    ad.i("MicroMsg.LazyerImageLoader2", "TimeLineAdPreloadHelper, download video complete, mediaId=" + paramString1 + ", path=" + paramString2);
    Object localObject1 = (LinkedList)this.zga.get(str);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95532);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((c)localObject2).zgV) && (str != null) && (str.equals(((c)localObject2).id)))
      {
        int i = ((c)localObject2).code;
        localObject2 = (WeakReference)this.iaj.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            aq localaq;
            if ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a))
            {
              ad.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
              if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof aq))
              {
                localaq = (aq)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
                boolean bool;
                if (localaq != null)
                {
                  if (i.fv(paramString2))
                  {
                    if (!this.zfK) {}
                    for (bool = true;; bool = false)
                    {
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).e(paramString2, bool, localaq.position);
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localaq.position);
                      localaq.zWB.setVisibility(8);
                      localaq.zFD.setVisibility(8);
                      localaq.zFE.setVisibility(8);
                      ayK(paramString1);
                      break;
                    }
                  }
                  setError(paramString1);
                  localaq.zWB.setVisibility(8);
                  localaq.zFD.setImageResource(2131234034);
                  localaq.zFD.setVisibility(0);
                }
                else
                {
                  if (!this.zfK) {}
                  for (bool = true;; bool = false)
                  {
                    ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).e(paramString2, bool, 0);
                    break;
                  }
                }
              }
            }
            else if ((localObject2 instanceof SnsAdTimelineVideoView))
            {
              ad.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (SnsAdTimelineVideoView)localObject2;
              if ((((SnsAdTimelineVideoView)localObject2).getTag() instanceof aq))
              {
                localaq = (aq)((SnsAdTimelineVideoView)localObject2).getTag();
                if (localaq != null)
                {
                  if (i.fv(paramString2))
                  {
                    ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                    ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                    localaq.zWB.setVisibility(8);
                    localaq.zFD.setVisibility(8);
                    localaq.zFE.setVisibility(8);
                    ayK(paramString1);
                  }
                  else
                  {
                    setError(paramString1);
                    localaq.zWB.setVisibility(8);
                    localaq.zFD.setImageResource(2131234034);
                    localaq.zFD.setVisibility(0);
                  }
                }
                else
                {
                  ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                  ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(95532);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(95482);
    this.zfK = false;
    b localb = ag.dTZ();
    localb.zfK = false;
    Object localObject3;
    synchronized (localb.mLock)
    {
      localObject2 = new LinkedList();
      localObject3 = localb.fVg.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.sns.data.n localn = (com.tencent.mm.plugin.sns.data.n)((Iterator)localObject3).next();
        if (localn.requestType != 6)
        {
          localb.zfN.remove(localn.key);
          ((LinkedList)localObject2).add(localn);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.sns.data.n)((Iterator)localObject2).next();
      localObject1.fVg.remove(localObject3);
    }
    localObject1.zfO.clear();
    localObject1.zfP.clear();
    AppMethodBeat.o(95482);
  }
  
  public final int s(p paramp)
  {
    AppMethodBeat.i(95519);
    int i = a(paramp, null);
    AppMethodBeat.o(95519);
    return i;
  }
  
  public final void start()
  {
    AppMethodBeat.i(95481);
    this.zfK = true;
    dTv();
    b localb = ag.dTZ();
    localb.zfK = true;
    localb.aHZ();
    AppMethodBeat.o(95481);
  }
  
  public final int t(p paramp)
  {
    AppMethodBeat.i(221345);
    int i = b(paramp, null);
    AppMethodBeat.o(221345);
    return i;
  }
  
  public final boolean u(byn parambyn)
  {
    AppMethodBeat.i(95524);
    if (!this.zgf.containsKey(parambyn.Id))
    {
      AppMethodBeat.o(95524);
      return false;
    }
    if (((Integer)this.zgf.get(parambyn.Id)).intValue() == 1)
    {
      AppMethodBeat.o(95524);
      return true;
    }
    AppMethodBeat.o(95524);
    return false;
  }
  
  public final boolean v(byn parambyn)
  {
    AppMethodBeat.i(95525);
    if (!this.zgf.containsKey(parambyn.Id))
    {
      AppMethodBeat.o(95525);
      return false;
    }
    if (((Integer)this.zgf.get(parambyn.Id)).intValue() == 2)
    {
      AppMethodBeat.o(95525);
      return true;
    }
    AppMethodBeat.o(95525);
    return false;
  }
  
  public final boolean w(byn parambyn)
  {
    AppMethodBeat.i(95526);
    if (!this.zgf.containsKey(parambyn.Id))
    {
      AppMethodBeat.o(95526);
      return false;
    }
    if (((Integer)this.zgf.get(parambyn.Id)).intValue() == 3)
    {
      AppMethodBeat.o(95526);
      return true;
    }
    AppMethodBeat.o(95526);
    return false;
  }
  
  public final boolean x(byn parambyn)
  {
    AppMethodBeat.i(95527);
    if (!this.zgf.containsKey(parambyn.Id))
    {
      AppMethodBeat.o(95527);
      return false;
    }
    if (((Integer)this.zgf.get(parambyn.Id)).intValue() == 4)
    {
      AppMethodBeat.o(95527);
      return true;
    }
    AppMethodBeat.o(95527);
    return false;
  }
  
  public final void y(byn parambyn)
  {
    AppMethodBeat.i(95528);
    this.zgf.put(parambyn.Id, Integer.valueOf(1));
    AppMethodBeat.o(95528);
  }
  
  public final void z(byn parambyn)
  {
    AppMethodBeat.i(95529);
    this.zgf.put(parambyn.Id, Integer.valueOf(2));
    AppMethodBeat.o(95529);
  }
  
  final class b
    extends g<String, Integer, Boolean>
  {
    private byn dIQ;
    private com.tencent.mm.memory.n hxN;
    private String irF;
    String key;
    private String path;
    private int zgT;
    
    public b(String paramString1, String paramString2, String paramString3, byn parambyn, int paramInt)
    {
      AppMethodBeat.i(95474);
      this.key = "";
      this.hxN = null;
      this.zgT = 0;
      f.this.zgs.add(paramString1);
      this.key = paramString1;
      this.path = paramString2;
      this.irF = paramString3;
      this.dIQ = parambyn;
      this.zgT = paramInt;
      f.dsl();
      ad.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(f.bcY()) });
      AppMethodBeat.o(95474);
    }
    
    private void aA(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(95475);
      i.fv(this.irF + paramString3);
      if (!i.fv(this.irF + paramString1))
      {
        String str = paramString2;
        if (!i.fv(this.irF + paramString2)) {
          str = com.tencent.mm.plugin.sns.data.q.l(this.dIQ);
        }
        boolean bool = u.a(this.irF, str, paramString1, ag.dUq());
        if (!bool)
        {
          ad.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
          i.deleteFile(this.irF + str);
        }
        ad.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.irF + str, this.irF + paramString1, Boolean.valueOf(bool) });
      }
      u.b(this.irF, paramString1, paramString3, ag.dUp());
      AppMethodBeat.o(95475);
    }
    
    private Boolean dTx()
    {
      AppMethodBeat.i(95476);
      f.a(f.this, true);
      Object localObject;
      if (!f.h(f.this))
      {
        ad.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      if (f.f(f.this).aM(this.key))
      {
        ad.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      i.aYu(this.irF);
      long l1 = System.currentTimeMillis();
      long l2;
      if (!i.fv(this.path))
      {
        aA(com.tencent.mm.plugin.sns.data.q.d(this.dIQ), com.tencent.mm.plugin.sns.data.q.k(this.dIQ), com.tencent.mm.plugin.sns.data.q.e(this.dIQ));
        l2 = bt.HI();
        if (this.zgT != 5) {
          break label769;
        }
        if (!i.fv(this.path)) {
          aA(com.tencent.mm.plugin.sns.data.q.d(this.dIQ), com.tencent.mm.plugin.sns.data.q.k(this.dIQ), com.tencent.mm.plugin.sns.data.q.e(this.dIQ));
        }
        bool1 = i.fv(this.irF + com.tencent.mm.plugin.sns.data.q.d(this.dIQ));
        boolean bool2 = i.fv(this.irF + com.tencent.mm.plugin.sns.data.q.k(this.dIQ));
        boolean bool3 = i.fv(this.irF + com.tencent.mm.plugin.sns.data.q.e(this.dIQ));
        this.hxN = com.tencent.mm.plugin.sns.data.q.aya(this.path);
        if (this.hxN == null)
        {
          ad.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = com.tencent.mm.plugin.sns.data.q.e(this.dIQ);
          this.hxN = com.tencent.mm.plugin.sns.lucky.a.a.jj(this.irF + (String)localObject, this.path);
          boolean bool4 = i.fv(this.path);
          ad.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
        }
        label427:
        long l3 = bt.aO(l2);
        int i = (int)i.aYo(this.path);
        if (bt.aO(f.i(f.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), ag.dUv(), com.tencent.mm.loader.j.b.arO() });
          f.b(f.this, bt.HI());
        }
        if (this.hxN == null)
        {
          ad.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.dIQ.Id });
          i.deleteFile(this.irF + com.tencent.mm.plugin.sns.data.q.e(this.dIQ));
          i.deleteFile(this.path);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 2L, 1L, true);
        }
        l3 = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 0L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 1L, l3 - l1, true);
        localObject = new StringBuilder("doInBackground decode %s and ");
        if (this.hxN != null) {
          break label872;
        }
      }
      label769:
      label872:
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.i("MicroMsg.ImageLoader", bool1 + " " + this.hxN + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
        localObject = Boolean.TRUE;
        AppMethodBeat.o(95476);
        return localObject;
        ad.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
        break;
        if (this.zgT == 4)
        {
          this.hxN = com.tencent.mm.plugin.sns.data.q.aya(this.path);
          if (this.hxN != null) {
            break label427;
          }
          ad.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = com.tencent.mm.plugin.sns.data.q.d(this.dIQ);
          this.hxN = com.tencent.mm.plugin.sns.lucky.a.a.jj(this.irF + (String)localObject, this.path);
          break label427;
        }
        this.hxN = com.tencent.mm.plugin.sns.data.q.ayc(this.path);
        break label427;
      }
    }
    
    public final ExecutorService dCe()
    {
      AppMethodBeat.i(179079);
      ExecutorService localExecutorService = ag.dTP();
      AppMethodBeat.o(179079);
      return localExecutorService;
    }
  }
  
  static final class c
  {
    public int code;
    public String id;
    public int zgU;
    public boolean zgV;
    
    public c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.id = paramString;
      this.code = paramInt1;
      this.zgU = paramInt2;
      this.zgV = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(95480);
      if ((paramObject != null) && (paramObject.hashCode() == this.code))
      {
        AppMethodBeat.o(95480);
        return true;
      }
      AppMethodBeat.o(95480);
      return false;
    }
    
    public final int hashCode()
    {
      return this.code;
    }
  }
  
  public static abstract interface d
  {
    public abstract void f(Bitmap paramBitmap, String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void al(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.f
 * JD-Core Version:    0.7.0.1
 */
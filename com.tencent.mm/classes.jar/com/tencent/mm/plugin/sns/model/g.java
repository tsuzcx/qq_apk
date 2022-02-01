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
import com.tencent.mm.b.f.b;
import com.tencent.mm.emoji.loader.d.i.c;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.memory.a.b.a;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.o;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ac;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.s;
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

public final class g
  implements com.tencent.mm.plugin.sns.b.g
{
  private static int DHs = 0;
  public boolean DGJ;
  private long DGV;
  private long DGW;
  com.tencent.mm.memory.a.b<com.tencent.mm.memory.n> DGX;
  private ap<String, WeakReference<Bitmap>> DGY;
  private Map<String, LinkedList<WeakReference<c>>> DGZ;
  private ConcurrentHashMap<Integer, String> DHa;
  private LinkedList<b> DHb;
  private boolean DHc;
  private HashSet<c> DHd;
  public HashMap<String, Integer> DHe;
  private int DHf;
  public ac DHg;
  public long DHh;
  public long DHi;
  private int DHj;
  private int DHk;
  private HashMap<Long, Integer> DHl;
  private HashMap<Integer, Boolean> DHm;
  private HashMap<Integer, Boolean> DHn;
  private int DHo;
  private int DHp;
  private HashMap<Long, Integer> DHq;
  protected Set<String> DHr;
  private Map<Integer, WeakReference<Object>> iXZ;
  
  public g()
  {
    AppMethodBeat.i(95483);
    this.DGV = 0L;
    this.DGW = 0L;
    this.iXZ = new HashMap();
    this.DGZ = new HashMap();
    this.DHa = new ConcurrentHashMap();
    this.DHb = new LinkedList();
    this.DHc = false;
    this.DHd = new HashSet();
    this.DHe = new HashMap();
    this.DHf = 4;
    this.DGJ = true;
    this.DHh = 0L;
    this.DHi = 0L;
    this.DHj = 0;
    this.DHk = 0;
    this.DHl = new HashMap();
    this.DHm = new HashMap();
    this.DHn = new HashMap();
    this.DHo = 0;
    this.DHp = 0;
    this.DHq = new HashMap();
    this.DHr = new HashSet();
    com.tencent.mm.memory.a.b.a(com.tencent.mm.memory.n.class, new b.a() {});
    int i = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    Log.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.DGX = new com.tencent.mm.memory.a.b(i, new f.b() {}, getClass());
      this.DGY = new ap(this.DHf, new ap.a()
      {
        public final boolean dQ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(95463);
          String str = (String)paramAnonymousObject;
          Object localObject;
          if (g.a(g.this, str)) {
            localObject = g.a(g.this);
          }
          for (;;)
          {
            try
            {
              paramAnonymousObject = ((ap.b)((ap)localObject).DMl.get(str)).obj;
              if (!(paramAnonymousObject instanceof Bitmap)) {
                continue;
              }
              paramAnonymousObject = (Bitmap)paramAnonymousObject;
              if ((paramAnonymousObject != null) && (!paramAnonymousObject.isRecycled()))
              {
                Log.d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
                paramAnonymousObject.recycle();
              }
            }
            catch (Exception paramAnonymousObject)
            {
              int i;
              Log.printErrStackTrace("MicroMsg.SnsLRUMap", paramAnonymousObject, "", new Object[0]);
              Log.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
              continue;
              boolean bool = false;
              continue;
            }
            i = ((ap)localObject).DMl.size();
            paramAnonymousObject = ((ap)localObject).DMl.remove(str);
            localObject = new StringBuilder("internalMap ").append(((ap)localObject).DMl.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              Log.d("MicroMsg.SnsLRUMap", bool);
              Log.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(g.this).DMl.size() + " listPaitSize:" + g.b(g.this).size());
              AppMethodBeat.o(95463);
              return true;
              paramAnonymousObject = (WeakReference)((ap.b)((ap)localObject).DMl.get(str)).obj;
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
  
  public static String D(cnb paramcnb)
  {
    AppMethodBeat.i(95541);
    if (paramcnb == null)
    {
      AppMethodBeat.o(95541);
      return null;
    }
    if (paramcnb.Id.startsWith("pre_temp_sns_pic")) {
      paramcnb = aj.getAccSnsTmpPath() + paramcnb.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(95541);
      return paramcnb;
      if (paramcnb.Id.startsWith("Locall_path")) {
        paramcnb = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.m(paramcnb);
      } else if (paramcnb.Id.startsWith("pre_temp_extend_pic")) {
        paramcnb = paramcnb.Id.substring(19);
      } else {
        paramcnb = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.d(paramcnb);
      }
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, bp parambp)
  {
    AppMethodBeat.i(95538);
    if ((!paramBoolean) && (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    cnb localcnb = com.tencent.mm.modelsns.n.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    com.tencent.mm.plugin.sns.data.r.cq(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = com.tencent.mm.plugin.sns.data.r.aOp(paramString1);
      if (com.tencent.mm.plugin.sns.data.r.M(paramString1))
      {
        AppMethodBeat.o(95538);
        return paramString1;
      }
      AppMethodBeat.o(95538);
      return null;
    }
    if (com.tencent.mm.plugin.sns.data.r.M(null))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.sns.data.r.l(localcnb);
    localObject = com.tencent.mm.plugin.sns.data.r.aOp(ar.ki(aj.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!com.tencent.mm.plugin.sns.data.r.M((Bitmap)localObject)) {
      paramString3 = com.tencent.mm.plugin.sns.data.r.aOp(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!Util.isNullOrNil(paramString2))) {
      aj.faJ().a(localcnb, 3, null, parambp);
    }
    if (!com.tencent.mm.plugin.sns.data.r.M(paramString3))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    AppMethodBeat.o(95538);
    return paramString3;
  }
  
  private String a(SnsInfo paramSnsInfo, final cnb paramcnb, final bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(95531);
    if (v(paramcnb))
    {
      AppMethodBeat.o(95531);
      return "";
    }
    String str1 = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    String str2 = com.tencent.mm.plugin.sns.data.r.j(paramcnb);
    if (s.YS(str1 + str2))
    {
      paramSnsInfo = str1 + str2;
      AppMethodBeat.o(95531);
      return paramSnsInfo;
    }
    if ((s.YS(str1 + com.tencent.mm.plugin.sns.data.r.p(paramcnb))) && (paramcnb.Id != null) && (paramcnb.Id.startsWith("Locall_path")))
    {
      paramSnsInfo = str1 + com.tencent.mm.plugin.sns.data.r.p(paramcnb);
      AppMethodBeat.o(95531);
      return paramSnsInfo;
    }
    if (!this.DGJ)
    {
      AppMethodBeat.o(95531);
      return "";
    }
    Log.i("MicroMsg.LazyerImageLoader2", "push sight loader " + paramcnb.Id + " url: " + paramcnb.Url);
    if (paramBoolean) {
      if (b(paramSnsInfo, null) == 5) {
        aj.dRd().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95470);
            aj.faJ().a(paramcnb, 4, null, parambp);
            AppMethodBeat.o(95470);
          }
        }, 0L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95531);
      return "";
      Log.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
    }
  }
  
  private void a(View paramView, String paramString, int paramInt, g.a parama)
  {
    AppMethodBeat.i(95509);
    a(paramView, paramString, true, -1, paramInt, -1, -1, parama);
    AppMethodBeat.o(95509);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95510);
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, g.a.DHP);
    AppMethodBeat.o(95510);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95512);
    a(paramObject, paramString, false, -1, paramInt1, paramInt2, paramInt3, g.a.DHP);
    AppMethodBeat.o(95512);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, g.a parama)
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
      Log.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.aSf() });
    }
    Object localObject;
    long l1;
    if ((paramObject instanceof QFadeImageView))
    {
      paramObject = (QFadeImageView)paramObject;
      localObject = paramObject.getDrawable();
      l1 = l2;
      if (!Util.isNullOrNil(paramObject.getImageKey()))
      {
        l1 = l2;
        if (paramObject.getImageKey().equals(paramString)) {
          l1 = paramObject.getStartTimeMillis();
        }
      }
      if ((localObject == null) || (!(localObject instanceof am))) {
        break label468;
      }
      l1 = ((am)localObject).DMd;
    }
    label454:
    label468:
    for (;;)
    {
      paramn = new am(paramString, paramn, l1);
      paramObject.T(paramn.DMd, paramString);
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
        if ((paramObject != null) && ((paramObject instanceof am))) {}
        for (paramObject = new am(paramString, paramn, ((am)paramObject).DMd);; paramObject = new am(paramString, paramn, 0L))
        {
          ((ImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof com.tencent.mm.plugin.sight.decode.a.a))
      {
        Log.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(paramString)));
        if ((paramObject instanceof SightPlayImageView))
        {
          localObject = (SightPlayImageView)paramObject;
          paramObject = ((SightPlayImageView)localObject).getDrawable();
          if ((paramObject == null) || (!(paramObject instanceof am))) {
            break label361;
          }
        }
        label361:
        for (paramObject = new am(paramString, paramn, ((am)paramObject).DMd);; paramObject = new am(paramString, paramn, 0L))
        {
          ((SightPlayImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof SnsAdTimelineVideoView))
      {
        Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setImageDrawable, key=".concat(String.valueOf(paramString)));
        localObject = (SnsAdTimelineVideoView)paramObject;
        paramObject = ((SnsAdTimelineVideoView)localObject).getThumbDrawable();
        if ((paramObject == null) || (!(paramObject instanceof am))) {
          break label454;
        }
      }
      for (paramObject = new am(paramString, paramn, ((am)paramObject).DMd);; paramObject = new am(paramString, paramn, 0L))
      {
        ((SnsAdTimelineVideoView)localObject).setThumbDrawable(paramObject);
        paramObject.invalidateSelf();
        AppMethodBeat.o(95498);
        return;
      }
    }
  }
  
  private void a(Object paramObject, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, g.a parama)
  {
    AppMethodBeat.i(95513);
    if (paramObject == null)
    {
      AppMethodBeat.o(95513);
      return;
    }
    int i = paramObject.hashCode();
    this.DHd.remove(new c(null, i, 0, false));
    c localc = new c(paramString, i, paramInt2, paramBoolean);
    this.DHd.add(localc);
    LinkedList localLinkedList = (LinkedList)this.DGZ.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.DGZ.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.DGZ.get(localObject);
      if (localLinkedList != null)
      {
        paramInt2 = 0;
        if (paramInt2 >= localLinkedList.size()) {
          break label494;
        }
        localc = (c)((WeakReference)localLinkedList.get(paramInt2)).get();
        if ((localc == null) || (localc.code != i)) {
          break label343;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != -1)
      {
        Log.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[] { localObject });
        localLinkedList.remove(paramInt2);
      }
      ((View)paramObject).setTag(2130706432, paramString);
      localObject = new WeakReference(paramObject);
      this.iXZ.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label352;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == g.a.DHQ) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
        {
          ForceGpuUtil.setLayerType((View)paramObject);
          AppMethodBeat.o(95513);
          return;
          label343:
          paramInt2 += 1;
          break;
          label352:
          if ((paramObject instanceof ImageView))
          {
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.cb.a.l(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.a.a)paramObject;
            if (!this.DGJ) {}
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
        ForceGpuUtil.decideLayerType((View)paramObject, paramInt3, paramInt4);
        Log.d("MicroMsg.LazyerImageLoader2", "try to setLayerType " + paramInt3 + " " + paramInt4);
      }
      AppMethodBeat.o(95513);
      return;
      label494:
      paramInt2 = -1;
    }
  }
  
  private boolean a(final int paramInt, final cnb paramcnb, final bp parambp)
  {
    AppMethodBeat.i(95517);
    if (!this.DGJ)
    {
      if ((paramcnb != null) && (!Util.isNullOrNil(paramcnb.Id))) {
        aj.faJ().aOS(paramcnb.Id);
      }
      AppMethodBeat.o(95517);
      return false;
    }
    aj.faB().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95469);
        com.tencent.mm.plugin.sns.data.n localn;
        c localc;
        cnb localcnb;
        if (!g.a(g.this, paramInt, paramcnb))
        {
          localn = new com.tencent.mm.plugin.sns.data.n(paramcnb);
          localn.DEs = paramInt;
          localn.dPI = paramcnb.Id;
          localc = aj.faJ();
          localcnb = paramcnb;
          if (paramcnb.oUv != 6) {
            break label97;
          }
        }
        label97:
        for (int i = 5;; i = 1)
        {
          localc.a(localcnb, i, localn, parambp);
          AppMethodBeat.o(95469);
          return;
        }
      }
    });
    AppMethodBeat.o(95517);
    return true;
  }
  
  public static boolean a(cnb paramcnb, bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(95540);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95540);
      return false;
    }
    Object localObject;
    if (paramcnb.Id.startsWith("Locall_path"))
    {
      localObject = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.m(paramcnb);
      if (s.YS((String)localObject)) {
        break label161;
      }
      localObject = aj.faJ();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 2)
    {
      ((c)localObject).a(paramcnb, i, null, parambp);
      AppMethodBeat.o(95540);
      return false;
      localObject = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.d(paramcnb);
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
      this.DGX.put(paramString, paramn);
    }
    AppMethodBeat.o(95534);
    return true;
  }
  
  private boolean a(final List<cnb> paramList, final bp parambp)
  {
    AppMethodBeat.i(95515);
    aj.faB().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95466);
        long l = Util.currentTicks();
        Object localObject = new com.tencent.mm.plugin.sns.data.n(paramList);
        ((com.tencent.mm.plugin.sns.data.n)localObject).dPI = com.tencent.mm.plugin.sns.data.r.gN(paramList);
        ((com.tencent.mm.plugin.sns.data.n)localObject).DEs = this.DHu;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          cnb localcnb = (cnb)paramList.get(j);
          if (aj.faJ().aON(localcnb.Id)) {
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
              } while (s.YS(ar.ki(aj.getAccSnsPath(), localcnb.Id) + com.tencent.mm.plugin.sns.data.r.e(localcnb)));
              i = k;
            } while (s.YS(ar.ki(aj.getAccSnsPath(), localcnb.Id) + com.tencent.mm.plugin.sns.data.r.l(localcnb)));
            i = k;
          } while (s.YS(ar.ki(aj.getAccSnsPath(), localcnb.Id) + com.tencent.mm.plugin.sns.data.r.m(localcnb)));
          c localc = aj.faJ();
          if (localcnb.oUv == 6) {}
          for (int i = 5;; i = 1)
          {
            localc.a(localcnb, i, (com.tencent.mm.plugin.sns.data.n)localObject, parambp);
            i = 0;
            break;
          }
        }
        l = Util.ticksToNow(l);
        if (l > 100L) {
          Log.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.aKD() + " " + aj.fbh() + " " + ((com.tencent.mm.plugin.sns.data.n)localObject).dPI);
        }
        if (Util.ticksToNow(g.c(g.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD() });
          g.a(g.this, Util.currentTicks());
        }
        localObject = com.tencent.mm.plugin.sns.data.r.gN(paramList);
        if (k != 0) {
          aj.dRd().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95465);
              new i(com.tencent.mm.plugin.sns.data.r.cq(0, this.LY), this.LY, g.9.this.DHL).y(new String[] { "" });
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
  
  private com.tencent.mm.memory.n aOV(String paramString)
  {
    AppMethodBeat.i(95492);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.DGX.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.DGX.remove(paramString);
      AppMethodBeat.o(95492);
      return null;
    }
    AppMethodBeat.o(95492);
    return localn;
  }
  
  private com.tencent.mm.memory.n aOW(String paramString)
  {
    AppMethodBeat.i(95493);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.DGX.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.DGX.remove(paramString);
      AppMethodBeat.o(95493);
      return null;
    }
    AppMethodBeat.o(95493);
    return localn;
  }
  
  private boolean aOX(String paramString)
  {
    AppMethodBeat.i(179083);
    if ((this.DHe.containsKey(paramString)) && (4 == ((Integer)this.DHe.get(paramString)).intValue())) {
      this.DHe.remove(paramString);
    }
    AppMethodBeat.o(179083);
    return true;
  }
  
  private boolean ax(View paramView, int paramInt)
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
      } while (!ax(paramView.getChildAt(j), paramInt));
      AppMethodBeat.o(95485);
      return true;
    }
    AppMethodBeat.o(95485);
    return false;
  }
  
  private void b(cnb paramcnb, View paramView, int paramInt, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95497);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95497);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.r.cq(5, paramcnb.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = aOV(str);
    if (!com.tencent.mm.plugin.sns.data.r.b(parama))
    {
      fh(paramView);
      if (this.DHr.contains(str))
      {
        AppMethodBeat.o(95497);
        return;
      }
      a(5, paramcnb, parambp);
      AppMethodBeat.o(95497);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95497);
  }
  
  private boolean fae()
  {
    AppMethodBeat.i(95516);
    if (this.DHc)
    {
      Log.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(95516);
      return false;
    }
    aj.dRd().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95467);
        if (g.d(g.this))
        {
          Log.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
          AppMethodBeat.o(95467);
          return;
        }
        if (g.e(g.this).size() > 0)
        {
          Log.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.e(g.this).size());
          ((g.b)g.e(g.this).removeLast()).y(new String[] { "" });
        }
        AppMethodBeat.o(95467);
      }
    }, 0L);
    AppMethodBeat.o(95516);
    return true;
  }
  
  private static void fh(View paramView)
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
  
  private static boolean fy(String paramString, int paramInt)
  {
    AppMethodBeat.i(95523);
    paramString = XmlParser.parseXml(paramString, "SightDownloadControl", null);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(95523);
      return true;
    }
    if (paramInt == 1)
    {
      if (Util.getInt((String)paramString.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1)
      {
        AppMethodBeat.o(95523);
        return true;
      }
      AppMethodBeat.o(95523);
      return false;
    }
    if (Util.getInt((String)paramString.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1)
    {
      AppMethodBeat.o(95523);
      return true;
    }
    AppMethodBeat.o(95523);
    return false;
  }
  
  public static String r(cnb paramcnb)
  {
    AppMethodBeat.i(95489);
    String str = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    paramcnb = com.tencent.mm.plugin.sns.data.r.e(paramcnb);
    paramcnb = str + paramcnb;
    AppMethodBeat.o(95489);
    return paramcnb;
  }
  
  public static String s(cnb paramcnb)
  {
    AppMethodBeat.i(95499);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95499);
      return null;
    }
    String str = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.e(paramcnb);
    if (!s.YS(str))
    {
      paramcnb = paramcnb.Msz;
      AppMethodBeat.o(95499);
      return paramcnb;
    }
    AppMethodBeat.o(95499);
    return str;
  }
  
  private void setError(String paramString)
  {
    AppMethodBeat.i(179084);
    this.DHe.put(paramString, Integer.valueOf(4));
    AppMethodBeat.o(179084);
  }
  
  public static String t(cnb paramcnb)
  {
    AppMethodBeat.i(95500);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95500);
      return null;
    }
    String str = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.d(paramcnb);
    if (!s.YS(str))
    {
      paramcnb = paramcnb.Url;
      AppMethodBeat.o(95500);
      return paramcnb;
    }
    AppMethodBeat.o(95500);
    return str;
  }
  
  public static boolean u(cnb paramcnb)
  {
    AppMethodBeat.i(95518);
    String str1 = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    String str2 = com.tencent.mm.plugin.sns.data.r.j(paramcnb);
    if (s.YS(str1 + str2))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    if ((s.YS(str1 + com.tencent.mm.plugin.sns.data.r.p(paramcnb))) && (!Util.isNullOrNil(paramcnb.Id)) && (paramcnb.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    AppMethodBeat.o(95518);
    return false;
  }
  
  public final int A(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(258597);
    int i = b(paramSnsInfo, null);
    AppMethodBeat.o(258597);
    return i;
  }
  
  public final void A(cnb paramcnb)
  {
    AppMethodBeat.i(95529);
    this.DHe.put(paramcnb.Id, Integer.valueOf(2));
    AppMethodBeat.o(95529);
  }
  
  public final void B(cnb paramcnb)
  {
    AppMethodBeat.i(95530);
    this.DHe.put(paramcnb.Id, Integer.valueOf(3));
    AppMethodBeat.o(95530);
  }
  
  public final boolean C(cnb paramcnb)
  {
    AppMethodBeat.i(95539);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95539);
      return false;
    }
    if (s.YS(ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.f(paramcnb)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    if (s.YS(ar.ki(aj.getAccSnsPath(), paramcnb.Id) + com.tencent.mm.plugin.sns.data.r.e(paramcnb)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    paramcnb = com.tencent.mm.plugin.sns.data.r.cq(1, paramcnb.Id);
    boolean bool = com.tencent.mm.plugin.sns.data.r.b((com.tencent.mm.memory.n)this.DGX.get(paramcnb));
    AppMethodBeat.o(95539);
    return bool;
  }
  
  public final int a(SnsInfo paramSnsInfo, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95520);
    Object localObject;
    PInt localPInt1;
    PInt localPInt2;
    if ((paramArrayOfInt != null) || (Util.ticksToNow(this.DHh) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      d.baW();
      if (!d.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.DHj = 5;
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
      this.DHk = ((PInt)localObject).value;
      this.DHh = Util.currentTicks();
      if ((this.DHk != 0) && (paramSnsInfo != null)) {
        break label163;
      }
      i = this.DHj;
      AppMethodBeat.o(95520);
      return i;
      this.DHj = 10;
      break;
    }
    label163:
    if (this.DHl.containsKey(Long.valueOf(paramSnsInfo.field_snsId)))
    {
      i = ((Integer)this.DHl.get(Long.valueOf(paramSnsInfo.field_snsId))).intValue();
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = new eaj();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.DHj;
        AppMethodBeat.o(95520);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.MZL == null) || (paramArrayOfInt.MZL.info == null))
      {
        i = this.DHj;
        AppMethodBeat.o(95520);
        return i;
      }
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramSnsInfo, "", new Object[0]);
      i = this.DHj;
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.MZL.info;
    i = paramArrayOfInt.hashCode();
    if (this.DHk == 1)
    {
      if (!this.DHn.containsKey(Integer.valueOf(i))) {
        this.DHn.put(Integer.valueOf(i), Boolean.valueOf(fy(paramArrayOfInt, this.DHk)));
      }
      if (((Boolean)this.DHn.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        Log.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i) });
        this.DHl.put(Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95520);
        return i;
      }
    }
    if (!this.DHm.containsKey(Integer.valueOf(i))) {
      this.DHm.put(Integer.valueOf(i), Boolean.valueOf(fy(paramArrayOfInt, this.DHk)));
    }
    if (((Boolean)this.DHm.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final com.tencent.mm.memory.n a(cnb paramcnb, ImageView paramImageView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95543);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95543);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.r.cq(0, paramcnb.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = aOV(str);
    if (!com.tencent.mm.plugin.sns.data.r.b(paramImageView))
    {
      a(0, paramcnb, parambp);
      AppMethodBeat.o(95543);
      return null;
    }
    AppMethodBeat.o(95543);
    return paramImageView;
  }
  
  public final void a(cnb paramcnb, View paramView, int paramInt1, int paramInt2, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95496);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95496);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.r.cq(0, paramcnb.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = aOV(str);
    if (!com.tencent.mm.plugin.sns.data.r.b(parama))
    {
      Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        fh(paramView);
      }
      if (this.DHr.contains(str))
      {
        AppMethodBeat.o(95496);
        return;
      }
      a(0, paramcnb, parambp);
      AppMethodBeat.o(95496);
      return;
    }
    Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    aj.faJ().aOS(paramcnb.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(95496);
  }
  
  public final void a(cnb paramcnb, View paramView, int paramInt1, int paramInt2, bp parambp)
  {
    AppMethodBeat.i(95494);
    a(paramcnb, paramView, paramInt1, paramInt2, g.a.DHP, parambp);
    AppMethodBeat.o(95494);
  }
  
  public final void a(cnb paramcnb, View paramView, int paramInt, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95491);
    a(paramcnb, paramView, -1, paramInt, parama, parambp);
    AppMethodBeat.o(95491);
  }
  
  public final void a(cnb paramcnb, View paramView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95501);
    b(paramcnb, paramView, -1, paramInt, parambp);
    AppMethodBeat.o(95501);
  }
  
  public final void a(final cnb paramcnb, final View paramView, final int paramInt, final boolean paramBoolean1, final bp parambp, final boolean paramBoolean2, final e parame)
  {
    AppMethodBeat.i(95542);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95542);
      return;
    }
    final String str1 = com.tencent.mm.plugin.sns.data.r.cq(3, paramcnb.Id);
    final String str2 = D(paramcnb);
    if (aj.faJ().aOO(paramcnb.Id))
    {
      Log.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + paramcnb.Id);
      a(paramView, str1, paramInt, -1, -1);
      parame.ax(null);
      AppMethodBeat.o(95542);
      return;
    }
    Object localObject1 = this.DGY;
    Object localObject2 = (ap.b)((ap)localObject1).DMl.get(str1);
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
      Log.i("MicroMsg.LazyerImageLoader2", bool);
      if (localObject1 != null) {
        break label292;
      }
    }
    label286:
    label292:
    for (localObject1 = null;; localObject1 = (Bitmap)((WeakReference)localObject1).get())
    {
      if (!com.tencent.mm.plugin.sns.data.r.M((Bitmap)localObject1)) {
        break label305;
      }
      Log.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
      a(paramView, str1, paramInt, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      parame.ax((Bitmap)localObject1);
      AppMethodBeat.o(95542);
      return;
      ((ap.b)((ap)localObject1).DMl.get(str1)).fbu();
      localObject1 = ((ap.b)localObject2).obj;
      break;
      bool = false;
      break label185;
    }
    label305:
    aj.faz().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95459);
        final Bitmap localBitmap = com.tencent.mm.plugin.sns.data.r.aOp(str2);
        aj.dRd().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95458);
            if (com.tencent.mm.plugin.sns.data.r.M(localBitmap))
            {
              g.a(g.this, g.4.this.DGe, g.4.this.DHx, g.4.this.DHy, localBitmap.getWidth(), localBitmap.getHeight());
              if (!com.tencent.mm.plugin.sns.data.r.M(localBitmap)) {
                break label252;
              }
              localObject1 = g.a(g.this);
              localObject2 = g.4.this.DHx;
              localObject3 = new WeakReference(localBitmap);
              if ((ap.b)((ap)localObject1).DMl.get(localObject2) != null) {
                break label215;
              }
              localObject3 = new ap.b((ap)localObject1, localObject3);
              ((ap)localObject1).DMl.put(localObject2, localObject3);
              ((ap)localObject1).fbt();
            }
            label215:
            label252:
            while (!g.4.this.DHz) {
              for (;;)
              {
                Object localObject3;
                if (g.4.this.DHC != null) {
                  g.4.this.DHC.ax(localBitmap);
                }
                AppMethodBeat.o(95458);
                return;
                g.a(g.this, g.4.this.DGe, g.4.this.DHx, g.4.this.DHy, -1, -1);
                break;
                ((ap.b)((ap)localObject1).DMl.get(localObject2)).fbu();
                ((ap.b)((ap)localObject1).DMl.get(localObject2)).obj = localObject3;
              }
            }
            Object localObject1 = aj.faJ();
            Object localObject2 = g.4.this.DyS;
            if (g.4.this.DHA) {}
            for (int i = 8;; i = 2)
            {
              ((c)localObject1).a((cnb)localObject2, i, null, g.4.this.DHB);
              break;
            }
          }
        });
        AppMethodBeat.o(95459);
      }
    });
    AppMethodBeat.o(95542);
  }
  
  public final void a(final String paramString, SparseArray<cnb> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, final bp parambp, final int paramInt2)
  {
    AppMethodBeat.i(95495);
    Log.i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
    if ((paramSparseArray == null) || (paramSparseArray.size() <= 0))
    {
      Log.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    if ((paramSparseArray1 == null) || (paramSparseArray1.size() <= 0))
    {
      Log.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    int j = paramSparseArray.size();
    int k = paramSparseArray1.size();
    if (j == k) {}
    for (int i = j; -1 == i; i = -1)
    {
      Log.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
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
      cnb localcnb = (cnb)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = com.tencent.mm.plugin.sns.data.r.cq(0, localcnb.Id);
      a(localView, str, -1, paramInt1, g.a.DHP);
      com.tencent.mm.memory.n localn = aOV(str);
      if (!com.tencent.mm.plugin.sns.data.r.b(localn))
      {
        Log.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        fh(localView);
        if (!this.DHr.contains(str)) {
          localSparseArray1.put(k, localcnb);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        Log.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
        a(localView, str, localn);
      }
    }
    if (localSparseArray1.size() != 0)
    {
      Log.i("MicroMsg.LazyerImageLoader2", "ok, let's download.");
      aj.faB().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95464);
          int j = localSparseArray1.size();
          int i = 0;
          while (i < j)
          {
            int k = localSparseArray1.keyAt(i);
            cnb localcnb = (cnb)localSparseArray1.get(k);
            if (!g.a(g.this, 0, localcnb))
            {
              com.tencent.mm.plugin.sns.data.n localn = new com.tencent.mm.plugin.sns.data.n(localcnb);
              localn.DEs = 0;
              localn.dPI = localcnb.Id;
              localSparseArray2.put(k, localn);
              localSparseArray3.put(k, localcnb);
            }
            i += 1;
          }
          if (localSparseArray3.size() > 0) {
            aj.faJ().a(paramString, localSparseArray3, localSparseArray2, parambp, paramInt2);
          }
          AppMethodBeat.o(95464);
        }
      });
    }
    AppMethodBeat.o(95495);
  }
  
  public final void a(List<cnb> paramList, View paramView, int paramInt, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95545);
    a(paramList, paramView, paramInt, parama, parambp, false);
    AppMethodBeat.o(95545);
  }
  
  public final void a(List<cnb> paramList, View paramView, int paramInt, g.a parama, bp parambp, boolean paramBoolean)
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
        b((cnb)paramList.get(0), paramView, paramInt, parambp);
        AppMethodBeat.o(95546);
        return;
      }
      b((cnb)paramList.get(0), paramView, paramInt, g.a.DHQ, parambp);
      AppMethodBeat.o(95546);
      return;
    }
    String str = com.tencent.mm.plugin.sns.data.r.cq(0, com.tencent.mm.plugin.sns.data.r.gN(paramList));
    a(paramView, str, paramInt, parama);
    parama = aOV(str);
    paramBoolean = com.tencent.mm.plugin.sns.data.r.b(parama);
    Log.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      fh(paramView);
      if (this.DHr.contains(str))
      {
        AppMethodBeat.o(95546);
        return;
      }
      new WeakReference(paramView);
      a(paramList, parambp);
      AppMethodBeat.o(95546);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95546);
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.data.n paramn, String paramString)
  {
    AppMethodBeat.i(95535);
    Object localObject1 = (cnb)paramn.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < paramn.list.size())
    {
      localObject2 = (cnb)paramn.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((cnb)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id);
      if (paramn.DEs == 0) {
        paramString = com.tencent.mm.plugin.sns.data.r.f((cnb)localObject1);
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.sns.data.r.cq(paramn.DEs, ((cnb)localObject1).Id);
        if (!this.DGX.check(str)) {
          new b(com.tencent.mm.plugin.sns.data.r.cq(paramn.DEs, ((cnb)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (cnb)localObject1, paramn.DEs).y(new String[] { "" });
        }
        AppMethodBeat.o(95535);
        return true;
        i += 1;
        break;
        if (paramn.DEs == 4) {
          paramString = com.tencent.mm.plugin.sns.data.r.g((cnb)localObject1);
        } else if (paramn.DEs == 5) {
          paramString = com.tencent.mm.plugin.sns.data.r.g((cnb)localObject1);
        } else if (paramn.DEs == 3) {
          paramString = com.tencent.mm.plugin.sns.data.r.l((cnb)localObject1);
        } else {
          paramString = com.tencent.mm.plugin.sns.data.r.e((cnb)localObject1);
        }
      }
    }
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cnb paramcnb, SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt, bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(179081);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(179081);
      return false;
    }
    String str1 = com.tencent.mm.plugin.sns.data.r.cq(1, paramcnb.Id);
    a(paramSnsAdTimelineVideoView, str1, -1, paramInt);
    String str2 = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    String str3 = com.tencent.mm.plugin.sns.data.r.e(paramcnb);
    Object localObject;
    c localc;
    if (!s.YS(str2 + str3))
    {
      localObject = new com.tencent.mm.plugin.sns.data.n(paramcnb);
      ((com.tencent.mm.plugin.sns.data.n)localObject).DEs = 1;
      ((com.tencent.mm.plugin.sns.data.n)localObject).dPI = paramcnb.Id;
      localc = aj.faJ();
      if (paramcnb.oUv != 6) {
        break label293;
      }
    }
    label293:
    for (paramInt = 5;; paramInt = 1)
    {
      localc.a(paramcnb, paramInt, (com.tencent.mm.plugin.sns.data.n)localObject, parambp);
      localObject = "";
      if (paramBoolean) {
        localObject = a(paramSnsInfo, paramcnb, parambp, paramBoolean);
      }
      Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean) });
      if ((Util.isNullOrNil((String)localObject)) || (v(paramcnb))) {
        break;
      }
      if (!((String)localObject).equals(paramSnsAdTimelineVideoView.getVideoPath()))
      {
        paramSnsAdTimelineVideoView.setThumbBmp(BitmapUtil.decodeFile(str2 + str3));
        Log.i("MicroMsg.SnsAdTimelineVideoView", "showVideoThumb:true");
        paramSnsAdTimelineVideoView.d(false, 0.0F);
      }
      paramSnsAdTimelineVideoView.setVideoPath((String)localObject);
      AppMethodBeat.o(179081);
      return true;
    }
    Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, sightPath %s", new Object[] { localObject });
    paramSnsAdTimelineVideoView.setVideoPath(null);
    paramSnsAdTimelineVideoView.clear();
    paramSnsInfo = aOV(str1);
    paramBoolean = com.tencent.mm.plugin.sns.data.r.b(paramSnsInfo);
    Log.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      paramSnsAdTimelineVideoView.setThumbBmp(null);
      if (this.DHr.contains(str1))
      {
        AppMethodBeat.o(179081);
        return false;
      }
      a(1, paramcnb, parambp);
      AppMethodBeat.o(179081);
      return false;
    }
    a(paramSnsAdTimelineVideoView, str1, paramSnsInfo);
    AppMethodBeat.o(179081);
    return true;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cnb paramcnb, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, int paramInt3, bp parambp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(202719);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(202719);
      return false;
    }
    String str1 = com.tencent.mm.plugin.sns.data.r.cq(1, paramcnb.Id);
    a(paramVideoSightView, str1, -1, paramInt2);
    String str2 = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    String str3 = com.tencent.mm.plugin.sns.data.r.e(paramcnb);
    Object localObject1;
    Object localObject2;
    if (!s.YS(str2 + str3))
    {
      localObject1 = new com.tencent.mm.plugin.sns.data.n(paramcnb);
      ((com.tencent.mm.plugin.sns.data.n)localObject1).DEs = 1;
      ((com.tencent.mm.plugin.sns.data.n)localObject1).dPI = paramcnb.Id;
      localObject2 = aj.faJ();
      if (paramcnb.oUv == 6)
      {
        paramInt1 = 5;
        ((c)localObject2).a(paramcnb, paramInt1, (com.tencent.mm.plugin.sns.data.n)localObject1, parambp);
      }
    }
    else
    {
      localObject2 = "";
      localObject1 = localObject2;
      if (paramBoolean1)
      {
        localObject1 = localObject2;
        if (paramBoolean3) {
          localObject1 = a(paramSnsInfo, paramcnb, parambp, paramBoolean1);
        }
      }
      Log.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject1, Boolean.valueOf(paramBoolean1) });
      if ((Util.isNullOrNil((String)localObject1)) || (v(paramcnb))) {
        break label315;
      }
      if (!((String)localObject1).equals(paramVideoSightView.getVideoPath())) {
        if (!paramBoolean2) {
          break label310;
        }
      }
    }
    label310:
    for (paramSnsInfo = BitmapUtil.decodeFile(str2 + str3);; paramSnsInfo = null)
    {
      paramVideoSightView.setThumbBmp(paramSnsInfo);
      paramVideoSightView.setVideoPath((String)localObject1);
      paramVideoSightView.setPosition(paramInt3);
      AppMethodBeat.o(202719);
      return true;
      paramInt1 = 1;
      break;
    }
    label315:
    Log.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject1 });
    paramVideoSightView.setVideoPath(null);
    paramVideoSightView.clear();
    paramSnsInfo = aOV(str1);
    paramBoolean1 = com.tencent.mm.plugin.sns.data.r.b(paramSnsInfo);
    Log.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!paramBoolean1)
    {
      paramVideoSightView.setPosition(0);
      paramVideoSightView.setThumbBmp(null);
      if (this.DHr.contains(str1))
      {
        AppMethodBeat.o(202719);
        return false;
      }
      a(1, paramcnb, parambp);
      AppMethodBeat.o(202719);
      return false;
    }
    a(paramVideoSightView, str1, paramSnsInfo);
    AppMethodBeat.o(202719);
    return true;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cnb paramcnb, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(176251);
    paramBoolean = a(paramSnsInfo, paramcnb, paramVideoSightView, paramInt1, paramInt2, parambp, paramBoolean, false);
    AppMethodBeat.o(176251);
    return paramBoolean;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cnb paramcnb, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bp parambp, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176252);
    paramBoolean1 = a(paramSnsInfo, paramcnb, paramVideoSightView, -1, paramInt1, paramInt2, parambp, paramBoolean1, paramBoolean2, true);
    AppMethodBeat.o(176252);
    return paramBoolean1;
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
  
  public final boolean a(cnb paramcnb, View paramView, int paramInt1, int paramInt2, bp parambp, int paramInt3)
  {
    AppMethodBeat.i(95507);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95507);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.r.cq(paramInt3, paramcnb.Id);
    a(paramView, str, paramInt1, paramInt2);
    com.tencent.mm.memory.n localn = aOV(str);
    boolean bool = com.tencent.mm.plugin.sns.data.r.b(localn);
    Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        fh(paramView);
      }
      if (this.DHr.contains(str))
      {
        AppMethodBeat.o(95507);
        return true;
      }
      a(paramInt3, paramcnb, parambp);
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
  
  public final void aI(Activity paramActivity)
  {
    AppMethodBeat.i(95486);
    Log.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.iXZ.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.DHd.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (ax(paramActivity.getWindow().getDecorView(), ((c)localObject3).code)) {
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
      this.iXZ.remove(Integer.valueOf(i));
      localObject3 = this.DHd.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        c localc = (c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.DHd.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.DHd.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (((c)localObject3).DHT == paramActivity.hashCode()) {
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
      this.iXZ.remove(Integer.valueOf(i));
      localObject1 = this.DHd.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (((c)localObject2).code != i) {
          break;
        }
        this.DHd.remove(localObject2);
      }
    }
    label371:
    this.DGY.fbt();
    Log.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.iXZ.size());
    AppMethodBeat.o(95486);
  }
  
  public final void aOY(String paramString)
  {
    AppMethodBeat.i(95536);
    b(paramString, null);
    AppMethodBeat.o(95536);
  }
  
  public final com.tencent.mm.memory.n aOZ(String paramString)
  {
    AppMethodBeat.i(95537);
    if (this.DGX == null)
    {
      AppMethodBeat.o(95537);
      return null;
    }
    paramString = (com.tencent.mm.memory.n)this.DGX.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95537);
    return paramString;
  }
  
  public final int b(SnsInfo paramSnsInfo, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95522);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (Util.ticksToNow(this.DHi) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      d.baW();
      if (!d.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.DHo = 5;
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
      this.DHp = ((PInt)localObject).value;
      this.DHi = Util.currentTicks();
      if ((this.DHp != 0) && (paramSnsInfo != null)) {
        break label144;
      }
      i = this.DHo;
      AppMethodBeat.o(95522);
      return i;
      this.DHo = 10;
      break;
    }
    label144:
    if (this.DHq.containsKey(Long.valueOf(paramSnsInfo.field_snsId)))
    {
      i = ((Integer)this.DHq.get(Long.valueOf(paramSnsInfo.field_snsId))).intValue();
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = new eaj();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.DHo;
        AppMethodBeat.o(95522);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.MZL == null) || (paramArrayOfInt.MZL.info == null))
      {
        i = this.DHj;
        AppMethodBeat.o(95522);
        return i;
      }
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramSnsInfo, "", new Object[0]);
      i = this.DHo;
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.MZL.info;
    i = paramArrayOfInt.hashCode();
    if (this.DHp == 1)
    {
      if (!this.DHn.containsKey(Integer.valueOf(i))) {
        this.DHn.put(Integer.valueOf(i), Boolean.valueOf(fy(paramArrayOfInt, this.DHp)));
      }
      if (((Boolean)this.DHn.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        Log.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i) });
        this.DHq.put(Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95522);
        return i;
      }
    }
    if (!this.DHm.containsKey(Integer.valueOf(i))) {
      this.DHm.put(Integer.valueOf(i), Boolean.valueOf(fy(paramArrayOfInt, this.DHp)));
    }
    if (((Boolean)this.DHm.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap b(cnb paramcnb)
  {
    AppMethodBeat.i(95488);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95488);
      return null;
    }
    String str1 = com.tencent.mm.plugin.sns.data.r.cq(1, paramcnb.Id);
    Object localObject = aOV(str1);
    if (com.tencent.mm.plugin.sns.data.r.b((com.tencent.mm.memory.n)localObject))
    {
      paramcnb = ((com.tencent.mm.memory.n)localObject).aSa();
      AppMethodBeat.o(95488);
      return paramcnb;
    }
    localObject = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
    String str2 = com.tencent.mm.plugin.sns.data.r.e(paramcnb);
    localObject = (String)localObject + str2;
    if (s.YS((String)localObject))
    {
      if (paramcnb.Id.startsWith("pre_temp_extend_pic")) {}
      for (paramcnb = com.tencent.mm.memory.n.H(com.tencent.mm.plugin.sns.storage.r.aQG((String)localObject)); com.tencent.mm.plugin.sns.data.r.b(paramcnb); paramcnb = com.tencent.mm.plugin.sns.data.r.aOq((String)localObject))
      {
        a(str1, paramcnb);
        paramcnb = paramcnb.aSa();
        AppMethodBeat.o(95488);
        return paramcnb;
      }
      AppMethodBeat.o(95488);
      return null;
    }
    AppMethodBeat.o(95488);
    return null;
  }
  
  public final void b(cnb paramcnb, View paramView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95490);
    a(paramcnb, paramView, -1, paramInt, parambp);
    AppMethodBeat.o(95490);
  }
  
  protected final void b(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(95547);
    com.tencent.mm.memory.n localn = paramn;
    if (!com.tencent.mm.plugin.sns.data.r.b(paramn)) {
      localn = aOW(paramString);
    }
    if (com.tencent.mm.plugin.sns.data.r.b(localn))
    {
      if ((this.DGX != null) && (localn != null) && (paramString != null)) {
        this.DGX.put(paramString, localn);
      }
      paramn = (LinkedList)this.DGZ.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((c)localObject).DHU) && (paramString != null) && (paramString.equals(((c)localObject).id)))
          {
            int i = ((c)localObject).code;
            localObject = (WeakReference)this.iXZ.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.DHg != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.DHg.Zx(i))) {
                      continue;
                    }
                  }
                }
                if ((com.tencent.mm.plugin.sns.data.r.b(localn)) && (localObject != null))
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
                    Log.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.plugin.sns.data.r.b(localn)) });
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
  
  public final boolean b(cnb paramcnb, View paramView, int paramInt1, int paramInt2, bp parambp)
  {
    AppMethodBeat.i(95506);
    boolean bool = a(paramcnb, paramView, paramInt1, paramInt2, parambp, 1);
    AppMethodBeat.o(95506);
    return bool;
  }
  
  public final void c(cnb paramcnb, View paramView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95505);
    if ((paramcnb == null) || (paramcnb.Id == null) || (paramcnb.Id.equals("")))
    {
      AppMethodBeat.o(95505);
      return;
    }
    String str = com.tencent.mm.plugin.sns.data.r.cq(4, paramcnb.Id);
    a(paramView, str, -1, paramInt);
    com.tencent.mm.memory.n localn = aOV(str);
    boolean bool = com.tencent.mm.plugin.sns.data.r.b(localn);
    Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      fh(paramView);
      if (!this.DHr.contains(str))
      {
        a(4, paramcnb, parambp);
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
    a(paramView, null, true, -1, paramInt3, -1, -1, g.a.DHP);
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
        ((ImageView)paramView).setImageDrawable(com.tencent.mm.cb.a.l(paramView.getContext(), paramInt2));
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
  
  public final void eZk()
  {
    AppMethodBeat.i(95548);
    fad();
    this.DHh = 0L;
    this.DHi = 0L;
    this.DHb.clear();
    this.DHc = false;
    AppMethodBeat.o(95548);
  }
  
  public final void fad()
  {
    AppMethodBeat.i(95484);
    if (this.DGX != null)
    {
      this.iXZ.clear();
      this.DGY.DMl.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.DGX.putCount() + ";");
      localStringBuffer.append("missCount:" + this.DGX.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.DGX.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.DGX.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.DGX.evictionCount() + ";");
      Log.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.DGX.trimToSize(-1);
    }
    this.DGY.fbt();
    System.gc();
    AppMethodBeat.o(95484);
  }
  
  public final void ff(View paramView)
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
  
  public final boolean fi(View paramView)
  {
    AppMethodBeat.i(95514);
    int i = paramView.hashCode();
    paramView = this.DHd.iterator();
    while (paramView.hasNext())
    {
      c localc = (c)paramView.next();
      if (i == localc.code) {
        this.DHd.remove(localc);
      }
    }
    this.iXZ.remove(Integer.valueOf(i));
    AppMethodBeat.o(95514);
    return true;
  }
  
  public final boolean kf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95532);
    if ((this.DHe.containsKey(paramString1)) && (3 == ((Integer)this.DHe.get(paramString1)).intValue())) {
      this.DHe.remove(paramString1);
    }
    String str = com.tencent.mm.plugin.sns.data.r.cq(1, paramString1);
    Log.i("MicroMsg.LazyerImageLoader2", "TimeLineAdPreloadHelper, download video complete, mediaId=" + paramString1 + ", path=" + paramString2);
    Object localObject1 = (LinkedList)this.DGZ.get(str);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95532);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((c)localObject2).DHU) && (str != null) && (str.equals(((c)localObject2).id)))
      {
        int i = ((c)localObject2).code;
        localObject2 = (WeakReference)this.iXZ.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            at localat;
            if ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a))
            {
              Log.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
              if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof at))
              {
                localat = (at)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
                boolean bool;
                if (localat != null)
                {
                  if (s.YS(paramString2))
                  {
                    if (!this.DGJ) {}
                    for (bool = true;; bool = false)
                    {
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).e(paramString2, bool, localat.position);
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localat.position);
                      localat.Ewv.setVisibility(8);
                      localat.EeS.setVisibility(8);
                      localat.EeT.setVisibility(8);
                      aOX(paramString1);
                      break;
                    }
                  }
                  setError(paramString1);
                  localat.Ewv.setVisibility(8);
                  localat.EeS.setImageResource(2131234876);
                  localat.EeS.setVisibility(0);
                }
                else
                {
                  if (!this.DGJ) {}
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
              Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (SnsAdTimelineVideoView)localObject2;
              if ((((SnsAdTimelineVideoView)localObject2).getTag() instanceof at))
              {
                localat = (at)((SnsAdTimelineVideoView)localObject2).getTag();
                if (localat != null)
                {
                  if (s.YS(paramString2))
                  {
                    ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                    ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                    localat.Ewv.setVisibility(8);
                    localat.EeS.setVisibility(8);
                    localat.EeT.setVisibility(8);
                    aOX(paramString1);
                  }
                  else
                  {
                    setError(paramString1);
                    localat.Ewv.setVisibility(8);
                    localat.EeS.setImageResource(2131234876);
                    localat.EeS.setVisibility(0);
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
    this.DGJ = false;
    c localc = aj.faJ();
    localc.DGJ = false;
    Object localObject3;
    synchronized (localc.mLock)
    {
      localObject2 = new LinkedList();
      localObject3 = localc.gCs.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        o localo = (o)((Iterator)localObject3).next();
        if (localo.requestType != 6)
        {
          localc.DGM.remove(localo.key);
          ((LinkedList)localObject2).add(localo);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (o)((Iterator)localObject2).next();
      localObject1.gCs.remove(localObject3);
    }
    localObject1.DGN.clear();
    localObject1.DGO.clear();
    AppMethodBeat.o(95482);
  }
  
  public final void start()
  {
    AppMethodBeat.i(95481);
    this.DGJ = true;
    fae();
    c localc = aj.faJ();
    localc.DGJ = true;
    localc.bck();
    AppMethodBeat.o(95481);
  }
  
  public final boolean v(cnb paramcnb)
  {
    AppMethodBeat.i(95524);
    if (!this.DHe.containsKey(paramcnb.Id))
    {
      AppMethodBeat.o(95524);
      return false;
    }
    if (((Integer)this.DHe.get(paramcnb.Id)).intValue() == 1)
    {
      AppMethodBeat.o(95524);
      return true;
    }
    AppMethodBeat.o(95524);
    return false;
  }
  
  public final boolean w(cnb paramcnb)
  {
    AppMethodBeat.i(95525);
    if (!this.DHe.containsKey(paramcnb.Id))
    {
      AppMethodBeat.o(95525);
      return false;
    }
    if (((Integer)this.DHe.get(paramcnb.Id)).intValue() == 2)
    {
      AppMethodBeat.o(95525);
      return true;
    }
    AppMethodBeat.o(95525);
    return false;
  }
  
  public final boolean x(cnb paramcnb)
  {
    AppMethodBeat.i(95526);
    if (!this.DHe.containsKey(paramcnb.Id))
    {
      AppMethodBeat.o(95526);
      return false;
    }
    if (((Integer)this.DHe.get(paramcnb.Id)).intValue() == 3)
    {
      AppMethodBeat.o(95526);
      return true;
    }
    AppMethodBeat.o(95526);
    return false;
  }
  
  public final boolean y(cnb paramcnb)
  {
    AppMethodBeat.i(95527);
    if (!this.DHe.containsKey(paramcnb.Id))
    {
      AppMethodBeat.o(95527);
      return false;
    }
    if (((Integer)this.DHe.get(paramcnb.Id)).intValue() == 4)
    {
      AppMethodBeat.o(95527);
      return true;
    }
    AppMethodBeat.o(95527);
    return false;
  }
  
  public final int z(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(258596);
    int i = a(paramSnsInfo, null);
    AppMethodBeat.o(258596);
    return i;
  }
  
  public final void z(cnb paramcnb)
  {
    AppMethodBeat.i(95528);
    this.DHe.put(paramcnb.Id, Integer.valueOf(1));
    AppMethodBeat.o(95528);
  }
  
  final class b
    extends h<String, Integer, Boolean>
  {
    private int DHS;
    private cnb ebR;
    private com.tencent.mm.memory.n iuI;
    private String jpM;
    String key;
    private String path;
    
    public b(String paramString1, String paramString2, String paramString3, cnb paramcnb, int paramInt)
    {
      AppMethodBeat.i(95474);
      this.key = "";
      this.iuI = null;
      this.DHS = 0;
      g.this.DHr.add(paramString1);
      this.key = paramString1;
      this.path = paramString2;
      this.jpM = paramString3;
      this.ebR = paramcnb;
      this.DHS = paramInt;
      g.etv();
      Log.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(g.byU()) });
      AppMethodBeat.o(95474);
    }
    
    private void aL(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(95475);
      s.YS(this.jpM + paramString3);
      if (!s.YS(this.jpM + paramString1))
      {
        String str = paramString2;
        if (!s.YS(this.jpM + paramString2)) {
          str = com.tencent.mm.plugin.sns.data.r.m(this.ebR);
        }
        boolean bool = com.tencent.mm.plugin.sns.storage.r.a(this.jpM, str, paramString1, aj.fbc());
        if (!bool)
        {
          Log.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
          s.deleteFile(this.jpM + str);
        }
        Log.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.jpM + str, this.jpM + paramString1, Boolean.valueOf(bool) });
      }
      com.tencent.mm.plugin.sns.storage.r.b(this.jpM, paramString1, paramString3, aj.fbb());
      AppMethodBeat.o(95475);
    }
    
    private Boolean fag()
    {
      AppMethodBeat.i(95476);
      g.a(g.this, true);
      Object localObject;
      if (!g.h(g.this))
      {
        Log.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      if (g.f(g.this).check(this.key))
      {
        Log.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      s.bpc(this.jpM);
      long l1 = System.currentTimeMillis();
      long l2;
      if (!s.YS(this.path))
      {
        aL(com.tencent.mm.plugin.sns.data.r.e(this.ebR), com.tencent.mm.plugin.sns.data.r.l(this.ebR), com.tencent.mm.plugin.sns.data.r.f(this.ebR));
        l2 = Util.currentTicks();
        if (this.DHS != 5) {
          break label769;
        }
        if (!s.YS(this.path)) {
          aL(com.tencent.mm.plugin.sns.data.r.e(this.ebR), com.tencent.mm.plugin.sns.data.r.l(this.ebR), com.tencent.mm.plugin.sns.data.r.f(this.ebR));
        }
        bool1 = s.YS(this.jpM + com.tencent.mm.plugin.sns.data.r.e(this.ebR));
        boolean bool2 = s.YS(this.jpM + com.tencent.mm.plugin.sns.data.r.l(this.ebR));
        boolean bool3 = s.YS(this.jpM + com.tencent.mm.plugin.sns.data.r.f(this.ebR));
        this.iuI = com.tencent.mm.plugin.sns.data.r.aOo(this.path);
        if (this.iuI == null)
        {
          Log.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = com.tencent.mm.plugin.sns.data.r.f(this.ebR);
          this.iuI = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.jpM + (String)localObject, this.path);
          boolean bool4 = s.YS(this.path);
          Log.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
        }
        label427:
        long l3 = Util.ticksToNow(l2);
        int i = (int)s.boW(this.path);
        if (Util.ticksToNow(g.i(g.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD() });
          g.b(g.this, Util.currentTicks());
        }
        if (this.iuI == null)
        {
          Log.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.ebR.Id });
          s.deleteFile(this.jpM + com.tencent.mm.plugin.sns.data.r.f(this.ebR));
          s.deleteFile(this.path);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(150L, 2L, 1L, true);
        }
        l3 = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(150L, 0L, 1L, true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(150L, 1L, l3 - l1, true);
        localObject = new StringBuilder("doInBackground decode %s and ");
        if (this.iuI != null) {
          break label872;
        }
      }
      label769:
      label872:
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.ImageLoader", bool1 + " " + this.iuI + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
        localObject = Boolean.TRUE;
        AppMethodBeat.o(95476);
        return localObject;
        Log.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
        break;
        if (this.DHS == 4)
        {
          this.iuI = com.tencent.mm.plugin.sns.data.r.aOo(this.path);
          if (this.iuI != null) {
            break label427;
          }
          Log.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = com.tencent.mm.plugin.sns.data.r.e(this.ebR);
          this.iuI = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.jpM + (String)localObject, this.path);
          break label427;
        }
        this.iuI = com.tencent.mm.plugin.sns.data.r.aOq(this.path);
        break label427;
      }
    }
    
    public final ExecutorService eGk()
    {
      AppMethodBeat.i(179079);
      ExecutorService localExecutorService = aj.faz();
      AppMethodBeat.o(179079);
      return localExecutorService;
    }
  }
  
  static final class c
  {
    public int DHT;
    public boolean DHU;
    public int code;
    public String id;
    
    public c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.id = paramString;
      this.code = paramInt1;
      this.DHT = paramInt2;
      this.DHU = paramBoolean;
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
    public abstract void ax(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g
 * JD-Core Version:    0.7.0.1
 */
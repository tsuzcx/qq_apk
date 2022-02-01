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
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.memory.a.b.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ae;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ekj;
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
import com.tencent.mm.vfs.u;
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
  implements com.tencent.mm.plugin.sns.b.h
{
  private static int JUr = 0;
  public boolean JTH;
  private long JTU;
  private long JTV;
  com.tencent.mm.memory.a.b<n> JTW;
  private ao<String, WeakReference<Bitmap>> JTX;
  private Map<String, LinkedList<WeakReference<c>>> JTY;
  private ConcurrentHashMap<Integer, String> JTZ;
  private LinkedList<b> JUa;
  private boolean JUb;
  private HashSet<c> JUc;
  public HashMap<String, Integer> JUd;
  private int JUe;
  public ae JUf;
  public long JUg;
  public long JUh;
  private int JUi;
  private int JUj;
  private HashMap<Long, Integer> JUk;
  private HashMap<Integer, Boolean> JUl;
  private HashMap<Integer, Boolean> JUm;
  private int JUn;
  private int JUo;
  private HashMap<Long, Integer> JUp;
  protected Set<String> JUq;
  private Map<Integer, WeakReference<Object>> lOt;
  
  public g()
  {
    AppMethodBeat.i(95483);
    this.JTU = 0L;
    this.JTV = 0L;
    this.lOt = new HashMap();
    this.JTY = new HashMap();
    this.JTZ = new ConcurrentHashMap();
    this.JUa = new LinkedList();
    this.JUb = false;
    this.JUc = new HashSet();
    this.JUd = new HashMap();
    this.JUe = 4;
    this.JTH = true;
    this.JUg = 0L;
    this.JUh = 0L;
    this.JUi = 0;
    this.JUj = 0;
    this.JUk = new HashMap();
    this.JUl = new HashMap();
    this.JUm = new HashMap();
    this.JUn = 0;
    this.JUo = 0;
    this.JUp = new HashMap();
    this.JUq = new HashSet();
    com.tencent.mm.memory.a.b.a(n.class, new b.a() {});
    int i = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    Log.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.JTW = new com.tencent.mm.memory.a.b(i, new f.b() {}, getClass());
      this.JTX = new ao(this.JUe, new ao.a()
      {
        public final boolean dT(Object paramAnonymousObject)
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
              paramAnonymousObject = ((ao.b)((ao)localObject).JZn.get(str)).obj;
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
            i = ((ao)localObject).JZn.size();
            paramAnonymousObject = ((ao)localObject).JZn.remove(str);
            localObject = new StringBuilder("internalMap ").append(((ao)localObject).JZn.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              Log.d("MicroMsg.SnsLRUMap", bool);
              Log.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(g.this).JZn.size() + " listPaitSize:" + g.b(g.this).size());
              AppMethodBeat.o(95463);
              return true;
              paramAnonymousObject = (WeakReference)((ao.b)((ao)localObject).JZn.get(str)).obj;
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
  
  public static String D(cvt paramcvt)
  {
    AppMethodBeat.i(95541);
    if (paramcvt == null)
    {
      AppMethodBeat.o(95541);
      return null;
    }
    if (paramcvt.Id.startsWith("pre_temp_sns_pic")) {
      paramcvt = aj.getAccSnsTmpPath() + paramcvt.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(95541);
      return paramcvt;
      if (paramcvt.Id.startsWith("Locall_path")) {
        paramcvt = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.l(paramcvt);
      } else if (paramcvt.Id.startsWith("pre_temp_extend_pic")) {
        paramcvt = paramcvt.Id.substring(19);
      } else {
        paramcvt = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.c(paramcvt);
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
    cvt localcvt = o.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    t.cq(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = t.aZl(paramString1);
      if (t.K(paramString1))
      {
        AppMethodBeat.o(95538);
        return paramString1;
      }
      AppMethodBeat.o(95538);
      return null;
    }
    if (t.K(null))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    Object localObject = t.k(localcvt);
    localObject = t.aZl(aq.kD(aj.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!t.K((Bitmap)localObject)) {
      paramString3 = t.aZl(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!Util.isNullOrNil(paramString2))) {
      aj.fOD().a(localcvt, 3, null, parambp);
    }
    if (!t.K(paramString3))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    AppMethodBeat.o(95538);
    return paramString3;
  }
  
  private String a(SnsInfo paramSnsInfo, final cvt paramcvt, final bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(95531);
    if (v(paramcvt))
    {
      AppMethodBeat.o(95531);
      return "";
    }
    String str1 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    String str2 = t.i(paramcvt);
    if (u.agG(str1 + str2))
    {
      paramSnsInfo = str1 + str2;
      AppMethodBeat.o(95531);
      return paramSnsInfo;
    }
    if ((u.agG(str1 + t.o(paramcvt))) && (paramcvt.Id != null) && (paramcvt.Id.startsWith("Locall_path")))
    {
      paramSnsInfo = str1 + t.o(paramcvt);
      AppMethodBeat.o(95531);
      return paramSnsInfo;
    }
    if (!this.JTH)
    {
      AppMethodBeat.o(95531);
      return "";
    }
    Log.i("MicroMsg.LazyerImageLoader2", "push sight loader " + paramcvt.Id + " url: " + paramcvt.Url);
    if (paramBoolean) {
      if (b(paramSnsInfo, null) == 5) {
        aj.etE().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95470);
            aj.fOD().a(paramcvt, 4, null, parambp);
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
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, g.a.JUO);
    AppMethodBeat.o(95510);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95512);
    a(paramObject, paramString, false, -1, paramInt1, paramInt2, paramInt3, g.a.JUO);
    AppMethodBeat.o(95512);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, g.a parama)
  {
    AppMethodBeat.i(95511);
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, parama);
    AppMethodBeat.o(95511);
  }
  
  private static void a(Object paramObject, String paramString, n paramn)
  {
    long l2 = 0L;
    AppMethodBeat.i(95498);
    if (paramObject == null)
    {
      AppMethodBeat.o(95498);
      return;
    }
    if (paramn != null) {
      Log.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.bbc() });
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
      l1 = ((am)localObject).JZg;
    }
    label454:
    label468:
    for (;;)
    {
      paramn = new am(paramString, paramn, l1);
      paramObject.af(paramn.JZg, paramString);
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
        for (paramObject = new am(paramString, paramn, ((am)paramObject).JZg);; paramObject = new am(paramString, paramn, 0L))
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
        for (paramObject = new am(paramString, paramn, ((am)paramObject).JZg);; paramObject = new am(paramString, paramn, 0L))
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
      for (paramObject = new am(paramString, paramn, ((am)paramObject).JZg);; paramObject = new am(paramString, paramn, 0L))
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
    this.JUc.remove(new c(null, i, 0, false));
    c localc = new c(paramString, i, paramInt2, paramBoolean);
    this.JUc.add(localc);
    LinkedList localLinkedList = (LinkedList)this.JTY.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.JTY.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.JTY.get(localObject);
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
      this.lOt.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label352;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == g.a.JUP) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
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
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.ci.a.m(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.a.a)paramObject;
            if (!this.JTH) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((com.tencent.mm.plugin.sight.decode.a.a)localObject).f(null, paramBoolean, 0);
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
  
  private boolean a(final int paramInt, final cvt paramcvt, final bp parambp)
  {
    AppMethodBeat.i(95517);
    if (!this.JTH)
    {
      if ((paramcvt != null) && (!Util.isNullOrNil(paramcvt.Id))) {
        aj.fOD().aZN(paramcvt.Id);
      }
      AppMethodBeat.o(95517);
      return false;
    }
    aj.fOv().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95469);
        p localp;
        c localc;
        cvt localcvt;
        if (!g.a(g.this, paramInt, paramcvt))
        {
          localp = new p(paramcvt);
          localp.JRn = paramInt;
          localp.fIY = paramcvt.Id;
          localc = aj.fOD();
          localcvt = paramcvt;
          if (paramcvt.rWu != 6) {
            break label97;
          }
        }
        label97:
        for (int i = 5;; i = 1)
        {
          localc.a(localcvt, i, localp, parambp);
          AppMethodBeat.o(95469);
          return;
        }
      }
    });
    AppMethodBeat.o(95517);
    return true;
  }
  
  public static boolean a(cvt paramcvt, bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(95540);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95540);
      return false;
    }
    Object localObject;
    if (paramcvt.Id.startsWith("Locall_path"))
    {
      localObject = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.l(paramcvt);
      if (u.agG((String)localObject)) {
        break label161;
      }
      localObject = aj.fOD();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 2)
    {
      ((c)localObject).a(paramcvt, i, null, parambp);
      AppMethodBeat.o(95540);
      return false;
      localObject = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.c(paramcvt);
      break;
    }
    label161:
    AppMethodBeat.o(95540);
    return true;
  }
  
  private boolean a(String paramString, n paramn)
  {
    AppMethodBeat.i(95534);
    if ((paramn != null) && (paramString != null)) {
      this.JTW.put(paramString, paramn);
    }
    AppMethodBeat.o(95534);
    return true;
  }
  
  private boolean a(final List<cvt> paramList, final bp parambp)
  {
    AppMethodBeat.i(95515);
    aj.fOv().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95466);
        long l = Util.currentTicks();
        Object localObject = new p(paramList);
        ((p)localObject).fIY = t.hw(paramList);
        ((p)localObject).JRn = this.JUt;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          cvt localcvt = (cvt)paramList.get(j);
          if (aj.fOD().aZI(localcvt.Id)) {
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
              } while (u.agG(aq.kD(aj.getAccSnsPath(), localcvt.Id) + t.d(localcvt)));
              i = k;
            } while (u.agG(aq.kD(aj.getAccSnsPath(), localcvt.Id) + t.k(localcvt)));
            i = k;
          } while (u.agG(aq.kD(aj.getAccSnsPath(), localcvt.Id) + t.l(localcvt)));
          c localc = aj.fOD();
          if (localcvt.rWu == 6) {}
          for (int i = 5;; i = 1)
          {
            localc.a(localcvt, i, (p)localObject, parambp);
            i = 0;
            break;
          }
        }
        l = Util.ticksToNow(l);
        if (l > 100L) {
          Log.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.aSF() + " " + aj.fPb() + " " + ((p)localObject).fIY);
        }
        if (Util.ticksToNow(g.c(g.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), aj.fPb(), com.tencent.mm.loader.j.b.aSF() });
          g.a(g.this, Util.currentTicks());
        }
        localObject = t.hw(paramList);
        if (k != 0) {
          aj.etE().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95465);
              new i(t.cq(0, this.acq), this.acq, g.9.this.JUK).y(new String[] { "" });
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
  
  private boolean aC(View paramView, int paramInt)
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
      } while (!aC(paramView.getChildAt(j), paramInt));
      AppMethodBeat.o(95485);
      return true;
    }
    AppMethodBeat.o(95485);
    return false;
  }
  
  private n aZQ(String paramString)
  {
    AppMethodBeat.i(95492);
    n localn = (n)this.JTW.get(paramString);
    if ((localn == null) || (localn.baX()))
    {
      this.JTW.remove(paramString);
      AppMethodBeat.o(95492);
      return null;
    }
    AppMethodBeat.o(95492);
    return localn;
  }
  
  private n aZR(String paramString)
  {
    AppMethodBeat.i(95493);
    n localn = (n)this.JTW.get(paramString);
    if ((localn == null) || (localn.baX()))
    {
      this.JTW.remove(paramString);
      AppMethodBeat.o(95493);
      return null;
    }
    AppMethodBeat.o(95493);
    return localn;
  }
  
  private boolean aZS(String paramString)
  {
    AppMethodBeat.i(179083);
    if ((this.JUd.containsKey(paramString)) && (4 == ((Integer)this.JUd.get(paramString)).intValue())) {
      this.JUd.remove(paramString);
    }
    AppMethodBeat.o(179083);
    return true;
  }
  
  private void b(cvt paramcvt, View paramView, int paramInt, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95497);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95497);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = t.cq(5, paramcvt.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = aZQ(str);
    if (!t.b(parama))
    {
      go(paramView);
      if (this.JUq.contains(str))
      {
        AppMethodBeat.o(95497);
        return;
      }
      a(5, paramcvt, parambp);
      AppMethodBeat.o(95497);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95497);
  }
  
  private boolean fNX()
  {
    AppMethodBeat.i(95516);
    if (this.JUb)
    {
      Log.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(95516);
      return false;
    }
    aj.etE().postDelayed(new Runnable()
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
  
  private static boolean gb(String paramString, int paramInt)
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
  
  private static void go(View paramView)
  {
    AppMethodBeat.i(95508);
    if ((paramView instanceof QImageView))
    {
      ((QImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(com.tencent.mm.plugin.sns.i.c.BG_3)));
      AppMethodBeat.o(95508);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(com.tencent.mm.plugin.sns.i.c.BG_3)));
      AppMethodBeat.o(95508);
      return;
    }
    AppMethodBeat.o(95508);
  }
  
  public static String r(cvt paramcvt)
  {
    AppMethodBeat.i(95489);
    String str = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    paramcvt = t.d(paramcvt);
    paramcvt = str + paramcvt;
    AppMethodBeat.o(95489);
    return paramcvt;
  }
  
  public static String s(cvt paramcvt)
  {
    AppMethodBeat.i(95499);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95499);
      return null;
    }
    String str = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.d(paramcvt);
    if (!u.agG(str))
    {
      paramcvt = paramcvt.TDF;
      AppMethodBeat.o(95499);
      return paramcvt;
    }
    AppMethodBeat.o(95499);
    return str;
  }
  
  private void setError(String paramString)
  {
    AppMethodBeat.i(179084);
    this.JUd.put(paramString, Integer.valueOf(4));
    AppMethodBeat.o(179084);
  }
  
  public static String t(cvt paramcvt)
  {
    AppMethodBeat.i(95500);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95500);
      return null;
    }
    String str = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.c(paramcvt);
    if (!u.agG(str))
    {
      paramcvt = paramcvt.Url;
      AppMethodBeat.o(95500);
      return paramcvt;
    }
    AppMethodBeat.o(95500);
    return str;
  }
  
  public static boolean u(cvt paramcvt)
  {
    AppMethodBeat.i(95518);
    String str1 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    String str2 = t.i(paramcvt);
    if (u.agG(str1 + str2))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    if ((u.agG(str1 + t.o(paramcvt))) && (!Util.isNullOrNil(paramcvt.Id)) && (paramcvt.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    AppMethodBeat.o(95518);
    return false;
  }
  
  public final int A(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(293009);
    int i = a(paramSnsInfo, null);
    AppMethodBeat.o(293009);
    return i;
  }
  
  public final void A(cvt paramcvt)
  {
    AppMethodBeat.i(95529);
    this.JUd.put(paramcvt.Id, Integer.valueOf(2));
    AppMethodBeat.o(95529);
  }
  
  public final int B(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(293010);
    int i = b(paramSnsInfo, null);
    AppMethodBeat.o(293010);
    return i;
  }
  
  public final void B(cvt paramcvt)
  {
    AppMethodBeat.i(95530);
    this.JUd.put(paramcvt.Id, Integer.valueOf(3));
    AppMethodBeat.o(95530);
  }
  
  public final boolean C(cvt paramcvt)
  {
    AppMethodBeat.i(95539);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95539);
      return false;
    }
    if (u.agG(aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.e(paramcvt)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    if (u.agG(aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.d(paramcvt)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    paramcvt = t.cq(1, paramcvt.Id);
    boolean bool = t.b((n)this.JTW.get(paramcvt));
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
    if ((paramArrayOfInt != null) || (Util.ticksToNow(this.JUg) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      d.bkm();
      if (!d.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.JUi = 5;
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
      this.JUj = ((PInt)localObject).value;
      this.JUg = Util.currentTicks();
      if ((this.JUj != 0) && (paramSnsInfo != null)) {
        break label163;
      }
      i = this.JUi;
      AppMethodBeat.o(95520);
      return i;
      this.JUi = 10;
      break;
    }
    label163:
    if (this.JUk.containsKey(Long.valueOf(paramSnsInfo.field_snsId)))
    {
      i = ((Integer)this.JUk.get(Long.valueOf(paramSnsInfo.field_snsId))).intValue();
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = new ekj();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.JUi;
        AppMethodBeat.o(95520);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.Tkb.UH);
      if ((paramArrayOfInt.Umf == null) || (paramArrayOfInt.Umf.fTp == null))
      {
        i = this.JUi;
        AppMethodBeat.o(95520);
        return i;
      }
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramSnsInfo, "", new Object[0]);
      i = this.JUi;
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.Umf.fTp;
    i = paramArrayOfInt.hashCode();
    if (this.JUj == 1)
    {
      if (!this.JUm.containsKey(Integer.valueOf(i))) {
        this.JUm.put(Integer.valueOf(i), Boolean.valueOf(gb(paramArrayOfInt, this.JUj)));
      }
      if (((Boolean)this.JUm.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        Log.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i) });
        this.JUk.put(Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95520);
        return i;
      }
    }
    if (!this.JUl.containsKey(Integer.valueOf(i))) {
      this.JUl.put(Integer.valueOf(i), Boolean.valueOf(gb(paramArrayOfInt, this.JUj)));
    }
    if (((Boolean)this.JUl.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(cvt paramcvt)
  {
    AppMethodBeat.i(95488);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95488);
      return null;
    }
    String str1 = t.cq(1, paramcvt.Id);
    Object localObject = aZQ(str1);
    if (t.b((n)localObject))
    {
      paramcvt = ((n)localObject).baV();
      AppMethodBeat.o(95488);
      return paramcvt;
    }
    localObject = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    String str2 = t.d(paramcvt);
    localObject = (String)localObject + str2;
    if (u.agG((String)localObject))
    {
      if (paramcvt.Id.startsWith("pre_temp_extend_pic")) {}
      for (paramcvt = n.F(r.bbG((String)localObject)); t.b(paramcvt); paramcvt = t.aZm((String)localObject))
      {
        a(str1, paramcvt);
        paramcvt = paramcvt.baV();
        AppMethodBeat.o(95488);
        return paramcvt;
      }
      AppMethodBeat.o(95488);
      return null;
    }
    AppMethodBeat.o(95488);
    return null;
  }
  
  public final n a(cvt paramcvt, ImageView paramImageView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95543);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95543);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = t.cq(0, paramcvt.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = aZQ(str);
    if (!t.b(paramImageView))
    {
      a(0, paramcvt, parambp);
      AppMethodBeat.o(95543);
      return null;
    }
    AppMethodBeat.o(95543);
    return paramImageView;
  }
  
  public final void a(cvt paramcvt, View paramView, int paramInt1, int paramInt2, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95496);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95496);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = t.cq(0, paramcvt.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = aZQ(str);
    if (!t.b(parama))
    {
      Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        go(paramView);
      }
      if (this.JUq.contains(str))
      {
        AppMethodBeat.o(95496);
        return;
      }
      a(0, paramcvt, parambp);
      AppMethodBeat.o(95496);
      return;
    }
    Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    aj.fOD().aZN(paramcvt.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(95496);
  }
  
  public final void a(cvt paramcvt, View paramView, int paramInt1, int paramInt2, bp parambp)
  {
    AppMethodBeat.i(95494);
    a(paramcvt, paramView, paramInt1, paramInt2, g.a.JUO, parambp);
    AppMethodBeat.o(95494);
  }
  
  public final void a(cvt paramcvt, View paramView, int paramInt, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95491);
    a(paramcvt, paramView, -1, paramInt, parama, parambp);
    AppMethodBeat.o(95491);
  }
  
  public final void a(cvt paramcvt, View paramView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95501);
    b(paramcvt, paramView, -1, paramInt, parambp);
    AppMethodBeat.o(95501);
  }
  
  public final void a(final cvt paramcvt, final View paramView, final int paramInt, final boolean paramBoolean1, final bp parambp, final boolean paramBoolean2, final e parame)
  {
    AppMethodBeat.i(95542);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95542);
      return;
    }
    final String str1 = t.cq(3, paramcvt.Id);
    final String str2 = D(paramcvt);
    if (aj.fOD().aZJ(paramcvt.Id))
    {
      Log.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + paramcvt.Id);
      a(paramView, str1, paramInt, -1, -1);
      parame.au(null);
      AppMethodBeat.o(95542);
      return;
    }
    Object localObject1 = this.JTX;
    Object localObject2 = (ao.b)((ao)localObject1).JZn.get(str1);
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
      if (!t.K((Bitmap)localObject1)) {
        break label305;
      }
      Log.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
      a(paramView, str1, paramInt, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      parame.au((Bitmap)localObject1);
      AppMethodBeat.o(95542);
      return;
      ((ao.b)((ao)localObject1).JZn.get(str1)).fPn();
      localObject1 = ((ao.b)localObject2).obj;
      break;
      bool = false;
      break label185;
    }
    label305:
    aj.fOt().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95459);
        final Bitmap localBitmap = t.aZl(str2);
        aj.etE().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95458);
            if (t.K(localBitmap))
            {
              g.a(g.this, g.4.this.JTa, g.4.this.JUw, g.4.this.JUx, localBitmap.getWidth(), localBitmap.getHeight());
              if (!t.K(localBitmap)) {
                break label252;
              }
              localObject1 = g.a(g.this);
              localObject2 = g.4.this.JUw;
              localObject3 = new WeakReference(localBitmap);
              if ((ao.b)((ao)localObject1).JZn.get(localObject2) != null) {
                break label215;
              }
              localObject3 = new ao.b((ao)localObject1, localObject3);
              ((ao)localObject1).JZn.put(localObject2, localObject3);
              ((ao)localObject1).fPm();
            }
            label215:
            label252:
            while (!g.4.this.JUy) {
              for (;;)
              {
                Object localObject3;
                if (g.4.this.JUB != null) {
                  g.4.this.JUB.au(localBitmap);
                }
                AppMethodBeat.o(95458);
                return;
                g.a(g.this, g.4.this.JTa, g.4.this.JUw, g.4.this.JUx, -1, -1);
                break;
                ((ao.b)((ao)localObject1).JZn.get(localObject2)).fPn();
                ((ao.b)((ao)localObject1).JZn.get(localObject2)).obj = localObject3;
              }
            }
            Object localObject1 = aj.fOD();
            Object localObject2 = g.4.this.JJb;
            if (g.4.this.JUz) {}
            for (int i = 8;; i = 2)
            {
              ((c)localObject1).a((cvt)localObject2, i, null, g.4.this.JUA);
              break;
            }
          }
        });
        AppMethodBeat.o(95459);
      }
    });
    AppMethodBeat.o(95542);
  }
  
  public final void a(final String paramString, SparseArray<cvt> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, final bp parambp, final int paramInt2)
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
      cvt localcvt = (cvt)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = t.cq(0, localcvt.Id);
      a(localView, str, -1, paramInt1, g.a.JUO);
      n localn = aZQ(str);
      if (!t.b(localn))
      {
        Log.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        go(localView);
        if (!this.JUq.contains(str)) {
          localSparseArray1.put(k, localcvt);
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
      aj.fOv().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95464);
          int j = localSparseArray1.size();
          int i = 0;
          while (i < j)
          {
            int k = localSparseArray1.keyAt(i);
            cvt localcvt = (cvt)localSparseArray1.get(k);
            if (!g.a(g.this, 0, localcvt))
            {
              p localp = new p(localcvt);
              localp.JRn = 0;
              localp.fIY = localcvt.Id;
              localSparseArray2.put(k, localp);
              localSparseArray3.put(k, localcvt);
            }
            i += 1;
          }
          if (localSparseArray3.size() > 0) {
            aj.fOD().a(paramString, localSparseArray3, localSparseArray2, parambp, paramInt2);
          }
          AppMethodBeat.o(95464);
        }
      });
    }
    AppMethodBeat.o(95495);
  }
  
  public final void a(List<cvt> paramList, View paramView, int paramInt, g.a parama, bp parambp)
  {
    AppMethodBeat.i(95545);
    a(paramList, paramView, paramInt, parama, parambp, false);
    AppMethodBeat.o(95545);
  }
  
  public final void a(List<cvt> paramList, View paramView, int paramInt, g.a parama, bp parambp, boolean paramBoolean)
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
        b((cvt)paramList.get(0), paramView, paramInt, parambp);
        AppMethodBeat.o(95546);
        return;
      }
      b((cvt)paramList.get(0), paramView, paramInt, g.a.JUP, parambp);
      AppMethodBeat.o(95546);
      return;
    }
    String str = t.cq(0, t.hw(paramList));
    a(paramView, str, paramInt, parama);
    parama = aZQ(str);
    paramBoolean = t.b(parama);
    Log.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      go(paramView);
      if (this.JUq.contains(str))
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
  
  public final boolean a(p paramp, String paramString)
  {
    AppMethodBeat.i(95535);
    Object localObject1 = (cvt)paramp.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < paramp.list.size())
    {
      localObject2 = (cvt)paramp.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((cvt)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id);
      if (paramp.JRn == 0) {
        paramString = t.e((cvt)localObject1);
      }
      for (;;)
      {
        String str = t.cq(paramp.JRn, ((cvt)localObject1).Id);
        if (!this.JTW.check(str)) {
          new b(t.cq(paramp.JRn, ((cvt)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (cvt)localObject1, paramp.JRn).y(new String[] { "" });
        }
        AppMethodBeat.o(95535);
        return true;
        i += 1;
        break;
        if (paramp.JRn == 4) {
          paramString = t.f((cvt)localObject1);
        } else if (paramp.JRn == 5) {
          paramString = t.f((cvt)localObject1);
        } else if (paramp.JRn == 3) {
          paramString = t.k((cvt)localObject1);
        } else {
          paramString = t.d((cvt)localObject1);
        }
      }
    }
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cvt paramcvt, SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt, bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(179081);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(179081);
      return false;
    }
    String str1 = t.cq(1, paramcvt.Id);
    a(paramSnsAdTimelineVideoView, str1, -1, paramInt);
    String str2 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    String str3 = t.d(paramcvt);
    Object localObject;
    c localc;
    if (!u.agG(str2 + str3))
    {
      localObject = new p(paramcvt);
      ((p)localObject).JRn = 1;
      ((p)localObject).fIY = paramcvt.Id;
      localc = aj.fOD();
      if (paramcvt.rWu != 6) {
        break label293;
      }
    }
    label293:
    for (paramInt = 5;; paramInt = 1)
    {
      localc.a(paramcvt, paramInt, (p)localObject, parambp);
      localObject = "";
      if (paramBoolean) {
        localObject = a(paramSnsInfo, paramcvt, parambp, paramBoolean);
      }
      Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean) });
      if ((Util.isNullOrNil((String)localObject)) || (v(paramcvt))) {
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
    paramSnsInfo = aZQ(str1);
    paramBoolean = t.b(paramSnsInfo);
    Log.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      paramSnsAdTimelineVideoView.setThumbBmp(null);
      if (this.JUq.contains(str1))
      {
        AppMethodBeat.o(179081);
        return false;
      }
      a(1, paramcvt, parambp);
      AppMethodBeat.o(179081);
      return false;
    }
    a(paramSnsAdTimelineVideoView, str1, paramSnsInfo);
    AppMethodBeat.o(179081);
    return true;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cvt paramcvt, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, int paramInt3, bp parambp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(232200);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(232200);
      return false;
    }
    String str1 = t.cq(1, paramcvt.Id);
    a(paramVideoSightView, str1, -1, paramInt2);
    String str2 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
    String str3 = t.d(paramcvt);
    Object localObject1;
    Object localObject2;
    if (!u.agG(str2 + str3))
    {
      localObject1 = new p(paramcvt);
      ((p)localObject1).JRn = 1;
      ((p)localObject1).fIY = paramcvt.Id;
      localObject2 = aj.fOD();
      if (paramcvt.rWu == 6)
      {
        paramInt1 = 5;
        ((c)localObject2).a(paramcvt, paramInt1, (p)localObject1, parambp);
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
          localObject1 = a(paramSnsInfo, paramcvt, parambp, paramBoolean1);
        }
      }
      Log.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject1, Boolean.valueOf(paramBoolean1) });
      if ((Util.isNullOrNil((String)localObject1)) || (v(paramcvt))) {
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
      AppMethodBeat.o(232200);
      return true;
      paramInt1 = 1;
      break;
    }
    label315:
    Log.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject1 });
    paramVideoSightView.setVideoPath(null);
    paramVideoSightView.clear();
    paramSnsInfo = aZQ(str1);
    paramBoolean1 = t.b(paramSnsInfo);
    Log.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!paramBoolean1)
    {
      paramVideoSightView.setPosition(0);
      paramVideoSightView.setThumbBmp(null);
      if (this.JUq.contains(str1))
      {
        AppMethodBeat.o(232200);
        return false;
      }
      a(1, paramcvt, parambp);
      AppMethodBeat.o(232200);
      return false;
    }
    a(paramVideoSightView, str1, paramSnsInfo);
    AppMethodBeat.o(232200);
    return true;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cvt paramcvt, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bp parambp, boolean paramBoolean)
  {
    AppMethodBeat.i(176251);
    paramBoolean = a(paramSnsInfo, paramcvt, paramVideoSightView, paramInt1, paramInt2, parambp, paramBoolean, false);
    AppMethodBeat.o(176251);
    return paramBoolean;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, cvt paramcvt, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bp parambp, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176252);
    paramBoolean1 = a(paramSnsInfo, paramcvt, paramVideoSightView, -1, paramInt1, paramInt2, parambp, paramBoolean1, paramBoolean2, true);
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
    paramVideoSightView.f(null, false, paramInt2);
    AppMethodBeat.o(176250);
    return true;
  }
  
  public final boolean a(cvt paramcvt, View paramView, int paramInt1, int paramInt2, bp parambp, int paramInt3)
  {
    AppMethodBeat.i(95507);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95507);
      return false;
    }
    String str = t.cq(paramInt3, paramcvt.Id);
    a(paramView, str, paramInt1, paramInt2);
    n localn = aZQ(str);
    boolean bool = t.b(localn);
    Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        go(paramView);
      }
      if (this.JUq.contains(str))
      {
        AppMethodBeat.o(95507);
        return true;
      }
      a(paramInt3, paramcvt, parambp);
      AppMethodBeat.o(95507);
      return false;
    }
    a(paramView, str, localn);
    AppMethodBeat.o(95507);
    return true;
  }
  
  public final boolean a(String paramString, n paramn, int paramInt)
  {
    AppMethodBeat.i(95533);
    a(paramInt + "-" + paramString, paramn);
    AppMethodBeat.o(95533);
    return true;
  }
  
  public final void aO(Activity paramActivity)
  {
    AppMethodBeat.i(95486);
    Log.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.lOt.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.JUc.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (aC(paramActivity.getWindow().getDecorView(), ((c)localObject3).code)) {
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
      this.lOt.remove(Integer.valueOf(i));
      localObject3 = this.JUc.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        c localc = (c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.JUc.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.JUc.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (((c)localObject3).JUS == paramActivity.hashCode()) {
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
      this.lOt.remove(Integer.valueOf(i));
      localObject1 = this.JUc.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (((c)localObject2).code != i) {
          break;
        }
        this.JUc.remove(localObject2);
      }
    }
    label371:
    this.JTX.fPm();
    Log.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.lOt.size());
    AppMethodBeat.o(95486);
  }
  
  public final void aZT(String paramString)
  {
    AppMethodBeat.i(95536);
    b(paramString, null);
    AppMethodBeat.o(95536);
  }
  
  public final n aZU(String paramString)
  {
    AppMethodBeat.i(95537);
    if (this.JTW == null)
    {
      AppMethodBeat.o(95537);
      return null;
    }
    paramString = (n)this.JTW.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95537);
    return paramString;
  }
  
  public final int b(SnsInfo paramSnsInfo, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95522);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (Util.ticksToNow(this.JUh) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      d.bkm();
      if (!d.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.JUn = 5;
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
      this.JUo = ((PInt)localObject).value;
      this.JUh = Util.currentTicks();
      if ((this.JUo != 0) && (paramSnsInfo != null)) {
        break label144;
      }
      i = this.JUn;
      AppMethodBeat.o(95522);
      return i;
      this.JUn = 10;
      break;
    }
    label144:
    if (this.JUp.containsKey(Long.valueOf(paramSnsInfo.field_snsId)))
    {
      i = ((Integer)this.JUp.get(Long.valueOf(paramSnsInfo.field_snsId))).intValue();
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = new ekj();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.JUn;
        AppMethodBeat.o(95522);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.Tkb.UH);
      if ((paramArrayOfInt.Umf == null) || (paramArrayOfInt.Umf.fTp == null))
      {
        i = this.JUi;
        AppMethodBeat.o(95522);
        return i;
      }
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramSnsInfo, "", new Object[0]);
      i = this.JUn;
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.Umf.fTp;
    i = paramArrayOfInt.hashCode();
    if (this.JUo == 1)
    {
      if (!this.JUm.containsKey(Integer.valueOf(i))) {
        this.JUm.put(Integer.valueOf(i), Boolean.valueOf(gb(paramArrayOfInt, this.JUo)));
      }
      if (((Boolean)this.JUm.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        Log.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i) });
        this.JUp.put(Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95522);
        return i;
      }
    }
    if (!this.JUl.containsKey(Integer.valueOf(i))) {
      this.JUl.put(Integer.valueOf(i), Boolean.valueOf(gb(paramArrayOfInt, this.JUo)));
    }
    if (((Boolean)this.JUl.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final void b(cvt paramcvt, View paramView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95490);
    a(paramcvt, paramView, -1, paramInt, parambp);
    AppMethodBeat.o(95490);
  }
  
  protected final void b(String paramString, n paramn)
  {
    AppMethodBeat.i(95547);
    n localn = paramn;
    if (!t.b(paramn)) {
      localn = aZR(paramString);
    }
    if (t.b(localn))
    {
      if ((this.JTW != null) && (localn != null) && (paramString != null)) {
        this.JTW.put(paramString, localn);
      }
      paramn = (LinkedList)this.JTY.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((c)localObject).JUT) && (paramString != null) && (paramString.equals(((c)localObject).id)))
          {
            int i = ((c)localObject).code;
            localObject = (WeakReference)this.lOt.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.JUf != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.JUf.agO(i))) {
                      continue;
                    }
                  }
                }
                if ((t.b(localn)) && (localObject != null))
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
                    Log.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(t.b(localn)) });
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
  
  public final boolean b(cvt paramcvt, View paramView, int paramInt1, int paramInt2, bp parambp)
  {
    AppMethodBeat.i(95506);
    boolean bool = a(paramcvt, paramView, paramInt1, paramInt2, parambp, 1);
    AppMethodBeat.o(95506);
    return bool;
  }
  
  public final void c(cvt paramcvt, View paramView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(95505);
    if ((paramcvt == null) || (paramcvt.Id == null) || (paramcvt.Id.equals("")))
    {
      AppMethodBeat.o(95505);
      return;
    }
    String str = t.cq(4, paramcvt.Id);
    a(paramView, str, -1, paramInt);
    n localn = aZQ(str);
    boolean bool = t.b(localn);
    Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      go(paramView);
      if (!this.JUq.contains(str))
      {
        a(4, paramcvt, parambp);
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
    a(paramView, null, true, -1, paramInt3, -1, -1, g.a.JUO);
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
        ((ImageView)paramView).setImageDrawable(com.tencent.mm.ci.a.m(paramView.getContext(), paramInt2));
        AppMethodBeat.o(95544);
      }
    }
    else
    {
      if ((paramView instanceof QFadeImageView))
      {
        ((QFadeImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(com.tencent.mm.plugin.sns.i.c.BG_3)));
        AppMethodBeat.o(95544);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(com.tencent.mm.plugin.sns.i.c.BG_3)));
      }
    }
    AppMethodBeat.o(95544);
  }
  
  public final void fNW()
  {
    AppMethodBeat.i(95484);
    if (this.JTW != null)
    {
      this.lOt.clear();
      this.JTX.JZn.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.JTW.putCount() + ";");
      localStringBuffer.append("missCount:" + this.JTW.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.JTW.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.JTW.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.JTW.evictionCount() + ";");
      Log.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.JTW.trimToSize(-1);
    }
    this.JTX.fPm();
    System.gc();
    AppMethodBeat.o(95484);
  }
  
  public final void fNa()
  {
    AppMethodBeat.i(95548);
    fNW();
    this.JUg = 0L;
    this.JUh = 0L;
    this.JUa.clear();
    this.JUb = false;
    AppMethodBeat.o(95548);
  }
  
  public final void gm(View paramView)
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
  
  public final boolean gp(View paramView)
  {
    AppMethodBeat.i(95514);
    int i = paramView.hashCode();
    paramView = this.JUc.iterator();
    while (paramView.hasNext())
    {
      c localc = (c)paramView.next();
      if (i == localc.code) {
        this.JUc.remove(localc);
      }
    }
    this.lOt.remove(Integer.valueOf(i));
    AppMethodBeat.o(95514);
    return true;
  }
  
  public final boolean kA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95532);
    if ((this.JUd.containsKey(paramString1)) && (3 == ((Integer)this.JUd.get(paramString1)).intValue())) {
      this.JUd.remove(paramString1);
    }
    String str = t.cq(1, paramString1);
    Log.i("MicroMsg.LazyerImageLoader2", "TimeLineAdPreloadHelper, download video complete, mediaId=" + paramString1 + ", path=" + paramString2);
    Object localObject1 = (LinkedList)this.JTY.get(str);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95532);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((c)localObject2).JUT) && (str != null) && (str.equals(((c)localObject2).id)))
      {
        int i = ((c)localObject2).code;
        localObject2 = (WeakReference)this.lOt.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            av localav;
            if ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a))
            {
              Log.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
              if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof av))
              {
                localav = (av)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
                boolean bool;
                if (localav != null)
                {
                  if (u.agG(paramString2))
                  {
                    if (!this.JTH) {}
                    for (bool = true;; bool = false)
                    {
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).f(paramString2, bool, localav.position);
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localav.position);
                      localav.KKn.setVisibility(8);
                      localav.JAL.setVisibility(8);
                      localav.Ktc.setVisibility(8);
                      aZS(paramString1);
                      break;
                    }
                  }
                  setError(paramString1);
                  localav.KKn.setVisibility(8);
                  localav.JAL.setImageResource(i.e.sight_chat_error);
                  localav.JAL.setVisibility(0);
                }
                else
                {
                  if (!this.JTH) {}
                  for (bool = true;; bool = false)
                  {
                    ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).f(paramString2, bool, 0);
                    break;
                  }
                }
              }
            }
            else if ((localObject2 instanceof SnsAdTimelineVideoView))
            {
              Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (SnsAdTimelineVideoView)localObject2;
              if ((((SnsAdTimelineVideoView)localObject2).getTag() instanceof av))
              {
                localav = (av)((SnsAdTimelineVideoView)localObject2).getTag();
                if (localav != null)
                {
                  if (u.agG(paramString2))
                  {
                    ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                    ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                    localav.KKn.setVisibility(8);
                    localav.JAL.setVisibility(8);
                    localav.Ktc.setVisibility(8);
                    aZS(paramString1);
                  }
                  else
                  {
                    setError(paramString1);
                    localav.KKn.setVisibility(8);
                    localav.JAL.setImageResource(i.e.sight_chat_error);
                    localav.JAL.setVisibility(0);
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
    this.JTH = false;
    c localc = aj.fOD();
    localc.JTH = false;
    Object localObject3;
    synchronized (localc.mLock)
    {
      localObject2 = new LinkedList();
      localObject3 = localc.jmy.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        q localq = (q)((Iterator)localObject3).next();
        if (localq.requestType != 6)
        {
          localc.JTL.remove(localq.key);
          ((LinkedList)localObject2).add(localq);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (q)((Iterator)localObject2).next();
      localObject1.jmy.remove(localObject3);
    }
    localObject1.JTM.clear();
    localObject1.JTN.clear();
    AppMethodBeat.o(95482);
  }
  
  public final void start()
  {
    AppMethodBeat.i(95481);
    this.JTH = true;
    fNX();
    c localc = aj.fOD();
    localc.JTH = true;
    localc.blz();
    AppMethodBeat.o(95481);
  }
  
  public final boolean v(cvt paramcvt)
  {
    AppMethodBeat.i(95524);
    if (!this.JUd.containsKey(paramcvt.Id))
    {
      AppMethodBeat.o(95524);
      return false;
    }
    if (((Integer)this.JUd.get(paramcvt.Id)).intValue() == 1)
    {
      AppMethodBeat.o(95524);
      return true;
    }
    AppMethodBeat.o(95524);
    return false;
  }
  
  public final boolean w(cvt paramcvt)
  {
    AppMethodBeat.i(95525);
    if (!this.JUd.containsKey(paramcvt.Id))
    {
      AppMethodBeat.o(95525);
      return false;
    }
    if (((Integer)this.JUd.get(paramcvt.Id)).intValue() == 2)
    {
      AppMethodBeat.o(95525);
      return true;
    }
    AppMethodBeat.o(95525);
    return false;
  }
  
  public final boolean x(cvt paramcvt)
  {
    AppMethodBeat.i(95526);
    if (!this.JUd.containsKey(paramcvt.Id))
    {
      AppMethodBeat.o(95526);
      return false;
    }
    if (((Integer)this.JUd.get(paramcvt.Id)).intValue() == 3)
    {
      AppMethodBeat.o(95526);
      return true;
    }
    AppMethodBeat.o(95526);
    return false;
  }
  
  public final boolean y(cvt paramcvt)
  {
    AppMethodBeat.i(95527);
    if (!this.JUd.containsKey(paramcvt.Id))
    {
      AppMethodBeat.o(95527);
      return false;
    }
    if (((Integer)this.JUd.get(paramcvt.Id)).intValue() == 4)
    {
      AppMethodBeat.o(95527);
      return true;
    }
    AppMethodBeat.o(95527);
    return false;
  }
  
  public final void z(cvt paramcvt)
  {
    AppMethodBeat.i(95528);
    this.JUd.put(paramcvt.Id, Integer.valueOf(1));
    AppMethodBeat.o(95528);
  }
  
  final class b
    extends h<String, Integer, Boolean>
  {
    private int JUR;
    private cvt fVT;
    String key;
    private n ljR;
    private String mfn;
    private String path;
    
    public b(String paramString1, String paramString2, String paramString3, cvt paramcvt, int paramInt)
    {
      AppMethodBeat.i(95474);
      this.key = "";
      this.ljR = null;
      this.JUR = 0;
      g.this.JUq.add(paramString1);
      this.key = paramString1;
      this.path = paramString2;
      this.mfn = paramString3;
      this.fVT = paramcvt;
      this.JUR = paramInt;
      g.fdG();
      Log.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(g.bKj()) });
      AppMethodBeat.o(95474);
    }
    
    private void aF(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(95475);
      u.agG(this.mfn + paramString3);
      if (!u.agG(this.mfn + paramString1))
      {
        String str = paramString2;
        if (!u.agG(this.mfn + paramString2)) {
          str = t.l(this.fVT);
        }
        boolean bool = r.a(this.mfn, str, paramString1, aj.fOW());
        if (!bool)
        {
          Log.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
          u.deleteFile(this.mfn + str);
        }
        Log.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.mfn + str, this.mfn + paramString1, Boolean.valueOf(bool) });
      }
      r.b(this.mfn, paramString1, paramString3, aj.fOV());
      AppMethodBeat.o(95475);
    }
    
    public final ExecutorService fsl()
    {
      AppMethodBeat.i(179079);
      ExecutorService localExecutorService = aj.fOt();
      AppMethodBeat.o(179079);
      return localExecutorService;
    }
  }
  
  static final class c
  {
    public int JUS;
    public boolean JUT;
    public int code;
    public String id;
    
    public c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.id = paramString;
      this.code = paramInt1;
      this.JUS = paramInt2;
      this.JUT = paramBoolean;
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
    public abstract void au(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g
 * JD-Core Version:    0.7.0.1
 */
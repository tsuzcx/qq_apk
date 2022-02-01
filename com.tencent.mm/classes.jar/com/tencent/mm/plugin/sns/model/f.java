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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bf;
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
  private static int xQz = 0;
  private Map<Integer, WeakReference<Object>> hHz;
  public boolean xPQ;
  private long xQc;
  private long xQd;
  com.tencent.mm.memory.a.b<com.tencent.mm.memory.n> xQe;
  private al<String, WeakReference<Bitmap>> xQf;
  private Map<String, LinkedList<WeakReference<c>>> xQg;
  private ConcurrentHashMap<Integer, String> xQh;
  private LinkedList<b> xQi;
  private boolean xQj;
  private HashSet<c> xQk;
  public HashMap<String, Integer> xQl;
  private int xQm;
  public aa xQn;
  public long xQo;
  public long xQp;
  private int xQq;
  private int xQr;
  private HashMap<Long, Integer> xQs;
  private HashMap<Integer, Boolean> xQt;
  private HashMap<Integer, Boolean> xQu;
  private int xQv;
  private int xQw;
  private HashMap<Long, Integer> xQx;
  protected Set<String> xQy;
  
  public f()
  {
    AppMethodBeat.i(95483);
    this.xQc = 0L;
    this.xQd = 0L;
    this.hHz = new HashMap();
    this.xQg = new HashMap();
    this.xQh = new ConcurrentHashMap();
    this.xQi = new LinkedList();
    this.xQj = false;
    this.xQk = new HashSet();
    this.xQl = new HashMap();
    this.xQm = 4;
    this.xPQ = true;
    this.xQo = 0L;
    this.xQp = 0L;
    this.xQq = 0;
    this.xQr = 0;
    this.xQs = new HashMap();
    this.xQt = new HashMap();
    this.xQu = new HashMap();
    this.xQv = 0;
    this.xQw = 0;
    this.xQx = new HashMap();
    this.xQy = new HashSet();
    com.tencent.mm.memory.a.b.a(com.tencent.mm.memory.n.class, new b.a() {});
    int i = ((ActivityManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("activity")).getLargeMemoryClass();
    ac.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.xQe = new com.tencent.mm.memory.a.b(i, new com.tencent.mm.b.f.b() {}, getClass());
      this.xQf = new al(this.xQm, new al.a()
      {
        public final boolean dD(Object paramAnonymousObject)
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
              paramAnonymousObject = ((al.b)((al)localObject).xVa.get(str)).obj;
              if (!(paramAnonymousObject instanceof Bitmap)) {
                continue;
              }
              paramAnonymousObject = (Bitmap)paramAnonymousObject;
              if ((paramAnonymousObject != null) && (!paramAnonymousObject.isRecycled()))
              {
                ac.d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
                paramAnonymousObject.recycle();
              }
            }
            catch (Exception paramAnonymousObject)
            {
              int i;
              ac.printErrStackTrace("MicroMsg.SnsLRUMap", paramAnonymousObject, "", new Object[0]);
              ac.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
              continue;
              boolean bool = false;
              continue;
            }
            i = ((al)localObject).xVa.size();
            paramAnonymousObject = ((al)localObject).xVa.remove(str);
            localObject = new StringBuilder("internalMap ").append(((al)localObject).xVa.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              ac.d("MicroMsg.SnsLRUMap", bool);
              ac.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + f.a(f.this).xVa.size() + " listPaitSize:" + f.b(f.this).size());
              AppMethodBeat.o(95463);
              return true;
              paramAnonymousObject = (WeakReference)((al.b)((al)localObject).xVa.get(str)).obj;
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
  
  public static String C(btz parambtz)
  {
    AppMethodBeat.i(95541);
    if (parambtz == null)
    {
      AppMethodBeat.o(95541);
      return null;
    }
    if (parambtz.Id.startsWith("pre_temp_sns_pic")) {
      parambtz = af.getAccSnsTmpPath() + parambtz.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(95541);
      return parambtz;
      if (parambtz.Id.startsWith("Locall_path")) {
        parambtz = an.jc(af.getAccSnsPath(), parambtz.Id) + q.l(parambtz);
      } else if (parambtz.Id.startsWith("pre_temp_extend_pic")) {
        parambtz = parambtz.Id.substring(19);
      } else {
        parambtz = an.jc(af.getAccSnsPath(), parambtz.Id) + q.c(parambtz);
      }
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, bf parambf)
  {
    AppMethodBeat.i(95538);
    if ((!paramBoolean) && (bs.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    btz localbtz = com.tencent.mm.modelsns.g.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    q.bS(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = q.asW(paramString1);
      if (q.I(paramString1))
      {
        AppMethodBeat.o(95538);
        return paramString1;
      }
      AppMethodBeat.o(95538);
      return null;
    }
    if (q.I(null))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    Object localObject = q.k(localbtz);
    localObject = q.asW(an.jc(af.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!q.I((Bitmap)localObject)) {
      paramString3 = q.asW(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!bs.isNullOrNil(paramString2))) {
      af.dHM().a(localbtz, 3, null, parambf);
    }
    if (!q.I(paramString3))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    AppMethodBeat.o(95538);
    return paramString3;
  }
  
  private String a(com.tencent.mm.plugin.sns.storage.p paramp, final btz parambtz, final bf parambf, boolean paramBoolean)
  {
    AppMethodBeat.i(95531);
    if (u(parambtz))
    {
      AppMethodBeat.o(95531);
      return "";
    }
    String str1 = an.jc(af.getAccSnsPath(), parambtz.Id);
    String str2 = q.i(parambtz);
    if (i.eA(str1 + str2))
    {
      paramp = str1 + str2;
      AppMethodBeat.o(95531);
      return paramp;
    }
    if ((i.eA(str1 + q.o(parambtz))) && (parambtz.Id != null) && (parambtz.Id.startsWith("Locall_path")))
    {
      paramp = str1 + q.o(parambtz);
      AppMethodBeat.o(95531);
      return paramp;
    }
    if (!this.xPQ)
    {
      AppMethodBeat.o(95531);
      return "";
    }
    ac.i("MicroMsg.LazyerImageLoader2", "push sight loader " + parambtz.Id + " url: " + parambtz.Url);
    if (paramBoolean) {
      if (b(paramp, null) == 5) {
        af.cMM().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95470);
            af.dHM().a(parambtz, 4, null, parambf);
            AppMethodBeat.o(95470);
          }
        }, 0L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95531);
      return "";
      ac.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
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
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, f.a.xQW);
    AppMethodBeat.o(95510);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95512);
    a(paramObject, paramString, false, -1, paramInt1, paramInt2, paramInt3, f.a.xQW);
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
      ac.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.avX() });
    }
    Object localObject;
    long l1;
    if ((paramObject instanceof QFadeImageView))
    {
      paramObject = (QFadeImageView)paramObject;
      localObject = paramObject.getDrawable();
      l1 = l2;
      if (!bs.isNullOrNil(paramObject.getImageKey()))
      {
        l1 = l2;
        if (paramObject.getImageKey().equals(paramString)) {
          l1 = paramObject.getStartTimeMillis();
        }
      }
      if ((localObject == null) || (!(localObject instanceof ai))) {
        break label468;
      }
      l1 = ((ai)localObject).xUT;
    }
    label454:
    label468:
    for (;;)
    {
      paramn = new ai(paramString, paramn, l1);
      paramObject.J(paramn.xUT, paramString);
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
        if ((paramObject != null) && ((paramObject instanceof ai))) {}
        for (paramObject = new ai(paramString, paramn, ((ai)paramObject).xUT);; paramObject = new ai(paramString, paramn, 0L))
        {
          ((ImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof com.tencent.mm.plugin.sight.decode.a.a))
      {
        ac.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(paramString)));
        if ((paramObject instanceof SightPlayImageView))
        {
          localObject = (SightPlayImageView)paramObject;
          paramObject = ((SightPlayImageView)localObject).getDrawable();
          if ((paramObject == null) || (!(paramObject instanceof ai))) {
            break label361;
          }
        }
        label361:
        for (paramObject = new ai(paramString, paramn, ((ai)paramObject).xUT);; paramObject = new ai(paramString, paramn, 0L))
        {
          ((SightPlayImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof SnsAdTimelineVideoView))
      {
        ac.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setImageDrawable, key=".concat(String.valueOf(paramString)));
        localObject = (SnsAdTimelineVideoView)paramObject;
        paramObject = ((SnsAdTimelineVideoView)localObject).getThumbDrawable();
        if ((paramObject == null) || (!(paramObject instanceof ai))) {
          break label454;
        }
      }
      for (paramObject = new ai(paramString, paramn, ((ai)paramObject).xUT);; paramObject = new ai(paramString, paramn, 0L))
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
    this.xQk.remove(new c(null, i, 0, false));
    c localc = new c(paramString, i, paramInt2, paramBoolean);
    this.xQk.add(localc);
    LinkedList localLinkedList = (LinkedList)this.xQg.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.xQg.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.xQg.get(localObject);
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
        ac.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[] { localObject });
        localLinkedList.remove(paramInt2);
      }
      ((View)paramObject).setTag(2130706432, paramString);
      localObject = new WeakReference(paramObject);
      this.hHz.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label348;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == f.a.xQX) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
        {
          com.tencent.mm.sdk.platformtools.p.eUA();
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
            if (!this.xPQ) {}
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
        com.tencent.mm.sdk.platformtools.p.z((View)paramObject, paramInt3, paramInt4);
        ac.d("MicroMsg.LazyerImageLoader2", "try to setLayerType " + paramInt3 + " " + paramInt4);
      }
      AppMethodBeat.o(95513);
      return;
      label490:
      paramInt2 = -1;
    }
  }
  
  private boolean a(final int paramInt, final btz parambtz, final bf parambf)
  {
    AppMethodBeat.i(95517);
    if (!this.xPQ)
    {
      if ((parambtz != null) && (!bs.isNullOrNil(parambtz.Id))) {
        af.dHM().atA(parambtz.Id);
      }
      AppMethodBeat.o(95517);
      return false;
    }
    af.dHE().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95469);
        m localm;
        b localb;
        btz localbtz;
        if (!f.a(f.this, paramInt, parambtz))
        {
          localm = new m(parambtz);
          localm.xNy = paramInt;
          localm.dlj = parambtz.Id;
          localb = af.dHM();
          localbtz = parambtz;
          if (parambtz.ndI != 6) {
            break label97;
          }
        }
        label97:
        for (int i = 5;; i = 1)
        {
          localb.a(localbtz, i, localm, parambf);
          AppMethodBeat.o(95469);
          return;
        }
      }
    });
    AppMethodBeat.o(95517);
    return true;
  }
  
  public static boolean a(btz parambtz, bf parambf, boolean paramBoolean)
  {
    AppMethodBeat.i(95540);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95540);
      return false;
    }
    Object localObject;
    if (parambtz.Id.startsWith("Locall_path"))
    {
      localObject = an.jc(af.getAccSnsPath(), parambtz.Id) + q.l(parambtz);
      if (i.eA((String)localObject)) {
        break label161;
      }
      localObject = af.dHM();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 2)
    {
      ((b)localObject).a(parambtz, i, null, parambf);
      AppMethodBeat.o(95540);
      return false;
      localObject = an.jc(af.getAccSnsPath(), parambtz.Id) + q.c(parambtz);
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
      this.xQe.put(paramString, paramn);
    }
    AppMethodBeat.o(95534);
    return true;
  }
  
  private boolean a(final List<btz> paramList, final bf parambf)
  {
    AppMethodBeat.i(95515);
    af.dHE().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95466);
        long l = bs.Gn();
        Object localObject = new m(paramList);
        ((m)localObject).dlj = q.fs(paramList);
        ((m)localObject).xNy = this.xQB;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          btz localbtz = (btz)paramList.get(j);
          if (af.dHM().atv(localbtz.Id)) {
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
              } while (i.eA(an.jc(af.getAccSnsPath(), localbtz.Id) + q.d(localbtz)));
              i = k;
            } while (i.eA(an.jc(af.getAccSnsPath(), localbtz.Id) + q.k(localbtz)));
            i = k;
          } while (i.eA(an.jc(af.getAccSnsPath(), localbtz.Id) + q.l(localbtz)));
          b localb = af.dHM();
          if (localbtz.ndI == 6) {}
          for (int i = 5;; i = 1)
          {
            localb.a(localbtz, i, (m)localObject, parambf);
            i = 0;
            break;
          }
        }
        l = bs.aO(l);
        if (l > 100L) {
          ac.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.apb() + " " + af.dIi() + " " + ((m)localObject).dlj);
        }
        if (bs.aO(f.c(f.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), af.dIi(), com.tencent.mm.loader.j.b.apb() });
          f.a(f.this, bs.Gn());
        }
        localObject = q.fs(paramList);
        if (k != 0) {
          af.cMM().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95465);
              new h(q.bS(0, this.JY), this.JY, f.9.this.xQS).x(new String[] { "" });
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
  
  private boolean ar(View paramView, int paramInt)
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
      } while (!ar(paramView.getChildAt(j), paramInt));
      AppMethodBeat.o(95485);
      return true;
    }
    AppMethodBeat.o(95485);
    return false;
  }
  
  private com.tencent.mm.memory.n atD(String paramString)
  {
    AppMethodBeat.i(95492);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.xQe.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.xQe.remove(paramString);
      AppMethodBeat.o(95492);
      return null;
    }
    AppMethodBeat.o(95492);
    return localn;
  }
  
  private com.tencent.mm.memory.n atE(String paramString)
  {
    AppMethodBeat.i(95493);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.xQe.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.xQe.remove(paramString);
      AppMethodBeat.o(95493);
      return null;
    }
    AppMethodBeat.o(95493);
    return localn;
  }
  
  private boolean atF(String paramString)
  {
    AppMethodBeat.i(179083);
    if ((this.xQl.containsKey(paramString)) && (4 == ((Integer)this.xQl.get(paramString)).intValue())) {
      this.xQl.remove(paramString);
    }
    AppMethodBeat.o(179083);
    return true;
  }
  
  private void b(btz parambtz, View paramView, int paramInt, f.a parama, bf parambf)
  {
    AppMethodBeat.i(95497);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95497);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = q.bS(5, parambtz.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = atD(str);
    if (!q.b(parama))
    {
      eD(paramView);
      if (this.xQy.contains(str))
      {
        AppMethodBeat.o(95497);
        return;
      }
      a(5, parambtz, parambf);
      AppMethodBeat.o(95497);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95497);
  }
  
  private boolean dHj()
  {
    AppMethodBeat.i(95516);
    if (this.xQj)
    {
      ac.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(95516);
      return false;
    }
    af.cMM().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95467);
        if (f.d(f.this))
        {
          ac.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
          AppMethodBeat.o(95467);
          return;
        }
        if (f.e(f.this).size() > 0)
        {
          ac.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + f.e(f.this).size());
          ((f.b)f.e(f.this).removeLast()).x(new String[] { "" });
        }
        AppMethodBeat.o(95467);
      }
    }, 0L);
    AppMethodBeat.o(95516);
    return true;
  }
  
  private static void eD(View paramView)
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
  
  private static boolean ez(String paramString, int paramInt)
  {
    AppMethodBeat.i(95523);
    paramString = bv.L(paramString, "SightDownloadControl");
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(95523);
      return true;
    }
    if (paramInt == 1)
    {
      if (bs.getInt((String)paramString.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1)
      {
        AppMethodBeat.o(95523);
        return true;
      }
      AppMethodBeat.o(95523);
      return false;
    }
    if (bs.getInt((String)paramString.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1)
    {
      AppMethodBeat.o(95523);
      return true;
    }
    AppMethodBeat.o(95523);
    return false;
  }
  
  public static String q(btz parambtz)
  {
    AppMethodBeat.i(95489);
    String str = an.jc(af.getAccSnsPath(), parambtz.Id);
    parambtz = q.d(parambtz);
    parambtz = str + parambtz;
    AppMethodBeat.o(95489);
    return parambtz;
  }
  
  public static String r(btz parambtz)
  {
    AppMethodBeat.i(95499);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95499);
      return null;
    }
    String str = an.jc(af.getAccSnsPath(), parambtz.Id) + q.d(parambtz);
    if (!i.eA(str))
    {
      parambtz = parambtz.Fjh;
      AppMethodBeat.o(95499);
      return parambtz;
    }
    AppMethodBeat.o(95499);
    return str;
  }
  
  public static String s(btz parambtz)
  {
    AppMethodBeat.i(95500);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95500);
      return null;
    }
    String str = an.jc(af.getAccSnsPath(), parambtz.Id) + q.c(parambtz);
    if (!i.eA(str))
    {
      parambtz = parambtz.Url;
      AppMethodBeat.o(95500);
      return parambtz;
    }
    AppMethodBeat.o(95500);
    return str;
  }
  
  private void setError(String paramString)
  {
    AppMethodBeat.i(179084);
    this.xQl.put(paramString, Integer.valueOf(4));
    AppMethodBeat.o(179084);
  }
  
  public static boolean t(btz parambtz)
  {
    AppMethodBeat.i(95518);
    String str1 = an.jc(af.getAccSnsPath(), parambtz.Id);
    String str2 = q.i(parambtz);
    if (i.eA(str1 + str2))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    if ((i.eA(str1 + q.o(parambtz))) && (!bs.isNullOrNil(parambtz.Id)) && (parambtz.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    AppMethodBeat.o(95518);
    return false;
  }
  
  public final void A(btz parambtz)
  {
    AppMethodBeat.i(95530);
    this.xQl.put(parambtz.Id, Integer.valueOf(3));
    AppMethodBeat.o(95530);
  }
  
  public final boolean B(btz parambtz)
  {
    AppMethodBeat.i(95539);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95539);
      return false;
    }
    if (i.eA(an.jc(af.getAccSnsPath(), parambtz.Id) + q.e(parambtz)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    if (i.eA(an.jc(af.getAccSnsPath(), parambtz.Id) + q.d(parambtz)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    parambtz = q.bS(1, parambtz.Id);
    boolean bool = q.b((com.tencent.mm.memory.n)this.xQe.get(parambtz));
    AppMethodBeat.o(95539);
    return bool;
  }
  
  public final int a(com.tencent.mm.plugin.sns.storage.p paramp, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95520);
    Object localObject;
    PInt localPInt1;
    PInt localPInt2;
    if ((paramArrayOfInt != null) || (bs.aO(this.xQo) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      c.aDI();
      if (!c.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.xQq = 5;
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
      this.xQr = ((PInt)localObject).value;
      this.xQo = bs.Gn();
      if ((this.xQr != 0) && (paramp != null)) {
        break label163;
      }
      i = this.xQq;
      AppMethodBeat.o(95520);
      return i;
      this.xQq = 10;
      break;
    }
    label163:
    if (this.xQs.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.xQs.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = new dau();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.xQq;
        AppMethodBeat.o(95520);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.FJT == null) || (paramArrayOfInt.FJT.info == null))
      {
        i = this.xQq;
        AppMethodBeat.o(95520);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ac.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.xQq;
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.FJT.info;
    i = paramArrayOfInt.hashCode();
    if (this.xQr == 1)
    {
      if (!this.xQu.containsKey(Integer.valueOf(i))) {
        this.xQu.put(Integer.valueOf(i), Boolean.valueOf(ez(paramArrayOfInt, this.xQr)));
      }
      if (((Boolean)this.xQu.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ac.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.xQs.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95520);
        return i;
      }
    }
    if (!this.xQt.containsKey(Integer.valueOf(i))) {
      this.xQt.put(Integer.valueOf(i), Boolean.valueOf(ez(paramArrayOfInt, this.xQr)));
    }
    if (((Boolean)this.xQt.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(btz parambtz)
  {
    AppMethodBeat.i(95488);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95488);
      return null;
    }
    String str1 = q.bS(1, parambtz.Id);
    Object localObject = atD(str1);
    if (q.b((com.tencent.mm.memory.n)localObject))
    {
      parambtz = ((com.tencent.mm.memory.n)localObject).avS();
      AppMethodBeat.o(95488);
      return parambtz;
    }
    localObject = an.jc(af.getAccSnsPath(), parambtz.Id);
    String str2 = q.d(parambtz);
    localObject = (String)localObject + str2;
    if (i.eA((String)localObject))
    {
      if (parambtz.Id.startsWith("pre_temp_extend_pic")) {}
      for (parambtz = com.tencent.mm.memory.n.D(u.avn((String)localObject)); q.b(parambtz); parambtz = q.asX((String)localObject))
      {
        a(str1, parambtz);
        parambtz = parambtz.avS();
        AppMethodBeat.o(95488);
        return parambtz;
      }
      AppMethodBeat.o(95488);
      return null;
    }
    AppMethodBeat.o(95488);
    return null;
  }
  
  public final com.tencent.mm.memory.n a(btz parambtz, ImageView paramImageView, int paramInt, bf parambf)
  {
    AppMethodBeat.i(95543);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95543);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = q.bS(0, parambtz.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = atD(str);
    if (!q.b(paramImageView))
    {
      a(0, parambtz, parambf);
      AppMethodBeat.o(95543);
      return null;
    }
    AppMethodBeat.o(95543);
    return paramImageView;
  }
  
  public final void a(btz parambtz, View paramView, int paramInt1, int paramInt2, f.a parama, bf parambf)
  {
    AppMethodBeat.i(95496);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95496);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = q.bS(0, parambtz.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = atD(str);
    if (!q.b(parama))
    {
      ac.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        eD(paramView);
      }
      if (this.xQy.contains(str))
      {
        AppMethodBeat.o(95496);
        return;
      }
      a(0, parambtz, parambf);
      AppMethodBeat.o(95496);
      return;
    }
    ac.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    af.dHM().atA(parambtz.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(95496);
  }
  
  public final void a(btz parambtz, View paramView, int paramInt1, int paramInt2, bf parambf)
  {
    AppMethodBeat.i(95494);
    a(parambtz, paramView, paramInt1, paramInt2, f.a.xQW, parambf);
    AppMethodBeat.o(95494);
  }
  
  public final void a(btz parambtz, View paramView, int paramInt, f.a parama, bf parambf)
  {
    AppMethodBeat.i(95491);
    a(parambtz, paramView, -1, paramInt, parama, parambf);
    AppMethodBeat.o(95491);
  }
  
  public final void a(btz parambtz, View paramView, int paramInt, bf parambf)
  {
    AppMethodBeat.i(95501);
    b(parambtz, paramView, -1, paramInt, parambf);
    AppMethodBeat.o(95501);
  }
  
  public final void a(final btz parambtz, final View paramView, final int paramInt, final boolean paramBoolean1, final bf parambf, final boolean paramBoolean2, final e parame)
  {
    AppMethodBeat.i(95542);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95542);
      return;
    }
    final String str1 = q.bS(3, parambtz.Id);
    final String str2 = C(parambtz);
    if (af.dHM().atw(parambtz.Id))
    {
      ac.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + parambtz.Id);
      a(paramView, str1, paramInt, -1, -1);
      parame.aj(null);
      AppMethodBeat.o(95542);
      return;
    }
    Object localObject1 = this.xQf;
    Object localObject2 = (al.b)((al)localObject1).xVa.get(str1);
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
      ac.i("MicroMsg.LazyerImageLoader2", bool);
      if (localObject1 != null) {
        break label292;
      }
    }
    label286:
    label292:
    for (localObject1 = null;; localObject1 = (Bitmap)((WeakReference)localObject1).get())
    {
      if (!q.I((Bitmap)localObject1)) {
        break label305;
      }
      ac.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
      a(paramView, str1, paramInt, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      parame.aj((Bitmap)localObject1);
      AppMethodBeat.o(95542);
      return;
      ((al.b)((al)localObject1).xVa.get(str1)).dIt();
      localObject1 = ((al.b)localObject2).obj;
      break;
      bool = false;
      break label185;
    }
    label305:
    af.dHC().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95459);
        final Bitmap localBitmap = q.asW(str2);
        af.cMM().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95458);
            if (q.I(localBitmap))
            {
              f.a(f.this, f.4.this.xPi, f.4.this.xQE, f.4.this.xQF, localBitmap.getWidth(), localBitmap.getHeight());
              if (!q.I(localBitmap)) {
                break label252;
              }
              localObject1 = f.a(f.this);
              localObject2 = f.4.this.xQE;
              localObject3 = new WeakReference(localBitmap);
              if ((al.b)((al)localObject1).xVa.get(localObject2) != null) {
                break label215;
              }
              localObject3 = new al.b((al)localObject1, localObject3);
              ((al)localObject1).xVa.put(localObject2, localObject3);
              ((al)localObject1).dIs();
            }
            label215:
            label252:
            while (!f.4.this.xQG) {
              for (;;)
              {
                Object localObject3;
                if (f.4.this.xQJ != null) {
                  f.4.this.xQJ.aj(localBitmap);
                }
                AppMethodBeat.o(95458);
                return;
                f.a(f.this, f.4.this.xPi, f.4.this.xQE, f.4.this.xQF, -1, -1);
                break;
                ((al.b)((al)localObject1).xVa.get(localObject2)).dIt();
                ((al.b)((al)localObject1).xVa.get(localObject2)).obj = localObject3;
              }
            }
            Object localObject1 = af.dHM();
            Object localObject2 = f.4.this.xLX;
            if (f.4.this.xQH) {}
            for (int i = 8;; i = 2)
            {
              ((b)localObject1).a((btz)localObject2, i, null, f.4.this.xQI);
              break;
            }
          }
        });
        AppMethodBeat.o(95459);
      }
    });
    AppMethodBeat.o(95542);
  }
  
  public final void a(final String paramString, SparseArray<btz> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, final bf parambf, final int paramInt2)
  {
    AppMethodBeat.i(95495);
    ac.i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
    if ((paramSparseArray == null) || (paramSparseArray.size() <= 0))
    {
      ac.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    if ((paramSparseArray1 == null) || (paramSparseArray1.size() <= 0))
    {
      ac.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    int j = paramSparseArray.size();
    int k = paramSparseArray1.size();
    if (j == k) {}
    for (int i = j; -1 == i; i = -1)
    {
      ac.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
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
      btz localbtz = (btz)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = q.bS(0, localbtz.Id);
      a(localView, str, -1, paramInt1, f.a.xQW);
      com.tencent.mm.memory.n localn = atD(str);
      if (!q.b(localn))
      {
        ac.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        eD(localView);
        if (!this.xQy.contains(str)) {
          localSparseArray1.put(k, localbtz);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ac.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
        a(localView, str, localn);
      }
    }
    if (localSparseArray1.size() != 0)
    {
      ac.i("MicroMsg.LazyerImageLoader2", "ok, let's download.");
      af.dHE().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95464);
          int j = localSparseArray1.size();
          int i = 0;
          while (i < j)
          {
            int k = localSparseArray1.keyAt(i);
            btz localbtz = (btz)localSparseArray1.get(k);
            if (!f.a(f.this, 0, localbtz))
            {
              m localm = new m(localbtz);
              localm.xNy = 0;
              localm.dlj = localbtz.Id;
              localSparseArray2.put(k, localm);
              localSparseArray3.put(k, localbtz);
            }
            i += 1;
          }
          if (localSparseArray3.size() > 0) {
            af.dHM().a(paramString, localSparseArray3, localSparseArray2, parambf, paramInt2);
          }
          AppMethodBeat.o(95464);
        }
      });
    }
    AppMethodBeat.o(95495);
  }
  
  public final void a(List<btz> paramList, View paramView, int paramInt, f.a parama, bf parambf)
  {
    AppMethodBeat.i(95545);
    a(paramList, paramView, paramInt, parama, parambf, false);
    AppMethodBeat.o(95545);
  }
  
  public final void a(List<btz> paramList, View paramView, int paramInt, f.a parama, bf parambf, boolean paramBoolean)
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
        b((btz)paramList.get(0), paramView, paramInt, parambf);
        AppMethodBeat.o(95546);
        return;
      }
      b((btz)paramList.get(0), paramView, paramInt, f.a.xQX, parambf);
      AppMethodBeat.o(95546);
      return;
    }
    String str = q.bS(0, q.fs(paramList));
    a(paramView, str, paramInt, parama);
    parama = atD(str);
    paramBoolean = q.b(parama);
    ac.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      eD(paramView);
      if (this.xQy.contains(str))
      {
        AppMethodBeat.o(95546);
        return;
      }
      new WeakReference(paramView);
      a(paramList, parambf);
      AppMethodBeat.o(95546);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95546);
  }
  
  public final boolean a(m paramm, String paramString)
  {
    AppMethodBeat.i(95535);
    Object localObject1 = (btz)paramm.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < paramm.list.size())
    {
      localObject2 = (btz)paramm.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((btz)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = an.jc(af.getAccSnsPath(), ((btz)localObject1).Id);
      if (paramm.xNy == 0) {
        paramString = q.e((btz)localObject1);
      }
      for (;;)
      {
        String str = q.bS(paramm.xNy, ((btz)localObject1).Id);
        if (!this.xQe.aK(str)) {
          new b(q.bS(paramm.xNy, ((btz)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (btz)localObject1, paramm.xNy).x(new String[] { "" });
        }
        AppMethodBeat.o(95535);
        return true;
        i += 1;
        break;
        if (paramm.xNy == 4) {
          paramString = q.f((btz)localObject1);
        } else if (paramm.xNy == 5) {
          paramString = q.f((btz)localObject1);
        } else if (paramm.xNy == 3) {
          paramString = q.k((btz)localObject1);
        } else {
          paramString = q.d((btz)localObject1);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.p paramp, btz parambtz, SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt, bf parambf, boolean paramBoolean)
  {
    AppMethodBeat.i(179081);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(179081);
      return false;
    }
    String str1 = q.bS(1, parambtz.Id);
    a(paramSnsAdTimelineVideoView, str1, -1, paramInt);
    String str2 = an.jc(af.getAccSnsPath(), parambtz.Id);
    String str3 = q.d(parambtz);
    Object localObject;
    b localb;
    if (!i.eA(str2 + str3))
    {
      localObject = new m(parambtz);
      ((m)localObject).xNy = 1;
      ((m)localObject).dlj = parambtz.Id;
      localb = af.dHM();
      if (parambtz.ndI != 6) {
        break label293;
      }
    }
    label293:
    for (paramInt = 5;; paramInt = 1)
    {
      localb.a(parambtz, paramInt, (m)localObject, parambf);
      localObject = "";
      if (paramBoolean) {
        localObject = a(paramp, parambtz, parambf, paramBoolean);
      }
      ac.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean) });
      if ((bs.isNullOrNil((String)localObject)) || (u(parambtz))) {
        break;
      }
      if (!((String)localObject).equals(paramSnsAdTimelineVideoView.getVideoPath()))
      {
        paramSnsAdTimelineVideoView.setThumbBmp(com.tencent.mm.sdk.platformtools.f.decodeFile(str2 + str3));
        ac.i("MicroMsg.SnsAdTimelineVideoView", "showVideoThumb:true");
        paramSnsAdTimelineVideoView.c(false, 0.0F);
      }
      paramSnsAdTimelineVideoView.setVideoPath((String)localObject);
      AppMethodBeat.o(179081);
      return true;
    }
    ac.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, sightPath %s", new Object[] { localObject });
    paramSnsAdTimelineVideoView.setVideoPath(null);
    paramSnsAdTimelineVideoView.clear();
    paramp = atD(str1);
    paramBoolean = q.b(paramp);
    ac.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      paramSnsAdTimelineVideoView.setThumbBmp(null);
      if (this.xQy.contains(str1))
      {
        AppMethodBeat.o(179081);
        return false;
      }
      a(1, parambtz, parambf);
      AppMethodBeat.o(179081);
      return false;
    }
    a(paramSnsAdTimelineVideoView, str1, paramp);
    AppMethodBeat.o(179081);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.p paramp, btz parambtz, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bf parambf, boolean paramBoolean)
  {
    AppMethodBeat.i(176251);
    paramBoolean = a(paramp, parambtz, paramVideoSightView, paramInt1, paramInt2, parambf, paramBoolean, false);
    AppMethodBeat.o(176251);
    return paramBoolean;
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.p paramp, btz parambtz, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bf parambf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176252);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(176252);
      return false;
    }
    String str1 = q.bS(1, parambtz.Id);
    a(paramVideoSightView, str1, -1, paramInt1);
    String str2 = an.jc(af.getAccSnsPath(), parambtz.Id);
    String str3 = q.d(parambtz);
    Object localObject;
    if (!i.eA(str2 + str3))
    {
      localObject = new m(parambtz);
      ((m)localObject).xNy = 1;
      ((m)localObject).dlj = parambtz.Id;
      b localb = af.dHM();
      if (parambtz.ndI == 6)
      {
        paramInt1 = 5;
        localb.a(parambtz, paramInt1, (m)localObject, parambf);
      }
    }
    else
    {
      localObject = "";
      if (paramBoolean1) {
        localObject = a(paramp, parambtz, parambf, paramBoolean1);
      }
      ac.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean1) });
      if ((bs.isNullOrNil((String)localObject)) || (u(parambtz))) {
        break label302;
      }
      if (!((String)localObject).equals(paramVideoSightView.getVideoPath())) {
        if (!paramBoolean2) {
          break label297;
        }
      }
    }
    label297:
    for (paramp = com.tencent.mm.sdk.platformtools.f.decodeFile(str2 + str3);; paramp = null)
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
    ac.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject });
    paramVideoSightView.setVideoPath(null);
    paramVideoSightView.clear();
    paramp = atD(str1);
    paramBoolean1 = q.b(paramp);
    ac.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!paramBoolean1)
    {
      paramVideoSightView.setPosition(0);
      paramVideoSightView.setThumbBmp(null);
      if (this.xQy.contains(str1))
      {
        AppMethodBeat.o(176252);
        return false;
      }
      a(1, parambtz, parambf);
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
  
  public final boolean a(btz parambtz, View paramView, int paramInt1, int paramInt2, bf parambf, int paramInt3)
  {
    AppMethodBeat.i(95507);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95507);
      return false;
    }
    String str = q.bS(paramInt3, parambtz.Id);
    a(paramView, str, paramInt1, paramInt2);
    com.tencent.mm.memory.n localn = atD(str);
    boolean bool = q.b(localn);
    ac.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        eD(paramView);
      }
      if (this.xQy.contains(str))
      {
        AppMethodBeat.o(95507);
        return true;
      }
      a(paramInt3, parambtz, parambf);
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
    ac.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.hHz.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.xQk.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (ar(paramActivity.getWindow().getDecorView(), ((c)localObject3).code)) {
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
      this.hHz.remove(Integer.valueOf(i));
      localObject3 = this.xQk.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        c localc = (c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.xQk.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.xQk.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (((c)localObject3).xRa == paramActivity.hashCode()) {
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
      this.hHz.remove(Integer.valueOf(i));
      localObject1 = this.xQk.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (((c)localObject2).code != i) {
          break;
        }
        this.xQk.remove(localObject2);
      }
    }
    label371:
    this.xQf.dIs();
    ac.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.hHz.size());
    AppMethodBeat.o(95486);
  }
  
  public final void atG(String paramString)
  {
    AppMethodBeat.i(95536);
    b(paramString, null);
    AppMethodBeat.o(95536);
  }
  
  public final com.tencent.mm.memory.n atH(String paramString)
  {
    AppMethodBeat.i(95537);
    if (this.xQe == null)
    {
      AppMethodBeat.o(95537);
      return null;
    }
    paramString = (com.tencent.mm.memory.n)this.xQe.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95537);
    return paramString;
  }
  
  public final int b(com.tencent.mm.plugin.sns.storage.p paramp, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95522);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (bs.aO(this.xQp) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      c.aDI();
      if (!c.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.xQv = 5;
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
      this.xQw = ((PInt)localObject).value;
      this.xQp = bs.Gn();
      if ((this.xQw != 0) && (paramp != null)) {
        break label144;
      }
      i = this.xQv;
      AppMethodBeat.o(95522);
      return i;
      this.xQv = 10;
      break;
    }
    label144:
    if (this.xQx.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.xQx.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = new dau();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.xQv;
        AppMethodBeat.o(95522);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.FJT == null) || (paramArrayOfInt.FJT.info == null))
      {
        i = this.xQq;
        AppMethodBeat.o(95522);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ac.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.xQv;
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.FJT.info;
    i = paramArrayOfInt.hashCode();
    if (this.xQw == 1)
    {
      if (!this.xQu.containsKey(Integer.valueOf(i))) {
        this.xQu.put(Integer.valueOf(i), Boolean.valueOf(ez(paramArrayOfInt, this.xQw)));
      }
      if (((Boolean)this.xQu.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ac.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.xQx.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95522);
        return i;
      }
    }
    if (!this.xQt.containsKey(Integer.valueOf(i))) {
      this.xQt.put(Integer.valueOf(i), Boolean.valueOf(ez(paramArrayOfInt, this.xQw)));
    }
    if (((Boolean)this.xQt.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final void b(btz parambtz, View paramView, int paramInt, bf parambf)
  {
    AppMethodBeat.i(95490);
    a(parambtz, paramView, -1, paramInt, parambf);
    AppMethodBeat.o(95490);
  }
  
  protected final void b(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(95547);
    com.tencent.mm.memory.n localn = paramn;
    if (!q.b(paramn)) {
      localn = atE(paramString);
    }
    if (q.b(localn))
    {
      if ((this.xQe != null) && (localn != null) && (paramString != null)) {
        this.xQe.put(paramString, localn);
      }
      paramn = (LinkedList)this.xQg.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((c)localObject).xRb) && (paramString != null) && (paramString.equals(((c)localObject).id)))
          {
            int i = ((c)localObject).code;
            localObject = (WeakReference)this.hHz.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.xQn != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.xQn.Pm(i))) {
                      continue;
                    }
                  }
                }
                if ((q.b(localn)) && (localObject != null))
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
                    ac.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(q.b(localn)) });
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
  
  public final boolean b(btz parambtz, View paramView, int paramInt1, int paramInt2, bf parambf)
  {
    AppMethodBeat.i(95506);
    boolean bool = a(parambtz, paramView, paramInt1, paramInt2, parambf, 1);
    AppMethodBeat.o(95506);
    return bool;
  }
  
  public final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95544);
    a(paramView, null, true, -1, paramInt3, -1, -1, f.a.xQW);
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
  
  public final void c(btz parambtz, View paramView, int paramInt, bf parambf)
  {
    AppMethodBeat.i(95505);
    if ((parambtz == null) || (parambtz.Id == null) || (parambtz.Id.equals("")))
    {
      AppMethodBeat.o(95505);
      return;
    }
    String str = q.bS(4, parambtz.Id);
    a(paramView, str, -1, paramInt);
    com.tencent.mm.memory.n localn = atD(str);
    boolean bool = q.b(localn);
    ac.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      eD(paramView);
      if (!this.xQy.contains(str))
      {
        a(4, parambtz, parambf);
        AppMethodBeat.o(95505);
      }
    }
    else
    {
      a(paramView, str, localn);
    }
    AppMethodBeat.o(95505);
  }
  
  public final void dGo()
  {
    AppMethodBeat.i(95548);
    dHi();
    this.xQo = 0L;
    this.xQp = 0L;
    this.xQi.clear();
    this.xQj = false;
    AppMethodBeat.o(95548);
  }
  
  public final void dHi()
  {
    AppMethodBeat.i(95484);
    if (this.xQe != null)
    {
      this.hHz.clear();
      this.xQf.xVa.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.xQe.putCount() + ";");
      localStringBuffer.append("missCount:" + this.xQe.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.xQe.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.xQe.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.xQe.evictionCount() + ";");
      ac.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.xQe.trimToSize(-1);
    }
    this.xQf.dIs();
    System.gc();
    AppMethodBeat.o(95484);
  }
  
  public final void eB(View paramView)
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
  
  public final boolean eE(View paramView)
  {
    AppMethodBeat.i(95514);
    int i = paramView.hashCode();
    paramView = this.xQk.iterator();
    while (paramView.hasNext())
    {
      c localc = (c)paramView.next();
      if (i == localc.code) {
        this.xQk.remove(localc);
      }
    }
    this.hHz.remove(Integer.valueOf(i));
    AppMethodBeat.o(95514);
    return true;
  }
  
  public final boolean iZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95532);
    if ((this.xQl.containsKey(paramString1)) && (3 == ((Integer)this.xQl.get(paramString1)).intValue())) {
      this.xQl.remove(paramString1);
    }
    String str = q.bS(1, paramString1);
    ac.i("MicroMsg.LazyerImageLoader2", "TimeLineAdPreloadHelper, download video complete, mediaId=" + paramString1 + ", path=" + paramString2);
    Object localObject1 = (LinkedList)this.xQg.get(str);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95532);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((c)localObject2).xRb) && (str != null) && (str.equals(((c)localObject2).id)))
      {
        int i = ((c)localObject2).code;
        localObject2 = (WeakReference)this.hHz.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.sns.ui.an localan;
            if ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a))
            {
              ac.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
              if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof com.tencent.mm.plugin.sns.ui.an))
              {
                localan = (com.tencent.mm.plugin.sns.ui.an)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
                boolean bool;
                if (localan != null)
                {
                  if (i.eA(paramString2))
                  {
                    if (!this.xPQ) {}
                    for (bool = true;; bool = false)
                    {
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).e(paramString2, bool, localan.position);
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localan.position);
                      localan.yFg.setVisibility(8);
                      localan.yoI.setVisibility(8);
                      localan.yoJ.setVisibility(8);
                      atF(paramString1);
                      break;
                    }
                  }
                  setError(paramString1);
                  localan.yFg.setVisibility(8);
                  localan.yoI.setImageResource(2131234034);
                  localan.yoI.setVisibility(0);
                }
                else
                {
                  if (!this.xPQ) {}
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
              ac.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (SnsAdTimelineVideoView)localObject2;
              if ((((SnsAdTimelineVideoView)localObject2).getTag() instanceof com.tencent.mm.plugin.sns.ui.an))
              {
                localan = (com.tencent.mm.plugin.sns.ui.an)((SnsAdTimelineVideoView)localObject2).getTag();
                if (localan != null)
                {
                  if (i.eA(paramString2))
                  {
                    ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                    ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                    localan.yFg.setVisibility(8);
                    localan.yoI.setVisibility(8);
                    localan.yoJ.setVisibility(8);
                    atF(paramString1);
                  }
                  else
                  {
                    setError(paramString1);
                    localan.yFg.setVisibility(8);
                    localan.yoI.setImageResource(2131234034);
                    localan.yoI.setVisibility(0);
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
    this.xPQ = false;
    b localb = af.dHM();
    localb.xPQ = false;
    Object localObject3;
    synchronized (localb.mLock)
    {
      localObject2 = new LinkedList();
      localObject3 = localb.fBS.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.sns.data.n localn = (com.tencent.mm.plugin.sns.data.n)((Iterator)localObject3).next();
        if (localn.requestType != 6)
        {
          localb.xPT.remove(localn.key);
          ((LinkedList)localObject2).add(localn);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.sns.data.n)((Iterator)localObject2).next();
      localObject1.fBS.remove(localObject3);
    }
    localObject1.xPU.clear();
    localObject1.xPV.clear();
    AppMethodBeat.o(95482);
  }
  
  public final int q(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(95519);
    int i = a(paramp, null);
    AppMethodBeat.o(95519);
    return i;
  }
  
  public final int r(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(210263);
    int i = b(paramp, null);
    AppMethodBeat.o(210263);
    return i;
  }
  
  public final void start()
  {
    AppMethodBeat.i(95481);
    this.xPQ = true;
    dHj();
    b localb = af.dHM();
    localb.xPQ = true;
    localb.aEU();
    AppMethodBeat.o(95481);
  }
  
  public final boolean u(btz parambtz)
  {
    AppMethodBeat.i(95524);
    if (!this.xQl.containsKey(parambtz.Id))
    {
      AppMethodBeat.o(95524);
      return false;
    }
    if (((Integer)this.xQl.get(parambtz.Id)).intValue() == 1)
    {
      AppMethodBeat.o(95524);
      return true;
    }
    AppMethodBeat.o(95524);
    return false;
  }
  
  public final boolean v(btz parambtz)
  {
    AppMethodBeat.i(95525);
    if (!this.xQl.containsKey(parambtz.Id))
    {
      AppMethodBeat.o(95525);
      return false;
    }
    if (((Integer)this.xQl.get(parambtz.Id)).intValue() == 2)
    {
      AppMethodBeat.o(95525);
      return true;
    }
    AppMethodBeat.o(95525);
    return false;
  }
  
  public final boolean w(btz parambtz)
  {
    AppMethodBeat.i(95526);
    if (!this.xQl.containsKey(parambtz.Id))
    {
      AppMethodBeat.o(95526);
      return false;
    }
    if (((Integer)this.xQl.get(parambtz.Id)).intValue() == 3)
    {
      AppMethodBeat.o(95526);
      return true;
    }
    AppMethodBeat.o(95526);
    return false;
  }
  
  public final boolean x(btz parambtz)
  {
    AppMethodBeat.i(95527);
    if (!this.xQl.containsKey(parambtz.Id))
    {
      AppMethodBeat.o(95527);
      return false;
    }
    if (((Integer)this.xQl.get(parambtz.Id)).intValue() == 4)
    {
      AppMethodBeat.o(95527);
      return true;
    }
    AppMethodBeat.o(95527);
    return false;
  }
  
  public final void y(btz parambtz)
  {
    AppMethodBeat.i(95528);
    this.xQl.put(parambtz.Id, Integer.valueOf(1));
    AppMethodBeat.o(95528);
  }
  
  public final void z(btz parambtz)
  {
    AppMethodBeat.i(95529);
    this.xQl.put(parambtz.Id, Integer.valueOf(2));
    AppMethodBeat.o(95529);
  }
  
  final class b
    extends g<String, Integer, Boolean>
  {
    private btz dwE;
    private String hYj;
    private com.tencent.mm.memory.n hfF;
    String key;
    private String path;
    private int xQZ;
    
    public b(String paramString1, String paramString2, String paramString3, btz parambtz, int paramInt)
    {
      AppMethodBeat.i(95474);
      this.key = "";
      this.hfF = null;
      this.xQZ = 0;
      f.this.xQy.add(paramString1);
      this.key = paramString1;
      this.path = paramString2;
      this.hYj = paramString3;
      this.dwE = parambtz;
      this.xQZ = paramInt;
      f.dhY();
      ac.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(f.aZA()) });
      AppMethodBeat.o(95474);
    }
    
    private void at(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(95475);
      i.eA(this.hYj + paramString3);
      if (!i.eA(this.hYj + paramString1))
      {
        String str = paramString2;
        if (!i.eA(this.hYj + paramString2)) {
          str = q.l(this.dwE);
        }
        boolean bool = u.a(this.hYj, str, paramString1, af.dId());
        if (!bool)
        {
          ac.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
          i.deleteFile(this.hYj + str);
        }
        ac.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.hYj + str, this.hYj + paramString1, Boolean.valueOf(bool) });
      }
      u.b(this.hYj, paramString1, paramString3, af.dIc());
      AppMethodBeat.o(95475);
    }
    
    private Boolean dHl()
    {
      AppMethodBeat.i(95476);
      f.a(f.this, true);
      Object localObject;
      if (!f.h(f.this))
      {
        ac.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      if (f.f(f.this).aK(this.key))
      {
        ac.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      i.aSv(this.hYj);
      long l1 = System.currentTimeMillis();
      long l2;
      if (!i.eA(this.path))
      {
        at(q.d(this.dwE), q.k(this.dwE), q.e(this.dwE));
        l2 = bs.Gn();
        if (this.xQZ != 5) {
          break label769;
        }
        if (!i.eA(this.path)) {
          at(q.d(this.dwE), q.k(this.dwE), q.e(this.dwE));
        }
        bool1 = i.eA(this.hYj + q.d(this.dwE));
        boolean bool2 = i.eA(this.hYj + q.k(this.dwE));
        boolean bool3 = i.eA(this.hYj + q.e(this.dwE));
        this.hfF = q.asV(this.path);
        if (this.hfF == null)
        {
          ac.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = q.e(this.dwE);
          this.hfF = com.tencent.mm.plugin.sns.lucky.a.a.iX(this.hYj + (String)localObject, this.path);
          boolean bool4 = i.eA(this.path);
          ac.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
        }
        label427:
        long l3 = bs.aO(l2);
        int i = (int)i.aSp(this.path);
        if (bs.aO(f.i(f.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), af.dIi(), com.tencent.mm.loader.j.b.apb() });
          f.b(f.this, bs.Gn());
        }
        if (this.hfF == null)
        {
          ac.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.dwE.Id });
          i.deleteFile(this.hYj + q.e(this.dwE));
          i.deleteFile(this.path);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(150L, 2L, 1L, true);
        }
        l3 = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(150L, 0L, 1L, true);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(150L, 1L, l3 - l1, true);
        localObject = new StringBuilder("doInBackground decode %s and ");
        if (this.hfF != null) {
          break label872;
        }
      }
      label769:
      label872:
      for (boolean bool1 = true;; bool1 = false)
      {
        ac.i("MicroMsg.ImageLoader", bool1 + " " + this.hfF + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
        localObject = Boolean.TRUE;
        AppMethodBeat.o(95476);
        return localObject;
        ac.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
        break;
        if (this.xQZ == 4)
        {
          this.hfF = q.asV(this.path);
          if (this.hfF != null) {
            break label427;
          }
          ac.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = q.d(this.dwE);
          this.hfF = com.tencent.mm.plugin.sns.lucky.a.a.iX(this.hYj + (String)localObject, this.path);
          break label427;
        }
        this.hfF = q.asX(this.path);
        break label427;
      }
    }
    
    public final ExecutorService dBu()
    {
      AppMethodBeat.i(179079);
      ExecutorService localExecutorService = af.dHC();
      AppMethodBeat.o(179079);
      return localExecutorService;
    }
  }
  
  static final class c
  {
    public int code;
    public String id;
    public int xRa;
    public boolean xRb;
    
    public c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.id = paramString;
      this.code = paramInt1;
      this.xRa = paramInt2;
      this.xRb = paramBoolean;
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
    public abstract void aj(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.f
 * JD-Core Version:    0.7.0.1
 */
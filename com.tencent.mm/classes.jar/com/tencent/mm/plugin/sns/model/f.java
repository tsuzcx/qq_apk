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
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bc;
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
  implements com.tencent.mm.plugin.sns.c.g
{
  private static int wEe = 0;
  private Map<Integer, WeakReference<Object>> hgW;
  private long wDH;
  private long wDI;
  com.tencent.mm.memory.a.b<com.tencent.mm.memory.n> wDJ;
  private al<String, WeakReference<Bitmap>> wDK;
  private Map<String, LinkedList<WeakReference<c>>> wDL;
  private ConcurrentHashMap<Integer, String> wDM;
  private LinkedList<b> wDN;
  private boolean wDO;
  private HashSet<c> wDP;
  public HashMap<String, Integer> wDQ;
  private int wDR;
  public aa wDS;
  public long wDT;
  public long wDU;
  private int wDV;
  private int wDW;
  private HashMap<Long, Integer> wDX;
  private HashMap<Integer, Boolean> wDY;
  private HashMap<Integer, Boolean> wDZ;
  public boolean wDv;
  private int wEa;
  private int wEb;
  private HashMap<Long, Integer> wEc;
  protected Set<String> wEd;
  
  public f()
  {
    AppMethodBeat.i(95483);
    this.wDH = 0L;
    this.wDI = 0L;
    this.hgW = new HashMap();
    this.wDL = new HashMap();
    this.wDM = new ConcurrentHashMap();
    this.wDN = new LinkedList();
    this.wDO = false;
    this.wDP = new HashSet();
    this.wDQ = new HashMap();
    this.wDR = 4;
    this.wDv = true;
    this.wDT = 0L;
    this.wDU = 0L;
    this.wDV = 0;
    this.wDW = 0;
    this.wDX = new HashMap();
    this.wDY = new HashMap();
    this.wDZ = new HashMap();
    this.wEa = 0;
    this.wEb = 0;
    this.wEc = new HashMap();
    this.wEd = new HashSet();
    com.tencent.mm.memory.a.b.a(com.tencent.mm.memory.n.class, new b.a() {});
    int i = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    ad.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.wDJ = new com.tencent.mm.memory.a.b(i, new com.tencent.mm.b.f.b() {}, getClass());
      this.wDK = new al(this.wDR, new al.a()
      {
        public final boolean dC(Object paramAnonymousObject)
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
              paramAnonymousObject = ((al.b)((al)localObject).wIF.get(str)).obj;
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
            i = ((al)localObject).wIF.size();
            paramAnonymousObject = ((al)localObject).wIF.remove(str);
            localObject = new StringBuilder("internalMap ").append(((al)localObject).wIF.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              ad.d("MicroMsg.SnsLRUMap", bool);
              ad.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + f.a(f.this).wIF.size() + " listPaitSize:" + f.b(f.this).size());
              AppMethodBeat.o(95463);
              return true;
              paramAnonymousObject = (WeakReference)((al.b)((al)localObject).wIF.get(str)).obj;
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
  
  public static String C(bpi parambpi)
  {
    AppMethodBeat.i(95541);
    if (parambpi == null)
    {
      AppMethodBeat.o(95541);
      return null;
    }
    if (parambpi.Id.startsWith("pre_temp_sns_pic")) {
      parambpi = af.getAccSnsTmpPath() + parambpi.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(95541);
      return parambpi;
      if (parambpi.Id.startsWith("Locall_path")) {
        parambpi = an.iF(af.getAccSnsPath(), parambpi.Id) + q.l(parambpi);
      } else if (parambpi.Id.startsWith("pre_temp_extend_pic")) {
        parambpi = parambpi.Id.substring(19);
      } else {
        parambpi = an.iF(af.getAccSnsPath(), parambpi.Id) + q.c(parambpi);
      }
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, bc parambc)
  {
    AppMethodBeat.i(95538);
    if ((!paramBoolean) && (bt.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    bpi localbpi = com.tencent.mm.modelsns.g.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    q.bO(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = q.anK(paramString1);
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
    Object localObject = q.k(localbpi);
    localObject = q.anK(an.iF(af.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!q.I((Bitmap)localObject)) {
      paramString3 = q.anK(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!bt.isNullOrNil(paramString2))) {
      af.dtp().a(localbpi, 3, null, parambc);
    }
    if (!q.I(paramString3))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    AppMethodBeat.o(95538);
    return paramString3;
  }
  
  private String a(com.tencent.mm.plugin.sns.storage.p paramp, final bpi parambpi, final bc parambc, boolean paramBoolean)
  {
    AppMethodBeat.i(95531);
    if (u(parambpi))
    {
      AppMethodBeat.o(95531);
      return "";
    }
    String str1 = an.iF(af.getAccSnsPath(), parambpi.Id);
    String str2 = q.i(parambpi);
    if (i.eK(str1 + str2))
    {
      paramp = str1 + str2;
      AppMethodBeat.o(95531);
      return paramp;
    }
    if ((i.eK(str1 + q.o(parambpi))) && (parambpi.Id != null) && (parambpi.Id.startsWith("Locall_path")))
    {
      paramp = str1 + q.o(parambpi);
      AppMethodBeat.o(95531);
      return paramp;
    }
    if (!this.wDv)
    {
      AppMethodBeat.o(95531);
      return "";
    }
    ad.i("MicroMsg.LazyerImageLoader2", "push sight loader " + parambpi.Id + " url: " + parambpi.Url);
    if (paramBoolean) {
      if (b(paramp, null) == 5) {
        af.czA().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95470);
            af.dtp().a(parambpi, 4, null, parambc);
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
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, f.a.wEB);
    AppMethodBeat.o(95510);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95512);
    a(paramObject, paramString, false, -1, paramInt1, paramInt2, paramInt3, f.a.wEB);
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
      ad.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.apg() });
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
      if ((localObject == null) || (!(localObject instanceof ai))) {
        break label468;
      }
      l1 = ((ai)localObject).wIy;
    }
    label454:
    label468:
    for (;;)
    {
      paramn = new ai(paramString, paramn, l1);
      paramObject.L(paramn.wIy, paramString);
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
        for (paramObject = new ai(paramString, paramn, ((ai)paramObject).wIy);; paramObject = new ai(paramString, paramn, 0L))
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
          if ((paramObject == null) || (!(paramObject instanceof ai))) {
            break label361;
          }
        }
        label361:
        for (paramObject = new ai(paramString, paramn, ((ai)paramObject).wIy);; paramObject = new ai(paramString, paramn, 0L))
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
        if ((paramObject == null) || (!(paramObject instanceof ai))) {
          break label454;
        }
      }
      for (paramObject = new ai(paramString, paramn, ((ai)paramObject).wIy);; paramObject = new ai(paramString, paramn, 0L))
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
    this.wDP.remove(new c(null, i, 0, false));
    c localc = new c(paramString, i, paramInt2, paramBoolean);
    this.wDP.add(localc);
    LinkedList localLinkedList = (LinkedList)this.wDL.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.wDL.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.wDL.get(localObject);
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
      this.hgW.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label348;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == f.a.wEC) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
        {
          com.tencent.mm.sdk.platformtools.p.eFg();
          AppMethodBeat.o(95513);
          return;
          label339:
          paramInt2 += 1;
          break;
          label348:
          if ((paramObject instanceof ImageView))
          {
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.cd.a.l(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.a.a)paramObject;
            if (!this.wDv) {}
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
        ad.d("MicroMsg.LazyerImageLoader2", "try to setLayerType " + paramInt3 + " " + paramInt4);
      }
      AppMethodBeat.o(95513);
      return;
      label490:
      paramInt2 = -1;
    }
  }
  
  private boolean a(final int paramInt, final bpi parambpi, final bc parambc)
  {
    AppMethodBeat.i(95517);
    if (!this.wDv)
    {
      if ((parambpi != null) && (!bt.isNullOrNil(parambpi.Id))) {
        af.dtp().aoo(parambpi.Id);
      }
      AppMethodBeat.o(95517);
      return false;
    }
    af.dth().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95469);
        m localm;
        b localb;
        bpi localbpi;
        if (!f.a(f.this, paramInt, parambpi))
        {
          localm = new m(parambpi);
          localm.wBd = paramInt;
          localm.dnB = parambpi.Id;
          localb = af.dtp();
          localbpi = parambpi;
          if (parambpi.mBH != 6) {
            break label97;
          }
        }
        label97:
        for (int i = 5;; i = 1)
        {
          localb.a(localbpi, i, localm, parambc);
          AppMethodBeat.o(95469);
          return;
        }
      }
    });
    AppMethodBeat.o(95517);
    return true;
  }
  
  public static boolean a(bpi parambpi, bc parambc, boolean paramBoolean)
  {
    AppMethodBeat.i(95540);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95540);
      return false;
    }
    Object localObject;
    if (parambpi.Id.startsWith("Locall_path"))
    {
      localObject = an.iF(af.getAccSnsPath(), parambpi.Id) + q.l(parambpi);
      if (i.eK((String)localObject)) {
        break label161;
      }
      localObject = af.dtp();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 2)
    {
      ((b)localObject).a(parambpi, i, null, parambc);
      AppMethodBeat.o(95540);
      return false;
      localObject = an.iF(af.getAccSnsPath(), parambpi.Id) + q.c(parambpi);
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
      this.wDJ.put(paramString, paramn);
    }
    AppMethodBeat.o(95534);
    return true;
  }
  
  private boolean a(final List<bpi> paramList, final bc parambc)
  {
    AppMethodBeat.i(95515);
    af.dth().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95466);
        long l = bt.GC();
        Object localObject = new m(paramList);
        ((m)localObject).dnB = q.fk(paramList);
        ((m)localObject).wBd = this.wEg;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          bpi localbpi = (bpi)paramList.get(j);
          if (af.dtp().aoj(localbpi.Id)) {
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
              } while (i.eK(an.iF(af.getAccSnsPath(), localbpi.Id) + q.d(localbpi)));
              i = k;
            } while (i.eK(an.iF(af.getAccSnsPath(), localbpi.Id) + q.k(localbpi)));
            i = k;
          } while (i.eK(an.iF(af.getAccSnsPath(), localbpi.Id) + q.l(localbpi)));
          b localb = af.dtp();
          if (localbpi.mBH == 6) {}
          for (int i = 5;; i = 1)
          {
            localb.a(localbpi, i, (m)localObject, parambc);
            i = 0;
            break;
          }
        }
        l = bt.aS(l);
        if (l > 100L) {
          ad.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.aib() + " " + af.dtK() + " " + ((m)localObject).dnB);
        }
        if (bt.aS(f.c(f.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), af.dtK(), com.tencent.mm.loader.j.b.aib() });
          f.a(f.this, bt.GC());
        }
        localObject = q.fk(paramList);
        if (k != 0) {
          af.czA().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95465);
              new h(q.bO(0, this.Jd), this.Jd, f.9.this.wEx).v(new String[] { "" });
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
  
  private com.tencent.mm.memory.n aor(String paramString)
  {
    AppMethodBeat.i(95492);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.wDJ.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.wDJ.remove(paramString);
      AppMethodBeat.o(95492);
      return null;
    }
    AppMethodBeat.o(95492);
    return localn;
  }
  
  private com.tencent.mm.memory.n aos(String paramString)
  {
    AppMethodBeat.i(95493);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.wDJ.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.wDJ.remove(paramString);
      AppMethodBeat.o(95493);
      return null;
    }
    AppMethodBeat.o(95493);
    return localn;
  }
  
  private boolean aot(String paramString)
  {
    AppMethodBeat.i(179083);
    if ((this.wDQ.containsKey(paramString)) && (4 == ((Integer)this.wDQ.get(paramString)).intValue())) {
      this.wDQ.remove(paramString);
    }
    AppMethodBeat.o(179083);
    return true;
  }
  
  private boolean ap(View paramView, int paramInt)
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
      } while (!ap(paramView.getChildAt(j), paramInt));
      AppMethodBeat.o(95485);
      return true;
    }
    AppMethodBeat.o(95485);
    return false;
  }
  
  private void b(bpi parambpi, View paramView, int paramInt, f.a parama, bc parambc)
  {
    AppMethodBeat.i(95497);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95497);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = q.bO(5, parambpi.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = aor(str);
    if (!q.b(parama))
    {
      eq(paramView);
      if (this.wEd.contains(str))
      {
        AppMethodBeat.o(95497);
        return;
      }
      a(5, parambpi, parambc);
      AppMethodBeat.o(95497);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95497);
  }
  
  private boolean dsL()
  {
    AppMethodBeat.i(95516);
    if (this.wDO)
    {
      ad.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(95516);
      return false;
    }
    af.czA().postDelayed(new Runnable()
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
          ((f.b)f.e(f.this).removeLast()).v(new String[] { "" });
        }
        AppMethodBeat.o(95467);
      }
    }, 0L);
    AppMethodBeat.o(95516);
    return true;
  }
  
  private static void eq(View paramView)
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
  
  private static boolean er(String paramString, int paramInt)
  {
    AppMethodBeat.i(95523);
    paramString = bw.K(paramString, "SightDownloadControl");
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
  
  public static String q(bpi parambpi)
  {
    AppMethodBeat.i(95489);
    String str = an.iF(af.getAccSnsPath(), parambpi.Id);
    parambpi = q.d(parambpi);
    parambpi = str + parambpi;
    AppMethodBeat.o(95489);
    return parambpi;
  }
  
  public static String r(bpi parambpi)
  {
    AppMethodBeat.i(95499);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95499);
      return null;
    }
    String str = an.iF(af.getAccSnsPath(), parambpi.Id) + q.d(parambpi);
    if (!i.eK(str))
    {
      parambpi = parambpi.DMQ;
      AppMethodBeat.o(95499);
      return parambpi;
    }
    AppMethodBeat.o(95499);
    return str;
  }
  
  public static String s(bpi parambpi)
  {
    AppMethodBeat.i(95500);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95500);
      return null;
    }
    String str = an.iF(af.getAccSnsPath(), parambpi.Id) + q.c(parambpi);
    if (!i.eK(str))
    {
      parambpi = parambpi.Url;
      AppMethodBeat.o(95500);
      return parambpi;
    }
    AppMethodBeat.o(95500);
    return str;
  }
  
  private void setError(String paramString)
  {
    AppMethodBeat.i(179084);
    this.wDQ.put(paramString, Integer.valueOf(4));
    AppMethodBeat.o(179084);
  }
  
  public static boolean t(bpi parambpi)
  {
    AppMethodBeat.i(95518);
    String str1 = an.iF(af.getAccSnsPath(), parambpi.Id);
    String str2 = q.i(parambpi);
    if (i.eK(str1 + str2))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    if ((i.eK(str1 + q.o(parambpi))) && (!bt.isNullOrNil(parambpi.Id)) && (parambpi.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    AppMethodBeat.o(95518);
    return false;
  }
  
  public final void A(bpi parambpi)
  {
    AppMethodBeat.i(95530);
    this.wDQ.put(parambpi.Id, Integer.valueOf(3));
    AppMethodBeat.o(95530);
  }
  
  public final boolean B(bpi parambpi)
  {
    AppMethodBeat.i(95539);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95539);
      return false;
    }
    if (i.eK(an.iF(af.getAccSnsPath(), parambpi.Id) + q.e(parambpi)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    if (i.eK(an.iF(af.getAccSnsPath(), parambpi.Id) + q.d(parambpi)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    parambpi = q.bO(1, parambpi.Id);
    boolean bool = q.b((com.tencent.mm.memory.n)this.wDJ.get(parambpi));
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
    if ((paramArrayOfInt != null) || (bt.aS(this.wDT) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      c.awQ();
      if (!c.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.wDV = 5;
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
      this.wDW = ((PInt)localObject).value;
      this.wDT = bt.GC();
      if ((this.wDW != 0) && (paramp != null)) {
        break label163;
      }
      i = this.wDV;
      AppMethodBeat.o(95520);
      return i;
      this.wDV = 10;
      break;
    }
    label163:
    if (this.wDX.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.wDX.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = new cvi();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.wDV;
        AppMethodBeat.o(95520);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.EmU == null) || (paramArrayOfInt.EmU.info == null))
      {
        i = this.wDV;
        AppMethodBeat.o(95520);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ad.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.wDV;
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.EmU.info;
    i = paramArrayOfInt.hashCode();
    if (this.wDW == 1)
    {
      if (!this.wDZ.containsKey(Integer.valueOf(i))) {
        this.wDZ.put(Integer.valueOf(i), Boolean.valueOf(er(paramArrayOfInt, this.wDW)));
      }
      if (((Boolean)this.wDZ.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ad.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.wDX.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95520);
        return i;
      }
    }
    if (!this.wDY.containsKey(Integer.valueOf(i))) {
      this.wDY.put(Integer.valueOf(i), Boolean.valueOf(er(paramArrayOfInt, this.wDW)));
    }
    if (((Boolean)this.wDY.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(bpi parambpi)
  {
    AppMethodBeat.i(95488);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95488);
      return null;
    }
    String str1 = q.bO(1, parambpi.Id);
    Object localObject = aor(str1);
    if (q.b((com.tencent.mm.memory.n)localObject))
    {
      parambpi = ((com.tencent.mm.memory.n)localObject).apb();
      AppMethodBeat.o(95488);
      return parambpi;
    }
    localObject = an.iF(af.getAccSnsPath(), parambpi.Id);
    String str2 = q.d(parambpi);
    localObject = (String)localObject + str2;
    if (i.eK((String)localObject))
    {
      if (parambpi.Id.startsWith("pre_temp_extend_pic")) {}
      for (parambpi = com.tencent.mm.memory.n.D(u.aqe((String)localObject)); q.b(parambpi); parambpi = q.anL((String)localObject))
      {
        a(str1, parambpi);
        parambpi = parambpi.apb();
        AppMethodBeat.o(95488);
        return parambpi;
      }
      AppMethodBeat.o(95488);
      return null;
    }
    AppMethodBeat.o(95488);
    return null;
  }
  
  public final com.tencent.mm.memory.n a(bpi parambpi, ImageView paramImageView, int paramInt, bc parambc)
  {
    AppMethodBeat.i(95543);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95543);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = q.bO(0, parambpi.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = aor(str);
    if (!q.b(paramImageView))
    {
      a(0, parambpi, parambc);
      AppMethodBeat.o(95543);
      return null;
    }
    AppMethodBeat.o(95543);
    return paramImageView;
  }
  
  public final void a(bpi parambpi, View paramView, int paramInt1, int paramInt2, f.a parama, bc parambc)
  {
    AppMethodBeat.i(95496);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95496);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = q.bO(0, parambpi.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = aor(str);
    if (!q.b(parama))
    {
      ad.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        eq(paramView);
      }
      if (this.wEd.contains(str))
      {
        AppMethodBeat.o(95496);
        return;
      }
      a(0, parambpi, parambc);
      AppMethodBeat.o(95496);
      return;
    }
    ad.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    af.dtp().aoo(parambpi.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(95496);
  }
  
  public final void a(bpi parambpi, View paramView, int paramInt1, int paramInt2, bc parambc)
  {
    AppMethodBeat.i(95494);
    a(parambpi, paramView, paramInt1, paramInt2, f.a.wEB, parambc);
    AppMethodBeat.o(95494);
  }
  
  public final void a(bpi parambpi, View paramView, int paramInt, f.a parama, bc parambc)
  {
    AppMethodBeat.i(95491);
    a(parambpi, paramView, -1, paramInt, parama, parambc);
    AppMethodBeat.o(95491);
  }
  
  public final void a(bpi parambpi, View paramView, int paramInt, bc parambc)
  {
    AppMethodBeat.i(95501);
    b(parambpi, paramView, -1, paramInt, parambc);
    AppMethodBeat.o(95501);
  }
  
  public final void a(final bpi parambpi, final View paramView, final int paramInt, final boolean paramBoolean1, final bc parambc, final boolean paramBoolean2, final e parame)
  {
    AppMethodBeat.i(95542);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95542);
      return;
    }
    final String str1 = q.bO(3, parambpi.Id);
    final String str2 = C(parambpi);
    if (af.dtp().aok(parambpi.Id))
    {
      ad.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + parambpi.Id);
      a(paramView, str1, paramInt, -1, -1);
      parame.ai(null);
      AppMethodBeat.o(95542);
      return;
    }
    Object localObject1 = this.wDK;
    Object localObject2 = (al.b)((al)localObject1).wIF.get(str1);
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
      if (!q.I((Bitmap)localObject1)) {
        break label305;
      }
      ad.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
      a(paramView, str1, paramInt, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      parame.ai((Bitmap)localObject1);
      AppMethodBeat.o(95542);
      return;
      ((al.b)((al)localObject1).wIF.get(str1)).dtV();
      localObject1 = ((al.b)localObject2).obj;
      break;
      bool = false;
      break label185;
    }
    label305:
    af.dtf().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95459);
        final Bitmap localBitmap = q.anK(str2);
        af.czA().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95458);
            if (q.I(localBitmap))
            {
              f.a(f.this, f.4.this.wCN, f.4.this.wEj, f.4.this.wEk, localBitmap.getWidth(), localBitmap.getHeight());
              if (!q.I(localBitmap)) {
                break label252;
              }
              localObject1 = f.a(f.this);
              localObject2 = f.4.this.wEj;
              localObject3 = new WeakReference(localBitmap);
              if ((al.b)((al)localObject1).wIF.get(localObject2) != null) {
                break label215;
              }
              localObject3 = new al.b((al)localObject1, localObject3);
              ((al)localObject1).wIF.put(localObject2, localObject3);
              ((al)localObject1).dtU();
            }
            label215:
            label252:
            while (!f.4.this.wEl) {
              for (;;)
              {
                Object localObject3;
                if (f.4.this.wEo != null) {
                  f.4.this.wEo.ai(localBitmap);
                }
                AppMethodBeat.o(95458);
                return;
                f.a(f.this, f.4.this.wCN, f.4.this.wEj, f.4.this.wEk, -1, -1);
                break;
                ((al.b)((al)localObject1).wIF.get(localObject2)).dtV();
                ((al.b)((al)localObject1).wIF.get(localObject2)).obj = localObject3;
              }
            }
            Object localObject1 = af.dtp();
            Object localObject2 = f.4.this.wAP;
            if (f.4.this.wEm) {}
            for (int i = 8;; i = 2)
            {
              ((b)localObject1).a((bpi)localObject2, i, null, f.4.this.wEn);
              break;
            }
          }
        });
        AppMethodBeat.o(95459);
      }
    });
    AppMethodBeat.o(95542);
  }
  
  public final void a(final String paramString, SparseArray<bpi> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, final bc parambc, final int paramInt2)
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
      bpi localbpi = (bpi)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = q.bO(0, localbpi.Id);
      a(localView, str, -1, paramInt1, f.a.wEB);
      com.tencent.mm.memory.n localn = aor(str);
      if (!q.b(localn))
      {
        ad.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        eq(localView);
        if (!this.wEd.contains(str)) {
          localSparseArray1.put(k, localbpi);
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
      af.dth().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95464);
          int j = localSparseArray1.size();
          int i = 0;
          while (i < j)
          {
            int k = localSparseArray1.keyAt(i);
            bpi localbpi = (bpi)localSparseArray1.get(k);
            if (!f.a(f.this, 0, localbpi))
            {
              m localm = new m(localbpi);
              localm.wBd = 0;
              localm.dnB = localbpi.Id;
              localSparseArray2.put(k, localm);
              localSparseArray3.put(k, localbpi);
            }
            i += 1;
          }
          if (localSparseArray3.size() > 0) {
            af.dtp().a(paramString, localSparseArray3, localSparseArray2, parambc, paramInt2);
          }
          AppMethodBeat.o(95464);
        }
      });
    }
    AppMethodBeat.o(95495);
  }
  
  public final void a(List<bpi> paramList, View paramView, int paramInt, f.a parama, bc parambc)
  {
    AppMethodBeat.i(95545);
    a(paramList, paramView, paramInt, parama, parambc, false);
    AppMethodBeat.o(95545);
  }
  
  public final void a(List<bpi> paramList, View paramView, int paramInt, f.a parama, bc parambc, boolean paramBoolean)
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
        b((bpi)paramList.get(0), paramView, paramInt, parambc);
        AppMethodBeat.o(95546);
        return;
      }
      b((bpi)paramList.get(0), paramView, paramInt, f.a.wEC, parambc);
      AppMethodBeat.o(95546);
      return;
    }
    String str = q.bO(0, q.fk(paramList));
    a(paramView, str, paramInt, parama);
    parama = aor(str);
    paramBoolean = q.b(parama);
    ad.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      eq(paramView);
      if (this.wEd.contains(str))
      {
        AppMethodBeat.o(95546);
        return;
      }
      new WeakReference(paramView);
      a(paramList, parambc);
      AppMethodBeat.o(95546);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95546);
  }
  
  public final boolean a(m paramm, String paramString)
  {
    AppMethodBeat.i(95535);
    Object localObject1 = (bpi)paramm.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < paramm.list.size())
    {
      localObject2 = (bpi)paramm.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((bpi)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id);
      if (paramm.wBd == 0) {
        paramString = q.e((bpi)localObject1);
      }
      for (;;)
      {
        String str = q.bO(paramm.wBd, ((bpi)localObject1).Id);
        if (!this.wDJ.aN(str)) {
          new b(q.bO(paramm.wBd, ((bpi)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (bpi)localObject1, paramm.wBd).v(new String[] { "" });
        }
        AppMethodBeat.o(95535);
        return true;
        i += 1;
        break;
        if (paramm.wBd == 4) {
          paramString = q.f((bpi)localObject1);
        } else if (paramm.wBd == 5) {
          paramString = q.f((bpi)localObject1);
        } else if (paramm.wBd == 3) {
          paramString = q.k((bpi)localObject1);
        } else {
          paramString = q.d((bpi)localObject1);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.p paramp, bpi parambpi, SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt, bc parambc, boolean paramBoolean)
  {
    AppMethodBeat.i(179081);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(179081);
      return false;
    }
    String str1 = q.bO(1, parambpi.Id);
    a(paramSnsAdTimelineVideoView, str1, -1, paramInt);
    String str2 = an.iF(af.getAccSnsPath(), parambpi.Id);
    String str3 = q.d(parambpi);
    Object localObject;
    b localb;
    if (!i.eK(str2 + str3))
    {
      localObject = new m(parambpi);
      ((m)localObject).wBd = 1;
      ((m)localObject).dnB = parambpi.Id;
      localb = af.dtp();
      if (parambpi.mBH != 6) {
        break label293;
      }
    }
    label293:
    for (paramInt = 5;; paramInt = 1)
    {
      localb.a(parambpi, paramInt, (m)localObject, parambc);
      localObject = "";
      if (paramBoolean) {
        localObject = a(paramp, parambpi, parambc, paramBoolean);
      }
      ad.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean) });
      if ((bt.isNullOrNil((String)localObject)) || (u(parambpi))) {
        break;
      }
      if (!((String)localObject).equals(paramSnsAdTimelineVideoView.getVideoPath()))
      {
        paramSnsAdTimelineVideoView.setThumbBmp(com.tencent.mm.sdk.platformtools.f.decodeFile(str2 + str3));
        ad.i("MicroMsg.SnsAdTimelineVideoView", "showVideoThumb:true");
        paramSnsAdTimelineVideoView.b(false, 0.0F);
      }
      paramSnsAdTimelineVideoView.setVideoPath((String)localObject);
      AppMethodBeat.o(179081);
      return true;
    }
    ad.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, sightPath %s", new Object[] { localObject });
    paramSnsAdTimelineVideoView.setVideoPath(null);
    paramSnsAdTimelineVideoView.clear();
    paramp = aor(str1);
    paramBoolean = q.b(paramp);
    ad.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      paramSnsAdTimelineVideoView.setThumbBmp(null);
      if (this.wEd.contains(str1))
      {
        AppMethodBeat.o(179081);
        return false;
      }
      a(1, parambpi, parambc);
      AppMethodBeat.o(179081);
      return false;
    }
    a(paramSnsAdTimelineVideoView, str1, paramp);
    AppMethodBeat.o(179081);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.p paramp, bpi parambpi, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bc parambc, boolean paramBoolean)
  {
    AppMethodBeat.i(176251);
    paramBoolean = a(paramp, parambpi, paramVideoSightView, paramInt1, paramInt2, parambc, paramBoolean, false);
    AppMethodBeat.o(176251);
    return paramBoolean;
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.p paramp, bpi parambpi, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bc parambc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176252);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(176252);
      return false;
    }
    String str1 = q.bO(1, parambpi.Id);
    a(paramVideoSightView, str1, -1, paramInt1);
    String str2 = an.iF(af.getAccSnsPath(), parambpi.Id);
    String str3 = q.d(parambpi);
    Object localObject;
    if (!i.eK(str2 + str3))
    {
      localObject = new m(parambpi);
      ((m)localObject).wBd = 1;
      ((m)localObject).dnB = parambpi.Id;
      b localb = af.dtp();
      if (parambpi.mBH == 6)
      {
        paramInt1 = 5;
        localb.a(parambpi, paramInt1, (m)localObject, parambc);
      }
    }
    else
    {
      localObject = "";
      if (paramBoolean1) {
        localObject = a(paramp, parambpi, parambc, paramBoolean1);
      }
      ad.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean1) });
      if ((bt.isNullOrNil((String)localObject)) || (u(parambpi))) {
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
    ad.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject });
    paramVideoSightView.setVideoPath(null);
    paramVideoSightView.clear();
    paramp = aor(str1);
    paramBoolean1 = q.b(paramp);
    ad.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!paramBoolean1)
    {
      paramVideoSightView.setPosition(0);
      paramVideoSightView.setThumbBmp(null);
      if (this.wEd.contains(str1))
      {
        AppMethodBeat.o(176252);
        return false;
      }
      a(1, parambpi, parambc);
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
  
  public final boolean a(bpi parambpi, View paramView, int paramInt1, int paramInt2, bc parambc, int paramInt3)
  {
    AppMethodBeat.i(95507);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95507);
      return false;
    }
    String str = q.bO(paramInt3, parambpi.Id);
    a(paramView, str, paramInt1, paramInt2);
    com.tencent.mm.memory.n localn = aor(str);
    boolean bool = q.b(localn);
    ad.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        eq(paramView);
      }
      if (this.wEd.contains(str))
      {
        AppMethodBeat.o(95507);
        return true;
      }
      a(paramInt3, parambpi, parambc);
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
  
  public final void aou(String paramString)
  {
    AppMethodBeat.i(95536);
    b(paramString, null);
    AppMethodBeat.o(95536);
  }
  
  public final com.tencent.mm.memory.n aov(String paramString)
  {
    AppMethodBeat.i(95537);
    if (this.wDJ == null)
    {
      AppMethodBeat.o(95537);
      return null;
    }
    paramString = (com.tencent.mm.memory.n)this.wDJ.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95537);
    return paramString;
  }
  
  public final void az(Activity paramActivity)
  {
    AppMethodBeat.i(95486);
    ad.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.hgW.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.wDP.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (ap(paramActivity.getWindow().getDecorView(), ((c)localObject3).code)) {
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
      this.hgW.remove(Integer.valueOf(i));
      localObject3 = this.wDP.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        c localc = (c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.wDP.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.wDP.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (((c)localObject3).wEF == paramActivity.hashCode()) {
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
      this.hgW.remove(Integer.valueOf(i));
      localObject1 = this.wDP.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (((c)localObject2).code != i) {
          break;
        }
        this.wDP.remove(localObject2);
      }
    }
    label371:
    this.wDK.dtU();
    ad.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.hgW.size());
    AppMethodBeat.o(95486);
  }
  
  public final int b(com.tencent.mm.plugin.sns.storage.p paramp, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95522);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (bt.aS(this.wDU) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      c.awQ();
      if (!c.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.wEa = 5;
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
      this.wEb = ((PInt)localObject).value;
      this.wDU = bt.GC();
      if ((this.wEb != 0) && (paramp != null)) {
        break label144;
      }
      i = this.wEa;
      AppMethodBeat.o(95522);
      return i;
      this.wEa = 10;
      break;
    }
    label144:
    if (this.wEc.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.wEc.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = new cvi();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.wEa;
        AppMethodBeat.o(95522);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.EmU == null) || (paramArrayOfInt.EmU.info == null))
      {
        i = this.wDV;
        AppMethodBeat.o(95522);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ad.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.wEa;
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.EmU.info;
    i = paramArrayOfInt.hashCode();
    if (this.wEb == 1)
    {
      if (!this.wDZ.containsKey(Integer.valueOf(i))) {
        this.wDZ.put(Integer.valueOf(i), Boolean.valueOf(er(paramArrayOfInt, this.wEb)));
      }
      if (((Boolean)this.wDZ.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ad.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.wEc.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95522);
        return i;
      }
    }
    if (!this.wDY.containsKey(Integer.valueOf(i))) {
      this.wDY.put(Integer.valueOf(i), Boolean.valueOf(er(paramArrayOfInt, this.wEb)));
    }
    if (((Boolean)this.wDY.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final void b(bpi parambpi, View paramView, int paramInt, bc parambc)
  {
    AppMethodBeat.i(95490);
    a(parambpi, paramView, -1, paramInt, parambc);
    AppMethodBeat.o(95490);
  }
  
  protected final void b(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(95547);
    com.tencent.mm.memory.n localn = paramn;
    if (!q.b(paramn)) {
      localn = aos(paramString);
    }
    if (q.b(localn))
    {
      if ((this.wDJ != null) && (localn != null) && (paramString != null)) {
        this.wDJ.put(paramString, localn);
      }
      paramn = (LinkedList)this.wDL.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((c)localObject).wEG) && (paramString != null) && (paramString.equals(((c)localObject).id)))
          {
            int i = ((c)localObject).code;
            localObject = (WeakReference)this.hgW.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.wDS != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.wDS.Nj(i))) {
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
                    ad.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(q.b(localn)) });
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
  
  public final boolean b(bpi parambpi, View paramView, int paramInt1, int paramInt2, bc parambc)
  {
    AppMethodBeat.i(95506);
    boolean bool = a(parambpi, paramView, paramInt1, paramInt2, parambc, 1);
    AppMethodBeat.o(95506);
    return bool;
  }
  
  public final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95544);
    a(paramView, null, true, -1, paramInt3, -1, -1, f.a.wEB);
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
        ((ImageView)paramView).setImageDrawable(com.tencent.mm.cd.a.l(paramView.getContext(), paramInt2));
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
  
  public final void c(bpi parambpi, View paramView, int paramInt, bc parambc)
  {
    AppMethodBeat.i(95505);
    if ((parambpi == null) || (parambpi.Id == null) || (parambpi.Id.equals("")))
    {
      AppMethodBeat.o(95505);
      return;
    }
    String str = q.bO(4, parambpi.Id);
    a(paramView, str, -1, paramInt);
    com.tencent.mm.memory.n localn = aor(str);
    boolean bool = q.b(localn);
    ad.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      eq(paramView);
      if (!this.wEd.contains(str))
      {
        a(4, parambpi, parambc);
        AppMethodBeat.o(95505);
      }
    }
    else
    {
      a(paramView, str, localn);
    }
    AppMethodBeat.o(95505);
  }
  
  public final void drP()
  {
    AppMethodBeat.i(95548);
    dsK();
    this.wDT = 0L;
    this.wDU = 0L;
    this.wDN.clear();
    this.wDO = false;
    AppMethodBeat.o(95548);
  }
  
  public final void dsK()
  {
    AppMethodBeat.i(95484);
    if (this.wDJ != null)
    {
      this.hgW.clear();
      this.wDK.wIF.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.wDJ.putCount() + ";");
      localStringBuffer.append("missCount:" + this.wDJ.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.wDJ.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.wDJ.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.wDJ.evictionCount() + ";");
      ad.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.wDJ.trimToSize(-1);
    }
    this.wDK.dtU();
    System.gc();
    AppMethodBeat.o(95484);
  }
  
  public final void eo(View paramView)
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
  
  public final boolean er(View paramView)
  {
    AppMethodBeat.i(95514);
    int i = paramView.hashCode();
    paramView = this.wDP.iterator();
    while (paramView.hasNext())
    {
      c localc = (c)paramView.next();
      if (i == localc.code) {
        this.wDP.remove(localc);
      }
    }
    this.hgW.remove(Integer.valueOf(i));
    AppMethodBeat.o(95514);
    return true;
  }
  
  public final boolean iC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95532);
    if ((this.wDQ.containsKey(paramString1)) && (3 == ((Integer)this.wDQ.get(paramString1)).intValue())) {
      this.wDQ.remove(paramString1);
    }
    String str = q.bO(1, paramString1);
    ad.i("MicroMsg.LazyerImageLoader2", "checkVideoAd, download video complete, mediaId=" + paramString1 + ", path=" + paramString2);
    Object localObject1 = (LinkedList)this.wDL.get(str);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95532);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((c)localObject2).wEG) && (str != null) && (str.equals(((c)localObject2).id)))
      {
        int i = ((c)localObject2).code;
        localObject2 = (WeakReference)this.hgW.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.sns.ui.an localan;
            if ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a))
            {
              ad.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
              if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof com.tencent.mm.plugin.sns.ui.an))
              {
                localan = (com.tencent.mm.plugin.sns.ui.an)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
                boolean bool;
                if (localan != null)
                {
                  if (i.eK(paramString2))
                  {
                    if (!this.wDv) {}
                    for (bool = true;; bool = false)
                    {
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).e(paramString2, bool, localan.position);
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localan.position);
                      localan.xsq.setVisibility(8);
                      localan.xbT.setVisibility(8);
                      localan.xbU.setVisibility(8);
                      aot(paramString1);
                      break;
                    }
                  }
                  setError(paramString1);
                  localan.xsq.setVisibility(8);
                  localan.xbT.setImageResource(2131234034);
                  localan.xbT.setVisibility(0);
                }
                else
                {
                  if (!this.wDv) {}
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
              if ((((SnsAdTimelineVideoView)localObject2).getTag() instanceof com.tencent.mm.plugin.sns.ui.an))
              {
                localan = (com.tencent.mm.plugin.sns.ui.an)((SnsAdTimelineVideoView)localObject2).getTag();
                if (localan != null)
                {
                  if (i.eK(paramString2))
                  {
                    ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                    ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                    localan.xsq.setVisibility(8);
                    localan.xbT.setVisibility(8);
                    localan.xbU.setVisibility(8);
                    aot(paramString1);
                  }
                  else
                  {
                    setError(paramString1);
                    localan.xsq.setVisibility(8);
                    localan.xbT.setImageResource(2131234034);
                    localan.xbT.setVisibility(0);
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
    this.wDv = false;
    b localb = af.dtp();
    localb.wDv = false;
    Object localObject3;
    synchronized (localb.mLock)
    {
      localObject2 = new LinkedList();
      localObject3 = localb.fyl.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.sns.data.n localn = (com.tencent.mm.plugin.sns.data.n)((Iterator)localObject3).next();
        if (localn.requestType != 6)
        {
          localb.wDy.remove(localn.key);
          ((LinkedList)localObject2).add(localn);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.sns.data.n)((Iterator)localObject2).next();
      localObject1.fyl.remove(localObject3);
    }
    localObject1.wDz.clear();
    localObject1.wDA.clear();
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
    AppMethodBeat.i(201276);
    int i = b(paramp, null);
    AppMethodBeat.o(201276);
    return i;
  }
  
  public final void start()
  {
    AppMethodBeat.i(95481);
    this.wDv = true;
    dsL();
    b localb = af.dtp();
    localb.wDv = true;
    localb.ayc();
    AppMethodBeat.o(95481);
  }
  
  public final boolean u(bpi parambpi)
  {
    AppMethodBeat.i(95524);
    if (!this.wDQ.containsKey(parambpi.Id))
    {
      AppMethodBeat.o(95524);
      return false;
    }
    if (((Integer)this.wDQ.get(parambpi.Id)).intValue() == 1)
    {
      AppMethodBeat.o(95524);
      return true;
    }
    AppMethodBeat.o(95524);
    return false;
  }
  
  public final boolean v(bpi parambpi)
  {
    AppMethodBeat.i(95525);
    if (!this.wDQ.containsKey(parambpi.Id))
    {
      AppMethodBeat.o(95525);
      return false;
    }
    if (((Integer)this.wDQ.get(parambpi.Id)).intValue() == 2)
    {
      AppMethodBeat.o(95525);
      return true;
    }
    AppMethodBeat.o(95525);
    return false;
  }
  
  public final boolean w(bpi parambpi)
  {
    AppMethodBeat.i(95526);
    if (!this.wDQ.containsKey(parambpi.Id))
    {
      AppMethodBeat.o(95526);
      return false;
    }
    if (((Integer)this.wDQ.get(parambpi.Id)).intValue() == 3)
    {
      AppMethodBeat.o(95526);
      return true;
    }
    AppMethodBeat.o(95526);
    return false;
  }
  
  public final boolean x(bpi parambpi)
  {
    AppMethodBeat.i(95527);
    if (!this.wDQ.containsKey(parambpi.Id))
    {
      AppMethodBeat.o(95527);
      return false;
    }
    if (((Integer)this.wDQ.get(parambpi.Id)).intValue() == 4)
    {
      AppMethodBeat.o(95527);
      return true;
    }
    AppMethodBeat.o(95527);
    return false;
  }
  
  public final void y(bpi parambpi)
  {
    AppMethodBeat.i(95528);
    this.wDQ.put(parambpi.Id, Integer.valueOf(1));
    AppMethodBeat.o(95528);
  }
  
  public final void z(bpi parambpi)
  {
    AppMethodBeat.i(95529);
    this.wDQ.put(parambpi.Id, Integer.valueOf(2));
    AppMethodBeat.o(95529);
  }
  
  final class b
    extends g<String, Integer, Boolean>
  {
    private bpi dyS;
    private com.tencent.mm.memory.n gFe;
    private String hxI;
    String key;
    private String path;
    private int wEE;
    
    public b(String paramString1, String paramString2, String paramString3, bpi parambpi, int paramInt)
    {
      AppMethodBeat.i(95474);
      this.key = "";
      this.gFe = null;
      this.wEE = 0;
      f.this.wEd.add(paramString1);
      this.key = paramString1;
      this.path = paramString2;
      this.hxI = paramString3;
      this.dyS = parambpi;
      this.wEE = paramInt;
      f.cUs();
      ad.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(f.aSD()) });
      AppMethodBeat.o(95474);
    }
    
    private void ar(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(95475);
      i.eK(this.hxI + paramString3);
      if (!i.eK(this.hxI + paramString1))
      {
        String str = paramString2;
        if (!i.eK(this.hxI + paramString2)) {
          str = q.l(this.dyS);
        }
        boolean bool = u.a(this.hxI, str, paramString1, af.dtF());
        if (!bool)
        {
          ad.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
          i.deleteFile(this.hxI + str);
        }
        ad.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.hxI + str, this.hxI + paramString1, Boolean.valueOf(bool) });
      }
      u.b(this.hxI, paramString1, paramString3, af.dtE());
      AppMethodBeat.o(95475);
    }
    
    private Boolean dsN()
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
      if (f.f(f.this).aN(this.key))
      {
        ad.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      i.aMT(this.hxI);
      long l1 = System.currentTimeMillis();
      long l2;
      if (!i.eK(this.path))
      {
        ar(q.d(this.dyS), q.k(this.dyS), q.e(this.dyS));
        l2 = bt.GC();
        if (this.wEE != 5) {
          break label769;
        }
        if (!i.eK(this.path)) {
          ar(q.d(this.dyS), q.k(this.dyS), q.e(this.dyS));
        }
        bool1 = i.eK(this.hxI + q.d(this.dyS));
        boolean bool2 = i.eK(this.hxI + q.k(this.dyS));
        boolean bool3 = i.eK(this.hxI + q.e(this.dyS));
        this.gFe = q.anJ(this.path);
        if (this.gFe == null)
        {
          ad.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = q.e(this.dyS);
          this.gFe = com.tencent.mm.plugin.sns.lucky.a.a.iA(this.hxI + (String)localObject, this.path);
          boolean bool4 = i.eK(this.path);
          ad.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
        }
        label427:
        long l3 = bt.aS(l2);
        int i = (int)i.aMN(this.path);
        if (bt.aS(f.i(f.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), af.dtK(), com.tencent.mm.loader.j.b.aib() });
          f.b(f.this, bt.GC());
        }
        if (this.gFe == null)
        {
          ad.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.dyS.Id });
          i.deleteFile(this.hxI + q.e(this.dyS));
          i.deleteFile(this.path);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(150L, 2L, 1L, true);
        }
        l3 = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(150L, 0L, 1L, true);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(150L, 1L, l3 - l1, true);
        localObject = new StringBuilder("doInBackground decode %s and ");
        if (this.gFe != null) {
          break label872;
        }
      }
      label769:
      label872:
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.i("MicroMsg.ImageLoader", bool1 + " " + this.gFe + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
        localObject = Boolean.TRUE;
        AppMethodBeat.o(95476);
        return localObject;
        ad.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
        break;
        if (this.wEE == 4)
        {
          this.gFe = q.anJ(this.path);
          if (this.gFe != null) {
            break label427;
          }
          ad.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = q.d(this.dyS);
          this.gFe = com.tencent.mm.plugin.sns.lucky.a.a.iA(this.hxI + (String)localObject, this.path);
          break label427;
        }
        this.gFe = q.anL(this.path);
        break label427;
      }
    }
    
    public final ExecutorService dnm()
    {
      AppMethodBeat.i(179079);
      ExecutorService localExecutorService = af.dtf();
      AppMethodBeat.o(179079);
      return localExecutorService;
    }
  }
  
  static final class c
  {
    public int code;
    public String id;
    public int wEF;
    public boolean wEG;
    
    public c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.id = paramString;
      this.code = paramInt1;
      this.wEF = paramInt2;
      this.wEG = paramBoolean;
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
  
  public static abstract interface e
  {
    public abstract void ai(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.f
 * JD-Core Version:    0.7.0.1
 */
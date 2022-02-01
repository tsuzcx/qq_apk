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
import com.tencent.mm.emoji.b.d.h.c;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.memory.a.b.a;
import com.tencent.mm.memory.m;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.c;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ego;
import com.tencent.mm.protocal.protobuf.fer;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.y;
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
  implements com.tencent.mm.plugin.sns.c.i
{
  private static int Qrt = 0;
  public boolean QqK;
  private long QqW;
  private long QqX;
  com.tencent.mm.memory.a.b<m> QqY;
  private aq<String, WeakReference<Bitmap>> QqZ;
  private Map<String, LinkedList<WeakReference<c>>> Qra;
  private ConcurrentHashMap<Integer, String> Qrb;
  private LinkedList<b> Qrc;
  private boolean Qrd;
  private HashSet<c> Qre;
  public HashMap<String, Integer> Qrf;
  private int Qrg;
  public af Qrh;
  public long Qri;
  public long Qrj;
  private int Qrk;
  private int Qrl;
  private HashMap<Long, Integer> Qrm;
  private HashMap<Integer, Boolean> Qrn;
  private HashMap<Integer, Boolean> Qro;
  private int Qrp;
  private int Qrq;
  private HashMap<Long, Integer> Qrr;
  protected Set<String> Qrs;
  private Map<Integer, WeakReference<Object>> oHd;
  
  public g()
  {
    AppMethodBeat.i(95483);
    this.QqW = 0L;
    this.QqX = 0L;
    this.oHd = new HashMap();
    this.Qra = new HashMap();
    this.Qrb = new ConcurrentHashMap();
    this.Qrc = new LinkedList();
    this.Qrd = false;
    this.Qre = new HashSet();
    this.Qrf = new HashMap();
    this.Qrg = 4;
    this.QqK = true;
    this.Qri = 0L;
    this.Qrj = 0L;
    this.Qrk = 0;
    this.Qrl = 0;
    this.Qrm = new HashMap();
    this.Qrn = new HashMap();
    this.Qro = new HashMap();
    this.Qrp = 0;
    this.Qrq = 0;
    this.Qrr = new HashMap();
    this.Qrs = new HashSet();
    com.tencent.mm.memory.a.b.a(m.class, new b.a() {});
    int i = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    Log.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.QqY = new com.tencent.mm.memory.a.b(i, new f.b() {}, getClass());
      this.QqZ = new aq(this.Qrg, new aq.a()
      {
        public final boolean gq(Object paramAnonymousObject)
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
              paramAnonymousObject = ((aq.b)((aq)localObject).Qwv.get(str)).obj;
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
            i = ((aq)localObject).Qwv.size();
            paramAnonymousObject = ((aq)localObject).Qwv.remove(str);
            localObject = new StringBuilder("internalMap ").append(((aq)localObject).Qwv.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              Log.d("MicroMsg.SnsLRUMap", bool);
              Log.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(g.this).Qwv.size() + " listPaitSize:" + g.b(g.this).size());
              AppMethodBeat.o(95463);
              return true;
              paramAnonymousObject = (WeakReference)((aq.b)((aq)localObject).Qwv.get(str)).obj;
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
  
  public static String D(dmz paramdmz)
  {
    AppMethodBeat.i(95541);
    if (paramdmz == null)
    {
      AppMethodBeat.o(95541);
      return null;
    }
    if (paramdmz.Id.startsWith("pre_temp_sns_pic")) {
      paramdmz = al.getAccSnsTmpPath() + paramdmz.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(95541);
      return paramdmz;
      if (paramdmz.Id.startsWith("Locall_path")) {
        paramdmz = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.l(paramdmz);
      } else if (paramdmz.Id.startsWith("pre_temp_extend_pic")) {
        paramdmz = paramdmz.Id.substring(19);
      } else {
        paramdmz = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.c(paramdmz);
      }
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, br parambr, String paramString4, String paramString5)
  {
    AppMethodBeat.i(309660);
    if ((!paramBoolean) && (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(309660);
      return null;
    }
    dmz localdmz = o.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    t.db(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = t.aXw(paramString1);
      if (t.S(paramString1))
      {
        AppMethodBeat.o(309660);
        return paramString1;
      }
      AppMethodBeat.o(309660);
      return null;
    }
    if (t.S(null))
    {
      AppMethodBeat.o(309660);
      return null;
    }
    Object localObject = t.k(localdmz);
    localObject = t.aXw(as.mg(al.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!t.S((Bitmap)localObject)) {
      paramString3 = t.aXw(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!Util.isNullOrNil(paramString2))) {
      al.hgw().a(localdmz, 3, null, parambr, null, paramString4, paramString5);
    }
    if (!t.S(paramString3))
    {
      AppMethodBeat.o(309660);
      return null;
    }
    AppMethodBeat.o(309660);
    return paramString3;
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
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, g.a.QrQ);
    AppMethodBeat.o(95510);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95512);
    a(paramObject, paramString, false, -1, paramInt1, paramInt2, paramInt3, g.a.QrQ);
    AppMethodBeat.o(95512);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, g.a parama)
  {
    AppMethodBeat.i(95511);
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, parama);
    AppMethodBeat.o(95511);
  }
  
  private static void a(Object paramObject, String paramString, m paramm)
  {
    long l2 = 0L;
    AppMethodBeat.i(95498);
    if (paramObject == null)
    {
      AppMethodBeat.o(95498);
      return;
    }
    if (paramm != null) {
      Log.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramm.bvX() });
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
      if ((localObject == null) || (!(localObject instanceof ao))) {
        break label468;
      }
      l1 = ((ao)localObject).cmk;
    }
    label454:
    label468:
    for (;;)
    {
      paramm = new ao(paramString, paramm, l1);
      paramObject.as(paramm.cmk, paramString);
      paramObject.setImageDrawable(paramm);
      paramm.invalidateSelf();
      AppMethodBeat.o(95498);
      return;
      if ((paramObject instanceof QDisFadeImageView))
      {
        paramObject = (QDisFadeImageView)paramObject;
        paramString = new com.tencent.mm.memory.b.a(paramString, paramm);
        paramObject.setImageDrawable(paramString);
        paramString.invalidateSelf();
        AppMethodBeat.o(95498);
        return;
      }
      if ((paramObject instanceof ImageView))
      {
        localObject = (ImageView)paramObject;
        paramObject = ((ImageView)localObject).getDrawable();
        if ((paramObject != null) && ((paramObject instanceof ao))) {}
        for (paramObject = new ao(paramString, paramm, ((ao)paramObject).cmk);; paramObject = new ao(paramString, paramm, 0L))
        {
          ((ImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof com.tencent.mm.plugin.sight.decode.model.a))
      {
        Log.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(paramString)));
        if ((paramObject instanceof SightPlayImageView))
        {
          localObject = (SightPlayImageView)paramObject;
          paramObject = ((SightPlayImageView)localObject).getDrawable();
          if ((paramObject == null) || (!(paramObject instanceof ao))) {
            break label361;
          }
        }
        label361:
        for (paramObject = new ao(paramString, paramm, ((ao)paramObject).cmk);; paramObject = new ao(paramString, paramm, 0L))
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
        if ((paramObject == null) || (!(paramObject instanceof ao))) {
          break label454;
        }
      }
      for (paramObject = new ao(paramString, paramm, ((ao)paramObject).cmk);; paramObject = new ao(paramString, paramm, 0L))
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
    this.Qre.remove(new c(null, i, 0, false));
    c localc = new c(paramString, i, paramInt2, paramBoolean);
    this.Qre.add(localc);
    LinkedList localLinkedList = (LinkedList)this.Qra.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.Qra.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.Qra.get(localObject);
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
      this.oHd.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label352;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == g.a.QrR) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
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
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.cd.a.m(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.model.a)paramObject;
            if (!this.QqK) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((com.tencent.mm.plugin.sight.decode.model.a)localObject).e(null, paramBoolean, 0);
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
  
  public static boolean a(dmz paramdmz, br parambr, boolean paramBoolean)
  {
    AppMethodBeat.i(95540);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95540);
      return false;
    }
    Object localObject;
    if (paramdmz.Id.startsWith("Locall_path"))
    {
      localObject = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.l(paramdmz);
      if (y.ZC((String)localObject)) {
        break label161;
      }
      localObject = al.hgw();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 2)
    {
      ((c)localObject).a(paramdmz, i, null, parambr);
      AppMethodBeat.o(95540);
      return false;
      localObject = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.c(paramdmz);
      break;
    }
    label161:
    AppMethodBeat.o(95540);
    return true;
  }
  
  private boolean a(String paramString, m paramm)
  {
    AppMethodBeat.i(95534);
    if ((paramm != null) && (paramString != null))
    {
      this.QqY.put(paramString, paramm);
      com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramString, new a.b(paramString, new WeakReference(paramm), a.a.Qaf));
    }
    AppMethodBeat.o(95534);
    return true;
  }
  
  private boolean a(final List<dmz> paramList, final br parambr)
  {
    AppMethodBeat.i(95515);
    al.hgo().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95466);
        long l = Util.currentTicks();
        Object localObject = new p(paramList);
        ((p)localObject).hOG = t.kx(paramList);
        ((p)localObject).QnY = this.Qrv;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          dmz localdmz = (dmz)paramList.get(j);
          if (al.hgw().aXV(localdmz.Id)) {
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
              } while (y.ZC(as.mg(al.getAccSnsPath(), localdmz.Id) + t.d(localdmz)));
              i = k;
            } while (y.ZC(as.mg(al.getAccSnsPath(), localdmz.Id) + t.k(localdmz)));
            i = k;
          } while (y.ZC(as.mg(al.getAccSnsPath(), localdmz.Id) + t.l(localdmz)));
          c localc = al.hgw();
          if (localdmz.vhJ == 6) {}
          for (int i = 5;; i = 1)
          {
            localc.a(localdmz, i, (p)localObject, parambr);
            i = 0;
            break;
          }
        }
        l = Util.ticksToNow(l);
        if (l > 100L) {
          Log.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.i.b.bmt() + " " + al.hgV() + " " + ((p)localObject).hOG);
        }
        if (Util.ticksToNow(g.c(g.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), al.hgV(), com.tencent.mm.loader.i.b.bmt() });
          g.a(g.this, Util.currentTicks());
        }
        localObject = t.kx(paramList);
        if (k != 0) {
          al.fAG().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95465);
              new i(t.db(0, this.bJZ), this.bJZ, g.9.this.QrM).A(new String[] { "" });
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
  
  private boolean aY(View paramView, int paramInt)
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
      } while (!aY(paramView.getChildAt(j), paramInt));
      AppMethodBeat.o(95485);
      return true;
    }
    AppMethodBeat.o(95485);
    return false;
  }
  
  private m aYe(String paramString)
  {
    AppMethodBeat.i(95493);
    m localm = (m)this.QqY.get(paramString);
    if ((localm == null) || (localm.bvS()))
    {
      this.QqY.remove(paramString);
      com.tencent.mm.plugin.sns.ad.timeline.helper.a.aWM(paramString);
      AppMethodBeat.o(95493);
      return null;
    }
    AppMethodBeat.o(95493);
    return localm;
  }
  
  private boolean aYf(String paramString)
  {
    AppMethodBeat.i(179083);
    if ((this.Qrf.containsKey(paramString)) && (4 == ((Integer)this.Qrf.get(paramString)).intValue())) {
      this.Qrf.remove(paramString);
    }
    AppMethodBeat.o(179083);
    return true;
  }
  
  private void b(dmz paramdmz, View paramView, int paramInt, g.a parama, br parambr)
  {
    AppMethodBeat.i(95497);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95497);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = t.db(5, paramdmz.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = aYd(str);
    if (!t.b(parama))
    {
      js(paramView);
      if (this.Qrs.contains(str))
      {
        AppMethodBeat.o(95497);
        return;
      }
      a(5, paramdmz, parambr);
      AppMethodBeat.o(95497);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95497);
  }
  
  private static boolean gU(String paramString, int paramInt)
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
  
  private boolean hfK()
  {
    AppMethodBeat.i(95516);
    if (this.Qrd)
    {
      Log.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(95516);
      return false;
    }
    al.fAG().postDelayed(new Runnable()
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
          ((g.b)g.e(g.this).removeLast()).A(new String[] { "" });
        }
        AppMethodBeat.o(95467);
      }
    }, 0L);
    AppMethodBeat.o(95516);
    return true;
  }
  
  private static void js(View paramView)
  {
    AppMethodBeat.i(95508);
    if ((paramView instanceof QImageView))
    {
      ((QImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(b.c.BG_3)));
      AppMethodBeat.o(95508);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(b.c.BG_3)));
      AppMethodBeat.o(95508);
      return;
    }
    AppMethodBeat.o(95508);
  }
  
  public static String r(dmz paramdmz)
  {
    AppMethodBeat.i(95489);
    String str = as.mg(al.getAccSnsPath(), paramdmz.Id);
    paramdmz = t.d(paramdmz);
    paramdmz = str + paramdmz;
    AppMethodBeat.o(95489);
    return paramdmz;
  }
  
  public static String s(dmz paramdmz)
  {
    AppMethodBeat.i(95499);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95499);
      return null;
    }
    String str = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.d(paramdmz);
    if (!y.ZC(str))
    {
      paramdmz = paramdmz.aaTl;
      AppMethodBeat.o(95499);
      return paramdmz;
    }
    AppMethodBeat.o(95499);
    return str;
  }
  
  public static String t(dmz paramdmz)
  {
    AppMethodBeat.i(95500);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95500);
      return null;
    }
    String str = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.c(paramdmz);
    if (!y.ZC(str))
    {
      paramdmz = paramdmz.Url;
      AppMethodBeat.o(95500);
      return paramdmz;
    }
    AppMethodBeat.o(95500);
    return str;
  }
  
  public static boolean u(dmz paramdmz)
  {
    AppMethodBeat.i(95518);
    String str1 = as.mg(al.getAccSnsPath(), paramdmz.Id);
    String str2 = t.i(paramdmz);
    if (y.ZC(str1 + str2))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    if ((y.ZC(str1 + t.o(paramdmz))) && (!Util.isNullOrNil(paramdmz.Id)) && (paramdmz.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    AppMethodBeat.o(95518);
    return false;
  }
  
  public final void A(dmz paramdmz)
  {
    AppMethodBeat.i(95529);
    this.Qrf.put(paramdmz.Id, Integer.valueOf(2));
    AppMethodBeat.o(95529);
  }
  
  public final int B(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(369990);
    int i = a(paramSnsInfo, null);
    AppMethodBeat.o(369990);
    return i;
  }
  
  public final void B(dmz paramdmz)
  {
    AppMethodBeat.i(95530);
    this.Qrf.put(paramdmz.Id, Integer.valueOf(3));
    AppMethodBeat.o(95530);
  }
  
  public final int C(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(369991);
    int i = b(paramSnsInfo, null);
    AppMethodBeat.o(369991);
    return i;
  }
  
  public final boolean C(dmz paramdmz)
  {
    AppMethodBeat.i(95539);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95539);
      return false;
    }
    if (y.ZC(as.mg(al.getAccSnsPath(), paramdmz.Id) + t.e(paramdmz)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    if (y.ZC(as.mg(al.getAccSnsPath(), paramdmz.Id) + t.d(paramdmz)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    paramdmz = t.db(1, paramdmz.Id);
    boolean bool = t.b((m)this.QqY.get(paramdmz));
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
    if ((paramArrayOfInt != null) || (Util.ticksToNow(this.Qri) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      d.bId();
      if (!d.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.Qrk = 5;
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
      this.Qrl = ((PInt)localObject).value;
      this.Qri = Util.currentTicks();
      if ((this.Qrl != 0) && (paramSnsInfo != null)) {
        break label163;
      }
      i = this.Qrk;
      AppMethodBeat.o(95520);
      return i;
      this.Qrk = 10;
      break;
    }
    label163:
    if (this.Qrm.containsKey(Long.valueOf(paramSnsInfo.field_snsId)))
    {
      i = ((Integer)this.Qrm.get(Long.valueOf(paramSnsInfo.field_snsId))).intValue();
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = new fer();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.Qrk;
        AppMethodBeat.o(95520);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.aaxD.Op);
      if ((paramArrayOfInt.abEg == null) || (paramArrayOfInt.abEg.hZn == null))
      {
        i = this.Qrk;
        AppMethodBeat.o(95520);
        return i;
      }
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramSnsInfo, "", new Object[0]);
      i = this.Qrk;
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.abEg.hZn;
    i = paramArrayOfInt.hashCode();
    if (this.Qrl == 1)
    {
      if (!this.Qro.containsKey(Integer.valueOf(i))) {
        this.Qro.put(Integer.valueOf(i), Boolean.valueOf(gU(paramArrayOfInt, this.Qrl)));
      }
      if (((Boolean)this.Qro.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        Log.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i) });
        this.Qrm.put(Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95520);
        return i;
      }
    }
    if (!this.Qrn.containsKey(Integer.valueOf(i))) {
      this.Qrn.put(Integer.valueOf(i), Boolean.valueOf(gU(paramArrayOfInt, this.Qrl)));
    }
    if (((Boolean)this.Qrn.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(dmz paramdmz)
  {
    AppMethodBeat.i(95488);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95488);
      return null;
    }
    String str1 = t.db(1, paramdmz.Id);
    Object localObject = aYd(str1);
    if (t.b((m)localObject))
    {
      paramdmz = ((m)localObject).bvQ();
      AppMethodBeat.o(95488);
      return paramdmz;
    }
    localObject = as.mg(al.getAccSnsPath(), paramdmz.Id);
    String str2 = t.d(paramdmz);
    localObject = (String)localObject + str2;
    if (y.ZC((String)localObject))
    {
      if (paramdmz.Id.startsWith("pre_temp_extend_pic")) {}
      for (paramdmz = m.O(aa.ban((String)localObject)); t.b(paramdmz); paramdmz = t.aXx((String)localObject))
      {
        a(str1, paramdmz);
        paramdmz = paramdmz.bvQ();
        AppMethodBeat.o(95488);
        return paramdmz;
      }
      AppMethodBeat.o(95488);
      return null;
    }
    AppMethodBeat.o(95488);
    return null;
  }
  
  public final m a(dmz paramdmz, ImageView paramImageView, int paramInt, br parambr)
  {
    AppMethodBeat.i(95543);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95543);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = t.db(0, paramdmz.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = aYd(str);
    if (!t.b(paramImageView))
    {
      a(0, paramdmz, parambr);
      AppMethodBeat.o(95543);
      return null;
    }
    AppMethodBeat.o(95543);
    return paramImageView;
  }
  
  public final String a(SnsInfo paramSnsInfo, final dmz paramdmz, final br parambr, boolean paramBoolean)
  {
    AppMethodBeat.i(95531);
    if (v(paramdmz))
    {
      AppMethodBeat.o(95531);
      return "";
    }
    String str1 = as.mg(al.getAccSnsPath(), paramdmz.Id);
    String str2 = t.i(paramdmz);
    if (y.ZC(str1 + str2))
    {
      paramSnsInfo = str1 + str2;
      AppMethodBeat.o(95531);
      return paramSnsInfo;
    }
    if ((y.ZC(str1 + t.o(paramdmz))) && (paramdmz.Id != null) && (paramdmz.Id.startsWith("Locall_path")))
    {
      paramSnsInfo = str1 + t.o(paramdmz);
      AppMethodBeat.o(95531);
      return paramSnsInfo;
    }
    if (!this.QqK)
    {
      AppMethodBeat.o(95531);
      return "";
    }
    Log.i("MicroMsg.LazyerImageLoader2", "push sight loader " + paramdmz.Id + " url: " + paramdmz.Url);
    if (paramBoolean) {
      if (b(paramSnsInfo, null) == 5) {
        al.fAG().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95470);
            al.hgw().a(paramdmz, 4, null, parambr);
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
  
  public final void a(dmz paramdmz, View paramView, int paramInt1, int paramInt2, g.a parama, br parambr)
  {
    AppMethodBeat.i(95496);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95496);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = t.db(0, paramdmz.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = aYd(str);
    if (!t.b(parama))
    {
      Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        js(paramView);
      }
      if (this.Qrs.contains(str))
      {
        AppMethodBeat.o(95496);
        return;
      }
      a(0, paramdmz, parambr);
      AppMethodBeat.o(95496);
      return;
    }
    Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    al.hgw().aYa(paramdmz.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(95496);
  }
  
  public final void a(dmz paramdmz, View paramView, int paramInt1, int paramInt2, br parambr)
  {
    AppMethodBeat.i(95494);
    a(paramdmz, paramView, paramInt1, paramInt2, g.a.QrQ, parambr);
    AppMethodBeat.o(95494);
  }
  
  public final void a(dmz paramdmz, View paramView, int paramInt, g.a parama, br parambr)
  {
    AppMethodBeat.i(95491);
    a(paramdmz, paramView, -1, paramInt, parama, parambr);
    AppMethodBeat.o(95491);
  }
  
  public final void a(dmz paramdmz, View paramView, int paramInt1, g.a parama, br parambr, int paramInt2)
  {
    AppMethodBeat.i(309842);
    a(paramdmz, paramView, paramInt2, paramInt1, parama, parambr);
    AppMethodBeat.o(309842);
  }
  
  public final void a(dmz paramdmz, View paramView, int paramInt, br parambr)
  {
    AppMethodBeat.i(95501);
    b(paramdmz, paramView, -1, paramInt, parambr);
    AppMethodBeat.o(95501);
  }
  
  public final void a(final dmz paramdmz, final View paramView, final int paramInt, final boolean paramBoolean1, final br parambr, final boolean paramBoolean2, final e parame)
  {
    AppMethodBeat.i(95542);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95542);
      return;
    }
    final String str1 = t.db(3, paramdmz.Id);
    final String str2 = D(paramdmz);
    if (al.hgw().aXW(paramdmz.Id))
    {
      Log.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + paramdmz.Id);
      a(paramView, str1, paramInt, -1, -1);
      parame.aN(null);
      AppMethodBeat.o(95542);
      return;
    }
    Object localObject1 = this.QqZ;
    Object localObject2 = (aq.b)((aq)localObject1).Qwv.get(str1);
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
      if (!t.S((Bitmap)localObject1)) {
        break label305;
      }
      Log.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
      a(paramView, str1, paramInt, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      parame.aN((Bitmap)localObject1);
      AppMethodBeat.o(95542);
      return;
      ((aq.b)((aq)localObject1).Qwv.get(str1)).hhg();
      localObject1 = ((aq.b)localObject2).obj;
      break;
      bool = false;
      break label185;
    }
    label305:
    al.hgm().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95459);
        final Bitmap localBitmap = t.aXw(str2);
        al.fAG().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95458);
            if (t.S(localBitmap))
            {
              g.a(g.this, g.4.this.Qqc, g.4.this.Qry, g.4.this.Qrz, localBitmap.getWidth(), localBitmap.getHeight());
              if (!t.S(localBitmap)) {
                break label252;
              }
              localObject1 = g.a(g.this);
              localObject2 = g.4.this.Qry;
              localObject3 = new WeakReference(localBitmap);
              if ((aq.b)((aq)localObject1).Qwv.get(localObject2) != null) {
                break label215;
              }
              localObject3 = new aq.b((aq)localObject1, localObject3);
              ((aq)localObject1).Qwv.put(localObject2, localObject3);
              ((aq)localObject1).hhf();
            }
            label215:
            label252:
            while (!g.4.this.QrA) {
              for (;;)
              {
                Object localObject3;
                if (g.4.this.QrD != null) {
                  g.4.this.QrD.aN(localBitmap);
                }
                AppMethodBeat.o(95458);
                return;
                g.a(g.this, g.4.this.Qqc, g.4.this.Qry, g.4.this.Qrz, -1, -1);
                break;
                ((aq.b)((aq)localObject1).Qwv.get(localObject2)).hhg();
                ((aq.b)((aq)localObject1).Qwv.get(localObject2)).obj = localObject3;
              }
            }
            Object localObject1 = al.hgw();
            Object localObject2 = g.4.this.QaD;
            if (g.4.this.QrB) {}
            for (int i = 8;; i = 2)
            {
              ((c)localObject1).a((dmz)localObject2, i, null, g.4.this.QrC);
              break;
            }
          }
        });
        AppMethodBeat.o(95459);
      }
    });
    AppMethodBeat.o(95542);
  }
  
  public final void a(final String paramString, SparseArray<dmz> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, final br parambr, final int paramInt2)
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
      dmz localdmz = (dmz)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = t.db(0, localdmz.Id);
      a(localView, str, -1, paramInt1, g.a.QrQ);
      m localm = aYd(str);
      if (!t.b(localm))
      {
        Log.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        js(localView);
        if (!this.Qrs.contains(str)) {
          localSparseArray1.put(k, localdmz);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        Log.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
        a(localView, str, localm);
      }
    }
    if (localSparseArray1.size() != 0)
    {
      Log.i("MicroMsg.LazyerImageLoader2", "ok, let's download.");
      al.hgo().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95464);
          int j = localSparseArray1.size();
          int i = 0;
          while (i < j)
          {
            int k = localSparseArray1.keyAt(i);
            dmz localdmz = (dmz)localSparseArray1.get(k);
            if (!g.a(g.this, 0, localdmz))
            {
              p localp = new p(localdmz);
              localp.QnY = 0;
              localp.hOG = localdmz.Id;
              localSparseArray2.put(k, localp);
              localSparseArray3.put(k, localdmz);
            }
            i += 1;
          }
          if (localSparseArray3.size() > 0) {
            al.hgw().a(paramString, localSparseArray3, localSparseArray2, parambr, paramInt2, 2);
          }
          AppMethodBeat.o(95464);
        }
      });
    }
    AppMethodBeat.o(95495);
  }
  
  public final void a(List<dmz> paramList, View paramView, int paramInt, g.a parama, br parambr)
  {
    AppMethodBeat.i(95545);
    a(paramList, paramView, paramInt, parama, parambr, false);
    AppMethodBeat.o(95545);
  }
  
  public final void a(List<dmz> paramList, View paramView, int paramInt, g.a parama, br parambr, boolean paramBoolean)
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
        b((dmz)paramList.get(0), paramView, paramInt, parambr);
        AppMethodBeat.o(95546);
        return;
      }
      b((dmz)paramList.get(0), paramView, paramInt, g.a.QrR, parambr);
      AppMethodBeat.o(95546);
      return;
    }
    String str = t.db(0, t.kx(paramList));
    a(paramView, str, paramInt, parama);
    parama = aYd(str);
    paramBoolean = t.b(parama);
    Log.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      js(paramView);
      if (this.Qrs.contains(str))
      {
        AppMethodBeat.o(95546);
        return;
      }
      new WeakReference(paramView);
      a(paramList, parambr);
      AppMethodBeat.o(95546);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95546);
  }
  
  public final boolean a(final int paramInt, final dmz paramdmz, final br parambr)
  {
    AppMethodBeat.i(95517);
    if (!this.QqK)
    {
      if ((paramdmz != null) && (!Util.isNullOrNil(paramdmz.Id))) {
        al.hgw().aYa(paramdmz.Id);
      }
      AppMethodBeat.o(95517);
      return false;
    }
    al.hgo().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95469);
        p localp;
        c localc;
        dmz localdmz;
        if (!g.a(g.this, paramInt, paramdmz))
        {
          localp = new p(paramdmz);
          localp.QnY = paramInt;
          localp.hOG = paramdmz.Id;
          localc = al.hgw();
          localdmz = paramdmz;
          if (paramdmz.vhJ != 6) {
            break label97;
          }
        }
        label97:
        for (int i = 5;; i = 1)
        {
          localc.a(localdmz, i, localp, parambr);
          AppMethodBeat.o(95469);
          return;
        }
      }
    });
    AppMethodBeat.o(95517);
    return true;
  }
  
  public final boolean a(p paramp, String paramString)
  {
    AppMethodBeat.i(95535);
    Object localObject1 = (dmz)paramp.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < paramp.list.size())
    {
      localObject2 = (dmz)paramp.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((dmz)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = as.mg(al.getAccSnsPath(), ((dmz)localObject1).Id);
      if (paramp.QnY == 0) {
        paramString = t.e((dmz)localObject1);
      }
      for (;;)
      {
        String str = t.db(paramp.QnY, ((dmz)localObject1).Id);
        if (!this.QqY.check(str)) {
          new b(t.db(paramp.QnY, ((dmz)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (dmz)localObject1, paramp.QnY).A(new String[] { "" });
        }
        AppMethodBeat.o(95535);
        return true;
        i += 1;
        break;
        if (paramp.QnY == 4) {
          paramString = t.f((dmz)localObject1);
        } else if (paramp.QnY == 5) {
          paramString = t.f((dmz)localObject1);
        } else if (paramp.QnY == 3) {
          paramString = t.k((dmz)localObject1);
        } else {
          paramString = t.d((dmz)localObject1);
        }
      }
    }
  }
  
  public final boolean a(SnsInfo paramSnsInfo, dmz paramdmz, SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt, br parambr)
  {
    AppMethodBeat.i(309888);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(309888);
      return false;
    }
    String str1 = t.db(1, paramdmz.Id);
    a(paramSnsAdTimelineVideoView, str1, -1, paramInt);
    String str2 = as.mg(al.getAccSnsPath(), paramdmz.Id);
    String str3 = t.d(paramdmz);
    p localp;
    c localc;
    if (!y.ZC(str2 + str3))
    {
      localp = new p(paramdmz);
      localp.QnY = 1;
      localp.hOG = paramdmz.Id;
      localc = al.hgw();
      if (paramdmz.vhJ != 6) {
        break label264;
      }
    }
    label264:
    for (paramInt = 5;; paramInt = 1)
    {
      localc.a(paramdmz, paramInt, localp, parambr);
      paramSnsInfo = a(paramSnsInfo, paramdmz, parambr, true);
      Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", new Object[] { str1, paramSnsInfo, Boolean.TRUE });
      if ((Util.isNullOrNil(paramSnsInfo)) || (v(paramdmz))) {
        break;
      }
      if (!paramSnsInfo.equals(paramSnsAdTimelineVideoView.getVideoPath()))
      {
        paramSnsAdTimelineVideoView.setThumbBmp(BitmapUtil.decodeFile(str2 + str3));
        paramSnsAdTimelineVideoView.hsQ();
      }
      paramSnsAdTimelineVideoView.setVideoPath(paramSnsInfo);
      AppMethodBeat.o(309888);
      return true;
    }
    Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, sightPath %s", new Object[] { paramSnsInfo });
    paramSnsAdTimelineVideoView.setVideoPath(null);
    paramSnsAdTimelineVideoView.clear();
    paramSnsInfo = aYd(str1);
    boolean bool = t.b(paramSnsInfo);
    Log.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      paramSnsAdTimelineVideoView.setThumbBmp(null);
      if (this.Qrs.contains(str1))
      {
        AppMethodBeat.o(309888);
        return false;
      }
      a(1, paramdmz, parambr);
      AppMethodBeat.o(309888);
      return false;
    }
    a(paramSnsAdTimelineVideoView, str1, paramSnsInfo);
    AppMethodBeat.o(309888);
    return true;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, dmz paramdmz, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, int paramInt3, br parambr, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(309885);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(309885);
      return false;
    }
    String str1 = t.db(1, paramdmz.Id);
    a(paramVideoSightView, str1, -1, paramInt2);
    String str2 = as.mg(al.getAccSnsPath(), paramdmz.Id);
    String str3 = t.d(paramdmz);
    Object localObject1;
    Object localObject2;
    if (!y.ZC(str2 + str3))
    {
      localObject1 = new p(paramdmz);
      ((p)localObject1).QnY = 1;
      ((p)localObject1).hOG = paramdmz.Id;
      localObject2 = al.hgw();
      if (paramdmz.vhJ == 6)
      {
        paramInt1 = 5;
        ((c)localObject2).a(paramdmz, paramInt1, (p)localObject1, parambr);
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
          localObject1 = a(paramSnsInfo, paramdmz, parambr, paramBoolean1);
        }
      }
      Log.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject1, Boolean.valueOf(paramBoolean1) });
      if ((Util.isNullOrNil((String)localObject1)) || (v(paramdmz))) {
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
      AppMethodBeat.o(309885);
      return true;
      paramInt1 = 1;
      break;
    }
    label315:
    Log.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject1 });
    paramVideoSightView.setVideoPath(null);
    paramVideoSightView.clear();
    paramSnsInfo = aYd(str1);
    paramBoolean1 = t.b(paramSnsInfo);
    Log.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!paramBoolean1)
    {
      paramVideoSightView.setPosition(0);
      paramVideoSightView.setThumbBmp(null);
      if (this.Qrs.contains(str1))
      {
        AppMethodBeat.o(309885);
        return false;
      }
      a(1, paramdmz, parambr);
      AppMethodBeat.o(309885);
      return false;
    }
    a(paramVideoSightView, str1, paramSnsInfo);
    AppMethodBeat.o(309885);
    return true;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, dmz paramdmz, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, br parambr, boolean paramBoolean)
  {
    AppMethodBeat.i(176251);
    paramBoolean = a(paramSnsInfo, paramdmz, paramVideoSightView, paramInt1, paramInt2, parambr, paramBoolean, false);
    AppMethodBeat.o(176251);
    return paramBoolean;
  }
  
  public final boolean a(SnsInfo paramSnsInfo, dmz paramdmz, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, br parambr, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176252);
    paramBoolean1 = a(paramSnsInfo, paramdmz, paramVideoSightView, -1, paramInt1, paramInt2, parambr, paramBoolean1, paramBoolean2, true);
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
  
  public final boolean a(dmz paramdmz, View paramView, int paramInt1, int paramInt2, br parambr, int paramInt3)
  {
    AppMethodBeat.i(95507);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95507);
      return false;
    }
    String str = t.db(paramInt3, paramdmz.Id);
    a(paramView, str, paramInt1, paramInt2);
    m localm = aYd(str);
    boolean bool = t.b(localm);
    Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        js(paramView);
      }
      if (this.Qrs.contains(str))
      {
        AppMethodBeat.o(95507);
        return true;
      }
      a(paramInt3, paramdmz, parambr);
      AppMethodBeat.o(95507);
      return false;
    }
    a(paramView, str, localm);
    AppMethodBeat.o(95507);
    return true;
  }
  
  public final boolean a(String paramString, m paramm, int paramInt)
  {
    AppMethodBeat.i(95533);
    a(paramInt + "-" + paramString, paramm);
    AppMethodBeat.o(95533);
    return true;
  }
  
  public final m aYd(String paramString)
  {
    AppMethodBeat.i(95492);
    m localm = (m)this.QqY.get(paramString);
    if ((localm == null) || (localm.bvS()))
    {
      this.QqY.remove(paramString);
      com.tencent.mm.plugin.sns.ad.timeline.helper.a.aWM(paramString);
      AppMethodBeat.o(95492);
      return null;
    }
    AppMethodBeat.o(95492);
    return localm;
  }
  
  public final void aYg(String paramString)
  {
    AppMethodBeat.i(95536);
    b(paramString, null);
    AppMethodBeat.o(95536);
  }
  
  public final m aYh(String paramString)
  {
    AppMethodBeat.i(95537);
    if (this.QqY == null)
    {
      AppMethodBeat.o(95537);
      return null;
    }
    paramString = (m)this.QqY.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95537);
    return paramString;
  }
  
  public final boolean aYi(String paramString)
  {
    AppMethodBeat.i(310031);
    boolean bool = this.Qrs.contains(paramString);
    AppMethodBeat.o(310031);
    return bool;
  }
  
  public final int b(SnsInfo paramSnsInfo, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95522);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (Util.ticksToNow(this.Qrj) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      d.bId();
      if (!d.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.Qrp = 5;
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
      this.Qrq = ((PInt)localObject).value;
      this.Qrj = Util.currentTicks();
      if ((this.Qrq != 0) && (paramSnsInfo != null)) {
        break label144;
      }
      i = this.Qrp;
      AppMethodBeat.o(95522);
      return i;
      this.Qrp = 10;
      break;
    }
    label144:
    if (this.Qrr.containsKey(Long.valueOf(paramSnsInfo.field_snsId)))
    {
      i = ((Integer)this.Qrr.get(Long.valueOf(paramSnsInfo.field_snsId))).intValue();
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = new fer();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramSnsInfo.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.Qrp;
        AppMethodBeat.o(95522);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.aaxD.Op);
      if ((paramArrayOfInt.abEg == null) || (paramArrayOfInt.abEg.hZn == null))
      {
        i = this.Qrk;
        AppMethodBeat.o(95522);
        return i;
      }
    }
    catch (Exception paramSnsInfo)
    {
      Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramSnsInfo, "", new Object[0]);
      i = this.Qrp;
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.abEg.hZn;
    i = paramArrayOfInt.hashCode();
    if (this.Qrq == 1)
    {
      if (!this.Qro.containsKey(Integer.valueOf(i))) {
        this.Qro.put(Integer.valueOf(i), Boolean.valueOf(gU(paramArrayOfInt, this.Qrq)));
      }
      if (((Boolean)this.Qro.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        Log.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i) });
        this.Qrr.put(Long.valueOf(paramSnsInfo.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95522);
        return i;
      }
    }
    if (!this.Qrn.containsKey(Integer.valueOf(i))) {
      this.Qrn.put(Integer.valueOf(i), Boolean.valueOf(gU(paramArrayOfInt, this.Qrq)));
    }
    if (((Boolean)this.Qrn.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final void b(dmz paramdmz, View paramView, int paramInt, br parambr)
  {
    AppMethodBeat.i(95490);
    a(paramdmz, paramView, -1, paramInt, parambr);
    AppMethodBeat.o(95490);
  }
  
  protected final void b(String paramString, m paramm)
  {
    AppMethodBeat.i(95547);
    m localm = paramm;
    if (!t.b(paramm)) {
      localm = aYe(paramString);
    }
    if (t.b(localm))
    {
      if ((this.QqY != null) && (localm != null) && (paramString != null))
      {
        this.QqY.put(paramString, localm);
        com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramString, new a.b(paramString, new WeakReference(localm), a.a.Qaf));
      }
      paramm = (LinkedList)this.Qra.get(paramString);
      if (paramm != null)
      {
        paramm = paramm.iterator();
        while (paramm.hasNext())
        {
          Object localObject = (c)((WeakReference)paramm.next()).get();
          if ((localObject != null) && (((c)localObject).QrV) && (paramString != null) && (paramString.equals(((c)localObject).id)))
          {
            int i = ((c)localObject).code;
            localObject = (WeakReference)this.oHd.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.Qrh != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.Qrh.alH(i))) {
                      continue;
                    }
                  }
                }
                if ((t.b(localm)) && (localObject != null))
                {
                  a(localObject, paramString, localm);
                }
                else
                {
                  boolean bool1;
                  if (localm == null)
                  {
                    bool1 = true;
                    label290:
                    if (localObject != null) {
                      break label346;
                    }
                  }
                  label346:
                  for (boolean bool2 = true;; bool2 = false)
                  {
                    Log.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(t.b(localm)) });
                    break;
                    bool1 = false;
                    break label290;
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
  
  public final boolean b(dmz paramdmz, View paramView, int paramInt1, int paramInt2, br parambr)
  {
    AppMethodBeat.i(95506);
    boolean bool = a(paramdmz, paramView, paramInt1, paramInt2, parambr, 1);
    AppMethodBeat.o(95506);
    return bool;
  }
  
  public final void bq(Activity paramActivity)
  {
    AppMethodBeat.i(95486);
    Log.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.oHd.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.Qre.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (aY(paramActivity.getWindow().getDecorView(), ((c)localObject3).code)) {
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
      this.oHd.remove(Integer.valueOf(i));
      localObject3 = this.Qre.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        c localc = (c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.Qre.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.Qre.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (((c)localObject3).QrU == paramActivity.hashCode()) {
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
      this.oHd.remove(Integer.valueOf(i));
      localObject1 = this.Qre.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (((c)localObject2).code != i) {
          break;
        }
        this.Qre.remove(localObject2);
      }
    }
    label371:
    this.QqZ.hhf();
    Log.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.oHd.size());
    AppMethodBeat.o(95486);
  }
  
  public final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95544);
    a(paramView, null, true, -1, paramInt3, -1, -1, g.a.QrQ);
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
        ((ImageView)paramView).setImageDrawable(com.tencent.mm.cd.a.m(paramView.getContext(), paramInt2));
        AppMethodBeat.o(95544);
      }
    }
    else
    {
      if ((paramView instanceof QFadeImageView))
      {
        ((QFadeImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(b.c.BG_3)));
        AppMethodBeat.o(95544);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageDrawable(new ColorDrawable(paramView.getResources().getColor(b.c.BG_3)));
      }
    }
    AppMethodBeat.o(95544);
  }
  
  public final void c(dmz paramdmz, View paramView, int paramInt, br parambr)
  {
    AppMethodBeat.i(95505);
    if ((paramdmz == null) || (paramdmz.Id == null) || (paramdmz.Id.equals("")))
    {
      AppMethodBeat.o(95505);
      return;
    }
    String str = t.db(4, paramdmz.Id);
    a(paramView, str, -1, paramInt);
    m localm = aYd(str);
    boolean bool = t.b(localm);
    Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      js(paramView);
      if (!this.Qrs.contains(str))
      {
        a(4, paramdmz, parambr);
        AppMethodBeat.o(95505);
      }
    }
    else
    {
      a(paramView, str, localm);
    }
    AppMethodBeat.o(95505);
  }
  
  public final void heg()
  {
    AppMethodBeat.i(95548);
    hfJ();
    this.Qri = 0L;
    this.Qrj = 0L;
    this.Qrc.clear();
    this.Qrd = false;
    AppMethodBeat.o(95548);
  }
  
  public final void hfJ()
  {
    AppMethodBeat.i(95484);
    if (this.QqY != null)
    {
      this.oHd.clear();
      this.QqZ.Qwv.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.QqY.putCount() + ";");
      localStringBuffer.append("missCount:" + this.QqY.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.QqY.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.QqY.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.QqY.evictionCount() + ";");
      Log.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.QqY.trimToSize(-1);
    }
    com.tencent.mm.plugin.sns.ad.timeline.helper.a.hbO();
    this.QqZ.hhf();
    System.gc();
    AppMethodBeat.o(95484);
  }
  
  public final void jq(View paramView)
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
  
  public final boolean jt(View paramView)
  {
    AppMethodBeat.i(95514);
    int i = paramView.hashCode();
    paramView = this.Qre.iterator();
    while (paramView.hasNext())
    {
      c localc = (c)paramView.next();
      if (i == localc.code) {
        this.Qre.remove(localc);
      }
    }
    this.oHd.remove(Integer.valueOf(i));
    AppMethodBeat.o(95514);
    return true;
  }
  
  public final Bitmap lS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(309832);
    m localm = aYd(paramString1);
    if (t.b(localm))
    {
      paramString1 = localm.bvQ();
      AppMethodBeat.o(309832);
      return paramString1;
    }
    if (y.ZC(paramString1))
    {
      paramString2.startsWith("pre_temp_extend_pic");
      paramString2 = m.O(aa.ban(paramString1));
      if (t.b(paramString2))
      {
        a(paramString1, paramString2);
        paramString1 = paramString2.bvQ();
        AppMethodBeat.o(309832);
        return paramString1;
      }
      AppMethodBeat.o(309832);
      return null;
    }
    AppMethodBeat.o(309832);
    return null;
  }
  
  public final boolean md(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95532);
    if ((this.Qrf.containsKey(paramString1)) && (3 == ((Integer)this.Qrf.get(paramString1)).intValue())) {
      this.Qrf.remove(paramString1);
    }
    String str = t.db(1, paramString1);
    Log.i("MicroMsg.LazyerImageLoader2", "TimeLineAdPreloadHelper, download video complete, mediaId=" + paramString1 + ", path=" + paramString2);
    Object localObject1 = (LinkedList)this.Qra.get(str);
    com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramString1, new a.c(paramString1, paramString2, a.a.Qaf));
    if (localObject1 == null)
    {
      AppMethodBeat.o(95532);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((c)localObject2).QrV) && (str != null) && (str.equals(((c)localObject2).id)))
      {
        int i = ((c)localObject2).code;
        localObject2 = (WeakReference)this.oHd.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            aw localaw;
            if ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.model.a))
            {
              Log.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (com.tencent.mm.plugin.sight.decode.model.a)localObject2;
              if ((((com.tencent.mm.plugin.sight.decode.model.a)localObject2).getTagObject() instanceof aw))
              {
                localaw = (aw)((com.tencent.mm.plugin.sight.decode.model.a)localObject2).getTagObject();
                boolean bool;
                if (localaw != null)
                {
                  if (y.ZC(paramString2))
                  {
                    if (!this.QqK) {}
                    for (bool = true;; bool = false)
                    {
                      ((com.tencent.mm.plugin.sight.decode.model.a)localObject2).e(paramString2, bool, localaw.position);
                      ((com.tencent.mm.plugin.sight.decode.model.a)localObject2).setPosition(localaw.position);
                      localaw.RjP.setVisibility(8);
                      localaw.PQu.setVisibility(8);
                      localaw.QRC.setVisibility(8);
                      aYf(paramString1);
                      break;
                    }
                  }
                  setError(paramString1);
                  localaw.RjP.setVisibility(8);
                  localaw.PQu.setImageResource(b.e.sight_chat_error);
                  localaw.PQu.setVisibility(0);
                }
                else
                {
                  if (!this.QqK) {}
                  for (bool = true;; bool = false)
                  {
                    ((com.tencent.mm.plugin.sight.decode.model.a)localObject2).e(paramString2, bool, 0);
                    break;
                  }
                }
              }
            }
            else if ((localObject2 instanceof SnsAdTimelineVideoView))
            {
              Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (SnsAdTimelineVideoView)localObject2;
              if ((((SnsAdTimelineVideoView)localObject2).getTag() instanceof aw))
              {
                localaw = (aw)((SnsAdTimelineVideoView)localObject2).getTag();
                if (localaw != null)
                {
                  if (y.ZC(paramString2))
                  {
                    ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                    ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                    localaw.RjP.setVisibility(8);
                    localaw.PQu.setVisibility(8);
                    localaw.QRC.setVisibility(8);
                    aYf(paramString1);
                  }
                  else
                  {
                    setError(paramString1);
                    localaw.RjP.setVisibility(8);
                    localaw.PQu.setImageResource(b.e.sight_chat_error);
                    localaw.PQu.setVisibility(0);
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
    this.QqK = false;
    c localc = al.hgw();
    localc.QqK = false;
    localc.hfA();
    AppMethodBeat.o(95482);
  }
  
  public final void setError(String paramString)
  {
    AppMethodBeat.i(179084);
    this.Qrf.put(paramString, Integer.valueOf(4));
    AppMethodBeat.o(179084);
  }
  
  public final void start()
  {
    AppMethodBeat.i(95481);
    this.QqK = true;
    hfK();
    c localc = al.hgw();
    localc.QqK = true;
    localc.bJu();
    AppMethodBeat.o(95481);
  }
  
  public final boolean v(dmz paramdmz)
  {
    AppMethodBeat.i(95524);
    if (!this.Qrf.containsKey(paramdmz.Id))
    {
      AppMethodBeat.o(95524);
      return false;
    }
    if (((Integer)this.Qrf.get(paramdmz.Id)).intValue() == 1)
    {
      AppMethodBeat.o(95524);
      return true;
    }
    AppMethodBeat.o(95524);
    return false;
  }
  
  public final boolean w(dmz paramdmz)
  {
    AppMethodBeat.i(95525);
    if (!this.Qrf.containsKey(paramdmz.Id))
    {
      AppMethodBeat.o(95525);
      return false;
    }
    if (((Integer)this.Qrf.get(paramdmz.Id)).intValue() == 2)
    {
      AppMethodBeat.o(95525);
      return true;
    }
    AppMethodBeat.o(95525);
    return false;
  }
  
  public final boolean x(dmz paramdmz)
  {
    AppMethodBeat.i(95526);
    if (!this.Qrf.containsKey(paramdmz.Id))
    {
      AppMethodBeat.o(95526);
      return false;
    }
    if (((Integer)this.Qrf.get(paramdmz.Id)).intValue() == 3)
    {
      AppMethodBeat.o(95526);
      return true;
    }
    AppMethodBeat.o(95526);
    return false;
  }
  
  public final boolean y(dmz paramdmz)
  {
    AppMethodBeat.i(95527);
    if (!this.Qrf.containsKey(paramdmz.Id))
    {
      AppMethodBeat.o(95527);
      return false;
    }
    if (((Integer)this.Qrf.get(paramdmz.Id)).intValue() == 4)
    {
      AppMethodBeat.o(95527);
      return true;
    }
    AppMethodBeat.o(95527);
    return false;
  }
  
  public final void z(dmz paramdmz)
  {
    AppMethodBeat.i(95528);
    this.Qrf.put(paramdmz.Id, Integer.valueOf(1));
    AppMethodBeat.o(95528);
  }
  
  final class b
    extends h<String, Integer, Boolean>
  {
    private int QrT;
    private dmz ibT;
    String key;
    private m nOC;
    private String oYg;
    private String path;
    
    public b(String paramString1, String paramString2, String paramString3, dmz paramdmz, int paramInt)
    {
      AppMethodBeat.i(95474);
      this.key = "";
      this.nOC = null;
      this.QrT = 0;
      g.this.Qrs.add(paramString1);
      this.key = paramString1;
      this.path = paramString2;
      this.oYg = paramString3;
      this.ibT = paramdmz;
      this.QrT = paramInt;
      g.gmJ();
      Log.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(g.cjJ()) });
      AppMethodBeat.o(95474);
    }
    
    private void aV(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(95475);
      y.ZC(this.oYg + paramString3);
      if (!y.ZC(this.oYg + paramString1))
      {
        String str = paramString2;
        if (!y.ZC(this.oYg + paramString2)) {
          str = t.l(this.ibT);
        }
        boolean bool = aa.a(this.oYg, str, paramString1, al.hgQ());
        if (!bool)
        {
          Log.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
          y.deleteFile(this.oYg + str);
        }
        Log.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.oYg + str, this.oYg + paramString1, Boolean.valueOf(bool) });
      }
      aa.b(this.oYg, paramString1, paramString3, al.hgP());
      AppMethodBeat.o(95475);
    }
    
    private Boolean hfM()
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
      y.bEr(this.oYg);
      long l1 = System.currentTimeMillis();
      long l2;
      if (!y.ZC(this.path))
      {
        aV(t.d(this.ibT), t.k(this.ibT), t.e(this.ibT));
        l2 = Util.currentTicks();
        if (this.QrT != 5) {
          break label769;
        }
        if (!y.ZC(this.path)) {
          aV(t.d(this.ibT), t.k(this.ibT), t.e(this.ibT));
        }
        bool1 = y.ZC(this.oYg + t.d(this.ibT));
        boolean bool2 = y.ZC(this.oYg + t.k(this.ibT));
        boolean bool3 = y.ZC(this.oYg + t.e(this.ibT));
        this.nOC = t.aXv(this.path);
        if (this.nOC == null)
        {
          Log.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = t.e(this.ibT);
          this.nOC = com.tencent.mm.plugin.sns.lucky.a.a.mb(this.oYg + (String)localObject, this.path);
          boolean bool4 = y.ZC(this.path);
          Log.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
        }
        label427:
        long l3 = Util.ticksToNow(l2);
        int i = (int)y.bEl(this.path);
        if (Util.ticksToNow(g.i(g.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), al.hgV(), com.tencent.mm.loader.i.b.bmt() });
          g.b(g.this, Util.currentTicks());
        }
        if (this.nOC == null)
        {
          Log.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.ibT.Id });
          y.deleteFile(this.oYg + t.e(this.ibT));
          y.deleteFile(this.path);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 2L, 1L, true);
        }
        l3 = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 0L, 1L, true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 1L, l3 - l1, true);
        localObject = new StringBuilder("doInBackground decode %s and ");
        if (this.nOC != null) {
          break label872;
        }
      }
      label769:
      label872:
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.ImageLoader", bool1 + " " + this.nOC + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
        localObject = Boolean.TRUE;
        AppMethodBeat.o(95476);
        return localObject;
        Log.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
        break;
        if (this.QrT == 4)
        {
          this.nOC = t.aXv(this.path);
          if (this.nOC != null) {
            break label427;
          }
          Log.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = t.d(this.ibT);
          this.nOC = com.tencent.mm.plugin.sns.lucky.a.a.mb(this.oYg + (String)localObject, this.path);
          break label427;
        }
        this.nOC = t.aXx(this.path);
        break label427;
      }
    }
    
    public final ExecutorService gDT()
    {
      AppMethodBeat.i(179079);
      ExecutorService localExecutorService = al.hgm();
      AppMethodBeat.o(179079);
      return localExecutorService;
    }
  }
  
  static final class c
  {
    public int QrU;
    public boolean QrV;
    public int code;
    public String id;
    
    public c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.id = paramString;
      this.code = paramInt1;
      this.QrU = paramInt2;
      this.QrV = paramBoolean;
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
    public abstract void j(Bitmap paramBitmap, String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void aN(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
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
  private static int zxj = 0;
  private Map<Integer, WeakReference<Object>> idb;
  public boolean zwA;
  private long zwM;
  private long zwN;
  com.tencent.mm.memory.a.b<com.tencent.mm.memory.n> zwO;
  private an<String, WeakReference<Bitmap>> zwP;
  private Map<String, LinkedList<WeakReference<c>>> zwQ;
  private ConcurrentHashMap<Integer, String> zwR;
  private LinkedList<b> zwS;
  private boolean zwT;
  private HashSet<c> zwU;
  public HashMap<String, Integer> zwV;
  private int zwW;
  public ab zwX;
  public long zwY;
  public long zwZ;
  private int zxa;
  private int zxb;
  private HashMap<Long, Integer> zxc;
  private HashMap<Integer, Boolean> zxd;
  private HashMap<Integer, Boolean> zxe;
  private int zxf;
  private int zxg;
  private HashMap<Long, Integer> zxh;
  protected Set<String> zxi;
  
  public g()
  {
    AppMethodBeat.i(95483);
    this.zwM = 0L;
    this.zwN = 0L;
    this.idb = new HashMap();
    this.zwQ = new HashMap();
    this.zwR = new ConcurrentHashMap();
    this.zwS = new LinkedList();
    this.zwT = false;
    this.zwU = new HashSet();
    this.zwV = new HashMap();
    this.zwW = 4;
    this.zwA = true;
    this.zwY = 0L;
    this.zwZ = 0L;
    this.zxa = 0;
    this.zxb = 0;
    this.zxc = new HashMap();
    this.zxd = new HashMap();
    this.zxe = new HashMap();
    this.zxf = 0;
    this.zxg = 0;
    this.zxh = new HashMap();
    this.zxi = new HashSet();
    com.tencent.mm.memory.a.b.a(com.tencent.mm.memory.n.class, new b.a() {});
    int i = ((ActivityManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("activity")).getLargeMemoryClass();
    ae.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.zwO = new com.tencent.mm.memory.a.b(i, new f.b() {}, getClass());
      this.zwP = new an(this.zwW, new an.a()
      {
        public final boolean dH(Object paramAnonymousObject)
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
              paramAnonymousObject = ((an.b)((an)localObject).zCl.get(str)).obj;
              if (!(paramAnonymousObject instanceof Bitmap)) {
                continue;
              }
              paramAnonymousObject = (Bitmap)paramAnonymousObject;
              if ((paramAnonymousObject != null) && (!paramAnonymousObject.isRecycled()))
              {
                ae.d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
                paramAnonymousObject.recycle();
              }
            }
            catch (Exception paramAnonymousObject)
            {
              int i;
              ae.printErrStackTrace("MicroMsg.SnsLRUMap", paramAnonymousObject, "", new Object[0]);
              ae.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
              continue;
              boolean bool = false;
              continue;
            }
            i = ((an)localObject).zCl.size();
            paramAnonymousObject = ((an)localObject).zCl.remove(str);
            localObject = new StringBuilder("internalMap ").append(((an)localObject).zCl.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              ae.d("MicroMsg.SnsLRUMap", bool);
              ae.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(g.this).zCl.size() + " listPaitSize:" + g.b(g.this).size());
              AppMethodBeat.o(95463);
              return true;
              paramAnonymousObject = (WeakReference)((an.b)((an)localObject).zCl.get(str)).obj;
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
  
  public static String C(bzh parambzh)
  {
    AppMethodBeat.i(95541);
    if (parambzh == null)
    {
      AppMethodBeat.o(95541);
      return null;
    }
    if (parambzh.Id.startsWith("pre_temp_sns_pic")) {
      parambzh = ah.getAccSnsTmpPath() + parambzh.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(95541);
      return parambzh;
      if (parambzh.Id.startsWith("Locall_path")) {
        parambzh = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.l(parambzh);
      } else if (parambzh.Id.startsWith("pre_temp_extend_pic")) {
        parambzh = parambzh.Id.substring(19);
      } else {
        parambzh = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.c(parambzh);
      }
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, bk parambk)
  {
    AppMethodBeat.i(95538);
    if ((!paramBoolean) && (bu.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    bzh localbzh = com.tencent.mm.modelsns.h.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    com.tencent.mm.plugin.sns.data.r.bZ(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = com.tencent.mm.plugin.sns.data.r.azs(paramString1);
      if (com.tencent.mm.plugin.sns.data.r.J(paramString1))
      {
        AppMethodBeat.o(95538);
        return paramString1;
      }
      AppMethodBeat.o(95538);
      return null;
    }
    if (com.tencent.mm.plugin.sns.data.r.J(null))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.sns.data.r.k(localbzh);
    localObject = com.tencent.mm.plugin.sns.data.r.azs(ap.jv(ah.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!com.tencent.mm.plugin.sns.data.r.J((Bitmap)localObject)) {
      paramString3 = com.tencent.mm.plugin.sns.data.r.azs(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!bu.isNullOrNil(paramString2))) {
      ah.dXz().a(localbzh, 3, null, parambk);
    }
    if (!com.tencent.mm.plugin.sns.data.r.J(paramString3))
    {
      AppMethodBeat.o(95538);
      return null;
    }
    AppMethodBeat.o(95538);
    return paramString3;
  }
  
  private String a(p paramp, final bzh parambzh, final bk parambk, boolean paramBoolean)
  {
    AppMethodBeat.i(95531);
    if (u(parambzh))
    {
      AppMethodBeat.o(95531);
      return "";
    }
    String str1 = ap.jv(ah.getAccSnsPath(), parambzh.Id);
    String str2 = com.tencent.mm.plugin.sns.data.r.i(parambzh);
    if (com.tencent.mm.vfs.o.fB(str1 + str2))
    {
      paramp = str1 + str2;
      AppMethodBeat.o(95531);
      return paramp;
    }
    if ((com.tencent.mm.vfs.o.fB(str1 + com.tencent.mm.plugin.sns.data.r.o(parambzh))) && (parambzh.Id != null) && (parambzh.Id.startsWith("Locall_path")))
    {
      paramp = str1 + com.tencent.mm.plugin.sns.data.r.o(parambzh);
      AppMethodBeat.o(95531);
      return paramp;
    }
    if (!this.zwA)
    {
      AppMethodBeat.o(95531);
      return "";
    }
    ae.i("MicroMsg.LazyerImageLoader2", "push sight loader " + parambzh.Id + " url: " + parambzh.Url);
    if (paramBoolean) {
      if (b(paramp, null) == 5) {
        ah.cXK().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95470);
            ah.dXz().a(parambzh, 4, null, parambk);
            AppMethodBeat.o(95470);
          }
        }, 0L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95531);
      return "";
      ae.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
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
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, g.a.zxG);
    AppMethodBeat.o(95510);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95512);
    a(paramObject, paramString, false, -1, paramInt1, paramInt2, paramInt3, g.a.zxG);
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
      ae.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.ayZ() });
    }
    Object localObject;
    long l1;
    if ((paramObject instanceof QFadeImageView))
    {
      paramObject = (QFadeImageView)paramObject;
      localObject = paramObject.getDrawable();
      l1 = l2;
      if (!bu.isNullOrNil(paramObject.getImageKey()))
      {
        l1 = l2;
        if (paramObject.getImageKey().equals(paramString)) {
          l1 = paramObject.getStartTimeMillis();
        }
      }
      if ((localObject == null) || (!(localObject instanceof ak))) {
        break label468;
      }
      l1 = ((ak)localObject).zCd;
    }
    label454:
    label468:
    for (;;)
    {
      paramn = new ak(paramString, paramn, l1);
      paramObject.P(paramn.zCd, paramString);
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
        if ((paramObject != null) && ((paramObject instanceof ak))) {}
        for (paramObject = new ak(paramString, paramn, ((ak)paramObject).zCd);; paramObject = new ak(paramString, paramn, 0L))
        {
          ((ImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof com.tencent.mm.plugin.sight.decode.a.a))
      {
        ae.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(paramString)));
        if ((paramObject instanceof SightPlayImageView))
        {
          localObject = (SightPlayImageView)paramObject;
          paramObject = ((SightPlayImageView)localObject).getDrawable();
          if ((paramObject == null) || (!(paramObject instanceof ak))) {
            break label361;
          }
        }
        label361:
        for (paramObject = new ak(paramString, paramn, ((ak)paramObject).zCd);; paramObject = new ak(paramString, paramn, 0L))
        {
          ((SightPlayImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(95498);
          return;
        }
      }
      if ((paramObject instanceof SnsAdTimelineVideoView))
      {
        ae.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setImageDrawable, key=".concat(String.valueOf(paramString)));
        localObject = (SnsAdTimelineVideoView)paramObject;
        paramObject = ((SnsAdTimelineVideoView)localObject).getThumbDrawable();
        if ((paramObject == null) || (!(paramObject instanceof ak))) {
          break label454;
        }
      }
      for (paramObject = new ak(paramString, paramn, ((ak)paramObject).zCd);; paramObject = new ak(paramString, paramn, 0L))
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
    this.zwU.remove(new c(null, i, 0, false));
    c localc = new c(paramString, i, paramInt2, paramBoolean);
    this.zwU.add(localc);
    LinkedList localLinkedList = (LinkedList)this.zwQ.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.zwQ.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.zwQ.get(localObject);
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
        ae.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[] { localObject });
        localLinkedList.remove(paramInt2);
      }
      ((View)paramObject).setTag(2130706432, paramString);
      localObject = new WeakReference(paramObject);
      this.idb.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label348;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == g.a.zxH) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
        {
          com.tencent.mm.sdk.platformtools.r.fnY();
          AppMethodBeat.o(95513);
          return;
          label339:
          paramInt2 += 1;
          break;
          label348:
          if ((paramObject instanceof ImageView))
          {
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.cb.a.l(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.a.a)paramObject;
            if (!this.zwA) {}
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
        com.tencent.mm.sdk.platformtools.r.z((View)paramObject, paramInt3, paramInt4);
        ae.d("MicroMsg.LazyerImageLoader2", "try to setLayerType " + paramInt3 + " " + paramInt4);
      }
      AppMethodBeat.o(95513);
      return;
      label490:
      paramInt2 = -1;
    }
  }
  
  private boolean a(final int paramInt, final bzh parambzh, final bk parambk)
  {
    AppMethodBeat.i(95517);
    if (!this.zwA)
    {
      if ((parambzh != null) && (!bu.isNullOrNil(parambzh.Id))) {
        ah.dXz().azW(parambzh.Id);
      }
      AppMethodBeat.o(95517);
      return false;
    }
    ah.dXr().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95469);
        com.tencent.mm.plugin.sns.data.n localn;
        c localc;
        bzh localbzh;
        if (!g.a(g.this, paramInt, parambzh))
        {
          localn = new com.tencent.mm.plugin.sns.data.n(parambzh);
          localn.zui = paramInt;
          localn.dyb = parambzh.Id;
          localc = ah.dXz();
          localbzh = parambzh;
          if (parambzh.nJA != 6) {
            break label97;
          }
        }
        label97:
        for (int i = 5;; i = 1)
        {
          localc.a(localbzh, i, localn, parambk);
          AppMethodBeat.o(95469);
          return;
        }
      }
    });
    AppMethodBeat.o(95517);
    return true;
  }
  
  public static boolean a(bzh parambzh, bk parambk, boolean paramBoolean)
  {
    AppMethodBeat.i(95540);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95540);
      return false;
    }
    Object localObject;
    if (parambzh.Id.startsWith("Locall_path"))
    {
      localObject = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.l(parambzh);
      if (com.tencent.mm.vfs.o.fB((String)localObject)) {
        break label161;
      }
      localObject = ah.dXz();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 2)
    {
      ((c)localObject).a(parambzh, i, null, parambk);
      AppMethodBeat.o(95540);
      return false;
      localObject = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.c(parambzh);
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
      this.zwO.put(paramString, paramn);
    }
    AppMethodBeat.o(95534);
    return true;
  }
  
  private boolean a(final List<bzh> paramList, final bk parambk)
  {
    AppMethodBeat.i(95515);
    ah.dXr().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95466);
        long l = bu.HQ();
        Object localObject = new com.tencent.mm.plugin.sns.data.n(paramList);
        ((com.tencent.mm.plugin.sns.data.n)localObject).dyb = com.tencent.mm.plugin.sns.data.r.fQ(paramList);
        ((com.tencent.mm.plugin.sns.data.n)localObject).zui = this.zxl;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          bzh localbzh = (bzh)paramList.get(j);
          if (ah.dXz().azR(localbzh.Id)) {
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
              } while (com.tencent.mm.vfs.o.fB(ap.jv(ah.getAccSnsPath(), localbzh.Id) + com.tencent.mm.plugin.sns.data.r.d(localbzh)));
              i = k;
            } while (com.tencent.mm.vfs.o.fB(ap.jv(ah.getAccSnsPath(), localbzh.Id) + com.tencent.mm.plugin.sns.data.r.k(localbzh)));
            i = k;
          } while (com.tencent.mm.vfs.o.fB(ap.jv(ah.getAccSnsPath(), localbzh.Id) + com.tencent.mm.plugin.sns.data.r.l(localbzh)));
          c localc = ah.dXz();
          if (localbzh.nJA == 6) {}
          for (int i = 5;; i = 1)
          {
            localc.a(localbzh, i, (com.tencent.mm.plugin.sns.data.n)localObject, parambk);
            i = 0;
            break;
          }
        }
        l = bu.aO(l);
        if (l > 100L) {
          ae.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.asd() + " " + ah.dXV() + " " + ((com.tencent.mm.plugin.sns.data.n)localObject).dyb);
        }
        if (bu.aO(g.c(g.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), ah.dXV(), com.tencent.mm.loader.j.b.asd() });
          g.a(g.this, bu.HQ());
        }
        localObject = com.tencent.mm.plugin.sns.data.r.fQ(paramList);
        if (k != 0) {
          ah.cXK().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95465);
              new i(com.tencent.mm.plugin.sns.data.r.bZ(0, this.LO), this.LO, g.9.this.zxC).x(new String[] { "" });
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
  
  private com.tencent.mm.memory.n aAa(String paramString)
  {
    AppMethodBeat.i(95493);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.zwO.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.zwO.remove(paramString);
      AppMethodBeat.o(95493);
      return null;
    }
    AppMethodBeat.o(95493);
    return localn;
  }
  
  private boolean aAb(String paramString)
  {
    AppMethodBeat.i(179083);
    if ((this.zwV.containsKey(paramString)) && (4 == ((Integer)this.zwV.get(paramString)).intValue())) {
      this.zwV.remove(paramString);
    }
    AppMethodBeat.o(179083);
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
  
  private com.tencent.mm.memory.n azZ(String paramString)
  {
    AppMethodBeat.i(95492);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.zwO.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.zwO.remove(paramString);
      AppMethodBeat.o(95492);
      return null;
    }
    AppMethodBeat.o(95492);
    return localn;
  }
  
  private void b(bzh parambzh, View paramView, int paramInt, g.a parama, bk parambk)
  {
    AppMethodBeat.i(95497);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95497);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.r.bZ(5, parambzh.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = azZ(str);
    if (!com.tencent.mm.plugin.sns.data.r.b(parama))
    {
      eS(paramView);
      if (this.zxi.contains(str))
      {
        AppMethodBeat.o(95497);
        return;
      }
      a(5, parambzh, parambk);
      AppMethodBeat.o(95497);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95497);
  }
  
  private boolean dWV()
  {
    AppMethodBeat.i(95516);
    if (this.zwT)
    {
      ae.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(95516);
      return false;
    }
    ah.cXK().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95467);
        if (g.d(g.this))
        {
          ae.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
          AppMethodBeat.o(95467);
          return;
        }
        if (g.e(g.this).size() > 0)
        {
          ae.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.e(g.this).size());
          ((g.b)g.e(g.this).removeLast()).x(new String[] { "" });
        }
        AppMethodBeat.o(95467);
      }
    }, 0L);
    AppMethodBeat.o(95516);
    return true;
  }
  
  private static void eS(View paramView)
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
  
  private static boolean fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(95523);
    paramString = bx.M(paramString, "SightDownloadControl");
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(95523);
      return true;
    }
    if (paramInt == 1)
    {
      if (bu.getInt((String)paramString.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1)
      {
        AppMethodBeat.o(95523);
        return true;
      }
      AppMethodBeat.o(95523);
      return false;
    }
    if (bu.getInt((String)paramString.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1)
    {
      AppMethodBeat.o(95523);
      return true;
    }
    AppMethodBeat.o(95523);
    return false;
  }
  
  public static String q(bzh parambzh)
  {
    AppMethodBeat.i(95489);
    String str = ap.jv(ah.getAccSnsPath(), parambzh.Id);
    parambzh = com.tencent.mm.plugin.sns.data.r.d(parambzh);
    parambzh = str + parambzh;
    AppMethodBeat.o(95489);
    return parambzh;
  }
  
  public static String r(bzh parambzh)
  {
    AppMethodBeat.i(95499);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95499);
      return null;
    }
    String str = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.d(parambzh);
    if (!com.tencent.mm.vfs.o.fB(str))
    {
      parambzh = parambzh.Hmj;
      AppMethodBeat.o(95499);
      return parambzh;
    }
    AppMethodBeat.o(95499);
    return str;
  }
  
  public static String s(bzh parambzh)
  {
    AppMethodBeat.i(95500);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95500);
      return null;
    }
    String str = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.c(parambzh);
    if (!com.tencent.mm.vfs.o.fB(str))
    {
      parambzh = parambzh.Url;
      AppMethodBeat.o(95500);
      return parambzh;
    }
    AppMethodBeat.o(95500);
    return str;
  }
  
  private void setError(String paramString)
  {
    AppMethodBeat.i(179084);
    this.zwV.put(paramString, Integer.valueOf(4));
    AppMethodBeat.o(179084);
  }
  
  public static boolean t(bzh parambzh)
  {
    AppMethodBeat.i(95518);
    String str1 = ap.jv(ah.getAccSnsPath(), parambzh.Id);
    String str2 = com.tencent.mm.plugin.sns.data.r.i(parambzh);
    if (com.tencent.mm.vfs.o.fB(str1 + str2))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    if ((com.tencent.mm.vfs.o.fB(str1 + com.tencent.mm.plugin.sns.data.r.o(parambzh))) && (!bu.isNullOrNil(parambzh.Id)) && (parambzh.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(95518);
      return true;
    }
    AppMethodBeat.o(95518);
    return false;
  }
  
  public final void A(bzh parambzh)
  {
    AppMethodBeat.i(95530);
    this.zwV.put(parambzh.Id, Integer.valueOf(3));
    AppMethodBeat.o(95530);
  }
  
  public final boolean B(bzh parambzh)
  {
    AppMethodBeat.i(95539);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95539);
      return false;
    }
    if (com.tencent.mm.vfs.o.fB(ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.e(parambzh)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    if (com.tencent.mm.vfs.o.fB(ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.d(parambzh)))
    {
      AppMethodBeat.o(95539);
      return true;
    }
    parambzh = com.tencent.mm.plugin.sns.data.r.bZ(1, parambzh.Id);
    boolean bool = com.tencent.mm.plugin.sns.data.r.b((com.tencent.mm.memory.n)this.zwO.get(parambzh));
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
    if ((paramArrayOfInt != null) || (bu.aO(this.zwY) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      com.tencent.mm.modelcontrol.c.aHe();
      if (!com.tencent.mm.modelcontrol.c.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.zxa = 5;
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
      this.zxb = ((PInt)localObject).value;
      this.zwY = bu.HQ();
      if ((this.zxb != 0) && (paramp != null)) {
        break label163;
      }
      i = this.zxa;
      AppMethodBeat.o(95520);
      return i;
      this.zxa = 10;
      break;
    }
    label163:
    if (this.zxc.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.zxc.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = new dhb();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.zxa;
        AppMethodBeat.o(95520);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.HOe == null) || (paramArrayOfInt.HOe.info == null))
      {
        i = this.zxa;
        AppMethodBeat.o(95520);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ae.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.zxa;
      AppMethodBeat.o(95520);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.HOe.info;
    i = paramArrayOfInt.hashCode();
    if (this.zxb == 1)
    {
      if (!this.zxe.containsKey(Integer.valueOf(i))) {
        this.zxe.put(Integer.valueOf(i), Boolean.valueOf(fa(paramArrayOfInt, this.zxb)));
      }
      if (((Boolean)this.zxe.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ae.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.zxc.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95520);
        return i;
      }
    }
    if (!this.zxd.containsKey(Integer.valueOf(i))) {
      this.zxd.put(Integer.valueOf(i), Boolean.valueOf(fa(paramArrayOfInt, this.zxb)));
    }
    if (((Boolean)this.zxd.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(bzh parambzh)
  {
    AppMethodBeat.i(95488);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95488);
      return null;
    }
    String str1 = com.tencent.mm.plugin.sns.data.r.bZ(1, parambzh.Id);
    Object localObject = azZ(str1);
    if (com.tencent.mm.plugin.sns.data.r.b((com.tencent.mm.memory.n)localObject))
    {
      parambzh = ((com.tencent.mm.memory.n)localObject).ayU();
      AppMethodBeat.o(95488);
      return parambzh;
    }
    localObject = ap.jv(ah.getAccSnsPath(), parambzh.Id);
    String str2 = com.tencent.mm.plugin.sns.data.r.d(parambzh);
    localObject = (String)localObject + str2;
    if (com.tencent.mm.vfs.o.fB((String)localObject))
    {
      if (parambzh.Id.startsWith("pre_temp_extend_pic")) {}
      for (parambzh = com.tencent.mm.memory.n.E(u.aBL((String)localObject)); com.tencent.mm.plugin.sns.data.r.b(parambzh); parambzh = com.tencent.mm.plugin.sns.data.r.azt((String)localObject))
      {
        a(str1, parambzh);
        parambzh = parambzh.ayU();
        AppMethodBeat.o(95488);
        return parambzh;
      }
      AppMethodBeat.o(95488);
      return null;
    }
    AppMethodBeat.o(95488);
    return null;
  }
  
  public final com.tencent.mm.memory.n a(bzh parambzh, ImageView paramImageView, int paramInt, bk parambk)
  {
    AppMethodBeat.i(95543);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95543);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.r.bZ(0, parambzh.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = azZ(str);
    if (!com.tencent.mm.plugin.sns.data.r.b(paramImageView))
    {
      a(0, parambzh, parambk);
      AppMethodBeat.o(95543);
      return null;
    }
    AppMethodBeat.o(95543);
    return paramImageView;
  }
  
  public final void a(bzh parambzh, View paramView, int paramInt1, int paramInt2, g.a parama, bk parambk)
  {
    AppMethodBeat.i(95496);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95496);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = com.tencent.mm.plugin.sns.data.r.bZ(0, parambzh.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = azZ(str);
    if (!com.tencent.mm.plugin.sns.data.r.b(parama))
    {
      ae.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        eS(paramView);
      }
      if (this.zxi.contains(str))
      {
        AppMethodBeat.o(95496);
        return;
      }
      a(0, parambzh, parambk);
      AppMethodBeat.o(95496);
      return;
    }
    ae.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    ah.dXz().azW(parambzh.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(95496);
  }
  
  public final void a(bzh parambzh, View paramView, int paramInt1, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(95494);
    a(parambzh, paramView, paramInt1, paramInt2, g.a.zxG, parambk);
    AppMethodBeat.o(95494);
  }
  
  public final void a(bzh parambzh, View paramView, int paramInt, g.a parama, bk parambk)
  {
    AppMethodBeat.i(95491);
    a(parambzh, paramView, -1, paramInt, parama, parambk);
    AppMethodBeat.o(95491);
  }
  
  public final void a(bzh parambzh, View paramView, int paramInt, bk parambk)
  {
    AppMethodBeat.i(95501);
    b(parambzh, paramView, -1, paramInt, parambk);
    AppMethodBeat.o(95501);
  }
  
  public final void a(final bzh parambzh, final View paramView, final int paramInt, final boolean paramBoolean1, final bk parambk, final boolean paramBoolean2, final e parame)
  {
    AppMethodBeat.i(95542);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95542);
      return;
    }
    final String str1 = com.tencent.mm.plugin.sns.data.r.bZ(3, parambzh.Id);
    final String str2 = C(parambzh);
    if (ah.dXz().azS(parambzh.Id))
    {
      ae.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + parambzh.Id);
      a(paramView, str1, paramInt, -1, -1);
      parame.am(null);
      AppMethodBeat.o(95542);
      return;
    }
    Object localObject1 = this.zwP;
    Object localObject2 = (an.b)((an)localObject1).zCl.get(str1);
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
      ae.i("MicroMsg.LazyerImageLoader2", bool);
      if (localObject1 != null) {
        break label292;
      }
    }
    label286:
    label292:
    for (localObject1 = null;; localObject1 = (Bitmap)((WeakReference)localObject1).get())
    {
      if (!com.tencent.mm.plugin.sns.data.r.J((Bitmap)localObject1)) {
        break label305;
      }
      ae.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
      a(paramView, str1, paramInt, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      parame.am((Bitmap)localObject1);
      AppMethodBeat.o(95542);
      return;
      ((an.b)((an)localObject1).zCl.get(str1)).dYg();
      localObject1 = ((an.b)localObject2).obj;
      break;
      bool = false;
      break label185;
    }
    label305:
    ah.dXp().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95459);
        final Bitmap localBitmap = com.tencent.mm.plugin.sns.data.r.azs(str2);
        ah.cXK().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95458);
            if (com.tencent.mm.plugin.sns.data.r.J(localBitmap))
            {
              g.a(g.this, g.4.this.zvR, g.4.this.zxo, g.4.this.zxp, localBitmap.getWidth(), localBitmap.getHeight());
              if (!com.tencent.mm.plugin.sns.data.r.J(localBitmap)) {
                break label252;
              }
              localObject1 = g.a(g.this);
              localObject2 = g.4.this.zxo;
              localObject3 = new WeakReference(localBitmap);
              if ((an.b)((an)localObject1).zCl.get(localObject2) != null) {
                break label215;
              }
              localObject3 = new an.b((an)localObject1, localObject3);
              ((an)localObject1).zCl.put(localObject2, localObject3);
              ((an)localObject1).dYf();
            }
            label215:
            label252:
            while (!g.4.this.zxq) {
              for (;;)
              {
                Object localObject3;
                if (g.4.this.zxt != null) {
                  g.4.this.zxt.am(localBitmap);
                }
                AppMethodBeat.o(95458);
                return;
                g.a(g.this, g.4.this.zvR, g.4.this.zxo, g.4.this.zxp, -1, -1);
                break;
                ((an.b)((an)localObject1).zCl.get(localObject2)).dYg();
                ((an.b)((an)localObject1).zCl.get(localObject2)).obj = localObject3;
              }
            }
            Object localObject1 = ah.dXz();
            Object localObject2 = g.4.this.zrQ;
            if (g.4.this.zxr) {}
            for (int i = 8;; i = 2)
            {
              ((c)localObject1).a((bzh)localObject2, i, null, g.4.this.zxs);
              break;
            }
          }
        });
        AppMethodBeat.o(95459);
      }
    });
    AppMethodBeat.o(95542);
  }
  
  public final void a(final String paramString, SparseArray<bzh> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, final bk parambk, final int paramInt2)
  {
    AppMethodBeat.i(95495);
    ae.i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
    if ((paramSparseArray == null) || (paramSparseArray.size() <= 0))
    {
      ae.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    if ((paramSparseArray1 == null) || (paramSparseArray1.size() <= 0))
    {
      ae.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
      AppMethodBeat.o(95495);
      return;
    }
    int j = paramSparseArray.size();
    int k = paramSparseArray1.size();
    if (j == k) {}
    for (int i = j; -1 == i; i = -1)
    {
      ae.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
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
      bzh localbzh = (bzh)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = com.tencent.mm.plugin.sns.data.r.bZ(0, localbzh.Id);
      a(localView, str, -1, paramInt1, g.a.zxG);
      com.tencent.mm.memory.n localn = azZ(str);
      if (!com.tencent.mm.plugin.sns.data.r.b(localn))
      {
        ae.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        eS(localView);
        if (!this.zxi.contains(str)) {
          localSparseArray1.put(k, localbzh);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ae.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
        a(localView, str, localn);
      }
    }
    if (localSparseArray1.size() != 0)
    {
      ae.i("MicroMsg.LazyerImageLoader2", "ok, let's download.");
      ah.dXr().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95464);
          int j = localSparseArray1.size();
          int i = 0;
          while (i < j)
          {
            int k = localSparseArray1.keyAt(i);
            bzh localbzh = (bzh)localSparseArray1.get(k);
            if (!g.a(g.this, 0, localbzh))
            {
              com.tencent.mm.plugin.sns.data.n localn = new com.tencent.mm.plugin.sns.data.n(localbzh);
              localn.zui = 0;
              localn.dyb = localbzh.Id;
              localSparseArray2.put(k, localn);
              localSparseArray3.put(k, localbzh);
            }
            i += 1;
          }
          if (localSparseArray3.size() > 0) {
            ah.dXz().a(paramString, localSparseArray3, localSparseArray2, parambk, paramInt2);
          }
          AppMethodBeat.o(95464);
        }
      });
    }
    AppMethodBeat.o(95495);
  }
  
  public final void a(List<bzh> paramList, View paramView, int paramInt, g.a parama, bk parambk)
  {
    AppMethodBeat.i(95545);
    a(paramList, paramView, paramInt, parama, parambk, false);
    AppMethodBeat.o(95545);
  }
  
  public final void a(List<bzh> paramList, View paramView, int paramInt, g.a parama, bk parambk, boolean paramBoolean)
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
        b((bzh)paramList.get(0), paramView, paramInt, parambk);
        AppMethodBeat.o(95546);
        return;
      }
      b((bzh)paramList.get(0), paramView, paramInt, g.a.zxH, parambk);
      AppMethodBeat.o(95546);
      return;
    }
    String str = com.tencent.mm.plugin.sns.data.r.bZ(0, com.tencent.mm.plugin.sns.data.r.fQ(paramList));
    a(paramView, str, paramInt, parama);
    parama = azZ(str);
    paramBoolean = com.tencent.mm.plugin.sns.data.r.b(parama);
    ae.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      eS(paramView);
      if (this.zxi.contains(str))
      {
        AppMethodBeat.o(95546);
        return;
      }
      new WeakReference(paramView);
      a(paramList, parambk);
      AppMethodBeat.o(95546);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(95546);
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.data.n paramn, String paramString)
  {
    AppMethodBeat.i(95535);
    Object localObject1 = (bzh)paramn.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < paramn.list.size())
    {
      localObject2 = (bzh)paramn.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((bzh)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id);
      if (paramn.zui == 0) {
        paramString = com.tencent.mm.plugin.sns.data.r.e((bzh)localObject1);
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.sns.data.r.bZ(paramn.zui, ((bzh)localObject1).Id);
        if (!this.zwO.aM(str)) {
          new b(com.tencent.mm.plugin.sns.data.r.bZ(paramn.zui, ((bzh)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (bzh)localObject1, paramn.zui).x(new String[] { "" });
        }
        AppMethodBeat.o(95535);
        return true;
        i += 1;
        break;
        if (paramn.zui == 4) {
          paramString = com.tencent.mm.plugin.sns.data.r.f((bzh)localObject1);
        } else if (paramn.zui == 5) {
          paramString = com.tencent.mm.plugin.sns.data.r.f((bzh)localObject1);
        } else if (paramn.zui == 3) {
          paramString = com.tencent.mm.plugin.sns.data.r.k((bzh)localObject1);
        } else {
          paramString = com.tencent.mm.plugin.sns.data.r.d((bzh)localObject1);
        }
      }
    }
  }
  
  public final boolean a(p paramp, bzh parambzh, SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt, bk parambk, boolean paramBoolean)
  {
    AppMethodBeat.i(179081);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(179081);
      return false;
    }
    String str1 = com.tencent.mm.plugin.sns.data.r.bZ(1, parambzh.Id);
    a(paramSnsAdTimelineVideoView, str1, -1, paramInt);
    String str2 = ap.jv(ah.getAccSnsPath(), parambzh.Id);
    String str3 = com.tencent.mm.plugin.sns.data.r.d(parambzh);
    Object localObject;
    c localc;
    if (!com.tencent.mm.vfs.o.fB(str2 + str3))
    {
      localObject = new com.tencent.mm.plugin.sns.data.n(parambzh);
      ((com.tencent.mm.plugin.sns.data.n)localObject).zui = 1;
      ((com.tencent.mm.plugin.sns.data.n)localObject).dyb = parambzh.Id;
      localc = ah.dXz();
      if (parambzh.nJA != 6) {
        break label293;
      }
    }
    label293:
    for (paramInt = 5;; paramInt = 1)
    {
      localc.a(parambzh, paramInt, (com.tencent.mm.plugin.sns.data.n)localObject, parambk);
      localObject = "";
      if (paramBoolean) {
        localObject = a(paramp, parambzh, parambk, paramBoolean);
      }
      ae.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean) });
      if ((bu.isNullOrNil((String)localObject)) || (u(parambzh))) {
        break;
      }
      if (!((String)localObject).equals(paramSnsAdTimelineVideoView.getVideoPath()))
      {
        paramSnsAdTimelineVideoView.setThumbBmp(com.tencent.mm.sdk.platformtools.h.decodeFile(str2 + str3));
        ae.i("MicroMsg.SnsAdTimelineVideoView", "showVideoThumb:true");
        paramSnsAdTimelineVideoView.c(false, 0.0F);
      }
      paramSnsAdTimelineVideoView.setVideoPath((String)localObject);
      AppMethodBeat.o(179081);
      return true;
    }
    ae.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, sightPath %s", new Object[] { localObject });
    paramSnsAdTimelineVideoView.setVideoPath(null);
    paramSnsAdTimelineVideoView.clear();
    paramp = azZ(str1);
    paramBoolean = com.tencent.mm.plugin.sns.data.r.b(paramp);
    ae.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      paramSnsAdTimelineVideoView.setThumbBmp(null);
      if (this.zxi.contains(str1))
      {
        AppMethodBeat.o(179081);
        return false;
      }
      a(1, parambzh, parambk);
      AppMethodBeat.o(179081);
      return false;
    }
    a(paramSnsAdTimelineVideoView, str1, paramp);
    AppMethodBeat.o(179081);
    return true;
  }
  
  public final boolean a(p paramp, bzh parambzh, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bk parambk, boolean paramBoolean)
  {
    AppMethodBeat.i(176251);
    paramBoolean = a(paramp, parambzh, paramVideoSightView, paramInt1, paramInt2, parambk, paramBoolean, false);
    AppMethodBeat.o(176251);
    return paramBoolean;
  }
  
  public final boolean a(p paramp, bzh parambzh, VideoSightView paramVideoSightView, int paramInt1, int paramInt2, bk parambk, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176252);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(176252);
      return false;
    }
    String str1 = com.tencent.mm.plugin.sns.data.r.bZ(1, parambzh.Id);
    a(paramVideoSightView, str1, -1, paramInt1);
    String str2 = ap.jv(ah.getAccSnsPath(), parambzh.Id);
    String str3 = com.tencent.mm.plugin.sns.data.r.d(parambzh);
    Object localObject;
    if (!com.tencent.mm.vfs.o.fB(str2 + str3))
    {
      localObject = new com.tencent.mm.plugin.sns.data.n(parambzh);
      ((com.tencent.mm.plugin.sns.data.n)localObject).zui = 1;
      ((com.tencent.mm.plugin.sns.data.n)localObject).dyb = parambzh.Id;
      c localc = ah.dXz();
      if (parambzh.nJA == 6)
      {
        paramInt1 = 5;
        localc.a(parambzh, paramInt1, (com.tencent.mm.plugin.sns.data.n)localObject, parambk);
      }
    }
    else
    {
      localObject = "";
      if (paramBoolean1) {
        localObject = a(paramp, parambzh, parambk, paramBoolean1);
      }
      ae.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean1) });
      if ((bu.isNullOrNil((String)localObject)) || (u(parambzh))) {
        break label302;
      }
      if (!((String)localObject).equals(paramVideoSightView.getVideoPath())) {
        if (!paramBoolean2) {
          break label297;
        }
      }
    }
    label297:
    for (paramp = com.tencent.mm.sdk.platformtools.h.decodeFile(str2 + str3);; paramp = null)
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
    ae.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject });
    paramVideoSightView.setVideoPath(null);
    paramVideoSightView.clear();
    paramp = azZ(str1);
    paramBoolean1 = com.tencent.mm.plugin.sns.data.r.b(paramp);
    ae.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!paramBoolean1)
    {
      paramVideoSightView.setPosition(0);
      paramVideoSightView.setThumbBmp(null);
      if (this.zxi.contains(str1))
      {
        AppMethodBeat.o(176252);
        return false;
      }
      a(1, parambzh, parambk);
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
  
  public final boolean a(bzh parambzh, View paramView, int paramInt1, int paramInt2, bk parambk, int paramInt3)
  {
    AppMethodBeat.i(95507);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95507);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.r.bZ(paramInt3, parambzh.Id);
    a(paramView, str, paramInt1, paramInt2);
    com.tencent.mm.memory.n localn = azZ(str);
    boolean bool = com.tencent.mm.plugin.sns.data.r.b(localn);
    ae.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        eS(paramView);
      }
      if (this.zxi.contains(str))
      {
        AppMethodBeat.o(95507);
        return true;
      }
      a(paramInt3, parambzh, parambk);
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
  
  public final void aAc(String paramString)
  {
    AppMethodBeat.i(95536);
    b(paramString, null);
    AppMethodBeat.o(95536);
  }
  
  public final com.tencent.mm.memory.n aAd(String paramString)
  {
    AppMethodBeat.i(95537);
    if (this.zwO == null)
    {
      AppMethodBeat.o(95537);
      return null;
    }
    paramString = (com.tencent.mm.memory.n)this.zwO.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(95537);
    return paramString;
  }
  
  public final void aE(Activity paramActivity)
  {
    AppMethodBeat.i(95486);
    ae.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.idb.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.zwU.iterator();
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
      this.idb.remove(Integer.valueOf(i));
      localObject3 = this.zwU.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        c localc = (c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.zwU.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.zwU.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (((c)localObject3).zxK == paramActivity.hashCode()) {
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
      this.idb.remove(Integer.valueOf(i));
      localObject1 = this.zwU.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (((c)localObject2).code != i) {
          break;
        }
        this.zwU.remove(localObject2);
      }
    }
    label371:
    this.zwP.dYf();
    ae.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.idb.size());
    AppMethodBeat.o(95486);
  }
  
  public final int b(p paramp, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(95522);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (bu.aO(this.zwZ) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      com.tencent.mm.modelcontrol.c.aHe();
      if (!com.tencent.mm.modelcontrol.c.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.zxf = 5;
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
      this.zxg = ((PInt)localObject).value;
      this.zwZ = bu.HQ();
      if ((this.zxg != 0) && (paramp != null)) {
        break label144;
      }
      i = this.zxf;
      AppMethodBeat.o(95522);
      return i;
      this.zxf = 10;
      break;
    }
    label144:
    if (this.zxh.containsKey(Long.valueOf(paramp.field_snsId)))
    {
      i = ((Integer)this.zxh.get(Long.valueOf(paramp.field_snsId))).intValue();
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = new dhb();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramp.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.zxf;
        AppMethodBeat.o(95522);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.HOe == null) || (paramArrayOfInt.HOe.info == null))
      {
        i = this.zxa;
        AppMethodBeat.o(95522);
        return i;
      }
    }
    catch (Exception paramp)
    {
      ae.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramp, "", new Object[0]);
      i = this.zxf;
      AppMethodBeat.o(95522);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.HOe.info;
    i = paramArrayOfInt.hashCode();
    if (this.zxg == 1)
    {
      if (!this.zxe.containsKey(Integer.valueOf(i))) {
        this.zxe.put(Integer.valueOf(i), Boolean.valueOf(fa(paramArrayOfInt, this.zxg)));
      }
      if (((Boolean)this.zxe.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ae.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramp.field_snsId), Integer.valueOf(i) });
        this.zxh.put(Long.valueOf(paramp.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(95522);
        return i;
      }
    }
    if (!this.zxd.containsKey(Integer.valueOf(i))) {
      this.zxd.put(Integer.valueOf(i), Boolean.valueOf(fa(paramArrayOfInt, this.zxg)));
    }
    if (((Boolean)this.zxd.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final void b(bzh parambzh, View paramView, int paramInt, bk parambk)
  {
    AppMethodBeat.i(95490);
    a(parambzh, paramView, -1, paramInt, parambk);
    AppMethodBeat.o(95490);
  }
  
  protected final void b(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(95547);
    com.tencent.mm.memory.n localn = paramn;
    if (!com.tencent.mm.plugin.sns.data.r.b(paramn)) {
      localn = aAa(paramString);
    }
    if (com.tencent.mm.plugin.sns.data.r.b(localn))
    {
      if ((this.zwO != null) && (localn != null) && (paramString != null)) {
        this.zwO.put(paramString, localn);
      }
      paramn = (LinkedList)this.zwQ.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((c)localObject).zxL) && (paramString != null) && (paramString.equals(((c)localObject).id)))
          {
            int i = ((c)localObject).code;
            localObject = (WeakReference)this.idb.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.zwX != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.zwX.RB(i))) {
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
                    ae.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.plugin.sns.data.r.b(localn)) });
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
  
  public final boolean b(bzh parambzh, View paramView, int paramInt1, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(95506);
    boolean bool = a(parambzh, paramView, paramInt1, paramInt2, parambk, 1);
    AppMethodBeat.o(95506);
    return bool;
  }
  
  public final void c(bzh parambzh, View paramView, int paramInt, bk parambk)
  {
    AppMethodBeat.i(95505);
    if ((parambzh == null) || (parambzh.Id == null) || (parambzh.Id.equals("")))
    {
      AppMethodBeat.o(95505);
      return;
    }
    String str = com.tencent.mm.plugin.sns.data.r.bZ(4, parambzh.Id);
    a(paramView, str, -1, paramInt);
    com.tencent.mm.memory.n localn = azZ(str);
    boolean bool = com.tencent.mm.plugin.sns.data.r.b(localn);
    ae.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      eS(paramView);
      if (!this.zxi.contains(str))
      {
        a(4, parambzh, parambk);
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
    a(paramView, null, true, -1, paramInt3, -1, -1, g.a.zxG);
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
  
  public final void dVZ()
  {
    AppMethodBeat.i(95548);
    dWU();
    this.zwY = 0L;
    this.zwZ = 0L;
    this.zwS.clear();
    this.zwT = false;
    AppMethodBeat.o(95548);
  }
  
  public final void dWU()
  {
    AppMethodBeat.i(95484);
    if (this.zwO != null)
    {
      this.idb.clear();
      this.zwP.zCl.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.zwO.putCount() + ";");
      localStringBuffer.append("missCount:" + this.zwO.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.zwO.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.zwO.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.zwO.evictionCount() + ";");
      ae.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.zwO.trimToSize(-1);
    }
    this.zwP.dYf();
    System.gc();
    AppMethodBeat.o(95484);
  }
  
  public final void eQ(View paramView)
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
  
  public final boolean eT(View paramView)
  {
    AppMethodBeat.i(95514);
    int i = paramView.hashCode();
    paramView = this.zwU.iterator();
    while (paramView.hasNext())
    {
      c localc = (c)paramView.next();
      if (i == localc.code) {
        this.zwU.remove(localc);
      }
    }
    this.idb.remove(Integer.valueOf(i));
    AppMethodBeat.o(95514);
    return true;
  }
  
  public final boolean js(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95532);
    if ((this.zwV.containsKey(paramString1)) && (3 == ((Integer)this.zwV.get(paramString1)).intValue())) {
      this.zwV.remove(paramString1);
    }
    String str = com.tencent.mm.plugin.sns.data.r.bZ(1, paramString1);
    ae.i("MicroMsg.LazyerImageLoader2", "TimeLineAdPreloadHelper, download video complete, mediaId=" + paramString1 + ", path=" + paramString2);
    Object localObject1 = (LinkedList)this.zwQ.get(str);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95532);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((c)localObject2).zxL) && (str != null) && (str.equals(((c)localObject2).id)))
      {
        int i = ((c)localObject2).code;
        localObject2 = (WeakReference)this.idb.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.sns.ui.aq localaq;
            if ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a))
            {
              ae.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
              if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof com.tencent.mm.plugin.sns.ui.aq))
              {
                localaq = (com.tencent.mm.plugin.sns.ui.aq)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
                boolean bool;
                if (localaq != null)
                {
                  if (com.tencent.mm.vfs.o.fB(paramString2))
                  {
                    if (!this.zwA) {}
                    for (bool = true;; bool = false)
                    {
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).e(paramString2, bool, localaq.position);
                      ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localaq.position);
                      localaq.AnK.setVisibility(8);
                      localaq.zWJ.setVisibility(8);
                      localaq.zWK.setVisibility(8);
                      aAb(paramString1);
                      break;
                    }
                  }
                  setError(paramString1);
                  localaq.AnK.setVisibility(8);
                  localaq.zWJ.setImageResource(2131234034);
                  localaq.zWJ.setVisibility(0);
                }
                else
                {
                  if (!this.zwA) {}
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
              ae.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, download fin set sight %s %s", new Object[] { paramString1, paramString2 });
              localObject2 = (SnsAdTimelineVideoView)localObject2;
              if ((((SnsAdTimelineVideoView)localObject2).getTag() instanceof com.tencent.mm.plugin.sns.ui.aq))
              {
                localaq = (com.tencent.mm.plugin.sns.ui.aq)((SnsAdTimelineVideoView)localObject2).getTag();
                if (localaq != null)
                {
                  if (com.tencent.mm.vfs.o.fB(paramString2))
                  {
                    ((SnsAdTimelineVideoView)localObject2).setVideoPath(paramString2);
                    ((SnsAdTimelineVideoView)localObject2).setShouldPlayWhenPrepared(true);
                    localaq.AnK.setVisibility(8);
                    localaq.zWJ.setVisibility(8);
                    localaq.zWK.setVisibility(8);
                    aAb(paramString1);
                  }
                  else
                  {
                    setError(paramString1);
                    localaq.AnK.setVisibility(8);
                    localaq.zWJ.setImageResource(2131234034);
                    localaq.zWJ.setVisibility(0);
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
    this.zwA = false;
    c localc = ah.dXz();
    localc.zwA = false;
    Object localObject3;
    synchronized (localc.mLock)
    {
      localObject2 = new LinkedList();
      localObject3 = localc.fXm.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.sns.data.o localo = (com.tencent.mm.plugin.sns.data.o)((Iterator)localObject3).next();
        if (localo.requestType != 6)
        {
          localc.zwD.remove(localo.key);
          ((LinkedList)localObject2).add(localo);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.sns.data.o)((Iterator)localObject2).next();
      localObject1.fXm.remove(localObject3);
    }
    localObject1.zwE.clear();
    localObject1.zwF.clear();
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
    this.zwA = true;
    dWV();
    c localc = ah.dXz();
    localc.zwA = true;
    localc.aIq();
    AppMethodBeat.o(95481);
  }
  
  public final int t(p paramp)
  {
    AppMethodBeat.i(224104);
    int i = b(paramp, null);
    AppMethodBeat.o(224104);
    return i;
  }
  
  public final boolean u(bzh parambzh)
  {
    AppMethodBeat.i(95524);
    if (!this.zwV.containsKey(parambzh.Id))
    {
      AppMethodBeat.o(95524);
      return false;
    }
    if (((Integer)this.zwV.get(parambzh.Id)).intValue() == 1)
    {
      AppMethodBeat.o(95524);
      return true;
    }
    AppMethodBeat.o(95524);
    return false;
  }
  
  public final boolean v(bzh parambzh)
  {
    AppMethodBeat.i(95525);
    if (!this.zwV.containsKey(parambzh.Id))
    {
      AppMethodBeat.o(95525);
      return false;
    }
    if (((Integer)this.zwV.get(parambzh.Id)).intValue() == 2)
    {
      AppMethodBeat.o(95525);
      return true;
    }
    AppMethodBeat.o(95525);
    return false;
  }
  
  public final boolean w(bzh parambzh)
  {
    AppMethodBeat.i(95526);
    if (!this.zwV.containsKey(parambzh.Id))
    {
      AppMethodBeat.o(95526);
      return false;
    }
    if (((Integer)this.zwV.get(parambzh.Id)).intValue() == 3)
    {
      AppMethodBeat.o(95526);
      return true;
    }
    AppMethodBeat.o(95526);
    return false;
  }
  
  public final boolean x(bzh parambzh)
  {
    AppMethodBeat.i(95527);
    if (!this.zwV.containsKey(parambzh.Id))
    {
      AppMethodBeat.o(95527);
      return false;
    }
    if (((Integer)this.zwV.get(parambzh.Id)).intValue() == 4)
    {
      AppMethodBeat.o(95527);
      return true;
    }
    AppMethodBeat.o(95527);
    return false;
  }
  
  public final void y(bzh parambzh)
  {
    AppMethodBeat.i(95528);
    this.zwV.put(parambzh.Id, Integer.valueOf(1));
    AppMethodBeat.o(95528);
  }
  
  public final void z(bzh parambzh)
  {
    AppMethodBeat.i(95529);
    this.zwV.put(parambzh.Id, Integer.valueOf(2));
    AppMethodBeat.o(95529);
  }
  
  final class b
    extends h<String, Integer, Boolean>
  {
    private bzh dKe;
    private com.tencent.mm.memory.n hAB;
    private String iuz;
    String key;
    private String path;
    private int zxJ;
    
    public b(String paramString1, String paramString2, String paramString3, bzh parambzh, int paramInt)
    {
      AppMethodBeat.i(95474);
      this.key = "";
      this.hAB = null;
      this.zxJ = 0;
      g.this.zxi.add(paramString1);
      this.key = paramString1;
      this.path = paramString2;
      this.iuz = paramString3;
      this.dKe = parambzh;
      this.zxJ = paramInt;
      g.dvA();
      ae.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(g.bdD()) });
      AppMethodBeat.o(95474);
    }
    
    private void aA(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(95475);
      com.tencent.mm.vfs.o.fB(this.iuz + paramString3);
      if (!com.tencent.mm.vfs.o.fB(this.iuz + paramString1))
      {
        String str = paramString2;
        if (!com.tencent.mm.vfs.o.fB(this.iuz + paramString2)) {
          str = com.tencent.mm.plugin.sns.data.r.l(this.dKe);
        }
        boolean bool = u.a(this.iuz, str, paramString1, ah.dXQ());
        if (!bool)
        {
          ae.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
          com.tencent.mm.vfs.o.deleteFile(this.iuz + str);
        }
        ae.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.iuz + str, this.iuz + paramString1, Boolean.valueOf(bool) });
      }
      u.b(this.iuz, paramString1, paramString3, ah.dXP());
      AppMethodBeat.o(95475);
    }
    
    private Boolean dWX()
    {
      AppMethodBeat.i(95476);
      g.a(g.this, true);
      Object localObject;
      if (!g.h(g.this))
      {
        ae.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      if (g.f(g.this).aM(this.key))
      {
        ae.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
        localObject = Boolean.FALSE;
        AppMethodBeat.o(95476);
        return localObject;
      }
      com.tencent.mm.vfs.o.aZX(this.iuz);
      long l1 = System.currentTimeMillis();
      long l2;
      if (!com.tencent.mm.vfs.o.fB(this.path))
      {
        aA(com.tencent.mm.plugin.sns.data.r.d(this.dKe), com.tencent.mm.plugin.sns.data.r.k(this.dKe), com.tencent.mm.plugin.sns.data.r.e(this.dKe));
        l2 = bu.HQ();
        if (this.zxJ != 5) {
          break label769;
        }
        if (!com.tencent.mm.vfs.o.fB(this.path)) {
          aA(com.tencent.mm.plugin.sns.data.r.d(this.dKe), com.tencent.mm.plugin.sns.data.r.k(this.dKe), com.tencent.mm.plugin.sns.data.r.e(this.dKe));
        }
        bool1 = com.tencent.mm.vfs.o.fB(this.iuz + com.tencent.mm.plugin.sns.data.r.d(this.dKe));
        boolean bool2 = com.tencent.mm.vfs.o.fB(this.iuz + com.tencent.mm.plugin.sns.data.r.k(this.dKe));
        boolean bool3 = com.tencent.mm.vfs.o.fB(this.iuz + com.tencent.mm.plugin.sns.data.r.e(this.dKe));
        this.hAB = com.tencent.mm.plugin.sns.data.r.azr(this.path);
        if (this.hAB == null)
        {
          ae.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = com.tencent.mm.plugin.sns.data.r.e(this.dKe);
          this.hAB = com.tencent.mm.plugin.sns.lucky.a.a.jq(this.iuz + (String)localObject, this.path);
          boolean bool4 = com.tencent.mm.vfs.o.fB(this.path);
          ae.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
        }
        label427:
        long l3 = bu.aO(l2);
        int i = (int)com.tencent.mm.vfs.o.aZR(this.path);
        if (bu.aO(g.i(g.this)) > 60000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), ah.dXV(), com.tencent.mm.loader.j.b.asd() });
          g.b(g.this, bu.HQ());
        }
        if (this.hAB == null)
        {
          ae.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.dKe.Id });
          com.tencent.mm.vfs.o.deleteFile(this.iuz + com.tencent.mm.plugin.sns.data.r.e(this.dKe));
          com.tencent.mm.vfs.o.deleteFile(this.path);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(150L, 2L, 1L, true);
        }
        l3 = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(150L, 0L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(150L, 1L, l3 - l1, true);
        localObject = new StringBuilder("doInBackground decode %s and ");
        if (this.hAB != null) {
          break label872;
        }
      }
      label769:
      label872:
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.i("MicroMsg.ImageLoader", bool1 + " " + this.hAB + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
        localObject = Boolean.TRUE;
        AppMethodBeat.o(95476);
        return localObject;
        ae.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
        break;
        if (this.zxJ == 4)
        {
          this.hAB = com.tencent.mm.plugin.sns.data.r.azr(this.path);
          if (this.hAB != null) {
            break label427;
          }
          ae.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
          localObject = com.tencent.mm.plugin.sns.data.r.d(this.dKe);
          this.hAB = com.tencent.mm.plugin.sns.lucky.a.a.jq(this.iuz + (String)localObject, this.path);
          break label427;
        }
        this.hAB = com.tencent.mm.plugin.sns.data.r.azt(this.path);
        break label427;
      }
    }
    
    public final ExecutorService dFv()
    {
      AppMethodBeat.i(179079);
      ExecutorService localExecutorService = ah.dXp();
      AppMethodBeat.o(179079);
      return localExecutorService;
    }
  }
  
  static final class c
  {
    public int code;
    public String id;
    public int zxK;
    public boolean zxL;
    
    public c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.id = paramString;
      this.code = paramInt1;
      this.zxK = paramInt2;
      this.zxL = paramBoolean;
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
    public abstract void am(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g
 * JD-Core Version:    0.7.0.1
 */
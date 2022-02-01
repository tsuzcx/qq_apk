package com.tencent.mm.plugin.vlog.model.local;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.opengl.EGL14;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.res.f;
import com.tencent.mm.plugin.recordvideo.res.g;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.u;
import com.tencent.mm.xeffect.GlobalContextCreator;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.n;
import com.tencent.mm.xeffect.effect.n.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager;", "", "()V", "ImageEnhancementResultImageSavePath", "", "getImageEnhancementResultImageSavePath", "()Ljava/lang/String;", "ImageEnhancementResultPathMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getImageEnhancementResultPathMap", "()Ljava/util/HashMap;", "setImageEnhancementResultPathMap", "(Ljava/util/HashMap;)V", "ImageEnhancementSceneValues", "", "", "getImageEnhancementSceneValues", "()Ljava/util/List;", "TAG", "TEMPLATE_CONFIG", "TEMPLATE_PATH", "TransEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "getTransEffectList", "()Ljava/util/LinkedList;", "TransEffectTime", "", "VideoTemplateList", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "getVideoTemplateList", "value", "Landroid/util/Pair;", "VideoTrackLabel", "getVideoTrackLabel", "setVideoTrackLabel", "currentVideoTemplate", "getCurrentVideoTemplate", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "setCurrentVideoTemplate", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;)V", "globalContextCreated", "", "transitionReady", "transitionResMap", "", "transitionView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "getTransitionView", "()Ljava/lang/ref/WeakReference;", "setTransitionView", "(Ljava/lang/ref/WeakReference;)V", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getVLogEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "setVLogEffectMgr", "(Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "videoEnhancementEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "getVideoEnhancementEffectInfo", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "setVideoEnhancementEffectInfo", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;)V", "applyTransition", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trans", "applyTransitionToAll", "trackList", "order", "checkCreateTransEffect", "transEffectInfo", "checkRefreshView", "generateTemplateEffectTrack", "template", "sourceTrackList", "getImageEnhancementBitmap", "Landroid/graphics/Bitmap;", "path", "getLabel", "getLocalPath", "assetsPath", "init", "instance", "initTransEffect", "initTransResource", "initVideoEnhancementEffect", "initVideoTemplates", "isSvrVideoEnhancementEnable", "isVideoEnhancementEnable", "removeVideoTemplate", "videoTemplate", "reset", "saveAllImageEnhancementResultImage", "pathList", "setTransition", "setVideoCompositionEnhancement", "videoComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "enable", "setVideoEnhancement", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVideoEnhancementScene", "scene", "setVideoEnhancementSceneFilterSettingsByJson", "json", "setVideoEnhancementShowFaceLandmarks", "show", "setVideoTemplate", "targets", "", "tryCreateX3DGlobalContext", "tryCreateX3DGlobalContextImpl", "unInit", "TransEffectInfo", "VideoEnhancementEffectInfo", "VideoTemplateInfo", "plugin-vlog_release"})
public final class a
{
  private static final String NnY;
  private static final Map<String, Integer> NnZ;
  private static final LinkedList<a> Noa;
  private static final LinkedList<c> Nob;
  private static b Noc;
  private static c Nod;
  private static EffectManager Noe;
  private static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> Nof;
  private static HashMap<String, String> Nog;
  private static boolean Noh;
  private static boolean Noi;
  private static HashMap<String, Pair<Integer, Long>> Noj;
  private static final List<Integer> Nok;
  public static final a Nol;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(226637);
    Nol = new a();
    NnY = com.tencent.mm.loader.j.b.aSD() + "image_enhancement_result";
    NnZ = ae.e(new o[] { s.M("diehua.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.diehua)), s.M("shanhei.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.shanhei)), s.M("shanbai.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.shanbai)), s.M("zuoyi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.zuoyi)), s.M("youyi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.youyi)), s.M("shangyi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.shangyi)), s.M("xiayi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.xiayi)), s.M("fangda.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.fangda)), s.M("suoxiao.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.suoxiao)), s.M("youzhuan.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.youzhuan)), s.M("zuozhuan.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.zuozhuan)) });
    Noa = new LinkedList();
    Nob = new LinkedList();
    Nog = new HashMap();
    Noj = new HashMap();
    n.a[] arrayOfa = n.a.values();
    Collection localCollection = (Collection)new ArrayList(arrayOfa.length);
    int j = arrayOfa.length;
    while (i < j)
    {
      localCollection.add(Integer.valueOf(arrayOfa[i].ordinal()));
      i += 1;
    }
    Nok = (List)localCollection;
    AppMethodBeat.o(226637);
  }
  
  public static void E(List<ad> paramList, int paramInt)
  {
    AppMethodBeat.i(226576);
    p.k(paramList, "trackList");
    Iterator localIterator = ((Iterable)Noa).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject).order == paramInt)
      {
        i = 1;
        label57:
        if (i == 0) {
          break label115;
        }
      }
    }
    for (;;)
    {
      localObject = (a)localObject;
      paramList = ((Iterable)kotlin.a.j.O(paramList, paramList.size() - 1)).iterator();
      while (paramList.hasNext()) {
        a((ad)paramList.next(), (a)localObject);
      }
      i = 0;
      break label57;
      label115:
      break;
      localObject = null;
    }
    AppMethodBeat.o(226576);
  }
  
  public static List<ad> a(c paramc, List<ad> paramList)
  {
    AppMethodBeat.i(226574);
    p.k(paramc, "template");
    p.k(paramList, "sourceTrackList");
    long l3 = Util.currentTicks();
    HashMap localHashMap = new HashMap();
    Object localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ad)((Iterator)localObject1).next();
      ((Map)localHashMap).put(((ad)localObject2).path, Long.valueOf(0L));
    }
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList((Collection)paramc.Nor);
    localObject1 = (List)localArrayList;
    if (((List)localObject1).size() > 1) {
      kotlin.a.j.a((List)localObject1, (Comparator)new e());
    }
    localArrayList.set(localArrayList.size() - 1, Pair.create(((Pair)kotlin.a.j.lq((List)localArrayList)).first, Long.valueOf(paramc.duration)));
    new HashMap();
    int m = ((Collection)localArrayList).size();
    int k = 0;
    Long localLong1;
    Long localLong2;
    long l1;
    long l2;
    Object localObject3;
    label323:
    int i;
    int j;
    if (k < m)
    {
      localLong1 = (Long)((Pair)localArrayList.get(k)).first;
      localLong2 = (Long)((Pair)localArrayList.get(k)).second;
      l1 = localLong2.longValue();
      p.j(localLong1, "replacementStart");
      l2 = l1 - localLong1.longValue();
      localObject1 = (ad)paramList.get(k % paramList.size());
      localObject3 = (Long)localHashMap.get(((ad)localObject1).path);
      if (localObject3 != null)
      {
        l1 = ((Long)localObject3).longValue();
        i = 0;
        j = ((Collection)paramList).size();
        label335:
        if (i >= j) {
          break label1095;
        }
        localObject1 = (ad)paramList.get((k + i) % paramList.size());
        localObject3 = (Long)localHashMap.get(((ad)localObject1).path);
        if (localObject3 == null) {
          break label790;
        }
        l1 = ((Long)localObject3).longValue();
        label389:
        if ((l1 + l2 > ((ad)localObject1).getDurationMs()) && (((ad)localObject1).type != 1)) {
          break label798;
        }
      }
    }
    label680:
    label825:
    label1092:
    label1095:
    for (;;)
    {
      localObject3 = new ad(((ad)localObject1).path, ((ad)localObject1).type);
      if (((ad)localObject1).type == 1)
      {
        ((ad)localObject3).Sn(0L);
        ((ad)localObject3).So(l2);
        ((ad)localObject3).Nng.NwS = l2;
        label463:
        ((ad)localObject3).Sl(localLong1.longValue());
        p.j(localLong2, "replacementEnd");
        ((ad)localObject3).Sm(localLong2.longValue());
        ((ad)localObject3).Nna = ((ad)localObject1).Nna;
        ((ad)localObject3).Nnb = ((ad)localObject1).Nnb;
        ((ad)localObject3).Nnc = ((ad)localObject1).Nnc;
        ((ad)localObject3).Nng.YHT = false;
        ((ad)localObject3).Nnd.vcr.set(((ad)localObject1).Nnd.vcr);
        ((ad)localObject3).Nnd.viewRect.set(((ad)localObject1).Nnd.viewRect);
        ((ad)localObject3).Nnd.kXj.set(((ad)localObject1).Nnd.kXj);
        ((ad)localObject3).Nnd.BZx = ((ad)localObject1).Nnd.BZx;
        ((ad)localObject1).Nnd.aGO *= 5.0F;
        ((ad)localObject1).Nnd.aGN *= 5.0F;
        ((ad)localObject3).Nnd.aHZ.set(((ad)localObject1).Nnd.aHZ);
        Iterator localIterator = ((Iterable)paramc.Nor).iterator();
        i = 0;
        j = -1;
        if (!localIterator.hasNext()) {
          break label825;
        }
        Object localObject4 = localIterator.next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject4 = (Pair)localObject4;
        if ((!p.h((Long)((Pair)localObject4).first, (Long)((Pair)localArrayList.get(k)).first)) || (!p.h((Long)((Pair)localObject4).second, (Long)((Pair)localArrayList.get(k)).second))) {
          break label1092;
        }
        j = i;
      }
      for (;;)
      {
        i += 1;
        break label680;
        l1 = -1L;
        break label323;
        l1 = -1L;
        break label389;
        i += 1;
        break label335;
        ((ad)localObject3).Sn(l1);
        ((ad)localObject3).So(l1 + l2);
        break label463;
        Log.i("MicroMsg.LocalEffectManager", "add template track, time:[" + localLong1 + ", " + localLong2 + "], track time:[" + ((ad)localObject3).Nng.MQV + ", " + ((ad)localObject3).Nng.MQW + ", " + ((ad)localObject3).Nng.NwS + "], path:" + ((ad)localObject1).path + ", originIndex:" + j);
        l2 = l1 + l2;
        l1 = l2;
        if (l2 >= ((ad)localObject1).getDurationMs()) {
          l1 = 0L;
        }
        ((Map)localHashMap).put(((ad)localObject1).path, Long.valueOf(l1));
        ((ArrayList)localObject2).add(localObject3);
        k += 1;
        break;
        Log.i("MicroMsg.LocalEffectManager", "finish generate template track name:" + paramc.name + ", result.size:" + ((ArrayList)localObject2).size() + ", replacementInfo:" + paramc.Nor + ", template.duration:" + paramc.duration + ", cost:" + Util.ticksToNow(l3));
        paramc = (List)localObject2;
        AppMethodBeat.o(226574);
        return paramc;
      }
    }
  }
  
  public static void a(ad paramad, int paramInt)
  {
    AppMethodBeat.i(226577);
    p.k(paramad, "track");
    Iterator localIterator = ((Iterable)Noa).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject).order == paramInt)
      {
        i = 1;
        label57:
        if (i == 0) {
          break label79;
        }
      }
    }
    for (;;)
    {
      a(paramad, (a)localObject);
      AppMethodBeat.o(226577);
      return;
      i = 0;
      break label57;
      label79:
      break;
      localObject = null;
    }
  }
  
  private static void a(ad paramad, a parama)
  {
    AppMethodBeat.i(226580);
    p.k(paramad, "track");
    EffectManager localEffectManager = Noe;
    if (localEffectManager != null) {
      localEffectManager.WI(paramad.gtF());
    }
    paramad.Nng.MQX.NnT = null;
    paramad.a(parama);
    AppMethodBeat.o(226580);
  }
  
  public static void a(c paramc, long[] paramArrayOfLong)
  {
    Long localLong = null;
    AppMethodBeat.i(226586);
    p.k(paramc, "videoTemplate");
    p.k(paramArrayOfLong, "targets");
    paramArrayOfLong = Noe;
    if (paramArrayOfLong != null) {
      paramArrayOfLong.ike();
    }
    b(null, false);
    paramArrayOfLong = Nod;
    Object localObject1;
    if (paramArrayOfLong != null)
    {
      localObject1 = new StringBuilder("setVideoTemplate: remove  ");
      if (paramArrayOfLong == null) {
        break label252;
      }
      paramArrayOfLong = Long.valueOf(paramArrayOfLong.Noq);
      Log.i("MicroMsg.LocalEffectManager", paramArrayOfLong);
      paramArrayOfLong = Noe;
      if (paramArrayOfLong != null) {
        paramArrayOfLong.b(com.tencent.mm.xeffect.effect.j.YZE);
      }
    }
    paramArrayOfLong = Noe;
    if (paramArrayOfLong != null)
    {
      localObject1 = com.tencent.mm.xeffect.effect.j.YZE;
      Object localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getAssets();
      p.j(localObject2, "MMApplicationContext.getContext().assets");
      paramArrayOfLong = paramArrayOfLong.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, paramc.path);
      label156:
      if (paramArrayOfLong != null) {
        paramArrayOfLong.aZ(0L, paramc.duration);
      }
      localObject1 = Noe;
      if (localObject1 != null) {
        ((EffectManager)localObject1).b(paramArrayOfLong);
      }
      localObject1 = new StringBuilder("setVideoTemplate: addEffect ");
      if (paramArrayOfLong != null) {
        localLong = Long.valueOf(paramArrayOfLong.id);
      }
      Log.i("MicroMsg.LocalEffectManager", localLong);
      if (paramArrayOfLong == null) {
        break label262;
      }
    }
    label262:
    for (long l = paramArrayOfLong.id;; l = 0L)
    {
      paramc.Noq = l;
      Nod = paramc;
      AppMethodBeat.o(226586);
      return;
      label252:
      paramArrayOfLong = null;
      break;
      paramArrayOfLong = null;
      break label156;
    }
  }
  
  public static void a(final com.tencent.mm.videocomposition.j paramj, boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(226597);
    b localb = Noc;
    Object localObject2;
    if (localb != null)
    {
      if ((!paramBoolean) || (localb.NnB != null)) {
        break label223;
      }
      localObject1 = Noe;
      if (localObject1 == null) {
        break label217;
      }
      localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.YZM);
      localObject2 = Noe;
      if (localObject2 != null) {
        ((EffectManager)localObject2).b((af)localObject1);
      }
      localObject2 = localObject1;
      if (!(localObject1 instanceof n)) {
        localObject2 = null;
      }
      localb.NnB = ((n)localObject2);
      label94:
      if (paramBoolean)
      {
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf.gvY();
        if (paramj != null) {
          paramj.a((com.tencent.mm.videocomposition.b.e)new i(paramBoolean, paramj));
        }
      }
    }
    Object localObject1 = new StringBuilder("setVideoEnhancement enable:").append(paramBoolean).append(", effectId:");
    paramj = Noc;
    if (paramj != null) {}
    for (paramj = Long.valueOf(paramj.gtZ());; paramj = null)
    {
      localObject1 = ((StringBuilder)localObject1).append(paramj).append(", rangeId:");
      localObject2 = Noc;
      paramj = localObject3;
      if (localObject2 != null) {
        paramj = ((b)localObject2).NnB;
      }
      Log.i("MicroMsg.LocalEffectManager", paramj);
      AppMethodBeat.o(226597);
      return;
      label217:
      localObject1 = null;
      break;
      label223:
      if ((paramBoolean) || (localb.NnB == null)) {
        break label94;
      }
      localObject1 = Noe;
      if (localObject1 != null)
      {
        localObject2 = localb.NnB;
        if (localObject2 == null) {
          break label278;
        }
      }
      label278:
      for (long l = ((af)localObject2).id;; l = 0L)
      {
        ((EffectManager)localObject1).WI(l);
        localb.NnB = null;
        break;
      }
    }
  }
  
  public static void akg(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(226604);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.LocalEffectManager", "setVideoEnhancementScene error:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(226604);
      return;
    }
    Object localObject = Noc;
    if (localObject != null)
    {
      if (((b)localObject).gtZ() > 0L)
      {
        Log.i("MicroMsg.LocalEffectManager", "setVideoEnhancementScene, effectId:" + ((b)localObject).gtZ() + ", scene:" + paramInt);
        n localn = ((b)localObject).NnB;
        if (localn != null) {
          localn.setScene(paramInt);
        }
        ((b)localObject).Non = paramInt;
      }
      if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) == 1) {}
      for (;;)
      {
        localObject = Noc;
        if (localObject == null) {
          break label190;
        }
        if (((b)localObject).gtZ() <= 0L) {
          break;
        }
        Log.i("MicroMsg.LocalEffectManager", "setVideoEnhancementShowFaceLandmarks, show:".concat(String.valueOf(bool)));
        localObject = ((b)localObject).NnB;
        if (localObject == null) {
          break;
        }
        ((n)localObject).Im(bool);
        AppMethodBeat.o(226604);
        return;
        bool = false;
      }
      AppMethodBeat.o(226604);
      return;
      label190:
      AppMethodBeat.o(226604);
      return;
    }
    AppMethodBeat.o(226604);
  }
  
  public static void b(final ac paramac, boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(226591);
    b localb = Noc;
    Object localObject2;
    if (localb != null)
    {
      if ((!paramBoolean) || (localb.NnB != null)) {
        break label232;
      }
      localObject1 = Noe;
      if (localObject1 == null) {
        break label226;
      }
      localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.YZM);
      localObject2 = Noe;
      if (localObject2 != null) {
        ((EffectManager)localObject2).b((af)localObject1);
      }
      localObject2 = localObject1;
      if (!(localObject1 instanceof n)) {
        localObject2 = null;
      }
      localb.NnB = ((n)localObject2);
      label94:
      if (paramac != null) {
        paramac.NmV = paramBoolean;
      }
      if (paramBoolean)
      {
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf.gvY();
        if (paramac != null) {
          paramac.a((com.tencent.mm.videocomposition.b.e)new j(paramBoolean, paramac));
        }
      }
    }
    Object localObject1 = new StringBuilder("setVideoEnhancement enable:").append(paramBoolean).append(", effectId:");
    paramac = Noc;
    if (paramac != null) {}
    for (paramac = Long.valueOf(paramac.gtZ());; paramac = null)
    {
      localObject1 = ((StringBuilder)localObject1).append(paramac).append(", rangeId:");
      localObject2 = Noc;
      paramac = localObject3;
      if (localObject2 != null) {
        paramac = ((b)localObject2).NnB;
      }
      Log.i("MicroMsg.LocalEffectManager", paramac);
      AppMethodBeat.o(226591);
      return;
      label226:
      localObject1 = null;
      break;
      label232:
      if ((paramBoolean) || (localb.NnB == null)) {
        break label94;
      }
      localObject1 = Noe;
      if (localObject1 != null)
      {
        localObject2 = localb.NnB;
        if (localObject2 == null) {
          break label287;
        }
      }
      label287:
      for (long l = ((af)localObject2).id;; l = 0L)
      {
        ((EffectManager)localObject1).WI(l);
        localb.NnB = null;
        break;
      }
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(226552);
    p.k(parama, "transEffectInfo");
    if (parama.NnT == null)
    {
      localObject = Noe;
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (Object localObject = ((EffectManager)localObject).a(com.tencent.mm.xeffect.effect.j.YZB, parama.assetPath);; localObject = null)
    {
      parama.NnT = ((af)localObject);
      AppMethodBeat.o(226552);
      return;
    }
  }
  
  public static boolean bfA(String paramString)
  {
    AppMethodBeat.i(226605);
    p.k(paramString, "json");
    b localb = Noc;
    if ((localb != null) && (localb.gtZ() > 0L))
    {
      n localn = localb.NnB;
      if (localn != null) {
        localn.bCB(paramString);
      }
      Log.i("MicroMsg.LocalEffectManager", "setImageEnhancementSceneFilterSettingsByJson:".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.LocalEffectManager", "setImageEnhancementSceneFilterSettingsByJson, ret:true, effectId:" + localb.gtZ());
      AppMethodBeat.o(226605);
      return true;
    }
    AppMethodBeat.o(226605);
    return false;
  }
  
  /* Error */
  private static Bitmap bfB(final String paramString)
  {
    // Byte code:
    //   0: ldc_w 833
    //   3: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 834
    //   10: invokestatic 344	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 4	java/lang/Object
    //   16: dup
    //   17: invokespecial 334	java/lang/Object:<init>	()V
    //   20: astore_2
    //   21: ldc_w 554
    //   24: ldc_w 836
    //   27: aload_0
    //   28: invokestatic 826	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokevirtual 757	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: new 373	com/tencent/mm/plugin/vlog/model/ad
    //   40: dup
    //   41: aload_0
    //   42: iconst_1
    //   43: invokespecial 466	com/tencent/mm/plugin/vlog/model/ad:<init>	(Ljava/lang/String;I)V
    //   46: astore 4
    //   48: new 795	com/tencent/mm/plugin/vlog/model/ac
    //   51: dup
    //   52: aload 4
    //   54: invokestatic 840	kotlin/a/j:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   57: invokespecial 843	com/tencent/mm/plugin/vlog/model/ac:<init>	(Ljava/util/List;)V
    //   60: astore_3
    //   61: aload_3
    //   62: iconst_1
    //   63: invokestatic 643	com/tencent/mm/plugin/vlog/model/local/a:b	(Lcom/tencent/mm/plugin/vlog/model/ac;Z)V
    //   66: aload_0
    //   67: invokestatic 847	com/tencent/mm/plugin/vlog/model/local/a:bfz	(Ljava/lang/String;)I
    //   70: istore_1
    //   71: getstatic 329	com/tencent/mm/plugin/vlog/model/local/a:Nok	Ljava/util/List;
    //   74: iload_1
    //   75: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: invokeinterface 850 2 0
    //   83: ifeq +7 -> 90
    //   86: iload_1
    //   87: invokestatic 852	com/tencent/mm/plugin/vlog/model/local/a:akg	(I)V
    //   90: new 854	kotlin/g/b/aa$f
    //   93: dup
    //   94: invokespecial 855	kotlin/g/b/aa$f:<init>	()V
    //   97: astore_0
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 858	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
    //   103: aload_3
    //   104: getstatic 612	com/tencent/mm/plugin/vlog/model/local/a:Noe	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   107: invokevirtual 860	com/tencent/mm/plugin/vlog/model/ac:a	(Lcom/tencent/mm/xeffect/effect/EffectManager;)V
    //   110: getstatic 866	com/tencent/mm/videocomposition/a:YHM	Lcom/tencent/mm/videocomposition/a$a;
    //   113: astore 5
    //   115: aload_3
    //   116: invokevirtual 870	com/tencent/mm/plugin/vlog/model/ac:getComposition	()Lcom/tencent/mm/videocomposition/j;
    //   119: invokestatic 875	com/tencent/mm/videocomposition/a$a:e	(Lcom/tencent/mm/videocomposition/j;)Lcom/tencent/mm/videocomposition/a;
    //   122: astore 5
    //   124: aload 5
    //   126: aload 4
    //   128: getfield 477	com/tencent/mm/plugin/vlog/model/ad:Nng	Lcom/tencent/mm/videocomposition/b;
    //   131: getfield 876	com/tencent/mm/videocomposition/b:Nna	I
    //   134: aload 4
    //   136: getfield 477	com/tencent/mm/plugin/vlog/model/ad:Nng	Lcom/tencent/mm/videocomposition/b;
    //   139: getfield 877	com/tencent/mm/videocomposition/b:Nnb	I
    //   142: invokevirtual 881	com/tencent/mm/videocomposition/a:setSize	(II)V
    //   145: aload 5
    //   147: ldc2_w 882
    //   150: invokestatic 397	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   153: invokestatic 840	kotlin/a/j:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   156: new 19	com/tencent/mm/plugin/vlog/model/local/a$f
    //   159: dup
    //   160: aload 4
    //   162: aload_0
    //   163: aload_2
    //   164: invokespecial 886	com/tencent/mm/plugin/vlog/model/local/a$f:<init>	(Lcom/tencent/mm/plugin/vlog/model/ad;Lkotlin/g/b/aa$f;Ljava/lang/Object;)V
    //   167: checkcast 888	kotlin/g/a/m
    //   170: invokevirtual 891	com/tencent/mm/videocomposition/a:b	(Ljava/util/List;Lkotlin/g/a/m;)V
    //   173: aload_2
    //   174: monitorenter
    //   175: aload_2
    //   176: invokevirtual 894	java/lang/Object:wait	()V
    //   179: getstatic 900	kotlin/x:aazN	Lkotlin/x;
    //   182: astore 4
    //   184: aload_2
    //   185: monitorexit
    //   186: aload_3
    //   187: iconst_0
    //   188: invokestatic 643	com/tencent/mm/plugin/vlog/model/local/a:b	(Lcom/tencent/mm/plugin/vlog/model/ac;Z)V
    //   191: aload_0
    //   192: getfield 858	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
    //   195: checkcast 902	android/graphics/Bitmap
    //   198: astore_0
    //   199: ldc_w 833
    //   202: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_0
    //   206: areturn
    //   207: astore_2
    //   208: ldc_w 554
    //   211: new 194	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 904
    //   218: invokespecial 559	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 906
    //   228: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 909	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   235: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 759	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: ldc_w 833
    //   247: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aconst_null
    //   251: areturn
    //   252: astore 4
    //   254: ldc_w 554
    //   257: aload 4
    //   259: checkcast 911	java/lang/Throwable
    //   262: ldc_w 912
    //   265: iconst_0
    //   266: anewarray 4	java/lang/Object
    //   269: invokestatic 916	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -93 -> 179
    //   275: astore_0
    //   276: aload_2
    //   277: monitorexit
    //   278: ldc_w 833
    //   281: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: aload_0
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramString	String
    //   70	17	1	i	int
    //   20	165	2	localObject1	Object
    //   207	70	2	localException1	java.lang.Exception
    //   60	127	3	localac	ac
    //   46	137	4	localObject2	Object
    //   252	6	4	localException2	java.lang.Exception
    //   113	33	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	48	207	java/lang/Exception
    //   175	179	252	java/lang/Exception
    //   175	179	275	finally
    //   179	184	275	finally
    //   254	272	275	finally
  }
  
  public static int bfz(String paramString)
  {
    AppMethodBeat.i(226538);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(226538);
      return -1;
    }
    paramString = (Pair)((Map)Noj).get(paramString);
    if (paramString != null)
    {
      paramString = (Integer)paramString.first;
      if (paramString != null)
      {
        int i = paramString.intValue();
        AppMethodBeat.o(226538);
        return i;
      }
    }
    AppMethodBeat.o(226538);
    return -1;
  }
  
  public static LinkedList<a> gtJ()
  {
    return Noa;
  }
  
  public static LinkedList<c> gtK()
  {
    return Nob;
  }
  
  public static b gtL()
  {
    return Noc;
  }
  
  public static EffectManager gtM()
  {
    return Noe;
  }
  
  public static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> gtN()
  {
    return Nof;
  }
  
  public static HashMap<String, String> gtO()
  {
    return Nog;
  }
  
  public static HashMap<String, Pair<Integer, Long>> gtP()
  {
    return Noj;
  }
  
  private static void gtQ()
  {
    AppMethodBeat.i(226545);
    Log.i("MicroMsg.LocalEffectManager", "initTransResource: transition res " + f.HVc.HUN + '}');
    if (f.HVc.HUN)
    {
      gtR();
      AppMethodBeat.o(226545);
      return;
    }
    f.HVc.HUO = ((kotlin.g.a.a)h.Nou);
    AppMethodBeat.o(226545);
  }
  
  private static void gtR()
  {
    AppMethodBeat.i(226550);
    Noh = true;
    Object localObject1 = f.HVc.fxD();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = f.HVc.fxG();
        if (localJSONArray == null) {
          p.iCn();
        }
        Noa.clear();
        int k = localJSONArray.length();
        int i = 0;
        if (i < k)
        {
          Object localObject3 = localJSONArray.optJSONObject(i);
          String str1 = ((JSONObject)localObject3).optString("name");
          String str2 = ((JSONObject)localObject3).getString("pag");
          Object localObject2 = (Integer)NnZ.get(((JSONObject)localObject3).getString("svg"));
          int m = ((JSONObject)localObject3).getInt("order");
          localObject3 = (String)localObject1 + str2;
          if (localObject2 != null)
          {
            j = ((Integer)localObject2).intValue();
            localObject2 = Noa;
            p.j(str1, "transEffectName");
            ((LinkedList)localObject2).add(new a(str1, m, (String)localObject3, j, 500L, 32));
            i += 1;
          }
        }
        else
        {
          localObject1 = (List)Noa;
          if (((List)localObject1).size() > 1) {
            kotlin.a.j.a((List)localObject1, (Comparator)new g());
          }
          AppMethodBeat.o(226550);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.LocalEffectManager", (Throwable)localJSONException, "Cannot load transEffect config", new Object[0]);
        AppMethodBeat.o(226550);
        return;
      }
      int j = -1;
    }
  }
  
  public static List<Integer> gtS()
  {
    return Nok;
  }
  
  public static boolean gtT()
  {
    Object localObject = Noc;
    if (localObject != null)
    {
      localObject = ((b)localObject).NnB;
      if (localObject == null) {}
    }
    for (long l = ((af)localObject).id; l > 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  public static boolean gtU()
  {
    AppMethodBeat.i(226601);
    boolean bool;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) {
      bool = true;
    }
    int i;
    for (;;)
    {
      i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_ENABLE_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", 0);
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(226601);
      return bool;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYy, 0) == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (i == 1)
    {
      AppMethodBeat.o(226601);
      return true;
    }
    AppMethodBeat.o(226601);
    return false;
  }
  
  public static void gtV()
  {
    AppMethodBeat.i(226621);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.xlabeffect.h localh = com.tencent.mm.plugin.xlabeffect.h.QQH;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.xlabeffect.h.hfj()).append("/");
    localh = com.tencent.mm.plugin.xlabeffect.h.QQH;
    localObject = com.tencent.mm.plugin.xlabeffect.h.hfl();
    if ((g.HVd.fxS()) && (!u.agG((String)localObject)))
    {
      u.oo(g.HVd.fxR(), (String)localObject);
      Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, copy image label model path, from:" + g.HVd.fxR() + " to " + (String)localObject);
    }
    if (!u.agG((String)localObject))
    {
      Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext model not exist!");
      AppMethodBeat.o(226621);
      return;
    }
    Log.i("MicroMsg.LocalEffectManager", "start tryCreateX3DGlobalContext");
    localObject = com.tencent.mm.plugin.xlabeffect.h.QQH;
    Noi = GlobalContextCreator.bCz(com.tencent.mm.plugin.xlabeffect.h.hfj());
    Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext finish");
    AppMethodBeat.o(226621);
  }
  
  public static void gtW()
  {
    AppMethodBeat.i(226624);
    com.tencent.e.h.ZvG.be((Runnable)k.Noy);
    AppMethodBeat.o(226624);
  }
  
  public static void h(WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> paramWeakReference)
  {
    Nof = paramWeakReference;
  }
  
  public static void iE(List<String> paramList)
  {
    AppMethodBeat.i(226619);
    p.k(paramList, "pathList");
    Nog.clear();
    Object localObject = com.tencent.mm.videocomposition.e.YIc;
    int i = com.tencent.mm.videocomposition.e.igE();
    localObject = com.tencent.mm.videocomposition.e.YIc;
    com.tencent.mm.videocomposition.e.azk(2000);
    com.tencent.mm.videocomposition.e.YIc.clear();
    localObject = ((Iterable)paramList).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      Bitmap localBitmap = bfB(str1);
      if (localBitmap != null)
      {
        String str2 = NnY + '/' + Util.currentTicks();
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, str2, false);
        ((Map)Nog).put(str1, str2);
        Log.i("MicroMsg.LocalEffectManager", "save enhancement image result in " + str2 + ", origin:" + str1);
        if (Nog.size() == paramList.size()) {
          Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish");
        }
      }
    }
    paramList = com.tencent.mm.videocomposition.e.YIc;
    com.tencent.mm.videocomposition.e.azk(i);
    Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish return");
    AppMethodBeat.o(226619);
  }
  
  public static void s(HashMap<String, Pair<Integer, Long>> paramHashMap)
  {
    AppMethodBeat.i(226534);
    p.k(paramHashMap, "value");
    if (!((Map)paramHashMap).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Noj.clear();
        Noj.putAll((Map)paramHashMap);
      }
      AppMethodBeat.o(226534);
      return;
    }
  }
  
  /* Error */
  public final void b(EffectManager paramEffectManager)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1214
    //   5: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 554
    //   11: ldc_w 1215
    //   14: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 612	com/tencent/mm/plugin/vlog/model/local/a:Noe	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   20: ifnonnull +21 -> 41
    //   23: aload_1
    //   24: astore_2
    //   25: aload_1
    //   26: ifnonnull +11 -> 37
    //   29: new 617	com/tencent/mm/xeffect/effect/EffectManager
    //   32: dup
    //   33: invokespecial 1216	com/tencent/mm/xeffect/effect/EffectManager:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: putstatic 612	com/tencent/mm/plugin/vlog/model/local/a:Noe	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   41: invokestatic 1147	com/tencent/mm/plugin/vlog/model/local/a:gtQ	()V
    //   44: invokestatic 1221	com/tencent/mm/plugin/vlog/model/w:gto	()Z
    //   47: pop
    //   48: new 9	com/tencent/mm/plugin/vlog/model/local/a$b
    //   51: dup
    //   52: invokespecial 1222	com/tencent/mm/plugin/vlog/model/local/a$b:<init>	()V
    //   55: putstatic 701	com/tencent/mm/plugin/vlog/model/local/a:Noc	Lcom/tencent/mm/plugin/vlog/model/local/a$b;
    //   58: new 194	java/lang/StringBuilder
    //   61: dup
    //   62: ldc_w 1224
    //   65: invokespecial 559	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: astore_2
    //   69: getstatic 701	com/tencent/mm/plugin/vlog/model/local/a:Noc	Lcom/tencent/mm/plugin/vlog/model/local/a$b;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +34 -> 108
    //   77: aload_1
    //   78: invokevirtual 742	com/tencent/mm/plugin/vlog/model/local/a$b:gtZ	()J
    //   81: invokestatic 397	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: astore_1
    //   85: ldc_w 554
    //   88: aload_2
    //   89: aload_1
    //   90: invokevirtual 562	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: ldc_w 1214
    //   102: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: aconst_null
    //   109: astore_1
    //   110: goto -25 -> 85
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	a
    //   0	118	1	paramEffectManager	EffectManager
    //   24	65	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	113	finally
    //   29	37	113	finally
    //   37	41	113	finally
    //   41	73	113	finally
    //   77	85	113	finally
    //   85	105	113	finally
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(226630);
      Log.i("MicroMsg.LocalEffectManager", "reset");
      EffectManager localEffectManager = Noe;
      if (localEffectManager != null) {
        localEffectManager.ike();
      }
      Nog.clear();
      AppMethodBeat.o(226630);
      return;
    }
    finally {}
  }
  
  public final void unInit()
  {
    try
    {
      AppMethodBeat.i(226628);
      Noa.clear();
      Log.i("MicroMsg.LocalEffectManager", "clear");
      Noj.clear();
      EffectManager localEffectManager = Noe;
      if (localEffectManager != null) {
        localEffectManager.destroy();
      }
      Noe = null;
      Noc = null;
      f.HVc.HUO = null;
      Nof = null;
      u.deleteDir(NnY);
      Nog.clear();
      if (Noi)
      {
        GlobalContextCreator.ijW();
        Noi = false;
      }
      AppMethodBeat.o(226628);
      return;
    }
    finally {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "", "name", "", "order", "", "assetPath", "svgPath", "duration", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Ljava/lang/String;ILjava/lang/String;IJLcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getAssetPath", "()Ljava/lang/String;", "setAssetPath", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getSvgPath", "setSvgPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"})
  public static final class a
  {
    af NnT;
    public int Nom;
    public String assetPath;
    public long duration;
    public String name;
    public int order;
    
    public a()
    {
      this(null, 0, null, 0, 0L, 63);
    }
    
    private a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(244011);
      this.name = paramString1;
      this.order = paramInt1;
      this.assetPath = paramString2;
      this.Nom = paramInt2;
      this.duration = paramLong;
      this.NnT = null;
      AppMethodBeat.o(244011);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(244020);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.name, paramObject.name)) || (this.order != paramObject.order) || (!p.h(this.assetPath, paramObject.assetPath)) || (this.Nom != paramObject.Nom) || (this.duration != paramObject.duration) || (!p.h(this.NnT, paramObject.NnT))) {}
        }
      }
      else
      {
        AppMethodBeat.o(244020);
        return true;
      }
      AppMethodBeat.o(244020);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(244017);
      Object localObject = this.name;
      int i;
      int m;
      if (localObject != null)
      {
        i = localObject.hashCode();
        m = this.order;
        localObject = this.assetPath;
        if (localObject == null) {
          break label127;
        }
      }
      label127:
      for (int j = localObject.hashCode();; j = 0)
      {
        int n = this.Nom;
        long l = this.duration;
        int i1 = (int)(l ^ l >>> 32);
        localObject = this.NnT;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(244017);
        return (((j + (i * 31 + m) * 31) * 31 + n) * 31 + i1) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(244016);
      String str = "TransEffectInfo(name=" + this.name + ", order=" + this.order + ", assetPath=" + this.assetPath + ", svgPath=" + this.Nom + ", duration=" + this.duration + ", effect=" + this.NnT + ")";
      AppMethodBeat.o(244016);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "currentScene", "", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;I)V", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "effectId", "", "getEffectId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class b
  {
    n NnB = null;
    int Non;
    
    private b(int paramInt)
    {
      this.Non = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(246674);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.NnB, paramObject.NnB)) || (this.Non != paramObject.Non)) {}
        }
      }
      else
      {
        AppMethodBeat.o(246674);
        return true;
      }
      AppMethodBeat.o(246674);
      return false;
    }
    
    public final long gtZ()
    {
      n localn = this.NnB;
      if (localn != null) {
        return localn.id;
      }
      return 0L;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(246673);
      n localn = this.NnB;
      if (localn != null) {}
      for (int i = localn.hashCode();; i = 0)
      {
        int j = this.Non;
        AppMethodBeat.o(246673);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(246672);
      String str = "VideoEnhancementEffectInfo(effect=" + this.NnB + ", currentScene=" + this.Non + ")";
      AppMethodBeat.o(246672);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "", "path", "", "musicPath", "size", "Landroid/util/Size;", "duration", "", "imageNums", "", "effectId", "trackCropToTemplateSize", "", "name", "icon", "templateEffectRangeId", "replacementInfo", "", "Landroid/util/Pair;", "(Ljava/lang/String;Ljava/lang/String;Landroid/util/Size;JIJZLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "getIcon", "()Ljava/lang/String;", "getImageNums", "()I", "setImageNums", "(I)V", "getMusicPath", "setMusicPath", "(Ljava/lang/String;)V", "getName", "getPath", "getReplacementInfo", "()Ljava/util/List;", "setReplacementInfo", "(Ljava/util/List;)V", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "getTemplateEffectRangeId", "setTemplateEffectRangeId", "getTrackCropToTemplateSize", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-vlog_release"})
  public static final class c
  {
    public Size GbH;
    private final long IcQ;
    private int Noo;
    public final boolean Nop;
    public long Noq;
    List<Pair<Long, Long>> Nor;
    public long duration;
    public final String icon;
    public String kXi;
    public final String name;
    public final String path;
    
    private c(String paramString1, String paramString2, Size paramSize, long paramLong1, int paramInt, boolean paramBoolean, String paramString3, String paramString4, long paramLong2, List<Pair<Long, Long>> paramList)
    {
      AppMethodBeat.i(247818);
      this.path = paramString1;
      this.kXi = paramString2;
      this.GbH = paramSize;
      this.duration = paramLong1;
      this.Noo = paramInt;
      this.IcQ = 0L;
      this.Nop = paramBoolean;
      this.name = paramString3;
      this.icon = paramString4;
      this.Noq = -1L;
      this.Nor = paramList;
      AppMethodBeat.o(247818);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(247828);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.h(this.path, paramObject.path)) || (!p.h(this.kXi, paramObject.kXi)) || (!p.h(this.GbH, paramObject.GbH)) || (this.duration != paramObject.duration) || (this.Noo != paramObject.Noo) || (this.IcQ != paramObject.IcQ) || (this.Nop != paramObject.Nop) || (!p.h(this.name, paramObject.name)) || (!p.h(this.icon, paramObject.icon)) || (this.Noq != paramObject.Noq) || (!p.h(this.Nor, paramObject.Nor))) {}
        }
      }
      else
      {
        AppMethodBeat.o(247828);
        return true;
      }
      AppMethodBeat.o(247828);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(247823);
      String str = "VideoTemplateInfo(path=" + this.path + ", musicPath=" + this.kXi + ", size=" + this.GbH + ", duration=" + this.duration + ", imageNums=" + this.Noo + ", effectId=" + this.IcQ + ", trackCropToTemplateSize=" + this.Nop + ", name=" + this.name + ", icon=" + this.icon + ", templateEffectRangeId=" + this.Noq + ", replacementInfo=" + this.Nor + ")";
      AppMethodBeat.o(247823);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final d Nos;
    
    static
    {
      AppMethodBeat.i(244501);
      Nos = new d();
      AppMethodBeat.o(244501);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(232082);
      int i = kotlin.b.a.a((Comparable)((Pair)paramT1).first, (Comparable)((Pair)paramT2).first);
      AppMethodBeat.o(232082);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class f
    extends q
    implements m<Long, Bitmap, x>
  {
    f(ad paramad, aa.f paramf, Object paramObject)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(227185);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((a.a)paramT1).order), (Comparable)Integer.valueOf(((a.a)paramT2).order));
      AppMethodBeat.o(227185);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final h Nou;
    
    static
    {
      AppMethodBeat.i(246402);
      Nou = new h();
      AppMethodBeat.o(246402);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/model/local/LocalEffectManager$setVideoCompositionEnhancement$1$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"})
  public static final class i
    implements com.tencent.mm.videocomposition.b.e
  {
    private String Nov = "";
    
    i(boolean paramBoolean, com.tencent.mm.videocomposition.j paramj) {}
    
    public final void Sj(long paramLong)
    {
      String str = null;
      AppMethodBeat.i(227237);
      Object localObject1 = a.Nol;
      localObject1 = a.gtL();
      Object localObject2;
      label52:
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((a.b)localObject1).NnB;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)paramj.MQY).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label241;
          }
          localObject1 = ((Iterator)localObject2).next();
          com.tencent.mm.videocomposition.b localb = (com.tencent.mm.videocomposition.b)localObject1;
          if ((localb.startTimeMs > paramLong) || (localb.endTimeMs <= paramLong)) {
            break label236;
          }
          i = 1;
          label100:
          if (i == 0) {
            break label239;
          }
          label104:
          localObject2 = (com.tencent.mm.videocomposition.b)localObject1;
          if (localObject2 == null) {
            break label247;
          }
        }
      }
      label236:
      label239:
      label241:
      label247:
      for (localObject1 = ((com.tencent.mm.videocomposition.b)localObject2).path;; localObject1 = null)
      {
        if ((p.h(localObject1, this.Nov) ^ true))
        {
          localObject1 = a.Nol;
          localObject1 = str;
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.videocomposition.b)localObject2).path;
          }
          i = a.bfz((String)localObject1);
          localObject1 = a.Nol;
          if (a.gtS().contains(Integer.valueOf(i)))
          {
            localObject1 = a.Nol;
            a.akg(i);
          }
          if (localObject2 != null)
          {
            str = ((com.tencent.mm.videocomposition.b)localObject2).path;
            localObject1 = str;
            if (str != null) {}
          }
          else
          {
            localObject1 = "";
          }
          this.Nov = ((String)localObject1);
        }
        AppMethodBeat.o(227237);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label100;
        break label52;
        localObject1 = null;
        break label104;
      }
    }
    
    public final void onRelease() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/model/local/LocalEffectManager$setVideoEnhancement$1$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"})
  public static final class j
    implements com.tencent.mm.videocomposition.b.e
  {
    private String Nov = "";
    
    j(boolean paramBoolean, ac paramac) {}
    
    public final void Sj(long paramLong)
    {
      String str = null;
      AppMethodBeat.i(250665);
      Object localObject = a.Nol;
      localObject = a.gtL();
      ad localad;
      if (localObject != null)
      {
        localObject = ((a.b)localObject).NnB;
        if (localObject != null)
        {
          localad = com.tencent.mm.plugin.vlog.model.i.a(paramac, paramLong);
          if (localad == null) {
            break label170;
          }
        }
      }
      label170:
      for (localObject = localad.path;; localObject = null)
      {
        if ((p.h(localObject, this.Nov) ^ true))
        {
          localObject = a.Nol;
          localObject = str;
          if (localad != null) {
            localObject = localad.path;
          }
          int i = a.bfz((String)localObject);
          localObject = a.Nol;
          if (a.gtS().contains(Integer.valueOf(i)))
          {
            localObject = a.Nol;
            a.akg(i);
          }
          if (localad != null)
          {
            str = localad.path;
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = "";
          }
          this.Nov = ((String)localObject);
        }
        AppMethodBeat.o(250665);
        return;
        localObject = null;
        break;
      }
    }
    
    public final void onRelease() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    public static final k Noy;
    
    static
    {
      AppMethodBeat.i(226075);
      Noy = new k();
      AppMethodBeat.o(226075);
    }
    
    public final void run()
    {
      AppMethodBeat.i(226073);
      Object localObject = c.lar;
      localObject = c.a.aVD();
      if (p.h(((c.b)localObject).lau, EGL14.EGL_NO_CONTEXT))
      {
        Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, create EGLContext failed");
        AppMethodBeat.o(226073);
        return;
      }
      a locala = a.Nol;
      a.gtV();
      if ((p.h(((c.b)localObject).eglSurface, EGL14.EGL_NO_SURFACE) ^ true)) {
        EGL14.eglDestroySurface(((c.b)localObject).las, ((c.b)localObject).eglSurface);
      }
      EGL14.eglDestroyContext(((c.b)localObject).las, ((c.b)localObject).lau);
      AppMethodBeat.o(226073);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.local.a
 * JD-Core Version:    0.7.0.1
 */
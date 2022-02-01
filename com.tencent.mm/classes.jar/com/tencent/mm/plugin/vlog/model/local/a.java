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
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.res.f;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.xeffect.GlobalContextCreator;
import com.tencent.mm.xeffect.effect.EffectManager;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.o;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager;", "", "()V", "ImageEnhancementResultImageSavePath", "", "getImageEnhancementResultImageSavePath", "()Ljava/lang/String;", "ImageEnhancementResultPathMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getImageEnhancementResultPathMap", "()Ljava/util/HashMap;", "setImageEnhancementResultPathMap", "(Ljava/util/HashMap;)V", "ImageEnhancementSceneValues", "", "", "getImageEnhancementSceneValues", "()Ljava/util/List;", "TAG", "TEMPLATE_CONFIG", "TEMPLATE_PATH", "TransEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "getTransEffectList", "()Ljava/util/LinkedList;", "TransEffectTime", "", "VideoTemplateList", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "getVideoTemplateList", "value", "Landroid/util/Pair;", "VideoTrackLabel", "getVideoTrackLabel", "setVideoTrackLabel", "currentVideoTemplate", "getCurrentVideoTemplate", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "setCurrentVideoTemplate", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;)V", "globalContextCreated", "", "transitionReady", "transitionResMap", "", "transitionView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "getTransitionView", "()Ljava/lang/ref/WeakReference;", "setTransitionView", "(Ljava/lang/ref/WeakReference;)V", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getVLogEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "setVLogEffectMgr", "(Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "videoEnhancementEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "getVideoEnhancementEffectInfo", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "setVideoEnhancementEffectInfo", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;)V", "applyTransition", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trans", "applyTransitionToAll", "trackList", "order", "checkCreateTransEffect", "transEffectInfo", "checkRefreshView", "generateTemplateEffectTrack", "template", "sourceTrackList", "getImageEnhancementBitmap", "Landroid/graphics/Bitmap;", "path", "getLabel", "getLocalPath", "assetsPath", "init", "initTransEffect", "initTransResource", "initVideoEnhancementEffect", "initVideoTemplates", "isSvrVideoEnhancementEnable", "isVideoEnhancementEnable", "removeVideoTemplate", "videoTemplate", "reset", "saveAllImageEnhancementResultImage", "pathList", "setTransition", "setVideoEnhancement", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "enable", "setVideoEnhancementScene", "scene", "setVideoEnhancementSceneFilterSettingsByJson", "json", "setVideoEnhancementShowFaceLandmarks", "show", "setVideoTemplate", "targets", "", "tryCreateX3DGlobalContext", "tryCreateX3DGlobalContextImpl", "unInit", "TransEffectInfo", "VideoEnhancementEffectInfo", "VideoTemplateInfo", "plugin-vlog_release"})
public final class a
{
  private static boolean GAA;
  private static HashMap<String, Pair<Integer, Long>> GAB;
  private static final List<Integer> GAC;
  public static final a GAD;
  private static final String GAs;
  private static final LinkedList<c> GAt;
  private static b GAu;
  private static c GAv;
  private static EffectManager GAw;
  private static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> GAx;
  private static HashMap<String, String> GAy;
  private static boolean GAz;
  private static final LinkedList<a> wKy;
  private static final Map<String, Integer> wKz;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(190779);
    GAD = new a();
    GAs = com.tencent.mm.loader.j.b.aKB() + "image_enhancement_result";
    wKz = ae.e(new o[] { kotlin.s.U("diehua.svg", Integer.valueOf(2131690086)), kotlin.s.U("shanhei.svg", Integer.valueOf(2131691476)), kotlin.s.U("shanbai.svg", Integer.valueOf(2131691474)), kotlin.s.U("zuoyi.svg", Integer.valueOf(2131691819)), kotlin.s.U("youyi.svg", Integer.valueOf(2131691817)), kotlin.s.U("shangyi.svg", Integer.valueOf(2131691475)), kotlin.s.U("xiayi.svg", Integer.valueOf(2131691816)), kotlin.s.U("fangda.svg", Integer.valueOf(2131690165)), kotlin.s.U("suoxiao.svg", Integer.valueOf(2131691597)), kotlin.s.U("youzhuan.svg", Integer.valueOf(2131691818)), kotlin.s.U("zuozhuan.svg", Integer.valueOf(2131691820)) });
    wKy = new LinkedList();
    GAt = new LinkedList();
    GAy = new HashMap();
    GAB = new HashMap();
    n.a[] arrayOfa = n.a.values();
    Collection localCollection = (Collection)new ArrayList(arrayOfa.length);
    int j = arrayOfa.length;
    while (i < j)
    {
      localCollection.add(Integer.valueOf(arrayOfa[i].ordinal()));
      i += 1;
    }
    GAC = (List)localCollection;
    AppMethodBeat.o(190779);
  }
  
  public static void D(List<com.tencent.mm.plugin.vlog.model.ad> paramList, int paramInt)
  {
    AppMethodBeat.i(190765);
    p.h(paramList, "trackList");
    Iterator localIterator = ((Iterable)wKy).iterator();
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
      paramList = ((Iterable)kotlin.a.j.N(paramList, paramList.size() - 1)).iterator();
      while (paramList.hasNext()) {
        a((com.tencent.mm.plugin.vlog.model.ad)paramList.next(), (a)localObject);
      }
      i = 0;
      break label57;
      label115:
      break;
      localObject = null;
    }
    AppMethodBeat.o(190765);
  }
  
  public static List<com.tencent.mm.plugin.vlog.model.ad> a(c paramc, List<com.tencent.mm.plugin.vlog.model.ad> paramList)
  {
    AppMethodBeat.i(190764);
    p.h(paramc, "template");
    p.h(paramList, "sourceTrackList");
    long l3 = Util.currentTicks();
    HashMap localHashMap = new HashMap();
    Object localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.vlog.model.ad)((Iterator)localObject1).next();
      ((Map)localHashMap).put(((com.tencent.mm.plugin.vlog.model.ad)localObject2).path, Long.valueOf(0L));
    }
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList((Collection)paramc.GAJ);
    localObject1 = (List)localArrayList;
    if (((List)localObject1).size() > 1) {
      kotlin.a.j.a((List)localObject1, (Comparator)new e());
    }
    localArrayList.set(localArrayList.size() - 1, Pair.create(((Pair)kotlin.a.j.ku((List)localArrayList)).first, Long.valueOf(paramc.duration)));
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
      p.g(localLong1, "replacementStart");
      l2 = l1 - localLong1.longValue();
      localObject1 = (com.tencent.mm.plugin.vlog.model.ad)paramList.get(k % paramList.size());
      localObject3 = (Long)localHashMap.get(((com.tencent.mm.plugin.vlog.model.ad)localObject1).path);
      if (localObject3 != null)
      {
        l1 = ((Long)localObject3).longValue();
        i = 0;
        j = ((Collection)paramList).size();
        label335:
        if (i >= j) {
          break label1095;
        }
        localObject1 = (com.tencent.mm.plugin.vlog.model.ad)paramList.get((k + i) % paramList.size());
        localObject3 = (Long)localHashMap.get(((com.tencent.mm.plugin.vlog.model.ad)localObject1).path);
        if (localObject3 == null) {
          break label790;
        }
        l1 = ((Long)localObject3).longValue();
        label389:
        if ((l1 + l2 > ((com.tencent.mm.plugin.vlog.model.ad)localObject1).getDurationMs()) && (((com.tencent.mm.plugin.vlog.model.ad)localObject1).type != 1)) {
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
      localObject3 = new com.tencent.mm.plugin.vlog.model.ad(((com.tencent.mm.plugin.vlog.model.ad)localObject1).path, ((com.tencent.mm.plugin.vlog.model.ad)localObject1).type);
      if (((com.tencent.mm.plugin.vlog.model.ad)localObject1).type == 1)
      {
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).KQ(0L);
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).KR(l2);
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).GzA.GJB = l2;
        label463:
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).KO(localLong1.longValue());
        p.g(localLong2, "replacementEnd");
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).KP(localLong2.longValue());
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzu = ((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzu;
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzv = ((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzv;
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzw = ((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzw;
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).GzA.Rhb = false;
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzx.rwL.set(((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzx.rwL);
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzx.viewRect.set(((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzx.viewRect);
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzx.iiw.set(((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzx.iiw);
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzx.xnf = ((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzx.xnf;
        ((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzx.aXu *= 5.0F;
        ((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzx.aXt *= 5.0F;
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).Gzx.gT.set(((com.tencent.mm.plugin.vlog.model.ad)localObject1).Gzx.gT);
        Iterator localIterator = ((Iterable)paramc.GAJ).iterator();
        i = 0;
        j = -1;
        if (!localIterator.hasNext()) {
          break label825;
        }
        Object localObject4 = localIterator.next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject4 = (Pair)localObject4;
        if ((!p.j((Long)((Pair)localObject4).first, (Long)((Pair)localArrayList.get(k)).first)) || (!p.j((Long)((Pair)localObject4).second, (Long)((Pair)localArrayList.get(k)).second))) {
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
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).KQ(l1);
        ((com.tencent.mm.plugin.vlog.model.ad)localObject3).KR(l1 + l2);
        break label463;
        Log.i("MicroMsg.LocalEffectManager", "add template track, time:[" + localLong1 + ", " + localLong2 + "], track time:[" + ((com.tencent.mm.plugin.vlog.model.ad)localObject3).GzA.GGz + ", " + ((com.tencent.mm.plugin.vlog.model.ad)localObject3).GzA.GGA + ", " + ((com.tencent.mm.plugin.vlog.model.ad)localObject3).GzA.GJB + "], path:" + ((com.tencent.mm.plugin.vlog.model.ad)localObject1).path + ", originIndex:" + j);
        l2 = l1 + l2;
        l1 = l2;
        if (l2 >= ((com.tencent.mm.plugin.vlog.model.ad)localObject1).getDurationMs()) {
          l1 = 0L;
        }
        ((Map)localHashMap).put(((com.tencent.mm.plugin.vlog.model.ad)localObject1).path, Long.valueOf(l1));
        ((ArrayList)localObject2).add(localObject3);
        k += 1;
        break;
        Log.i("MicroMsg.LocalEffectManager", "finish generate template track name:" + paramc.name + ", result.size:" + ((ArrayList)localObject2).size() + ", replacementInfo:" + paramc.GAJ + ", template.duration:" + paramc.duration + ", cost:" + Util.ticksToNow(l3));
        paramc = (List)localObject2;
        AppMethodBeat.o(190764);
        return paramc;
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.vlog.model.ad paramad, int paramInt)
  {
    AppMethodBeat.i(190766);
    p.h(paramad, "track");
    Iterator localIterator = ((Iterable)wKy).iterator();
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
      AppMethodBeat.o(190766);
      return;
      i = 0;
      break label57;
      label79:
      break;
      localObject = null;
    }
  }
  
  private static void a(com.tencent.mm.plugin.vlog.model.ad paramad, a parama)
  {
    AppMethodBeat.i(190767);
    p.h(paramad, "track");
    EffectManager localEffectManager = GAw;
    if (localEffectManager != null) {
      localEffectManager.Ot(paramad.fBI());
    }
    paramad.GzA.Rhc.GAn = null;
    paramad.a(parama);
    AppMethodBeat.o(190767);
  }
  
  public static void a(c paramc, long[] paramArrayOfLong)
  {
    Long localLong = null;
    AppMethodBeat.i(190768);
    p.h(paramc, "videoTemplate");
    p.h(paramArrayOfLong, "targets");
    paramArrayOfLong = GAw;
    if (paramArrayOfLong != null) {
      paramArrayOfLong.hiv();
    }
    b(null, false);
    paramArrayOfLong = GAv;
    Object localObject1;
    if (paramArrayOfLong != null)
    {
      localObject1 = new StringBuilder("setVideoTemplate: remove  ");
      if (paramArrayOfLong == null) {
        break label252;
      }
      paramArrayOfLong = Long.valueOf(paramArrayOfLong.GAI);
      Log.i("MicroMsg.LocalEffectManager", paramArrayOfLong);
      paramArrayOfLong = GAw;
      if (paramArrayOfLong != null) {
        paramArrayOfLong.b(com.tencent.mm.xeffect.effect.j.RxY);
      }
    }
    paramArrayOfLong = GAw;
    if (paramArrayOfLong != null)
    {
      localObject1 = com.tencent.mm.xeffect.effect.j.RxY;
      Object localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getAssets();
      p.g(localObject2, "MMApplicationContext.getContext().assets");
      paramArrayOfLong = paramArrayOfLong.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, paramc.path);
      label156:
      if (paramArrayOfLong != null) {
        paramArrayOfLong.aH(0L, paramc.duration);
      }
      localObject1 = GAw;
      if (localObject1 != null) {
        ((EffectManager)localObject1).a(paramArrayOfLong);
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
      paramc.GAI = l;
      GAv = paramc;
      AppMethodBeat.o(190768);
      return;
      label252:
      paramArrayOfLong = null;
      break;
      paramArrayOfLong = null;
      break label156;
    }
  }
  
  public static int aUc(String paramString)
  {
    AppMethodBeat.i(190759);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(190759);
      return -1;
    }
    paramString = (Pair)((Map)GAB).get(paramString);
    if (paramString != null)
    {
      paramString = (Integer)paramString.first;
      if (paramString != null)
      {
        int i = paramString.intValue();
        AppMethodBeat.o(190759);
        return i;
      }
    }
    AppMethodBeat.o(190759);
    return -1;
  }
  
  public static boolean aUd(String paramString)
  {
    AppMethodBeat.i(190772);
    p.h(paramString, "json");
    b localb = GAu;
    if ((localb != null) && (localb.fCb() > 0L))
    {
      n localn = localb.GzV;
      if (localn != null) {
        localn.bpE(paramString);
      }
      Log.i("MicroMsg.LocalEffectManager", "setImageEnhancementSceneFilterSettingsByJson:".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.LocalEffectManager", "setImageEnhancementSceneFilterSettingsByJson, ret:true, effectId:" + localb.fCb());
      AppMethodBeat.o(190772);
      return true;
    }
    AppMethodBeat.o(190772);
    return false;
  }
  
  /* Error */
  private static Bitmap aUe(final String paramString)
  {
    // Byte code:
    //   0: ldc_w 714
    //   3: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 715
    //   10: invokestatic 313	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 4	java/lang/Object
    //   16: dup
    //   17: invokespecial 303	java/lang/Object:<init>	()V
    //   20: astore_2
    //   21: ldc_w 524
    //   24: ldc_w 717
    //   27: aload_0
    //   28: invokestatic 703	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokevirtual 707	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokestatic 557	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: new 343	com/tencent/mm/plugin/vlog/model/ad
    //   40: dup
    //   41: aload_0
    //   42: iconst_1
    //   43: invokespecial 436	com/tencent/mm/plugin/vlog/model/ad:<init>	(Ljava/lang/String;I)V
    //   46: astore 4
    //   48: new 719	com/tencent/mm/plugin/vlog/model/ac
    //   51: dup
    //   52: aload 4
    //   54: invokestatic 723	kotlin/a/j:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   57: invokespecial 726	com/tencent/mm/plugin/vlog/model/ac:<init>	(Ljava/util/List;)V
    //   60: astore_3
    //   61: aload_3
    //   62: iconst_1
    //   63: invokestatic 613	com/tencent/mm/plugin/vlog/model/local/a:b	(Lcom/tencent/mm/plugin/vlog/model/ac;Z)V
    //   66: aload_0
    //   67: invokestatic 728	com/tencent/mm/plugin/vlog/model/local/a:aUc	(Ljava/lang/String;)I
    //   70: istore_1
    //   71: getstatic 298	com/tencent/mm/plugin/vlog/model/local/a:GAC	Ljava/util/List;
    //   74: iload_1
    //   75: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: invokeinterface 731 2 0
    //   83: ifeq +7 -> 90
    //   86: iload_1
    //   87: invokestatic 734	com/tencent/mm/plugin/vlog/model/local/a:acA	(I)V
    //   90: new 736	kotlin/g/b/z$f
    //   93: dup
    //   94: invokespecial 737	kotlin/g/b/z$f:<init>	()V
    //   97: astore_0
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 740	kotlin/g/b/z$f:SYG	Ljava/lang/Object;
    //   103: aload_3
    //   104: getstatic 582	com/tencent/mm/plugin/vlog/model/local/a:GAw	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   107: invokevirtual 742	com/tencent/mm/plugin/vlog/model/ac:a	(Lcom/tencent/mm/xeffect/effect/EffectManager;)V
    //   110: getstatic 748	com/tencent/mm/videocomposition/c:RgU	Lcom/tencent/mm/videocomposition/c$a;
    //   113: astore 5
    //   115: aload_3
    //   116: invokevirtual 752	com/tencent/mm/plugin/vlog/model/ac:getComposition	()Lcom/tencent/mm/videocomposition/n;
    //   119: invokestatic 757	com/tencent/mm/videocomposition/c$a:b	(Lcom/tencent/mm/videocomposition/n;)Lcom/tencent/mm/videocomposition/c;
    //   122: astore 5
    //   124: aload 5
    //   126: aload 4
    //   128: getfield 447	com/tencent/mm/plugin/vlog/model/ad:GzA	Lcom/tencent/mm/videocomposition/d;
    //   131: getfield 758	com/tencent/mm/videocomposition/d:Gzu	I
    //   134: aload 4
    //   136: getfield 447	com/tencent/mm/plugin/vlog/model/ad:GzA	Lcom/tencent/mm/videocomposition/d;
    //   139: getfield 759	com/tencent/mm/videocomposition/d:Gzv	I
    //   142: invokevirtual 763	com/tencent/mm/videocomposition/c:setSize	(II)V
    //   145: aload 5
    //   147: ldc2_w 764
    //   150: invokestatic 367	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   153: invokestatic 723	kotlin/a/j:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   156: new 19	com/tencent/mm/plugin/vlog/model/local/a$f
    //   159: dup
    //   160: aload 4
    //   162: aload_0
    //   163: aload_2
    //   164: invokespecial 768	com/tencent/mm/plugin/vlog/model/local/a$f:<init>	(Lcom/tencent/mm/plugin/vlog/model/ad;Lkotlin/g/b/z$f;Ljava/lang/Object;)V
    //   167: checkcast 770	kotlin/g/a/m
    //   170: invokevirtual 773	com/tencent/mm/videocomposition/c:b	(Ljava/util/List;Lkotlin/g/a/m;)V
    //   173: aload_2
    //   174: monitorenter
    //   175: aload_2
    //   176: invokevirtual 776	java/lang/Object:wait	()V
    //   179: getstatic 782	kotlin/x:SXb	Lkotlin/x;
    //   182: astore 4
    //   184: aload_2
    //   185: monitorexit
    //   186: aload_3
    //   187: iconst_0
    //   188: invokestatic 613	com/tencent/mm/plugin/vlog/model/local/a:b	(Lcom/tencent/mm/plugin/vlog/model/ac;Z)V
    //   191: aload_0
    //   192: getfield 740	kotlin/g/b/z$f:SYG	Ljava/lang/Object;
    //   195: checkcast 784	android/graphics/Bitmap
    //   198: astore_0
    //   199: ldc_w 714
    //   202: invokestatic 301	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_0
    //   206: areturn
    //   207: astore_2
    //   208: ldc_w 524
    //   211: new 188	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 786
    //   218: invokespecial 529	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 788
    //   228: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 791	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   235: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 793	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: ldc_w 714
    //   247: invokestatic 301	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aconst_null
    //   251: areturn
    //   252: astore 4
    //   254: ldc_w 524
    //   257: aload 4
    //   259: checkcast 795	java/lang/Throwable
    //   262: ldc_w 796
    //   265: iconst_0
    //   266: anewarray 4	java/lang/Object
    //   269: invokestatic 800	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -93 -> 179
    //   275: astore_0
    //   276: aload_2
    //   277: monitorexit
    //   278: ldc_w 714
    //   281: invokestatic 301	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void acA(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(190771);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.LocalEffectManager", "setVideoEnhancementScene error:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(190771);
      return;
    }
    Object localObject = GAu;
    if (localObject != null)
    {
      if (((b)localObject).fCb() > 0L)
      {
        Log.i("MicroMsg.LocalEffectManager", "setVideoEnhancementScene, effectId:" + ((b)localObject).fCb() + ", scene:" + paramInt);
        n localn = ((b)localObject).GzV;
        if (localn != null) {
          localn.setScene(paramInt);
        }
        ((b)localObject).GAF = paramInt;
      }
      if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) == 1) {}
      for (;;)
      {
        localObject = GAu;
        if (localObject == null) {
          break label190;
        }
        if (((b)localObject).fCb() <= 0L) {
          break;
        }
        Log.i("MicroMsg.LocalEffectManager", "setVideoEnhancementShowFaceLandmarks, show:".concat(String.valueOf(bool)));
        localObject = ((b)localObject).GzV;
        if (localObject == null) {
          break;
        }
        ((n)localObject).DL(bool);
        AppMethodBeat.o(190771);
        return;
        bool = false;
      }
      AppMethodBeat.o(190771);
      return;
      label190:
      AppMethodBeat.o(190771);
      return;
    }
    AppMethodBeat.o(190771);
  }
  
  public static void b(final ac paramac, boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(190769);
    b localb = GAu;
    Object localObject2;
    if (localb != null)
    {
      if ((!paramBoolean) || (localb.GzV != null)) {
        break label232;
      }
      localObject1 = GAw;
      if (localObject1 == null) {
        break label226;
      }
      localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.Ryg);
      localObject2 = GAw;
      if (localObject2 != null) {
        ((EffectManager)localObject2).a((com.tencent.mm.xeffect.effect.ad)localObject1);
      }
      localObject2 = localObject1;
      if (!(localObject1 instanceof n)) {
        localObject2 = null;
      }
      localb.GzV = ((n)localObject2);
      label94:
      if (paramac != null) {
        paramac.Gzp = paramBoolean;
      }
      if (paramBoolean)
      {
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.fDY();
        if (paramac != null) {
          paramac.a((com.tencent.mm.videocomposition.b.e)new i(paramBoolean, paramac));
        }
      }
    }
    Object localObject1 = new StringBuilder("setVideoEnhancement enable:").append(paramBoolean).append(", effectId:");
    paramac = GAu;
    if (paramac != null) {}
    for (paramac = Long.valueOf(paramac.fCb());; paramac = null)
    {
      localObject1 = ((StringBuilder)localObject1).append(paramac).append(", rangeId:");
      localObject2 = GAu;
      paramac = localObject3;
      if (localObject2 != null) {
        paramac = ((b)localObject2).GzV;
      }
      Log.i("MicroMsg.LocalEffectManager", paramac);
      AppMethodBeat.o(190769);
      return;
      label226:
      localObject1 = null;
      break;
      label232:
      if ((paramBoolean) || (localb.GzV == null)) {
        break label94;
      }
      localObject1 = GAw;
      if (localObject1 != null)
      {
        localObject2 = localb.GzV;
        if (localObject2 == null) {
          break label287;
        }
      }
      label287:
      for (long l = ((com.tencent.mm.xeffect.effect.ad)localObject2).id;; l = 0L)
      {
        ((EffectManager)localObject1).Ot(l);
        localb.GzV = null;
        break;
      }
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(190763);
    p.h(parama, "transEffectInfo");
    if (parama.GAn == null)
    {
      localObject = GAw;
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (Object localObject = ((EffectManager)localObject).a(com.tencent.mm.xeffect.effect.j.RxV, parama.assetPath);; localObject = null)
    {
      parama.GAn = ((com.tencent.mm.xeffect.effect.ad)localObject);
      AppMethodBeat.o(190763);
      return;
    }
  }
  
  private static void dMd()
  {
    AppMethodBeat.i(190762);
    GAz = true;
    Object localObject1 = f.BYo.eLk();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = f.BYo.eLn();
        if (localJSONArray == null) {
          p.hyc();
        }
        int k = localJSONArray.length();
        int i = 0;
        if (i < k)
        {
          Object localObject3 = localJSONArray.optJSONObject(i);
          String str1 = ((JSONObject)localObject3).optString("name");
          String str2 = ((JSONObject)localObject3).getString("pag");
          Object localObject2 = (Integer)wKz.get(((JSONObject)localObject3).getString("svg"));
          int m = ((JSONObject)localObject3).getInt("order");
          localObject3 = (String)localObject1 + str2;
          if (localObject2 != null)
          {
            j = ((Integer)localObject2).intValue();
            localObject2 = wKy;
            p.g(str1, "transEffectName");
            ((LinkedList)localObject2).add(new a(str1, m, (String)localObject3, j, 500L, 32));
            i += 1;
          }
        }
        else
        {
          localObject1 = (List)wKy;
          if (((List)localObject1).size() > 1) {
            kotlin.a.j.a((List)localObject1, (Comparator)new g());
          }
          AppMethodBeat.o(190762);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.LocalEffectManager", (Throwable)localJSONException, "Cannot load transEffect config", new Object[0]);
        AppMethodBeat.o(190762);
        return;
      }
      int j = -1;
    }
  }
  
  public static LinkedList<a> fBM()
  {
    return wKy;
  }
  
  public static LinkedList<c> fBN()
  {
    return GAt;
  }
  
  public static b fBO()
  {
    return GAu;
  }
  
  public static EffectManager fBP()
  {
    return GAw;
  }
  
  public static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> fBQ()
  {
    return GAx;
  }
  
  public static HashMap<String, String> fBR()
  {
    return GAy;
  }
  
  public static HashMap<String, Pair<Integer, Long>> fBS()
  {
    return GAB;
  }
  
  private static void fBT()
  {
    AppMethodBeat.i(190761);
    Log.i("MicroMsg.LocalEffectManager", "initTransResource: transition res " + f.BYo.BXZ + '}');
    if (f.BYo.BXZ)
    {
      dMd();
      AppMethodBeat.o(190761);
      return;
    }
    f.BYo.BYa = ((kotlin.g.a.a)h.GAM);
    AppMethodBeat.o(190761);
  }
  
  public static List<Integer> fBU()
  {
    return GAC;
  }
  
  public static boolean fBV()
  {
    Object localObject = GAu;
    if (localObject != null)
    {
      localObject = ((b)localObject).GzV;
      if (localObject == null) {}
    }
    for (long l = ((com.tencent.mm.xeffect.effect.ad)localObject).id; l > 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  public static boolean fBW()
  {
    AppMethodBeat.i(190770);
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
      AppMethodBeat.o(190770);
      return bool;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snm, 0) == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (i == 1)
    {
      AppMethodBeat.o(190770);
      return true;
    }
    AppMethodBeat.o(190770);
    return false;
  }
  
  public static void fBX()
  {
    AppMethodBeat.i(190775);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.xlabeffect.e locale = com.tencent.mm.plugin.xlabeffect.e.JRF;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.xlabeffect.e.glu()).append("/");
    locale = com.tencent.mm.plugin.xlabeffect.e.JRF;
    localObject = com.tencent.mm.plugin.xlabeffect.e.glv();
    if ((com.tencent.mm.plugin.recordvideo.res.g.BYp.eLz()) && (!com.tencent.mm.vfs.s.YS((String)localObject)))
    {
      com.tencent.mm.vfs.s.nx(com.tencent.mm.plugin.recordvideo.res.g.BYp.eLy(), (String)localObject);
      Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, copy image label model path, from:" + com.tencent.mm.plugin.recordvideo.res.g.BYp.eLy() + " to " + (String)localObject);
    }
    if (!com.tencent.mm.vfs.s.YS((String)localObject))
    {
      Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext model not exist!");
      AppMethodBeat.o(190775);
      return;
    }
    Log.i("MicroMsg.LocalEffectManager", "start tryCreateX3DGlobalContext");
    localObject = com.tencent.mm.plugin.xlabeffect.e.JRF;
    GAA = GlobalContextCreator.bpC(com.tencent.mm.plugin.xlabeffect.e.glu());
    Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext finish");
    AppMethodBeat.o(190775);
  }
  
  public static void fBY()
  {
    AppMethodBeat.i(190776);
    h.RTc.aX((Runnable)j.GAP);
    AppMethodBeat.o(190776);
  }
  
  public static void hP(List<String> paramList)
  {
    AppMethodBeat.i(190774);
    p.h(paramList, "pathList");
    GAy.clear();
    Object localObject = com.tencent.mm.videocomposition.i.Rhj;
    int i = com.tencent.mm.videocomposition.i.hfl();
    localObject = com.tencent.mm.videocomposition.i.Rhj;
    com.tencent.mm.videocomposition.i.apL(2000);
    com.tencent.mm.videocomposition.i.Rhj.clear();
    localObject = ((Iterable)paramList).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      Bitmap localBitmap = aUe(str1);
      if (localBitmap != null)
      {
        String str2 = GAs + '/' + Util.currentTicks();
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, str2, false);
        ((Map)GAy).put(str1, str2);
        Log.i("MicroMsg.LocalEffectManager", "save enhancement image result in " + str2 + ", origin:" + str1);
        if (GAy.size() == paramList.size()) {
          Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish");
        }
      }
    }
    paramList = com.tencent.mm.videocomposition.i.Rhj;
    com.tencent.mm.videocomposition.i.apL(i);
    Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish return");
    AppMethodBeat.o(190774);
  }
  
  public static void i(WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> paramWeakReference)
  {
    GAx = paramWeakReference;
  }
  
  public static void p(HashMap<String, Pair<Integer, Long>> paramHashMap)
  {
    AppMethodBeat.i(190758);
    p.h(paramHashMap, "value");
    if (!((Map)paramHashMap).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        GAB.clear();
        GAB.putAll((Map)paramHashMap);
      }
      AppMethodBeat.o(190758);
      return;
    }
  }
  
  /* Error */
  public final void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1170
    //   5: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 524
    //   11: ldc_w 1171
    //   14: invokestatic 557	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 582	com/tencent/mm/plugin/vlog/model/local/a:GAw	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   20: ifnonnull +13 -> 33
    //   23: new 587	com/tencent/mm/xeffect/effect/EffectManager
    //   26: dup
    //   27: invokespecial 1172	com/tencent/mm/xeffect/effect/EffectManager:<init>	()V
    //   30: putstatic 582	com/tencent/mm/plugin/vlog/model/local/a:GAw	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   33: invokestatic 1102	com/tencent/mm/plugin/vlog/model/local/a:fBT	()V
    //   36: invokestatic 1177	com/tencent/mm/plugin/vlog/model/w:fBs	()Z
    //   39: pop
    //   40: new 9	com/tencent/mm/plugin/vlog/model/local/a$b
    //   43: dup
    //   44: invokespecial 1178	com/tencent/mm/plugin/vlog/model/local/a$b:<init>	()V
    //   47: putstatic 684	com/tencent/mm/plugin/vlog/model/local/a:GAu	Lcom/tencent/mm/plugin/vlog/model/local/a$b;
    //   50: new 188	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 1180
    //   57: invokespecial 529	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: astore_2
    //   61: getstatic 684	com/tencent/mm/plugin/vlog/model/local/a:GAu	Lcom/tencent/mm/plugin/vlog/model/local/a$b;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +34 -> 100
    //   69: aload_1
    //   70: invokevirtual 687	com/tencent/mm/plugin/vlog/model/local/a$b:fCb	()J
    //   73: invokestatic 367	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: astore_1
    //   77: ldc_w 524
    //   80: aload_2
    //   81: aload_1
    //   82: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 557	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc_w 1170
    //   94: invokestatic 301	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aconst_null
    //   101: astore_1
    //   102: goto -25 -> 77
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	a
    //   64	38	1	localObject1	Object
    //   105	4	1	localObject2	Object
    //   60	21	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	33	105	finally
    //   33	65	105	finally
    //   69	77	105	finally
    //   77	97	105	finally
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(190778);
      Log.i("MicroMsg.LocalEffectManager", "reset");
      EffectManager localEffectManager = GAw;
      if (localEffectManager != null) {
        localEffectManager.hiv();
      }
      GAy.clear();
      AppMethodBeat.o(190778);
      return;
    }
    finally {}
  }
  
  public final void unInit()
  {
    try
    {
      AppMethodBeat.i(190777);
      wKy.clear();
      Log.i("MicroMsg.LocalEffectManager", "clear");
      GAB.clear();
      EffectManager localEffectManager = GAw;
      if (localEffectManager != null) {
        localEffectManager.destroy();
      }
      GAw = null;
      GAu = null;
      f.BYo.BYa = null;
      GAx = null;
      com.tencent.mm.vfs.s.deleteDir(GAs);
      GAy.clear();
      if (GAA)
      {
        GlobalContextCreator.hir();
        GAA = false;
      }
      AppMethodBeat.o(190777);
      return;
    }
    finally {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "", "name", "", "order", "", "assetPath", "svgPath", "duration", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Ljava/lang/String;ILjava/lang/String;IJLcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getAssetPath", "()Ljava/lang/String;", "setAssetPath", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getSvgPath", "setSvgPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"})
  public static final class a
  {
    public int GAE;
    com.tencent.mm.xeffect.effect.ad GAn;
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
      AppMethodBeat.i(190734);
      this.name = paramString1;
      this.order = paramInt1;
      this.assetPath = paramString2;
      this.GAE = paramInt2;
      this.duration = paramLong;
      this.GAn = null;
      AppMethodBeat.o(190734);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(190738);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.j(this.name, paramObject.name)) || (this.order != paramObject.order) || (!p.j(this.assetPath, paramObject.assetPath)) || (this.GAE != paramObject.GAE) || (this.duration != paramObject.duration) || (!p.j(this.GAn, paramObject.GAn))) {}
        }
      }
      else
      {
        AppMethodBeat.o(190738);
        return true;
      }
      AppMethodBeat.o(190738);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(190737);
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
        int n = this.GAE;
        long l = this.duration;
        int i1 = (int)(l ^ l >>> 32);
        localObject = this.GAn;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(190737);
        return (((j + (i * 31 + m) * 31) * 31 + n) * 31 + i1) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(190736);
      String str = "TransEffectInfo(name=" + this.name + ", order=" + this.order + ", assetPath=" + this.assetPath + ", svgPath=" + this.GAE + ", duration=" + this.duration + ", effect=" + this.GAn + ")";
      AppMethodBeat.o(190736);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "currentScene", "", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;I)V", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "effectId", "", "getEffectId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class b
  {
    int GAF;
    n GzV = null;
    
    private b(int paramInt)
    {
      this.GAF = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(190742);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.GzV, paramObject.GzV)) || (this.GAF != paramObject.GAF)) {}
        }
      }
      else
      {
        AppMethodBeat.o(190742);
        return true;
      }
      AppMethodBeat.o(190742);
      return false;
    }
    
    public final long fCb()
    {
      n localn = this.GzV;
      if (localn != null) {
        return localn.id;
      }
      return 0L;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(190741);
      n localn = this.GzV;
      if (localn != null) {}
      for (int i = localn.hashCode();; i = 0)
      {
        int j = this.GAF;
        AppMethodBeat.o(190741);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(190740);
      String str = "VideoEnhancementEffectInfo(effect=" + this.GzV + ", currentScene=" + this.GAF + ")";
      AppMethodBeat.o(190740);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "", "path", "", "musicPath", "size", "Landroid/util/Size;", "duration", "", "imageNums", "", "effectId", "trackCropToTemplateSize", "", "name", "icon", "templateEffectRangeId", "replacementInfo", "", "Landroid/util/Pair;", "(Ljava/lang/String;Ljava/lang/String;Landroid/util/Size;JIJZLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "getIcon", "()Ljava/lang/String;", "getImageNums", "()I", "setImageNums", "(I)V", "getMusicPath", "setMusicPath", "(Ljava/lang/String;)V", "getName", "getPath", "getReplacementInfo", "()Ljava/util/List;", "setReplacementInfo", "(Ljava/util/List;)V", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "getTemplateEffectRangeId", "setTemplateEffectRangeId", "getTrackCropToTemplateSize", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-vlog_release"})
  public static final class c
  {
    public Size ApT;
    private int GAG;
    public final boolean GAH;
    public long GAI;
    List<Pair<Long, Long>> GAJ;
    public long duration;
    public final String icon;
    public String iiv;
    public final String name;
    public final String path;
    private final long wKD;
    
    private c(String paramString1, String paramString2, Size paramSize, long paramLong1, int paramInt, boolean paramBoolean, String paramString3, String paramString4, long paramLong2, List<Pair<Long, Long>> paramList)
    {
      AppMethodBeat.i(190743);
      this.path = paramString1;
      this.iiv = paramString2;
      this.ApT = paramSize;
      this.duration = paramLong1;
      this.GAG = paramInt;
      this.wKD = 0L;
      this.GAH = paramBoolean;
      this.name = paramString3;
      this.icon = paramString4;
      this.GAI = -1L;
      this.GAJ = paramList;
      AppMethodBeat.o(190743);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(190747);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.j(this.path, paramObject.path)) || (!p.j(this.iiv, paramObject.iiv)) || (!p.j(this.ApT, paramObject.ApT)) || (this.duration != paramObject.duration) || (this.GAG != paramObject.GAG) || (this.wKD != paramObject.wKD) || (this.GAH != paramObject.GAH) || (!p.j(this.name, paramObject.name)) || (!p.j(this.icon, paramObject.icon)) || (this.GAI != paramObject.GAI) || (!p.j(this.GAJ, paramObject.GAJ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(190747);
        return true;
      }
      AppMethodBeat.o(190747);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(190745);
      String str = "VideoTemplateInfo(path=" + this.path + ", musicPath=" + this.iiv + ", size=" + this.ApT + ", duration=" + this.duration + ", imageNums=" + this.GAG + ", effectId=" + this.wKD + ", trackCropToTemplateSize=" + this.GAH + ", name=" + this.name + ", icon=" + this.icon + ", templateEffectRangeId=" + this.GAI + ", replacementInfo=" + this.GAJ + ")";
      AppMethodBeat.o(190745);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final d GAK;
    
    static
    {
      AppMethodBeat.i(190749);
      GAK = new d();
      AppMethodBeat.o(190749);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(190750);
      int i = kotlin.b.a.a((Comparable)((Pair)paramT1).first, (Comparable)((Pair)paramT2).first);
      AppMethodBeat.o(190750);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class f
    extends q
    implements m<Long, Bitmap, x>
  {
    f(com.tencent.mm.plugin.vlog.model.ad paramad, z.f paramf, Object paramObject)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(190752);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((a.a)paramT1).order), (Comparable)Integer.valueOf(((a.a)paramT2).order));
      AppMethodBeat.o(190752);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final h GAM;
    
    static
    {
      AppMethodBeat.i(190754);
      GAM = new h();
      AppMethodBeat.o(190754);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/model/local/LocalEffectManager$setVideoEnhancement$1$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"})
  public static final class i
    implements com.tencent.mm.videocomposition.b.e
  {
    private String GAN = "";
    
    i(boolean paramBoolean, ac paramac) {}
    
    public final void KM(long paramLong)
    {
      String str = null;
      AppMethodBeat.i(190755);
      Object localObject = a.GAD;
      localObject = a.fBO();
      com.tencent.mm.plugin.vlog.model.ad localad;
      if (localObject != null)
      {
        localObject = ((a.b)localObject).GzV;
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
        if ((p.j(localObject, this.GAN) ^ true))
        {
          localObject = a.GAD;
          localObject = str;
          if (localad != null) {
            localObject = localad.path;
          }
          int i = a.aUc((String)localObject);
          localObject = a.GAD;
          if (a.fBU().contains(Integer.valueOf(i)))
          {
            localObject = a.GAD;
            a.acA(i);
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
          this.GAN = ((String)localObject);
        }
        AppMethodBeat.o(190755);
        return;
        localObject = null;
        break;
      }
    }
    
    public final void onRelease() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    public static final j GAP;
    
    static
    {
      AppMethodBeat.i(190757);
      GAP = new j();
      AppMethodBeat.o(190757);
    }
    
    public final void run()
    {
      AppMethodBeat.i(190756);
      Object localObject = c.ilt;
      localObject = c.a.aNa();
      if (p.j(((c.b)localObject).ilv, EGL14.EGL_NO_CONTEXT))
      {
        Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, create EGLContext failed");
        AppMethodBeat.o(190756);
        return;
      }
      a locala = a.GAD;
      a.fBX();
      if ((p.j(((c.b)localObject).eglSurface, EGL14.EGL_NO_SURFACE) ^ true)) {
        EGL14.eglDestroySurface(((c.b)localObject).ilu, ((c.b)localObject).eglSurface);
      }
      EGL14.eglDestroyContext(((c.b)localObject).ilu, ((c.b)localObject).ilv);
      AppMethodBeat.o(190756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.local.a
 * JD-Core Version:    0.7.0.1
 */
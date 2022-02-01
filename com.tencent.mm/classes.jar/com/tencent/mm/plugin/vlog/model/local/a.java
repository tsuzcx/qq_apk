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
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.recordvideo.res.f;
import com.tencent.mm.plugin.recordvideo.res.g;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.xlabeffect.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.y;
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
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager;", "", "()V", "ImageEnhancementResultImageSavePath", "", "getImageEnhancementResultImageSavePath", "()Ljava/lang/String;", "ImageEnhancementResultPathMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getImageEnhancementResultPathMap", "()Ljava/util/HashMap;", "setImageEnhancementResultPathMap", "(Ljava/util/HashMap;)V", "ImageEnhancementSceneValues", "", "", "getImageEnhancementSceneValues", "()Ljava/util/List;", "TAG", "TEMPLATE_CONFIG", "TEMPLATE_PATH", "TransEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "getTransEffectList", "()Ljava/util/LinkedList;", "TransEffectTime", "", "VideoTemplateList", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "getVideoTemplateList", "value", "Landroid/util/Pair;", "VideoTrackLabel", "getVideoTrackLabel", "setVideoTrackLabel", "currentVideoTemplate", "getCurrentVideoTemplate", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "setCurrentVideoTemplate", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;)V", "globalContextCreated", "", "transitionReady", "transitionResMap", "", "transitionView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "getTransitionView", "()Ljava/lang/ref/WeakReference;", "setTransitionView", "(Ljava/lang/ref/WeakReference;)V", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getVLogEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "setVLogEffectMgr", "(Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "videoEnhancementEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "getVideoEnhancementEffectInfo", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "setVideoEnhancementEffectInfo", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;)V", "applyTransition", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trans", "applyTransitionToAll", "trackList", "order", "checkCreateTransEffect", "transEffectInfo", "checkRefreshView", "generateTemplateEffectTrack", "template", "sourceTrackList", "getImageEnhancementBitmap", "Landroid/graphics/Bitmap;", "path", "getLabel", "getLocalPath", "assetsPath", "init", "instance", "initTransEffect", "initTransResource", "initVideoEnhancementEffect", "initVideoTemplates", "isSvrVideoEnhancementEnable", "isVideoEnhancementEnable", "removeVideoTemplate", "videoTemplate", "reset", "saveAllImageEnhancementResultImage", "pathList", "setTransition", "setVideoCompositionEnhancement", "videoComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "enable", "setVideoEnhancement", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVideoEnhancementScene", "scene", "setVideoEnhancementSceneFilterSettingsByJson", "json", "setVideoEnhancementShowFaceLandmarks", "show", "setVideoTemplate", "targets", "", "tryCreateX3DGlobalContext", "tryCreateX3DGlobalContextImpl", "unInit", "TransEffectInfo", "VideoEnhancementEffectInfo", "VideoTemplateInfo", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a UbD;
  private static final String UbE;
  private static final Map<String, Integer> UbF;
  private static final LinkedList<a> UbG;
  private static final LinkedList<c> UbH;
  private static b UbI;
  private static c UbJ;
  private static EffectManager UbK;
  private static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> UbL;
  private static HashMap<String, String> UbM;
  private static boolean UbN;
  private static boolean UbO;
  private static HashMap<String, Pair<Integer, Long>> UbP;
  private static final List<Integer> UbQ;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(283798);
    UbD = new a();
    UbE = s.X(com.tencent.mm.loader.i.b.bmr(), "image_enhancement_result");
    UbF = ak.e(new r[] { v.Y("diehua.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.diehua)), v.Y("shanhei.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.shanhei)), v.Y("shanbai.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.shanbai)), v.Y("zuoyi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.zuoyi)), v.Y("youyi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.youyi)), v.Y("shangyi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.shangyi)), v.Y("xiayi.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.xiayi)), v.Y("fangda.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.fangda)), v.Y("suoxiao.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.suoxiao)), v.Y("youzhuan.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.youzhuan)), v.Y("zuozhuan.svg", Integer.valueOf(com.tencent.mm.plugin.vlog.a.h.zuozhuan)) });
    UbG = new LinkedList();
    UbH = new LinkedList();
    UbM = new HashMap();
    UbP = new HashMap();
    n.a[] arrayOfa = n.a.values();
    Collection localCollection = (Collection)new ArrayList(arrayOfa.length);
    int j = arrayOfa.length;
    while (i < j)
    {
      localCollection.add(Integer.valueOf(arrayOfa[i].ordinal()));
      i += 1;
    }
    UbQ = (List)localCollection;
    AppMethodBeat.o(283798);
  }
  
  public static void W(List<ad> paramList, int paramInt)
  {
    AppMethodBeat.i(283626);
    s.u(paramList, "trackList");
    Iterator localIterator = ((Iterable)UbG).iterator();
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
      paramList = ((Iterable)p.ag(paramList, paramList.size() - 1)).iterator();
      while (paramList.hasNext()) {
        a((ad)paramList.next(), (a)localObject);
      }
      i = 0;
      break label57;
      label115:
      break;
      localObject = null;
    }
    AppMethodBeat.o(283626);
  }
  
  public static List<ad> a(c paramc, List<ad> paramList)
  {
    AppMethodBeat.i(283615);
    s.u(paramc, "template");
    s.u(paramList, "sourceTrackList");
    long l3 = Util.currentTicks();
    HashMap localHashMap = new HashMap();
    Object localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ad)((Iterator)localObject1).next();
      ((Map)localHashMap).put(((ad)localObject2).path, Long.valueOf(0L));
    }
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList((Collection)paramc.UbV);
    localObject1 = (List)localArrayList;
    if (((List)localObject1).size() > 1) {
      p.a((List)localObject1, (Comparator)new e());
    }
    localArrayList.set(localArrayList.size() - 1, Pair.create(((Pair)p.oM((List)localArrayList)).first, Long.valueOf(paramc.duration)));
    new HashMap();
    int n = localArrayList.size() - 1;
    int k;
    int m;
    Long localLong1;
    Long localLong2;
    long l1;
    long l2;
    Object localObject3;
    label322:
    int i1;
    if (n >= 0)
    {
      k = 0;
      m = k + 1;
      localLong1 = (Long)((Pair)localArrayList.get(k)).first;
      localLong2 = (Long)((Pair)localArrayList.get(k)).second;
      l1 = localLong2.longValue();
      s.s(localLong1, "replacementStart");
      l2 = l1 - localLong1.longValue();
      localObject1 = (ad)paramList.get(k % paramList.size());
      localObject3 = (Long)localHashMap.get(((ad)localObject1).path);
      if (localObject3 == null)
      {
        l1 = -1L;
        i1 = paramList.size() - 1;
        if (i1 < 0) {
          break label801;
        }
      }
    }
    int j;
    label390:
    label413:
    label685:
    label824:
    label1096:
    label1099:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject1 = (ad)paramList.get((i + k) % paramList.size());
      localObject3 = (Long)localHashMap.get(((ad)localObject1).path);
      if (localObject3 == null)
      {
        l1 = -1L;
        if ((l1 + l2 > ((ad)localObject1).getDurationMs()) && (((ad)localObject1).type != 1)) {
          break label795;
        }
        localObject3 = new ad(((ad)localObject1).path, ((ad)localObject1).type);
        if (((ad)localObject1).type != 1) {
          break label804;
        }
        ((ad)localObject3).wB(0L);
        ((ad)localObject3).wC(l2);
        ((ad)localObject3).UaI.UjZ = l2;
        label464:
        ((ad)localObject3).setStartTimeMs(localLong1.longValue());
        s.s(localLong2, "replacementEnd");
        ((ad)localObject3).wA(localLong2.longValue());
        ((ad)localObject3).UaC = ((ad)localObject1).UaC;
        ((ad)localObject3).UaD = ((ad)localObject1).UaD;
        ((ad)localObject3).UaE = ((ad)localObject1).UaE;
        ((ad)localObject3).UaI.agDA = false;
        ((ad)localObject3).UaF.yok.set(((ad)localObject1).UaF.yok);
        ((ad)localObject3).UaF.viewRect.set(((ad)localObject1).UaF.viewRect);
        ((ad)localObject3).UaF.Gl.set(((ad)localObject1).UaF.Gl);
        ((ad)localObject3).UaF.HLs = ((ad)localObject1).UaF.HLs;
        ((ad)localObject1).UaF.minScale *= 5.0F;
        ((ad)localObject1).UaF.maxScale *= 5.0F;
        ((ad)localObject3).UaF.matrix.set(((ad)localObject1).UaF.matrix);
        j = -1;
        Object localObject4 = (Iterable)paramc.UbV;
        i = 0;
        localObject4 = ((Iterable)localObject4).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label824;
        }
        Object localObject5 = ((Iterator)localObject4).next();
        if (i < 0) {
          p.kkW();
        }
        localObject5 = (Pair)localObject5;
        if ((!s.p(((Pair)localObject5).first, ((Pair)localArrayList.get(k)).first)) || (!s.p(((Pair)localObject5).second, ((Pair)localArrayList.get(k)).second))) {
          break label1096;
        }
        j = i;
      }
      for (;;)
      {
        i += 1;
        break label685;
        l1 = ((Long)localObject3).longValue();
        break label322;
        l1 = ((Long)localObject3).longValue();
        break label390;
        if (j <= i1) {
          break label1099;
        }
        break label413;
        ((ad)localObject3).wB(l1);
        ((ad)localObject3).wC(l1 + l2);
        break label464;
        Log.i("MicroMsg.LocalEffectManager", "add template track, time:[" + localLong1 + ", " + localLong2 + "], track time:[" + ((ad)localObject3).UaI.TDw + ", " + ((ad)localObject3).UaI.TDx + ", " + ((ad)localObject3).UaI.UjZ + "], path:" + ((ad)localObject1).path + ", originIndex:" + j);
        l2 = l1 + l2;
        l1 = l2;
        if (l2 >= ((ad)localObject1).getDurationMs()) {
          l1 = 0L;
        }
        ((Map)localHashMap).put(((ad)localObject1).path, Long.valueOf(l1));
        ((ArrayList)localObject2).add(localObject3);
        if (m > n)
        {
          Log.i("MicroMsg.LocalEffectManager", "finish generate template track name:" + paramc.name + ", result.size:" + ((ArrayList)localObject2).size() + ", replacementInfo:" + paramc.UbV + ", template.duration:" + paramc.duration + ", cost:" + Util.ticksToNow(l3));
          paramc = (List)localObject2;
          AppMethodBeat.o(283615);
          return paramc;
        }
        k = m;
        break;
      }
    }
  }
  
  public static void a(ad paramad, int paramInt)
  {
    AppMethodBeat.i(283632);
    s.u(paramad, "track");
    Iterator localIterator = ((Iterable)UbG).iterator();
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
      AppMethodBeat.o(283632);
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
    AppMethodBeat.i(283644);
    s.u(paramad, "track");
    EffectManager localEffectManager = UbK;
    if (localEffectManager != null) {
      localEffectManager.AT(paramad.hRg());
    }
    paramad.UaI.TDy.Uby = null;
    paramad.a(parama);
    AppMethodBeat.o(283644);
  }
  
  public static void a(c paramc, long[] paramArrayOfLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(283659);
    s.u(paramc, "videoTemplate");
    s.u(paramArrayOfLong, "targets");
    paramArrayOfLong = UbK;
    if (paramArrayOfLong != null) {
      paramArrayOfLong.jQl();
    }
    b(null, false);
    paramArrayOfLong = UbJ;
    if (paramArrayOfLong != null) {
      d(paramArrayOfLong);
    }
    paramArrayOfLong = UbK;
    Object localObject2;
    if (paramArrayOfLong == null)
    {
      paramArrayOfLong = null;
      if (paramArrayOfLong != null) {
        paramArrayOfLong.bL(0L, paramc.duration);
      }
      localObject2 = UbK;
      if (localObject2 != null) {
        ((EffectManager)localObject2).b(paramArrayOfLong);
      }
      if (paramArrayOfLong != null) {
        break label169;
      }
      label96:
      Log.i("MicroMsg.LocalEffectManager", s.X("setVideoTemplate: addEffect ", localObject1));
      if (paramArrayOfLong != null) {
        break label181;
      }
    }
    label169:
    label181:
    for (long l = 0L;; l = paramArrayOfLong.id)
    {
      paramc.UbU = l;
      UbJ = paramc;
      AppMethodBeat.o(283659);
      return;
      localObject2 = com.tencent.mm.xeffect.effect.j.agXQ;
      AssetManager localAssetManager = MMApplicationContext.getContext().getAssets();
      s.s(localAssetManager, "getContext().assets");
      paramArrayOfLong = paramArrayOfLong.a((com.tencent.mm.xeffect.effect.j)localObject2, localAssetManager, paramc.path);
      break;
      localObject1 = Long.valueOf(paramArrayOfLong.id);
      break label96;
    }
  }
  
  public static void a(com.tencent.mm.videocomposition.j paramj, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(283711);
    b localb = UbI;
    Object localObject3;
    if (localb != null)
    {
      if ((!paramBoolean) || (localb.Ubc != null)) {
        break label211;
      }
      localObject1 = UbK;
      if (localObject1 != null) {
        break label192;
      }
      localObject1 = null;
      localObject3 = UbK;
      if (localObject3 != null) {
        ((EffectManager)localObject3).b((af)localObject1);
      }
      if (!(localObject1 instanceof n)) {
        break label205;
      }
      localObject1 = (n)localObject1;
      label77:
      localb.Ubc = ((n)localObject1);
      label84:
      if (paramBoolean)
      {
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR.hTN();
        if (paramj != null) {
          paramj.a((com.tencent.mm.videocomposition.c.e)new i(paramj));
        }
      }
    }
    Object localObject1 = new StringBuilder("setVideoEnhancement enable:").append(paramBoolean).append(", effectId:");
    paramj = UbI;
    if (paramj == null)
    {
      paramj = null;
      label145:
      localObject1 = ((StringBuilder)localObject1).append(paramj).append(", rangeId:");
      paramj = UbI;
      if (paramj != null) {
        break label282;
      }
    }
    label262:
    label282:
    for (paramj = localObject2;; paramj = paramj.Ubc)
    {
      Log.i("MicroMsg.LocalEffectManager", paramj);
      AppMethodBeat.o(283711);
      return;
      label192:
      localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.agXY);
      break;
      label205:
      localObject1 = null;
      break label77;
      label211:
      if ((paramBoolean) || (localb.Ubc == null)) {
        break label84;
      }
      localObject1 = UbK;
      if (localObject1 != null)
      {
        localObject3 = localb.Ubc;
        if (localObject3 != null) {
          break label262;
        }
      }
      for (long l = 0L;; l = ((af)localObject3).id)
      {
        ((EffectManager)localObject1).AT(l);
        localb.Ubc = null;
        break;
      }
      paramj = Long.valueOf(paramj.gKE());
      break label145;
    }
  }
  
  public static void apA(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(283744);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.LocalEffectManager", s.X("setVideoEnhancementScene error:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(283744);
      return;
    }
    Object localObject = UbI;
    if (localObject != null)
    {
      if (((b)localObject).gKE() > 0L)
      {
        Log.i("MicroMsg.LocalEffectManager", "setVideoEnhancementScene, effectId:" + ((b)localObject).gKE() + ", scene:" + paramInt);
        n localn = ((b)localObject).Ubc;
        if (localn != null) {
          localn.setScene(paramInt);
        }
        ((b)localObject).DMu = paramInt;
      }
      if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) != 1) {
        break label178;
      }
    }
    for (;;)
    {
      localObject = UbI;
      if ((localObject != null) && (((b)localObject).gKE() > 0L))
      {
        Log.i("MicroMsg.LocalEffectManager", s.X("setVideoEnhancementShowFaceLandmarks, show:", Boolean.valueOf(bool)));
        localObject = ((b)localObject).Ubc;
        if (localObject != null) {
          ((n)localObject).Oo(bool);
        }
      }
      AppMethodBeat.o(283744);
      return;
      label178:
      bool = false;
    }
  }
  
  public static void b(ac paramac, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(283704);
    b localb = UbI;
    Object localObject3;
    if (localb != null)
    {
      if ((!paramBoolean) || (localb.Ubc != null)) {
        break label220;
      }
      localObject1 = UbK;
      if (localObject1 != null) {
        break label201;
      }
      localObject1 = null;
      localObject3 = UbK;
      if (localObject3 != null) {
        ((EffectManager)localObject3).b((af)localObject1);
      }
      if (!(localObject1 instanceof n)) {
        break label214;
      }
      localObject1 = (n)localObject1;
      label77:
      localb.Ubc = ((n)localObject1);
      label84:
      if (paramac != null) {
        paramac.Uay = paramBoolean;
      }
      if (paramBoolean)
      {
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR.hTN();
        if (paramac != null) {
          paramac.a((com.tencent.mm.videocomposition.c.e)new j(paramac));
        }
      }
    }
    Object localObject1 = new StringBuilder("setVideoEnhancement enable:").append(paramBoolean).append(", effectId:");
    paramac = UbI;
    if (paramac == null)
    {
      paramac = null;
      label154:
      localObject1 = ((StringBuilder)localObject1).append(paramac).append(", rangeId:");
      paramac = UbI;
      if (paramac != null) {
        break label291;
      }
    }
    label271:
    label291:
    for (paramac = localObject2;; paramac = paramac.Ubc)
    {
      Log.i("MicroMsg.LocalEffectManager", paramac);
      AppMethodBeat.o(283704);
      return;
      label201:
      localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.agXY);
      break;
      label214:
      localObject1 = null;
      break label77;
      label220:
      if ((paramBoolean) || (localb.Ubc == null)) {
        break label84;
      }
      localObject1 = UbK;
      if (localObject1 != null)
      {
        localObject3 = localb.Ubc;
        if (localObject3 != null) {
          break label271;
        }
      }
      for (long l = 0L;; l = ((af)localObject3).id)
      {
        ((EffectManager)localObject1).AT(l);
        localb.Ubc = null;
        break;
      }
      paramac = Long.valueOf(paramac.gKE());
      break label154;
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(283578);
    s.u(parama, "transEffectInfo");
    if (parama.Uby == null)
    {
      localObject = UbK;
      if (localObject != null) {
        break label42;
      }
    }
    label42:
    for (Object localObject = null;; localObject = ((EffectManager)localObject).a(com.tencent.mm.xeffect.effect.j.agXN, parama.assetPath))
    {
      parama.Uby = ((af)localObject);
      AppMethodBeat.o(283578);
      return;
    }
  }
  
  public static int bfg(String paramString)
  {
    AppMethodBeat.i(283511);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(283511);
      return -1;
    }
    paramString = (Pair)((Map)UbP).get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(283511);
      return -1;
    }
    paramString = (Integer)paramString.first;
    if (paramString == null)
    {
      AppMethodBeat.o(283511);
      return -1;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(283511);
    return i;
  }
  
  public static boolean bfh(String paramString)
  {
    AppMethodBeat.i(283754);
    s.u(paramString, "json");
    b localb = UbI;
    if ((localb != null) && (localb.gKE() > 0L))
    {
      n localn = localb.Ubc;
      if (localn != null) {
        localn.bEY(paramString);
      }
      Log.i("MicroMsg.LocalEffectManager", s.X("setImageEnhancementSceneFilterSettingsByJson:", paramString));
      Log.i("MicroMsg.LocalEffectManager", "setImageEnhancementSceneFilterSettingsByJson, ret:true, effectId:" + localb.gKE());
      AppMethodBeat.o(283754);
      return true;
    }
    AppMethodBeat.o(283754);
    return false;
  }
  
  /* Error */
  private static Bitmap bfi(String paramString)
  {
    // Byte code:
    //   0: ldc_w 839
    //   3: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 840
    //   10: invokestatic 340	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 4	java/lang/Object
    //   16: dup
    //   17: invokespecial 332	java/lang/Object:<init>	()V
    //   20: astore_2
    //   21: ldc_w 549
    //   24: ldc_w 842
    //   27: aload_0
    //   28: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokestatic 591	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: new 369	com/tencent/mm/plugin/vlog/model/ad
    //   37: dup
    //   38: aload_0
    //   39: iconst_1
    //   40: invokespecial 463	com/tencent/mm/plugin/vlog/model/ad:<init>	(Ljava/lang/String;I)V
    //   43: astore 4
    //   45: new 789	com/tencent/mm/plugin/vlog/model/ac
    //   48: dup
    //   49: aload 4
    //   51: invokestatic 846	kotlin/a/p:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   54: invokespecial 849	com/tencent/mm/plugin/vlog/model/ac:<init>	(Ljava/util/List;)V
    //   57: astore_3
    //   58: aload_3
    //   59: iconst_1
    //   60: invokestatic 647	com/tencent/mm/plugin/vlog/model/local/a:b	(Lcom/tencent/mm/plugin/vlog/model/ac;Z)V
    //   63: aload_0
    //   64: invokestatic 851	com/tencent/mm/plugin/vlog/model/local/a:bfg	(Ljava/lang/String;)I
    //   67: istore_1
    //   68: getstatic 331	com/tencent/mm/plugin/vlog/model/local/a:UbQ	Ljava/util/List;
    //   71: iload_1
    //   72: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokeinterface 854 2 0
    //   80: ifeq +7 -> 87
    //   83: iload_1
    //   84: invokestatic 856	com/tencent/mm/plugin/vlog/model/local/a:apA	(I)V
    //   87: new 858	kotlin/g/b/ah$f
    //   90: dup
    //   91: invokespecial 859	kotlin/g/b/ah$f:<init>	()V
    //   94: astore_0
    //   95: aload_3
    //   96: getstatic 616	com/tencent/mm/plugin/vlog/model/local/a:UbK	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   99: invokevirtual 861	com/tencent/mm/plugin/vlog/model/ac:a	(Lcom/tencent/mm/xeffect/effect/EffectManager;)V
    //   102: getstatic 867	com/tencent/mm/videocomposition/a:agDr	Lcom/tencent/mm/videocomposition/a$a;
    //   105: astore 5
    //   107: aload_3
    //   108: invokevirtual 871	com/tencent/mm/plugin/vlog/model/ac:getComposition	()Lcom/tencent/mm/videocomposition/j;
    //   111: invokestatic 876	com/tencent/mm/videocomposition/a$a:e	(Lcom/tencent/mm/videocomposition/j;)Lcom/tencent/mm/videocomposition/a;
    //   114: astore 5
    //   116: aload 5
    //   118: aload 4
    //   120: getfield 474	com/tencent/mm/plugin/vlog/model/ad:UaI	Lcom/tencent/mm/videocomposition/b;
    //   123: getfield 877	com/tencent/mm/videocomposition/b:UaC	I
    //   126: aload 4
    //   128: getfield 474	com/tencent/mm/plugin/vlog/model/ad:UaI	Lcom/tencent/mm/videocomposition/b;
    //   131: getfield 878	com/tencent/mm/videocomposition/b:UaD	I
    //   134: invokevirtual 882	com/tencent/mm/videocomposition/a:setSize	(II)V
    //   137: aload 5
    //   139: ldc2_w 883
    //   142: invokestatic 393	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   145: invokestatic 846	kotlin/a/p:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   148: new 886	com/tencent/mm/plugin/vlog/model/local/a$f
    //   151: dup
    //   152: aload 4
    //   154: aload_0
    //   155: aload_2
    //   156: invokespecial 889	com/tencent/mm/plugin/vlog/model/local/a$f:<init>	(Lcom/tencent/mm/plugin/vlog/model/ad;Lkotlin/g/b/ah$f;Ljava/lang/Object;)V
    //   159: checkcast 891	kotlin/g/a/m
    //   162: invokevirtual 894	com/tencent/mm/videocomposition/a:b	(Ljava/util/List;Lkotlin/g/a/m;)V
    //   165: aload_2
    //   166: monitorenter
    //   167: aload_2
    //   168: invokevirtual 897	java/lang/Object:wait	()V
    //   171: getstatic 903	kotlin/ah:aiuX	Lkotlin/ah;
    //   174: astore 4
    //   176: aload_2
    //   177: monitorexit
    //   178: aload_3
    //   179: iconst_0
    //   180: invokestatic 647	com/tencent/mm/plugin/vlog/model/local/a:b	(Lcom/tencent/mm/plugin/vlog/model/ac;Z)V
    //   183: aload_0
    //   184: getfield 906	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   187: checkcast 908	android/graphics/Bitmap
    //   190: astore_0
    //   191: ldc_w 839
    //   194: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_0
    //   198: areturn
    //   199: astore_2
    //   200: ldc_w 549
    //   203: new 551	java/lang/StringBuilder
    //   206: dup
    //   207: ldc_w 910
    //   210: invokespecial 556	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload_0
    //   214: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 912
    //   220: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_2
    //   224: invokevirtual 915	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   227: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 586	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 751	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: ldc_w 839
    //   239: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aconst_null
    //   243: areturn
    //   244: astore 4
    //   246: ldc_w 549
    //   249: aload 4
    //   251: checkcast 917	java/lang/Throwable
    //   254: ldc_w 918
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 922	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: goto -93 -> 171
    //   267: astore_0
    //   268: aload_2
    //   269: monitorexit
    //   270: ldc_w 839
    //   273: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_0
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramString	String
    //   67	17	1	i	int
    //   20	157	2	localObject1	Object
    //   199	70	2	localException1	java.lang.Exception
    //   57	122	3	localac	ac
    //   43	132	4	localObject2	Object
    //   244	6	4	localException2	java.lang.Exception
    //   105	33	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   34	45	199	java/lang/Exception
    //   167	171	244	java/lang/Exception
    //   167	171	267	finally
    //   171	176	267	finally
    //   246	264	267	finally
  }
  
  public static void d(c paramc)
  {
    AppMethodBeat.i(283675);
    if (paramc == null) {}
    for (paramc = null;; paramc = Long.valueOf(paramc.UbU))
    {
      Log.i("MicroMsg.LocalEffectManager", s.X("setVideoTemplate: remove  ", paramc));
      paramc = UbK;
      if (paramc != null) {
        paramc.b(com.tencent.mm.xeffect.effect.j.agXQ);
      }
      AppMethodBeat.o(283675);
      return;
    }
  }
  
  public static List<Integer> hRA()
  {
    return UbQ;
  }
  
  public static boolean hRB()
  {
    long l = -1L;
    Object localObject = UbI;
    if (localObject == null) {}
    while (l > 0L)
    {
      return true;
      localObject = ((b)localObject).Ubc;
      if (localObject != null) {
        l = ((af)localObject).id;
      }
    }
    return false;
  }
  
  public static boolean hRC()
  {
    AppMethodBeat.i(283732);
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
      AppMethodBeat.o(283732);
      return bool;
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zrS, 0) == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (i == 1)
    {
      AppMethodBeat.o(283732);
      return true;
    }
    AppMethodBeat.o(283732);
    return false;
  }
  
  public static void hRD()
  {
    AppMethodBeat.i(283781);
    Object localObject = new StringBuilder();
    d locald = d.XJR;
    localObject = ((StringBuilder)localObject).append(d.iFJ()).append('/');
    locald = d.XJR;
    localObject = d.iFO();
    if ((g.NRT.gJF()) && (!y.ZC((String)localObject)))
    {
      y.qn(g.NRT.getModelFilePath(), (String)localObject);
      Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, copy image label model path, from:" + g.NRT.getModelFilePath() + " to " + (String)localObject);
    }
    if (!y.ZC((String)localObject))
    {
      Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext model not exist!");
      AppMethodBeat.o(283781);
      return;
    }
    Log.i("MicroMsg.LocalEffectManager", "start tryCreateX3DGlobalContext");
    Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext finish");
    AppMethodBeat.o(283781);
  }
  
  public static void hRE()
  {
    AppMethodBeat.i(283784);
    com.tencent.threadpool.h.ahAA.bm(a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(283784);
  }
  
  private static final void hRF()
  {
    AppMethodBeat.i(283788);
    c.b localb = com.tencent.mm.media.util.c.a.a(com.tencent.mm.media.util.c.nFs);
    if (s.p(localb.eXL, EGL14.EGL_NO_CONTEXT))
    {
      Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, create EGLContext failed");
      AppMethodBeat.o(283788);
      return;
    }
    hRD();
    if (!s.p(localb.eglSurface, EGL14.EGL_NO_SURFACE)) {
      EGL14.eglDestroySurface(localb.nFB, localb.eglSurface);
    }
    EGL14.eglDestroyContext(localb.nFB, localb.eXL);
    AppMethodBeat.o(283788);
  }
  
  public static LinkedList<a> hRr()
  {
    return UbG;
  }
  
  public static LinkedList<c> hRs()
  {
    return UbH;
  }
  
  public static b hRt()
  {
    return UbI;
  }
  
  public static EffectManager hRu()
  {
    return UbK;
  }
  
  public static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> hRv()
  {
    return UbL;
  }
  
  public static HashMap<String, String> hRw()
  {
    return UbM;
  }
  
  public static HashMap<String, Pair<Integer, Long>> hRx()
  {
    return UbP;
  }
  
  private static void hRy()
  {
    AppMethodBeat.i(283541);
    Log.i("MicroMsg.LocalEffectManager", "initTransResource: transition res " + f.NRS.NRG + '}');
    if (f.NRS.NRG)
    {
      hRz();
      AppMethodBeat.o(283541);
      return;
    }
    f.NRS.NRH = ((kotlin.g.a.a)h.UbY);
    AppMethodBeat.o(283541);
  }
  
  private static void hRz()
  {
    AppMethodBeat.i(283564);
    UbN = true;
    Object localObject1 = f.NRS.gJs();
    label246:
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = f.NRS.gJv();
        s.checkNotNull(localJSONArray);
        UbG.clear();
        int k = localJSONArray.length();
        int j;
        Object localObject2;
        if (k > 0)
        {
          i = 0;
          j = i + 1;
          Object localObject3 = localJSONArray.optJSONObject(i);
          String str1 = ((JSONObject)localObject3).optString("name");
          String str2 = ((JSONObject)localObject3).getString("pag");
          localObject2 = (Integer)UbF.get(((JSONObject)localObject3).getString("svg"));
          int m = ((JSONObject)localObject3).getInt("order");
          localObject3 = s.X((String)localObject1, str2);
          if (localObject2 == null)
          {
            i = -1;
            localObject2 = UbG;
            s.s(str1, "transEffectName");
            ((LinkedList)localObject2).add(new a(str1, m, (String)localObject3, i, 500L, 32));
            if (j < k) {
              break label246;
            }
          }
        }
        else
        {
          localObject1 = (List)UbG;
          if (((List)localObject1).size() > 1) {
            p.a((List)localObject1, (Comparator)new g());
          }
          AppMethodBeat.o(283564);
          return;
        }
        int i = ((Integer)localObject2).intValue();
        continue;
        i = j;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.LocalEffectManager", (Throwable)localJSONException, "Cannot load transEffect config", new Object[0]);
        AppMethodBeat.o(283564);
        return;
      }
    }
  }
  
  public static void j(WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> paramWeakReference)
  {
    UbL = paramWeakReference;
  }
  
  public static void lK(List<String> paramList)
  {
    AppMethodBeat.i(283776);
    s.u(paramList, "pathList");
    UbM.clear();
    Object localObject = com.tencent.mm.videocomposition.e.agDJ;
    int i = com.tencent.mm.videocomposition.e.jLS();
    localObject = com.tencent.mm.videocomposition.e.agDJ;
    com.tencent.mm.videocomposition.e.aFO(2000);
    com.tencent.mm.videocomposition.e.agDJ.clear();
    localObject = ((Iterable)paramList).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      Bitmap localBitmap = bfi(str1);
      if (localBitmap != null)
      {
        String str2 = UbE + '/' + Util.currentTicks();
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, str2, false);
        ((Map)UbM).put(str1, str2);
        Log.i("MicroMsg.LocalEffectManager", "save enhancement image result in " + str2 + ", origin:" + str1);
        if (UbM.size() == paramList.size()) {
          Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish");
        }
      }
    }
    paramList = com.tencent.mm.videocomposition.e.agDJ;
    com.tencent.mm.videocomposition.e.aFO(i);
    Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish return");
    AppMethodBeat.o(283776);
  }
  
  public static void v(HashMap<String, Pair<Integer, Long>> paramHashMap)
  {
    AppMethodBeat.i(283494);
    s.u(paramHashMap, "value");
    if (!((Map)paramHashMap).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        UbP.clear();
        UbP.putAll((Map)paramHashMap);
      }
      AppMethodBeat.o(283494);
      return;
    }
  }
  
  /* Error */
  public final void b(EffectManager paramEffectManager)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1258
    //   5: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 549
    //   11: ldc_w 1259
    //   14: invokestatic 591	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 616	com/tencent/mm/plugin/vlog/model/local/a:UbK	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   20: ifnonnull +24 -> 44
    //   23: aload_1
    //   24: astore 13
    //   26: aload_1
    //   27: ifnonnull +12 -> 39
    //   30: new 621	com/tencent/mm/xeffect/effect/EffectManager
    //   33: dup
    //   34: invokespecial 1260	com/tencent/mm/xeffect/effect/EffectManager:<init>	()V
    //   37: astore 13
    //   39: aload 13
    //   41: putstatic 616	com/tencent/mm/plugin/vlog/model/local/a:UbK	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   44: invokestatic 1088	com/tencent/mm/plugin/vlog/model/local/a:hRy	()V
    //   47: invokestatic 1265	com/tencent/mm/plugin/vlog/model/w:hQN	()Z
    //   50: ifeq +746 -> 796
    //   53: new 302	java/util/HashMap
    //   56: dup
    //   57: invokespecial 303	java/util/HashMap:<init>	()V
    //   60: astore 16
    //   62: invokestatic 679	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   65: invokevirtual 685	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   68: ldc_w 1267
    //   71: invokevirtual 1273	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   74: astore_1
    //   75: aload_1
    //   76: ldc_w 1275
    //   79: invokestatic 448	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokestatic 1279	com/tencent/mm/sdk/platformtools/Util:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   86: astore_1
    //   87: ldc_w 549
    //   90: ldc_w 1281
    //   93: aload_1
    //   94: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokestatic 591	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: new 1177	org/json/JSONObject
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 1282	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   108: ldc_w 1284
    //   111: invokevirtual 1288	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   114: astore 17
    //   116: aload 17
    //   118: invokevirtual 1170	org/json/JSONArray:length	()I
    //   121: istore 6
    //   123: iload 6
    //   125: ifle +453 -> 578
    //   128: iconst_0
    //   129: istore_2
    //   130: iload_2
    //   131: iconst_1
    //   132: iadd
    //   133: istore 5
    //   135: aload 17
    //   137: iload_2
    //   138: invokevirtual 1291	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   141: astore_1
    //   142: aload_1
    //   143: ldc_w 1175
    //   146: invokevirtual 1181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 18
    //   151: ldc_w 1293
    //   154: aload_1
    //   155: ldc_w 1183
    //   158: invokevirtual 1181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   164: astore 19
    //   166: ldc_w 1293
    //   169: aload_1
    //   170: ldc_w 1295
    //   173: invokevirtual 1181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   179: astore 15
    //   181: ldc_w 1293
    //   184: aload_1
    //   185: ldc_w 1297
    //   188: invokevirtual 1181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   194: astore 20
    //   196: getstatic 616	com/tencent/mm/plugin/vlog/model/local/a:UbK	Lcom/tencent/mm/xeffect/effect/EffectManager;
    //   199: astore_1
    //   200: aload_1
    //   201: ifnonnull +465 -> 666
    //   204: aconst_null
    //   205: astore 14
    //   207: aload 14
    //   209: instanceof 1299
    //   212: ifeq +690 -> 902
    //   215: aload 14
    //   217: checkcast 1299	com/tencent/mm/xeffect/effect/w
    //   220: astore_1
    //   221: goto +644 -> 865
    //   224: aload_1
    //   225: astore 13
    //   227: aload_1
    //   228: ifnonnull +14 -> 242
    //   231: new 1301	android/util/Size
    //   234: dup
    //   235: iconst_0
    //   236: iconst_0
    //   237: invokespecial 1303	android/util/Size:<init>	(II)V
    //   240: astore 13
    //   242: aload 14
    //   244: instanceof 1299
    //   247: ifeq +660 -> 907
    //   250: aload 14
    //   252: checkcast 1299	com/tencent/mm/xeffect/effect/w
    //   255: astore_1
    //   256: goto +618 -> 874
    //   259: aload 14
    //   261: instanceof 1299
    //   264: ifeq +648 -> 912
    //   267: aload 14
    //   269: checkcast 1299	com/tencent/mm/xeffect/effect/w
    //   272: astore_1
    //   273: goto +610 -> 883
    //   276: aload 14
    //   278: instanceof 1299
    //   281: ifeq +636 -> 917
    //   284: aload 14
    //   286: checkcast 1299	com/tencent/mm/xeffect/effect/w
    //   289: astore_1
    //   290: goto +603 -> 893
    //   293: aload_1
    //   294: astore 14
    //   296: aload_1
    //   297: ifnonnull +15 -> 312
    //   300: new 315	java/util/ArrayList
    //   303: dup
    //   304: invokespecial 398	java/util/ArrayList:<init>	()V
    //   307: checkcast 329	java/util/List
    //   310: astore 14
    //   312: lconst_0
    //   313: lstore 9
    //   315: aload 15
    //   317: checkcast 813	java/lang/CharSequence
    //   320: invokeinterface 1304 1 0
    //   325: ifle +410 -> 735
    //   328: iconst_1
    //   329: istore 4
    //   331: iload 4
    //   333: ifeq +526 -> 859
    //   336: new 551	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 971	java/lang/StringBuilder:<init>	()V
    //   343: invokestatic 203	com/tencent/mm/loader/i/b:bmr	()Ljava/lang/String;
    //   346: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 15
    //   351: invokevirtual 1307	java/lang/String:hashCode	()I
    //   354: invokevirtual 583	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: ldc_w 1309
    //   360: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 586	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: astore_1
    //   367: ldc_w 1311
    //   370: aload 15
    //   372: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   375: aload_1
    //   376: iconst_0
    //   377: invokestatic 1315	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   380: pop2
    //   381: new 1317	com/tencent/mm/compatible/i/d
    //   384: dup
    //   385: invokespecial 1318	com/tencent/mm/compatible/i/d:<init>	()V
    //   388: astore 15
    //   390: aload 15
    //   392: aload_1
    //   393: invokevirtual 1321	com/tencent/mm/compatible/i/d:setDataSource	(Ljava/lang/String;)V
    //   396: aload 15
    //   398: bipush 9
    //   400: invokevirtual 1325	com/tencent/mm/compatible/i/d:extractMetadata	(I)Ljava/lang/String;
    //   403: lconst_0
    //   404: invokestatic 1329	com/tencent/mm/sdk/platformtools/Util:getLong	(Ljava/lang/String;J)J
    //   407: lstore 11
    //   409: lload 11
    //   411: lstore 9
    //   413: aload 15
    //   415: invokevirtual 1332	com/tencent/mm/compatible/i/d:release	()V
    //   418: ldc_w 549
    //   421: ldc_w 1334
    //   424: aload 14
    //   426: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   429: invokestatic 591	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: ldc_w 549
    //   435: new 551	java/lang/StringBuilder
    //   438: dup
    //   439: ldc_w 1336
    //   442: invokespecial 556	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   445: aload 19
    //   447: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc_w 1338
    //   453: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 18
    //   458: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   461: ldc_w 1340
    //   464: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 13
    //   469: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: ldc_w 1342
    //   475: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload_3
    //   479: invokevirtual 583	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: ldc_w 1344
    //   485: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: lload 7
    //   490: invokevirtual 573	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   493: ldc_w 1346
    //   496: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 1348
    //   506: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: lload 9
    //   511: invokevirtual 573	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   514: invokevirtual 586	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 591	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload 18
    //   522: ldc_w 1350
    //   525: invokestatic 448	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   528: new 12	com/tencent/mm/plugin/vlog/model/local/a$c
    //   531: dup
    //   532: aload 19
    //   534: aload_1
    //   535: aload 13
    //   537: lload 9
    //   539: iload_3
    //   540: iconst_1
    //   541: aload 18
    //   543: aload 20
    //   545: lconst_0
    //   546: aload 14
    //   548: sipush 512
    //   551: invokespecial 1353	com/tencent/mm/plugin/vlog/model/local/a$c:<init>	(Ljava/lang/String;Ljava/lang/String;Landroid/util/Size;JIZLjava/lang/String;Ljava/lang/String;JLjava/util/List;I)V
    //   554: astore_1
    //   555: aload 16
    //   557: checkcast 386	java/util/Map
    //   560: iload_2
    //   561: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: aload_1
    //   565: invokeinterface 397 3 0
    //   570: pop
    //   571: iload 5
    //   573: iload 6
    //   575: if_icmplt +278 -> 853
    //   578: getstatic 300	com/tencent/mm/plugin/vlog/model/local/a:UbH	Ljava/util/LinkedList;
    //   581: invokevirtual 1165	java/util/LinkedList:clear	()V
    //   584: aload 16
    //   586: invokevirtual 1357	java/util/HashMap:keySet	()Ljava/util/Set;
    //   589: astore_1
    //   590: aload_1
    //   591: ldc_w 1359
    //   594: invokestatic 448	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   597: aload_1
    //   598: checkcast 342	java/lang/Iterable
    //   601: invokestatic 1363	kotlin/a/p:n	(Ljava/lang/Iterable;)Ljava/util/List;
    //   604: invokeinterface 1364 1 0
    //   609: astore_1
    //   610: aload_1
    //   611: invokeinterface 352 1 0
    //   616: ifeq +180 -> 796
    //   619: aload 16
    //   621: aload_1
    //   622: invokeinterface 356 1 0
    //   627: checkcast 1366	java/lang/Number
    //   630: invokevirtual 1367	java/lang/Number:intValue	()I
    //   633: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   636: invokevirtual 452	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   639: checkcast 12	com/tencent/mm/plugin/vlog/model/local/a$c
    //   642: astore 13
    //   644: aload 13
    //   646: ifnull -36 -> 610
    //   649: getstatic 300	com/tencent/mm/plugin/vlog/model/local/a:UbH	Ljava/util/LinkedList;
    //   652: aload 13
    //   654: invokevirtual 1199	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   657: pop
    //   658: goto -48 -> 610
    //   661: astore_1
    //   662: aload_0
    //   663: monitorexit
    //   664: aload_1
    //   665: athrow
    //   666: getstatic 673	com/tencent/mm/xeffect/effect/j:agXQ	Lcom/tencent/mm/xeffect/effect/j;
    //   669: astore 13
    //   671: invokestatic 679	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   674: invokevirtual 685	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   677: astore 14
    //   679: aload 14
    //   681: ldc_w 687
    //   684: invokestatic 448	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   687: aload_1
    //   688: aload 13
    //   690: aload 14
    //   692: aload 19
    //   694: invokevirtual 691	com/tencent/mm/xeffect/effect/EffectManager:a	(Lcom/tencent/mm/xeffect/effect/j;Landroid/content/res/AssetManager;Ljava/lang/String;)Lcom/tencent/mm/xeffect/effect/af;
    //   697: astore 14
    //   699: goto -492 -> 207
    //   702: aload_1
    //   703: getfield 1373	com/tencent/mm/xeffect/effect/t:Kz	Landroid/util/Size;
    //   706: astore_1
    //   707: goto -483 -> 224
    //   710: aload_1
    //   711: getfield 1376	com/tencent/mm/xeffect/effect/t:agYP	I
    //   714: istore_3
    //   715: goto -456 -> 259
    //   718: aload_1
    //   719: getfield 1379	com/tencent/mm/xeffect/effect/t:agYQ	J
    //   722: lstore 7
    //   724: goto -448 -> 276
    //   727: aload_1
    //   728: invokestatic 1382	com/tencent/mm/xeffect/effect/w:a	(Lcom/tencent/mm/xeffect/effect/w;)Ljava/util/List;
    //   731: astore_1
    //   732: goto -439 -> 293
    //   735: iconst_0
    //   736: istore 4
    //   738: goto -407 -> 331
    //   741: astore 21
    //   743: ldc_w 549
    //   746: aload 21
    //   748: checkcast 917	java/lang/Throwable
    //   751: ldc_w 1384
    //   754: iconst_0
    //   755: anewarray 4	java/lang/Object
    //   758: invokestatic 922	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   761: aload 15
    //   763: invokevirtual 1332	com/tencent/mm/compatible/i/d:release	()V
    //   766: goto -348 -> 418
    //   769: astore_1
    //   770: ldc_w 549
    //   773: ldc_w 1386
    //   776: invokestatic 751	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: goto -201 -> 578
    //   782: astore_1
    //   783: aload 15
    //   785: invokevirtual 1332	com/tencent/mm/compatible/i/d:release	()V
    //   788: ldc_w 1258
    //   791: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   794: aload_1
    //   795: athrow
    //   796: new 9	com/tencent/mm/plugin/vlog/model/local/a$b
    //   799: dup
    //   800: invokespecial 1387	com/tencent/mm/plugin/vlog/model/local/a$b:<init>	()V
    //   803: putstatic 702	com/tencent/mm/plugin/vlog/model/local/a:UbI	Lcom/tencent/mm/plugin/vlog/model/local/a$b;
    //   806: getstatic 702	com/tencent/mm/plugin/vlog/model/local/a:UbI	Lcom/tencent/mm/plugin/vlog/model/local/a$b;
    //   809: astore_1
    //   810: aload_1
    //   811: ifnonnull +27 -> 838
    //   814: aconst_null
    //   815: astore_1
    //   816: ldc_w 549
    //   819: ldc_w 1389
    //   822: aload_1
    //   823: invokestatic 211	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   826: invokestatic 591	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: ldc_w 1258
    //   832: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   835: aload_0
    //   836: monitorexit
    //   837: return
    //   838: aload_1
    //   839: invokevirtual 745	com/tencent/mm/plugin/vlog/model/local/a$b:gKE	()J
    //   842: lstore 7
    //   844: lload 7
    //   846: invokestatic 393	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   849: astore_1
    //   850: goto -34 -> 816
    //   853: iload 5
    //   855: istore_2
    //   856: goto -726 -> 130
    //   859: aload 15
    //   861: astore_1
    //   862: goto -444 -> 418
    //   865: aload_1
    //   866: ifnonnull -164 -> 702
    //   869: aconst_null
    //   870: astore_1
    //   871: goto -647 -> 224
    //   874: aload_1
    //   875: ifnonnull -165 -> 710
    //   878: iconst_0
    //   879: istore_3
    //   880: goto -621 -> 259
    //   883: aload_1
    //   884: ifnonnull -166 -> 718
    //   887: lconst_0
    //   888: lstore 7
    //   890: goto -614 -> 276
    //   893: aload_1
    //   894: ifnonnull -167 -> 727
    //   897: aconst_null
    //   898: astore_1
    //   899: goto -606 -> 293
    //   902: aconst_null
    //   903: astore_1
    //   904: goto -39 -> 865
    //   907: aconst_null
    //   908: astore_1
    //   909: goto -35 -> 874
    //   912: aconst_null
    //   913: astore_1
    //   914: goto -31 -> 883
    //   917: aconst_null
    //   918: astore_1
    //   919: goto -26 -> 893
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	922	0	this	a
    //   0	922	1	paramEffectManager	EffectManager
    //   129	727	2	i	int
    //   478	402	3	j	int
    //   329	408	4	k	int
    //   133	721	5	m	int
    //   121	455	6	n	int
    //   488	1	7	localObject1	Object
    //   722	167	7	l1	long
    //   313	225	9	l2	long
    //   407	3	11	l3	long
    //   24	665	13	localObject2	Object
    //   205	493	14	localObject3	Object
    //   179	681	15	localObject4	Object
    //   60	560	16	localHashMap	HashMap
    //   114	22	17	localJSONArray	JSONArray
    //   149	393	18	str1	String
    //   164	529	19	str2	String
    //   194	350	20	str3	String
    //   741	6	21	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	23	661	finally
    //   30	39	661	finally
    //   39	44	661	finally
    //   44	100	661	finally
    //   100	123	661	finally
    //   135	200	661	finally
    //   207	221	661	finally
    //   231	242	661	finally
    //   242	256	661	finally
    //   259	273	661	finally
    //   276	290	661	finally
    //   300	312	661	finally
    //   315	328	661	finally
    //   336	390	661	finally
    //   413	418	661	finally
    //   418	571	661	finally
    //   578	610	661	finally
    //   610	644	661	finally
    //   649	658	661	finally
    //   666	699	661	finally
    //   702	707	661	finally
    //   710	715	661	finally
    //   718	724	661	finally
    //   727	732	661	finally
    //   761	766	661	finally
    //   770	779	661	finally
    //   783	796	661	finally
    //   796	810	661	finally
    //   816	835	661	finally
    //   838	844	661	finally
    //   390	409	741	java/lang/Exception
    //   100	123	769	java/lang/Exception
    //   135	200	769	java/lang/Exception
    //   207	221	769	java/lang/Exception
    //   231	242	769	java/lang/Exception
    //   242	256	769	java/lang/Exception
    //   259	273	769	java/lang/Exception
    //   276	290	769	java/lang/Exception
    //   300	312	769	java/lang/Exception
    //   315	328	769	java/lang/Exception
    //   336	390	769	java/lang/Exception
    //   413	418	769	java/lang/Exception
    //   418	571	769	java/lang/Exception
    //   666	699	769	java/lang/Exception
    //   702	707	769	java/lang/Exception
    //   710	715	769	java/lang/Exception
    //   718	724	769	java/lang/Exception
    //   727	732	769	java/lang/Exception
    //   761	766	769	java/lang/Exception
    //   783	796	769	java/lang/Exception
    //   390	409	782	finally
    //   743	761	782	finally
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(283816);
      Log.i("MicroMsg.LocalEffectManager", "reset");
      EffectManager localEffectManager = UbK;
      if (localEffectManager != null) {
        localEffectManager.jQl();
      }
      UbM.clear();
      AppMethodBeat.o(283816);
      return;
    }
    finally {}
  }
  
  public final void unInit()
  {
    try
    {
      AppMethodBeat.i(283812);
      UbG.clear();
      Log.i("MicroMsg.LocalEffectManager", "clear");
      UbP.clear();
      EffectManager localEffectManager = UbK;
      if (localEffectManager != null) {
        localEffectManager.destroy();
      }
      UbK = null;
      UbI = null;
      f.NRS.NRH = null;
      UbL = null;
      y.ew(UbE, true);
      UbM.clear();
      if (UbO)
      {
        GlobalContextCreator.jQe();
        UbO = false;
      }
      AppMethodBeat.o(283812);
      return;
    }
    finally {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "", "name", "", "order", "", "assetPath", "svgPath", "duration", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Ljava/lang/String;ILjava/lang/String;IJLcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getAssetPath", "()Ljava/lang/String;", "setAssetPath", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getSvgPath", "setSvgPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public int UbR;
    af Uby;
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
      AppMethodBeat.i(283279);
      this.name = paramString1;
      this.order = paramInt1;
      this.assetPath = paramString2;
      this.UbR = paramInt2;
      this.duration = paramLong;
      this.Uby = null;
      AppMethodBeat.o(283279);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(283323);
      if (this == paramObject)
      {
        AppMethodBeat.o(283323);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(283323);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.name, paramObject.name))
      {
        AppMethodBeat.o(283323);
        return false;
      }
      if (this.order != paramObject.order)
      {
        AppMethodBeat.o(283323);
        return false;
      }
      if (!s.p(this.assetPath, paramObject.assetPath))
      {
        AppMethodBeat.o(283323);
        return false;
      }
      if (this.UbR != paramObject.UbR)
      {
        AppMethodBeat.o(283323);
        return false;
      }
      if (this.duration != paramObject.duration)
      {
        AppMethodBeat.o(283323);
        return false;
      }
      if (!s.p(this.Uby, paramObject.Uby))
      {
        AppMethodBeat.o(283323);
        return false;
      }
      AppMethodBeat.o(283323);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(283315);
      int j = this.name.hashCode();
      int k = this.order;
      int m = this.assetPath.hashCode();
      int n = this.UbR;
      int i1 = q.a..ExternalSyntheticBackport0.m(this.duration);
      if (this.Uby == null) {}
      for (int i = 0;; i = this.Uby.hashCode())
      {
        AppMethodBeat.o(283315);
        return i + ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(283304);
      String str = "TransEffectInfo(name=" + this.name + ", order=" + this.order + ", assetPath=" + this.assetPath + ", svgPath=" + this.UbR + ", duration=" + this.duration + ", effect=" + this.Uby + ')';
      AppMethodBeat.o(283304);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "currentScene", "", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;I)V", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "effectId", "", "getEffectId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    int DMu;
    n Ubc = null;
    
    private b(int paramInt)
    {
      this.DMu = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(283300);
      if (this == paramObject)
      {
        AppMethodBeat.o(283300);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(283300);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.Ubc, paramObject.Ubc))
      {
        AppMethodBeat.o(283300);
        return false;
      }
      if (this.DMu != paramObject.DMu)
      {
        AppMethodBeat.o(283300);
        return false;
      }
      AppMethodBeat.o(283300);
      return true;
    }
    
    public final long gKE()
    {
      n localn = this.Ubc;
      if (localn == null) {
        return 0L;
      }
      return localn.id;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(283292);
      if (this.Ubc == null) {}
      for (int i = 0;; i = this.Ubc.hashCode())
      {
        int j = this.DMu;
        AppMethodBeat.o(283292);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(283282);
      String str = "VideoEnhancementEffectInfo(effect=" + this.Ubc + ", currentScene=" + this.DMu + ')';
      AppMethodBeat.o(283282);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "", "path", "", "musicPath", "size", "Landroid/util/Size;", "duration", "", "imageNums", "", "effectId", "trackCropToTemplateSize", "", "name", "icon", "templateEffectRangeId", "replacementInfo", "", "Landroid/util/Pair;", "(Ljava/lang/String;Ljava/lang/String;Landroid/util/Size;JIJZLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "getIcon", "()Ljava/lang/String;", "getImageNums", "()I", "setImageNums", "(I)V", "getMusicPath", "setMusicPath", "(Ljava/lang/String;)V", "getName", "getPath", "getReplacementInfo", "()Ljava/util/List;", "setReplacementInfo", "(Ljava/util/List;)V", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "getTemplateEffectRangeId", "setTemplateEffectRangeId", "getTrackCropToTemplateSize", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public Size Kz;
    private final long NZm;
    private int UbS;
    public final boolean UbT;
    public long UbU;
    List<Pair<Long, Long>> UbV;
    public long duration;
    public final String icon;
    public String nBT;
    public final String name;
    public final String path;
    
    private c(String paramString1, String paramString2, Size paramSize, long paramLong1, int paramInt, boolean paramBoolean, String paramString3, String paramString4, long paramLong2, List<Pair<Long, Long>> paramList)
    {
      AppMethodBeat.i(283306);
      this.path = paramString1;
      this.nBT = paramString2;
      this.Kz = paramSize;
      this.duration = paramLong1;
      this.UbS = paramInt;
      this.NZm = 0L;
      this.UbT = paramBoolean;
      this.name = paramString3;
      this.icon = paramString4;
      this.UbU = paramLong2;
      this.UbV = paramList;
      AppMethodBeat.o(283306);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(283341);
      if (this == paramObject)
      {
        AppMethodBeat.o(283341);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(283341);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.path, paramObject.path))
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (!s.p(this.nBT, paramObject.nBT))
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (!s.p(this.Kz, paramObject.Kz))
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (this.duration != paramObject.duration)
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (this.UbS != paramObject.UbS)
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (this.NZm != paramObject.NZm)
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (this.UbT != paramObject.UbT)
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (!s.p(this.name, paramObject.name))
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (!s.p(this.icon, paramObject.icon))
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (this.UbU != paramObject.UbU)
      {
        AppMethodBeat.o(283341);
        return false;
      }
      if (!s.p(this.UbV, paramObject.UbV))
      {
        AppMethodBeat.o(283341);
        return false;
      }
      AppMethodBeat.o(283341);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(283327);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoTemplateInfo(path=").append(this.path).append(", musicPath=").append(this.nBT).append(", size=").append(this.Kz).append(", duration=").append(this.duration).append(", imageNums=").append(this.UbS).append(", effectId=").append(this.NZm).append(", trackCropToTemplateSize=").append(this.UbT).append(", name=").append(this.name).append(", icon=").append(this.icon).append(", templateEffectRangeId=").append(this.UbU).append(", replacementInfo=").append(this.UbV).append(')');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(283327);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class e<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(283319);
      int i = kotlin.b.a.b((Comparable)((Pair)paramT1).first, (Comparable)((Pair)paramT2).first);
      AppMethodBeat.o(283319);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class g<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(283324);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((a.a)paramT1).order), (Comparable)Integer.valueOf(((a.a)paramT2).order));
      AppMethodBeat.o(283324);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final h UbY;
    
    static
    {
      AppMethodBeat.i(283317);
      UbY = new h();
      AppMethodBeat.o(283317);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/model/local/LocalEffectManager$setVideoCompositionEnhancement$1$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.mm.videocomposition.c.e
  {
    private String UbZ = "";
    
    i(com.tencent.mm.videocomposition.j paramj) {}
    
    public final void onRelease() {}
    
    public final void wx(long paramLong)
    {
      String str = null;
      AppMethodBeat.i(283342);
      Object localObject1 = a.UbD;
      localObject1 = a.hRt();
      Object localObject2;
      label48:
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        label141:
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)this.Uca.TDz).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label212;
          }
          localObject1 = ((Iterator)localObject2).next();
          com.tencent.mm.videocomposition.b localb = (com.tencent.mm.videocomposition.b)localObject1;
          if ((localb.startTimeMs > paramLong) || (localb.endTimeMs <= paramLong)) {
            break label207;
          }
          i = 1;
          label96:
          if (i == 0) {
            break label210;
          }
          label100:
          localObject2 = (com.tencent.mm.videocomposition.b)localObject1;
          if (localObject2 != null) {
            break label218;
          }
          localObject1 = null;
          label115:
          if (!s.p(localObject1, this.UbZ))
          {
            localObject1 = a.UbD;
            if (localObject2 != null) {
              break label228;
            }
            localObject1 = str;
            i = a.bfg((String)localObject1);
            localObject1 = a.UbD;
            if (a.hRA().contains(Integer.valueOf(i)))
            {
              localObject1 = a.UbD;
              a.apA(i);
            }
            if (localObject2 != null) {
              break label238;
            }
            localObject1 = "";
          }
        }
      }
      for (;;)
      {
        this.UbZ = ((String)localObject1);
        AppMethodBeat.o(283342);
        return;
        localObject1 = ((a.b)localObject1).Ubc;
        break;
        label207:
        i = 0;
        break label96;
        label210:
        break label48;
        label212:
        localObject1 = null;
        break label100;
        label218:
        localObject1 = ((com.tencent.mm.videocomposition.b)localObject2).path;
        break label115;
        label228:
        localObject1 = ((com.tencent.mm.videocomposition.b)localObject2).path;
        break label141;
        label238:
        str = ((com.tencent.mm.videocomposition.b)localObject2).path;
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/model/local/LocalEffectManager$setVideoEnhancement$1$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.videocomposition.c.e
  {
    private String UbZ = "";
    
    j(ac paramac) {}
    
    public final void onRelease() {}
    
    public final void wx(long paramLong)
    {
      String str = null;
      AppMethodBeat.i(283334);
      Object localObject = a.UbD;
      localObject = a.hRt();
      ad localad;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null)
        {
          localad = com.tencent.mm.plugin.vlog.model.h.a(this.TYr, paramLong);
          if (localad != null) {
            break label141;
          }
          localObject = null;
          label49:
          if (!s.p(localObject, this.UbZ))
          {
            localObject = a.UbD;
            if (localad != null) {
              break label151;
            }
            localObject = str;
            label75:
            int i = a.bfg((String)localObject);
            localObject = a.UbD;
            if (a.hRA().contains(Integer.valueOf(i)))
            {
              localObject = a.UbD;
              a.apA(i);
            }
            if (localad != null) {
              break label161;
            }
            localObject = "";
          }
        }
      }
      for (;;)
      {
        this.UbZ = ((String)localObject);
        AppMethodBeat.o(283334);
        return;
        localObject = ((a.b)localObject).Ubc;
        break;
        label141:
        localObject = localad.path;
        break label49;
        label151:
        localObject = localad.path;
        break label75;
        label161:
        str = localad.path;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.local.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.vlog.model.local;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.res.f;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.xeffect.VLogEffectMgr;
import com.tencent.mm.xeffect.VLogEffectMgr.a;
import d.a.ae;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.u;
import d.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager;", "", "()V", "TAG", "", "TEMPLATE_CONFIG", "TEMPLATE_PATH", "TransEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "getTransEffectList", "()Ljava/util/LinkedList;", "TransEffectTime", "", "VideoTemplateList", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "getVideoTemplateList", "currentVideoTemplate", "getCurrentVideoTemplate", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "setCurrentVideoTemplate", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;)V", "transitionReady", "", "transitionResMap", "", "", "transitionView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "getTransitionView", "()Ljava/lang/ref/WeakReference;", "setTransitionView", "(Ljava/lang/ref/WeakReference;)V", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "getVLogEffectMgr", "()Lcom/tencent/mm/xeffect/VLogEffectMgr;", "setVLogEffectMgr", "(Lcom/tencent/mm/xeffect/VLogEffectMgr;)V", "videoEnhancementEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "getVideoEnhancementEffectInfo", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "setVideoEnhancementEffectInfo", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;)V", "applyTransitionToAll", "", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "effectId", "checkCreateTransEffect", "transEffectInfo", "checkRefreshView", "generateTemplateEffectTrack", "template", "sourceTrackList", "getLocalPath", "assetsPath", "init", "initTransEffect", "initTransResource", "initVideoEnhancementEffect", "initVideoTemplates", "removeVideoTemplate", "videoTemplate", "reset", "setTransition", "track", "setVideoEnhancement", "startMs", "endMs", "enable", "setVideoTemplate", "targets", "", "unInit", "MusicInfo", "TransEffectInfo", "VideoEnhancementEffectInfo", "VideoTemplateInfo", "plugin-vlog_release"})
public final class a
{
  private static final Map<String, Integer> BHm;
  private static final LinkedList<a> BHn;
  private static final LinkedList<c> BHo;
  private static b BHp;
  public static c BHq;
  public static VLogEffectMgr BHr;
  private static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> BHs;
  private static boolean BHt;
  public static final a BHu;
  
  static
  {
    AppMethodBeat.i(195860);
    BHu = new a();
    BHm = ae.a(new o[] { u.S("diehua.svg", Integer.valueOf(2131691569)), u.S("shanhei.svg", Integer.valueOf(2131691610)), u.S("shanbai.svg", Integer.valueOf(2131691608)), u.S("zuoyi.svg", Integer.valueOf(2131691620)), u.S("youyi.svg", Integer.valueOf(2131691618)), u.S("shangyi.svg", Integer.valueOf(2131691609)), u.S("xiayi.svg", Integer.valueOf(2131691617)), u.S("fangda.svg", Integer.valueOf(2131691583)), u.S("suoxiao.svg", Integer.valueOf(2131691613)), u.S("youzhuan.svg", Integer.valueOf(2131691619)), u.S("zuozhuan.svg", Integer.valueOf(2131691621)) });
    BHn = new LinkedList();
    BHo = new LinkedList();
    AppMethodBeat.o(195860);
  }
  
  public static List<w> a(c paramc, List<w> paramList)
  {
    AppMethodBeat.i(195854);
    p.h(paramc, "template");
    p.h(paramList, "sourceTrackList");
    long l3 = bt.HI();
    HashMap localHashMap = new HashMap();
    Object localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (w)((Iterator)localObject1).next();
      ((Map)localHashMap).put(((w)localObject2).path, Long.valueOf(0L));
    }
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList((Collection)paramc.BHB);
    localObject1 = (List)localArrayList;
    if (((List)localObject1).size() > 1) {
      j.a((List)localObject1, (Comparator)new e());
    }
    localArrayList.set(localArrayList.size() - 1, Pair.create(((Pair)j.je((List)localArrayList)).first, Long.valueOf(paramc.duration)));
    new HashMap();
    int m = ((Collection)localArrayList).size();
    int k = 0;
    Long localLong1;
    Long localLong2;
    long l1;
    long l2;
    Object localObject3;
    label320:
    int i;
    int j;
    if (k < m)
    {
      localLong1 = (Long)((Pair)localArrayList.get(k)).first;
      localLong2 = (Long)((Pair)localArrayList.get(k)).second;
      l1 = localLong2.longValue();
      p.g(localLong1, "replacementStart");
      l2 = l1 - localLong1.longValue();
      localObject1 = (w)paramList.get(k % paramList.size());
      localObject3 = (Long)localHashMap.get(((w)localObject1).path);
      if (localObject3 != null)
      {
        l1 = ((Long)localObject3).longValue();
        i = 0;
        j = ((Collection)paramList).size();
        label332:
        if (i >= j) {
          break label1091;
        }
        localObject1 = (w)paramList.get((k + i) % paramList.size());
        localObject3 = (Long)localHashMap.get(((w)localObject1).path);
        if (localObject3 == null) {
          break label787;
        }
        l1 = ((Long)localObject3).longValue();
        label386:
        if ((l1 + l2 > ((w)localObject1).getDurationMs()) && (((w)localObject1).type != 1)) {
          break label795;
        }
      }
    }
    label677:
    label822:
    label1088:
    label1091:
    for (;;)
    {
      localObject3 = new w(((w)localObject1).path, ((w)localObject1).type);
      if (((w)localObject1).type == 1)
      {
        ((w)localObject3).Bk(0L);
        ((w)localObject3).Bl(l2);
        ((w)localObject3).BGw.BMD = l2;
        label460:
        ((w)localObject3).Bi(localLong1.longValue());
        p.g(localLong2, "replacementEnd");
        ((w)localObject3).Bj(localLong2.longValue());
        ((w)localObject3).BGr = ((w)localObject1).BGr;
        ((w)localObject3).BGs = ((w)localObject1).BGs;
        ((w)localObject3).BGt = ((w)localObject1).BGt;
        ((w)localObject3).BGw.LmA = false;
        ((w)localObject3).BGu.pZj.set(((w)localObject1).BGu.pZj);
        ((w)localObject3).BGu.viewRect.set(((w)localObject1).BGu.viewRect);
        ((w)localObject3).BGu.hmm.set(((w)localObject1).BGu.hmm);
        ((w)localObject3).BGu.tLe = ((w)localObject1).BGu.tLe;
        ((w)localObject1).BGu.aXF *= 5.0F;
        ((w)localObject1).BGu.aXE *= 5.0F;
        ((w)localObject3).BGu.gR.set(((w)localObject1).BGu.gR);
        Iterator localIterator = ((Iterable)paramc.BHB).iterator();
        i = 0;
        j = -1;
        if (!localIterator.hasNext()) {
          break label822;
        }
        Object localObject4 = localIterator.next();
        if (i < 0) {
          j.gfB();
        }
        localObject4 = (Pair)localObject4;
        if ((!p.i((Long)((Pair)localObject4).first, (Long)((Pair)localArrayList.get(k)).first)) || (!p.i((Long)((Pair)localObject4).second, (Long)((Pair)localArrayList.get(k)).second))) {
          break label1088;
        }
        j = i;
      }
      for (;;)
      {
        i += 1;
        break label677;
        l1 = -1L;
        break label320;
        l1 = -1L;
        break label386;
        i += 1;
        break label332;
        ((w)localObject3).Bk(l1);
        ((w)localObject3).Bl(l1 + l2);
        break label460;
        ad.i("MicroMsg.LocalEffectManager", "add template track, time:[" + localLong1 + ", " + localLong2 + "], track time:[" + ((w)localObject3).BGw.HCU + ", " + ((w)localObject3).BGw.HCV + ", " + ((w)localObject3).BGw.BMD + "], path:" + ((w)localObject1).path + ", originIndex:" + j);
        l2 = l1 + l2;
        l1 = l2;
        if (l2 >= ((w)localObject1).getDurationMs()) {
          l1 = 0L;
        }
        ((Map)localHashMap).put(((w)localObject1).path, Long.valueOf(l1));
        ((ArrayList)localObject2).add(localObject3);
        k += 1;
        break;
        ad.i("MicroMsg.LocalEffectManager", "finish generate template track name:" + paramc.name + ", result.size:" + ((ArrayList)localObject2).size() + ", replacementInfo:" + paramc.BHB + ", template.duration:" + paramc.duration + ", cost:" + bt.aO(l3));
        paramc = (List)localObject2;
        AppMethodBeat.o(195854);
        return paramc;
      }
    }
  }
  
  public static void a(w paramw, long paramLong)
  {
    AppMethodBeat.i(195856);
    p.h(paramw, "track");
    Iterator localIterator = ((Iterable)BHn).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject).xPg == paramLong)
      {
        i = 1;
        label60:
        if (i == 0) {
          break label83;
        }
      }
    }
    for (;;)
    {
      paramw.a((a)localObject);
      AppMethodBeat.o(195856);
      return;
      i = 0;
      break label60;
      label83:
      break;
      localObject = null;
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(195853);
    p.h(parama, "transEffectInfo");
    long l2;
    long l1;
    if (parama.xPg <= 0L)
    {
      l2 = bt.HI();
      VLogEffectMgr localVLogEffectMgr = BHr;
      if (localVLogEffectMgr == null) {
        break label95;
      }
      l1 = localVLogEffectMgr.a(VLogEffectMgr.a.LBm, parama.assetPath);
      if (l1 != -1L) {
        break label102;
      }
      ad.e("MicroMsg.LocalEffectManager", "effect load error. maybe so load fail!!!!!! path:" + parama.assetPath);
    }
    for (;;)
    {
      parama.xPg = l1;
      AppMethodBeat.o(195853);
      return;
      label95:
      l1 = -1L;
      break;
      label102:
      ad.i("MicroMsg.LocalEffectManager", "checkCreateTransEffect effect:" + l1 + " cost:" + bt.aO(l2));
    }
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(195857);
    VLogEffectMgr localVLogEffectMgr = BHr;
    if (localVLogEffectMgr != null)
    {
      if (paramc != null) {}
      for (long l = paramc.BHA;; l = -1L)
      {
        localVLogEffectMgr.EJ(l);
        AppMethodBeat.o(195857);
        return;
      }
    }
    AppMethodBeat.o(195857);
  }
  
  public static void d(WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> paramWeakReference)
  {
    BHs = paramWeakReference;
  }
  
  public static void e(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(195858);
    Object localObject1 = BHp;
    Object localObject2;
    if (localObject1 != null)
    {
      if ((!paramBoolean) || (((b)localObject1).BHw > 0L)) {
        break label171;
      }
      localObject2 = BHr;
      if (localObject2 != null)
      {
        paramLong1 = ((VLogEffectMgr)localObject2).a(paramLong1, paramLong2, ((b)localObject1).xPg, new long[0]);
        ((b)localObject1).BHw = paramLong1;
      }
    }
    else
    {
      label63:
      localObject2 = new StringBuilder("setVideoEnhancement enable:").append(paramBoolean).append(", effectId:");
      localObject1 = BHp;
      if (localObject1 == null) {
        break label218;
      }
      localObject1 = Long.valueOf(((b)localObject1).xPg);
      label106:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", rangeId:");
      localObject1 = BHp;
      if (localObject1 == null) {
        break label224;
      }
    }
    label171:
    label218:
    label224:
    for (localObject1 = Long.valueOf(((b)localObject1).BHw);; localObject1 = null)
    {
      ad.i("MicroMsg.LocalEffectManager", localObject1);
      AppMethodBeat.o(195858);
      return;
      paramLong1 = -1L;
      break;
      if ((paramBoolean) || (((b)localObject1).BHw < 0L)) {
        break label63;
      }
      localObject2 = BHr;
      if (localObject2 != null) {
        ((VLogEffectMgr)localObject2).EJ(((b)localObject1).BHw);
      }
      ((b)localObject1).BHw = -1L;
      break label63;
      localObject1 = null;
      break label106;
    }
  }
  
  public static LinkedList<a> ess()
  {
    return BHn;
  }
  
  public static LinkedList<c> est()
  {
    return BHo;
  }
  
  public static VLogEffectMgr esu()
  {
    return BHr;
  }
  
  public static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> esv()
  {
    return BHs;
  }
  
  private static void esw()
  {
    AppMethodBeat.i(195851);
    ad.i("MicroMsg.LocalEffectManager", "initTransResource: transition res " + f.xHC.xHn + '}');
    if (f.xHC.xHn)
    {
      esx();
      AppMethodBeat.o(195851);
      return;
    }
    f.xHC.xHo = ((d.g.a.a)g.BHD);
    AppMethodBeat.o(195851);
  }
  
  private static void esx()
  {
    AppMethodBeat.i(195852);
    BHt = true;
    Object localObject1 = f.xHC.dGV();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = f.xHC.dGY();
        if (localJSONArray == null) {
          p.gfZ();
        }
        int k = localJSONArray.length();
        int i = 0;
        if (i < k)
        {
          Object localObject3 = localJSONArray.optJSONObject(i);
          String str1 = ((JSONObject)localObject3).optString("name");
          String str2 = ((JSONObject)localObject3).getString("pag");
          Object localObject2 = (Integer)BHm.get(((JSONObject)localObject3).getString("svg"));
          int m = ((JSONObject)localObject3).getInt("order");
          localObject3 = (String)localObject1 + str2;
          if (localObject2 != null)
          {
            j = ((Integer)localObject2).intValue();
            localObject2 = BHn;
            p.g(str1, "transEffectName");
            ((LinkedList)localObject2).add(new a(str1, m, (String)localObject3, j, -1L));
            i += 1;
          }
        }
        else
        {
          localObject1 = (List)BHn;
          if (((List)localObject1).size() > 1) {
            j.a((List)localObject1, (Comparator)new f());
          }
          AppMethodBeat.o(195852);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ad.printErrStackTrace("MicroMsg.LocalEffectManager", (Throwable)localJSONException, "Cannot load transEffect config", new Object[0]);
        AppMethodBeat.o(195852);
        return;
      }
      int j = -1;
    }
  }
  
  public static void f(List<w> paramList, long paramLong)
  {
    AppMethodBeat.i(195855);
    p.h(paramList, "trackList");
    Iterator localIterator = ((Iterable)BHn).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject).xPg == paramLong)
      {
        i = 1;
        label60:
        if (i == 0) {
          break label121;
        }
      }
    }
    for (;;)
    {
      localObject = (a)localObject;
      paramList = ((Iterable)j.F(paramList, paramList.size() - 1)).iterator();
      while (paramList.hasNext()) {
        ((w)paramList.next()).a((a)localObject);
      }
      i = 0;
      break label60;
      label121:
      break;
      localObject = null;
    }
    AppMethodBeat.o(195855);
  }
  
  /* Error */
  public final void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 683
    //   5: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 418
    //   11: ldc_w 684
    //   14: invokestatic 461	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   20: ifnonnull +13 -> 33
    //   23: new 508	com/tencent/mm/xeffect/VLogEffectMgr
    //   26: dup
    //   27: invokespecial 685	com/tencent/mm/xeffect/VLogEffectMgr:<init>	()V
    //   30: putstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   33: invokestatic 659	com/tencent/mm/plugin/vlog/model/local/a:esw	()V
    //   36: invokestatic 690	com/tencent/mm/plugin/vlog/model/p:erX	()Z
    //   39: ifeq +866 -> 905
    //   42: new 218	java/util/HashMap
    //   45: dup
    //   46: invokespecial 219	java/util/HashMap:<init>	()V
    //   49: astore 17
    //   51: invokestatic 696	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   54: astore 13
    //   56: aload 13
    //   58: ldc_w 698
    //   61: invokestatic 317	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   64: aload 13
    //   66: invokevirtual 704	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   69: ldc_w 706
    //   72: invokevirtual 712	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   75: astore 13
    //   77: aload 13
    //   79: ldc_w 714
    //   82: invokestatic 317	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   85: aload 13
    //   87: invokestatic 717	com/tencent/mm/sdk/platformtools/bt:S	(Ljava/io/InputStream;)Ljava/lang/String;
    //   90: astore 13
    //   92: ldc_w 418
    //   95: ldc_w 719
    //   98: aload 13
    //   100: invokestatic 724	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   103: invokevirtual 727	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 461	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: new 618	org/json/JSONObject
    //   112: dup
    //   113: aload 13
    //   115: invokespecial 728	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   118: ldc_w 730
    //   121: invokevirtual 734	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   124: astore 18
    //   126: aload 18
    //   128: invokevirtual 611	org/json/JSONArray:length	()I
    //   131: istore 4
    //   133: iconst_0
    //   134: istore_1
    //   135: iload_1
    //   136: iload 4
    //   138: if_icmpge +661 -> 799
    //   141: aload 18
    //   143: iload_1
    //   144: invokevirtual 737	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   147: astore 13
    //   149: aload 13
    //   151: ldc_w 616
    //   154: invokevirtual 622	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 19
    //   159: new 420	java/lang/StringBuilder
    //   162: dup
    //   163: ldc_w 739
    //   166: invokespecial 425	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload 13
    //   171: ldc_w 624
    //   174: invokevirtual 622	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore 20
    //   185: new 420	java/lang/StringBuilder
    //   188: dup
    //   189: ldc_w 739
    //   192: invokespecial 425	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload 13
    //   197: ldc_w 741
    //   200: invokevirtual 622	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore 16
    //   211: new 420	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 739
    //   218: invokespecial 425	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload 13
    //   223: ldc_w 743
    //   226: invokevirtual 622	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   229: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 21
    //   237: getstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   240: astore 13
    //   242: aload 13
    //   244: ifnull +492 -> 736
    //   247: getstatic 746	com/tencent/mm/xeffect/VLogEffectMgr$a:LBr	Lcom/tencent/mm/xeffect/VLogEffectMgr$a;
    //   250: astore 14
    //   252: invokestatic 696	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   255: astore 15
    //   257: aload 15
    //   259: ldc_w 698
    //   262: invokestatic 317	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   265: aload 13
    //   267: aload 14
    //   269: aload 15
    //   271: invokevirtual 704	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   274: aload 20
    //   276: invokevirtual 749	com/tencent/mm/xeffect/VLogEffectMgr:a	(Lcom/tencent/mm/xeffect/VLogEffectMgr$a;Landroid/content/res/AssetManager;Ljava/lang/String;)J
    //   279: lstore 7
    //   281: getstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   284: astore 13
    //   286: aload 13
    //   288: ifnull +36 -> 324
    //   291: aload 13
    //   293: lload 7
    //   295: iconst_1
    //   296: anewarray 136	d/o
    //   299: dup
    //   300: iconst_0
    //   301: getstatic 755	com/tencent/mm/xeffect/VLogEffectMgr$b:LBB	Lcom/tencent/mm/xeffect/VLogEffectMgr$b;
    //   304: invokevirtual 758	com/tencent/mm/xeffect/VLogEffectMgr$b:ordinal	()I
    //   307: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: fconst_1
    //   311: invokestatic 763	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   314: invokestatic 151	d/u:S	(Ljava/lang/Object;Ljava/lang/Object;)Ld/o;
    //   317: aastore
    //   318: invokestatic 766	d/a/ae:c	([Ld/o;)Ljava/util/HashMap;
    //   321: invokevirtual 769	com/tencent/mm/xeffect/VLogEffectMgr:a	(JLjava/util/HashMap;)V
    //   324: getstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   327: astore 13
    //   329: aload 13
    //   331: ifnull +21 -> 352
    //   334: aload 13
    //   336: lload 7
    //   338: invokevirtual 773	com/tencent/mm/xeffect/VLogEffectMgr:EN	(J)Landroid/util/Size;
    //   341: astore 14
    //   343: aload 14
    //   345: astore 13
    //   347: aload 14
    //   349: ifnonnull +14 -> 363
    //   352: new 775	android/util/Size
    //   355: dup
    //   356: iconst_0
    //   357: iconst_0
    //   358: invokespecial 778	android/util/Size:<init>	(II)V
    //   361: astore 13
    //   363: getstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   366: astore 14
    //   368: aload 14
    //   370: ifnull +374 -> 744
    //   373: aload 14
    //   375: lload 7
    //   377: invokevirtual 782	com/tencent/mm/xeffect/VLogEffectMgr:EM	(J)I
    //   380: istore_2
    //   381: getstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   384: astore 14
    //   386: aload 14
    //   388: ifnull +361 -> 749
    //   391: aload 14
    //   393: lload 7
    //   395: invokevirtual 785	com/tencent/mm/xeffect/VLogEffectMgr:EO	(J)J
    //   398: lstore 9
    //   400: getstatic 497	com/tencent/mm/plugin/vlog/model/local/a:BHr	Lcom/tencent/mm/xeffect/VLogEffectMgr;
    //   403: astore 14
    //   405: aload 14
    //   407: ifnull +21 -> 428
    //   410: aload 14
    //   412: lload 7
    //   414: invokevirtual 789	com/tencent/mm/xeffect/VLogEffectMgr:EP	(J)Ljava/util/List;
    //   417: astore 15
    //   419: aload 15
    //   421: astore 14
    //   423: aload 15
    //   425: ifnonnull +11 -> 436
    //   428: getstatic 795	d/a/v:MKE	Ld/a/v;
    //   431: checkcast 266	java/util/List
    //   434: astore 14
    //   436: lconst_0
    //   437: lstore 5
    //   439: aload 16
    //   441: checkcast 797	java/lang/CharSequence
    //   444: invokeinterface 798 1 0
    //   449: ifle +306 -> 755
    //   452: iconst_1
    //   453: istore_3
    //   454: aload 16
    //   456: astore 15
    //   458: lload 5
    //   460: lstore 11
    //   462: iload_3
    //   463: ifeq +93 -> 556
    //   466: new 420	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 637	java/lang/StringBuilder:<init>	()V
    //   473: invokestatic 803	com/tencent/mm/loader/j/b:arM	()Ljava/lang/String;
    //   476: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload 16
    //   481: invokevirtual 806	java/lang/String:hashCode	()I
    //   484: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   487: ldc_w 808
    //   490: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: astore 15
    //   498: ldc_w 810
    //   501: aload 16
    //   503: invokestatic 724	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   506: invokevirtual 727	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   509: aload 15
    //   511: invokestatic 816	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   514: pop2
    //   515: new 818	com/tencent/mm/compatible/h/d
    //   518: dup
    //   519: invokespecial 819	com/tencent/mm/compatible/h/d:<init>	()V
    //   522: astore 16
    //   524: aload 16
    //   526: aload 15
    //   528: invokevirtual 822	com/tencent/mm/compatible/h/d:setDataSource	(Ljava/lang/String;)V
    //   531: aload 16
    //   533: bipush 9
    //   535: invokevirtual 826	com/tencent/mm/compatible/h/d:extractMetadata	(I)Ljava/lang/String;
    //   538: lconst_0
    //   539: invokestatic 830	com/tencent/mm/sdk/platformtools/bt:getLong	(Ljava/lang/String;J)J
    //   542: lstore 11
    //   544: lload 11
    //   546: lstore 5
    //   548: aload 16
    //   550: invokevirtual 833	com/tencent/mm/compatible/h/d:release	()V
    //   553: goto +361 -> 914
    //   556: ldc_w 418
    //   559: ldc_w 835
    //   562: aload 14
    //   564: invokestatic 724	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   567: invokevirtual 727	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokestatic 461	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: ldc_w 418
    //   576: new 420	java/lang/StringBuilder
    //   579: dup
    //   580: ldc_w 837
    //   583: invokespecial 425	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   586: aload 20
    //   588: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc_w 839
    //   594: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 19
    //   599: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 551
    //   605: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: lload 7
    //   610: invokevirtual 442	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 841
    //   616: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 13
    //   621: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   624: ldc_w 843
    //   627: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: iload_2
    //   631: invokevirtual 452	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: ldc_w 845
    //   637: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: lload 9
    //   642: invokevirtual 442	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   645: ldc_w 847
    //   648: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload 15
    //   653: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: ldc_w 849
    //   659: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: lload 11
    //   664: invokevirtual 442	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   667: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 461	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: aload 19
    //   675: ldc_w 851
    //   678: invokestatic 317	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   681: new 12	com/tencent/mm/plugin/vlog/model/local/a$c
    //   684: dup
    //   685: aload 20
    //   687: aload 15
    //   689: aload 13
    //   691: lload 11
    //   693: iload_2
    //   694: lload 7
    //   696: iconst_1
    //   697: aload 19
    //   699: aload 21
    //   701: lconst_0
    //   702: aload 14
    //   704: sipush 512
    //   707: invokespecial 854	com/tencent/mm/plugin/vlog/model/local/a$c:<init>	(Ljava/lang/String;Ljava/lang/String;Landroid/util/Size;JIJZLjava/lang/String;Ljava/lang/String;JLjava/util/List;I)V
    //   710: astore 13
    //   712: aload 17
    //   714: checkcast 239	java/util/Map
    //   717: iload_1
    //   718: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   721: aload 13
    //   723: invokeinterface 252 3 0
    //   728: pop
    //   729: iload_1
    //   730: iconst_1
    //   731: iadd
    //   732: istore_1
    //   733: goto -598 -> 135
    //   736: ldc2_w 415
    //   739: lstore 7
    //   741: goto -460 -> 281
    //   744: iconst_0
    //   745: istore_2
    //   746: goto -365 -> 381
    //   749: lconst_0
    //   750: lstore 9
    //   752: goto -352 -> 400
    //   755: iconst_0
    //   756: istore_3
    //   757: goto -303 -> 454
    //   760: astore 22
    //   762: ldc_w 418
    //   765: aload 22
    //   767: checkcast 649	java/lang/Throwable
    //   770: ldc_w 856
    //   773: iconst_0
    //   774: anewarray 4	java/lang/Object
    //   777: invokestatic 655	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   780: aload 16
    //   782: invokevirtual 833	com/tencent/mm/compatible/h/d:release	()V
    //   785: goto +129 -> 914
    //   788: astore 13
    //   790: ldc_w 418
    //   793: ldc_w 858
    //   796: invokestatic 516	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   799: getstatic 195	com/tencent/mm/plugin/vlog/model/local/a:BHo	Ljava/util/LinkedList;
    //   802: invokevirtual 861	java/util/LinkedList:clear	()V
    //   805: aload 17
    //   807: invokevirtual 865	java/util/HashMap:keySet	()Ljava/util/Set;
    //   810: astore 13
    //   812: aload 13
    //   814: ldc_w 867
    //   817: invokestatic 317	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   820: aload 13
    //   822: checkcast 221	java/lang/Iterable
    //   825: invokestatic 871	d/a/j:j	(Ljava/lang/Iterable;)Ljava/util/List;
    //   828: invokeinterface 872 1 0
    //   833: astore 13
    //   835: aload 13
    //   837: invokeinterface 231 1 0
    //   842: ifeq +63 -> 905
    //   845: aload 17
    //   847: aload 13
    //   849: invokeinterface 235 1 0
    //   854: checkcast 141	java/lang/Integer
    //   857: invokevirtual 321	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   860: checkcast 12	com/tencent/mm/plugin/vlog/model/local/a$c
    //   863: astore 14
    //   865: aload 14
    //   867: ifnull -32 -> 835
    //   870: getstatic 195	com/tencent/mm/plugin/vlog/model/local/a:BHo	Ljava/util/LinkedList;
    //   873: aload 14
    //   875: invokevirtual 646	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   878: pop
    //   879: goto -44 -> 835
    //   882: astore 13
    //   884: aload_0
    //   885: monitorexit
    //   886: aload 13
    //   888: athrow
    //   889: astore 13
    //   891: aload 16
    //   893: invokevirtual 833	com/tencent/mm/compatible/h/d:release	()V
    //   896: ldc_w 683
    //   899: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   902: aload 13
    //   904: athrow
    //   905: ldc_w 683
    //   908: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   911: aload_0
    //   912: monitorexit
    //   913: return
    //   914: lload 5
    //   916: lstore 11
    //   918: goto -362 -> 556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	921	0	this	a
    //   134	599	1	i	int
    //   380	366	2	j	int
    //   453	304	3	k	int
    //   131	8	4	m	int
    //   437	478	5	l1	long
    //   279	461	7	l2	long
    //   398	353	9	l3	long
    //   460	457	11	l4	long
    //   54	668	13	localObject1	Object
    //   788	1	13	localException1	java.lang.Exception
    //   810	38	13	localObject2	Object
    //   882	5	13	localObject3	Object
    //   889	14	13	localObject4	Object
    //   250	624	14	localObject5	Object
    //   255	433	15	localObject6	Object
    //   209	683	16	localObject7	Object
    //   49	797	17	localHashMap	HashMap
    //   124	18	18	localJSONArray	JSONArray
    //   157	541	19	str1	String
    //   183	503	20	str2	String
    //   235	465	21	str3	String
    //   760	6	22	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   524	544	760	java/lang/Exception
    //   109	133	788	java/lang/Exception
    //   141	242	788	java/lang/Exception
    //   247	281	788	java/lang/Exception
    //   281	286	788	java/lang/Exception
    //   291	324	788	java/lang/Exception
    //   324	329	788	java/lang/Exception
    //   334	343	788	java/lang/Exception
    //   352	363	788	java/lang/Exception
    //   363	368	788	java/lang/Exception
    //   373	381	788	java/lang/Exception
    //   381	386	788	java/lang/Exception
    //   391	400	788	java/lang/Exception
    //   400	405	788	java/lang/Exception
    //   410	419	788	java/lang/Exception
    //   428	436	788	java/lang/Exception
    //   439	452	788	java/lang/Exception
    //   466	524	788	java/lang/Exception
    //   548	553	788	java/lang/Exception
    //   556	729	788	java/lang/Exception
    //   780	785	788	java/lang/Exception
    //   891	905	788	java/lang/Exception
    //   2	33	882	finally
    //   33	109	882	finally
    //   109	133	882	finally
    //   141	242	882	finally
    //   247	281	882	finally
    //   281	286	882	finally
    //   291	324	882	finally
    //   324	329	882	finally
    //   334	343	882	finally
    //   352	363	882	finally
    //   363	368	882	finally
    //   373	381	882	finally
    //   381	386	882	finally
    //   391	400	882	finally
    //   400	405	882	finally
    //   410	419	882	finally
    //   428	436	882	finally
    //   439	452	882	finally
    //   466	524	882	finally
    //   548	553	882	finally
    //   556	729	882	finally
    //   780	785	882	finally
    //   790	799	882	finally
    //   799	835	882	finally
    //   835	865	882	finally
    //   870	879	882	finally
    //   891	905	882	finally
    //   905	911	882	finally
    //   524	544	889	finally
    //   762	780	889	finally
  }
  
  public final void unInit()
  {
    try
    {
      AppMethodBeat.i(195859);
      BHn.clear();
      ad.i("MicroMsg.LocalEffectManager", "clear");
      VLogEffectMgr localVLogEffectMgr = BHr;
      if (localVLogEffectMgr != null) {
        localVLogEffectMgr.destroy();
      }
      BHr = null;
      f.xHC.xHo = null;
      BHs = null;
      AppMethodBeat.o(195859);
      return;
    }
    finally {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "", "name", "", "order", "", "assetPath", "svgPath", "duration", "", "effectId", "(Ljava/lang/String;ILjava/lang/String;IJJ)V", "getAssetPath", "()Ljava/lang/String;", "setAssetPath", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "setEffectId", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getSvgPath", "setSvgPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-vlog_release"})
  public static final class a
  {
    public int BHv;
    public String assetPath;
    public long duration;
    public String name;
    int order;
    public long xPg;
    
    public a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(195833);
      this.name = paramString1;
      this.order = paramInt1;
      this.assetPath = paramString2;
      this.BHv = paramInt2;
      this.duration = 500L;
      this.xPg = paramLong;
      AppMethodBeat.o(195833);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195837);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.i(this.name, paramObject.name)) || (this.order != paramObject.order) || (!p.i(this.assetPath, paramObject.assetPath)) || (this.BHv != paramObject.BHv) || (this.duration != paramObject.duration) || (this.xPg != paramObject.xPg)) {}
        }
      }
      else
      {
        AppMethodBeat.o(195837);
        return true;
      }
      AppMethodBeat.o(195837);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(195836);
      String str = this.name;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int k = this.order;
        str = this.assetPath;
        if (str != null) {
          j = str.hashCode();
        }
        int m = this.BHv;
        long l = this.duration;
        int n = (int)(l ^ l >>> 32);
        l = this.xPg;
        int i1 = (int)(l ^ l >>> 32);
        AppMethodBeat.o(195836);
        return ((((i * 31 + k) * 31 + j) * 31 + m) * 31 + n) * 31 + i1;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195835);
      String str = "TransEffectInfo(name=" + this.name + ", order=" + this.order + ", assetPath=" + this.assetPath + ", svgPath=" + this.BHv + ", duration=" + this.duration + ", effectId=" + this.xPg + ")";
      AppMethodBeat.o(195835);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "", "effectId", "", "effectRangeId", "(JJ)V", "getEffectId", "()J", "setEffectId", "(J)V", "getEffectRangeId", "setEffectRangeId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"})
  public static final class b
  {
    long BHw = 0L;
    long xPg = 0L;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.xPg != paramObject.xPg) || (this.BHw != paramObject.BHw)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.xPg;
      int i = (int)(l ^ l >>> 32);
      l = this.BHw;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195838);
      String str = "VideoEnhancementEffectInfo(effectId=" + this.xPg + ", effectRangeId=" + this.BHw + ")";
      AppMethodBeat.o(195838);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "", "path", "", "musicPath", "size", "Landroid/util/Size;", "duration", "", "imageNums", "", "effectId", "trackCropToTemplateSize", "", "name", "icon", "templateEffectRangeId", "replacementInfo", "", "Landroid/util/Pair;", "(Ljava/lang/String;Ljava/lang/String;Landroid/util/Size;JIJZLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "getIcon", "()Ljava/lang/String;", "getImageNums", "()I", "setImageNums", "(I)V", "getMusicPath", "setMusicPath", "(Ljava/lang/String;)V", "getName", "getPath", "getReplacementInfo", "()Ljava/util/List;", "setReplacementInfo", "(Ljava/util/List;)V", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "getTemplateEffectRangeId", "setTemplateEffectRangeId", "getTrackCropToTemplateSize", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-vlog_release"})
  public static final class c
  {
    public long BHA;
    List<Pair<Long, Long>> BHB;
    public Size BHx;
    private int BHy;
    public final boolean BHz;
    public final String dDH;
    public long duration;
    public String hml;
    public final String name;
    public final String path;
    public final long xPg;
    
    private c(String paramString1, String paramString2, Size paramSize, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString3, String paramString4, long paramLong3, List<Pair<Long, Long>> paramList)
    {
      AppMethodBeat.i(195839);
      this.path = paramString1;
      this.hml = paramString2;
      this.BHx = paramSize;
      this.duration = paramLong1;
      this.BHy = paramInt;
      this.xPg = paramLong2;
      this.BHz = paramBoolean;
      this.name = paramString3;
      this.dDH = paramString4;
      this.BHA = paramLong3;
      this.BHB = paramList;
      AppMethodBeat.o(195839);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195843);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.i(this.path, paramObject.path)) || (!p.i(this.hml, paramObject.hml)) || (!p.i(this.BHx, paramObject.BHx)) || (this.duration != paramObject.duration) || (this.BHy != paramObject.BHy) || (this.xPg != paramObject.xPg) || (this.BHz != paramObject.BHz) || (!p.i(this.name, paramObject.name)) || (!p.i(this.dDH, paramObject.dDH)) || (this.BHA != paramObject.BHA) || (!p.i(this.BHB, paramObject.BHB))) {}
        }
      }
      else
      {
        AppMethodBeat.o(195843);
        return true;
      }
      AppMethodBeat.o(195843);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195841);
      String str = "VideoTemplateInfo(path=" + this.path + ", musicPath=" + this.hml + ", size=" + this.BHx + ", duration=" + this.duration + ", imageNums=" + this.BHy + ", effectId=" + this.xPg + ", trackCropToTemplateSize=" + this.BHz + ", name=" + this.name + ", icon=" + this.dDH + ", templateEffectRangeId=" + this.BHA + ", replacementInfo=" + this.BHB + ")";
      AppMethodBeat.o(195841);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    public static final d BHC;
    
    static
    {
      AppMethodBeat.i(195845);
      BHC = new d();
      AppMethodBeat.o(195845);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(195846);
      int i = d.b.a.a((Comparable)((Pair)paramT1).first, (Comparable)((Pair)paramT2).first);
      AppMethodBeat.o(195846);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class f<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(195847);
      int i = d.b.a.a((Comparable)Integer.valueOf(((a.a)paramT1).order), (Comparable)Integer.valueOf(((a.a)paramT2).order));
      AppMethodBeat.o(195847);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    public static final g BHD;
    
    static
    {
      AppMethodBeat.i(195849);
      BHD = new g();
      AppMethodBeat.o(195849);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.local.a
 * JD-Core Version:    0.7.0.1
 */
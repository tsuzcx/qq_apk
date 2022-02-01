package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/util/ExptSettingLogic;", "", "()V", "InnerVersion", "", "getInnerVersion", "()I", "InnerVersionKey", "", "getInnerVersionKey", "()Ljava/lang/String;", "TAG", "getTAG", "exptSettingConfig", "Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "getExptSettingConfig", "()Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "exptSettingValueMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExptSettingValueMap", "()Ljava/util/HashMap;", "applyLocalTemplate", "", "getConfigKey", "groupKey", "itemKey", "getConfigValue", "key", "defaultValue", "getCopyMsgInfoFlag", "getExptFlag", "getExptFlagInt", "getJsAccelerateFlag", "isInnerUser", "isOpenFingerSearch", "isOpenHotWordSearch", "isOpenImageSearch", "isRedOrPurple", "isTestBSPatch", "isTestFullApk", "isTestHotPatch", "needRestart", "openPreload", "openTPPlayer", "openTPPlayerBgPrepare", "openTPPlayerFlowControl", "openTPPlayerScroll", "resetTemplate", "saveConfigValue", "", "setConfigValue", "flag", "plugin-comm_release"})
public final class c
{
  private static final String LDb = "InnerVersion";
  private static final int LDc = 1;
  public static final aia LDd;
  public static final HashMap<String, Integer> LDe;
  public static final c LDf;
  private static final String TAG = "MicroMsg.ExptSettingLogic";
  
  static
  {
    AppMethodBeat.i(218965);
    LDf = new c();
    TAG = "MicroMsg.ExptSettingLogic";
    LDb = "InnerVersion";
    LDc = 1;
    LDd = new aia();
    LDe = new HashMap();
    Object localObject1 = new aib();
    ((aib)localObject1).key = "total";
    ((aib)localObject1).title = "全局配置";
    Object localObject3 = new aic();
    ((aic)localObject3).key = "total";
    ((aic)localObject3).title = "试验总开关";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "copyMsgInfo";
    ((aic)localObject3).title = "复制消息体";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    LDd.GxO.add(localObject1);
    localObject1 = z.Nhr;
    localObject1 = new aib();
    ((aib)localObject1).key = "tpplayer";
    ((aib)localObject1).title = "TP播放器配置";
    localObject3 = new aic();
    ((aic)localObject3).key = "openFlag";
    ((aic)localObject3).title = "是否打开TPPlayer";
    ((aic)localObject3).defaultValue = 1;
    ((aic)localObject3).GxP = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "openBgPrepare";
    ((aic)localObject3).title = "是否打开预加载";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "openScroll";
    ((aic)localObject3).title = "是否打开滑动优化";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "openFlowControl";
    ((aic)localObject3).title = "是否打开流控";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    LDd.GxO.add(localObject1);
    localObject1 = z.Nhr;
    localObject1 = new aib();
    ((aib)localObject1).key = "search";
    ((aib)localObject1).title = "搜索配置";
    localObject3 = new aic();
    ((aic)localObject3).key = "openPreload";
    ((aic)localObject3).title = "是否打开搜索预加载";
    ((aic)localObject3).defaultValue = 1;
    ((aic)localObject3).GxP = 1;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "openResetTemplate";
    ((aic)localObject3).title = "是否启动重置模板";
    ((aic)localObject3).defaultValue = 0;
    ((aic)localObject3).GxP = 1;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "applyLocalTemplate";
    ((aic)localObject3).title = "是否允许应用本地模板";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "openFingerSearch";
    ((aic)localObject3).title = "是否打开指尖搜索";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "openHotWordSearch";
    ((aic)localObject3).title = "是否打开热词搜索建立、加载模型";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "openImageSearch";
    ((aic)localObject3).title = "是否打开图片搜索";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    LDd.GxO.add(localObject1);
    localObject1 = z.Nhr;
    localObject1 = new aib();
    ((aib)localObject1).key = "testUpdate";
    ((aib)localObject1).title = "更新配置";
    localObject3 = new aic();
    ((aic)localObject3).key = "testHotPatch";
    ((aic)localObject3).title = "测试hotPatch";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "testBSDiff";
    ((aic)localObject3).title = "测试BSDiff";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    localObject3 = new aic();
    ((aic)localObject3).key = "testFullApk";
    ((aic)localObject3).title = "测试fullApk";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    LDd.GxO.add(localObject1);
    localObject1 = z.Nhr;
    localObject1 = new aib();
    ((aib)localObject1).key = "topstory";
    ((aib)localObject1).title = "看一看配置";
    localObject3 = new aic();
    ((aic)localObject3).key = "openJsAccelerate";
    ((aic)localObject3).title = "是否打开JSCodeCache加速";
    ((aic)localObject3).defaultValue = 0;
    ((aib)localObject1).hFT.add(localObject3);
    localObject3 = z.Nhr;
    LDd.GxO.add(localObject1);
    localObject1 = z.Nhr;
    localObject1 = LDd.GxO;
    p.g(localObject1, "exptSettingConfig.groups");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (aib)((Iterator)localObject1).next();
      localObject4 = ((aib)localObject3).hFT;
      p.g(localObject4, "group.items");
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (aic)((Iterator)localObject4).next();
        ((Map)LDe).put(((aib)localObject3).key + '-' + ((aic)localObject5).key, Integer.valueOf(((aic)localObject5).defaultValue));
      }
    }
    try
    {
      localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      localObject3 = ((e)localObject1).ajA().a(am.a.JdP, "");
      if (localObject3 == null) {
        break label1155;
      }
      localObject1 = (CharSequence)localObject3;
      if (localObject1 == null) {
        break label1217;
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label1186;
      }
    }
    catch (Exception localException)
    {
      label1069:
      label1119:
      ae.d(TAG, "init " + LDe);
      label1155:
      AppMethodBeat.o(218965);
      return;
    }
    if (localObject1 != null)
    {
      localObject1 = new JSONObject((String)localObject3);
      if (((JSONObject)localObject1).optInt(LDb, 0) != LDc) {
        break label1210;
      }
      localObject3 = ((JSONObject)localObject1).keys();
      if (localObject3 == null) {
        break label1210;
      }
    }
    label1186:
    label1191:
    label1210:
    label1217:
    label1234:
    label1237:
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localObject5 = ((JSONObject)localObject1).opt((String)localObject4);
        CharSequence localCharSequence = (CharSequence)localObject4;
        if (localCharSequence == null) {
          break label1234;
        }
        if (localCharSequence.length() == 0) {
          break label1234;
        }
      }
      for (;;)
      {
        if ((i != 0) || (localObject5 == null) || (!(localObject5 instanceof Integer))) {
          break label1237;
        }
        ((Map)LDe).put(localObject4, localObject5);
        break label1069;
        int i = 0;
        for (i = 0; i == 0; i = 1)
        {
          localObject2 = null;
          break;
          i = 0;
          break label1119;
          localObject2 = z.Nhr;
          localObject2 = z.Nhr;
          break label1155;
          i = 1;
          if (i != 0) {
            break label1191;
          }
        }
        Object localObject2 = localObject3;
        break;
        i = 1;
      }
    }
  }
  
  public static int aZw(String paramString)
  {
    AppMethodBeat.i(218960);
    p.h(paramString, "key");
    paramString = (Integer)LDe.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(218960);
      return i;
    }
    AppMethodBeat.o(218960);
    return 0;
  }
  
  public static boolean bPY()
  {
    AppMethodBeat.i(218964);
    if (aZw(mz("search", "openPreload")) == 1)
    {
      AppMethodBeat.o(218964);
      return true;
    }
    AppMethodBeat.o(218964);
    return false;
  }
  
  public static aia fSc()
  {
    return LDd;
  }
  
  public static void fSd()
  {
    AppMethodBeat.i(218958);
    JSONObject localJSONObject = new JSONObject();
    f.a((Map)LDe, localJSONObject);
    localJSONObject.put(LDb, LDc);
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JdP, localJSONObject.toString());
    AppMethodBeat.o(218958);
  }
  
  public static int fSe()
  {
    AppMethodBeat.i(218961);
    int i = aZw(mz("total", "total"));
    AppMethodBeat.o(218961);
    return i;
  }
  
  public static boolean fSf()
  {
    AppMethodBeat.i(218962);
    if (aZw(mz("total", "total")) == 1)
    {
      AppMethodBeat.o(218962);
      return true;
    }
    AppMethodBeat.o(218962);
    return false;
  }
  
  public static boolean fSg()
  {
    return (j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED);
  }
  
  public static boolean fSh()
  {
    AppMethodBeat.i(218963);
    if ((j.DEBUG) || (fSg()) || (bv.fpT()))
    {
      AppMethodBeat.o(218963);
      return true;
    }
    AppMethodBeat.o(218963);
    return false;
  }
  
  public static String mz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218959);
    p.h(paramString1, "groupKey");
    p.h(paramString2, "itemKey");
    paramString1 = paramString1 + '-' + paramString2;
    AppMethodBeat.o(218959);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.util.c
 * JD-Core Version:    0.7.0.1
 */
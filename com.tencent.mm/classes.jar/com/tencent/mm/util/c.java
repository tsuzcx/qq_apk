package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/util/ExptSettingLogic;", "", "()V", "InnerVersion", "", "getInnerVersion", "()I", "InnerVersionKey", "", "getInnerVersionKey", "()Ljava/lang/String;", "TAG", "getTAG", "exptSettingConfig", "Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "getExptSettingConfig", "()Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "exptSettingValueMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExptSettingValueMap", "()Ljava/util/HashMap;", "applyLocalTemplate", "", "getConfigKey", "groupKey", "itemKey", "getConfigValue", "key", "defaultValue", "getCopyMsgInfoFlag", "getExptFlag", "getExptFlagInt", "isInnerUser", "isOpenFingerSearch", "isOpenHotWordSearch", "isOpenImageSearch", "isRedOrPurple", "isTestBSPatch", "isTestFullApk", "isTestHotPatch", "needRestart", "openPreload", "openTPPlayer", "openTPPlayerBgPrepare", "openTPPlayerFlowControl", "openTPPlayerScroll", "resetTemplate", "saveConfigValue", "", "setConfigValue", "flag", "plugin-comm_release"})
public final class c
{
  private static final int LgA = 1;
  public static final ahq LgB;
  public static final HashMap<String, Integer> LgC;
  public static final c LgD;
  private static final String Lgz = "InnerVersion";
  private static final String TAG = "MicroMsg.ExptSettingLogic";
  
  static
  {
    AppMethodBeat.i(195186);
    LgD = new c();
    TAG = "MicroMsg.ExptSettingLogic";
    Lgz = "InnerVersion";
    LgA = 1;
    LgB = new ahq();
    LgC = new HashMap();
    Object localObject1 = new ahr();
    ((ahr)localObject1).key = "total";
    ((ahr)localObject1).title = "全局配置";
    Object localObject3 = new ahs();
    ((ahs)localObject3).key = "total";
    ((ahs)localObject3).title = "试验总开关";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "copyMsgInfo";
    ((ahs)localObject3).title = "复制消息体";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    LgB.Gfg.add(localObject1);
    localObject1 = new ahr();
    ((ahr)localObject1).key = "tpplayer";
    ((ahr)localObject1).title = "TP播放器配置";
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openFlag";
    ((ahs)localObject3).title = "是否打开TPPlayer";
    ((ahs)localObject3).defaultValue = 1;
    ((ahs)localObject3).Gfh = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openBgPrepare";
    ((ahs)localObject3).title = "是否打开预加载";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openScroll";
    ((ahs)localObject3).title = "是否打开滑动优化";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openFlowControl";
    ((ahs)localObject3).title = "是否打开流控";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    LgB.Gfg.add(localObject1);
    localObject1 = new ahr();
    ((ahr)localObject1).key = "search";
    ((ahr)localObject1).title = "搜索配置";
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openPreload";
    ((ahs)localObject3).title = "是否打开搜索预加载";
    ((ahs)localObject3).defaultValue = 1;
    ((ahs)localObject3).Gfh = 1;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openResetTemplate";
    ((ahs)localObject3).title = "是否启动重置模板";
    ((ahs)localObject3).defaultValue = 0;
    ((ahs)localObject3).Gfh = 1;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "applyLocalTemplate";
    ((ahs)localObject3).title = "是否允许应用本地模板";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openFingerSearch";
    ((ahs)localObject3).title = "是否打开指尖搜索";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openHotWordSearch";
    ((ahs)localObject3).title = "是否打开热词搜索建立、加载模型";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "openImageSearch";
    ((ahs)localObject3).title = "是否打开图片搜索";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    LgB.Gfg.add(localObject1);
    localObject1 = new ahr();
    ((ahr)localObject1).key = "testUpdate";
    ((ahr)localObject1).title = "更新配置";
    localObject3 = new ahs();
    ((ahs)localObject3).key = "testHotPatch";
    ((ahs)localObject3).title = "测试hotPatch";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "testBSDiff";
    ((ahs)localObject3).title = "测试BSDiff";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    localObject3 = new ahs();
    ((ahs)localObject3).key = "testFullApk";
    ((ahs)localObject3).title = "测试fullApk";
    ((ahs)localObject3).defaultValue = 0;
    ((ahr)localObject1).hDb.add(localObject3);
    LgB.Gfg.add(localObject1);
    localObject1 = LgB.Gfg;
    p.g(localObject1, "exptSettingConfig.groups");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (ahr)((Iterator)localObject1).next();
      localObject4 = ((ahr)localObject3).hDb;
      p.g(localObject4, "group.items");
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ahs)((Iterator)localObject4).next();
        ((Map)LgC).put(((ahr)localObject3).key + '-' + ((ahs)localObject5).key, Integer.valueOf(((ahs)localObject5).defaultValue));
      }
    }
    try
    {
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      localObject3 = ((e)localObject1).ajl().a(al.a.IJj, "");
      if (localObject3 == null) {
        break label1006;
      }
      localObject1 = (CharSequence)localObject3;
      if (localObject1 == null) {
        break label1057;
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label1037;
      }
    }
    catch (Exception localException)
    {
      ad.d(TAG, "init " + LgC);
      AppMethodBeat.o(195186);
      return;
    }
    if (localObject1 != null)
    {
      localObject1 = new JSONObject((String)localObject3);
      if (((JSONObject)localObject1).optInt(Lgz, 0) == LgA)
      {
        localObject3 = ((JSONObject)localObject1).keys();
        if (localObject3 == null) {}
      }
    }
    label920:
    label1052:
    label1057:
    label1074:
    label1077:
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localObject5 = ((JSONObject)localObject1).opt((String)localObject4);
        CharSequence localCharSequence = (CharSequence)localObject4;
        if (localCharSequence == null) {
          break label1074;
        }
        if (localCharSequence.length() != 0) {
          break label1052;
        }
        break label1074;
      }
      for (;;)
      {
        label970:
        if ((i != 0) || (localObject5 == null) || (!(localObject5 instanceof Integer))) {
          break label1077;
        }
        ((Map)LgC).put(localObject4, localObject5);
        break label920;
        label1006:
        int i = 0;
        for (i = 0; i == 0; i = 1)
        {
          localObject2 = null;
          break;
          i = 0;
          break label970;
          i = 1;
          if (i != 0) {
            break label1042;
          }
        }
        Object localObject2 = localObject3;
        break;
        i = 1;
      }
    }
  }
  
  public static int aXU(String paramString)
  {
    AppMethodBeat.i(195181);
    p.h(paramString, "key");
    paramString = (Integer)LgC.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(195181);
      return i;
    }
    AppMethodBeat.o(195181);
    return 0;
  }
  
  public static boolean bPa()
  {
    AppMethodBeat.i(195185);
    if (aXU(ms("search", "openPreload")) == 1)
    {
      AppMethodBeat.o(195185);
      return true;
    }
    AppMethodBeat.o(195185);
    return false;
  }
  
  public static ahq fNH()
  {
    return LgB;
  }
  
  public static void fNI()
  {
    AppMethodBeat.i(195179);
    JSONObject localJSONObject = new JSONObject();
    f.a((Map)LgC, localJSONObject);
    localJSONObject.put(Lgz, LgA);
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IJj, localJSONObject.toString());
    AppMethodBeat.o(195179);
  }
  
  public static int fNJ()
  {
    AppMethodBeat.i(195182);
    int i = aXU(ms("total", "total"));
    AppMethodBeat.o(195182);
    return i;
  }
  
  public static boolean fNK()
  {
    AppMethodBeat.i(195183);
    if (aXU(ms("total", "total")) == 1)
    {
      AppMethodBeat.o(195183);
      return true;
    }
    AppMethodBeat.o(195183);
    return false;
  }
  
  public static boolean fNL()
  {
    return (i.IS_FLAVOR_PURPLE) || (i.IS_FLAVOR_RED);
  }
  
  public static boolean fNM()
  {
    AppMethodBeat.i(195184);
    if ((i.DEBUG) || (fNL()) || (bu.flY()))
    {
      AppMethodBeat.o(195184);
      return true;
    }
    AppMethodBeat.o(195184);
    return false;
  }
  
  public static String ms(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195180);
    p.h(paramString1, "groupKey");
    p.h(paramString2, "itemKey");
    paramString1 = paramString1 + '-' + paramString2;
    AppMethodBeat.o(195180);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.util.c
 * JD-Core Version:    0.7.0.1
 */
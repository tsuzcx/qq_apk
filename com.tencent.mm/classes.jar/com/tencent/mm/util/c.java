package com.tencent.mm.util;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mmkv.MMKV;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/util/ExptSettingLogic;", "", "()V", "InnerVersion", "", "getInnerVersion", "()I", "InnerVersionKey", "", "getInnerVersionKey", "()Ljava/lang/String;", "TAG", "getTAG", "defaultValueMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDefaultValueMap", "()Ljava/util/HashMap;", "exptSettingConfig", "Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "getExptSettingConfig", "()Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "mmkv", "Lcom/tencent/mmkv/MMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mmkv/MMKV;", "applyLocalTemplate", "", "getConfigKey", "groupKey", "itemKey", "getConfigValue", "key", "getCopyMsgInfoFlag", "getExptFlag", "getExptFlagInt", "getIsUseSysEditTextFlag", "getJsAccelerateFlag", "getOpenAppShortcutFlag", "getOpenInlineTagC2CFlag", "getOpenInlineTagSNSFlag", "getOpenMvChattingFlag", "getOpenMvTypeFlag", "getTinkerBaseId", "isCacheSosResult", "isCloseAutoTinkerPatch", "isIconOpenInContact", "isIconOpenInGroup", "isIconOpenInNewMsg", "isIconOpenInSnsCommentAndLike", "isIconOpenInSnsFeeds", "isInnerUser", "isOpenAutoProcessor", "isOpenCenterActionBar", "isOpenImageSearch", "isOpenMultiTaskMode", "isOpenNewTips", "isOpenNewUpdater", "isOpenNorthWestIDC", "isOpenTextStatus", "isPlanetOpen", "isRedOrPurple", "needRestart", "openPreload", "openXEffector", "resetTemplate", "setConfigValue", "value", "useQQMusicPlayer", "libcompatible_release"})
public final class c
{
  private static final String QYv = "InnerVersion";
  private static final int QYw = 8;
  private static final akm QYx;
  private static final HashMap<String, String> QYy;
  public static final c QYz;
  private static final String TAG = "MicroMsg.ExptSettingLogic";
  private static final MMKV mmkv;
  
  static
  {
    AppMethodBeat.i(215534);
    QYz = new c();
    TAG = "MicroMsg.ExptSettingLogic";
    QYv = "InnerVersion";
    QYw = 8;
    QYx = new akm();
    mmkv = MMKV.mmkvWithID("ExptSettingLogic", 2);
    QYy = new HashMap();
    Object localObject1 = new akn();
    ((akn)localObject1).key = "total";
    ((akn)localObject1).title = "全局配置";
    Object localObject2 = new ako();
    ((ako)localObject2).key = "total";
    ((ako)localObject2).title = "试验总开关";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "copyMsgInfo";
    ((ako)localObject2).title = "复制消息体";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "switchNorthwestIDC";
    ((ako)localObject2).title = "是否切换西北IDC";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openAppShortcut";
    ((ako)localObject2).title = "是否打开快捷菜单";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((ako)localObject2).Lty = 1;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openCenterActionBar";
    ((ako)localObject2).title = "是否开启ActionBar居中";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((ako)localObject2).Lty = 1;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openMultiTaskMode";
    ((ako)localObject2).title = "是否开启负一屏";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((ako)localObject2).Lty = 1;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    QYx.Ltx.add(localObject1);
    localObject1 = x.SXb;
    localObject1 = new akn();
    ((akn)localObject1).key = "search";
    ((akn)localObject1).title = "基础搜索配置";
    localObject2 = new ako();
    ((ako)localObject2).key = "openResetTemplate";
    ((ako)localObject2).title = "是否启动重置模板";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).Lty = 1;
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "applyLocalTemplate";
    ((ako)localObject2).title = "是否允许应用本地模板";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openInlineTagC2C";
    ((ako)localObject2).title = "是否打开行内Tag（会话）";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openInlineTagSns";
    ((ako)localObject2).title = "是否打开行内Tag（朋友圈）";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isUseSysEditText";
    ((ako)localObject2).title = "是否使用系统EditText";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    QYx.Ltx.add(localObject1);
    localObject1 = x.SXb;
    localObject1 = new akn();
    ((akn)localObject1).key = "topstory";
    ((akn)localObject1).title = "看一看配置";
    localObject2 = new ako();
    ((ako)localObject2).key = "openJsAccelerate";
    ((ako)localObject2).title = "是否打开JSCodeCache加速";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    QYx.Ltx.add(localObject1);
    localObject1 = x.SXb;
    localObject1 = new akn();
    ((akn)localObject1).key = "websearch";
    ((akn)localObject1).title = "搜一搜配置";
    localObject2 = new ako();
    ((ako)localObject2).key = "openPreload";
    ((ako)localObject2).title = "是否打开搜一搜WebView预加载";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).Lty = 1;
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "cacheSosResult";
    ((ako)localObject2).title = "是否存储搜一搜结果到SDcard";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openImageSearch";
    ((ako)localObject2).title = "是否打开搜一搜图片搜索";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    QYx.Ltx.add(localObject1);
    localObject1 = x.SXb;
    localObject1 = new akn();
    ((akn)localObject1).key = "updater";
    ((akn)localObject1).title = "更新配置";
    localObject2 = new ako();
    ((ako)localObject2).key = "closeAutoTinkerPatch";
    ((ako)localObject2).title = "是否关闭自动TinkerPatch";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openNewUpdater";
    ((ako)localObject2).title = "是否打开新版更新机制";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openAutoProcessor";
    ((ako)localObject2).title = "是否打开自动处理逻辑";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "tinkerBaseId";
    ((ako)localObject2).title = "设置TinkerBaseId";
    ((ako)localObject2).oxJ = "";
    ((ako)localObject2).type = 1;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    QYx.Ltx.add(localObject1);
    localObject1 = x.SXb;
    localObject1 = new akn();
    ((akn)localObject1).key = "musicplayer";
    ((akn)localObject1).title = "音乐播放器";
    localObject2 = new ako();
    ((ako)localObject2).key = "openXEffector";
    ((ako)localObject2).title = "是否打开XEffector";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openMvType";
    ((ako)localObject2).title = "是否打开新的MV卡片类型";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "openMvChatting";
    ((ako)localObject2).title = "是否打开聊天室";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "useQQMusicPlayer";
    ((ako)localObject2).title = "是否使用QQ音乐播放器";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    QYx.Ltx.add(localObject1);
    localObject1 = x.SXb;
    localObject1 = new akn();
    ((akn)localObject1).key = "textstatus";
    ((akn)localObject1).title = "状态配置";
    localObject2 = new ako();
    ((ako)localObject2).key = "openTextStatus";
    ((ako)localObject2).title = "开启文字状态";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).Lty = 0;
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isPlanetOpen";
    ((ako)localObject2).title = "开启状态星球";
    ((ako)localObject2).oxJ = "0";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isNewTipsOpen";
    ((ako)localObject2).title = "开启NewTips";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isIconOpenInContact";
    ((ako)localObject2).title = "开启通讯录icon";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isIconOpenInGroup";
    ((ako)localObject2).title = "开启群聊icon";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isIconOpenInSnsFeeds";
    ((ako)localObject2).title = "开启朋友圈feeds icon";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isIconOpenInSnsCommentAndLike";
    ((ako)localObject2).title = "开启朋友圈点赞/评论icon";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    localObject2 = new ako();
    ((ako)localObject2).key = "isIconOpenInNewMsg";
    ((ako)localObject2).title = "开启朋友圈消息提醒列表icon";
    ((ako)localObject2).oxJ = "1";
    ((ako)localObject2).type = 0;
    ((akn)localObject1).iAd.add(localObject2);
    localObject2 = x.SXb;
    QYx.Ltx.add(localObject1);
    localObject1 = x.SXb;
    h.RTc.b((Runnable)1.QYA, TAG);
    AppMethodBeat.o(215534);
  }
  
  public static String axY(String paramString)
  {
    AppMethodBeat.i(215523);
    p.h(paramString, "key");
    MMKV localMMKV = mmkv;
    String str2 = (String)QYy.get(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramString = localMMKV.decodeString(paramString, str1);
    p.g(paramString, "mmkv.decodeString(key, defaultValueMap[key] ?: \"\")");
    AppMethodBeat.o(215523);
    return paramString;
  }
  
  public static boolean cnC()
  {
    AppMethodBeat.i(215532);
    if (Util.getInt(axY(np("websearch", "openPreload")), 0) == 1)
    {
      AppMethodBeat.o(215532);
      return true;
    }
    AppMethodBeat.o(215532);
    return false;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static String hcY()
  {
    return QYv;
  }
  
  public static int hcZ()
  {
    return QYw;
  }
  
  public static akm hda()
  {
    return QYx;
  }
  
  public static MMKV hdb()
  {
    return mmkv;
  }
  
  public static HashMap<String, String> hdc()
  {
    return QYy;
  }
  
  public static int hdd()
  {
    AppMethodBeat.i(215525);
    int i = Util.getInt(axY(np("total", "total")), 0);
    AppMethodBeat.o(215525);
    return i;
  }
  
  public static boolean hde()
  {
    AppMethodBeat.i(215526);
    if (Util.getInt(axY(np("total", "total")), 0) == 1)
    {
      AppMethodBeat.o(215526);
      return true;
    }
    AppMethodBeat.o(215526);
    return false;
  }
  
  public static boolean hdf()
  {
    return (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED);
  }
  
  public static boolean hdg()
  {
    AppMethodBeat.i(215527);
    if ((BuildInfo.DEBUG) || (hdf()) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(215527);
      return true;
    }
    AppMethodBeat.o(215527);
    return false;
  }
  
  public static int hdh()
  {
    AppMethodBeat.i(215528);
    int i = Util.getInt(axY(np("total", "openAppShortcut")), 0);
    AppMethodBeat.o(215528);
    return i;
  }
  
  public static int hdi()
  {
    AppMethodBeat.i(215529);
    int i = Util.getInt(axY(np("search", "openInlineTagC2C")), 0);
    AppMethodBeat.o(215529);
    return i;
  }
  
  public static int hdj()
  {
    AppMethodBeat.i(215530);
    int i = Util.getInt(axY(np("search", "openInlineTagSns")), 0);
    AppMethodBeat.o(215530);
    return i;
  }
  
  public static String hdk()
  {
    AppMethodBeat.i(215531);
    String str = axY(np("updater", "tinkerBaseId"));
    AppMethodBeat.o(215531);
    return str;
  }
  
  public static boolean hdl()
  {
    AppMethodBeat.i(215533);
    if (Util.getInt(axY(np("musicplayer", "openXEffector")), 1) == 1)
    {
      AppMethodBeat.o(215533);
      return true;
    }
    AppMethodBeat.o(215533);
    return false;
  }
  
  public static String np(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215522);
    p.h(paramString1, "groupKey");
    p.h(paramString2, "itemKey");
    paramString1 = paramString1 + '-' + paramString2;
    AppMethodBeat.o(215522);
    return paramString1;
  }
  
  public static boolean nq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215524);
    p.h(paramString1, "key");
    p.h(paramString2, "value");
    mmkv.encode(paramString1, paramString2);
    p.h(paramString1, "key");
    paramString2 = n.a((CharSequence)paramString1, new String[] { "-" });
    if (paramString2.size() == 2)
    {
      i = 1;
      if (i == 0) {
        break label238;
      }
      paramString1 = paramString2;
      label72:
      if (paramString1 == null) {
        break label266;
      }
      paramString1 = QYx.Ltx;
      p.g(paramString1, "exptSettingConfig.groups");
      Iterator localIterator = ((Iterable)paramString1).iterator();
      while (localIterator.hasNext())
      {
        paramString1 = localIterator.next();
        if (p.j(((akn)paramString1).key, (String)paramString2.get(0)))
        {
          label139:
          paramString1 = (akn)paramString1;
          if (paramString1 == null) {
            break label253;
          }
          paramString1 = paramString1.iAd;
          if (paramString1 == null) {
            break label253;
          }
          localIterator = ((Iterable)paramString1).iterator();
          while (localIterator.hasNext())
          {
            paramString1 = localIterator.next();
            if (p.j(((ako)paramString1).key, (String)paramString2.get(1)))
            {
              label206:
              paramString1 = (ako)paramString1;
              if (paramString1 == null) {
                break label253;
              }
            }
          }
        }
      }
    }
    label238:
    label253:
    for (int i = paramString1.Lty;; i = 0)
    {
      if (i != 1) {
        break label258;
      }
      AppMethodBeat.o(215524);
      return true;
      i = 0;
      break;
      paramString1 = null;
      break label72;
      paramString1 = null;
      break label139;
      paramString1 = null;
      break label206;
    }
    label258:
    AppMethodBeat.o(215524);
    return false;
    label266:
    AppMethodBeat.o(215524);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.ar;
import com.tencent.mm.autogen.b.ap;
import com.tencent.mm.kernel.b;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.fmu;
import com.tencent.mm.protocal.protobuf.fmv;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizCardLogic;", "", "()V", "AD_COUNT_ONE_DAY", "", "AD_COUNT_ONE_DAY_MAX", "BIZ_AD_CARD_INSERT_POS", "CHECK_AD_INTERVAL", "DEFAULT_REFRESH_INTERVAL", "", "FROM_MAIN_CELL_EXPOSE", "FROM_MSG_RESORT", "FROM_TEST_PUSH", "KEY_BIZ_AD_CARD_DATA", "", "KEY_BIZ_AD_INSERT_POS", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CANVAS_LAST_TIME", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CRASH_TIMES", "KEY_BIZ_MAX_AD_COUNT", "KEY_BIZ_REFRESH_INTERVAL", "KEY_BIZ_REFRESH_LAST_TIME", "KEY_BIZ_ResortRefreshIntervalSec", "TAG", "aIdMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "adCardPrefix", "adExposeParamsInit", "", "getAdExposeParamsInit", "()Z", "setAdExposeParamsInit", "(Z)V", "adMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getAdMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "adMmkv$delegate", "Lkotlin/Lazy;", "adOpen", "getAdOpen", "adPrefetchOpen", "getAdPrefetchOpen", "adPrefetchOpen$delegate", "adPreviewMode", "getAdPreviewMode", "adValidExpose", "getAdValidExpose", "adValidExpose$delegate", "bizAdOpen", "getBizAdOpen", "bizAdOpen$delegate", "canvasPreloadOpen", "getCanvasPreloadOpen", "canvasPreloadOpen$delegate", "checkedAIdSet", "Ljava/util/HashSet;", "doClearAdData", "exposeRefreshInterval", "getExposeRefreshInterval", "()J", "setExposeRefreshInterval", "(J)V", "hasPreload", "hasSetCrashFlag", "insertPos", "insertType", "getInsertType", "()I", "setInsertType", "(I)V", "insertTypeDefault", "insertTypeInsert", "insertTypeInsertToUnExposePos", "isForeGround", "isTeenMode", "lastNotifyTime", "lastPreloadTraceId", "getLastPreloadTraceId", "()Ljava/lang/String;", "setLastPreloadTraceId", "(Ljava/lang/String;)V", "lastReplaceTraceId", "getLastReplaceTraceId", "setLastReplaceTraceId", "lastSaveTraceId", "getLastSaveTraceId", "setLastSaveTraceId", "lastTraceId", "getLastTraceId", "setLastTraceId", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "localInsertPos", "getLocalInsertPos", "localInsertPos$delegate", "maxAdCount", "minAdExposureRatio", "", "getMinAdExposureRatio", "()F", "setMinAdExposureRatio", "(F)V", "minAdExposureTime", "getMinAdExposureTime", "setMinAdExposureTime", "minNotifyJsCoreTime", "mmkv", "getMmkv", "mmkv$delegate", "mockAdData", "getMockAdData", "mockPicAdData", "mockVideoAdData", "openRecycleLogicContext", "getOpenRecycleLogicContext", "openRecycleLogicContext$delegate", "openRecyclePreLoadedAd", "getOpenRecyclePreLoadedAd", "openRecyclePreLoadedAd$delegate", "openRecycleRenderVM", "getOpenRecycleRenderVM", "openRecycleRenderVM$delegate", "openSendUIEvent", "getOpenSendUIEvent", "openSendUIEvent$delegate", "prefetchOpen", "getPrefetchOpen", "recConflictOpen", "getRecConflictOpen", "recConflictOpen$delegate", "recOpen", "getRecOpen", "recOpen$delegate", "resortRefreshInterval", "getResortRefreshInterval", "setResortRefreshInterval", "testMode", "getTestMode", "testMode$delegate", "triggerDownLoadPkgOnGetAdData", "getTriggerDownLoadPkgOnGetAdData", "triggerDownLoadPkgOnGetAdData$delegate", "triggerDownLoadPkgOnGetRecData", "getTriggerDownLoadPkgOnGetRecData", "triggerDownLoadPkgOnGetRecData$delegate", "bizBoxClick", "", "checkAd", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "clearAdData", "dispatchEventToAdPrefetch", "event", "msg", "doBizCardCgi", "from", "exposePreload", "getAdDataObject", "Lorg/json/JSONObject;", "content", "getAdExposureRatio", "getAdExposureTime", "getAdInsertPos", "getExposeInterval", "getLastUnExposedAd", "getMaxAdCount", "getOrderFlag", "defOrderFlag", "getResortInterval", "getTimeLineContext", "handleExtInfo", "extInfo", "Lcom/tencent/mm/protocal/protobuf/AdvertisementExtInfo;", "initAdExposeParams", "insertAd", "replaceAd", "isAdChecked", "aid", "isAdDataValid", "adData", "onAppBackground", "onAppForeground", "onBizAdNotify", "valuesMap", "", "msgContent", "onMainCellExpose", "preloadAdCard", "preloadCanvasCard", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "info", "preloadRecFeedCanvasCard", "preloadUnInsertAdCard", "preloadUnInsertRecCard", "recyclePreloadAdCard", "tranceId", "lastVisiblePosition", "firstUnExposePos", "replaceAdData", "data", "replaceTimelineAd", "canvasId", "resetClashFlag", "saveAdData", "setAdExposeParams", "exposureRatio", "exposureTme", "setAdInsertType", "type", "updateExtInfo", "updateInterval", "interval", "adCanvasId", "toAccountKey", "BizCardFlag", "BusinessId", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  private static long AfG;
  private static boolean Bwq;
  public static int Yjq;
  public static final r acDM;
  private static final HashMap<String, Long> acDN;
  private static final HashSet<String> acDO;
  public static int acDP;
  private static String acDQ;
  public static String acDR;
  public static String acDS;
  private static String acDT;
  private static final kotlin.j acDU;
  private static final kotlin.j acDV;
  private static final kotlin.j acDW;
  private static final kotlin.j acDX;
  private static final kotlin.j acDY;
  private static final kotlin.j acDZ;
  private static final kotlin.j acEa;
  private static final kotlin.j acEb;
  private static final kotlin.j acEc;
  private static final kotlin.j acEd;
  private static final kotlin.j acEe;
  private static final kotlin.j acEf;
  private static final kotlin.j acEg;
  private static final kotlin.j acEh;
  public static boolean acEi;
  private static long acEj;
  private static long acEk;
  private static boolean acEl;
  private static boolean acEm;
  public static float acEn;
  public static long acEo;
  public static boolean acEp;
  private static final String acEq;
  private static final String acEr;
  private static final kotlin.j aklt;
  private static final kotlin.j exj;
  public static int hAt;
  private static final com.tencent.mm.an.r vCc;
  
  static
  {
    AppMethodBeat.i(249048);
    acDM = new r();
    vCc = new com.tencent.mm.an.r(600000);
    acDN = new HashMap();
    acDO = new HashSet();
    acDP = -1;
    Yjq = -1;
    exj = kotlin.k.cm((kotlin.g.a.a)r.g.acEy);
    acDU = kotlin.k.cm((kotlin.g.a.a)r.a.acEs);
    acDV = kotlin.k.cm((kotlin.g.a.a)r.m.acEE);
    acDW = kotlin.k.cm((kotlin.g.a.a)r.f.acEx);
    acDX = kotlin.k.cm((kotlin.g.a.a)r.d.acEv);
    acDY = kotlin.k.cm((kotlin.g.a.a)r.l.acED);
    acDZ = kotlin.k.cm((kotlin.g.a.a)r.b.acEt);
    acEa = kotlin.k.cm((kotlin.g.a.a)r.k.acEC);
    acEb = kotlin.k.cm((kotlin.g.a.a)r.c.acEu);
    acEc = kotlin.k.cm((kotlin.g.a.a)r.n.acEF);
    acEd = kotlin.k.cm((kotlin.g.a.a)r.o.acEG);
    acEe = kotlin.k.cm((kotlin.g.a.a)r.i.acEA);
    acEf = kotlin.k.cm((kotlin.g.a.a)r.h.acEz);
    aklt = kotlin.k.cm((kotlin.g.a.a)r.p.aklu);
    acEg = kotlin.k.cm((kotlin.g.a.a)r.j.acEB);
    acEh = kotlin.k.cm((kotlin.g.a.a)r.e.acEw);
    acEm = true;
    if (BuildInfo.DEBUG) {}
    for (int i = 1;; i = 0)
    {
      hAt = i;
      acEn = 0.1F;
      acEo = 100L;
      acEq = "  {\n  \"hint_txt\": \"创意-20200601_1\",\n  \"url\": \"http://e.cn.miaozhen.com/r/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=95e085c866db2ca4da4529b48423634da3737d13156ab08310b6c0d6b29adcaa89dc88172fab7fc8425d0e54f740947d&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"traceid\": \"wx0p67bjetlwkdc200\",\n  \"group_id\": \"wx0p67bjetlwkdc200_wx0p67bjetlwkdc201\",\n  \"ticket\": \"\",\n  \"aid\": \"274376350\",\n  \"pathType\": \"ad\",\n  \"pt\": 2,\n  \"image_url\": \"http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx2c1dad7332964d7d\",\n  \"biz_info\": {\n    \"user_name\": \"gh_f60cb6e1bbe0\",\n    \"nick_name\": \"新加坡旅游局\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM7ibCaN09GMnHSZNhcA9G36v9vhgIUy8OYX4PmcPwvg5Mw/0\",\n    \"biz_uin\": 3580351467,\n    \"signature\": \"心想狮城\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 0,\n  \"dest_type\": 1,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"998\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:1,&quot;jump_url&quot;:&quot;http:\\\\/\\\\/e.cn.miaozhen.com\\\\/r\\\\/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=6d7c64459169785a1510691ed6578b66d61408173f47c29e364658492046fbd0f7f55ad59c1e22f9fc7b42b8c5a84314&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"274376350|wx0p67bjetlwkdc200|255437066|0|1594265023|0|0|72058780271891663||AgKTRVlIlM5171j831mAsV9KhXn1D6AO9t0OzsoUSabfNucHFl9DpvWA4VsIAsTV6Sg=|274376355\",\n  \"ext_info\": \"\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d32a0fb17d38d299f730fd35928b7f5bbf\",\n  \"crt_info\": \"[{&quot;image_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;height&quot;:540,&quot;width&quot;:960,&quot;size&quot;:74132,&quot;image_md5&quot;:&quot;7a9c01200bcb2dba6a07c98abad6a89d&quot;,&quot;materialId&quot;:&quot;102225575&quot;,&quot;card_info&quot;:{&quot;head_desc_type&quot;:1,&quot;mp_tag_type&quot;:0}}]\",\n  \"reranking_ext_info\": \"{\\\"tid\\\":2303720433,\\\"material_hash\\\":\\\"CMzm1scGEOCTyMQC\\\"}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0100109996274}\"\n}";
      acEr = "  {\n  \"hint_txt\": \"创意-20200619_1\",\n  \"url\": \"pages/Home/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=227428a14b944e52c301d99d7769b9d5e6ccd7aa55aac2ca8ca514b5e77a73e83b1579fffef623a5d0972810be5e4fb7&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"traceid\": \"wx0zfmndr7d35pjq00\",\n  \"group_id\": \"wx0zfmndr7d35pjq00_wx0zfmndr7d35pjq01_wx0zfmndr7d35pjq02\",\n  \"ticket\": \"\",\n  \"aid\": \"278576846\",\n  \"pathType\": \"ad\",\n  \"pt\": 9,\n  \"image_url\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx032b61d035e02538\",\n  \"biz_info\": {\n    \"user_name\": \"gh_c5a5a55e74a5\",\n    \"nick_name\": \"BVLGARI宝格丽\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hgUXh7XsHRGLHRribgcXlRGXKB4phZorcicBGVeDWCYQQ/0\",\n    \"biz_uin\": 3074666211,\n    \"signature\": \"于1884年在罗马建立的高端珠宝品牌BVLGARI宝格丽，始终代表着精美奢华的意大利风格。\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 1,\n  \"video_info\": {\n    \"displayWidth\": 960,\n    \"displayHeight\": 540,\n    \"thumbUrl\": \"http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023\",\n    \"videoUrl\": \"http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023\"\n  },\n  \"weapp_info\": {\n    \"original_id\": \"gh_e70774015690\",\n    \"appid\": \"wx56b4770737a7dddf\",\n    \"nick_name\": \"BVLGARI宝格丽精品店\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5pN0eR1LRZJzPxALx3mRPYSmiaPbibPE5fQKS8xTy6ichbQ/0\"\n  },\n  \"dest_type\": 6,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"538\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:6,&quot;jump_url&quot;:&quot;pages\\\\/Home\\\\/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=5418655bc3dd454e4ed84dad6962668068661cb2009130ec86f3626ef4700e9b7a06ee64eb5d93f14e87b54ce39699c9&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"278576846|wx0zfmndr7d35pjq00||0|1594264005|0|0|72058780271891663||AgKNIqBiWhQxioBrueuTRKG/ZDGPF4ER7Im3GhiUj6HO7oRLhI/wSZTh3mxc7jqPZug=|278576919\",\n  \"ext_info\": \"{&quot;wx_app_type&quot;:2,&quot;gh_id&quot;:&quot;gh_e70774015690&quot;}\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d3779f0258b01c0503fbde6feda83a487b\",\n  \"crt_info\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"reranking_ext_info\": \"{tid:278576919}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0134623190388}\"\n}";
      AppMethodBeat.o(249048);
      return;
    }
  }
  
  private static final int a(LinkedList paramLinkedList, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(249038);
    s.u(paramLinkedList, "$cardIds");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.BizCardLogic", "checkAd callback errType=" + paramInt1 + ", errCode=" + paramInt2);
      paramLinkedList = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(17L);
      AppMethodBeat.o(249038);
      return 0;
    }
    paramString = c.c.b(paramc.otC);
    if ((paramString instanceof fmv)) {}
    for (paramString = (fmv)paramString; paramString == null; paramString = null)
    {
      AppMethodBeat.o(249038);
      return 0;
    }
    if (Util.isNullOrNil(paramString.YVP))
    {
      Log.e("MicroMsg.BizCardLogic", "checkAd callback resp.Data is empty");
      paramLinkedList = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(18L);
      AppMethodBeat.o(249038);
      return 0;
    }
    paramc = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(19L);
    for (;;)
    {
      int i;
      try
      {
        paramc = new JSONObject(paramString.YVP);
        paramString = paramc.optString("aid");
        paramc = paramc.optJSONArray("del_aid");
        Log.i("MicroMsg.BizCardLogic", s.X("checkAd callback chooseAid=", paramString));
        if (paramc == null)
        {
          paramInt1 = 0;
          if (paramInt1 > 0)
          {
            paramInt1 = 0;
            i = paramc.length();
            if (i > 0)
            {
              paramInt2 = paramInt1 + 1;
              paramp = paramc.optString(paramInt1);
              Object localObject1 = (CharSequence)paramp;
              if (localObject1 == null) {
                break label704;
              }
              if (!n.bp((CharSequence)localObject1)) {
                break label718;
              }
              break label704;
              label263:
              if (paramInt1 != 0) {
                break label709;
              }
              Object localObject2 = (Long)acDN.get(paramp);
              if (localObject2 == null) {
                break label709;
              }
              localObject1 = af.bHl().aq(((Long)localObject2).longValue(), "msgId");
              if (localObject1 == null) {
                break label709;
              }
              af.bHl().yQ(((Long)localObject2).longValue());
              Log.e("MicroMsg.BizCardLogic", s.X("checkAd force delete ad ", paramp));
              localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
              String str = ((ab)localObject1).getTraceId();
              if (((ab)localObject1).field_isRead != 1) {
                break label723;
              }
              paramInt1 = 1;
              ((com.tencent.mm.plugin.report.service.h)localObject2).b(20635, new Object[] { paramp, str, Integer.valueOf(2), Integer.valueOf(paramInt1) });
              paramp = com.tencent.mm.plugin.webcanvas.j.WkY;
              if (((ab)localObject1).field_isRead != 1) {
                break label728;
              }
              l = 21L;
              com.tencent.mm.plugin.webcanvas.j.xC(l);
              paramp = com.tencent.mm.plugin.webcanvas.j.WkY;
              com.tencent.mm.plugin.webcanvas.j.xC(23L);
              break label709;
            }
          }
          paramLinkedList = ((Iterable)paramLinkedList).iterator();
          if (paramLinkedList.hasNext())
          {
            paramc = (String)paramLinkedList.next();
            acDO.add(paramc);
            if (s.p(paramc, paramString)) {
              continue;
            }
            paramp = (Long)acDN.get(paramc);
            if (paramp == null) {
              continue;
            }
            paramc = af.bHl().aq(paramp.longValue(), "msgId");
            if (paramc == null) {
              continue;
            }
            if (paramc.field_isRead != 0) {
              break label642;
            }
            af.bHl().yQ(paramp.longValue());
            Log.e("MicroMsg.BizCardLogic", s.X("checkAd delete ad ", paramc.iYs()));
            com.tencent.mm.plugin.report.service.h.OAn.b(20635, new Object[] { paramc.iYs(), paramc.getTraceId(), Integer.valueOf(1), Integer.valueOf(0) });
            paramc = com.tencent.mm.plugin.webcanvas.j.WkY;
            com.tencent.mm.plugin.webcanvas.j.xC(22L);
            continue;
          }
        }
        paramInt1 = paramc.length();
      }
      catch (Exception paramLinkedList)
      {
        Log.e("MicroMsg.BizCardLogic", s.X("checkAd callback ex ", paramLinkedList.getMessage()));
        AppMethodBeat.o(249038);
        return 0;
      }
      continue;
      label642:
      paramp = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(24L);
      com.tencent.mm.plugin.report.service.h.OAn.b(20635, new Object[] { paramc.iYs(), paramc.getTraceId(), Integer.valueOf(0), Integer.valueOf(1) });
      continue;
      label704:
      label709:
      do
      {
        paramInt1 = paramInt2;
        break;
        paramInt1 = 1;
        break label263;
      } while (paramInt2 < i);
      continue;
      label718:
      paramInt1 = 0;
      continue;
      label723:
      paramInt1 = 0;
      continue;
      label728:
      long l = 20L;
    }
  }
  
  private static long aN(long paramLong, int paramInt)
  {
    ab localab = null;
    AppMethodBeat.i(249004);
    if (paramInt > 0) {}
    for (;;)
    {
      Object localObject = af.bHl();
      String str = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(kotlin.k.k.qu(paramInt - 2, 0)));
      localObject = ((ac)localObject).omV.rawQuery(str, null);
      if (((Cursor)localObject).moveToFirst())
      {
        localab = new ab();
        localab.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
      if (localab != null) {
        break;
      }
      Log.w("MicroMsg.BizCardLogic", "getOrderFlag lastTimeLineInfo is null");
      AppMethodBeat.o(249004);
      return 0L;
      paramInt = iXD();
    }
    if (paramInt == 1) {}
    long l2;
    for (long l1 = localab.field_orderFlag + 1L;; l1 = localab.field_orderFlag - 1L)
    {
      l2 = l1;
      if (l1 != paramLong) {
        break;
      }
      AppMethodBeat.o(249004);
      return l1;
    }
    while (af.bHl().yF(l2) != null)
    {
      Log.w("MicroMsg.BizCardLogic", s.X("insertAd field_orderFlag conflict orderFlag=", Long.valueOf(l2)));
      l2 -= 1L;
    }
    AppMethodBeat.o(249004);
    return l2;
  }
  
  private static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(248849);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(248849);
    return localMultiProcessMMKV;
  }
  
  public static String ayw(int paramInt)
  {
    AppMethodBeat.i(248941);
    Object localObject1 = af.bHl().ayA(5);
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject3;
    JSONObject localJSONObject2;
    int j;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    long l;
    boolean bool;
    for (;;)
    {
      try
      {
        s.s(localObject1, "it");
        localObject1 = (Iterable)localObject1;
        int i = 0;
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label1095;
        }
        localObject1 = localIterator.next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject3 = (ab)localObject1;
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("index", i);
        if (((ab)localObject3).iYe())
        {
          localJSONObject2.put("is_recommand", false);
          localObject4 = new JSONArray();
          localObject1 = (com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class);
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((u)localObject1).nUC;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = (Iterable)localObject1;
            j = 0;
            localObject1 = ((Iterable)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject5 = ((Iterator)localObject1).next();
              if (j < 0) {
                kotlin.a.p.kkW();
              }
              localObject6 = (v)localObject5;
              localObject5 = new JSONObject();
              if (!Util.isNullOrNil(((v)localObject6).url))
              {
                localObject7 = Uri.parse(((v)localObject6).url);
                k = Util.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
                l = Util.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
                localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
                s.s(localObject7, "decode(uri.getQueryParam…\"__biz\"), Base64.NO_WRAP)");
                ((JSONObject)localObject5).put("bizuin", Util.getLong(new String((byte[])localObject7, d.UTF_8), 0L));
                ((JSONObject)localObject5).put("mid", l);
                ((JSONObject)localObject5).put("idx", k);
                ((JSONObject)localObject5).put("title", ((v)localObject6).title);
              }
              ((JSONObject)localObject5).put("index", j);
              ((JSONObject)localObject5).put("msg_time", ((v)localObject6).time);
              if ((j < 2) || (((ab)localObject3).field_isExpand)) {
                break label1138;
              }
              bool = true;
              ((JSONObject)localObject5).put("is_fold", bool);
              localObject6 = new JSONObject();
              if (((ab)localObject3).field_isRead != 1) {
                break label1144;
              }
              k = 1;
              label435:
              ((JSONObject)localObject6).put("type", k);
              localObject7 = kotlin.ah.aiuX;
              ((JSONObject)localObject5).put("user_action", localObject6);
              localObject6 = kotlin.ah.aiuX;
              ((JSONArray)localObject4).put(localObject5);
              j += 1;
              continue;
            }
          }
          else
          {
            localObject1 = ((com.tencent.mm.plugin.biz.a.a)localObject1).c(((ab)localObject3).field_msgId, ((ab)localObject3).field_content);
            continue;
          }
          localObject1 = kotlin.ah.aiuX;
          localObject1 = kotlin.ah.aiuX;
          localJSONObject2.put("msg", localObject4);
          label524:
          localJSONArray.put(localJSONObject2);
          i += 1;
          continue;
        }
        if (!((ab)localObject3).iYf()) {
          continue;
        }
        localJSONObject2.put("is_recommend", true);
        localObject4 = ((ab)localObject3).iYp();
        if (localObject4 != null) {
          break label743;
        }
        j = 0;
        localJSONObject2.put("style", j);
        if ((localObject4 == null) || (((flj)localObject4).style != 1001)) {
          break;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("extra_data", ((flj)localObject4).hRR);
        ((JSONObject)localObject1).put("msg_time", ((ab)localObject3).field_createTime);
        localObject4 = new JSONObject();
        if (((ab)localObject3).field_isRead != 1) {
          break label1149;
        }
        j = 1;
        label654:
        ((JSONObject)localObject4).put("type", j);
        localObject3 = kotlin.ah.aiuX;
        ((JSONObject)localObject1).put("user_action", localObject4);
        localObject3 = kotlin.ah.aiuX;
        localJSONObject2.put("ext_info", localObject1);
        continue;
        localObject2 = localJSONObject1.toString();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BizCardLogic", (Throwable)localException, "getTimeLineContext", new Object[0]);
      }
      label719:
      s.s(localObject2, "getBizTimeLineInfoStorag…text.toString()\n        }");
      AppMethodBeat.o(248941);
      return localObject2;
      label743:
      j = ((flj)localObject4).style;
    }
    Object localObject2 = new JSONArray();
    s.s(localObject3, "msg");
    Object localObject4 = ah.J((ab)localObject3);
    if (localObject4 != null)
    {
      localObject4 = (Iterable)localObject4;
      j = 0;
      localObject4 = ((Iterable)localObject4).iterator();
      label799:
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        if (j < 0) {
          kotlin.a.p.kkW();
        }
        localObject6 = (qn)localObject5;
        localObject5 = new JSONObject();
        if (!Util.isNullOrNil(((qn)localObject6).YQK))
        {
          localObject7 = Uri.parse(((qn)localObject6).YQK);
          k = Util.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
          l = Util.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
          localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
          s.s(localObject7, "decode(uri.getQueryParam…\"__biz\"), Base64.NO_WRAP)");
          ((JSONObject)localObject5).put("bizuin", Util.getLong(new String((byte[])localObject7, d.UTF_8), 0L));
          ((JSONObject)localObject5).put("mid", l);
          ((JSONObject)localObject5).put("idx", k);
          ((JSONObject)localObject5).put("title", ((qn)localObject6).hAP);
        }
        ((JSONObject)localObject5).put("index", j);
        ((JSONObject)localObject5).put("msg_time", ((ab)localObject3).field_createTime);
        ((JSONObject)localObject5).put("is_fold", false);
        localObject6 = new JSONObject();
        if (((ab)localObject3).field_isRead != 1) {
          break label1154;
        }
      }
    }
    label1154:
    for (int k = 1;; k = 0)
    {
      ((JSONObject)localObject6).put("type", k);
      localObject7 = kotlin.ah.aiuX;
      ((JSONObject)localObject5).put("user_action", localObject6);
      localObject6 = kotlin.ah.aiuX;
      ((JSONArray)localObject2).put(localObject5);
      j += 1;
      break label799;
      localObject3 = kotlin.ah.aiuX;
      localObject3 = kotlin.ah.aiuX;
      localJSONObject2.put("msg", localObject2);
      break label524;
      label1095:
      localJSONObject1.put("timeline_context", localJSONArray);
      localJSONObject1.put("timeline_request_type", paramInt);
      localJSONObject1.put("last_expose_time", iXi().decodeLong("BizLastExposeAdTime", 0L));
      break label719;
      label1138:
      bool = false;
      break;
      label1144:
      k = 0;
      break label435;
      label1149:
      j = 0;
      break label654;
    }
  }
  
  private static final void ayx(int paramInt)
  {
    AppMethodBeat.i(249034);
    Object localObject1 = com.tencent.mm.plugin.biz.b.c.vtp;
    com.tencent.mm.plugin.biz.b.c.daA().encode("biz_canvas_card_expose_preload_crash_times", paramInt + 1);
    Log.i("MicroMsg.BizCardLogic", "exposePreload set crash flag");
    acEl = true;
    localObject1 = af.bHl().nT(637534257, 1);
    int i;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      paramInt = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label140;
      }
      localObject2 = (ab)((Iterator)localObject1).next();
      if (Math.abs(((ab)localObject2).field_createTime - System.currentTimeMillis()) >= 86400000L) {
        break label481;
      }
      localObject3 = acDM;
      s.s(localObject2, "info");
      ((r)localObject3).B((ab)localObject2);
      localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(12L);
    }
    label140:
    label439:
    label467:
    label481:
    for (paramInt = 1;; paramInt = i)
    {
      i = paramInt;
      break;
      paramInt = 0;
      localObject1 = af.bHl().nT(620757041, 1);
      i = paramInt;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          i = paramInt;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ab)((Iterator)localObject1).next();
          if (Math.abs(((ab)localObject2).field_createTime - System.currentTimeMillis()) < 86400000L)
          {
            localObject3 = acDM;
            s.s(localObject2, "info");
            if (((r)localObject3).B((ab)localObject2))
            {
              localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
              com.tencent.mm.plugin.webcanvas.j.xC(13L);
              paramInt = 1;
            }
          }
        }
      }
      localObject1 = acDM;
      localObject2 = iXi().decodeString(bvh("biz_ad_card_data"));
      localObject3 = (CharSequence)localObject2;
      if ((localObject3 == null) || (n.bp((CharSequence)localObject3)))
      {
        paramInt = 1;
        if (paramInt == 0)
        {
          localObject2 = bvj((String)localObject2);
          if (localObject2 != null) {
            ((r)localObject1).cN((JSONObject)localObject2);
          }
        }
        localObject1 = acDM;
        localObject2 = ad.iYM();
        if (!Util.isNullOrNil((String)localObject2))
        {
          s.s(localObject2, "msgContent");
          paramInt = n.a((CharSequence)localObject2, "<sysmsg", 0, false, 6);
          if (paramInt != -1)
          {
            localObject3 = ((String)localObject2).substring(paramInt);
            s.s(localObject3, "(this as java.lang.String).substring(startIndex)");
            localObject3 = XmlParser.parseXml((String)localObject3, "sysmsg", null);
            if (localObject3 != null) {
              break label439;
            }
            Log.e("MicroMsg.BizCardLogic", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbI();
        if ((i == 0) || (!acEm)) {
          break label467;
        }
        com.tencent.threadpool.h.ahAA.p(r..ExternalSyntheticLambda4.INSTANCE, 3000L);
        AppMethodBeat.o(249034);
        return;
        paramInt = 0;
        break;
        if (ah.cz((Map)localObject3))
        {
          localObject2 = ah.cA((Map)localObject3);
          if (localObject2 != null) {
            ((r)localObject1).b((flj)localObject2, null);
          }
        }
      }
      acEl = false;
      iXE();
      AppMethodBeat.o(249034);
      return;
    }
  }
  
  /* Error */
  private boolean b(flj paramflj, ab paramab)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1127
    //   5: invokestatic 283	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +128 -> 137
    //   12: aload_1
    //   13: getfield 951	com/tencent/mm/protocal/protobuf/flj:style	I
    //   16: sipush 1001
    //   19: if_icmpne +118 -> 137
    //   22: aload_1
    //   23: getfield 1131	com/tencent/mm/protocal/protobuf/flj:abLO	Lcom/tencent/mm/protocal/protobuf/enc;
    //   26: ifnull +111 -> 137
    //   29: aload_2
    //   30: ifnonnull +99 -> 129
    //   33: lconst_0
    //   34: lstore_3
    //   35: ldc_w 519
    //   38: ldc_w 1133
    //   41: invokestatic 1136	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: getstatic 549	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   47: astore_2
    //   48: ldc2_w 1137
    //   51: invokestatic 554	com/tencent/mm/plugin/webcanvas/j:xC	(J)V
    //   54: ldc_w 1093
    //   57: invokestatic 840	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   60: checkcast 1093	com/tencent/mm/plugin/brandservice/api/c
    //   63: astore 7
    //   65: aload_1
    //   66: getfield 1131	com/tencent/mm/protocal/protobuf/flj:abLO	Lcom/tencent/mm/protocal/protobuf/enc;
    //   69: getfield 1143	com/tencent/mm/protocal/protobuf/enc:abrA	Ljava/lang/String;
    //   72: astore 6
    //   74: aload 6
    //   76: astore_2
    //   77: aload 6
    //   79: ifnonnull +7 -> 86
    //   82: ldc_w 1145
    //   85: astore_2
    //   86: aload 7
    //   88: aload_2
    //   89: ldc_w 1147
    //   92: aload_1
    //   93: getfield 1131	com/tencent/mm/protocal/protobuf/flj:abLO	Lcom/tencent/mm/protocal/protobuf/enc;
    //   96: getfield 1150	com/tencent/mm/protocal/protobuf/enc:cardId	Ljava/lang/String;
    //   99: invokestatic 603	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   102: aload_1
    //   103: getfield 1131	com/tencent/mm/protocal/protobuf/flj:abLO	Lcom/tencent/mm/protocal/protobuf/enc;
    //   106: getfield 1152	com/tencent/mm/protocal/protobuf/enc:data	Ljava/lang/String;
    //   109: lload_3
    //   110: invokeinterface 1155 6 0
    //   115: iconst_1
    //   116: istore 5
    //   118: ldc_w 1127
    //   121: invokestatic 289	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_0
    //   125: monitorexit
    //   126: iload 5
    //   128: ireturn
    //   129: aload_2
    //   130: getfield 928	com/tencent/mm/storage/ab:field_msgId	J
    //   133: lstore_3
    //   134: goto -99 -> 35
    //   137: iconst_0
    //   138: istore 5
    //   140: ldc_w 1127
    //   143: invokestatic 289	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: goto -22 -> 124
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	r
    //   0	154	1	paramflj	flj
    //   0	154	2	paramab	ab
    //   34	100	3	l	long
    //   116	23	5	bool	boolean
    //   72	6	6	str	String
    //   63	24	7	localc	com.tencent.mm.plugin.brandservice.api.c
    // Exception table:
    //   from	to	target	type
    //   2	8	149	finally
    //   12	29	149	finally
    //   35	74	149	finally
    //   86	115	149	finally
    //   118	124	149	finally
    //   129	134	149	finally
    //   140	146	149	finally
  }
  
  public static String bvg(String paramString)
  {
    AppMethodBeat.i(248839);
    s.u(paramString, "<this>");
    paramString = s.X("__ad_card_", paramString);
    AppMethodBeat.o(248839);
    return paramString;
  }
  
  public static String bvh(String paramString)
  {
    AppMethodBeat.i(248846);
    paramString = new StringBuilder().append(paramString).append('-');
    com.tencent.mm.kernel.h.baC();
    paramString = b.aZs();
    AppMethodBeat.o(248846);
    return paramString;
  }
  
  private void bvi(String paramString)
  {
    AppMethodBeat.i(248949);
    if (!com.tencent.mm.kernel.h.baz()) {
      Log.i("MicroMsg.BizCardLogic", "saveAdData acc not ready");
    }
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizCardLogic", "saveAdData data is null");
      paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(3L);
      AppMethodBeat.o(248949);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(4L);
    localObject1 = bvj(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizCardLogic", "saveAdData adData is null");
      paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(91L);
      AppMethodBeat.o(248949);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(92L);
    if (iXs()) {
      com.tencent.mm.plugin.webcanvas.k.WkZ.ioR();
    }
    localObject2 = ((JSONObject)localObject1).optString("aid");
    String str = ((JSONObject)localObject1).optString("traceid");
    acDQ = str;
    acDR = str;
    Log.i("MicroMsg.BizCardLogic", "saveAdData aid=" + localObject2 + " traceId=" + acDQ);
    localObject2 = (CharSequence)acDQ;
    if ((localObject2 == null) || (n.bp((CharSequence)localObject2))) {}
    for (i = 1; i == 0; i = 0)
    {
      cN((JSONObject)localObject1);
      iXi().encode(bvh("biz_ad_card_data"), paramString);
      AppMethodBeat.o(248949);
      return;
    }
    paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(100L);
    AppMethodBeat.o(248949);
  }
  
  public static JSONObject bvj(String paramString)
  {
    AppMethodBeat.i(248956);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(248956);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("advertisement_info");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0);
        AppMethodBeat.o(248956);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.BizCardLogic", "getAdData ex %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(248956);
    }
    return null;
  }
  
  public static boolean bvk(String paramString)
  {
    AppMethodBeat.i(248995);
    s.u(paramString, "canvasId");
    Log.d("MicroMsg.BizCardLogic", s.X("replaceTimelineAd lastTraceId=", acDQ));
    Object localObject = (CharSequence)acDQ;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(248995);
      return false;
    }
    localObject = paramString.substring(10);
    s.s(localObject, "(this as java.lang.String).substring(startIndex)");
    if (ad.acGg)
    {
      if (!Util.isEqual(acDQ, (String)localObject))
      {
        Log.d("MicroMsg.BizCardLogic", s.X("replaceTimelineAd is not replace traceId ", localObject));
        AppMethodBeat.o(248995);
        return false;
      }
      com.tencent.threadpool.h.ahAA.g(r..ExternalSyntheticLambda5.INSTANCE, "BizInsertTlRecCardThread");
      AppMethodBeat.o(248995);
      return true;
    }
    if (Util.isEqual(acDQ, (String)localObject))
    {
      Log.i("MicroMsg.BizCardLogic", "replaceTimelineAd but not in timeline lastTranceId=" + acDQ + ", canvasId=" + paramString);
      paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(160L);
      pF("adReplace", "err_code:2,err_msg:'not in timeline', traceid:'" + acDQ + '\'');
      acDQ = null;
    }
    AppMethodBeat.o(248995);
    return false;
  }
  
  private static void bvl(String paramString)
  {
    AppMethodBeat.i(249011);
    if (!ad.acGg)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!n.bp(localCharSequence))) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (iXu()))
      {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiH(bvg(paramString));
        paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(132L);
      }
      AppMethodBeat.o(249011);
      return;
    }
  }
  
  public static boolean bvm(String paramString)
  {
    AppMethodBeat.i(249020);
    s.u(paramString, "aid");
    boolean bool = acDO.contains(paramString);
    AppMethodBeat.o(249020);
    return bool;
  }
  
  private static final void bvn(String paramString)
  {
    AppMethodBeat.i(249043);
    Log.d("MicroMsg.BizCardLogic", s.X("replaceAdData replace lastTraceId=", acDQ));
    com.tencent.mm.plugin.webcanvas.j localj = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(156L);
    acDM.bvi(paramString);
    AppMethodBeat.o(249043);
  }
  
  private static boolean cM(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(248953);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(248953);
      return false;
    }
    long l1 = br.bCJ() / 1000L;
    long l2 = paramJSONObject.optLong("ad_expire_time", l1);
    if (l1 <= l2) {
      bool = true;
    }
    if (!bool)
    {
      com.tencent.mm.plugin.webcanvas.j localj = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(103L);
      Log.i("MicroMsg.BizCardLogic", "isAdDataValid ad expire aid=" + paramJSONObject.optString("aid") + " adExpireTime=" + l2);
    }
    AppMethodBeat.o(248953);
    return bool;
  }
  
  /* Error */
  private void cN(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1319
    //   5: invokestatic 283	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 1320
    //   12: invokestatic 517	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: invokestatic 1323	com/tencent/mm/storage/r:iXl	()Z
    //   18: ifne +12 -> 30
    //   21: ldc_w 1319
    //   24: invokestatic 289	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_1
    //   31: ldc_w 587
    //   34: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 5
    //   39: aload 5
    //   41: ldc_w 1325
    //   44: invokestatic 813	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   47: aload_1
    //   48: ldc_w 1211
    //   51: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: ldc_w 1327
    //   59: invokestatic 813	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   62: aload_1
    //   63: ldc_w 1329
    //   66: ldc_w 1331
    //   69: invokevirtual 1334	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 4
    //   74: aload 4
    //   76: ldc_w 1336
    //   79: invokestatic 813	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   82: ldc_w 519
    //   85: new 521	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 1338
    //   92: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload 5
    //   97: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 1340
    //   103: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_3
    //   107: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc_w 1342
    //   113: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 4
    //   118: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 537	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 605	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_3
    //   128: checkcast 615	java/lang/CharSequence
    //   131: invokestatic 621	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
    //   134: ifeq +126 -> 260
    //   137: iconst_1
    //   138: istore_2
    //   139: iload_2
    //   140: ifne +76 -> 216
    //   143: aload 4
    //   145: checkcast 615	java/lang/CharSequence
    //   148: invokestatic 621	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
    //   151: ifeq +114 -> 265
    //   154: iconst_1
    //   155: istore_2
    //   156: iload_2
    //   157: ifne +59 -> 216
    //   160: getstatic 549	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   163: astore 5
    //   165: ldc2_w 1343
    //   168: invokestatic 554	com/tencent/mm/plugin/webcanvas/j:xC	(J)V
    //   171: aload_3
    //   172: getstatic 1215	com/tencent/mm/storage/r:acDR	Ljava/lang/String;
    //   175: invokestatic 701	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifne +9 -> 187
    //   181: getstatic 1346	com/tencent/mm/storage/r:acDT	Ljava/lang/String;
    //   184: invokestatic 1348	com/tencent/mm/storage/r:bvl	(Ljava/lang/String;)V
    //   187: aload_3
    //   188: putstatic 1346	com/tencent/mm/storage/r:acDT	Ljava/lang/String;
    //   191: ldc_w 1093
    //   194: invokestatic 840	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   197: checkcast 1093	com/tencent/mm/plugin/brandservice/api/c
    //   200: aload 4
    //   202: aload_3
    //   203: invokestatic 1277	com/tencent/mm/storage/r:bvg	(Ljava/lang/String;)Ljava/lang/String;
    //   206: aload_1
    //   207: invokevirtual 969	org/json/JSONObject:toString	()Ljava/lang/String;
    //   210: lconst_0
    //   211: invokeinterface 1155 6 0
    //   216: ldc_w 1319
    //   219: invokestatic 289	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: goto -195 -> 27
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: ldc_w 519
    //   234: ldc_w 1350
    //   237: iconst_1
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload_1
    //   244: invokevirtual 713	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   247: aastore
    //   248: invokestatic 1233	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: ldc_w 1319
    //   254: invokestatic 289	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: goto -230 -> 27
    //   260: iconst_0
    //   261: istore_2
    //   262: goto -123 -> 139
    //   265: iconst_0
    //   266: istore_2
    //   267: goto -111 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	r
    //   0	270	1	paramJSONObject	JSONObject
    //   138	129	2	i	int
    //   54	149	3	str1	String
    //   72	129	4	str2	String
    //   37	127	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	225	finally
    //   30	127	225	finally
    //   127	137	225	finally
    //   143	154	225	finally
    //   160	187	225	finally
    //   187	216	225	finally
    //   216	222	225	finally
    //   231	257	225	finally
    //   30	127	230	java/lang/Exception
  }
  
  public static void eml()
  {
    acEm = true;
  }
  
  public static void emm()
  {
    AppMethodBeat.i(248978);
    acEm = false;
    if (acEl) {
      iXE();
    }
    AppMethodBeat.o(248978);
  }
  
  private static final int h(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(249027);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.BizCardLogic", "doBizCardCgi callback errType=" + paramInt1 + ", errCode=" + paramInt2);
      paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(1L);
      if (paramInt2 == 1004)
      {
        paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(7L);
      }
      AppMethodBeat.o(249027);
      return 0;
    }
    paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(2L);
    paramString = c.c.b(paramc.otC);
    if ((paramString instanceof fmv)) {}
    for (paramString = (fmv)paramString; paramString == null; paramString = null)
    {
      AppMethodBeat.o(249027);
      return 0;
    }
    Log.d("MicroMsg.BizCardLogic", s.X("doBizCardCgi callback ", paramString.YVP));
    Log.i("MicroMsg.BizCardLogic", "doBizCardCgi callback errType=" + paramInt1 + ", errCode=" + paramInt2 + " interval=" + Integer.valueOf(paramString.YRq));
    paramInt1 = paramString.YRq;
    if ((paramInt1 <= 259200) && (paramInt1 > 60))
    {
      acEj = paramInt1 * 1000L;
      iXi().encode("biz_card_refresh_interval", paramInt1 * 1000L);
    }
    paramc = paramString.IMu;
    if (paramc != null) {}
    try
    {
      Log.i("MicroMsg.BizCardLogic", s.X("handleExtInfo extInfo ", paramc));
      paramc = new JSONObject(paramc);
      if (paramc.has("ResortRefreshIntervalSec"))
      {
        paramInt1 = paramc.optInt("ResortRefreshIntervalSec", 0);
        if ((paramInt1 > 0) && (paramInt1 <= 259200))
        {
          acEk = paramInt1 * 1000L;
          iXi().encode("biz_card_resort_Refresh_IntervalSec", acEk);
        }
      }
      acDP = paramc.optInt("MaxAdCount", 1);
      Yjq = paramc.optInt("AdInsertPos", 3);
      iXz();
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        Log.e("MicroMsg.BizCardLogic", s.X("handleExtInfo ex ", paramc.getMessage()));
        continue;
        paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(5L);
      }
    }
    if ((paramString.YFu & 0x1) == 0)
    {
      acDM.bvi(paramString.YVP);
      paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(6L);
      AppMethodBeat.o(249027);
      return 0;
    }
  }
  
  private static long iXA()
  {
    AppMethodBeat.i(248964);
    if (acEj > 1000L)
    {
      l = acEj;
      AppMethodBeat.o(248964);
      return l;
    }
    long l = iXi().getLong("biz_card_refresh_interval", 3600000L);
    acEj = l;
    AppMethodBeat.o(248964);
    return l;
  }
  
  private static long iXB()
  {
    AppMethodBeat.i(248966);
    if (acEk > 1000L)
    {
      l = acEk;
      AppMethodBeat.o(248966);
      return l;
    }
    long l = iXi().getLong("biz_card_resort_Refresh_IntervalSec", 3600000L);
    acEk = l;
    AppMethodBeat.o(248966);
    return l;
  }
  
  private static int iXC()
  {
    int j = 0;
    AppMethodBeat.i(248970);
    int i = acDP;
    if (i > 0) {
      if (i <= 10) {
        i = 1;
      }
    }
    while (i != 0)
    {
      i = acDP;
      AppMethodBeat.o(248970);
      return i;
      i = 0;
      continue;
      i = 0;
    }
    int k = iXi().decodeInt("biz_card_max_ad_count", 1);
    acDP = k;
    i = j;
    if (k > 0)
    {
      i = j;
      if (k <= 10) {
        i = 1;
      }
    }
    if (i == 0) {
      acDP = 1;
    }
    i = acDP;
    AppMethodBeat.o(248970);
    return i;
  }
  
  public static int iXD()
  {
    int j = 1;
    AppMethodBeat.i(248974);
    if (iXk() > 0)
    {
      Log.i("MicroMsg.BizCardLogic", s.X("getAdInsertPos localInsertPos = ", Integer.valueOf(iXk())));
      i = iXk();
      AppMethodBeat.o(248974);
      return i;
    }
    int i = Yjq;
    if (2 <= i) {
      if (i <= 10) {
        i = 1;
      }
    }
    while (i != 0)
    {
      i = Yjq;
      AppMethodBeat.o(248974);
      return i;
      i = 0;
      continue;
      i = 0;
    }
    i = iXi().decodeInt("biz_card_ad_insert_pos", 3);
    Yjq = i;
    if (2 <= i) {
      if (i <= 10) {
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        Yjq = 3;
      }
      i = Yjq;
      AppMethodBeat.o(248974);
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private static void iXE()
  {
    AppMethodBeat.i(248983);
    Log.i("MicroMsg.BizCardLogic", "exposePreload reset crash flag");
    com.tencent.mm.plugin.biz.b.c localc = com.tencent.mm.plugin.biz.b.c.vtp;
    com.tencent.mm.plugin.biz.b.c.daA().encode("biz_canvas_card_expose_preload_crash_times", 0);
    AppMethodBeat.o(248983);
  }
  
  public static void iXF()
  {
    AppMethodBeat.i(248999);
    if (acEp)
    {
      AppMethodBeat.o(248999);
      return;
    }
    acEn = iXi().decodeFloat("minAdExposureRatio", acEn);
    acEo = iXi().decodeLong("minAdExposureTme", acEo);
    acEp = true;
    Log.i("MicroMsg.BizCardLogic", "initAdExposeParams exposureRatio=" + acEn + "， exposureTme=" + acEo);
    AppMethodBeat.o(248999);
  }
  
  private static ab iXG()
  {
    AppMethodBeat.i(249009);
    ab localab = af.bHl().iYw();
    if ((localab != null) && (localab.field_isRead == 0))
    {
      AppMethodBeat.o(249009);
      return localab;
    }
    AppMethodBeat.o(249009);
    return null;
  }
  
  private static String iXH()
  {
    AppMethodBeat.i(249025);
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (atj().getInt("BizTimeLineAdMockType", 0) == 0) {}
    for (Object localObject = acEr;; localObject = acEq)
    {
      localJSONArray.put(new JSONObject((String)localObject));
      localObject = kotlin.ah.aiuX;
      localJSONObject.put("advertisement_info", localJSONArray);
      localJSONObject.put("advertisement_num", 1);
      localObject = localJSONObject.toString();
      s.s(localObject, "adData.toString()");
      AppMethodBeat.o(249025);
      return localObject;
    }
  }
  
  private static final void iXI()
  {
    AppMethodBeat.i(249030);
    iXE();
    acEl = false;
    AppMethodBeat.o(249030);
  }
  
  private static final void iXJ()
  {
    boolean bool = true;
    AppMethodBeat.i(249042);
    if (s.p(acDS, acDQ))
    {
      Log.d("MicroMsg.BizCardLogic", s.X("replaceTimelineAd lastTranceId=lastReplaceTranceId=", acDS));
      AppMethodBeat.o(249042);
      return;
    }
    acDS = acDQ;
    Object localObject1 = af.bHl().iYw();
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label623;
      }
      localObject1 = acDQ;
      if (localObject1 == null) {
        break label623;
      }
      Log.i("MicroMsg.BizCardLogic", "replaceTimelineAd ad not exist");
      localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(159L);
      if (hAt > 0)
      {
        localObject1 = new ar();
        ((ar)localObject1).hAs.hAt = hAt;
        ((ar)localObject1).publish();
        AppMethodBeat.o(249042);
      }
    }
    else
    {
      if (((ab)localObject1).field_isRead == 0)
      {
        if (Util.isEqual(((ab)localObject1).getTraceId(), acDQ))
        {
          Log.d("MicroMsg.BizCardLogic", "replaceTimelineAd is same ad lastTraceId=" + acDQ + '}');
          localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(161L);
          pF("adReplace", "err_code:4,err_msg:'same traceid', traceid:'" + acDQ + '\'');
          AppMethodBeat.o(249042);
          return;
        }
        ((ab)localObject1).field_content = iXi().decodeString(bvh("biz_ad_card_data"));
        ((ab)localObject1).field_createTime = br.bCJ();
        localObject2 = af.bHl();
        Object localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("content", ((ab)localObject1).field_content);
        ((ContentValues)localObject3).put("createTime", Long.valueOf(((ab)localObject1).field_createTime));
        int i = ((ac)localObject2).omV.update("BizTimeLineInfo", (ContentValues)localObject3, " msgId = ?", new String[] { ((ab)localObject1).field_msgId });
        if (i > 0)
        {
          localObject3 = new ac.a();
          ((ac.a)localObject3).talker = ((ab)localObject1).field_talker;
          ((ac.a)localObject3).list = new LinkedList();
          ((ac.a)localObject3).list.add(localObject1);
          ((ac.a)localObject3).acFX = ac.b.acGb;
          ((ac)localObject2).a((ac.a)localObject3);
        }
        if (i > 0)
        {
          label392:
          iXi().encode(bvh("biz_ad_card_data"), "");
          localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(157L);
          pF("adReplace", "err_code:0,err_msg:'ok', traceid:'" + acDQ + '\'');
          acDQ = null;
          acDT = null;
          Log.i("MicroMsg.BizCardLogic", "replaceTimelineAd result: " + bool + ", msgId:" + ((ab)localObject1).field_msgId + " orderFlag:" + ((ab)localObject1).field_orderFlag + " aid: " + ((ab)localObject1).iYs() + " traceid:" + ((ab)localObject1).getTraceId());
        }
      }
      for (;;)
      {
        localObject1 = kotlin.ah.aiuX;
        break;
        bool = false;
        break label392;
        Log.i("MicroMsg.BizCardLogic", "replaceTimelineAd ad exposed");
        localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(158L);
        pF("adReplace", "err_code:1,err_msg:'ad exposed', traceid:'" + acDQ + '\'');
      }
    }
    pF("adReplace", "err_code:5,err_msg:'ad not exist', traceid:'" + (String)localObject1 + '\'');
    label623:
    AppMethodBeat.o(249042);
  }
  
  public static MultiProcessMMKV iXi()
  {
    AppMethodBeat.i(248853);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)acDU.getValue();
    AppMethodBeat.o(248853);
    return localMultiProcessMMKV;
  }
  
  private static int iXj()
  {
    AppMethodBeat.i(248856);
    int i = ((Number)acDV.getValue()).intValue();
    AppMethodBeat.o(248856);
    return i;
  }
  
  private static int iXk()
  {
    AppMethodBeat.i(248859);
    int i = ((Number)acDW.getValue()).intValue();
    AppMethodBeat.o(248859);
    return i;
  }
  
  public static boolean iXl()
  {
    AppMethodBeat.i(248867);
    if ((!((com.tencent.mm.api.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.r.class)).aBu()) && (((Boolean)acDX.getValue()).booleanValue()))
    {
      AppMethodBeat.o(248867);
      return true;
    }
    AppMethodBeat.o(248867);
    return false;
  }
  
  private static boolean iXm()
  {
    AppMethodBeat.i(248875);
    if (atj().decodeInt("BizTimeLineAdPreviewMode", 0) == 1)
    {
      long l = atj().decodeLong("BizTimeLineAdPreviewModeTime", 0L);
      if (l <= 0L)
      {
        AppMethodBeat.o(248875);
        return false;
      }
      if (System.currentTimeMillis() - l < 86400000L)
      {
        AppMethodBeat.o(248875);
        return true;
      }
      AppMethodBeat.o(248875);
      return false;
    }
    AppMethodBeat.o(248875);
    return false;
  }
  
  public static boolean iXn()
  {
    AppMethodBeat.i(248879);
    if ((iXj() > 0) || (iXm()))
    {
      AppMethodBeat.o(248879);
      return true;
    }
    AppMethodBeat.o(248879);
    return false;
  }
  
  public static boolean iXo()
  {
    AppMethodBeat.i(248884);
    boolean bool = ((Boolean)acDY.getValue()).booleanValue();
    AppMethodBeat.o(248884);
    return bool;
  }
  
  public static boolean iXp()
  {
    AppMethodBeat.i(248890);
    if ((((Boolean)acDZ.getValue()).booleanValue()) && (iXl()))
    {
      AppMethodBeat.o(248890);
      return true;
    }
    AppMethodBeat.o(248890);
    return false;
  }
  
  public static boolean iXq()
  {
    AppMethodBeat.i(248897);
    boolean bool = ((Boolean)acEa.getValue()).booleanValue();
    AppMethodBeat.o(248897);
    return bool;
  }
  
  public static boolean iXr()
  {
    AppMethodBeat.i(248903);
    boolean bool = ((Boolean)acEb.getValue()).booleanValue();
    AppMethodBeat.o(248903);
    return bool;
  }
  
  private static boolean iXs()
  {
    AppMethodBeat.i(248908);
    boolean bool = ((Boolean)acEc.getValue()).booleanValue();
    AppMethodBeat.o(248908);
    return bool;
  }
  
  public static boolean iXt()
  {
    AppMethodBeat.i(248913);
    boolean bool = ((Boolean)acEd.getValue()).booleanValue();
    AppMethodBeat.o(248913);
    return bool;
  }
  
  private static boolean iXu()
  {
    AppMethodBeat.i(248917);
    boolean bool = ((Boolean)acEe.getValue()).booleanValue();
    AppMethodBeat.o(248917);
    return bool;
  }
  
  public static boolean iXv()
  {
    AppMethodBeat.i(248923);
    boolean bool = ((Boolean)acEf.getValue()).booleanValue();
    AppMethodBeat.o(248923);
    return bool;
  }
  
  public static boolean iXw()
  {
    AppMethodBeat.i(248928);
    boolean bool = ((Boolean)acEg.getValue()).booleanValue();
    AppMethodBeat.o(248928);
    return bool;
  }
  
  public static boolean iXx()
  {
    AppMethodBeat.i(248930);
    boolean bool = ((Boolean)acEh.getValue()).booleanValue();
    AppMethodBeat.o(248930);
    return bool;
  }
  
  public static void iXz()
  {
    int j = 0;
    AppMethodBeat.i(248960);
    iXi().encode("biz_card_max_ad_count", acDP);
    int k = Yjq;
    int i = j;
    if (2 <= k)
    {
      i = j;
      if (k <= 10) {
        i = 1;
      }
    }
    if (i != 0) {
      iXi().encode("biz_card_ad_insert_pos", Yjq);
    }
    AppMethodBeat.o(248960);
  }
  
  public static boolean kLW()
  {
    AppMethodBeat.i(369609);
    boolean bool = ((Boolean)aklt.getValue()).booleanValue();
    AppMethodBeat.o(369609);
    return bool;
  }
  
  public static void mG(List<? extends ab> paramList)
  {
    AppMethodBeat.i(248985);
    s.u(paramList, "list");
    if ((!iXl()) || (Util.isNullOrNil(paramList)))
    {
      AppMethodBeat.o(248985);
      return;
    }
    if (iXj() == 1)
    {
      AppMethodBeat.o(248985);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject5;
    Object localObject4;
    label158:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject5 = (ab)localObject2;
      localObject4 = vCc;
      localObject5 = ((ab)localObject5).iYs();
      s.s(localObject5, "it.aId");
      if (!((com.tencent.mm.an.r)localObject4).contains((String)localObject5)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label158;
        }
        paramList.add(localObject2);
        break;
      }
    }
    localObject1 = (List)paramList;
    paramList = new JSONArray();
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ab)((Iterator)localObject1).next();
      localObject4 = new JSONObject();
      try
      {
        Object localObject6 = ((ab)localObject2).iYr();
        localObject5 = ((JSONObject)localObject6).optString("aid");
        ((JSONObject)localObject4).put("aid", localObject5);
        Object localObject7 = ((JSONObject)localObject6).optString("reranking_ext_info");
        if (localObject7 != null)
        {
          localObject7 = new JSONObject((String)localObject7);
          ((JSONObject)localObject4).put("tid", String.valueOf(((JSONObject)localObject7).optLong("tid", 0L)));
          ((JSONObject)localObject4).put("material_hash", ((JSONObject)localObject7).optString("material_hash"));
        }
        ((JSONObject)localObject4).put("trace_id", ((JSONObject)localObject6).optString("traceid"));
        localObject6 = (Map)acDN;
        s.s(localObject5, "aid");
        ((Map)localObject6).put(localObject5, Long.valueOf(((ab)localObject2).field_msgId));
        localLinkedList.add(localObject5);
        paramList.put(localObject4);
        vCc.add((String)localObject5);
        i = 1;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BizCardLogic", s.X("checkAd ex ", localException.getMessage()));
      }
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("ads", paramList);
    paramList = ((JSONObject)localObject1).toString();
    s.s(paramList, "list?.filter {\n         …  }?.toString()\n        }");
    if (n.bp((CharSequence)paramList)) {}
    for (int j = 1; (j != 0) || (i == 0); j = 0)
    {
      AppMethodBeat.o(248985);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(16L);
    localObject1 = new c.a();
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)new fmu());
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new fmv());
    ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/recommend/timelinecard";
    ((c.a)localObject1).funcId = 2781;
    localObject1 = ((c.a)localObject1).bEF();
    Object localObject3 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
    if (localObject3 == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(248985);
      throw paramList;
    }
    localObject3 = (fmu)localObject3;
    ((fmu)localObject3).YVJ = System.currentTimeMillis();
    ((fmu)localObject3).YVO = 2;
    ((fmu)localObject3).YVP = paramList;
    z.a((com.tencent.mm.am.c)localObject1, new r..ExternalSyntheticLambda0(localLinkedList));
    AppMethodBeat.o(248985);
  }
  
  public static void pF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248991);
    ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).m("wxa06c02b5c00ff39b", null, paramString1, paramString2);
    AppMethodBeat.o(248991);
  }
  
  public static void replaceAdData(String paramString)
  {
    AppMethodBeat.i(249001);
    com.tencent.threadpool.h.ahAA.g(new r..ExternalSyntheticLambda3(paramString), "BizInsertTlRecCardThread");
    AppMethodBeat.o(249001);
  }
  
  public static void setAdInsertType(int paramInt)
  {
    AppMethodBeat.i(248998);
    Log.i("MicroMsg.BizCardLogic", s.X("setAdInsertType ", Integer.valueOf(paramInt)));
    hAt = paramInt;
    AppMethodBeat.o(248998);
  }
  
  public final boolean B(ab paramab)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(249097);
        s.u(paramab, "info");
        if (paramab.iYg())
        {
          if (!iXl())
          {
            AppMethodBeat.o(249097);
            bool = false;
            return bool;
          }
          long l = paramab.field_msgId;
          Log.d("MicroMsg.BizCardLogic", "preload ad card");
          localObject = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(8L);
          com.tencent.mm.plugin.brandservice.api.c localc = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
          localObject = (CharSequence)paramab.iYt();
          if (localObject == null) {
            break label200;
          }
          if (!n.bp((CharSequence)localObject)) {
            break label202;
          }
          break label200;
          String str = paramab.getTraceId();
          s.s(str, "info.traceId");
          localc.a((String)localObject, bvg(str), paramab.iYq(), l);
          AppMethodBeat.o(249097);
          bool = true;
          continue;
          localObject = paramab.iYt();
          continue;
        }
        if (paramab.iYf())
        {
          bool = b(paramab.iYp(), paramab);
          AppMethodBeat.o(249097);
          continue;
        }
        AppMethodBeat.o(249097);
      }
      finally {}
      boolean bool = false;
      continue;
      label200:
      i = 1;
      label202:
      if (i != 0) {
        localObject = "ad";
      }
    }
  }
  
  /* Error */
  public final boolean C(ab paramab)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 1766
    //   7: invokestatic 283	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_1
    //   11: ldc_w 1037
    //   14: invokestatic 517	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_1
    //   18: getfield 1770	com/tencent/mm/storage/ab:acFJ	Lcom/tencent/mm/protocal/protobuf/ene;
    //   21: astore 6
    //   23: aload 6
    //   25: ifnull +92 -> 117
    //   28: aload 6
    //   30: invokestatic 1773	com/tencent/mm/storage/ah:b	(Lcom/tencent/mm/protocal/protobuf/ene;)Z
    //   33: iconst_1
    //   34: if_icmpne +83 -> 117
    //   37: iconst_1
    //   38: istore_2
    //   39: iload_2
    //   40: ifeq +82 -> 122
    //   43: aload_1
    //   44: getfield 928	com/tencent/mm/storage/ab:field_msgId	J
    //   47: lstore 4
    //   49: ldc_w 519
    //   52: ldc_w 1775
    //   55: invokestatic 1136	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: getstatic 549	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   61: astore 6
    //   63: ldc2_w 1137
    //   66: invokestatic 554	com/tencent/mm/plugin/webcanvas/j:xC	(J)V
    //   69: ldc_w 1093
    //   72: invokestatic 840	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   75: checkcast 1093	com/tencent/mm/plugin/brandservice/api/c
    //   78: ldc_w 1777
    //   81: ldc_w 1779
    //   84: aload_1
    //   85: getfield 1770	com/tencent/mm/storage/ab:acFJ	Lcom/tencent/mm/protocal/protobuf/ene;
    //   88: getfield 1784	com/tencent/mm/protocal/protobuf/ene:YSF	Ljava/lang/String;
    //   91: invokestatic 603	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   94: aload_1
    //   95: invokevirtual 1787	com/tencent/mm/storage/ab:iYv	()Ljava/lang/String;
    //   98: lload 4
    //   100: invokeinterface 1155 6 0
    //   105: ldc_w 1766
    //   108: invokestatic 289	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iconst_1
    //   112: istore_3
    //   113: aload_0
    //   114: monitorexit
    //   115: iload_3
    //   116: ireturn
    //   117: iconst_0
    //   118: istore_2
    //   119: goto -80 -> 39
    //   122: ldc_w 1766
    //   125: invokestatic 289	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: goto -15 -> 113
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	r
    //   0	136	1	paramab	ab
    //   38	81	2	i	int
    //   1	115	3	bool	boolean
    //   47	52	4	l	long
    //   21	41	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	23	131	finally
    //   28	37	131	finally
    //   43	111	131	finally
    //   122	128	131	finally
  }
  
  public final void ax(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(249105);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(249105);
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    while (i != 0)
    {
      i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
      if (i != -1)
      {
        if (paramString == null)
        {
          paramMap = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(249105);
          throw paramMap;
          i = 0;
        }
        else
        {
          paramMap = paramString.substring(i);
          s.s(paramMap, "(this as java.lang.String).substring(startIndex)");
          localObject = XmlParser.parseXml(paramMap, "sysmsg", null);
          paramMap = (Map<String, String>)localObject;
          if (localObject == null)
          {
            Log.e("MicroMsg.BizCardLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
            AppMethodBeat.o(249105);
          }
        }
      }
      else
      {
        AppMethodBeat.o(249105);
        return;
      }
    }
    localObject = (String)paramMap.get(".sysmsg.BizAdNotify.previewMode");
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    i = Util.getInt(paramString, -1);
    paramString = (String)paramMap.get(".sysmsg.BizAdNotify.adCmd");
    paramMap = paramString;
    if (paramString == null) {
      paramMap = "";
    }
    if (i != -1)
    {
      paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(140L);
      atj().encode("BizTimeLineAdPreviewMode", i);
      atj().encode("BizTimeLineAdCmd", paramMap);
      if (i == 1) {
        atj().encode("BizTimeLineAdPreviewModeTime", System.currentTimeMillis());
      }
    }
    while (iXp())
    {
      Log.i("MicroMsg.BizCardLogic", "onAdNotify, adPreviewMode=" + i + ", adCmd=" + paramMap);
      pF("onAdNotify", "previewMode:" + i + ", adCmd:'" + paramMap + '\'');
      AppMethodBeat.o(249105);
      return;
      paramString = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(141L);
    }
    AppMethodBeat.o(249105);
  }
  
  public final void ayv(int paramInt)
  {
    AppMethodBeat.i(249074);
    if (!iXl())
    {
      AppMethodBeat.o(249074);
      return;
    }
    if (iXj() == 1)
    {
      bvi(iXH());
      iXi().encode("biz_card_last_time", System.currentTimeMillis());
      AppMethodBeat.o(249074);
      return;
    }
    if (iXp())
    {
      if ((!iXn()) && (Math.abs(System.currentTimeMillis() - AfG) < 300000L))
      {
        Log.d("MicroMsg.BizCardLogic", s.X("doBizCardCgi delta < interval, return from=", Integer.valueOf(paramInt)));
        AppMethodBeat.o(249074);
        return;
      }
      AfG = System.currentTimeMillis();
      Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + iXj() + ", adPreviewMode=" + iXm() + ", from=" + paramInt);
      if (2 == paramInt) {}
      for (localObject1 = "mainCellExpose";; localObject1 = "resortEnd")
      {
        pF((String)localObject1, s.X("from:", Integer.valueOf(paramInt)));
        AppMethodBeat.o(249074);
        return;
      }
    }
    long l2 = iXi().getLong("biz_card_last_time", 0L);
    long l3 = System.currentTimeMillis();
    long l4 = Math.abs(l3 - l2);
    if (paramInt == 1) {}
    for (long l1 = iXB(); (3 != paramInt) && (((!iXn()) && (l4 < l1)) || ((iXn()) && (l4 < 10000L))); l1 = iXA())
    {
      Log.d("MicroMsg.BizCardLogic", s.X("doBizCardCgi delta < interval, return from=", Integer.valueOf(paramInt)));
      AppMethodBeat.o(249074);
      return;
    }
    iXi().encode("biz_card_last_time", System.currentTimeMillis());
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)new fmu());
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new fmv());
    ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/recommend/timelinecard";
    ((c.a)localObject1).funcId = 2781;
    localObject1 = ((c.a)localObject1).bEF();
    Object localObject2 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(249074);
      throw ((Throwable)localObject1);
    }
    localObject2 = (fmu)localObject2;
    ((fmu)localObject2).YVJ = System.currentTimeMillis();
    ((fmu)localObject2).YVO = 1;
    ((fmu)localObject2).YSF = "";
    ((fmu)localObject2).YVP = ayw(paramInt);
    Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + iXj() + ", adPreviewMode=" + iXm() + " from=" + paramInt + " interval=" + l1 + " lastTime=" + l2 + " currentMills=" + l3);
    localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(0L);
    z.a((com.tencent.mm.am.c)localObject1, r..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(249074);
  }
  
  public final boolean cy(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(249087);
    if (!iXl())
    {
      AppMethodBeat.o(249087);
      return false;
    }
    if ((acEi) && (!paramBoolean))
    {
      Log.i("MicroMsg.BizCardLogic", "insertAd return for not replaceAd");
      AppMethodBeat.o(249087);
      return false;
    }
    int i;
    label71:
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      i = 1;
      if (ad.iYQ()) {
        break label400;
      }
      if (!iXp()) {
        break label390;
      }
      af.bHl().iYI();
      Log.i("MicroMsg.BizCardLogic", "insertAd replaceAd=" + paramBoolean + ", insertType:'" + hAt + "', insertPos=" + paramInt);
      localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(29L);
      localObject3 = iXi().decodeString(bvh("biz_ad_card_data"));
      localObject1 = iXG();
      if ((localObject1 == null) || (cM(((ab)localObject1).iYr()))) {
        break label1737;
      }
      af.bHl().yQ(((ab)localObject1).field_msgId);
      bvl(((ab)localObject1).getTraceId());
      Log.i("MicroMsg.BizCardLogic", "insertAd delete expire ad aid=" + ((ab)localObject1).iYs() + ", tranceId=" + ((ab)localObject1).getTraceId());
      localObject1 = null;
    }
    label256:
    label390:
    label400:
    label424:
    label437:
    label1725:
    label1737:
    for (;;)
    {
      Object localObject4 = bvj((String)localObject3);
      Object localObject2 = (CharSequence)acDR;
      if ((localObject2 == null) || (n.bp((CharSequence)localObject2)))
      {
        j = 1;
        if (j != 0) {
          if (localObject4 != null) {
            break label424;
          }
        }
      }
      for (localObject2 = null;; localObject2 = ((JSONObject)localObject4).optString("traceid"))
      {
        acDR = (String)localObject2;
        if ((paramBoolean) || (cM((JSONObject)localObject4))) {
          break label613;
        }
        Log.w("MicroMsg.BizCardLogic", "insertAd ad data invalid");
        if (!Util.isNullOrNil((String)localObject3))
        {
          iXi().encode(bvh("biz_ad_card_data"), "");
          localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(102L);
        }
        localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(30L);
        if (localObject1 == null) {
          break label605;
        }
        l = a(acDM, ((ab)localObject1).field_orderFlag);
        if ((((ab)localObject1).field_orderFlag != l) && (l > 0L)) {
          break label437;
        }
        AppMethodBeat.o(249087);
        return false;
        i = 0;
        break;
        af.bHl().ayC(1);
        break label71;
        if ((paramBoolean) || (iXn())) {
          break label71;
        }
        AppMethodBeat.o(249087);
        return false;
        j = 0;
        break label256;
      }
      ((ab)localObject1).field_orderFlag = l;
      localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(36L);
      acDM.B((ab)localObject1);
      paramBoolean = af.bHl().d((ab)localObject1, true);
      pF("adInsert", "err_code:0,err_msg:'move ad position', traceid:'" + acDR + "', insertType:'" + hAt + "', insertAction:'" + i + '\'');
      Log.i("MicroMsg.BizCardLogic", "insertAd updateById result: " + paramBoolean + ", msgId:" + ((ab)localObject1).field_msgId + " orderFlag:" + ((ab)localObject1).field_orderFlag + " aid: " + ((ab)localObject1).iYs() + " traceId: " + ((ab)localObject1).getTraceId());
      label605:
      AppMethodBeat.o(249087);
      return false;
      label613:
      int j = af.bHl().dWF();
      if ((!iXn()) && (j <= 3))
      {
        Log.i("MicroMsg.BizCardLogic", s.X("insertAd return for: msgCount = ", Integer.valueOf(j)));
        pF("adInsert", "err_code:1,err_msg:'msg size invalid', traceid:'" + acDR + "', insertType:'" + hAt + "', insertAction:'" + i + '\'');
        AppMethodBeat.o(249087);
        return false;
      }
      localObject4 = af.bHl().iYx();
      if (localObject4 == null)
      {
        Log.i("MicroMsg.BizCardLogic", "insertAd lastTimeLineInfo is null");
        AppMethodBeat.o(249087);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(31L);
      com.tencent.mm.plugin.report.service.h.OAn.b(20636, new Object[] { "", "", Integer.valueOf(4) });
      long l = af.bHl().iYD();
      localObject2 = new ab();
      ((ab)localObject2).field_content = ((String)localObject3);
      ((ab)localObject2).field_type = 637534257;
      if ((iXq()) && (!iXn()) && (af.bHl().yS(l << 32) != null))
      {
        Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a recCard", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.report.service.h.OAn.b(20636, new Object[] { ((ab)localObject2).iYs(), ((ab)localObject2).getTraceId(), Integer.valueOf(1) });
        localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(34L);
        pF("adInsert", "err_code:2,err_msg:'rec conflict', traceid:'" + acDR + "', insertType:'" + hAt + "', insertAction:'" + i + '\'');
        AppMethodBeat.o(249087);
        return false;
      }
      j = 0;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(37L);
        af.bHl().ayC(0);
        bvl(((ab)localObject1).getTraceId());
        j = 1;
        Log.d("MicroMsg.BizCardLogic", "insertAd delete un expose ad");
      }
      if (!iXn())
      {
        int k = af.bHm().iXg();
        if (k >= iXC())
        {
          Log.i("MicroMsg.BizCardLogic", s.X("insertAd too much ad count=", Integer.valueOf(k)));
          localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(32L);
          com.tencent.mm.plugin.report.service.h.OAn.b(20636, new Object[] { ((ab)localObject2).iYs(), ((ab)localObject2).getTraceId(), Integer.valueOf(3) });
          pF("adInsert", "err_code:3,err_msg:'ad count limit', traceid:'" + acDR + "', insertType:'" + hAt + "', insertAction:'" + i + '\'');
          AppMethodBeat.o(249087);
          return false;
        }
      }
      else
      {
        Log.i("MicroMsg.BizCardLogic", "insertAd delete all ad msg");
        af.bHl().iYJ();
      }
      if (af.bHl().yT(l << 32) != null)
      {
        Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a adCard", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.report.service.h.OAn.b(20636, new Object[] { ((ab)localObject2).iYs(), ((ab)localObject2).getTraceId(), Integer.valueOf(2) });
        localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(33L);
        pF("adInsert", "err_code:4,err_msg:'ad conflict', traceid:'" + acDR + "', insertType:'" + hAt + "', insertAction:'" + i + '\'');
        AppMethodBeat.o(249087);
        return false;
      }
      ((ab)localObject2).field_msgId = af.bHl().iYH();
      ((ab)localObject2).field_msgSvrId = 0L;
      ((ab)localObject2).field_talker = "";
      ((ab)localObject2).field_talkerId = 0;
      ((ab)localObject2).field_hasShow = 1;
      ((ab)localObject2).field_createTime = br.bCJ();
      if (((ab)localObject4).iYg()) {}
      for (l = ((ap)localObject4).jUt;; l = ((ab)localObject4).field_createTime)
      {
        ((ab)localObject2).gM(l);
        ((ab)localObject2).po(1);
        ((ab)localObject2).field_status = 3;
        ((ab)localObject2).field_orderFlag = aN(0L, paramInt);
        if (((ab)localObject2).field_orderFlag > 0L) {
          break;
        }
        AppMethodBeat.o(249087);
        return false;
      }
      acDT = null;
      iXi().encode(bvh("biz_ad_card_data"), "");
      B((ab)localObject2);
      boolean bool = af.bHl().E((ab)localObject2);
      Log.i("MicroMsg.BizCardLogic", "insertAd result: " + bool + ", msgId:" + ((ab)localObject2).field_msgId + " orderFlag:" + ((ab)localObject2).field_orderFlag + " aid: " + ((ab)localObject2).iYs() + " traceId: " + ((ab)localObject2).getTraceId());
      com.tencent.mm.plugin.report.service.h.OAn.b(20636, new Object[] { ((ab)localObject2).iYs(), ((ab)localObject2).getTraceId(), Integer.valueOf(0) });
      localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(35L);
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
        if (hAt == 1)
        {
          l = 170L;
          com.tencent.mm.plugin.webcanvas.j.xC(l);
        }
      }
      else
      {
        if (j == 0)
        {
          localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(38L);
        }
        if (!bool) {
          break label1725;
        }
        af.bHm().bvf(((ab)localObject2).getTraceId());
        pF("adInsert", "err_code:0,err_msg:'ok', traceid:'" + acDR + "', insertType:'" + hAt + "', insertAction:'" + i + '\'');
      }
      for (;;)
      {
        AppMethodBeat.o(249087);
        return true;
        l = 179L;
        break;
        Log.i("MicroMsg.BizCardLogic", "insert fail");
      }
    }
  }
  
  public final void iXy()
  {
    long l2 = 0L;
    int i = 0;
    AppMethodBeat.i(249067);
    ayv(2);
    if ((Bwq) || (!iXx()))
    {
      Log.d("MicroMsg.BizCardLogic", "exposePreload hasPreload=" + Bwq + ", canvasPreloadOpen=" + iXx());
      AppMethodBeat.o(249067);
      return;
    }
    Bwq = true;
    Object localObject = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(14L);
    localObject = com.tencent.mm.plugin.biz.b.c.vtp;
    int j = com.tencent.mm.plugin.biz.b.c.daA().decodeInt("biz_canvas_card_expose_preload_crash_times", 0);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      i = 1;
    }
    localObject = com.tencent.mm.plugin.biz.b.c.vtp;
    r..ExternalSyntheticLambda2 localExternalSyntheticLambda2;
    if (i != 0)
    {
      l1 = 0L;
      if (com.tencent.mm.plugin.biz.b.c.b(j, l1, "biz_canvas_card_expose_preload_last_time", 11L))
      {
        localObject = com.tencent.threadpool.h.ahAA;
        localExternalSyntheticLambda2 = new r..ExternalSyntheticLambda2(j);
        l1 = l2;
        if (System.currentTimeMillis() - PluginBiz.startTime <= 20000L)
        {
          l1 = l2;
          if (!BuildInfo.DEBUG) {
            if (!BuildInfo.IS_FLAVOR_RED) {
              break label223;
            }
          }
        }
      }
    }
    label223:
    for (long l1 = l2;; l1 = 10000L)
    {
      ((i)localObject).p(localExternalSyntheticLambda2, l1);
      AppMethodBeat.o(249067);
      return;
      l1 = 600000L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */
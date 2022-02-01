package com.tencent.mm.storage;

import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.erm;
import com.tencent.mm.protocal.protobuf.ern;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizCardLogic;", "", "()V", "AD_COUNT_ONE_DAY", "", "AD_COUNT_ONE_DAY_MAX", "BIZ_AD_CARD_INSERT_POS", "CHECK_AD_INTERVAL", "DEFAULT_REFRESH_INTERVAL", "", "FROM_MAIN_CELL_EXPOSE", "FROM_MSG_RESORT", "FROM_TEST_PUSH", "KEY_BIZ_AD_CARD_DATA", "", "KEY_BIZ_AD_INSERT_POS", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CANVAS_LAST_TIME", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CRASH_TIMES", "KEY_BIZ_MAX_AD_COUNT", "KEY_BIZ_REFRESH_INTERVAL", "KEY_BIZ_REFRESH_LAST_TIME", "KEY_BIZ_ResortRefreshIntervalSec", "TAG", "aIdMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "adCardPrefix", "adMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getAdMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "adMmkv$delegate", "Lkotlin/Lazy;", "adOpen", "", "getAdOpen", "()Z", "adOpen$delegate", "adPreviewMode", "getAdPreviewMode", "canvasPreloadOpen", "getCanvasPreloadOpen", "canvasPreloadOpen$delegate", "checkedAIdSet", "Ljava/util/HashSet;", "exposeRefreshInterval", "getExposeRefreshInterval", "()J", "setExposeRefreshInterval", "(J)V", "hasPreload", "hasSetCrashFlag", "insertPos", "isForeGround", "lastAId", "getLastAId", "()Ljava/lang/String;", "setLastAId", "(Ljava/lang/String;)V", "lastPreloadAId", "getLastPreloadAId", "setLastPreloadAId", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "localInsertPos", "getLocalInsertPos", "()I", "localInsertPos$delegate", "maxAdCount", "mmkv", "getMmkv", "mmkv$delegate", "mockAdData", "getMockAdData", "mockPicAdData", "mockVideoAdData", "openRecyclePreLoadedAd", "getOpenRecyclePreLoadedAd", "openRecyclePreLoadedAd$delegate", "prefetchOpen", "getPrefetchOpen", "prefetchOpen$delegate", "recConflictOpen", "getRecConflictOpen", "recConflictOpen$delegate", "recOpen", "getRecOpen", "recOpen$delegate", "resortRefreshInterval", "getResortRefreshInterval", "setResortRefreshInterval", "testMode", "getTestMode", "testMode$delegate", "triggerDownLoadPkgOnGetAdData", "getTriggerDownLoadPkgOnGetAdData", "triggerDownLoadPkgOnGetAdData$delegate", "triggerDownLoadPkgOnGetRecData", "getTriggerDownLoadPkgOnGetRecData", "triggerDownLoadPkgOnGetRecData$delegate", "bizBoxClick", "", "checkAd", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doBizCardCgi", "from", "exposePreload", "getAdDataObject", "Lorg/json/JSONObject;", "content", "getAdInsertPos", "getExposeInterval", "getLastUnExposedAd", "getMaxAdCount", "getOrderFlag", "defOrderFlag", "getResortInterval", "getTimeLineContext", "handleExtInfo", "extInfo", "Lcom/tencent/mm/protocal/protobuf/AdvertisementExtInfo;", "insertAd", "isAdChecked", "aid", "isAdDataValid", "adData", "onAppBackground", "onAppForeground", "onBizAdNotify", "valuesMap", "", "msgContent", "onMainCellExpose", "preloadAdCard", "preloadCanvasCard", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "info", "preloadRecFeedCanvasCard", "preloadUnInsertAdCard", "preloadUnInsertRecCard", "recyclePreloadAdCard", "aId", "replaceAdData", "data", "replaceTimelineAd", "canvasId", "resetClashFlag", "saveAdData", "updateExtInfo", "updateInterval", "interval", "toAccountKey", "BizCardFlag", "BusinessId", "plugin-biz_release"})
public final class r
{
  public static int Rna;
  private static final HashMap<String, Long> VcA;
  private static final HashSet<String> VcB;
  public static int VcC;
  private static String VcD;
  static String VcE;
  private static final f VcF;
  private static final f VcG;
  private static final f VcH;
  private static final f VcI;
  private static final f VcJ;
  private static final f VcK;
  private static final f VcL;
  private static final f VcM;
  private static final f VcN;
  private static final f VcO;
  private static final f VcP;
  private static long VcQ;
  static long VcR;
  private static boolean VcS;
  private static boolean VcT;
  private static final String VcU;
  private static final String VcV;
  public static final r VcW;
  private static final f lrB;
  private static final com.tencent.mm.ao.r swu;
  static boolean xVQ;
  
  static
  {
    AppMethodBeat.i(206098);
    VcW = new r();
    swu = new com.tencent.mm.ao.r(600000);
    VcA = new HashMap();
    VcB = new HashSet();
    VcC = -1;
    Rna = -1;
    lrB = g.ar((kotlin.g.a.a)h.Vdf);
    VcF = g.ar((kotlin.g.a.a)a.VcX);
    VcG = g.ar((kotlin.g.a.a)o.Vdl);
    VcH = g.ar((kotlin.g.a.a)g.Vde);
    VcI = g.ar((kotlin.g.a.a)b.VcY);
    VcJ = g.ar((kotlin.g.a.a)l.Vdj);
    VcK = g.ar((kotlin.g.a.a)j.Vdh);
    VcL = g.ar((kotlin.g.a.a)k.Vdi);
    VcM = g.ar((kotlin.g.a.a)p.Vdm);
    VcN = g.ar((kotlin.g.a.a)q.Vdn);
    VcO = g.ar((kotlin.g.a.a)i.Vdg);
    VcP = g.ar((kotlin.g.a.a)c.VcZ);
    VcT = true;
    VcU = "  {\n  \"hint_txt\": \"创意-20200601_1\",\n  \"url\": \"http://e.cn.miaozhen.com/r/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=95e085c866db2ca4da4529b48423634da3737d13156ab08310b6c0d6b29adcaa89dc88172fab7fc8425d0e54f740947d&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"traceid\": \"wx0p67bjetlwkdc200\",\n  \"group_id\": \"wx0p67bjetlwkdc200_wx0p67bjetlwkdc201\",\n  \"ticket\": \"\",\n  \"aid\": \"274376350\",\n  \"pathType\": \"ad\",\n  \"pt\": 2,\n  \"image_url\": \"http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx2c1dad7332964d7d\",\n  \"biz_info\": {\n    \"user_name\": \"gh_f60cb6e1bbe0\",\n    \"nick_name\": \"新加坡旅游局\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM7ibCaN09GMnHSZNhcA9G36v9vhgIUy8OYX4PmcPwvg5Mw/0\",\n    \"biz_uin\": 3580351467,\n    \"signature\": \"心想狮城\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 0,\n  \"dest_type\": 1,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"998\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:1,&quot;jump_url&quot;:&quot;http:\\\\/\\\\/e.cn.miaozhen.com\\\\/r\\\\/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=6d7c64459169785a1510691ed6578b66d61408173f47c29e364658492046fbd0f7f55ad59c1e22f9fc7b42b8c5a84314&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"274376350|wx0p67bjetlwkdc200|255437066|0|1594265023|0|0|72058780271891663||AgKTRVlIlM5171j831mAsV9KhXn1D6AO9t0OzsoUSabfNucHFl9DpvWA4VsIAsTV6Sg=|274376355\",\n  \"ext_info\": \"\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d32a0fb17d38d299f730fd35928b7f5bbf\",\n  \"crt_info\": \"[{&quot;image_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;height&quot;:540,&quot;width&quot;:960,&quot;size&quot;:74132,&quot;image_md5&quot;:&quot;7a9c01200bcb2dba6a07c98abad6a89d&quot;,&quot;materialId&quot;:&quot;102225575&quot;,&quot;card_info&quot;:{&quot;head_desc_type&quot;:1,&quot;mp_tag_type&quot;:0}}]\",\n  \"reranking_ext_info\": \"{\\\"tid\\\":2303720433,\\\"material_hash\\\":\\\"CMzm1scGEOCTyMQC\\\"}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0100109996274}\"\n}";
    VcV = "  {\n  \"hint_txt\": \"创意-20200619_1\",\n  \"url\": \"pages/Home/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=227428a14b944e52c301d99d7769b9d5e6ccd7aa55aac2ca8ca514b5e77a73e83b1579fffef623a5d0972810be5e4fb7&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"traceid\": \"wx0zfmndr7d35pjq00\",\n  \"group_id\": \"wx0zfmndr7d35pjq00_wx0zfmndr7d35pjq01_wx0zfmndr7d35pjq02\",\n  \"ticket\": \"\",\n  \"aid\": \"278576846\",\n  \"pathType\": \"ad\",\n  \"pt\": 9,\n  \"image_url\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx032b61d035e02538\",\n  \"biz_info\": {\n    \"user_name\": \"gh_c5a5a55e74a5\",\n    \"nick_name\": \"BVLGARI宝格丽\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hgUXh7XsHRGLHRribgcXlRGXKB4phZorcicBGVeDWCYQQ/0\",\n    \"biz_uin\": 3074666211,\n    \"signature\": \"于1884年在罗马建立的高端珠宝品牌BVLGARI宝格丽，始终代表着精美奢华的意大利风格。\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 1,\n  \"video_info\": {\n    \"displayWidth\": 960,\n    \"displayHeight\": 540,\n    \"thumbUrl\": \"http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023\",\n    \"videoUrl\": \"http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023\"\n  },\n  \"weapp_info\": {\n    \"original_id\": \"gh_e70774015690\",\n    \"appid\": \"wx56b4770737a7dddf\",\n    \"nick_name\": \"BVLGARI宝格丽精品店\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5pN0eR1LRZJzPxALx3mRPYSmiaPbibPE5fQKS8xTy6ichbQ/0\"\n  },\n  \"dest_type\": 6,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"538\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:6,&quot;jump_url&quot;:&quot;pages\\\\/Home\\\\/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=5418655bc3dd454e4ed84dad6962668068661cb2009130ec86f3626ef4700e9b7a06ee64eb5d93f14e87b54ce39699c9&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"278576846|wx0zfmndr7d35pjq00||0|1594264005|0|0|72058780271891663||AgKNIqBiWhQxioBrueuTRKG/ZDGPF4ER7Im3GhiUj6HO7oRLhI/wSZTh3mxc7jqPZug=|278576919\",\n  \"ext_info\": \"{&quot;wx_app_type&quot;:2,&quot;gh_id&quot;:&quot;gh_e70774015690&quot;}\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d3779f0258b01c0503fbde6feda83a487b\",\n  \"crt_info\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"reranking_ext_info\": \"{tid:278576919}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0134623190388}\"\n}";
    AppMethodBeat.o(206098);
  }
  
  static long Us(long paramLong)
  {
    AppMethodBeat.i(206082);
    int i;
    z localz;
    if (hvL() > 0)
    {
      Log.i("MicroMsg.BizCardLogic", "getAdInsertPos localInsertPos = " + hvL());
      i = hvL();
      localz = com.tencent.mm.ao.af.bjB().asq(kotlin.k.i.ov(i - 2, 0));
      if (localz == null)
      {
        Log.w("MicroMsg.BizCardLogic", "getOrderFlag lastTimeLineInfo is null");
        AppMethodBeat.o(206082);
        return 0L;
      }
    }
    else
    {
      i = Rna;
      if (2 > i) {}
      for (;;)
      {
        Rna = hvJ().decodeInt("biz_card_ad_insert_pos", 3);
        i = Rna;
        if ((2 > i) || (10 < i)) {
          Rna = 3;
        }
        do
        {
          i = Rna;
          break;
        } while (10 >= i);
      }
    }
    if (i == 1) {}
    long l2;
    for (long l1 = localz.field_orderFlag + 1L;; l1 = localz.field_orderFlag - 1L)
    {
      l2 = l1;
      if (l1 != paramLong) {
        break;
      }
      AppMethodBeat.o(206082);
      return l1;
    }
    while (com.tencent.mm.ao.af.bjB().Uv(l2) != null)
    {
      Log.w("MicroMsg.BizCardLogic", "insertAd field_orderFlag conflict orderFlag=".concat(String.valueOf(l2)));
      l2 -= 1L;
    }
    AppMethodBeat.o(206082);
    return l2;
  }
  
  public static void ad(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(206095);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(206095);
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
          paramMap = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(206095);
          throw paramMap;
          i = 0;
        }
        else
        {
          paramMap = paramString.substring(i);
          p.j(paramMap, "(this as java.lang.String).substring(startIndex)");
          localObject = XmlParser.parseXml(paramMap, "sysmsg", null);
          paramMap = (Map<String, String>)localObject;
          if (localObject == null)
          {
            Log.e("MicroMsg.BizCardLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
            AppMethodBeat.o(206095);
          }
        }
      }
      else
      {
        AppMethodBeat.o(206095);
        return;
      }
    }
    localObject = (String)paramMap.get(".sysmsg.BizAdNotify.previewMode");
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    i = Util.getInt(paramString, -1);
    paramMap = (String)paramMap.get(".sysmsg.BizAdNotify.adCmd");
    if (paramMap == null) {
      paramMap = "";
    }
    for (;;)
    {
      if (i != -1)
      {
        paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(140L);
        bcJ().encode("BizTimeLineAdPreviewMode", i);
        bcJ().encode("BizTimeLineAdCmd", paramMap);
        if (i == 1) {
          bcJ().encode("BizTimeLineAdPreviewModeTime", System.currentTimeMillis());
        }
      }
      while (hvQ())
      {
        Log.i("MicroMsg.BizCardLogic", "onAdNotify, adPreviewMode=" + i + ", adCmd=" + paramMap);
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).n("wxa06c02b5c00ff39b", null, "onAdNotify", "previewMode:" + i + ", adCmd:'" + paramMap + '\'');
        AppMethodBeat.o(206095);
        return;
        paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(141L);
      }
      AppMethodBeat.o(206095);
      return;
    }
  }
  
  public static String asl(int paramInt)
  {
    AppMethodBeat.i(206050);
    Object localObject1 = com.tencent.mm.ao.af.bjB().aso(5);
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject3;
    JSONObject localJSONObject2;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    long l;
    boolean bool;
    for (;;)
    {
      try
      {
        p.j(localObject1, "it");
        localObject1 = (Iterable)localObject1;
        int i = 0;
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label1093;
        }
        localObject1 = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject3 = (z)localObject1;
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("index", i);
        p.j(localObject3, "msg");
        if (((z)localObject3).hwA())
        {
          localJSONObject2.put("is_recommand", false);
          localObject4 = new JSONArray();
          localObject1 = (com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class);
          if (localObject1 == null) {
            break label1136;
          }
          localObject1 = ((com.tencent.mm.plugin.biz.a.a)localObject1).b(((z)localObject3).field_msgId, ((z)localObject3).field_content);
          if (localObject1 != null)
          {
            localObject1 = ((u)localObject1).lpz;
            if (localObject1 != null)
            {
              localObject1 = (Iterable)localObject1;
              j = 0;
              localObject1 = ((Iterable)localObject1).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject5 = ((Iterator)localObject1).next();
                if (j < 0) {
                  j.iBO();
                }
                localObject6 = (v)localObject5;
                localObject5 = new JSONObject();
                if (!Util.isNullOrNil(((v)localObject6).url))
                {
                  localObject7 = Uri.parse(((v)localObject6).url);
                  k = Util.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
                  l = Util.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
                  localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
                  p.j(localObject7, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
                  ((JSONObject)localObject5).put("bizuin", Util.getLong(new String((byte[])localObject7, kotlin.n.d.UTF_8), 0L));
                  ((JSONObject)localObject5).put("mid", l);
                  ((JSONObject)localObject5).put("idx", k);
                  ((JSONObject)localObject5).put("title", ((v)localObject6).title);
                }
                ((JSONObject)localObject5).put("index", j);
                ((JSONObject)localObject5).put("msg_time", ((v)localObject6).time);
                if ((j < 2) || (((z)localObject3).field_isExpand)) {
                  break label1142;
                }
                bool = true;
                label428:
                ((JSONObject)localObject5).put("is_fold", bool);
                localObject6 = new JSONObject();
                if (((z)localObject3).field_isRead != 1) {
                  break label1148;
                }
                k = 1;
                label459:
                ((JSONObject)localObject6).put("type", k);
                localObject7 = x.aazN;
                ((JSONObject)localObject5).put("user_action", localObject6);
                localObject6 = x.aazN;
                ((JSONArray)localObject4).put(localObject5);
                j += 1;
                continue;
              }
              localObject1 = x.aazN;
            }
          }
          localObject1 = x.aazN;
          localJSONObject2.put("msg", localObject4);
          label526:
          localJSONArray.put(localJSONObject2);
          i += 1;
          continue;
        }
        if (!((z)localObject3).hwB()) {
          continue;
        }
        localJSONObject2.put("is_recommend", true);
        localObject4 = ((z)localObject3).hwL();
        if (localObject4 == null) {
          break label757;
        }
        j = ((eqg)localObject4).style;
        localJSONObject2.put("style", j);
        if ((localObject4 == null) || (((eqg)localObject4).style != 1001)) {
          break;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("extra_data", ((eqg)localObject4).fMh);
        ((JSONObject)localObject1).put("msg_time", ((z)localObject3).field_createTime);
        localObject4 = new JSONObject();
        if (((z)localObject3).field_isRead != 1) {
          break label762;
        }
        j = 1;
        ((JSONObject)localObject4).put("type", j);
        localObject3 = x.aazN;
        ((JSONObject)localObject1).put("user_action", localObject4);
        localObject3 = x.aazN;
        localJSONObject2.put("ext_info", localObject1);
        continue;
        localObject2 = localJSONObject1.toString();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BizCardLogic", (Throwable)localException, "getTimeLineContext", new Object[0]);
      }
      label725:
      p.j(localObject2, "timelineContext.toString()");
      p.j(localObject2, "SubCoreBiz.getBizTimeLin…text.toString()\n        }");
      AppMethodBeat.o(206050);
      return localObject2;
      label757:
      j = 0;
      continue;
      label762:
      j = 0;
    }
    Object localObject2 = new JSONArray();
    Object localObject4 = (Iterable)af.K((z)localObject3);
    int j = 0;
    localObject4 = ((Iterable)localObject4).iterator();
    label797:
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((Iterator)localObject4).next();
      if (j < 0) {
        j.iBO();
      }
      localObject6 = (pe)localObject5;
      localObject5 = new JSONObject();
      if (!Util.isNullOrNil(((pe)localObject6).RTk))
      {
        localObject7 = Uri.parse(((pe)localObject6).RTk);
        k = Util.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
        l = Util.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
        localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
        p.j(localObject7, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
        ((JSONObject)localObject5).put("bizuin", Util.getLong(new String((byte[])localObject7, kotlin.n.d.UTF_8), 0L));
        ((JSONObject)localObject5).put("mid", l);
        ((JSONObject)localObject5).put("idx", k);
        ((JSONObject)localObject5).put("title", ((pe)localObject6).fwr);
      }
      ((JSONObject)localObject5).put("index", j);
      ((JSONObject)localObject5).put("msg_time", ((z)localObject3).field_createTime);
      ((JSONObject)localObject5).put("is_fold", false);
      localObject6 = new JSONObject();
      if (((z)localObject3).field_isRead != 1) {
        break label1153;
      }
    }
    label1153:
    for (int k = 1;; k = 0)
    {
      ((JSONObject)localObject6).put("type", k);
      localObject7 = x.aazN;
      ((JSONObject)localObject5).put("user_action", localObject6);
      localObject6 = x.aazN;
      ((JSONArray)localObject2).put(localObject5);
      j += 1;
      break label797;
      localObject3 = x.aazN;
      localObject3 = x.aazN;
      localJSONObject2.put("msg", localObject2);
      break label526;
      label1093:
      localJSONObject1.put("timeline_context", localJSONArray);
      localJSONObject1.put("timeline_request_type", paramInt);
      localJSONObject1.put("last_expose_time", hvJ().decodeLong("BizLastExposeAdTime", 0L));
      break label725;
      label1136:
      localObject2 = null;
      break;
      label1142:
      bool = false;
      break label428;
      label1148:
      k = 0;
      break label459;
    }
  }
  
  private static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(206027);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(206027);
    return localMultiProcessMMKV;
  }
  
  static String buZ(String paramString)
  {
    AppMethodBeat.i(206022);
    paramString = new StringBuilder().append(paramString).append('-');
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    paramString = b.aGq();
    AppMethodBeat.o(206022);
    return paramString;
  }
  
  public static JSONObject bvb(String paramString)
  {
    AppMethodBeat.i(206058);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(206058);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("advertisement_info");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0);
        AppMethodBeat.o(206058);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.BizCardLogic", "getAdData ex %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(206058);
    }
    return null;
  }
  
  public static boolean bvc(String paramString)
  {
    AppMethodBeat.i(206078);
    p.k(paramString, "canvasId");
    Object localObject = (CharSequence)VcD;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(206078);
      return false;
    }
    localObject = paramString.substring(10);
    p.j(localObject, "(this as java.lang.String).substring(startIndex)");
    if (ab.VeK)
    {
      if (!Util.isEqual(VcD, (String)localObject))
      {
        AppMethodBeat.o(206078);
        return false;
      }
      com.tencent.e.h.ZvG.d((Runnable)n.Vdk, "BizInsertTlRecCardThread");
      AppMethodBeat.o(206078);
      return true;
    }
    if (Util.isEqual(VcD, (String)localObject))
    {
      Log.i("MicroMsg.BizCardLogic", "replaceTimelineAd but not in timeline lastAId=" + VcD + ", canvasId=" + paramString);
      ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).n("wxa06c02b5c00ff39b", null, "adReplace", "err_code:2,err_msg:'not in timeline', aid:'" + VcD + '\'');
      VcD = null;
    }
    AppMethodBeat.o(206078);
    return false;
  }
  
  static void bvd(String paramString)
  {
    AppMethodBeat.i(206085);
    if (!ab.VeK)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!n.ba(localCharSequence))) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (((Boolean)VcO.getValue()).booleanValue()))
      {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apk("__ad_card_".concat(String.valueOf(paramString)));
        paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(132L);
      }
      AppMethodBeat.o(206085);
      return;
    }
  }
  
  public static boolean bve(String paramString)
  {
    AppMethodBeat.i(206094);
    p.k(paramString, "aid");
    boolean bool = VcB.contains(paramString);
    AppMethodBeat.o(206094);
    return bool;
  }
  
  static boolean cr(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(206056);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(206056);
      return false;
    }
    long l1 = bq.beS() / 1000L;
    long l2 = paramJSONObject.optLong("ad_expire_time", l1);
    if (l1 <= l2) {
      bool = true;
    }
    if (!bool)
    {
      com.tencent.mm.plugin.webcanvas.l locall = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.Tt(103L);
      Log.i("MicroMsg.BizCardLogic", "isAdDataValid ad expire aid=" + paramJSONObject.optString("aid") + " adExpireTime=" + l2);
    }
    AppMethodBeat.o(206056);
    return bool;
  }
  
  private void cs(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(206088);
        p.k(paramJSONObject, "adData");
        try
        {
          str1 = paramJSONObject.optString("aid");
          p.j(str1, "adData.optString(\"aid\")");
          str2 = paramJSONObject.optString("path_type", "ad");
          p.j(str2, "adData.optString(\"path_type\", \"ad\")");
          Log.i("MicroMsg.BizCardLogic", "preloadAdCard aid=" + str1 + ", pathType=" + str2);
          localObject = (CharSequence)str1;
          if (localObject == null) {
            break label242;
          }
          if (!n.ba((CharSequence)localObject)) {
            break label232;
          }
        }
        catch (Exception paramJSONObject)
        {
          String str1;
          String str2;
          Object localObject;
          Log.w("MicroMsg.BizCardLogic", "preloadAdCard ex %s", new Object[] { paramJSONObject.getMessage() });
          AppMethodBeat.o(206088);
          continue;
        }
        if (i == 0)
        {
          localObject = (CharSequence)str2;
          if (localObject == null) {
            break label247;
          }
          if (!n.ba((CharSequence)localObject)) {
            break label237;
          }
          break label247;
          if (i == 0)
          {
            localObject = com.tencent.mm.plugin.webcanvas.l.PuB;
            com.tencent.mm.plugin.webcanvas.l.Tt(8L);
            bvd(VcE);
            VcE = str1;
            ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).O(str2, "__ad_card_".concat(String.valueOf(str1)), paramJSONObject.toString());
          }
        }
        AppMethodBeat.o(206088);
        return;
      }
      finally {}
      label232:
      int i = 0;
      continue;
      label237:
      i = 0;
      continue;
      label242:
      i = 1;
      continue;
      label247:
      i = 1;
    }
  }
  
  public static void fKR()
  {
    AppMethodBeat.i(206073);
    if (!hvM())
    {
      AppMethodBeat.o(206073);
      return;
    }
    Object localObject1 = com.tencent.mm.ao.af.bjB().md(637534257, 1);
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label114:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (Math.abs(((z)localObject3).field_createTime - System.currentTimeMillis()) < 86400000L) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label114;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      ju((List)localObject1);
      AppMethodBeat.o(206073);
      return;
    }
    AppMethodBeat.o(206073);
  }
  
  public static String hvG()
  {
    return VcD;
  }
  
  public static void hvH()
  {
    VcD = null;
  }
  
  public static void hvI()
  {
    VcE = null;
  }
  
  static MultiProcessMMKV hvJ()
  {
    AppMethodBeat.i(206028);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)VcF.getValue();
    AppMethodBeat.o(206028);
    return localMultiProcessMMKV;
  }
  
  private static int hvK()
  {
    AppMethodBeat.i(206030);
    int i = ((Number)VcG.getValue()).intValue();
    AppMethodBeat.o(206030);
    return i;
  }
  
  private static int hvL()
  {
    AppMethodBeat.i(206031);
    int i = ((Number)VcH.getValue()).intValue();
    AppMethodBeat.o(206031);
    return i;
  }
  
  public static boolean hvM()
  {
    AppMethodBeat.i(206032);
    boolean bool = ((Boolean)VcI.getValue()).booleanValue();
    AppMethodBeat.o(206032);
    return bool;
  }
  
  private static boolean hvN()
  {
    AppMethodBeat.i(206034);
    if (bcJ().decodeInt("BizTimeLineAdPreviewMode", 0) == 1)
    {
      long l = bcJ().decodeLong("BizTimeLineAdPreviewModeTime", 0L);
      if (l <= 0L)
      {
        AppMethodBeat.o(206034);
        return false;
      }
      if (System.currentTimeMillis() - l < 86400000L)
      {
        AppMethodBeat.o(206034);
        return true;
      }
      AppMethodBeat.o(206034);
      return false;
    }
    AppMethodBeat.o(206034);
    return false;
  }
  
  public static boolean hvP()
  {
    AppMethodBeat.i(206037);
    boolean bool = ((Boolean)VcJ.getValue()).booleanValue();
    AppMethodBeat.o(206037);
    return bool;
  }
  
  public static boolean hvQ()
  {
    AppMethodBeat.i(206038);
    boolean bool = ((Boolean)VcK.getValue()).booleanValue();
    AppMethodBeat.o(206038);
    return bool;
  }
  
  public static boolean hvR()
  {
    AppMethodBeat.i(206039);
    boolean bool = ((Boolean)VcL.getValue()).booleanValue();
    AppMethodBeat.o(206039);
    return bool;
  }
  
  private static boolean hvS()
  {
    AppMethodBeat.i(206040);
    boolean bool = ((Boolean)VcM.getValue()).booleanValue();
    AppMethodBeat.o(206040);
    return bool;
  }
  
  public static boolean hvT()
  {
    AppMethodBeat.i(206041);
    boolean bool = ((Boolean)VcN.getValue()).booleanValue();
    AppMethodBeat.o(206041);
    return bool;
  }
  
  public static boolean hvU()
  {
    AppMethodBeat.i(206042);
    boolean bool = ((Boolean)VcP.getValue()).booleanValue();
    AppMethodBeat.o(206042);
    return bool;
  }
  
  public static void hvV()
  {
    AppMethodBeat.i(206061);
    hvJ().encode("biz_card_max_ad_count", VcC);
    int i = Rna;
    if (2 > i)
    {
      AppMethodBeat.o(206061);
      return;
    }
    if (10 >= i) {
      hvJ().encode("biz_card_ad_insert_pos", Rna);
    }
    AppMethodBeat.o(206061);
  }
  
  private static long hvW()
  {
    AppMethodBeat.i(206063);
    if (VcQ > 1000L)
    {
      l = VcQ;
      AppMethodBeat.o(206063);
      return l;
    }
    long l = hvJ().getLong("biz_card_refresh_interval", 3600000L);
    VcQ = l;
    AppMethodBeat.o(206063);
    return l;
  }
  
  private static long hvX()
  {
    AppMethodBeat.i(206065);
    if (VcR > 1000L)
    {
      l = VcR;
      AppMethodBeat.o(206065);
      return l;
    }
    long l = hvJ().getLong("biz_card_resort_Refresh_IntervalSec", 3600000L);
    VcR = l;
    AppMethodBeat.o(206065);
    return l;
  }
  
  public static void hvY()
  {
    AppMethodBeat.i(206066);
    VcT = false;
    if (VcS) {
      hwa();
    }
    AppMethodBeat.o(206066);
  }
  
  public static void hvZ()
  {
    VcT = true;
  }
  
  private static void hwa()
  {
    AppMethodBeat.i(206070);
    Log.i("MicroMsg.BizCardLogic", "exposePreload reset crash flag");
    com.tencent.mm.plugin.biz.b.c localc = com.tencent.mm.plugin.biz.b.c.shz;
    com.tencent.mm.plugin.biz.b.c.cxK().encode("biz_canvas_card_expose_preload_crash_times", 0);
    AppMethodBeat.o(206070);
  }
  
  static z hwb()
  {
    AppMethodBeat.i(206084);
    z localz = com.tencent.mm.ao.af.bjB().hwT();
    if ((localz != null) && (localz.field_isRead == 0))
    {
      AppMethodBeat.o(206084);
      return localz;
    }
    AppMethodBeat.o(206084);
    return null;
  }
  
  private static String hwc()
  {
    AppMethodBeat.i(206096);
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (bcJ().getInt("BizTimeLineAdMockType", 0) == 0) {}
    for (String str = VcV;; str = VcU)
    {
      localJSONArray.put(new JSONObject(str));
      localJSONObject.put("advertisement_info", localJSONArray);
      localJSONObject.put("advertisement_num", 1);
      str = localJSONObject.toString();
      p.j(str, "adData.toString()");
      AppMethodBeat.o(206096);
      return str;
    }
  }
  
  private static void ju(List<? extends z> paramList)
  {
    AppMethodBeat.i(206076);
    p.k(paramList, "list");
    if ((!hvM()) || (Util.isNullOrNil(paramList)))
    {
      AppMethodBeat.o(206076);
      return;
    }
    if (hvK() == 1)
    {
      AppMethodBeat.o(206076);
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
      localObject5 = (z)localObject2;
      localObject4 = swu;
      localObject5 = ((z)localObject5).hwO();
      p.j(localObject5, "it.aId");
      if (!((com.tencent.mm.ao.r)localObject4).contains((String)localObject5)) {}
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
      localObject2 = (z)((Iterator)localObject1).next();
      localObject4 = new JSONObject();
      try
      {
        Object localObject6 = ((z)localObject2).hwM();
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
        localObject6 = (Map)VcA;
        p.j(localObject5, "aid");
        ((Map)localObject6).put(localObject5, Long.valueOf(((z)localObject2).field_msgId));
        localLinkedList.add(localObject5);
        paramList.put(localObject4);
        swu.add((String)localObject5);
        i = 1;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BizCardLogic", "checkAd ex " + localException.getMessage());
      }
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("ads", paramList);
    paramList = ((JSONObject)localObject1).toString();
    p.j(paramList, "list?.filter {\n         …  }?.toString()\n        }");
    localObject1 = (CharSequence)paramList;
    if ((localObject1 == null) || (n.ba((CharSequence)localObject1))) {}
    for (int j = 1; (j != 0) || (i == 0); j = 0)
    {
      AppMethodBeat.o(206076);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(16L);
    localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.cd.a)new erm());
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new ern());
    ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((d.a)localObject1).vD(2781);
    localObject1 = ((d.a)localObject1).bgN();
    p.j(localObject1, "rr");
    Object localObject3 = ((com.tencent.mm.an.d)localObject1).bhX();
    if (localObject3 == null)
    {
      paramList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(206076);
      throw paramList;
    }
    localObject3 = (erm)localObject3;
    ((erm)localObject3).RXN = System.currentTimeMillis();
    ((erm)localObject3).RXS = 2;
    ((erm)localObject3).RXT = paramList;
    com.tencent.mm.an.aa.a((com.tencent.mm.an.d)localObject1, (aa.a)new d(localLinkedList));
    AppMethodBeat.o(206076);
  }
  
  public static void replaceAdData(String paramString)
  {
    AppMethodBeat.i(206079);
    com.tencent.e.h.ZvG.d((Runnable)new m(paramString), "BizInsertTlRecCardThread");
    AppMethodBeat.o(206079);
  }
  
  public final boolean B(z paramz)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(206090);
        p.k(paramz, "info");
        if (paramz.hwC())
        {
          Log.d("MicroMsg.BizCardLogic", "preload ad card");
          localObject = com.tencent.mm.plugin.webcanvas.l.PuB;
          com.tencent.mm.plugin.webcanvas.l.Tt(8L);
          com.tencent.mm.plugin.brandservice.a.c localc = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
          localObject = (CharSequence)paramz.getPathType();
          if (localObject == null) {
            break label175;
          }
          if (!n.ba((CharSequence)localObject)) {
            break label177;
          }
          break label175;
          localc.O((String)localObject, "__ad_card_" + paramz.hwO(), paramz.ahl());
          AppMethodBeat.o(206090);
          bool = true;
          return bool;
          localObject = paramz.getPathType();
          continue;
        }
        if (paramz.hwB())
        {
          bool = b(paramz.hwL());
          AppMethodBeat.o(206090);
          continue;
        }
        AppMethodBeat.o(206090);
      }
      finally {}
      boolean bool = false;
      continue;
      label175:
      i = 1;
      label177:
      if (i != 0) {
        localObject = "ad";
      }
    }
  }
  
  /* Error */
  public final boolean C(z paramz)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1263
    //   5: invokestatic 243	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 1248
    //   12: invokestatic 892	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: getfield 1267	com/tencent/mm/storage/z:Ven	Lcom/tencent/mm/protocal/protobuf/dug;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnull +86 -> 107
    //   24: aload_3
    //   25: invokestatic 1270	com/tencent/mm/storage/af:b	(Lcom/tencent/mm/protocal/protobuf/dug;)Z
    //   28: iconst_1
    //   29: if_icmpne +78 -> 107
    //   32: ldc_w 376
    //   35: ldc_w 1272
    //   38: invokestatic 1255	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: getstatic 540	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   44: astore_3
    //   45: ldc2_w 1273
    //   48: invokestatic 545	com/tencent/mm/plugin/webcanvas/l:Tt	(J)V
    //   51: ldc_w 581
    //   54: invokestatic 587	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   57: checkcast 581	com/tencent/mm/plugin/brandservice/a/c
    //   60: ldc_w 1276
    //   63: new 378	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 1278
    //   70: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: getfield 1267	com/tencent/mm/storage/z:Ven	Lcom/tencent/mm/protocal/protobuf/dug;
    //   77: getfield 1283	com/tencent/mm/protocal/protobuf/dug:RVi	Ljava/lang/String;
    //   80: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload_1
    //   87: invokevirtual 1286	com/tencent/mm/storage/z:hwR	()Ljava/lang/String;
    //   90: invokeinterface 1007 4 0
    //   95: ldc_w 1263
    //   98: invokestatic 362	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_1
    //   102: istore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_2
    //   106: ireturn
    //   107: iconst_0
    //   108: istore_2
    //   109: ldc_w 1263
    //   112: invokestatic 362	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -12 -> 103
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	r
    //   0	123	1	paramz	z
    //   102	7	2	bool	boolean
    //   19	26	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	118	finally
    //   24	101	118	finally
    //   109	115	118	finally
  }
  
  public final void ask(int paramInt)
  {
    AppMethodBeat.i(206045);
    if (!hvM())
    {
      AppMethodBeat.o(206045);
      return;
    }
    if (hvK() == 1)
    {
      bva(hwc());
      hvJ().encode("biz_card_last_time", System.currentTimeMillis());
      AppMethodBeat.o(206045);
      return;
    }
    if (hvQ())
    {
      Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + hvK() + ", adPreviewMode=" + hvN() + ", from=" + paramInt);
      localObject2 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
      if (2 == paramInt) {}
      for (localObject1 = "mainCellExpose";; localObject1 = "resortEnd")
      {
        ((com.tencent.mm.plugin.brandservice.a.c)localObject2).n("wxa06c02b5c00ff39b", null, (String)localObject1, "from:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(206045);
        return;
      }
    }
    long l2 = hvJ().getLong("biz_card_last_time", 0L);
    long l3 = System.currentTimeMillis();
    long l4 = Math.abs(l3 - l2);
    if (paramInt == 1) {}
    for (long l1 = hvX(); (3 != paramInt) && (((!hvO()) && (l4 < l1)) || ((hvO()) && (l4 < 10000L))); l1 = hvW())
    {
      Log.d("MicroMsg.BizCardLogic", "doBizCardCgi delta < interval, return from=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(206045);
      return;
    }
    hvJ().encode("biz_card_last_time", System.currentTimeMillis());
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.cd.a)new erm());
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new ern());
    ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((d.a)localObject1).vD(2781);
    localObject1 = ((d.a)localObject1).bgN();
    p.j(localObject1, "rr");
    Object localObject2 = ((com.tencent.mm.an.d)localObject1).bhX();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(206045);
      throw ((Throwable)localObject1);
    }
    localObject2 = (erm)localObject2;
    ((erm)localObject2).RXN = System.currentTimeMillis();
    ((erm)localObject2).RXS = 1;
    ((erm)localObject2).RVi = "";
    ((erm)localObject2).RXT = asl(paramInt);
    Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + hvK() + ", adPreviewMode=" + hvN() + " from=" + paramInt + " interval=" + l1 + " lastTime=" + l2 + " currentMills=" + l3);
    localObject2 = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(0L);
    com.tencent.mm.an.aa.a((com.tencent.mm.an.d)localObject1, (aa.a)e.Vdb);
    AppMethodBeat.o(206045);
  }
  
  /* Error */
  public final boolean b(eqg parameqg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1341
    //   5: invokestatic 243	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +121 -> 130
    //   12: aload_1
    //   13: getfield 773	com/tencent/mm/protocal/protobuf/eqg:style	I
    //   16: sipush 1001
    //   19: if_icmpne +111 -> 130
    //   22: aload_1
    //   23: getfield 1345	com/tencent/mm/protocal/protobuf/eqg:UsH	Lcom/tencent/mm/protocal/protobuf/due;
    //   26: ifnull +104 -> 130
    //   29: ldc_w 376
    //   32: ldc_w 1347
    //   35: invokestatic 1255	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: getstatic 540	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   41: astore_3
    //   42: ldc2_w 1273
    //   45: invokestatic 545	com/tencent/mm/plugin/webcanvas/l:Tt	(J)V
    //   48: ldc_w 581
    //   51: invokestatic 587	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   54: checkcast 581	com/tencent/mm/plugin/brandservice/a/c
    //   57: astore 5
    //   59: aload_1
    //   60: getfield 1345	com/tencent/mm/protocal/protobuf/eqg:UsH	Lcom/tencent/mm/protocal/protobuf/due;
    //   63: getfield 1352	com/tencent/mm/protocal/protobuf/due:Uay	Ljava/lang/String;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload 4
    //   73: ifnonnull +7 -> 80
    //   76: ldc_w 1354
    //   79: astore_3
    //   80: aload 5
    //   82: aload_3
    //   83: new 378	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 1356
    //   90: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_1
    //   94: getfield 1345	com/tencent/mm/protocal/protobuf/eqg:UsH	Lcom/tencent/mm/protocal/protobuf/due;
    //   97: getfield 1359	com/tencent/mm/protocal/protobuf/due:cardId	Ljava/lang/String;
    //   100: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload_1
    //   107: getfield 1345	com/tencent/mm/protocal/protobuf/eqg:UsH	Lcom/tencent/mm/protocal/protobuf/due;
    //   110: getfield 1361	com/tencent/mm/protocal/protobuf/due:data	Ljava/lang/String;
    //   113: invokeinterface 1007 4 0
    //   118: iconst_1
    //   119: istore_2
    //   120: ldc_w 1341
    //   123: invokestatic 362	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: monitorexit
    //   128: iload_2
    //   129: ireturn
    //   130: iconst_0
    //   131: istore_2
    //   132: ldc_w 1341
    //   135: invokestatic 362	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -12 -> 126
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	r
    //   0	146	1	parameqg	eqg
    //   119	13	2	bool	boolean
    //   41	42	3	localObject	Object
    //   66	6	4	str	String
    //   57	24	5	localc	com.tencent.mm.plugin.brandservice.a.c
    // Exception table:
    //   from	to	target	type
    //   2	8	141	finally
    //   12	68	141	finally
    //   80	118	141	finally
    //   120	126	141	finally
    //   132	138	141	finally
  }
  
  public final void bva(String paramString)
  {
    AppMethodBeat.i(206053);
    if (!com.tencent.mm.kernel.h.aHB()) {
      Log.i("MicroMsg.BizCardLogic", "saveAdData acc not ready");
    }
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (n.ba((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizCardLogic", "saveAdData data is null");
      paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.Tt(3L);
      AppMethodBeat.o(206053);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(4L);
    localObject1 = bvb(paramString);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizCardLogic", "saveAdData adData is null");
      paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.Tt(91L);
      AppMethodBeat.o(206053);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(92L);
    if (hvS()) {
      m.PuL.gPA();
    }
    VcD = ((JSONObject)localObject1).optString("aid");
    Log.i("MicroMsg.BizCardLogic", "saveAdData aid=" + VcD);
    localObject2 = (CharSequence)VcD;
    if ((localObject2 == null) || (n.ba((CharSequence)localObject2))) {}
    for (i = 1; i == 0; i = 0)
    {
      cs((JSONObject)localObject1);
      hvJ().encode(buZ("biz_ad_card_data"), paramString);
      AppMethodBeat.o(206053);
      return;
    }
    paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(100L);
    AppMethodBeat.o(206053);
  }
  
  final boolean hvO()
  {
    AppMethodBeat.i(206035);
    if ((hvK() > 0) || (hvN()))
    {
      AppMethodBeat.o(206035);
      return true;
    }
    AppMethodBeat.o(206035);
    return false;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final a VcX;
    
    static
    {
      AppMethodBeat.i(205719);
      VcX = new a();
      AppMethodBeat.o(205719);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final b VcY;
    
    static
    {
      AppMethodBeat.i(207101);
      VcY = new b();
      AppMethodBeat.o(207101);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final c VcZ;
    
    static
    {
      AppMethodBeat.i(207880);
      VcZ = new c();
      AppMethodBeat.o(207880);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class d
    implements aa.a
  {
    d(LinkedList paramLinkedList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(207216);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.BizCardLogic", "checkAd callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(17L);
        AppMethodBeat.o(207216);
        return 0;
      }
      p.j(paramd, "rr");
      paramd = paramd.bhY();
      paramString = paramd;
      if (!(paramd instanceof ern)) {
        paramString = null;
      }
      paramString = (ern)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(207216);
        return 0;
      }
      if (Util.isNullOrNil(paramString.RXT))
      {
        Log.e("MicroMsg.BizCardLogic", "checkAd callback resp.Data is empty");
        paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(18L);
        AppMethodBeat.o(207216);
        return 0;
      }
      paramd = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.Tt(19L);
      for (;;)
      {
        try
        {
          paramd = new JSONObject(paramString.RXT);
          paramString = paramd.optString("aid");
          paramd = paramd.optJSONArray("del_aid");
          Log.i("MicroMsg.BizCardLogic", "checkAd callback chooseAid=".concat(String.valueOf(paramString)));
          if (paramd == null) {
            break label727;
          }
          paramInt1 = paramd.length();
          if (paramInt1 > 0)
          {
            int i = paramd.length();
            paramInt1 = 0;
            if (paramInt1 < i)
            {
              paramq = paramd.optString(paramInt1);
              localObject1 = (CharSequence)paramq;
              if (localObject1 == null) {
                break label715;
              }
              if (!n.ba((CharSequence)localObject1)) {
                break label732;
              }
              break label715;
              if (paramInt2 != 0) {
                break label720;
              }
              localObject1 = r.VcW;
              Object localObject2 = (Long)r.hwf().get(paramq);
              if (localObject2 == null) {
                break label720;
              }
              localObject1 = com.tencent.mm.ao.af.bjB().Uw(((Long)localObject2).longValue());
              if (localObject1 == null) {
                break label720;
              }
              com.tencent.mm.ao.af.bjB().UI(((Long)localObject2).longValue());
              Log.e("MicroMsg.BizCardLogic", "checkAd force delete ad ".concat(String.valueOf(paramq)));
              localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
              String str = ((z)localObject1).getTraceId();
              if (((z)localObject1).field_isRead != 1) {
                break label737;
              }
              paramInt2 = 1;
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(20635, new Object[] { paramq, str, Integer.valueOf(2), Integer.valueOf(paramInt2) });
              paramq = com.tencent.mm.plugin.webcanvas.l.PuB;
              if (((z)localObject1).field_isRead != 1) {
                break label742;
              }
              l = 21L;
              com.tencent.mm.plugin.webcanvas.l.Tt(l);
              paramq = com.tencent.mm.plugin.webcanvas.l.PuB;
              com.tencent.mm.plugin.webcanvas.l.Tt(23L);
              break label720;
            }
          }
          paramd = ((Iterable)this.Vda).iterator();
          if (paramd.hasNext())
          {
            paramq = (String)paramd.next();
            localObject1 = r.VcW;
            r.hwg().add(paramq);
            if (!(p.h(paramq, paramString) ^ true)) {
              continue;
            }
            localObject1 = r.VcW;
            localObject1 = (Long)r.hwf().get(paramq);
            if (localObject1 == null) {
              continue;
            }
            paramq = com.tencent.mm.ao.af.bjB().Uw(((Long)localObject1).longValue());
            if (paramq == null) {
              continue;
            }
            if (paramq.field_isRead != 0) {
              break label658;
            }
            com.tencent.mm.ao.af.bjB().UI(((Long)localObject1).longValue());
            Log.e("MicroMsg.BizCardLogic", "checkAd delete ad " + paramq.hwO());
            com.tencent.mm.plugin.report.service.h.IzE.a(20635, new Object[] { paramq.hwO(), paramq.getTraceId(), Integer.valueOf(1), Integer.valueOf(0) });
            paramq = com.tencent.mm.plugin.webcanvas.l.PuB;
            com.tencent.mm.plugin.webcanvas.l.Tt(22L);
          }
          Object localObject1 = com.tencent.mm.plugin.webcanvas.l.PuB;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.BizCardLogic", "checkAd callback ex " + paramString.getMessage());
          AppMethodBeat.o(207216);
          return 0;
        }
        label658:
        com.tencent.mm.plugin.webcanvas.l.Tt(24L);
        com.tencent.mm.plugin.report.service.h.IzE.a(20635, new Object[] { paramq.hwO(), paramq.getTraceId(), Integer.valueOf(0), Integer.valueOf(1) });
        continue;
        label715:
        paramInt2 = 1;
        continue;
        label720:
        paramInt1 += 1;
        continue;
        label727:
        paramInt1 = 0;
        continue;
        label732:
        paramInt2 = 0;
        continue;
        label737:
        paramInt2 = 0;
        continue;
        label742:
        long l = 20L;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class e
    implements aa.a
  {
    public static final e Vdb;
    
    static
    {
      AppMethodBeat.i(205846);
      Vdb = new e();
      AppMethodBeat.o(205846);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      paramq = null;
      AppMethodBeat.i(205844);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.BizCardLogic", "doBizCardCgi callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(1L);
        if (paramInt2 == 1004)
        {
          paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
          com.tencent.mm.plugin.webcanvas.l.Tt(7L);
        }
        AppMethodBeat.o(205844);
        return 0;
      }
      paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.Tt(2L);
      p.j(paramd, "rr");
      paramd = paramd.bhY();
      paramString = paramd;
      if (!(paramd instanceof ern)) {
        paramString = null;
      }
      paramd = (ern)paramString;
      if (paramd == null)
      {
        AppMethodBeat.o(205844);
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder("doBizCardCgi callback ");
      if (paramd != null) {}
      for (paramString = paramd.RXT;; paramString = null)
      {
        Log.d("MicroMsg.BizCardLogic", paramString);
        localStringBuilder = new StringBuilder("doBizCardCgi callback errType=").append(paramInt1).append(", errCode=").append(paramInt2).append(" interval=");
        paramString = paramq;
        if (paramd != null) {
          paramString = Integer.valueOf(paramd.RTQ);
        }
        Log.i("MicroMsg.BizCardLogic", paramString.intValue());
        paramString = r.VcW;
        r.asm(paramd.RTQ);
        paramString = r.VcW;
        paramString = paramd.CSe;
        if (paramString != null) {}
        try
        {
          Log.i("MicroMsg.BizCardLogic", "handleExtInfo extInfo ".concat(String.valueOf(paramString)));
          paramString = new JSONObject(paramString);
          if (paramString.has("ResortRefreshIntervalSec"))
          {
            paramInt1 = paramString.optInt("ResortRefreshIntervalSec", 0);
            if ((paramInt1 > 0) && (paramInt1 <= 259200))
            {
              r.VcR = paramInt1 * 1000L;
              r.hvJ().encode("biz_card_resort_Refresh_IntervalSec", r.VcR);
            }
          }
          r.VcC = paramString.optInt("MaxAdCount", 1);
          r.Rna = paramString.optInt("AdInsertPos", 3);
          r.hvV();
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.BizCardLogic", "handleExtInfo ex " + paramString.getMessage());
            continue;
            paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
            com.tencent.mm.plugin.webcanvas.l.Tt(5L);
          }
        }
        if ((paramd.RIs & 0x1) != 0) {
          break;
        }
        r.VcW.bva(paramd.RXT);
        paramString = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(6L);
        AppMethodBeat.o(205844);
        return 0;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(206870);
      Object localObject1 = com.tencent.mm.plugin.biz.b.c.shz;
      com.tencent.mm.plugin.biz.b.c.cxK().encode("biz_canvas_card_expose_preload_crash_times", this.Vdc + 1);
      Log.i("MicroMsg.BizCardLogic", "exposePreload set crash flag");
      localObject1 = r.VcW;
      r.EQ(true);
      localObject1 = com.tencent.mm.ao.af.bjB().md(637534257, 1);
      int j;
      Object localObject2;
      r localr;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        j = 0;
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break label146;
        }
        localObject2 = (z)((Iterator)localObject1).next();
        if (Math.abs(((z)localObject2).field_createTime - System.currentTimeMillis()) >= 86400000L) {
          break label335;
        }
        localr = r.VcW;
        p.j(localObject2, "info");
        localr.B((z)localObject2);
        localObject2 = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(12L);
      }
      label146:
      label335:
      for (int i = 1;; i = j)
      {
        j = i;
        break;
        i = 0;
        localObject1 = com.tencent.mm.ao.af.bjB().md(620757041, 1);
        j = i;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (z)((Iterator)localObject1).next();
            if (Math.abs(((z)localObject2).field_createTime - System.currentTimeMillis()) < 86400000L)
            {
              localr = r.VcW;
              p.j(localObject2, "info");
              if (localr.B((z)localObject2))
              {
                localObject2 = com.tencent.mm.plugin.webcanvas.l.PuB;
                com.tencent.mm.plugin.webcanvas.l.Tt(13L);
                i = 1;
              }
            }
          }
        }
        r.a(r.VcW);
        r.b(r.VcW);
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyK();
        if (j != 0)
        {
          localObject1 = r.VcW;
          if (r.hwd())
          {
            com.tencent.e.h.ZvG.o((Runnable)1.Vdd, 3000L);
            AppMethodBeat.o(206870);
            return;
          }
        }
        localObject1 = r.VcW;
        r.EQ(false);
        localObject1 = r.VcW;
        r.hwe();
        AppMethodBeat.o(206870);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final g Vde;
    
    static
    {
      AppMethodBeat.i(206018);
      Vde = new g();
      AppMethodBeat.o(206018);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final h Vdf;
    
    static
    {
      AppMethodBeat.i(207861);
      Vdf = new h();
      AppMethodBeat.o(207861);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final i Vdg;
    
    static
    {
      AppMethodBeat.i(208749);
      Vdg = new i();
      AppMethodBeat.o(208749);
    }
    
    i()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final j Vdh;
    
    static
    {
      AppMethodBeat.i(206433);
      Vdh = new j();
      AppMethodBeat.o(206433);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final k Vdi;
    
    static
    {
      AppMethodBeat.i(206455);
      Vdi = new k();
      AppMethodBeat.o(206455);
    }
    
    k()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final l Vdj;
    
    static
    {
      AppMethodBeat.i(209742);
      Vdj = new l();
      AppMethodBeat.o(209742);
    }
    
    l()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(205399);
      Object localObject = r.VcW;
      localObject = (CharSequence)r.hvG();
      if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = new StringBuilder("replaceAdData replace lastAId=");
          r localr = r.VcW;
          Log.d("MicroMsg.BizCardLogic", r.hvG());
        }
        r.VcW.bva(this.soI);
        AppMethodBeat.o(205399);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    public static final n Vdk;
    
    static
    {
      AppMethodBeat.i(205357);
      Vdk = new n();
      AppMethodBeat.o(205357);
    }
    
    public final void run()
    {
      AppMethodBeat.i(205356);
      Object localObject1 = r.VcW;
      localObject1 = r.hwh();
      if (localObject1 != null)
      {
        localObject2 = ((z)localObject1).hwO();
        localObject3 = r.VcW;
        if (Util.isEqual((String)localObject2, r.hvG()))
        {
          localObject1 = new StringBuilder("replaceTimelineAd is same ad lastAId=");
          localObject2 = r.VcW;
          Log.i("MicroMsg.BizCardLogic", r.hvG() + '}');
          AppMethodBeat.o(205356);
          return;
        }
        localObject2 = r.VcW;
        localObject2 = r.hwi();
        localObject3 = r.VcW;
        ((z)localObject1).field_content = ((MultiProcessMMKV)localObject2).decodeString(r.bvf("biz_ad_card_data"));
        ((z)localObject1).field_createTime = bq.beS();
        boolean bool = com.tencent.mm.ao.af.bjB().H((z)localObject1);
        localObject2 = r.VcW;
        localObject2 = r.hwi();
        localObject3 = r.VcW;
        ((MultiProcessMMKV)localObject2).encode(r.bvf("biz_ad_card_data"), "");
        localObject2 = r.VcW;
        r.hvH();
        localObject2 = r.VcW;
        r.hvI();
        localObject2 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
        localObject3 = new StringBuilder("err_code:0,err_msg:'ok', aid:'");
        r localr = r.VcW;
        ((com.tencent.mm.plugin.brandservice.a.c)localObject2).n("wxa06c02b5c00ff39b", null, "adReplace", r.hvG() + '\'');
        Log.i("MicroMsg.BizCardLogic", "replaceAd updateById result: " + bool + ", msgId:" + ((z)localObject1).field_msgId + " orderFlag:" + ((z)localObject1).field_orderFlag + " aid: " + ((z)localObject1).hwO());
        AppMethodBeat.o(205356);
        return;
      }
      localObject1 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
      Object localObject2 = new StringBuilder("err_code:1,err_msg:'ad exposed', aid:'");
      Object localObject3 = r.VcW;
      ((com.tencent.mm.plugin.brandservice.a.c)localObject1).n("wxa06c02b5c00ff39b", null, "adReplace", r.hvG() + '\'');
      AppMethodBeat.o(205356);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final o Vdl;
    
    static
    {
      AppMethodBeat.i(207674);
      Vdl = new o();
      AppMethodBeat.o(207674);
    }
    
    o()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final p Vdm;
    
    static
    {
      AppMethodBeat.i(205928);
      Vdm = new p();
      AppMethodBeat.o(205928);
    }
    
    p()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final q Vdn;
    
    static
    {
      AppMethodBeat.i(205646);
      Vdn = new q();
      AppMethodBeat.o(205646);
    }
    
    q()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.storage;

import android.net.Uri;
import android.util.Base64;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.ehl;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizCardLogic;", "", "()V", "AD_COUNT_ONE_DAY", "", "AD_COUNT_ONE_DAY_MAX", "BIZ_AD_CARD_INSERT_POS", "CHECK_AD_INTERVAL", "DEFAULT_REFRESH_INTERVAL", "", "FROM_MAIN_CELL_EXPOSE", "FROM_MSG_RESORT", "FROM_TEST_PUSH", "KEY_BIZ_AD_CARD_DATA", "", "KEY_BIZ_AD_INSERT_POS", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CANVAS_LAST_TIME", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CRASH_TIMES", "KEY_BIZ_MAX_AD_COUNT", "KEY_BIZ_REFRESH_INTERVAL", "KEY_BIZ_REFRESH_LAST_TIME", "KEY_BIZ_ResortRefreshIntervalSec", "TAG", "aIdMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "adCardPrefix", "adMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getAdMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "adMmkv$delegate", "Lkotlin/Lazy;", "adOpen", "", "getAdOpen", "()Z", "adOpen$delegate", "canvasPreloadOpen", "getCanvasPreloadOpen", "canvasPreloadOpen$delegate", "checkedAIdSet", "Ljava/util/HashSet;", "exposeRefreshInterval", "getExposeRefreshInterval", "()J", "setExposeRefreshInterval", "(J)V", "hasPreload", "hasSetCrashFlag", "insertPos", "isForeGround", "lastAId", "getLastAId", "()Ljava/lang/String;", "setLastAId", "(Ljava/lang/String;)V", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "localInsertPos", "getLocalInsertPos", "()I", "localInsertPos$delegate", "maxAdCount", "mmkv", "getMmkv", "mmkv$delegate", "mockAdData", "getMockAdData", "mockPicAdData", "mockVideoAdData", "prefetchOpen", "getPrefetchOpen", "prefetchOpen$delegate", "recConflictOpen", "getRecConflictOpen", "recConflictOpen$delegate", "recOpen", "getRecOpen", "recOpen$delegate", "resortRefreshInterval", "getResortRefreshInterval", "setResortRefreshInterval", "testMode", "getTestMode", "testMode$delegate", "triggerDownLoadPkgOnGetAdData", "getTriggerDownLoadPkgOnGetAdData", "triggerDownLoadPkgOnGetAdData$delegate", "triggerDownLoadPkgOnGetRecData", "getTriggerDownLoadPkgOnGetRecData", "triggerDownLoadPkgOnGetRecData$delegate", "bizBoxClick", "", "checkAd", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doBizCardCgi", "from", "exposePreload", "getAdDataObject", "Lorg/json/JSONObject;", "content", "getAdInsertPos", "getExposeInterval", "getLastUnExposedAd", "getMaxAdCount", "getOrderFlag", "defOrderFlag", "getResortInterval", "getTimeLineContext", "handleExtInfo", "extInfo", "Lcom/tencent/mm/protocal/protobuf/AdvertisementExtInfo;", "insertAd", "isAdChecked", "aid", "isAdDataValid", "adData", "onAppBackground", "onAppForeground", "onMainCellExpose", "preloadAdCard", "preloadCanvasCard", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "info", "preloadUnInsertAdCard", "preloadUnInsertRecCard", "replaceAdData", "data", "replaceTimelineAd", "canvasId", "resetClashFlag", "saveAdData", "updateExtInfo", "updateInterval", "interval", "toAccountKey", "BizCardFlag", "BusinessId", "plugin-biz_release"})
public final class r
{
  public static int Kmn;
  private static final HashMap<String, Long> NOR;
  private static final HashSet<String> NOS;
  public static int NOT;
  private static String NOU;
  private static final f NOV;
  private static final f NOW;
  private static final f NOX;
  private static final f NOY;
  private static final f NOZ;
  private static final f NPa;
  static final f NPb;
  private static final f NPc;
  private static final f NPd;
  private static final f NPe;
  private static long NPf;
  static long NPg;
  private static boolean NPh;
  private static boolean NPi;
  private static final String NPj;
  private static final String NPk;
  public static final r NPl;
  private static final f iBW;
  private static final com.tencent.mm.al.r pnt;
  static boolean uft;
  
  static
  {
    AppMethodBeat.i(212542);
    NPl = new r();
    pnt = new com.tencent.mm.al.r(600000);
    NOR = new HashMap();
    NOS = new HashSet();
    NOT = -1;
    Kmn = -1;
    iBW = kotlin.g.ah((kotlin.g.a.a)r.h.NPu);
    NOV = kotlin.g.ah((kotlin.g.a.a)r.a.NPm);
    NOW = kotlin.g.ah((kotlin.g.a.a)r.n.NPz);
    NOX = kotlin.g.ah((kotlin.g.a.a)r.g.NPt);
    NOY = kotlin.g.ah((kotlin.g.a.a)r.b.NPn);
    NOZ = kotlin.g.ah((kotlin.g.a.a)r.k.NPx);
    NPa = kotlin.g.ah((kotlin.g.a.a)r.i.NPv);
    NPb = kotlin.g.ah((kotlin.g.a.a)r.j.NPw);
    NPc = kotlin.g.ah((kotlin.g.a.a)r.o.NPA);
    NPd = kotlin.g.ah((kotlin.g.a.a)r.p.NPB);
    NPe = kotlin.g.ah((kotlin.g.a.a)r.c.NPo);
    NPi = true;
    NPj = "  {\n  \"hint_txt\": \"创意-20200601_1\",\n  \"url\": \"http://e.cn.miaozhen.com/r/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=95e085c866db2ca4da4529b48423634da3737d13156ab08310b6c0d6b29adcaa89dc88172fab7fc8425d0e54f740947d&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"traceid\": \"wx0p67bjetlwkdc200\",\n  \"group_id\": \"wx0p67bjetlwkdc200_wx0p67bjetlwkdc201\",\n  \"ticket\": \"\",\n  \"aid\": \"274376350\",\n  \"pathType\": \"ad\",\n  \"pt\": 2,\n  \"image_url\": \"http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx2c1dad7332964d7d\",\n  \"biz_info\": {\n    \"user_name\": \"gh_f60cb6e1bbe0\",\n    \"nick_name\": \"新加坡旅游局\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM7ibCaN09GMnHSZNhcA9G36v9vhgIUy8OYX4PmcPwvg5Mw/0\",\n    \"biz_uin\": 3580351467,\n    \"signature\": \"心想狮城\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 0,\n  \"dest_type\": 1,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"998\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:1,&quot;jump_url&quot;:&quot;http:\\\\/\\\\/e.cn.miaozhen.com\\\\/r\\\\/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=6d7c64459169785a1510691ed6578b66d61408173f47c29e364658492046fbd0f7f55ad59c1e22f9fc7b42b8c5a84314&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"274376350|wx0p67bjetlwkdc200|255437066|0|1594265023|0|0|72058780271891663||AgKTRVlIlM5171j831mAsV9KhXn1D6AO9t0OzsoUSabfNucHFl9DpvWA4VsIAsTV6Sg=|274376355\",\n  \"ext_info\": \"\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d32a0fb17d38d299f730fd35928b7f5bbf\",\n  \"crt_info\": \"[{&quot;image_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;height&quot;:540,&quot;width&quot;:960,&quot;size&quot;:74132,&quot;image_md5&quot;:&quot;7a9c01200bcb2dba6a07c98abad6a89d&quot;,&quot;materialId&quot;:&quot;102225575&quot;,&quot;card_info&quot;:{&quot;head_desc_type&quot;:1,&quot;mp_tag_type&quot;:0}}]\",\n  \"reranking_ext_info\": \"{\\\"tid\\\":2303720433,\\\"material_hash\\\":\\\"CMzm1scGEOCTyMQC\\\"}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0100109996274}\"\n}";
    NPk = "  {\n  \"hint_txt\": \"创意-20200619_1\",\n  \"url\": \"pages/Home/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=227428a14b944e52c301d99d7769b9d5e6ccd7aa55aac2ca8ca514b5e77a73e83b1579fffef623a5d0972810be5e4fb7&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"traceid\": \"wx0zfmndr7d35pjq00\",\n  \"group_id\": \"wx0zfmndr7d35pjq00_wx0zfmndr7d35pjq01_wx0zfmndr7d35pjq02\",\n  \"ticket\": \"\",\n  \"aid\": \"278576846\",\n  \"pathType\": \"ad\",\n  \"pt\": 9,\n  \"image_url\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx032b61d035e02538\",\n  \"biz_info\": {\n    \"user_name\": \"gh_c5a5a55e74a5\",\n    \"nick_name\": \"BVLGARI宝格丽\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hgUXh7XsHRGLHRribgcXlRGXKB4phZorcicBGVeDWCYQQ/0\",\n    \"biz_uin\": 3074666211,\n    \"signature\": \"于1884年在罗马建立的高端珠宝品牌BVLGARI宝格丽，始终代表着精美奢华的意大利风格。\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 1,\n  \"video_info\": {\n    \"displayWidth\": 960,\n    \"displayHeight\": 540,\n    \"thumbUrl\": \"http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023\",\n    \"videoUrl\": \"http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023\"\n  },\n  \"weapp_info\": {\n    \"original_id\": \"gh_e70774015690\",\n    \"appid\": \"wx56b4770737a7dddf\",\n    \"nick_name\": \"BVLGARI宝格丽精品店\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5pN0eR1LRZJzPxALx3mRPYSmiaPbibPE5fQKS8xTy6ichbQ/0\"\n  },\n  \"dest_type\": 6,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"538\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:6,&quot;jump_url&quot;:&quot;pages\\\\/Home\\\\/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=5418655bc3dd454e4ed84dad6962668068661cb2009130ec86f3626ef4700e9b7a06ee64eb5d93f14e87b54ce39699c9&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"278576846|wx0zfmndr7d35pjq00||0|1594264005|0|0|72058780271891663||AgKNIqBiWhQxioBrueuTRKG/ZDGPF4ER7Im3GhiUj6HO7oRLhI/wSZTh3mxc7jqPZug=|278576919\",\n  \"ext_info\": \"{&quot;wx_app_type&quot;:2,&quot;gh_id&quot;:&quot;gh_e70774015690&quot;}\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d3779f0258b01c0503fbde6feda83a487b\",\n  \"crt_info\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"reranking_ext_info\": \"{tid:278576919}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0134623190388}\"\n}";
    AppMethodBeat.o(212542);
  }
  
  static long MJ(long paramLong)
  {
    AppMethodBeat.i(212535);
    int i = Kmn;
    if (2 > i) {}
    z localz;
    while (10 < i)
    {
      if (gzK() <= 0) {
        break;
      }
      i = gzK();
      localz = ag.ban().ajW(kotlin.k.j.mZ(i - 2, 0));
      if (localz != null) {
        break label110;
      }
      Log.w("MicroMsg.BizCardLogic", "getOrderFlag lastTimeLineInfo is null");
      AppMethodBeat.o(212535);
      return 0L;
    }
    for (;;)
    {
      i = Kmn;
      break;
      Kmn = gzI().decodeInt("biz_card_ad_insert_pos", 3);
      i = Kmn;
      if ((2 > i) || (10 < i)) {
        Kmn = 3;
      }
    }
    label110:
    if (i == 1) {}
    long l2;
    for (long l1 = localz.field_orderFlag + 1L;; l1 = localz.field_orderFlag - 1L)
    {
      l2 = l1;
      if (l1 != paramLong) {
        break;
      }
      AppMethodBeat.o(212535);
      return l1;
    }
    while (ag.ban().ML(l2) != null)
    {
      Log.w("MicroMsg.BizCardLogic", "insertAd field_orderFlag conflict orderFlag=".concat(String.valueOf(l2)));
      l2 -= 1L;
    }
    AppMethodBeat.o(212535);
    return l2;
  }
  
  private static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(212511);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(212511);
    return localMultiProcessMMKV;
  }
  
  public static String ajQ(int paramInt)
  {
    AppMethodBeat.i(212522);
    Object localObject1 = ag.ban().ajT(5);
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
        p.g(localObject1, "it");
        localObject1 = (Iterable)localObject1;
        int i = 0;
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label1093;
        }
        localObject1 = localIterator.next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject3 = (z)localObject1;
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("index", i);
        p.g(localObject3, "msg");
        if (((z)localObject3).gAt())
        {
          localJSONObject2.put("is_recommand", false);
          localObject4 = new JSONArray();
          localObject1 = (com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class);
          if (localObject1 == null) {
            break label1136;
          }
          localObject1 = ((com.tencent.mm.plugin.biz.a.a)localObject1).a(((z)localObject3).field_msgId, ((z)localObject3).field_content);
          if (localObject1 != null)
          {
            localObject1 = ((u)localObject1).iAd;
            if (localObject1 != null)
            {
              localObject1 = (Iterable)localObject1;
              j = 0;
              localObject1 = ((Iterable)localObject1).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject5 = ((Iterator)localObject1).next();
                if (j < 0) {
                  kotlin.a.j.hxH();
                }
                localObject6 = (v)localObject5;
                localObject5 = new JSONObject();
                if (!Util.isNullOrNil(((v)localObject6).url))
                {
                  localObject7 = Uri.parse(((v)localObject6).url);
                  k = Util.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
                  l = Util.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
                  localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
                  p.g(localObject7, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
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
                localObject7 = x.SXb;
                ((JSONObject)localObject5).put("user_action", localObject6);
                localObject6 = x.SXb;
                ((JSONArray)localObject4).put(localObject5);
                j += 1;
                continue;
              }
              localObject1 = x.SXb;
            }
          }
          localObject1 = x.SXb;
          localJSONObject2.put("msg", localObject4);
          label526:
          localJSONArray.put(localJSONObject2);
          i += 1;
          continue;
        }
        if (!((z)localObject3).gAu()) {
          continue;
        }
        localJSONObject2.put("is_recommend", true);
        localObject4 = ((z)localObject3).gAD();
        if (localObject4 == null) {
          break label757;
        }
        j = ((ege)localObject4).style;
        localJSONObject2.put("style", j);
        if ((localObject4 == null) || (((ege)localObject4).style != 1001)) {
          break;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("extra_data", ((ege)localObject4).dSJ);
        ((JSONObject)localObject1).put("msg_time", ((z)localObject3).field_createTime);
        localObject4 = new JSONObject();
        if (((z)localObject3).field_isRead != 1) {
          break label762;
        }
        j = 1;
        ((JSONObject)localObject4).put("type", j);
        localObject3 = x.SXb;
        ((JSONObject)localObject1).put("user_action", localObject4);
        localObject3 = x.SXb;
        localJSONObject2.put("ext_info", localObject1);
        continue;
        localObject2 = localJSONObject1.toString();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BizCardLogic", (Throwable)localException, "getTimeLineContext", new Object[0]);
      }
      label725:
      p.g(localObject2, "timelineContext.toString()");
      p.g(localObject2, "SubCoreBiz.getBizTimeLin…text.toString()\n        }");
      AppMethodBeat.o(212522);
      return localObject2;
      label757:
      j = 0;
      continue;
      label762:
      j = 0;
    }
    Object localObject2 = new JSONArray();
    Object localObject4 = (Iterable)af.F((z)localObject3);
    int j = 0;
    localObject4 = ((Iterable)localObject4).iterator();
    label797:
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((Iterator)localObject4).next();
      if (j < 0) {
        kotlin.a.j.hxH();
      }
      localObject6 = (pi)localObject5;
      localObject5 = new JSONObject();
      if (!Util.isNullOrNil(((pi)localObject6).KSj))
      {
        localObject7 = Uri.parse(((pi)localObject6).KSj);
        k = Util.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
        l = Util.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
        localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
        p.g(localObject7, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
        ((JSONObject)localObject5).put("bizuin", Util.getLong(new String((byte[])localObject7, kotlin.n.d.UTF_8), 0L));
        ((JSONObject)localObject5).put("mid", l);
        ((JSONObject)localObject5).put("idx", k);
        ((JSONObject)localObject5).put("title", ((pi)localObject6).Title);
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
      localObject7 = x.SXb;
      ((JSONObject)localObject5).put("user_action", localObject6);
      localObject6 = x.SXb;
      ((JSONArray)localObject2).put(localObject5);
      j += 1;
      break label797;
      localObject3 = x.SXb;
      localObject3 = x.SXb;
      localJSONObject2.put("msg", localObject2);
      break label526;
      label1093:
      localJSONObject1.put("timeline_context", localJSONArray);
      localJSONObject1.put("timeline_request_type", paramInt);
      localJSONObject1.put("last_expose_time", gzI().decodeLong("BizLastExposeAdTime", 0L));
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
  
  static String biG(String paramString)
  {
    AppMethodBeat.i(212510);
    paramString = new StringBuilder().append(paramString).append('-');
    p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    paramString = com.tencent.mm.kernel.a.ayV();
    AppMethodBeat.o(212510);
    return paramString;
  }
  
  public static JSONObject biI(String paramString)
  {
    AppMethodBeat.i(212525);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(212525);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("advertisement_info");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0);
        AppMethodBeat.o(212525);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.BizCardLogic", "getAdData ex %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(212525);
    }
    return null;
  }
  
  public static boolean biJ(String paramString)
  {
    AppMethodBeat.i(212533);
    p.h(paramString, "canvasId");
    Object localObject = (CharSequence)NOU;
    if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212533);
      return false;
    }
    localObject = paramString.substring(10);
    p.g(localObject, "(this as java.lang.String).substring(startIndex)");
    if (ab.NQR)
    {
      if (!Util.isEqual(NOU, (String)localObject))
      {
        AppMethodBeat.o(212533);
        return false;
      }
      com.tencent.f.h.RTc.b((Runnable)m.NPy, "BizInsertTlRecCardThread");
      AppMethodBeat.o(212533);
      return true;
    }
    if (Util.isEqual(NOU, (String)localObject))
    {
      Log.i("MicroMsg.BizCardLogic", "replaceTimelineAd but not in timeline lastAId=" + NOU + ", canvasId=" + paramString);
      ((b)com.tencent.mm.kernel.g.af(b.class)).P("wxa06c02b5c00ff39b", "adReplace", "err_code:2,err_msg:'not in timeline', aid:'" + NOU + '\'');
      NOU = null;
    }
    AppMethodBeat.o(212533);
    return false;
  }
  
  public static boolean biK(String paramString)
  {
    AppMethodBeat.i(212540);
    p.h(paramString, "aid");
    boolean bool = NOS.contains(paramString);
    AppMethodBeat.o(212540);
    return bool;
  }
  
  static boolean cg(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(212524);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(212524);
      return false;
    }
    long l1 = bp.aVP() / 1000L;
    long l2 = paramJSONObject.optLong("ad_expire_time", l1);
    if (l1 <= l2) {
      bool = true;
    }
    if (!bool)
    {
      com.tencent.mm.plugin.webcanvas.l locall = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.LV(103L);
      Log.i("MicroMsg.BizCardLogic", "isAdDataValid ad expire aid=" + paramJSONObject.optString("aid") + " adExpireTime=" + l2);
    }
    AppMethodBeat.o(212524);
    return bool;
  }
  
  private void ch(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212537);
        p.h(paramJSONObject, "adData");
        try
        {
          str1 = paramJSONObject.optString("aid");
          p.g(str1, "adData.optString(\"aid\")");
          str2 = paramJSONObject.optString("path_type", "ad");
          p.g(str2, "adData.optString(\"path_type\", \"ad\")");
          Log.i("MicroMsg.BizCardLogic", "preloadAdCard aid=" + str1 + ", pathType=" + str2);
          localObject = (CharSequence)str1;
          if (localObject == null) {
            break label232;
          }
          if (!n.aL((CharSequence)localObject)) {
            break label222;
          }
        }
        catch (Exception paramJSONObject)
        {
          String str1;
          String str2;
          Object localObject;
          Log.w("MicroMsg.BizCardLogic", "preloadAdCard ex %s", new Object[] { paramJSONObject.getMessage() });
          AppMethodBeat.o(212537);
          continue;
        }
        if (i == 0)
        {
          localObject = (CharSequence)str2;
          if (localObject == null) {
            break label237;
          }
          if (!n.aL((CharSequence)localObject)) {
            break label227;
          }
          break label237;
          if (i == 0)
          {
            localObject = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(8L);
            ((b)com.tencent.mm.kernel.g.af(b.class)).Q(str2, "__ad_card_".concat(String.valueOf(str1)), paramJSONObject.toString());
          }
        }
        AppMethodBeat.o(212537);
        return;
      }
      finally {}
      label222:
      int i = 0;
      continue;
      label227:
      i = 0;
      continue;
      label232:
      i = 1;
      continue;
      label237:
      i = 1;
    }
  }
  
  public static void eXq()
  {
    AppMethodBeat.i(212531);
    if (!gzL())
    {
      AppMethodBeat.o(212531);
      return;
    }
    Object localObject1 = ag.ban().kL(637534257, 1);
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
      iC((List)localObject1);
      AppMethodBeat.o(212531);
      return;
    }
    AppMethodBeat.o(212531);
  }
  
  public static String gzG()
  {
    return NOU;
  }
  
  public static void gzH()
  {
    NOU = null;
  }
  
  static MultiProcessMMKV gzI()
  {
    AppMethodBeat.i(212512);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)NOV.getValue();
    AppMethodBeat.o(212512);
    return localMultiProcessMMKV;
  }
  
  public static int gzJ()
  {
    AppMethodBeat.i(212513);
    int i = ((Number)NOW.getValue()).intValue();
    AppMethodBeat.o(212513);
    return i;
  }
  
  private static int gzK()
  {
    AppMethodBeat.i(212514);
    int i = ((Number)NOX.getValue()).intValue();
    AppMethodBeat.o(212514);
    return i;
  }
  
  public static boolean gzL()
  {
    AppMethodBeat.i(212515);
    boolean bool = ((Boolean)NOY.getValue()).booleanValue();
    AppMethodBeat.o(212515);
    return bool;
  }
  
  public static boolean gzM()
  {
    AppMethodBeat.i(212516);
    boolean bool = ((Boolean)NOZ.getValue()).booleanValue();
    AppMethodBeat.o(212516);
    return bool;
  }
  
  public static boolean gzN()
  {
    AppMethodBeat.i(212517);
    boolean bool = ((Boolean)NPa.getValue()).booleanValue();
    AppMethodBeat.o(212517);
    return bool;
  }
  
  private static boolean gzO()
  {
    AppMethodBeat.i(212518);
    boolean bool = ((Boolean)NPc.getValue()).booleanValue();
    AppMethodBeat.o(212518);
    return bool;
  }
  
  public static boolean gzP()
  {
    AppMethodBeat.i(212519);
    boolean bool = ((Boolean)NPd.getValue()).booleanValue();
    AppMethodBeat.o(212519);
    return bool;
  }
  
  public static boolean gzQ()
  {
    AppMethodBeat.i(212520);
    boolean bool = ((Boolean)NPe.getValue()).booleanValue();
    AppMethodBeat.o(212520);
    return bool;
  }
  
  public static void gzR()
  {
    AppMethodBeat.i(212526);
    gzI().encode("biz_card_max_ad_count", NOT);
    int i = Kmn;
    if (2 > i)
    {
      AppMethodBeat.o(212526);
      return;
    }
    if (10 >= i) {
      gzI().encode("biz_card_ad_insert_pos", Kmn);
    }
    AppMethodBeat.o(212526);
  }
  
  private static long gzS()
  {
    AppMethodBeat.i(212527);
    if (NPf > 1000L)
    {
      l = NPf;
      AppMethodBeat.o(212527);
      return l;
    }
    long l = gzI().getLong("biz_card_refresh_interval", 3600000L);
    NPf = l;
    AppMethodBeat.o(212527);
    return l;
  }
  
  private static long gzT()
  {
    AppMethodBeat.i(212528);
    if (NPg > 1000L)
    {
      l = NPg;
      AppMethodBeat.o(212528);
      return l;
    }
    long l = gzI().getLong("biz_card_resort_Refresh_IntervalSec", 3600000L);
    NPg = l;
    AppMethodBeat.o(212528);
    return l;
  }
  
  public static void gzU()
  {
    AppMethodBeat.i(212529);
    NPi = false;
    if (NPh) {
      gzW();
    }
    AppMethodBeat.o(212529);
  }
  
  public static void gzV()
  {
    NPi = true;
  }
  
  private static void gzW()
  {
    AppMethodBeat.i(212530);
    Log.i("MicroMsg.BizCardLogic", "exposePreload reset crash flag");
    c localc = c.pfv;
    c.cks().encode("biz_canvas_card_expose_preload_crash_times", 0);
    AppMethodBeat.o(212530);
  }
  
  static z gzX()
  {
    AppMethodBeat.i(212536);
    z localz = ag.ban().gAL();
    if ((localz != null) && (localz.field_isRead == 0))
    {
      AppMethodBeat.o(212536);
      return localz;
    }
    AppMethodBeat.o(212536);
    return null;
  }
  
  private static String gzY()
  {
    AppMethodBeat.i(212541);
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (aTI().getInt("BizTimeLineAdMockType", 0) == 0) {}
    for (String str = NPk;; str = NPj)
    {
      localJSONArray.put(new JSONObject(str));
      localJSONObject.put("advertisement_info", localJSONArray);
      localJSONObject.put("advertisement_num", 1);
      str = localJSONObject.toString();
      p.g(str, "adData.toString()");
      AppMethodBeat.o(212541);
      return str;
    }
  }
  
  private static void iC(List<? extends z> paramList)
  {
    AppMethodBeat.i(212532);
    p.h(paramList, "list");
    if ((!gzL()) || (Util.isNullOrNil(paramList)))
    {
      AppMethodBeat.o(212532);
      return;
    }
    if (gzJ() == 1)
    {
      AppMethodBeat.o(212532);
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
      localObject4 = pnt;
      localObject5 = ((z)localObject5).gAG();
      p.g(localObject5, "it.aId");
      if (!((com.tencent.mm.al.r)localObject4).contains((String)localObject5)) {}
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
        Object localObject6 = ((z)localObject2).gAE();
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
        localObject6 = (Map)NOR;
        p.g(localObject5, "aid");
        ((Map)localObject6).put(localObject5, Long.valueOf(((z)localObject2).field_msgId));
        localLinkedList.add(localObject5);
        paramList.put(localObject4);
        pnt.add((String)localObject5);
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
    p.g(paramList, "list?.filter {\n         …  }?.toString()\n        }");
    localObject1 = (CharSequence)paramList;
    if ((localObject1 == null) || (n.aL((CharSequence)localObject1))) {}
    for (int j = 1; (j != 0) || (i == 0); j = 0)
    {
      AppMethodBeat.o(212532);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
    com.tencent.mm.plugin.webcanvas.l.LV(16L);
    localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.bw.a)new ehk());
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new ehl());
    ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((d.a)localObject1).sG(2781);
    localObject1 = ((d.a)localObject1).aXF();
    p.g(localObject1, "rr");
    Object localObject3 = ((com.tencent.mm.ak.d)localObject1).aYJ();
    if (localObject3 == null)
    {
      paramList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(212532);
      throw paramList;
    }
    localObject3 = (ehk)localObject3;
    ((ehk)localObject3).KWz = System.currentTimeMillis();
    ((ehk)localObject3).KWE = 2;
    ((ehk)localObject3).KWF = paramList;
    com.tencent.mm.ak.aa.a((com.tencent.mm.ak.d)localObject1, (aa.a)new d(localLinkedList));
    AppMethodBeat.o(212532);
  }
  
  public static void replaceAdData(String paramString)
  {
    AppMethodBeat.i(212534);
    com.tencent.f.h.RTc.b((Runnable)new l(paramString), "BizInsertTlRecCardThread");
    AppMethodBeat.o(212534);
  }
  
  public final void ajP(int paramInt)
  {
    AppMethodBeat.i(212521);
    if (!gzL())
    {
      AppMethodBeat.o(212521);
      return;
    }
    if (gzJ() == 1)
    {
      biH(gzY());
      gzI().encode("biz_card_last_time", System.currentTimeMillis());
      AppMethodBeat.o(212521);
      return;
    }
    if (gzN())
    {
      Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + gzJ() + " from=" + paramInt);
      localObject2 = (b)com.tencent.mm.kernel.g.af(b.class);
      if (2 == paramInt) {}
      for (localObject1 = "mainCellExpose";; localObject1 = "resortEnd")
      {
        ((b)localObject2).P("wxa06c02b5c00ff39b", (String)localObject1, "from:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(212521);
        return;
      }
    }
    long l2 = gzI().getLong("biz_card_last_time", 0L);
    long l3 = System.currentTimeMillis();
    long l4 = Math.abs(l3 - l2);
    if (paramInt == 1) {}
    for (long l1 = gzT(); (3 != paramInt) && (((gzJ() <= 0) && (l4 < l1)) || ((gzJ() > 0) && (l4 < 10000L))); l1 = gzS())
    {
      Log.d("MicroMsg.BizCardLogic", "doBizCardCgi delta < interval, return from=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(212521);
      return;
    }
    gzI().encode("biz_card_last_time", System.currentTimeMillis());
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.bw.a)new ehk());
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new ehl());
    ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((d.a)localObject1).sG(2781);
    localObject1 = ((d.a)localObject1).aXF();
    p.g(localObject1, "rr");
    Object localObject2 = ((com.tencent.mm.ak.d)localObject1).aYJ();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(212521);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ehk)localObject2;
    ((ehk)localObject2).KWz = System.currentTimeMillis();
    ((ehk)localObject2).KWE = 1;
    ((ehk)localObject2).KUk = "";
    ((ehk)localObject2).KWF = ajQ(paramInt);
    Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + gzJ() + " from=" + paramInt + " interval=" + l1 + " lastTime=" + l2 + " currentMills=" + l3);
    localObject2 = com.tencent.mm.plugin.webcanvas.l.IAx;
    com.tencent.mm.plugin.webcanvas.l.LV(0L);
    com.tencent.mm.ak.aa.a((com.tencent.mm.ak.d)localObject1, (aa.a)e.NPq);
    AppMethodBeat.o(212521);
  }
  
  /* Error */
  public final boolean b(ege paramege)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1211
    //   5: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +121 -> 130
    //   12: aload_1
    //   13: getfield 628	com/tencent/mm/protocal/protobuf/ege:style	I
    //   16: sipush 1001
    //   19: if_icmpne +111 -> 130
    //   22: aload_1
    //   23: getfield 1215	com/tencent/mm/protocal/protobuf/ege:Ngc	Lcom/tencent/mm/protocal/protobuf/dkp;
    //   26: ifnull +104 -> 130
    //   29: ldc_w 370
    //   32: ldc_w 1217
    //   35: invokestatic 1192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: getstatic 863	com/tencent/mm/plugin/webcanvas/l:IAx	Lcom/tencent/mm/plugin/webcanvas/l;
    //   41: astore_3
    //   42: ldc2_w 1218
    //   45: invokestatic 868	com/tencent/mm/plugin/webcanvas/l:LV	(J)V
    //   48: ldc_w 825
    //   51: invokestatic 511	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   54: checkcast 825	com/tencent/mm/plugin/brandservice/a/b
    //   57: astore 5
    //   59: aload_1
    //   60: getfield 1215	com/tencent/mm/protocal/protobuf/ege:Ngc	Lcom/tencent/mm/protocal/protobuf/dkp;
    //   63: getfield 1224	com/tencent/mm/protocal/protobuf/dkp:MOE	Ljava/lang/String;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload 4
    //   73: ifnonnull +7 -> 80
    //   76: ldc_w 1226
    //   79: astore_3
    //   80: aload 5
    //   82: aload_3
    //   83: new 695	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 1228
    //   90: invokespecial 699	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_1
    //   94: getfield 1215	com/tencent/mm/protocal/protobuf/ege:Ngc	Lcom/tencent/mm/protocal/protobuf/dkp;
    //   97: getfield 1231	com/tencent/mm/protocal/protobuf/dkp:cardId	Ljava/lang/String;
    //   100: invokevirtual 714	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 715	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload_1
    //   107: getfield 1215	com/tencent/mm/protocal/protobuf/ege:Ngc	Lcom/tencent/mm/protocal/protobuf/dkp;
    //   110: getfield 1233	com/tencent/mm/protocal/protobuf/dkp:data	Ljava/lang/String;
    //   113: invokeinterface 905 4 0
    //   118: iconst_1
    //   119: istore_2
    //   120: ldc_w 1211
    //   123: invokestatic 338	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: monitorexit
    //   128: iload_2
    //   129: ireturn
    //   130: iconst_0
    //   131: istore_2
    //   132: ldc_w 1211
    //   135: invokestatic 338	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -12 -> 126
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	r
    //   0	146	1	paramege	ege
    //   119	13	2	bool	boolean
    //   41	42	3	localObject	Object
    //   66	6	4	str	String
    //   57	24	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	8	141	finally
    //   12	68	141	finally
    //   80	118	141	finally
    //   120	126	141	finally
    //   132	138	141	finally
  }
  
  public final void biH(String paramString)
  {
    AppMethodBeat.i(212523);
    if (!com.tencent.mm.kernel.g.aAc()) {
      Log.i("MicroMsg.BizCardLogic", "saveAdData acc not ready");
    }
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizCardLogic", "saveAdData data is null");
      paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.LV(3L);
      AppMethodBeat.o(212523);
      return;
    }
    localObject = com.tencent.mm.plugin.webcanvas.l.IAx;
    com.tencent.mm.plugin.webcanvas.l.LV(4L);
    localObject = biI(paramString);
    if (localObject == null)
    {
      Log.i("MicroMsg.BizCardLogic", "saveAdData adData is null");
      paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.LV(91L);
      AppMethodBeat.o(212523);
      return;
    }
    com.tencent.mm.plugin.webcanvas.l locall = com.tencent.mm.plugin.webcanvas.l.IAx;
    com.tencent.mm.plugin.webcanvas.l.LV(92L);
    if (gzO()) {
      m.IAG.fWS();
    }
    ch((JSONObject)localObject);
    NOU = ((JSONObject)localObject).optString("aid");
    gzI().encode(biG("biz_ad_card_data"), paramString);
    AppMethodBeat.o(212523);
  }
  
  public final boolean z(z paramz)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212538);
        p.h(paramz, "info");
        if (paramz.gAv())
        {
          Log.d("MicroMsg.BizCardLogic", "preload ad card");
          Object localObject = com.tencent.mm.plugin.webcanvas.l.IAx;
          com.tencent.mm.plugin.webcanvas.l.LV(8L);
          b localb = (b)com.tencent.mm.kernel.g.af(b.class);
          String str = paramz.getPathType();
          localObject = str;
          if (str == null) {
            localObject = "ad";
          }
          localb.Q((String)localObject, "__ad_card_" + paramz.gAG(), paramz.acx());
          bool = true;
          AppMethodBeat.o(212538);
          return bool;
        }
        if (paramz.gAu())
        {
          bool = b(paramz.gAD());
          AppMethodBeat.o(212538);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      AppMethodBeat.o(212538);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class d
    implements aa.a
  {
    d(LinkedList paramLinkedList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
    {
      AppMethodBeat.i(212485);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.BizCardLogic", "checkAd callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(17L);
        AppMethodBeat.o(212485);
        return 0;
      }
      p.g(paramd, "rr");
      paramd = paramd.aYK();
      paramString = paramd;
      if (!(paramd instanceof ehl)) {
        paramString = null;
      }
      paramString = (ehl)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(212485);
        return 0;
      }
      if (Util.isNullOrNil(paramString.KWF))
      {
        Log.e("MicroMsg.BizCardLogic", "checkAd callback resp.Data is empty");
        paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(18L);
        AppMethodBeat.o(212485);
        return 0;
      }
      paramd = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.LV(19L);
      for (;;)
      {
        try
        {
          paramd = new JSONObject(paramString.KWF);
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
              if (!n.aL((CharSequence)localObject1)) {
                break label732;
              }
              break label715;
              if (paramInt2 != 0) {
                break label720;
              }
              localObject1 = r.NPl;
              Object localObject2 = (Long)r.gAb().get(paramq);
              if (localObject2 == null) {
                break label720;
              }
              localObject1 = ag.ban().MM(((Long)localObject2).longValue());
              if (localObject1 == null) {
                break label720;
              }
              ag.ban().MX(((Long)localObject2).longValue());
              Log.e("MicroMsg.BizCardLogic", "checkAd force delete ad ".concat(String.valueOf(paramq)));
              localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
              String str = ((z)localObject1).getTraceId();
              if (((z)localObject1).field_isRead != 1) {
                break label737;
              }
              paramInt2 = 1;
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(20635, new Object[] { paramq, str, Integer.valueOf(2), Integer.valueOf(paramInt2) });
              paramq = com.tencent.mm.plugin.webcanvas.l.IAx;
              if (((z)localObject1).field_isRead != 1) {
                break label742;
              }
              l = 21L;
              com.tencent.mm.plugin.webcanvas.l.LV(l);
              paramq = com.tencent.mm.plugin.webcanvas.l.IAx;
              com.tencent.mm.plugin.webcanvas.l.LV(23L);
              break label720;
            }
          }
          paramd = ((Iterable)this.NPp).iterator();
          if (paramd.hasNext())
          {
            paramq = (String)paramd.next();
            localObject1 = r.NPl;
            r.gAc().add(paramq);
            if (!(p.j(paramq, paramString) ^ true)) {
              continue;
            }
            localObject1 = r.NPl;
            localObject1 = (Long)r.gAb().get(paramq);
            if (localObject1 == null) {
              continue;
            }
            paramq = ag.ban().MM(((Long)localObject1).longValue());
            if (paramq == null) {
              continue;
            }
            if (paramq.field_isRead != 0) {
              break label658;
            }
            ag.ban().MX(((Long)localObject1).longValue());
            Log.e("MicroMsg.BizCardLogic", "checkAd delete ad " + paramq.gAG());
            com.tencent.mm.plugin.report.service.h.CyF.a(20635, new Object[] { paramq.gAG(), paramq.getTraceId(), Integer.valueOf(1), Integer.valueOf(0) });
            paramq = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(22L);
          }
          Object localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.BizCardLogic", "checkAd callback ex " + paramString.getMessage());
          AppMethodBeat.o(212485);
          return 0;
        }
        label658:
        com.tencent.mm.plugin.webcanvas.l.LV(24L);
        com.tencent.mm.plugin.report.service.h.CyF.a(20635, new Object[] { paramq.gAG(), paramq.getTraceId(), Integer.valueOf(0), Integer.valueOf(1) });
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class e
    implements aa.a
  {
    public static final e NPq;
    
    static
    {
      AppMethodBeat.i(212487);
      NPq = new e();
      AppMethodBeat.o(212487);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
    {
      paramq = null;
      AppMethodBeat.i(212486);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.BizCardLogic", "doBizCardCgi callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(1L);
        if (paramInt2 == 1004)
        {
          paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
          com.tencent.mm.plugin.webcanvas.l.LV(7L);
        }
        AppMethodBeat.o(212486);
        return 0;
      }
      paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.LV(2L);
      p.g(paramd, "rr");
      paramd = paramd.aYK();
      paramString = paramd;
      if (!(paramd instanceof ehl)) {
        paramString = null;
      }
      paramd = (ehl)paramString;
      if (paramd == null)
      {
        AppMethodBeat.o(212486);
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder("doBizCardCgi callback ");
      if (paramd != null) {}
      for (paramString = paramd.KWF;; paramString = null)
      {
        Log.d("MicroMsg.BizCardLogic", paramString);
        localStringBuilder = new StringBuilder("doBizCardCgi callback errType=").append(paramInt1).append(", errCode=").append(paramInt2).append(" interval=");
        paramString = paramq;
        if (paramd != null) {
          paramString = Integer.valueOf(paramd.KSO);
        }
        Log.i("MicroMsg.BizCardLogic", paramString.intValue());
        paramString = r.NPl;
        r.ajR(paramd.KSO);
        paramString = r.NPl;
        paramString = paramd.xNU;
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
              r.NPg = paramInt1 * 1000L;
              r.gzI().encode("biz_card_resort_Refresh_IntervalSec", r.NPg);
            }
          }
          r.NOT = paramString.optInt("MaxAdCount", 1);
          r.Kmn = paramString.optInt("AdInsertPos", 3);
          r.gzR();
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.BizCardLogic", "handleExtInfo ex " + paramString.getMessage());
            continue;
            paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(5L);
          }
        }
        if ((paramd.KHa & 0x1) != 0) {
          break;
        }
        r.NPl.biH(paramd.KWF);
        paramString = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(6L);
        AppMethodBeat.o(212486);
        return 0;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(212490);
      Object localObject1 = c.pfv;
      c.cks().encode("biz_canvas_card_expose_preload_crash_times", this.NPr + 1);
      Log.i("MicroMsg.BizCardLogic", "exposePreload set crash flag");
      localObject1 = r.NPl;
      r.AJ(true);
      localObject1 = ag.ban().kL(637534257, 1);
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
        localr = r.NPl;
        p.g(localObject2, "info");
        localr.z((z)localObject2);
        localObject2 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(12L);
      }
      label146:
      label335:
      for (int i = 1;; i = j)
      {
        j = i;
        break;
        i = 0;
        localObject1 = ag.ban().kL(620757041, 1);
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
              localr = r.NPl;
              p.g(localObject2, "info");
              if (localr.z((z)localObject2))
              {
                localObject2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(13L);
                i = 1;
              }
            }
          }
        }
        r.a(r.NPl);
        r.b(r.NPl);
        ((b)com.tencent.mm.kernel.g.af(b.class)).clk();
        if (j != 0)
        {
          localObject1 = r.NPl;
          if (r.gzZ())
          {
            com.tencent.f.h.RTc.o((Runnable)1.NPs, 3000L);
            AppMethodBeat.o(212490);
            return;
          }
        }
        localObject1 = r.NPl;
        r.AJ(false);
        localObject1 = r.NPl;
        r.gAa();
        AppMethodBeat.o(212490);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(212501);
      Object localObject = r.NPl;
      localObject = (CharSequence)r.gzG();
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = new StringBuilder("replaceAdData replace lastAId=");
          r localr = r.NPl;
          Log.d("MicroMsg.BizCardLogic", r.gzG());
        }
        r.NPl.biH(this.pmq);
        AppMethodBeat.o(212501);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    public static final m NPy;
    
    static
    {
      AppMethodBeat.i(212503);
      NPy = new m();
      AppMethodBeat.o(212503);
    }
    
    public final void run()
    {
      AppMethodBeat.i(212502);
      Object localObject1 = r.NPl;
      localObject1 = r.gAd();
      if (localObject1 != null)
      {
        localObject2 = ((z)localObject1).gAG();
        localObject3 = r.NPl;
        if (Util.isEqual((String)localObject2, r.gzG()))
        {
          localObject1 = new StringBuilder("replaceTimelineAd is same ad lastAId=");
          localObject2 = r.NPl;
          Log.i("MicroMsg.BizCardLogic", r.gzG() + '}');
          AppMethodBeat.o(212502);
          return;
        }
        localObject2 = r.NPl;
        localObject2 = r.gAe();
        localObject3 = r.NPl;
        ((z)localObject1).field_content = ((MultiProcessMMKV)localObject2).decodeString(r.biL("biz_ad_card_data"));
        ((z)localObject1).field_createTime = bp.aVP();
        boolean bool = ag.ban().D((z)localObject1);
        localObject2 = r.NPl;
        localObject2 = r.gAe();
        localObject3 = r.NPl;
        ((MultiProcessMMKV)localObject2).encode(r.biL("biz_ad_card_data"), "");
        localObject2 = r.NPl;
        r.gzH();
        localObject2 = (b)com.tencent.mm.kernel.g.af(b.class);
        localObject3 = new StringBuilder("err_code:0,err_msg:'ok', aid:'");
        r localr = r.NPl;
        ((b)localObject2).P("wxa06c02b5c00ff39b", "adReplace", r.gzG() + '\'');
        Log.i("MicroMsg.BizCardLogic", "replaceAd updateById result: " + bool + ", msgId:" + ((z)localObject1).field_msgId + " orderFlag:" + ((z)localObject1).field_orderFlag + " aid: " + ((z)localObject1).gAG());
        AppMethodBeat.o(212502);
        return;
      }
      localObject1 = (b)com.tencent.mm.kernel.g.af(b.class);
      Object localObject2 = new StringBuilder("err_code:1,err_msg:'ad exposed', aid:'");
      Object localObject3 = r.NPl;
      ((b)localObject1).P("wxa06c02b5c00ff39b", "adReplace", r.gzG() + '\'');
      AppMethodBeat.o(212502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */
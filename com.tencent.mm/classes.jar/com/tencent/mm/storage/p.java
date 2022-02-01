package com.tencent.mm.storage;

import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.x.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.r;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.l;
import d.n.d;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/storage/BizCardLogic;", "", "()V", "AD_COUNT_ONE_DAY", "", "AD_COUNT_ONE_DAY_MAX", "BIZ_AD_CARD_INSERT_POS", "CHECK_AD_INTERVAL", "DEFAULT_REFRESH_INTERVAL", "", "FROM_MAIN_CELL_EXPOSE", "FROM_MSG_RESORT", "FROM_TEST_PUSH", "KEY_BIZ_AD_CARD_DATA", "", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CANVAS_LAST_TIME", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CRASH_TIMES", "KEY_BIZ_MAX_AD_COUNT", "KEY_BIZ_REFRESH_INTERVAL", "KEY_BIZ_REFRESH_LAST_TIME", "KEY_BIZ_ResortRefreshIntervalSec", "TAG", "aIdMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "adOpen", "", "getAdOpen", "()Z", "adOpen$delegate", "Lkotlin/Lazy;", "canvasPreloadOpen", "getCanvasPreloadOpen", "canvasPreloadOpen$delegate", "checkedAIdSet", "Ljava/util/HashSet;", "hasPreload", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "maxAdCount", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "mockAdData", "recOpen", "getRecOpen", "recOpen$delegate", "testMode", "getTestMode", "()I", "testMode$delegate", "checkAd", "", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doBizCardCgi", "from", "exposePreload", "getAdData", "content", "getMaxAdCount", "getMockAdData", "getTimeLineContext", "handleExtInfo", "extInfo", "insertAd", "isAdChecked", "aid", "isAdDataValid", "data", "onMainCellExpose", "preloadAdCard", "adData", "preloadCanvasCard", "info", "saveAdData", "updateInterval", "interval", "toAccountKey", "BizCardFlag", "BusinessId", "plugin-biz_release"})
public final class p
{
  private static final HashMap<String, Long> InL;
  private static final HashSet<String> InM;
  static int InN;
  private static final d.f InO;
  private static final d.f InP;
  private static final d.f InQ;
  private static final d.f InR;
  static boolean InS;
  private static final String InT;
  public static final p InU;
  private static final d.f nOP;
  private static final r nWL;
  
  static
  {
    AppMethodBeat.i(207341);
    InU = new p();
    nWL = new r(600000);
    InL = new HashMap();
    InM = new HashSet();
    InN = -1;
    nOP = d.g.O((d.g.a.a)p.f.Iob);
    InO = d.g.O((d.g.a.a)p.h.Iod);
    InP = d.g.O((d.g.a.a)p.a.InV);
    InQ = d.g.O((d.g.a.a)p.g.Ioc);
    InR = d.g.O((d.g.a.a)p.b.InW);
    InT = "  {\n  \"hint_txt\": \"创意-20200619_1\",\n  \"url\": \"pages/Home/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=227428a14b944e52c301d99d7769b9d5e6ccd7aa55aac2ca8ca514b5e77a73e83b1579fffef623a5d0972810be5e4fb7&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"traceid\": \"wx0zfmndr7d35pjq00\",\n  \"group_id\": \"wx0zfmndr7d35pjq00_wx0zfmndr7d35pjq01_wx0zfmndr7d35pjq02\",\n  \"ticket\": \"\",\n  \"aid\": \"278576846\",\n  \"pathType\": \"ad\",\n  \"pt\": 9,\n  \"image_url\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx032b61d035e02538\",\n  \"biz_info\": {\n    \"user_name\": \"gh_c5a5a55e74a5\",\n    \"nick_name\": \"BVLGARI宝格丽\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hgUXh7XsHRGLHRribgcXlRGXKB4phZorcicBGVeDWCYQQ/0\",\n    \"biz_uin\": 3074666211,\n    \"signature\": \"于1884年在罗马建立的高端珠宝品牌BVLGARI宝格丽，始终代表着精美奢华的意大利风格。\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 1,\n  \"video_info\": {\n    \"displayWidth\": 960,\n    \"displayHeight\": 540,\n    \"thumbUrl\": \"http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023\",\n    \"videoUrl\": \"http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023\"\n  },\n  \"weapp_info\": {\n    \"original_id\": \"gh_e70774015690\",\n    \"appid\": \"wx56b4770737a7dddf\",\n    \"nick_name\": \"BVLGARI宝格丽精品店\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5pN0eR1LRZJzPxALx3mRPYSmiaPbibPE5fQKS8xTy6ichbQ/0\"\n  },\n  \"dest_type\": 6,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"538\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:6,&quot;jump_url&quot;:&quot;pages\\\\/Home\\\\/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=5418655bc3dd454e4ed84dad6962668068661cb2009130ec86f3626ef4700e9b7a06ee64eb5d93f14e87b54ce39699c9&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"278576846|wx0zfmndr7d35pjq00||0|1594264005|0|0|72058780271891663||AgKNIqBiWhQxioBrueuTRKG/ZDGPF4ER7Im3GhiUj6HO7oRLhI/wSZTh3mxc7jqPZug=|278576919\",\n  \"ext_info\": \"{&quot;wx_app_type&quot;:2,&quot;gh_id&quot;:&quot;gh_e70774015690&quot;}\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d3779f0258b01c0503fbde6feda83a487b\",\n  \"crt_info\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"reranking_ext_info\": \"{tid:278576919}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0134623190388}\"\n}";
    AppMethodBeat.o(207341);
  }
  
  static String aSn(String paramString)
  {
    AppMethodBeat.i(207325);
    paramString = new StringBuilder().append(paramString).append('-');
    d.g.b.p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
    paramString = com.tencent.mm.kernel.a.aiq();
    AppMethodBeat.o(207325);
    return paramString;
  }
  
  private final void aSo(String paramString)
  {
    AppMethodBeat.i(207334);
    if (!com.tencent.mm.kernel.g.ajx()) {
      ad.i("MicroMsg.BizCardLogic", "saveAdData acc not ready");
    }
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (d.n.n.aE((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
      com.tencent.mm.plugin.webcanvas.f.Cj(3L);
      AppMethodBeat.o(207334);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
    com.tencent.mm.plugin.webcanvas.f.Cj(4L);
    localObject1 = aSp(paramString);
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (d.n.n.aE((CharSequence)localObject2))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207334);
      return;
    }
    localObject2 = com.tencent.mm.plugin.webcanvas.g.Dzc;
    com.tencent.mm.plugin.webcanvas.g.eLs();
    aSq((String)localObject1);
    bNe().encode(aSn("biz_ad_card_data"), paramString);
    AppMethodBeat.o(207334);
  }
  
  public static String aSp(String paramString)
  {
    AppMethodBeat.i(207335);
    d.g.b.p.h(paramString, "content");
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("advertisement_info");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0).toString();
        AppMethodBeat.o(207335);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.BizCardLogic", "getAdData ex %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(207335);
    }
    return null;
  }
  
  private void aSq(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207338);
        d.g.b.p.h(paramString, "adData");
        try
        {
          localObject1 = new JSONObject(paramString);
          str = ((JSONObject)localObject1).optString("aid");
          d.g.b.p.g(str, "adObject.optString(\"aid\")");
          localObject1 = ((JSONObject)localObject1).optString("path_type", "ad");
          d.g.b.p.g(localObject1, "adObject.optString(\"path_type\", \"ad\")");
          localObject2 = (CharSequence)str;
          if (localObject2 == null) {
            break label206;
          }
          if (!d.n.n.aE((CharSequence)localObject2)) {
            break label196;
          }
        }
        catch (Exception paramString)
        {
          Object localObject1;
          String str;
          Object localObject2;
          ad.w("MicroMsg.BizCardLogic", "preloadAdCard ex %s", new Object[] { paramString.getMessage() });
          AppMethodBeat.o(207338);
          continue;
        }
        if (i == 0)
        {
          localObject2 = (CharSequence)localObject1;
          if (localObject2 == null) {
            break label211;
          }
          if (!d.n.n.aE((CharSequence)localObject2)) {
            break label201;
          }
          break label211;
          if (i == 0)
          {
            localObject2 = com.tencent.mm.plugin.webcanvas.f.DyX;
            com.tencent.mm.plugin.webcanvas.f.Cj(8L);
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).L((String)localObject1, "__ad_card_".concat(String.valueOf(str)), paramString);
          }
        }
        AppMethodBeat.o(207338);
        return;
      }
      finally {}
      label196:
      int i = 0;
      continue;
      label201:
      i = 0;
      continue;
      label206:
      i = 1;
      continue;
      label211:
      i = 1;
    }
  }
  
  public static boolean aSr(String paramString)
  {
    AppMethodBeat.i(207340);
    d.g.b.p.h(paramString, "aid");
    boolean bool = InM.contains(paramString);
    AppMethodBeat.o(207340);
    return bool;
  }
  
  static ax bNe()
  {
    AppMethodBeat.i(207326);
    ax localax = (ax)nOP.getValue();
    AppMethodBeat.o(207326);
    return localax;
  }
  
  public static int foM()
  {
    AppMethodBeat.i(207327);
    int i = ((Number)InO.getValue()).intValue();
    AppMethodBeat.o(207327);
    return i;
  }
  
  public static boolean foN()
  {
    AppMethodBeat.i(207328);
    boolean bool = ((Boolean)InP.getValue()).booleanValue();
    AppMethodBeat.o(207328);
    return bool;
  }
  
  public static boolean foO()
  {
    AppMethodBeat.i(207329);
    boolean bool = ((Boolean)InQ.getValue()).booleanValue();
    AppMethodBeat.o(207329);
    return bool;
  }
  
  public static boolean foP()
  {
    AppMethodBeat.i(207330);
    boolean bool = ((Boolean)InR.getValue()).booleanValue();
    AppMethodBeat.o(207330);
    return bool;
  }
  
  private static String foQ()
  {
    AppMethodBeat.i(207332);
    Object localObject1 = ag.aGf().aaG(5);
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        d.g.b.p.g(localObject1, "it");
        localObject1 = (Iterable)localObject1;
        int i = 0;
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          if (i < 0) {
            j.gfB();
          }
          Object localObject2 = (w)localObject1;
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("index", i);
          d.g.b.p.g(localObject2, "msg");
          Object localObject4;
          Object localObject5;
          Object localObject6;
          long l;
          if (((w)localObject2).fpd())
          {
            localJSONObject2.put("is_recommand", false);
            localObject3 = new JSONArray();
            localObject1 = (com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class);
            if (localObject1 == null) {
              break label946;
            }
            localObject1 = ((com.tencent.mm.plugin.biz.a.a)localObject1).a(((w)localObject2).field_msgId, ((w)localObject2).field_content);
            if (localObject1 != null)
            {
              localObject1 = ((u)localObject1).hDb;
              if (localObject1 != null)
              {
                localObject1 = (Iterable)localObject1;
                j = 0;
                localObject1 = ((Iterable)localObject1).iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject4 = ((Iterator)localObject1).next();
                  if (j < 0) {
                    j.gfB();
                  }
                  localObject5 = (com.tencent.mm.ai.v)localObject4;
                  localObject4 = new JSONObject();
                  if (!bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).url))
                  {
                    localObject6 = Uri.parse(((com.tencent.mm.ai.v)localObject5).url);
                    k = bt.getInt(((Uri)localObject6).getQueryParameter("idx"), 0);
                    l = bt.getLong(((Uri)localObject6).getQueryParameter("mid"), 0L);
                    localObject6 = Base64.decode(((Uri)localObject6).getQueryParameter("__biz"), 2);
                    d.g.b.p.g(localObject6, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
                    ((JSONObject)localObject4).put("bizuin", bt.getLong(new String((byte[])localObject6, d.UTF_8), 0L));
                    ((JSONObject)localObject4).put("mid", l);
                    ((JSONObject)localObject4).put("idx", k);
                    ((JSONObject)localObject4).put("title", ((com.tencent.mm.ai.v)localObject5).title);
                  }
                  ((JSONObject)localObject4).put("index", j);
                  ((JSONObject)localObject4).put("msg_time", ((com.tencent.mm.ai.v)localObject5).time);
                  if ((j < 2) || (((w)localObject2).field_isExpand)) {
                    break label952;
                  }
                  bool = true;
                  ((JSONObject)localObject4).put("is_fold", bool);
                  localObject5 = new JSONObject();
                  if (((w)localObject2).field_isRead != 1) {
                    break label958;
                  }
                  k = 1;
                  ((JSONObject)localObject5).put("type", k);
                  localObject6 = z.MKo;
                  ((JSONObject)localObject4).put("user_action", localObject5);
                  localObject5 = z.MKo;
                  ((JSONArray)localObject3).put(localObject4);
                  j += 1;
                  continue;
                }
                localObject1 = z.MKo;
              }
            }
            localObject1 = z.MKo;
            localJSONObject2.put("msg", localObject3);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
          if (!((w)localObject2).fpe()) {
            continue;
          }
          localJSONObject2.put("is_recommand", true);
          localObject1 = new JSONArray();
          Object localObject3 = (Iterable)aa.s((w)localObject2);
          int j = 0;
          localObject3 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            if (j < 0) {
              j.gfB();
            }
            localObject5 = (oj)localObject4;
            localObject4 = new JSONObject();
            if (!bt.isNullOrNil(((oj)localObject5).FFW))
            {
              localObject6 = Uri.parse(((oj)localObject5).FFW);
              k = bt.getInt(((Uri)localObject6).getQueryParameter("idx"), 0);
              l = bt.getLong(((Uri)localObject6).getQueryParameter("mid"), 0L);
              localObject6 = Base64.decode(((Uri)localObject6).getQueryParameter("__biz"), 2);
              d.g.b.p.g(localObject6, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
              ((JSONObject)localObject4).put("bizuin", bt.getLong(new String((byte[])localObject6, d.UTF_8), 0L));
              ((JSONObject)localObject4).put("mid", l);
              ((JSONObject)localObject4).put("idx", k);
              ((JSONObject)localObject4).put("title", ((oj)localObject5).Title);
            }
            ((JSONObject)localObject4).put("index", j);
            ((JSONObject)localObject4).put("msg_time", ((w)localObject2).field_createTime);
            ((JSONObject)localObject4).put("is_fold", false);
            localObject5 = new JSONObject();
            if (((w)localObject2).field_isRead != 1) {
              break label963;
            }
            k = 1;
            ((JSONObject)localObject5).put("type", k);
            localObject6 = z.MKo;
            ((JSONObject)localObject4).put("user_action", localObject5);
            localObject5 = z.MKo;
            ((JSONArray)localObject1).put(localObject4);
            j += 1;
            continue;
          }
          localObject2 = z.MKo;
          localObject2 = z.MKo;
          localJSONObject2.put("msg", localObject1);
          continue;
        }
        localJSONObject1.put("timeline_context", localJSONArray);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.BizCardLogic", (Throwable)localException, "getTimeLineContext", new Object[0]);
        str = localJSONObject1.toString();
        d.g.b.p.g(str, "timelineContext.toString()");
        d.g.b.p.g(str, "SubCoreBiz.getBizTimeLin…text.toString()\n        }");
        AppMethodBeat.o(207332);
        return str;
      }
      continue;
      label946:
      String str = null;
      continue;
      label952:
      boolean bool = false;
      continue;
      label958:
      int k = 0;
      continue;
      label963:
      k = 0;
    }
  }
  
  private static String foR()
  {
    AppMethodBeat.i(207333);
    Object localObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(new JSONObject(InT));
    ((JSONObject)localObject).put("advertisement_info", localJSONArray);
    ((JSONObject)localObject).put("advertisement_num", 1);
    localObject = ((JSONObject)localObject).toString();
    d.g.b.p.g(localObject, "adData.toString()");
    AppMethodBeat.o(207333);
    return localObject;
  }
  
  public static void foS()
  {
    AppMethodBeat.i(207336);
    if (!foN())
    {
      AppMethodBeat.o(207336);
      return;
    }
    List localList = ag.aGf().aaH(637534257);
    if (localList != null)
    {
      ho(localList);
      AppMethodBeat.o(207336);
      return;
    }
    AppMethodBeat.o(207336);
  }
  
  public static void ho(List<? extends w> paramList)
  {
    AppMethodBeat.i(207337);
    d.g.b.p.h(paramList, "list");
    if ((!foN()) || (bt.hj(paramList)))
    {
      AppMethodBeat.o(207337);
      return;
    }
    if (foM() == 1)
    {
      AppMethodBeat.o(207337);
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
      localObject5 = (w)localObject2;
      localObject4 = nWL;
      localObject5 = ((w)localObject5).fpo();
      d.g.b.p.g(localObject5, "it.aId");
      if (!((r)localObject4).contains((String)localObject5)) {}
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
      localObject2 = (w)((Iterator)localObject1).next();
      localObject4 = new JSONObject();
      try
      {
        Object localObject6 = new JSONObject(((w)localObject2).fpn());
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
        localObject6 = (Map)InL;
        d.g.b.p.g(localObject5, "aid");
        ((Map)localObject6).put(localObject5, Long.valueOf(((w)localObject2).field_msgId));
        localLinkedList.add(localObject5);
        paramList.put(localObject4);
        nWL.Ej((String)localObject5);
        i = 1;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.BizCardLogic", "checkAd ex " + localException.getMessage());
      }
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("ads", paramList);
    paramList = ((JSONObject)localObject1).toString();
    d.g.b.p.g(paramList, "list?.filter {\n         …  }?.toString()\n        }");
    localObject1 = (CharSequence)paramList;
    if ((localObject1 == null) || (d.n.n.aE((CharSequence)localObject1))) {}
    for (int j = 1; (j != 0) || (i == 0); j = 0)
    {
      AppMethodBeat.o(207337);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
    com.tencent.mm.plugin.webcanvas.f.Cj(16L);
    localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bx.a)new dms());
    ((b.a)localObject1).d((com.tencent.mm.bx.a)new dmt());
    ((b.a)localObject1).Dl("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((b.a)localObject1).oP(2781);
    localObject1 = ((b.a)localObject1).aDC();
    d.g.b.p.g(localObject1, "rr");
    Object localObject3 = ((com.tencent.mm.al.b)localObject1).aEE();
    if (localObject3 == null)
    {
      paramList = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(207337);
      throw paramList;
    }
    localObject3 = (dms)localObject3;
    ((dms)localObject3).FJW = System.currentTimeMillis();
    ((dms)localObject3).FKa = 2;
    ((dms)localObject3).FKb = paramList;
    com.tencent.mm.al.x.a((com.tencent.mm.al.b)localObject1, (x.a)new c(localLinkedList));
    AppMethodBeat.o(207337);
  }
  
  public final void aaD(int paramInt)
  {
    AppMethodBeat.i(207331);
    if (!foN())
    {
      AppMethodBeat.o(207331);
      return;
    }
    long l1 = bNe().getLong("biz_card_last_time", 0L);
    long l2 = Math.abs(System.currentTimeMillis() - l1);
    if (paramInt == 1) {}
    for (l1 = bNe().getLong("biz_card_resort_Refresh_IntervalSec", 60000L); (2 != paramInt) && (((foM() <= 0) && (l2 < l1)) || ((foM() > 0) && (l2 < 10000L))); l1 = bNe().getLong("biz_card_refresh_interval", 1800000L))
    {
      ad.d("MicroMsg.BizCardLogic", "doBizCardCgi delta < interval, return from=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(207331);
      return;
    }
    if (foM() == 1)
    {
      aSo(foR());
      bNe().encode("biz_card_last_time", System.currentTimeMillis());
      AppMethodBeat.o(207331);
      return;
    }
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bx.a)new dms());
    ((b.a)localObject1).d((com.tencent.mm.bx.a)new dmt());
    ((b.a)localObject1).Dl("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((b.a)localObject1).oP(2781);
    localObject1 = ((b.a)localObject1).aDC();
    d.g.b.p.g(localObject1, "rr");
    Object localObject2 = ((com.tencent.mm.al.b)localObject1).aEE();
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(207331);
      throw ((Throwable)localObject1);
    }
    localObject2 = (dms)localObject2;
    ((dms)localObject2).FJW = System.currentTimeMillis();
    ((dms)localObject2).FKa = 1;
    ((dms)localObject2).FHU = "";
    ((dms)localObject2).FKb = foQ();
    if (foM() == 1)
    {
      ((dms)localObject2).FKb = foR();
      ((dms)localObject2).FKa = 0;
      aSo(((dms)localObject2).FKb);
    }
    ad.i("MicroMsg.BizCardLogic", "doBizCardCgi BusinessId=" + ((dms)localObject2).FKa + ", testMode=" + foM() + " from=" + paramInt + " interval=" + l1);
    localObject2 = com.tencent.mm.plugin.webcanvas.f.DyX;
    com.tencent.mm.plugin.webcanvas.f.Cj(0L);
    com.tencent.mm.al.x.a((com.tencent.mm.al.b)localObject1, (x.a)d.InY);
    AppMethodBeat.o(207331);
  }
  
  /* Error */
  public final boolean n(w paramw)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 865
    //   5: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 866
    //   12: invokestatic 318	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 869	com/tencent/mm/storage/w:fpf	()Z
    //   19: ifeq +94 -> 113
    //   22: ldc 253
    //   24: ldc_w 871
    //   27: invokestatic 834	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: getstatic 274	com/tencent/mm/plugin/webcanvas/f:DyX	Lcom/tencent/mm/plugin/webcanvas/f;
    //   33: astore_3
    //   34: ldc2_w 365
    //   37: invokestatic 280	com/tencent/mm/plugin/webcanvas/f:Cj	(J)V
    //   40: ldc_w 368
    //   43: invokestatic 372	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   46: checkcast 368	com/tencent/mm/plugin/brandservice/a/b
    //   49: astore 5
    //   51: aload_1
    //   52: invokevirtual 874	com/tencent/mm/storage/w:getPathType	()Ljava/lang/String;
    //   55: astore 4
    //   57: aload 4
    //   59: astore_3
    //   60: aload 4
    //   62: ifnonnull +7 -> 69
    //   65: ldc_w 359
    //   68: astore_3
    //   69: aload 5
    //   71: aload_3
    //   72: new 216	java/lang/StringBuilder
    //   75: dup
    //   76: ldc_w 374
    //   79: invokespecial 424	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 692	com/tencent/mm/storage/w:fpo	()Ljava/lang/String;
    //   86: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: aload_1
    //   93: invokevirtual 704	com/tencent/mm/storage/w:fpn	()Ljava/lang/String;
    //   96: invokeinterface 387 4 0
    //   101: ldc_w 865
    //   104: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_1
    //   108: istore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: iload_2
    //   112: ireturn
    //   113: aload_1
    //   114: invokevirtual 619	com/tencent/mm/storage/w:fpe	()Z
    //   117: ifeq +131 -> 248
    //   120: aload_1
    //   121: invokevirtual 878	com/tencent/mm/storage/w:fpm	()Lcom/tencent/mm/protocal/protobuf/dlt;
    //   124: astore 5
    //   126: aload 5
    //   128: ifnull +120 -> 248
    //   131: aload 5
    //   133: getfield 883	com/tencent/mm/protocal/protobuf/dlt:style	I
    //   136: sipush 1001
    //   139: if_icmpne +109 -> 248
    //   142: aload 5
    //   144: getfield 887	com/tencent/mm/protocal/protobuf/dlt:HAh	Lcom/tencent/mm/protocal/protobuf/crs;
    //   147: ifnull +101 -> 248
    //   150: ldc 253
    //   152: ldc_w 889
    //   155: invokestatic 834	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: getstatic 274	com/tencent/mm/plugin/webcanvas/f:DyX	Lcom/tencent/mm/plugin/webcanvas/f;
    //   161: astore_3
    //   162: ldc2_w 890
    //   165: invokestatic 280	com/tencent/mm/plugin/webcanvas/f:Cj	(J)V
    //   168: ldc_w 368
    //   171: invokestatic 372	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   174: checkcast 368	com/tencent/mm/plugin/brandservice/a/b
    //   177: astore 6
    //   179: aload 5
    //   181: getfield 887	com/tencent/mm/protocal/protobuf/dlt:HAh	Lcom/tencent/mm/protocal/protobuf/crs;
    //   184: getfield 896	com/tencent/mm/protocal/protobuf/crs:Hkk	Ljava/lang/String;
    //   187: astore 4
    //   189: aload 4
    //   191: astore_3
    //   192: aload 4
    //   194: ifnonnull +7 -> 201
    //   197: ldc_w 898
    //   200: astore_3
    //   201: aload 6
    //   203: aload_3
    //   204: new 216	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 900
    //   211: invokespecial 424	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: getfield 517	com/tencent/mm/storage/w:field_msgId	J
    //   218: invokevirtual 858	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: aload 5
    //   226: getfield 887	com/tencent/mm/protocal/protobuf/dlt:HAh	Lcom/tencent/mm/protocal/protobuf/crs;
    //   229: getfield 902	com/tencent/mm/protocal/protobuf/crs:data	Ljava/lang/String;
    //   232: invokeinterface 387 4 0
    //   237: ldc_w 865
    //   240: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iconst_1
    //   244: istore_2
    //   245: goto -136 -> 109
    //   248: iconst_0
    //   249: istore_2
    //   250: ldc_w 865
    //   253: invokestatic 202	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: goto -147 -> 109
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	p
    //   0	264	1	paramw	w
    //   108	142	2	bool	boolean
    //   33	171	3	localObject1	Object
    //   55	138	4	str	String
    //   49	176	5	localObject2	Object
    //   177	25	6	localb	com.tencent.mm.plugin.brandservice.a.b
    // Exception table:
    //   from	to	target	type
    //   2	57	259	finally
    //   69	107	259	finally
    //   113	126	259	finally
    //   131	189	259	finally
    //   201	243	259	finally
    //   250	256	259	finally
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class c
    implements x.a
  {
    c(LinkedList paramLinkedList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(207313);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.BizCardLogic", "checkAd callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(17L);
        AppMethodBeat.o(207313);
        return 0;
      }
      d.g.b.p.g(paramb, "rr");
      paramb = paramb.aEF();
      paramString = paramb;
      if (!(paramb instanceof dmt)) {
        paramString = null;
      }
      paramString = (dmt)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(207313);
        return 0;
      }
      if (bt.isNullOrNil(paramString.FKb))
      {
        ad.e("MicroMsg.BizCardLogic", "checkAd callback resp.Data is empty");
        paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(18L);
        AppMethodBeat.o(207313);
        return 0;
      }
      paramb = com.tencent.mm.plugin.webcanvas.f.DyX;
      com.tencent.mm.plugin.webcanvas.f.Cj(19L);
      for (;;)
      {
        try
        {
          paramn = new JSONObject(paramString.FKb);
          paramb = paramn.optString("aid");
          paramn = paramn.optJSONArray("del_aid");
          ad.i("MicroMsg.BizCardLogic", "checkAd callback chooseAid=".concat(String.valueOf(paramb)));
          if (paramn == null) {
            break label720;
          }
          paramInt1 = paramn.length();
          Object localObject1;
          Object localObject2;
          if (paramInt1 > 0)
          {
            int i = paramn.length();
            paramInt1 = 0;
            if (paramInt1 < i)
            {
              localObject1 = paramn.optString(paramInt1);
              localObject2 = (CharSequence)localObject1;
              if (localObject2 == null) {
                break label708;
              }
              if (!d.n.n.aE((CharSequence)localObject2)) {
                break label725;
              }
              break label708;
              if (paramInt2 != 0) {
                break label713;
              }
              localObject2 = p.InU;
              Object localObject3 = (Long)p.foU().get(localObject1);
              if (localObject3 == null) {
                break label713;
              }
              localObject2 = ag.aGf().Dn(((Long)localObject3).longValue());
              if (localObject2 == null) {
                break label713;
              }
              ag.aGf().Dv(((Long)localObject3).longValue());
              ad.e("MicroMsg.BizCardLogic", "checkAd force delete ad ".concat(String.valueOf(localObject1)));
              localObject3 = com.tencent.mm.plugin.report.service.g.yhR;
              String str = ((w)localObject2).getTraceId();
              if (((w)localObject2).field_isRead != 1) {
                break label730;
              }
              paramInt2 = 1;
              ((com.tencent.mm.plugin.report.service.g)localObject3).f(20635, new Object[] { localObject1, str, Integer.valueOf(2), Integer.valueOf(paramInt2) });
              localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
              if (((w)localObject2).field_isRead != 1) {
                break label735;
              }
              l = 21L;
              com.tencent.mm.plugin.webcanvas.f.Cj(l);
              localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
              com.tencent.mm.plugin.webcanvas.f.Cj(23L);
              break label713;
            }
          }
          paramn = ((Iterable)this.InX).iterator();
          if (paramn.hasNext())
          {
            localObject1 = (String)paramn.next();
            localObject2 = p.InU;
            p.foV().add(localObject1);
            if (!(d.g.b.p.i(localObject1, paramb) ^ true)) {
              continue;
            }
            localObject2 = p.InU;
            localObject2 = (Long)p.foU().get(localObject1);
            if (localObject2 == null) {
              continue;
            }
            localObject1 = ag.aGf().Dn(((Long)localObject2).longValue());
            if ((localObject1 == null) || (((w)localObject1).field_isRead != 1)) {
              continue;
            }
            ag.aGf().Dv(((Long)localObject2).longValue());
            ad.e("MicroMsg.BizCardLogic", "checkAd delete ad " + ((w)localObject1).fpo());
            com.tencent.mm.plugin.report.service.g.yhR.f(20635, new Object[] { ((w)localObject1).fpo(), ((w)localObject1).getTraceId(), Integer.valueOf(1), Integer.valueOf(1) });
            localObject2 = com.tencent.mm.plugin.webcanvas.f.DyX;
            if (((w)localObject1).field_isRead != 1) {
              break label700;
            }
            l = 21L;
            com.tencent.mm.plugin.webcanvas.f.Cj(l);
            localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
            com.tencent.mm.plugin.webcanvas.f.Cj(22L);
          }
          l = 20L;
        }
        catch (Exception paramb)
        {
          ad.e("MicroMsg.BizCardLogic", "checkAd callback ex " + paramb.getMessage());
          paramb = p.InU;
          p.aaE(paramString.FGx);
          AppMethodBeat.o(207313);
          return 0;
        }
        label700:
        continue;
        label708:
        paramInt2 = 1;
        continue;
        label713:
        paramInt1 += 1;
        continue;
        label720:
        paramInt1 = 0;
        continue;
        label725:
        paramInt2 = 0;
        continue;
        label730:
        paramInt2 = 0;
        continue;
        label735:
        long l = 20L;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class d
    implements x.a
  {
    public static final d InY;
    
    static
    {
      AppMethodBeat.i(207315);
      InY = new d();
      AppMethodBeat.o(207315);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, com.tencent.mm.al.n paramn)
    {
      paramn = null;
      AppMethodBeat.i(207314);
      paramString = p.InU;
      p.foT().encode("biz_card_last_time", System.currentTimeMillis());
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.BizCardLogic", "doBizCardCgi callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(1L);
        if (paramInt2 == 1004)
        {
          paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
          com.tencent.mm.plugin.webcanvas.f.Cj(7L);
        }
        AppMethodBeat.o(207314);
        return 0;
      }
      paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
      com.tencent.mm.plugin.webcanvas.f.Cj(2L);
      d.g.b.p.g(paramb, "rr");
      paramb = paramb.aEF();
      paramString = paramb;
      if (!(paramb instanceof dmt)) {
        paramString = null;
      }
      paramb = (dmt)paramString;
      if (paramb == null)
      {
        AppMethodBeat.o(207314);
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder("doBizCardCgi callback ");
      paramString = paramn;
      if (paramb != null) {
        paramString = paramb.FKb;
      }
      ad.d("MicroMsg.BizCardLogic", paramString);
      paramString = p.InU;
      p.aaE(paramb.FGx);
      paramString = p.InU;
      p.aSs(paramb.ukw);
      if ((paramb.FuX & 0x1) == 0)
      {
        p.a(p.InU, paramb.FKb);
        paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(6L);
      }
      for (;;)
      {
        AppMethodBeat.o(207314);
        return 0;
        paramString = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(5L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.p
 * JD-Core Version:    0.7.0.1
 */
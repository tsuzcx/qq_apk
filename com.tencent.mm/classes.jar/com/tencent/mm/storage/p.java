package com.tencent.mm.storage;

import android.net.Uri;
import android.util.Base64;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.r;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.f;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/BizCardLogic;", "", "()V", "AD_COUNT_ONE_DAY", "", "AD_COUNT_ONE_DAY_MAX", "BIZ_AD_CARD_INSERT_POS", "CHECK_AD_INTERVAL", "DEFAULT_REFRESH_INTERVAL", "", "FROM_MAIN_CELL_EXPOSE", "FROM_MSG_RESORT", "FROM_TEST_PUSH", "KEY_BIZ_AD_CARD_DATA", "", "KEY_BIZ_AD_INSERT_POS", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CANVAS_LAST_TIME", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CRASH_TIMES", "KEY_BIZ_MAX_AD_COUNT", "KEY_BIZ_REFRESH_INTERVAL", "KEY_BIZ_REFRESH_LAST_TIME", "KEY_BIZ_ResortRefreshIntervalSec", "TAG", "aIdMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "adOpen", "", "getAdOpen", "()Z", "adOpen$delegate", "Lkotlin/Lazy;", "canvasPreloadOpen", "getCanvasPreloadOpen", "canvasPreloadOpen$delegate", "checkedAIdSet", "Ljava/util/HashSet;", "hasPreload", "hasSetCrashFlag", "insertPos", "isForeGround", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "maxAdCount", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "mockAdData", "recOpen", "getRecOpen", "recOpen$delegate", "testMode", "getTestMode", "()I", "testMode$delegate", "triggerDownLoadPkgOnGetAdData", "getTriggerDownLoadPkgOnGetAdData", "triggerDownLoadPkgOnGetAdData$delegate", "triggerDownLoadPkgOnGetRecData", "getTriggerDownLoadPkgOnGetRecData", "triggerDownLoadPkgOnGetRecData$delegate", "checkAd", "", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doBizCardCgi", "from", "exposePreload", "getAdData", "content", "getAdInsertPos", "getLastUnExposedAd", "getMaxAdCount", "getMockAdData", "getOrderFlag", "defOrderFlag", "getTimeLineContext", "handleExtInfo", "extInfo", "insertAd", "isAdChecked", "aid", "isAdDataValid", "data", "onAppBackground", "onAppForeground", "onMainCellExpose", "preloadAdCard", "adData", "preloadCanvasCard", "info", "resetClashFlag", "saveAdData", "updateInterval", "interval", "toAccountKey", "BizCardFlag", "BusinessId", "plugin-biz_release"})
public final class p
{
  private static int Fvs;
  private static final HashMap<String, Long> IHW;
  private static final HashSet<String> IHX;
  static int IHY;
  private static final f IHZ;
  private static final f IIa;
  private static final f IIb;
  private static final f IIc;
  private static final f IId;
  private static final f IIe;
  static boolean IIf;
  public static boolean IIg;
  private static final String IIh;
  public static final p IIi;
  public static boolean OzN;
  private static final f nUv;
  private static final r ocu;
  
  static
  {
    AppMethodBeat.i(188812);
    IIi = new p();
    ocu = new r(600000);
    IHW = new HashMap();
    IHX = new HashSet();
    IHY = -1;
    Fvs = -1;
    nUv = d.g.O((d.g.a.a)p.f.IIp);
    IHZ = d.g.O((d.g.a.a)p.h.IIr);
    IIa = d.g.O((d.g.a.a)p.a.IIj);
    IIb = d.g.O((d.g.a.a)p.g.IIq);
    IIc = d.g.O((d.g.a.a)p.i.IIs);
    IId = d.g.O((d.g.a.a)p.j.IIt);
    IIe = d.g.O((d.g.a.a)p.b.IIk);
    OzN = true;
    IIh = "  {\n  \"hint_txt\": \"创意-20200619_1\",\n  \"url\": \"pages/Home/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=227428a14b944e52c301d99d7769b9d5e6ccd7aa55aac2ca8ca514b5e77a73e83b1579fffef623a5d0972810be5e4fb7&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"traceid\": \"wx0zfmndr7d35pjq00\",\n  \"group_id\": \"wx0zfmndr7d35pjq00_wx0zfmndr7d35pjq01_wx0zfmndr7d35pjq02\",\n  \"ticket\": \"\",\n  \"aid\": \"278576846\",\n  \"pathType\": \"ad\",\n  \"pt\": 9,\n  \"image_url\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx032b61d035e02538\",\n  \"biz_info\": {\n    \"user_name\": \"gh_c5a5a55e74a5\",\n    \"nick_name\": \"BVLGARI宝格丽\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hgUXh7XsHRGLHRribgcXlRGXKB4phZorcicBGVeDWCYQQ/0\",\n    \"biz_uin\": 3074666211,\n    \"signature\": \"于1884年在罗马建立的高端珠宝品牌BVLGARI宝格丽，始终代表着精美奢华的意大利风格。\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 1,\n  \"video_info\": {\n    \"displayWidth\": 960,\n    \"displayHeight\": 540,\n    \"thumbUrl\": \"http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023\",\n    \"videoUrl\": \"http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023\"\n  },\n  \"weapp_info\": {\n    \"original_id\": \"gh_e70774015690\",\n    \"appid\": \"wx56b4770737a7dddf\",\n    \"nick_name\": \"BVLGARI宝格丽精品店\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5pN0eR1LRZJzPxALx3mRPYSmiaPbibPE5fQKS8xTy6ichbQ/0\"\n  },\n  \"dest_type\": 6,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"538\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:6,&quot;jump_url&quot;:&quot;pages\\\\/Home\\\\/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=5418655bc3dd454e4ed84dad6962668068661cb2009130ec86f3626ef4700e9b7a06ee64eb5d93f14e87b54ce39699c9&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"278576846|wx0zfmndr7d35pjq00||0|1594264005|0|0|72058780271891663||AgKNIqBiWhQxioBrueuTRKG/ZDGPF4ER7Im3GhiUj6HO7oRLhI/wSZTh3mxc7jqPZug=|278576919\",\n  \"ext_info\": \"{&quot;wx_app_type&quot;:2,&quot;gh_id&quot;:&quot;gh_e70774015690&quot;}\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d3779f0258b01c0503fbde6feda83a487b\",\n  \"crt_info\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"reranking_ext_info\": \"{tid:278576919}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0134623190388}\"\n}";
    AppMethodBeat.o(188812);
  }
  
  static long DJ(long paramLong)
  {
    AppMethodBeat.i(188807);
    Object localObject = ag.aGv();
    int i = Fvs;
    if (2 > i) {}
    for (;;)
    {
      Fvs = bOc().decodeInt("biz_card_ad_insert_pos", 3);
      i = Fvs;
      if ((2 > i) || (10 < i)) {
        Fvs = 3;
      }
      do
      {
        localObject = ((x)localObject).abq(Fvs - 2);
        if (localObject != null) {
          break;
        }
        ae.w("MicroMsg.BizCardLogic", "getOrderFlag lastTimeLineInfo is null");
        AppMethodBeat.o(188807);
        return 0L;
      } while (10 >= i);
    }
    long l2 = ((w)localObject).field_orderFlag - 1L;
    long l1 = l2;
    if (l2 == paramLong)
    {
      AppMethodBeat.o(188807);
      return l2;
    }
    while (ag.aGv().DL(l1) != null)
    {
      ae.w("MicroMsg.BizCardLogic", "insertAd field_orderFlag conflict orderFlag=".concat(String.valueOf(l1)));
      l1 -= 1L;
    }
    AppMethodBeat.o(188807);
    return l1;
  }
  
  static String aTK(String paramString)
  {
    AppMethodBeat.i(188791);
    paramString = new StringBuilder().append(paramString).append('-');
    d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    paramString = com.tencent.mm.kernel.a.aiF();
    AppMethodBeat.o(188791);
    return paramString;
  }
  
  private final void aTL(String paramString)
  {
    AppMethodBeat.i(188802);
    if (!com.tencent.mm.kernel.g.ajM()) {
      ae.i("MicroMsg.BizCardLogic", "saveAdData acc not ready");
    }
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (d.n.n.aD((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(3L);
      AppMethodBeat.o(188802);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
    com.tencent.mm.plugin.webcanvas.g.CH(4L);
    localObject1 = aTM(paramString);
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (d.n.n.aD((CharSequence)localObject2))) {}
    for (i = 1; i != 0; i = 0)
    {
      paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(91L);
      AppMethodBeat.o(188802);
      return;
    }
    localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
    com.tencent.mm.plugin.webcanvas.g.CH(92L);
    if (fsI())
    {
      localObject2 = com.tencent.mm.plugin.webcanvas.h.DQL;
      com.tencent.mm.plugin.webcanvas.h.eUa();
    }
    aTN((String)localObject1);
    bOc().encode(aTK("biz_ad_card_data"), paramString);
    AppMethodBeat.o(188802);
  }
  
  public static String aTM(String paramString)
  {
    AppMethodBeat.i(188803);
    d.g.b.p.h(paramString, "content");
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("advertisement_info");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0).toString();
        AppMethodBeat.o(188803);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ae.w("MicroMsg.BizCardLogic", "getAdData ex %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(188803);
    }
    return null;
  }
  
  private void aTN(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(188809);
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
            break label207;
          }
          if (!d.n.n.aD((CharSequence)localObject2)) {
            break label197;
          }
        }
        catch (Exception paramString)
        {
          Object localObject1;
          String str;
          Object localObject2;
          ae.w("MicroMsg.BizCardLogic", "preloadAdCard ex %s", new Object[] { paramString.getMessage() });
          AppMethodBeat.o(188809);
          continue;
        }
        if (i == 0)
        {
          localObject2 = (CharSequence)localObject1;
          if (localObject2 == null) {
            break label212;
          }
          if (!d.n.n.aD((CharSequence)localObject2)) {
            break label202;
          }
          break label212;
          if (i == 0)
          {
            localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
            com.tencent.mm.plugin.webcanvas.g.CH(8L);
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).M((String)localObject1, "__ad_card_".concat(String.valueOf(str)), paramString);
          }
        }
        AppMethodBeat.o(188809);
        return;
      }
      finally {}
      label197:
      int i = 0;
      continue;
      label202:
      i = 0;
      continue;
      label207:
      i = 1;
      continue;
      label212:
      i = 1;
    }
  }
  
  public static boolean aTO(String paramString)
  {
    AppMethodBeat.i(188811);
    d.g.b.p.h(paramString, "aid");
    boolean bool = IHX.contains(paramString);
    AppMethodBeat.o(188811);
    return bool;
  }
  
  private static String abk(int paramInt)
  {
    AppMethodBeat.i(188800);
    Object localObject1 = ag.aGv().abn(5);
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
        d.g.b.p.g(localObject1, "it");
        localObject1 = (Iterable)localObject1;
        int i = 0;
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label1104;
        }
        localObject1 = localIterator.next();
        if (i < 0) {
          j.gkd();
        }
        localObject3 = (w)localObject1;
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("index", i);
        d.g.b.p.g(localObject3, "msg");
        if (((w)localObject3).fta())
        {
          localJSONObject2.put("is_recommand", false);
          localObject4 = new JSONArray();
          localObject1 = (com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class);
          if (localObject1 == null) {
            break label1147;
          }
          localObject1 = ((com.tencent.mm.plugin.biz.a.a)localObject1).a(((w)localObject3).field_msgId, ((w)localObject3).field_content);
          if (localObject1 != null)
          {
            localObject1 = ((u)localObject1).hFT;
            if (localObject1 != null)
            {
              localObject1 = (Iterable)localObject1;
              j = 0;
              localObject1 = ((Iterable)localObject1).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject5 = ((Iterator)localObject1).next();
                if (j < 0) {
                  j.gkd();
                }
                localObject6 = (com.tencent.mm.ah.v)localObject5;
                localObject5 = new JSONObject();
                if (!bu.isNullOrNil(((com.tencent.mm.ah.v)localObject6).url))
                {
                  localObject7 = Uri.parse(((com.tencent.mm.ah.v)localObject6).url);
                  k = bu.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
                  l = bu.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
                  localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
                  d.g.b.p.g(localObject7, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
                  ((JSONObject)localObject5).put("bizuin", bu.getLong(new String((byte[])localObject7, d.UTF_8), 0L));
                  ((JSONObject)localObject5).put("mid", l);
                  ((JSONObject)localObject5).put("idx", k);
                  ((JSONObject)localObject5).put("title", ((com.tencent.mm.ah.v)localObject6).title);
                }
                ((JSONObject)localObject5).put("index", j);
                ((JSONObject)localObject5).put("msg_time", ((com.tencent.mm.ah.v)localObject6).time);
                if ((j < 2) || (((w)localObject3).field_isExpand)) {
                  break label1153;
                }
                bool = true;
                label428:
                ((JSONObject)localObject5).put("is_fold", bool);
                localObject6 = new JSONObject();
                if (((w)localObject3).field_isRead != 1) {
                  break label1159;
                }
                k = 1;
                label459:
                ((JSONObject)localObject6).put("type", k);
                localObject7 = z.Nhr;
                ((JSONObject)localObject5).put("user_action", localObject6);
                localObject6 = z.Nhr;
                ((JSONArray)localObject4).put(localObject5);
                j += 1;
                continue;
              }
              localObject1 = z.Nhr;
            }
          }
          localObject1 = z.Nhr;
          localJSONObject2.put("msg", localObject4);
          label526:
          localJSONArray.put(localJSONObject2);
          i += 1;
          continue;
        }
        if (!((w)localObject3).ftb()) {
          continue;
        }
        localJSONObject2.put("is_recommend", true);
        localObject4 = ((w)localObject3).ftk();
        if (localObject4 == null) {
          break label768;
        }
        j = ((dmq)localObject4).style;
        localJSONObject2.put("style", j);
        if ((localObject4 == null) || (((dmq)localObject4).style != 1001) || (((dmq)localObject4).HTU == null)) {
          break;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("extra_data", ((dmq)localObject4).HTU.dAU);
        ((JSONObject)localObject1).put("msg_time", ((w)localObject3).field_createTime);
        localObject4 = new JSONObject();
        if (((w)localObject3).field_isRead != 1) {
          break label773;
        }
        j = 1;
        ((JSONObject)localObject4).put("type", j);
        localObject3 = z.Nhr;
        ((JSONObject)localObject1).put("user_action", localObject4);
        localObject3 = z.Nhr;
        localJSONObject2.put("ext_info", localObject1);
        continue;
        localObject2 = localJSONObject1.toString();
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.BizCardLogic", (Throwable)localException, "getTimeLineContext", new Object[0]);
      }
      label736:
      d.g.b.p.g(localObject2, "timelineContext.toString()");
      d.g.b.p.g(localObject2, "SubCoreBiz.getBizTimeLin…text.toString()\n        }");
      AppMethodBeat.o(188800);
      return localObject2;
      label768:
      j = 0;
      continue;
      label773:
      j = 0;
    }
    Object localObject2 = new JSONArray();
    Object localObject4 = (Iterable)aa.s((w)localObject3);
    int j = 0;
    localObject4 = ((Iterable)localObject4).iterator();
    label808:
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((Iterator)localObject4).next();
      if (j < 0) {
        j.gkd();
      }
      localObject6 = (ol)localObject5;
      localObject5 = new JSONObject();
      if (!bu.isNullOrNil(((ol)localObject6).FYs))
      {
        localObject7 = Uri.parse(((ol)localObject6).FYs);
        k = bu.getInt(((Uri)localObject7).getQueryParameter("idx"), 0);
        l = bu.getLong(((Uri)localObject7).getQueryParameter("mid"), 0L);
        localObject7 = Base64.decode(((Uri)localObject7).getQueryParameter("__biz"), 2);
        d.g.b.p.g(localObject7, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
        ((JSONObject)localObject5).put("bizuin", bu.getLong(new String((byte[])localObject7, d.UTF_8), 0L));
        ((JSONObject)localObject5).put("mid", l);
        ((JSONObject)localObject5).put("idx", k);
        ((JSONObject)localObject5).put("title", ((ol)localObject6).Title);
      }
      ((JSONObject)localObject5).put("index", j);
      ((JSONObject)localObject5).put("msg_time", ((w)localObject3).field_createTime);
      ((JSONObject)localObject5).put("is_fold", false);
      localObject6 = new JSONObject();
      if (((w)localObject3).field_isRead != 1) {
        break label1164;
      }
    }
    label1153:
    label1159:
    label1164:
    for (int k = 1;; k = 0)
    {
      ((JSONObject)localObject6).put("type", k);
      localObject7 = z.Nhr;
      ((JSONObject)localObject5).put("user_action", localObject6);
      localObject6 = z.Nhr;
      ((JSONArray)localObject2).put(localObject5);
      j += 1;
      break label808;
      localObject3 = z.Nhr;
      localObject3 = z.Nhr;
      localJSONObject2.put("msg", localObject2);
      break label526;
      label1104:
      localJSONObject1.put("timeline_context", localJSONArray);
      localJSONObject1.put("timeline_request_type", paramInt);
      localJSONObject1.put("last_expose_time", bOc().decodeLong("BizLastExposeAdTime", 0L));
      break label736;
      label1147:
      localObject2 = null;
      break;
      bool = false;
      break label428;
      k = 0;
      break label459;
    }
  }
  
  static ay bOc()
  {
    AppMethodBeat.i(188792);
    ay localay = (ay)nUv.getValue();
    AppMethodBeat.o(188792);
    return localay;
  }
  
  public static int fsF()
  {
    AppMethodBeat.i(188793);
    int i = ((Number)IHZ.getValue()).intValue();
    AppMethodBeat.o(188793);
    return i;
  }
  
  public static boolean fsG()
  {
    AppMethodBeat.i(188794);
    boolean bool = ((Boolean)IIa.getValue()).booleanValue();
    AppMethodBeat.o(188794);
    return bool;
  }
  
  public static boolean fsH()
  {
    AppMethodBeat.i(188795);
    boolean bool = ((Boolean)IIb.getValue()).booleanValue();
    AppMethodBeat.o(188795);
    return bool;
  }
  
  private static boolean fsI()
  {
    AppMethodBeat.i(188796);
    boolean bool = ((Boolean)IIc.getValue()).booleanValue();
    AppMethodBeat.o(188796);
    return bool;
  }
  
  public static boolean fsJ()
  {
    AppMethodBeat.i(188797);
    boolean bool = ((Boolean)IId.getValue()).booleanValue();
    AppMethodBeat.o(188797);
    return bool;
  }
  
  public static boolean fsK()
  {
    AppMethodBeat.i(188798);
    boolean bool = ((Boolean)IIe.getValue()).booleanValue();
    AppMethodBeat.o(188798);
    return bool;
  }
  
  private static String fsL()
  {
    AppMethodBeat.i(188801);
    Object localObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(new JSONObject(IIh));
    ((JSONObject)localObject).put("advertisement_info", localJSONArray);
    ((JSONObject)localObject).put("advertisement_num", 1);
    localObject = ((JSONObject)localObject).toString();
    d.g.b.p.g(localObject, "adData.toString()");
    AppMethodBeat.o(188801);
    return localObject;
  }
  
  public static void fsM()
  {
    AppMethodBeat.i(188804);
    ae.i("MicroMsg.BizCardLogic", "exposePreload reset crash flag");
    com.tencent.mm.plugin.biz.b.b localb = com.tencent.mm.plugin.biz.b.b.nUB;
    com.tencent.mm.plugin.biz.b.b.bNw().encode("biz_canvas_card_expose_preload_crash_times", 0);
    AppMethodBeat.o(188804);
  }
  
  public static void fsN()
  {
    AppMethodBeat.i(188805);
    if (!fsG())
    {
      AppMethodBeat.o(188805);
      return;
    }
    Object localObject1 = ag.aGv().abo(637534257);
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label113:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (Math.abs(((w)localObject3).field_createTime - System.currentTimeMillis()) < 86400000L) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label113;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      hy((List)localObject1);
      AppMethodBeat.o(188805);
      return;
    }
    AppMethodBeat.o(188805);
  }
  
  static w fsO()
  {
    AppMethodBeat.i(188808);
    w localw = ag.aGv().fto();
    if ((localw != null) && (localw.field_isRead == 0))
    {
      AppMethodBeat.o(188808);
      return localw;
    }
    AppMethodBeat.o(188808);
    return null;
  }
  
  public static void fwP()
  {
    OzN = true;
  }
  
  public static void hy(List<? extends w> paramList)
  {
    AppMethodBeat.i(188806);
    d.g.b.p.h(paramList, "list");
    if ((!fsG()) || (bu.ht(paramList)))
    {
      AppMethodBeat.o(188806);
      return;
    }
    if (fsF() == 1)
    {
      AppMethodBeat.o(188806);
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
      localObject4 = ocu;
      localObject5 = ((w)localObject5).ftm();
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
        Object localObject6 = new JSONObject(((w)localObject2).ftl());
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
        localObject6 = (Map)IHW;
        d.g.b.p.g(localObject5, "aid");
        ((Map)localObject6).put(localObject5, Long.valueOf(((w)localObject2).field_msgId));
        localLinkedList.add(localObject5);
        paramList.put(localObject4);
        ocu.EL((String)localObject5);
        i = 1;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.BizCardLogic", "checkAd ex " + localException.getMessage());
      }
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("ads", paramList);
    paramList = ((JSONObject)localObject1).toString();
    d.g.b.p.g(paramList, "list?.filter {\n         …  }?.toString()\n        }");
    localObject1 = (CharSequence)paramList;
    if ((localObject1 == null) || (d.n.n.aD((CharSequence)localObject1))) {}
    for (int j = 1; (j != 0) || (i == 0); j = 0)
    {
      AppMethodBeat.o(188806);
      return;
    }
    localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
    com.tencent.mm.plugin.webcanvas.g.CH(16L);
    localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bw.a)new dnp());
    ((b.a)localObject1).d((com.tencent.mm.bw.a)new dnq());
    ((b.a)localObject1).DN("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((b.a)localObject1).oS(2781);
    localObject1 = ((b.a)localObject1).aDS();
    d.g.b.p.g(localObject1, "rr");
    Object localObject3 = ((com.tencent.mm.ak.b)localObject1).aEU();
    if (localObject3 == null)
    {
      paramList = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(188806);
      throw paramList;
    }
    localObject3 = (dnp)localObject3;
    ((dnp)localObject3).Gcv = System.currentTimeMillis();
    ((dnp)localObject3).Gcz = 2;
    ((dnp)localObject3).GcA = paramList;
    com.tencent.mm.ak.x.a((com.tencent.mm.ak.b)localObject1, (x.a)new c(localLinkedList));
    AppMethodBeat.o(188806);
  }
  
  public final void abj(int paramInt)
  {
    AppMethodBeat.i(188799);
    if (!fsG())
    {
      AppMethodBeat.o(188799);
      return;
    }
    long l1 = bOc().getLong("biz_card_last_time", 0L);
    long l2 = Math.abs(System.currentTimeMillis() - l1);
    if (paramInt == 1) {}
    for (l1 = bOc().getLong("biz_card_resort_Refresh_IntervalSec", 3600000L); (3 != paramInt) && (((fsF() <= 0) && (l2 < l1)) || ((fsF() > 0) && (l2 < 10000L))); l1 = bOc().getLong("biz_card_refresh_interval", 3600000L))
    {
      ae.d("MicroMsg.BizCardLogic", "doBizCardCgi delta < interval, return from=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(188799);
      return;
    }
    if (fsF() == 1)
    {
      aTL(fsL());
      bOc().encode("biz_card_last_time", System.currentTimeMillis());
      AppMethodBeat.o(188799);
      return;
    }
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bw.a)new dnp());
    ((b.a)localObject1).d((com.tencent.mm.bw.a)new dnq());
    ((b.a)localObject1).DN("/cgi-bin/mmbiz-bin/recommend/timelinecard");
    ((b.a)localObject1).oS(2781);
    localObject1 = ((b.a)localObject1).aDS();
    d.g.b.p.g(localObject1, "rr");
    Object localObject2 = ((com.tencent.mm.ak.b)localObject1).aEU();
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
      AppMethodBeat.o(188799);
      throw ((Throwable)localObject1);
    }
    localObject2 = (dnp)localObject2;
    ((dnp)localObject2).Gcv = System.currentTimeMillis();
    ((dnp)localObject2).Gcz = 1;
    ((dnp)localObject2).Gaq = "";
    ((dnp)localObject2).GcA = abk(paramInt);
    if (fsF() == 1)
    {
      ((dnp)localObject2).GcA = fsL();
      ((dnp)localObject2).Gcz = 0;
      aTL(((dnp)localObject2).GcA);
    }
    ae.i("MicroMsg.BizCardLogic", "doBizCardCgi BusinessId=" + ((dnp)localObject2).Gcz + ", testMode=" + fsF() + " from=" + paramInt + " interval=" + l1);
    localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
    com.tencent.mm.plugin.webcanvas.g.CH(0L);
    com.tencent.mm.ak.x.a((com.tencent.mm.ak.b)localObject1, (x.a)d.IIm);
    AppMethodBeat.o(188799);
  }
  
  /* Error */
  public final boolean o(w paramw)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1011
    //   5: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 1012
    //   12: invokestatic 418	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 1015	com/tencent/mm/storage/w:ftc	()Z
    //   19: ifeq +95 -> 114
    //   22: ldc_w 279
    //   25: ldc_w 1017
    //   28: invokestatic 983	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: getstatic 373	com/tencent/mm/plugin/webcanvas/g:DQG	Lcom/tencent/mm/plugin/webcanvas/g;
    //   34: astore_3
    //   35: ldc2_w 464
    //   38: invokestatic 379	com/tencent/mm/plugin/webcanvas/g:CH	(J)V
    //   41: ldc_w 467
    //   44: invokestatic 471	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   47: checkcast 467	com/tencent/mm/plugin/brandservice/a/b
    //   50: astore 5
    //   52: aload_1
    //   53: invokevirtual 1020	com/tencent/mm/storage/w:getPathType	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: ifnonnull +7 -> 70
    //   66: ldc_w 458
    //   69: astore_3
    //   70: aload 5
    //   72: aload_3
    //   73: new 320	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 473
    //   80: invokespecial 518	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 858	com/tencent/mm/storage/w:ftm	()Ljava/lang/String;
    //   87: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: aload_1
    //   94: invokevirtual 865	com/tencent/mm/storage/w:ftl	()Ljava/lang/String;
    //   97: invokeinterface 480 4 0
    //   102: ldc_w 1011
    //   105: invokestatic 248	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: iconst_1
    //   109: istore_2
    //   110: aload_0
    //   111: monitorexit
    //   112: iload_2
    //   113: ireturn
    //   114: aload_1
    //   115: invokevirtual 675	com/tencent/mm/storage/w:ftb	()Z
    //   118: ifeq +132 -> 250
    //   121: aload_1
    //   122: invokevirtual 681	com/tencent/mm/storage/w:ftk	()Lcom/tencent/mm/protocal/protobuf/dmq;
    //   125: astore 5
    //   127: aload 5
    //   129: ifnull +121 -> 250
    //   132: aload 5
    //   134: getfield 686	com/tencent/mm/protocal/protobuf/dmq:style	I
    //   137: sipush 1001
    //   140: if_icmpne +110 -> 250
    //   143: aload 5
    //   145: getfield 691	com/tencent/mm/protocal/protobuf/dmq:HTU	Lcom/tencent/mm/protocal/protobuf/csm;
    //   148: ifnull +102 -> 250
    //   151: ldc_w 279
    //   154: ldc_w 1022
    //   157: invokestatic 983	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: getstatic 373	com/tencent/mm/plugin/webcanvas/g:DQG	Lcom/tencent/mm/plugin/webcanvas/g;
    //   163: astore_3
    //   164: ldc2_w 1023
    //   167: invokestatic 379	com/tencent/mm/plugin/webcanvas/g:CH	(J)V
    //   170: ldc_w 467
    //   173: invokestatic 471	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   176: checkcast 467	com/tencent/mm/plugin/brandservice/a/b
    //   179: astore 6
    //   181: aload 5
    //   183: getfield 691	com/tencent/mm/protocal/protobuf/dmq:HTU	Lcom/tencent/mm/protocal/protobuf/csm;
    //   186: getfield 1027	com/tencent/mm/protocal/protobuf/csm:HDK	Ljava/lang/String;
    //   189: astore 4
    //   191: aload 4
    //   193: astore_3
    //   194: aload 4
    //   196: ifnonnull +7 -> 203
    //   199: ldc_w 1029
    //   202: astore_3
    //   203: aload 6
    //   205: aload_3
    //   206: new 320	java/lang/StringBuilder
    //   209: dup
    //   210: ldc_w 1031
    //   213: invokespecial 518	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload_1
    //   217: getfield 573	com/tencent/mm/storage/w:field_msgId	J
    //   220: invokevirtual 1005	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aload 5
    //   228: getfield 691	com/tencent/mm/protocal/protobuf/dmq:HTU	Lcom/tencent/mm/protocal/protobuf/csm;
    //   231: getfield 1033	com/tencent/mm/protocal/protobuf/csm:data	Ljava/lang/String;
    //   234: invokeinterface 480 4 0
    //   239: ldc_w 1011
    //   242: invokestatic 248	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: iconst_1
    //   246: istore_2
    //   247: goto -137 -> 110
    //   250: iconst_0
    //   251: istore_2
    //   252: ldc_w 1011
    //   255: invokestatic 248	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: goto -148 -> 110
    //   261: astore_1
    //   262: aload_0
    //   263: monitorexit
    //   264: aload_1
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	p
    //   0	266	1	paramw	w
    //   109	143	2	bool	boolean
    //   34	172	3	localObject1	Object
    //   56	139	4	str	String
    //   50	177	5	localObject2	Object
    //   179	25	6	localb	com.tencent.mm.plugin.brandservice.a.b
    // Exception table:
    //   from	to	target	type
    //   2	58	261	finally
    //   70	108	261	finally
    //   114	127	261	finally
    //   132	191	261	finally
    //   203	245	261	finally
    //   252	258	261	finally
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class c
    implements x.a
  {
    c(LinkedList paramLinkedList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(188775);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.BizCardLogic", "checkAd callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(17L);
        AppMethodBeat.o(188775);
        return 0;
      }
      d.g.b.p.g(paramb, "rr");
      paramb = paramb.aEV();
      paramString = paramb;
      if (!(paramb instanceof dnq)) {
        paramString = null;
      }
      paramString = (dnq)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(188775);
        return 0;
      }
      if (bu.isNullOrNil(paramString.GcA))
      {
        ae.e("MicroMsg.BizCardLogic", "checkAd callback resp.Data is empty");
        paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(18L);
        AppMethodBeat.o(188775);
        return 0;
      }
      paramb = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(19L);
      for (;;)
      {
        try
        {
          paramn = new JSONObject(paramString.GcA);
          paramb = paramn.optString("aid");
          paramn = paramn.optJSONArray("del_aid");
          ae.i("MicroMsg.BizCardLogic", "checkAd callback chooseAid=".concat(String.valueOf(paramb)));
          if (paramn == null) {
            break label719;
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
                break label707;
              }
              if (!d.n.n.aD((CharSequence)localObject2)) {
                break label724;
              }
              break label707;
              if (paramInt2 != 0) {
                break label712;
              }
              localObject2 = p.IIi;
              Object localObject3 = (Long)p.fsR().get(localObject1);
              if (localObject3 == null) {
                break label712;
              }
              localObject2 = ag.aGv().DM(((Long)localObject3).longValue());
              if (localObject2 == null) {
                break label712;
              }
              ag.aGv().DU(((Long)localObject3).longValue());
              ae.e("MicroMsg.BizCardLogic", "checkAd force delete ad ".concat(String.valueOf(localObject1)));
              localObject3 = com.tencent.mm.plugin.report.service.g.yxI;
              String str = ((w)localObject2).getTraceId();
              if (((w)localObject2).field_isRead != 1) {
                break label729;
              }
              paramInt2 = 1;
              ((com.tencent.mm.plugin.report.service.g)localObject3).f(20635, new Object[] { localObject1, str, Integer.valueOf(2), Integer.valueOf(paramInt2) });
              localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
              if (((w)localObject2).field_isRead != 1) {
                break label734;
              }
              l = 21L;
              com.tencent.mm.plugin.webcanvas.g.CH(l);
              localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
              com.tencent.mm.plugin.webcanvas.g.CH(23L);
              break label712;
            }
          }
          paramn = ((Iterable)this.IIl).iterator();
          if (paramn.hasNext())
          {
            localObject1 = (String)paramn.next();
            localObject2 = p.IIi;
            p.fsS().add(localObject1);
            if (!(d.g.b.p.i(localObject1, paramb) ^ true)) {
              continue;
            }
            localObject2 = p.IIi;
            localObject2 = (Long)p.fsR().get(localObject1);
            if (localObject2 == null) {
              continue;
            }
            localObject1 = ag.aGv().DM(((Long)localObject2).longValue());
            if ((localObject1 == null) || (((w)localObject1).field_isRead != 0)) {
              continue;
            }
            ag.aGv().DU(((Long)localObject2).longValue());
            ae.e("MicroMsg.BizCardLogic", "checkAd delete ad " + ((w)localObject1).ftm());
            com.tencent.mm.plugin.report.service.g.yxI.f(20635, new Object[] { ((w)localObject1).ftm(), ((w)localObject1).getTraceId(), Integer.valueOf(1), Integer.valueOf(1) });
            localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
            if (((w)localObject1).field_isRead != 1) {
              break label699;
            }
            l = 21L;
            com.tencent.mm.plugin.webcanvas.g.CH(l);
            localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
            com.tencent.mm.plugin.webcanvas.g.CH(22L);
          }
          l = 20L;
        }
        catch (Exception paramb)
        {
          ae.e("MicroMsg.BizCardLogic", "checkAd callback ex " + paramb.getMessage());
          paramb = p.IIi;
          p.abl(paramString.FYT);
          AppMethodBeat.o(188775);
          return 0;
        }
        label699:
        continue;
        label707:
        paramInt2 = 1;
        continue;
        label712:
        paramInt1 += 1;
        continue;
        label719:
        paramInt1 = 0;
        continue;
        label724:
        paramInt2 = 0;
        continue;
        label729:
        paramInt2 = 0;
        continue;
        label734:
        long l = 20L;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class d
    implements x.a
  {
    public static final d IIm;
    
    static
    {
      AppMethodBeat.i(188777);
      IIm = new d();
      AppMethodBeat.o(188777);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, com.tencent.mm.ak.n paramn)
    {
      paramn = null;
      AppMethodBeat.i(188776);
      paramString = p.IIi;
      p.fsP().encode("biz_card_last_time", System.currentTimeMillis());
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.BizCardLogic", "doBizCardCgi callback errType=" + paramInt1 + ", errCode=" + paramInt2);
        paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(1L);
        if (paramInt2 == 1004)
        {
          paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
          com.tencent.mm.plugin.webcanvas.g.CH(7L);
        }
        AppMethodBeat.o(188776);
        return 0;
      }
      paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(2L);
      d.g.b.p.g(paramb, "rr");
      paramb = paramb.aEV();
      paramString = paramb;
      if (!(paramb instanceof dnq)) {
        paramString = null;
      }
      paramb = (dnq)paramString;
      if (paramb == null)
      {
        AppMethodBeat.o(188776);
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder("doBizCardCgi callback ");
      if (paramb != null)
      {
        paramString = paramb.GcA;
        ae.d("MicroMsg.BizCardLogic", paramString);
        localStringBuilder = new StringBuilder("doBizCardCgi callback errType=").append(paramInt1).append(", errCode=").append(paramInt2).append(" interval=");
        paramString = paramn;
        if (paramb != null) {
          paramString = Integer.valueOf(paramb.FYT);
        }
        ae.i("MicroMsg.BizCardLogic", paramString.intValue());
        paramString = p.IIi;
        p.abl(paramb.FYT);
        paramString = p.IIi;
        p.aTP(paramb.uvT);
        if ((paramb.FNv & 0x1) != 0) {
          break label315;
        }
        p.a(p.IIi, paramb.GcA);
        paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(6L);
      }
      for (;;)
      {
        AppMethodBeat.o(188776);
        return 0;
        paramString = null;
        break;
        label315:
        paramString = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(5L);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(188780);
      Object localObject1 = com.tencent.mm.plugin.biz.b.b.nUB;
      com.tencent.mm.plugin.biz.b.b.bNw().encode("biz_canvas_card_expose_preload_crash_times", this.IIn + 1);
      ae.i("MicroMsg.BizCardLogic", "exposePreload set crash flag");
      localObject1 = p.IIi;
      p.wV(true);
      localObject1 = ag.aGv().abo(637534257);
      int j;
      Object localObject2;
      p localp;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        j = 0;
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break label145;
        }
        localObject2 = (w)((Iterator)localObject1).next();
        if (Math.abs(((w)localObject2).field_createTime - System.currentTimeMillis()) >= 86400000L) {
          break label308;
        }
        localp = p.IIi;
        d.g.b.p.g(localObject2, "info");
        localp.o((w)localObject2);
        localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(12L);
      }
      label145:
      label308:
      for (int i = 1;; i = j)
      {
        j = i;
        break;
        i = 0;
        localObject1 = ag.aGv().abo(620757041);
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
            localObject2 = (w)((Iterator)localObject1).next();
            if (Math.abs(((w)localObject2).field_createTime - System.currentTimeMillis()) < 86400000L)
            {
              localp = p.IIi;
              d.g.b.p.g(localObject2, "info");
              if (localp.o((w)localObject2))
              {
                localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
                com.tencent.mm.plugin.webcanvas.g.CH(13L);
                i = 1;
              }
            }
          }
        }
        if (j != 0)
        {
          localObject1 = p.IIi;
          if (p.fxi())
          {
            com.tencent.e.h.MqF.r((Runnable)1.IIo, 3000L);
            AppMethodBeat.o(188780);
            return;
          }
        }
        localObject1 = p.IIi;
        p.wV(false);
        localObject1 = p.IIi;
        p.fsQ();
        AppMethodBeat.o(188780);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.p
 * JD-Core Version:    0.7.0.1
 */
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;

public class aiov
  implements View.OnClickListener
{
  public aiov(StructMsgItemVideo paramStructMsgItemVideo) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: lconst_0
    //   4: lstore 4
    //   6: aload_1
    //   7: invokevirtual 26	android/view/View:getContext	()Landroid/content/Context;
    //   10: astore 12
    //   12: aload_1
    //   13: ldc 27
    //   15: invokevirtual 31	android/view/View:getTag	(I)Ljava/lang/Object;
    //   18: astore 8
    //   20: aload 8
    //   22: ifnull +168 -> 190
    //   25: aload 8
    //   27: instanceof 33
    //   30: ifeq +160 -> 190
    //   33: aload 8
    //   35: checkcast 33	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo$Holder
    //   38: astore 11
    //   40: aload_0
    //   41: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   44: getfield 39	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:k	I
    //   47: iconst_4
    //   48: if_icmpne +826 -> 874
    //   51: ldc 41
    //   53: astore 9
    //   55: aload 9
    //   57: astore 8
    //   59: aload_0
    //   60: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   63: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   66: ifnull +37 -> 103
    //   69: aload 9
    //   71: astore 8
    //   73: aload_0
    //   74: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   77: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   80: getfield 50	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   83: ifnull +20 -> 103
    //   86: aload_0
    //   87: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   90: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   93: getfield 50	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   96: ldc 52
    //   98: invokevirtual 58	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 8
    //   103: aload 11
    //   105: getfield 61	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo$Holder:a	Lcom/tencent/mobileqq/widget/PAVideoView;
    //   108: invokevirtual 67	com/tencent/mobileqq/widget/PAVideoView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   111: ifnull +967 -> 1078
    //   114: aload 11
    //   116: getfield 61	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo$Holder:a	Lcom/tencent/mobileqq/widget/PAVideoView;
    //   119: invokevirtual 67	com/tencent/mobileqq/widget/PAVideoView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   122: instanceof 69
    //   125: ifeq +953 -> 1078
    //   128: aload 11
    //   130: getfield 61	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo$Holder:a	Lcom/tencent/mobileqq/widget/PAVideoView;
    //   133: invokevirtual 67	com/tencent/mobileqq/widget/PAVideoView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   136: checkcast 69	com/tencent/image/URLDrawable
    //   139: astore 9
    //   141: aload 9
    //   143: invokevirtual 73	com/tencent/image/URLDrawable:getStatus	()I
    //   146: iconst_1
    //   147: if_icmpne +931 -> 1078
    //   150: aload 9
    //   152: invokevirtual 76	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   155: instanceof 78
    //   158: ifeq +920 -> 1078
    //   161: aload 9
    //   163: invokevirtual 76	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   166: checkcast 78	com/tencent/image/QQLiveDrawable
    //   169: invokevirtual 82	com/tencent/image/QQLiveDrawable:getCurrentPosition	()J
    //   172: lstore_2
    //   173: aload_1
    //   174: ldc 83
    //   176: invokevirtual 31	android/view/View:getTag	(I)Ljava/lang/Object;
    //   179: checkcast 85	java/lang/String
    //   182: astore_1
    //   183: aload_1
    //   184: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifeq +4 -> 191
    //   190: return
    //   191: aload_1
    //   192: ldc 93
    //   194: lload_2
    //   195: invokestatic 97	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   198: invokestatic 102	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   201: ldc 104
    //   203: aload 8
    //   205: invokestatic 102	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 14
    //   210: new 106	android/content/Intent
    //   213: dup
    //   214: aload 12
    //   216: ldc 108
    //   218: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   221: astore 13
    //   223: aload 13
    //   225: ldc 113
    //   227: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   230: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   233: pop
    //   234: aload_0
    //   235: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   238: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   241: getfield 50	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   244: ldc 124
    //   246: invokevirtual 58	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   254: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   257: getfield 50	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   260: ldc 126
    //   262: invokevirtual 58	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   265: astore 8
    //   267: aload 8
    //   269: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   272: ifeq +411 -> 683
    //   275: new 128	org/json/JSONObject
    //   278: dup
    //   279: invokespecial 129	org/json/JSONObject:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: ldc 131
    //   288: invokevirtual 134	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 8
    //   293: aload 9
    //   295: ldc 136
    //   297: invokevirtual 134	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore 9
    //   302: invokestatic 142	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   305: invokevirtual 146	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   308: checkcast 148	com/tencent/mobileqq/app/QQAppInterface
    //   311: astore 10
    //   313: new 150	com/tencent/gdtad/net/GdtAdHandler$ReportInfo
    //   316: dup
    //   317: invokespecial 151	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:<init>	()V
    //   320: astore 11
    //   322: aload 11
    //   324: iconst_3
    //   325: putfield 153	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:a	I
    //   328: aload 11
    //   330: iconst_1
    //   331: putfield 156	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:f	I
    //   334: aload 11
    //   336: aload_0
    //   337: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   340: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   343: getfield 50	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   346: invokestatic 161	com/tencent/gdtad/net/GdtAdHandler:a	(Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;
    //   349: astore 11
    //   351: aload 10
    //   353: bipush 110
    //   355: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   358: checkcast 158	com/tencent/gdtad/net/GdtAdHandler
    //   361: aload 11
    //   363: aconst_null
    //   364: invokevirtual 167	com/tencent/gdtad/net/GdtAdHandler:a	(Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;Ljava/lang/String;)V
    //   367: aload 8
    //   369: invokestatic 173	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   372: lstore 6
    //   374: lload 6
    //   376: lstore 4
    //   378: aload 9
    //   380: astore 10
    //   382: aload 8
    //   384: astore 9
    //   386: aload 10
    //   388: astore 8
    //   390: aload_1
    //   391: astore 10
    //   393: aload_1
    //   394: ifnull +20 -> 414
    //   397: aload_1
    //   398: ldc 175
    //   400: ldc 41
    //   402: invokevirtual 179	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   405: ldc 181
    //   407: ldc 41
    //   409: invokevirtual 179	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   412: astore 10
    //   414: ldc 183
    //   416: aload_0
    //   417: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   420: getfield 187	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:L	Ljava/lang/String;
    //   423: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   426: ifeq +343 -> 769
    //   429: new 193	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   432: dup
    //   433: invokespecial 194	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   436: astore 9
    //   438: aload 9
    //   440: getfield 198	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   443: lload 4
    //   445: invokevirtual 204	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   448: aload 9
    //   450: getfield 208	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   453: aload 8
    //   455: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   458: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   461: aload 9
    //   463: getfield 219	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   466: aload 10
    //   468: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   471: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   474: new 221	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   477: dup
    //   478: invokespecial 222	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   481: astore 8
    //   483: aload 8
    //   485: getfield 225	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   488: astore 10
    //   490: aload_0
    //   491: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   494: getfield 228	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:J	Ljava/lang/String;
    //   497: ifnonnull +228 -> 725
    //   500: ldc 41
    //   502: astore_1
    //   503: aload 10
    //   505: aload_1
    //   506: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   509: aload 8
    //   511: getfield 231	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   514: astore 10
    //   516: aload_0
    //   517: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   520: getfield 234	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:K	Ljava/lang/String;
    //   523: ifnonnull +213 -> 736
    //   526: ldc 41
    //   528: astore_1
    //   529: aload 10
    //   531: aload_1
    //   532: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   535: aload 8
    //   537: getfield 238	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   540: aload 9
    //   542: invokevirtual 241	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   545: new 243	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   548: dup
    //   549: invokespecial 244	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   552: astore_1
    //   553: aload_1
    //   554: getfield 248	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   557: aload 8
    //   559: invokevirtual 249	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   562: new 251	com/tencent/gdtad/aditem/GdtAd
    //   565: dup
    //   566: aload_1
    //   567: invokespecial 254	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   570: astore 8
    //   572: new 256	com/tencent/gdtad/views/video/GdtVideoData
    //   575: dup
    //   576: invokespecial 257	com/tencent/gdtad/views/video/GdtVideoData:<init>	()V
    //   579: astore 9
    //   581: aload 9
    //   583: iconst_1
    //   584: invokevirtual 261	com/tencent/gdtad/views/video/GdtVideoData:setLoop	(Z)V
    //   587: aload 9
    //   589: aload 8
    //   591: invokevirtual 265	com/tencent/gdtad/views/video/GdtVideoData:setAd	(Lcom/tencent/gdtad/aditem/GdtAd;)V
    //   594: aload 9
    //   596: lload_2
    //   597: invokevirtual 268	com/tencent/gdtad/views/video/GdtVideoData:setStartPositionMillis	(J)V
    //   600: aload_0
    //   601: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   604: getfield 271	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:v	Ljava/lang/String;
    //   607: ifnonnull +140 -> 747
    //   610: ldc 41
    //   612: astore_1
    //   613: aload 9
    //   615: aload_1
    //   616: invokevirtual 274	com/tencent/gdtad/views/video/GdtVideoData:setUrl	(Ljava/lang/String;)V
    //   619: new 276	com/tencent/gdtad/views/videoceiling/GdtVideoCeilingData
    //   622: dup
    //   623: invokespecial 277	com/tencent/gdtad/views/videoceiling/GdtVideoCeilingData:<init>	()V
    //   626: astore 10
    //   628: aload 10
    //   630: aload 9
    //   632: invokevirtual 281	com/tencent/gdtad/views/videoceiling/GdtVideoCeilingData:setVideoData	(Lcom/tencent/gdtad/views/video/GdtVideoData;)V
    //   635: aload 10
    //   637: aload 8
    //   639: invokevirtual 282	com/tencent/gdtad/views/videoceiling/GdtVideoCeilingData:setAd	(Lcom/tencent/gdtad/aditem/GdtAd;)V
    //   642: aload_0
    //   643: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   646: getfield 284	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:I	Ljava/lang/String;
    //   649: ifnonnull +109 -> 758
    //   652: ldc 41
    //   654: astore_1
    //   655: aload 10
    //   657: aload_1
    //   658: invokevirtual 287	com/tencent/gdtad/views/videoceiling/GdtVideoCeilingData:setWebUrl	(Ljava/lang/String;)V
    //   661: aload 12
    //   663: instanceof 289
    //   666: ifeq -476 -> 190
    //   669: aload 12
    //   671: checkcast 289	android/app/Activity
    //   674: ldc_w 291
    //   677: aload 10
    //   679: invokestatic 294	com/tencent/biz/pubaccount/ecshopassit/ShopVideoCeilingFragment:a	(Landroid/app/Activity;Ljava/lang/Class;Lcom/tencent/gdtad/views/videoceiling/GdtVideoCeilingData;)V
    //   682: return
    //   683: new 128	org/json/JSONObject
    //   686: dup
    //   687: aload 8
    //   689: invokespecial 296	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   692: astore 9
    //   694: goto -410 -> 284
    //   697: astore 8
    //   699: aconst_null
    //   700: astore 11
    //   702: aload 10
    //   704: astore 9
    //   706: aload_1
    //   707: astore 8
    //   709: aload 11
    //   711: astore_1
    //   712: aload_1
    //   713: astore 10
    //   715: aload 8
    //   717: astore_1
    //   718: aload 10
    //   720: astore 8
    //   722: goto -332 -> 390
    //   725: aload_0
    //   726: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   729: getfield 228	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:J	Ljava/lang/String;
    //   732: astore_1
    //   733: goto -230 -> 503
    //   736: aload_0
    //   737: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   740: getfield 234	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:K	Ljava/lang/String;
    //   743: astore_1
    //   744: goto -215 -> 529
    //   747: aload_0
    //   748: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   751: getfield 271	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:v	Ljava/lang/String;
    //   754: astore_1
    //   755: goto -142 -> 613
    //   758: aload_0
    //   759: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   762: getfield 284	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:I	Ljava/lang/String;
    //   765: astore_1
    //   766: goto -111 -> 655
    //   769: new 298	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   776: astore 11
    //   778: aload 11
    //   780: aload 14
    //   782: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: astore 15
    //   787: aload 14
    //   789: ldc_w 305
    //   792: invokevirtual 308	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   795: ifeq +72 -> 867
    //   798: ldc_w 310
    //   801: astore_1
    //   802: aload 15
    //   804: aload_1
    //   805: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload 10
    //   810: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   813: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: ldc_w 312
    //   819: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 9
    //   824: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   827: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: ldc_w 314
    //   833: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload 8
    //   838: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   841: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 13
    //   847: ldc_w 316
    //   850: aload 11
    //   852: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokevirtual 323	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   858: pop
    //   859: aload 12
    //   861: aload 13
    //   863: invokevirtual 329	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   866: return
    //   867: ldc_w 331
    //   870: astore_1
    //   871: goto -69 -> 802
    //   874: invokestatic 336	com/tencent/mobileqq/structmsg/AIOVideoPlayController:a	()Lcom/tencent/mobileqq/structmsg/AIOVideoPlayController;
    //   877: astore_1
    //   878: aload_1
    //   879: invokevirtual 339	com/tencent/mobileqq/structmsg/AIOVideoPlayController:a	()Z
    //   882: ifne +39 -> 921
    //   885: aload_0
    //   886: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   889: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   892: instanceof 341
    //   895: ifeq -705 -> 190
    //   898: aload_0
    //   899: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   902: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   905: checkcast 341	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   908: astore_1
    //   909: aload_0
    //   910: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   913: aload 12
    //   915: aload_1
    //   916: lconst_0
    //   917: invokevirtual 344	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	(Landroid/content/Context;Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;J)V
    //   920: return
    //   921: aload_1
    //   922: aload 12
    //   924: iconst_2
    //   925: aload_0
    //   926: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   929: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   932: getfield 347	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   935: invokevirtual 350	com/tencent/mobileqq/structmsg/AIOVideoPlayController:a	(Landroid/content/Context;II)Z
    //   938: ifeq +39 -> 977
    //   941: aload_0
    //   942: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   945: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   948: instanceof 341
    //   951: ifeq -761 -> 190
    //   954: aload_0
    //   955: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   958: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   961: checkcast 341	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   964: astore_1
    //   965: aload_0
    //   966: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   969: aload 12
    //   971: aload_1
    //   972: lconst_0
    //   973: invokevirtual 344	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	(Landroid/content/Context;Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;J)V
    //   976: return
    //   977: aload 12
    //   979: invokestatic 355	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   982: ifne +17 -> 999
    //   985: aload 12
    //   987: ldc_w 356
    //   990: iconst_0
    //   991: invokestatic 361	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   994: invokevirtual 364	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   997: pop
    //   998: return
    //   999: aload_0
    //   1000: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   1003: aload 12
    //   1005: aload_0
    //   1006: getfield 12	aiov:a	Lcom/tencent/mobileqq/structmsg/view/StructMsgItemVideo;
    //   1009: getfield 44	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1012: checkcast 341	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1015: lconst_0
    //   1016: invokevirtual 344	com/tencent/mobileqq/structmsg/view/StructMsgItemVideo:a	(Landroid/content/Context;Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;J)V
    //   1019: return
    //   1020: astore_1
    //   1021: aconst_null
    //   1022: astore_1
    //   1023: aconst_null
    //   1024: astore 8
    //   1026: aload 10
    //   1028: astore 9
    //   1030: goto -318 -> 712
    //   1033: astore 9
    //   1035: aconst_null
    //   1036: astore 11
    //   1038: aload_1
    //   1039: astore 9
    //   1041: aload 8
    //   1043: astore 10
    //   1045: aload 11
    //   1047: astore_1
    //   1048: aload 9
    //   1050: astore 8
    //   1052: aload 10
    //   1054: astore 9
    //   1056: goto -344 -> 712
    //   1059: astore 10
    //   1061: aload 9
    //   1063: astore 10
    //   1065: aload 8
    //   1067: astore 9
    //   1069: aload_1
    //   1070: astore 8
    //   1072: aload 10
    //   1074: astore_1
    //   1075: goto -363 -> 712
    //   1078: lconst_0
    //   1079: lstore_2
    //   1080: goto -907 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1083	0	this	aiov
    //   0	1083	1	paramView	android.view.View
    //   172	908	2	l1	long
    //   4	440	4	l2	long
    //   372	3	6	l3	long
    //   18	670	8	localObject1	Object
    //   697	1	8	localException1	java.lang.Exception
    //   707	364	8	localObject2	Object
    //   53	976	9	localObject3	Object
    //   1033	1	9	localException2	java.lang.Exception
    //   1039	29	9	localObject4	Object
    //   1	1052	10	localObject5	Object
    //   1059	1	10	localException3	java.lang.Exception
    //   1063	10	10	localObject6	Object
    //   38	1008	11	localObject7	Object
    //   10	994	12	localContext	android.content.Context
    //   221	641	13	localIntent	android.content.Intent
    //   208	580	14	str	java.lang.String
    //   785	18	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   250	284	697	java/lang/Exception
    //   284	293	697	java/lang/Exception
    //   683	694	697	java/lang/Exception
    //   234	250	1020	java/lang/Exception
    //   293	302	1033	java/lang/Exception
    //   302	374	1059	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiov
 * JD-Core Version:    0.7.0.1
 */
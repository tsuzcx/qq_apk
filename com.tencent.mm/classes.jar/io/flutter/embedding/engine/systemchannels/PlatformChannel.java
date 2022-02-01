package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlatformChannel
{
  private static final String TAG = "PlatformChannel";
  public final MethodChannel channel;
  final MethodChannel.MethodCallHandler parsingMethodCallHandler;
  private PlatformMessageHandler platformMessageHandler;
  
  public PlatformChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10242);
    this.parsingMethodCallHandler = new MethodChannel.MethodCallHandler()
    {
      /* Error */
      public void onMethodCall(io.flutter.plugin.common.MethodCall paramAnonymousMethodCall, io.flutter.plugin.common.MethodChannel.Result paramAnonymousResult)
      {
        // Byte code:
        //   0: sipush 10217
        //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: aload_0
        //   7: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   10: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   13: ifnonnull +10 -> 23
        //   16: sipush 10217
        //   19: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   22: return
        //   23: aload_1
        //   24: getfield 43	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
        //   27: astore 5
        //   29: aload_1
        //   30: getfield 47	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
        //   33: astore_1
        //   34: ldc 49
        //   36: new 51	java/lang/StringBuilder
        //   39: dup
        //   40: ldc 53
        //   42: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   45: aload 5
        //   47: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   50: ldc 62
        //   52: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   55: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   58: invokestatic 72	io/flutter/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   61: iconst_m1
        //   62: istore_3
        //   63: aload 5
        //   65: invokevirtual 78	java/lang/String:hashCode	()I
        //   68: lookupswitch	default:+923->991, -766342101:+219->287, -720677196:+251->319, -548468504:+158->226, -247230243:+128->196, -215273374:+113->181, 241845679:+188->256, 875995648:+267->335, 1390477857:+203->271, 1514180520:+235->303, 1674312266:+173->241, 2119655719:+143->211
        //   169: invokeinterface 83 1 0
        //   174: sipush 10217
        //   177: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   180: return
        //   181: aload 5
        //   183: ldc 85
        //   185: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   188: ifeq +803 -> 991
        //   191: iconst_0
        //   192: istore_3
        //   193: goto +798 -> 991
        //   196: aload 5
        //   198: ldc 91
        //   200: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   203: ifeq +788 -> 991
        //   206: iconst_1
        //   207: istore_3
        //   208: goto +783 -> 991
        //   211: aload 5
        //   213: ldc 93
        //   215: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   218: ifeq +773 -> 991
        //   221: iconst_2
        //   222: istore_3
        //   223: goto +768 -> 991
        //   226: aload 5
        //   228: ldc 95
        //   230: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   233: ifeq +758 -> 991
        //   236: iconst_3
        //   237: istore_3
        //   238: goto +753 -> 991
        //   241: aload 5
        //   243: ldc 97
        //   245: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   248: ifeq +743 -> 991
        //   251: iconst_4
        //   252: istore_3
        //   253: goto +738 -> 991
        //   256: aload 5
        //   258: ldc 99
        //   260: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   263: ifeq +728 -> 991
        //   266: iconst_5
        //   267: istore_3
        //   268: goto +723 -> 991
        //   271: aload 5
        //   273: ldc 101
        //   275: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   278: ifeq +713 -> 991
        //   281: bipush 6
        //   283: istore_3
        //   284: goto +707 -> 991
        //   287: aload 5
        //   289: ldc 103
        //   291: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   294: ifeq +697 -> 991
        //   297: bipush 7
        //   299: istore_3
        //   300: goto +691 -> 991
        //   303: aload 5
        //   305: ldc 105
        //   307: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   310: ifeq +681 -> 991
        //   313: bipush 8
        //   315: istore_3
        //   316: goto +675 -> 991
        //   319: aload 5
        //   321: ldc 107
        //   323: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   326: ifeq +665 -> 991
        //   329: bipush 9
        //   331: istore_3
        //   332: goto +659 -> 991
        //   335: aload 5
        //   337: ldc 109
        //   339: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   342: istore 4
        //   344: iload 4
        //   346: ifeq +645 -> 991
        //   349: bipush 10
        //   351: istore_3
        //   352: goto +639 -> 991
        //   355: aload_1
        //   356: checkcast 74	java/lang/String
        //   359: invokestatic 115	io/flutter/embedding/engine/systemchannels/PlatformChannel$SoundType:fromValue	(Ljava/lang/String;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SoundType;
        //   362: astore_1
        //   363: aload_0
        //   364: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   367: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   370: aload_1
        //   371: invokeinterface 121 2 0
        //   376: aload_2
        //   377: aconst_null
        //   378: invokeinterface 125 2 0
        //   383: sipush 10217
        //   386: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   389: return
        //   390: astore_1
        //   391: aload_2
        //   392: ldc 127
        //   394: new 51	java/lang/StringBuilder
        //   397: dup
        //   398: ldc 129
        //   400: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   403: aload_1
        //   404: invokevirtual 132	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   407: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   410: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   413: aconst_null
        //   414: invokeinterface 135 4 0
        //   419: sipush 10217
        //   422: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   425: return
        //   426: astore_1
        //   427: aload_2
        //   428: ldc 127
        //   430: aload_1
        //   431: invokevirtual 136	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   434: aconst_null
        //   435: invokeinterface 135 4 0
        //   440: sipush 10217
        //   443: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   446: return
        //   447: aload_1
        //   448: checkcast 74	java/lang/String
        //   451: invokestatic 141	io/flutter/embedding/engine/systemchannels/PlatformChannel$HapticFeedbackType:fromValue	(Ljava/lang/String;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$HapticFeedbackType;
        //   454: astore_1
        //   455: aload_0
        //   456: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   459: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   462: aload_1
        //   463: invokeinterface 145 2 0
        //   468: aload_2
        //   469: aconst_null
        //   470: invokeinterface 125 2 0
        //   475: sipush 10217
        //   478: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   481: return
        //   482: astore_1
        //   483: aload_2
        //   484: ldc 127
        //   486: aload_1
        //   487: invokevirtual 136	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   490: aconst_null
        //   491: invokeinterface 135 4 0
        //   496: sipush 10217
        //   499: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   502: return
        //   503: aload_0
        //   504: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   507: aload_1
        //   508: checkcast 147	org/json/JSONArray
        //   511: invokestatic 151	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$100	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;Lorg/json/JSONArray;)I
        //   514: istore_3
        //   515: aload_0
        //   516: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   519: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   522: iload_3
        //   523: invokeinterface 154 2 0
        //   528: aload_2
        //   529: aconst_null
        //   530: invokeinterface 125 2 0
        //   535: sipush 10217
        //   538: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   541: return
        //   542: aload_2
        //   543: ldc 127
        //   545: aload_1
        //   546: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   549: aconst_null
        //   550: invokeinterface 135 4 0
        //   555: sipush 10217
        //   558: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   561: return
        //   562: aload_0
        //   563: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   566: aload_1
        //   567: checkcast 159	org/json/JSONObject
        //   570: invokestatic 163	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$200	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;Lorg/json/JSONObject;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$AppSwitcherDescription;
        //   573: astore_1
        //   574: aload_0
        //   575: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   578: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   581: aload_1
        //   582: invokeinterface 167 2 0
        //   587: aload_2
        //   588: aconst_null
        //   589: invokeinterface 125 2 0
        //   594: sipush 10217
        //   597: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   600: return
        //   601: astore_1
        //   602: aload_2
        //   603: ldc 127
        //   605: aload_1
        //   606: invokevirtual 132	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   609: aconst_null
        //   610: invokeinterface 135 4 0
        //   615: sipush 10217
        //   618: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   621: return
        //   622: aload_0
        //   623: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   626: aload_1
        //   627: checkcast 147	org/json/JSONArray
        //   630: invokestatic 171	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$300	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;Lorg/json/JSONArray;)Ljava/util/List;
        //   633: astore_1
        //   634: aload_0
        //   635: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   638: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   641: aload_1
        //   642: invokeinterface 175 2 0
        //   647: aload_2
        //   648: aconst_null
        //   649: invokeinterface 125 2 0
        //   654: sipush 10217
        //   657: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   660: return
        //   661: aload_2
        //   662: ldc 127
        //   664: aload_1
        //   665: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   668: aconst_null
        //   669: invokeinterface 135 4 0
        //   674: sipush 10217
        //   677: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   680: return
        //   681: aload_0
        //   682: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   685: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   688: invokeinterface 178 1 0
        //   693: aload_2
        //   694: aconst_null
        //   695: invokeinterface 125 2 0
        //   700: sipush 10217
        //   703: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   706: return
        //   707: aload_0
        //   708: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   711: aload_1
        //   712: checkcast 159	org/json/JSONObject
        //   715: invokestatic 182	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$400	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;Lorg/json/JSONObject;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemChromeStyle;
        //   718: astore_1
        //   719: aload_0
        //   720: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   723: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   726: aload_1
        //   727: invokeinterface 186 2 0
        //   732: aload_2
        //   733: aconst_null
        //   734: invokeinterface 125 2 0
        //   739: sipush 10217
        //   742: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   745: return
        //   746: aload_2
        //   747: ldc 127
        //   749: aload_1
        //   750: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   753: aconst_null
        //   754: invokeinterface 135 4 0
        //   759: sipush 10217
        //   762: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   765: return
        //   766: aload_0
        //   767: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   770: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   773: invokeinterface 189 1 0
        //   778: aload_2
        //   779: aconst_null
        //   780: invokeinterface 125 2 0
        //   785: sipush 10217
        //   788: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   791: return
        //   792: aload_1
        //   793: checkcast 74	java/lang/String
        //   796: astore 5
        //   798: aload 5
        //   800: ifnull +267 -> 1067
        //   803: aload 5
        //   805: invokestatic 194	io/flutter/embedding/engine/systemchannels/PlatformChannel$ClipboardContentFormat:fromValue	(Ljava/lang/String;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$ClipboardContentFormat;
        //   808: astore_1
        //   809: aload_0
        //   810: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   813: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   816: aload_1
        //   817: invokeinterface 198 2 0
        //   822: astore_1
        //   823: aload_1
        //   824: ifnull +59 -> 883
        //   827: new 159	org/json/JSONObject
        //   830: dup
        //   831: invokespecial 199	org/json/JSONObject:<init>	()V
        //   834: astore 5
        //   836: aload 5
        //   838: ldc 201
        //   840: aload_1
        //   841: invokevirtual 205	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   844: pop
        //   845: aload_2
        //   846: aload 5
        //   848: invokeinterface 125 2 0
        //   853: sipush 10217
        //   856: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   859: return
        //   860: astore_1
        //   861: aload_2
        //   862: ldc 127
        //   864: ldc 207
        //   866: aload 5
        //   868: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   871: invokevirtual 215	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   874: aconst_null
        //   875: invokeinterface 135 4 0
        //   880: goto +187 -> 1067
        //   883: aload_2
        //   884: aconst_null
        //   885: invokeinterface 125 2 0
        //   890: sipush 10217
        //   893: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   896: return
        //   897: aload_1
        //   898: checkcast 159	org/json/JSONObject
        //   901: ldc 201
        //   903: invokevirtual 218	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   906: astore_1
        //   907: aload_0
        //   908: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   911: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   914: aload_1
        //   915: invokeinterface 221 2 0
        //   920: aload_2
        //   921: aconst_null
        //   922: invokeinterface 125 2 0
        //   927: sipush 10217
        //   930: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   933: return
        //   934: aload_0
        //   935: getfield 14	io/flutter/embedding/engine/systemchannels/PlatformChannel$1:this$0	Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
        //   938: invokestatic 34	io/flutter/embedding/engine/systemchannels/PlatformChannel:access$000	(Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
        //   941: invokeinterface 225 1 0
        //   946: istore 4
        //   948: new 159	org/json/JSONObject
        //   951: dup
        //   952: invokespecial 199	org/json/JSONObject:<init>	()V
        //   955: astore_1
        //   956: aload_1
        //   957: ldc 227
        //   959: iload 4
        //   961: invokevirtual 230	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
        //   964: pop
        //   965: aload_2
        //   966: aload_1
        //   967: invokeinterface 125 2 0
        //   972: sipush 10217
        //   975: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   978: return
        //   979: astore_1
        //   980: goto -234 -> 746
        //   983: astore_1
        //   984: goto -323 -> 661
        //   987: astore_1
        //   988: goto -446 -> 542
        //   991: iload_3
        //   992: tableswitch	default:+60 -> 1052, 0:+-637->355, 1:+-545->447, 2:+-489->503, 3:+-430->562, 4:+-370->622, 5:+-311->681, 6:+-285->707, 7:+-226->766, 8:+-200->792, 9:+-95->897, 10:+-58->934
        //   1053: <illegal opcode>
        //   1054: f2l
        //   1055: astore_1
        //   1056: goto -514 -> 542
        //   1059: astore_1
        //   1060: goto -399 -> 661
        //   1063: astore_1
        //   1064: goto -318 -> 746
        //   1067: aconst_null
        //   1068: astore_1
        //   1069: goto -260 -> 809
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1072	0	this	1
        //   0	1072	1	paramAnonymousMethodCall	io.flutter.plugin.common.MethodCall
        //   0	1072	2	paramAnonymousResult	io.flutter.plugin.common.MethodChannel.Result
        //   62	930	3	i	int
        //   342	618	4	bool	boolean
        //   27	840	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   63	168	390	org/json/JSONException
        //   168	174	390	org/json/JSONException
        //   181	191	390	org/json/JSONException
        //   196	206	390	org/json/JSONException
        //   211	221	390	org/json/JSONException
        //   226	236	390	org/json/JSONException
        //   241	251	390	org/json/JSONException
        //   256	266	390	org/json/JSONException
        //   271	281	390	org/json/JSONException
        //   287	297	390	org/json/JSONException
        //   303	313	390	org/json/JSONException
        //   319	329	390	org/json/JSONException
        //   335	344	390	org/json/JSONException
        //   355	383	390	org/json/JSONException
        //   383	389	390	org/json/JSONException
        //   427	446	390	org/json/JSONException
        //   447	475	390	org/json/JSONException
        //   475	481	390	org/json/JSONException
        //   483	502	390	org/json/JSONException
        //   535	541	390	org/json/JSONException
        //   542	561	390	org/json/JSONException
        //   594	600	390	org/json/JSONException
        //   602	621	390	org/json/JSONException
        //   654	660	390	org/json/JSONException
        //   661	680	390	org/json/JSONException
        //   681	706	390	org/json/JSONException
        //   739	745	390	org/json/JSONException
        //   746	765	390	org/json/JSONException
        //   766	791	390	org/json/JSONException
        //   792	798	390	org/json/JSONException
        //   803	809	390	org/json/JSONException
        //   809	823	390	org/json/JSONException
        //   827	859	390	org/json/JSONException
        //   861	880	390	org/json/JSONException
        //   883	896	390	org/json/JSONException
        //   897	933	390	org/json/JSONException
        //   934	978	390	org/json/JSONException
        //   355	383	426	java/lang/NoSuchFieldException
        //   447	475	482	java/lang/NoSuchFieldException
        //   562	594	601	org/json/JSONException
        //   803	809	860	java/lang/NoSuchFieldException
        //   707	739	979	org/json/JSONException
        //   622	654	983	org/json/JSONException
        //   503	535	987	org/json/JSONException
        //   503	535	1055	java/lang/NoSuchFieldException
        //   622	654	1059	java/lang/NoSuchFieldException
        //   707	739	1063	java/lang/NoSuchFieldException
      }
    };
    this.channel = new MethodChannel(paramDartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingMethodCallHandler);
    AppMethodBeat.o(10242);
  }
  
  private AppSwitcherDescription decodeAppSwitcherDescription(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190305);
    int j = paramJSONObject.getInt("primaryColor");
    int i = j;
    if (j != 0) {
      i = j | 0xFF000000;
    }
    paramJSONObject = new AppSwitcherDescription(i, paramJSONObject.getString("label"));
    AppMethodBeat.o(190305);
    return paramJSONObject;
  }
  
  private int decodeOrientations(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(190298);
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < paramJSONArray.length())
    {
      DeviceOrientation localDeviceOrientation = DeviceOrientation.fromValue(paramJSONArray.getString(j));
      switch (2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[localDeviceOrientation.ordinal()])
      {
      }
      for (;;)
      {
        int m = k;
        if (k == 0) {
          m = i;
        }
        j += 1;
        k = m;
        break;
        i |= 0x1;
        continue;
        i |= 0x4;
        continue;
        i |= 0x2;
        continue;
        i |= 0x8;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190298);
      return 1;
      AppMethodBeat.o(190298);
      return -1;
      AppMethodBeat.o(190298);
      return 1;
      AppMethodBeat.o(190298);
      return 0;
      AppMethodBeat.o(190298);
      return 9;
      AppMethodBeat.o(190298);
      return 12;
      AppMethodBeat.o(190298);
      return 8;
      AppMethodBeat.o(190298);
      return 11;
      AppMethodBeat.o(190298);
      return 2;
      AppMethodBeat.o(190298);
      return 13;
      switch (k)
      {
      }
    }
    AppMethodBeat.o(190298);
    return 1;
    AppMethodBeat.o(190298);
    return 0;
    AppMethodBeat.o(190298);
    return 9;
    AppMethodBeat.o(190298);
    return 8;
  }
  
  private SystemChromeStyle decodeSystemChromeStyle(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190319);
    if (!paramJSONObject.isNull("systemNavigationBarIconBrightness")) {}
    for (Brightness localBrightness1 = Brightness.fromValue(paramJSONObject.getString("systemNavigationBarIconBrightness"));; localBrightness1 = null)
    {
      if (!paramJSONObject.isNull("systemNavigationBarColor")) {}
      for (Integer localInteger1 = Integer.valueOf(paramJSONObject.getInt("systemNavigationBarColor"));; localInteger1 = null)
      {
        if (!paramJSONObject.isNull("statusBarIconBrightness")) {}
        for (Brightness localBrightness2 = Brightness.fromValue(paramJSONObject.getString("statusBarIconBrightness"));; localBrightness2 = null)
        {
          if (!paramJSONObject.isNull("statusBarColor")) {}
          for (Integer localInteger2 = Integer.valueOf(paramJSONObject.getInt("statusBarColor"));; localInteger2 = null)
          {
            if (!paramJSONObject.isNull("systemNavigationBarDividerColor")) {}
            for (paramJSONObject = Integer.valueOf(paramJSONObject.getInt("systemNavigationBarDividerColor"));; paramJSONObject = null)
            {
              paramJSONObject = new SystemChromeStyle(localInteger2, localBrightness2, localInteger1, localBrightness1, paramJSONObject);
              AppMethodBeat.o(190319);
              return paramJSONObject;
            }
          }
        }
      }
    }
  }
  
  private List<SystemUiOverlay> decodeSystemUiOverlays(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(190311);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      SystemUiOverlay localSystemUiOverlay = SystemUiOverlay.fromValue(paramJSONArray.getString(i));
      switch (2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[localSystemUiOverlay.ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(SystemUiOverlay.TOP_OVERLAYS);
        continue;
        localArrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
      }
    }
    AppMethodBeat.o(190311);
    return localArrayList;
  }
  
  public void setPlatformMessageHandler(PlatformMessageHandler paramPlatformMessageHandler)
  {
    this.platformMessageHandler = paramPlatformMessageHandler;
  }
  
  public static class AppSwitcherDescription
  {
    public final int color;
    public final String label;
    
    public AppSwitcherDescription(int paramInt, String paramString)
    {
      this.color = paramInt;
      this.label = paramString;
    }
  }
  
  public static enum Brightness
  {
    private String encodedName;
    
    static
    {
      AppMethodBeat.i(10228);
      LIGHT = new Brightness("LIGHT", 0, "Brightness.light");
      DARK = new Brightness("DARK", 1, "Brightness.dark");
      $VALUES = new Brightness[] { LIGHT, DARK };
      AppMethodBeat.o(10228);
    }
    
    private Brightness(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static Brightness fromValue(String paramString)
    {
      AppMethodBeat.i(10227);
      Brightness[] arrayOfBrightness = values();
      int j = arrayOfBrightness.length;
      int i = 0;
      while (i < j)
      {
        Brightness localBrightness = arrayOfBrightness[i];
        if (localBrightness.encodedName.equals(paramString))
        {
          AppMethodBeat.o(10227);
          return localBrightness;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such Brightness: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10227);
      throw paramString;
    }
  }
  
  public static enum DeviceOrientation
  {
    private String encodedName;
    
    static
    {
      AppMethodBeat.i(10279);
      PORTRAIT_UP = new DeviceOrientation("PORTRAIT_UP", 0, "DeviceOrientation.portraitUp");
      PORTRAIT_DOWN = new DeviceOrientation("PORTRAIT_DOWN", 1, "DeviceOrientation.portraitDown");
      LANDSCAPE_LEFT = new DeviceOrientation("LANDSCAPE_LEFT", 2, "DeviceOrientation.landscapeLeft");
      LANDSCAPE_RIGHT = new DeviceOrientation("LANDSCAPE_RIGHT", 3, "DeviceOrientation.landscapeRight");
      $VALUES = new DeviceOrientation[] { PORTRAIT_UP, PORTRAIT_DOWN, LANDSCAPE_LEFT, LANDSCAPE_RIGHT };
      AppMethodBeat.o(10279);
    }
    
    private DeviceOrientation(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static DeviceOrientation fromValue(String paramString)
    {
      AppMethodBeat.i(10278);
      DeviceOrientation[] arrayOfDeviceOrientation = values();
      int j = arrayOfDeviceOrientation.length;
      int i = 0;
      while (i < j)
      {
        DeviceOrientation localDeviceOrientation = arrayOfDeviceOrientation[i];
        if (localDeviceOrientation.encodedName.equals(paramString))
        {
          AppMethodBeat.o(10278);
          return localDeviceOrientation;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such DeviceOrientation: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10278);
      throw paramString;
    }
  }
  
  public static enum HapticFeedbackType
  {
    private final String encodedName;
    
    static
    {
      AppMethodBeat.i(10252);
      STANDARD = new HapticFeedbackType("STANDARD", 0, null);
      LIGHT_IMPACT = new HapticFeedbackType("LIGHT_IMPACT", 1, "HapticFeedbackType.lightImpact");
      MEDIUM_IMPACT = new HapticFeedbackType("MEDIUM_IMPACT", 2, "HapticFeedbackType.mediumImpact");
      HEAVY_IMPACT = new HapticFeedbackType("HEAVY_IMPACT", 3, "HapticFeedbackType.heavyImpact");
      SELECTION_CLICK = new HapticFeedbackType("SELECTION_CLICK", 4, "HapticFeedbackType.selectionClick");
      $VALUES = new HapticFeedbackType[] { STANDARD, LIGHT_IMPACT, MEDIUM_IMPACT, HEAVY_IMPACT, SELECTION_CLICK };
      AppMethodBeat.o(10252);
    }
    
    private HapticFeedbackType(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static HapticFeedbackType fromValue(String paramString)
    {
      AppMethodBeat.i(10251);
      HapticFeedbackType[] arrayOfHapticFeedbackType = values();
      int j = arrayOfHapticFeedbackType.length;
      int i = 0;
      while (i < j)
      {
        HapticFeedbackType localHapticFeedbackType = arrayOfHapticFeedbackType[i];
        if (((localHapticFeedbackType.encodedName == null) && (paramString == null)) || ((localHapticFeedbackType.encodedName != null) && (localHapticFeedbackType.encodedName.equals(paramString))))
        {
          AppMethodBeat.o(10251);
          return localHapticFeedbackType;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such HapticFeedbackType: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10251);
      throw paramString;
    }
  }
  
  public static abstract interface PlatformMessageHandler
  {
    public abstract boolean clipboardHasStrings();
    
    public abstract CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramClipboardContentFormat);
    
    public abstract void playSystemSound(PlatformChannel.SoundType paramSoundType);
    
    public abstract void popSystemNavigator();
    
    public abstract void restoreSystemUiOverlays();
    
    public abstract void setApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription);
    
    public abstract void setClipboardData(String paramString);
    
    public abstract void setPreferredOrientations(int paramInt);
    
    public abstract void setSystemUiOverlayStyle(PlatformChannel.SystemChromeStyle paramSystemChromeStyle);
    
    public abstract void showSystemOverlays(List<PlatformChannel.SystemUiOverlay> paramList);
    
    public abstract void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramHapticFeedbackType);
  }
  
  public static class SystemChromeStyle
  {
    public final Integer statusBarColor;
    public final PlatformChannel.Brightness statusBarIconBrightness;
    public final Integer systemNavigationBarColor;
    public final Integer systemNavigationBarDividerColor;
    public final PlatformChannel.Brightness systemNavigationBarIconBrightness;
    
    public SystemChromeStyle(Integer paramInteger1, PlatformChannel.Brightness paramBrightness1, Integer paramInteger2, PlatformChannel.Brightness paramBrightness2, Integer paramInteger3)
    {
      this.statusBarColor = paramInteger1;
      this.statusBarIconBrightness = paramBrightness1;
      this.systemNavigationBarColor = paramInteger2;
      this.systemNavigationBarIconBrightness = paramBrightness2;
      this.systemNavigationBarDividerColor = paramInteger3;
    }
  }
  
  public static enum SystemUiOverlay
  {
    private String encodedName;
    
    static
    {
      AppMethodBeat.i(10232);
      TOP_OVERLAYS = new SystemUiOverlay("TOP_OVERLAYS", 0, "SystemUiOverlay.top");
      BOTTOM_OVERLAYS = new SystemUiOverlay("BOTTOM_OVERLAYS", 1, "SystemUiOverlay.bottom");
      $VALUES = new SystemUiOverlay[] { TOP_OVERLAYS, BOTTOM_OVERLAYS };
      AppMethodBeat.o(10232);
    }
    
    private SystemUiOverlay(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static SystemUiOverlay fromValue(String paramString)
    {
      AppMethodBeat.i(10231);
      SystemUiOverlay[] arrayOfSystemUiOverlay = values();
      int j = arrayOfSystemUiOverlay.length;
      int i = 0;
      while (i < j)
      {
        SystemUiOverlay localSystemUiOverlay = arrayOfSystemUiOverlay[i];
        if (localSystemUiOverlay.encodedName.equals(paramString))
        {
          AppMethodBeat.o(10231);
          return localSystemUiOverlay;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such SystemUiOverlay: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10231);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel
 * JD-Core Version:    0.7.0.1
 */
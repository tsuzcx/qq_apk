package io.flutter.embedding.engine.c;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public f MEd;
  protected final k.c MEe;
  public final k vCn;
  
  public f(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10242);
    this.MEe = new k.c()
    {
      /* Error */
      public final void a(io.flutter.plugin.a.j paramAnonymousj, io.flutter.plugin.a.k.d paramAnonymousd)
      {
        // Byte code:
        //   0: sipush 10217
        //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: aload_0
        //   7: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   10: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   13: ifnonnull +10 -> 23
        //   16: sipush 10217
        //   19: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   22: return
        //   23: aload_1
        //   24: getfield 43	io/flutter/plugin/a/j:method	Ljava/lang/String;
        //   27: astore 6
        //   29: aload_1
        //   30: getfield 47	io/flutter/plugin/a/j:grf	Ljava/lang/Object;
        //   33: astore_1
        //   34: new 49	java/lang/StringBuilder
        //   37: dup
        //   38: ldc 51
        //   40: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   43: aload 6
        //   45: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   48: ldc 60
        //   50: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   53: pop
        //   54: invokestatic 65	io/flutter/a:gea	()V
        //   57: iconst_m1
        //   58: istore_3
        //   59: aload 6
        //   61: invokevirtual 71	java/lang/String:hashCode	()I
        //   64: lookupswitch	default:+1188->1252, -766342101:+227->291, -720677196:+291->355, -548468504:+166->230, -247230243:+136->200, -215273374:+121->185, 96412730:+243->307, 232206254:+259->323, 241845679:+196->260, 1390477857:+211->275, 1514180520:+275->339, 1674312266:+181->245, 2119655719:+151->215
        //   173: invokeinterface 76 1 0
        //   178: sipush 10217
        //   181: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   184: return
        //   185: aload 6
        //   187: ldc 78
        //   189: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   192: ifeq +1060 -> 1252
        //   195: iconst_0
        //   196: istore_3
        //   197: goto +1055 -> 1252
        //   200: aload 6
        //   202: ldc 84
        //   204: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   207: ifeq +1045 -> 1252
        //   210: iconst_1
        //   211: istore_3
        //   212: goto +1040 -> 1252
        //   215: aload 6
        //   217: ldc 86
        //   219: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   222: ifeq +1030 -> 1252
        //   225: iconst_2
        //   226: istore_3
        //   227: goto +1025 -> 1252
        //   230: aload 6
        //   232: ldc 88
        //   234: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   237: ifeq +1015 -> 1252
        //   240: iconst_3
        //   241: istore_3
        //   242: goto +1010 -> 1252
        //   245: aload 6
        //   247: ldc 90
        //   249: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   252: ifeq +1000 -> 1252
        //   255: iconst_4
        //   256: istore_3
        //   257: goto +995 -> 1252
        //   260: aload 6
        //   262: ldc 92
        //   264: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   267: ifeq +985 -> 1252
        //   270: iconst_5
        //   271: istore_3
        //   272: goto +980 -> 1252
        //   275: aload 6
        //   277: ldc 94
        //   279: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   282: ifeq +970 -> 1252
        //   285: bipush 6
        //   287: istore_3
        //   288: goto +964 -> 1252
        //   291: aload 6
        //   293: ldc 96
        //   295: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   298: ifeq +954 -> 1252
        //   301: bipush 7
        //   303: istore_3
        //   304: goto +948 -> 1252
        //   307: aload 6
        //   309: ldc 98
        //   311: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   314: ifeq +938 -> 1252
        //   317: bipush 8
        //   319: istore_3
        //   320: goto +932 -> 1252
        //   323: aload 6
        //   325: ldc 100
        //   327: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   330: ifeq +922 -> 1252
        //   333: bipush 9
        //   335: istore_3
        //   336: goto +916 -> 1252
        //   339: aload 6
        //   341: ldc 102
        //   343: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   346: ifeq +906 -> 1252
        //   349: bipush 10
        //   351: istore_3
        //   352: goto +900 -> 1252
        //   355: aload 6
        //   357: ldc 104
        //   359: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   362: istore 5
        //   364: iload 5
        //   366: ifeq +886 -> 1252
        //   369: bipush 11
        //   371: istore_3
        //   372: goto +880 -> 1252
        //   375: aload_1
        //   376: checkcast 67	java/lang/String
        //   379: invokestatic 110	io/flutter/embedding/engine/c/f$g:bbU	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$g;
        //   382: astore_1
        //   383: aload_0
        //   384: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   387: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   390: aload_1
        //   391: invokeinterface 115 2 0
        //   396: aload_2
        //   397: aconst_null
        //   398: invokeinterface 119 2 0
        //   403: sipush 10217
        //   406: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   409: return
        //   410: astore_1
        //   411: aload_2
        //   412: ldc 121
        //   414: new 49	java/lang/StringBuilder
        //   417: dup
        //   418: ldc 123
        //   420: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   423: aload_1
        //   424: invokevirtual 127	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   427: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   430: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   433: aconst_null
        //   434: invokeinterface 134 4 0
        //   439: sipush 10217
        //   442: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   445: return
        //   446: astore_1
        //   447: aload_2
        //   448: ldc 121
        //   450: aload_1
        //   451: invokevirtual 135	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   454: aconst_null
        //   455: invokeinterface 134 4 0
        //   460: sipush 10217
        //   463: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   466: return
        //   467: aload_1
        //   468: checkcast 67	java/lang/String
        //   471: invokestatic 141	io/flutter/embedding/engine/c/f$e:bbS	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$e;
        //   474: astore_1
        //   475: aload_0
        //   476: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   479: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   482: aload_1
        //   483: invokeinterface 144 2 0
        //   488: aload_2
        //   489: aconst_null
        //   490: invokeinterface 119 2 0
        //   495: sipush 10217
        //   498: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   501: return
        //   502: astore_1
        //   503: aload_2
        //   504: ldc 121
        //   506: aload_1
        //   507: invokevirtual 135	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   510: aconst_null
        //   511: invokeinterface 134 4 0
        //   516: sipush 10217
        //   519: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   522: return
        //   523: aload_1
        //   524: checkcast 146	org/json/JSONArray
        //   527: invokestatic 150	io/flutter/embedding/engine/c/f:S	(Lorg/json/JSONArray;)I
        //   530: istore_3
        //   531: aload_0
        //   532: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   535: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   538: iload_3
        //   539: invokeinterface 153 2 0
        //   544: aload_2
        //   545: aconst_null
        //   546: invokeinterface 119 2 0
        //   551: sipush 10217
        //   554: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   557: return
        //   558: aload_2
        //   559: ldc 121
        //   561: aload_1
        //   562: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   565: aconst_null
        //   566: invokeinterface 134 4 0
        //   571: sipush 10217
        //   574: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   577: return
        //   578: aload_1
        //   579: checkcast 158	org/json/JSONObject
        //   582: astore_1
        //   583: aload_1
        //   584: ldc 160
        //   586: invokevirtual 164	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   589: istore 4
        //   591: iload 4
        //   593: istore_3
        //   594: iload 4
        //   596: ifeq +9 -> 605
        //   599: iload 4
        //   601: ldc 165
        //   603: ior
        //   604: istore_3
        //   605: new 167	io/flutter/embedding/engine/c/f$a
        //   608: dup
        //   609: iload_3
        //   610: aload_1
        //   611: ldc 169
        //   613: invokevirtual 173	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   616: invokespecial 176	io/flutter/embedding/engine/c/f$a:<init>	(ILjava/lang/String;)V
        //   619: astore_1
        //   620: aload_0
        //   621: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   624: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   627: aload_1
        //   628: invokeinterface 179 2 0
        //   633: aload_2
        //   634: aconst_null
        //   635: invokeinterface 119 2 0
        //   640: sipush 10217
        //   643: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   646: return
        //   647: astore_1
        //   648: aload_2
        //   649: ldc 121
        //   651: aload_1
        //   652: invokevirtual 127	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   655: aconst_null
        //   656: invokeinterface 134 4 0
        //   661: sipush 10217
        //   664: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   667: return
        //   668: aload_1
        //   669: checkcast 146	org/json/JSONArray
        //   672: invokestatic 183	io/flutter/embedding/engine/c/f:T	(Lorg/json/JSONArray;)Ljava/util/List;
        //   675: astore_1
        //   676: aload_0
        //   677: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   680: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   683: aload_1
        //   684: invokeinterface 187 2 0
        //   689: aload_2
        //   690: aconst_null
        //   691: invokeinterface 119 2 0
        //   696: sipush 10217
        //   699: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   702: return
        //   703: aload_2
        //   704: ldc 121
        //   706: aload_1
        //   707: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   710: aconst_null
        //   711: invokeinterface 134 4 0
        //   716: sipush 10217
        //   719: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   722: return
        //   723: aload_0
        //   724: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   727: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   730: invokeinterface 190 1 0
        //   735: aload_2
        //   736: aconst_null
        //   737: invokeinterface 119 2 0
        //   742: sipush 10217
        //   745: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   748: return
        //   749: aload_1
        //   750: checkcast 158	org/json/JSONObject
        //   753: astore 9
        //   755: aload 9
        //   757: ldc 192
        //   759: invokevirtual 196	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   762: ifne +485 -> 1247
        //   765: aload 9
        //   767: ldc 192
        //   769: invokevirtual 173	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   772: invokestatic 202	io/flutter/embedding/engine/c/f$b:bbP	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$b;
        //   775: astore_1
        //   776: aload 9
        //   778: ldc 204
        //   780: invokevirtual 196	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   783: ifne +458 -> 1241
        //   786: aload 9
        //   788: ldc 204
        //   790: invokevirtual 164	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   793: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   796: astore 6
        //   798: aload 9
        //   800: ldc 212
        //   802: invokevirtual 196	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   805: ifne +430 -> 1235
        //   808: aload 9
        //   810: ldc 212
        //   812: invokevirtual 173	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   815: invokestatic 202	io/flutter/embedding/engine/c/f$b:bbP	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$b;
        //   818: astore 7
        //   820: aload 9
        //   822: ldc 214
        //   824: invokevirtual 196	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   827: ifne +402 -> 1229
        //   830: aload 9
        //   832: ldc 214
        //   834: invokevirtual 164	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   837: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   840: astore 8
        //   842: aload 9
        //   844: ldc 216
        //   846: invokevirtual 196	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   849: ifne +374 -> 1223
        //   852: aload 9
        //   854: ldc 216
        //   856: invokevirtual 164	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   859: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   862: astore 9
        //   864: new 218	io/flutter/embedding/engine/c/f$h
        //   867: dup
        //   868: aload 8
        //   870: aload 7
        //   872: aload 6
        //   874: aload_1
        //   875: aload 9
        //   877: invokespecial 221	io/flutter/embedding/engine/c/f$h:<init>	(Ljava/lang/Integer;Lio/flutter/embedding/engine/c/f$b;Ljava/lang/Integer;Lio/flutter/embedding/engine/c/f$b;Ljava/lang/Integer;)V
        //   880: astore_1
        //   881: aload_0
        //   882: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   885: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   888: aload_1
        //   889: invokeinterface 224 2 0
        //   894: aload_2
        //   895: aconst_null
        //   896: invokeinterface 119 2 0
        //   901: sipush 10217
        //   904: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   907: return
        //   908: aload_2
        //   909: ldc 121
        //   911: aload_1
        //   912: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   915: aconst_null
        //   916: invokeinterface 134 4 0
        //   921: sipush 10217
        //   924: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   927: return
        //   928: aload_0
        //   929: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   932: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   935: invokeinterface 227 1 0
        //   940: aload_2
        //   941: aconst_null
        //   942: invokeinterface 119 2 0
        //   947: sipush 10217
        //   950: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   953: return
        //   954: aload_0
        //   955: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   958: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   961: invokeinterface 231 1 0
        //   966: astore_1
        //   967: aload_1
        //   968: ifnonnull +21 -> 989
        //   971: aload_2
        //   972: ldc 121
        //   974: ldc 233
        //   976: aconst_null
        //   977: invokeinterface 134 4 0
        //   982: sipush 10217
        //   985: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   988: return
        //   989: aload_2
        //   990: aload_1
        //   991: invokestatic 237	io/flutter/embedding/engine/c/f:iX	(Ljava/util/List;)Ljava/util/ArrayList;
        //   994: invokeinterface 119 2 0
        //   999: sipush 10217
        //   1002: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1005: return
        //   1006: aload_1
        //   1007: instanceof 146
        //   1010: ifne +21 -> 1031
        //   1013: aload_2
        //   1014: ldc 239
        //   1016: ldc 241
        //   1018: aconst_null
        //   1019: invokeinterface 134 4 0
        //   1024: sipush 10217
        //   1027: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1030: return
        //   1031: aload_1
        //   1032: checkcast 146	org/json/JSONArray
        //   1035: invokestatic 245	io/flutter/embedding/engine/c/f:R	(Lorg/json/JSONArray;)Ljava/util/ArrayList;
        //   1038: astore_1
        //   1039: aload_0
        //   1040: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   1043: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   1046: aload_1
        //   1047: invokeinterface 249 2 0
        //   1052: aload_2
        //   1053: aconst_null
        //   1054: invokeinterface 119 2 0
        //   1059: sipush 10217
        //   1062: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1065: return
        //   1066: aload_1
        //   1067: checkcast 67	java/lang/String
        //   1070: astore 6
        //   1072: aload 6
        //   1074: ifnull +257 -> 1331
        //   1077: aload 6
        //   1079: invokestatic 255	io/flutter/embedding/engine/c/f$c:bbQ	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$c;
        //   1082: astore_1
        //   1083: aload_0
        //   1084: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   1087: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   1090: aload_1
        //   1091: invokeinterface 258 2 0
        //   1096: astore_1
        //   1097: aload_1
        //   1098: ifnull +61 -> 1159
        //   1101: new 158	org/json/JSONObject
        //   1104: dup
        //   1105: invokespecial 259	org/json/JSONObject:<init>	()V
        //   1108: astore 6
        //   1110: aload 6
        //   1112: ldc_w 261
        //   1115: aload_1
        //   1116: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   1119: pop
        //   1120: aload_2
        //   1121: aload 6
        //   1123: invokeinterface 119 2 0
        //   1128: sipush 10217
        //   1131: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1134: return
        //   1135: astore_1
        //   1136: aload_2
        //   1137: ldc 121
        //   1139: ldc_w 267
        //   1142: aload 6
        //   1144: invokestatic 270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   1147: invokevirtual 273	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1150: aconst_null
        //   1151: invokeinterface 134 4 0
        //   1156: goto +175 -> 1331
        //   1159: aload_2
        //   1160: aconst_null
        //   1161: invokeinterface 119 2 0
        //   1166: sipush 10217
        //   1169: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1172: return
        //   1173: aload_1
        //   1174: checkcast 158	org/json/JSONObject
        //   1177: ldc_w 261
        //   1180: invokevirtual 173	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   1183: astore_1
        //   1184: aload_0
        //   1185: getfield 14	io/flutter/embedding/engine/c/f$1:MEf	Lio/flutter/embedding/engine/c/f;
        //   1188: getfield 34	io/flutter/embedding/engine/c/f:MEd	Lio/flutter/embedding/engine/c/f$f;
        //   1191: aload_1
        //   1192: invokeinterface 276 2 0
        //   1197: aload_2
        //   1198: aconst_null
        //   1199: invokeinterface 119 2 0
        //   1204: sipush 10217
        //   1207: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1210: return
        //   1211: astore_1
        //   1212: goto -304 -> 908
        //   1215: astore_1
        //   1216: goto -513 -> 703
        //   1219: astore_1
        //   1220: goto -662 -> 558
        //   1223: aconst_null
        //   1224: astore 9
        //   1226: goto -362 -> 864
        //   1229: aconst_null
        //   1230: astore 8
        //   1232: goto -390 -> 842
        //   1235: aconst_null
        //   1236: astore 7
        //   1238: goto -418 -> 820
        //   1241: aconst_null
        //   1242: astore 6
        //   1244: goto -446 -> 798
        //   1247: aconst_null
        //   1248: astore_1
        //   1249: goto -473 -> 776
        //   1252: iload_3
        //   1253: tableswitch	default:+63 -> 1316, 0:+-878->375, 1:+-786->467, 2:+-730->523, 3:+-675->578, 4:+-585->668, 5:+-530->723, 6:+-504->749, 7:+-325->928, 8:+-299->954, 9:+-247->1006, 10:+-187->1066, 11:+-80->1173
        //   1317: <illegal opcode>
        //   1318: l2i
        //   1319: astore_1
        //   1320: goto -762 -> 558
        //   1323: astore_1
        //   1324: goto -621 -> 703
        //   1327: astore_1
        //   1328: goto -420 -> 908
        //   1331: aconst_null
        //   1332: astore_1
        //   1333: goto -250 -> 1083
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1336	0	this	1
        //   0	1336	1	paramAnonymousj	io.flutter.plugin.a.j
        //   0	1336	2	paramAnonymousd	io.flutter.plugin.a.k.d
        //   58	1195	3	i	int
        //   589	15	4	j	int
        //   362	3	5	bool	boolean
        //   27	1216	6	localObject1	Object
        //   818	419	7	localb	f.b
        //   840	391	8	localInteger	Integer
        //   753	472	9	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   59	172	410	org/json/JSONException
        //   172	178	410	org/json/JSONException
        //   185	195	410	org/json/JSONException
        //   200	210	410	org/json/JSONException
        //   215	225	410	org/json/JSONException
        //   230	240	410	org/json/JSONException
        //   245	255	410	org/json/JSONException
        //   260	270	410	org/json/JSONException
        //   275	285	410	org/json/JSONException
        //   291	301	410	org/json/JSONException
        //   307	317	410	org/json/JSONException
        //   323	333	410	org/json/JSONException
        //   339	349	410	org/json/JSONException
        //   355	364	410	org/json/JSONException
        //   375	403	410	org/json/JSONException
        //   403	409	410	org/json/JSONException
        //   447	466	410	org/json/JSONException
        //   467	495	410	org/json/JSONException
        //   495	501	410	org/json/JSONException
        //   503	522	410	org/json/JSONException
        //   551	557	410	org/json/JSONException
        //   558	577	410	org/json/JSONException
        //   640	646	410	org/json/JSONException
        //   648	667	410	org/json/JSONException
        //   696	702	410	org/json/JSONException
        //   703	722	410	org/json/JSONException
        //   723	748	410	org/json/JSONException
        //   901	907	410	org/json/JSONException
        //   908	927	410	org/json/JSONException
        //   928	953	410	org/json/JSONException
        //   954	967	410	org/json/JSONException
        //   971	988	410	org/json/JSONException
        //   989	1005	410	org/json/JSONException
        //   1006	1030	410	org/json/JSONException
        //   1031	1065	410	org/json/JSONException
        //   1066	1072	410	org/json/JSONException
        //   1077	1083	410	org/json/JSONException
        //   1083	1097	410	org/json/JSONException
        //   1101	1134	410	org/json/JSONException
        //   1136	1156	410	org/json/JSONException
        //   1159	1172	410	org/json/JSONException
        //   1173	1210	410	org/json/JSONException
        //   375	403	446	java/lang/NoSuchFieldException
        //   467	495	502	java/lang/NoSuchFieldException
        //   578	591	647	org/json/JSONException
        //   605	640	647	org/json/JSONException
        //   1077	1083	1135	java/lang/NoSuchFieldException
        //   749	776	1211	org/json/JSONException
        //   776	798	1211	org/json/JSONException
        //   798	820	1211	org/json/JSONException
        //   820	842	1211	org/json/JSONException
        //   842	864	1211	org/json/JSONException
        //   864	901	1211	org/json/JSONException
        //   668	696	1215	org/json/JSONException
        //   523	551	1219	org/json/JSONException
        //   523	551	1319	java/lang/NoSuchFieldException
        //   668	696	1323	java/lang/NoSuchFieldException
        //   749	776	1327	java/lang/NoSuchFieldException
        //   776	798	1327	java/lang/NoSuchFieldException
        //   798	820	1327	java/lang/NoSuchFieldException
        //   820	842	1327	java/lang/NoSuchFieldException
        //   842	864	1327	java/lang/NoSuchFieldException
        //   864	901	1327	java/lang/NoSuchFieldException
      }
    };
    this.vCn = new k(paramDartExecutor, "flutter/platform", g.MFU);
    this.vCn.a(this.MEe);
    AppMethodBeat.o(10242);
  }
  
  static ArrayList<Rect> R(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(213269);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      try
      {
        int j = localJSONObject.getInt("top");
        int k = localJSONObject.getInt("right");
        int m = localJSONObject.getInt("bottom");
        int n = localJSONObject.getInt("left");
        localArrayList.add(new Rect(n, j, k, m));
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray = new JSONException("Incorrect JSON data shape. To set system gesture exclusion rects, \na JSONObject with top, right, bottom and left values need to be set to int values.");
        AppMethodBeat.o(213269);
        throw paramJSONArray;
      }
    }
    AppMethodBeat.o(213269);
    return localArrayList;
  }
  
  public static final class a
  {
    public final int color;
    public final String label;
    
    public a(int paramInt, String paramString)
    {
      this.color = paramInt;
      this.label = paramString;
    }
  }
  
  public static enum d
  {
    private String MEk;
    
    static
    {
      AppMethodBeat.i(10279);
      MEo = new d("PORTRAIT_UP", 0, "DeviceOrientation.portraitUp");
      MEp = new d("PORTRAIT_DOWN", 1, "DeviceOrientation.portraitDown");
      MEq = new d("LANDSCAPE_LEFT", 2, "DeviceOrientation.landscapeLeft");
      MEr = new d("LANDSCAPE_RIGHT", 3, "DeviceOrientation.landscapeRight");
      MEs = new d[] { MEo, MEp, MEq, MEr };
      AppMethodBeat.o(10279);
    }
    
    private d(String paramString)
    {
      this.MEk = paramString;
    }
    
    static d bbR(String paramString)
    {
      AppMethodBeat.i(10278);
      d[] arrayOfd = values();
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        if (locald.MEk.equals(paramString))
        {
          AppMethodBeat.o(10278);
          return locald;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such DeviceOrientation: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10278);
      throw paramString;
    }
  }
  
  public static enum e
  {
    private final String MEk;
    
    static
    {
      AppMethodBeat.i(10252);
      MEt = new e("STANDARD", 0, null);
      MEu = new e("LIGHT_IMPACT", 1, "HapticFeedbackType.lightImpact");
      MEv = new e("MEDIUM_IMPACT", 2, "HapticFeedbackType.mediumImpact");
      MEw = new e("HEAVY_IMPACT", 3, "HapticFeedbackType.heavyImpact");
      MEx = new e("SELECTION_CLICK", 4, "HapticFeedbackType.selectionClick");
      MEy = new e[] { MEt, MEu, MEv, MEw, MEx };
      AppMethodBeat.o(10252);
    }
    
    private e(String paramString)
    {
      this.MEk = paramString;
    }
    
    static e bbS(String paramString)
    {
      AppMethodBeat.i(10251);
      e[] arrayOfe = values();
      int j = arrayOfe.length;
      int i = 0;
      while (i < j)
      {
        e locale = arrayOfe[i];
        if (((locale.MEk == null) && (paramString == null)) || ((locale.MEk != null) && (locale.MEk.equals(paramString))))
        {
          AppMethodBeat.o(10251);
          return locale;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such HapticFeedbackType: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10251);
      throw paramString;
    }
  }
  
  public static abstract interface f
  {
    public abstract CharSequence a(f.c paramc);
    
    public abstract void a(f.a parama);
    
    public abstract void a(f.e parame);
    
    public abstract void a(f.g paramg);
    
    public abstract void a(f.h paramh);
    
    public abstract void aiZ(int paramInt);
    
    public abstract void bb(ArrayList<Rect> paramArrayList);
    
    public abstract void bbT(String paramString);
    
    public abstract void gfc();
    
    public abstract void gfd();
    
    public abstract List<Rect> gfe();
    
    public abstract void iY(List<f.i> paramList);
  }
  
  public static final class h
  {
    public final Integer MEB;
    public final f.b MEC;
    public final Integer MED;
    public final f.b MEE;
    public final Integer MEF;
    
    public h(Integer paramInteger1, f.b paramb1, Integer paramInteger2, f.b paramb2, Integer paramInteger3)
    {
      this.MEB = paramInteger1;
      this.MEC = paramb1;
      this.MED = paramInteger2;
      this.MEE = paramb2;
      this.MEF = paramInteger3;
    }
  }
  
  public static enum i
  {
    private String MEk;
    
    static
    {
      AppMethodBeat.i(10232);
      MEG = new i("TOP_OVERLAYS", 0, "SystemUiOverlay.top");
      MEH = new i("BOTTOM_OVERLAYS", 1, "SystemUiOverlay.bottom");
      MEI = new i[] { MEG, MEH };
      AppMethodBeat.o(10232);
    }
    
    private i(String paramString)
    {
      this.MEk = paramString;
    }
    
    static i bbV(String paramString)
    {
      AppMethodBeat.i(10231);
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      int i = 0;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (locali.MEk.equals(paramString))
        {
          AppMethodBeat.o(10231);
          return locali;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such SystemUiOverlay: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10231);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.f
 * JD-Core Version:    0.7.0.1
 */
package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.g;
import io.flutter.a.a.k;
import io.flutter.a.a.k.c;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.List;

public final class f
{
  public f IZD;
  private final k.c IZE;
  public final k sNT;
  
  public f(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10242);
    this.IZE = new k.c()
    {
      /* Error */
      public final void a(io.flutter.a.a.j paramAnonymousj, io.flutter.a.a.k.d paramAnonymousd)
      {
        // Byte code:
        //   0: sipush 10217
        //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: aload_0
        //   7: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   10: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   13: ifnonnull +10 -> 23
        //   16: sipush 10217
        //   19: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   22: return
        //   23: aload_1
        //   24: getfield 43	io/flutter/a/a/j:method	Ljava/lang/String;
        //   27: astore 6
        //   29: aload_1
        //   30: getfield 47	io/flutter/a/a/j:fTP	Ljava/lang/Object;
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
        //   54: invokestatic 65	io/flutter/a:ftS	()V
        //   57: iconst_m1
        //   58: istore_3
        //   59: aload 6
        //   61: invokevirtual 71	java/lang/String:hashCode	()I
        //   64: lookupswitch	default:+1025->1089, -766342101:+211->275, -720677196:+243->307, -548468504:+150->214, -247230243:+120->184, -215273374:+105->169, 241845679:+180->244, 1390477857:+195->259, 1514180520:+227->291, 1674312266:+165->229, 2119655719:+135->199
        //   157: invokeinterface 76 1 0
        //   162: sipush 10217
        //   165: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   168: return
        //   169: aload 6
        //   171: ldc 78
        //   173: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   176: ifeq +913 -> 1089
        //   179: iconst_0
        //   180: istore_3
        //   181: goto +908 -> 1089
        //   184: aload 6
        //   186: ldc 84
        //   188: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   191: ifeq +898 -> 1089
        //   194: iconst_1
        //   195: istore_3
        //   196: goto +893 -> 1089
        //   199: aload 6
        //   201: ldc 86
        //   203: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   206: ifeq +883 -> 1089
        //   209: iconst_2
        //   210: istore_3
        //   211: goto +878 -> 1089
        //   214: aload 6
        //   216: ldc 88
        //   218: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   221: ifeq +868 -> 1089
        //   224: iconst_3
        //   225: istore_3
        //   226: goto +863 -> 1089
        //   229: aload 6
        //   231: ldc 90
        //   233: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   236: ifeq +853 -> 1089
        //   239: iconst_4
        //   240: istore_3
        //   241: goto +848 -> 1089
        //   244: aload 6
        //   246: ldc 92
        //   248: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   251: ifeq +838 -> 1089
        //   254: iconst_5
        //   255: istore_3
        //   256: goto +833 -> 1089
        //   259: aload 6
        //   261: ldc 94
        //   263: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   266: ifeq +823 -> 1089
        //   269: bipush 6
        //   271: istore_3
        //   272: goto +817 -> 1089
        //   275: aload 6
        //   277: ldc 96
        //   279: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   282: ifeq +807 -> 1089
        //   285: bipush 7
        //   287: istore_3
        //   288: goto +801 -> 1089
        //   291: aload 6
        //   293: ldc 98
        //   295: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   298: ifeq +791 -> 1089
        //   301: bipush 8
        //   303: istore_3
        //   304: goto +785 -> 1089
        //   307: aload 6
        //   309: ldc 100
        //   311: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   314: istore 5
        //   316: iload 5
        //   318: ifeq +771 -> 1089
        //   321: bipush 9
        //   323: istore_3
        //   324: goto +765 -> 1089
        //   327: aload_1
        //   328: checkcast 67	java/lang/String
        //   331: invokestatic 106	io/flutter/embedding/engine/c/f$g:aPT	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$g;
        //   334: astore_1
        //   335: aload_0
        //   336: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   339: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   342: aload_1
        //   343: invokeinterface 111 2 0
        //   348: aload_2
        //   349: aconst_null
        //   350: invokeinterface 115 2 0
        //   355: sipush 10217
        //   358: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   361: return
        //   362: astore_1
        //   363: aload_2
        //   364: ldc 117
        //   366: new 49	java/lang/StringBuilder
        //   369: dup
        //   370: ldc 119
        //   372: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   375: aload_1
        //   376: invokevirtual 123	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   379: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   382: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   385: aconst_null
        //   386: invokeinterface 129 4 0
        //   391: sipush 10217
        //   394: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   397: return
        //   398: astore_1
        //   399: aload_2
        //   400: ldc 117
        //   402: aload_1
        //   403: invokevirtual 130	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   406: aconst_null
        //   407: invokeinterface 129 4 0
        //   412: sipush 10217
        //   415: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   418: return
        //   419: aload_1
        //   420: checkcast 67	java/lang/String
        //   423: invokestatic 136	io/flutter/embedding/engine/c/f$e:aPR	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$e;
        //   426: astore_1
        //   427: aload_0
        //   428: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   431: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   434: aload_1
        //   435: invokeinterface 139 2 0
        //   440: aload_2
        //   441: aconst_null
        //   442: invokeinterface 115 2 0
        //   447: sipush 10217
        //   450: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   453: return
        //   454: astore_1
        //   455: aload_2
        //   456: ldc 117
        //   458: aload_1
        //   459: invokevirtual 130	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   462: aconst_null
        //   463: invokeinterface 129 4 0
        //   468: sipush 10217
        //   471: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   474: return
        //   475: aload_1
        //   476: checkcast 141	org/json/JSONArray
        //   479: invokestatic 145	io/flutter/embedding/engine/c/f:Q	(Lorg/json/JSONArray;)I
        //   482: istore_3
        //   483: aload_0
        //   484: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   487: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   490: iload_3
        //   491: invokeinterface 148 2 0
        //   496: aload_2
        //   497: aconst_null
        //   498: invokeinterface 115 2 0
        //   503: sipush 10217
        //   506: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   509: return
        //   510: aload_2
        //   511: ldc 117
        //   513: aload_1
        //   514: invokevirtual 151	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   517: aconst_null
        //   518: invokeinterface 129 4 0
        //   523: sipush 10217
        //   526: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   529: return
        //   530: aload_1
        //   531: checkcast 153	org/json/JSONObject
        //   534: astore_1
        //   535: aload_1
        //   536: ldc 155
        //   538: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   541: istore 4
        //   543: iload 4
        //   545: istore_3
        //   546: iload 4
        //   548: ifeq +9 -> 557
        //   551: iload 4
        //   553: ldc 160
        //   555: ior
        //   556: istore_3
        //   557: new 162	io/flutter/embedding/engine/c/f$a
        //   560: dup
        //   561: iload_3
        //   562: aload_1
        //   563: ldc 164
        //   565: invokevirtual 168	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   568: invokespecial 171	io/flutter/embedding/engine/c/f$a:<init>	(ILjava/lang/String;)V
        //   571: astore_1
        //   572: aload_0
        //   573: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   576: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   579: aload_1
        //   580: invokeinterface 174 2 0
        //   585: aload_2
        //   586: aconst_null
        //   587: invokeinterface 115 2 0
        //   592: sipush 10217
        //   595: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   598: return
        //   599: astore_1
        //   600: aload_2
        //   601: ldc 117
        //   603: aload_1
        //   604: invokevirtual 123	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   607: aconst_null
        //   608: invokeinterface 129 4 0
        //   613: sipush 10217
        //   616: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   619: return
        //   620: aload_1
        //   621: checkcast 141	org/json/JSONArray
        //   624: invokestatic 178	io/flutter/embedding/engine/c/f:R	(Lorg/json/JSONArray;)Ljava/util/List;
        //   627: astore_1
        //   628: aload_0
        //   629: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   632: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   635: aload_1
        //   636: invokeinterface 182 2 0
        //   641: aload_2
        //   642: aconst_null
        //   643: invokeinterface 115 2 0
        //   648: sipush 10217
        //   651: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   654: return
        //   655: aload_2
        //   656: ldc 117
        //   658: aload_1
        //   659: invokevirtual 151	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   662: aconst_null
        //   663: invokeinterface 129 4 0
        //   668: sipush 10217
        //   671: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   674: return
        //   675: aload_0
        //   676: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   679: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   682: invokeinterface 185 1 0
        //   687: aload_2
        //   688: aconst_null
        //   689: invokeinterface 115 2 0
        //   694: sipush 10217
        //   697: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   700: return
        //   701: aload_1
        //   702: checkcast 153	org/json/JSONObject
        //   705: astore 9
        //   707: aload 9
        //   709: ldc 187
        //   711: invokevirtual 191	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   714: ifne +370 -> 1084
        //   717: aload 9
        //   719: ldc 187
        //   721: invokevirtual 168	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   724: invokestatic 197	io/flutter/embedding/engine/c/f$b:aPO	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$b;
        //   727: astore_1
        //   728: aload 9
        //   730: ldc 199
        //   732: invokevirtual 191	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   735: ifne +343 -> 1078
        //   738: aload 9
        //   740: ldc 199
        //   742: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   745: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   748: astore 6
        //   750: aload 9
        //   752: ldc 207
        //   754: invokevirtual 191	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   757: ifne +315 -> 1072
        //   760: aload 9
        //   762: ldc 207
        //   764: invokevirtual 168	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   767: invokestatic 197	io/flutter/embedding/engine/c/f$b:aPO	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$b;
        //   770: astore 7
        //   772: aload 9
        //   774: ldc 209
        //   776: invokevirtual 191	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   779: ifne +287 -> 1066
        //   782: aload 9
        //   784: ldc 209
        //   786: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   789: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   792: astore 8
        //   794: aload 9
        //   796: ldc 211
        //   798: invokevirtual 191	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   801: ifne +259 -> 1060
        //   804: aload 9
        //   806: ldc 211
        //   808: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   811: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   814: astore 9
        //   816: new 213	io/flutter/embedding/engine/c/f$h
        //   819: dup
        //   820: aload 8
        //   822: aload 7
        //   824: aload 6
        //   826: aload_1
        //   827: aload 9
        //   829: invokespecial 216	io/flutter/embedding/engine/c/f$h:<init>	(Ljava/lang/Integer;Lio/flutter/embedding/engine/c/f$b;Ljava/lang/Integer;Lio/flutter/embedding/engine/c/f$b;Ljava/lang/Integer;)V
        //   832: astore_1
        //   833: aload_0
        //   834: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   837: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   840: aload_1
        //   841: invokeinterface 219 2 0
        //   846: aload_2
        //   847: aconst_null
        //   848: invokeinterface 115 2 0
        //   853: sipush 10217
        //   856: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   859: return
        //   860: aload_2
        //   861: ldc 117
        //   863: aload_1
        //   864: invokevirtual 151	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   867: aconst_null
        //   868: invokeinterface 129 4 0
        //   873: sipush 10217
        //   876: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   879: return
        //   880: aload_0
        //   881: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   884: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   887: invokeinterface 222 1 0
        //   892: aload_2
        //   893: aconst_null
        //   894: invokeinterface 115 2 0
        //   899: sipush 10217
        //   902: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   905: return
        //   906: aload_1
        //   907: checkcast 67	java/lang/String
        //   910: astore 6
        //   912: aload 6
        //   914: ifnull +245 -> 1159
        //   917: aload 6
        //   919: invokestatic 228	io/flutter/embedding/engine/c/f$c:aPP	(Ljava/lang/String;)Lio/flutter/embedding/engine/c/f$c;
        //   922: astore_1
        //   923: aload_0
        //   924: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   927: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   930: aload_1
        //   931: invokeinterface 231 2 0
        //   936: astore_1
        //   937: aload_1
        //   938: ifnull +59 -> 997
        //   941: new 153	org/json/JSONObject
        //   944: dup
        //   945: invokespecial 232	org/json/JSONObject:<init>	()V
        //   948: astore 6
        //   950: aload 6
        //   952: ldc 234
        //   954: aload_1
        //   955: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   958: pop
        //   959: aload_2
        //   960: aload 6
        //   962: invokeinterface 115 2 0
        //   967: sipush 10217
        //   970: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   973: return
        //   974: astore_1
        //   975: aload_2
        //   976: ldc 117
        //   978: ldc 240
        //   980: aload 6
        //   982: invokestatic 243	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   985: invokevirtual 246	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   988: aconst_null
        //   989: invokeinterface 129 4 0
        //   994: goto +165 -> 1159
        //   997: aload_2
        //   998: aconst_null
        //   999: invokeinterface 115 2 0
        //   1004: sipush 10217
        //   1007: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1010: return
        //   1011: aload_1
        //   1012: checkcast 153	org/json/JSONObject
        //   1015: ldc 234
        //   1017: invokevirtual 168	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   1020: astore_1
        //   1021: aload_0
        //   1022: getfield 14	io/flutter/embedding/engine/c/f$1:IZF	Lio/flutter/embedding/engine/c/f;
        //   1025: getfield 34	io/flutter/embedding/engine/c/f:IZD	Lio/flutter/embedding/engine/c/f$f;
        //   1028: aload_1
        //   1029: invokeinterface 249 2 0
        //   1034: aload_2
        //   1035: aconst_null
        //   1036: invokeinterface 115 2 0
        //   1041: sipush 10217
        //   1044: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1047: return
        //   1048: astore_1
        //   1049: goto -189 -> 860
        //   1052: astore_1
        //   1053: goto -398 -> 655
        //   1056: astore_1
        //   1057: goto -547 -> 510
        //   1060: aconst_null
        //   1061: astore 9
        //   1063: goto -247 -> 816
        //   1066: aconst_null
        //   1067: astore 8
        //   1069: goto -275 -> 794
        //   1072: aconst_null
        //   1073: astore 7
        //   1075: goto -303 -> 772
        //   1078: aconst_null
        //   1079: astore 6
        //   1081: goto -331 -> 750
        //   1084: aconst_null
        //   1085: astore_1
        //   1086: goto -358 -> 728
        //   1089: iload_3
        //   1090: tableswitch	default:+54 -> 1144, 0:+-763->327, 1:+-671->419, 2:+-615->475, 3:+-560->530, 4:+-470->620, 5:+-415->675, 6:+-389->701, 7:+-210->880, 8:+-184->906, 9:+-79->1011
        //   1145: <illegal opcode>
        //   1146: fload_2
        //   1147: astore_1
        //   1148: goto -638 -> 510
        //   1151: astore_1
        //   1152: goto -497 -> 655
        //   1155: astore_1
        //   1156: goto -296 -> 860
        //   1159: aconst_null
        //   1160: astore_1
        //   1161: goto -238 -> 923
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1164	0	this	1
        //   0	1164	1	paramAnonymousj	io.flutter.a.a.j
        //   0	1164	2	paramAnonymousd	io.flutter.a.a.k.d
        //   58	1032	3	i	int
        //   541	15	4	j	int
        //   314	3	5	bool	boolean
        //   27	1053	6	localObject1	Object
        //   770	304	7	localb	f.b
        //   792	276	8	localInteger	Integer
        //   705	357	9	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   59	156	362	org/json/JSONException
        //   156	162	362	org/json/JSONException
        //   169	179	362	org/json/JSONException
        //   184	194	362	org/json/JSONException
        //   199	209	362	org/json/JSONException
        //   214	224	362	org/json/JSONException
        //   229	239	362	org/json/JSONException
        //   244	254	362	org/json/JSONException
        //   259	269	362	org/json/JSONException
        //   275	285	362	org/json/JSONException
        //   291	301	362	org/json/JSONException
        //   307	316	362	org/json/JSONException
        //   327	355	362	org/json/JSONException
        //   355	361	362	org/json/JSONException
        //   399	418	362	org/json/JSONException
        //   419	447	362	org/json/JSONException
        //   447	453	362	org/json/JSONException
        //   455	474	362	org/json/JSONException
        //   503	509	362	org/json/JSONException
        //   510	529	362	org/json/JSONException
        //   592	598	362	org/json/JSONException
        //   600	619	362	org/json/JSONException
        //   648	654	362	org/json/JSONException
        //   655	674	362	org/json/JSONException
        //   675	700	362	org/json/JSONException
        //   853	859	362	org/json/JSONException
        //   860	879	362	org/json/JSONException
        //   880	905	362	org/json/JSONException
        //   906	912	362	org/json/JSONException
        //   917	923	362	org/json/JSONException
        //   923	937	362	org/json/JSONException
        //   941	973	362	org/json/JSONException
        //   975	994	362	org/json/JSONException
        //   997	1010	362	org/json/JSONException
        //   1011	1047	362	org/json/JSONException
        //   327	355	398	java/lang/NoSuchFieldException
        //   419	447	454	java/lang/NoSuchFieldException
        //   530	543	599	org/json/JSONException
        //   557	592	599	org/json/JSONException
        //   917	923	974	java/lang/NoSuchFieldException
        //   701	728	1048	org/json/JSONException
        //   728	750	1048	org/json/JSONException
        //   750	772	1048	org/json/JSONException
        //   772	794	1048	org/json/JSONException
        //   794	816	1048	org/json/JSONException
        //   816	853	1048	org/json/JSONException
        //   620	648	1052	org/json/JSONException
        //   475	503	1056	org/json/JSONException
        //   475	503	1147	java/lang/NoSuchFieldException
        //   620	648	1151	java/lang/NoSuchFieldException
        //   701	728	1155	java/lang/NoSuchFieldException
        //   728	750	1155	java/lang/NoSuchFieldException
        //   750	772	1155	java/lang/NoSuchFieldException
        //   772	794	1155	java/lang/NoSuchFieldException
        //   794	816	1155	java/lang/NoSuchFieldException
        //   816	853	1155	java/lang/NoSuchFieldException
      }
    };
    this.sNT = new k(paramDartExecutor, "flutter/platform", g.Jbt);
    this.sNT.a(this.IZE);
    AppMethodBeat.o(10242);
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
  
  public static enum b
  {
    private String IZK;
    
    static
    {
      AppMethodBeat.i(10228);
      IZI = new b("LIGHT", 0, "Brightness.light");
      IZJ = new b("DARK", 1, "Brightness.dark");
      IZL = new b[] { IZI, IZJ };
      AppMethodBeat.o(10228);
    }
    
    private b(String paramString)
    {
      this.IZK = paramString;
    }
    
    static b aPO(String paramString)
    {
      AppMethodBeat.i(10227);
      b[] arrayOfb = values();
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        b localb = arrayOfb[i];
        if (localb.IZK.equals(paramString))
        {
          AppMethodBeat.o(10227);
          return localb;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such Brightness: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10227);
      throw paramString;
    }
  }
  
  public static enum d
  {
    private String IZK;
    
    static
    {
      AppMethodBeat.i(10279);
      IZO = new d("PORTRAIT_UP", 0, "DeviceOrientation.portraitUp");
      IZP = new d("PORTRAIT_DOWN", 1, "DeviceOrientation.portraitDown");
      IZQ = new d("LANDSCAPE_LEFT", 2, "DeviceOrientation.landscapeLeft");
      IZR = new d("LANDSCAPE_RIGHT", 3, "DeviceOrientation.landscapeRight");
      IZS = new d[] { IZO, IZP, IZQ, IZR };
      AppMethodBeat.o(10279);
    }
    
    private d(String paramString)
    {
      this.IZK = paramString;
    }
    
    static d aPQ(String paramString)
    {
      AppMethodBeat.i(10278);
      d[] arrayOfd = values();
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        if (locald.IZK.equals(paramString))
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
    private final String IZK;
    
    static
    {
      AppMethodBeat.i(10252);
      IZT = new e("STANDARD", 0, null);
      IZU = new e("LIGHT_IMPACT", 1, "HapticFeedbackType.lightImpact");
      IZV = new e("MEDIUM_IMPACT", 2, "HapticFeedbackType.mediumImpact");
      IZW = new e("HEAVY_IMPACT", 3, "HapticFeedbackType.heavyImpact");
      IZX = new e("SELECTION_CLICK", 4, "HapticFeedbackType.selectionClick");
      IZY = new e[] { IZT, IZU, IZV, IZW, IZX };
      AppMethodBeat.o(10252);
    }
    
    private e(String paramString)
    {
      this.IZK = paramString;
    }
    
    static e aPR(String paramString)
    {
      AppMethodBeat.i(10251);
      e[] arrayOfe = values();
      int j = arrayOfe.length;
      int i = 0;
      while (i < j)
      {
        e locale = arrayOfe[i];
        if (((locale.IZK == null) && (paramString == null)) || ((locale.IZK != null) && (locale.IZK.equals(paramString))))
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
    
    public abstract void aPS(String paramString);
    
    public abstract void adD(int paramInt);
    
    public abstract void fuY();
    
    public abstract void fuZ();
    
    public abstract void iu(List<f.i> paramList);
  }
  
  public static enum g
  {
    private final String IZK;
    
    static
    {
      AppMethodBeat.i(10289);
      IZZ = new g("CLICK", "SystemSoundType.click");
      Jaa = new g[] { IZZ };
      AppMethodBeat.o(10289);
    }
    
    private g(String paramString)
    {
      Object localObject;
      this.IZK = localObject;
    }
    
    static g aPT(String paramString)
    {
      AppMethodBeat.i(10288);
      g[] arrayOfg = values();
      int j = arrayOfg.length;
      int i = 0;
      while (i < j)
      {
        g localg = arrayOfg[i];
        if (localg.IZK.equals(paramString))
        {
          AppMethodBeat.o(10288);
          return localg;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such SoundType: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10288);
      throw paramString;
    }
  }
  
  public static final class h
  {
    public final Integer Jab;
    public final f.b Jac;
    public final Integer Jad;
    public final f.b Jae;
    public final Integer Jaf;
    
    public h(Integer paramInteger1, f.b paramb1, Integer paramInteger2, f.b paramb2, Integer paramInteger3)
    {
      this.Jab = paramInteger1;
      this.Jac = paramb1;
      this.Jad = paramInteger2;
      this.Jae = paramb2;
      this.Jaf = paramInteger3;
    }
  }
  
  public static enum i
  {
    private String IZK;
    
    static
    {
      AppMethodBeat.i(10232);
      Jag = new i("TOP_OVERLAYS", 0, "SystemUiOverlay.top");
      Jah = new i("BOTTOM_OVERLAYS", 1, "SystemUiOverlay.bottom");
      Jai = new i[] { Jag, Jah };
      AppMethodBeat.o(10232);
    }
    
    private i(String paramString)
    {
      this.IZK = paramString;
    }
    
    static i aPU(String paramString)
    {
      AppMethodBeat.i(10231);
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      int i = 0;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (locali.IZK.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.f
 * JD-Core Version:    0.7.0.1
 */
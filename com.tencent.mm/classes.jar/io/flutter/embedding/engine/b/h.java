package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import java.util.List;

public final class h
{
  public final k aKT;
  public f aasA;
  final k.c aasy;
  
  public h(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10242);
    this.aasy = new k.c()
    {
      /* Error */
      public final void a(io.flutter.plugin.a.j paramAnonymousj, io.flutter.plugin.a.k.d paramAnonymousd)
      {
        // Byte code:
        //   0: sipush 10217
        //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: aload_0
        //   7: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   10: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   13: ifnonnull +10 -> 23
        //   16: sipush 10217
        //   19: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   22: return
        //   23: aload_1
        //   24: getfield 43	io/flutter/plugin/a/j:method	Ljava/lang/String;
        //   27: astore 6
        //   29: aload_1
        //   30: getfield 47	io/flutter/plugin/a/j:ZZe	Ljava/lang/Object;
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
        //   54: invokestatic 65	io/flutter/b:iAd	()V
        //   57: iconst_m1
        //   58: istore_3
        //   59: aload 6
        //   61: invokevirtual 71	java/lang/String:hashCode	()I
        //   64: lookupswitch	default:+1095->1159, -766342101:+219->283, -720677196:+251->315, -548468504:+158->222, -247230243:+128->192, -215273374:+113->177, 241845679:+188->252, 875995648:+267->331, 1390477857:+203->267, 1514180520:+235->299, 1674312266:+173->237, 2119655719:+143->207
        //   165: invokeinterface 76 1 0
        //   170: sipush 10217
        //   173: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   176: return
        //   177: aload 6
        //   179: ldc 78
        //   181: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   184: ifeq +975 -> 1159
        //   187: iconst_0
        //   188: istore_3
        //   189: goto +970 -> 1159
        //   192: aload 6
        //   194: ldc 84
        //   196: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   199: ifeq +960 -> 1159
        //   202: iconst_1
        //   203: istore_3
        //   204: goto +955 -> 1159
        //   207: aload 6
        //   209: ldc 86
        //   211: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   214: ifeq +945 -> 1159
        //   217: iconst_2
        //   218: istore_3
        //   219: goto +940 -> 1159
        //   222: aload 6
        //   224: ldc 88
        //   226: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   229: ifeq +930 -> 1159
        //   232: iconst_3
        //   233: istore_3
        //   234: goto +925 -> 1159
        //   237: aload 6
        //   239: ldc 90
        //   241: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   244: ifeq +915 -> 1159
        //   247: iconst_4
        //   248: istore_3
        //   249: goto +910 -> 1159
        //   252: aload 6
        //   254: ldc 92
        //   256: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   259: ifeq +900 -> 1159
        //   262: iconst_5
        //   263: istore_3
        //   264: goto +895 -> 1159
        //   267: aload 6
        //   269: ldc 94
        //   271: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   274: ifeq +885 -> 1159
        //   277: bipush 6
        //   279: istore_3
        //   280: goto +879 -> 1159
        //   283: aload 6
        //   285: ldc 96
        //   287: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   290: ifeq +869 -> 1159
        //   293: bipush 7
        //   295: istore_3
        //   296: goto +863 -> 1159
        //   299: aload 6
        //   301: ldc 98
        //   303: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   306: ifeq +853 -> 1159
        //   309: bipush 8
        //   311: istore_3
        //   312: goto +847 -> 1159
        //   315: aload 6
        //   317: ldc 100
        //   319: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   322: ifeq +837 -> 1159
        //   325: bipush 9
        //   327: istore_3
        //   328: goto +831 -> 1159
        //   331: aload 6
        //   333: ldc 102
        //   335: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   338: istore 5
        //   340: iload 5
        //   342: ifeq +817 -> 1159
        //   345: bipush 10
        //   347: istore_3
        //   348: goto +811 -> 1159
        //   351: aload_1
        //   352: checkcast 67	java/lang/String
        //   355: invokestatic 108	io/flutter/embedding/engine/b/h$g:bGp	(Ljava/lang/String;)Lio/flutter/embedding/engine/b/h$g;
        //   358: astore_1
        //   359: aload_0
        //   360: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   363: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   366: aload_1
        //   367: invokeinterface 113 2 0
        //   372: aload_2
        //   373: aconst_null
        //   374: invokeinterface 117 2 0
        //   379: sipush 10217
        //   382: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   385: return
        //   386: astore_1
        //   387: aload_2
        //   388: ldc 119
        //   390: new 49	java/lang/StringBuilder
        //   393: dup
        //   394: ldc 121
        //   396: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   399: aload_1
        //   400: invokevirtual 125	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   403: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   406: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   409: aconst_null
        //   410: invokeinterface 132 4 0
        //   415: sipush 10217
        //   418: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   421: return
        //   422: astore_1
        //   423: aload_2
        //   424: ldc 119
        //   426: aload_1
        //   427: invokevirtual 133	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   430: aconst_null
        //   431: invokeinterface 132 4 0
        //   436: sipush 10217
        //   439: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   442: return
        //   443: aload_1
        //   444: checkcast 67	java/lang/String
        //   447: invokestatic 139	io/flutter/embedding/engine/b/h$e:bGn	(Ljava/lang/String;)Lio/flutter/embedding/engine/b/h$e;
        //   450: astore_1
        //   451: aload_0
        //   452: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   455: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   458: aload_1
        //   459: invokeinterface 142 2 0
        //   464: aload_2
        //   465: aconst_null
        //   466: invokeinterface 117 2 0
        //   471: sipush 10217
        //   474: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   477: return
        //   478: astore_1
        //   479: aload_2
        //   480: ldc 119
        //   482: aload_1
        //   483: invokevirtual 133	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
        //   486: aconst_null
        //   487: invokeinterface 132 4 0
        //   492: sipush 10217
        //   495: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   498: return
        //   499: aload_1
        //   500: checkcast 144	org/json/JSONArray
        //   503: invokestatic 148	io/flutter/embedding/engine/b/h:Z	(Lorg/json/JSONArray;)I
        //   506: istore_3
        //   507: aload_0
        //   508: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   511: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   514: iload_3
        //   515: invokeinterface 151 2 0
        //   520: aload_2
        //   521: aconst_null
        //   522: invokeinterface 117 2 0
        //   527: sipush 10217
        //   530: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   533: return
        //   534: aload_2
        //   535: ldc 119
        //   537: aload_1
        //   538: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   541: aconst_null
        //   542: invokeinterface 132 4 0
        //   547: sipush 10217
        //   550: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   553: return
        //   554: aload_1
        //   555: checkcast 156	org/json/JSONObject
        //   558: astore_1
        //   559: aload_1
        //   560: ldc 158
        //   562: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   565: istore 4
        //   567: iload 4
        //   569: istore_3
        //   570: iload 4
        //   572: ifeq +9 -> 581
        //   575: iload 4
        //   577: ldc 163
        //   579: ior
        //   580: istore_3
        //   581: new 165	io/flutter/embedding/engine/b/h$a
        //   584: dup
        //   585: iload_3
        //   586: aload_1
        //   587: ldc 167
        //   589: invokevirtual 171	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   592: invokespecial 174	io/flutter/embedding/engine/b/h$a:<init>	(ILjava/lang/String;)V
        //   595: astore_1
        //   596: aload_0
        //   597: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   600: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   603: aload_1
        //   604: invokeinterface 177 2 0
        //   609: aload_2
        //   610: aconst_null
        //   611: invokeinterface 117 2 0
        //   616: sipush 10217
        //   619: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   622: return
        //   623: astore_1
        //   624: aload_2
        //   625: ldc 119
        //   627: aload_1
        //   628: invokevirtual 125	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   631: aconst_null
        //   632: invokeinterface 132 4 0
        //   637: sipush 10217
        //   640: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   643: return
        //   644: aload_1
        //   645: checkcast 144	org/json/JSONArray
        //   648: invokestatic 181	io/flutter/embedding/engine/b/h:aa	(Lorg/json/JSONArray;)Ljava/util/List;
        //   651: astore_1
        //   652: aload_0
        //   653: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   656: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   659: aload_1
        //   660: invokeinterface 185 2 0
        //   665: aload_2
        //   666: aconst_null
        //   667: invokeinterface 117 2 0
        //   672: sipush 10217
        //   675: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   678: return
        //   679: aload_2
        //   680: ldc 119
        //   682: aload_1
        //   683: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   686: aconst_null
        //   687: invokeinterface 132 4 0
        //   692: sipush 10217
        //   695: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   698: return
        //   699: aload_0
        //   700: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   703: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   706: invokeinterface 188 1 0
        //   711: aload_2
        //   712: aconst_null
        //   713: invokeinterface 117 2 0
        //   718: sipush 10217
        //   721: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   724: return
        //   725: aload_1
        //   726: checkcast 156	org/json/JSONObject
        //   729: astore 9
        //   731: aload 9
        //   733: ldc 190
        //   735: invokevirtual 194	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   738: ifne +416 -> 1154
        //   741: aload 9
        //   743: ldc 190
        //   745: invokevirtual 171	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   748: invokestatic 200	io/flutter/embedding/engine/b/h$b:bGk	(Ljava/lang/String;)Lio/flutter/embedding/engine/b/h$b;
        //   751: astore_1
        //   752: aload 9
        //   754: ldc 202
        //   756: invokevirtual 194	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   759: ifne +389 -> 1148
        //   762: aload 9
        //   764: ldc 202
        //   766: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   769: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   772: astore 6
        //   774: aload 9
        //   776: ldc 210
        //   778: invokevirtual 194	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   781: ifne +361 -> 1142
        //   784: aload 9
        //   786: ldc 210
        //   788: invokevirtual 171	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   791: invokestatic 200	io/flutter/embedding/engine/b/h$b:bGk	(Ljava/lang/String;)Lio/flutter/embedding/engine/b/h$b;
        //   794: astore 7
        //   796: aload 9
        //   798: ldc 212
        //   800: invokevirtual 194	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   803: ifne +333 -> 1136
        //   806: aload 9
        //   808: ldc 212
        //   810: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   813: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   816: astore 8
        //   818: aload 9
        //   820: ldc 214
        //   822: invokevirtual 194	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   825: ifne +305 -> 1130
        //   828: aload 9
        //   830: ldc 214
        //   832: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   835: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   838: astore 9
        //   840: new 216	io/flutter/embedding/engine/b/h$h
        //   843: dup
        //   844: aload 8
        //   846: aload 7
        //   848: aload 6
        //   850: aload_1
        //   851: aload 9
        //   853: invokespecial 219	io/flutter/embedding/engine/b/h$h:<init>	(Ljava/lang/Integer;Lio/flutter/embedding/engine/b/h$b;Ljava/lang/Integer;Lio/flutter/embedding/engine/b/h$b;Ljava/lang/Integer;)V
        //   856: astore_1
        //   857: aload_0
        //   858: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   861: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   864: aload_1
        //   865: invokeinterface 222 2 0
        //   870: aload_2
        //   871: aconst_null
        //   872: invokeinterface 117 2 0
        //   877: sipush 10217
        //   880: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   883: return
        //   884: aload_2
        //   885: ldc 119
        //   887: aload_1
        //   888: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   891: aconst_null
        //   892: invokeinterface 132 4 0
        //   897: sipush 10217
        //   900: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   903: return
        //   904: aload_0
        //   905: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   908: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   911: invokeinterface 225 1 0
        //   916: aload_2
        //   917: aconst_null
        //   918: invokeinterface 117 2 0
        //   923: sipush 10217
        //   926: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   929: return
        //   930: aload_1
        //   931: checkcast 67	java/lang/String
        //   934: astore 6
        //   936: aload 6
        //   938: ifnull +297 -> 1235
        //   941: aload 6
        //   943: invokestatic 231	io/flutter/embedding/engine/b/h$c:bGl	(Ljava/lang/String;)Lio/flutter/embedding/engine/b/h$c;
        //   946: astore_1
        //   947: aload_0
        //   948: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   951: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   954: aload_1
        //   955: invokeinterface 234 2 0
        //   960: astore_1
        //   961: aload_1
        //   962: ifnull +59 -> 1021
        //   965: new 156	org/json/JSONObject
        //   968: dup
        //   969: invokespecial 235	org/json/JSONObject:<init>	()V
        //   972: astore 6
        //   974: aload 6
        //   976: ldc 237
        //   978: aload_1
        //   979: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   982: pop
        //   983: aload_2
        //   984: aload 6
        //   986: invokeinterface 117 2 0
        //   991: sipush 10217
        //   994: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   997: return
        //   998: astore_1
        //   999: aload_2
        //   1000: ldc 119
        //   1002: ldc 243
        //   1004: aload 6
        //   1006: invokestatic 246	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   1009: invokevirtual 249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1012: aconst_null
        //   1013: invokeinterface 132 4 0
        //   1018: goto +217 -> 1235
        //   1021: aload_2
        //   1022: aconst_null
        //   1023: invokeinterface 117 2 0
        //   1028: sipush 10217
        //   1031: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1034: return
        //   1035: aload_1
        //   1036: checkcast 156	org/json/JSONObject
        //   1039: ldc 237
        //   1041: invokevirtual 171	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   1044: astore_1
        //   1045: aload_0
        //   1046: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   1049: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   1052: aload_1
        //   1053: invokeinterface 252 2 0
        //   1058: aload_2
        //   1059: aconst_null
        //   1060: invokeinterface 117 2 0
        //   1065: sipush 10217
        //   1068: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1071: return
        //   1072: aload_0
        //   1073: getfield 14	io/flutter/embedding/engine/b/h$1:aasB	Lio/flutter/embedding/engine/b/h;
        //   1076: getfield 34	io/flutter/embedding/engine/b/h:aasA	Lio/flutter/embedding/engine/b/h$f;
        //   1079: invokeinterface 256 1 0
        //   1084: istore 5
        //   1086: new 156	org/json/JSONObject
        //   1089: dup
        //   1090: invokespecial 235	org/json/JSONObject:<init>	()V
        //   1093: astore_1
        //   1094: aload_1
        //   1095: ldc_w 258
        //   1098: iload 5
        //   1100: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
        //   1103: pop
        //   1104: aload_2
        //   1105: aload_1
        //   1106: invokeinterface 117 2 0
        //   1111: sipush 10217
        //   1114: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1117: return
        //   1118: astore_1
        //   1119: goto -235 -> 884
        //   1122: astore_1
        //   1123: goto -444 -> 679
        //   1126: astore_1
        //   1127: goto -593 -> 534
        //   1130: aconst_null
        //   1131: astore 9
        //   1133: goto -293 -> 840
        //   1136: aconst_null
        //   1137: astore 8
        //   1139: goto -321 -> 818
        //   1142: aconst_null
        //   1143: astore 7
        //   1145: goto -349 -> 796
        //   1148: aconst_null
        //   1149: astore 6
        //   1151: goto -377 -> 774
        //   1154: aconst_null
        //   1155: astore_1
        //   1156: goto -404 -> 752
        //   1159: iload_3
        //   1160: tableswitch	default:+60 -> 1220, 0:+-809->351, 1:+-717->443, 2:+-661->499, 3:+-606->554, 4:+-516->644, 5:+-461->699, 6:+-435->725, 7:+-256->904, 8:+-230->930, 9:+-125->1035, 10:+-88->1072
        //   1221: <illegal opcode>
        //   1222: <illegal opcode>
        //   1223: astore_1
        //   1224: goto -690 -> 534
        //   1227: astore_1
        //   1228: goto -549 -> 679
        //   1231: astore_1
        //   1232: goto -348 -> 884
        //   1235: aconst_null
        //   1236: astore_1
        //   1237: goto -290 -> 947
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1240	0	this	1
        //   0	1240	1	paramAnonymousj	io.flutter.plugin.a.j
        //   0	1240	2	paramAnonymousd	io.flutter.plugin.a.k.d
        //   58	1102	3	i	int
        //   565	15	4	j	int
        //   338	761	5	bool	boolean
        //   27	1123	6	localObject1	Object
        //   794	350	7	localb	h.b
        //   816	322	8	localInteger	Integer
        //   729	403	9	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   59	164	386	org/json/JSONException
        //   164	170	386	org/json/JSONException
        //   177	187	386	org/json/JSONException
        //   192	202	386	org/json/JSONException
        //   207	217	386	org/json/JSONException
        //   222	232	386	org/json/JSONException
        //   237	247	386	org/json/JSONException
        //   252	262	386	org/json/JSONException
        //   267	277	386	org/json/JSONException
        //   283	293	386	org/json/JSONException
        //   299	309	386	org/json/JSONException
        //   315	325	386	org/json/JSONException
        //   331	340	386	org/json/JSONException
        //   351	379	386	org/json/JSONException
        //   379	385	386	org/json/JSONException
        //   423	442	386	org/json/JSONException
        //   443	471	386	org/json/JSONException
        //   471	477	386	org/json/JSONException
        //   479	498	386	org/json/JSONException
        //   527	533	386	org/json/JSONException
        //   534	553	386	org/json/JSONException
        //   616	622	386	org/json/JSONException
        //   624	643	386	org/json/JSONException
        //   672	678	386	org/json/JSONException
        //   679	698	386	org/json/JSONException
        //   699	724	386	org/json/JSONException
        //   877	883	386	org/json/JSONException
        //   884	903	386	org/json/JSONException
        //   904	929	386	org/json/JSONException
        //   930	936	386	org/json/JSONException
        //   941	947	386	org/json/JSONException
        //   947	961	386	org/json/JSONException
        //   965	997	386	org/json/JSONException
        //   999	1018	386	org/json/JSONException
        //   1021	1034	386	org/json/JSONException
        //   1035	1071	386	org/json/JSONException
        //   1072	1117	386	org/json/JSONException
        //   351	379	422	java/lang/NoSuchFieldException
        //   443	471	478	java/lang/NoSuchFieldException
        //   554	567	623	org/json/JSONException
        //   581	616	623	org/json/JSONException
        //   941	947	998	java/lang/NoSuchFieldException
        //   725	752	1118	org/json/JSONException
        //   752	774	1118	org/json/JSONException
        //   774	796	1118	org/json/JSONException
        //   796	818	1118	org/json/JSONException
        //   818	840	1118	org/json/JSONException
        //   840	877	1118	org/json/JSONException
        //   644	672	1122	org/json/JSONException
        //   499	527	1126	org/json/JSONException
        //   499	527	1223	java/lang/NoSuchFieldException
        //   644	672	1227	java/lang/NoSuchFieldException
        //   725	752	1231	java/lang/NoSuchFieldException
        //   752	774	1231	java/lang/NoSuchFieldException
        //   774	796	1231	java/lang/NoSuchFieldException
        //   796	818	1231	java/lang/NoSuchFieldException
        //   818	840	1231	java/lang/NoSuchFieldException
        //   840	877	1231	java/lang/NoSuchFieldException
      }
    };
    this.aKT = new k(paramDartExecutor, "flutter/platform", g.aauM);
    this.aKT.a(this.aasy);
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
    private String aasG;
    
    static
    {
      AppMethodBeat.i(10228);
      aasE = new b("LIGHT", 0, "Brightness.light");
      aasF = new b("DARK", 1, "Brightness.dark");
      aasH = new b[] { aasE, aasF };
      AppMethodBeat.o(10228);
    }
    
    private b(String paramString)
    {
      this.aasG = paramString;
    }
    
    static b bGk(String paramString)
    {
      AppMethodBeat.i(10227);
      b[] arrayOfb = values();
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        b localb = arrayOfb[i];
        if (localb.aasG.equals(paramString))
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
    private String aasG;
    
    static
    {
      AppMethodBeat.i(10279);
      aasK = new d("PORTRAIT_UP", 0, "DeviceOrientation.portraitUp");
      aasL = new d("PORTRAIT_DOWN", 1, "DeviceOrientation.portraitDown");
      aasM = new d("LANDSCAPE_LEFT", 2, "DeviceOrientation.landscapeLeft");
      aasN = new d("LANDSCAPE_RIGHT", 3, "DeviceOrientation.landscapeRight");
      aasO = new d[] { aasK, aasL, aasM, aasN };
      AppMethodBeat.o(10279);
    }
    
    private d(String paramString)
    {
      this.aasG = paramString;
    }
    
    static d bGm(String paramString)
    {
      AppMethodBeat.i(10278);
      d[] arrayOfd = values();
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        if (locald.aasG.equals(paramString))
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
    private final String aasG;
    
    static
    {
      AppMethodBeat.i(10252);
      aasP = new e("STANDARD", 0, null);
      aasQ = new e("LIGHT_IMPACT", 1, "HapticFeedbackType.lightImpact");
      aasR = new e("MEDIUM_IMPACT", 2, "HapticFeedbackType.mediumImpact");
      aasS = new e("HEAVY_IMPACT", 3, "HapticFeedbackType.heavyImpact");
      aasT = new e("SELECTION_CLICK", 4, "HapticFeedbackType.selectionClick");
      aasU = new e[] { aasP, aasQ, aasR, aasS, aasT };
      AppMethodBeat.o(10252);
    }
    
    private e(String paramString)
    {
      this.aasG = paramString;
    }
    
    static e bGn(String paramString)
    {
      AppMethodBeat.i(10251);
      e[] arrayOfe = values();
      int j = arrayOfe.length;
      int i = 0;
      while (i < j)
      {
        e locale = arrayOfe[i];
        if (((locale.aasG == null) && (paramString == null)) || ((locale.aasG != null) && (locale.aasG.equals(paramString))))
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
    public abstract CharSequence a(h.c paramc);
    
    public abstract void a(h.a parama);
    
    public abstract void a(h.e parame);
    
    public abstract void a(h.g paramg);
    
    public abstract void a(h.h paramh);
    
    public abstract void aDn(int paramInt);
    
    public abstract void bGo(String paramString);
    
    public abstract void iBh();
    
    public abstract void iBi();
    
    public abstract boolean iBj();
    
    public abstract void lh(List<h.i> paramList);
  }
  
  public static final class h
  {
    public final Integer aasY;
    public final h.b aasZ;
    public final Integer aata;
    public final h.b aatb;
    public final Integer aatc;
    
    public h(Integer paramInteger1, h.b paramb1, Integer paramInteger2, h.b paramb2, Integer paramInteger3)
    {
      this.aasY = paramInteger1;
      this.aasZ = paramb1;
      this.aata = paramInteger2;
      this.aatb = paramb2;
      this.aatc = paramInteger3;
    }
  }
  
  public static enum i
  {
    private String aasG;
    
    static
    {
      AppMethodBeat.i(10232);
      aatd = new i("TOP_OVERLAYS", 0, "SystemUiOverlay.top");
      aate = new i("BOTTOM_OVERLAYS", 1, "SystemUiOverlay.bottom");
      aatf = new i[] { aatd, aate };
      AppMethodBeat.o(10232);
    }
    
    private i(String paramString)
    {
      this.aasG = paramString;
    }
    
    static i bGq(String paramString)
    {
      AppMethodBeat.i(10231);
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      int i = 0;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (locali.aasG.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.h
 * JD-Core Version:    0.7.0.1
 */
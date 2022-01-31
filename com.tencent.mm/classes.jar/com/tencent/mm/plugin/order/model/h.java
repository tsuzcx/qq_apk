package com.tencent.mm.plugin.order.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends j
{
  public MallOrderDetailObject mPG = null;
  private int mPH = -1;
  
  public h(String paramString)
  {
    this(paramString, null, -1);
  }
  
  public h(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, -1);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    if (!bk.bl(paramString2)) {
      localHashMap.put("bill_id", paramString2);
    }
    if (this.mPH >= 0) {
      this.mPH = paramInt;
    }
    D(localHashMap);
  }
  
  /* Error */
  public final void a(int paramInt, String paramString, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +382 -> 383
    //   4: aload_0
    //   5: new 53	com/tencent/mm/plugin/order/model/MallOrderDetailObject
    //   8: dup
    //   9: invokespecial 54	com/tencent/mm/plugin/order/model/MallOrderDetailObject:<init>	()V
    //   12: putfield 20	com/tencent/mm/plugin/order/model/h:mPG	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject;
    //   15: aload_0
    //   16: getfield 20	com/tencent/mm/plugin/order/model/h:mPG	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject;
    //   19: astore 7
    //   21: aload_3
    //   22: ifnull +361 -> 383
    //   25: aload 7
    //   27: aload_3
    //   28: invokestatic 60	com/tencent/mm/plugin/order/model/MallTransactionObject:ab	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   31: putfield 64	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOw	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   34: aload_3
    //   35: ldc 66
    //   37: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   40: astore 6
    //   42: aload 6
    //   44: ifnull +372 -> 416
    //   47: new 74	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b
    //   50: dup
    //   51: invokespecial 75	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:<init>	()V
    //   54: astore_2
    //   55: aload_2
    //   56: aload 6
    //   58: ldc 77
    //   60: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 85	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:mOF	Ljava/lang/String;
    //   66: aload_2
    //   67: aload 6
    //   69: ldc 87
    //   71: invokevirtual 91	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   74: putfield 93	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:time	I
    //   77: aload_2
    //   78: aload 6
    //   80: ldc 95
    //   82: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 98	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:thumbUrl	Ljava/lang/String;
    //   88: aload_2
    //   89: aload 6
    //   91: ldc 100
    //   93: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   96: putfield 103	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:kRP	Ljava/lang/String;
    //   99: aload_2
    //   100: aload 6
    //   102: ldc 105
    //   104: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 108	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:mOG	Ljava/lang/String;
    //   110: aload 7
    //   112: aload_2
    //   113: putfield 112	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOx	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject$b;
    //   116: aload 7
    //   118: aload_3
    //   119: invokestatic 116	com/tencent/mm/plugin/order/model/MallOrderDetailObject:Z	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   122: putfield 120	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOy	Ljava/util/ArrayList;
    //   125: aload_3
    //   126: ldc 122
    //   128: invokevirtual 126	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   131: astore 6
    //   133: aload 6
    //   135: ifnull +553 -> 688
    //   138: aload 6
    //   140: invokevirtual 132	org/json/JSONArray:length	()I
    //   143: ifne +342 -> 485
    //   146: goto +542 -> 688
    //   149: aload 7
    //   151: aload_2
    //   152: putfield 136	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOz	Ljava/util/List;
    //   155: aload 7
    //   157: getfield 136	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOz	Ljava/util/List;
    //   160: astore 6
    //   162: aload_3
    //   163: ldc 138
    //   165: invokevirtual 141	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   168: astore 8
    //   170: aload 8
    //   172: ifnull +89 -> 261
    //   175: aload 6
    //   177: astore_2
    //   178: aload 6
    //   180: ifnonnull +11 -> 191
    //   183: new 143	java/util/ArrayList
    //   186: dup
    //   187: invokespecial 144	java/util/ArrayList:<init>	()V
    //   190: astore_2
    //   191: new 146	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a
    //   194: dup
    //   195: invokespecial 147	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:<init>	()V
    //   198: astore 6
    //   200: aload 8
    //   202: ldc 149
    //   204: invokevirtual 152	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   207: ifeq +456 -> 663
    //   210: aload 6
    //   212: aload 8
    //   214: ldc 149
    //   216: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 154	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:value	Ljava/lang/String;
    //   222: aload 6
    //   224: iconst_2
    //   225: putfield 157	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:type	I
    //   228: aload 8
    //   230: ldc 159
    //   232: iconst_0
    //   233: invokevirtual 162	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   236: istore_1
    //   237: iload_1
    //   238: iflt +23 -> 261
    //   241: iload_1
    //   242: aload 8
    //   244: invokevirtual 163	org/json/JSONObject:length	()I
    //   247: iconst_1
    //   248: iadd
    //   249: if_icmpgt +12 -> 261
    //   252: aload_2
    //   253: iload_1
    //   254: aload 6
    //   256: invokeinterface 169 3 0
    //   261: aload 7
    //   263: aload_3
    //   264: ldc 171
    //   266: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 174	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOC	Ljava/lang/String;
    //   272: aload 7
    //   274: aload_3
    //   275: ldc 176
    //   277: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   280: putfield 179	com/tencent/mm/plugin/order/model/MallOrderDetailObject:jEu	Ljava/lang/String;
    //   283: aload 7
    //   285: aload_3
    //   286: ldc 181
    //   288: invokevirtual 91	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   291: putfield 184	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOE	I
    //   294: aload 7
    //   296: getfield 112	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOx	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject$b;
    //   299: ifnull +24 -> 323
    //   302: aload 7
    //   304: getfield 184	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOE	I
    //   307: ifgt +16 -> 323
    //   310: aload 7
    //   312: aload 7
    //   314: getfield 112	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOx	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject$b;
    //   317: getfield 93	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:time	I
    //   320: putfield 184	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOE	I
    //   323: aload 7
    //   325: getfield 64	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOw	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   328: ifnull +55 -> 383
    //   331: aload 7
    //   333: aload 7
    //   335: getfield 64	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOw	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   338: getfield 187	com/tencent/mm/plugin/order/model/MallTransactionObject:mOD	Ljava/lang/String;
    //   341: putfield 188	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOD	Ljava/lang/String;
    //   344: aload 7
    //   346: aload 7
    //   348: getfield 64	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOw	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   351: getfield 191	com/tencent/mm/plugin/order/model/MallTransactionObject:mPa	Ljava/lang/String;
    //   354: putfield 194	com/tencent/mm/plugin/order/model/MallOrderDetailObject:bNZ	Ljava/lang/String;
    //   357: aload 7
    //   359: aload 7
    //   361: getfield 64	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOw	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   364: getfield 197	com/tencent/mm/plugin/order/model/MallTransactionObject:mOB	I
    //   367: putfield 198	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOB	I
    //   370: aload 7
    //   372: aload 7
    //   374: getfield 64	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOw	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   377: getfield 201	com/tencent/mm/plugin/order/model/MallTransactionObject:mOA	Ljava/util/List;
    //   380: putfield 202	com/tencent/mm/plugin/order/model/MallOrderDetailObject:mOA	Ljava/util/List;
    //   383: return
    //   384: astore_2
    //   385: ldc 204
    //   387: aload_2
    //   388: ldc 206
    //   390: iconst_0
    //   391: anewarray 208	java/lang/Object
    //   394: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   397: goto -363 -> 34
    //   400: astore_2
    //   401: ldc 204
    //   403: aload_2
    //   404: ldc 206
    //   406: iconst_0
    //   407: anewarray 208	java/lang/Object
    //   410: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: goto -379 -> 34
    //   416: aconst_null
    //   417: astore_2
    //   418: goto -308 -> 110
    //   421: astore_2
    //   422: ldc 204
    //   424: aload_2
    //   425: ldc 206
    //   427: iconst_0
    //   428: anewarray 208	java/lang/Object
    //   431: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: goto -318 -> 116
    //   437: astore_2
    //   438: ldc 204
    //   440: aload_2
    //   441: ldc 206
    //   443: iconst_0
    //   444: anewarray 208	java/lang/Object
    //   447: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: goto -334 -> 116
    //   453: astore_2
    //   454: ldc 204
    //   456: aload_2
    //   457: ldc 206
    //   459: iconst_0
    //   460: anewarray 208	java/lang/Object
    //   463: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: goto -341 -> 125
    //   469: astore_2
    //   470: ldc 204
    //   472: aload_2
    //   473: ldc 206
    //   475: iconst_0
    //   476: anewarray 208	java/lang/Object
    //   479: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: goto -357 -> 125
    //   485: new 143	java/util/ArrayList
    //   488: dup
    //   489: invokespecial 144	java/util/ArrayList:<init>	()V
    //   492: astore_2
    //   493: iconst_0
    //   494: istore_1
    //   495: iconst_0
    //   496: istore 4
    //   498: iload_1
    //   499: aload 6
    //   501: invokevirtual 132	org/json/JSONArray:length	()I
    //   504: if_icmpge +156 -> 660
    //   507: aload 6
    //   509: iload_1
    //   510: invokevirtual 217	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   513: astore 8
    //   515: new 146	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a
    //   518: dup
    //   519: invokespecial 147	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:<init>	()V
    //   522: astore 9
    //   524: aload 8
    //   526: ldc 219
    //   528: invokevirtual 91	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   531: ifne +169 -> 700
    //   534: iconst_0
    //   535: istore 5
    //   537: aload 9
    //   539: iload 5
    //   541: putfield 222	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:ilA	Z
    //   544: aload 9
    //   546: aload 8
    //   548: ldc 224
    //   550: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   553: putfield 226	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:name	Ljava/lang/String;
    //   556: aload 9
    //   558: getfield 226	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:name	Ljava/lang/String;
    //   561: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   564: ifeq +13 -> 577
    //   567: aload 9
    //   569: getfield 222	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:ilA	Z
    //   572: istore 4
    //   574: goto +119 -> 693
    //   577: iload 4
    //   579: ifeq +10 -> 589
    //   582: aload 9
    //   584: iload 4
    //   586: putfield 222	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:ilA	Z
    //   589: aload 9
    //   591: getfield 222	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:ilA	Z
    //   594: istore 4
    //   596: aload 9
    //   598: aload 8
    //   600: ldc 149
    //   602: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   605: putfield 154	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:value	Ljava/lang/String;
    //   608: aload 9
    //   610: aload 8
    //   612: ldc 100
    //   614: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   617: putfield 235	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:jumpUrl	Ljava/lang/String;
    //   620: aload 9
    //   622: aload 8
    //   624: ldc 237
    //   626: invokevirtual 91	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   629: putfield 240	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:jumpType	I
    //   632: aload_2
    //   633: aload 9
    //   635: invokeinterface 243 2 0
    //   640: pop
    //   641: goto +52 -> 693
    //   644: astore_2
    //   645: ldc 204
    //   647: aload_2
    //   648: ldc 206
    //   650: iconst_0
    //   651: anewarray 208	java/lang/Object
    //   654: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   657: goto -396 -> 261
    //   660: goto -511 -> 149
    //   663: aload 6
    //   665: iconst_1
    //   666: putfield 157	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:type	I
    //   669: goto -441 -> 228
    //   672: astore_2
    //   673: ldc 204
    //   675: aload_2
    //   676: ldc 206
    //   678: iconst_0
    //   679: anewarray 208	java/lang/Object
    //   682: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   685: goto -424 -> 261
    //   688: aconst_null
    //   689: astore_2
    //   690: goto -541 -> 149
    //   693: iload_1
    //   694: iconst_1
    //   695: iadd
    //   696: istore_1
    //   697: goto -199 -> 498
    //   700: iconst_1
    //   701: istore 5
    //   703: goto -166 -> 537
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	h
    //   0	706	1	paramInt	int
    //   0	706	2	paramString	String
    //   0	706	3	paramJSONObject	org.json.JSONObject
    //   496	99	4	bool1	boolean
    //   535	167	5	bool2	boolean
    //   40	624	6	localObject	java.lang.Object
    //   19	354	7	localMallOrderDetailObject	MallOrderDetailObject
    //   168	455	8	localJSONObject	org.json.JSONObject
    //   522	112	9	locala	MallOrderDetailObject.a
    // Exception table:
    //   from	to	target	type
    //   25	34	384	org/json/JSONException
    //   25	34	400	java/lang/Exception
    //   34	42	421	org/json/JSONException
    //   47	110	421	org/json/JSONException
    //   110	116	421	org/json/JSONException
    //   34	42	437	java/lang/Exception
    //   47	110	437	java/lang/Exception
    //   110	116	437	java/lang/Exception
    //   116	125	453	org/json/JSONException
    //   116	125	469	java/lang/Exception
    //   125	133	644	org/json/JSONException
    //   138	146	644	org/json/JSONException
    //   149	170	644	org/json/JSONException
    //   183	191	644	org/json/JSONException
    //   191	228	644	org/json/JSONException
    //   228	237	644	org/json/JSONException
    //   241	261	644	org/json/JSONException
    //   485	493	644	org/json/JSONException
    //   498	534	644	org/json/JSONException
    //   537	574	644	org/json/JSONException
    //   582	589	644	org/json/JSONException
    //   589	641	644	org/json/JSONException
    //   663	669	644	org/json/JSONException
    //   125	133	672	java/lang/Exception
    //   138	146	672	java/lang/Exception
    //   149	170	672	java/lang/Exception
    //   183	191	672	java/lang/Exception
    //   191	228	672	java/lang/Exception
    //   228	237	672	java/lang/Exception
    //   241	261	672	java/lang/Exception
    //   485	493	672	java/lang/Exception
    //   498	534	672	java/lang/Exception
    //   537	574	672	java/lang/Exception
    //   582	589	672	java/lang/Exception
    //   589	641	672	java/lang/Exception
    //   663	669	672	java/lang/Exception
  }
  
  public final int aEC()
  {
    return 108;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.h
 * JD-Core Version:    0.7.0.1
 */
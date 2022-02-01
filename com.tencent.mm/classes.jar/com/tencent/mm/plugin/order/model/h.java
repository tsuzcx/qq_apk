package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends m
{
  public MallOrderDetailObject MEV;
  private int MEW;
  
  public h(String paramString)
  {
    this(paramString, null, (byte)0);
  }
  
  public h(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, (byte)0);
  }
  
  private h(String paramString1, String paramString2, byte paramByte)
  {
    AppMethodBeat.i(262779);
    this.MEV = null;
    this.MEW = -1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("bill_id", paramString2);
    }
    if (this.MEW >= 0) {
      this.MEW = -1;
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(262779);
  }
  
  public final int getTenpayCgicmd()
  {
    return 108;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt, String paramString, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ifnull +382 -> 388
    //   9: aload_0
    //   10: new 66	com/tencent/mm/plugin/order/model/MallOrderDetailObject
    //   13: dup
    //   14: invokespecial 67	com/tencent/mm/plugin/order/model/MallOrderDetailObject:<init>	()V
    //   17: putfield 27	com/tencent/mm/plugin/order/model/h:MEV	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject;
    //   20: aload_0
    //   21: getfield 27	com/tencent/mm/plugin/order/model/h:MEV	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject;
    //   24: astore 7
    //   26: aload_3
    //   27: ifnull +361 -> 388
    //   30: aload 7
    //   32: aload_3
    //   33: invokestatic 73	com/tencent/mm/plugin/order/model/MallTransactionObject:bF	(Lorg/json/JSONObject;)Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   36: putfield 77	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDN	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   39: aload_3
    //   40: ldc 79
    //   42: invokevirtual 85	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +377 -> 426
    //   52: new 87	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b
    //   55: dup
    //   56: invokespecial 88	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: aload 6
    //   63: ldc 90
    //   65: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: putfield 98	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:MDW	Ljava/lang/String;
    //   71: aload_2
    //   72: aload 6
    //   74: ldc 100
    //   76: invokevirtual 104	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   79: putfield 106	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:time	I
    //   82: aload_2
    //   83: aload 6
    //   85: ldc 108
    //   87: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: putfield 111	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:thumbUrl	Ljava/lang/String;
    //   93: aload_2
    //   94: aload 6
    //   96: ldc 113
    //   98: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 116	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:IGI	Ljava/lang/String;
    //   104: aload_2
    //   105: aload 6
    //   107: ldc 118
    //   109: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: putfield 121	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:MDX	Ljava/lang/String;
    //   115: aload 7
    //   117: aload_2
    //   118: putfield 125	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDO	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject$b;
    //   121: aload 7
    //   123: aload_3
    //   124: invokestatic 129	com/tencent/mm/plugin/order/model/MallOrderDetailObject:bD	(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    //   127: putfield 133	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDP	Ljava/util/ArrayList;
    //   130: aload_3
    //   131: ldc 135
    //   133: invokevirtual 139	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   136: astore 6
    //   138: aload 6
    //   140: ifnull +558 -> 698
    //   143: aload 6
    //   145: invokevirtual 144	org/json/JSONArray:length	()I
    //   148: ifne +347 -> 495
    //   151: goto +547 -> 698
    //   154: aload 7
    //   156: aload_2
    //   157: putfield 148	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDQ	Ljava/util/List;
    //   160: aload 7
    //   162: getfield 148	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDQ	Ljava/util/List;
    //   165: astore 6
    //   167: aload_3
    //   168: ldc 150
    //   170: invokevirtual 153	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +89 -> 266
    //   180: aload 6
    //   182: astore_2
    //   183: aload 6
    //   185: ifnonnull +11 -> 196
    //   188: new 155	java/util/ArrayList
    //   191: dup
    //   192: invokespecial 156	java/util/ArrayList:<init>	()V
    //   195: astore_2
    //   196: new 158	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a
    //   199: dup
    //   200: invokespecial 159	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:<init>	()V
    //   203: astore 6
    //   205: aload 8
    //   207: ldc 161
    //   209: invokevirtual 164	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   212: ifeq +461 -> 673
    //   215: aload 6
    //   217: aload 8
    //   219: ldc 161
    //   221: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   224: putfield 166	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:value	Ljava/lang/String;
    //   227: aload 6
    //   229: iconst_2
    //   230: putfield 169	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:type	I
    //   233: aload 8
    //   235: ldc 171
    //   237: iconst_0
    //   238: invokevirtual 174	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   241: istore_1
    //   242: iload_1
    //   243: iflt +23 -> 266
    //   246: iload_1
    //   247: aload 8
    //   249: invokevirtual 175	org/json/JSONObject:length	()I
    //   252: iconst_1
    //   253: iadd
    //   254: if_icmpgt +12 -> 266
    //   257: aload_2
    //   258: iload_1
    //   259: aload 6
    //   261: invokeinterface 181 3 0
    //   266: aload 7
    //   268: aload_3
    //   269: ldc 183
    //   271: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: putfield 186	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDT	Ljava/lang/String;
    //   277: aload 7
    //   279: aload_3
    //   280: ldc 188
    //   282: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: putfield 191	com/tencent/mm/plugin/order/model/MallOrderDetailObject:yBh	Ljava/lang/String;
    //   288: aload 7
    //   290: aload_3
    //   291: ldc 193
    //   293: invokevirtual 104	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   296: putfield 196	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDV	I
    //   299: aload 7
    //   301: getfield 125	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDO	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject$b;
    //   304: ifnull +24 -> 328
    //   307: aload 7
    //   309: getfield 196	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDV	I
    //   312: ifgt +16 -> 328
    //   315: aload 7
    //   317: aload 7
    //   319: getfield 125	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDO	Lcom/tencent/mm/plugin/order/model/MallOrderDetailObject$b;
    //   322: getfield 106	com/tencent/mm/plugin/order/model/MallOrderDetailObject$b:time	I
    //   325: putfield 196	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDV	I
    //   328: aload 7
    //   330: getfield 77	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDN	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   333: ifnull +55 -> 388
    //   336: aload 7
    //   338: aload 7
    //   340: getfield 77	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDN	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   343: getfield 199	com/tencent/mm/plugin/order/model/MallTransactionObject:MDU	Ljava/lang/String;
    //   346: putfield 200	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDU	Ljava/lang/String;
    //   349: aload 7
    //   351: aload 7
    //   353: getfield 77	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDN	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   356: getfield 203	com/tencent/mm/plugin/order/model/MallTransactionObject:hzv	Ljava/lang/String;
    //   359: putfield 206	com/tencent/mm/plugin/order/model/MallOrderDetailObject:appUserName	Ljava/lang/String;
    //   362: aload 7
    //   364: aload 7
    //   366: getfield 77	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDN	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   369: getfield 209	com/tencent/mm/plugin/order/model/MallTransactionObject:MDS	I
    //   372: putfield 210	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDS	I
    //   375: aload 7
    //   377: aload 7
    //   379: getfield 77	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDN	Lcom/tencent/mm/plugin/order/model/MallTransactionObject;
    //   382: getfield 213	com/tencent/mm/plugin/order/model/MallTransactionObject:MDR	Ljava/util/List;
    //   385: putfield 214	com/tencent/mm/plugin/order/model/MallOrderDetailObject:MDR	Ljava/util/List;
    //   388: ldc 64
    //   390: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: return
    //   394: astore_2
    //   395: ldc 216
    //   397: aload_2
    //   398: ldc 218
    //   400: iconst_0
    //   401: anewarray 220	java/lang/Object
    //   404: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: goto -368 -> 39
    //   410: astore_2
    //   411: ldc 216
    //   413: aload_2
    //   414: ldc 218
    //   416: iconst_0
    //   417: anewarray 220	java/lang/Object
    //   420: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -384 -> 39
    //   426: aconst_null
    //   427: astore_2
    //   428: goto -313 -> 115
    //   431: astore_2
    //   432: ldc 216
    //   434: aload_2
    //   435: ldc 218
    //   437: iconst_0
    //   438: anewarray 220	java/lang/Object
    //   441: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: goto -323 -> 121
    //   447: astore_2
    //   448: ldc 216
    //   450: aload_2
    //   451: ldc 218
    //   453: iconst_0
    //   454: anewarray 220	java/lang/Object
    //   457: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: goto -339 -> 121
    //   463: astore_2
    //   464: ldc 216
    //   466: aload_2
    //   467: ldc 218
    //   469: iconst_0
    //   470: anewarray 220	java/lang/Object
    //   473: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: goto -346 -> 130
    //   479: astore_2
    //   480: ldc 216
    //   482: aload_2
    //   483: ldc 218
    //   485: iconst_0
    //   486: anewarray 220	java/lang/Object
    //   489: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   492: goto -362 -> 130
    //   495: new 155	java/util/ArrayList
    //   498: dup
    //   499: invokespecial 156	java/util/ArrayList:<init>	()V
    //   502: astore_2
    //   503: iconst_0
    //   504: istore_1
    //   505: iconst_0
    //   506: istore 4
    //   508: iload_1
    //   509: aload 6
    //   511: invokevirtual 144	org/json/JSONArray:length	()I
    //   514: if_icmpge +156 -> 670
    //   517: aload 6
    //   519: iload_1
    //   520: invokevirtual 229	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   523: astore 8
    //   525: new 158	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a
    //   528: dup
    //   529: invokespecial 159	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:<init>	()V
    //   532: astore 9
    //   534: aload 8
    //   536: ldc 231
    //   538: invokevirtual 104	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   541: ifne +169 -> 710
    //   544: iconst_0
    //   545: istore 5
    //   547: aload 9
    //   549: iload 5
    //   551: putfield 235	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:wsJ	Z
    //   554: aload 9
    //   556: aload 8
    //   558: ldc 237
    //   560: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   563: putfield 239	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:name	Ljava/lang/String;
    //   566: aload 9
    //   568: getfield 239	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:name	Ljava/lang/String;
    //   571: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   574: ifeq +13 -> 587
    //   577: aload 9
    //   579: getfield 235	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:wsJ	Z
    //   582: istore 4
    //   584: goto +119 -> 703
    //   587: iload 4
    //   589: ifeq +10 -> 599
    //   592: aload 9
    //   594: iload 4
    //   596: putfield 235	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:wsJ	Z
    //   599: aload 9
    //   601: getfield 235	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:wsJ	Z
    //   604: istore 4
    //   606: aload 9
    //   608: aload 8
    //   610: ldc 161
    //   612: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   615: putfield 166	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:value	Ljava/lang/String;
    //   618: aload 9
    //   620: aload 8
    //   622: ldc 113
    //   624: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   627: putfield 248	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:jumpUrl	Ljava/lang/String;
    //   630: aload 9
    //   632: aload 8
    //   634: ldc 250
    //   636: invokevirtual 104	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   639: putfield 253	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:jumpType	I
    //   642: aload_2
    //   643: aload 9
    //   645: invokeinterface 256 2 0
    //   650: pop
    //   651: goto +52 -> 703
    //   654: astore_2
    //   655: ldc 216
    //   657: aload_2
    //   658: ldc 218
    //   660: iconst_0
    //   661: anewarray 220	java/lang/Object
    //   664: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   667: goto -401 -> 266
    //   670: goto -516 -> 154
    //   673: aload 6
    //   675: iconst_1
    //   676: putfield 169	com/tencent/mm/plugin/order/model/MallOrderDetailObject$a:type	I
    //   679: goto -446 -> 233
    //   682: astore_2
    //   683: ldc 216
    //   685: aload_2
    //   686: ldc 218
    //   688: iconst_0
    //   689: anewarray 220	java/lang/Object
    //   692: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   695: goto -429 -> 266
    //   698: aconst_null
    //   699: astore_2
    //   700: goto -546 -> 154
    //   703: iload_1
    //   704: iconst_1
    //   705: iadd
    //   706: istore_1
    //   707: goto -199 -> 508
    //   710: iconst_1
    //   711: istore 5
    //   713: goto -166 -> 547
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	h
    //   0	716	1	paramInt	int
    //   0	716	2	paramString	String
    //   0	716	3	paramJSONObject	org.json.JSONObject
    //   506	99	4	bool1	boolean
    //   545	167	5	bool2	boolean
    //   45	629	6	localObject	java.lang.Object
    //   24	354	7	localMallOrderDetailObject	MallOrderDetailObject
    //   173	460	8	localJSONObject	org.json.JSONObject
    //   532	112	9	locala	MallOrderDetailObject.a
    // Exception table:
    //   from	to	target	type
    //   30	39	394	org/json/JSONException
    //   30	39	410	java/lang/Exception
    //   39	47	431	org/json/JSONException
    //   52	115	431	org/json/JSONException
    //   115	121	431	org/json/JSONException
    //   39	47	447	java/lang/Exception
    //   52	115	447	java/lang/Exception
    //   115	121	447	java/lang/Exception
    //   121	130	463	org/json/JSONException
    //   121	130	479	java/lang/Exception
    //   130	138	654	org/json/JSONException
    //   143	151	654	org/json/JSONException
    //   154	175	654	org/json/JSONException
    //   188	196	654	org/json/JSONException
    //   196	233	654	org/json/JSONException
    //   233	242	654	org/json/JSONException
    //   246	266	654	org/json/JSONException
    //   495	503	654	org/json/JSONException
    //   508	544	654	org/json/JSONException
    //   547	584	654	org/json/JSONException
    //   592	599	654	org/json/JSONException
    //   599	651	654	org/json/JSONException
    //   673	679	654	org/json/JSONException
    //   130	138	682	java/lang/Exception
    //   143	151	682	java/lang/Exception
    //   154	175	682	java/lang/Exception
    //   188	196	682	java/lang/Exception
    //   196	233	682	java/lang/Exception
    //   233	242	682	java/lang/Exception
    //   246	266	682	java/lang/Exception
    //   495	503	682	java/lang/Exception
    //   508	544	682	java/lang/Exception
    //   547	584	682	java/lang/Exception
    //   592	599	682	java/lang/Exception
    //   599	651	682	java/lang/Exception
    //   673	679	682	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.h
 * JD-Core Version:    0.7.0.1
 */
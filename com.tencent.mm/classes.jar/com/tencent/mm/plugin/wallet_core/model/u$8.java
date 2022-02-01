package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.Map;

final class u$8
  implements ck.a
{
  u$8(u paramu) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(70373);
    parama = com.tencent.mm.platformtools.z.a(parama.jQG.RIF);
    final Map localMap = XmlParser.parseXml(parama, "sysmsg", null);
    if (localMap == null)
    {
      AppMethodBeat.o(70373);
      return;
    }
    int i = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    Log.i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(70373);
      return;
      i = Util.getInt((String)localMap.get(".sysmsg.paymsg.WalletType"), -1);
      Log.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
      if (i >= 0)
      {
        h.aHH();
        h.aHG().aHp().i(339975, Integer.valueOf(i));
        AppMethodBeat.o(70373);
        return;
        i = Util.getInt((String)localMap.get(".sysmsg.paymsg.Flag"), 0);
        Log.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
        if (i == 1)
        {
          Log.i("MicroMsg.SubCoreWalletCore", "open wallet");
          com.tencent.mm.model.z.bdm();
          AppMethodBeat.o(70373);
          return;
        }
        if (i == 2)
        {
          Log.i("MicroMsg.SubCoreWalletCore", "close wallet");
          com.tencent.mm.model.z.bdT();
          AppMethodBeat.o(70373);
          return;
          Log.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", new Object[] { parama });
          h.aHH();
          h.aHJ().postToWorker(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 29
              //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: aconst_null
              //   6: astore 5
              //   8: aload_0
              //   9: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$8$1:OTd	Ljava/util/Map;
              //   12: ldc 37
              //   14: invokeinterface 43 2 0
              //   19: checkcast 45	java/lang/String
              //   22: astore_2
              //   23: aload_0
              //   24: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$8$1:OTd	Ljava/util/Map;
              //   27: ldc 47
              //   29: invokeinterface 43 2 0
              //   34: checkcast 45	java/lang/String
              //   37: astore_3
              //   38: aload_0
              //   39: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$8$1:OTd	Ljava/util/Map;
              //   42: ldc 49
              //   44: invokeinterface 43 2 0
              //   49: checkcast 45	java/lang/String
              //   52: astore 4
              //   54: aload_0
              //   55: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$8$1:OTd	Ljava/util/Map;
              //   58: ldc 51
              //   60: invokeinterface 43 2 0
              //   65: checkcast 45	java/lang/String
              //   68: astore 7
              //   70: aload_2
              //   71: ldc 53
              //   73: invokestatic 59	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
              //   76: astore 6
              //   78: aload_3
              //   79: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
              //   82: ifne +335 -> 417
              //   85: aload_3
              //   86: invokestatic 71	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
              //   89: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
              //   92: ifne +325 -> 417
              //   95: aload_3
              //   96: astore_2
              //   97: aload_3
              //   98: invokestatic 80	com/tencent/mm/model/ab:Lj	(Ljava/lang/String;)Z
              //   101: ifeq +322 -> 423
              //   104: aload_3
              //   105: astore_2
              //   106: ldc 82
              //   108: ldc 84
              //   110: iconst_5
              //   111: anewarray 4	java/lang/Object
              //   114: dup
              //   115: iconst_0
              //   116: invokestatic 71	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
              //   119: aastore
              //   120: dup
              //   121: iconst_1
              //   122: aload_3
              //   123: aastore
              //   124: dup
              //   125: iconst_2
              //   126: aload 4
              //   128: aastore
              //   129: dup
              //   130: iconst_3
              //   131: aload_2
              //   132: aastore
              //   133: dup
              //   134: iconst_4
              //   135: aload 7
              //   137: aastore
              //   138: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   141: aload 6
              //   143: invokestatic 95	com/tencent/mm/aj/k$b:OQ	(Ljava/lang/String;)Lcom/tencent/mm/aj/k$b;
              //   146: astore 7
              //   148: ldc 82
              //   150: ldc 97
              //   152: iconst_2
              //   153: anewarray 4	java/lang/Object
              //   156: dup
              //   157: iconst_0
              //   158: aload 6
              //   160: aastore
              //   161: dup
              //   162: iconst_1
              //   163: aload 7
              //   165: aastore
              //   166: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   169: new 99	java/util/ArrayList
              //   172: dup
              //   173: invokespecial 100	java/util/ArrayList:<init>	()V
              //   176: astore 4
              //   178: aload 7
              //   180: ifnull +486 -> 666
              //   183: ldc 102
              //   185: invokestatic 108	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   188: checkcast 102	com/tencent/mm/plugin/messenger/foundation/a/n
              //   191: invokeinterface 112 1 0
              //   196: aload_2
              //   197: invokeinterface 118 2 0
              //   202: astore_2
              //   203: aload_2
              //   204: ifnull +265 -> 469
              //   207: aload_2
              //   208: astore_3
              //   209: aload_2
              //   210: invokeinterface 124 1 0
              //   215: ifeq +254 -> 469
              //   218: aload_2
              //   219: astore_3
              //   220: new 126	com/tencent/mm/storage/ca
              //   223: dup
              //   224: invokespecial 127	com/tencent/mm/storage/ca:<init>	()V
              //   227: astore 5
              //   229: aload_2
              //   230: astore_3
              //   231: aload 5
              //   233: aload_2
              //   234: invokevirtual 131	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
              //   237: aload_2
              //   238: astore_3
              //   239: aload 5
              //   241: getfield 137	com/tencent/mm/f/c/et:field_content	Ljava/lang/String;
              //   244: invokestatic 95	com/tencent/mm/aj/k$b:OQ	(Ljava/lang/String;)Lcom/tencent/mm/aj/k$b;
              //   247: astore 8
              //   249: aload 8
              //   251: ifnull -44 -> 207
              //   254: aload_2
              //   255: astore_3
              //   256: aload 8
              //   258: getfield 140	com/tencent/mm/aj/k$b:lnJ	Ljava/lang/String;
              //   261: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
              //   264: ifne -57 -> 207
              //   267: aload_2
              //   268: astore_3
              //   269: aload 8
              //   271: getfield 140	com/tencent/mm/aj/k$b:lnJ	Ljava/lang/String;
              //   274: aload 7
              //   276: getfield 140	com/tencent/mm/aj/k$b:lnJ	Ljava/lang/String;
              //   279: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
              //   282: ifeq -75 -> 207
              //   285: aload_2
              //   286: astore_3
              //   287: ldc 82
              //   289: ldc 142
              //   291: iconst_3
              //   292: anewarray 4	java/lang/Object
              //   295: dup
              //   296: iconst_0
              //   297: aload 5
              //   299: getfield 146	com/tencent/mm/f/c/et:field_msgId	J
              //   302: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   305: aastore
              //   306: dup
              //   307: iconst_1
              //   308: aload 5
              //   310: getfield 155	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
              //   313: aastore
              //   314: dup
              //   315: iconst_2
              //   316: aload 5
              //   318: getfield 159	com/tencent/mm/f/c/et:field_isSend	I
              //   321: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   324: aastore
              //   325: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   328: aload_2
              //   329: astore_3
              //   330: aload 5
              //   332: getfield 155	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
              //   335: invokestatic 80	com/tencent/mm/model/ab:Lj	(Ljava/lang/String;)Z
              //   338: ifeq +101 -> 439
              //   341: aload_2
              //   342: astore_3
              //   343: aload 5
              //   345: aload 6
              //   347: aload 5
              //   349: getfield 137	com/tencent/mm/f/c/et:field_content	Ljava/lang/String;
              //   352: invokestatic 170	com/tencent/mm/model/bq:RL	(Ljava/lang/String;)Ljava/lang/String;
              //   355: invokestatic 173	com/tencent/mm/model/bq:aT	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
              //   358: invokevirtual 177	com/tencent/mm/storage/ca:setContent	(Ljava/lang/String;)V
              //   361: aload_2
              //   362: astore_3
              //   363: aload 4
              //   365: aload 5
              //   367: invokeinterface 182 2 0
              //   372: pop
              //   373: goto -166 -> 207
              //   376: astore 4
              //   378: aload_2
              //   379: astore_3
              //   380: ldc 82
              //   382: aload 4
              //   384: ldc 184
              //   386: iconst_1
              //   387: anewarray 4	java/lang/Object
              //   390: dup
              //   391: iconst_0
              //   392: aload 4
              //   394: invokevirtual 187	java/lang/Exception:getMessage	()Ljava/lang/String;
              //   397: aastore
              //   398: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   401: aload_2
              //   402: ifnull +220 -> 622
              //   405: aload_2
              //   406: invokeinterface 194 1 0
              //   411: ldc 29
              //   413: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   416: return
              //   417: aload 4
              //   419: astore_2
              //   420: goto -323 -> 97
              //   423: aload 4
              //   425: invokestatic 80	com/tencent/mm/model/ab:Lj	(Ljava/lang/String;)Z
              //   428: istore_1
              //   429: iload_1
              //   430: ifeq +241 -> 671
              //   433: aload 4
              //   435: astore_2
              //   436: goto -330 -> 106
              //   439: aload_2
              //   440: astore_3
              //   441: aload 5
              //   443: aload 6
              //   445: invokevirtual 177	com/tencent/mm/storage/ca:setContent	(Ljava/lang/String;)V
              //   448: goto -87 -> 361
              //   451: astore_2
              //   452: aload_3
              //   453: ifnull +9 -> 462
              //   456: aload_3
              //   457: invokeinterface 194 1 0
              //   462: ldc 29
              //   464: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   467: aload_2
              //   468: athrow
              //   469: aload_2
              //   470: astore_3
              //   471: aload_2
              //   472: ifnull +11 -> 483
              //   475: aload_2
              //   476: invokeinterface 194 1 0
              //   481: aconst_null
              //   482: astore_3
              //   483: aload_3
              //   484: astore_2
              //   485: ldc 82
              //   487: ldc 199
              //   489: iconst_1
              //   490: anewarray 4	java/lang/Object
              //   493: dup
              //   494: iconst_0
              //   495: aload 4
              //   497: aastore
              //   498: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   501: aload 4
              //   503: invokeinterface 203 1 0
              //   508: ifle +98 -> 606
              //   511: aload 4
              //   513: invokeinterface 207 1 0
              //   518: astore_3
              //   519: aload_3
              //   520: invokeinterface 212 1 0
              //   525: ifeq +81 -> 606
              //   528: aload_3
              //   529: invokeinterface 216 1 0
              //   534: checkcast 126	com/tencent/mm/storage/ca
              //   537: astore 4
              //   539: ldc 82
              //   541: ldc 218
              //   543: iconst_2
              //   544: anewarray 4	java/lang/Object
              //   547: dup
              //   548: iconst_0
              //   549: aload 4
              //   551: getfield 146	com/tencent/mm/f/c/et:field_msgId	J
              //   554: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   557: aastore
              //   558: dup
              //   559: iconst_1
              //   560: aload 4
              //   562: getfield 137	com/tencent/mm/f/c/et:field_content	Ljava/lang/String;
              //   565: aastore
              //   566: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   569: ldc 102
              //   571: invokestatic 108	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   574: checkcast 102	com/tencent/mm/plugin/messenger/foundation/a/n
              //   577: invokeinterface 112 1 0
              //   582: aload 4
              //   584: getfield 146	com/tencent/mm/f/c/et:field_msgId	J
              //   587: aload 4
              //   589: invokeinterface 221 4 0
              //   594: goto -75 -> 519
              //   597: astore 4
              //   599: goto -221 -> 378
              //   602: astore_3
              //   603: goto -118 -> 485
              //   606: aload_2
              //   607: ifnull +15 -> 622
              //   610: aload_2
              //   611: invokeinterface 194 1 0
              //   616: ldc 29
              //   618: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   621: return
              //   622: ldc 29
              //   624: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   627: return
              //   628: astore_2
              //   629: aload 5
              //   631: astore_3
              //   632: goto -180 -> 452
              //   635: astore_3
              //   636: aload_2
              //   637: astore 4
              //   639: aload_3
              //   640: astore_2
              //   641: aload 4
              //   643: astore_3
              //   644: goto -192 -> 452
              //   647: astore_3
              //   648: aload_2
              //   649: astore 4
              //   651: aload_3
              //   652: astore_2
              //   653: aload 4
              //   655: astore_3
              //   656: goto -204 -> 452
              //   659: astore 4
              //   661: aconst_null
              //   662: astore_2
              //   663: goto -285 -> 378
              //   666: aconst_null
              //   667: astore_2
              //   668: goto -199 -> 469
              //   671: goto -565 -> 106
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	674	0	this	1
              //   428	2	1	bool	boolean
              //   22	418	2	localObject1	Object
              //   451	25	2	localObject2	Object
              //   484	127	2	localObject3	Object
              //   628	9	2	localObject4	Object
              //   640	28	2	localObject5	Object
              //   37	492	3	localObject6	Object
              //   602	1	3	localException1	java.lang.Exception
              //   631	1	3	localca1	com.tencent.mm.storage.ca
              //   635	5	3	localObject7	Object
              //   643	1	3	localObject8	Object
              //   647	5	3	localObject9	Object
              //   655	1	3	localObject10	Object
              //   52	312	4	localObject11	Object
              //   376	136	4	localException2	java.lang.Exception
              //   537	51	4	localca2	com.tencent.mm.storage.ca
              //   597	1	4	localException3	java.lang.Exception
              //   637	17	4	localObject12	Object
              //   659	1	4	localException4	java.lang.Exception
              //   6	624	5	localca3	com.tencent.mm.storage.ca
              //   76	368	6	str	String
              //   68	207	7	localObject13	Object
              //   247	23	8	localb	com.tencent.mm.aj.k.b
              // Exception table:
              //   from	to	target	type
              //   209	218	376	java/lang/Exception
              //   220	229	376	java/lang/Exception
              //   231	237	376	java/lang/Exception
              //   239	249	376	java/lang/Exception
              //   256	267	376	java/lang/Exception
              //   269	285	376	java/lang/Exception
              //   287	328	376	java/lang/Exception
              //   330	341	376	java/lang/Exception
              //   343	361	376	java/lang/Exception
              //   363	373	376	java/lang/Exception
              //   441	448	376	java/lang/Exception
              //   209	218	451	finally
              //   220	229	451	finally
              //   231	237	451	finally
              //   239	249	451	finally
              //   256	267	451	finally
              //   269	285	451	finally
              //   287	328	451	finally
              //   330	341	451	finally
              //   343	361	451	finally
              //   363	373	451	finally
              //   380	401	451	finally
              //   441	448	451	finally
              //   485	519	597	java/lang/Exception
              //   519	594	597	java/lang/Exception
              //   475	481	602	java/lang/Exception
              //   8	95	628	finally
              //   97	104	628	finally
              //   106	178	628	finally
              //   183	203	628	finally
              //   423	429	628	finally
              //   475	481	635	finally
              //   485	519	647	finally
              //   519	594	647	finally
              //   8	95	659	java/lang/Exception
              //   97	104	659	java/lang/Exception
              //   106	178	659	java/lang/Exception
              //   183	203	659	java/lang/Exception
              //   423	429	659	java/lang/Exception
            }
          });
        }
      }
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u.8
 * JD-Core Version:    0.7.0.1
 */
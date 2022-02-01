package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import java.util.Map;

final class u$5
  implements cl.a
{
  u$5(u paramu) {}
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(70373);
    parama = w.a(parama.mpN.YFG);
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
        h.baF();
        h.baE().ban().B(339975, Integer.valueOf(i));
        AppMethodBeat.o(70373);
        return;
        i = Util.getInt((String)localMap.get(".sysmsg.paymsg.Flag"), 0);
        Log.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
        if (i == 1)
        {
          Log.i("MicroMsg.SubCoreWalletCore", "open wallet");
          z.bBe();
          AppMethodBeat.o(70373);
          return;
        }
        if (i == 2)
        {
          Log.i("MicroMsg.SubCoreWalletCore", "close wallet");
          z.bBL();
          AppMethodBeat.o(70373);
          return;
          Log.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", new Object[] { parama });
          h.baF();
          h.baH().postToWorker(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 29
              //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: aconst_null
              //   6: astore 7
              //   8: aload_0
              //   9: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$5$1:VJk	Ljava/util/Map;
              //   12: ldc 37
              //   14: invokeinterface 43 2 0
              //   19: checkcast 45	java/lang/String
              //   22: astore 4
              //   24: aload_0
              //   25: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$5$1:VJk	Ljava/util/Map;
              //   28: ldc 47
              //   30: invokeinterface 43 2 0
              //   35: checkcast 45	java/lang/String
              //   38: astore 5
              //   40: aload_0
              //   41: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$5$1:VJk	Ljava/util/Map;
              //   44: ldc 49
              //   46: invokeinterface 43 2 0
              //   51: checkcast 45	java/lang/String
              //   54: astore 6
              //   56: aload_0
              //   57: getfield 21	com/tencent/mm/plugin/wallet_core/model/u$5$1:VJk	Ljava/util/Map;
              //   60: ldc 51
              //   62: invokeinterface 43 2 0
              //   67: checkcast 45	java/lang/String
              //   70: astore 9
              //   72: aload 4
              //   74: ldc 53
              //   76: invokestatic 59	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
              //   79: astore 8
              //   81: aload 5
              //   83: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
              //   86: ifne +372 -> 458
              //   89: aload 5
              //   91: invokestatic 71	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
              //   94: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
              //   97: ifne +361 -> 458
              //   100: aload 5
              //   102: astore 4
              //   104: aload 5
              //   106: invokestatic 80	com/tencent/mm/storage/au:bwE	(Ljava/lang/String;)Z
              //   109: ifeq +356 -> 465
              //   112: aload 5
              //   114: astore 4
              //   116: ldc 82
              //   118: ldc 84
              //   120: iconst_5
              //   121: anewarray 4	java/lang/Object
              //   124: dup
              //   125: iconst_0
              //   126: invokestatic 71	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
              //   129: aastore
              //   130: dup
              //   131: iconst_1
              //   132: aload 5
              //   134: aastore
              //   135: dup
              //   136: iconst_2
              //   137: aload 6
              //   139: aastore
              //   140: dup
              //   141: iconst_3
              //   142: aload 4
              //   144: aastore
              //   145: dup
              //   146: iconst_4
              //   147: aload 9
              //   149: aastore
              //   150: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   153: aload 8
              //   155: invokestatic 95	com/tencent/mm/message/k$b:Hf	(Ljava/lang/String;)Lcom/tencent/mm/message/k$b;
              //   158: astore 9
              //   160: ldc 82
              //   162: ldc 97
              //   164: iconst_2
              //   165: anewarray 4	java/lang/Object
              //   168: dup
              //   169: iconst_0
              //   170: aload 8
              //   172: aastore
              //   173: dup
              //   174: iconst_1
              //   175: aload 9
              //   177: aastore
              //   178: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   181: new 99	java/util/ArrayList
              //   184: dup
              //   185: invokespecial 100	java/util/ArrayList:<init>	()V
              //   188: astore 6
              //   190: aload 9
              //   192: ifnull +628 -> 820
              //   195: ldc 102
              //   197: invokestatic 108	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   200: checkcast 102	com/tencent/mm/plugin/messenger/foundation/a/n
              //   203: invokeinterface 112 1 0
              //   208: aload 4
              //   210: invokeinterface 118 2 0
              //   215: astore 4
              //   217: aload 4
              //   219: ifnull +299 -> 518
              //   222: aload 4
              //   224: astore 5
              //   226: aload 4
              //   228: invokeinterface 124 1 0
              //   233: ifeq +285 -> 518
              //   236: aload 4
              //   238: astore 5
              //   240: new 126	com/tencent/mm/storage/cc
              //   243: dup
              //   244: invokespecial 127	com/tencent/mm/storage/cc:<init>	()V
              //   247: astore 7
              //   249: aload 4
              //   251: astore 5
              //   253: aload 7
              //   255: aload 4
              //   257: invokevirtual 131	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
              //   260: aload 4
              //   262: astore 5
              //   264: aload 7
              //   266: getfield 137	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
              //   269: invokestatic 95	com/tencent/mm/message/k$b:Hf	(Ljava/lang/String;)Lcom/tencent/mm/message/k$b;
              //   272: astore 10
              //   274: aload 10
              //   276: ifnull -54 -> 222
              //   279: aload 4
              //   281: astore 5
              //   283: aload 10
              //   285: getfield 140	com/tencent/mm/message/k$b:nSN	Ljava/lang/String;
              //   288: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
              //   291: ifne -69 -> 222
              //   294: aload 4
              //   296: astore 5
              //   298: aload 10
              //   300: getfield 140	com/tencent/mm/message/k$b:nSN	Ljava/lang/String;
              //   303: aload 9
              //   305: getfield 140	com/tencent/mm/message/k$b:nSN	Ljava/lang/String;
              //   308: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
              //   311: ifeq -89 -> 222
              //   314: aload 4
              //   316: astore 5
              //   318: ldc 82
              //   320: ldc 142
              //   322: iconst_3
              //   323: anewarray 4	java/lang/Object
              //   326: dup
              //   327: iconst_0
              //   328: aload 7
              //   330: getfield 146	com/tencent/mm/autogen/b/fi:field_msgId	J
              //   333: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   336: aastore
              //   337: dup
              //   338: iconst_1
              //   339: aload 7
              //   341: getfield 155	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
              //   344: aastore
              //   345: dup
              //   346: iconst_2
              //   347: aload 7
              //   349: getfield 159	com/tencent/mm/autogen/b/fi:field_isSend	I
              //   352: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   355: aastore
              //   356: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   359: aload 4
              //   361: astore 5
              //   363: aload 7
              //   365: getfield 155	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
              //   368: invokestatic 80	com/tencent/mm/storage/au:bwE	(Ljava/lang/String;)Z
              //   371: ifeq +111 -> 482
              //   374: aload 4
              //   376: astore 5
              //   378: aload 7
              //   380: aload 8
              //   382: aload 7
              //   384: getfield 137	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
              //   387: invokestatic 170	com/tencent/mm/model/br:JJ	(Ljava/lang/String;)Ljava/lang/String;
              //   390: invokestatic 173	com/tencent/mm/model/br:bd	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
              //   393: invokevirtual 177	com/tencent/mm/storage/cc:setContent	(Ljava/lang/String;)V
              //   396: aload 4
              //   398: astore 5
              //   400: aload 6
              //   402: aload 7
              //   404: invokeinterface 182 2 0
              //   409: pop
              //   410: goto -188 -> 222
              //   413: astore 6
              //   415: aload 4
              //   417: astore 5
              //   419: ldc 82
              //   421: aload 6
              //   423: ldc 184
              //   425: iconst_1
              //   426: anewarray 4	java/lang/Object
              //   429: dup
              //   430: iconst_0
              //   431: aload 6
              //   433: invokevirtual 187	java/lang/Exception:getMessage	()Ljava/lang/String;
              //   436: aastore
              //   437: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   440: aload 4
              //   442: ifnull +321 -> 763
              //   445: aload 4
              //   447: invokeinterface 194 1 0
              //   452: ldc 29
              //   454: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   457: return
              //   458: aload 6
              //   460: astore 4
              //   462: goto -358 -> 104
              //   465: aload 6
              //   467: invokestatic 80	com/tencent/mm/storage/au:bwE	(Ljava/lang/String;)Z
              //   470: istore_1
              //   471: iload_1
              //   472: ifeq +354 -> 826
              //   475: aload 6
              //   477: astore 4
              //   479: goto -363 -> 116
              //   482: aload 4
              //   484: astore 5
              //   486: aload 7
              //   488: aload 8
              //   490: invokevirtual 177	com/tencent/mm/storage/cc:setContent	(Ljava/lang/String;)V
              //   493: goto -97 -> 396
              //   496: astore 4
              //   498: aload 5
              //   500: ifnull +10 -> 510
              //   503: aload 5
              //   505: invokeinterface 194 1 0
              //   510: ldc 29
              //   512: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   515: aload 4
              //   517: athrow
              //   518: aload 4
              //   520: astore 5
              //   522: aload 4
              //   524: ifnull +13 -> 537
              //   527: aload 4
              //   529: invokeinterface 194 1 0
              //   534: aconst_null
              //   535: astore 5
              //   537: aload 5
              //   539: astore 4
              //   541: aload 9
              //   543: getfield 140	com/tencent/mm/message/k$b:nSN	Ljava/lang/String;
              //   546: invokestatic 203	com/tencent/mm/plugin/luckymoney/model/ah:aKB	(Ljava/lang/String;)J
              //   549: lstore_2
              //   550: lload_2
              //   551: lconst_0
              //   552: lcmp
              //   553: iflt +67 -> 620
              //   556: ldc 82
              //   558: ldc 205
              //   560: iconst_2
              //   561: anewarray 4	java/lang/Object
              //   564: dup
              //   565: iconst_0
              //   566: aload 9
              //   568: getfield 140	com/tencent/mm/message/k$b:nSN	Ljava/lang/String;
              //   571: aastore
              //   572: dup
              //   573: iconst_1
              //   574: lload_2
              //   575: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   578: aastore
              //   579: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   582: ldc 102
              //   584: invokestatic 108	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   587: checkcast 102	com/tencent/mm/plugin/messenger/foundation/a/n
              //   590: invokeinterface 112 1 0
              //   595: lload_2
              //   596: invokeinterface 209 3 0
              //   601: astore 5
              //   603: aload 5
              //   605: aload 8
              //   607: invokevirtual 177	com/tencent/mm/storage/cc:setContent	(Ljava/lang/String;)V
              //   610: aload 6
              //   612: aload 5
              //   614: invokeinterface 182 2 0
              //   619: pop
              //   620: ldc 82
              //   622: ldc 211
              //   624: iconst_1
              //   625: anewarray 4	java/lang/Object
              //   628: dup
              //   629: iconst_0
              //   630: aload 6
              //   632: aastore
              //   633: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   636: aload 6
              //   638: invokeinterface 215 1 0
              //   643: ifle +102 -> 745
              //   646: aload 6
              //   648: invokeinterface 219 1 0
              //   653: astore 5
              //   655: aload 5
              //   657: invokeinterface 224 1 0
              //   662: ifeq +83 -> 745
              //   665: aload 5
              //   667: invokeinterface 228 1 0
              //   672: checkcast 126	com/tencent/mm/storage/cc
              //   675: astore 6
              //   677: ldc 82
              //   679: ldc 230
              //   681: iconst_2
              //   682: anewarray 4	java/lang/Object
              //   685: dup
              //   686: iconst_0
              //   687: aload 6
              //   689: getfield 146	com/tencent/mm/autogen/b/fi:field_msgId	J
              //   692: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
              //   695: aastore
              //   696: dup
              //   697: iconst_1
              //   698: aload 6
              //   700: getfield 137	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
              //   703: aastore
              //   704: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   707: ldc 102
              //   709: invokestatic 108	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
              //   712: checkcast 102	com/tencent/mm/plugin/messenger/foundation/a/n
              //   715: invokeinterface 112 1 0
              //   720: aload 6
              //   722: getfield 146	com/tencent/mm/autogen/b/fi:field_msgId	J
              //   725: aload 6
              //   727: invokeinterface 233 4 0
              //   732: goto -77 -> 655
              //   735: astore 6
              //   737: goto -322 -> 415
              //   740: astore 5
              //   742: goto -201 -> 541
              //   745: aload 4
              //   747: ifnull +16 -> 763
              //   750: aload 4
              //   752: invokeinterface 194 1 0
              //   757: ldc 29
              //   759: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   762: return
              //   763: ldc 29
              //   765: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   768: return
              //   769: astore 4
              //   771: aload 7
              //   773: astore 5
              //   775: goto -277 -> 498
              //   778: astore 5
              //   780: aload 4
              //   782: astore 6
              //   784: aload 5
              //   786: astore 4
              //   788: aload 6
              //   790: astore 5
              //   792: goto -294 -> 498
              //   795: astore 5
              //   797: aload 4
              //   799: astore 6
              //   801: aload 5
              //   803: astore 4
              //   805: aload 6
              //   807: astore 5
              //   809: goto -311 -> 498
              //   812: astore 6
              //   814: aconst_null
              //   815: astore 4
              //   817: goto -402 -> 415
              //   820: aconst_null
              //   821: astore 4
              //   823: goto -305 -> 518
              //   826: goto -710 -> 116
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	829	0	this	1
              //   470	2	1	bool	boolean
              //   549	47	2	l	long
              //   22	461	4	localObject1	Object
              //   496	32	4	localObject2	Object
              //   539	212	4	localObject3	Object
              //   769	12	4	localObject4	Object
              //   786	36	4	localObject5	Object
              //   38	628	5	localObject6	Object
              //   740	1	5	localException1	java.lang.Exception
              //   773	1	5	localcc1	com.tencent.mm.storage.cc
              //   778	7	5	localObject7	Object
              //   790	1	5	localObject8	Object
              //   795	7	5	localObject9	Object
              //   807	1	5	localObject10	Object
              //   54	347	6	localObject11	Object
              //   413	234	6	localException2	java.lang.Exception
              //   675	51	6	localcc2	com.tencent.mm.storage.cc
              //   735	1	6	localException3	java.lang.Exception
              //   782	24	6	localObject12	Object
              //   812	1	6	localException4	java.lang.Exception
              //   6	766	7	localcc3	com.tencent.mm.storage.cc
              //   79	527	8	str	String
              //   70	497	9	localObject13	Object
              //   272	27	10	localb	com.tencent.mm.message.k.b
              // Exception table:
              //   from	to	target	type
              //   226	236	413	java/lang/Exception
              //   240	249	413	java/lang/Exception
              //   253	260	413	java/lang/Exception
              //   264	274	413	java/lang/Exception
              //   283	294	413	java/lang/Exception
              //   298	314	413	java/lang/Exception
              //   318	359	413	java/lang/Exception
              //   363	374	413	java/lang/Exception
              //   378	396	413	java/lang/Exception
              //   400	410	413	java/lang/Exception
              //   486	493	413	java/lang/Exception
              //   226	236	496	finally
              //   240	249	496	finally
              //   253	260	496	finally
              //   264	274	496	finally
              //   283	294	496	finally
              //   298	314	496	finally
              //   318	359	496	finally
              //   363	374	496	finally
              //   378	396	496	finally
              //   400	410	496	finally
              //   419	440	496	finally
              //   486	493	496	finally
              //   541	550	735	java/lang/Exception
              //   556	620	735	java/lang/Exception
              //   620	655	735	java/lang/Exception
              //   655	732	735	java/lang/Exception
              //   527	534	740	java/lang/Exception
              //   8	100	769	finally
              //   104	112	769	finally
              //   116	190	769	finally
              //   195	217	769	finally
              //   465	471	769	finally
              //   527	534	778	finally
              //   541	550	795	finally
              //   556	620	795	finally
              //   620	655	795	finally
              //   655	732	795	finally
              //   8	100	812	java/lang/Exception
              //   104	112	812	java/lang/Exception
              //   116	190	812	java/lang/Exception
              //   195	217	812	java/lang/Exception
              //   465	471	812	java/lang/Exception
            }
          });
        }
      }
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u.5
 * JD-Core Version:    0.7.0.1
 */
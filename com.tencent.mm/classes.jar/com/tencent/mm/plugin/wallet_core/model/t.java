package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.l;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class t
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private volatile x CZG;
  private com.tencent.mm.cn.h<an> CZH;
  private volatile ah CZI;
  private com.tencent.mm.cn.h<ak> CZJ;
  private com.tencent.mm.cn.h<k> CZK;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.d> CZL;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.c> CZM;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.a> CZN;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.g> CZO;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.e> CZP;
  private aa CZQ;
  private com.tencent.mm.cn.h<f> CZR;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.j> CZS;
  private com.tencent.mm.cn.h<i> CZT;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.h> CZU;
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a CZV;
  private com.tencent.mm.sdk.b.c CZW;
  private String CZX;
  private com.tencent.mm.sdk.b.c<xl> CZY;
  private com.tencent.mm.sdk.b.c<yu> CZZ;
  private cd.a vDy;
  
  static
  {
    AppMethodBeat.i(70405);
    t.class.getClassLoader();
    com.tencent.mm.compatible.util.j.vr("tenpay_utils");
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_SCENE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.a.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new t.15());
    baseDBFactories.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return i.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.h.SQL_CREATE;
      }
    });
    AppMethodBeat.o(70405);
  }
  
  public t()
  {
    AppMethodBeat.i(70383);
    this.CZG = new x();
    this.CZH = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZI = null;
    this.CZJ = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZK = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZL = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZM = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZN = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZO = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZP = new com.tencent.mm.cn.h(new t.25(this));
    this.CZQ = new aa();
    this.CZR = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZS = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZT = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZU = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.CZV = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    this.CZW = new t.5(this);
    this.CZX = "";
    this.CZY = new com.tencent.mm.sdk.b.c() {};
    this.CZZ = new t.7(this);
    this.vDy = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(70373);
        paramAnonymousa = z.a(paramAnonymousa.gqE.Fvk);
        final Map localMap = bw.M(paramAnonymousa, "sysmsg");
        if (localMap == null)
        {
          AppMethodBeat.o(70373);
          return;
        }
        int i = bt.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        ad.i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(70373);
          return;
          i = bt.getInt((String)localMap.get(".sysmsg.paymsg.WalletType"), -1);
          ad.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
          if (i >= 0)
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(339975, Integer.valueOf(i));
            AppMethodBeat.o(70373);
            return;
            i = bt.getInt((String)localMap.get(".sysmsg.paymsg.Flag"), 0);
            ad.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
            if (i == 1)
            {
              ad.i("MicroMsg.SubCoreWalletCore", "open wallet");
              u.aAx();
              AppMethodBeat.o(70373);
              return;
            }
            if (i == 2)
            {
              ad.i("MicroMsg.SubCoreWalletCore", "close wallet");
              u.aBe();
              AppMethodBeat.o(70373);
              return;
              ad.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", new Object[] { paramAnonymousa });
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajF().ay(new Runnable()
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
                  //   9: getfield 21	com/tencent/mm/plugin/wallet_core/model/t$8$1:Dab	Ljava/util/Map;
                  //   12: ldc 37
                  //   14: invokeinterface 43 2 0
                  //   19: checkcast 45	java/lang/String
                  //   22: astore_2
                  //   23: aload_0
                  //   24: getfield 21	com/tencent/mm/plugin/wallet_core/model/t$8$1:Dab	Ljava/util/Map;
                  //   27: ldc 47
                  //   29: invokeinterface 43 2 0
                  //   34: checkcast 45	java/lang/String
                  //   37: astore_3
                  //   38: aload_0
                  //   39: getfield 21	com/tencent/mm/plugin/wallet_core/model/t$8$1:Dab	Ljava/util/Map;
                  //   42: ldc 49
                  //   44: invokeinterface 43 2 0
                  //   49: checkcast 45	java/lang/String
                  //   52: astore 4
                  //   54: aload_0
                  //   55: getfield 21	com/tencent/mm/plugin/wallet_core/model/t$8$1:Dab	Ljava/util/Map;
                  //   58: ldc 51
                  //   60: invokeinterface 43 2 0
                  //   65: checkcast 45	java/lang/String
                  //   68: astore 7
                  //   70: aload_2
                  //   71: ldc 53
                  //   73: invokestatic 59	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
                  //   76: astore 6
                  //   78: aload_3
                  //   79: invokestatic 65	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
                  //   82: ifne +335 -> 417
                  //   85: aload_3
                  //   86: invokestatic 71	com/tencent/mm/model/u:aAm	()Ljava/lang/String;
                  //   89: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
                  //   92: ifne +325 -> 417
                  //   95: aload_3
                  //   96: astore_2
                  //   97: aload_3
                  //   98: invokestatic 80	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
                  //   101: ifeq +322 -> 423
                  //   104: aload_3
                  //   105: astore_2
                  //   106: ldc 82
                  //   108: ldc 84
                  //   110: iconst_5
                  //   111: anewarray 4	java/lang/Object
                  //   114: dup
                  //   115: iconst_0
                  //   116: invokestatic 71	com/tencent/mm/model/u:aAm	()Ljava/lang/String;
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
                  //   138: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   141: aload 6
                  //   143: invokestatic 95	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
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
                  //   166: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   169: new 99	java/util/ArrayList
                  //   172: dup
                  //   173: invokespecial 100	java/util/ArrayList:<init>	()V
                  //   176: astore 4
                  //   178: aload 7
                  //   180: ifnull +486 -> 666
                  //   183: ldc 102
                  //   185: invokestatic 108	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
                  //   188: checkcast 102	com/tencent/mm/plugin/messenger/foundation/a/l
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
                  //   220: new 126	com/tencent/mm/storage/bu
                  //   223: dup
                  //   224: invokespecial 127	com/tencent/mm/storage/bu:<init>	()V
                  //   227: astore 5
                  //   229: aload_2
                  //   230: astore_3
                  //   231: aload 5
                  //   233: aload_2
                  //   234: invokevirtual 131	com/tencent/mm/storage/bu:convertFrom	(Landroid/database/Cursor;)V
                  //   237: aload_2
                  //   238: astore_3
                  //   239: aload 5
                  //   241: getfield 137	com/tencent/mm/g/c/ei:field_content	Ljava/lang/String;
                  //   244: invokestatic 95	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
                  //   247: astore 8
                  //   249: aload 8
                  //   251: ifnull -44 -> 207
                  //   254: aload_2
                  //   255: astore_3
                  //   256: aload 8
                  //   258: getfield 140	com/tencent/mm/ai/k$b:hBz	Ljava/lang/String;
                  //   261: invokestatic 65	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
                  //   264: ifne -57 -> 207
                  //   267: aload_2
                  //   268: astore_3
                  //   269: aload 8
                  //   271: getfield 140	com/tencent/mm/ai/k$b:hBz	Ljava/lang/String;
                  //   274: aload 7
                  //   276: getfield 140	com/tencent/mm/ai/k$b:hBz	Ljava/lang/String;
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
                  //   299: getfield 146	com/tencent/mm/g/c/ei:field_msgId	J
                  //   302: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                  //   305: aastore
                  //   306: dup
                  //   307: iconst_1
                  //   308: aload 5
                  //   310: getfield 155	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
                  //   313: aastore
                  //   314: dup
                  //   315: iconst_2
                  //   316: aload 5
                  //   318: getfield 159	com/tencent/mm/g/c/ei:field_isSend	I
                  //   321: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                  //   324: aastore
                  //   325: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   328: aload_2
                  //   329: astore_3
                  //   330: aload 5
                  //   332: getfield 155	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
                  //   335: invokestatic 80	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
                  //   338: ifeq +101 -> 439
                  //   341: aload_2
                  //   342: astore_3
                  //   343: aload 5
                  //   345: aload 6
                  //   347: aload 5
                  //   349: getfield 137	com/tencent/mm/g/c/ei:field_content	Ljava/lang/String;
                  //   352: invokestatic 170	com/tencent/mm/model/bj:Bk	(Ljava/lang/String;)Ljava/lang/String;
                  //   355: invokestatic 173	com/tencent/mm/model/bj:aN	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
                  //   358: invokevirtual 177	com/tencent/mm/storage/bu:setContent	(Ljava/lang/String;)V
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
                  //   398: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
                  //   425: invokestatic 80	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
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
                  //   445: invokevirtual 177	com/tencent/mm/storage/bu:setContent	(Ljava/lang/String;)V
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
                  //   498: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
                  //   534: checkcast 126	com/tencent/mm/storage/bu
                  //   537: astore 4
                  //   539: ldc 82
                  //   541: ldc 218
                  //   543: iconst_2
                  //   544: anewarray 4	java/lang/Object
                  //   547: dup
                  //   548: iconst_0
                  //   549: aload 4
                  //   551: getfield 146	com/tencent/mm/g/c/ei:field_msgId	J
                  //   554: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                  //   557: aastore
                  //   558: dup
                  //   559: iconst_1
                  //   560: aload 4
                  //   562: getfield 137	com/tencent/mm/g/c/ei:field_content	Ljava/lang/String;
                  //   565: aastore
                  //   566: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                  //   569: ldc 102
                  //   571: invokestatic 108	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
                  //   574: checkcast 102	com/tencent/mm/plugin/messenger/foundation/a/l
                  //   577: invokeinterface 112 1 0
                  //   582: aload 4
                  //   584: getfield 146	com/tencent/mm/g/c/ei:field_msgId	J
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
                  //   631	1	3	localbu1	com.tencent.mm.storage.bu
                  //   635	5	3	localObject7	Object
                  //   643	1	3	localObject8	Object
                  //   647	5	3	localObject9	Object
                  //   655	1	3	localObject10	Object
                  //   52	312	4	localObject11	Object
                  //   376	136	4	localException2	java.lang.Exception
                  //   537	51	4	localbu2	com.tencent.mm.storage.bu
                  //   597	1	4	localException3	java.lang.Exception
                  //   637	17	4	localObject12	Object
                  //   659	1	4	localException4	java.lang.Exception
                  //   6	624	5	localbu3	com.tencent.mm.storage.bu
                  //   76	368	6	str	String
                  //   68	207	7	localObject13	Object
                  //   247	23	8	localb	com.tencent.mm.ai.k.b
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
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(70383);
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    AppMethodBeat.i(70402);
    boolean bool = eFs().CZV.a(paramMMActivity, parame, 1008);
    AppMethodBeat.o(70402);
    return bool;
  }
  
  public static void ad(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(70400);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (u.aAC())
    {
      localIntent.setFlags(536870912);
      ad.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.bs.d.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    if (u.aAD())
    {
      localIntent.setFlags(536870912);
      com.tencent.mm.bs.d.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    ad.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
    localIntent.setFlags(536870912);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzF, false);
    ad.i("MicroMsg.SubCoreWalletCore", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      com.tencent.mm.bs.d.b(paramContext, "mall", ".ui.MallIndexUIv2", localIntent);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajD();
      if (com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        paramContext = new l(11);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramContext, 0);
      }
      AppMethodBeat.o(70400);
      return;
      com.tencent.mm.bs.d.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
    }
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(70403);
    boolean bool = eFs().CZV.a(paramMMActivity, parame, paramInt);
    AppMethodBeat.o(70403);
    return bool;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a eFA()
  {
    AppMethodBeat.i(70392);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70392);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.a)eFs().CZN.get();
    AppMethodBeat.o(70392);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.g eFB()
  {
    AppMethodBeat.i(70393);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70393);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.g)eFs().CZO.get();
    AppMethodBeat.o(70393);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e eFC()
  {
    AppMethodBeat.i(70394);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70394);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.e)eFs().CZP.get();
    AppMethodBeat.o(70394);
    return localObject;
  }
  
  public static f eFD()
  {
    AppMethodBeat.i(70395);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70395);
      throw ((Throwable)localObject);
    }
    Object localObject = (f)eFs().CZR.get();
    AppMethodBeat.o(70395);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.j eFE()
  {
    AppMethodBeat.i(70396);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70396);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.j)eFs().CZS.get();
    AppMethodBeat.o(70396);
    return localObject;
  }
  
  public static ah eFF()
  {
    AppMethodBeat.i(70397);
    ah localah = eFs().CZI;
    AppMethodBeat.o(70397);
    return localah;
  }
  
  public static x eFG()
  {
    AppMethodBeat.i(70401);
    x localx = eFs().CZG;
    AppMethodBeat.o(70401);
    return localx;
  }
  
  public static boolean eFH()
  {
    AppMethodBeat.i(70404);
    boolean bool = u.aAF();
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDs, 0);
    ad.i("MicroMsg.SubCoreWalletCore", "isSupportMobileRemit() isCN:%s mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((bool) && (i == 1))
    {
      AppMethodBeat.o(70404);
      return true;
    }
    AppMethodBeat.o(70404);
    return false;
  }
  
  public static t eFs()
  {
    AppMethodBeat.i(70384);
    t localt = (t)com.tencent.mm.model.t.ap(t.class);
    AppMethodBeat.o(70384);
    return localt;
  }
  
  public static k eFt()
  {
    AppMethodBeat.i(70385);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70385);
      throw ((Throwable)localObject);
    }
    Object localObject = (k)eFs().CZK.get();
    AppMethodBeat.o(70385);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h eFu()
  {
    AppMethodBeat.i(70386);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70386);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.h)eFs().CZU.get();
    AppMethodBeat.o(70386);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.d eFv()
  {
    AppMethodBeat.i(70387);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70387);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.d)eFs().CZL.get();
    AppMethodBeat.o(70387);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c eFw()
  {
    AppMethodBeat.i(70388);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70388);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.c)eFs().CZM.get();
    AppMethodBeat.o(70388);
    return localObject;
  }
  
  public static i eFx()
  {
    AppMethodBeat.i(70389);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70389);
      throw ((Throwable)localObject);
    }
    Object localObject = (i)eFs().CZT.get();
    AppMethodBeat.o(70389);
    return localObject;
  }
  
  public static an eFy()
  {
    AppMethodBeat.i(70390);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70390);
      throw ((Throwable)localObject);
    }
    Object localObject = (an)eFs().CZH.get();
    AppMethodBeat.o(70390);
    return localObject;
  }
  
  public static ak eFz()
  {
    AppMethodBeat.i(70391);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70391);
      throw ((Throwable)localObject);
    }
    Object localObject = (ak)eFs().CZJ.get();
    AppMethodBeat.o(70391);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(70398);
    ad.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
    com.tencent.mm.wallet_core.c.b.fRq().init(aj.getContext());
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", this.vDy, true);
    eFy().eGo();
    this.CZI = ah.eFK();
    ah localah = this.CZI;
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", localah.oZH, true);
    com.tencent.mm.sdk.b.a.IbL.b(this.CZW);
    com.tencent.mm.sdk.b.a.IbL.b(this.CZQ);
    com.tencent.mm.sdk.b.a.IbL.b(this.CZZ);
    com.tencent.mm.sdk.b.a.IbL.b(this.CZY);
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//cleanpaycn" });
    AppMethodBeat.o(70398);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(70399);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", this.vDy, true);
    eFy().Zh();
    Object localObject = eFz();
    ((ak)localObject).DaO = null;
    ((ak)localObject).DaN.clear();
    ((ak)localObject).DaN = new ArrayList();
    localObject = this.CZI;
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", ((ah)localObject).oZH, true);
    if (ah.eO != null) {
      ah.eO.clear();
    }
    this.CZI = null;
    com.tencent.mm.sdk.b.a.IbL.d(this.CZW);
    com.tencent.mm.sdk.b.a.IbL.d(this.CZQ);
    com.tencent.mm.sdk.b.a.IbL.d(this.CZZ);
    com.tencent.mm.sdk.b.a.IbL.d(this.CZY);
    AppMethodBeat.o(70399);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    implements com.tencent.mm.pluginsdk.cmd.a
  {
    public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
    {
      AppMethodBeat.i(70382);
      paramContext = paramArrayOfString[0];
      int i = -1;
      switch (paramContext.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(70382);
          return false;
          if (paramContext.equals("//cleanpaycn")) {
            i = 0;
          }
          break;
        }
      }
      com.tencent.mm.wallet_core.c.b.fRq();
      com.tencent.mm.wallet_core.c.b.clean();
      AppMethodBeat.o(70382);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.t
 * JD-Core Version:    0.7.0.1
 */
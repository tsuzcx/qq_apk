package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.protocal.protobuf.gew;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class e
  extends p
  implements m
{
  public c.g WBe;
  private h callback;
  public int hVk;
  private int qzs;
  com.tencent.mm.am.c rr;
  private int scene;
  
  /* Error */
  public e(java.util.Map<String, Object> paramMap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	com/tencent/mm/am/p:<init>	()V
    //   4: ldc 24
    //   6: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 32	com/tencent/mm/plugin/webview/fts/e:hVk	I
    //   14: new 34	com/tencent/mm/am/c$a
    //   17: dup
    //   18: invokespecial 35	com/tencent/mm/am/c$a:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: new 37	com/tencent/mm/protocal/protobuf/gev
    //   28: dup
    //   29: invokespecial 38	com/tencent/mm/protocal/protobuf/gev:<init>	()V
    //   32: putfield 42	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   35: aload 4
    //   37: new 44	com/tencent/mm/protocal/protobuf/gew
    //   40: dup
    //   41: invokespecial 45	com/tencent/mm/protocal/protobuf/gew:<init>	()V
    //   44: putfield 48	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   47: aload 4
    //   49: ldc 50
    //   51: putfield 54	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   54: aload 4
    //   56: sipush 1866
    //   59: putfield 57	com/tencent/mm/am/c$a:funcId	I
    //   62: aload_0
    //   63: aload 4
    //   65: invokevirtual 61	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   68: putfield 63	com/tencent/mm/plugin/webview/fts/e:rr	Lcom/tencent/mm/am/c;
    //   71: aload_0
    //   72: iload_3
    //   73: putfield 65	com/tencent/mm/plugin/webview/fts/e:qzs	I
    //   76: aload_0
    //   77: iload_2
    //   78: putfield 67	com/tencent/mm/plugin/webview/fts/e:scene	I
    //   81: invokestatic 73	com/tencent/mm/plugin/websearch/api/aj:dch	()Lcom/tencent/mm/protocal/protobuf/dhb;
    //   84: astore 5
    //   86: aload_0
    //   87: getfield 63	com/tencent/mm/plugin/webview/fts/e:rr	Lcom/tencent/mm/am/c;
    //   90: getfield 79	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   93: invokestatic 85	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   96: checkcast 37	com/tencent/mm/protocal/protobuf/gev
    //   99: astore 4
    //   101: aload 5
    //   103: ifnull +25 -> 128
    //   106: aload 4
    //   108: aload 5
    //   110: getfield 91	com/tencent/mm/protocal/protobuf/dhb:ZaH	F
    //   113: f2d
    //   114: putfield 95	com/tencent/mm/protocal/protobuf/gev:accp	D
    //   117: aload 4
    //   119: aload 5
    //   121: getfield 98	com/tencent/mm/protocal/protobuf/dhb:ZaG	F
    //   124: f2d
    //   125: putfield 101	com/tencent/mm/protocal/protobuf/gev:accq	D
    //   128: aload 4
    //   130: invokestatic 105	com/tencent/mm/plugin/websearch/api/aj:gtA	()Ljava/lang/String;
    //   133: putfield 108	com/tencent/mm/protocal/protobuf/gev:accr	Ljava/lang/String;
    //   136: aload 4
    //   138: iconst_3
    //   139: invokestatic 112	com/tencent/mm/plugin/websearch/api/aj:asY	(I)I
    //   142: putfield 115	com/tencent/mm/protocal/protobuf/gev:WoG	I
    //   145: aload 4
    //   147: aload_1
    //   148: ldc 117
    //   150: invokestatic 121	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   153: putfield 124	com/tencent/mm/protocal/protobuf/gev:sessionId	Ljava/lang/String;
    //   156: aload 4
    //   158: aload_1
    //   159: ldc 125
    //   161: iconst_0
    //   162: invokestatic 129	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   165: putfield 130	com/tencent/mm/protocal/protobuf/gev:scene	I
    //   168: aload_1
    //   169: ldc 132
    //   171: invokestatic 121	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 138	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   179: ifne +113 -> 292
    //   182: new 140	org/json/JSONArray
    //   185: dup
    //   186: aload_1
    //   187: invokespecial 143	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   190: astore 5
    //   192: aload 4
    //   194: new 145	java/util/LinkedList
    //   197: dup
    //   198: invokespecial 146	java/util/LinkedList:<init>	()V
    //   201: putfield 150	com/tencent/mm/protocal/protobuf/gev:accs	Ljava/util/LinkedList;
    //   204: iconst_0
    //   205: istore_2
    //   206: iload_2
    //   207: aload 5
    //   209: invokevirtual 154	org/json/JSONArray:length	()I
    //   212: if_icmpge +80 -> 292
    //   215: aload 5
    //   217: iload_2
    //   218: invokevirtual 158	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   221: astore 6
    //   223: new 160	com/tencent/mm/protocal/protobuf/fvp
    //   226: dup
    //   227: invokespecial 161	com/tencent/mm/protocal/protobuf/fvp:<init>	()V
    //   230: astore 7
    //   232: aload 7
    //   234: aload 6
    //   236: ldc 163
    //   238: ldc 165
    //   240: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: putfield 173	com/tencent/mm/protocal/protobuf/fvp:key	Ljava/lang/String;
    //   246: aload 7
    //   248: aload 6
    //   250: ldc 175
    //   252: lconst_0
    //   253: invokevirtual 179	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   256: putfield 183	com/tencent/mm/protocal/protobuf/fvp:Zmx	J
    //   259: aload 7
    //   261: aload 6
    //   263: ldc 185
    //   265: ldc 165
    //   267: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: putfield 188	com/tencent/mm/protocal/protobuf/fvp:Zmy	Ljava/lang/String;
    //   273: aload 4
    //   275: getfield 150	com/tencent/mm/protocal/protobuf/gev:accs	Ljava/util/LinkedList;
    //   278: aload 7
    //   280: invokevirtual 192	java/util/LinkedList:push	(Ljava/lang/Object;)V
    //   283: iload_2
    //   284: iconst_1
    //   285: iadd
    //   286: istore_2
    //   287: goto -81 -> 206
    //   290: astore 5
    //   292: ldc 194
    //   294: ldc 196
    //   296: iconst_4
    //   297: anewarray 198	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload 4
    //   304: getfield 115	com/tencent/mm/protocal/protobuf/gev:WoG	I
    //   307: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 4
    //   315: getfield 124	com/tencent/mm/protocal/protobuf/gev:sessionId	Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_2
    //   321: aload 4
    //   323: getfield 130	com/tencent/mm/protocal/protobuf/gev:scene	I
    //   326: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: aastore
    //   330: dup
    //   331: iconst_3
    //   332: aload_1
    //   333: aastore
    //   334: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: ldc 24
    //   339: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	e
    //   0	343	1	paramMap	java.util.Map<String, Object>
    //   0	343	2	paramInt1	int
    //   0	343	3	paramInt2	int
    //   21	301	4	localObject1	Object
    //   84	132	5	localObject2	Object
    //   290	1	5	localException	java.lang.Exception
    //   221	41	6	localJSONObject	org.json.JSONObject
    //   230	49	7	localfvp	com.tencent.mm.protocal.protobuf.fvp
    // Exception table:
    //   from	to	target	type
    //   182	204	290	java/lang/Exception
    //   206	283	290	java/lang/Exception
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(77928);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(77928);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(77927);
    int i = this.rr.getType();
    AppMethodBeat.o(77927);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77929);
    Log.i("MicroMsg.WebSearch.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.WBe = new c.g(this.scene, (gew)c.c.b(this.rr.otC), this.qzs);
    c.g localg = this.WBe;
    paramArrayOfByte = new dlx();
    paramArrayOfByte.IJG = localg.scene;
    paramArrayOfByte.aayd = localg.hMi;
    paramArrayOfByte.aaRZ = localg.interval;
    paramArrayOfByte.aaRY = localg.HAe;
    paramArrayOfByte.aaSa = localg.qzs;
    params = null;
    try
    {
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      params = paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      label146:
      break label146;
    }
    if (params != null)
    {
      paramArrayOfByte = new u(com.tencent.mm.plugin.record.c.bzO(), c.g.atw(localg.scene));
      if (!paramArrayOfByte.jKP().jKS()) {
        paramArrayOfByte.jKP().jKY();
      }
      if (paramArrayOfByte.jKS()) {
        paramArrayOfByte.diJ();
      }
      y.f(ah.v(paramArrayOfByte.jKT()), params, params.length);
      Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", new Object[] { Integer.valueOf(localg.scene) });
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(77929);
      return;
      Log.w("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", new Object[] { Integer.valueOf(localg.scene) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.e
 * JD-Core Version:    0.7.0.1
 */
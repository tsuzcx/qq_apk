package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.dqd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public final class d
  extends n
  implements k
{
  private int AOR;
  public b.g AOT;
  private g callback;
  public int dtt;
  com.tencent.mm.al.b rr;
  private int scene;
  
  /* Error */
  public d(java.util.Map<String, Object> paramMap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	com/tencent/mm/al/n:<init>	()V
    //   4: ldc 24
    //   6: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 32	com/tencent/mm/plugin/webview/fts/d:dtt	I
    //   14: new 34	com/tencent/mm/al/b$a
    //   17: dup
    //   18: invokespecial 35	com/tencent/mm/al/b$a:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: new 37	com/tencent/mm/protocal/protobuf/dqc
    //   28: dup
    //   29: invokespecial 38	com/tencent/mm/protocal/protobuf/dqc:<init>	()V
    //   32: putfield 42	com/tencent/mm/al/b$a:gUU	Lcom/tencent/mm/bx/a;
    //   35: aload 4
    //   37: new 44	com/tencent/mm/protocal/protobuf/dqd
    //   40: dup
    //   41: invokespecial 45	com/tencent/mm/protocal/protobuf/dqd:<init>	()V
    //   44: putfield 48	com/tencent/mm/al/b$a:gUV	Lcom/tencent/mm/bx/a;
    //   47: aload 4
    //   49: ldc 50
    //   51: putfield 54	com/tencent/mm/al/b$a:uri	Ljava/lang/String;
    //   54: aload 4
    //   56: sipush 1866
    //   59: putfield 57	com/tencent/mm/al/b$a:funcId	I
    //   62: aload_0
    //   63: aload 4
    //   65: invokevirtual 61	com/tencent/mm/al/b$a:atI	()Lcom/tencent/mm/al/b;
    //   68: putfield 63	com/tencent/mm/plugin/webview/fts/d:rr	Lcom/tencent/mm/al/b;
    //   71: aload_0
    //   72: iload_3
    //   73: putfield 65	com/tencent/mm/plugin/webview/fts/d:AOR	I
    //   76: aload_0
    //   77: iload_2
    //   78: putfield 67	com/tencent/mm/plugin/webview/fts/d:scene	I
    //   81: invokestatic 73	com/tencent/mm/plugin/websearch/api/aa:bCk	()Lcom/tencent/mm/protocal/protobuf/ble;
    //   84: astore 5
    //   86: aload_0
    //   87: getfield 63	com/tencent/mm/plugin/webview/fts/d:rr	Lcom/tencent/mm/al/b;
    //   90: getfield 79	com/tencent/mm/al/b:gUS	Lcom/tencent/mm/al/b$b;
    //   93: getfield 84	com/tencent/mm/al/b$b:gUX	Lcom/tencent/mm/bx/a;
    //   96: checkcast 37	com/tencent/mm/protocal/protobuf/dqc
    //   99: astore 4
    //   101: aload 5
    //   103: ifnull +25 -> 128
    //   106: aload 4
    //   108: aload 5
    //   110: getfield 90	com/tencent/mm/protocal/protobuf/ble:COJ	F
    //   113: f2d
    //   114: putfield 94	com/tencent/mm/protocal/protobuf/dqc:EFU	D
    //   117: aload 4
    //   119: aload 5
    //   121: getfield 97	com/tencent/mm/protocal/protobuf/ble:COI	F
    //   124: f2d
    //   125: putfield 100	com/tencent/mm/protocal/protobuf/dqc:EFV	D
    //   128: aload 4
    //   130: invokestatic 104	com/tencent/mm/plugin/websearch/api/aa:cWN	()Ljava/lang/String;
    //   133: putfield 107	com/tencent/mm/protocal/protobuf/dqc:EFW	Ljava/lang/String;
    //   136: aload 4
    //   138: iconst_3
    //   139: invokestatic 111	com/tencent/mm/plugin/websearch/api/aa:Sb	(I)I
    //   142: putfield 114	com/tencent/mm/protocal/protobuf/dqc:AGn	I
    //   145: aload 4
    //   147: aload_1
    //   148: ldc 116
    //   150: invokestatic 120	com/tencent/mm/plugin/websearch/api/aa:w	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   153: putfield 123	com/tencent/mm/protocal/protobuf/dqc:sessionId	Ljava/lang/String;
    //   156: aload 4
    //   158: aload_1
    //   159: ldc 124
    //   161: iconst_0
    //   162: invokestatic 128	com/tencent/mm/plugin/websearch/api/aa:d	(Ljava/util/Map;Ljava/lang/String;I)I
    //   165: putfield 129	com/tencent/mm/protocal/protobuf/dqc:scene	I
    //   168: aload_1
    //   169: ldc 131
    //   171: invokestatic 120	com/tencent/mm/plugin/websearch/api/aa:w	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 137	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   179: ifne +113 -> 292
    //   182: new 139	org/json/JSONArray
    //   185: dup
    //   186: aload_1
    //   187: invokespecial 142	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   190: astore 5
    //   192: aload 4
    //   194: new 144	java/util/LinkedList
    //   197: dup
    //   198: invokespecial 145	java/util/LinkedList:<init>	()V
    //   201: putfield 149	com/tencent/mm/protocal/protobuf/dqc:EFX	Ljava/util/LinkedList;
    //   204: iconst_0
    //   205: istore_2
    //   206: iload_2
    //   207: aload 5
    //   209: invokevirtual 153	org/json/JSONArray:length	()I
    //   212: if_icmpge +80 -> 292
    //   215: aload 5
    //   217: iload_2
    //   218: invokevirtual 157	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   221: astore 6
    //   223: new 159	com/tencent/mm/protocal/protobuf/dix
    //   226: dup
    //   227: invokespecial 160	com/tencent/mm/protocal/protobuf/dix:<init>	()V
    //   230: astore 7
    //   232: aload 7
    //   234: aload 6
    //   236: ldc 162
    //   238: ldc 164
    //   240: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: putfield 172	com/tencent/mm/protocal/protobuf/dix:key	Ljava/lang/String;
    //   246: aload 7
    //   248: aload 6
    //   250: ldc 174
    //   252: lconst_0
    //   253: invokevirtual 178	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   256: putfield 182	com/tencent/mm/protocal/protobuf/dix:CZi	J
    //   259: aload 7
    //   261: aload 6
    //   263: ldc 184
    //   265: ldc 164
    //   267: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: putfield 187	com/tencent/mm/protocal/protobuf/dix:CZj	Ljava/lang/String;
    //   273: aload 4
    //   275: getfield 149	com/tencent/mm/protocal/protobuf/dqc:EFX	Ljava/util/LinkedList;
    //   278: aload 7
    //   280: invokevirtual 191	java/util/LinkedList:push	(Ljava/lang/Object;)V
    //   283: iload_2
    //   284: iconst_1
    //   285: iadd
    //   286: istore_2
    //   287: goto -81 -> 206
    //   290: astore 5
    //   292: ldc 193
    //   294: ldc 195
    //   296: iconst_4
    //   297: anewarray 197	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload 4
    //   304: getfield 114	com/tencent/mm/protocal/protobuf/dqc:AGn	I
    //   307: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 4
    //   315: getfield 123	com/tencent/mm/protocal/protobuf/dqc:sessionId	Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_2
    //   321: aload 4
    //   323: getfield 129	com/tencent/mm/protocal/protobuf/dqc:scene	I
    //   326: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: aastore
    //   330: dup
    //   331: iconst_3
    //   332: aload_1
    //   333: aastore
    //   334: invokestatic 208	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: ldc 24
    //   339: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	d
    //   0	343	1	paramMap	java.util.Map<String, Object>
    //   0	343	2	paramInt1	int
    //   0	343	3	paramInt2	int
    //   21	301	4	localObject1	Object
    //   84	132	5	localObject2	Object
    //   290	1	5	localException	java.lang.Exception
    //   221	41	6	localJSONObject	org.json.JSONObject
    //   230	49	7	localdix	com.tencent.mm.protocal.protobuf.dix
    // Exception table:
    //   from	to	target	type
    //   182	204	290	java/lang/Exception
    //   206	283	290	java/lang/Exception
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(77928);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77929);
    ad.i("MicroMsg.WebSearch.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.AOT = new b.g(this.scene, (dqd)this.rr.gUT.gUX, this.AOR);
    b.g localg = this.AOT;
    paramArrayOfByte = new bof();
    paramArrayOfByte.Scene = localg.scene;
    paramArrayOfByte.DLy = localg.dlu;
    paramArrayOfByte.DLB = localg.interval;
    paramArrayOfByte.DLA = localg.AOJ;
    paramArrayOfByte.DLC = localg.AOR;
    paramq = null;
    try
    {
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      paramq = paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      label146:
      break label146;
    }
    if (paramq != null)
    {
      paramArrayOfByte = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.record.b.apZ(), b.g.Sy(localg.scene));
      if (!paramArrayOfByte.fhT().exists()) {
        paramArrayOfByte.fhT().mkdirs();
      }
      if (paramArrayOfByte.exists()) {
        paramArrayOfByte.delete();
      }
      i.f(com.tencent.mm.vfs.q.B(paramArrayOfByte.fhU()), paramq, paramq.length);
      ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", new Object[] { Integer.valueOf(localg.scene) });
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(77929);
      return;
      ad.w("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", new Object[] { Integer.valueOf(localg.scene) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */
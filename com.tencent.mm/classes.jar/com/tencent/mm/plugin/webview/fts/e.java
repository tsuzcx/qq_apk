package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.record.c;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class e
  extends com.tencent.mm.an.q
  implements m
{
  private int PKP;
  public c.g PKS;
  private i callback;
  public int fPp;
  d rr;
  private int scene;
  
  /* Error */
  public e(java.util.Map<String, Object> paramMap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	com/tencent/mm/an/q:<init>	()V
    //   4: ldc 24
    //   6: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 32	com/tencent/mm/plugin/webview/fts/e:fPp	I
    //   14: new 34	com/tencent/mm/an/d$a
    //   17: dup
    //   18: invokespecial 35	com/tencent/mm/an/d$a:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: new 37	com/tencent/mm/protocal/protobuf/fii
    //   28: dup
    //   29: invokespecial 38	com/tencent/mm/protocal/protobuf/fii:<init>	()V
    //   32: putfield 42	com/tencent/mm/an/d$a:lBU	Lcom/tencent/mm/cd/a;
    //   35: aload 4
    //   37: new 44	com/tencent/mm/protocal/protobuf/fij
    //   40: dup
    //   41: invokespecial 45	com/tencent/mm/protocal/protobuf/fij:<init>	()V
    //   44: putfield 48	com/tencent/mm/an/d$a:lBV	Lcom/tencent/mm/cd/a;
    //   47: aload 4
    //   49: ldc 50
    //   51: putfield 54	com/tencent/mm/an/d$a:uri	Ljava/lang/String;
    //   54: aload 4
    //   56: sipush 1866
    //   59: putfield 57	com/tencent/mm/an/d$a:funcId	I
    //   62: aload_0
    //   63: aload 4
    //   65: invokevirtual 61	com/tencent/mm/an/d$a:bgN	()Lcom/tencent/mm/an/d;
    //   68: putfield 63	com/tencent/mm/plugin/webview/fts/e:rr	Lcom/tencent/mm/an/d;
    //   71: aload_0
    //   72: iload_3
    //   73: putfield 65	com/tencent/mm/plugin/webview/fts/e:PKP	I
    //   76: aload_0
    //   77: iload_2
    //   78: putfield 67	com/tencent/mm/plugin/webview/fts/e:scene	I
    //   81: invokestatic 73	com/tencent/mm/plugin/websearch/api/ai:czn	()Lcom/tencent/mm/protocal/protobuf/cqh;
    //   84: astore 5
    //   86: aload_0
    //   87: getfield 63	com/tencent/mm/plugin/webview/fts/e:rr	Lcom/tencent/mm/an/d;
    //   90: getfield 79	com/tencent/mm/an/d:lBR	Lcom/tencent/mm/an/d$b;
    //   93: invokestatic 85	com/tencent/mm/an/d$b:b	(Lcom/tencent/mm/an/d$b;)Lcom/tencent/mm/cd/a;
    //   96: checkcast 37	com/tencent/mm/protocal/protobuf/fii
    //   99: astore 4
    //   101: aload 5
    //   103: ifnull +25 -> 128
    //   106: aload 4
    //   108: aload 5
    //   110: getfield 91	com/tencent/mm/protocal/protobuf/cqh:ScP	F
    //   113: f2d
    //   114: putfield 95	com/tencent/mm/protocal/protobuf/fii:UIg	D
    //   117: aload 4
    //   119: aload 5
    //   121: getfield 98	com/tencent/mm/protocal/protobuf/cqh:ScO	F
    //   124: f2d
    //   125: putfield 101	com/tencent/mm/protocal/protobuf/fii:UIh	D
    //   128: aload 4
    //   130: invokestatic 105	com/tencent/mm/plugin/websearch/api/ai:anV	()Ljava/lang/String;
    //   133: putfield 108	com/tencent/mm/protocal/protobuf/fii:UIi	Ljava/lang/String;
    //   136: aload 4
    //   138: iconst_3
    //   139: invokestatic 112	com/tencent/mm/plugin/websearch/api/ai:anh	(I)I
    //   142: putfield 115	com/tencent/mm/protocal/protobuf/fii:Pyz	I
    //   145: aload 4
    //   147: aload_1
    //   148: ldc 117
    //   150: invokestatic 121	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   153: putfield 124	com/tencent/mm/protocal/protobuf/fii:sessionId	Ljava/lang/String;
    //   156: aload 4
    //   158: aload_1
    //   159: ldc 125
    //   161: iconst_0
    //   162: invokestatic 128	com/tencent/mm/plugin/websearch/api/ai:b	(Ljava/util/Map;Ljava/lang/String;I)I
    //   165: putfield 129	com/tencent/mm/protocal/protobuf/fii:scene	I
    //   168: aload_1
    //   169: ldc 131
    //   171: invokestatic 121	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 137	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
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
    //   201: putfield 149	com/tencent/mm/protocal/protobuf/fii:UIj	Ljava/util/LinkedList;
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
    //   223: new 159	com/tencent/mm/protocal/protobuf/ezm
    //   226: dup
    //   227: invokespecial 160	com/tencent/mm/protocal/protobuf/ezm:<init>	()V
    //   230: astore 7
    //   232: aload 7
    //   234: aload 6
    //   236: ldc 162
    //   238: ldc 164
    //   240: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: putfield 172	com/tencent/mm/protocal/protobuf/ezm:key	Ljava/lang/String;
    //   246: aload 7
    //   248: aload 6
    //   250: ldc 174
    //   252: lconst_0
    //   253: invokevirtual 178	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   256: putfield 182	com/tencent/mm/protocal/protobuf/ezm:SnV	J
    //   259: aload 7
    //   261: aload 6
    //   263: ldc 184
    //   265: ldc 164
    //   267: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: putfield 187	com/tencent/mm/protocal/protobuf/ezm:SnW	Ljava/lang/String;
    //   273: aload 4
    //   275: getfield 149	com/tencent/mm/protocal/protobuf/fii:UIj	Ljava/util/LinkedList;
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
    //   304: getfield 115	com/tencent/mm/protocal/protobuf/fii:Pyz	I
    //   307: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 4
    //   315: getfield 124	com/tencent/mm/protocal/protobuf/fii:sessionId	Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_2
    //   321: aload 4
    //   323: getfield 129	com/tencent/mm/protocal/protobuf/fii:scene	I
    //   326: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: aastore
    //   330: dup
    //   331: iconst_3
    //   332: aload_1
    //   333: aastore
    //   334: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: ldc 24
    //   339: invokestatic 211	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   230	49	7	localezm	com.tencent.mm.protocal.protobuf.ezm
    // Exception table:
    //   from	to	target	type
    //   182	204	290	java/lang/Exception
    //   206	283	290	java/lang/Exception
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(77928);
    this.callback = parami;
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
    this.PKS = new c.g(this.scene, (fij)d.c.b(this.rr.lBS), this.PKP);
    c.g localg = this.PKS;
    paramArrayOfByte = new cur();
    paramArrayOfByte.CPw = localg.scene;
    paramArrayOfByte.Tkw = localg.fGM;
    paramArrayOfByte.TCt = localg.interval;
    paramArrayOfByte.TCs = localg.PKI;
    paramArrayOfByte.TCu = localg.PKP;
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
      paramArrayOfByte = new com.tencent.mm.vfs.q(c.bbZ(), c.g.anC(localg.scene));
      if (!paramArrayOfByte.ifB().ifE()) {
        paramArrayOfByte.ifB().ifL();
      }
      if (paramArrayOfByte.ifE()) {
        paramArrayOfByte.cFq();
      }
      u.f(paramArrayOfByte.bOF(), params, params.length);
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
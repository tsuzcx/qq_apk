package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbu;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.IOException;

public final class d
  extends m
  implements k
{
  public int cCT;
  private f callback;
  com.tencent.mm.ai.b rr;
  private int uOZ;
  public b.g uPb;
  
  /* Error */
  public d(java.util.Map<String, Object> paramMap, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 22	com/tencent/mm/ai/m:<init>	()V
    //   4: sipush 5711
    //   7: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: iconst_m1
    //   12: putfield 30	com/tencent/mm/plugin/webview/fts/d:cCT	I
    //   15: new 32	com/tencent/mm/ai/b$a
    //   18: dup
    //   19: invokespecial 33	com/tencent/mm/ai/b$a:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: new 35	com/tencent/mm/protocal/protobuf/cvv
    //   27: dup
    //   28: invokespecial 36	com/tencent/mm/protocal/protobuf/cvv:<init>	()V
    //   31: putfield 40	com/tencent/mm/ai/b$a:fsX	Lcom/tencent/mm/bv/a;
    //   34: aload_3
    //   35: new 42	com/tencent/mm/protocal/protobuf/cvw
    //   38: dup
    //   39: invokespecial 43	com/tencent/mm/protocal/protobuf/cvw:<init>	()V
    //   42: putfield 46	com/tencent/mm/ai/b$a:fsY	Lcom/tencent/mm/bv/a;
    //   45: aload_3
    //   46: ldc 48
    //   48: putfield 52	com/tencent/mm/ai/b$a:uri	Ljava/lang/String;
    //   51: aload_3
    //   52: sipush 1866
    //   55: putfield 55	com/tencent/mm/ai/b$a:funcId	I
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 59	com/tencent/mm/ai/b$a:ado	()Lcom/tencent/mm/ai/b;
    //   63: putfield 61	com/tencent/mm/plugin/webview/fts/d:rr	Lcom/tencent/mm/ai/b;
    //   66: aload_0
    //   67: iload_2
    //   68: putfield 63	com/tencent/mm/plugin/webview/fts/d:uOZ	I
    //   71: invokestatic 69	com/tencent/mm/plugin/websearch/api/aa:acv	()Lcom/tencent/mm/protocal/protobuf/azu;
    //   74: astore 4
    //   76: aload_0
    //   77: getfield 61	com/tencent/mm/plugin/webview/fts/d:rr	Lcom/tencent/mm/ai/b;
    //   80: getfield 75	com/tencent/mm/ai/b:fsV	Lcom/tencent/mm/ai/b$b;
    //   83: getfield 80	com/tencent/mm/ai/b$b:fta	Lcom/tencent/mm/bv/a;
    //   86: checkcast 35	com/tencent/mm/protocal/protobuf/cvv
    //   89: astore_3
    //   90: aload 4
    //   92: ifnull +23 -> 115
    //   95: aload_3
    //   96: aload 4
    //   98: getfield 86	com/tencent/mm/protocal/protobuf/azu:wDi	F
    //   101: f2d
    //   102: putfield 90	com/tencent/mm/protocal/protobuf/cvv:yei	D
    //   105: aload_3
    //   106: aload 4
    //   108: getfield 93	com/tencent/mm/protocal/protobuf/azu:wDh	F
    //   111: f2d
    //   112: putfield 96	com/tencent/mm/protocal/protobuf/cvv:yej	D
    //   115: aload_3
    //   116: invokestatic 100	com/tencent/mm/plugin/websearch/api/aa:bXn	()Ljava/lang/String;
    //   119: putfield 103	com/tencent/mm/protocal/protobuf/cvv:yek	Ljava/lang/String;
    //   122: aload_3
    //   123: invokestatic 109	com/tencent/mm/plugin/appbrand/s/r:aLx	()I
    //   126: putfield 112	com/tencent/mm/protocal/protobuf/cvv:uJc	I
    //   129: aload_3
    //   130: aload_1
    //   131: ldc 114
    //   133: invokestatic 118	com/tencent/mm/plugin/websearch/api/aa:t	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   136: putfield 121	com/tencent/mm/protocal/protobuf/cvv:cpW	Ljava/lang/String;
    //   139: aload_3
    //   140: aload_1
    //   141: ldc 123
    //   143: iconst_0
    //   144: invokestatic 127	com/tencent/mm/plugin/websearch/api/aa:d	(Ljava/util/Map;Ljava/lang/String;I)I
    //   147: putfield 129	com/tencent/mm/protocal/protobuf/cvv:scene	I
    //   150: aload_1
    //   151: ldc 131
    //   153: invokestatic 118	com/tencent/mm/plugin/websearch/api/aa:t	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_1
    //   157: aload_1
    //   158: invokestatic 137	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   161: ifne +111 -> 272
    //   164: new 139	org/json/JSONArray
    //   167: dup
    //   168: aload_1
    //   169: invokespecial 142	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   172: astore 4
    //   174: aload_3
    //   175: new 144	java/util/LinkedList
    //   178: dup
    //   179: invokespecial 145	java/util/LinkedList:<init>	()V
    //   182: putfield 149	com/tencent/mm/protocal/protobuf/cvv:yel	Ljava/util/LinkedList;
    //   185: iconst_0
    //   186: istore_2
    //   187: iload_2
    //   188: aload 4
    //   190: invokevirtual 152	org/json/JSONArray:length	()I
    //   193: if_icmpge +79 -> 272
    //   196: aload 4
    //   198: iload_2
    //   199: invokevirtual 156	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   202: astore 5
    //   204: new 158	com/tencent/mm/protocal/protobuf/cpo
    //   207: dup
    //   208: invokespecial 159	com/tencent/mm/protocal/protobuf/cpo:<init>	()V
    //   211: astore 6
    //   213: aload 6
    //   215: aload 5
    //   217: ldc 161
    //   219: ldc 163
    //   221: invokevirtual 169	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: putfield 171	com/tencent/mm/protocal/protobuf/cpo:key	Ljava/lang/String;
    //   227: aload 6
    //   229: aload 5
    //   231: ldc 173
    //   233: lconst_0
    //   234: invokevirtual 177	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   237: putfield 181	com/tencent/mm/protocal/protobuf/cpo:wMM	J
    //   240: aload 6
    //   242: aload 5
    //   244: ldc 183
    //   246: ldc 163
    //   248: invokevirtual 169	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   251: putfield 186	com/tencent/mm/protocal/protobuf/cpo:wMN	Ljava/lang/String;
    //   254: aload_3
    //   255: getfield 149	com/tencent/mm/protocal/protobuf/cvv:yel	Ljava/util/LinkedList;
    //   258: aload 6
    //   260: invokevirtual 190	java/util/LinkedList:push	(Ljava/lang/Object;)V
    //   263: iload_2
    //   264: iconst_1
    //   265: iadd
    //   266: istore_2
    //   267: goto -80 -> 187
    //   270: astore 4
    //   272: ldc 192
    //   274: ldc 194
    //   276: iconst_4
    //   277: anewarray 196	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload_3
    //   283: getfield 112	com/tencent/mm/protocal/protobuf/cvv:uJc	I
    //   286: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: dup
    //   291: iconst_1
    //   292: aload_3
    //   293: getfield 121	com/tencent/mm/protocal/protobuf/cvv:cpW	Ljava/lang/String;
    //   296: aastore
    //   297: dup
    //   298: iconst_2
    //   299: aload_3
    //   300: getfield 129	com/tencent/mm/protocal/protobuf/cvv:scene	I
    //   303: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: aastore
    //   307: dup
    //   308: iconst_3
    //   309: aload_1
    //   310: aastore
    //   311: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: sipush 5711
    //   317: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	d
    //   0	321	1	paramMap	java.util.Map<String, Object>
    //   0	321	2	paramInt	int
    //   22	278	3	localObject1	Object
    //   74	123	4	localObject2	Object
    //   270	1	4	localException	java.lang.Exception
    //   202	41	5	localJSONObject	org.json.JSONObject
    //   211	48	6	localcpo	com.tencent.mm.protocal.protobuf.cpo
    // Exception table:
    //   from	to	target	type
    //   164	185	270	java/lang/Exception
    //   187	263	270	java/lang/Exception
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5712);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5712);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(153076);
    int i = this.rr.getType();
    AppMethodBeat.o(153076);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5713);
    ab.i("MicroMsg.WebSearch.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uPb = new b.g((cvw)this.rr.fsW.fta, this.uOZ);
    b.g localg = this.uPb;
    paramArrayOfByte = new bbu();
    paramArrayOfByte.Scene = localg.scene;
    paramArrayOfByte.wAa = localg.cvV;
    paramArrayOfByte.xqR = localg.interval;
    paramArrayOfByte.xqQ = localg.uOS;
    paramArrayOfByte.xqS = localg.uOZ;
    paramq = null;
    try
    {
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      paramq = paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      label143:
      break label143;
    }
    if (paramq != null)
    {
      paramArrayOfByte = new File(com.tencent.mm.plugin.record.b.YN(), b.g.JG(localg.scene));
      if (!paramArrayOfByte.getParentFile().exists()) {
        paramArrayOfByte.getParentFile().mkdirs();
      }
      if (paramArrayOfByte.exists()) {
        paramArrayOfByte.delete();
      }
      com.tencent.mm.a.e.b(paramArrayOfByte.getAbsolutePath(), paramq, paramq.length);
      ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", new Object[] { Integer.valueOf(localg.scene) });
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(5713);
      return;
      ab.w("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", new Object[] { Integer.valueOf(localg.scene) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */
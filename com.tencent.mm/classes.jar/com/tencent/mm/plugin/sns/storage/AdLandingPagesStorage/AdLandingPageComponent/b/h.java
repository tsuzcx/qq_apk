package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private c rr;
  
  /* Error */
  public h(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_3
    //   2: aload_0
    //   3: invokespecial 17	com/tencent/mm/am/p:<init>	()V
    //   6: ldc 18
    //   8: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 26	com/tencent/mm/am/c$a
    //   14: dup
    //   15: invokespecial 27	com/tencent/mm/am/c$a:<init>	()V
    //   18: astore 4
    //   20: aload 4
    //   22: new 29	com/tencent/mm/protocal/protobuf/cb
    //   25: dup
    //   26: invokespecial 30	com/tencent/mm/protocal/protobuf/cb:<init>	()V
    //   29: putfield 34	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   32: aload 4
    //   34: new 36	com/tencent/mm/protocal/protobuf/cc
    //   37: dup
    //   38: invokespecial 37	com/tencent/mm/protocal/protobuf/cc:<init>	()V
    //   41: putfield 40	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   44: aload 4
    //   46: ldc 42
    //   48: putfield 46	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   51: aload 4
    //   53: sipush 2538
    //   56: putfield 50	com/tencent/mm/am/c$a:funcId	I
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 54	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   65: putfield 56	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/b/h:rr	Lcom/tencent/mm/am/c;
    //   68: aload_0
    //   69: getfield 56	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/b/h:rr	Lcom/tencent/mm/am/c;
    //   72: getfield 62	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   75: invokestatic 68	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   78: checkcast 29	com/tencent/mm/protocal/protobuf/cb
    //   81: astore 5
    //   83: new 70	com/tencent/mm/protocal/protobuf/ca
    //   86: dup
    //   87: invokespecial 71	com/tencent/mm/protocal/protobuf/ca:<init>	()V
    //   90: astore 4
    //   92: aload 4
    //   94: iconst_2
    //   95: putfield 74	com/tencent/mm/protocal/protobuf/ca:YDU	I
    //   98: invokestatic 80	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   101: astore 6
    //   103: aload 6
    //   105: invokestatic 86	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   108: ifeq +199 -> 307
    //   111: iconst_1
    //   112: istore_3
    //   113: aload 4
    //   115: iload_3
    //   116: putfield 89	com/tencent/mm/protocal/protobuf/ca:YDR	I
    //   119: aload 4
    //   121: invokestatic 95	com/tencent/mm/plugin/sns/ad/a/a:aPk	()Ljava/lang/String;
    //   124: putfield 98	com/tencent/mm/protocal/protobuf/ca:PNk	Ljava/lang/String;
    //   127: aload 4
    //   129: invokestatic 101	com/tencent/mm/plugin/sns/ad/a/a:gZB	()Ljava/lang/String;
    //   132: putfield 104	com/tencent/mm/protocal/protobuf/ca:imei	Ljava/lang/String;
    //   135: aload 4
    //   137: invokestatic 107	com/tencent/mm/plugin/sns/ad/a/a:gZz	()Ljava/lang/String;
    //   140: putfield 110	com/tencent/mm/protocal/protobuf/ca:YDZ	Ljava/lang/String;
    //   143: aload 4
    //   145: invokestatic 115	com/tencent/mm/plugin/sns/ad/j/g:hcn	()Ljava/lang/String;
    //   148: putfield 118	com/tencent/mm/protocal/protobuf/ca:YDY	Ljava/lang/String;
    //   151: new 120	com/tencent/mm/pointers/PString
    //   154: dup
    //   155: invokespecial 121	com/tencent/mm/pointers/PString:<init>	()V
    //   158: astore 6
    //   160: aload 4
    //   162: aload_1
    //   163: aload_2
    //   164: aload 6
    //   166: invokestatic 124	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/b/h:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   169: putfield 127	com/tencent/mm/protocal/protobuf/ca:YEa	Ljava/lang/String;
    //   172: aload 4
    //   174: aload 6
    //   176: getfield 130	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   179: invokestatic 136	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   182: putfield 139	com/tencent/mm/protocal/protobuf/ca:YEb	Ljava/lang/String;
    //   185: aload 5
    //   187: aload 4
    //   189: putfield 143	com/tencent/mm/protocal/protobuf/cb:YEc	Lcom/tencent/mm/protocal/protobuf/ca;
    //   192: aload 5
    //   194: aload_1
    //   195: putfield 146	com/tencent/mm/protocal/protobuf/cb:channel	Ljava/lang/String;
    //   198: aload 5
    //   200: aload_2
    //   201: putfield 149	com/tencent/mm/protocal/protobuf/cb:content	Ljava/lang/String;
    //   204: new 151	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   211: astore_1
    //   212: aload_1
    //   213: ldc 154
    //   215: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 4
    //   220: getfield 98	com/tencent/mm/protocal/protobuf/ca:PNk	Ljava/lang/String;
    //   223: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 160
    //   228: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 4
    //   233: getfield 104	com/tencent/mm/protocal/protobuf/ca:imei	Ljava/lang/String;
    //   236: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 162
    //   241: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 4
    //   246: getfield 127	com/tencent/mm/protocal/protobuf/ca:YEa	Ljava/lang/String;
    //   249: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 164
    //   254: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 4
    //   259: getfield 139	com/tencent/mm/protocal/protobuf/ca:YEb	Ljava/lang/String;
    //   262: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 166
    //   267: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 4
    //   272: getfield 110	com/tencent/mm/protocal/protobuf/ca:YDZ	Ljava/lang/String;
    //   275: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 168
    //   280: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 4
    //   285: getfield 118	com/tencent/mm/protocal/protobuf/ca:YDY	Ljava/lang/String;
    //   288: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 170
    //   294: aload_1
    //   295: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: ldc 18
    //   303: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: return
    //   307: aload 6
    //   309: invokestatic 184	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   312: ifne -199 -> 113
    //   315: aload 6
    //   317: invokestatic 187	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   320: ifeq +8 -> 328
    //   323: iconst_3
    //   324: istore_3
    //   325: goto -212 -> 113
    //   328: aload 6
    //   330: invokestatic 190	com/tencent/mm/sdk/platformtools/NetStatusUtil:is4G	(Landroid/content/Context;)Z
    //   333: ifeq +8 -> 341
    //   336: iconst_4
    //   337: istore_3
    //   338: goto -225 -> 113
    //   341: aload 6
    //   343: invokestatic 193	com/tencent/mm/sdk/platformtools/NetStatusUtil:is5G	(Landroid/content/Context;)Z
    //   346: ifeq +39 -> 385
    //   349: iconst_5
    //   350: istore_3
    //   351: goto -238 -> 113
    //   354: astore_1
    //   355: ldc 170
    //   357: new 151	java/lang/StringBuilder
    //   360: dup
    //   361: ldc 195
    //   363: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload_1
    //   367: invokevirtual 201	java/lang/Throwable:toString	()Ljava/lang/String;
    //   370: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: ldc 18
    //   381: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: return
    //   385: iconst_0
    //   386: istore_3
    //   387: goto -274 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	h
    //   0	390	1	paramString1	String
    //   0	390	2	paramString2	String
    //   1	386	3	i	int
    //   18	266	4	localObject1	java.lang.Object
    //   81	118	5	localcb	com.tencent.mm.protocal.protobuf.cb
    //   101	241	6	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   204	301	354	finally
  }
  
  private static String b(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(306835);
    if (paramString2.contains("uxinfo")) {
      try
      {
        paramString2 = new JSONObject(paramString2).optString("uxinfo");
        if (TextUtils.isEmpty(paramString2))
        {
          Log.e("NetSceneAdLadingPageClick", "getWaid, has no uxinfo, channel=".concat(String.valueOf(paramString1)));
          AppMethodBeat.o(306835);
          return "";
        }
        paramString1 = ADInfo.getWaidPkgByUxInfo(paramString2);
        Log.i("NetSceneAdLadingPageClick", "getWaid, waidPkg=" + paramString1 + ", uxinfo=" + paramString2);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramPString.value = paramString1;
          paramString1 = b.bbr(paramString1);
          AppMethodBeat.o(306835);
          return paramString1;
        }
      }
      finally
      {
        Log.e("NetSceneAdLadingPageClick", "getWaid exop=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(306835);
    return "";
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(97149);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97149);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97148);
    int i = this.rr.getType();
    AppMethodBeat.o(97148);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97147);
    Log.i("NetSceneAdLadingPageClick", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h
 * JD-Core Version:    0.7.0.1
 */
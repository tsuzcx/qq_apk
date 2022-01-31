package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

final class b$g
{
  public String cvV;
  public long interval;
  public int scene;
  public long uOS;
  public int uOZ;
  
  public b$g()
  {
    this.scene = 0;
    this.cvV = "";
    this.interval = 0L;
    this.uOS = 0L;
    this.uOZ = 0;
  }
  
  public b$g(cvw paramcvw, int paramInt)
  {
    AppMethodBeat.i(5685);
    this.scene = 0;
    this.cvV = "";
    this.interval = 0L;
    this.uOS = 0L;
    this.uOZ = 0;
    this.scene = 201;
    this.cvV = paramcvw.cvV;
    this.interval = paramcvw.eAS;
    this.uOS = (System.currentTimeMillis() / 1000L);
    this.uOZ = paramInt;
    AppMethodBeat.o(5685);
  }
  
  static String JG(int paramInt)
  {
    AppMethodBeat.i(5687);
    String str = aa.gP(ah.getContext());
    str = "SearchGuide_" + paramInt + "-" + str;
    AppMethodBeat.o(5687);
    return str;
  }
  
  /* Error */
  public static g daA()
  {
    // Byte code:
    //   0: sipush 5686
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 96	java/io/File
    //   9: dup
    //   10: invokestatic 101	com/tencent/mm/plugin/record/b:YN	()Ljava/lang/String;
    //   13: sipush 201
    //   16: invokestatic 103	com/tencent/mm/plugin/webview/fts/b$g:JG	(I)Ljava/lang/String;
    //   19: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: iconst_0
    //   28: aload_0
    //   29: invokevirtual 112	java/io/File:length	()J
    //   32: l2i
    //   33: invokestatic 117	com/tencent/mm/a/e:i	(Ljava/lang/String;II)[B
    //   36: astore_0
    //   37: new 119	com/tencent/mm/protocal/protobuf/bbu
    //   40: dup
    //   41: invokespecial 120	com/tencent/mm/protocal/protobuf/bbu:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 124	com/tencent/mm/protocal/protobuf/bbu:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   50: pop
    //   51: new 2	com/tencent/mm/plugin/webview/fts/b$g
    //   54: dup
    //   55: invokespecial 125	com/tencent/mm/plugin/webview/fts/b$g:<init>	()V
    //   58: astore_0
    //   59: aload_0
    //   60: aload_1
    //   61: getfield 128	com/tencent/mm/protocal/protobuf/bbu:Scene	I
    //   64: putfield 21	com/tencent/mm/plugin/webview/fts/b$g:scene	I
    //   67: aload_0
    //   68: aload_1
    //   69: getfield 131	com/tencent/mm/protocal/protobuf/bbu:wAa	Ljava/lang/String;
    //   72: putfield 25	com/tencent/mm/plugin/webview/fts/b$g:cvV	Ljava/lang/String;
    //   75: aload_0
    //   76: aload_1
    //   77: getfield 134	com/tencent/mm/protocal/protobuf/bbu:xqR	J
    //   80: putfield 27	com/tencent/mm/plugin/webview/fts/b$g:interval	J
    //   83: aload_0
    //   84: aload_1
    //   85: getfield 137	com/tencent/mm/protocal/protobuf/bbu:xqQ	J
    //   88: putfield 29	com/tencent/mm/plugin/webview/fts/b$g:uOS	J
    //   91: aload_0
    //   92: aload_1
    //   93: getfield 140	com/tencent/mm/protocal/protobuf/bbu:xqS	I
    //   96: putfield 31	com/tencent/mm/plugin/webview/fts/b$g:uOZ	I
    //   99: sipush 5686
    //   102: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_0
    //   110: goto -11 -> 99
    //   113: astore_1
    //   114: goto -15 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	84	0	localObject1	Object
    //   107	1	0	localException1	java.lang.Exception
    //   109	1	0	localObject2	Object
    //   44	49	1	localbbu	com.tencent.mm.protocal.protobuf.bbu
    //   113	1	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   37	59	107	java/lang/Exception
    //   59	99	113	java/lang/Exception
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(5688);
    if (this.uOS + this.interval <= System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(5688);
      return true;
    }
    AppMethodBeat.o(5688);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.g
 * JD-Core Version:    0.7.0.1
 */
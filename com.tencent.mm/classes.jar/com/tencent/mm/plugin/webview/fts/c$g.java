package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.edl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;

final class c$g
{
  public long Ecf;
  public int Ecm;
  public String dvT;
  public long interval;
  public int scene;
  
  public c$g()
  {
    this.scene = 0;
    this.dvT = "";
    this.interval = 0L;
    this.Ecf = 0L;
    this.Ecm = 0;
  }
  
  public c$g(int paramInt1, edl paramedl, int paramInt2)
  {
    AppMethodBeat.i(197985);
    this.scene = 0;
    this.dvT = "";
    this.interval = 0L;
    this.Ecf = 0L;
    this.Ecm = 0;
    this.scene = paramInt1;
    this.dvT = paramedl.dvT;
    this.interval = paramedl.gxu;
    this.Ecf = (System.currentTimeMillis() / 1000L);
    this.Ecm = paramInt2;
    AppMethodBeat.o(197985);
  }
  
  /* Error */
  public static g Xe(int paramInt)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 64	com/tencent/mm/vfs/k
    //   8: dup
    //   9: invokestatic 70	com/tencent/mm/plugin/record/b:azT	()Ljava/lang/String;
    //   12: iload_0
    //   13: invokestatic 74	com/tencent/mm/plugin/webview/fts/c$g:Xf	(I)Ljava/lang/String;
    //   16: invokespecial 77	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 81	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   24: invokestatic 87	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   27: iconst_0
    //   28: aload_1
    //   29: invokevirtual 90	com/tencent/mm/vfs/k:length	()J
    //   32: l2i
    //   33: invokestatic 96	com/tencent/mm/vfs/o:bb	(Ljava/lang/String;II)[B
    //   36: astore_1
    //   37: new 98	com/tencent/mm/protocal/protobuf/byc
    //   40: dup
    //   41: invokespecial 99	com/tencent/mm/protocal/protobuf/byc:<init>	()V
    //   44: astore_2
    //   45: aload_2
    //   46: aload_1
    //   47: invokevirtual 103	com/tencent/mm/protocal/protobuf/byc:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   50: pop
    //   51: new 2	com/tencent/mm/plugin/webview/fts/c$g
    //   54: dup
    //   55: invokespecial 104	com/tencent/mm/plugin/webview/fts/c$g:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: aload_2
    //   61: getfield 107	com/tencent/mm/protocal/protobuf/byc:Scene	I
    //   64: putfield 21	com/tencent/mm/plugin/webview/fts/c$g:scene	I
    //   67: aload_1
    //   68: aload_2
    //   69: getfield 110	com/tencent/mm/protocal/protobuf/byc:GWB	Ljava/lang/String;
    //   72: putfield 25	com/tencent/mm/plugin/webview/fts/c$g:dvT	Ljava/lang/String;
    //   75: aload_1
    //   76: aload_2
    //   77: getfield 113	com/tencent/mm/protocal/protobuf/byc:HkS	J
    //   80: putfield 27	com/tencent/mm/plugin/webview/fts/c$g:interval	J
    //   83: aload_1
    //   84: aload_2
    //   85: getfield 116	com/tencent/mm/protocal/protobuf/byc:HkR	J
    //   88: putfield 29	com/tencent/mm/plugin/webview/fts/c$g:Ecf	J
    //   91: aload_1
    //   92: aload_2
    //   93: getfield 119	com/tencent/mm/protocal/protobuf/byc:HkT	I
    //   96: putfield 31	com/tencent/mm/plugin/webview/fts/c$g:Ecm	I
    //   99: ldc 62
    //   101: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_1
    //   105: areturn
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -10 -> 99
    //   112: astore_2
    //   113: goto -14 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramInt	int
    //   19	86	1	localObject1	Object
    //   106	1	1	localException1	java.lang.Exception
    //   108	1	1	localObject2	Object
    //   44	49	2	localbyc	com.tencent.mm.protocal.protobuf.byc
    //   112	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   37	59	106	java/lang/Exception
    //   59	99	112	java/lang/Exception
  }
  
  static String Xf(int paramInt)
  {
    AppMethodBeat.i(77896);
    String str = ad.iR(ak.getContext());
    str = "SearchGuide_" + paramInt + "-" + str;
    AppMethodBeat.o(77896);
    return str;
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(77897);
    if (this.Ecf + this.interval <= System.currentTimeMillis() / 1000L)
    {
      AppMethodBeat.o(77897);
      return true;
    }
    AppMethodBeat.o(77897);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.g
 * JD-Core Version:    0.7.0.1
 */
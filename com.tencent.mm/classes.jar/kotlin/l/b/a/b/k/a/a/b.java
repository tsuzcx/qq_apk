package kotlin.l.b.a.b.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.a.l;
import kotlin.l.b.a.b.k.a.q;
import kotlin.l.b.a.b.l.j;

public final class b
  extends q
  implements kotlin.l.b.a.b.a.b
{
  public static final a TLS;
  private final boolean TLR;
  
  static
  {
    AppMethodBeat.i(60389);
    TLS = new a((byte)0);
    AppMethodBeat.o(60389);
  }
  
  private b(kotlin.l.b.a.b.f.b paramb, j paramj, y paramy, a.l paraml, kotlin.l.b.a.b.e.a.a parama, boolean paramBoolean)
  {
    super(paramb, paramj, paramy, paraml, (kotlin.l.b.a.b.e.b.a)parama);
    AppMethodBeat.i(186260);
    this.TLR = false;
    AppMethodBeat.o(186260);
  }
  
  public static final class a
  {
    /* Error */
    public static b a(kotlin.l.b.a.b.f.b paramb, j paramj, y paramy, java.io.InputStream paramInputStream)
    {
      // Byte code:
      //   0: ldc 18
      //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ldc 26
      //   8: invokestatic 32	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload_1
      //   12: ldc 34
      //   14: invokestatic 32	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   17: aload_2
      //   18: ldc 36
      //   20: invokestatic 32	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   23: aload_3
      //   24: ldc 38
      //   26: invokestatic 32	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   29: aload_3
      //   30: checkcast 40	java/io/Closeable
      //   33: astore_3
      //   34: aload_3
      //   35: checkcast 42	java/io/InputStream
      //   38: astore 4
      //   40: getstatic 48	kotlin/l/b/a/b/e/a/a:TAB	Lkotlin/l/b/a/b/e/a/a$a;
      //   43: astore 5
      //   45: aload 4
      //   47: ldc 50
      //   49: invokestatic 32	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   52: new 52	java/io/DataInputStream
      //   55: dup
      //   56: aload 4
      //   58: invokespecial 55	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   61: astore 5
      //   63: new 57	kotlin/k/f
      //   66: dup
      //   67: iconst_1
      //   68: aload 5
      //   70: invokevirtual 61	java/io/DataInputStream:readInt	()I
      //   73: invokespecial 64	kotlin/k/f:<init>	(II)V
      //   76: checkcast 66	java/lang/Iterable
      //   79: astore 7
      //   81: new 68	java/util/ArrayList
      //   84: dup
      //   85: aload 7
      //   87: bipush 10
      //   89: invokestatic 73	kotlin/a/j:a	(Ljava/lang/Iterable;I)I
      //   92: invokespecial 75	java/util/ArrayList:<init>	(I)V
      //   95: checkcast 77	java/util/Collection
      //   98: astore 6
      //   100: aload 7
      //   102: invokeinterface 81 1 0
      //   107: astore 7
      //   109: aload 7
      //   111: invokeinterface 87 1 0
      //   116: ifeq +52 -> 168
      //   119: aload 7
      //   121: checkcast 89	kotlin/a/ab
      //   124: invokevirtual 92	kotlin/a/ab:nextInt	()I
      //   127: pop
      //   128: aload 6
      //   130: aload 5
      //   132: invokevirtual 61	java/io/DataInputStream:readInt	()I
      //   135: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   138: invokeinterface 102 2 0
      //   143: pop
      //   144: goto -35 -> 109
      //   147: astore_1
      //   148: ldc 18
      //   150: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   153: aload_1
      //   154: athrow
      //   155: astore_0
      //   156: aload_3
      //   157: aload_1
      //   158: invokestatic 110	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   161: ldc 18
      //   163: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   166: aload_0
      //   167: athrow
      //   168: aload 6
      //   170: checkcast 112	java/util/List
      //   173: checkcast 77	java/util/Collection
      //   176: invokestatic 116	kotlin/a/j:u	(Ljava/util/Collection;)[I
      //   179: astore 5
      //   181: new 44	kotlin/l/b/a/b/e/a/a
      //   184: dup
      //   185: aload 5
      //   187: aload 5
      //   189: arraylength
      //   190: invokestatic 122	java/util/Arrays:copyOf	([II)[I
      //   193: invokespecial 125	kotlin/l/b/a/b/e/a/a:<init>	([I)V
      //   196: astore 5
      //   198: aload 5
      //   200: invokevirtual 128	kotlin/l/b/a/b/e/a/a:hIi	()Z
      //   203: ifne +54 -> 257
      //   206: new 130	java/lang/UnsupportedOperationException
      //   209: dup
      //   210: new 132	java/lang/StringBuilder
      //   213: dup
      //   214: ldc 134
      //   216: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   219: getstatic 141	kotlin/l/b/a/b/e/a/a:TAz	Lkotlin/l/b/a/b/e/a/a;
      //   222: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   225: ldc 147
      //   227: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   230: aload 5
      //   232: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   235: ldc 152
      //   237: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   240: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   243: invokespecial 157	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
      //   246: checkcast 17	java/lang/Throwable
      //   249: astore_0
      //   250: ldc 18
      //   252: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   255: aload_0
      //   256: athrow
      //   257: aload 4
      //   259: getstatic 163	kotlin/l/b/a/b/k/a/a/a:TLQ	Lkotlin/l/b/a/b/k/a/a/a;
      //   262: getfield 169	kotlin/l/b/a/b/k/a:TDN	Lkotlin/l/b/a/b/h/g;
      //   265: invokestatic 175	kotlin/l/b/a/b/e/a$l:d	(Ljava/io/InputStream;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/e/a$l;
      //   268: astore 4
      //   270: aload_3
      //   271: aconst_null
      //   272: invokestatic 110	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   275: aload 4
      //   277: ldc 177
      //   279: invokestatic 180	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   282: new 6	kotlin/l/b/a/b/k/a/a/b
      //   285: dup
      //   286: aload_0
      //   287: aload_1
      //   288: aload_2
      //   289: aload 4
      //   291: aload 5
      //   293: invokespecial 183	kotlin/l/b/a/b/k/a/a/b:<init>	(Lkotlin/l/b/a/b/f/b;Lkotlin/l/b/a/b/l/j;Lkotlin/l/b/a/b/b/y;Lkotlin/l/b/a/b/e/a$l;Lkotlin/l/b/a/b/e/a/a;)V
      //   296: astore_0
      //   297: ldc 18
      //   299: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   302: aload_0
      //   303: areturn
      //   304: astore_0
      //   305: aconst_null
      //   306: astore_1
      //   307: goto -151 -> 156
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	310	0	paramb	kotlin.l.b.a.b.f.b
      //   0	310	1	paramj	j
      //   0	310	2	paramy	y
      //   0	310	3	paramInputStream	java.io.InputStream
      //   38	252	4	localObject1	Object
      //   43	249	5	localObject2	Object
      //   98	71	6	localCollection	java.util.Collection
      //   79	41	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   34	109	147	java/lang/Throwable
      //   109	144	147	java/lang/Throwable
      //   168	257	147	java/lang/Throwable
      //   257	270	147	java/lang/Throwable
      //   148	155	155	finally
      //   34	109	304	finally
      //   109	144	304	finally
      //   168	257	304	finally
      //   257	270	304	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */
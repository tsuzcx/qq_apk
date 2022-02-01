package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.n;
import kotlin.l.b.a.b.h.o;

public final class a$o$a
  extends i.a<a.o, a>
  implements q
{
  private o Tzi = n.TDQ;
  private int bOT;
  
  private a hGO()
  {
    AppMethodBeat.i(58778);
    a locala = new a().e(hGP());
    AppMethodBeat.o(58778);
    return locala;
  }
  
  private void hGQ()
  {
    AppMethodBeat.i(58782);
    if ((this.bOT & 0x1) != 1)
    {
      this.Tzi = new n(this.Tzi);
      this.bOT |= 0x1;
    }
    AppMethodBeat.o(58782);
  }
  
  /* Error */
  private a s(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 65	kotlin/l/b/a/b/e/a$o:TwL	Lkotlin/l/b/a/b/h/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 70 3 0
    //   17: checkcast 9	kotlin/l/b/a/b/e/a$o
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 44	kotlin/l/b/a/b/e/a$o$a:e	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   26: pop
    //   27: ldc 61
    //   29: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 74	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   39: checkcast 9	kotlin/l/b/a/b/e/a$o
    //   42: astore_2
    //   43: ldc 61
    //   45: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 44	kotlin/l/b/a/b/e/a$o$a:e	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   60: pop
    //   61: ldc 61
    //   63: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto -20 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	parame	kotlin.l.b.a.b.h.e
    //   0	74	2	paramg	kotlin.l.b.a.b.h.g
    //   6	64	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   7	21	34	kotlin/l/b/a/b/h/k
    //   43	50	50	finally
    //   7	21	68	finally
    //   35	43	68	finally
  }
  
  public final a e(a.o paramo)
  {
    AppMethodBeat.i(58780);
    if (paramo == a.o.hGN())
    {
      AppMethodBeat.o(58780);
      return this;
    }
    if (!a.o.c(paramo).isEmpty())
    {
      if (!this.Tzi.isEmpty()) {
        break label84;
      }
      this.Tzi = a.o.c(paramo);
      this.bOT &= 0xFFFFFFFE;
    }
    for (;;)
    {
      this.TwK = this.TwK.a(a.o.d(paramo));
      AppMethodBeat.o(58780);
      return this;
      label84:
      hGQ();
      this.Tzi.addAll(a.o.c(paramo));
    }
  }
  
  public final a.o hGP()
  {
    AppMethodBeat.i(58779);
    a.o localo = new a.o(this, (byte)0);
    if ((this.bOT & 0x1) == 1)
    {
      this.Tzi = this.Tzi.hJM();
      this.bOT &= 0xFFFFFFFE;
    }
    a.o.a(localo, this.Tzi);
    AppMethodBeat.o(58779);
    return localo;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.o.a
 * JD-Core Version:    0.7.0.1
 */
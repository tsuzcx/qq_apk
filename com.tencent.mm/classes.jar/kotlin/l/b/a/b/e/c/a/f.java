package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.l.b.a.b.e.b.a;

public final class f
  extends a
{
  public static final f abfs;
  public static final f abft;
  public static final a abfu;
  private final boolean abfr;
  
  static
  {
    AppMethodBeat.i(59244);
    abfu = new a((byte)0);
    abfs = new f(new int[] { 1, 1, 16 });
    abft = new f(new int[0]);
    AppMethodBeat.o(59244);
  }
  
  public f(int... paramVarArgs)
  {
    this(paramVarArgs, false);
    AppMethodBeat.i(59243);
    AppMethodBeat.o(59243);
  }
  
  public f(int[] paramArrayOfInt, boolean paramBoolean)
  {
    super(Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    AppMethodBeat.i(59242);
    this.abfr = paramBoolean;
    AppMethodBeat.o(59242);
  }
  
  public final boolean iMC()
  {
    AppMethodBeat.i(59241);
    if ((this.oey != 1) || (this.oez != 0))
    {
      boolean bool;
      if (this.abfr) {
        bool = a((a)abfs);
      }
      while (bool)
      {
        AppMethodBeat.o(59241);
        return true;
        if ((this.oey == 1) && (this.oez <= 4)) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    AppMethodBeat.o(59241);
    return false;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.f
 * JD-Core Version:    0.7.0.1
 */
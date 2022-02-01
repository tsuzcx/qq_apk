package d.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.e.b.a;
import java.util.Arrays;

public final class f
  extends a
{
  public static final f NpU;
  public static final f NpV;
  public static final a NpW;
  private final boolean NpT;
  
  static
  {
    AppMethodBeat.i(59244);
    NpW = new a((byte)0);
    NpU = new f(new int[] { 1, 1, 16 });
    NpV = new f(new int[0]);
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
    this.NpT = paramBoolean;
    AppMethodBeat.o(59242);
  }
  
  public final boolean gqj()
  {
    AppMethodBeat.i(59241);
    if ((this.major != 1) || (this.minor != 0))
    {
      boolean bool;
      if (this.NpT) {
        bool = a((a)NpU);
      }
      while (bool)
      {
        AppMethodBeat.o(59241);
        return true;
        if ((this.major == 1) && (this.minor <= 4)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.f
 * JD-Core Version:    0.7.0.1
 */
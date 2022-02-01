package d.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.e.b.a;
import java.util.Arrays;

public final class f
  extends a
{
  public static final f LyX;
  public static final f LyY;
  public static final a LyZ;
  private final boolean LyW;
  
  static
  {
    AppMethodBeat.i(59244);
    LyZ = new a((byte)0);
    LyX = new f(new int[] { 1, 1, 16 });
    LyY = new f(new int[0]);
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
    this.LyW = paramBoolean;
    AppMethodBeat.o(59242);
  }
  
  public final boolean fYK()
  {
    AppMethodBeat.i(59241);
    if ((this.major != 1) || (this.minor != 0))
    {
      boolean bool;
      if (this.LyW) {
        bool = a((a)LyX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.f
 * JD-Core Version:    0.7.0.1
 */
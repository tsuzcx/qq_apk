package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.l.b.a.b.e.b.a;

public final class e
  extends a
{
  public static final e.a ajed;
  public static final e ajef;
  public static final e ajeg;
  private final boolean ajee;
  
  static
  {
    AppMethodBeat.i(59244);
    ajed = new e.a((byte)0);
    ajef = new e(new int[] { 1, 5, 1 });
    ajeg = new e(new int[0]);
    AppMethodBeat.o(59244);
  }
  
  public e(int... paramVarArgs)
  {
    this(paramVarArgs, false);
    AppMethodBeat.i(59243);
    AppMethodBeat.o(59243);
  }
  
  public e(int[] paramArrayOfInt, boolean paramBoolean)
  {
    super(Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    AppMethodBeat.i(59242);
    this.ajee = paramBoolean;
    AppMethodBeat.o(59242);
  }
  
  public final boolean axM()
  {
    AppMethodBeat.i(59241);
    if ((this.rid != 1) || (this.rie != 0))
    {
      boolean bool;
      if (this.ajee) {
        bool = a((a)ajef);
      }
      while (bool)
      {
        AppMethodBeat.o(59241);
        return true;
        if ((this.rid == ajef.rid) && (this.rie <= ajef.rie + 1)) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    AppMethodBeat.o(59241);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.e
 * JD-Core Version:    0.7.0.1
 */
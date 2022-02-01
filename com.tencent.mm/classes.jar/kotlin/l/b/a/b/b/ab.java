package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ab
{
  public static final a aiGX;
  
  static
  {
    AppMethodBeat.i(56860);
    aiGY = new ab("FINAL", 0);
    aiGZ = new ab("SEALED", 1);
    aiHa = new ab("OPEN", 2);
    aiHb = new ab("ABSTRACT", 3);
    aiHc = new ab[] { aiGY, aiGZ, aiHa, aiHb };
    aiGX = new a((byte)0);
    AppMethodBeat.o(56860);
  }
  
  private ab() {}
  
  public static final class a
  {
    public static ab bY(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        return ab.aiHb;
      }
      if (paramBoolean2) {
        return ab.aiHa;
      }
      return ab.aiGY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.ab
 * JD-Core Version:    0.7.0.1
 */
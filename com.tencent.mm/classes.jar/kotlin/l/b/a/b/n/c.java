package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public final boolean isSuccess;
  
  private c(boolean paramBoolean)
  {
    this.isSuccess = paramBoolean;
  }
  
  public static final class a
    extends c
  {
    public static final a ajrU;
    
    static
    {
      AppMethodBeat.i(61279);
      ajrU = new a();
      AppMethodBeat.o(61279);
    }
    
    private a()
    {
      super((byte)0);
    }
  }
  
  public static final class b
    extends c
  {
    private final String error;
    
    public b(String paramString)
    {
      super((byte)0);
      AppMethodBeat.i(61280);
      this.error = paramString;
      AppMethodBeat.o(61280);
    }
  }
  
  public static final class c
    extends c
  {
    public static final c ajrV;
    
    static
    {
      AppMethodBeat.i(61281);
      ajrV = new c();
      AppMethodBeat.o(61281);
    }
    
    private c()
    {
      super((byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.n.c
 * JD-Core Version:    0.7.0.1
 */
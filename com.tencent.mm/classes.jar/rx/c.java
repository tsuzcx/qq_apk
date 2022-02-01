package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c<T>
{
  private static final c<Void> abNm;
  private final a abNl;
  public final Throwable throwable = null;
  private final T value = null;
  
  static
  {
    AppMethodBeat.i(90087);
    abNm = new c(a.abNp);
    AppMethodBeat.o(90087);
  }
  
  private c(a parama)
  {
    this.abNl = parama;
  }
  
  private boolean iIU()
  {
    if (this.abNl == a.abNn) {}
    for (int i = 1; (i != 0) && (this.value != null); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean iVG()
  {
    if (this.abNl == a.abNo) {}
    for (int i = 1; (i != 0) && (this.throwable != null); i = 0) {
      return true;
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(90086);
    if (paramObject == null)
    {
      AppMethodBeat.o(90086);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(90086);
      return true;
    }
    if (paramObject.getClass() != getClass())
    {
      AppMethodBeat.o(90086);
      return false;
    }
    paramObject = (c)paramObject;
    if (paramObject.abNl != this.abNl)
    {
      AppMethodBeat.o(90086);
      return false;
    }
    if ((this.value != paramObject.value) && ((this.value == null) || (!this.value.equals(paramObject.value))))
    {
      AppMethodBeat.o(90086);
      return false;
    }
    if ((this.throwable == paramObject.throwable) || ((this.throwable != null) && (this.throwable.equals(paramObject.throwable))))
    {
      AppMethodBeat.o(90086);
      return true;
    }
    AppMethodBeat.o(90086);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(90085);
    int j = this.abNl.hashCode();
    int i = j;
    if (iIU()) {
      i = j * 31 + this.value.hashCode();
    }
    j = i;
    if (iVG()) {
      j = i * 31 + this.throwable.hashCode();
    }
    AppMethodBeat.o(90085);
    return j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90084);
    Object localObject = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(this.abNl);
    if (iIU()) {
      ((StringBuilder)localObject).append(' ').append(this.value);
    }
    if (iVG()) {
      ((StringBuilder)localObject).append(' ').append(this.throwable.getMessage());
    }
    ((StringBuilder)localObject).append(']');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(90084);
    return localObject;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(90083);
      abNn = new a("OnNext", 0);
      abNo = new a("OnError", 1);
      abNp = new a("OnCompleted", 2);
      abNq = new a[] { abNn, abNo, abNp };
      AppMethodBeat.o(90083);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     rx.c
 * JD-Core Version:    0.7.0.1
 */
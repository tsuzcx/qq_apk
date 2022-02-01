package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c<T>
{
  private static final c<Void> Kon;
  public final Throwable IzS = null;
  private final a Kom;
  private final T value = null;
  
  static
  {
    AppMethodBeat.i(90087);
    Kon = new c(a.Koq);
    AppMethodBeat.o(90087);
  }
  
  private c(a parama)
  {
    this.Kom = parama;
  }
  
  private boolean fNt()
  {
    if (this.Kom == a.Kop) {}
    for (int i = 1; (i != 0) && (this.IzS != null); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean hasValue()
  {
    if (this.Kom == a.Koo) {}
    for (int i = 1; (i != 0) && (this.value != null); i = 0) {
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
    if (paramObject.Kom != this.Kom)
    {
      AppMethodBeat.o(90086);
      return false;
    }
    if ((this.value != paramObject.value) && ((this.value == null) || (!this.value.equals(paramObject.value))))
    {
      AppMethodBeat.o(90086);
      return false;
    }
    if ((this.IzS == paramObject.IzS) || ((this.IzS != null) && (this.IzS.equals(paramObject.IzS))))
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
    int j = this.Kom.hashCode();
    int i = j;
    if (hasValue()) {
      i = j * 31 + this.value.hashCode();
    }
    j = i;
    if (fNt()) {
      j = i * 31 + this.IzS.hashCode();
    }
    AppMethodBeat.o(90085);
    return j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90084);
    Object localObject = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(this.Kom);
    if (hasValue()) {
      ((StringBuilder)localObject).append(' ').append(this.value);
    }
    if (fNt()) {
      ((StringBuilder)localObject).append(' ').append(this.IzS.getMessage());
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
      Koo = new a("OnNext", 0);
      Kop = new a("OnError", 1);
      Koq = new a("OnCompleted", 2);
      Kor = new a[] { Koo, Kop, Koq };
      AppMethodBeat.o(90083);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     rx.c
 * JD-Core Version:    0.7.0.1
 */
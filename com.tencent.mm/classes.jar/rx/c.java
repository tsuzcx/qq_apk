package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c<T>
{
  private static final c<Void> MbW;
  public final Throwable KbB = null;
  private final a MbV;
  private final T value = null;
  
  static
  {
    AppMethodBeat.i(90087);
    MbW = new c(a.MbZ);
    AppMethodBeat.o(90087);
  }
  
  private c(a parama)
  {
    this.MbV = parama;
  }
  
  private boolean ggj()
  {
    if (this.MbV == a.MbY) {}
    for (int i = 1; (i != 0) && (this.KbB != null); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean hasValue()
  {
    if (this.MbV == a.MbX) {}
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
    if (paramObject.MbV != this.MbV)
    {
      AppMethodBeat.o(90086);
      return false;
    }
    if ((this.value != paramObject.value) && ((this.value == null) || (!this.value.equals(paramObject.value))))
    {
      AppMethodBeat.o(90086);
      return false;
    }
    if ((this.KbB == paramObject.KbB) || ((this.KbB != null) && (this.KbB.equals(paramObject.KbB))))
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
    int j = this.MbV.hashCode();
    int i = j;
    if (hasValue()) {
      i = j * 31 + this.value.hashCode();
    }
    j = i;
    if (ggj()) {
      j = i * 31 + this.KbB.hashCode();
    }
    AppMethodBeat.o(90085);
    return j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90084);
    Object localObject = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(this.MbV);
    if (hasValue()) {
      ((StringBuilder)localObject).append(' ').append(this.value);
    }
    if (ggj()) {
      ((StringBuilder)localObject).append(' ').append(this.KbB.getMessage());
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
      MbX = new a("OnNext", 0);
      MbY = new a("OnError", 1);
      MbZ = new a("OnCompleted", 2);
      Mca = new a[] { MbX, MbY, MbZ };
      AppMethodBeat.o(90083);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     rx.c
 * JD-Core Version:    0.7.0.1
 */
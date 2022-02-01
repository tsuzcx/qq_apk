package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c<T>
{
  private static final c<Void> UjR;
  private final a UjQ;
  public final Throwable throwable = null;
  private final T value = null;
  
  static
  {
    AppMethodBeat.i(90087);
    UjR = new c(a.UjU);
    AppMethodBeat.o(90087);
  }
  
  private c(a parama)
  {
    this.UjQ = parama;
  }
  
  private boolean hQx()
  {
    if (this.UjQ == a.UjT) {}
    for (int i = 1; (i != 0) && (this.throwable != null); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean hasValue()
  {
    if (this.UjQ == a.UjS) {}
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
    if (paramObject.UjQ != this.UjQ)
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
    int j = this.UjQ.hashCode();
    int i = j;
    if (hasValue()) {
      i = j * 31 + this.value.hashCode();
    }
    j = i;
    if (hQx()) {
      j = i * 31 + this.throwable.hashCode();
    }
    AppMethodBeat.o(90085);
    return j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90084);
    Object localObject = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(this.UjQ);
    if (hasValue()) {
      ((StringBuilder)localObject).append(' ').append(this.value);
    }
    if (hQx()) {
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
      UjS = new a("OnNext", 0);
      UjT = new a("OnError", 1);
      UjU = new a("OnCompleted", 2);
      UjV = new a[] { UjS, UjT, UjU };
      AppMethodBeat.o(90083);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.c
 * JD-Core Version:    0.7.0.1
 */
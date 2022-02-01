package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c<T>
{
  private static final c<Void> NWY;
  private final a NWX;
  public final Throwable throwable = null;
  private final T value = null;
  
  static
  {
    AppMethodBeat.i(90087);
    NWY = new c(a.NXb);
    AppMethodBeat.o(90087);
  }
  
  private c(a parama)
  {
    this.NWX = parama;
  }
  
  private boolean gyN()
  {
    if (this.NWX == a.NXa) {}
    for (int i = 1; (i != 0) && (this.throwable != null); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean hasValue()
  {
    if (this.NWX == a.NWZ) {}
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
    if (paramObject.NWX != this.NWX)
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
    int j = this.NWX.hashCode();
    int i = j;
    if (hasValue()) {
      i = j * 31 + this.value.hashCode();
    }
    j = i;
    if (gyN()) {
      j = i * 31 + this.throwable.hashCode();
    }
    AppMethodBeat.o(90085);
    return j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90084);
    Object localObject = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(this.NWX);
    if (hasValue()) {
      ((StringBuilder)localObject).append(' ').append(this.value);
    }
    if (gyN()) {
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
      NWZ = new a("OnNext", 0);
      NXa = new a("OnError", 1);
      NXb = new a("OnCompleted", 2);
      NXc = new a[] { NWZ, NXa, NXb };
      AppMethodBeat.o(90083);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.c
 * JD-Core Version:    0.7.0.1
 */
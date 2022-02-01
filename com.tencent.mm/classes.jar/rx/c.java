package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c<T>
{
  private static final c<Void> akaf;
  private final a akae;
  public final Throwable throwable = null;
  private final T value = null;
  
  static
  {
    AppMethodBeat.i(90087);
    akaf = new c(a.akai);
    AppMethodBeat.o(90087);
  }
  
  private c(a parama)
  {
    this.akae = parama;
  }
  
  private boolean kKf()
  {
    if (this.akae == a.akah) {}
    for (int i = 1; (i != 0) && (this.throwable != null); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean ktm()
  {
    if (this.akae == a.akag) {}
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
    if (paramObject.akae != this.akae)
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
    int j = this.akae.hashCode();
    int i = j;
    if (ktm()) {
      i = j * 31 + this.value.hashCode();
    }
    j = i;
    if (kKf()) {
      j = i * 31 + this.throwable.hashCode();
    }
    AppMethodBeat.o(90085);
    return j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90084);
    Object localObject = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(this.akae);
    if (ktm()) {
      ((StringBuilder)localObject).append(' ').append(this.value);
    }
    if (kKf()) {
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
      akag = new a("OnNext", 0);
      akah = new a("OnError", 1);
      akai = new a("OnCompleted", 2);
      akaj = new a[] { akag, akah, akai };
      AppMethodBeat.o(90083);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     rx.c
 * JD-Core Version:    0.7.0.1
 */
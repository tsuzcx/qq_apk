package rx;

public abstract class i<T>
  implements e<T>, j
{
  public final rx.internal.util.i abNB;
  private final i<?> abNC;
  private f abND;
  private long abNE = -9223372036854775808L;
  
  protected i()
  {
    this(null, false);
  }
  
  protected i(i<?> parami)
  {
    this(parami, true);
  }
  
  private i(i<?> parami, boolean paramBoolean)
  {
    this.abNC = parami;
    if ((paramBoolean) && (parami != null)) {}
    for (parami = parami.abNB;; parami = new rx.internal.util.i())
    {
      this.abNB = parami;
      return;
    }
  }
  
  protected final void XM(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      try
      {
        if (this.abND != null)
        {
          f localf = this.abND;
          localf.XM(paramLong);
          return;
        }
        if (this.abNE == -9223372036854775808L)
        {
          this.abNE = paramLong;
          return;
        }
      }
      finally {}
      paramLong = this.abNE + paramLong;
      if (paramLong < 0L) {
        this.abNE = 9223372036854775807L;
      } else {
        this.abNE = paramLong;
      }
    }
  }
  
  public void a(f paramf)
  {
    int j = 0;
    long l;
    try
    {
      l = this.abNE;
      this.abND = paramf;
      int i = j;
      if (this.abNC != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.abNC.a(this.abND);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.abND.XM(9223372036854775807L);
      return;
    }
    this.abND.XM(l);
  }
  
  public final void b(j paramj)
  {
    this.abNB.b(paramj);
  }
  
  public final void iVJ()
  {
    this.abNB.iVJ();
  }
  
  public final boolean iVK()
  {
    return this.abNB.abQP;
  }
  
  public void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.i
 * JD-Core Version:    0.7.0.1
 */
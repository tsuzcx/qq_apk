package rx;

public abstract class i<T>
  implements e<T>, j
{
  public final rx.internal.util.i Mcl;
  private final i<?> Mcm;
  private f Mcn;
  private long Mco = -9223372036854775808L;
  
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
    this.Mcm = parami;
    if ((paramBoolean) && (parami != null)) {}
    for (parami = parami.Mcl;; parami = new rx.internal.util.i())
    {
      this.Mcl = parami;
      return;
    }
  }
  
  protected final void CI(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      try
      {
        if (this.Mcn != null)
        {
          f localf = this.Mcn;
          localf.CI(paramLong);
          return;
        }
        if (this.Mco == -9223372036854775808L)
        {
          this.Mco = paramLong;
          return;
        }
      }
      finally {}
      paramLong = this.Mco + paramLong;
      if (paramLong < 0L) {
        this.Mco = 9223372036854775807L;
      } else {
        this.Mco = paramLong;
      }
    }
  }
  
  public void a(f paramf)
  {
    int j = 0;
    long l;
    try
    {
      l = this.Mco;
      this.Mcn = paramf;
      int i = j;
      if (this.Mcm != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.Mcm.a(this.Mcn);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.Mcn.CI(9223372036854775807L);
      return;
    }
    this.Mcn.CI(l);
  }
  
  public final void b(j paramj)
  {
    this.Mcl.b(paramj);
  }
  
  public final void ggm()
  {
    this.Mcl.ggm();
  }
  
  public final boolean ggn()
  {
    return this.Mcl.MfG;
  }
  
  public void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.i
 * JD-Core Version:    0.7.0.1
 */
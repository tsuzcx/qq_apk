package rx;

public abstract class i<T>
  implements e<T>, j
{
  public final rx.internal.util.i KoC;
  private final i<?> KoD;
  private f KoE;
  private long KoF = -9223372036854775808L;
  
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
    this.KoD = parami;
    if ((paramBoolean) && (parami != null)) {}
    for (parami = parami.KoC;; parami = new rx.internal.util.i())
    {
      this.KoC = parami;
      return;
    }
  }
  
  public void a(f paramf)
  {
    int j = 0;
    long l;
    try
    {
      l = this.KoF;
      this.KoE = paramf;
      int i = j;
      if (this.KoD != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.KoD.a(this.KoE);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.KoE.xU(9223372036854775807L);
      return;
    }
    this.KoE.xU(l);
  }
  
  public final void b(j paramj)
  {
    this.KoC.b(paramj);
  }
  
  public final void fNw()
  {
    this.KoC.fNw();
  }
  
  public final boolean fNx()
  {
    return this.KoC.KrX;
  }
  
  public void onStart() {}
  
  protected final void xU(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      try
      {
        if (this.KoE != null)
        {
          f localf = this.KoE;
          localf.xU(paramLong);
          return;
        }
        if (this.KoF == -9223372036854775808L)
        {
          this.KoF = paramLong;
          return;
        }
      }
      finally {}
      paramLong = this.KoF + paramLong;
      if (paramLong < 0L) {
        this.KoF = 9223372036854775807L;
      } else {
        this.KoF = paramLong;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.i
 * JD-Core Version:    0.7.0.1
 */
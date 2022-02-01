package rx;

public abstract class i<T>
  implements e<T>, j
{
  public final rx.internal.util.i Ous;
  private final i<?> Out;
  private f Ouu;
  private long Ouv = -9223372036854775808L;
  
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
    this.Out = parami;
    if ((paramBoolean) && (parami != null)) {}
    for (parami = parami.Ous;; parami = new rx.internal.util.i())
    {
      this.Ous = parami;
      return;
    }
  }
  
  protected final void Gq(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      try
      {
        if (this.Ouu != null)
        {
          f localf = this.Ouu;
          localf.Gq(paramLong);
          return;
        }
        if (this.Ouv == -9223372036854775808L)
        {
          this.Ouv = paramLong;
          return;
        }
      }
      finally {}
      paramLong = this.Ouv + paramLong;
      if (paramLong < 0L) {
        this.Ouv = 9223372036854775807L;
      } else {
        this.Ouv = paramLong;
      }
    }
  }
  
  public void a(f paramf)
  {
    int j = 0;
    long l;
    try
    {
      l = this.Ouv;
      this.Ouu = paramf;
      int i = j;
      if (this.Out != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.Out.a(this.Ouu);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.Ouu.Gq(9223372036854775807L);
      return;
    }
    this.Ouu.Gq(l);
  }
  
  public final void b(j paramj)
  {
    this.Ous.b(paramj);
  }
  
  public final void gDs()
  {
    this.Ous.gDs();
  }
  
  public final boolean gDt()
  {
    return this.Ous.OxN;
  }
  
  public void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.i
 * JD-Core Version:    0.7.0.1
 */
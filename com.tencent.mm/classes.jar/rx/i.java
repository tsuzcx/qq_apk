package rx;

public abstract class i<T>
  implements e<T>, j
{
  public final rx.internal.util.i NXn;
  private final i<?> NXo;
  private f NXp;
  private long NXq = -9223372036854775808L;
  
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
    this.NXo = parami;
    if ((paramBoolean) && (parami != null)) {}
    for (parami = parami.NXn;; parami = new rx.internal.util.i())
    {
      this.NXn = parami;
      return;
    }
  }
  
  protected final void FO(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      try
      {
        if (this.NXp != null)
        {
          f localf = this.NXp;
          localf.FO(paramLong);
          return;
        }
        if (this.NXq == -9223372036854775808L)
        {
          this.NXq = paramLong;
          return;
        }
      }
      finally {}
      paramLong = this.NXq + paramLong;
      if (paramLong < 0L) {
        this.NXq = 9223372036854775807L;
      } else {
        this.NXq = paramLong;
      }
    }
  }
  
  public void a(f paramf)
  {
    int j = 0;
    long l;
    try
    {
      l = this.NXq;
      this.NXp = paramf;
      int i = j;
      if (this.NXo != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.NXo.a(this.NXp);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.NXp.FO(9223372036854775807L);
      return;
    }
    this.NXp.FO(l);
  }
  
  public final void b(j paramj)
  {
    this.NXn.b(paramj);
  }
  
  public final void gyQ()
  {
    this.NXn.gyQ();
  }
  
  public final boolean gyR()
  {
    return this.NXn.OaI;
  }
  
  public void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.i
 * JD-Core Version:    0.7.0.1
 */
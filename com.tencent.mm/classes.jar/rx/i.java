package rx;

public abstract class i<T>
  implements e<T>, j
{
  public final rx.internal.util.i Ukg;
  private final i<?> Ukh;
  private f Uki;
  private long Ukj = -9223372036854775808L;
  
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
    this.Ukh = parami;
    if ((paramBoolean) && (parami != null)) {}
    for (parami = parami.Ukg;; parami = new rx.internal.util.i())
    {
      this.Ukg = parami;
      return;
    }
  }
  
  protected final void Pw(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      try
      {
        if (this.Uki != null)
        {
          f localf = this.Uki;
          localf.Pw(paramLong);
          return;
        }
        if (this.Ukj == -9223372036854775808L)
        {
          this.Ukj = paramLong;
          return;
        }
      }
      finally {}
      paramLong = this.Ukj + paramLong;
      if (paramLong < 0L) {
        this.Ukj = 9223372036854775807L;
      } else {
        this.Ukj = paramLong;
      }
    }
  }
  
  public void a(f paramf)
  {
    int j = 0;
    long l;
    try
    {
      l = this.Ukj;
      this.Uki = paramf;
      int i = j;
      if (this.Ukh != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.Ukh.a(this.Uki);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.Uki.Pw(9223372036854775807L);
      return;
    }
    this.Uki.Pw(l);
  }
  
  public final void b(j paramj)
  {
    this.Ukg.b(paramj);
  }
  
  public final void hQA()
  {
    this.Ukg.hQA();
  }
  
  public final boolean hQB()
  {
    return this.Ukg.UnB;
  }
  
  public void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.i
 * JD-Core Version:    0.7.0.1
 */
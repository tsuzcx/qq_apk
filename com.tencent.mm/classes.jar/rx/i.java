package rx;

public abstract class i<T>
  implements e<T>, j
{
  public final rx.internal.util.i akau;
  private final i<?> akav;
  private f akaw;
  private long akax = -9223372036854775808L;
  
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
    this.akav = parami;
    if ((paramBoolean) && (parami != null)) {}
    for (parami = parami.akau;; parami = new rx.internal.util.i())
    {
      this.akau = parami;
      return;
    }
  }
  
  protected final void Cp(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(paramLong)));
    }
    for (;;)
    {
      try
      {
        if (this.akaw != null)
        {
          f localf = this.akaw;
          localf.Cp(paramLong);
          return;
        }
        if (this.akax == -9223372036854775808L)
        {
          this.akax = paramLong;
          return;
        }
      }
      finally {}
      paramLong = this.akax + paramLong;
      if (paramLong < 0L) {
        this.akax = 9223372036854775807L;
      } else {
        this.akax = paramLong;
      }
    }
  }
  
  public void a(f paramf)
  {
    int j = 0;
    long l;
    try
    {
      l = this.akax;
      this.akaw = paramf;
      int i = j;
      if (this.akav != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.akav.a(this.akaw);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.akaw.Cp(9223372036854775807L);
      return;
    }
    this.akaw.Cp(l);
  }
  
  public final void b(j paramj)
  {
    this.akau.b(paramj);
  }
  
  public final void kKh()
  {
    this.akau.kKh();
  }
  
  public final boolean kKi()
  {
    return this.akau.akdH;
  }
  
  public void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.i
 * JD-Core Version:    0.7.0.1
 */
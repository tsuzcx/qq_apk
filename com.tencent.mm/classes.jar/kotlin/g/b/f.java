package kotlin.g.b;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.l.e;
import kotlin.l.n;

public abstract class f
  implements Serializable, kotlin.l.b
{
  public static final Object aiwK = ;
  protected final Object aiwE;
  private final Class aiwF;
  private final boolean aiwG;
  private transient kotlin.l.b aiwJ;
  private final String name;
  private final String signature;
  
  public f()
  {
    this(aiwK);
  }
  
  private f(Object paramObject)
  {
    this(paramObject, null, null, null, false);
  }
  
  protected f(Object paramObject, Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.aiwE = paramObject;
    this.aiwF = paramClass;
    this.name = paramString1;
    this.signature = paramString2;
    this.aiwG = paramBoolean;
  }
  
  public final Object ap(Object... paramVarArgs)
  {
    return klp().ap(paramVarArgs);
  }
  
  public e avF()
  {
    if (this.aiwF == null) {
      return null;
    }
    if (this.aiwG) {
      return ai.cy(this.aiwF);
    }
    return ai.cz(this.aiwF);
  }
  
  public final Object dA(Map paramMap)
  {
    return klp().dA(paramMap);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
  
  protected abstract kotlin.l.b klm();
  
  public final Object kln()
  {
    return this.aiwE;
  }
  
  public final kotlin.l.b klo()
  {
    kotlin.l.b localb2 = this.aiwJ;
    kotlin.l.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = klm();
      this.aiwJ = localb1;
    }
    return localb1;
  }
  
  protected kotlin.l.b klp()
  {
    kotlin.l.b localb = klo();
    if (localb == this) {
      throw new kotlin.g.b();
    }
    return localb;
  }
  
  public final List<n> klq()
  {
    return klp().klq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.f
 * JD-Core Version:    0.7.0.1
 */
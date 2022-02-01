package kotlin.g.b;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.g.b;
import kotlin.l.a;
import kotlin.l.d;
import kotlin.l.m;

public abstract class e
  implements Serializable, a
{
  public static final Object aaAY = ;
  private transient a aaAW;
  protected final Object aaAX;
  
  public e()
  {
    this(aaAY);
  }
  
  protected e(Object paramObject)
  {
    this.aaAX = paramObject;
  }
  
  public d Vc()
  {
    throw new AbstractMethodError();
  }
  
  public final Object ak(Object... paramVarArgs)
  {
    return iCa().ak(paramVarArgs);
  }
  
  public final Object cE(Map paramMap)
  {
    return iCa().cE(paramMap);
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  public String getSignature()
  {
    throw new AbstractMethodError();
  }
  
  protected abstract a iBX();
  
  public final Object iBY()
  {
    return this.aaAX;
  }
  
  public final a iBZ()
  {
    a locala2 = this.aaAW;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = iBX();
      this.aaAW = locala1;
    }
    return locala1;
  }
  
  protected a iCa()
  {
    a locala = iBZ();
    if (locala == this) {
      throw new b();
    }
    return locala;
  }
  
  public final List<m> iCb()
  {
    return iCa().iCb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.g.b.e
 * JD-Core Version:    0.7.0.1
 */
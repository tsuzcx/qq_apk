package kotlin.l.b.a.b.m;

public abstract class ba
  implements az
{
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof az)) {
        return false;
      }
      paramObject = (az)paramObject;
      if (kAM() != paramObject.kAM()) {
        return false;
      }
      if (kAN() != paramObject.kAN()) {
        return false;
      }
    } while (koG().equals(paramObject.koG()));
    return false;
  }
  
  public int hashCode()
  {
    int i = kAN().hashCode();
    int j;
    if (bg.ar(koG()))
    {
      j = i * 31;
      i = 19;
    }
    for (;;)
    {
      return i + j;
      j = i * 31;
      if (kAM()) {
        i = 17;
      } else {
        i = koG().hashCode();
      }
    }
  }
  
  public String toString()
  {
    if (kAM()) {
      return "*";
    }
    if (kAN() == bl.ajqM) {
      return koG().toString();
    }
    return kAN() + " " + koG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ba
 * JD-Core Version:    0.7.0.1
 */
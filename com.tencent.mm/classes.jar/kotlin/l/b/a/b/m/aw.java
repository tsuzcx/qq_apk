package kotlin.l.b.a.b.m;

public abstract class aw
  implements av
{
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof av)) {
        return false;
      }
      paramObject = (av)paramObject;
      if (iPZ() != paramObject.iPZ()) {
        return false;
      }
      if (iQa() != paramObject.iQa()) {
        return false;
      }
    } while (iFN().equals(paramObject.iFN()));
    return false;
  }
  
  public int hashCode()
  {
    int i = iQa().hashCode();
    int j;
    if (bc.aA(iFN()))
    {
      j = i * 31;
      i = 19;
    }
    for (;;)
    {
      return i + j;
      j = i * 31;
      if (iPZ()) {
        i = 17;
      } else {
        i = iFN().hashCode();
      }
    }
  }
  
  public String toString()
  {
    if (iPZ()) {
      return "*";
    }
    if (iQa() == bh.abrp) {
      return iFN().toString();
    }
    return iQa() + " " + iFN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aw
 * JD-Core Version:    0.7.0.1
 */
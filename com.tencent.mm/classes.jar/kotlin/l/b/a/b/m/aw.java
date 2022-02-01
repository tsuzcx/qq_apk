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
      if (hLH() != paramObject.hLH()) {
        return false;
      }
      if (hLI() != paramObject.hLI()) {
        return false;
      }
    } while (hBy().equals(paramObject.hBy()));
    return false;
  }
  
  public int hashCode()
  {
    int i = hLI().hashCode();
    int j;
    if (bc.aA(hBy()))
    {
      j = i * 31;
      i = 19;
    }
    for (;;)
    {
      return i + j;
      j = i * 31;
      if (hLH()) {
        i = 17;
      } else {
        i = hBy().hashCode();
      }
    }
  }
  
  public String toString()
  {
    if (hLH()) {
      return "*";
    }
    if (hLI() == bh.TOQ) {
      return hBy().toString();
    }
    return hLI() + " " + hBy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aw
 * JD-Core Version:    0.7.0.1
 */
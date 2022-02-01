package d.l.b.a.b.m;

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
      if (gyE() != paramObject.gyE()) {
        return false;
      }
      if (gyF() != paramObject.gyF()) {
        return false;
      }
    } while (gnW().equals(paramObject.gnW()));
    return false;
  }
  
  public int hashCode()
  {
    int i = gyF().hashCode();
    int j;
    if (bc.aB(gnW()))
    {
      j = i * 31;
      i = 19;
    }
    for (;;)
    {
      return i + j;
      j = i * 31;
      if (gyE()) {
        i = 17;
      } else {
        i = gnW().hashCode();
      }
    }
  }
  
  public String toString()
  {
    if (gyE()) {
      return "*";
    }
    if (gyF() == bh.NZW) {
      return gnW().toString();
    }
    return gyF() + " " + gnW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.aw
 * JD-Core Version:    0.7.0.1
 */
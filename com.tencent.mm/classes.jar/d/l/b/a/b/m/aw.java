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
      if (guc() != paramObject.guc()) {
        return false;
      }
      if (gud() != paramObject.gud()) {
        return false;
      }
    } while (gju().equals(paramObject.gju()));
    return false;
  }
  
  public int hashCode()
  {
    int i = gud().hashCode();
    int j;
    if (bc.aB(gju()))
    {
      j = i * 31;
      i = 19;
    }
    for (;;)
    {
      return i + j;
      j = i * 31;
      if (guc()) {
        i = 17;
      } else {
        i = gju().hashCode();
      }
    }
  }
  
  public String toString()
  {
    if (guc()) {
      return "*";
    }
    if (gud() == bh.NCP) {
      return gju().toString();
    }
    return gud() + " " + gju();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.aw
 * JD-Core Version:    0.7.0.1
 */
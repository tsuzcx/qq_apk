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
      if (fJY() != paramObject.fJY()) {
        return false;
      }
      if (fJZ() != paramObject.fJZ()) {
        return false;
      }
    } while (fzr().equals(paramObject.fzr()));
    return false;
  }
  
  public int hashCode()
  {
    int i = fJZ().hashCode();
    int j;
    if (bc.aB(fzr()))
    {
      j = i * 31;
      i = 19;
    }
    for (;;)
    {
      return i + j;
      j = i * 31;
      if (fJY()) {
        i = 17;
      } else {
        i = fzr().hashCode();
      }
    }
  }
  
  public String toString()
  {
    if (fJY()) {
      return "*";
    }
    if (fJZ() == bh.JYC) {
      return fzr().toString();
    }
    return fJZ() + " " + fzr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.aw
 * JD-Core Version:    0.7.0.1
 */
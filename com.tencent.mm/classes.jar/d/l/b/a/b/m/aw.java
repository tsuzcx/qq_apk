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
      if (gcB() != paramObject.gcB()) {
        return false;
      }
      if (gcC() != paramObject.gcC()) {
        return false;
      }
    } while (fRV().equals(paramObject.fRV()));
    return false;
  }
  
  public int hashCode()
  {
    int i = gcC().hashCode();
    int j;
    if (bc.aB(fRV()))
    {
      j = i * 31;
      i = 19;
    }
    for (;;)
    {
      return i + j;
      j = i * 31;
      if (gcB()) {
        i = 17;
      } else {
        i = fRV().hashCode();
      }
    }
  }
  
  public String toString()
  {
    if (gcB()) {
      return "*";
    }
    if (gcC() == bh.LLV) {
      return fRV().toString();
    }
    return gcC() + " " + fRV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.aw
 * JD-Core Version:    0.7.0.1
 */
package f.a.c;

public final class a
{
  public short[] xvJ;
  public int xvK;
  
  public a(int paramInt)
  {
    this.xvK = paramInt;
    this.xvJ = new short[1 << paramInt];
  }
  
  public final int a(b paramb)
  {
    int i = this.xvK;
    int j = 1;
    while (i != 0)
    {
      j = paramb.e(this.xvJ, j) + (j << 1);
      i -= 1;
    }
    return j - (1 << this.xvK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     f.a.c.a
 * JD-Core Version:    0.7.0.1
 */
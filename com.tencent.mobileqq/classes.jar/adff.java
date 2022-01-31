public class adff
  extends adfi
{
  public int a;
  public int b;
  
  public adff(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof adff));
      paramObject = (adff)paramObject;
    } while ((this.b != paramObject.b) || (this.a != paramObject.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adff
 * JD-Core Version:    0.7.0.1
 */
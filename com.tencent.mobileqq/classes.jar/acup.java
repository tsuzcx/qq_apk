public class acup
  extends acus
{
  public int a;
  public int b;
  
  public acup(int paramInt1, int paramInt2)
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
      } while (!(paramObject instanceof acup));
      paramObject = (acup)paramObject;
    } while ((this.b != paramObject.b) || (this.a != paramObject.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acup
 * JD-Core Version:    0.7.0.1
 */
public class acuk
  extends acus
{
  public int a;
  public int b;
  public int c;
  
  public acuk(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof acuk));
      paramObject = (acuk)paramObject;
    } while ((this.a != paramObject.a) || (this.c != paramObject.c) || (this.b != paramObject.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acuk
 * JD-Core Version:    0.7.0.1
 */
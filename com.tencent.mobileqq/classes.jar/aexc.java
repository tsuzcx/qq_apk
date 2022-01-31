public class aexc
  extends aexk
{
  public int a;
  public int b;
  public int c;
  
  public aexc(int paramInt1, int paramInt2, int paramInt3)
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
      } while (!(paramObject instanceof aexc));
      paramObject = (aexc)paramObject;
    } while ((this.a != paramObject.a) || (this.c != paramObject.c) || (this.b != paramObject.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexc
 * JD-Core Version:    0.7.0.1
 */
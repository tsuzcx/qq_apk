public class adfa
  extends adfi
{
  public int a;
  public int b;
  public int c;
  
  public adfa(int paramInt1, int paramInt2, int paramInt3)
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
      } while (!(paramObject instanceof adfa));
      paramObject = (adfa)paramObject;
    } while ((this.a != paramObject.a) || (this.c != paramObject.c) || (this.b != paramObject.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adfa
 * JD-Core Version:    0.7.0.1
 */
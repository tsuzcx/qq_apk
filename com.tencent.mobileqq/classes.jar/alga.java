public abstract class alga
  extends algo
{
  private int a = 1;
  private int b = 1;
  
  public alga(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 5);
  }
  
  public alga(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static boolean a(alga paramalga)
  {
    return (paramalga != null) && (paramalga.a());
  }
  
  public int a()
  {
    return this.b;
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alga
 * JD-Core Version:    0.7.0.1
 */
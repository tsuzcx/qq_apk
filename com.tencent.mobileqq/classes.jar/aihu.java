public class aihu
{
  public double a;
  public double b;
  
  public aihu(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aihu(aihu paramaihu)
  {
    a(paramaihu);
  }
  
  public void a(aihu paramaihu)
  {
    this.a = paramaihu.a;
    this.b = paramaihu.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihu
 * JD-Core Version:    0.7.0.1
 */
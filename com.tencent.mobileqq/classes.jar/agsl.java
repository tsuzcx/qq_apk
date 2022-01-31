public class agsl
{
  public double a;
  public double b;
  
  public agsl(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public agsl(agsl paramagsl)
  {
    a(paramagsl);
  }
  
  public void a(agsl paramagsl)
  {
    this.a = paramagsl.a;
    this.b = paramagsl.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsl
 * JD-Core Version:    0.7.0.1
 */
public class agxa
{
  public double a;
  public double b;
  
  public agxa(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public agxa(agxa paramagxa)
  {
    a(paramagxa);
  }
  
  public void a(agxa paramagxa)
  {
    this.a = paramagxa.a;
    this.b = paramagxa.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxa
 * JD-Core Version:    0.7.0.1
 */
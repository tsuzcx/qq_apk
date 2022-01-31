public class agwz
{
  public double a;
  public double b;
  
  public agwz(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public agwz(agwz paramagwz)
  {
    a(paramagwz);
  }
  
  public void a(agwz paramagwz)
  {
    this.a = paramagwz.a;
    this.b = paramagwz.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwz
 * JD-Core Version:    0.7.0.1
 */
public class agsk
{
  public double a;
  public double b;
  
  public agsk(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public agsk(agsk paramagsk)
  {
    a(paramagsk);
  }
  
  public void a(agsk paramagsk)
  {
    this.a = paramagsk.a;
    this.b = paramagsk.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsk
 * JD-Core Version:    0.7.0.1
 */
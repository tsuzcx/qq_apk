public class airm
{
  public double a;
  public double b;
  
  public airm(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public airm(airm paramairm)
  {
    a(paramairm);
  }
  
  public void a(airm paramairm)
  {
    this.a = paramairm.a;
    this.b = paramairm.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airm
 * JD-Core Version:    0.7.0.1
 */
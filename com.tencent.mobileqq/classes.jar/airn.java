public class airn
{
  public double a;
  public double b;
  
  public airn(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public airn(airn paramairn)
  {
    a(paramairn);
  }
  
  public void a(airn paramairn)
  {
    this.a = paramairn.a;
    this.b = paramairn.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airn
 * JD-Core Version:    0.7.0.1
 */
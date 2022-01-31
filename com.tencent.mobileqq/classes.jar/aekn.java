public class aekn
{
  public double a;
  public double b;
  
  public aekn(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aekn(aekn paramaekn)
  {
    a(paramaekn);
  }
  
  public void a(aekn paramaekn)
  {
    this.a = paramaekn.a;
    this.b = paramaekn.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aekn
 * JD-Core Version:    0.7.0.1
 */
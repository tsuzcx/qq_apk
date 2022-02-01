public class ahlv
{
  public double a;
  public double b;
  
  public ahlv(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public ahlv(ahlv paramahlv)
  {
    a(paramahlv);
  }
  
  public void a(ahlv paramahlv)
  {
    this.a = paramahlv.a;
    this.b = paramahlv.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlv
 * JD-Core Version:    0.7.0.1
 */
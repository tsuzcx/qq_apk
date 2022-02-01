public class aigp
{
  public double a;
  public double b;
  
  public aigp(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aigp(aigp paramaigp)
  {
    a(paramaigp);
  }
  
  public void a(aigp paramaigp)
  {
    this.a = paramaigp.a;
    this.b = paramaigp.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigp
 * JD-Core Version:    0.7.0.1
 */
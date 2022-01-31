public class aevg
{
  public double a;
  public double b;
  
  public aevg(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aevg(aevg paramaevg)
  {
    a(paramaevg);
  }
  
  public void a(aevg paramaevg)
  {
    this.a = paramaevg.a;
    this.b = paramaevg.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevg
 * JD-Core Version:    0.7.0.1
 */
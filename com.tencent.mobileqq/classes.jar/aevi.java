public class aevi
{
  public double a;
  public double b;
  
  public aevi(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aevi(aevi paramaevi)
  {
    a(paramaevi);
  }
  
  public void a(aevi paramaevi)
  {
    this.a = paramaevi.a;
    this.b = paramaevi.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevi
 * JD-Core Version:    0.7.0.1
 */
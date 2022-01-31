public class aevf
{
  public double a;
  public double b;
  
  public aevf(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aevf(aevf paramaevf)
  {
    a(paramaevf);
  }
  
  public void a(aevf paramaevf)
  {
    this.a = paramaevf.a;
    this.b = paramaevf.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevf
 * JD-Core Version:    0.7.0.1
 */
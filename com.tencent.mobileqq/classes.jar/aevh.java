public class aevh
{
  public double a;
  public double b;
  
  public aevh(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aevh(aevh paramaevh)
  {
    a(paramaevh);
  }
  
  public void a(aevh paramaevh)
  {
    this.a = paramaevh.a;
    this.b = paramaevh.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevh
 * JD-Core Version:    0.7.0.1
 */
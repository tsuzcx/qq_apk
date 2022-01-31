public class aekm
{
  public double a;
  public double b;
  
  public aekm(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aekm(aekm paramaekm)
  {
    a(paramaekm);
  }
  
  public void a(aekm paramaekm)
  {
    this.a = paramaekm.a;
    this.b = paramaekm.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aekm
 * JD-Core Version:    0.7.0.1
 */
public class ahlu
{
  public double a;
  public double b;
  
  public ahlu(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public ahlu(ahlu paramahlu)
  {
    a(paramahlu);
  }
  
  public void a(ahlu paramahlu)
  {
    this.a = paramahlu.a;
    this.b = paramahlu.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlu
 * JD-Core Version:    0.7.0.1
 */
public class aigo
{
  public double a;
  public double b;
  
  public aigo(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aigo(aigo paramaigo)
  {
    a(paramaigo);
  }
  
  public void a(aigo paramaigo)
  {
    this.a = paramaigo.a;
    this.b = paramaigo.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigo
 * JD-Core Version:    0.7.0.1
 */
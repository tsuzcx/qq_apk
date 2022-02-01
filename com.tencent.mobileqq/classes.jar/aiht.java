public class aiht
{
  public double a;
  public double b;
  
  public aiht(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public aiht(aiht paramaiht)
  {
    a(paramaiht);
  }
  
  public void a(aiht paramaiht)
  {
    this.a = paramaiht.a;
    this.b = paramaiht.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiht
 * JD-Core Version:    0.7.0.1
 */
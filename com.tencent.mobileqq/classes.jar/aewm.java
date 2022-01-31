public class aewm
  implements aewi
{
  public static final aewj<aewm> a;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  
  static
  {
    jdField_a_of_type_Aewj = new aewn();
  }
  
  public aewm() {}
  
  public aewm(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public aewm(aewg paramaewg)
  {
    paramaewg.a();
    this.jdField_a_of_type_Float = paramaewg.a();
    this.b = paramaewg.a();
    this.c = paramaewg.a();
    this.jdField_a_of_type_Long = paramaewg.a();
  }
  
  public aewm(aewm paramaewm)
  {
    if (paramaewm != null) {
      a(paramaewm.a(), paramaewm.b(), paramaewm.c(), 0L);
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.c = paramFloat3;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(aewg paramaewg, int paramInt)
  {
    paramaewg.a(1);
    paramaewg.a(this.jdField_a_of_type_Float);
    paramaewg.a(this.b);
    paramaewg.a(this.c);
    paramaewg.a(this.jdField_a_of_type_Long);
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void c(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void d(float paramFloat)
  {
    this.jdField_a_of_type_Float *= paramFloat;
    this.b *= paramFloat;
    this.c *= paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewm
 * JD-Core Version:    0.7.0.1
 */
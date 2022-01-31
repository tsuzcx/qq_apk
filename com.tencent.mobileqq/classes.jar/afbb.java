public class afbb
  implements afax
{
  public static final afay<afbb> a;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  
  static
  {
    jdField_a_of_type_Afay = new afbc();
  }
  
  public afbb() {}
  
  public afbb(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public afbb(afav paramafav)
  {
    paramafav.a();
    this.jdField_a_of_type_Float = paramafav.a();
    this.b = paramafav.a();
    this.c = paramafav.a();
    this.jdField_a_of_type_Long = paramafav.a();
  }
  
  public afbb(afbb paramafbb)
  {
    if (paramafbb != null) {
      a(paramafbb.a(), paramafbb.b(), paramafbb.c(), 0L);
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
  
  public void a(afav paramafav, int paramInt)
  {
    paramafav.a(1);
    paramafav.a(this.jdField_a_of_type_Float);
    paramafav.a(this.b);
    paramafav.a(this.c);
    paramafav.a(this.jdField_a_of_type_Long);
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
 * Qualified Name:     afbb
 * JD-Core Version:    0.7.0.1
 */
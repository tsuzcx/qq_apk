public class actu
  implements actq
{
  public static final actr<actu> a;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  
  static
  {
    jdField_a_of_type_Actr = new actv();
  }
  
  public actu() {}
  
  public actu(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public actu(acto paramacto)
  {
    paramacto.a();
    this.jdField_a_of_type_Float = paramacto.a();
    this.b = paramacto.a();
    this.c = paramacto.a();
    this.jdField_a_of_type_Long = paramacto.a();
  }
  
  public actu(actu paramactu)
  {
    if (paramactu != null) {
      a(paramactu.a(), paramactu.b(), paramactu.c(), 0L);
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
  
  public void a(acto paramacto, int paramInt)
  {
    paramacto.a(1);
    paramacto.a(this.jdField_a_of_type_Float);
    paramacto.a(this.b);
    paramacto.a(this.c);
    paramacto.a(this.jdField_a_of_type_Long);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     actu
 * JD-Core Version:    0.7.0.1
 */
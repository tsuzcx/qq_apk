public class agqo
  implements agqk
{
  public static final agql<agqo> a;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  
  static
  {
    jdField_a_of_type_Agql = new agqp();
  }
  
  public agqo() {}
  
  public agqo(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public agqo(agqi paramagqi)
  {
    paramagqi.a();
    this.jdField_a_of_type_Float = paramagqi.a();
    this.b = paramagqi.a();
    this.c = paramagqi.a();
    this.jdField_a_of_type_Long = paramagqi.a();
  }
  
  public agqo(agqo paramagqo)
  {
    if (paramagqo != null) {
      a(paramagqo.a(), paramagqo.b(), paramagqo.c(), 0L);
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
  
  public void a(agqi paramagqi, int paramInt)
  {
    paramagqi.a(1);
    paramagqi.a(this.jdField_a_of_type_Float);
    paramagqi.a(this.b);
    paramagqi.a(this.c);
    paramagqi.a(this.jdField_a_of_type_Long);
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
 * Qualified Name:     agqo
 * JD-Core Version:    0.7.0.1
 */
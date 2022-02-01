public class agdm
  implements agdi
{
  public static final agdj<agdm> a;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  
  static
  {
    jdField_a_of_type_Agdj = new agdn();
  }
  
  public agdm() {}
  
  public agdm(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public agdm(agdg paramagdg)
  {
    paramagdg.a();
    this.jdField_a_of_type_Float = paramagdg.a();
    this.b = paramagdg.a();
    this.c = paramagdg.a();
    this.jdField_a_of_type_Long = paramagdg.a();
  }
  
  public agdm(agdm paramagdm)
  {
    if (paramagdm != null) {
      a(paramagdm.a(), paramagdm.b(), paramagdm.c(), 0L);
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
  
  public void a(agdg paramagdg, int paramInt)
  {
    paramagdg.a(1);
    paramagdg.a(this.jdField_a_of_type_Float);
    paramagdg.a(this.b);
    paramagdg.a(this.c);
    paramagdg.a(this.jdField_a_of_type_Long);
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
 * Qualified Name:     agdm
 * JD-Core Version:    0.7.0.1
 */
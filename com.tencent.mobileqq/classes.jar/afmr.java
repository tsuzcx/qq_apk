public class afmr
{
  public float a;
  public long a;
  public float b = 0.0F;
  public float c = 0.0F;
  
  afmr()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Long = 0L;
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void a(afmr paramafmr)
  {
    this.jdField_a_of_type_Float = paramafmr.jdField_a_of_type_Float;
    this.b = paramafmr.b;
    this.c = paramafmr.c;
    this.jdField_a_of_type_Long = paramafmr.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmr
 * JD-Core Version:    0.7.0.1
 */
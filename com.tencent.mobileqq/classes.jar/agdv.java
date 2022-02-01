public class agdv
{
  public float a;
  public long a;
  public float b = 0.0F;
  public float c = 0.0F;
  
  agdv()
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
  
  void a(agdv paramagdv)
  {
    this.jdField_a_of_type_Float = paramagdv.jdField_a_of_type_Float;
    this.b = paramagdv.b;
    this.c = paramagdv.c;
    this.jdField_a_of_type_Long = paramagdv.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdv
 * JD-Core Version:    0.7.0.1
 */
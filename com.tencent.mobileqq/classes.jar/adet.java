public class adet
{
  public float a;
  public long a;
  public float b = 0.0F;
  public float c = 0.0F;
  
  adet()
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
  
  void a(adet paramadet)
  {
    this.jdField_a_of_type_Float = paramadet.jdField_a_of_type_Float;
    this.b = paramadet.b;
    this.c = paramadet.c;
    this.jdField_a_of_type_Long = paramadet.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adet
 * JD-Core Version:    0.7.0.1
 */
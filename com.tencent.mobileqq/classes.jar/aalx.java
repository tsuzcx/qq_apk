import android.support.annotation.FloatRange;

public class aalx
{
  private float jdField_a_of_type_Float = 1.0F;
  private aalw jdField_a_of_type_Aalw = new aalw();
  
  public aalw a()
  {
    aalw.b(this.jdField_a_of_type_Aalw, this.jdField_a_of_type_Float - aalw.a(this.jdField_a_of_type_Aalw));
    return this.jdField_a_of_type_Aalw;
  }
  
  public aalx a(@FloatRange(from=0.01D) float paramFloat)
  {
    aalw.a(this.jdField_a_of_type_Aalw, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalx
 * JD-Core Version:    0.7.0.1
 */
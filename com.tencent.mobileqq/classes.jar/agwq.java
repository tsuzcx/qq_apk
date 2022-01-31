import com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter;

public class agwq
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public agwq(DanceGameReporter paramDanceGameReporter, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.b * 100 / this.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agwq
 * JD-Core Version:    0.7.0.1
 */
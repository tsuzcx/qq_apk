public class alhf
{
  private static volatile alhf jdField_a_of_type_Alhf;
  private boolean jdField_a_of_type_Boolean;
  
  public static alhf a()
  {
    if (jdField_a_of_type_Alhf == null) {}
    try
    {
      if (jdField_a_of_type_Alhf == null) {
        jdField_a_of_type_Alhf = new alhf();
      }
      return jdField_a_of_type_Alhf;
    }
    finally {}
  }
  
  public void a(alhh paramalhh)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramalhh != null) {
        paramalhh.a(true);
      }
      return;
    }
    bdgx.a().a("tensorflowlite_jni", new alhg(this, paramalhh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhf
 * JD-Core Version:    0.7.0.1
 */
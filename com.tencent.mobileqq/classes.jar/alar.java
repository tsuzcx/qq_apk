public class alar
{
  private static volatile alar jdField_a_of_type_Alar;
  private boolean jdField_a_of_type_Boolean;
  
  public static alar a()
  {
    if (jdField_a_of_type_Alar == null) {}
    try
    {
      if (jdField_a_of_type_Alar == null) {
        jdField_a_of_type_Alar = new alar();
      }
      return jdField_a_of_type_Alar;
    }
    finally {}
  }
  
  public void a(alat paramalat)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramalat != null) {
        paramalat.a(true);
      }
      return;
    }
    bdgh.a().a("tensorflowlite_jni", new alas(this, paramalat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alar
 * JD-Core Version:    0.7.0.1
 */
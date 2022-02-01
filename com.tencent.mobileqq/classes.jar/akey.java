public class akey
{
  private static volatile akey jdField_a_of_type_Akey;
  private boolean jdField_a_of_type_Boolean;
  
  public static akey a()
  {
    if (jdField_a_of_type_Akey == null) {}
    try
    {
      if (jdField_a_of_type_Akey == null) {
        jdField_a_of_type_Akey = new akey();
      }
      return jdField_a_of_type_Akey;
    }
    finally {}
  }
  
  public void a(akfa paramakfa)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramakfa != null) {
        paramakfa.a(true);
      }
      return;
    }
    bbzm.a().a("tensorflowlite_jni", new akez(this, paramakfa));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akey
 * JD-Core Version:    0.7.0.1
 */
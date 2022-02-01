public class akvq
{
  private static volatile akvq jdField_a_of_type_Akvq;
  private boolean jdField_a_of_type_Boolean;
  
  public static akvq a()
  {
    if (jdField_a_of_type_Akvq == null) {}
    try
    {
      if (jdField_a_of_type_Akvq == null) {
        jdField_a_of_type_Akvq = new akvq();
      }
      return jdField_a_of_type_Akvq;
    }
    finally {}
  }
  
  public void a(akvs paramakvs)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramakvs != null) {
        paramakvs.a(true);
      }
      return;
    }
    bcof.a().a("tensorflowlite_jni", new akvr(this, paramakvs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvq
 * JD-Core Version:    0.7.0.1
 */
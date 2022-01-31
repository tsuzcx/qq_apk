import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class abbl
{
  private static int jdField_a_of_type_Int;
  private static abbl jdField_a_of_type_Abbl;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  azwp jdField_a_of_type_Azwp;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private abbl b;
  
  static abbl a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Abbl != null)
      {
        abbl localabbl = jdField_a_of_type_Abbl;
        jdField_a_of_type_Abbl = localabbl.b;
        localabbl.b = null;
        jdField_a_of_type_Int -= 1;
        return localabbl;
      }
      return new abbl();
    }
  }
  
  static abbl a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    abbl localabbl = a();
    localabbl.jdField_a_of_type_JavaLangString = paramString;
    azwp localazwp = localabbl.a();
    if (localazwp != null) {
      localazwp.a();
    }
    localabbl.jdField_a_of_type_Azwp = azwp.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localabbl.jdField_a_of_type_Boolean = false;
    return localabbl;
  }
  
  azwp a()
  {
    if (this.jdField_a_of_type_Azwp == null) {
      return null;
    }
    return this.jdField_a_of_type_Azwp;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((azwp)???).a();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Abbl;
        jdField_a_of_type_Abbl = this;
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(String paramString)
  {
    return (!this.jdField_a_of_type_Boolean) && (paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abbl
 * JD-Core Version:    0.7.0.1
 */
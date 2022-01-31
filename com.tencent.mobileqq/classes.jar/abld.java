import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class abld
{
  private static int jdField_a_of_type_Int;
  private static abld jdField_a_of_type_Abld;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  bayh jdField_a_of_type_Bayh;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private abld b;
  
  static abld a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Abld != null)
      {
        abld localabld = jdField_a_of_type_Abld;
        jdField_a_of_type_Abld = localabld.b;
        localabld.b = null;
        jdField_a_of_type_Int -= 1;
        return localabld;
      }
      return new abld();
    }
  }
  
  static abld a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    abld localabld = a();
    localabld.jdField_a_of_type_JavaLangString = paramString;
    bayh localbayh = localabld.a();
    if (localbayh != null) {
      localbayh.a();
    }
    localabld.jdField_a_of_type_Bayh = bayh.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localabld.jdField_a_of_type_Boolean = false;
    return localabld;
  }
  
  bayh a()
  {
    if (this.jdField_a_of_type_Bayh == null) {
      return null;
    }
    return this.jdField_a_of_type_Bayh;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((bayh)???).a();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Abld;
        jdField_a_of_type_Abld = this;
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
 * Qualified Name:     abld
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ablh
{
  private static int jdField_a_of_type_Int;
  private static ablh jdField_a_of_type_Ablh;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  baxt jdField_a_of_type_Baxt;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private ablh b;
  
  static ablh a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ablh != null)
      {
        ablh localablh = jdField_a_of_type_Ablh;
        jdField_a_of_type_Ablh = localablh.b;
        localablh.b = null;
        jdField_a_of_type_Int -= 1;
        return localablh;
      }
      return new ablh();
    }
  }
  
  static ablh a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    ablh localablh = a();
    localablh.jdField_a_of_type_JavaLangString = paramString;
    baxt localbaxt = localablh.a();
    if (localbaxt != null) {
      localbaxt.a();
    }
    localablh.jdField_a_of_type_Baxt = baxt.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localablh.jdField_a_of_type_Boolean = false;
    return localablh;
  }
  
  baxt a()
  {
    if (this.jdField_a_of_type_Baxt == null) {
      return null;
    }
    return this.jdField_a_of_type_Baxt;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((baxt)???).a();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Ablh;
        jdField_a_of_type_Ablh = this;
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
 * Qualified Name:     ablh
 * JD-Core Version:    0.7.0.1
 */
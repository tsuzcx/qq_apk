import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aewo
{
  private static int jdField_a_of_type_Int;
  private static aewo jdField_a_of_type_Aewo;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  aoot jdField_a_of_type_Aoot;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private aewo b;
  
  static aewo a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aewo != null)
      {
        aewo localaewo = jdField_a_of_type_Aewo;
        jdField_a_of_type_Aewo = localaewo.b;
        localaewo.b = null;
        jdField_a_of_type_Int -= 1;
        return localaewo;
      }
      return new aewo();
    }
  }
  
  static aewo a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    aewo localaewo = a();
    localaewo.jdField_a_of_type_JavaLangString = paramString;
    aoot localaoot = localaewo.a();
    if (localaoot != null) {
      localaoot.b();
    }
    localaewo.jdField_a_of_type_Aoot = aoot.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localaewo.jdField_a_of_type_Boolean = false;
    return localaewo;
  }
  
  aoot a()
  {
    if (this.jdField_a_of_type_Aoot == null) {
      return null;
    }
    return this.jdField_a_of_type_Aoot;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((aoot)???).b();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Aewo;
        jdField_a_of_type_Aewo = this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewo
 * JD-Core Version:    0.7.0.1
 */
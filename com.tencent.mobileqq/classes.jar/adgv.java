import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class adgv
{
  private static int jdField_a_of_type_Int;
  private static adgv jdField_a_of_type_Adgv;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  bdbk jdField_a_of_type_Bdbk;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private adgv b;
  
  static adgv a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Adgv != null)
      {
        adgv localadgv = jdField_a_of_type_Adgv;
        jdField_a_of_type_Adgv = localadgv.b;
        localadgv.b = null;
        jdField_a_of_type_Int -= 1;
        return localadgv;
      }
      return new adgv();
    }
  }
  
  static adgv a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    adgv localadgv = a();
    localadgv.jdField_a_of_type_JavaLangString = paramString;
    bdbk localbdbk = localadgv.a();
    if (localbdbk != null) {
      localbdbk.a();
    }
    localadgv.jdField_a_of_type_Bdbk = bdbk.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localadgv.jdField_a_of_type_Boolean = false;
    return localadgv;
  }
  
  bdbk a()
  {
    if (this.jdField_a_of_type_Bdbk == null) {
      return null;
    }
    return this.jdField_a_of_type_Bdbk;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((bdbk)???).a();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Adgv;
        jdField_a_of_type_Adgv = this;
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
 * Qualified Name:     adgv
 * JD-Core Version:    0.7.0.1
 */
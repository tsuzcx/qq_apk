import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class adcg
{
  private static int jdField_a_of_type_Int;
  private static adcg jdField_a_of_type_Adcg;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  bcxb jdField_a_of_type_Bcxb;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private adcg b;
  
  static adcg a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Adcg != null)
      {
        adcg localadcg = jdField_a_of_type_Adcg;
        jdField_a_of_type_Adcg = localadcg.b;
        localadcg.b = null;
        jdField_a_of_type_Int -= 1;
        return localadcg;
      }
      return new adcg();
    }
  }
  
  static adcg a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    adcg localadcg = a();
    localadcg.jdField_a_of_type_JavaLangString = paramString;
    bcxb localbcxb = localadcg.a();
    if (localbcxb != null) {
      localbcxb.a();
    }
    localadcg.jdField_a_of_type_Bcxb = bcxb.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localadcg.jdField_a_of_type_Boolean = false;
    return localadcg;
  }
  
  bcxb a()
  {
    if (this.jdField_a_of_type_Bcxb == null) {
      return null;
    }
    return this.jdField_a_of_type_Bcxb;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((bcxb)???).a();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Adcg;
        jdField_a_of_type_Adcg = this;
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
 * Qualified Name:     adcg
 * JD-Core Version:    0.7.0.1
 */
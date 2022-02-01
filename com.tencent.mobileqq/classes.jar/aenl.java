import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aenl
{
  private static int jdField_a_of_type_Int;
  private static aenl jdField_a_of_type_Aenl;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  aoch jdField_a_of_type_Aoch;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private aenl b;
  
  static aenl a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aenl != null)
      {
        aenl localaenl = jdField_a_of_type_Aenl;
        jdField_a_of_type_Aenl = localaenl.b;
        localaenl.b = null;
        jdField_a_of_type_Int -= 1;
        return localaenl;
      }
      return new aenl();
    }
  }
  
  static aenl a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    aenl localaenl = a();
    localaenl.jdField_a_of_type_JavaLangString = paramString;
    aoch localaoch = localaenl.a();
    if (localaoch != null) {
      localaoch.b();
    }
    localaenl.jdField_a_of_type_Aoch = aoch.a(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localaenl.jdField_a_of_type_Boolean = false;
    return localaenl;
  }
  
  aoch a()
  {
    if (this.jdField_a_of_type_Aoch == null) {
      return null;
    }
    return this.jdField_a_of_type_Aoch;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((aoch)???).b();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Aenl;
        jdField_a_of_type_Aenl = this;
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
 * Qualified Name:     aenl
 * JD-Core Version:    0.7.0.1
 */
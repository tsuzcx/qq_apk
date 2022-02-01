import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

class aegt
{
  private static int jdField_a_of_type_Int;
  private static aegt jdField_a_of_type_Aegt;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  FaceDrawable jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private aegt b;
  
  static aegt a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aegt != null)
      {
        aegt localaegt = jdField_a_of_type_Aegt;
        jdField_a_of_type_Aegt = localaegt.b;
        localaegt.b = null;
        jdField_a_of_type_Int -= 1;
        return localaegt;
      }
      return new aegt();
    }
  }
  
  static aegt a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    aegt localaegt = a();
    localaegt.jdField_a_of_type_JavaLangString = paramString;
    FaceDrawable localFaceDrawable = localaegt.a();
    if (localFaceDrawable != null) {
      localFaceDrawable.cancel();
    }
    localaegt.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable = FaceDrawable.getUserFaceDrawable(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localaegt.jdField_a_of_type_Boolean = false;
    return localaegt;
  }
  
  FaceDrawable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((FaceDrawable)???).cancel();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_Aegt;
        jdField_a_of_type_Aegt = this;
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
 * Qualified Name:     aegt
 * JD-Core Version:    0.7.0.1
 */
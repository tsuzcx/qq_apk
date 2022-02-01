import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

class adpq
{
  private static int jdField_a_of_type_Int;
  private static adpq jdField_a_of_type_Adpq;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  FaceDrawable jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private adpq b;
  
  static adpq a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Adpq != null)
      {
        adpq localadpq = jdField_a_of_type_Adpq;
        jdField_a_of_type_Adpq = localadpq.b;
        localadpq.b = null;
        jdField_a_of_type_Int -= 1;
        return localadpq;
      }
      return new adpq();
    }
  }
  
  static adpq a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    adpq localadpq = a();
    localadpq.jdField_a_of_type_JavaLangString = paramString;
    FaceDrawable localFaceDrawable = localadpq.a();
    if (localFaceDrawable != null) {
      localFaceDrawable.cancel();
    }
    localadpq.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable = FaceDrawable.getUserFaceDrawable(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localadpq.jdField_a_of_type_Boolean = false;
    return localadpq;
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
        this.b = jdField_a_of_type_Adpq;
        jdField_a_of_type_Adpq = this;
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
 * Qualified Name:     adpq
 * JD-Core Version:    0.7.0.1
 */
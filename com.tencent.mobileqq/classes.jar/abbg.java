import com.tencent.qphone.base.util.QLog;

class abbg
  implements zqq
{
  abbg(abbf paramabbf, abbh paramabbh, abbi paramabbi) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Abbh != null)
    {
      this.jdField_a_of_type_Abbi.a(943004);
      this.jdField_a_of_type_Abbi.a(paramString);
      this.jdField_a_of_type_Abbh.b(this.jdField_a_of_type_Abbi);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo failure");
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo finish");
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (this.jdField_a_of_type_Abbh != null) {
      this.jdField_a_of_type_Abbh.a(this.jdField_a_of_type_Abbi);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abbg
 * JD-Core Version:    0.7.0.1
 */
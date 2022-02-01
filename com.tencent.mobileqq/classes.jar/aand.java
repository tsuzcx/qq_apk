import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

class aand
  implements FFmpegExecuteResponseCallback
{
  aand(aanc paramaanc, aane paramaane, aanf paramaanf) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Aane != null)
    {
      this.jdField_a_of_type_Aanf.a(943004);
      this.jdField_a_of_type_Aanf.a(paramString);
      this.jdField_a_of_type_Aane.failed(this.jdField_a_of_type_Aanf);
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
    if (this.jdField_a_of_type_Aane != null) {
      this.jdField_a_of_type_Aane.success(this.jdField_a_of_type_Aanf);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aand
 * JD-Core Version:    0.7.0.1
 */
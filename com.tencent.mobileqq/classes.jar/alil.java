import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class alil
  extends ayxq
{
  alil(alii paramalii, QQAppInterface paramQQAppInterface, String paramString, ayxr paramayxr, ayrx paramayrx, alio paramalio, alin paramalin)
  {
    super(paramQQAppInterface, paramString, paramayxr, paramayrx);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (alii.a(this.jdField_a_of_type_Alii))
    {
      alin localalin = (alin)alii.a(this.jdField_a_of_type_Alii).get(this.jdField_a_of_type_Alio.b);
      if (localalin != null) {
        localalin.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (alii.a(this.jdField_a_of_type_Alii))
    {
      alin localalin = (alin)alii.a(this.jdField_a_of_type_Alii).get(this.jdField_a_of_type_Alio.b);
      if (localalin != null) {
        this.jdField_a_of_type_Alin.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alil
 * JD-Core Version:    0.7.0.1
 */
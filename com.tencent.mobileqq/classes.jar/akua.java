import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class akua
  extends axxh
{
  akua(aktx paramaktx, QQAppInterface paramQQAppInterface, String paramString, axxi paramaxxi, axro paramaxro, akud paramakud, akuc paramakuc)
  {
    super(paramQQAppInterface, paramString, paramaxxi, paramaxro);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (aktx.a(this.jdField_a_of_type_Aktx))
    {
      akuc localakuc = (akuc)aktx.a(this.jdField_a_of_type_Aktx).get(this.jdField_a_of_type_Akud.b);
      if (localakuc != null) {
        localakuc.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (aktx.a(this.jdField_a_of_type_Aktx))
    {
      akuc localakuc = (akuc)aktx.a(this.jdField_a_of_type_Aktx).get(this.jdField_a_of_type_Akud.b);
      if (localakuc != null) {
        this.jdField_a_of_type_Akuc.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akua
 * JD-Core Version:    0.7.0.1
 */
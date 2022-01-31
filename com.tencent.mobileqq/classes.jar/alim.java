import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class alim
  extends ayxo
{
  alim(alij paramalij, QQAppInterface paramQQAppInterface, String paramString, ayxp paramayxp, ayrv paramayrv, alip paramalip, alio paramalio)
  {
    super(paramQQAppInterface, paramString, paramayxp, paramayrv);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (alij.a(this.jdField_a_of_type_Alij))
    {
      alio localalio = (alio)alij.a(this.jdField_a_of_type_Alij).get(this.jdField_a_of_type_Alip.b);
      if (localalio != null) {
        localalio.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (alij.a(this.jdField_a_of_type_Alij))
    {
      alio localalio = (alio)alij.a(this.jdField_a_of_type_Alij).get(this.jdField_a_of_type_Alip.b);
      if (localalio != null) {
        this.jdField_a_of_type_Alio.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alim
 * JD-Core Version:    0.7.0.1
 */
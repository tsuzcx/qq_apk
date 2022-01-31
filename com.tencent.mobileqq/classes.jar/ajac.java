import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ajac
  implements EIPCResultCallback
{
  ajac(aizw paramaizw) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow onDressChanged send!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajac
 * JD-Core Version:    0.7.0.1
 */
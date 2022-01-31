import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aamf
  implements EIPCResultCallback
{
  aamf(aame paramaame, aamh paramaamh, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str2 = null;
    String str1;
    if (this.jdField_a_of_type_Aamh != null)
    {
      str1 = this.jdField_a_of_type_Aamh.a();
      if (this.jdField_a_of_type_Aamh != null) {
        str2 = this.jdField_a_of_type_Aamh.b();
      }
      if (paramEIPCResult == null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
    {
      aanp.b("GdtIPCManager", String.format("ClientToServerIPCModule.onCallback action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(bool) }));
      this.jdField_a_of_type_Aame.callbackResult(this.jdField_a_of_type_Int, paramEIPCResult);
      return;
      str1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamf
 * JD-Core Version:    0.7.0.1
 */
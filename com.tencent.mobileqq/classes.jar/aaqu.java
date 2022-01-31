import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aaqu
  implements EIPCResultCallback
{
  aaqu(aaqt paramaaqt, aaqw paramaaqw, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str2 = null;
    String str1;
    if (this.jdField_a_of_type_Aaqw != null)
    {
      str1 = this.jdField_a_of_type_Aaqw.a();
      if (this.jdField_a_of_type_Aaqw != null) {
        str2 = this.jdField_a_of_type_Aaqw.b();
      }
      if (paramEIPCResult == null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
    {
      aase.b("GdtIPCManager", String.format("ClientToServerIPCModule.onCallback action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(bool) }));
      this.jdField_a_of_type_Aaqt.callbackResult(this.jdField_a_of_type_Int, paramEIPCResult);
      return;
      str1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqu
 * JD-Core Version:    0.7.0.1
 */
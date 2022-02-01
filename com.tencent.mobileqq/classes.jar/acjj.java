import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class acjj
  implements EIPCResultCallback
{
  acjj(acji paramacji, AdIPCManager.Params paramParams, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str2 = null;
    String str1;
    if (this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Params != null)
    {
      str1 = this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Params.getAction();
      if (this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Params != null) {
        str2 = this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Params.getToProcessName();
      }
      if (paramEIPCResult == null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
    {
      acqy.b("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCallback action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(bool) }));
      this.jdField_a_of_type_Acji.callbackResult(this.jdField_a_of_type_Int, paramEIPCResult);
      return;
      str1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjj
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class akli
  extends CmdCallback.Stub
{
  akli(aklh paramaklh, Bundle paramBundle, int paramInt) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramBoolean)
    {
      paramBundle = paramBundle.getString("imageUrl", "").replaceFirst("https*://", "");
      QLog.d("mini_msg_IPCServer", 1, "doMiniShareUploadImage newImagePath: " + paramBundle);
      this.jdField_a_of_type_AndroidOsBundle.putString("preview", paramBundle);
    }
    localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
    this.jdField_a_of_type_Aklh.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akli
 * JD-Core Version:    0.7.0.1
 */
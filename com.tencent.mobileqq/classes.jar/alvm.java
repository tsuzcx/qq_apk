import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class alvm
  extends bbwf
{
  alvm(alvk paramalvk, String paramString, int paramInt) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambbwg.jdField_a_of_type_Int) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", parambbwg.jdField_a_of_type_Int);
    parambbwg = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_Alvk.callbackResult(this.jdField_a_of_type_Int, parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alvm
 * JD-Core Version:    0.7.0.1
 */
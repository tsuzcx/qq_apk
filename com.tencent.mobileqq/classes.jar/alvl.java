import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class alvl
  extends bbwt
{
  alvl(alvj paramalvj, String paramString, int paramInt) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambbwu.jdField_a_of_type_Int) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", parambbwu.jdField_a_of_type_Int);
    parambbwu = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_Alvj.callbackResult(this.jdField_a_of_type_Int, parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alvl
 * JD-Core Version:    0.7.0.1
 */
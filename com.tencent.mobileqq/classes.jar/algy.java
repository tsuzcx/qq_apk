import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class algy
  extends batl
{
  algy(algw paramalgw, String paramString, int paramInt) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambatm.jdField_a_of_type_Int) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", parambatm.jdField_a_of_type_Int);
    parambatm = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_Algw.callbackResult(this.jdField_a_of_type_Int, parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     algy
 * JD-Core Version:    0.7.0.1
 */
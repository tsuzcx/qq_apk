import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ambp
  implements EIPCResultCallback
{
  public ambp(String paramString1, String paramString2, ambu paramambu) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("selfUinStatus");
    int j = paramEIPCResult.getInt("friendUinStatus");
    ambn.a(this.jdField_a_of_type_JavaLangString, i);
    ambn.a(this.b, j);
    if (this.jdField_a_of_type_Ambu != null) {
      this.jdField_a_of_type_Ambu.a(true);
    }
    QLog.i("CmShow_CmShowRenderView", 1, "initCmShowData selfUinStatus:" + i + " friendUinStatus:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambp
 * JD-Core Version:    0.7.0.1
 */
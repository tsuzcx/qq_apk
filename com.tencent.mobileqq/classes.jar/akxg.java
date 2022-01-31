import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class akxg
  implements EIPCResultCallback
{
  public akxg(String paramString1, String paramString2, akxl paramakxl) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("selfUinStatus");
    int j = paramEIPCResult.getInt("friendUinStatus");
    akxe.a(this.jdField_a_of_type_JavaLangString, i);
    akxe.a(this.b, j);
    if (this.jdField_a_of_type_Akxl != null) {
      this.jdField_a_of_type_Akxl.a(true);
    }
    QLog.i("CmShow_CmShowRenderView", 1, "initCmShowData selfUinStatus:" + i + " friendUinStatus:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxg
 * JD-Core Version:    0.7.0.1
 */
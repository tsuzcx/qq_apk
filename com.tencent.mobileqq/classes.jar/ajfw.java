import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ajfw
  implements EIPCResultCallback
{
  public ajfw(String paramString1, String paramString2, ajgb paramajgb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("selfUinStatus");
    int j = paramEIPCResult.getInt("friendUinStatus");
    ajfu.a(this.jdField_a_of_type_JavaLangString, i);
    ajfu.a(this.b, j);
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(true);
    }
    QLog.i("CmShow_CmShowRenderView", 1, "initCmShowData selfUinStatus:" + i + " friendUinStatus:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfw
 * JD-Core Version:    0.7.0.1
 */
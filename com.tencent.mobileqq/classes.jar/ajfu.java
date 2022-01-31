import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ajfu
  implements EIPCResultCallback
{
  public ajfu(String paramString1, String paramString2, ajfz paramajfz) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("selfUinStatus");
    int j = paramEIPCResult.getInt("friendUinStatus");
    ajfs.a(this.jdField_a_of_type_JavaLangString, i);
    ajfs.a(this.b, j);
    if (this.jdField_a_of_type_Ajfz != null) {
      this.jdField_a_of_type_Ajfz.a(true);
    }
    QLog.i("CmShow_CmShowRenderView", 1, "initCmShowData selfUinStatus:" + i + " friendUinStatus:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfu
 * JD-Core Version:    0.7.0.1
 */
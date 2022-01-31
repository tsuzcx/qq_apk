import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.4.1;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class alcj
  implements EIPCResultCallback
{
  alcj(alch paramalch, alcg paramalcg) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = (IPCSpriteContext)paramEIPCResult.data.getParcelable("IPCSpriteContext");
    paramEIPCResult = paramEIPCResult.data.getString("js_content");
    QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "checkfDressChanged CmShow_ spriteJs:" + paramEIPCResult);
    if (TextUtils.isEmpty(paramEIPCResult)) {
      alhp.a(this.jdField_a_of_type_Alcg.a(), 300, 301, new Object[] { "spriteJs is empty" });
    }
    do
    {
      return;
      localObject = (alcd)alch.a(this.jdField_a_of_type_Alch).a(100);
    } while (localObject == null);
    ThreadManagerV2.excute(new CmShowSpriteDrawerInfoBridge.4.1(this, paramEIPCResult, (alcd)localObject), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcj
 * JD-Core Version:    0.7.0.1
 */
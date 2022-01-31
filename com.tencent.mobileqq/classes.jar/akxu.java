import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.4.1;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class akxu
  implements EIPCResultCallback
{
  akxu(akxs paramakxs, akxr paramakxr) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = (IPCSpriteContext)paramEIPCResult.data.getParcelable("IPCSpriteContext");
    paramEIPCResult = paramEIPCResult.data.getString("js_content");
    QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "checkfDressChanged CmShow_ spriteJs:" + paramEIPCResult);
    if (TextUtils.isEmpty(paramEIPCResult)) {
      alda.a(this.jdField_a_of_type_Akxr.a(), 300, 301, new Object[] { "spriteJs is empty" });
    }
    do
    {
      return;
      localObject = (akxo)akxs.a(this.jdField_a_of_type_Akxs).a(100);
    } while (localObject == null);
    ThreadManagerV2.excute(new CmShowSpriteDrawerInfoBridge.4.1(this, paramEIPCResult, (akxo)localObject), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxu
 * JD-Core Version:    0.7.0.1
 */
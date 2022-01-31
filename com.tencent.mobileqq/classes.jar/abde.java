import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.mobileqq.ark.ArkMessageServerLogic;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ServerCheckCallback;
import java.util.ArrayList;

public final class abde
  implements ArkAppLocationManager.ArkGetLocationCallback
{
  public abde(ArrayList paramArrayList, boolean paramBoolean, long paramLong, ArkMessageServerLogic.ServerCheckCallback paramServerCheckCallback) {}
  
  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    paramString = ArkMessageServerLogic.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, paramString, paramDouble1, paramDouble2);
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, start request, req is empty", new Object[0]));
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (localObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, fail, appInterface is null", new Object[0]));
          return;
        }
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(120);
        if (localObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, fail, arkAppCenter is null", new Object[0]));
          return;
        }
        localObject = ((ArkAppCenter)localObject).a();
        if (localObject == null)
        {
          ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, fail, sso is null", new Object[0]));
          return;
        }
      } while (TextUtils.isEmpty(paramString.toString()));
      ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("UnkownWordQuery, start request, req=%s", new Object[] { paramString.toString() }));
    } while (((ArkAppSSO)localObject).a("ArkMsgAI.IntentCheck", paramString.toString(), 10000, 0, new abdf(this, paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abde
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridgeCall;
import com.tencent.pb.wadl.GetGameCheckCode.GetGameCheckCodeRspBody;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import mqq.observer.BusinessObserver;

public class aljr
  implements BusinessObserver
{
  public aljr(WadlJsBridgeCall paramWadlJsBridgeCall, WadlParams paramWadlParams) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      Object localObject = paramBundle.getString("extra_cmd");
      int i = paramBundle.getInt("extra_result_code");
      String str = paramBundle.getString("extra_result_err_msg");
      WLog.b("WadlJsBridgeCall", "getWadlTaskSign type=" + paramInt + ",success=" + paramBoolean + ",cmd=" + (String)localObject + ",resultCode=" + i + ",errMsg=" + str);
      if (TextUtils.equals((CharSequence)localObject, "GameCenterProtoSvr.GetGameCheckCode"))
      {
        WLog.a("WadlJsBridgeCall", 3, "get app check success=" + paramBoolean);
        if (paramBoolean)
        {
          paramBundle = paramBundle.getByteArray("extra_data");
          localObject = new GetGameCheckCode.GetGameCheckCodeRspBody();
          ((GetGameCheckCode.GetGameCheckCodeRspBody)localObject).mergeFrom(paramBundle);
          paramInt = ((GetGameCheckCode.GetGameCheckCodeRspBody)localObject).ret.get();
          paramBundle = ((GetGameCheckCode.GetGameCheckCodeRspBody)localObject).check_code.get();
          WLog.b("WadlJsBridgeCall", "getWadlTaskSign success ret=" + paramInt + ",apk sign=" + paramBundle);
          if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)))
          {
            this.jdField_a_of_type_CooperationWadlIpcWadlParams.c = paramBundle;
            WadlProxyServiceUtil.a().b(this.jdField_a_of_type_CooperationWadlIpcWadlParams);
          }
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      WLog.a("WadlJsBridgeCall", "getWadlTaskSign exception:" + paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljr
 * JD-Core Version:    0.7.0.1
 */
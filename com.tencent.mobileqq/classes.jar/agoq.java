import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class agoq
  implements BusinessObserver
{
  agoq(agop paramagop) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label500;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt != 0)
        {
          paramBundle = paramBundle.optString("msg");
          if (!TextUtils.isEmpty(paramBundle))
          {
            QQToast.a(this.a.a.jdField_a_of_type_AndroidContentContext, 1, paramBundle, 0).b(this.a.a.a());
            QLog.d(this.a.a.jdField_a_of_type_JavaLangString + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ", op:" + "1" + ", errMsg:" + paramBundle);
            return;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            QQToast.a(this.a.a.jdField_a_of_type_AndroidContentContext, 1, this.a.a.jdField_a_of_type_AndroidContentContext.getString(2131694690), 0).b(this.a.a.a());
          }
          if (this.a.a.Z == paramBoolean) {
            continue;
          }
          this.a.a.Z = paramBoolean;
          this.a.a.m();
          return;
        }
        localObject = paramBundle.getJSONObject("result");
        paramInt = paramBundle.optInt("retcode");
        if (paramInt != 0) {
          continue;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      try
      {
        QQToast.a(this.a.a.jdField_a_of_type_AndroidContentContext, 2, this.a.a.jdField_a_of_type_AndroidContentContext.getString(2131694691), 0).b(this.a.a.a());
        bool = true;
        paramBoolean = bool;
        try
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.a.a.jdField_a_of_type_JavaLangString + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "result:" + ((JSONObject)localObject).toString());
          paramBoolean = bool;
        }
        catch (Exception paramBundle) {}
      }
      catch (Exception paramBundle)
      {
        bool = true;
        continue;
      }
      paramBoolean = bool;
      if (QLog.isColorLevel())
      {
        QLog.d(this.a.a.jdField_a_of_type_JavaLangString + "Q.nearby.follow", 2, "sendOperateFollowUser Exception");
        paramBoolean = bool;
        continue;
        label500:
        paramBoolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoq
 * JD-Core Version:    0.7.0.1
 */
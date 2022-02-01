import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ahyw
  implements BusinessObserver
{
  ahyw(ahyl paramahyl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.a(2131694983);
    }
    for (;;)
    {
      ChatActivityUtils.b();
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
          localFollowResponse.mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            ((FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, false);
            paramBundle = (antw)this.a.app.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
            if (paramBundle != null) {
              paramBundle.a(SystemClock.uptimeMillis());
            }
          }
          else if (paramInt == 58)
          {
            this.a.a(2131694979);
          }
          else if (paramInt == 65)
          {
            this.a.a(2131694954);
          }
          else if (paramInt == 20)
          {
            this.a.a(2131694955);
          }
          else
          {
            this.a.a(2131694983);
          }
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyw
 * JD-Core Version:    0.7.0.1
 */
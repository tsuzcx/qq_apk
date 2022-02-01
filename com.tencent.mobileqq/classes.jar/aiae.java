import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class aiae
  extends BroadcastReceiver
{
  aiae(ahzx paramahzx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst")) {
        break label72;
      }
      paramContext = paramIntent.getExtras();
      if (paramContext != null) {
        break label26;
      }
    }
    label26:
    label72:
    do
    {
      do
      {
        do
        {
          long l;
          do
          {
            return;
            l = paramContext.getLong("deviceopdin", 0L);
          } while ((paramContext.getInt("deviceoprstcode", 0) != 0) || (Long.parseLong(this.a.sessionInfo.curFriendUin) != l));
          this.a.finish();
          return;
          if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_ProductFetchRst")) {
            break;
          }
          paramContext = paramIntent.getExtras();
        } while ((paramContext == null) || (paramContext.getInt("deviceoprstcode", 0) != 0));
        this.a.a();
        return;
        if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveVasFlagResult")) {
          break;
        }
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      int i = paramContext.getInt("Flag", 0);
      paramContext = (abkw)this.a.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if (i == 1)
      {
        ahzx.f = true;
        paramIntent = this.a.app.getApp().getString(2131691766) + this.a.app.getApp().getString(2131691501);
        paramContext.a(this.a.sessionInfo.curFriendUin, paramIntent, bcrg.a(), true, false, 0);
        return;
      }
      ahzx.f = false;
      paramIntent = this.a.app.getApp().getString(2131691766) + this.a.app.getApp().getString(2131691500) + this.a.app.getApp().getString(2131691483);
      paramContext.a(this.a.sessionInfo.curFriendUin, paramIntent, bcrg.a(), true, false, 2);
      return;
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress"))
      {
        ahzx.a(this.a, paramIntent);
        return;
      }
    } while (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet"));
    ahzx.b(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiae
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ahfm
  extends BroadcastReceiver
{
  ahfm(ahff paramahff) {}
  
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
      paramContext = (aavk)this.a.app.getBusinessHandler(49);
      if (i == 1)
      {
        ahff.f = true;
        paramIntent = this.a.app.getApp().getString(2131691681) + this.a.app.getApp().getString(2131691416);
        paramContext.a(this.a.sessionInfo.curFriendUin, paramIntent, bbko.a(), true, false, 0);
        return;
      }
      ahff.f = false;
      paramIntent = this.a.app.getApp().getString(2131691681) + this.a.app.getApp().getString(2131691415) + this.a.app.getApp().getString(2131691398);
      paramContext.a(this.a.sessionInfo.curFriendUin, paramIntent, bbko.a(), true, false, 2);
      return;
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress"))
      {
        ahff.a(this.a, paramIntent);
        return;
      }
    } while (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet"));
    ahff.b(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfm
 * JD-Core Version:    0.7.0.1
 */
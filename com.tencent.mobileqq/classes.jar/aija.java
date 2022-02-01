import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class aija
  extends BroadcastReceiver
{
  aija(aiit paramaiit) {}
  
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
          } while ((paramContext.getInt("deviceoprstcode", 0) != 0) || (Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) != l));
          this.a.I();
          return;
          if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_ProductFetchRst")) {
            break;
          }
          paramContext = paramIntent.getExtras();
        } while ((paramContext == null) || (paramContext.getInt("deviceoprstcode", 0) != 0));
        this.a.bo();
        return;
        if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveVasFlagResult")) {
          break;
        }
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      int i = paramContext.getInt("Flag", 0);
      paramContext = (abzb)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      if (i == 1)
      {
        aiit.W = true;
        paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691637) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691376);
        paramContext.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramIntent, bcrg.a(), true, false, 0);
        return;
      }
      aiit.W = false;
      paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691637) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691375) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691358);
      paramContext.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramIntent, bcrg.a(), true, false, 2);
      return;
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress"))
      {
        aiit.a(this.a, paramIntent);
        return;
      }
    } while (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet"));
    aiit.b(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aija
 * JD-Core Version:    0.7.0.1
 */
import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class aehk
  extends MqqHandler
{
  public aehk(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("LoginInfoActivity.AccDevSec", 2, "handleMessage.msg.arg1=" + paramMessage.arg1);
              }
            } while (LoginInfoActivity.a(this.a) == null);
            LoginInfoActivity.a(this.a).DevSetup = paramMessage.arg1;
            LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
            return;
            LoginInfoActivity.a(this.a, this.a.findViewById(1));
            return;
            LoginInfoActivity.b(this.a, this.a.findViewById(2));
            return;
          } while (LoginInfoActivity.a(this.a) == null);
          localObject = paramMessage.getData();
        } while (localObject == null);
        paramMessage = ((Bundle)localObject).getString(AuthDevRenameActivity.f);
        Object localObject = ((Bundle)localObject).getByteArray(AuthDevRenameActivity.h);
        int i = 0;
        for (;;)
        {
          if (i < LoginInfoActivity.a(this.a).size())
          {
            SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)LoginInfoActivity.a(this.a).get(i);
            if ((localSvcDevLoginInfo != null) && (Arrays.equals(localSvcDevLoginInfo.stDeviceItemDes.vecItemDes, (byte[])localObject))) {
              localSvcDevLoginInfo.strDeviceName = paramMessage;
            }
          }
          else
          {
            LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
            return;
          }
          i += 1;
        }
      } while ((LoginInfoActivity.a(this.a) == null) || ((!LoginInfoActivity.a(this.a)) && (!LoginInfoActivity.b(this.a))));
      paramMessage = this.a.getString(2131716569);
      if (LoginInfoActivity.a(this.a) >= 4)
      {
        LoginInfoActivity.a(this.a).setText(paramMessage);
        return;
      }
      LoginInfoActivity.a(this.a).setVisibility(0);
      LoginInfoActivity.a(this.a, (LoginInfoActivity.a(this.a) + 1) % 4);
      switch (LoginInfoActivity.a(this.a))
      {
      }
      for (;;)
      {
        sendEmptyMessageDelayed(20170210, 300L);
        return;
        paramMessage = paramMessage + this.a.getString(2131718435);
        LoginInfoActivity.a(this.a).setText(paramMessage);
        continue;
        paramMessage = paramMessage + this.a.getString(2131718436);
        LoginInfoActivity.a(this.a).setText(paramMessage);
        continue;
        paramMessage = paramMessage + this.a.getString(2131718437);
        LoginInfoActivity.a(this.a).setText(paramMessage);
        continue;
        LoginInfoActivity.a(this.a).setText(paramMessage);
      }
      paramMessage = paramMessage.getData();
    } while (paramMessage == null);
    boolean bool = paramMessage.getBoolean("bSafe");
    paramMessage = paramMessage.getString("TipText");
    LoginInfoActivity.a(this.a, bool, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehk
 * JD-Core Version:    0.7.0.1
 */
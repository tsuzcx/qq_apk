import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class ahgz
  extends CountDownTimer
{
  ahgz(ahgw paramahgw, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("SpringHbCountDownDialog", 2, "startCountDown-->onFinish mCurrentTime:" + NetConnInfoCenter.getServerTimeMillis());
      }
      if ((BaseActivity.sTopActivity != null) && (BaseActivity.sTopActivity.app != null)) {
        ((ahfx)BaseActivity.sTopActivity.app.getManager(342)).a((ViewGroup)BaseActivity.sTopActivity.getWindow().getDecorView(), true);
      }
      this.a.dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SpringHbCountDownDialog", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onTick(long paramLong)
  {
    try
    {
      long l1 = paramLong / 3600000L;
      long l2 = (paramLong - 3600000L * l1) / 60000L;
      paramLong = (paramLong - 3600000L * l1 - 60000L * l2) / 1000L;
      String str1;
      if (l2 > 9L)
      {
        str1 = "" + l2;
        if (paramLong <= 9L) {
          break label160;
        }
      }
      label160:
      for (String str2 = "" + paramLong;; str2 = "0" + paramLong)
      {
        ahgw.a(this.a).setText(String.format("%s:%s:%s", new Object[] { Long.valueOf(l1), str1, str2 }));
        return;
        str1 = "0" + l2;
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SpringHbCountDownDialog", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgz
 * JD-Core Version:    0.7.0.1
 */
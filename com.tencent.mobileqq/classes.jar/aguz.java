import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HitAndRunHelper.1;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aguz
  implements agvc
{
  private BaseChatPie a;
  
  aguz(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 9: 
    case 6: 
      for (;;)
      {
        return;
        ((AvatarPendantManager)this.a.a.getManager(46)).c();
        airr.a(this.a.d);
        return;
        if (!ahod.c) {}
        try
        {
          System.loadLibrary("sonic");
          ahod.c = true;
          label81:
          bhoi.a(ahod.c);
          bhoi.a(this.a.a);
          ahod.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
          localargs = (args)aran.a().a(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            args localargs;
            if (!ahod.e) {
              if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localargs.a()) {
                break label317;
              }
            }
            label317:
            for (ahod.f = true;; ahod.f = false)
            {
              ThreadManager.post(new HitAndRunHelper.1(this), 5, null, true);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + ahod.d + " hasAddGrayTip =" + ahod.e + " grayTipPerThousandStatus=" + ahod.f);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              ahod.c = false;
              break label81;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PttAutoChange", 2, "error=" + localException.toString());
              }
            }
          }
        }
      }
    }
    ahqw.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 9, 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguz
 * JD-Core Version:    0.7.0.1
 */
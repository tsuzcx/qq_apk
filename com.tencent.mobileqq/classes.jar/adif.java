import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adif
  implements adih
{
  private BaseChatPie a;
  
  adif(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 8: 
    case 5: 
      for (;;)
      {
        return;
        ((AvatarPendantManager)this.a.a.getManager(46)).c();
        aevm.a(this.a.d);
        return;
        if (!adwv.c) {}
        try
        {
          System.loadLibrary("sonic");
          adwv.c = true;
          label81:
          bbfm.a(adwv.c);
          bbfm.a(this.a.a);
          adwv.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
          localamuf = (amuf)ampm.a().a(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            amuf localamuf;
            if (!adwv.e) {
              if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localamuf.a()) {
                break label303;
              }
            }
            label303:
            for (adwv.f = true; QLog.isColorLevel(); adwv.f = false)
            {
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + adwv.d + " hasAddGrayTip =" + adwv.e + " grayTipPerThousandStatus=" + adwv.f);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              adwv.c = false;
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
    adzh.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 8, 5 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adif
 * JD-Core Version:    0.7.0.1
 */
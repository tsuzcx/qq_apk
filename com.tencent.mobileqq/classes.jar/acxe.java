import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class acxe
  implements acxg
{
  private BaseChatPie a;
  
  acxe(BaseChatPie paramBaseChatPie)
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
        aekr.a(this.a.d);
        return;
        if (!adlw.c) {}
        try
        {
          System.loadLibrary("sonic");
          adlw.c = true;
          label81:
          baeh.a(adlw.c);
          baeh.a(this.a.a);
          adlw.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
          localamdz = (amdz)alzw.a().a(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            amdz localamdz;
            if (!adlw.e) {
              if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localamdz.a()) {
                break label303;
              }
            }
            label303:
            for (adlw.f = true; QLog.isColorLevel(); adlw.f = false)
            {
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + adlw.d + " hasAddGrayTip =" + adlw.e + " grayTipPerThousandStatus=" + adlw.f);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              adlw.c = false;
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
    adoi.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 8, 5 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxe
 * JD-Core Version:    0.7.0.1
 */
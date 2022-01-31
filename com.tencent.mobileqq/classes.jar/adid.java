import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adid
  implements adif
{
  private BaseChatPie a;
  
  adid(BaseChatPie paramBaseChatPie)
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
        aevk.a(this.a.d);
        return;
        if (!adwt.c) {}
        try
        {
          System.loadLibrary("sonic");
          adwt.c = true;
          label81:
          bbga.a(adwt.c);
          bbga.a(this.a.a);
          adwt.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
          localamue = (amue)ampl.a().a(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            amue localamue;
            if (!adwt.e) {
              if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localamue.a()) {
                break label303;
              }
            }
            label303:
            for (adwt.f = true; QLog.isColorLevel(); adwt.f = false)
            {
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + adwt.d + " hasAddGrayTip =" + adwt.e + " grayTipPerThousandStatus=" + adwt.f);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              adwt.c = false;
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
    adzf.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 8, 5 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adid
 * JD-Core Version:    0.7.0.1
 */
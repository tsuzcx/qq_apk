import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afaj
  implements afal
{
  private BaseChatPie a;
  
  afaj(BaseChatPie paramBaseChatPie)
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
        agsp.a(this.a.d);
        return;
        if (!aftg.c) {}
        try
        {
          System.loadLibrary("sonic");
          aftg.c = true;
          label81:
          bdew.a(aftg.c);
          bdew.a(this.a.a);
          aftg.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
          localaoli = (aoli)aogj.a().a(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            aoli localaoli;
            if (!aftg.e) {
              if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localaoli.a()) {
                break label303;
              }
            }
            label303:
            for (aftg.f = true; QLog.isColorLevel(); aftg.f = false)
            {
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + aftg.d + " hasAddGrayTip =" + aftg.e + " grayTipPerThousandStatus=" + aftg.f);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              aftg.c = false;
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
    afvt.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 8, 5 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afaj
 * JD-Core Version:    0.7.0.1
 */
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HitAndRunHelper.1;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aglx
  implements agma
{
  private BaseChatPie a;
  
  aglx(BaseChatPie paramBaseChatPie)
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
        aihy.a(this.a.d);
        return;
        if (!aher.c) {}
        try
        {
          System.loadLibrary("sonic");
          aher.c = true;
          label81:
          bgog.a(aher.c);
          bgog.a(this.a.a);
          aher.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
          localaqri = (aqri)aqlk.a().a(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            aqri localaqri;
            if (!aher.e) {
              if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localaqri.a()) {
                break label317;
              }
            }
            label317:
            for (aher.f = true;; aher.f = false)
            {
              ThreadManager.post(new HitAndRunHelper.1(this), 5, null, true);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + aher.d + " hasAddGrayTip =" + aher.e + " grayTipPerThousandStatus=" + aher.f);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              aher.c = false;
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
    ahhm.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 9, 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglx
 * JD-Core Version:    0.7.0.1
 */
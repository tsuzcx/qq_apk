import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afey
  implements affa
{
  private BaseChatPie a;
  
  afey(BaseChatPie paramBaseChatPie)
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
        agxe.a(this.a.d);
        return;
        if (!afxv.c) {}
        try
        {
          System.loadLibrary("sonic");
          afxv.c = true;
          label81:
          bdjf.a(afxv.c);
          bdjf.a(this.a.a);
          afxv.h = this.a.a.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.a.getCurrentAccountUin(), false);
          localaopr = (aopr)aoks.a().a(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            aopr localaopr;
            if (!afxv.e) {
              if ((int)(Long.valueOf(this.a.a.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localaopr.a()) {
                break label303;
              }
            }
            label303:
            for (afxv.f = true; QLog.isColorLevel(); afxv.f = false)
            {
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + afxv.d + " hasAddGrayTip =" + afxv.e + " grayTipPerThousandStatus=" + afxv.f);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              afxv.c = false;
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
    agai.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 8, 5 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afey
 * JD-Core Version:    0.7.0.1
 */
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HitAndRunHelper.1;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class agik
  implements agin
{
  private BaseChatPie a;
  
  agik(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    bhfx.a(this.a.app);
    ahdg.h = this.a.app.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.app.getCurrentAccountUin(), false);
    ardl localardl = (ardl)aqxe.a().a(442);
    try
    {
      if (!ahdg.e)
      {
        if ((int)(Long.valueOf(this.a.app.getCurrentAccountUin()).longValue() / 1000L % 1000L) > localardl.a())
        {
          ahdg.f = true;
          return;
        }
        ahdg.f = false;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChange", 2, "error=" + localException.toString());
      }
    }
  }
  
  private void b()
  {
    if (!ahdg.c) {}
    try
    {
      System.loadLibrary("sonic");
      ahdg.c = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sonic", 2, "load error:" + localThrowable.toString());
      }
      ahdg.c = false;
      return;
    }
    finally
    {
      bhfx.a(ahdg.c);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 10: 
    case 7: 
      do
      {
        return;
        ((AvatarPendantManager)this.a.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).c();
        aigt.a(this.a.afRoot);
        return;
        a();
        ThreadManager.post(new HitAndRunHelper.1(this), 5, null, true);
      } while (!QLog.isColorLevel());
      QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + ahdg.d + " hasAddGrayTip =" + ahdg.e + " grayTipPerThousandStatus=" + ahdg.f);
      return;
    }
    ahfz.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 10, 7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agik
 * JD-Core Version:    0.7.0.1
 */
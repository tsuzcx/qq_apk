import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HitAndRunHelper.1;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afqz
  implements afrc
{
  private BaseChatPie a;
  
  afqz(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    bfxf.a(this.a.app);
    agkq.h = this.a.app.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.app.getCurrentAccountUin(), false);
    aqai localaqai = (aqai)apub.a().a(442);
    try
    {
      if (!agkq.e)
      {
        if ((int)(Long.valueOf(this.a.app.getCurrentAccountUin()).longValue() / 1000L % 1000L) > localaqai.a())
        {
          agkq.f = true;
          return;
        }
        agkq.f = false;
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
    if (!agkq.c) {}
    try
    {
      System.loadLibrary("sonic");
      agkq.c = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sonic", 2, "load error:" + localThrowable.toString());
      }
      agkq.c = false;
      return;
    }
    finally
    {
      bfxf.a(agkq.c);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 9: 
    case 6: 
      do
      {
        return;
        ((AvatarPendantManager)this.a.app.getManager(46)).c();
        ahlz.a(this.a.afRoot);
        return;
        a();
        ThreadManager.post(new HitAndRunHelper.1(this), 5, null, true);
      } while (!QLog.isColorLevel());
      QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + agkq.d + " hasAddGrayTip =" + agkq.e + " grayTipPerThousandStatus=" + agkq.f);
      return;
    }
    agnj.g();
    ShortVideoRealItemBuilder.g();
  }
  
  public int[] a()
  {
    return new int[] { 9, 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqz
 * JD-Core Version:    0.7.0.1
 */
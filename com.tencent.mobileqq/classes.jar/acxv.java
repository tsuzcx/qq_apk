import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class acxv
  implements acxg
{
  private long jdField_a_of_type_Long;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QEffectView jdField_a_of_type_ComTencentQqEffectQEffectView;
  
  public acxv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqEffectQEffectView != null) {
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.pause();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
    case 11: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null);
      StringBuilder localStringBuilder = new StringBuilder().append("destroy qeffect, duration:");
      if (this.jdField_a_of_type_Long == 0L) {}
      for (long l = this.jdField_a_of_type_Long;; l = System.currentTimeMillis() - this.jdField_a_of_type_Long)
      {
        QLog.i("QEffectBgProvider", 1, l);
        if (this.jdField_a_of_type_ComTencentQqEffectQEffectView.getQEffectImpl() != null) {
          ((View)this.jdField_a_of_type_ComTencentQqEffectQEffectView.getQEffectImpl()).destroyDrawingCache();
        }
        this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
        return;
      }
    case 12: 
      a();
      return;
    }
    b();
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = 1;
    if ((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Ackc != null))
    {
      paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null)
      {
        this.jdField_a_of_type_ComTencentQqEffectQEffectView = new QEffectView(paramContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.addView(this.jdField_a_of_type_ComTencentQqEffectQEffectView, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.setExtOptions(2, QEffectApngImageView.a(new int[] { 0 }, "-chatBg-"));
      str = paramQQAppInterface.c();
      j = ChatBackgroundManager.a(paramContext, str, paramSessionInfo);
      if ((j > 0) && (ChatBackgroundManager.a()))
      {
        ((baov)paramQQAppInterface.getManager(235)).a.a(j, new acxw(this, j));
        i = 0;
        if (i == 0) {
          break label248;
        }
        paramContext = "1";
        MagnifierSDK.a("AIO错层动画", paramContext, zqi.class);
      }
    }
    label248:
    while (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null) {
      for (;;)
      {
        String str;
        int j;
        return;
        if ((ChatBackgroundManager.a(paramContext, str, paramSessionInfo)) && (ChatBackgroundManager.a()))
        {
          paramContext = ackc.a(paramContext, str, paramSessionInfo);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentQqEffectQEffectView.setSrc(paramContext.replace("aioImage", ""), "zip");
          QLog.i("QEffectBgProvider", 1, "set qeffect for custom background aioImageID:" + ChatBackgroundManager.d(paramContext));
        }
        else
        {
          this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
          i = 0;
          continue;
          paramContext = "0";
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
  }
  
  public int[] a()
  {
    return new int[] { 2, 11, 12, 13, 14 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqEffectQEffectView != null) {
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxv
 * JD-Core Version:    0.7.0.1
 */
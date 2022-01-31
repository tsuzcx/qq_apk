import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class adiu
  implements adif
{
  private long jdField_a_of_type_Long;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QEffectView jdField_a_of_type_ComTencentQqEffectQEffectView;
  
  public adiu(BaseChatPie paramBaseChatPie)
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
    String str1;
    if ((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Acur != null))
    {
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null)
      {
        this.jdField_a_of_type_ComTencentQqEffectQEffectView = new QEffectView(paramContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.addView(this.jdField_a_of_type_ComTencentQqEffectQEffectView, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (paramSessionInfo.jdField_a_of_type_Acur.a == null) {
        break label335;
      }
      if ((paramSessionInfo.jdField_a_of_type_Acur.a instanceof anoy)) {
        paramSessionInfo = "aio-bg-static";
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.setExtOptions(2, QEffectApngImageView.a(new int[] { 0 }, "-chatBg-"));
      String str2 = paramQQAppInterface.c();
      int i = ChatBackgroundManager.a(paramContext, str2, str1);
      if ((i > 0) && (ChatBackgroundManager.a()))
      {
        ((bbrg)paramQQAppInterface.getManager(235)).a.a(i, new adiv(this, i));
        paramSessionInfo = paramSessionInfo + "-effect";
        label181:
        MagnifierSDK.a("AIO背景", paramSessionInfo, zzx.class);
      }
      do
      {
        return;
        if (!(paramSessionInfo.jdField_a_of_type_Acur.a instanceof URLDrawable)) {
          break label335;
        }
        paramSessionInfo = "aio-bg-dynamic";
        break;
        if ((ChatBackgroundManager.a(paramContext, str2, str1)) && (ChatBackgroundManager.a()))
        {
          paramContext = acur.a(paramContext, str2, str1);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentQqEffectQEffectView.setSrc(paramContext.replace("aioImage", ""), "zip");
          QLog.i("QEffectBgProvider", 1, "set qeffect for custom background aioImageID:" + ChatBackgroundManager.d(paramContext));
          paramSessionInfo = paramSessionInfo + "-3d";
          break label181;
        }
        this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
        break label181;
      } while (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null);
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
      return;
      label335:
      paramSessionInfo = "aio-bg-default";
    }
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
 * Qualified Name:     adiu
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;
import java.io.File;

public class agvv
  implements agvc
{
  private long jdField_a_of_type_Long;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QEffectView jdField_a_of_type_ComTencentQqEffectQEffectView;
  
  public agvv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = aggu.a(paramContext, paramString1, paramString2);
    if (paramContext.contains("aioImage")) {
      return paramContext.replace("aioImage", "aio_bg.mp4");
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext, paramString1, paramString2);
    if (!TextUtils.isEmpty(paramContext)) {
      return new File(paramContext).exists();
    }
    return false;
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
    case 3: 
    default: 
    case 13: 
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
    case 14: 
      a();
      return;
    }
    b();
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str1;
    if ((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Aggu != null))
    {
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null)
      {
        this.jdField_a_of_type_ComTencentQqEffectQEffectView = new QEffectView(paramContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.addView(this.jdField_a_of_type_ComTencentQqEffectQEffectView, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (paramSessionInfo.jdField_a_of_type_Aggu.a == null) {
        break label410;
      }
      if ((paramSessionInfo.jdField_a_of_type_Aggu.a instanceof ascy)) {
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
        ((bhzq)paramQQAppInterface.getManager(235)).a.a(i, new agvw(this, i));
        paramContext = paramSessionInfo + "-effect";
        label181:
        QAPM.setAbFactor("AIO背景", paramContext, adkp.class);
      }
      do
      {
        return;
        if (!(paramSessionInfo.jdField_a_of_type_Aggu.a instanceof URLDrawable)) {
          break label410;
        }
        paramSessionInfo = "aio-bg-dynamic";
        break;
        if ((ChatBackgroundManager.a(paramContext, str2, str1)) && (ChatBackgroundManager.a()))
        {
          paramContext = aggu.a(paramContext, str2, str1);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentQqEffectQEffectView.setSrc(paramContext.replace("aioImage", ""), "zip");
          QLog.i("QEffectBgProvider", 1, "set qeffect for custom background aioImageID:" + ChatBackgroundManager.d(paramContext));
          paramContext = paramSessionInfo + "-3d";
          break label181;
        }
        if (a(paramContext, str2, str1))
        {
          paramQQAppInterface = ThemeBackground.getDynamicDrawable(a(paramContext, str2, str1), 2130839099);
          bicd.a().a(paramQQAppInterface, true);
          paramContext = paramSessionInfo;
          if (paramQQAppInterface == null) {
            break label181;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.setBackgroundDrawable(paramQQAppInterface);
          paramContext = paramSessionInfo + "-video";
          break label181;
        }
        this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
        paramContext = paramSessionInfo;
        break label181;
      } while (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null);
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
      return;
      label410:
      paramSessionInfo = "aio-bg-default";
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 13, 14, 15, 16 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqEffectQEffectView != null) {
      this.jdField_a_of_type_ComTencentQqEffectQEffectView.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvv
 * JD-Core Version:    0.7.0.1
 */
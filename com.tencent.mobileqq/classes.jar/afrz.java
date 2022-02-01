import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeBackground.BusinessFlag;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;
import java.io.File;

public class afrz
  implements afrc
{
  private long jdField_a_of_type_Long;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QEffectView jdField_a_of_type_ComTencentQqEffectQEffectView;
  
  public afrz(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = aezp.a(paramContext, paramString1, paramString2);
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
    if ((paramSessionInfo != null) && (paramSessionInfo.chatBg != null))
    {
      str1 = paramSessionInfo.curFriendUin;
      if (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null)
      {
        this.jdField_a_of_type_ComTencentQqEffectQEffectView = new QEffectView(paramContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot.addView(this.jdField_a_of_type_ComTencentQqEffectQEffectView, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (paramSessionInfo.chatBg.a != null) {
        if ((paramSessionInfo.chatBg.a instanceof aqwv))
        {
          ThemeBackground.sAIOBusinessFlag.setUseStatic();
          paramSessionInfo = "aio-bg-static";
          this.jdField_a_of_type_ComTencentQqEffectQEffectView.setExtOptions(2, QEffectApngImageView.a(new int[] { 0 }, "-chatBg-"));
          str2 = paramQQAppInterface.getCurrentUin();
          i = ChatBackgroundManager.a(paramContext, str2, str1);
          if ((i <= 0) || (!ChatBackgroundManager.a())) {
            break label239;
          }
          ((bgga)paramQQAppInterface.getManager(235)).a.a(i, new afsa(this, i));
          paramContext = paramSessionInfo + "-effect";
          ThemeBackground.sAIOBusinessFlag.setUseEffect();
          QAPM.setAbFactor("AIO背景", paramContext, achj.class);
        }
      }
    }
    label239:
    while (this.jdField_a_of_type_ComTencentQqEffectQEffectView == null) {
      for (;;)
      {
        String str1;
        String str2;
        int i;
        return;
        if ((paramSessionInfo.chatBg.a instanceof URLDrawable))
        {
          ThemeBackground.sAIOBusinessFlag.setUseApng();
          paramSessionInfo = "aio-bg-dynamic";
          continue;
          ThemeBackground.sAIOBusinessFlag.setUseStatic();
        }
        else
        {
          paramSessionInfo = "aio-bg-default";
          continue;
          if ((ChatBackgroundManager.a(paramContext, str2, str1)) && (ChatBackgroundManager.a()))
          {
            paramContext = aezp.a(paramContext, str2, str1);
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentQqEffectQEffectView.setSrc(paramContext.replace("aioImage", ""), "zip");
            QLog.i("QEffectBgProvider", 1, "set qeffect for custom background aioImageID:" + ChatBackgroundManager.d(paramContext));
            paramContext = paramSessionInfo + "-3d";
            ThemeBackground.sAIOBusinessFlag.setUse3D();
          }
          else if (a(paramContext, str2, str1))
          {
            paramQQAppInterface = ThemeBackground.getDynamicDrawable(a(paramContext, str2, str1), 2130839134);
            bgio.a().a(paramQQAppInterface, true);
            paramContext = paramSessionInfo;
            if (paramQQAppInterface != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot.setBackgroundDrawable(paramQQAppInterface);
              paramContext = paramSessionInfo + "-video";
              ThemeBackground.sAIOBusinessFlag.setUseVideo();
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
            paramContext = paramSessionInfo;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqEffectQEffectView.clear();
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
 * Qualified Name:     afrz
 * JD-Core Version:    0.7.0.1
 */
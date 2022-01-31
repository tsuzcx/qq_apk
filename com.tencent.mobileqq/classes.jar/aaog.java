import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class aaog
  implements View.OnClickListener
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public ImageView a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  
  public aaog(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
  }
  
  private void d()
  {
    if (antc.d(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849310);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131625630));
      this.jdField_a_of_type_Int = 1;
      return;
    }
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849308);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131625631));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(2131299196));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_AndroidWidgetImageView).a();
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    d();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null))
    {
      QLog.e("ConversationTitleBtnCtrl", 1, "refreshCameraRedTouch, not inited");
      return;
    }
    if ((amdc.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      Object localObject = (auqh)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)localObject).a(6, "120000");
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
        ((auqh)localObject).b(localAppInfo, null);
        if (!paramBoolean) {
          awqx.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
        }
        label152:
        if (!paramBoolean) {
          break label213;
        }
        if (bool1) {
          break label215;
        }
      }
      label213:
      label215:
      for (localObject = "1";; localObject = "3")
      {
        awqx.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, (String)localObject, "", "", "");
        return;
        if ((bool1) || (!bool2)) {
          break label152;
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label152;
        break;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
  }
  
  public void b()
  {
    e();
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (amdc.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void c()
  {
    d();
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 500L) {}
    do
    {
      return;
      jdField_a_of_type_Long = l;
      if (QLog.isDevelopLevel()) {
        QLog.d("ConversationTitleBtnCtrl", 4, "userClick time=" + System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c(paramView);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    paramView = new Intent();
    paramView.putExtra("ExtendFriendLimitChatFromeType", 1);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), paramView, ExtendFriendLimitChatMatchFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaog
 * JD-Core Version:    0.7.0.1
 */
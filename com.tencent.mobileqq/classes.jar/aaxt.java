import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.2;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aaxt
  implements View.OnClickListener
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public ImageView a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  
  public aaxt(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849552);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691206));
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(2131364757));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_AndroidWidgetImageView).a();
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    b();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(this);
  }
  
  public void a(View paramView)
  {
    biwu.a().b();
    biwu.a().a("userClick");
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = akwf.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a());; bool = true)
    {
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().requestPermissions(new aaxu(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramView);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null))
    {
      QLog.e("ConversationTitleBtnCtrl", 1, "refreshCameraRedTouch, not inited");
      return;
    }
    if ((amtd.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      Object localObject = (avps)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)localObject).a(6, "120000");
      RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      boolean bool1 = RedTouch.a(localAppInfo);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
        ((avps)localObject).b(localAppInfo, null);
        if (!paramBoolean) {
          axqy.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
        }
        label154:
        if (!paramBoolean) {
          break label215;
        }
        if (bool1) {
          break label217;
        }
      }
      label215:
      label217:
      for (localObject = "1";; localObject = "3")
      {
        axqy.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, (String)localObject, "", "", "");
        return;
        if ((bool1) || (!bool2)) {
          break label154;
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label154;
        break;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
  }
  
  public void b()
  {
    boolean bool = aojt.d(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
    if (QLog.isDevelopLevel()) {
      QLog.d("ConversationTitleBtnCtrl", 4, "switchType isMatchChatMode =" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849554);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691205));
      this.jdField_a_of_type_Int = 1;
      return;
    }
    e();
  }
  
  public void b(View paramView)
  {
    Object localObject1 = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch)
    {
      localObject2 = (avps)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)localObject2).a(6, "120000");
      localObject1 = bjzs.a(localAppInfo.buffer.get(), "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1");
      ((avps)localObject2).a(localAppInfo, null);
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("cmode"))
      {
        if (!((String)localObject1).contains("?")) {
          break label208;
        }
        localObject2 = "&";
        localObject2 = ((String)localObject1).concat((String)localObject2 + "cmode" + "=" + "all");
      }
    }
    localObject1 = new Intent();
    ((Intent)localObject1).setData(Uri.parse((String)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.2(this), 500L);
    if (paramView != this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch) {}
    for (paramView = "1";; paramView = "3")
    {
      axqy.b(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
      return;
      label208:
      localObject2 = "?";
      break;
    }
  }
  
  public void c()
  {
    e();
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (amtd.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void d()
  {
    b();
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 500L) {
      jdField_a_of_type_Long = l;
    }
    do
    {
      return;
      jdField_a_of_type_Long = l;
      if (QLog.isDevelopLevel()) {
        QLog.d("ConversationTitleBtnCtrl", 4, "userClick time=" + System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        a(paramView);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    paramView = new Intent();
    paramView.putExtra("ExtendFriendLimitChatFromeType", 1);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), paramView, ExtendFriendLimitChatMatchFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxt
 * JD-Core Version:    0.7.0.1
 */
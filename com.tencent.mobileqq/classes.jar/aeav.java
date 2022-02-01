import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.2;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.5;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.6;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class aeav
  implements View.OnClickListener, bkzc
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private volatile String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private volatile int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile int c;
  
  public aeav(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
        b();
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void h()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "hideAllEntrances");
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.c = 0;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2))
    {
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850657);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691065));
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(2131365069);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374351);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(2131365070));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(2131365068));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_AndroidWidgetImageView).a();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(this);
    QzoneConfig.getInstance().addListener(this);
    a(true);
  }
  
  public void a(View paramView)
  {
    bnvd.a().d();
    bnvd.a().a("userClick");
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = aoqb.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a());; bool = true)
    {
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().requestPermissions(new aeaw(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramView);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "updateQQCircle " + paramBoolean);
    if (QzoneConfig.isQQCircleShowMessageEntrance()) {}
    for (this.jdField_a_of_type_Int = 2;; this.jdField_a_of_type_Int = 0)
    {
      g();
      b(paramBoolean);
      return;
    }
  }
  
  public void b()
  {
    boolean bool = asli.d(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
    if (QLog.isDevelopLevel()) {
      QLog.d("ConversationTitleBtnCtrl", 4, "switchType isMatchChatMode =" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850659);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691064));
      this.jdField_a_of_type_Int = 1;
      return;
    }
    i();
  }
  
  public void b(View paramView)
  {
    Object localObject2 = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    if (paramView != this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b()) {}
      }
    }
    else
    {
      localObject2 = (baif)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((baif)localObject2).a(6, "120000");
      localObject1 = bpgu.a(localAppInfo.buffer.get(), "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1");
      QLog.i("ConversationTitleBtnCtrl", 1, "handleCameraBtnClick---has red point, jumpSchme=" + (String)localObject1);
      ((baif)localObject2).a(localAppInfo, null);
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("cmode"))
      {
        if (!((String)localObject1).contains("?")) {
          break label268;
        }
        localObject2 = "&";
        localObject2 = ((String)localObject1).concat((String)localObject2 + "cmode" + "=" + "all");
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).setData(Uri.parse((String)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.4(this), 500L);
    if (paramView != this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch) {}
    for (paramView = "1";; paramView = "3")
    {
      bcst.b(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
      return;
      label268:
      localObject2 = "?";
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 2;
    if (this.jdField_a_of_type_Int != 2) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      ThreadManager.post(new ConversationTitleBtnCtrl.1(this), i, null, false);
      return;
      i = 5;
    }
  }
  
  public void c()
  {
    i();
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (aqpx.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    h();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 2) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null))
    {
      QLog.e("ConversationTitleBtnCtrl", 1, "refreshCameraRedTouch, not inited");
      return;
    }
    if ((aqpx.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      Object localObject = (baif)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((baif)localObject).a(6, "120000");
      RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      boolean bool1 = RedTouch.a(localAppInfo);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
        ((baif)localObject).b(localAppInfo, null);
        if (!paramBoolean) {
          bcst.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
        }
        label174:
        if (!paramBoolean) {
          break label244;
        }
        if (bool1) {
          break label246;
        }
      }
      label244:
      label246:
      for (localObject = "1";; localObject = "3")
      {
        bcst.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, (String)localObject, "", "", "");
        return;
        if ((bool1) || (!bool2)) {
          break label174;
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label174;
        break;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onAfterSyncMsg " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 2) {
      ThreadManager.post(new ConversationTitleBtnCtrl.6(this), 1, null, false);
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 500L) {
      jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_a_of_type_Long = l;
      if (QLog.isDevelopLevel()) {
        QLog.d("ConversationTitleBtnCtrl", 4, "userClick time=" + System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        a(paramView);
      }
      else
      {
        Object localObject;
        if (this.jdField_a_of_type_Int == 1)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("ExtendFriendLimitChatFromeType", 1);
          PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), (Intent)localObject, ExtendFriendLimitChatMatchFragment.class);
        }
        else if (this.jdField_a_of_type_Int == 2)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_enable_splash", true);
          ((Intent)localObject).putExtra("key_jump_from", "4");
          boolean bool;
          if (((!this.jdField_b_of_type_Boolean) || (this.c <= 0)) && (this.jdField_b_of_type_Int <= 0))
          {
            bool = true;
            label189:
            ((Intent)localObject).putExtra("key_enable_page_memory_cache", bool);
            uxo.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), (Intent)localObject);
            ThreadManager.post(new ConversationTitleBtnCtrl.2(this), 5, null, false);
            if (!vqu.a()) {
              break label284;
            }
          }
          label284:
          for (localObject = "1";; localObject = "0")
          {
            if (this.jdField_b_of_type_Int <= 0) {
              break label292;
            }
            vrf.a("", 2, 2, 2, (String)localObject, "", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", null, -1, -1);
            break;
            bool = false;
            break label189;
          }
          label292:
          if ((this.jdField_b_of_type_Boolean) && (this.c > 0)) {
            vrf.a("", 2, 2, 1, (String)localObject, "", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", null, -1, -1);
          } else {
            vrf.a("", 2, 2, 3, (String)localObject, "", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", null, -1, -1);
          }
        }
      }
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onConfigChange");
    this.jdField_a_of_type_AndroidOsHandler.post(new ConversationTitleBtnCtrl.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeav
 * JD-Core Version:    0.7.0.1
 */
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.2;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.3;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.6;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.7;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.8;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class adtz
  implements View.OnClickListener, QzoneConfig.QzoneConfigChangeListener
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private volatile int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private volatile boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private volatile boolean jdField_d_of_type_Boolean;
  
  public adtz(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void h()
  {
    if (this.jdField_d_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((QzoneConfig.isQQCircleShowMessageEntranceTips()) && (vvv.a() == 1)) {
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
          if ((localLayoutParams != null) && (this.jdField_a_of_type_AndroidAppActivity != null) && (ViewUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity) > 0))
          {
            localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin + (ViewUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity) - ViewUtils.dpToPx(32.0F)), localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          }
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          vvv.a(false);
        }
      }
    }
    do
    {
      ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.1(this), 5000L);
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
        }
        return;
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
        b();
      }
      if ((this.jdField_d_of_type_Int == 0) && (Build.VERSION.SDK_INT < 21))
      {
        QLog.d("ConversationTitleBtnCtrl", 1, "version below 5.0, hide the camera");
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
        }
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void i()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "hideAllEntrances");
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  private void j()
  {
    if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 2))
    {
      this.jdField_d_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850729);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691190));
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_d_of_type_Int == 2)
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.getSubThreadHandler().post(new ConversationTitleBtnCtrl.8(this));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365230);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131374034);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374492);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365231));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365229));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_AndroidWidgetImageView).a();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    QzoneConfig.getInstance().addListener(this);
    a(true);
  }
  
  public void a(View paramView)
  {
    bnqe.a().d();
    bnqe.a().a("userClick");
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());; bool = true)
    {
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().requestPermissions(new adua(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramView);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "updateQQCircle " + paramBoolean);
    if ((QzoneConfig.isQQCircleShowMessageEntrance()) && (QzoneConfig.isQQCircleShowLebaBySwitchButton()))
    {
      this.jdField_d_of_type_Int = 2;
      if (vvv.a() == -1) {
        vvv.a(true);
      }
      h();
      b(paramBoolean);
    }
    for (;;)
    {
      if (QzoneConfig.isQQCircleShowMessageEntrance())
      {
        this.jdField_a_of_type_JavaLangRunnable = new ConversationTitleBtnCtrl.2(this);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      this.jdField_d_of_type_Int = 0;
      h();
    }
  }
  
  public void b()
  {
    boolean bool = asrt.d(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a);
    if (QLog.isDevelopLevel()) {
      QLog.d("ConversationTitleBtnCtrl", 4, "switchType isMatchChatMode =" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850731);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691189));
      this.jdField_d_of_type_Int = 1;
      return;
    }
    j();
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
        if (!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c()) {}
      }
    }
    else
    {
      localObject2 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)localObject2).a(6, "120000");
      localObject1 = bove.a(localAppInfo.buffer.get(), "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1");
      QLog.i("ConversationTitleBtnCtrl", 1, "handleCameraBtnClick---has red point, jumpSchme=" + (String)localObject1);
      ((bbbq)localObject2).a(localAppInfo, null);
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("cmode"))
      {
        if (!((String)localObject1).contains("?")) {
          break label271;
        }
        localObject2 = "&";
        localObject2 = ((String)localObject1).concat((String)localObject2 + "cmode" + "=" + "all");
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).setData(Uri.parse((String)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.6(this), 500L);
    if (paramView != this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch) {}
    for (paramView = "1";; paramView = "3")
    {
      bdla.b(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
      return;
      label271:
      localObject2 = "?";
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 2;
    if (this.jdField_d_of_type_Int != 2) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      ThreadManager.post(new ConversationTitleBtnCtrl.3(this), i, null, false);
      return;
      i = 5;
    }
  }
  
  public void c()
  {
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (arby.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21) && (this.jdField_d_of_type_Int == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    i();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Int == 2) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null))
    {
      QLog.e("ConversationTitleBtnCtrl", 1, "refreshCameraRedTouch, not inited");
      return;
    }
    if ((arby.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      Object localObject = (bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)localObject).a(6, "120000");
      RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      boolean bool1 = RedTouch.a(localAppInfo);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c();
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
        ((bbbq)localObject).b(localAppInfo, null);
        if (!paramBoolean) {
          bdla.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
        }
        label176:
        if (!paramBoolean) {
          break label246;
        }
        if (bool1) {
          break label248;
        }
      }
      label246:
      label248:
      for (localObject = "1";; localObject = "3")
      {
        bdla.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, (String)localObject, "", "", "");
        return;
        if ((bool1) || (!bool2)) {
          break label176;
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label176;
        break;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void f()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onAfterSyncMsg " + this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    k();
  }
  
  public void g()
  {
    QCircleInitInject.g().getPluginCallbacks().clear();
    vvq.a().b();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374034) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      if (l - jdField_a_of_type_Long < 500L)
      {
        jdField_a_of_type_Long = l;
      }
      else
      {
        jdField_a_of_type_Long = l;
        if (QLog.isDevelopLevel()) {
          QLog.d("ConversationTitleBtnCtrl", 4, "userClick time=" + System.currentTimeMillis());
        }
        if (this.jdField_d_of_type_Int == 0)
        {
          a(paramView);
        }
        else
        {
          Object localObject;
          if (this.jdField_d_of_type_Int == 1)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("ExtendFriendLimitChatFromeType", 1);
            PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), (Intent)localObject, ExtendFriendLimitChatMatchFragment.class);
          }
          else if (this.jdField_d_of_type_Int == 2)
          {
            if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0))
            {
              QLog.e("ConversationTitleBtnCtrl", 1, "QQCircle entrance logo is not visilbe,direct return!");
            }
            else
            {
              HashMap localHashMap1 = new HashMap();
              HashMap localHashMap2 = new HashMap();
              localHashMap1.put("key_enable_splash", "1");
              localHashMap1.put("key_jump_from", "4");
              if (this.jdField_d_of_type_Boolean)
              {
                localObject = "1";
                label238:
                localHashMap1.put("key_show_active_red_dot", localObject);
                localHashMap1.put("key_unread_red_num", this.jdField_b_of_type_Int + "");
                if (this.jdField_a_of_type_Int > 0) {
                  localHashMap1.put("key_assign_show_tab_type", this.jdField_a_of_type_Int + "");
                }
                if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
                  localHashMap2.put("key_red_dot_trans_info", this.jdField_a_of_type_ArrayOfByte);
                }
                vvh.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), "openfolder", localHashMap1, localHashMap2);
                ThreadManager.post(new ConversationTitleBtnCtrl.4(this), 5, null, false);
                if (!QCircleRedPointManager.isQQCircleCurrentUseEeveeRedPoint()) {
                  break label436;
                }
              }
              label436:
              for (localObject = "1";; localObject = "0")
              {
                if (this.jdField_b_of_type_Int <= 0) {
                  break label444;
                }
                QCircleLpReportDc05504.report("", 2, 2, 2, (String)localObject, "", this.jdField_a_of_type_JavaLangString, null, "", "", null, -1, -1);
                break;
                localObject = "0";
                break label238;
              }
              label444:
              if (this.jdField_d_of_type_Boolean) {
                QCircleLpReportDc05504.report("", 2, 2, 1, (String)localObject, "", this.jdField_a_of_type_JavaLangString, null, "", "", null, -1, -1);
              } else {
                QCircleLpReportDc05504.report("", 2, 2, 3, (String)localObject, "", this.jdField_a_of_type_JavaLangString, null, "", "", null, -1, -1);
              }
            }
          }
        }
      }
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onConfigChange");
    this.jdField_a_of_type_AndroidOsHandler.post(new ConversationTitleBtnCtrl.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtz
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.1;
import com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.2;
import com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;

public class aeau
  implements View.OnClickListener, bkzc
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public aeau(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void d()
  {
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "hideAllEntrances");
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a()
  {
    d();
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365069);
      this.b = paramView.findViewById(2131374351);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365070));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "updateQQCircle " + paramBoolean);
    if (QzoneConfig.isQQCircleShowMessageEntrance()) {}
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 0)
    {
      c();
      b(paramBoolean);
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    QzoneConfig.getInstance().removeListener(this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int != 1) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      ThreadManager.post(new ConversationQbossBannerTitleEntranceCtrl.1(this), i, null, false);
      return;
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
        QLog.d("ConversationQbossBannerTitleEntranceCtrl", 4, "userClick time=" + System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_enable_splash", true);
        localIntent.putExtra("key_jump_from", "4");
        uxo.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), localIntent);
        ThreadManager.post(new ConversationQbossBannerTitleEntranceCtrl.2(this), 5, null, false);
      }
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "onConfigChange");
    this.jdField_a_of_type_AndroidOsHandler.post(new ConversationQbossBannerTitleEntranceCtrl.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeau
 * JD-Core Version:    0.7.0.1
 */
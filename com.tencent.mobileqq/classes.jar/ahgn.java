import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class ahgn
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private View b;
  
  public ahgn(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    b();
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), QQBrowserDelegationActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().startActivity(localIntent);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().findViewById(2131364695));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getLayoutInflater().inflate(2131559135, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, false);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131363099);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363098).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getColor(2131165422));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367579));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ahgo(this));
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367581)).setOnClickListener(new ahgp(this));
  }
  
  private static void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public void a()
  {
    bgwk.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpringBigInsertPage", 2, "showHongbaoLayer | imgUrl is: " + paramString1 + " actionUrl: " + paramString2);
    }
    if (!nam.a(paramString1))
    {
      QLog.d("SpringBigInsertPage", 2, "error, invalide url...");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ahgq(this, paramString2));
    PreloadManager.a().c(paramString1, new ahgr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgn
 * JD-Core Version:    0.7.0.1
 */
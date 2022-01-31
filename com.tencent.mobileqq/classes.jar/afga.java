import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;

public class afga
  extends afeb
{
  protected afgb a;
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  protected QQAppInterface a;
  protected AlphaClickableRelativeLayout a;
  protected XListView a;
  
  public afga(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "CTEntryController create");
    }
  }
  
  public void a(afgb paramafgb)
  {
    this.jdField_a_of_type_Afgb = paramafgb;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131310475));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout = ((AlphaClickableRelativeLayout)paramView.findViewById(2131309215));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309221));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131304163));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296584));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
  }
  
  public void c(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afga
 * JD-Core Version:    0.7.0.1
 */
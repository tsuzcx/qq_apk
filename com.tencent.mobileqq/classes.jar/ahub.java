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

public class ahub
  extends ahsd
{
  protected ahud a;
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  private babe a;
  protected QQAppInterface a;
  protected AlphaClickableRelativeLayout a;
  protected XListView a;
  
  public ahub(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Babe = new ahuc(this);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "CTEntryController create");
    }
  }
  
  public void a(ahud paramahud)
  {
    this.jdField_a_of_type_Ahud = paramahud;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376826));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout = ((AlphaClickableRelativeLayout)paramView.findViewById(2131375482));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375488));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131370123));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362131));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
  }
  
  public void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    boolean bool = babd.a();
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, String.format("shouldShowRecommendEntry, isStudyMode: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return !bool;
  }
  
  public void b()
  {
    super.b();
    babd.a(this.jdField_a_of_type_Babe);
  }
  
  public void d()
  {
    super.d();
    babd.b(this.jdField_a_of_type_Babe);
  }
  
  public void d(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahub
 * JD-Core Version:    0.7.0.1
 */
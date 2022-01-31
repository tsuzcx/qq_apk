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

public class ahpm
  extends ahno
{
  protected ahpo a;
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  private azwv a;
  protected QQAppInterface a;
  protected AlphaClickableRelativeLayout a;
  protected XListView a;
  
  public ahpm(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Azwv = new ahpn(this);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "CTEntryController create");
    }
  }
  
  public void a(ahpo paramahpo)
  {
    this.jdField_a_of_type_Ahpo = paramahpo;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376772));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout = ((AlphaClickableRelativeLayout)paramView.findViewById(2131375431));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375437));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131370104));
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
    boolean bool = azwu.a();
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, String.format("shouldShowRecommendEntry, isStudyMode: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return !bool;
  }
  
  public void b()
  {
    super.b();
    azwu.a(this.jdField_a_of_type_Azwv);
  }
  
  public void d()
  {
    super.d();
    azwu.b(this.jdField_a_of_type_Azwv);
  }
  
  public void d(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpm
 * JD-Core Version:    0.7.0.1
 */
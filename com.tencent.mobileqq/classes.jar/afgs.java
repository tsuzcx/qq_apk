import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.util.List;

public class afgs
  extends afga
{
  public static boolean a;
  private afgp jdField_a_of_type_Afgp;
  private afgq jdField_a_of_type_Afgq = new afgt(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afgu(this);
  
  public afgs(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a()
  {
    Object localObject = (ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    int i;
    if (TextUtils.isEmpty(((ajls)localObject).a))
    {
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Afgp != null) {
        break label108;
      }
      i = 0;
      label58:
      localObject = ((ajls)localObject).a(i);
      if (localObject != null) {
        break label119;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    label108:
    label119:
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        i = this.jdField_a_of_type_Afgp.getCount();
        break label58;
        if (((List)localObject).isEmpty()) {
          break label217;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        if (this.jdField_a_of_type_Afgp == null)
        {
          this.jdField_a_of_type_Afgp = new afgp(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true, this.jdField_a_of_type_Afgq);
          this.jdField_a_of_type_Afgp.a((List)localObject);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afgp);
        }
        while (((List)localObject).size() == 1)
        {
          f();
          return;
          this.jdField_a_of_type_Afgp.a((List)localObject);
        }
      }
    } while (this.jdField_a_of_type_Afgp == null);
    label217:
    this.jdField_a_of_type_Afgp.notifyDataSetChanged();
  }
  
  private void f()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.height = aciy.a(88.0F, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.a(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131647463));
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_Afgp != null) {
        this.jdField_a_of_type_Afgp.a(paramQQAppInterface);
      }
    }
    a();
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Afgp != null) && (this.jdField_a_of_type_Afgp.a(paramString)))
    {
      ((ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).i();
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    jdField_a_of_type_Boolean = true;
    a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Afgp != null) {
      this.jdField_a_of_type_Afgp.a(paramBoolean);
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Afgp != null) {
      this.jdField_a_of_type_Afgp.a();
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Afgp != null) {
      this.jdField_a_of_type_Afgp.a();
    }
    this.jdField_a_of_type_Afgp = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afgs
 * JD-Core Version:    0.7.0.1
 */
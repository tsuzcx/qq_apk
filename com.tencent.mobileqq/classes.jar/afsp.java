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

public class afsp
  extends afrx
{
  public static boolean a;
  private afsm jdField_a_of_type_Afsm;
  private afsn jdField_a_of_type_Afsn = new afsq(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afsr(this);
  
  public afsp(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a()
  {
    Object localObject = (akac)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    int i;
    if (TextUtils.isEmpty(((akac)localObject).a))
    {
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Afsm != null) {
        break label108;
      }
      i = 0;
      label58:
      localObject = ((akac)localObject).a(i);
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
        i = this.jdField_a_of_type_Afsm.getCount();
        break label58;
        if (((List)localObject).isEmpty()) {
          break label217;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        if (this.jdField_a_of_type_Afsm == null)
        {
          this.jdField_a_of_type_Afsm = new afsm(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true, this.jdField_a_of_type_Afsn);
          this.jdField_a_of_type_Afsm.a((List)localObject);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afsm);
        }
        while (((List)localObject).size() == 1)
        {
          f();
          return;
          this.jdField_a_of_type_Afsm.a((List)localObject);
        }
      }
    } while (this.jdField_a_of_type_Afsm == null);
    label217:
    this.jdField_a_of_type_Afsm.notifyDataSetChanged();
  }
  
  private void f()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.height = actn.a(88.0F, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.a(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131713251));
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_Afsm != null) {
        this.jdField_a_of_type_Afsm.a(paramQQAppInterface);
      }
    }
    a();
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Afsm != null) && (this.jdField_a_of_type_Afsm.a(paramString)))
    {
      ((akac)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).i();
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
    if (this.jdField_a_of_type_Afsm != null) {
      this.jdField_a_of_type_Afsm.a(paramBoolean);
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Afsm != null) {
      this.jdField_a_of_type_Afsm.a();
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Afsm != null) {
      this.jdField_a_of_type_Afsm.a();
    }
    this.jdField_a_of_type_Afsm = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsp
 * JD-Core Version:    0.7.0.1
 */
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

public class ajxg
  extends ajwi
{
  public static boolean a;
  private ajxd jdField_a_of_type_Ajxd;
  private ajxe jdField_a_of_type_Ajxe = new ajxh(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajxi(this);
  
  public ajxg(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a()
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    label125:
    do
    {
      for (;;)
      {
        return;
        Object localObject = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
        if (TextUtils.isEmpty(((aobl)localObject).a))
        {
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(false);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          if (this.jdField_a_of_type_Ajxd != null) {
            break label125;
          }
        }
        for (int i = 0;; i = this.jdField_a_of_type_Ajxd.getCount())
        {
          localObject = ((aobl)localObject).a(i);
          if (localObject != null) {
            break label136;
          }
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
          return;
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
        }
        if (((List)localObject).isEmpty()) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        if (this.jdField_a_of_type_Ajxd == null)
        {
          this.jdField_a_of_type_Ajxd = new ajxd(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true, this.jdField_a_of_type_Ajxe);
          this.jdField_a_of_type_Ajxd.a((List)localObject);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajxd);
        }
        while (((List)localObject).size() == 1)
        {
          f();
          return;
          this.jdField_a_of_type_Ajxd.a((List)localObject);
        }
      }
    } while (this.jdField_a_of_type_Ajxd == null);
    label136:
    this.jdField_a_of_type_Ajxd.notifyDataSetChanged();
  }
  
  private void f()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.height = agej.a(88.0F, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.a(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131712134));
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_Ajxd != null) {
        this.jdField_a_of_type_Ajxd.a(paramQQAppInterface);
      }
    }
    a();
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Ajxd != null) && (this.jdField_a_of_type_Ajxd.a(paramString)))
    {
      ((aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).i();
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ajxd != null) {
      this.jdField_a_of_type_Ajxd.a(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    jdField_a_of_type_Boolean = true;
    a();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Ajxd != null) {
      this.jdField_a_of_type_Ajxd.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    a();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Ajxd != null) {
      this.jdField_a_of_type_Ajxd.a();
    }
    this.jdField_a_of_type_Ajxd = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxg
 * JD-Core Version:    0.7.0.1
 */
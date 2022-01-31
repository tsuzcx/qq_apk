import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class ahse
  extends ArrayAdapter
  implements View.OnClickListener
{
  Filter jdField_a_of_type_AndroidWidgetFilter;
  
  public ahse(LoginView paramLoginView, Context paramContext)
  {
    super(paramContext, 2131558412, 2131368386, paramLoginView.jdField_a_of_type_JavaUtilList);
  }
  
  public String a(int paramInt)
  {
    String str = ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return str;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
  }
  
  public String b(int paramInt)
  {
    return ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
    }
    for (;;)
    {
      return super.getCount();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(0);
    }
  }
  
  public Filter getFilter()
  {
    if (this.jdField_a_of_type_AndroidWidgetFilter == null) {
      this.jdField_a_of_type_AndroidWidgetFilter = new ahsf(this);
    }
    return this.jdField_a_of_type_AndroidWidgetFilter;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (LinearLayout)paramView.findViewById(2131362998);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368335);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a(((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin(), false);
    if ((localObject instanceof Bitmap))
    {
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView = (ImageView)paramView.findViewById(2131368327);
      localImageView.setTag(Integer.valueOf(paramInt));
      localImageView.setOnClickListener(this);
      localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720056));
      paramView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131689548) + "%s", new Object[] { ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin() }));
      if (getCount() != 1) {
        break label256;
      }
      paramViewGroup.setPadding(0, actj.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()), 0, actj.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()));
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new ahsg(this, paramInt));
      paramView.setOnTouchListener(new mud());
      return paramView;
      localImageView.setImageResource(2130840288);
      break;
      label256:
      if (paramInt == 0) {
        paramViewGroup.setPadding(0, actj.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()), 0, 0);
      } else if (paramInt == getCount() - 1) {
        paramViewGroup.setPadding(0, 0, 0, actj.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()));
      } else {
        paramViewGroup.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_Int = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahse
 * JD-Core Version:    0.7.0.1
 */
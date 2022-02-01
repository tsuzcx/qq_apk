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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class alsl
  extends ArrayAdapter
  implements View.OnClickListener
{
  Filter jdField_a_of_type_AndroidWidgetFilter;
  
  public alsl(LoginView paramLoginView, Context paramContext)
  {
    super(paramContext, 2131558412, 2131368996, paramLoginView.jdField_a_of_type_JavaUtilList);
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
      this.jdField_a_of_type_AndroidWidgetFilter = new alsm(this);
    }
    return this.jdField_a_of_type_AndroidWidgetFilter;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131363243);
    ImageView localImageView = (ImageView)localView.findViewById(2131368913);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a(((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin(), false);
    if ((localObject instanceof Bitmap))
    {
      localImageView.setImageBitmap((Bitmap)localObject);
      localImageView = (ImageView)localView.findViewById(2131368869);
      localImageView.setTag(Integer.valueOf(paramInt));
      localImageView.setOnClickListener(this);
      localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718538));
      localView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131689501) + "%s", new Object[] { ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin() }));
      if (getCount() != 1) {
        break label280;
      }
      localLinearLayout.setPadding(0, agej.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()), 0, agej.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()));
    }
    for (;;)
    {
      localLinearLayout.setOnClickListener(new alsn(this, paramInt));
      localView.setOnTouchListener(new mve());
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localImageView.setImageResource(2130840588);
      break;
      label280:
      if (paramInt == 0) {
        localLinearLayout.setPadding(0, agej.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()), 0, 0);
      } else if (paramInt == getCount() - 1) {
        localLinearLayout.setPadding(0, 0, 0, agej.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()));
      } else {
        localLinearLayout.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_Int = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsl
 * JD-Core Version:    0.7.0.1
 */
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class abtl
  extends aims
{
  private List<abti> jdField_a_of_type_JavaUtilList;
  
  public abtl(List<abti> paramList)
  {
    super(paramList, paramList.app, paramList.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559441, paramViewGroup, false);
      paramViewGroup = new abto();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131367679));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370647));
      paramView.setTag(paramViewGroup);
      Object localObject = getItem(paramInt);
      if (localObject != null)
      {
        localObject = (abti)localObject;
        if (localObject != null)
        {
          paramViewGroup.jdField_a_of_type_JavaLangString = ((abti)localObject).a.getUin();
          paramViewGroup.jdField_a_of_type_Abti = ((abti)localObject);
          paramViewGroup.c.setImageBitmap(super.a(paramViewGroup.jdField_a_of_type_JavaLangString, 1, (byte)0));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((abti)localObject).a.name);
          if (((abti)localObject).a.certifiedGrade <= 0L) {
            break label256;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getResources().getDrawable(2130841310);
            this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
            ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      return paramView;
      paramViewGroup = (abto)paramView.getTag();
      break;
      label256:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abtl
 * JD-Core Version:    0.7.0.1
 */
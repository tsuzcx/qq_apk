import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import java.util.List;

public class adwq
  extends BaseAdapter
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public adwq(SelectedAndSearchBar paramSelectedAndSearchBar)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = SelectedAndSearchBar.a(paramSelectedAndSearchBar).getResources().getDrawable(2130844552);
    this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a();
  }
  
  private int a(int paramInt)
  {
    int i = 4;
    if (paramInt == 4) {
      i = 11;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt == 3000) {
      return 101;
    }
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar) != null) && (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).size() > 0))
      {
        ResultRecord localResultRecord = (ResultRecord)SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).get(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).size() - 1);
        if (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar) != null) {
          SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).a(localResultRecord);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(false);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = null;
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar)).inflate(2131559201, null);
    }
    paramViewGroup.setTag(localResultRecord);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131365912);
    label99:
    int i;
    if (paramInt == getCount() - 1)
    {
      paramView = str;
      if (this.jdField_a_of_type_Boolean) {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      localImageView.setImageDrawable(paramView);
      if (localResultRecord.jdField_b_of_type_Int != -1) {
        break label166;
      }
      paramInt = localResultRecord.jdField_a_of_type_Int;
      if (localResultRecord.jdField_a_of_type_Int != -1) {
        break label179;
      }
      i = paramInt;
      label111:
      localResultRecord.jdField_a_of_type_Int = i;
      if (!alof.z.equals(localResultRecord.jdField_a_of_type_JavaLangString)) {
        break label189;
      }
      localImageView.setBackgroundResource(2130843834);
    }
    for (;;)
    {
      if (AppSetting.c) {
        localImageView.setContentDescription(localResultRecord.jdField_b_of_type_JavaLangString);
      }
      return paramViewGroup;
      localImageView.setImageDrawable(null);
      break;
      label166:
      paramInt = a(localResultRecord.jdField_b_of_type_Int);
      break label99;
      label179:
      i = localResultRecord.jdField_a_of_type_Int;
      break label111;
      label189:
      if (alof.A.equals(localResultRecord.jdField_a_of_type_JavaLangString))
      {
        localImageView.setBackgroundResource(2130843832);
      }
      else if (alof.B.equals(localResultRecord.jdField_a_of_type_JavaLangString))
      {
        localImageView.setBackgroundResource(2130843837);
      }
      else if (alof.y.equals(localResultRecord.jdField_a_of_type_JavaLangString))
      {
        localImageView.setBackgroundResource(2130839385);
      }
      else
      {
        if (localResultRecord.jdField_a_of_type_Int != 5) {
          break label280;
        }
        localImageView.setImageResource(2130841744);
      }
    }
    label280:
    str = localResultRecord.jdField_a_of_type_JavaLangString;
    paramView = SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).a(paramInt, str);
    if (paramView == null)
    {
      SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).a(str, paramInt, true);
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    for (;;)
    {
      localImageView.setBackgroundDrawable(new BitmapDrawable(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).getResources(), paramView));
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adwq
 * JD-Core Version:    0.7.0.1
 */
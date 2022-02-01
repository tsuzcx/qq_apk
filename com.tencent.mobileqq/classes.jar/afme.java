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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afme
  extends BaseAdapter
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public afme(SelectedAndSearchBar paramSelectedAndSearchBar)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = SelectedAndSearchBar.a(paramSelectedAndSearchBar).getResources().getDrawable(2130844961);
    this.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.a();
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
    Object localObject = null;
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar)).inflate(2131559281, null);
    }
    for (;;)
    {
      paramView.setTag(localResultRecord);
      ImageView localImageView = (ImageView)paramView.findViewById(2131366213);
      int i;
      label97:
      int j;
      if (paramInt == getCount() - 1)
      {
        if (this.jdField_a_of_type_Boolean) {
          localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        localImageView.setImageDrawable((Drawable)localObject);
        if (localResultRecord.jdField_b_of_type_Int != -1) {
          break label179;
        }
        i = localResultRecord.jdField_a_of_type_Int;
        if (localResultRecord.jdField_a_of_type_Int != -1) {
          break label193;
        }
        j = i;
        label110:
        localResultRecord.jdField_a_of_type_Int = j;
        if (!antf.z.equals(localResultRecord.jdField_a_of_type_JavaLangString)) {
          break label203;
        }
        localImageView.setBackgroundResource(2130844234);
      }
      for (;;)
      {
        if (AppSetting.c) {
          localImageView.setContentDescription(localResultRecord.jdField_b_of_type_JavaLangString);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageDrawable(null);
        break;
        label179:
        i = a(localResultRecord.jdField_b_of_type_Int);
        break label97;
        label193:
        j = localResultRecord.jdField_a_of_type_Int;
        break label110;
        label203:
        if (antf.A.equals(localResultRecord.jdField_a_of_type_JavaLangString))
        {
          localImageView.setBackgroundResource(2130844232);
        }
        else if (antf.B.equals(localResultRecord.jdField_a_of_type_JavaLangString))
        {
          localImageView.setBackgroundResource(2130844237);
        }
        else if (antf.y.equals(localResultRecord.jdField_a_of_type_JavaLangString))
        {
          localImageView.setBackgroundResource(2130839573);
        }
        else
        {
          if (localResultRecord.jdField_a_of_type_Int != 5) {
            break label294;
          }
          localImageView.setImageResource(2130842062);
        }
      }
      label294:
      String str = localResultRecord.jdField_a_of_type_JavaLangString;
      localObject = SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).a(i, str);
      if (localObject == null)
      {
        SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).a(str, i, true);
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      for (;;)
      {
        localImageView.setBackgroundDrawable(new BitmapDrawable(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).getResources(), (Bitmap)localObject));
        break;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afme
 * JD-Core Version:    0.7.0.1
 */
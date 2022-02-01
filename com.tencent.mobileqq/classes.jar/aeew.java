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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aeew
  extends BaseAdapter
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public aeew(SelectedAndSearchBar paramSelectedAndSearchBar)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = SelectedAndSearchBar.a(paramSelectedAndSearchBar).getResources().getDrawable(2130844842);
    this.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a();
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
          SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).onItemDeleted(localResultRecord);
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
      paramView = LayoutInflater.from(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar)).inflate(2131559287, null);
    }
    for (;;)
    {
      paramView.setTag(localResultRecord);
      ImageView localImageView = (ImageView)paramView.findViewById(2131366241);
      int i;
      label97:
      int j;
      if (paramInt == getCount() - 1)
      {
        if (this.jdField_a_of_type_Boolean) {
          localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        localImageView.setImageDrawable((Drawable)localObject);
        if (localResultRecord.uinType != -1) {
          break label179;
        }
        i = localResultRecord.type;
        if (localResultRecord.type != -1) {
          break label193;
        }
        j = i;
        label110:
        localResultRecord.type = j;
        if (!AppConstants.DATALINE_PC_UIN.equals(localResultRecord.uin)) {
          break label203;
        }
        localImageView.setBackgroundResource(2130844119);
      }
      for (;;)
      {
        if (AppSetting.c) {
          localImageView.setContentDescription(localResultRecord.name);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageDrawable(null);
        break;
        label179:
        i = a(localResultRecord.uinType);
        break label97;
        label193:
        j = localResultRecord.type;
        break label110;
        label203:
        if (AppConstants.DATALINE_IPAD_UIN.equals(localResultRecord.uin))
        {
          localImageView.setBackgroundResource(2130844117);
        }
        else if (AppConstants.DATALINE_PRINTER_UIN.equals(localResultRecord.uin))
        {
          localImageView.setBackgroundResource(2130844122);
        }
        else if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(localResultRecord.uin))
        {
          localImageView.setBackgroundResource(2130839608);
        }
        else
        {
          if (localResultRecord.type != 5) {
            break label294;
          }
          localImageView.setImageResource(2130842104);
        }
      }
      label294:
      String str = localResultRecord.uin;
      localObject = SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).getBitmapFromCache(i, str);
      if (localObject == null)
      {
        SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).requestDecodeFace(str, i, true);
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
 * Qualified Name:     aeew
 * JD-Core Version:    0.7.0.1
 */
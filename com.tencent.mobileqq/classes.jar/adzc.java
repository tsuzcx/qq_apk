import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.NumberCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class adzc
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public adzc(PhotoListPanel paramPhotoListPanel) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf.getItemCount() <= 0) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf.a(this.jdField_a_of_type_Int);
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf.getItemViewType(this.jdField_a_of_type_Int);
    if ((!paramView.mChecked) && (baaf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, PhotoListPanel.b)))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramView.mChecked);
      return;
    }
    if ((j == 1) && (baaf.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity)))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramView.mChecked);
      return;
    }
    if ((j == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (!paramView.mChecked) && (baaf.c(paramView, 104345600L, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity))) {
      baaf.d();
    }
    if ((j == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (baaf.b(paramView, PhotoListPanel.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity)))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramView.mChecked);
      return;
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) && (!paramView.mChecked))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
      String str;
      long l1;
      for (i = 0; ((Iterator)localObject).hasNext(); i = (int)(bace.a(str) + l1))
      {
        str = (String)((Iterator)localObject).next();
        l1 = i;
      }
      if (i + bace.a(paramView.path) > 52428800L)
      {
        localObject = (xrh)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if ((localObject != null) && (((xrh)localObject).a()))
        {
          l1 = 0L;
          try
          {
            long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            l1 = l2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          if (((xrh)localObject).a(l1, 1))
          {
            bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, "选择图片总大小不能超过50M", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getDimensionPixelSize(2131167766));
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramView.mChecked);
            return;
          }
        }
      }
    }
    boolean bool;
    if (!paramView.mChecked)
    {
      bool = true;
      paramView.mChecked = bool;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramView.mChecked);
      if (!paramView.mChecked) {
        break label625;
      }
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramView.path, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.add(paramView.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.add(paramView.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzd != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a());
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size();
      ((NumberCheckBox)this.jdField_a_of_type_AndroidWidgetCheckBox).setCheckedNumber(i);
      awqx.b(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k();
      return;
      bool = false;
      break;
      label625:
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramView.path);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.remove(paramView.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.remove(paramView.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzd != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzc
 * JD-Core Version:    0.7.0.1
 */
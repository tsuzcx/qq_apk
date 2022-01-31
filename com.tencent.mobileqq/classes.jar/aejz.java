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

public class aejz
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public aejz(PhotoListPanel paramPhotoListPanel) {}
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.getItemCount() <= 0) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.a(this.jdField_a_of_type_Int);
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.getItemViewType(this.jdField_a_of_type_Int);
    if ((!paramView.mChecked) && (bbbx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, PhotoListPanel.jdField_a_of_type_Int)))
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramView.mChecked);
      return;
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) && (!paramView.mChecked))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
      String str;
      for (i = 0; ((Iterator)localObject).hasNext(); i = (int)(i + bbdx.a(str))) {
        str = (String)((Iterator)localObject).next();
      }
      if (i + bbdx.a(paramView.path) > 52428800L)
      {
        localObject = (yah)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if ((localObject != null) && (((yah)localObject).a()))
        {
          long l1 = 0L;
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
          if (((yah)localObject).a(l1, 1))
          {
            bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, "选择图片总大小不能超过50M", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getDimensionPixelSize(2131298865));
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
        break label542;
      }
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramView.path, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.add(paramView.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.add(paramView.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aeka != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aeka.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a());
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size();
      ((NumberCheckBox)this.jdField_a_of_type_AndroidWidgetCheckBox).setCheckedNumber(i);
      axqy.b(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
      if (PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel) != null) {
        PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getContext(), paramView.path, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilMap, null, true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k();
      return;
      bool = false;
      break;
      label542:
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramView.path);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.remove(paramView.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.remove(paramView.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aeka != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aeka.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejz
 * JD-Core Version:    0.7.0.1
 */
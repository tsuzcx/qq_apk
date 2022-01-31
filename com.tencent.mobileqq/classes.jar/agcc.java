import android.content.res.Resources;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import java.util.ArrayList;

public class agcc
  implements behk
{
  public agcc(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " onItemSelected position=" + paramInt);
    }
    LocalMediaInfo localLocalMediaInfo = this.a.b(this.a.jdField_a_of_type_Agdb.a(paramInt));
    if (this.a.E)
    {
      if ((localLocalMediaInfo == null) || (this.a.a(localLocalMediaInfo.path) != 1)) {
        break label444;
      }
      if (this.a.jdField_a_of_type_Agew != null)
      {
        agfe localagfe = new agfe();
        localagfe.jdField_a_of_type_Boolean = false;
        localagfe.jdField_a_of_type_JavaLangString = localLocalMediaInfo.path;
        this.a.jdField_a_of_type_Agew.a(paramAdapterView, localagfe);
      }
      if (paramView != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306223));
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.a.b != 0) && (this.a.b != 1) && (this.a.b != 3000)) {
        break label432;
      }
      PhotoPreviewActivity.b(this.a, 8);
    }
    for (;;)
    {
      this.a.t = paramInt;
      try
      {
        this.a.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.a.b((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t)).thumbRect);
        if (PhotoPreviewActivity.c(this.a))
        {
          PhotoPreviewActivity.a(this.a, this.a.t);
          this.a.g();
          if (!this.a.w)
          {
            if (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
              break label590;
            }
            this.a.d.setText(paramInt + 1 + " / " + this.a.jdField_a_of_type_JavaUtilArrayList.size());
          }
          paramAdapterView = (String)paramAdapterView.getAdapter().getItem(paramInt);
          if ((this.a.a(paramAdapterView) == 1) && (!this.a.g)) {
            this.a.f();
          }
          if (PhotoPreviewActivity.c(this.a)) {
            PhotoPreviewActivity.a(this.a, (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t));
          }
          return;
          label432:
          PhotoPreviewActivity.c(this.a, 8);
          continue;
          label444:
          PhotoPreviewActivity.c(this.a, 0);
          if (this.a.jdField_a_of_type_Agew == null) {
            continue;
          }
          this.a.jdField_a_of_type_Agew.a(null, null);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("PhotoPreviewActivity", 2, befj.a(paramView));
            continue;
            if (this.a.c.contains(Integer.valueOf(this.a.t)))
            {
              int i = this.a.c.indexOf(Integer.valueOf(this.a.t));
              if (i != -1) {
                PhotoPreviewActivity.a(this.a, i + 1);
              } else {
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
              }
            }
            else
            {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
              continue;
              label590:
              this.a.d.setText(this.a.getResources().getString(2131629655));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcc
 * JD-Core Version:    0.7.0.1
 */
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agcq
  implements View.OnClickListener
{
  public agcq(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())
    {
      if (baaf.a(this.a.jdField_b_of_type_JavaUtilArrayList, PhotoPreviewActivity.a, PhotoListActivity.a, this.a.E, this.a.g) > 0)
      {
        bbmy.a(this.a, this.a.getResources().getString(2131629431), 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
        return;
      }
      this.a.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcq
 * JD-Core Version:    0.7.0.1
 */
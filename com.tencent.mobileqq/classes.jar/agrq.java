import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class agrq
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public agrq(NewPhotoListActivity paramNewPhotoListActivity) {}
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.a.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.a.a.a(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetCheckBox);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrq
 * JD-Core Version:    0.7.0.1
 */
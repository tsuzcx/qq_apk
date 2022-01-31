import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;

public class agpe
  implements View.OnClickListener
{
  public agpe(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = QzonePhotoPreviewActivity.a(this.a);
    paramView.putExtra("PhotoConst.send_changtu", true);
    paramView.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    paramView.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    PhotoUtils.a(this.a.getActivity(), QzonePhotoPreviewActivity.a(this.a), this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_Int, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpe
 * JD-Core Version:    0.7.0.1
 */
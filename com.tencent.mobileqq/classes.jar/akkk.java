import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akkk
  implements View.OnClickListener
{
  public akkk(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = QzonePhotoPreviewActivity.a(this.a);
    localIntent.putExtra("PhotoConst.send_changtu", true);
    localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    localIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    PhotoUtils.sendPhoto(this.a.getActivity(), QzonePhotoPreviewActivity.a(this.a), this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_Int, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkk
 * JD-Core Version:    0.7.0.1
 */
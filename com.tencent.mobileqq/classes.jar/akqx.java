import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.widget.AdapterView;

public class akqx
  implements bljm
{
  public akqx(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QzonePhotoPreviewActivity.a(this.a))
    {
      this.a.getActivity().finish();
      bhkd.anim(this.a.getActivity(), true, false);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqx
 * JD-Core Version:    0.7.0.1
 */
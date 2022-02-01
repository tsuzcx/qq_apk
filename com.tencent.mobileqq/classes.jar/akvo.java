import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akvo
  implements View.OnClickListener
{
  akvo(akvn paramakvn) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).flashPicCb.toggle();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvo
 * JD-Core Version:    0.7.0.1
 */
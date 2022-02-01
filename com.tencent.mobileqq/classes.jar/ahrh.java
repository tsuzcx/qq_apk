import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import java.util.concurrent.CopyOnWriteArraySet;

public class ahrh
  extends aggl
{
  public ImageView a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public URLDrawable a;
  public VideoProgressView a;
  public CropBubbleVideoView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;
  
  public ahrh(ahqw paramahqw) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCurPlayingPos();
      if (l > 0L)
      {
        MessageForShortVideo localMessageForShortVideo = bhjz.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getId()));
        if (localMessageForShortVideo != null) {
          ahqw.a(this.jdField_a_of_type_Ahqw, localMessageForShortVideo, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.releasePlayer(true);
      ahqw.a().remove(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrh
 * JD-Core Version:    0.7.0.1
 */
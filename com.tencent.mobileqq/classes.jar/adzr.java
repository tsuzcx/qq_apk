import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.videoplatform.CropBubbleVideoView;
import java.util.concurrent.CopyOnWriteArraySet;

public class adzr
  extends acun
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
  
  public adzr(adzh paramadzh) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a();
      if (l > 0L)
      {
        MessageForShortVideo localMessageForShortVideo = bbbf.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.getId()));
        if (localMessageForShortVideo != null) {
          adzh.a(this.jdField_a_of_type_Adzh, localMessageForShortVideo, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(true);
      adzh.a().remove(this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzr
 * JD-Core Version:    0.7.0.1
 */
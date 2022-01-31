import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.videoplatform.CropBubbleVideoView;
import java.util.concurrent.CopyOnWriteArraySet;

public class adzp
  extends acuj
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
  
  public adzp(adzf paramadzf) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a();
      if (l > 0L)
      {
        MessageForShortVideo localMessageForShortVideo = bbbt.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.getId()));
        if (localMessageForShortVideo != null) {
          adzf.a(this.jdField_a_of_type_Adzf, localMessageForShortVideo, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(true);
      adzf.a().remove(this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzp
 * JD-Core Version:    0.7.0.1
 */
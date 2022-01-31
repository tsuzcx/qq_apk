import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.videoplayer.AIOBubbleVideoView;
import java.util.concurrent.CopyOnWriteArraySet;

public class ados
  extends acju
{
  public ImageView a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public URLDrawable a;
  public VideoProgressView a;
  public AIOBubbleVideoView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;
  
  public ados(adoi paramadoi) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a();
      if (l > 0L)
      {
        MessageForShortVideo localMessageForShortVideo = baab.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.getId()));
        if (localMessageForShortVideo != null) {
          adoi.a(this.jdField_a_of_type_Adoi, localMessageForShortVideo, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(true);
      adoi.a().remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ados
 * JD-Core Version:    0.7.0.1
 */
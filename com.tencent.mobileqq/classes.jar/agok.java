import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.util.concurrent.CopyOnWriteArraySet;

public class agok
  extends aezf
{
  public ImageView a;
  public TextView a;
  public CropBubbleVideoView a;
  public MessageProgressView a;
  public ImageView b;
  public int e;
  public int f;
  
  public agok(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCurPlayingPos();
      if (l > 0L)
      {
        MessageForShortVideo localMessageForShortVideo = bfth.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getId()));
        if (localMessageForShortVideo != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a(localMessageForShortVideo, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.releasePlayer(true);
      ShortVideoRealItemBuilder.a.remove(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agok
 * JD-Core Version:    0.7.0.1
 */
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.videoplatform.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.util.concurrent.CopyOnWriteArraySet;

public class aeaf
  extends acuj
{
  public ImageView a;
  public TextView a;
  public CropBubbleVideoView a;
  public MessageProgressView a;
  public ImageView b;
  public int e;
  public int f;
  
  public aeaf(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a();
      if (l > 0L)
      {
        MessageForShortVideo localMessageForShortVideo = bbbt.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.getId()));
        if (localMessageForShortVideo != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a(localMessageForShortVideo, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(true);
      ShortVideoRealItemBuilder.a.remove(this.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeaf
 * JD-Core Version:    0.7.0.1
 */
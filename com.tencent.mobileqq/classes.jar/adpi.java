import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.videoplayer.AIOBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.util.concurrent.CopyOnWriteArraySet;

public class adpi
  extends acju
{
  public ImageView a;
  public TextView a;
  public AIOBubbleVideoView a;
  public MessageProgressView a;
  public ImageView b;
  public int e;
  public int f;
  
  public adpi(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView != null)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a();
      if (l > 0L)
      {
        MessageForShortVideo localMessageForShortVideo = baab.a().a(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.getId()));
        if (localMessageForShortVideo != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a(localMessageForShortVideo, l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(true);
      ShortVideoRealItemBuilder.a.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adpi
 * JD-Core Version:    0.7.0.1
 */
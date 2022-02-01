import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import com.tencent.mobileqq.activity.photo.album.preview.VideoPreviewPresent;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class ajtz
  extends VideoPreviewPresent
{
  public ajtz(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  public BaseVideoView generateVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    paramVideoPlayParam.mSceneId = 105;
    paramVideoPlayParam.mSceneName = azjn.a(105);
    return (BaseVideoView)azjm.b(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtz
 * JD-Core Version:    0.7.0.1
 */
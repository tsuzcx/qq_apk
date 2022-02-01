import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import com.tencent.mobileqq.activity.photo.album.preview.VideoPreviewPresent;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class akkx
  extends VideoPreviewPresent
{
  public akkx(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  public BaseVideoView generateVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    paramVideoPlayParam.mSceneId = 105;
    paramVideoPlayParam.mSceneName = azws.a(105);
    return (BaseVideoView)azwr.b(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkx
 * JD-Core Version:    0.7.0.1
 */
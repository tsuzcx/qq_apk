import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import com.tencent.mobileqq.activity.photo.album.preview.VideoPreviewPresent;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class akpr
  extends VideoPreviewPresent
{
  public akpr(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  public BaseVideoView generateVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    paramVideoPlayParam.mSceneId = 105;
    paramVideoPlayParam.mSceneName = bapv.a(105);
    return (BaseVideoView)bapu.b(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpr
 * JD-Core Version:    0.7.0.1
 */
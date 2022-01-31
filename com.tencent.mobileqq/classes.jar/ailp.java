import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class ailp
  implements MediaPlayer.OnCompletionListener
{
  public ailp(VideoSprite paramVideoSprite) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.j) {
      this.a.b.b(new ailq(this));
    }
    do
    {
      return;
      this.a.g = false;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener == null);
    this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailp
 * JD-Core Version:    0.7.0.1
 */
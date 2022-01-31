import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

public final class ajyw
  implements Runnable
{
  public ajyw(WeakReference paramWeakReference, String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener) {}
  
  public void run()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyw
 * JD-Core Version:    0.7.0.1
 */
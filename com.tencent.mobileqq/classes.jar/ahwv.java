import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.OnBuiltListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class ahwv
  implements Runnable
{
  public ahwv(SceneBuilder paramSceneBuilder, SpriteGLView paramSpriteGLView, SceneBuilder.OnBuiltListener paramOnBuiltListener) {}
  
  public void run()
  {
    String str = SceneBuilder.a(SceneBuilder.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder) + "/scene.json");
    new Handler(Looper.getMainLooper()).post(new ahww(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahwv
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.OnBuiltListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class aipt
  implements Runnable
{
  public aipt(SceneBuilder paramSceneBuilder, SpriteGLView paramSpriteGLView, SceneBuilder.OnBuiltListener paramOnBuiltListener) {}
  
  public void run()
  {
    String str = SceneBuilder.a(SceneBuilder.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder) + "/scene.json");
    new Handler(Looper.getMainLooper()).post(new aipu(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipt
 * JD-Core Version:    0.7.0.1
 */
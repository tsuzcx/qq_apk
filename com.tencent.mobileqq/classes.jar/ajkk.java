import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.OnBuiltListener;
import com.tencent.mobileqq.surfaceviewaction.gl.Layer;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;

class ajkk
  implements SceneBuilder.OnBuiltListener
{
  ajkk(ajkj paramajkj) {}
  
  public void a(Layer paramLayer)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    this.a.a.jdField_a_of_type_AndroidOsHandler.post(new ajkl(this, paramLayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkk
 * JD-Core Version:    0.7.0.1
 */
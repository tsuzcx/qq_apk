import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;

class ajkr
  implements FrameSprite.OnFrameEndListener
{
  ajkr(ajkj paramajkj) {}
  
  public void a()
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
      this.a.a.jdField_a_of_type_AndroidOsHandler.post(new ajks(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkr
 * JD-Core Version:    0.7.0.1
 */
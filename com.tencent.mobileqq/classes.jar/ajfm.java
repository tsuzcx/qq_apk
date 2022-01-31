import android.graphics.Bitmap;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;

class ajfm
  implements FaceDrawable.OnLoadingStateChangeListener
{
  ajfm(ajfl paramajfl, Sprite paramSprite) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1) && (this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfh.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a != null))
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(TroopUtils.a(FaceDrawable.a(this.jdField_a_of_type_Ajfl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfh.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$TroopEnterEffectData.a)), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d(), true);
      this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfh.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a.b(new ajfn(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfm
 * JD-Core Version:    0.7.0.1
 */
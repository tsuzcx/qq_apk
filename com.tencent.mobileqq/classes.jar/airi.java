import android.graphics.Bitmap;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;

class airi
  implements FaceDrawable.OnLoadingStateChangeListener
{
  airi(airh paramairh, Sprite paramSprite) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1) && (this.jdField_a_of_type_Airh.jdField_a_of_type_Aird.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a != null))
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(TroopUtils.a(FaceDrawable.a(this.jdField_a_of_type_Airh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Airh.jdField_a_of_type_Aird.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$TroopEnterEffectData.a)), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d(), true);
      this.jdField_a_of_type_Airh.jdField_a_of_type_Aird.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a.b(new airj(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     airi
 * JD-Core Version:    0.7.0.1
 */
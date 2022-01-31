import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;

public class aird
  implements Runnable
{
  public aird(TroopEnterEffectController paramTroopEnterEffectController, TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new SceneBuilder().a(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth()).a(TroopEnterEffectController.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$TroopEnterEffectData.a).a(new airl(this)).a(new airk(this, localQQAppInterface)).a(new airh(this, localQQAppInterface)).a(new airg(this)).a(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, new aire(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aird
 * JD-Core Version:    0.7.0.1
 */
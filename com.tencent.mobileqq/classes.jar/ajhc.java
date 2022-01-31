import android.graphics.Bitmap;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.qphone.base.util.QLog;

class ajhc
  implements FaceDrawable.OnLoadingStateChangeListener
{
  ajhc(ajgz paramajgz) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1) && ((this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a instanceof TroopGiftToPersonalSurfaceView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "onLoadingStateChanged: curState = " + paramInt2);
      }
      Bitmap localBitmap = TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiverUin), null));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a.b(new ajhd(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajhc
 * JD-Core Version:    0.7.0.1
 */
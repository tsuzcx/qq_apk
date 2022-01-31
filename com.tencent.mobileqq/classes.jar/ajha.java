import android.graphics.Bitmap;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;

class ajha
  implements FaceDrawable.OnLoadingStateChangeListener
{
  ajha(ajgz paramajgz) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin), null));
    if ((paramInt1 == 0) && (paramInt2 == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a.b(new ajhb(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajha
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.IFaceBitmaprGetter;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class ajvd
  implements Runnable
{
  public ajvd(TroopGiftAnimationController paramTroopGiftAnimationController, MessageForDeliverGiftTips paramMessageForDeliverGiftTips) {}
  
  public void run()
  {
    TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController, System.currentTimeMillis());
    Object localObject2;
    Object localObject1;
    if (TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController) != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin), new ajve(this));
      localObject2 = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.b = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiverUin), new ajvg(this));
      localObject1 = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.b);
    }
    for (;;)
    {
      label200:
      Object localObject3;
      label259:
      label265:
      String str;
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin <= 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiverUin <= 0L)) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderAvatarUrl))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderAvatarUrl, (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
          if ((((URLDrawable)localObject1).getStatus() == 1) && (((URLDrawable)localObject1).getCurrDrawable() != null))
          {
            localObject1 = ImageUtil.a(((URLDrawable)localObject1).getCurrDrawable());
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiveAvatarUrl)) {
              break label438;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiveAvatarUrl, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
            if ((((URLDrawable)localObject2).getStatus() != 1) || (((URLDrawable)localObject2).getCurrDrawable() == null)) {
              break label427;
            }
            localObject2 = ImageUtil.a(((URLDrawable)localObject2).getCurrDrawable());
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            str = TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
          }
        }
      }
      label427:
      label438:
      label489:
      for (;;)
      {
        try
        {
          localObject3 = BitmapFactory.decodeFile(str + "/avatar/avatar_anim_res.png");
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajvi(this, str, (Bitmap)localObject2, (Bitmap)localObject1, (Bitmap)localObject3), 300L);
          return;
          if ((TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController) == null) || (!(TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController) instanceof TroopGiftAnimationController.IFaceBitmaprGetter))) {
            break label492;
          }
          localObject1 = (TroopGiftAnimationController.IFaceBitmaprGetter)TroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController);
          localObject2 = ((TroopGiftAnimationController.IFaceBitmaprGetter)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
          localObject1 = ((TroopGiftAnimationController.IFaceBitmaprGetter)localObject1).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.receiverUin), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin);
          break;
          ((URLDrawable)localObject1).startDownload();
          localObject1 = ImageUtil.a();
          break label200;
          localObject1 = null;
          break label200;
          ((URLDrawable)localObject2).startDownload();
          localObject2 = ImageUtil.a();
          break label259;
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label265;
          if (localObject2 != null) {
            break label489;
          }
          localObject2 = ImageUtil.a();
          if (localObject1 == null) {
            localObject1 = ImageUtil.a();
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAnimationController", 2, "decode avatarAnimRes failed");
          }
          Object localObject4 = null;
          continue;
        }
        break label265;
      }
      label492:
      localObject1 = null;
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvd
 * JD-Core Version:    0.7.0.1
 */
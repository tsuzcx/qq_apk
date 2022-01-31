import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class akdj
  implements Runnable
{
  akdj(akdi paramakdi, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInteractGiftAnimationController", 2, "TroopGiftUtil.getInteractConfig = null, packageId: " + this.jdField_a_of_type_Akdi.jdField_a_of_type_JavaLangString);
      }
    }
    label686:
    label688:
    label955:
    for (;;)
    {
      return;
      boolean bool;
      label62:
      Object localObject1;
      Object localObject3;
      Object localObject2;
      JSONObject localJSONObject;
      int i;
      int j;
      int k;
      int m;
      if (this.jdField_a_of_type_OrgJsonJSONObject.optInt("type", 2) == 1)
      {
        bool = true;
        if (this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null) {
          break label686;
        }
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = new SpriteVideoView(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a, bool);
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setCenterCrop(true);
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.d.removeAllViews();
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.d.addView(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView, -1, this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.o);
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_Boolean = true;
        if ((this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState != 2) && (this.jdField_a_of_type_Akdi.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton = new TroopGiftActionButton(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a, this.jdField_a_of_type_OrgJsonJSONObject, new akdk(this));
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setOnProgressChangedListener(new akdl(this));
          localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a, 175.0F), DisplayUtil.a(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a, 175.0F));
          ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.o - DisplayUtil.a(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a, 85.0F));
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = (-DisplayUtil.a(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a, 25.0F));
          ((RelativeLayout.LayoutParams)localObject1).addRule(11);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10);
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton, (ViewGroup.LayoutParams)localObject1);
        }
        localObject1 = TroopGiftUtil.a(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
        localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("animation1");
        localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("animation2");
        localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("animation3");
        i = ((JSONObject)localObject3).optInt("duration");
        j = ((JSONObject)localObject2).optInt("duration");
        k = localJSONObject.optInt("duration");
        m = (int)(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.alreadyPlayMicroseconds / 1000L);
        int n = (int)(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds / 1000L);
        if ((this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState != 2) && (this.jdField_a_of_type_Akdi.jdField_a_of_type_Boolean)) {
          break label688;
        }
        localObject3 = (String)localObject1 + ((JSONObject)localObject3).optString("videoPath", "1.mp4");
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject3, new akdm(this, n, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState != 0) {
          break label955;
        }
        this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.b(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId, this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationPackageId, new akdv(this));
        return;
        bool = false;
        break label62;
        break;
        if (m < i)
        {
          localObject3 = (String)localObject1 + ((JSONObject)localObject3).optString("videoPath", "1.mp4");
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject3, m, new akdp(this, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, i - m - 300);
        }
        else if (m < i + j)
        {
          localObject2 = (String)localObject1 + ((JSONObject)localObject2).optString("videoPath", "2.mp4");
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject2, m - i, new akds(this, i, j, (String)localObject1, localJSONObject));
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a(this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, i + j - m - 300);
        }
        else if (m < i + j + k)
        {
          localObject1 = (String)localObject1 + localJSONObject.optString("videoPath", "3.mp4");
          this.jdField_a_of_type_Akdi.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a((String)localObject1, m - i - j, new akdu(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdj
 * JD-Core Version:    0.7.0.1
 */
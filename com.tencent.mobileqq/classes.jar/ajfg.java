import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class ajfg
  implements View.OnTouchListener
{
  public ajfg(TroopEnterEffectController paramTroopEnterEffectController, String paramString, TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a.getContext(), QQBrowserActivity.class);
      paramMotionEvent = IndividuationUrlHelper.a("troopEnterEffect");
      paramView.putExtra("url", paramMotionEvent + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.b);
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a.getContext().startActivity(paramView);
      TroopEnterEffectManager.a("Grp_AIO", "action_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.b });
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_JavaLangString, "style", "0X8008E63", "", 1, 0, 0, "", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$TroopEnterEffectData.a), "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfg
 * JD-Core Version:    0.7.0.1
 */
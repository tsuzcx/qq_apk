import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.lang.ref.WeakReference;

public class ajlz
  implements Runnable
{
  public ajlz(HomeworkTroopController paramHomeworkTroopController, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return;
    }
    label31:
    Object localObject1;
    if (this.jdField_a_of_type_Int == 1)
    {
      i = 1;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      if (i == 0) {
        break label79;
      }
    }
    label79:
    for (int j = 32;; j = 31)
    {
      localObject1 = ((PanelIconLinearLayout)localObject1).findViewWithTag(Integer.valueOf(j));
      if (localObject1 != null) {
        break label85;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HomeworkTroopController", 2, "showAIOPanelTip anchorView null.");
      return;
      i = 0;
      break label31;
    }
    label85:
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.c();
    CalloutPopupWindow.Builder localBuilder = CalloutPopupWindow.a((Context)localObject2).b(0).a(true);
    if (i != 0) {}
    for (int i = 2131430724;; i = 2131430725)
    {
      localObject2 = localBuilder.a(((BaseActivity)localObject2).getString(i)).a(16.0F).a(-1);
      ((CalloutPopupWindow.Builder)localObject2).c(49);
      localObject2 = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject2).b(Color.argb(255, 0, 0, 0)).a(5).a();
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = ((CalloutPopupWindow.Builder)localObject2).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(new ajma(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicHomeworkTroopController.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a((View)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlz
 * JD-Core Version:    0.7.0.1
 */
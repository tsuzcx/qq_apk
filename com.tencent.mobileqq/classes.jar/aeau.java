import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.QZoneEntryController;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.leba.model.pluginactions.PluginAction;
import com.tencent.mobileqq.leba.model.pluginactions.QzonePluginAction;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;

public class aeau
  implements View.OnClickListener
{
  public aeau(QZoneEntryController paramQZoneEntryController) {}
  
  public void onClick(View paramView)
  {
    QZoneEntryController.c(this.a);
    paramView = LebaGridShowManager.a().a(10000);
    QzonePluginAction localQzonePluginAction = new QzonePluginAction(this.a.jdField_a_of_type_AndroidContentContext);
    if (paramView == null) {
      QLog.i("UndealCount.QZoneEntryController", 1, "user clicked qzone feed entry. lebaGridItemInfo is null");
    }
    for (;;)
    {
      localQzonePluginAction.c(paramView);
      paramView = (QZoneManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      if (QZoneEntryController.a(this.a) == 4) {
        ThreadManager.post(new aeav(this, paramView), 5, null, false);
      }
      QZoneEntryController.a(this.a, true);
      paramView.a(true);
      return;
      QLog.i("UndealCount.QZoneEntryController", 1, "user clicked qzone feed entry. hasNew:" + localQzonePluginAction.a(paramView.a.isNew, paramView.a.pluginId));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeau
 * JD-Core Version:    0.7.0.1
 */
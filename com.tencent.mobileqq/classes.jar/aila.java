import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aila
  extends Handler
{
  public aila(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 1002: 
            case 1007: 
            default: 
              return;
            case 1001: 
              this.a.a(false);
              if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              }
              QQToast.a(this.a, 2131430332, 1).b(this.a.getTitleBarHeight());
            }
          } while (!(paramMessage.obj instanceof String));
          paramMessage = (String)paramMessage.obj;
          try
          {
            this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramMessage);
            return;
          }
          catch (UnsupportedOperationException paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.d("TroopBar", 2, paramMessage.toString());
        return;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        this.a.a(false);
        this.a.a();
        return;
        if ((paramMessage.arg1 == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.url = ((String)paramMessage.obj);
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      this.a.a();
      return;
      this.a.a(false);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQToast.a(this.a, 2131430331, 1).b(this.a.getTitleBarHeight());
      return;
      if ((paramMessage.obj instanceof String))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a((String)paramMessage.obj);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(this.a.jdField_a_of_type_JavaUtilArrayList);
    } while (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    return;
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
    TroopBarReplyActivity.a(this.a, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aila
 * JD-Core Version:    0.7.0.1
 */
import android.app.Dialog;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class achd
  implements Handler.Callback
{
  public achd(ChatHistory paramChatHistory) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 6: 
    case 4: 
    case 2: 
    case 0: 
    case 1: 
    case 7: 
    case 3: 
    case 5: 
    case 8: 
      do
      {
        do
        {
          do
          {
            return true;
            this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          } while (!bdee.d(BaseApplication.getContext()));
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
          return true;
          this.a.jdField_a_of_type_AndroidAppDialog = new Dialog(this.a, 2131755801);
          this.a.jdField_a_of_type_AndroidAppDialog.setContentView(2131562559);
          ((TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131365231)).setText(paramMessage.obj.toString());
          this.a.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new ache(this));
          this.a.jdField_a_of_type_AndroidAppDialog.show();
          return true;
          this.a.i();
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          try
          {
            if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
              this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
            }
          }
          catch (IllegalArgumentException paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
              }
              this.a.jdField_a_of_type_AndroidAppDialog = null;
            }
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
              }
              this.a.jdField_a_of_type_AndroidAppDialog = null;
            }
          }
          finally
          {
            this.a.jdField_a_of_type_AndroidAppDialog = null;
          }
          this.a.a(10, false);
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
          this.a.a(2130839391, this.a.getString(2131693126));
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
          this.a.a(2130839391, this.a.getString(2131693127));
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
          this.a.a(2130839391, this.a.getString(2131719836));
          return true;
          this.a.a(2130839391, this.a.getString(2131691563));
          return true;
        } while (paramMessage.obj == null);
        paramMessage = (Cursor)paramMessage.obj;
        if (this.a.jdField_a_of_type_Acid != null)
        {
          if (this.a.jdField_a_of_type_Acid.getCursor() != null) {
            this.a.jdField_a_of_type_Acid.getCursor().deactivate();
          }
          this.a.jdField_a_of_type_Acid.changeCursor(paramMessage);
        }
      } while ((this.a.jdField_a_of_type_Acid == null) || (this.a.jdField_a_of_type_Acid.c < 0) || (this.a.jdField_a_of_type_Acid.c >= 8));
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.a.jdField_a_of_type_Acid.c + this.a.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount());
      this.a.jdField_a_of_type_Acid.c = -1;
      return true;
    case 9: 
      this.a.a(paramMessage.arg1, paramMessage.arg2);
      this.a.f();
      this.a.d();
      return true;
    case 10: 
      this.a.a(paramMessage.arg1, paramMessage.arg2);
      this.a.e();
      return true;
    case 11: 
      this.a.a(paramMessage.arg1, paramMessage.arg2);
      this.a.g();
      return true;
    case 12: 
      if (paramMessage.arg1 > 0) {
        this.a.a((String)paramMessage.obj);
      }
      for (;;)
      {
        azmj.b(this.a.app, "CliOper", "", "", "0X800568F", "0X800568F", this.a.k, 0, "", "", "", "");
        return true;
        this.a.b(this.a.getString(2131690088));
      }
    }
    this.a.a(paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achd
 * JD-Core Version:    0.7.0.1
 */
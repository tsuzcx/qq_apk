import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class alyb
  extends Handler
{
  public alyb(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      QQToast.a(BaseApplication.getContext(), 1, 2131693948, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Biau == null) {
        this.a.jdField_a_of_type_Biau = new biau(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Biau.c(2131698318);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Biau.isShowing()));
    this.a.jdField_a_of_type_Biau.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyb
 * JD-Core Version:    0.7.0.1
 */
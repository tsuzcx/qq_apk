import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class aleq
  extends Handler
{
  public aleq(SpecailCareListActivity paramSpecailCareListActivity) {}
  
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
      QQToast.a(BaseApplication.getContext(), 1, 2131694064, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bhht == null) {
        this.a.jdField_a_of_type_Bhht = new bhht(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bhht.c(2131698589);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bhht.isShowing()));
    this.a.jdField_a_of_type_Bhht.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aleq
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class aijf
  extends Handler
{
  public aijf(SpecailCareListActivity paramSpecailCareListActivity) {}
  
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
      bcpw.a(BaseApplication.getContext(), 1, 2131694609, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bcpq == null) {
        this.a.jdField_a_of_type_Bcpq = new bcpq(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bcpq.c(2131699484);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bcpq.isShowing()));
    this.a.jdField_a_of_type_Bcpq.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijf
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class aijd
  extends Handler
{
  public aijd(SpecailCareListActivity paramSpecailCareListActivity) {}
  
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
      bcql.a(BaseApplication.getContext(), 1, 2131694610, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bcqf == null) {
        this.a.jdField_a_of_type_Bcqf = new bcqf(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bcqf.c(2131699495);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bcqf.isShowing()));
    this.a.jdField_a_of_type_Bcqf.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijd
 * JD-Core Version:    0.7.0.1
 */
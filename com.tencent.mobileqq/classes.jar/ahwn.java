import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class ahwn
  extends Handler
{
  public ahwn(SpecailCareListActivity paramSpecailCareListActivity) {}
  
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
      bbmy.a(BaseApplication.getContext(), 1, 2131628948, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bbms == null) {
        this.a.jdField_a_of_type_Bbms = new bbms(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bbms.c(2131633714);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bbms.isShowing()));
    this.a.jdField_a_of_type_Bbms.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahwn
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class akfc
  extends Handler
{
  public akfc(SpecailCareListActivity paramSpecailCareListActivity) {}
  
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
      QQToast.a(BaseApplication.getContext(), 1, 2131694768, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bety == null) {
        this.a.jdField_a_of_type_Bety = new bety(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bety.c(2131699860);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bety.isShowing()));
    this.a.jdField_a_of_type_Bety.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfc
 * JD-Core Version:    0.7.0.1
 */
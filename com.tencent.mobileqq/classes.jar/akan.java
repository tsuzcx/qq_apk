import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class akan
  extends Handler
{
  public akan(SpecailCareListActivity paramSpecailCareListActivity) {}
  
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
      QQToast.a(BaseApplication.getContext(), 1, 2131694766, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bepp == null) {
        this.a.jdField_a_of_type_Bepp = new bepp(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bepp.c(2131699848);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bepp.isShowing()));
    this.a.jdField_a_of_type_Bepp.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akan
 * JD-Core Version:    0.7.0.1
 */
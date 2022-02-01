import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adhd
  implements View.OnClickListener
{
  adhd(adhc paramadhc, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (!bgnt.d(adhc.a(this.jdField_a_of_type_Adhc))) {
      QQToast.a(adhc.a(this.jdField_a_of_type_Adhc), adhc.a(this.jdField_a_of_type_Adhc).getString(2131693946), 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)
      {
        QLog.e("SdkAuthDialog", 1, "positiveListener is null");
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
        bcst.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhd
 * JD-Core Version:    0.7.0.1
 */
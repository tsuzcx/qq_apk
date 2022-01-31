import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class aahw
  implements DialogInterface.OnClickListener
{
  public aahw(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (bbfj.d(BaseApplication.getContext()))
    {
      long l = Long.valueOf(this.a.app.getCurrentAccountUin()).longValue();
      this.a.showDialog(2);
      this.a.jdField_a_of_type_Ajti.a(l, Long.valueOf(this.a.jdField_a_of_type_JavaLangString).longValue(), 1);
      return;
    }
    bcql.a(this.a, 2131694610, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aahw
 * JD-Core Version:    0.7.0.1
 */
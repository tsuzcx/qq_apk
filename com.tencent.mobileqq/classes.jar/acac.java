import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class acac
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  abzz jdField_a_of_type_Abzz;
  Button jdField_a_of_type_AndroidWidgetButton;
  
  public acac(acab paramacab, View paramView, abzz paramabzz)
  {
    super(paramView);
    this.jdField_a_of_type_Abzz = paramabzz;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131373477));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Abzz != null) {
      this.jdField_a_of_type_Abzz.a(paramView, getPosition());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acac
 * JD-Core Version:    0.7.0.1
 */
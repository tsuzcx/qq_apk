import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class advz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  advw jdField_a_of_type_Advw;
  Button jdField_a_of_type_AndroidWidgetButton;
  
  public advz(advy paramadvy, View paramView, advw paramadvw)
  {
    super(paramView);
    this.jdField_a_of_type_Advw = paramadvw;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131373980));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Advw != null) {
      this.jdField_a_of_type_Advw.a(paramView, getPosition());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advz
 * JD-Core Version:    0.7.0.1
 */
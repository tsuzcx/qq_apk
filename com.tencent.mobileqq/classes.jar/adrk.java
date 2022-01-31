import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class adrk
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  adrh jdField_a_of_type_Adrh;
  Button jdField_a_of_type_AndroidWidgetButton;
  
  public adrk(adrj paramadrj, View paramView, adrh paramadrh)
  {
    super(paramView);
    this.jdField_a_of_type_Adrh = paramadrh;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131373929));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Adrh != null) {
      this.jdField_a_of_type_Adrh.a(paramView, getPosition());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrk
 * JD-Core Version:    0.7.0.1
 */
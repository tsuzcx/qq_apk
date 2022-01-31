import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class abpu
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  abpr jdField_a_of_type_Abpr;
  Button jdField_a_of_type_AndroidWidgetButton;
  
  public abpu(abpt paramabpt, View paramView, abpr paramabpr)
  {
    super(paramView);
    this.jdField_a_of_type_Abpr = paramabpr;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131307761));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Abpr != null) {
      this.jdField_a_of_type_Abpr.a(paramView, getPosition());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpu
 * JD-Core Version:    0.7.0.1
 */
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aeef
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  aeec jdField_a_of_type_Aeec;
  Button jdField_a_of_type_AndroidWidgetButton;
  
  public aeef(aeee paramaeee, View paramView, aeec paramaeec)
  {
    super(paramView);
    this.jdField_a_of_type_Aeec = paramaeec;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131374604));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aeec != null) {
      this.jdField_a_of_type_Aeec.a(paramView, getPosition());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeef
 * JD-Core Version:    0.7.0.1
 */
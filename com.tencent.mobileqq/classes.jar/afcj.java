import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afcj
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  afcg jdField_a_of_type_Afcg;
  Button jdField_a_of_type_AndroidWidgetButton;
  
  public afcj(afci paramafci, View paramView, afcg paramafcg)
  {
    super(paramView);
    this.jdField_a_of_type_Afcg = paramafcg;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131374702));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Afcg != null) {
      this.jdField_a_of_type_Afcg.a(paramView, getPosition());
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
 * Qualified Name:     afcj
 * JD-Core Version:    0.7.0.1
 */
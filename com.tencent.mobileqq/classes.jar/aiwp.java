import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiwp
  implements View.OnClickListener
{
  aiwp(aiwo paramaiwo, aiwr paramaiwr) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Aiwr.a.getText());
    aiwo.a(this.jdField_a_of_type_Aiwo, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwp
 * JD-Core Version:    0.7.0.1
 */
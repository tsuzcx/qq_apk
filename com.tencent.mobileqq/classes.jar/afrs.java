import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afrs
  implements View.OnClickListener
{
  public afrs(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_confirm", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_Bhru = ((bhru)this.a.app.getManager(31));
      this.a.b.setCompoundDrawablesWithIntrinsicBounds(2130839410, 0, 0, 0);
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        String str = String.valueOf(this.a.jdField_a_of_type_JavaUtilList.get(i));
        this.a.a(str, 4);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrs
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import java.util.List;

class agbk
  implements View.OnClickListener
{
  agbk(agbj paramagbj, TroopLinkElement paramTroopLinkElement, agbl paramagbl) {}
  
  public void onClick(View paramView)
  {
    if (!agbj.a(this.jdField_a_of_type_Agbj))
    {
      paramView = new Intent(agbj.a(this.jdField_a_of_type_Agbj), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      agbj.a(this.jdField_a_of_type_Agbj).startActivity(paramView);
      return;
    }
    boolean bool = agbl.a(this.jdField_a_of_type_Agbl).isChecked();
    if (bool)
    {
      agbj.a(this.jdField_a_of_type_Agbj).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      paramView = agbl.a(this.jdField_a_of_type_Agbl);
      if (bool) {
        break label125;
      }
    }
    label125:
    for (bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
      agbj.a(this.jdField_a_of_type_Agbj).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbk
 * JD-Core Version:    0.7.0.1
 */
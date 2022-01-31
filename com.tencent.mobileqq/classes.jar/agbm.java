import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import java.util.List;

class agbm
  implements View.OnClickListener
{
  agbm(agbl paramagbl, TroopLinkElement paramTroopLinkElement, agbn paramagbn) {}
  
  public void onClick(View paramView)
  {
    if (!agbl.a(this.jdField_a_of_type_Agbl))
    {
      paramView = new Intent(agbl.a(this.jdField_a_of_type_Agbl), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      agbl.a(this.jdField_a_of_type_Agbl).startActivity(paramView);
      return;
    }
    boolean bool = agbn.a(this.jdField_a_of_type_Agbn).isChecked();
    if (bool)
    {
      agbl.a(this.jdField_a_of_type_Agbl).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      paramView = agbn.a(this.jdField_a_of_type_Agbn);
      if (bool) {
        break label125;
      }
    }
    label125:
    for (bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
      agbl.a(this.jdField_a_of_type_Agbl).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbm
 * JD-Core Version:    0.7.0.1
 */
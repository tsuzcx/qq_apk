import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import java.util.List;

class ahzm
  implements View.OnClickListener
{
  ahzm(ahzk paramahzk, TroopLinkElement paramTroopLinkElement, ahzo paramahzo) {}
  
  public void onClick(View paramView)
  {
    if (!ahzk.a(this.jdField_a_of_type_Ahzk))
    {
      paramView = new Intent(ahzk.a(this.jdField_a_of_type_Ahzk), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      ahzk.a(this.jdField_a_of_type_Ahzk).startActivity(paramView);
      return;
    }
    boolean bool = ahzo.a(this.jdField_a_of_type_Ahzo).isChecked();
    if (bool)
    {
      ahzk.a(this.jdField_a_of_type_Ahzk).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      paramView = ahzo.a(this.jdField_a_of_type_Ahzo);
      if (bool) {
        break label125;
      }
    }
    label125:
    for (bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
      ahzk.a(this.jdField_a_of_type_Ahzk).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzm
 * JD-Core Version:    0.7.0.1
 */
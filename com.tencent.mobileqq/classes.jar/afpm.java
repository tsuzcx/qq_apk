import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import java.util.List;

class afpm
  implements View.OnClickListener
{
  afpm(afpl paramafpl, TroopLinkElement paramTroopLinkElement, afpn paramafpn) {}
  
  public void onClick(View paramView)
  {
    if (!afpl.a(this.jdField_a_of_type_Afpl))
    {
      paramView = new Intent(afpl.a(this.jdField_a_of_type_Afpl), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      afpl.a(this.jdField_a_of_type_Afpl).startActivity(paramView);
      return;
    }
    boolean bool = afpn.a(this.jdField_a_of_type_Afpn).isChecked();
    if (bool)
    {
      afpl.a(this.jdField_a_of_type_Afpl).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      paramView = afpn.a(this.jdField_a_of_type_Afpn);
      if (bool) {
        break label125;
      }
    }
    label125:
    for (bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
      afpl.a(this.jdField_a_of_type_Afpl).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afpm
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import java.util.List;

class aieb
  implements View.OnClickListener
{
  aieb(aidz paramaidz, TroopLinkElement paramTroopLinkElement, aied paramaied) {}
  
  public void onClick(View paramView)
  {
    if (!aidz.a(this.jdField_a_of_type_Aidz))
    {
      paramView = new Intent(aidz.a(this.jdField_a_of_type_Aidz), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      aidz.a(this.jdField_a_of_type_Aidz).startActivity(paramView);
      return;
    }
    boolean bool = aied.a(this.jdField_a_of_type_Aied).isChecked();
    if (bool)
    {
      aidz.a(this.jdField_a_of_type_Aidz).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      paramView = aied.a(this.jdField_a_of_type_Aied);
      if (bool) {
        break label125;
      }
    }
    label125:
    for (bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
      aidz.a(this.jdField_a_of_type_Aidz).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aieb
 * JD-Core Version:    0.7.0.1
 */
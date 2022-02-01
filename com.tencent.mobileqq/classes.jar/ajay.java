import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajay
  implements View.OnClickListener
{
  ajay(ajaw paramajaw, TroopLinkElement paramTroopLinkElement, ajba paramajba) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!ajaw.a(this.jdField_a_of_type_Ajaw))
    {
      localObject = new Intent(ajaw.a(this.jdField_a_of_type_Ajaw), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      ajaw.a(this.jdField_a_of_type_Ajaw).startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = ajba.a(this.jdField_a_of_type_Ajba).isChecked();
    if (bool)
    {
      ajaw.a(this.jdField_a_of_type_Ajaw).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      label92:
      localObject = ajba.a(this.jdField_a_of_type_Ajba);
      if (bool) {
        break label134;
      }
    }
    label134:
    for (bool = true;; bool = false)
    {
      ((CheckBox)localObject).setChecked(bool);
      break;
      ajaw.a(this.jdField_a_of_type_Ajaw).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajay
 * JD-Core Version:    0.7.0.1
 */
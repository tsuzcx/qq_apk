import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajup
  implements View.OnClickListener
{
  ajup(ajun paramajun, TroopLinkElement paramTroopLinkElement, ajur paramajur) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!ajun.a(this.jdField_a_of_type_Ajun))
    {
      localObject = new Intent(ajun.a(this.jdField_a_of_type_Ajun), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      ajun.a(this.jdField_a_of_type_Ajun).startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = ajur.a(this.jdField_a_of_type_Ajur).isChecked();
    if (bool)
    {
      ajun.a(this.jdField_a_of_type_Ajun).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      label92:
      localObject = ajur.a(this.jdField_a_of_type_Ajur);
      if (bool) {
        break label134;
      }
    }
    label134:
    for (bool = true;; bool = false)
    {
      ((CheckBox)localObject).setChecked(bool);
      break;
      ajun.a(this.jdField_a_of_type_Ajun).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajup
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajwn
  implements View.OnClickListener
{
  ajwn(ajwl paramajwl, TroopLinkElement paramTroopLinkElement, ajwp paramajwp) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!ajwl.a(this.jdField_a_of_type_Ajwl))
    {
      localObject = new Intent(ajwl.a(this.jdField_a_of_type_Ajwl), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      ajwl.a(this.jdField_a_of_type_Ajwl).startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = ajwp.a(this.jdField_a_of_type_Ajwp).isChecked();
    if (bool)
    {
      ajwl.a(this.jdField_a_of_type_Ajwl).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      label92:
      localObject = ajwp.a(this.jdField_a_of_type_Ajwp);
      if (bool) {
        break label134;
      }
    }
    label134:
    for (bool = true;; bool = false)
    {
      ((CheckBox)localObject).setChecked(bool);
      break;
      ajwl.a(this.jdField_a_of_type_Ajwl).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwn
 * JD-Core Version:    0.7.0.1
 */
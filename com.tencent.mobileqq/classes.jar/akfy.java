import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class akfy
  implements View.OnClickListener
{
  akfy(akfw paramakfw, TroopLinkElement paramTroopLinkElement, akga paramakga) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!akfw.a(this.jdField_a_of_type_Akfw))
    {
      localObject = new Intent(akfw.a(this.jdField_a_of_type_Akfw), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      akfw.a(this.jdField_a_of_type_Akfw).startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = akga.a(this.jdField_a_of_type_Akga).isChecked();
    if (bool)
    {
      akfw.a(this.jdField_a_of_type_Akfw).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      label92:
      localObject = akga.a(this.jdField_a_of_type_Akga);
      if (bool) {
        break label134;
      }
    }
    label134:
    for (bool = true;; bool = false)
    {
      ((CheckBox)localObject).setChecked(bool);
      break;
      akfw.a(this.jdField_a_of_type_Akfw).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfy
 * JD-Core Version:    0.7.0.1
 */
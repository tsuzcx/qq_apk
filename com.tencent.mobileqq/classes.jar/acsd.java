import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;

public class acsd
  implements CompoundButton.OnCheckedChangeListener
{
  public acsd(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int k = this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < k)
    {
      localObject = this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getChildAt(i);
      if ((localObject instanceof FormSwitchItem))
      {
        localObject = (FormSwitchItem)localObject;
        if (paramCompoundButton != ((FormSwitchItem)localObject).a()) {}
      }
    }
    for (;;)
    {
      if ((localObject == null) || (!(((FormSwitchItem)localObject).getTag() instanceof aire))) {}
      aire localaire;
      boolean bool;
      label109:
      do
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i += 1;
        break;
        localaire = (aire)((FormSwitchItem)localObject).getTag();
        if (paramBoolean) {
          break label267;
        }
        bool = true;
        localaire.e = bool;
        if (this.a.jdField_a_of_type_Airj != null) {
          this.a.jdField_a_of_type_Airj.a(localaire, localaire.e);
        }
        localObject = this.a.app;
        k = localaire.a;
        i = j;
        if (localaire.e) {
          i = 2;
        }
        bcef.b((QQAppInterface)localObject, "dc00898", "", "", "0X80097A0", "0X80097A0", k, 0, String.valueOf(i), "", "", "");
      } while (localaire.a != 3);
      QQAppInterface localQQAppInterface = this.a.app;
      if (paramBoolean)
      {
        localObject = "0X8009C0A";
        label227:
        if (!paramBoolean) {
          break label280;
        }
      }
      label267:
      label280:
      for (String str = "0X8009C0A";; str = "0X8009C0B")
      {
        bcef.b(localQQAppInterface, "dc00898", "", "", (String)localObject, str, localaire.a, 0, "", "", "", "");
        break;
        bool = false;
        break label109;
        localObject = "0X8009C0B";
        break label227;
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsd
 * JD-Core Version:    0.7.0.1
 */
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.HeightAdaptableListView;

public class aaji
  implements CompoundButton.OnCheckedChangeListener
{
  public aaji(AssistantSettingActivity paramAssistantSettingActivity) {}
  
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
    for (paramCompoundButton = (CompoundButton)localObject;; paramCompoundButton = null)
    {
      if ((paramCompoundButton == null) || (!(paramCompoundButton.getTag() instanceof afru))) {}
      afru localafru;
      boolean bool;
      do
      {
        return;
        i += 1;
        break;
        localafru = (afru)paramCompoundButton.getTag();
        if (paramBoolean) {
          break label253;
        }
        bool = true;
        localafru.e = bool;
        if (this.a.jdField_a_of_type_Afry != null) {
          this.a.jdField_a_of_type_Afry.a(localafru, localafru.e);
        }
        paramCompoundButton = this.a.app;
        k = localafru.a;
        i = j;
        if (localafru.e) {
          i = 2;
        }
        axqy.b(paramCompoundButton, "dc00898", "", "", "0X80097A0", "0X80097A0", k, 0, String.valueOf(i), "", "", "");
      } while (localafru.a != 3);
      QQAppInterface localQQAppInterface = this.a.app;
      if (paramBoolean)
      {
        paramCompoundButton = "0X8009C0A";
        label216:
        if (!paramBoolean) {
          break label265;
        }
      }
      label265:
      for (localObject = "0X8009C0A";; localObject = "0X8009C0B")
      {
        axqy.b(localQQAppInterface, "dc00898", "", "", paramCompoundButton, (String)localObject, localafru.a, 0, "", "", "", "");
        return;
        label253:
        bool = false;
        break;
        paramCompoundButton = "0X8009C0B";
        break label216;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaji
 * JD-Core Version:    0.7.0.1
 */
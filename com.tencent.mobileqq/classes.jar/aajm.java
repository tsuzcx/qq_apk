import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.HeightAdaptableListView;

public class aajm
  implements CompoundButton.OnCheckedChangeListener
{
  public aajm(AssistantSettingActivity paramAssistantSettingActivity) {}
  
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
      if ((paramCompoundButton == null) || (!(paramCompoundButton.getTag() instanceof afrw))) {}
      afrw localafrw;
      boolean bool;
      do
      {
        return;
        i += 1;
        break;
        localafrw = (afrw)paramCompoundButton.getTag();
        if (paramBoolean) {
          break label253;
        }
        bool = true;
        localafrw.e = bool;
        if (this.a.jdField_a_of_type_Afsa != null) {
          this.a.jdField_a_of_type_Afsa.a(localafrw, localafrw.e);
        }
        paramCompoundButton = this.a.app;
        k = localafrw.a;
        i = j;
        if (localafrw.e) {
          i = 2;
        }
        axqw.b(paramCompoundButton, "dc00898", "", "", "0X80097A0", "0X80097A0", k, 0, String.valueOf(i), "", "", "");
      } while (localafrw.a != 3);
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
        axqw.b(localQQAppInterface, "dc00898", "", "", paramCompoundButton, (String)localObject, localafrw.a, 0, "", "", "", "");
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
 * Qualified Name:     aajm
 * JD-Core Version:    0.7.0.1
 */
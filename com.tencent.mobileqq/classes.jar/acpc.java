import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.XListView;

public class acpc
  implements aufy<bdwv>
{
  public acpc(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(bdwv parambdwv)
  {
    if (this.a.f) {
      return;
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[40];
    localFormSimpleItem.setRightText(parambdwv.jdField_a_of_type_JavaLangString);
    localFormSimpleItem.setTag(2131374184, parambdwv);
    if (parambdwv.jdField_a_of_type_Boolean)
    {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130841117));
      if (!beat.a(this.a.app, "troop_keyword_scrolled", false))
      {
        beat.b(this.a.app, "troop_keyword_scrolled", true);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.addOnLayoutChangeListener(ChatSettingForTroop.a(this.a));
      }
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F7", parambdwv.c, 1, 0, "", "", "", "");
      return;
      localFormSimpleItem.setRightIcon(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpc
 * JD-Core Version:    0.7.0.1
 */
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.XListView;

public class aatt
  implements asko<bbtb>
{
  public aatt(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(bbtb parambbtb)
  {
    if (this.a.f) {
      return;
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[40];
    localFormSimpleItem.setRightText(parambbtb.jdField_a_of_type_JavaLangString);
    localFormSimpleItem.setTag(2131373678, parambbtb);
    if (parambbtb.jdField_a_of_type_Boolean)
    {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130841001));
      if (!bbwv.a(this.a.app, "troop_keyword_scrolled", false))
      {
        bbwv.b(this.a.app, "troop_keyword_scrolled", true);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.addOnLayoutChangeListener(ChatSettingForTroop.a(this.a));
      }
    }
    for (;;)
    {
      axqw.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F7", parambbtb.c, 1, 0, "", "", "", "");
      return;
      localFormSimpleItem.setRightIcon(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aatt
 * JD-Core Version:    0.7.0.1
 */
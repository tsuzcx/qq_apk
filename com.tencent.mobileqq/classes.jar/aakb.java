import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.XListView;

public class aakb
  implements arok<baqz>
{
  public aakb(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(baqz parambaqz)
  {
    if (this.a.f) {
      return;
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[40];
    localFormSimpleItem.setRightText(parambaqz.jdField_a_of_type_JavaLangString);
    localFormSimpleItem.setTag(2131307962, parambaqz);
    if (parambaqz.jdField_a_of_type_Boolean)
    {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130840934));
      if (!baub.a(this.a.app, "troop_keyword_scrolled", false))
      {
        baub.b(this.a.app, "troop_keyword_scrolled", true);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.addOnLayoutChangeListener(ChatSettingForTroop.a(this.a));
      }
    }
    for (;;)
    {
      awqx.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F7", parambaqz.c, 1, 0, "", "", "", "");
      return;
      localFormSimpleItem.setRightIcon(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakb
 * JD-Core Version:    0.7.0.1
 */
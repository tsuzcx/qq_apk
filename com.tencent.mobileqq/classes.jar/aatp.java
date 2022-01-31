import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.XListView;

public class aatp
  implements askq<bbtp>
{
  public aatp(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(bbtp parambbtp)
  {
    if (this.a.f) {
      return;
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[40];
    localFormSimpleItem.setRightText(parambbtp.jdField_a_of_type_JavaLangString);
    localFormSimpleItem.setTag(2131373680, parambbtp);
    if (parambbtp.jdField_a_of_type_Boolean)
    {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130840998));
      if (!bbxj.a(this.a.app, "troop_keyword_scrolled", false))
      {
        bbxj.b(this.a.app, "troop_keyword_scrolled", true);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.addOnLayoutChangeListener(ChatSettingForTroop.a(this.a));
      }
    }
    for (;;)
    {
      axqy.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F7", parambbtp.c, 1, 0, "", "", "", "");
      return;
      localFormSimpleItem.setRightIcon(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aatp
 * JD-Core Version:    0.7.0.1
 */
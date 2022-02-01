import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aimq
  implements View.OnClickListener
{
  public aimq(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    aikn localaikn;
    if ((paramView.getTag() instanceof aikn))
    {
      localaikn = (aikn)paramView.getTag();
      if ((localaikn != null) && (aimu.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localaikn.b))) {
        break label43;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label43:
      aimu.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localaikn.b, false);
      String str = this.a.getString(2131698704);
      localaikn.a.setText(str);
      localaikn.a.setClickable(false);
      localaikn.a.setBackgroundDrawable(null);
      localaikn.a.setTextAppearance(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755973);
      aimu.a(localaikn.b, TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, "", TroopWithCommonFriendsFragment.a(this.a));
      bcef.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimq
 * JD-Core Version:    0.7.0.1
 */
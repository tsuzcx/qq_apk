import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;

public class ahqv
  implements View.OnClickListener
{
  public ahqv(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ahpn))
    {
      paramView = (ahpn)paramView.getTag();
      if ((paramView != null) && (ahqz.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramView.b))) {}
    }
    else
    {
      return;
    }
    ahqz.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramView.b, false);
    String str = this.a.getString(2131699971);
    paramView.a.setText(str);
    paramView.a.setClickable(false);
    paramView.a.setBackgroundDrawable(null);
    paramView.a.setTextAppearance(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755951);
    ahqz.a(paramView.b, TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, "", TroopWithCommonFriendsFragment.a(this.a));
    azqs.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqv
 * JD-Core Version:    0.7.0.1
 */
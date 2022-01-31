import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;

public class ahmg
  implements View.OnClickListener
{
  public ahmg(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ahky))
    {
      paramView = (ahky)paramView.getTag();
      if ((paramView != null) && (ahmk.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramView.b))) {}
    }
    else
    {
      return;
    }
    ahmk.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramView.b, false);
    String str = this.a.getString(2131699959);
    paramView.a.setText(str);
    paramView.a.setClickable(false);
    paramView.a.setBackgroundDrawable(null);
    paramView.a.setTextAppearance(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755951);
    ahmk.a(paramView.b, TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, "", TroopWithCommonFriendsFragment.a(this.a));
    azmj.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmg
 * JD-Core Version:    0.7.0.1
 */
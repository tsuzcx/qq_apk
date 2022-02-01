import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajgk
  implements View.OnClickListener
{
  public ajgk(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    ajeo localajeo;
    if ((paramView.getTag() instanceof ajeo))
    {
      localajeo = (ajeo)paramView.getTag();
      if ((localajeo != null) && (ajgo.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localajeo.b))) {
        break label43;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label43:
      ajgo.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localajeo.b, false);
      String str = this.a.getString(2131698394);
      localajeo.a.setText(str);
      localajeo.a.setClickable(false);
      localajeo.a.setBackgroundDrawable(null);
      localajeo.a.setTextAppearance(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755971);
      ajgo.a(localajeo.b, TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, "", TroopWithCommonFriendsFragment.a(this.a));
      bcst.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgk
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajhq
  implements View.OnClickListener
{
  public ajhq(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    ajfk localajfk;
    if ((paramView.getTag() instanceof ajfk))
    {
      localajfk = (ajfk)paramView.getTag();
      if ((localajfk != null) && (ajhu.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localajfk.b))) {
        break label43;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label43:
      ajhu.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localajfk.b, false);
      String str = this.a.getString(2131699019);
      localajfk.a.setText(str);
      localajfk.a.setClickable(false);
      localajfk.a.setBackgroundDrawable(null);
      localajfk.a.setTextAppearance(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755977);
      ajhu.a(localajfk.b, TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, "", TroopWithCommonFriendsFragment.a(this.a));
      bdla.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhq
 * JD-Core Version:    0.7.0.1
 */
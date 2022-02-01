import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajrt
  implements View.OnClickListener
{
  public ajrt(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    ajpx localajpx;
    if ((paramView.getTag() instanceof ajpx))
    {
      localajpx = (ajpx)paramView.getTag();
      if ((localajpx != null) && (ajrx.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localajpx.b))) {
        break label43;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label43:
      ajrx.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localajpx.b, false);
      String str = this.a.getString(2131698496);
      localajpx.a.setText(str);
      localajpx.a.setClickable(false);
      localajpx.a.setBackgroundDrawable(null);
      localajpx.a.setTextAppearance(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755972);
      ajrx.a(localajpx.b, TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, "", TroopWithCommonFriendsFragment.a(this.a));
      bdll.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrt
 * JD-Core Version:    0.7.0.1
 */
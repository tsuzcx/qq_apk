import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import java.util.List;

class aeoc
  implements View.OnClickListener
{
  aeoc(aenv paramaenv) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    TroopWithCommonFriendsFragment.a(this.a.jdField_a_of_type_JavaLangString);
    TroopWithCommonFriendsFragment.a(paramView.getContext(), 2);
    azmj.b(null, "dc00898", "", "", "0X800AD22", "0X800AD22", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoc
 * JD-Core Version:    0.7.0.1
 */
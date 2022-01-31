import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ahmh
  extends ased
{
  public ahmh(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<ahkz> paramArrayList)
  {
    if (TroopWithCommonFriendsFragment.a(this.a) != null) {
      TroopWithCommonFriendsFragment.a(this.a).dismiss();
    }
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1014);
      return;
    }
    ahmk.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramArrayList);
    ahmk.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramInt);
    this.a.b = paramInt;
    this.a.jdField_a_of_type_JavaUtilList = ahmk.a(paramArrayList, TroopWithCommonFriendsFragment.a(this.a));
    TroopWithCommonFriendsFragment.a(this.a).a();
    TroopWithCommonFriendsFragment.a(this.a).a(this.a.jdField_a_of_type_JavaUtilList);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmh
 * JD-Core Version:    0.7.0.1
 */
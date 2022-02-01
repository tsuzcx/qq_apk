import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aimr
  extends atuh
{
  public aimr(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<aiko> paramArrayList)
  {
    if (TroopWithCommonFriendsFragment.a(this.a) != null) {
      TroopWithCommonFriendsFragment.a(this.a).dismiss();
    }
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1014);
      return;
    }
    aimu.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramArrayList);
    aimu.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramInt);
    this.a.b = paramInt;
    this.a.jdField_a_of_type_JavaUtilList = aimu.a(paramArrayList, TroopWithCommonFriendsFragment.a(this.a));
    TroopWithCommonFriendsFragment.a(this.a).a();
    TroopWithCommonFriendsFragment.a(this.a).a(this.a.jdField_a_of_type_JavaUtilList);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimr
 * JD-Core Version:    0.7.0.1
 */
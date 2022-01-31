import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class abgy
  implements bfoq
{
  public abgy(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Bfol != null) {
      this.jdField_a_of_type_Bfol.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      FriendProfileMoreInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, 1);
      FriendProfileMoreInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
      return;
    case 1: 
      FriendProfileMoreInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, 2);
      FriendProfileMoreInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      return;
    }
    FriendProfileMoreInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, 3);
    FriendProfileMoreInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgy
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.widget.AbsListView;

public class acwg
  implements bhpo
{
  public acwg(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    FriendProfileCardActivity.a(this.a, paramInt1);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a.jdField_a_of_type_Int != paramInt) {
      this.a.jdField_a_of_type_Int = paramInt;
    }
    switch (paramInt)
    {
    default: 
      abqw.a().a("vas_profilecard_list");
    }
    for (;;)
    {
      if (FriendProfileCardActivity.a(this.a) != null) {
        FriendProfileCardActivity.a(this.a).a(paramInt);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      abqw.a().a("vas_profilecard_list", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwg
 * JD-Core Version:    0.7.0.1
 */
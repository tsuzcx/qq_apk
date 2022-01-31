import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController.DrawerInfoCallback.1;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController.DrawerInfoCallback.2;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.Card;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aiht
  implements aiso, View.OnClickListener
{
  private aiht(FriendCardApolloViewController paramFriendCardApolloViewController) {}
  
  public void a()
  {
    Object localObject3 = null;
    QQAppInterface localQQAppInterface = this.a.a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)FriendCardApolloViewController.a(this.a).get();
    Object localObject1 = (View)FriendCardApolloViewController.b(this.a).get();
    if ((localQQAppInterface == null) || (localFriendProfileCardActivity == null) || (localObject1 == null)) {
      return;
    }
    if ((!TextUtils.isEmpty(FriendCardApolloViewController.a(this.a))) && ((this.a.a == null) || (this.a.a.getVisibility() != 0))) {
      ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.1(this, localFriendProfileCardActivity, (View)localObject1));
    }
    Object localObject2 = localFriendProfileCardActivity.a;
    if ((localObject2 != null) && (((atwx)localObject2).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject1 = ((atwx)localObject2).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;; localObject1 = null)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null) && (((atwx)localObject2).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
      for (localObject2 = ((atwx)localObject2).jdField_a_of_type_ComTencentMobileqqDataCard.uin;; localObject2 = localObject1)
      {
        aifg localaifg = (aifg)localQQAppInterface.getManager(153);
        localObject1 = localObject3;
        if (!FriendCardApolloViewController.a(this.a)) {
          localObject1 = localaifg.a(localQQAppInterface, (String)localObject2, new int[] { 4 });
        }
        int i = 5;
        if (localObject1 == null)
        {
          localObject1 = new ApolloActionData();
          ((ApolloActionData)localObject1).actionId = -1;
          ((ApolloActionData)localObject1).actionType = 0;
        }
        for (;;)
        {
          aisl.a(FriendCardApolloViewController.a(this.a), i, (ApolloActionData)localObject1);
          new aikw((String)localObject2).a(FriendCardApolloViewController.a(this.a), localFriendProfileCardActivity, localQQAppInterface, ajjy.a(2131639076));
          return;
          i = 12;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.2(this, paramInt1, paramInt2, paramString));
  }
  
  public void b() {}
  
  public void onClick(View paramView)
  {
    this.a.a(1, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiht
 * JD-Core Version:    0.7.0.1
 */
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class adyd
  implements aewf
{
  public adyd(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardFriendListActivity.a(this.a).setVisibility(8);
    }
    for (;;)
    {
      if (ForwardFriendListActivity.a(this.a) != null) {
        ForwardFriendListActivity.a(this.a).a(paramEditable);
      }
      return;
      ForwardFriendListActivity.a(this.a).setVisibility(0);
    }
  }
  
  public void onEditTextFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardFriendListActivity.a(this.a) == null))
    {
      ForwardFriendListActivity.a(this.a, ContactSearchFragment.a(6, 1, null, null, ForwardFriendListActivity.a(this.a)));
      FragmentTransaction localFragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131376602, ForwardFriendListActivity.a(this.a));
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public void onItemDeleted(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null) {
      ForwardFriendListActivity.a(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
    }
    ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyd
 * JD-Core Version:    0.7.0.1
 */
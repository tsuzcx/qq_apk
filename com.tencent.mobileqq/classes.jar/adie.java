import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class adie
  implements aeex
{
  public adie(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      ForwardTroopListFragment.a(this.a).setVisibility(8);
    }
    for (;;)
    {
      if (ForwardTroopListFragment.a(this.a) != null) {
        ForwardTroopListFragment.a(this.a).a(paramEditable);
      }
      return;
      ForwardTroopListFragment.a(this.a).setVisibility(0);
    }
  }
  
  public void onEditTextFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardTroopListFragment.a(this.a) == null))
    {
      ForwardTroopListFragment.a(this.a, ContactSearchFragment.a(8, 2097176, null, null, ForwardTroopListFragment.a(this.a)));
      FragmentTransaction localFragmentTransaction = this.a.getActivity().getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131376347, ForwardTroopListFragment.a(this.a));
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public void onItemDeleted(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null) {
      ForwardTroopListFragment.a(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
    }
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adie
 * JD-Core Version:    0.7.0.1
 */
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class adhg
  implements aeex
{
  public adhg(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.a.a.setVisibility(8);
    }
    for (;;)
    {
      if (ForwardRecentActivity.a(this.a) != null) {
        ForwardRecentActivity.a(this.a).a(paramEditable);
      }
      return;
      this.a.a.setVisibility(0);
    }
  }
  
  public void onEditTextFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardRecentActivity.a(this.a) == null))
    {
      ForwardRecentActivity.a(this.a, ContactSearchFragment.a(7, 2097177, null, null, ForwardRecentActivity.a(this.a)));
      Object localObject = new ArrayList();
      Iterator localIterator = ForwardRecentActivity.a(this.a).values().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((ResultRecord)localIterator.next()).uin);
      }
      ForwardRecentActivity.a(this.a).a((List)localObject, (List)localObject);
      localObject = this.a.getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131376347, ForwardRecentActivity.a(this.a));
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void onItemDeleted(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {}
    for (;;)
    {
      return;
      ForwardRecentActivity.a(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
      int j = ForwardRecentActivity.a(this.a).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = ForwardRecentActivity.a(this.a).getChildAt(i);
        if ((localObject instanceof ForwardRecentItemView))
        {
          localObject = (ForwardRecentItemView)localObject;
          if ((((ForwardRecentItemView)localObject).a.uinType == paramResultRecord.uinType) && (((ForwardRecentItemView)localObject).a.uin.equals(paramResultRecord.uin))) {
            ((ForwardRecentItemView)localObject).a(false);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adhg
 * JD-Core Version:    0.7.0.1
 */
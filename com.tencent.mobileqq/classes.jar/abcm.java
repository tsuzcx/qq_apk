import android.content.Intent;
import android.database.DataSetObserver;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class abcm
  extends DataSetObserver
{
  public abcm(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onChanged()
  {
    super.onChanged();
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onChanged() called " + System.identityHashCode(this.a));
    }
    if (this.a.e == ForwardRecentActivity.g)
    {
      localObject1 = ForwardRecentActivity.a(this.a);
      this.a.getIntent().putParcelableArrayListExtra("result_set", (ArrayList)localObject1);
      this.a.setResult(-1);
      this.a.finish();
    }
    while (this.a.e != ForwardRecentActivity.f) {
      return;
    }
    Object localObject1 = ForwardRecentActivity.a(this.a).getAdapter();
    int j = ((ListAdapter)localObject1).getCount();
    String str = this.a.getIntent().getStringExtra("key_direct_show_uin");
    int k = this.a.getIntent().getIntExtra("key_direct_show_uin_type", 0);
    if ((6000 == k) && (TextUtils.equals(ajsf.z, str)) && (ForwardRecentActivity.a(this.a) != null))
    {
      ForwardRecentActivity.a(this.a).callOnClick();
      return;
    }
    int i = 0;
    label197:
    Object localObject2;
    if (i < j)
    {
      localObject2 = ((ListAdapter)localObject1).getItem(i);
      if ((localObject2 instanceof aina)) {
        break label227;
      }
    }
    label227:
    do
    {
      i += 1;
      break label197;
      break;
      localObject2 = (aina)localObject2;
    } while ((((aina)localObject2).a == null) || (!TextUtils.equals(((aina)localObject2).a.uin, str)) || (k != ((aina)localObject2).a.getType()));
    localObject1 = ((ListAdapter)localObject1).getView(i, null, ForwardRecentActivity.a(this.a));
    this.a.a((View)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abcm
 * JD-Core Version:    0.7.0.1
 */
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ahiu
  extends ameq
{
  public ahiu(TroopView paramTroopView) {}
  
  protected void d(boolean paramBoolean, ArrayList<ahfc> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onGetAddContactFindTroopClassify isSuccess = " + paramBoolean + ",dataList = " + paramArrayList);
    }
    Object localObject;
    int i;
    if ((TroopView.a(this.a) != null) && (TroopView.a(this.a).b()))
    {
      localObject = TroopView.a(this.a);
      if (paramBoolean)
      {
        i = 1;
        localObject = ((ahjd)localObject).obtainMessage(14, 0, i);
        TroopView.a(this.a).sendMessage((Message)localObject);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label223;
      }
      TroopView.a(this.a).sendEmptyMessage(4);
    }
    label223:
    for (;;)
    {
      label118:
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.a.clear();
        this.a.a.addAll(paramArrayList);
        TroopView.a(this.a).notifyDataSetChanged();
        localObject = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i < paramArrayList.size())
          {
            ahfc localahfc = (ahfc)paramArrayList.get(i);
            localahfc.c = (i + 100);
            ((ArrayList)localObject).add(localahfc);
            i += 1;
            continue;
            i = 0;
            break;
            TroopView.a(this.a).sendEmptyMessage(5);
            break label118;
          }
        }
        TroopView.a(this.a).a((ArrayList)localObject);
        TroopView.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiu
 * JD-Core Version:    0.7.0.1
 */
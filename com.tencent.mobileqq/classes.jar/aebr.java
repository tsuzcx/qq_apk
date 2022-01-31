import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.ExpandableListView;

public class aebr
  implements bhww
{
  public aebr(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if (((akmb)paramExpandableListView.a()).getChildType(paramInt1, paramInt2) == 1) {
      return true;
    }
    azrr.b(this.a.getActivity(), this.a.app.getCurrentAccountUin());
    paramExpandableListView = (TroopInfo)paramExpandableListView.a().getChild(paramInt1, paramInt2);
    this.a.a(paramExpandableListView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebr
 * JD-Core Version:    0.7.0.1
 */
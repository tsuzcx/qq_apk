import android.view.View;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class aedh
  implements AdapterView.OnItemClickListener
{
  public aedh(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt - 1 < 0) || (this.a.a.size() <= paramInt - 1)) {
      return;
    }
    GroupManagerActivity.a(this.a, (Groups)this.a.a.get(paramInt - 1));
    GroupManagerActivity.a(this.a, bhdj.a(this.a, 2131692984, 2131692988, GroupManagerActivity.a(this.a).group_name, GroupManagerActivity.a(this.a), GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
    GroupManagerActivity.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedh
 * JD-Core Version:    0.7.0.1
 */
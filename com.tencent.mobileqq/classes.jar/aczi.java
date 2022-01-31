import android.view.View;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.widget.AdapterView;
import java.util.List;

public class aczi
  implements bhqp
{
  public aczi(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt - 1 < 0) || (this.a.a.size() <= paramInt - 1)) {
      return;
    }
    GroupManagerActivity.a(this.a, (Groups)this.a.a.get(paramInt - 1));
    GroupManagerActivity.a(this.a, bdcd.a(this.a, 2131693325, 2131693329, GroupManagerActivity.a(this.a).group_name, GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
    GroupManagerActivity.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczi
 * JD-Core Version:    0.7.0.1
 */
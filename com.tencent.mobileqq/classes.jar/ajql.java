import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ajql
  implements ajom
{
  public ajql(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof ajpp)) {}
    do
    {
      return;
      paramView = (ajpp)paramViewHolder;
    } while (paramView.a.msg_type.get() != 2);
    TroopNotifyAndRecommendView.a(this.a, paramView);
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajql
 * JD-Core Version:    0.7.0.1
 */
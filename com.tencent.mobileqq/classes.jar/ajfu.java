import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ajfu
  implements ajdd
{
  public ajfu(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof ajeg)) {}
    do
    {
      return;
      paramView = (ajeg)paramViewHolder;
    } while (paramView.a.msg_type.get() != 2);
    TroopSuspiciousFragment.a(this.a, paramView);
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfu
 * JD-Core Version:    0.7.0.1
 */
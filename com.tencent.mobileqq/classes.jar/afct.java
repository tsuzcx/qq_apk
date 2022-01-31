import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class afct
  implements aexp
{
  public afct(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof afbv)) {}
    do
    {
      return;
      paramView = (afbv)paramViewHolder;
    } while (paramView.a.msg_type.get() != 2);
    TroopSuspiciousFragment.a(this.a, paramView);
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afct
 * JD-Core Version:    0.7.0.1
 */
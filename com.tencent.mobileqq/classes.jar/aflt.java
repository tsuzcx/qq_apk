import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectionsExplorationClidFragment;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectionsExplorationFragment;

public class aflt
  implements bfvx
{
  public aflt(ConnectionsExplorationClidFragment paramConnectionsExplorationClidFragment) {}
  
  public void a(View paramView)
  {
    paramView = this.a.getParentFragment();
    if ((paramView != null) && ((paramView instanceof ConnectionsExplorationFragment))) {
      ((ConnectionsExplorationFragment)paramView).a(false);
    }
  }
  
  public void b(View paramView)
  {
    paramView = this.a.getParentFragment();
    if ((paramView != null) && ((paramView instanceof ConnectionsExplorationFragment))) {
      ((ConnectionsExplorationFragment)paramView).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflt
 * JD-Core Version:    0.7.0.1
 */
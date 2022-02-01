import android.view.View;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationClidFragment;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;

public class ajin
  implements blpp
{
  public ajin(ConnectionsExplorationClidFragment paramConnectionsExplorationClidFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajin
 * JD-Core Version:    0.7.0.1
 */
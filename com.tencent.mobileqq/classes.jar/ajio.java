import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajio
  implements View.OnClickListener
{
  public ajio(ConnectionsExplorationFragment paramConnectionsExplorationFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajio
 * JD-Core Version:    0.7.0.1
 */
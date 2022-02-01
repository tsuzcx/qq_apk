import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afvh
  implements View.OnClickListener
{
  public afvh(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.a.b.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
    }
    TroopMemberListActivity.a(this.a, localArrayList);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvh
 * JD-Core Version:    0.7.0.1
 */
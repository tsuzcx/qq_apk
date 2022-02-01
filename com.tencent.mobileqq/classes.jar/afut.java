import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class afut
  implements View.OnClickListener
{
  public afut(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    znw.a(this.a.a);
    znw.a(this.a.a.a);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.a.a.size())
    {
      localArrayList.add(((afwe)this.a.a.a.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.a.setResult(-1, localIntent);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afut
 * JD-Core Version:    0.7.0.1
 */
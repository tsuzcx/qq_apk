import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class akdt
  implements View.OnClickListener
{
  public akdt(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    znw.a(this.a.a);
    znw.a(this.a.a.a);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.a.a.size())
    {
      localArrayList.add(((akfc)this.a.a.a.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.a.getActivity().setResult(-1, localIntent);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdt
 * JD-Core Version:    0.7.0.1
 */
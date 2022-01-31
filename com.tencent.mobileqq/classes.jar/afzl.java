import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import java.util.ArrayList;
import java.util.List;

public class afzl
  implements View.OnClickListener
{
  public afzl(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    vxs.a(this.a.a);
    vxs.a(this.a.a.a);
    paramView = new ArrayList();
    int i = 0;
    while (i < this.a.a.a.size())
    {
      paramView.add(((agau)this.a.a.a.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", paramView);
    this.a.getActivity().setResult(-1, localIntent);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afzl
 * JD-Core Version:    0.7.0.1
 */
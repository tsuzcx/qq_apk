import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class aibs
  implements View.OnClickListener
{
  public aibs(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d == 15) && (ChatHistoryTroopMemberFragment.a(this.a).size() > 0))
    {
      paramView = new Intent();
      paramView.putExtra("param_deleted_uins", ChatHistoryTroopMemberFragment.a(this.a));
      this.a.getActivity().setResult(-1, paramView);
      if ((this.a.f == null) || (!this.a.f.equals(this.a.getActivity().app.getCurrentAccountUin()))) {
        break label171;
      }
    }
    label171:
    for (int i = 0;; i = 1)
    {
      azqs.b(this.a.getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, this.a.c, "" + i, "1", ChatHistoryTroopMemberFragment.a(this.a).toString());
      this.a.getActivity().finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibs
 * JD-Core Version:    0.7.0.1
 */
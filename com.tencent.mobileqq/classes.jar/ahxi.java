import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import java.util.ArrayList;
import java.util.List;

public class ahxi
  implements View.OnClickListener
{
  public ahxi(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    xmh.a(this.a.jdField_a_of_type_Ahys);
    xmh.a(this.a.jdField_a_of_type_JavaUtilList);
    paramView = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      paramView.add(((ahyq)this.a.jdField_a_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", paramView);
    this.a.getActivity().setResult(-1, localIntent);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxi
 * JD-Core Version:    0.7.0.1
 */
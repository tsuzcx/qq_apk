import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class aicp
  implements View.OnClickListener
{
  public aicp(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      return;
      i = ((Integer)localObject).intValue();
    } while (i < 0);
    paramView = paramView.findViewById(2131378883);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof Boolean))) {}
    for (boolean bool = ((Boolean)paramView.getTag()).booleanValue();; bool = false)
    {
      if (bool)
      {
        paramView = (aidf)this.a.jdField_a_of_type_Aidj.getItem(i);
        this.a.a(paramView);
        if ((this.a.jdField_d_of_type_AndroidAppDialog != null) && (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_d_of_type_AndroidAppDialog.dismiss();
        }
        if (this.a.jdField_d_of_type_Int != 11) {
          break;
        }
        azqs.b(this.a.b, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
        return;
      }
      paramView = (aidf)this.a.jdField_a_of_type_Aidh.getItem(i);
      this.a.a(paramView);
      if (this.a.jdField_d_of_type_Int == 11) {
        azqs.b(this.a.b, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_d_of_type_Int != 18) {
        break;
      }
      azqs.b(this.a.b, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.a.c, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicp
 * JD-Core Version:    0.7.0.1
 */
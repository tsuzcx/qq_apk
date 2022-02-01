import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajvb
  implements View.OnClickListener
{
  public ajvb(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)localObject).intValue();
    } while (i < 0);
    localObject = paramView.findViewById(2131380027);
    if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof Boolean))) {}
    for (boolean bool = ((Boolean)((View)localObject).getTag()).booleanValue();; bool = false)
    {
      if (bool)
      {
        localObject = (ajvr)this.a.jdField_a_of_type_Ajvv.getItem(i);
        this.a.a((ajvr)localObject);
        if ((this.a.jdField_d_of_type_AndroidAppDialog != null) && (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_d_of_type_AndroidAppDialog.dismiss();
        }
        if (this.a.jdField_d_of_type_Int != 11) {
          break;
        }
        bdla.b(this.a.b, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
        break;
      }
      localObject = (ajvr)this.a.jdField_a_of_type_Ajvt.getItem(i);
      this.a.a((ajvr)localObject);
      if (this.a.jdField_d_of_type_Int == 11) {
        bdla.b(this.a.b, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_d_of_type_Int != 18) {
        break;
      }
      bdla.b(this.a.b, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.a.c, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvb
 * JD-Core Version:    0.7.0.1
 */
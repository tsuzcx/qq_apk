import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class ackd
  implements View.OnClickListener
{
  public ackd(TroopMemberListActivity paramTroopMemberListActivity) {}
  
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
    paramView = paramView.findViewById(2131378259);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof Boolean))) {}
    for (boolean bool = ((Boolean)paramView.getTag()).booleanValue();; bool = false)
    {
      if (bool)
      {
        paramView = (acku)this.a.jdField_a_of_type_Acky.getItem(i);
        this.a.a(paramView);
        if ((this.a.jdField_b_of_type_AndroidAppDialog != null) && (this.a.jdField_b_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_b_of_type_AndroidAppDialog.dismiss();
        }
        if (this.a.d != 11) {
          break;
        }
        axqy.b(this.a.app, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
        return;
      }
      paramView = (acku)this.a.jdField_a_of_type_Ackw.getItem(i);
      this.a.a(paramView);
      if (this.a.d == 11) {
        axqy.b(this.a.app, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
      }
      if (this.a.d != 18) {
        break;
      }
      axqy.b(this.a.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.a.jdField_b_of_type_JavaLangString, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ackd
 * JD-Core Version:    0.7.0.1
 */
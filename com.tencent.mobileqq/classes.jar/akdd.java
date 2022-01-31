import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.open.base.LogUtility;

public class akdd
  implements View.OnClickListener
{
  public akdd(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void onClick(View paramView)
  {
    switch (NewUpgradeDialog.a(this.a))
    {
    default: 
      return;
    case 1: 
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      NewUpgradeDialog.a(this.a);
      return;
    case 4: 
      NewUpgradeDialog.b(this.a);
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      return;
    case 10: 
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      return;
    case 3: 
      NewUpgradeDialog.c(this.a);
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      return;
    case 2: 
      this.a.c();
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      return;
    }
    LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akdd
 * JD-Core Version:    0.7.0.1
 */
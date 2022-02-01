import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aeij
  extends anvi
{
  public aeij(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "onAddGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    MoveToGroupActivity.a(this.a, true);
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      QQToast.a(this.a, this.a.getString(2131694056), 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      return;
      QQToast.a(this.a, 2, this.a.getString(2131694058), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeij
 * JD-Core Version:    0.7.0.1
 */
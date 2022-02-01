import android.os.Handler;
import android.view.View;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;

class ahdv
  implements zuz
{
  ahdv(ahdt paramahdt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    this.a.c.setVisibility(0);
    this.a.a.sendEmptyMessageDelayed(0, 10000L);
    StructMsg.ButtonInfo localButtonInfo = this.a.a(paramInt1);
    argw.a(this.a.app).a(paramString, this.a.getActivity(), this.a.app, this.a.getCurFriendUin(), localButtonInfo);
    bcef.b(this.a.app, "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, this.a.getCurFriendUin(), paramInt1 + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdv
 * JD-Core Version:    0.7.0.1
 */
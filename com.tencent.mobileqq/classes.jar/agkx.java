import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agkx
  implements View.OnClickListener
{
  agkx(agkt paramagkt) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    if ((agkt.a(this.a) == null) || (agkt.a(this.a).sessionInfo == null) || (agkt.a(this.a).app == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Aoep == null) {
        this.a.jdField_a_of_type_Aoep = ((aoep)agkt.a(this.a).app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
      }
      if (this.a.jdField_a_of_type_Aoep != null)
      {
        agkt.a(this.a).app.addObserver(agkt.a(this.a));
        this.a.jdField_a_of_type_Aoep.h(agkt.a(this.a).sessionInfo.curFriendUin, true);
      }
      bhbu.a("Grp_AIO", "AIO_clk", "game_tips_clk_on", 0, 0, new String[] { this.a.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkx
 * JD-Core Version:    0.7.0.1
 */
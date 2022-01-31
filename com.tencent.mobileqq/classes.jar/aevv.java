import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class aevv
  implements AdapterView.OnItemClickListener
{
  public aevv(GameQuickWordsPanel paramGameQuickWordsPanel) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView = new ChatActivityFacade.SendMsgParams();
    paramView.c = NetworkUtil.a(BaseApplication.getContext());
    paramView.a = System.currentTimeMillis();
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramAdapterView, null, paramView);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.ay();
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "send_default", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevv
 * JD-Core Version:    0.7.0.1
 */
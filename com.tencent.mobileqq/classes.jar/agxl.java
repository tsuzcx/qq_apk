import android.content.Context;
import android.view.View;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class agxl
  implements agxf<PlusPanel>
{
  private PlusPanel jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  agxl(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public int a()
  {
    return 8;
  }
  
  public PlusPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  }
  
  public PlusPanel a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)View.inflate(paramContext, 2131558631, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
    paramContext = (afop)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(62);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.setAIOLongCaptureCtrlListener(paramContext.a);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons.c();
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    if (!paramTroopChatPie.b()) {
      bcef.b(paramTroopChatPie.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, paramTroopChatPie.sessionInfo.curFriendUin, "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIOGiftPanelContainer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIOGiftPanelContainer = new zsj(paramTroopChatPie);
    }
    zsj localzsj = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIOGiftPanelContainer;
    int j = TroopGiftPanel.e;
    if (nmy.a().a(paramTroopChatPie.sessionInfo.curFriendUin)) {}
    for (int i = 4;; i = 1)
    {
      localzsj.a(j, i);
      bduw.a(paramTroopChatPie.app).a(bdvb.a(paramTroopChatPie.getCurTroopUin()));
      return;
    }
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
      a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    b(paramXPanelContainer);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afiw)) {
      b();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    aqcv localaqcv = ((aqcu)apub.a().a(551)).a(4);
    if ((localaqcv != null) && (localaqcv.d > 0)) {
      if (localaqcv.c != 1) {
        break label76;
      }
    }
    label76:
    for (int i = 1109995692;; i = localaqcv.d)
    {
      ((auqv)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin), i, true);
      return;
    }
  }
  
  public void b(XPanelContainer paramXPanelContainer)
  {
    ((afqg)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(83)).b();
    paramXPanelContainer.a(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setInputStat(0);
    agwt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "0X8004078", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
    paramXPanelContainer = (aqxc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(77);
    if (paramXPanelContainer != null)
    {
      paramXPanelContainer = (aqxt)paramXPanelContainer.a("qq.android.poke.res_0625");
      if ((paramXPanelContainer != null) && (!paramXPanelContainer.g())) {
        paramXPanelContainer.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxl
 * JD-Core Version:    0.7.0.1
 */
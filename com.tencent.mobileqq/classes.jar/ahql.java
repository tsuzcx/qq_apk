import android.content.Context;
import android.view.View;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahql
  implements ahqf<PlusPanel>
{
  private PlusPanel jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  ahql(BaseChatPie paramBaseChatPie)
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)View.inflate(paramContext, 2131558643, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
    paramContext = (agft)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(62);
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
      bdla.b(paramTroopChatPie.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, paramTroopChatPie.sessionInfo.curFriendUin, "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIOGiftPanelContainer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIOGiftPanelContainer = new aahv(paramTroopChatPie);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIOGiftPanelContainer;
    int j = TroopGiftPanel.e;
    if (nty.a().a(paramTroopChatPie.sessionInfo.curFriendUin)) {}
    String str;
    for (int i = 4;; i = 1)
    {
      ((aahv)localObject1).a(j, i);
      bfbz.a(paramTroopChatPie.app).a(bfce.a(paramTroopChatPie.getCurTroopUin()));
      localObject1 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) {
        break label261;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.troopUin;
      Object localObject2 = ((aghg)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(89)).a();
      paramTroopChatPie = new ArrayList();
      if (localObject2 == null) {
        break label262;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramTroopChatPie.add(String.valueOf(((PlusPanelAppInfo)((Iterator)localObject2).next()).getRedDotID()));
      }
    }
    for (;;)
    {
      if (((bbbq)localObject1).a(11, str, paramTroopChatPie) != null) {
        ((bbbq)localObject1).b(11, 31);
      }
      label261:
      return;
      label262:
      paramTroopChatPie = null;
    }
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
      a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    b(paramXPanelContainer);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab)) {
      b();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    Object localObject1 = ((argb)aqxe.a().a(551)).a(4);
    if ((localObject1 != null) && (((argc)localObject1).d > 0)) {
      if (((argc)localObject1).c != 1) {
        break label204;
      }
    }
    bbbq localbbbq;
    String str;
    label204:
    for (int i = 1109995692;; i = ((argc)localObject1).d)
    {
      ((avwq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin), i, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
      }
      localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) {
        break label232;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.troopUin;
      Object localObject2 = ((aghg)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(89)).a();
      localObject1 = new ArrayList();
      if (localObject2 == null) {
        break label233;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(String.valueOf(((PlusPanelAppInfo)((Iterator)localObject2).next()).getRedDotID()));
      }
    }
    for (;;)
    {
      if (localbbbq.a(10, str, (List)localObject1) != null) {
        localbbbq.b(10, 31);
      }
      label232:
      return;
      label233:
      localObject1 = null;
    }
  }
  
  public void b(XPanelContainer paramXPanelContainer)
  {
    ((aghq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(83)).b();
    paramXPanelContainer.a(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setInputStat(0);
    ahpt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "0X8004078", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
    paramXPanelContainer = (asbm)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    if (paramXPanelContainer != null)
    {
      paramXPanelContainer = (ascd)paramXPanelContainer.a("qq.android.poke.res_0625");
      if ((paramXPanelContainer != null) && (!paramXPanelContainer.g())) {
        paramXPanelContainer.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahql
 * JD-Core Version:    0.7.0.1
 */
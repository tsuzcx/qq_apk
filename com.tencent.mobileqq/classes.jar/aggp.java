import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class aggp
  implements agin, View.OnClickListener
{
  private akce jdField_a_of_type_Akce;
  private akdt jdField_a_of_type_Akdt;
  private anzc jdField_a_of_type_Anzc;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  aggp(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a()
  {
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curFriendUin = localBundle.getString("uin");
    localSessionInfo.curType = localBundle.getInt("uintype");
    localSessionInfo.troopUin = localBundle.getString("troop_uin");
    localSessionInfo.chatBg = new afrb();
    localSessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab))
    {
      this.jdField_a_of_type_Akce = new akce(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, localSessionInfo, this.jdField_a_of_type_Anzc.l());
      this.jdField_a_of_type_Akce.show();
      this.jdField_a_of_type_Akce.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Akce.a.setOnItemClickListener(new aggq(this));
      return;
    }
    this.jdField_a_of_type_Akdt = new akdt(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, localSessionInfo, this.jdField_a_of_type_Anzc.l());
    this.jdField_a_of_type_Akdt.show();
    this.jdField_a_of_type_Akdt.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Akdt.a.setOnItemClickListener(new aggr(this));
  }
  
  private void a(akcy paramakcy)
  {
    paramakcy = paramakcy.a;
    if ((paramakcy instanceof ChatMessage))
    {
      axio.a().b((ChatMessage)paramakcy, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramakcy.time;
    int i = paramakcy.istroop;
    long l2 = paramakcy.shmsgseq;
    if (i == 1) {
      l1 = l2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jumpToSpecifiedMsg(l1);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      switch (paramInt)
      {
      }
    }
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getIntent().getExtras();
      } while (localBundle == null);
      this.jdField_a_of_type_Anzc = ((anzc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTitleBtnRightSearch.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Anzc != null) {
        this.jdField_a_of_type_Anzc.a(hashCode());
      }
      if ((this.jdField_a_of_type_Akdt != null) && (this.jdField_a_of_type_Akdt.isShowing()))
      {
        this.jdField_a_of_type_Akdt.dismiss();
        this.jdField_a_of_type_Akdt = null;
      }
    } while ((this.jdField_a_of_type_Akce == null) || (!this.jdField_a_of_type_Akce.isShowing()));
    this.jdField_a_of_type_Akce.dismiss();
    this.jdField_a_of_type_Akce = null;
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 14 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369260) && (this.jdField_a_of_type_Boolean))
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggp
 * JD-Core Version:    0.7.0.1
 */
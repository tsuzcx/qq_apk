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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class afpl
  implements afrc, View.OnClickListener
{
  private ajgq jdField_a_of_type_Ajgq;
  private ajif jdField_a_of_type_Ajif;
  private amwo jdField_a_of_type_Amwo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  afpl(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afiw)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))) {}
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
    localSessionInfo.chatBg = new aezp();
    localSessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afiw))
    {
      this.jdField_a_of_type_Ajgq = new ajgq(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, localSessionInfo, this.jdField_a_of_type_Amwo.l());
      this.jdField_a_of_type_Ajgq.show();
      this.jdField_a_of_type_Ajgq.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Ajgq.a.setOnItemClickListener(new afpm(this));
      return;
    }
    this.jdField_a_of_type_Ajif = new ajif(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, localSessionInfo, this.jdField_a_of_type_Amwo.l());
    this.jdField_a_of_type_Ajif.show();
    this.jdField_a_of_type_Ajif.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Ajif.a.setOnItemClickListener(new afpn(this));
  }
  
  private void a(ajhk paramajhk)
  {
    paramajhk = paramajhk.a;
    if ((paramajhk instanceof ChatMessage))
    {
      awcm.a().b((ChatMessage)paramajhk, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramajhk.time;
    int i = paramajhk.istroop;
    long l2 = paramajhk.shmsgseq;
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
      this.jdField_a_of_type_Amwo = ((amwo)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(92));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTitleBtnRightSearch.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Amwo != null) {
        this.jdField_a_of_type_Amwo.a(hashCode());
      }
      if ((this.jdField_a_of_type_Ajif != null) && (this.jdField_a_of_type_Ajif.isShowing()))
      {
        this.jdField_a_of_type_Ajif.dismiss();
        this.jdField_a_of_type_Ajif = null;
      }
    } while ((this.jdField_a_of_type_Ajgq == null) || (!this.jdField_a_of_type_Ajgq.isShowing()));
    this.jdField_a_of_type_Ajgq.dismiss();
    this.jdField_a_of_type_Ajgq = null;
  }
  
  public int[] a()
  {
    return new int[] { 3, 7, 13 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369097) && (this.jdField_a_of_type_Boolean))
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpl
 * JD-Core Version:    0.7.0.1
 */
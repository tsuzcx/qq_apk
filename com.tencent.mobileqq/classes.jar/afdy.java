import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper.1;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class afdy
  implements affa, View.OnClickListener
{
  private aigp jdField_a_of_type_Aigp;
  private aiie jdField_a_of_type_Aiie;
  private alxa jdField_a_of_type_Alxa;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  afdy(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agps)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a()
  {
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    localSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    localSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    localSessionInfo.jdField_a_of_type_Aeqq = new aeqq();
    localSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agps))
    {
      this.jdField_a_of_type_Aigp = new aigp(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Alxa.l());
      this.jdField_a_of_type_Aigp.show();
      this.jdField_a_of_type_Aigp.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Aigp.a.setOnItemClickListener(new afdz(this));
      return;
    }
    this.jdField_a_of_type_Aiie = new aiie(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Alxa.l());
    this.jdField_a_of_type_Aiie.show();
    this.jdField_a_of_type_Aiie.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Aiie.a.setOnItemClickListener(new afea(this));
  }
  
  private void a(aihj paramaihj)
  {
    paramaihj = paramaihj.a;
    if ((paramaihj instanceof ChatMessage))
    {
      aupg.a().b((ChatMessage)paramaihj, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aeqo.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramaihj.time;
    int i = paramaihj.istroop;
    long l2 = paramaihj.shmsgseq;
    if (i == 1) {
      l1 = l2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(l1);
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
        localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getExtras();
      } while (localBundle == null);
      this.jdField_a_of_type_Alxa = ((alxa)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Alxa != null) {
        this.jdField_a_of_type_Alxa.a(hashCode());
      }
      if ((this.jdField_a_of_type_Aiie != null) && (this.jdField_a_of_type_Aiie.isShowing()))
      {
        this.jdField_a_of_type_Aiie.dismiss();
        this.jdField_a_of_type_Aiie = null;
      }
    } while ((this.jdField_a_of_type_Aigp == null) || (!this.jdField_a_of_type_Aigp.isShowing()));
    this.jdField_a_of_type_Aigp.dismiss();
    this.jdField_a_of_type_Aigp = null;
  }
  
  public int[] a()
  {
    return new int[] { 2, 6, 11 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368653) && (this.jdField_a_of_type_Boolean))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdy
 * JD-Core Version:    0.7.0.1
 */
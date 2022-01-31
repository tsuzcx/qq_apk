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

public class adhf
  implements adif, View.OnClickListener
{
  private agdv jdField_a_of_type_Agdv;
  private agfk jdField_a_of_type_Agfk;
  private akaw jdField_a_of_type_Akaw;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  adhf(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeom)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {}
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
    localSessionInfo.jdField_a_of_type_Acur = new acur();
    localSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeom))
    {
      this.jdField_a_of_type_Agdv = new agdv(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Akaw.k());
      this.jdField_a_of_type_Agdv.show();
      this.jdField_a_of_type_Agdv.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Agdv.a.setOnItemClickListener(new adhg(this));
      return;
    }
    this.jdField_a_of_type_Agfk = new agfk(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Akaw.k());
    this.jdField_a_of_type_Agfk.show();
    this.jdField_a_of_type_Agfk.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Agfk.a.setOnItemClickListener(new adhh(this));
  }
  
  private void a(agep paramagep)
  {
    paramagep = paramagep.a;
    if ((paramagep instanceof ChatMessage))
    {
      asua.a().b((ChatMessage)paramagep, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acup.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramagep.time;
    int i = paramagep.istroop;
    long l2 = paramagep.shmsgseq;
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
      this.jdField_a_of_type_Akaw = ((akaw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Akaw != null) {
        this.jdField_a_of_type_Akaw.a(hashCode());
      }
      if ((this.jdField_a_of_type_Agfk != null) && (this.jdField_a_of_type_Agfk.isShowing()))
      {
        this.jdField_a_of_type_Agfk.dismiss();
        this.jdField_a_of_type_Agfk = null;
      }
    } while ((this.jdField_a_of_type_Agdv == null) || (!this.jdField_a_of_type_Agdv.isShowing()));
    this.jdField_a_of_type_Agdv.dismiss();
    this.jdField_a_of_type_Agdv = null;
  }
  
  public int[] a()
  {
    return new int[] { 2, 6, 11 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368455) && (this.jdField_a_of_type_Boolean))
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhf
 * JD-Core Version:    0.7.0.1
 */
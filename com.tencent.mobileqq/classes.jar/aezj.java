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

public class aezj
  implements afal, View.OnClickListener
{
  private aica jdField_a_of_type_Aica;
  private aidp jdField_a_of_type_Aidp;
  private alsl jdField_a_of_type_Alsl;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  aezj(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agld)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {}
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
    localSessionInfo.jdField_a_of_type_Aemb = new aemb();
    localSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agld))
    {
      this.jdField_a_of_type_Aica = new aica(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Alsl.l());
      this.jdField_a_of_type_Aica.show();
      this.jdField_a_of_type_Aica.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Aica.a.setOnItemClickListener(new aezk(this));
      return;
    }
    this.jdField_a_of_type_Aidp = new aidp(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Alsl.l());
    this.jdField_a_of_type_Aidp.show();
    this.jdField_a_of_type_Aidp.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Aidp.a.setOnItemClickListener(new aezl(this));
  }
  
  private void a(aicu paramaicu)
  {
    paramaicu = paramaicu.a;
    if ((paramaicu instanceof ChatMessage))
    {
      aukx.a().b((ChatMessage)paramaicu, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aelz.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramaicu.time;
    int i = paramaicu.istroop;
    long l2 = paramaicu.shmsgseq;
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
      this.jdField_a_of_type_Alsl = ((alsl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Alsl != null) {
        this.jdField_a_of_type_Alsl.a(hashCode());
      }
      if ((this.jdField_a_of_type_Aidp != null) && (this.jdField_a_of_type_Aidp.isShowing()))
      {
        this.jdField_a_of_type_Aidp.dismiss();
        this.jdField_a_of_type_Aidp = null;
      }
    } while ((this.jdField_a_of_type_Aica == null) || (!this.jdField_a_of_type_Aica.isShowing()));
    this.jdField_a_of_type_Aica.dismiss();
    this.jdField_a_of_type_Aica = null;
  }
  
  public int[] a()
  {
    return new int[] { 2, 6, 11 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368642) && (this.jdField_a_of_type_Boolean))
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezj
 * JD-Core Version:    0.7.0.1
 */
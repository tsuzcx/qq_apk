import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class acwm
  implements acxg, View.OnClickListener
{
  private afry jdField_a_of_type_Afry;
  private aftn jdField_a_of_type_Aftn;
  private ajmp jdField_a_of_type_Ajmp;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  acwm(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aedo)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb))) {}
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
    localSessionInfo.jdField_a_of_type_Ackc = new ackc();
    localSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aedo))
    {
      this.jdField_a_of_type_Afry = new afry(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Ajmp.k());
      this.jdField_a_of_type_Afry.show();
      this.jdField_a_of_type_Afry.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Afry.a.setOnItemClickListener(new acwn(this));
      return;
    }
    this.jdField_a_of_type_Aftn = new aftn(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Ajmp.k());
    this.jdField_a_of_type_Aftn.show();
    this.jdField_a_of_type_Aftn.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Aftn.a.setOnItemClickListener(new acwo(this));
  }
  
  private void a(afss paramafss)
  {
    paramafss = paramafss.a;
    if ((paramafss instanceof ChatMessage))
    {
      arxu.a().b((ChatMessage)paramafss, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramafss.time;
    int i = paramafss.istroop;
    long l2 = paramafss.shmsgseq;
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
      this.jdField_a_of_type_Ajmp = ((ajmp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Ajmp != null) {
        this.jdField_a_of_type_Ajmp.a(hashCode());
      }
      if ((this.jdField_a_of_type_Aftn != null) && (this.jdField_a_of_type_Aftn.isShowing()))
      {
        this.jdField_a_of_type_Aftn.dismiss();
        this.jdField_a_of_type_Aftn = null;
      }
    } while ((this.jdField_a_of_type_Afry == null) || (!this.jdField_a_of_type_Afry.isShowing()));
    this.jdField_a_of_type_Afry.dismiss();
    this.jdField_a_of_type_Afry = null;
  }
  
  public int[] a()
  {
    return new int[] { 2, 6, 11 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131302830) && (this.jdField_a_of_type_Boolean))
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwm
 * JD-Core Version:    0.7.0.1
 */
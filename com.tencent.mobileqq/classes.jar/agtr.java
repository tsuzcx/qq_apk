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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class agtr
  implements agvc, View.OnClickListener
{
  private akir jdField_a_of_type_Akir;
  private akkg jdField_a_of_type_Akkg;
  private aocm jdField_a_of_type_Aocm;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  agtr(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijm)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {}
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
    localSessionInfo.jdField_a_of_type_Aggu = new aggu();
    localSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijm))
    {
      this.jdField_a_of_type_Akir = new akir(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Aocm.l());
      this.jdField_a_of_type_Akir.show();
      this.jdField_a_of_type_Akir.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_Akir.a.setOnItemClickListener(new agts(this));
      return;
    }
    this.jdField_a_of_type_Akkg = new akkg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_Aocm.l());
    this.jdField_a_of_type_Akkg.show();
    this.jdField_a_of_type_Akkg.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_Akkg.a.setOnItemClickListener(new agtt(this));
  }
  
  private void a(akjl paramakjl)
  {
    paramakjl = paramakjl.a;
    if ((paramakjl instanceof ChatMessage))
    {
      axpf.a().b((ChatMessage)paramakjl, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aggs.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramakjl.time;
    int i = paramakjl.istroop;
    long l2 = paramakjl.shmsgseq;
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
      this.jdField_a_of_type_Aocm = ((aocm)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, localBundle));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Aocm != null) {
        this.jdField_a_of_type_Aocm.a(hashCode());
      }
      if ((this.jdField_a_of_type_Akkg != null) && (this.jdField_a_of_type_Akkg.isShowing()))
      {
        this.jdField_a_of_type_Akkg.dismiss();
        this.jdField_a_of_type_Akkg = null;
      }
    } while ((this.jdField_a_of_type_Akir == null) || (!this.jdField_a_of_type_Akir.isShowing()));
    this.jdField_a_of_type_Akir.dismiss();
    this.jdField_a_of_type_Akir = null;
  }
  
  public int[] a()
  {
    return new int[] { 3, 7, 13 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369071) && (this.jdField_a_of_type_Boolean))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtr
 * JD-Core Version:    0.7.0.1
 */
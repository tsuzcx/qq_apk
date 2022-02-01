import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.requests.QCircleChatGetPMBeginShowMsgRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.4;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;

public class aipe
  extends BaseChatPie
  implements Handler.Callback
{
  private anyu jdField_a_of_type_Anyu = new aiph(this);
  private aocj jdField_a_of_type_Aocj = new aipg(this);
  private MessageForQCircleIceBreak jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleIceBreak;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private MessageForUniteGrayTip jdField_a_of_type_ComTencentMobileqqGraytipMessageForUniteGrayTip;
  private Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new aipf(this);
  private byte[] jdField_a_of_type_ArrayOfByte;
  private MessageRecord b;
  private String g;
  private volatile int q;
  
  public aipe(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean E()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      int i = j;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_Aavw != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Aavw.a())
      {
        this.jdField_a_of_type_Aavw.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void bo()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "gotoFriendAio : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = agej.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void bp()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleChatPie.4(this));
  }
  
  private void bq()
  {
    if (this.jdField_a_of_type_Aggs != null) {
      this.jdField_a_of_type_Aggs.a = Boolean.valueOf(false);
    }
  }
  
  private void br()
  {
    avyl localavyl = (avyl)a(16);
    if (localavyl != null) {
      localavyl.b();
    }
  }
  
  private void g(String paramString)
  {
    paramString = new QCircleChatGetPMBeginShowMsgRequest(paramString);
    VSNetworkHelper.a().a(this.jdField_a_of_type_AndroidContentContext, paramString, new aipi(this));
  }
  
  public void H()
  {
    super.H();
  }
  
  public void P()
  {
    super.P();
    if (((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bo();
    }
  }
  
  public void Z()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPreThemeChanged" + this.H);
    }
  }
  
  public List<ChatMessage> a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = super.a(paramQQAppInterface, paramBoolean);
    Collections.sort(paramQQAppInterface, this.jdField_a_of_type_JavaUtilComparator);
    return paramQQAppInterface;
  }
  
  public List<ChatMessage> a(boolean paramBoolean)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "QCircleChatPie";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
    }
    if (paramInt2 == 1)
    {
      vtq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 5, 2);
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "report input click");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_Aggs != null) {
      this.jdField_a_of_type_Aggs.a = Boolean.valueOf(false);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.H) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bq();
    bp();
    return paramBoolean;
  }
  
  public void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPostThemeChanged" + this.H);
    }
    aV();
  }
  
  public void ap()
  {
    super.ap();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addBusinessObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.g = paramIntent.getStringExtra("qcircle_chat_show_fuel_tips_key");
    this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("qcirlce_chat_gift_info_bytes_key");
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(0);
    vtq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 1, 1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public boolean i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onBackEvent begin");
    }
    if (E()) {
      return true;
    }
    return super.i();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aiwh, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Aiwh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
  }
  
  public void m(boolean paramBoolean) {}
  
  public void o(int paramInt)
  {
    super.o(paramInt);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131367328) {
      vtq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 6, 3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (avyl)a(16);
      if (paramObject != null)
      {
        if (!paramObservable.isSend()) {
          break label44;
        }
        paramObject.d();
      }
    }
    label44:
    while (paramObservable.time <= paramObject.b) {
      return;
    }
    br();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipe
 * JD-Core Version:    0.7.0.1
 */
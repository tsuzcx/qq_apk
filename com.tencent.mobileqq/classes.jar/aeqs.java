import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class aeqs
  extends BaseChatPie
  implements Handler.Callback
{
  private boolean T;
  private boolean U;
  private boolean V;
  private ajxj jdField_a_of_type_Ajxj = new aeqw(this);
  private akat jdField_a_of_type_Akat = new aeqv(this);
  aoez jdField_a_of_type_Aoez = new aeqx(this);
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new aeqt(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new aequ(this);
  private long jdField_g_of_type_Long = -1L;
  private String jdField_g_of_type_JavaLangString = "";
  private long jdField_h_of_type_Long;
  private String jdField_h_of_type_JavaLangString = "0";
  private String i = "";
  private int q = 0;
  private int r = 0;
  private volatile int s;
  private int t;
  private int u;
  private int v;
  private int w = 0;
  
  public aeqs(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean D()
  {
    boolean bool1 = false;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      int j = k;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          j = k;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()) {
            j = 1;
          }
        }
      }
      if (j == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_Xbm != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Xbm.a())
      {
        this.jdField_a_of_type_Xbm.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "handleExtendFriendOnlineState onlineUinList =" + paramArrayList);
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      String str = ((Long)paramArrayList.get(0)).toString();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
      for (paramArrayList = ""; str.equals(paramArrayList); paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        a().runOnUiThread(new LimitChatPie.10(this));
        return;
      }
    }
  }
  
  private void bq()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "gotoFriendAio : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = actj.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void br()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      this.jdField_h_of_type_JavaLangString = aojt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.6(this, str));
      this.t = aojt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  private void bs()
  {
    if (this.jdField_a_of_type_Acup != null) {
      this.jdField_a_of_type_Acup.a = Boolean.valueOf(false);
    }
    this.jdField_a_of_type_Boolean = false;
    c(true);
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void bt()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
    ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, localAllInOne, this.w, 2);
  }
  
  private void bu()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      localObject = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateSession_updateSubTitle toUin =" + (String)localObject);
      }
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(Long.valueOf((String)localObject));
        label63:
        if (!localArrayList.isEmpty())
        {
          localObject = (aoet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
          if (localObject != null) {
            ((aoet)localObject).a(localArrayList);
          }
        }
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      catch (Exception localException)
      {
        break label63;
      }
    }
  }
  
  private void bv()
  {
    ardt localardt = (ardt)a(16);
    if (localardt != null) {
      localardt.b();
    }
  }
  
  public void G()
  {
    super.G();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy, userfinish:" + this.U);
    }
    ((akbn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(34)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      if (this.V)
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_h_of_type_Long;
        if ((this.u <= 0) || (this.v <= 0)) {
          break label184;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.jdField_h_of_type_JavaLangString, "");
      return;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      label184:
      if ((this.u > 0) || (this.v > 0)) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void I()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    localIntent.putExtra("key_limit_chat_result_action", this.r);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "chat pie finish, finishaction:" + this.r);
    }
    this.U = true;
  }
  
  public void J()
  {
    super.J();
    ((aoet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
  }
  
  public void K()
  {
    super.K();
  }
  
  public void L()
  {
    super.L();
    aokv.b();
  }
  
  public void O()
  {
    super.O();
    if (((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bq();
    }
  }
  
  public void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPreThemeChanged" + this.I);
    }
  }
  
  public void Z()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPostThemeChanged" + this.I);
    }
    aX();
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.u();
    return bbjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public List<ChatMessage> a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = super.a(paramQQAppInterface, paramBoolean);
    Collections.sort(paramQQAppInterface, this.jdField_a_of_type_JavaUtilComparator);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)paramQQAppInterface.get(paramQQAppInterface.size() - 1));
    }
    return paramQQAppInterface;
  }
  
  public List<ChatMessage> a(boolean paramBoolean)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "LimitChatPie";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    super.a(paramMessage);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AA", "0X80096AA", this.w, 0, "", "", "", "");
      return;
    case 2: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A9", "0X80096A9", this.w, 0, "", "", "", "");
      return;
    case 5: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AB", "0X80096AB", this.w, 0, "", "", "", "");
      return;
    case 24: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AC", "0X80096AC", this.w, 0, "", "", "", "");
      return;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AD", "0X80096AD", this.w, 0, "", "", "", "");
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "setSubTitleText text =" + paramString);
    }
    ardt localardt = (ardt)a(16);
    if (localardt != null) {
      localardt.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_Acup != null) {
      this.jdField_a_of_type_Acup.a = Boolean.valueOf(false);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "setSubTitlonShowSubTitleTexteText statusText =" + paramString);
    }
    awbu localawbu = (awbu)a(45);
    if ((localawbu != null) && (localawbu.a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new LimitChatPie.9(this, paramString, paramBoolean));
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.I) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bs();
    ((akbn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(34)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    br();
    return paramBoolean;
  }
  
  public void aX()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateUI_titleBarForTheme" + this.I);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    super.aX();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void ab()
  {
    aokv.b();
    super.ab();
  }
  
  public void af()
  {
    super.af();
  }
  
  public void an()
  {
    super.an();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addBusinessObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoez);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoez);
  }
  
  public void aq()
  {
    super.aq();
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(new aeqy(this));
  }
  
  public void bo()
  {
    int j = 1;
    Object localObject = (aoeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
    int m = ((aoeu)localObject).b();
    int k;
    if (m > 0)
    {
      k = this.s / m + 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkShowGrayTips " + this.s + " " + k + " " + this.t);
      }
      if (this.s % m != 0) {
        break label171;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        String str = ((aoeu)localObject).c();
        localObject = ((aoeu)localObject).d();
        if (!TextUtils.isEmpty(str))
        {
          aojt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k);
          this.t = k;
          ThreadManager.getSubThreadHandler().post(new LimitChatPie.5(this, str, (String)localObject));
        }
      }
      return;
      label171:
      if (k - this.t <= 1) {
        j = 0;
      }
    }
  }
  
  public void bp()
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.w = paramIntent.getIntExtra("key_limitchat_from_type", 0);
    this.V = paramIntent.getBooleanExtra("key_limitchat_auto_open", false);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateSession, mfromType :" + this.w);
    }
  }
  
  public void e(Intent paramIntent)
  {
    this.c = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(0);
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
    if (D()) {
      return true;
    }
    return super.i();
  }
  
  public void j() {}
  
  public void l(boolean paramBoolean) {}
  
  public void n()
  {
    super.n();
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    bu();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131370506)
    {
      super.onClick(paramView);
      return;
    }
    super.onClick(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (ardt)a(16);
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
    bv();
  }
  
  public void x()
  {
    if ((bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (bbbr.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str2 = this.jdField_g_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("ExtendFriendLimitChatFromeType", this.w);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqs
 * JD-Core Version:    0.7.0.1
 */
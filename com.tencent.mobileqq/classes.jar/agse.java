import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade.Message;
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
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceAnimView;
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

public class agse
  extends BaseChatPie
  implements Handler.Callback
{
  private boolean T;
  private boolean U;
  private boolean V;
  private boolean W = true;
  private altm jdField_a_of_type_Altm = new agsl(this);
  private alwx jdField_a_of_type_Alwx = new agsk(this);
  aqbl jdField_a_of_type_Aqbl = new agsm(this);
  private volatile ExtendFriendUserInfo jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new agsf(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new agsj(this);
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
  
  public agse(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean E()
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
    if (this.jdField_a_of_type_Yuu != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Yuu.a())
      {
        this.jdField_a_of_type_Yuu.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private boolean F()
  {
    boolean bool = false;
    aqfk localaqfk;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1044) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localaqfk = (aqfk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
        if (localaqfk == null) {
          break label66;
        }
      }
    }
    label66:
    for (bool = localaqfk.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();; bool = false)
    {
      return bool;
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "UINTYPE NOT Y");
      return false;
    }
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
  
  private void bA()
  {
    bdjz localbdjz;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      localbdjz = bdgm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698743)).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694953), new agsi(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690648), new agsh(this));
      localbdjz.setCancelable(false);
    }
    try
    {
      localbdjz.show();
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ADC8", "0X800ADC8", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ShowVoiceDialog fail" + localException.toString());
      }
    }
  }
  
  private void bB()
  {
    this.W = ((alqf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).b();
    ((aqfk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292)).a(this.W);
  }
  
  private void bC()
  {
    if ((this.d.getParent() instanceof RelativeLayout))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.d.getParent();
      ExtendFriendVoiceAnimView localExtendFriendVoiceAnimView = new ExtendFriendVoiceAnimView(this.jdField_a_of_type_AndroidContentContext);
      int j = bdoo.a(29.0F);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(13, -1);
      localRelativeLayout.addView(localExtendFriendVoiceAnimView, 0, localLayoutParams);
      localExtendFriendVoiceAnimView.setCircleParams(j(), 800);
      localExtendFriendVoiceAnimView.a(500L);
    }
  }
  
  private void bt()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "gotoFriendAio : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = aepi.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void bu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      this.jdField_h_of_type_JavaLangString = aqge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.6(this, str));
      this.t = aqge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  private void bv()
  {
    if (this.jdField_a_of_type_Aeqo != null) {
      this.jdField_a_of_type_Aeqo.a = Boolean.valueOf(false);
    }
    this.jdField_a_of_type_Boolean = false;
    c(true);
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void bw()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
    ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, localAllInOne, this.w, 2);
  }
  
  private void bx()
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
          localObject = (aqbe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
          if (localObject != null) {
            ((aqbe)localObject).a(localArrayList);
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
  
  private void by()
  {
    asyq localasyq = (asyq)a(16);
    if (localasyq != null) {
      localasyq.b();
    }
  }
  
  private void bz()
  {
    if ((this.d != null) && (this.d.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.tagID == 10000))
    {
      bC();
      bA();
    }
  }
  
  private int j()
  {
    String str1 = "#FFFFFFFF";
    String str2 = ThemeUtil.getCurrentThemeId();
    if ("1103".equals(str2)) {
      str1 = "#FFA1A1A1";
    }
    for (;;)
    {
      try
      {
        int j = Color.parseColor(str1);
        return j;
      }
      catch (Exception localException) {}
      if ("2920".equals(str2)) {
        str1 = "#FF848484";
      } else if ("2101".equals(str2)) {
        str1 = "#FFDBB86B";
      } else if ("2105".equals(str2)) {
        str1 = "#FF12B7F5";
      } else if (azmk.b(str2)) {
        if (("2921".equals(str2)) || ("2971".equals(str2))) {
          str1 = "#FF03081A";
        } else {
          str1 = "#FFFFFFFF";
        }
      }
    }
    return 0;
  }
  
  public void H()
  {
    super.H();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy, userfinish:" + this.U);
    }
    ((alxr)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(34)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      if (this.V)
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_h_of_type_Long;
        if ((this.u <= 0) || (this.v <= 0)) {
          break label195;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.jdField_h_of_type_JavaLangString, "");
      return;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      label195:
      if ((this.u > 0) || (this.v > 0)) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void J()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    localIntent.putExtra("key_limit_chat_result_action", this.r);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "chat pie finish, finishaction:" + this.r);
    }
    this.U = true;
  }
  
  public void K()
  {
    super.K();
    ((aqbe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
  }
  
  public void L()
  {
    super.L();
  }
  
  public void M()
  {
    super.M();
    aqhw.b();
  }
  
  public void P()
  {
    super.P();
    if (((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bt();
    }
    bB();
  }
  
  public void Z()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPreThemeChanged" + this.I);
    }
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.u();
    return bdml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AA", "0X80096AA", this.w, 0, "", "", "", "");
      return;
    case 2: 
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A9", "0X80096A9", this.w, 0, "", "", "", "");
      return;
    case 5: 
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AB", "0X80096AB", this.w, 0, "", "", "", "");
      return;
    case 24: 
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AC", "0X80096AC", this.w, 0, "", "", "", "");
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AD", "0X80096AD", this.w, 0, "", "", "", "");
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "setSubTitleText text =" + paramString);
    }
    asyq localasyq = (asyq)a(16);
    if (localasyq != null) {
      localasyq.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_Aeqo != null) {
      this.jdField_a_of_type_Aeqo.a = Boolean.valueOf(false);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "setSubTitlonShowSubTitleTexteText statusText =" + paramString);
    }
    aybg localaybg = (aybg)a(45);
    if ((localaybg != null) && (localaybg.a(paramBoolean, paramString))) {
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
    bv();
    ((alxr)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(34)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqbl);
    bu();
    return paramBoolean;
  }
  
  public void aZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateUI_titleBarForTheme" + this.I);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    super.aZ();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPostThemeChanged" + this.I);
    }
    aZ();
  }
  
  public void ac()
  {
    aqhw.b();
    super.ac();
  }
  
  public void ah()
  {
    super.ah();
  }
  
  public void ap()
  {
    super.ap();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addBusinessObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
  }
  
  public void as()
  {
    super.as();
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(new agsn(this));
  }
  
  public void bq()
  {
    super.bq();
    this.jdField_a_of_type_Afev.a(this);
  }
  
  public void br()
  {
    int j = 1;
    Object localObject = (aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
    int m = ((aqbg)localObject).b();
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
        String str = ((aqbg)localObject).c();
        localObject = ((aqbg)localObject).d();
        if (!TextUtils.isEmpty(str))
        {
          aqge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k);
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
  
  public void bs()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
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
    if (E()) {
      return true;
    }
    return super.i();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Ahap, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
  }
  
  public void l(boolean paramBoolean) {}
  
  public void n()
  {
    super.n();
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    bx();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131370831)
    {
      super.onClick(paramView);
      return;
    }
    super.onClick(paramView);
  }
  
  public void r()
  {
    if (Boolean.valueOf(F()).booleanValue())
    {
      this.d.setVisibility(0);
      this.d.setOnClickListener(new agsg(this));
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (asyq)a(16);
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
    by();
  }
  
  public void x()
  {
    if ((bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (bdeu.a(this.jdField_a_of_type_AndroidContentContext))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agse
 * JD-Core Version:    0.7.0.1
 */
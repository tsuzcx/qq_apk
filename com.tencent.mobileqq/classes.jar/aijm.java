import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.12;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.17;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.19;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.20;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.25;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.7;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;

public class aijm
  extends BaseChatPie
{
  public boolean S;
  boolean T = false;
  public boolean U;
  public boolean V;
  boolean W = false;
  private boolean X;
  private boolean Y;
  private boolean Z;
  aczv jdField_a_of_type_Aczv;
  agee jdField_a_of_type_Agee = new aijy(this);
  agmn jdField_a_of_type_Agmn;
  public ahzx a;
  protected aivb a;
  aivd jdField_a_of_type_Aivd;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  antp jdField_a_of_type_Antp = new aijp(this);
  anyu jdField_a_of_type_Anyu = new aijr(this);
  private aohy jdField_a_of_type_Aohy = new aijn(this);
  avhb jdField_a_of_type_Avhb = new aijs(this);
  public axts a;
  protected ayxp a;
  private bbco jdField_a_of_type_Bbco;
  private bcvx jdField_a_of_type_Bcvx = new aike(this);
  bebs jdField_a_of_type_Bebs = new aijx(this);
  private bkia jdField_a_of_type_Bkia = new aiju(this);
  protected BabyQAIOPanel a;
  private Observer jdField_a_of_type_JavaUtilObserver = new aijt(this);
  private boolean aa = true;
  private boolean ab;
  private boolean ac;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aika(this);
  public bkgt b;
  Runnable jdField_b_of_type_JavaLangRunnable = new FriendChatPie.3(this);
  private View.OnClickListener c;
  protected aocj c;
  private long e;
  String g;
  View p;
  protected int q = 0;
  
  public aijm(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new aikb(this);
    this.jdField_a_of_type_Ayxp = new aikd(this);
    this.jdField_c_of_type_Aocj = new aijo(this);
    if (paramQQAppInterface.a(165)) {
      this.jdField_b_of_type_Bkgt = ((bkgt)paramQQAppInterface.getManager(165));
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError uin " + paramString + " type " + paramInt + " uniseq " + paramLong);
    }
    MessageRecord localMessageRecord;
    boolean bool;
    if (paramInt == 0)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == -2058) && ((localMessageRecord.extraflag == 32768) || (localMessageRecord.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError, sticker msg is failed!");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, false);
        paramString = adak.a(paramString, paramInt);
        if (!EmojiStickerManager.a().b.containsKey(paramString)) {
          break label263;
        }
        paramLong = ((Long)EmojiStickerManager.a().b.get(paramString)).longValue();
        if (System.currentTimeMillis() - paramLong <= 300000L) {
          break label269;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (bool)
      {
        EmojiStickerManager.a().b.put(paramString, Long.valueOf(System.currentTimeMillis()));
        ThreadManager.getUIHandler().post(new FriendChatPie.12(this, localMessageRecord));
      }
      return;
      label263:
      bool = true;
      continue;
      label269:
      bool = false;
    }
  }
  
  private void bA()
  {
    if (this.jdField_a_of_type_Bbco != null)
    {
      this.jdField_a_of_type_Bbco.b();
      this.jdField_a_of_type_Bbco = null;
    }
  }
  
  private void bo()
  {
    Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    boolean bool;
    azib localazib;
    if ((localFriends != null) && ((bhlg.a(localFriends.detalStatusFlag, localFriends.iTermType) != 0) || ((!TextUtils.isEmpty(localFriends.strTermDesc)) && (localFriends.strTermDesc.contains("TIM"))))) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        bool = true;
        localazib = azhq.a().a(AppRuntime.Status.online, localFriends.uExtOnlineStatus, bool);
        if ((bhlg.a(localFriends.detalStatusFlag, localFriends.iTermType) != 4) || (localazib.jdField_a_of_type_Long <= 0L) || (localazib == null)) {
          break label226;
        }
        bool = true;
        label131:
        String str = azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, this.jdField_f_of_type_AndroidWidgetTextView, 1, localazib, Boolean.valueOf(bool));
        if ((TextUtils.isEmpty(str)) || (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label231;
        }
        c(true);
        this.jdField_g_of_type_JavaLangString = str;
        a(str);
        azhq.a().a(localFriends, this.jdField_f_of_type_AndroidWidgetTextView, false, localazib);
        if (R) {
          this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(str);
        }
      }
    }
    label226:
    label231:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        bool = false;
        break label131;
        c(false);
        azhq.a().a(localFriends, this.jdField_f_of_type_AndroidWidgetTextView, true, localazib);
        return;
      } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
      c(false);
    } while (this.jdField_a_of_type_Aiwh.a() != 5);
    aivb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aiwh.a();
  }
  
  private void bp()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166987));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166987));
      Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localFriends == null) || ((bhlg.a(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label255;
      }
      a(bhlg.b(localFriends));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(aifn.a().b(5), null, null, null);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
      }
      c(true);
    }
    label255:
    do
    {
      do
      {
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166988));
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166988));
        break;
      } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
      c(false);
    } while (this.jdField_a_of_type_Aiwh.a() != 5);
    aivb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aiwh.a();
  }
  
  private void bq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166987));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166987));
      Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localFriends == null) || ((bhlg.a(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label192;
      }
      a(bhlg.b(localFriends));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(aiuk.a().b(5), null, null, null);
      c(true);
    }
    label192:
    while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166988));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166988));
      break;
    }
    c(false);
  }
  
  private void br()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(85);
    if (bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      arjc localarjc = ((arjb)aran.a().a(551)).a(4);
      if ((localarjc != null) && (localarjc.jdField_a_of_type_Boolean)) {
        localMessage.arg1 = 1;
      }
    }
    localMessage.sendToTarget();
  }
  
  private void bs()
  {
    ThreadManager.post(new FriendChatPie.21(this), 5, null, false);
  }
  
  private void bt()
  {
    if (this.ac) {
      return;
    }
    ((aqyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ac = true;
  }
  
  private void bu()
  {
    avyl localavyl = (avyl)a(16);
    if (localavyl != null) {
      localavyl.b();
    }
  }
  
  private void bv()
  {
    if (this.jdField_a_of_type_Bbco == null)
    {
      this.jdField_a_of_type_Bbco = new bbco(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bbco.a(new aijz(this));
    }
  }
  
  private void bw()
  {
    if (this.jdField_a_of_type_Bbco != null) {
      this.jdField_a_of_type_Bbco.a();
    }
  }
  
  private void d(long paramLong)
  {
    bikv localbikv = (bikv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    biku localbiku = localbikv.a();
    if ((localbiku != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localbiku.b.equalsIgnoreCase(a())) && (localbiku.d == 2L) && (paramLong == localbiku.jdField_a_of_type_Long)) {
      localbikv.a(localbiku, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int i;
      if (paramBoolean1)
      {
        i = 2130843840;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!bdgb.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label132;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166987), PorterDuff.Mode.MULTIPLY);
        label64:
        if (!paramBoolean1) {
          break label166;
        }
        label68:
        this.jdField_f_of_type_AndroidWidgetTextView.setClickable(false);
        if (!paramBoolean2) {
          break label196;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(zps.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
        this.jdField_b_of_type_AndroidViewViewGroup.setClickable(true);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
        return;
        i = 2130843847;
        break;
        label132:
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label64;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label64;
        label166:
        ((Drawable)localObject).setBounds(0, 0, zps.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), zps.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        break label68;
        label196:
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h(Intent paramIntent)
  {
    this.ac = false;
    String str = paramIntent.getStringExtra("uin");
    this.W = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    aqyp localaqyp = (aqyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269);
    if (this.W)
    {
      this.T = localaqyp.c(str, paramIntent);
      return;
    }
    this.T = localaqyp.a(str, paramIntent);
  }
  
  public void D()
  {
    if (((awpd)a(32)).c()) {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateOnlineStatus, isListenTogetherTime");
      }
    }
    do
    {
      return;
      if (!((agwp)a(43)).c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateOnlineStatus, isTogetherTime");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))
    {
      bp();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      bq();
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166987));
    this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166987));
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    if ((bhxt.a().a()) || (azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
      }
      if ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_Bkgt != null) && (this.jdField_b_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || (q())) {
        break;
      }
      bo();
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
  }
  
  public boolean D()
  {
    return this.ab;
  }
  
  @TargetApi(16)
  public boolean F()
  {
    Object localObject = axsi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new aijw(this);
    }
    axtj localaxtj = (axtj)((Pair)localObject).first;
    localObject = (axtj)((Pair)localObject).second;
    if (localaxtj != null)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaxtj, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_e_of_type_AndroidWidgetImageView.setTag(localaxtj);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (localObject == null) {
        break label259;
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (axtj)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(localObject);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localaxtj, (axtj)localObject);
      axsf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaxtj, (axtj)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateSession_updateInteractive one:" + localaxtj + " two:" + localObject);
      }
      return true;
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      break;
      label259:
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    }
  }
  
  public void H()
  {
    if (this.jdField_e_of_type_Long > 0L) {
      ThreadManager.getSubThreadHandler().post(new FriendChatPie.2(this));
    }
    if (this.M)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(false);
    }
    if (this.T) {
      bt();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      adak.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      adak.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
    }
    if (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((antk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a();
    }
    this.S = false;
    super.H();
    if ((this.jdField_a_of_type_Aday != null) && (this.jdField_a_of_type_Aday.jdField_a_of_type_Adae != null))
    {
      ((airg)this.jdField_a_of_type_Aday.jdField_a_of_type_Adae).a();
      this.jdField_a_of_type_Aday.jdField_a_of_type_Adae = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a = null;
    }
    if (this.jdField_a_of_type_Aivm != null) {
      this.jdField_a_of_type_Aivm = null;
    }
    if (this.jdField_a_of_type_Agmn != null) {
      this.jdField_a_of_type_Agmn.c();
    }
    this.Z = false;
    ((wiz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253)).a();
    if (this.d != null) {
      this.d.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_Ahzx != null) {
      this.jdField_a_of_type_Ahzx.b();
    }
    if (this.jdField_a_of_type_Aged != null) {
      this.jdField_a_of_type_Aged.a(null);
    }
    bA();
  }
  
  public void K()
  {
    super.K();
    if (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((antk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).b();
    }
  }
  
  public void M()
  {
    super.M();
    if (this.jdField_a_of_type_Agmn != null) {
      this.jdField_a_of_type_Agmn.b();
    }
  }
  
  public void N()
  {
    super.N();
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(true);
    if (this.jdField_a_of_type_Agmn != null) {
      this.jdField_a_of_type_Agmn.a();
    }
  }
  
  public agrt a()
  {
    if (!agrr.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    if ((!((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(66600000L))))
    {
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      return null;
    }
    if (!axtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "aio intimate is close");
      }
      return null;
    }
    return new agrx(this);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558586, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openBabyQPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel;
    }
    return super.a(paramInt);
  }
  
  public EntryModel a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      return new EntryModel(0, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, false);
    }
    return super.a();
  }
  
  public QQRecorder.RecorderParam a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      boolean bool = super.u();
      return bhrp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new QQRecorder.RecorderParam(bhrp.jdField_a_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "FriendChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (bmxc.a(this, paramInt1, paramInt2, paramIntent)) {}
    for (;;)
    {
      return;
      super.a(paramInt1, paramInt2, paramIntent);
      if (paramInt1 == 13008) {
        if (paramIntent != null)
        {
          String str = paramIntent.getStringExtra("result");
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          if (!bhnv.d(BaseApplication.getContext())) {
            break label168;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
            break label142;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, false);
          localObject = new bnkl();
          ((bnkl)localObject).jdField_a_of_type_Int = 5;
          bnkk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a((bnkl)localObject);
        }
      }
      while (this.jdField_a_of_type_Aday.jdField_a_of_type_Adae != null)
      {
        ((airg)this.jdField_a_of_type_Aday.jdField_a_of_type_Adae).a(paramInt1, paramInt2, paramIntent);
        return;
        label142:
        new bjcf(this.jdField_a_of_type_AndroidContentContext).a(2131693035, a(), 0, 1);
        continue;
        label168:
        new bjcf(this.jdField_a_of_type_AndroidContentContext).a(2131694005, a(), 0, 1);
        continue;
        if (paramInt1 != 13009) {}
      }
    }
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==> aio cache is find! origUid" + paramLong1 + ", time" + paramLong2);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1);
    int i;
    MessageRecord localMessageRecord;
    if ((localList != null) && (localList.size() > 0))
    {
      i = 0;
      if (i >= localList.size()) {
        break label286;
      }
      localMessageRecord = (MessageRecord)localList.get(i);
      if ((adak.b(localMessageRecord)) || ((localMessageRecord instanceof MessageForSafeGrayTips))) {
        break label183;
      }
    }
    for (;;)
    {
      if ((localMessageRecord != null) && (!avpe.a(localMessageRecord)))
      {
        i = this.jdField_a_of_type_Aggs.a(localMessageRecord.uniseq);
        if (i != -1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, i, i, null, 10);
        }
      }
      label183:
      do
      {
        do
        {
          return;
          i += 1;
          break;
          if (localMessageRecord.msgtype == -2006) {
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, anzj.a(2131703760), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
        } while (paramInt2 != 1);
        ahpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
        return;
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697020, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      } while (paramInt2 != 1);
      ahpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
      return;
      label286:
      localMessageRecord = null;
    }
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, Runnable paramRunnable)
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131696546, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      if (paramInt2 == 1) {
        ahpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
      }
    }
    do
    {
      return;
      if (airf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
        }
        this.jdField_a_of_type_Aczv.a(paramLong1, paramLong2, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramRunnable, 10);
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697020, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    } while (paramInt2 != 1);
    ahpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord)
  {
    a(paramInt, paramLong1, paramLong2, paramMessageRecord, 0, 0);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==>type:" + paramInt1 + "|origUid:" + paramLong1);
    }
    paramMessageRecord = new FriendChatPie.17(this);
    boolean bool = a(paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt2);
    if (!bool)
    {
      a(paramInt1, paramLong1, paramLong2, paramInt3, paramMessageRecord);
      return;
    }
    a(paramInt1, paramLong1, paramLong2, paramInt3);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showAddFriendActivity-->uinType=" + paramInt1 + " peerUin=" + paramString1 + " name=" + paramString2 + " phoneNum=" + paramString3 + " srcId=" + paramInt2);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(aifn.a().a(2130850099));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850140);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130850672);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(aifn.a().b(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(aifn.a().b(2));
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(aiuk.a().a(2130850099));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850140);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130850672);
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aiuk.a().b(2));
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aiuk.a().b(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850099);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850139, 2130850140);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130850671, 2130850672);
        if (this.jdField_a_of_type_AndroidViewViewStub != null) {
          this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
        }
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131378164)
    {
      if (this.q == 1) {
        ((awpd)a(32)).b();
      }
      while (this.q != 2) {
        return;
      }
      ((agwp)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    super.a(paramView);
  }
  
  public void a(asmu paramasmu)
  {
    super.a(paramasmu);
    if (this.X)
    {
      aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.X);
      this.X = false;
    }
    if (this.Z)
    {
      this.Z = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i = ((Integer)paramObject).intValue();
    if (i == 29)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
    do
    {
      do
      {
        return;
      } while (i != 8);
      paramObject = ((arjb)aran.a().a(551)).a(4);
    } while ((paramObject == null) || (paramObject.d <= 0));
    if (paramObject.c == 1) {}
    for (i = 1109995692;; i = paramObject.d)
    {
      ((awdv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    avyl localavyl = (avyl)a(16);
    if (localavyl != null) {
      localavyl.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    bbsi localbbsi = (bbsi)a(45);
    if ((localbbsi != null) && (localbbsi.a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new FriendChatPie.25(this, paramString, paramBoolean));
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.H) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "FriendChatPie onViewCompleteVisableAndReleased");
    }
    if (((this.jdField_a_of_type_Aggs != null) && (this.jdField_a_of_type_Aggs.getCount() > 0)) || (!bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Aczv.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        ((aggv)this.jdField_a_of_type_Aday.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aday.e = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aday, this.jdField_a_of_type_Aczv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_Aczv.jdField_b_of_type_Boolean = false;
        return true;
      }
      super.a(paramInt, paramView, paramListView);
      return true;
    }
    g(false);
    return true;
  }
  
  protected boolean a(long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_Aggs.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
      } while ((adak.b(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      return bool;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(FriendProfileCardActivity.class.getName()))) {
      this.jdField_e_of_type_Long = NetConnInfoCenter.getServerTime();
    }
    this.S = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      str = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "upload avator " + str);
      }
      if (str != null)
      {
        if (!bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localIntent)) {
          break label285;
        }
        QQToast.a(a(), 2, 2131717918, 0).b(a());
        if (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.T = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.T) {
        h(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.T;
      this.jdField_a_of_type_Aczv = new aczv();
      this.jdField_a_of_type_Agmn = new agnc(a());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Axts = new axts(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return super.a(paramBoolean);
      label285:
      QQToast.a(a(), 1, 2131717917, 0).b(a());
    }
  }
  
  public void aR()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "==refreshTitleReativeIcon==");
    }
    F();
  }
  
  public void aV()
  {
    super.aV();
    if (bdgb.b())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "FriendChatPie updateUI_titleBarForTheme, SimpleUIMode is open now");
      return;
    }
    switch (VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))
    {
    default: 
      return;
    }
    try
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167133));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void ag()
  {
    bhsq.a(null, "AIO_onShow_business");
    super.ag();
    this.Y = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.X = aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    bhsq.a("AIO_onShow_business", null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
  }
  
  public void ah()
  {
    boolean bool1;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c())) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      String str;
      if (!bool1)
      {
        bool2 = bhxt.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (QLog.isDevelopLevel())
        {
          QLog.d("CustomOnlineStatusManager", 4, "not update friend online info\nisGetOnlineListRecently = " + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b() + "\nshouldGetOnlineInfo = " + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c());
          StringBuilder localStringBuilder = new StringBuilder();
          if (!bool2) {
            break label291;
          }
          str = "need update online status";
          QLog.d("CustomOnlineStatusManager", 4, str + " for " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      if (bool2) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if (this.aa)
        {
          this.aa = false;
          ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, true);
        }
        super.ah();
        if (!((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          aean.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          aean.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          aean.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          aean.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        br();
        return;
        bool1 = false;
        continue;
        label291:
        str = "not need update online status";
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "friendchatpie onShow_otherThings, " + localNumberFormatException.toString());
          }
        }
      }
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aohy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Avhb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Bcvx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayxp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bkia);
    ((avoj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Antp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bebs);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avhb);
    if (this.jdField_a_of_type_Bcvx != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Bcvx);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aohy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bkia);
    ((avoj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Antp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bebs);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    F();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.K);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new aijv(this));
  }
  
  protected void b(Object paramObject)
  {
    if (((paramObject instanceof MessageForStructing)) && (((MessageForStructing)paramObject).isread))
    {
      paramObject = (MessageForStructing)paramObject;
      if ((paramObject.structingMsg == null) || (paramObject.structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(paramObject.structingMsg.mResid)) || (!((bikv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a(paramObject))) {}
    }
  }
  
  public void bm()
  {
    super.bm();
    Object localObject1 = "";
    Object localObject2 = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject2 != null) {
      localObject1 = ((Card)localObject2).strReMark;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "-" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "-grayTipsRemarkMention";
      if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).apply();
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void bn()
  {
    super.bn();
    this.jdField_a_of_type_Aguw.a(this);
  }
  
  public void bx()
  {
    Object localObject = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
    localAllInOne.jdField_h_of_type_JavaLangString = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localAllInOne.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localAllInOne.g = 2;
    localAllInOne.jdField_h_of_type_Int = 117;
    azxr localazxr = new azxr();
    localazxr.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    localObject = aqoj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazxr);
    bhhz.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void by()
  {
    if (this.jdField_a_of_type_Ahzx == null) {
      this.jdField_a_of_type_Ahzx = new ahzx(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_Ahzx.a(1);
    this.jdField_a_of_type_Ahzx.a();
  }
  
  public void bz()
  {
    if ((this.h == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null)) {}
    for (;;)
    {
      return;
      Object localObject = (awpd)a(32);
      boolean bool1 = ((awpd)localObject).c();
      boolean bool2 = ((awpd)localObject).d();
      agwp localagwp = (agwp)a(43);
      boolean bool3 = localagwp.c();
      int i;
      if (bool1)
      {
        this.q = 1;
        c(true);
        a(((awpd)localObject).a(bool2));
        e(bool2, false);
        i = agej.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        awow.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.q = 2;
          c(true);
          bool3 = localagwp.a();
          a(localagwp.a());
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166987));
          e(bool3, localagwp.d());
          localObject = (bbsi)a(45);
          i = agej.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
          awow.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
        }
        else
        {
          this.h.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
          this.jdField_b_of_type_AndroidViewViewGroup.setClickable(false);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          awow.a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
          this.q = 0;
          a("");
          D();
          localObject = (bbsi)a(45);
          if (localObject != null) {
            ((bbsi)localObject).b("");
          }
        }
      }
    }
  }
  
  public void c()
  {
    super.c();
    if (this.X)
    {
      aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.X);
      this.X = false;
    }
    if (this.Z)
    {
      this.Z = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if (!bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Aday.jdField_a_of_type_Adae = new airg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_b_of_type_Bkgt != null) && (this.jdField_b_of_type_Bkgt.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_b_of_type_Bkgt != null) && (this.jdField_b_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      nok.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.post(new FriendChatPie.19(this), 5, null, false);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  protected void c(Object paramObject)
  {
    avyl localavyl;
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      localavyl = (avyl)a(16);
      if (localavyl != null)
      {
        if (!paramObject.isSend()) {
          break label38;
        }
        localavyl.d();
      }
    }
    label38:
    while (paramObject.time <= localavyl.b) {
      return;
    }
    bu();
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.V = false;
  }
  
  protected void d(Object paramObject)
  {
    if ((paramObject instanceof MessageForText))
    {
      paramObject = (MessageForText)paramObject;
      String str = paramObject.msg;
      if (paramObject.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in FriendChatPie.update()");
        }
        biho.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObject, str, this.jdField_a_of_type_AndroidContentContext, paramObject.isSend());
      }
    }
  }
  
  public boolean e()
  {
    return D();
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.Y) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.T) {
      bt();
    }
    super.f(paramBoolean);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    case 70: 
      if (this.jdField_a_of_type_Agmn != null)
      {
        this.jdField_a_of_type_Agmn.a(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_Agmn != null)
      {
        this.jdField_a_of_type_Agmn.a(2);
        return true;
      }
      break;
    case 85: 
      int i = paramMessage.arg1;
      paramMessage = this.j;
      if (i == 0) {}
      for (i = 8;; i = 0)
      {
        paramMessage.setVisibility(i);
        return true;
      }
    case 201: 
      if ((this.jdField_a_of_type_Agmn != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_Agmn.a(3, paramMessage[0], paramMessage[1]);
        }
        return true;
      }
      break;
    }
    return true;
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    ahqk.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aged != null) {
      this.jdField_a_of_type_Aged.a(this.jdField_a_of_type_Agee);
    }
  }
  
  public boolean i()
  {
    if ((this.Y) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aird.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.T) {
      bt();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Aivm == null) {
      this.jdField_a_of_type_Aivm = new aivm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aiwh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Aivd = new aivd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aiwh, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aiwh.a(this.jdField_a_of_type_Aivm);
    this.jdField_a_of_type_Aiwh.a(this.jdField_a_of_type_Aivd);
  }
  
  public void j(int paramInt)
  {
    super.j(paramInt);
    agwg localagwg = (agwg)a(52);
    if (localagwg != null) {
      localagwg.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void o(int paramInt)
  {
    super.o(paramInt);
    if (nmd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_Bkgt = ((bkgt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    axtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    bs();
    if (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (antk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if ((localObject != null) && (((antk)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        ((antk)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof aihh)) || (nmd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      aI();
      if (this.jdField_b_of_type_Bkgt != null) {
        break label246;
      }
    }
    label246:
    for (Object localObject = "";; localObject = this.jdField_b_of_type_Bkgt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.4.5", "");
      ThreadManager.post(new FriendChatPie.20(this), 5, null, true);
      by();
      bbwm.b(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      bv();
      bw();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    arjc localarjc;
    if (paramView.getId() == 2131369056)
    {
      localarjc = ((arjb)aran.a().a(551)).a(4);
      if ((localarjc != null) && (localarjc.d > 0))
      {
        if (localarjc.c != 1) {
          break label109;
        }
        ((awdv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localarjc.d, true);
      }
      if ((this.j != null) && (this.j.getVisibility() == 0)) {
        break label117;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label109:
      int i = localarjc.d;
      break;
      label117:
      if ((bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) && (localarjc != null) && (localarjc.jdField_a_of_type_Boolean)) {
        bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
      }
    }
  }
  
  public void p()
  {
    if ((this.jdField_b_of_type_Bkgt != null) && (this.jdField_b_of_type_Bkgt.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    D();
  }
  
  public void r()
  {
    int i;
    if ((!bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i = 1;
    }
    while (i != 0)
    {
      this.d.setOnClickListener(new aikc(this));
      if (mbh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.d.setVisibility(0);
        this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131697828));
        return;
        i = 0;
      }
      else
      {
        this.d.setVisibility(8);
        return;
      }
    }
    this.d.setVisibility(4);
    ThreadManager.post(new FriendChatPie.7(this), 5, null, false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageForPokeEmo))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    b(paramObject);
    if (((paramObject instanceof ChatMessage)) && (v()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.U)) {
        axtr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      }
    }
    super.update(paramObservable, paramObject);
    d(paramObject);
    aean.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    c(paramObject);
  }
  
  public void v()
  {
    bg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijm
 * JD-Core Version:    0.7.0.1
 */
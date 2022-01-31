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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.18;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.20;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.22;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.26;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;

public class aedo
  extends BaseChatPie
{
  public boolean T;
  boolean U = false;
  public boolean V;
  public boolean W;
  boolean X = false;
  private boolean Y;
  private boolean Z;
  acit jdField_a_of_type_Acit = new aeec(this);
  acpg jdField_a_of_type_Acpg;
  public aduq a;
  protected aenb a;
  aend jdField_a_of_type_Aend;
  private aenf jdField_a_of_type_Aenf;
  ajen jdField_a_of_type_Ajen = new aedt(this);
  ajjh jdField_a_of_type_Ajjh = new aedv(this);
  private ajsp jdField_a_of_type_Ajsp = new aedr(this);
  akaj jdField_a_of_type_Akaj;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  apqw jdField_a_of_type_Apqw = new aedw(this);
  public asci a;
  protected atdl a;
  private awdj jdField_a_of_type_Awdj = new aedq(this);
  axfi jdField_a_of_type_Axfi = new aeeb(this);
  private bcqu jdField_a_of_type_Bcqu = new aedy(this);
  protected BabyQAIOPanel a;
  private Observer jdField_a_of_type_JavaUtilObserver = new aedx(this);
  private boolean aa;
  private boolean ab = true;
  private boolean ac;
  aaed jdField_b_of_type_Aaed = new aeed(this);
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aeee(this);
  public bcpn b;
  Runnable jdField_b_of_type_JavaLangRunnable = new FriendChatPie.4(this);
  protected ajmm c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new aeef(this);
  Runnable jdField_c_of_type_JavaLangRunnable = new FriendChatPie.5(this);
  private long g;
  String h;
  protected int q = 0;
  View q;
  
  public aedo(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_a_of_type_Atdl = new aedp(this);
    this.jdField_c_of_type_Ajmm = new aeds(this);
    if (paramQQAppInterface.a(165)) {
      this.jdField_b_of_type_Bcpn = ((bcpn)paramQQAppInterface.getManager(165));
    }
  }
  
  private void bm()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(85);
    if (axng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      amfx localamfx = ((amfw)alzw.a().a(551)).a(4);
      if ((localamfx != null) && (localamfx.jdField_a_of_type_Boolean)) {
        localMessage.arg1 = 1;
      }
    }
    localMessage.sendToTarget();
  }
  
  private void bn()
  {
    ThreadManager.post(new FriendChatPie.22(this), 5, null, false);
  }
  
  private void bo()
  {
    if (this.ac) {
      return;
    }
    ((alxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ac = true;
  }
  
  private void bp()
  {
    aqjm localaqjm = (aqjm)a(16);
    if (localaqjm != null) {
      localaqjm.b();
    }
  }
  
  private void c(long paramLong)
  {
    bawm localbawm = (bawm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bawl localbawl = localbawm.a();
    if ((localbawl != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localbawl.b.equalsIgnoreCase(a())) && (localbawl.d == 2L) && (paramLong == localbawl.jdField_a_of_type_Long)) {
      localbawm.a(localbawl, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
  }
  
  private void h(Intent paramIntent)
  {
    this.ac = false;
    String str = paramIntent.getStringExtra("uin");
    this.X = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    alxy localalxy = (alxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269);
    if (this.X)
    {
      this.U = localalxy.c(str, paramIntent);
      return;
    }
    this.U = localalxy.a(str, paramIntent);
  }
  
  private void t(boolean paramBoolean)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int i;
      if (paramBoolean)
      {
        i = 2130843181;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!awnu.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label124;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257), PorterDuff.Mode.MULTIPLY);
        label60:
        if (!paramBoolean) {
          break label156;
        }
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(vms.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
        this.jdField_b_of_type_AndroidViewViewGroup.setClickable(true);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
        return;
        i = 2130843188;
        break;
        label124:
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label60;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label60;
        label156:
        ((Drawable)localObject).setBounds(0, 0, vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void D()
  {
    if (((aqyp)a(32)).c()) {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateOnlineStatus, isListenToghetherTime");
      }
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!((acyj)a(43)).c()) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateOnlineStatus, isTogetherTime");
              return;
              System.currentTimeMillis();
              if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f)) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
              {
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101257));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101257));
              }
              for (;;)
              {
                localObject1 = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((localObject1 == null) || ((babh.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
                  break;
                }
                a(babh.b((Friends)localObject1));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(2.0F, BaseApplicationImpl.getContext().getResources()));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(adzs.a().b(5), null, null, null);
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
                this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
                if (QLog.isDevelopLevel()) {
                  QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
                }
                c(true);
                return;
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101258));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101258));
              }
            } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
            c(false);
          } while (this.jdField_a_of_type_Aeob.a() != 5);
          aenb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Aeob.a();
          return;
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
          {
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101257));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101257));
          }
          for (;;)
          {
            localObject1 = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if ((localObject1 == null) || ((babh.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
              break;
            }
            a(babh.b((Friends)localObject1));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(2.0F, BaseApplicationImpl.getContext().getResources()));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(aemp.a().b(5), null, null, null);
            c(true);
            return;
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101258));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101258));
          }
        } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
        c(false);
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101257));
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101257));
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        if (!banc.a().a()) {
          break;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
        }
        System.currentTimeMillis();
      } while ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_Bcpn != null) && (this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    } while (q());
    Object localObject2 = ((ajjj)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    atlj localatlj;
    int i;
    if ((localObject2 != null) && ((babh.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject2).strTermDesc)) && (((Friends)localObject2).strTermDesc.contains("TIM")))))
    {
      localatlj = atlb.a().a(AppRuntime.Status.online, ((Friends)localObject2).uExtOnlineStatus);
      localObject1 = atlb.a().a(localatlj);
      if ((babh.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) == 4) && (((Friends)localObject2).uExtOnlineStatus > 0L) && (localatlj != null))
      {
        i = 1;
        label871:
        if ((i == 0) || (!atlj.a(localatlj.jdField_a_of_type_Long))) {
          break label1173;
        }
        if (atlb.a().a((Friends)localObject2) <= 0) {
          break label1047;
        }
        i = 1;
      }
    }
    label898:
    label913:
    label1173:
    for (;;)
    {
      Drawable[] arrayOfDrawable;
      if (i != 0)
      {
        localObject1 = atlb.a().a(localatlj, (AppRuntime.Status)localObject1, (Friends)localObject2);
        arrayOfDrawable = this.jdField_f_of_type_AndroidWidgetTextView.getCompoundDrawables();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label1091;
        }
        c(true);
        this.jdField_h_of_type_JavaLangString = ((String)localObject1);
        a((String)localObject1);
        if (i == 0) {
          break label1060;
        }
        localObject2 = atlb.a().a(localatlj, (Friends)localObject2);
        if (localObject2 != null)
        {
          i = aciy.a(4.0F, BaseApplicationImpl.getContext().getResources());
          this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
          this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        }
      }
      for (;;)
      {
        if (!S) {
          break label1089;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(null);
        break;
        i = 0;
        break label871;
        label1047:
        i = 0;
        break label898;
        localObject1 = babh.b((Friends)localObject2);
        break label913;
        label1060:
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      }
      label1089:
      break;
      label1091:
      c(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break;
      }
      c(false);
      if (this.jdField_a_of_type_Aeob.a() != 5) {
        break;
      }
      aenb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aeob.a();
      return;
    }
  }
  
  @TargetApi(16)
  public boolean E()
  {
    Object localObject = asax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new aeea(this);
    }
    asbx localasbx = (asbx)((Pair)localObject).first;
    localObject = (asbx)((Pair)localObject).second;
    if (localasbx != null)
    {
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localasbx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_e_of_type_AndroidWidgetImageView.setTag(localasbx);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (localObject == null) {
        break label259;
      }
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (asbx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(localObject);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localasbx, (asbx)localObject);
      asau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localasbx, (asbx)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateSession_updateInteractive one:" + localasbx + " two:" + localObject);
      }
      return true;
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      break;
      label259:
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    }
  }
  
  public void G()
  {
    if (this.jdField_g_of_type_Long > 0L) {
      ThreadManager.getSubThreadHandler().post(new FriendChatPie.2(this));
    }
    if (this.N)
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
    if (this.U) {
      bo();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      akbm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      akbm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
    }
    if (azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((ajei)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a();
    }
    this.T = false;
    super.G();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.a = null;
    }
    if ((this.jdField_a_of_type_Aenf != null) && ((this.jdField_a_of_type_Aenf.a()) || (this.jdField_a_of_type_Aenf.b()))) {
      ThreadManager.executeOnSubThread(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_Aenl != null) {
      this.jdField_a_of_type_Aenl = null;
    }
    if (this.jdField_a_of_type_Acpg != null) {
      this.jdField_a_of_type_Acpg.c();
    }
    this.aa = false;
    if ((this.jdField_b_of_type_Bcpn != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) || (this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_b_of_type_Bcpn != null) && (this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((bcqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (((this instanceof aebk)) || (mnz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      if (this.jdField_b_of_type_Bcpn != null) {
        break label552;
      }
    }
    label552:
    for (String str = "";; str = this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.2.6", "");
      ((sfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253)).a();
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      ThreadManager.executeOnSubThread(new FriendChatPie.3(this));
      if (this.jdField_a_of_type_Aduq != null) {
        this.jdField_a_of_type_Aduq.b();
      }
      if (this.jdField_a_of_type_Acis == null) {
        break;
      }
      this.jdField_a_of_type_Acis.a(null);
      return;
    }
  }
  
  public void J()
  {
    super.J();
    if (azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((ajei)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).b();
    }
  }
  
  public void L()
  {
    super.L();
    if (this.jdField_a_of_type_Acpg != null) {
      this.jdField_a_of_type_Acpg.b();
    }
  }
  
  public void M()
  {
    super.M();
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(true);
    if (this.jdField_a_of_type_Acpg != null) {
      this.jdField_a_of_type_Acpg.a();
    }
  }
  
  public acuz a()
  {
    if (!acux.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    if ((!((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(66600000L))))
    {
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      return null;
    }
    if (!asca.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "aio intimate is close");
      }
      return null;
    }
    return new acvc(this);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131492978, null));
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
      return new EntryModel(1, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, false);
    }
    return super.a();
  }
  
  public QQRecorder.RecorderParam a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      boolean bool = super.u();
      return bahn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new QQRecorder.RecorderParam(bahn.jdField_a_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "FriendChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (bftb.a(this, paramInt1, paramInt2, paramIntent)) {}
    do
    {
      do
      {
        return;
        super.a(paramInt1, paramInt2, paramIntent);
        if (paramInt1 != 13008) {
          break;
        }
      } while (paramIntent == null);
      String str = paramIntent.getStringExtra("result");
      paramIntent = str;
      if (str == null) {
        paramIntent = "";
      }
      if (badq.d(BaseApplication.getContext()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
          paramIntent = new bgfx();
          paramIntent.jdField_a_of_type_Int = 5;
          bgfw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(paramIntent);
          return;
        }
        new bbne(this.jdField_a_of_type_AndroidContentContext).a(2131627883, a(), 0, 1);
        return;
      }
      new bbne(this.jdField_a_of_type_AndroidContentContext).a(2131629006, a(), 0, 1);
      return;
    } while (paramInt1 != 13009);
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
    paramMessageRecord = new FriendChatPie.18(this);
    Object localObject = this.jdField_a_of_type_Acka.a();
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
      } while ((akbm.b(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt2);
      if (!bool) {
        if (!badq.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
        {
          bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131631771, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          if (paramInt3 == 1) {
            adni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          }
        }
      }
      do
      {
        do
        {
          return;
          if (aekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
            }
            this.jdField_a_of_type_Akaj.a(paramLong1, paramLong2, false);
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramMessageRecord, 10);
            return;
          }
          bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131632210, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        } while (paramInt3 != 1);
        adni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==> aio cache is find! origUid" + paramLong1 + ", time" + paramLong2);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1);
      } while ((localObject == null) || (((List)localObject).size() <= 0));
      paramInt2 = 0;
      label460:
      if (paramInt2 < ((List)localObject).size())
      {
        paramMessageRecord = (MessageRecord)((List)localObject).get(paramInt2);
        if ((akbm.b(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips))) {}
      }
      for (;;)
      {
        if ((paramMessageRecord != null) && (!aqay.a(paramMessageRecord)))
        {
          paramInt2 = this.jdField_a_of_type_Acka.a(paramMessageRecord.uniseq);
          if (paramInt2 != -1)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
            return;
            paramInt2 += 1;
            break label460;
          }
          if (paramMessageRecord.msgtype == -2006) {
            bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ajjy.a(2131639077), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
          if (paramInt3 != 1) {
            break;
          }
          adni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          return;
        }
        bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131632210, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        if (paramInt3 != 1) {
          break;
        }
        adni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
        return;
        paramMessageRecord = null;
      }
    }
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(adzs.a().a(2130848801));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130848842);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849307);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(adzs.a().b(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(adzs.a().b(2));
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(aemp.a().a(2130848801));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130848842);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849307);
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(aemp.a().b(2));
        }
        else
        {
          this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(aemp.a().b(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130848801);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130848841, 2130848842);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849306, 2130849307);
        if (this.jdField_a_of_type_AndroidViewViewStub != null) {
          this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_d_of_type_AndroidViewView != null) {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131310824)
    {
      if (this.q == 1) {
        ((aqyp)a(32)).c();
      }
      while (this.q != 2) {
        return;
      }
      ((acyj)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    super.a(paramView);
  }
  
  public void a(anht paramanht)
  {
    super.a(paramanht);
    if (this.Y)
    {
      aeki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
      this.Y = false;
    }
    if (this.aa)
    {
      this.aa = false;
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
    do
    {
      do
      {
        return;
      } while (i != 8);
      paramObject = ((amfw)alzw.a().a(551)).a(4);
    } while ((paramObject == null) || (paramObject.d <= 0));
    if (paramObject.c == 1) {}
    for (i = 1109995692;; i = paramObject.d)
    {
      ((aqpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    aqjm localaqjm = (aqjm)a(16);
    if (localaqjm != null) {
      localaqjm.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    avbz localavbz = (avbz)a(45);
    if ((localavbz != null) && (localavbz.a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new FriendChatPie.26(this, paramString, paramBoolean));
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.I) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "FriendChatPie onViewCompleteVisableAndReleased");
    }
    if ((this.jdField_a_of_type_Acka != null) && (this.jdField_a_of_type_Acka.getCount() > 0))
    {
      if (this.jdField_a_of_type_Akaj.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        ((ackd)this.jdField_a_of_type_Akcg.a).a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Akcg.e = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Akcg, this.jdField_a_of_type_Akaj, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_Akaj.jdField_b_of_type_Boolean = false;
        return true;
      }
      super.a(paramInt, paramView, paramListView);
      return true;
    }
    g(false);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(FriendProfileCardActivity.class.getName()))) {
      this.jdField_g_of_type_Long = NetConnInfoCenter.getServerTime();
    }
    this.T = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      str = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "upload avator " + str);
      }
      if (str != null)
      {
        if (!azyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localIntent)) {
          break label285;
        }
        bbmy.a(a(), 2, 2131653474, 0).b(a());
        if (azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.U = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.U) {
        h(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.U;
      this.jdField_a_of_type_Akaj = new akaj();
      this.jdField_a_of_type_Acpg = new acpv(a());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Asci = new asci(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return super.a(paramBoolean);
      label285:
      bbmy.a(a(), 1, 2131653473, 0).b(a());
    }
  }
  
  public void aQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "==refreshTitleReativeIcon==");
    }
    E();
  }
  
  public void aV()
  {
    super.aV();
    if (awnu.b())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "FriendChatPie updateUI_titleBarForTheme, SimpleUIMode is open now");
      return;
    }
    switch (bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))
    {
    default: 
      return;
    }
    try
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101391));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void ae()
  {
    baio.a(null, "AIO_onShow_business");
    super.ae();
    aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.Z = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.Y = aeki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    baio.a("AIO_onShow_business", null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!mqb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
  }
  
  public void af()
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
        bool2 = banc.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (QLog.isDevelopLevel())
        {
          QLog.d("CustomOnlineStatusManager", 4, "not update friend online info\nisGetOnlineListRecently = " + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b() + "\nshouldGetOnlineInfo = " + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c());
          StringBuilder localStringBuilder = new StringBuilder();
          if (!bool2) {
            break label238;
          }
          str = "need update online status";
          QLog.d("CustomOnlineStatusManager", 4, str + " for " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      if (bool2) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if (this.ab)
        {
          this.ab = false;
          ThreadManager.post(this.jdField_c_of_type_JavaLangRunnable, 8, null, true);
        }
        super.af();
        if (((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          aael.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          bm();
          return;
          bool1 = false;
          continue;
          label238:
          str = "not need update online status";
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "friendchatpie onShow_otherThings, " + localNumberFormatException.toString());
            continue;
            aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
            aael.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            aael.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            aael.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            aael.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Apqw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Awdj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atdl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcqu);
    ((aqae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajen);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axfi);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apqw);
    if (this.jdField_a_of_type_Awdj != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Awdj);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atdl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bcqu);
    ((aqae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajen);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axfi);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    E();
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.L);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new aedz(this));
  }
  
  public void bl()
  {
    super.bl();
    Object localObject1 = "";
    Object localObject2 = azyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  public void bv()
  {
    Object localObject = azyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
    localAllInOne.jdField_h_of_type_JavaLangString = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localAllInOne.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localAllInOne.g = 2;
    localAllInOne.jdField_h_of_type_Int = 117;
    atwx localatwx = new atwx();
    localatwx.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    localObject = alqg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localatwx);
    azyk.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void bw()
  {
    if (this.jdField_a_of_type_Aduq == null) {
      this.jdField_a_of_type_Aduq = new aduq(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_Aduq.a(1);
    this.jdField_a_of_type_Aduq.a();
  }
  
  public void bx()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null)) {}
    for (;;)
    {
      return;
      Object localObject = (aqyp)a(32);
      boolean bool1 = ((aqyp)localObject).c();
      boolean bool2 = ((aqyp)localObject).d();
      acyj localacyj = (acyj)a(43);
      boolean bool3 = localacyj.c();
      int i;
      if (bool1)
      {
        this.q = 1;
        c(true);
        a(((aqyp)localObject).a(bool2));
        t(bool2);
        i = aciy.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        aqyg.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.q = 2;
          c(true);
          bool3 = localacyj.a();
          a(localacyj.a());
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
          t(bool3);
          localObject = (avbz)a(45);
          i = aciy.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
          aqyg.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
        }
        else
        {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
          this.jdField_b_of_type_AndroidViewViewGroup.setClickable(false);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          aqyg.a(this.jdField_b_of_type_AndroidViewViewGroup);
          this.q = 0;
          a("");
          D();
          localObject = (avbz)a(45);
          if (localObject != null) {
            ((avbz)localObject).b("");
          }
        }
      }
    }
  }
  
  public void c()
  {
    super.c();
    if (this.Y)
    {
      aeki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
      this.Y = false;
    }
    if (this.aa)
    {
      this.aa = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if ((this.jdField_b_of_type_Bcpn != null) && (this.jdField_b_of_type_Bcpn.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_b_of_type_Bcpn != null) && (this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      mqb.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.post(new FriendChatPie.20(this), 5, null, false);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.W = false;
  }
  
  public boolean e()
  {
    return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aeki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.U) {
      bo();
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
      if (this.jdField_a_of_type_Acpg != null)
      {
        this.jdField_a_of_type_Acpg.a(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_Acpg != null)
      {
        this.jdField_a_of_type_Acpg.a(2);
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
      if ((this.jdField_a_of_type_Acpg != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_Acpg.a(3, paramMessage[0], paramMessage[1]);
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
    adnu.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Acis != null) {
      this.jdField_a_of_type_Acis.a(this.jdField_a_of_type_Acit);
    }
    this.jdField_a_of_type_Aaed = this.jdField_b_of_type_Aaed;
  }
  
  public boolean i()
  {
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aeki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.U) {
      bo();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    this.jdField_a_of_type_Aenf = new aenf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (this.jdField_a_of_type_Aenl == null) {
      this.jdField_a_of_type_Aenl = new aenl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Aend = new aend(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aenl);
    this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aenf);
    this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aend);
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    if (mnz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_Bcpn = ((bcpn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    asch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    bn();
    if (azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (ajei)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if ((localObject != null) && (((ajei)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        ((ajei)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof aebk)) || (mnz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      aH();
      if (this.jdField_b_of_type_Bcpn != null) {
        break label238;
      }
    }
    label238:
    for (Object localObject = "";; localObject = this.jdField_b_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.2.6", "");
      ThreadManager.post(new FriendChatPie.21(this), 5, null, true);
      bw();
      avge.b(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131302816)
    {
      paramView = ((amfw)alzw.a().a(551)).a(4);
      if ((paramView != null) && (paramView.d > 0))
      {
        if (paramView.c != 1) {
          break label102;
        }
        ((aqpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramView.d, true);
      }
      if ((this.j != null) && (this.j.getVisibility() == 0)) {
        break label110;
      }
    }
    label102:
    label110:
    while ((!axng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) || (paramView == null) || (!paramView.jdField_a_of_type_Boolean))
    {
      return;
      int i = paramView.d;
      break;
    }
    axng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
  }
  
  public void p()
  {
    if ((this.jdField_b_of_type_Bcpn != null) && (this.jdField_b_of_type_Bcpn.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    D();
  }
  
  public void s()
  {
    int i;
    if ((!azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i = 1;
    }
    while (i != 0)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new aeeg(this));
      if (lqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131632821));
        return;
        i = 0;
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    ThreadManager.post(new FriendChatPie.9(this), 5, null, false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject != null) && ((paramObject instanceof MessageForPokeEmo)))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    if ((paramObject != null) && ((paramObject instanceof MessageForStructing)) && (!((MessageForStructing)paramObject).isread))
    {
      localObject = (MessageForStructing)paramObject;
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mResid)) || (!((bawm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a((MessageForStructing)localObject))) {}
    }
    if (((paramObject instanceof ChatMessage)) && (v()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.V)) {
        asch.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      }
    }
    super.update(paramObservable, paramObject);
    if ((paramObject != null) && ((paramObject instanceof MessageForText)))
    {
      paramObservable = (MessageForText)paramObject;
      localObject = paramObservable.msg;
      if (paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in FriendChatPie.update()");
        }
        batg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, (String)localObject, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
      }
    }
    aael.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (aqjm)a(16);
      if (paramObject != null)
      {
        if (!paramObservable.isSend()) {
          break label323;
        }
        paramObject.d();
      }
    }
    label323:
    while (paramObservable.time <= paramObject.b) {
      return;
    }
    bp();
  }
  
  public void v()
  {
    bg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedo
 * JD-Core Version:    0.7.0.1
 */
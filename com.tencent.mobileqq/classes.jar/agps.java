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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.17;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.19;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.20;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.25;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.8;
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

public class agps
  extends BaseChatPie
{
  public boolean T;
  boolean U = false;
  public boolean V;
  public boolean W;
  boolean X = false;
  private boolean Y;
  private boolean Z;
  abst jdField_a_of_type_Abst;
  aepd jdField_a_of_type_Aepd = new agqf(this);
  aewb jdField_a_of_type_Aewb;
  public aggq a;
  protected agzo a;
  agzq jdField_a_of_type_Agzq;
  alop jdField_a_of_type_Alop = new agpw(this);
  altm jdField_a_of_type_Altm = new agpy(this);
  private amdd jdField_a_of_type_Amdd = new agpu(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  asim jdField_a_of_type_Asim = new agpz(this);
  public autu a;
  protected avve a;
  private azcg jdField_a_of_type_Azcg = new agpt(this);
  baht jdField_a_of_type_Baht = new agqe(this);
  private bfzo jdField_a_of_type_Bfzo = new agqb(this);
  protected BabyQAIOPanel a;
  private Observer jdField_a_of_type_JavaUtilObserver = new agqa(this);
  private boolean aa;
  private boolean ab = true;
  private boolean ac;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new agqg(this);
  public bfyh b;
  Runnable jdField_b_of_type_JavaLangRunnable = new FriendChatPie.4(this);
  protected alwx c;
  private View.OnClickListener c;
  private long g;
  String h;
  protected int q = 0;
  View q;
  
  public agps(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new agqh(this);
    this.jdField_a_of_type_Avve = new agqj(this);
    this.jdField_c_of_type_Alwx = new agpv(this);
    if (paramQQAppInterface.a(165)) {
      this.jdField_b_of_type_Bfyh = ((bfyh)paramQQAppInterface.getManager(165));
    }
  }
  
  private void br()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(85);
    if (bapu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      aoro localaoro = ((aorn)aoks.a().a(551)).a(4);
      if ((localaoro != null) && (localaoro.jdField_a_of_type_Boolean)) {
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
    ((aoiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ac = true;
  }
  
  private void bu()
  {
    asyq localasyq = (asyq)a(16);
    if (localasyq != null) {
      localasyq.b();
    }
  }
  
  private void c(long paramLong)
  {
    bede localbede = (bede)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bedd localbedd = localbede.a();
    if ((localbedd != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localbedd.b.equalsIgnoreCase(a())) && (localbedd.d == 2L) && (paramLong == localbedd.jdField_a_of_type_Long)) {
      localbede.a(localbedd, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
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
        i = 2130843461;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!azmk.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label132;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900), PorterDuff.Mode.MULTIPLY);
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
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(xsm.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
        this.jdField_b_of_type_AndroidViewViewGroup.setClickable(true);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
        return;
        i = 2130843468;
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
        ((Drawable)localObject).setBounds(0, 0, xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
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
    this.X = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    aoiu localaoiu = (aoiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269);
    if (this.X)
    {
      this.U = localaoiu.c(str, paramIntent);
      return;
    }
    this.U = localaoiu.a(str, paramIntent);
  }
  
  public void D()
  {
    if (((atpj)a(32)).c()) {
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
                if (!((afgf)a(43)).c()) {
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
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166900));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166900));
              }
              for (;;)
              {
                localObject1 = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((localObject1 == null) || ((bdgc.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
                  break;
                }
                a(bdgc.b((Friends)localObject1));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aepi.a(2.0F, BaseApplicationImpl.getContext().getResources()));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(aglv.a().b(5), null, null, null);
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
                this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
                if (QLog.isDevelopLevel()) {
                  QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
                }
                c(true);
                return;
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166901));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166901));
              }
            } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
            c(false);
          } while (this.jdField_a_of_type_Ahap.a() != 5);
          agzo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Ahap.a();
          return;
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
          {
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166900));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166900));
          }
          for (;;)
          {
            localObject1 = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if ((localObject1 == null) || ((bdgc.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
              break;
            }
            a(bdgc.b((Friends)localObject1));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aepi.a(2.0F, BaseApplicationImpl.getContext().getResources()));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(agzc.a().b(5), null, null, null);
            c(true);
            return;
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166901));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166901));
          }
        } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
        c(false);
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166900));
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166900));
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        if ((!bdsp.a().a()) && (!awfa.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
        }
        System.currentTimeMillis();
      } while ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_Bfyh != null) && (this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
      localObject1 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    } while (q());
    Object localObject2 = ((alto)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    awev localawev;
    int i;
    if ((localObject2 != null) && ((bdgc.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject2).strTermDesc)) && (((Friends)localObject2).strTermDesc.contains("TIM")))))
    {
      localawev = aweo.a().a(AppRuntime.Status.online, ((Friends)localObject2).uExtOnlineStatus);
      localObject1 = aweo.a().a(localawev);
      if ((bdgc.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) == 4) && (((Friends)localObject2).uExtOnlineStatus > 0L) && (localawev != null))
      {
        i = 1;
        label891:
        if ((i == 0) || (!awev.a(localawev.jdField_a_of_type_Long))) {
          break label1201;
        }
        if (aweo.a().a((Friends)localObject2) <= 0) {
          break label1075;
        }
        i = 1;
      }
    }
    label918:
    label941:
    label1201:
    for (;;)
    {
      Drawable[] arrayOfDrawable;
      if (i != 0)
      {
        localObject1 = aweo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawev, (AppRuntime.Status)localObject1, (Friends)localObject2, this.jdField_f_of_type_AndroidWidgetTextView);
        arrayOfDrawable = this.jdField_f_of_type_AndroidWidgetTextView.getCompoundDrawables();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label1119;
        }
        c(true);
        this.jdField_h_of_type_JavaLangString = ((String)localObject1);
        a((String)localObject1);
        if (i == 0) {
          break label1088;
        }
        localObject2 = aweo.a().a(localawev, (Friends)localObject2);
        if (localObject2 != null)
        {
          i = aepi.a(4.0F, BaseApplicationImpl.getContext().getResources());
          this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
          this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        }
      }
      for (;;)
      {
        if (!S) {
          break label1117;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(null);
        break;
        i = 0;
        break label891;
        label1075:
        i = 0;
        break label918;
        localObject1 = bdgc.b((Friends)localObject2);
        break label941;
        label1088:
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      }
      label1117:
      break;
      label1119:
      c(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break;
      }
      c(false);
      if (this.jdField_a_of_type_Ahap.a() != 5) {
        break;
      }
      agzo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Ahap.a();
      return;
    }
  }
  
  @TargetApi(16)
  public boolean F()
  {
    Object localObject = ausj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new agqd(this);
    }
    autj localautj = (autj)((Pair)localObject).first;
    localObject = (autj)((Pair)localObject).second;
    if (localautj != null)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localautj, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_e_of_type_AndroidWidgetImageView.setTag(localautj);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (localObject == null) {
        break label259;
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (autj)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(localObject);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localautj, (autj)localObject);
      ausg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localautj, (autj)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateSession_updateInteractive one:" + localautj + " two:" + localObject);
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
      bt();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      abti.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      abti.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
    }
    if (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a();
    }
    this.T = false;
    super.H();
    if ((this.jdField_a_of_type_Abts != null) && (this.jdField_a_of_type_Abts.jdField_a_of_type_Abtd != null))
    {
      ((agwt)this.jdField_a_of_type_Abts.jdField_a_of_type_Abtd).a();
      this.jdField_a_of_type_Abts.jdField_a_of_type_Abtd = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq.a = null;
    }
    if (this.jdField_a_of_type_Agzy != null) {
      this.jdField_a_of_type_Agzy = null;
    }
    if (this.jdField_a_of_type_Aewb != null) {
      this.jdField_a_of_type_Aewb.c();
    }
    this.aa = false;
    if ((this.jdField_b_of_type_Bfyh != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) || (this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_b_of_type_Bfyh != null) && (this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((bfzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (((this instanceof agnn)) || (nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      if (this.jdField_b_of_type_Bfyh != null) {
        break label556;
      }
    }
    label556:
    for (String str = "";; str = this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.3.5", "");
      ((uls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253)).a();
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      ThreadManager.executeOnSubThread(new FriendChatPie.3(this));
      if (this.jdField_a_of_type_Aggq != null) {
        this.jdField_a_of_type_Aggq.b();
      }
      if (this.jdField_a_of_type_Aepc == null) {
        break;
      }
      this.jdField_a_of_type_Aepc.a(null);
      return;
    }
  }
  
  public void K()
  {
    super.K();
    if (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).b();
    }
  }
  
  public void M()
  {
    super.M();
    if (this.jdField_a_of_type_Aewb != null) {
      this.jdField_a_of_type_Aewb.b();
    }
  }
  
  public void N()
  {
    super.N();
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(true);
    if (this.jdField_a_of_type_Aewb != null) {
      this.jdField_a_of_type_Aewb.a();
    }
  }
  
  public afcg a()
  {
    if (!afce.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    if ((!((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(66600000L))))
    {
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      return null;
    }
    if (!autm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "aio intimate is close");
      }
      return null;
    }
    return new afck(this);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558559, null));
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
      return bdml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new QQRecorder.RecorderParam(bdml.jdField_a_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "FriendChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (bjhs.a(this, paramInt1, paramInt2, paramIntent)) {}
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
          if (!bdin.d(BaseApplication.getContext())) {
            break label168;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
            break label142;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, false);
          localObject = new bjuy();
          ((bjuy)localObject).jdField_a_of_type_Int = 5;
          bjux.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a((bjuy)localObject);
        }
      }
      while (this.jdField_a_of_type_Abts.jdField_a_of_type_Abtd != null)
      {
        ((agwt)this.jdField_a_of_type_Abts.jdField_a_of_type_Abtd).a(paramInt1, paramInt2, paramIntent);
        return;
        label142:
        new beuj(this.jdField_a_of_type_AndroidContentContext).a(2131693628, a(), 0, 1);
        continue;
        label168:
        new beuj(this.jdField_a_of_type_AndroidContentContext).a(2131694829, a(), 0, 1);
        continue;
        if (paramInt1 != 13009) {}
      }
    }
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
    Object localObject = this.jdField_a_of_type_Aeqo.a();
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
      } while ((abti.b(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt2);
      if (!bool) {
        if (!bdin.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
        {
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697661, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          if (paramInt3 == 1) {
            afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          }
        }
      }
      do
      {
        do
        {
          return;
          if (agws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
            }
            this.jdField_a_of_type_Abst.a(paramLong1, paramLong2, false);
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramMessageRecord, 10);
            return;
          }
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698124, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        } while (paramInt3 != 1);
        afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
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
        if ((abti.b(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips))) {}
      }
      for (;;)
      {
        if ((paramMessageRecord != null) && (!aspz.a(paramMessageRecord)))
        {
          paramInt2 = this.jdField_a_of_type_Aeqo.a(paramMessageRecord.uniseq);
          if (paramInt2 != -1)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
            return;
            paramInt2 += 1;
            break label460;
          }
          if (paramMessageRecord.msgtype == -2006) {
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, alud.a(2131705257), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
          if (paramInt3 != 1) {
            break;
          }
          afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698124, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        if (paramInt3 != 1) {
          break;
        }
        afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(aglv.a().a(2130849536));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849577);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130850064);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aglv.a().b(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aglv.a().b(2));
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(agzc.a().a(2130849536));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849577);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130850064);
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(agzc.a().b(2));
        }
        else
        {
          this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(agzc.a().b(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849536);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849576, 2130849577);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130850063, 2130850064);
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
    if (paramView.getId() == 2131377198)
    {
      if (this.q == 1) {
        ((atpj)a(32)).b();
      }
      while (this.q != 2) {
        return;
      }
      ((afgf)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    super.a(paramView);
  }
  
  public void a(apuf paramapuf)
  {
    super.a(paramapuf);
    if (this.Y)
    {
      agwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
    do
    {
      do
      {
        return;
      } while (i != 8);
      paramObject = ((aorn)aoks.a().a(551)).a(4);
    } while ((paramObject == null) || (paramObject.d <= 0));
    if (paramObject.c == 1) {}
    for (i = 1109995692;; i = paramObject.d)
    {
      ((ateu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    asyq localasyq = (asyq)a(16);
    if (localasyq != null) {
      localasyq.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    aybg localaybg = (aybg)a(45);
    if ((localaybg != null) && (localaybg.a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new FriendChatPie.25(this, paramString, paramBoolean));
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
    if (((this.jdField_a_of_type_Aeqo != null) && (this.jdField_a_of_type_Aeqo.getCount() > 0)) || (!bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Abst.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        ((aeqr)this.jdField_a_of_type_Abts.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Abts.e = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Abts, this.jdField_a_of_type_Abst, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_Abst.jdField_b_of_type_Boolean = false;
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
        if (!bddf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localIntent)) {
          break label285;
        }
        QQToast.a(a(), 2, 2131719807, 0).b(a());
        if (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.U = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.U) {
        h(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.U;
      this.jdField_a_of_type_Abst = new abst();
      this.jdField_a_of_type_Aewb = new aewq(a());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Autu = new autu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return super.a(paramBoolean);
      label285:
      QQToast.a(a(), 1, 2131719806, 0).b(a());
    }
  }
  
  public void aU()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "==refreshTitleReativeIcon==");
    }
    F();
  }
  
  public void aZ()
  {
    super.aZ();
    if (azmk.b())
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
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167039));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void ag()
  {
    bdnm.a(null, "AIO_onShow_business");
    super.ag();
    acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.Z = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.Y = agwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    bdnm.a("AIO_onShow_business", null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!ndv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
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
        bool2 = bdsp.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
          ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, true);
        }
        super.ah();
        if (((alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          acjm.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          br();
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
            acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
            acjm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            acjm.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            acjm.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            acjm.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amdd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asim);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azcg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Avve);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfzo);
    ((aspf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alop);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Baht);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asim);
    if (this.jdField_a_of_type_Azcg != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azcg);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Avve);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amdd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bfzo);
    ((aspf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alop);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Baht);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    F();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.L);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new agqc(this));
  }
  
  public void bA()
  {
    Object localObject = bddf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
    localAllInOne.jdField_h_of_type_JavaLangString = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localAllInOne.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localAllInOne.g = 2;
    localAllInOne.jdField_h_of_type_Int = 117;
    awqt localawqt = new awqt();
    localawqt.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    localObject = aoae.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawqt);
    bddf.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void bB()
  {
    if (this.jdField_a_of_type_Aggq == null) {
      this.jdField_a_of_type_Aggq = new aggq(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_Aggq.a(1);
    this.jdField_a_of_type_Aggq.a();
  }
  
  public void bC()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null)) {}
    for (;;)
    {
      return;
      Object localObject = (atpj)a(32);
      boolean bool1 = ((atpj)localObject).c();
      boolean bool2 = ((atpj)localObject).d();
      afgf localafgf = (afgf)a(43);
      boolean bool3 = localafgf.c();
      int i;
      if (bool1)
      {
        this.q = 1;
        c(true);
        a(((atpj)localObject).a(bool2));
        e(bool2, false);
        i = aepi.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        atpc.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.q = 2;
          c(true);
          bool3 = localafgf.a();
          a(localafgf.a());
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
          e(bool3, localafgf.d());
          localObject = (aybg)a(45);
          i = aepi.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
          atpc.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
        }
        else
        {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
          this.jdField_b_of_type_AndroidViewViewGroup.setClickable(false);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          atpc.a(this.jdField_b_of_type_AndroidViewViewGroup);
          this.q = 0;
          a("");
          D();
          localObject = (aybg)a(45);
          if (localObject != null) {
            ((aybg)localObject).b("");
          }
        }
      }
    }
  }
  
  public void bp()
  {
    super.bp();
    Object localObject1 = "";
    Object localObject2 = bddf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  public void bq()
  {
    super.bq();
    this.jdField_a_of_type_Afev.a(this);
  }
  
  public void c()
  {
    super.c();
    if (this.Y)
    {
      agwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
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
    if (!bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Abts.jdField_a_of_type_Abtd = new agwt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_b_of_type_Bfyh != null) && (this.jdField_b_of_type_Bfyh.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_b_of_type_Bfyh != null) && (this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      ndv.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.post(new FriendChatPie.19(this), 5, null, false);
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
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (agwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.U) {
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
      if (this.jdField_a_of_type_Aewb != null)
      {
        this.jdField_a_of_type_Aewb.a(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_Aewb != null)
      {
        this.jdField_a_of_type_Aewb.a(2);
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
      if ((this.jdField_a_of_type_Aewb != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_Aewb.a(3, paramMessage[0], paramMessage[1]);
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
    afzu.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aepc != null) {
      this.jdField_a_of_type_Aepc.a(this.jdField_a_of_type_Aepd);
    }
  }
  
  public boolean i()
  {
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (agwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.U) {
      bt();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Agzy == null) {
      this.jdField_a_of_type_Agzy = new agzy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahap, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Agzq = new agzq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahap, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Agzy);
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Agzq);
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    if (nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_Bfyh = ((bfyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    autt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    bs();
    if (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if ((localObject != null) && (((alok)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        ((alok)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof agnn)) || (nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      aL();
      if (this.jdField_b_of_type_Bfyh != null) {
        break label238;
      }
    }
    label238:
    for (Object localObject = "";; localObject = this.jdField_b_of_type_Bfyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.3.5", "");
      ThreadManager.post(new FriendChatPie.20(this), 5, null, true);
      bB();
      ayfl.b(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131368638)
    {
      paramView = ((aorn)aoks.a().a(551)).a(4);
      if ((paramView != null) && (paramView.d > 0))
      {
        if (paramView.c != 1) {
          break label102;
        }
        ((ateu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramView.d, true);
      }
      if ((this.j != null) && (this.j.getVisibility() == 0)) {
        break label110;
      }
    }
    label102:
    label110:
    while ((!bapu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) || (paramView == null) || (!paramView.jdField_a_of_type_Boolean))
    {
      return;
      int i = paramView.d;
      break;
    }
    bapu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
  }
  
  public void p()
  {
    if ((this.jdField_b_of_type_Bfyh != null) && (this.jdField_b_of_type_Bfyh.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    D();
  }
  
  public void r()
  {
    int i;
    if ((!bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i = 1;
    }
    while (i != 0)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new agqi(this));
      if (mdj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698875));
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
    ThreadManager.post(new FriendChatPie.8(this), 5, null, false);
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
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mResid)) || (!((bede)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a((MessageForStructing)localObject))) {}
    }
    if (((paramObject instanceof ChatMessage)) && (v()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.V)) {
        autt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
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
        bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, (String)localObject, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
      }
    }
    acjm.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (asyq)a(16);
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
    bu();
  }
  
  public void v()
  {
    bk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agps
 * JD-Core Version:    0.7.0.1
 */
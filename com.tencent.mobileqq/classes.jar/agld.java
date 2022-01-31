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

public class agld
  extends BaseChatPie
{
  public boolean T;
  boolean U = false;
  public boolean V;
  public boolean W;
  boolean X = false;
  private boolean Y;
  private boolean Z;
  aboe jdField_a_of_type_Aboe;
  aeko jdField_a_of_type_Aeko = new aglq(this);
  aerm jdField_a_of_type_Aerm;
  public agcb a;
  protected aguz a;
  agvb jdField_a_of_type_Agvb;
  alka jdField_a_of_type_Alka = new aglh(this);
  alox jdField_a_of_type_Alox = new aglj(this);
  private alyo jdField_a_of_type_Alyo = new aglf(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  ased jdField_a_of_type_Ased = new aglk(this);
  public aupl a;
  protected avqv a;
  private ayxx jdField_a_of_type_Ayxx = new agle(this);
  badk jdField_a_of_type_Badk = new aglp(this);
  private bfvh jdField_a_of_type_Bfvh = new aglm(this);
  protected BabyQAIOPanel a;
  private Observer jdField_a_of_type_JavaUtilObserver = new agll(this);
  private boolean aa;
  private boolean ab = true;
  private boolean ac;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aglr(this);
  public bfua b;
  Runnable jdField_b_of_type_JavaLangRunnable = new FriendChatPie.4(this);
  protected alsi c;
  private View.OnClickListener c;
  private long g;
  String h;
  protected int q = 0;
  View q;
  
  public agld(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new agls(this);
    this.jdField_a_of_type_Avqv = new aglu(this);
    this.jdField_c_of_type_Alsi = new aglg(this);
    if (paramQQAppInterface.a(165)) {
      this.jdField_b_of_type_Bfua = ((bfua)paramQQAppInterface.getManager(165));
    }
  }
  
  private void br()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(85);
    if (ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      aonf localaonf = ((aone)aogj.a().a(551)).a(4);
      if ((localaonf != null) && (localaonf.jdField_a_of_type_Boolean)) {
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
    ((aoel)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ac = true;
  }
  
  private void bu()
  {
    asuh localasuh = (asuh)a(16);
    if (localasuh != null) {
      localasuh.b();
    }
  }
  
  private void c(long paramLong)
  {
    bdyv localbdyv = (bdyv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bdyu localbdyu = localbdyv.a();
    if ((localbdyu != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localbdyu.b.equalsIgnoreCase(a())) && (localbdyu.d == 2L) && (paramLong == localbdyu.jdField_a_of_type_Long)) {
      localbdyv.a(localbdyu, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
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
        i = 2130843448;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!azib.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label132;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166898), PorterDuff.Mode.MULTIPLY);
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
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(xod.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
        this.jdField_b_of_type_AndroidViewViewGroup.setClickable(true);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
        return;
        i = 2130843455;
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
        ((Drawable)localObject).setBounds(0, 0, xod.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), xod.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
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
    aoel localaoel = (aoel)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269);
    if (this.X)
    {
      this.U = localaoel.c(str, paramIntent);
      return;
    }
    this.U = localaoel.a(str, paramIntent);
  }
  
  public void D()
  {
    if (((atla)a(32)).c()) {
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
                if (!((afbq)a(43)).c()) {
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
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166898));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166898));
              }
              for (;;)
              {
                localObject1 = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((localObject1 == null) || ((bdbt.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
                  break;
                }
                a(bdbt.b((Friends)localObject1));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aekt.a(2.0F, BaseApplicationImpl.getContext().getResources()));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(aghg.a().b(5), null, null, null);
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
                this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
                if (QLog.isDevelopLevel()) {
                  QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
                }
                c(true);
                return;
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166899));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166899));
              }
            } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
            c(false);
          } while (this.jdField_a_of_type_Agwa.a() != 5);
          aguz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Agwa.a();
          return;
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
          {
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166898));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166898));
          }
          for (;;)
          {
            localObject1 = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if ((localObject1 == null) || ((bdbt.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
              break;
            }
            a(bdbt.b((Friends)localObject1));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aekt.a(2.0F, BaseApplicationImpl.getContext().getResources()));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(agun.a().b(5), null, null, null);
            c(true);
            return;
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166899));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166899));
          }
        } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
        c(false);
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166898));
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166898));
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        if ((!bdog.a().a()) && (!awar.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
        }
        System.currentTimeMillis();
      } while ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_Bfua != null) && (this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
      localObject1 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    } while (q());
    Object localObject2 = ((aloz)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    awam localawam;
    int i;
    if ((localObject2 != null) && ((bdbt.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject2).strTermDesc)) && (((Friends)localObject2).strTermDesc.contains("TIM")))))
    {
      localawam = awaf.a().a(AppRuntime.Status.online, ((Friends)localObject2).uExtOnlineStatus);
      localObject1 = awaf.a().a(localawam);
      if ((bdbt.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) == 4) && (((Friends)localObject2).uExtOnlineStatus > 0L) && (localawam != null))
      {
        i = 1;
        label891:
        if ((i == 0) || (!awam.a(localawam.jdField_a_of_type_Long))) {
          break label1201;
        }
        if (awaf.a().a((Friends)localObject2) <= 0) {
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
        localObject1 = awaf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawam, (AppRuntime.Status)localObject1, (Friends)localObject2, this.jdField_f_of_type_AndroidWidgetTextView);
        arrayOfDrawable = this.jdField_f_of_type_AndroidWidgetTextView.getCompoundDrawables();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label1119;
        }
        c(true);
        this.jdField_h_of_type_JavaLangString = ((String)localObject1);
        a((String)localObject1);
        if (i == 0) {
          break label1088;
        }
        localObject2 = awaf.a().a(localawam, (Friends)localObject2);
        if (localObject2 != null)
        {
          i = aekt.a(4.0F, BaseApplicationImpl.getContext().getResources());
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
        localObject1 = bdbt.b((Friends)localObject2);
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
      if (this.jdField_a_of_type_Agwa.a() != 5) {
        break;
      }
      aguz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Agwa.a();
      return;
    }
  }
  
  @TargetApi(16)
  public boolean F()
  {
    Object localObject = auoa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new aglo(this);
    }
    aupa localaupa = (aupa)((Pair)localObject).first;
    localObject = (aupa)((Pair)localObject).second;
    if (localaupa != null)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaupa, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_e_of_type_AndroidWidgetImageView.setTag(localaupa);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (localObject == null) {
        break label259;
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (aupa)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(localObject);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localaupa, (aupa)localObject);
      aunx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaupa, (aupa)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateSession_updateInteractive one:" + localaupa + " two:" + localObject);
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
      abot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      abot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
    }
    if (bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((aljv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a();
    }
    this.T = false;
    super.H();
    if ((this.jdField_a_of_type_Abpd != null) && (this.jdField_a_of_type_Abpd.jdField_a_of_type_Aboo != null))
    {
      ((agse)this.jdField_a_of_type_Abpd.jdField_a_of_type_Aboo).a();
      this.jdField_a_of_type_Abpd.jdField_a_of_type_Aboo = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.a = null;
    }
    if (this.jdField_a_of_type_Agvj != null) {
      this.jdField_a_of_type_Agvj = null;
    }
    if (this.jdField_a_of_type_Aerm != null) {
      this.jdField_a_of_type_Aerm.c();
    }
    this.aa = false;
    if ((this.jdField_b_of_type_Bfua != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) || (this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_b_of_type_Bfua != null) && (this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((bfvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (((this instanceof agiy)) || (nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      if (this.jdField_b_of_type_Bfua != null) {
        break label556;
      }
    }
    label556:
    for (String str = "";; str = this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.3.3", "");
      ((uhj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253)).a();
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      ThreadManager.executeOnSubThread(new FriendChatPie.3(this));
      if (this.jdField_a_of_type_Agcb != null) {
        this.jdField_a_of_type_Agcb.b();
      }
      if (this.jdField_a_of_type_Aekn == null) {
        break;
      }
      this.jdField_a_of_type_Aekn.a(null);
      return;
    }
  }
  
  public void K()
  {
    super.K();
    if (bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((aljv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).b();
    }
  }
  
  public void M()
  {
    super.M();
    if (this.jdField_a_of_type_Aerm != null) {
      this.jdField_a_of_type_Aerm.b();
    }
  }
  
  public void N()
  {
    super.N();
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(true);
    if (this.jdField_a_of_type_Aerm != null) {
      this.jdField_a_of_type_Aerm.a();
    }
  }
  
  public aexr a()
  {
    if (!aexp.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    if ((!((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(66600000L))))
    {
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      return null;
    }
    if (!aupd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "aio intimate is close");
      }
      return null;
    }
    return new aexv(this);
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
      return bdic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new QQRecorder.RecorderParam(bdic.jdField_a_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "FriendChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (bjdl.a(this, paramInt1, paramInt2, paramIntent)) {}
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
          if (!bdee.d(BaseApplication.getContext())) {
            break label168;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
            break label142;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, false);
          localObject = new bjqr();
          ((bjqr)localObject).jdField_a_of_type_Int = 5;
          bjqq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a((bjqr)localObject);
        }
      }
      while (this.jdField_a_of_type_Abpd.jdField_a_of_type_Aboo != null)
      {
        ((agse)this.jdField_a_of_type_Abpd.jdField_a_of_type_Aboo).a(paramInt1, paramInt2, paramIntent);
        return;
        label142:
        new beqa(this.jdField_a_of_type_AndroidContentContext).a(2131693626, a(), 0, 1);
        continue;
        label168:
        new beqa(this.jdField_a_of_type_AndroidContentContext).a(2131694827, a(), 0, 1);
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
    Object localObject = this.jdField_a_of_type_Aelz.a();
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
      } while ((abot.b(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt2);
      if (!bool) {
        if (!bdee.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
        {
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697659, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          if (paramInt3 == 1) {
            afus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          }
        }
      }
      do
      {
        do
        {
          return;
          if (agsd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
            }
            this.jdField_a_of_type_Aboe.a(paramLong1, paramLong2, false);
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramMessageRecord, 10);
            return;
          }
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698122, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        } while (paramInt3 != 1);
        afus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
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
        if ((abot.b(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips))) {}
      }
      for (;;)
      {
        if ((paramMessageRecord != null) && (!aslq.a(paramMessageRecord)))
        {
          paramInt2 = this.jdField_a_of_type_Aelz.a(paramMessageRecord.uniseq);
          if (paramInt2 != -1)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
            return;
            paramInt2 += 1;
            break label460;
          }
          if (paramMessageRecord.msgtype == -2006) {
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, alpo.a(2131705245), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
          if (paramInt3 != 1) {
            break;
          }
          afus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698122, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        if (paramInt3 != 1) {
          break;
        }
        afus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(aghg.a().a(2130849463));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849504);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849991);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aghg.a().b(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aghg.a().b(2));
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(agun.a().a(2130849463));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849504);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849991);
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(agun.a().b(2));
        }
        else
        {
          this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(agun.a().b(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849463);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849503, 2130849504);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849990, 2130849991);
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
    if (paramView.getId() == 2131377144)
    {
      if (this.q == 1) {
        ((atla)a(32)).b();
      }
      while (this.q != 2) {
        return;
      }
      ((afbq)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    super.a(paramView);
  }
  
  public void a(appw paramappw)
  {
    super.a(paramappw);
    if (this.Y)
    {
      agsb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
    do
    {
      do
      {
        return;
      } while (i != 8);
      paramObject = ((aone)aogj.a().a(551)).a(4);
    } while ((paramObject == null) || (paramObject.d <= 0));
    if (paramObject.c == 1) {}
    for (i = 1109995692;; i = paramObject.d)
    {
      ((atal)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    asuh localasuh = (asuh)a(16);
    if (localasuh != null) {
      localasuh.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    axwx localaxwx = (axwx)a(45);
    if ((localaxwx != null) && (localaxwx.a(paramBoolean, paramString))) {
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
    if (((this.jdField_a_of_type_Aelz != null) && (this.jdField_a_of_type_Aelz.getCount() > 0)) || (!bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_Aboe.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        ((aemc)this.jdField_a_of_type_Abpd.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Abpd.e = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Abpd, this.jdField_a_of_type_Aboe, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_Aboe.jdField_b_of_type_Boolean = false;
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
        if (!bcyw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localIntent)) {
          break label285;
        }
        QQToast.a(a(), 2, 2131719795, 0).b(a());
        if (bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.U = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.U) {
        h(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.U;
      this.jdField_a_of_type_Aboe = new aboe();
      this.jdField_a_of_type_Aerm = new aesb(a());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Aupl = new aupl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return super.a(paramBoolean);
      label285:
      QQToast.a(a(), 1, 2131719794, 0).b(a());
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
    if (azib.b())
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
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167037));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void ag()
  {
    bdjd.a(null, "AIO_onShow_business");
    super.ag();
    acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.Z = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.Y = agsb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    bdjd.a("AIO_onShow_business", null);
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
        bool2 = bdog.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
        if (((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          acex.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
            acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
            acex.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            acex.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            acex.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            acex.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alyo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ased);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayxx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Avqv);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfvh);
    ((askw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alka);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Badk);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ased);
    if (this.jdField_a_of_type_Ayxx != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxx);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Avqv);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alyo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bfvh);
    ((askw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alka);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Badk);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    F();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.L);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new agln(this));
  }
  
  public void bA()
  {
    Object localObject = bcyw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
    localAllInOne.jdField_h_of_type_JavaLangString = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localAllInOne.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localAllInOne.g = 2;
    localAllInOne.jdField_h_of_type_Int = 117;
    awmk localawmk = new awmk();
    localawmk.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    localObject = anvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawmk);
    bcyw.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void bB()
  {
    if (this.jdField_a_of_type_Agcb == null) {
      this.jdField_a_of_type_Agcb = new agcb(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_Agcb.a(1);
    this.jdField_a_of_type_Agcb.a();
  }
  
  public void bC()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null)) {}
    for (;;)
    {
      return;
      Object localObject = (atla)a(32);
      boolean bool1 = ((atla)localObject).c();
      boolean bool2 = ((atla)localObject).d();
      afbq localafbq = (afbq)a(43);
      boolean bool3 = localafbq.c();
      int i;
      if (bool1)
      {
        this.q = 1;
        c(true);
        a(((atla)localObject).a(bool2));
        e(bool2, false);
        i = aekt.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        atkt.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.q = 2;
          c(true);
          bool3 = localafbq.a();
          a(localafbq.a());
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166898));
          e(bool3, localafbq.d());
          localObject = (axwx)a(45);
          i = aekt.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
          atkt.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
        }
        else
        {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
          this.jdField_b_of_type_AndroidViewViewGroup.setClickable(false);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          atkt.a(this.jdField_b_of_type_AndroidViewViewGroup);
          this.q = 0;
          a("");
          D();
          localObject = (axwx)a(45);
          if (localObject != null) {
            ((axwx)localObject).b("");
          }
        }
      }
    }
  }
  
  public void bp()
  {
    super.bp();
    Object localObject1 = "";
    Object localObject2 = bcyw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Afag.a(this);
  }
  
  public void c()
  {
    super.c();
    if (this.Y)
    {
      agsb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
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
    if (!bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Abpd.jdField_a_of_type_Aboo = new agse(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_b_of_type_Bfua != null) && (this.jdField_b_of_type_Bfua.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_b_of_type_Bfua != null) && (this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
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
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (agsb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
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
      if (this.jdField_a_of_type_Aerm != null)
      {
        this.jdField_a_of_type_Aerm.a(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_Aerm != null)
      {
        this.jdField_a_of_type_Aerm.a(2);
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
      if ((this.jdField_a_of_type_Aerm != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_Aerm.a(3, paramMessage[0], paramMessage[1]);
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
    afvf.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aekn != null) {
      this.jdField_a_of_type_Aekn.a(this.jdField_a_of_type_Aeko);
    }
  }
  
  public boolean i()
  {
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (agsb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
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
    if (this.jdField_a_of_type_Agvj == null) {
      this.jdField_a_of_type_Agvj = new agvj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agwa, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Agvb = new agvb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agwa, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Agwa.a(this.jdField_a_of_type_Agvj);
    this.jdField_a_of_type_Agwa.a(this.jdField_a_of_type_Agvb);
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    if (nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_Bfua = ((bfua)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    bs();
    if (bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (aljv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if ((localObject != null) && (((aljv)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        ((aljv)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof agiy)) || (nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      aL();
      if (this.jdField_b_of_type_Bfua != null) {
        break label238;
      }
    }
    label238:
    for (Object localObject = "";; localObject = this.jdField_b_of_type_Bfua.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.3.3", "");
      ThreadManager.post(new FriendChatPie.20(this), 5, null, true);
      bB();
      aybc.b(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131368627)
    {
      paramView = ((aone)aogj.a().a(551)).a(4);
      if ((paramView != null) && (paramView.d > 0))
      {
        if (paramView.c != 1) {
          break label102;
        }
        ((atal)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramView.d, true);
      }
      if ((this.j != null) && (this.j.getVisibility() == 0)) {
        break label110;
      }
    }
    label102:
    label110:
    while ((!ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) || (paramView == null) || (!paramView.jdField_a_of_type_Boolean))
    {
      return;
      int i = paramView.d;
      break;
    }
    ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
  }
  
  public void p()
  {
    if ((this.jdField_b_of_type_Bfua != null) && (this.jdField_b_of_type_Bfua.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    D();
  }
  
  public void r()
  {
    int i;
    if ((!bdal.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i = 1;
    }
    while (i != 0)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new aglt(this));
      if (mdj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698863));
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
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mResid)) || (!((bdyv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a((MessageForStructing)localObject))) {}
    }
    if (((paramObject instanceof ChatMessage)) && (v()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.V)) {
        aupk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
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
        bdvp.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, (String)localObject, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
      }
    }
    acex.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (asuh)a(16);
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
 * Qualified Name:     agld
 * JD-Core Version:    0.7.0.1
 */
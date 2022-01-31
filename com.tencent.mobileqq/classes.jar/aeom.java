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
import com.tencent.mobileqq.utils.VipUtils;
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

public class aeom
  extends BaseChatPie
{
  public boolean T;
  boolean U = false;
  public boolean V;
  public boolean W;
  boolean X = false;
  private boolean Y;
  private boolean Z;
  acte jdField_a_of_type_Acte = new aeoz(this);
  aczw jdField_a_of_type_Aczw;
  public aefn a;
  protected aexu a;
  aexw jdField_a_of_type_Aexw;
  ajsn jdField_a_of_type_Ajsn = new aeoq(this);
  ajxj jdField_a_of_type_Ajxj = new aeos(this);
  private akgy jdField_a_of_type_Akgy = new aeoo(this);
  akou jdField_a_of_type_Akou;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  aqkn jdField_a_of_type_Aqkn = new aeot(this);
  public asyo a;
  protected atzr a;
  private axct jdField_a_of_type_Axct = new aeon(this);
  ayfn jdField_a_of_type_Ayfn = new aeoy(this);
  private bdvm jdField_a_of_type_Bdvm = new aeov(this);
  protected BabyQAIOPanel a;
  private Observer jdField_a_of_type_JavaUtilObserver = new aeou(this);
  private boolean aa;
  private boolean ab = true;
  private boolean ac;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aepa(this);
  public bduf b;
  Runnable jdField_b_of_type_JavaLangRunnable = new FriendChatPie.4(this);
  protected akat c;
  private View.OnClickListener c;
  private long g;
  String h;
  protected int q = 0;
  View q;
  
  public aeom(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new aepb(this);
    this.jdField_a_of_type_Atzr = new aepd(this);
    this.jdField_c_of_type_Akat = new aeop(this);
    if (paramQQAppInterface.a(165)) {
      this.jdField_b_of_type_Bduf = ((bduf)paramQQAppInterface.getManager(165));
    }
  }
  
  private void bo()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(85);
    if (aynp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      amwa localamwa = ((amvz)ampl.a().a(551)).a(4);
      if ((localamwa != null) && (localamwa.jdField_a_of_type_Boolean)) {
        localMessage.arg1 = 1;
      }
    }
    localMessage.sendToTarget();
  }
  
  private void bp()
  {
    ThreadManager.post(new FriendChatPie.21(this), 5, null, false);
  }
  
  private void bq()
  {
    if (this.ac) {
      return;
    }
    ((amnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ac = true;
  }
  
  private void br()
  {
    ardt localardt = (ardt)a(16);
    if (localardt != null) {
      localardt.b();
    }
  }
  
  private void c(long paramLong)
  {
    bbzu localbbzu = (bbzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    bbzt localbbzt = localbbzu.a();
    if ((localbbzt != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && (localbbzt.b.equalsIgnoreCase(a())) && (localbbzt.d == 2L) && (paramLong == localbbzt.jdField_a_of_type_Long)) {
      localbbzu.a(localbbzt, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
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
        i = 2130843265;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!axmv.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label132;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851), PorterDuff.Mode.MULTIPLY);
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
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(vzl.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
        this.jdField_b_of_type_AndroidViewViewGroup.setClickable(true);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
        return;
        i = 2130843272;
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
        ((Drawable)localObject).setBounds(0, 0, vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
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
    amnn localamnn = (amnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269);
    if (this.X)
    {
      this.U = localamnn.c(str, paramIntent);
      return;
    }
    this.U = localamnn.a(str, paramIntent);
  }
  
  public void D()
  {
    if (((aruf)a(32)).c()) {
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
                if (!((adji)a(43)).c()) {
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
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166851));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166851));
              }
              for (;;)
              {
                localObject1 = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                if ((localObject1 == null) || ((bbcz.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
                  break;
                }
                a(bbcz.b((Friends)localObject1));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actj.a(2.0F, BaseApplicationImpl.getContext().getResources()));
                this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(aekp.a().b(5), null, null, null);
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
                this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
                if (QLog.isDevelopLevel()) {
                  QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
                }
                c(true);
                return;
                this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166852));
                this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166852));
              }
            } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
            c(false);
          } while (this.jdField_a_of_type_Aeyv.a() != 5);
          aexu.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Aeyv.a();
          return;
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
          {
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166851));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166851));
          }
          for (;;)
          {
            localObject1 = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if ((localObject1 == null) || ((bbcz.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 0) && (TextUtils.isEmpty(((Friends)localObject1).strTermDesc)))) {
              break;
            }
            a(bbcz.b((Friends)localObject1));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actj.a(2.0F, BaseApplicationImpl.getContext().getResources()));
            this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(aexi.a().b(5), null, null, null);
            c(true);
            return;
            this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166852));
            this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166852));
          }
        } while (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0);
        c(false);
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166851));
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166851));
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        if (!bbpm.a().a()) {
          break;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
        }
        System.currentTimeMillis();
      } while ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_Bduf != null) && (this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
      localObject1 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    } while (q());
    Object localObject2 = ((ajxl)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    aujj localaujj;
    int i;
    if ((localObject2 != null) && ((bbcz.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject2).strTermDesc)) && (((Friends)localObject2).strTermDesc.contains("TIM")))))
    {
      localaujj = aujc.a().a(AppRuntime.Status.online, ((Friends)localObject2).uExtOnlineStatus);
      localObject1 = aujc.a().a(localaujj);
      if ((bbcz.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType) == 4) && (((Friends)localObject2).uExtOnlineStatus > 0L) && (localaujj != null))
      {
        i = 1;
        label871:
        if ((i == 0) || (!aujj.a(localaujj.jdField_a_of_type_Long))) {
          break label1177;
        }
        if (aujc.a().a((Friends)localObject2) <= 0) {
          break label1051;
        }
        i = 1;
      }
    }
    label898:
    label917:
    label1177:
    for (;;)
    {
      Drawable[] arrayOfDrawable;
      if (i != 0)
      {
        localObject1 = aujc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaujj, (AppRuntime.Status)localObject1, (Friends)localObject2);
        arrayOfDrawable = this.jdField_f_of_type_AndroidWidgetTextView.getCompoundDrawables();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label1095;
        }
        c(true);
        this.jdField_h_of_type_JavaLangString = ((String)localObject1);
        a((String)localObject1);
        if (i == 0) {
          break label1064;
        }
        localObject2 = aujc.a().a(localaujj, (Friends)localObject2);
        if (localObject2 != null)
        {
          i = actj.a(4.0F, BaseApplicationImpl.getContext().getResources());
          this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
          this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
        }
      }
      for (;;)
      {
        if (!S) {
          break label1093;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        return;
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(null);
        break;
        i = 0;
        break label871;
        label1051:
        i = 0;
        break label898;
        localObject1 = bbcz.b((Friends)localObject2);
        break label917;
        label1064:
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      }
      label1093:
      break;
      label1095:
      c(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break;
      }
      c(false);
      if (this.jdField_a_of_type_Aeyv.a() != 5) {
        break;
      }
      aexu.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aeyv.a();
      return;
    }
  }
  
  @TargetApi(16)
  public boolean E()
  {
    Object localObject = asxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new aeox(this);
    }
    asyd localasyd = (asyd)((Pair)localObject).first;
    localObject = (asyd)((Pair)localObject).second;
    if (localasyd != null)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localasyd, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_e_of_type_AndroidWidgetImageView.setTag(localasyd);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (localObject == null) {
        break label259;
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (asyd)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "C2C_show");
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(localObject);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localasyd, (asyd)localObject);
      asxa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localasyd, (asyd)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateSession_updateInteractive one:" + localasyd + " two:" + localObject);
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
      bq();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      akpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      akpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4022);
    }
    if (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((ajsi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a();
    }
    this.T = false;
    super.G();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acur != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acur.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acur.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acur.a = null;
    }
    if (this.jdField_a_of_type_Aeye != null) {
      this.jdField_a_of_type_Aeye = null;
    }
    if (this.jdField_a_of_type_Aczw != null) {
      this.jdField_a_of_type_Aczw.c();
    }
    this.aa = false;
    if ((this.jdField_b_of_type_Bduf != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) || (this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_b_of_type_Bduf != null) && (this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((bdvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (((this instanceof aemh)) || (myv.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      if (this.jdField_b_of_type_Bduf != null) {
        break label518;
      }
    }
    label518:
    for (String str = "";; str = this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.3.0", "");
      ((ssr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253)).a();
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      ThreadManager.executeOnSubThread(new FriendChatPie.3(this));
      if (this.jdField_a_of_type_Aefn != null) {
        this.jdField_a_of_type_Aefn.b();
      }
      if (this.jdField_a_of_type_Actd == null) {
        break;
      }
      this.jdField_a_of_type_Actd.a(null);
      return;
    }
  }
  
  public void J()
  {
    super.J();
    if (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((ajsi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).b();
    }
  }
  
  public void L()
  {
    super.L();
    if (this.jdField_a_of_type_Aczw != null) {
      this.jdField_a_of_type_Aczw.b();
    }
  }
  
  public void M()
  {
    super.M();
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(true);
    if (this.jdField_a_of_type_Aczw != null) {
      this.jdField_a_of_type_Aczw.a();
    }
  }
  
  public adfp a()
  {
    if (!adfn.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    if ((!((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(66600000L))))
    {
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      return null;
    }
    if (!asyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "aio intimate is close");
      }
      return null;
    }
    return new adfs(this);
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 29)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558530, null));
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
      return bbjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    return new QQRecorder.RecorderParam(bbjg.jdField_a_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "FriendChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (bhcb.a(this, paramInt1, paramInt2, paramIntent)) {}
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
      if (bbfj.d(BaseApplication.getContext()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
          paramIntent = new bhpg();
          paramIntent.jdField_a_of_type_Int = 5;
          bhpf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(paramIntent);
          return;
        }
        new bcqr(this.jdField_a_of_type_AndroidContentContext).a(2131693525, a(), 0, 1);
        return;
      }
      new bcqr(this.jdField_a_of_type_AndroidContentContext).a(2131694671, a(), 0, 1);
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
    paramMessageRecord = new FriendChatPie.17(this);
    Object localObject = this.jdField_a_of_type_Acup.a();
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
      } while ((akpx.b(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt2);
      if (!bool) {
        if (!bbfj.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
        {
          bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697484, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          if (paramInt3 == 1) {
            adyf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          }
        }
      }
      do
      {
        do
        {
          return;
          if (aevd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong2, paramLong1) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
            }
            this.jdField_a_of_type_Akou.a(paramLong1, paramLong2, false);
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramMessageRecord, 10);
            return;
          }
          bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697945, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        } while (paramInt3 != 1);
        adyf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
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
        if ((akpx.b(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips))) {}
      }
      for (;;)
      {
        if ((paramMessageRecord != null) && (!aqvc.a(paramMessageRecord)))
        {
          paramInt2 = this.jdField_a_of_type_Acup.a(paramMessageRecord.uniseq);
          if (paramInt2 != -1)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
            return;
            paramInt2 += 1;
            break label460;
          }
          if (paramMessageRecord.msgtype == -2006) {
            bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ajya.a(2131704873), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
          if (paramInt3 != 1) {
            break;
          }
          adyf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
          return;
        }
        bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697945, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        if (paramInt3 != 1) {
          break;
        }
        adyf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(aekp.a().a(2130849032));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849073);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849551);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aekp.a().b(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(aekp.a().b(2));
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(aexi.a().a(2130849032));
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849073);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849551);
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(aexi.a().b(2));
        }
        else
        {
          this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(aexi.a().b(2));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130849032);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130849072, 2130849073);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130849550, 2130849551);
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
    if (paramView.getId() == 2131376634)
    {
      if (this.q == 1) {
        ((aruf)a(32)).b();
      }
      while (this.q != 2) {
        return;
      }
      ((adji)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    super.a(paramView);
  }
  
  public void a(anyh paramanyh)
  {
    super.a(paramanyh);
    if (this.Y)
    {
      aevb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
    do
    {
      do
      {
        return;
      } while (i != 8);
      paramObject = ((amvz)ampl.a().a(551)).a(4);
    } while ((paramObject == null) || (paramObject.d <= 0));
    if (paramObject.c == 1) {}
    for (i = 1109995692;; i = paramObject.d)
    {
      ((arjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    ardt localardt = (ardt)a(16);
    if (localardt != null) {
      localardt.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    awbu localawbu = (awbu)a(45);
    if ((localawbu != null) && (localawbu.a(paramBoolean, paramString))) {
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
    if ((this.jdField_a_of_type_Acup != null) && (this.jdField_a_of_type_Acup.getCount() > 0))
    {
      if (this.jdField_a_of_type_Akou.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        ((acus)this.jdField_a_of_type_Akqr.a).a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Akqr.e = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Akqr, this.jdField_a_of_type_Akou, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_Akou.jdField_b_of_type_Boolean = false;
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
        if (!bbac.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localIntent)) {
          break label285;
        }
        bcql.a(a(), 2, 2131719314, 0).b(a());
        if (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.U = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.U) {
        h(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j = this.U;
      this.jdField_a_of_type_Akou = new akou();
      this.jdField_a_of_type_Aczw = new adal(a());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Asyo = new asyo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return super.a(paramBoolean);
      label285:
      bcql.a(a(), 1, 2131719313, 0).b(a());
    }
  }
  
  public void aS()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "==refreshTitleReativeIcon==");
    }
    E();
  }
  
  public void aX()
  {
    super.aX();
    if (axmv.b())
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
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void ae()
  {
    bbkj.a(null, "AIO_onShow_business");
    super.ae();
    aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.Z = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.Y = aevb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    bbkj.a("AIO_onShow_business", null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!naz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
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
        bool2 = bbpm.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
        super.af();
        if (((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          aanz.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          bo();
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
            aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
            aanz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            aanz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            aanz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            aanz.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akgy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqkn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axct);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atzr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdvm);
    ((aqui)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayfn);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqkn);
    if (this.jdField_a_of_type_Axct != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axct);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atzr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akgy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdvm);
    ((aqui)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayfn);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    E();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.L);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new aeow(this));
  }
  
  public void bn()
  {
    super.bn();
    Object localObject1 = "";
    Object localObject2 = bbac.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  public void bx()
  {
    Object localObject = bbac.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
    localAllInOne.jdField_h_of_type_JavaLangString = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localAllInOne.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localAllInOne.g = 2;
    localAllInOne.jdField_h_of_type_Int = 117;
    auuy localauuy = new auuy();
    localauuy.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    localObject = amev.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localauuy);
    bbac.a(a(), (BusinessCard)localObject, localAllInOne);
  }
  
  public void by()
  {
    if (this.jdField_a_of_type_Aefn == null) {
      this.jdField_a_of_type_Aefn = new aefn(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_Aefn.a(1);
    this.jdField_a_of_type_Aefn.a();
  }
  
  public void bz()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null)) {}
    for (;;)
    {
      return;
      Object localObject = (aruf)a(32);
      boolean bool1 = ((aruf)localObject).c();
      boolean bool2 = ((aruf)localObject).d();
      adji localadji = (adji)a(43);
      boolean bool3 = localadji.c();
      int i;
      if (bool1)
      {
        this.q = 1;
        c(true);
        a(((aruf)localObject).a(bool2));
        e(bool2, false);
        i = actj.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        arty.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.q = 2;
          c(true);
          bool3 = localadji.a();
          a(localadji.a());
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
          e(bool3, localadji.d());
          localObject = (awbu)a(45);
          i = actj.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
          arty.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, i, 0, 0);
        }
        else
        {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setClickable(true);
          this.jdField_b_of_type_AndroidViewViewGroup.setClickable(false);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          arty.a(this.jdField_b_of_type_AndroidViewViewGroup);
          this.q = 0;
          a("");
          D();
          localObject = (awbu)a(45);
          if (localObject != null) {
            ((awbu)localObject).b("");
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
      aevb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.Y);
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
    if ((this.jdField_b_of_type_Bduf != null) && (this.jdField_b_of_type_Bduf.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    if ((this.jdField_b_of_type_Bduf != null) && (this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      naz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aevb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.U) {
      bq();
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
      if (this.jdField_a_of_type_Aczw != null)
      {
        this.jdField_a_of_type_Aczw.a(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_Aczw != null)
      {
        this.jdField_a_of_type_Aczw.a(2);
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
      if ((this.jdField_a_of_type_Aczw != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_Aczw.a(3, paramMessage[0], paramMessage[1]);
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
    adyr.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Actd != null) {
      this.jdField_a_of_type_Actd.a(this.jdField_a_of_type_Acte);
    }
  }
  
  public boolean i()
  {
    if ((this.Z) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aevb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return true;
    }
    if (this.U) {
      bq();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Aeye == null) {
      this.jdField_a_of_type_Aeye = new aeye(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Aexw = new aexw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aeye);
    this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aexw);
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
    if (myv.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_Bduf = ((bduf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    }
    asyn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    bp();
    if (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (ajsi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if ((localObject != null) && (((ajsi)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        ((ajsi)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof aemh)) || (myv.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      aJ();
      if (this.jdField_b_of_type_Bduf != null) {
        break label238;
      }
    }
    label238:
    for (Object localObject = "";; localObject = this.jdField_b_of_type_Bduf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.3.0", "");
      ThreadManager.post(new FriendChatPie.20(this), 5, null, true);
      by();
      awfz.b(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131368441)
    {
      paramView = ((amvz)ampl.a().a(551)).a(4);
      if ((paramView != null) && (paramView.d > 0))
      {
        if (paramView.c != 1) {
          break label102;
        }
        ((arjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(348)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramView.d, true);
      }
      if ((this.j != null) && (this.j.getVisibility() == 0)) {
        break label110;
      }
    }
    label102:
    label110:
    while ((!aynp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) || (paramView == null) || (!paramView.jdField_a_of_type_Boolean))
    {
      return;
      int i = paramView.d;
      break;
    }
    aynp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
  }
  
  public void p()
  {
    if ((this.jdField_b_of_type_Bduf != null) && (this.jdField_b_of_type_Bduf.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    D();
  }
  
  public void s()
  {
    int i;
    if ((!bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      i = 1;
    }
    while (i != 0)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new aepc(this));
      if (mau.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698567));
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
      if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (((MessageForStructing)localObject).structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mResid)) || (!((bbzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a((MessageForStructing)localObject))) {}
    }
    if (((paramObject instanceof ChatMessage)) && (v()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.V)) {
        asyn.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
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
        bbwo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, (String)localObject, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
      }
    }
    aanz.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (ardt)a(16);
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
    br();
  }
  
  public void v()
  {
    bi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeom
 * JD-Core Version:    0.7.0.1
 */
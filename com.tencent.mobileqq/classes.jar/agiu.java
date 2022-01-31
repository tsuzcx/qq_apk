import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class agiu
  extends BaseChatPie
  implements aeqw
{
  protected boolean T;
  protected boolean U;
  public boolean V;
  protected boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  protected amjj a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  public bcco a;
  public TroopAIORobotLayout a;
  protected long g;
  public String g;
  public String h;
  
  public agiu(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Amjj = new agiw(this);
  }
  
  public void A()
  {
    String str = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bdbt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
  }
  
  public boolean E()
  {
    return this.N;
  }
  
  public boolean F()
  {
    return false;
  }
  
  public boolean G()
  {
    return this.V;
  }
  
  @TargetApi(16)
  public void H()
  {
    if (this.N)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_Bblx != null) {
      this.jdField_a_of_type_Bblx.a();
    }
    if (this.jdField_a_of_type_Bcco != null)
    {
      this.jdField_a_of_type_Bcco.b();
      this.jdField_a_of_type_Bcco = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label136;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      br();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(false);
      }
      afby localafby = (afby)this.jdField_a_of_type_Afag.a(23);
      if (localafby != null) {
        localafby.c();
      }
      super.H();
      return;
      label136:
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void L()
  {
    if (!this.N)
    {
      Object localObject = (aubr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localObject != null)
      {
        ((aubr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
        if (this.jdField_a_of_type_Bblx != null)
        {
          localObject = this.jdField_a_of_type_Bblx.a();
          if (localObject != null) {
            ((bblr)localObject).a.set(false);
          }
        }
      }
    }
    super.L();
  }
  
  public void M()
  {
    super.M();
    if (this.jdField_a_of_type_Bblx != null) {
      this.jdField_a_of_type_Bblx.i();
    }
  }
  
  public void P()
  {
    super.P();
    bs();
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131559057, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = this.K;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.f = this.K;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c = this.K;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight(), this.jdField_e_of_type_JavaLangString, this.o, this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      if (this.V) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.V);
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    return super.a(paramInt);
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.u();
    return bdic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "BaseTroopChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    afcc localafcc = (afcc)a(53);
    aezp localaezp = (aezp)a(52);
    if ((localafcc != null) && (localaezp != null) && (localaezp.jdField_a_of_type_Boolean) && (localafcc.a())) {
      localaezp.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.V)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131376758).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    afby localafby = (afby)this.jdField_a_of_type_Afag.a(23);
    if (localafby != null) {
      localafby.a(paramIntent);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    afby localafby = (afby)this.jdField_a_of_type_Afag.a(23);
    if ((localafby != null) && (localafby.a(paramMotionEvent, this.L))) {
      return;
    }
    super.a(paramMotionEvent);
  }
  
  public void a(SessionInfo paramSessionInfo, atvk paramatvk, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      paramCharSequence = bceh.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    }
    for (;;)
    {
      String str = null;
      if (localArrayList.size() > 0) {
        str = bceh.a(localArrayList);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        ThreadManager.post(new SaveTextDraftJob(this, paramSessionInfo, paramatvk, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131373095), str), 8, null, false);
      }
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((bcjl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l);
    BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
    return;
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l)
    {
      if ("0".equals(paramString1))
      {
        BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.i = paramString1;
      this.jdField_e_of_type_Int = 131077;
      e(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(alpo.a(2131701432));
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.4(this), 200L);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.5(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_f_of_type_AndroidViewView != null) {
      super.a(paramBoolean1, paramBoolean2);
    }
    Object localObject;
    do
    {
      return;
      super.a(paramBoolean1, paramBoolean2);
      localObject = (afby)this.jdField_a_of_type_Afag.a(23);
      if (localObject != null) {
        ((afby)localObject).a(this.jdField_f_of_type_AndroidViewView);
      }
      localObject = (aezp)a(52);
    } while (localObject == null);
    ((aezp)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_f_of_type_AndroidViewView);
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_Aelz.getCount() > 0)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((aemc)this.jdField_a_of_type_Abpd.a).a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Bblx != null) {
        if (this.jdField_a_of_type_Bblx.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Abpd.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Bblx.jdField_a_of_type_Long, this.jdField_a_of_type_Bblx.jdField_b_of_type_Long, this.jdField_a_of_type_Bblx.c, this.jdField_a_of_type_Abpd);
          this.jdField_a_of_type_Bblx.j();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Abpd.e = false;
      this.jdField_a_of_type_Abpd.f = true;
      if (!this.U)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Abpd);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Abpd);
      this.U = false;
      break;
      this.jdField_a_of_type_Abpd.e = false;
      this.jdField_a_of_type_Abpd.f = true;
      if (!this.U)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Abpd);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Abpd);
      this.U = false;
      break;
      g(false);
    }
  }
  
  public void as()
  {
    super.as();
    this.c = "";
  }
  
  public void at_() {}
  
  public void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(new bahs(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 32).a());
      if (AppSetting.c)
      {
        paramIntent = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
      }
      return;
      A();
    }
  }
  
  protected void b(Object paramObject)
  {
    paramObject = (bbla)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleUpdateTroopAioAgentMessage: " + paramObject.jdField_a_of_type_Int);
      }
      if (paramObject.jdField_a_of_type_Int != bbkz.jdField_a_of_type_Int) {
        break label74;
      }
      a(paramObject.c, paramObject.a(), paramObject.d, null);
    }
    label74:
    while ((paramObject.jdField_a_of_type_Int != bbkz.b) || (this.jdField_f_of_type_AndroidViewView == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObject.b);
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_Bblx != null) {
      this.jdField_a_of_type_Bblx.a();
    }
    return super.b(paramInt);
  }
  
  public void bq()
  {
    super.bq();
    this.jdField_a_of_type_Afag.a(this);
  }
  
  protected void br()
  {
    o(0);
  }
  
  protected void bs()
  {
    this.g = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131721025));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void bt()
  {
    if (this.jdField_a_of_type_Bblx == null) {
      this.jdField_a_of_type_Bblx = new bblx();
    }
    this.jdField_a_of_type_Bblx.h();
    this.jdField_a_of_type_Bblx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aelz, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Bblx != null) && (this.jdField_a_of_type_Agwa.a() != 9)) {
      this.jdField_a_of_type_Bblx.e();
    }
    bu();
  }
  
  void bu()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleGrayTipsMsg");
    }
    Object localObject = (bclk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((bclk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new BaseTroopChatPie.3(this, (bclk)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void bv()
  {
    f(true);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
      this.d.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.V)) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.d.setTextSize(1, 17.0F);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new agiv(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166898));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166898));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166895));
    afby localafby = (afby)this.jdField_a_of_type_Afag.a(23);
    if (localafby != null) {
      localafby.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.a(this);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bblx != null) {
      this.jdField_a_of_type_Bblx.a();
    }
    super.f(paramBoolean);
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void i(int paramInt)
  {
    super.i(paramInt);
    Object localObject = (afby)this.jdField_a_of_type_Afag.a(23);
    if (localObject != null) {
      ((afby)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = (aezp)a(52);
    if (localObject != null) {
      ((aezp)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_Bblx != null) {
      this.jdField_a_of_type_Bblx.a();
    }
    return super.i();
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_Bcco == null) || (!this.jdField_a_of_type_Bcco.a())) {
      return;
    }
    this.jdField_a_of_type_Bcco.a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if ((this.jdField_a_of_type_Bblx != null) && (this.jdField_a_of_type_Bblx.d()) && (this.jdField_a_of_type_Aelz != null) && (!this.jdField_a_of_type_Bblx.a().a.get()))
    {
      if ((!bblr.a(this.jdField_a_of_type_Bblx.b())) || (paramInt2 <= 0)) {
        break label239;
      }
      List localList = this.jdField_a_of_type_Aelz.a();
      int k = localList.size();
      int m = paramInt1 + paramInt2 - j - i;
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + i + ",headerCnt = " + j + ", listSize = " + k);
      }
      if ((paramInt1 >= 0) && (paramInt1 <= m) && (m < k))
      {
        localList = localList.subList(paramInt1, m);
        this.jdField_a_of_type_Bblx.b(localList);
      }
    }
    for (;;)
    {
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label239:
      this.jdField_a_of_type_Bblx.b(0);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.jdField_a_of_type_Bbpl != null)
      {
        if ((this.jdField_a_of_type_Bbpl.d == bbpl.c) && (this.jdField_a_of_type_Bbpl.a != null)) {
          a(this.jdField_a_of_type_Bbpl.a.c, this.jdField_a_of_type_Bbpl.a.a(), this.jdField_a_of_type_Bbpl.a.d, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString + ".trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_Bbpl.d);
        }
        this.jdField_a_of_type_Bbpl = null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteObservers();
      }
    }
    while (!(paramObject instanceof bbla)) {
      return;
    }
    b(paramObject);
  }
  
  public void z()
  {
    if ((this.V) || (this.W))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843237);
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849497, 2130849498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agiu
 * JD-Core Version:    0.7.0.1
 */
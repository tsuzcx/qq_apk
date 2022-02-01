import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Spanned;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
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
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aihd
  extends BaseChatPie
  implements aglx
{
  protected boolean S;
  protected boolean T;
  public boolean U;
  protected boolean V;
  public boolean W;
  public boolean X;
  public boolean Y;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  public bghm a;
  protected ProxyObserver a;
  public TroopAIORobotLayout a;
  protected long e;
  public String g;
  public String h;
  
  public aihd(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new aihf(this);
  }
  
  public void A()
  {
    String str = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
  }
  
  public boolean E()
  {
    return this.M;
  }
  
  public boolean F()
  {
    return false;
  }
  
  public boolean G()
  {
    return this.U;
  }
  
  @TargetApi(16)
  public void H()
  {
    if (this.M)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_Bfpy != null) {
      this.jdField_a_of_type_Bfpy.a();
    }
    if (this.jdField_a_of_type_Bghm != null)
    {
      this.jdField_a_of_type_Bghm.b();
      this.jdField_a_of_type_Bghm = null;
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
      bo();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(false);
      }
      agwy localagwy = (agwy)this.jdField_a_of_type_Aguw.a(23);
      if (localagwy != null) {
        localagwy.b();
      }
      super.H();
      return;
      label136:
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void L()
  {
    if (!this.M)
    {
      Object localObject = (bgiw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(363);
      if (localObject != null)
      {
        ((bgiw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
        if (this.jdField_a_of_type_Bfpy != null)
        {
          localObject = this.jdField_a_of_type_Bfpy.a();
          if (localObject != null) {
            ((bgia)localObject).a.set(false);
          }
        }
      }
    }
    super.L();
  }
  
  public void M()
  {
    super.M();
    if (this.jdField_a_of_type_Bfpy != null) {
      this.jdField_a_of_type_Bfpy.i();
    }
  }
  
  public void P()
  {
    super.P();
    bp();
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131559123, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      EmoticonMainPanel localEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      if ((A()) || (this.J)) {}
      for (boolean bool = true;; bool = false)
      {
        localEmoticonMainPanel.jdField_b_of_type_Boolean = bool;
        if (A()) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setHideAllSettingTabs(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.f = this.J;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c = this.J;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight(), this.jdField_e_of_type_JavaLangString, this.o, this);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        if (this.U) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.U);
        }
        return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      }
    }
    return super.a(paramInt);
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.u();
    return bhrp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "BaseTroopChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    agxc localagxc = (agxc)a(53);
    agwg localagwg = (agwg)a(52);
    if ((localagxc != null) && (localagwg != null) && (localagwg.b()) && (localagxc.a())) {
      localagwg.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.U)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377779).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    agwy localagwy = (agwy)this.jdField_a_of_type_Aguw.a(23);
    if (localagwy != null) {
      localagwy.a(paramIntent);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    agwy localagwy = (agwy)this.jdField_a_of_type_Aguw.a(23);
    if ((localagwy != null) && (localagwy.a(paramMotionEvent, this.K))) {
      return;
    }
    super.a(paramMotionEvent);
  }
  
  public void a(SessionInfo paramSessionInfo, awzu paramawzu, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      paramSpanned = bgme.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        paramString2 = bgme.a(localArrayList);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
          super.a(paramSessionInfo, paramawzu, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, paramString2);
        }
        return;
      }
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((bgsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
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
      f(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(anzj.a(2131699975));
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.4(this), 200L);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.5(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      super.a(paramBoolean1, paramBoolean2);
    }
    Object localObject;
    do
    {
      return;
      super.a(paramBoolean1, paramBoolean2);
      localObject = (agwy)this.jdField_a_of_type_Aguw.a(23);
      if (localObject != null) {
        ((agwy)localObject).a(this.jdField_e_of_type_AndroidViewView);
      }
      localObject = (agwg)a(52);
    } while (localObject == null);
    ((agwg)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_e_of_type_AndroidViewView);
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_Aggs.getCount() > 0)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((aggv)this.jdField_a_of_type_Aday.a).a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Bfpy != null) {
        if (this.jdField_a_of_type_Bfpy.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Aday.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Bfpy.jdField_a_of_type_Long, this.jdField_a_of_type_Bfpy.jdField_b_of_type_Long, this.jdField_a_of_type_Bfpy.c, this.jdField_a_of_type_Aday);
          this.jdField_a_of_type_Bfpy.j();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Aday.e = false;
      this.jdField_a_of_type_Aday.f = true;
      if (!this.T)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Aday);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aday);
      this.T = false;
      break;
      this.jdField_a_of_type_Aday.e = false;
      this.jdField_a_of_type_Aday.f = true;
      if (!this.T)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Aday);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aday);
      this.T = false;
      break;
      g(false);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = super.a(paramMotionEvent);
    agwg localagwg = (agwg)a(52);
    if ((localagwg != null) && (localagwg.a(paramMotionEvent))) {
      return false;
    }
    return bool;
  }
  
  public void al_() {}
  
  public void as()
  {
    super.as();
    this.c = "";
  }
  
  public void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(new begb(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 32).a());
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
    paramObject = (bfpe)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleUpdateTroopAioAgentMessage: " + paramObject.jdField_a_of_type_Int);
      }
      if (paramObject.jdField_a_of_type_Int != bfpd.jdField_a_of_type_Int) {
        break label74;
      }
      a(paramObject.c, paramObject.a(), paramObject.d, null);
    }
    label74:
    while ((paramObject.jdField_a_of_type_Int != bfpd.b) || (this.jdField_e_of_type_AndroidViewView == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObject.b);
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_Bfpy != null) {
      this.jdField_a_of_type_Bfpy.a();
    }
    return super.b(paramInt);
  }
  
  public void bn()
  {
    super.bn();
    this.jdField_a_of_type_Aguw.a(this);
  }
  
  protected void bo()
  {
    p(0);
  }
  
  protected void bp()
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131718923));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void bq()
  {
    if (this.jdField_a_of_type_Bfpy == null) {
      this.jdField_a_of_type_Bfpy = new bfpy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_Bfpy);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Base#onShow_troopType#setTroopTips");
      }
    }
    this.jdField_a_of_type_Bfpy.h();
    this.jdField_a_of_type_Bfpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aggs, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Bfpy != null) && (this.jdField_a_of_type_Aiwh.a() != 9)) {
      this.jdField_a_of_type_Bfpy.e();
    }
    br();
  }
  
  void br()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleGrayTipsMsg");
    }
    Object localObject = (bgul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((bgul)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new BaseTroopChatPie.3(this, (bgul)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void bs()
  {
    f(true);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.f.getVisibility() == 8))
    {
      this.f.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
      this.d.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.f.getVisibility() != 0) || (this.U)) {
      return;
    }
    this.f.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.d.setTextSize(1, 17.0F);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aihe(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166987));
    this.f.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166987));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166984));
    agwy localagwy = (agwy)this.jdField_a_of_type_Aguw.a(23);
    if (localagwy != null) {
      localagwy.a();
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
    if (this.jdField_a_of_type_Bfpy != null) {
      this.jdField_a_of_type_Bfpy.a();
    }
    super.f(paramBoolean);
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_Bfpy != null) {
      this.jdField_a_of_type_Bfpy.a();
    }
    return super.i();
  }
  
  public void j(int paramInt)
  {
    super.j(paramInt);
    Object localObject = (agwy)this.jdField_a_of_type_Aguw.a(23);
    if (localObject != null) {
      ((agwy)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = (agwg)a(52);
    if (localObject != null) {
      ((agwg)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_Bghm == null) || (!this.jdField_a_of_type_Bghm.a())) {
      return;
    }
    this.jdField_a_of_type_Bghm.a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if (this.jdField_a_of_type_Bfpy != null) {
      this.jdField_a_of_type_Bfpy.a(paramInt1, paramInt2, paramInt3, i, j);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.jdField_a_of_type_Bftm != null)
      {
        if ((this.jdField_a_of_type_Bftm.d == bftm.c) && (this.jdField_a_of_type_Bftm.a != null)) {
          a(this.jdField_a_of_type_Bftm.a.c, this.jdField_a_of_type_Bftm.a.a(), this.jdField_a_of_type_Bftm.a.d, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString + ".trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_Bftm.d);
        }
        this.jdField_a_of_type_Bftm = null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteObservers();
      }
    }
    while (!(paramObject instanceof bfpe)) {
      return;
    }
    b(paramObject);
  }
  
  public void z()
  {
    if ((this.U) || (this.V))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843629);
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850133, 2130850134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihd
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class aemf
  extends BaseChatPie
  implements aczl
{
  protected boolean T;
  protected boolean U;
  public boolean V;
  protected boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  protected aktf a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  public bado a;
  public TroopAIORobotLayout a;
  protected long g;
  public String g;
  public String h;
  
  public aemf(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Aktf = new aemh(this);
  }
  
  public void A()
  {
    String str = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bbcl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
  }
  
  public boolean D()
  {
    return this.N;
  }
  
  public boolean E()
  {
    return false;
  }
  
  public boolean F()
  {
    return this.V;
  }
  
  @TargetApi(16)
  public void G()
  {
    if (this.N)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_Aznm != null) {
      this.jdField_a_of_type_Aznm.a();
    }
    if (this.jdField_a_of_type_Bado != null)
    {
      this.jdField_a_of_type_Bado.b();
      this.jdField_a_of_type_Bado = null;
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
      adjr localadjr = (adjr)this.jdField_a_of_type_Adic.a(23);
      if (localadjr != null) {
        localadjr.c();
      }
      super.G();
      return;
      label136:
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void K()
  {
    if (!this.N)
    {
      Object localObject = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localObject != null)
      {
        ((askq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
        if (this.jdField_a_of_type_Aznm != null)
        {
          localObject = this.jdField_a_of_type_Aznm.a();
          if (localObject != null) {
            ((azng)localObject).a.set(false);
          }
        }
      }
    }
    super.K();
  }
  
  public void L()
  {
    super.L();
    if (this.jdField_a_of_type_Aznm != null) {
      this.jdField_a_of_type_Aznm.i();
    }
  }
  
  public void O()
  {
    super.O();
    bp();
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131559018, null));
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
    return bbis.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "BaseTroopChatPie";
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.V)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131376253).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    adjr localadjr = (adjr)this.jdField_a_of_type_Adic.a(23);
    if (localadjr != null) {
      localadjr.a(paramIntent);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    adjr localadjr = (adjr)this.jdField_a_of_type_Adic.a(23);
    if ((localadjr != null) && (localadjr.a(paramMotionEvent, this.L))) {
      return;
    }
    super.a(paramMotionEvent);
  }
  
  public void a(SessionInfo paramSessionInfo, asei paramasei, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      paramCharSequence = bafh.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    }
    for (;;)
    {
      String str = null;
      if (localArrayList.size() > 0) {
        str = bafh.a(localArrayList);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        ThreadManager.post(new SaveTextDraftJob(this, paramSessionInfo, paramasei, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131372737), str), 8, null, false);
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
    if (((bakk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
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
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(ajyc.a(2131701052));
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
      localObject = (adjr)this.jdField_a_of_type_Adic.a(23);
      if (localObject != null) {
        ((adjr)localObject).a(this.jdField_f_of_type_AndroidViewView);
      }
      localObject = (adho)a(52);
    } while (localObject == null);
    ((adho)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_f_of_type_AndroidViewView);
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
    if (this.jdField_a_of_type_Acut.getCount() > 0)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((acuw)this.jdField_a_of_type_Akqs.a).a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Aznm != null) {
        if (this.jdField_a_of_type_Aznm.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Akqs.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aznm.jdField_a_of_type_Long, this.jdField_a_of_type_Aznm.jdField_b_of_type_Long, this.jdField_a_of_type_Aznm.c, this.jdField_a_of_type_Akqs);
          this.jdField_a_of_type_Aznm.j();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Akqs.e = false;
      this.jdField_a_of_type_Akqs.f = true;
      if (!this.U)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akqs);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Akqs);
      this.U = false;
      break;
      this.jdField_a_of_type_Akqs.e = false;
      this.jdField_a_of_type_Akqs.f = true;
      if (!this.U)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akqs);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Akqs);
      this.U = false;
      break;
      g(false);
    }
  }
  
  public void al_() {}
  
  public void aq()
  {
    super.aq();
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
      this.jdField_e_of_type_AndroidWidgetTextView.setText(new ayju(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 32).a());
      if (AppSetting.d)
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
    paramObject = (azmp)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleUpdateTroopAioAgentMessage: " + paramObject.jdField_a_of_type_Int);
      }
      if (paramObject.jdField_a_of_type_Int != azmo.jdField_a_of_type_Int) {
        break label74;
      }
      a(paramObject.c, paramObject.a(), paramObject.d, null);
    }
    label74:
    while ((paramObject.jdField_a_of_type_Int != azmo.b) || (this.jdField_f_of_type_AndroidViewView == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObject.b);
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_Aznm != null) {
      this.jdField_a_of_type_Aznm.a();
    }
    return super.b(paramInt);
  }
  
  protected void bo()
  {
    o(0);
  }
  
  protected void bp()
  {
    this.g = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720475));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void bq()
  {
    if (this.jdField_a_of_type_Aznm == null) {
      this.jdField_a_of_type_Aznm = new aznm();
    }
    this.jdField_a_of_type_Aznm.h();
    this.jdField_a_of_type_Aznm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acut, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Aznm != null) && (this.jdField_a_of_type_Aeyx.a() != 9)) {
      this.jdField_a_of_type_Aznm.e();
    }
    br();
  }
  
  void br()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleGrayTipsMsg");
    }
    Object localObject = (bamj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((bamj)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new BaseTroopChatPie.3(this, (bamj)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void bs()
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
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aemg(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166848));
    adjr localadjr = (adjr)this.jdField_a_of_type_Adic.a(23);
    if (localadjr != null) {
      localadjr.b();
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
    if (this.jdField_a_of_type_Aznm != null) {
      this.jdField_a_of_type_Aznm.a();
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
    Object localObject = (adjr)this.jdField_a_of_type_Adic.a(23);
    if (localObject != null) {
      ((adjr)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = (adho)a(52);
    if (localObject != null) {
      ((adho)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_Aznm != null) {
      this.jdField_a_of_type_Aznm.a();
    }
    return super.i();
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_Bado == null) || (!this.jdField_a_of_type_Bado.a())) {
      return;
    }
    this.jdField_a_of_type_Bado.a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if ((this.jdField_a_of_type_Aznm != null) && (this.jdField_a_of_type_Aznm.d()) && (this.jdField_a_of_type_Acut != null) && (!this.jdField_a_of_type_Aznm.a().a.get()))
    {
      if ((!azng.a(this.jdField_a_of_type_Aznm.b())) || (paramInt2 <= 0)) {
        break label239;
      }
      List localList = this.jdField_a_of_type_Acut.a();
      int k = localList.size();
      int m = paramInt1 + paramInt2 - j - i;
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + i + ",headerCnt = " + j + ", listSize = " + k);
      }
      if ((paramInt1 >= 0) && (paramInt1 <= m) && (m < k))
      {
        localList = localList.subList(paramInt1, m);
        this.jdField_a_of_type_Aznm.b(localList);
      }
    }
    for (;;)
    {
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label239:
      this.jdField_a_of_type_Aznm.b(0);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.jdField_a_of_type_Azra != null)
      {
        if ((this.jdField_a_of_type_Azra.d == azra.c) && (this.jdField_a_of_type_Azra.a != null)) {
          a(this.jdField_a_of_type_Azra.a.c, this.jdField_a_of_type_Azra.a.a(), this.jdField_a_of_type_Azra.a.d, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString + ".trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_Azra.d);
        }
        this.jdField_a_of_type_Azra = null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteObservers();
      }
    }
    while (!(paramObject instanceof azmp)) {
      return;
    }
    b(paramObject);
  }
  
  public void z()
  {
    if ((this.V) || (this.W))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843052);
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849060, 2130849061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemf
 * JD-Core Version:    0.7.0.1
 */
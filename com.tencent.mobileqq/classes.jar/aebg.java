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

public class aebg
  extends BaseChatPie
  implements acos
{
  protected boolean T;
  protected boolean U;
  public boolean V;
  protected boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  aket a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  public azct a;
  public TroopAIORobotLayout a;
  protected long g;
  public String g;
  public String h;
  
  public aebg(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Aket = new aebi(this);
  }
  
  public void A()
  {
    String str = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, babh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
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
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a();
    }
    if (this.jdField_a_of_type_Azct != null)
    {
      this.jdField_a_of_type_Azct.b();
      this.jdField_a_of_type_Azct = null;
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
      bm();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(false);
      }
      acyp localacyp = (acyp)this.jdField_a_of_type_Acxb.a(23);
      if (localacyp != null) {
        localacyp.c();
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
      Object localObject = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localObject != null)
      {
        ((arom)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
        if (this.jdField_a_of_type_Aymw != null)
        {
          localObject = this.jdField_a_of_type_Aymw.a();
          if (localObject != null) {
            ((aymq)localObject).a.set(false);
          }
        }
      }
    }
    super.K();
  }
  
  public void L()
  {
    super.L();
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.i();
    }
  }
  
  public void O()
  {
    super.O();
    bn();
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131493455, null));
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
    return bahn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131310461).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    acyp localacyp = (acyp)this.jdField_a_of_type_Acxb.a(23);
    if (localacyp != null) {
      localacyp.a(paramIntent);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    acyp localacyp = (acyp)this.jdField_a_of_type_Acxb.a(23);
    if ((localacyp != null) && (localacyp.a(paramMotionEvent, this.L))) {
      return;
    }
    super.a(paramMotionEvent);
  }
  
  public void a(SessionInfo paramSessionInfo, arig paramarig, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      paramCharSequence = azef.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    }
    for (;;)
    {
      String str = null;
      if (localArrayList.size() > 0) {
        str = azef.a(localArrayList);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        ThreadManager.post(new SaveTextDraftJob(this, paramSessionInfo, paramarig, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131307025), str), 8, null, false);
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
    if (((azjh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
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
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(ajjy.a(2131635268));
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
    acyp localacyp;
    do
    {
      return;
      super.a(paramBoolean1, paramBoolean2);
      localacyp = (acyp)this.jdField_a_of_type_Acxb.a(23);
    } while (localacyp == null);
    localacyp.a(this.jdField_f_of_type_AndroidViewView);
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
    if (this.jdField_a_of_type_Acka.getCount() > 0)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ackd)this.jdField_a_of_type_Akcg.a).a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Aymw != null) {
        if (this.jdField_a_of_type_Aymw.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Akcg.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aymw.jdField_a_of_type_Long, this.jdField_a_of_type_Aymw.jdField_b_of_type_Long, this.jdField_a_of_type_Aymw.c, this.jdField_a_of_type_Akcg);
          this.jdField_a_of_type_Aymw.j();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Akcg.e = false;
      this.jdField_a_of_type_Akcg.f = true;
      if (!this.U)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akcg);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Akcg);
      this.U = false;
      break;
      this.jdField_a_of_type_Akcg.e = false;
      this.jdField_a_of_type_Akcg.f = true;
      if (!this.U)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Akcg);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Akcg);
      this.U = false;
      break;
      g(false);
    }
  }
  
  public void ao_() {}
  
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
      this.jdField_e_of_type_AndroidWidgetTextView.setText(new axjq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 32).a());
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
    paramObject = (aylz)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleUpdateTroopAioAgentMessage: " + paramObject.jdField_a_of_type_Int);
      }
      if (paramObject.jdField_a_of_type_Int != ayly.jdField_a_of_type_Int) {
        break label74;
      }
      a(paramObject.c, paramObject.a(), paramObject.d, null);
    }
    label74:
    while ((paramObject.jdField_a_of_type_Int != ayly.b) || (this.jdField_f_of_type_AndroidViewView == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObject.b);
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a();
    }
    return super.b(paramInt);
  }
  
  protected void bm()
  {
    o(0);
  }
  
  void bn()
  {
    this.g = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131654579));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void bo()
  {
    if (this.jdField_a_of_type_Aymw == null) {
      this.jdField_a_of_type_Aymw = new aymw();
    }
    this.jdField_a_of_type_Aymw.h();
    this.jdField_a_of_type_Aymw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_Aymw != null) && (this.jdField_a_of_type_Aeob.a() != 9)) {
      this.jdField_a_of_type_Aymw.e();
    }
    bp();
  }
  
  void bp()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleGrayTipsMsg");
    }
    Object localObject = (azlf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((azlf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new BaseTroopChatPie.3(this, (azlf)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void bq()
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
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aebh(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101254));
    acyp localacyp = (acyp)this.jdField_a_of_type_Acxb.a(23);
    if (localacyp != null) {
      localacyp.b();
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
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a();
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
    acyp localacyp = (acyp)this.jdField_a_of_type_Acxb.a(23);
    if (localacyp != null) {
      localacyp.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a();
    }
    return super.i();
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_Azct == null) || (!this.jdField_a_of_type_Azct.a())) {
      return;
    }
    this.jdField_a_of_type_Azct.a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if ((this.jdField_a_of_type_Aymw != null) && (this.jdField_a_of_type_Aymw.d()) && (this.jdField_a_of_type_Acka != null) && (!this.jdField_a_of_type_Aymw.a().a.get()))
    {
      if ((!aymq.a(this.jdField_a_of_type_Aymw.b())) || (paramInt2 <= 0)) {
        break label239;
      }
      List localList = this.jdField_a_of_type_Acka.a();
      int k = localList.size();
      int m = paramInt1 + paramInt2 - j - i;
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + i + ",headerCnt = " + j + ", listSize = " + k);
      }
      if ((paramInt1 >= 0) && (paramInt1 <= m) && (m < k))
      {
        localList = localList.subList(paramInt1, m);
        this.jdField_a_of_type_Aymw.b(localList);
      }
    }
    for (;;)
    {
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label239:
      this.jdField_a_of_type_Aymw.b(0);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.jdField_a_of_type_Ayqk != null)
      {
        if ((this.jdField_a_of_type_Ayqk.d == ayqk.c) && (this.jdField_a_of_type_Ayqk.a != null)) {
          a(this.jdField_a_of_type_Ayqk.a.c, this.jdField_a_of_type_Ayqk.a.a(), this.jdField_a_of_type_Ayqk.a.d, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString + ".trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_Ayqk.d);
        }
        this.jdField_a_of_type_Ayqk = null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteObservers();
      }
    }
    while (!(paramObject instanceof aylz)) {
      return;
    }
    b(paramObject);
  }
  
  public void z()
  {
    if ((this.V) || (this.W))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842969);
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130848835, 2130848836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aebg
 * JD-Core Version:    0.7.0.1
 */
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class afss
  implements afrc, View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  protected ImageButton a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected BaseChatPie a;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  protected ImageButton b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n;
  private int o = -1;
  private int p = -1;
  private int q = -1;
  
  public afss(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a(RedTouch paramRedTouch)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((azvi)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(36)).a(10);
      if (localRedTypeInfo != null) {
        paramRedTouch.a(localRedTypeInfo);
      }
    }
  }
  
  private void a(RedTouch paramRedTouch, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((azvi)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(36)).a(4, String.valueOf(paramInt));
      if (localAppInfo != null) {
        paramRedTouch.a(localAppInfo);
      }
    }
  }
  
  private boolean a(View paramView)
  {
    if ((paramView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
      return (View)paramView.getParent() instanceof RedTouch;
    }
    return false;
  }
  
  private void h()
  {
    this.n = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
    this.jdField_a_of_type_Boolean = a();
    b();
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void i() {}
  
  private void j() {}
  
  private void k() {}
  
  private void l() {}
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn).a(8388661).a());
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_b_of_type_AndroidWidgetImageButton).a(8388661).a(), 130105);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_AndroidWidgetImageButton).a(8388661).a(), 130101);
    }
  }
  
  private void p()
  {
    boolean bool = nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "reAdjustAnonymousStatusBar is called! isAnony = " + bool);
      }
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c())) {
        ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow());
      }
    }
  }
  
  public int a()
  {
    return 2130838303;
  }
  
  protected void a()
  {
    this.jdField_f_of_type_Boolean = false;
    Object localObject1;
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(amtj.a(2131713272));
          }
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton == null) {
          break label785;
        }
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(amtj.a(2131713269));
          }
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367354));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null)
        {
          localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams();
          if (this.jdField_c_of_type_Int == -1) {
            this.jdField_c_of_type_Int = ((FrameLayout.LayoutParams)localObject1).leftMargin;
          }
          ((FrameLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView != null)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367353));
          localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).gravity = 80;
          if (this.o == -1) {
            this.o = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
          }
          if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.p == -1)) {
            this.p = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams()).bottomMargin;
          }
          if (this.p == -1) {
            break label838;
          }
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.p;
          if (QLog.isColorLevel()) {
            QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin 1 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
          localLayoutParams = ((View)localObject1).getLayoutParams();
          localObject2 = localLayoutParams;
          if ((localLayoutParams instanceof FrameLayout.LayoutParams))
          {
            localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getParent();
            localObject2 = ((View)localObject1).getLayoutParams();
            if ((localObject1 instanceof RedTouch)) {
              a((RedTouch)localObject1);
            }
          }
          if ((localObject2 instanceof LinearLayout.LayoutParams))
          {
            localObject2 = (LinearLayout.LayoutParams)localObject2;
            if (this.jdField_d_of_type_Int == -1) {
              this.jdField_d_of_type_Int = ((LinearLayout.LayoutParams)localObject2).width;
            }
            if (this.jdField_e_of_type_Int == -1) {
              this.jdField_e_of_type_Int = ((LinearLayout.LayoutParams)localObject2).height;
            }
            ((LinearLayout.LayoutParams)localObject2).width = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources().getDimension(2131298108));
            ((LinearLayout.LayoutParams)localObject2).height = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources().getDimension(2131298108));
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setVisibility(0);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
            if (!this.jdField_e_of_type_Boolean) {
              break label862;
            }
            i1 = 2130838206;
            ((PatchedButton)localObject2).setBackgroundResource(i1);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setText("");
            if (AppSetting.jdField_c_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setContentDescription(amtj.a(2131713279));
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setEnabled(true);
          }
          if (!(localObject1 instanceof RedTouch)) {
            m();
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
        {
          if (!a(this.jdField_a_of_type_AndroidWidgetImageButton)) {
            break label869;
          }
          localObject1 = (View)this.jdField_a_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130101);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
        {
          if (!a(this.jdField_b_of_type_AndroidWidgetImageButton)) {
            break label876;
          }
          localObject1 = (View)this.jdField_b_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130105);
        }
      }
    }
    label785:
    label838:
    label862:
    label869:
    label876:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahkw))
    {
      for (;;)
      {
        int i1;
        return;
        localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.findViewById(2131362486);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
          this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838216);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          continue;
          localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.findViewById(2131362487);
          if (localObject1 != null)
          {
            this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
            this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838154);
            this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
            continue;
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources().getDimension(2131298107));
            continue;
            i1 = 2130838207;
            continue;
            o();
          }
        }
      }
      n();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      if (a(this.jdField_a_of_type_AndroidWidgetImageButton)) {
        ((RedTouch)this.jdField_a_of_type_AndroidWidgetImageButton.getParent()).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
    {
      if (a(this.jdField_b_of_type_AndroidWidgetImageButton)) {
        ((RedTouch)this.jdField_b_of_type_AndroidWidgetImageButton.getParent()).setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null) && (this.jdField_c_of_type_Int != -1))
    {
      localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).leftMargin = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          ((RedTouch)localObject1).d();
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if ((this.jdField_d_of_type_Int != -1) && (this.jdField_e_of_type_Int != -1))
        {
          ((LinearLayout.LayoutParams)localObject2).width = this.jdField_d_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).height = this.jdField_e_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject2).gravity = 8388693;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setBackgroundResource(a());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setText(2131690709);
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setContentDescription(amtj.a(2131713282));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText().length() <= 0) {
              break label1397;
            }
          }
        }
      }
    }
    label1397:
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject1).setEnabled(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView == null) {
        break;
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367353));
      }
      localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).gravity = 80;
      if (this.o != -1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.o;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin  2 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return;
    case 1: 
      h();
      return;
    case 2: 
      e();
      return;
    case 5: 
      g();
    case 7: 
      l();
      return;
    case 8: 
      k();
      return;
    case 9: 
      i();
      return;
    }
    j();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
      if (paramInt2 != 8) {
        break label99;
      }
      bool1 = true;
      ((PatchedButton)localObject).setSelected(bool1);
      localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (paramInt2 != 3) {
        break label104;
      }
      bool1 = true;
      label53:
      ((ImageButton)localObject).setSelected(bool1);
      if (paramInt2 != 2) {
        break label109;
      }
    }
    label99:
    label104:
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(bool1);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        if (!bool1) {
          break label114;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(amtj.a(2131713277));
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label53;
    }
    label114:
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(amtj.a(2131713284));
  }
  
  public void a(TextView paramTextView)
  {
    Object localObject;
    if (paramTextView != null)
    {
      localObject = paramTextView.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (!this.jdField_a_of_type_Boolean) {
          break label70;
        }
        if (this.q == -1) {
          this.q = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
        paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    return;
    label70:
    if (this.q != -1) {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.q;
    }
    paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {}
    for (localObject = ((ChatFragment)localObject).a;; localObject = null)
    {
      bbyp.a((SystemBarCompact)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getWindow(), paramBoolean);
      p();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (aftj)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(23);
    boolean bool = paramBoolean;
    if (localObject1 != null) {
      if (!((aftj)localObject1).b())
      {
        bool = paramBoolean;
        if (!this.jdField_f_of_type_Boolean) {}
      }
      else
      {
        bool = paramBoolean;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afii)) {
          bool = true;
        }
      }
    }
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      if (!bool) {
        break label583;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setBackgroundResource(a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setText(2131690709);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setContentDescription(amtj.a(2131713280));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setEnabled(true);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        if (this.j == -1) {
          this.j = ((LinearLayout.LayoutParams)localObject1).leftMargin;
        }
        if (this.k == -1) {
          this.k = ((LinearLayout.LayoutParams)localObject1).rightMargin;
        }
        ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(2.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
        ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          ((RedTouch)localObject1).d();
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if (this.jdField_f_of_type_Int == -1) {
          this.jdField_f_of_type_Int = ((LinearLayout.LayoutParams)localObject2).rightMargin;
        }
        if (this.g == -1) {
          this.g = ((LinearLayout.LayoutParams)localObject2).leftMargin;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
        if ((this.jdField_f_of_type_Int != -1) && (this.g != -1) && (!this.jdField_c_of_type_Boolean))
        {
          ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width + this.jdField_f_of_type_Int + this.g + this.j + this.k - AIOUtils.dp2px(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources()));
          this.jdField_c_of_type_Boolean = true;
        }
        if (this.h == -1) {
          this.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getPaddingLeft();
        }
        if (this.i == -1) {
          this.i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getPaddingRight();
        }
        if (this.l == -1) {
          this.l = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getPaddingTop();
        }
        if (this.m == -1) {
          this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getPaddingBottom();
        }
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setPadding(0, this.n, 0, this.n);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    return;
    label583:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
    if (this.jdField_e_of_type_Boolean) {}
    for (int i1 = 2130838206;; i1 = 2130838207)
    {
      ((PatchedButton)localObject1).setBackgroundResource(i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setText("");
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setContentDescription(amtj.a(2131713275));
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        if (this.j != -1) {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = this.j;
        }
        if (this.k != -1) {
          ((LinearLayout.LayoutParams)localObject1).rightMargin = this.k;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          a((RedTouch)localObject1);
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if (this.jdField_f_of_type_Int != -1) {
          ((LinearLayout.LayoutParams)localObject2).rightMargin = this.jdField_f_of_type_Int;
        }
        if (this.g != -1) {
          ((LinearLayout.LayoutParams)localObject2).leftMargin = this.g;
        }
        if ((this.g != -1) && (this.jdField_f_of_type_Int != -1) && (this.jdField_c_of_type_Boolean))
        {
          ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width - this.jdField_f_of_type_Int - this.g - (this.j + this.k - AIOUtils.dp2px(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources())));
          this.jdField_c_of_type_Boolean = false;
        }
        if ((this.h != -1) && (this.i != -1) && (this.m != -1) && (this.l != -1)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setPadding(this.h, this.l, this.i, this.m);
        }
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setEnabled(true);
      return;
    }
  }
  
  protected boolean a()
  {
    boolean bool = bbyp.b();
    QLog.i("grever", 2, "Simple-->ret:" + bool);
    return bool;
  }
  
  public int[] a()
  {
    return new int[] { 1, 2, 3, 5, 7, 8, 9, 13 };
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 3000)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (paramInt == 2) && (this.jdField_a_of_type_AndroidWidgetImageButton != null)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i2 = 2130838206;
    boolean bool = true;
    Object localObject = (aftj)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(23);
    if ((localObject != null) && ((((aftj)localObject).b()) || (this.jdField_f_of_type_Boolean))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((a()) && (this.jdField_b_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClickFunBtn() simple mode fun_btn isSend = " + paramBoolean);
        }
        if (!paramBoolean) {
          break label185;
        }
        if (i1 == 0)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
            this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
          }
          if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
          if (!this.jdField_e_of_type_Boolean) {
            break label178;
          }
        }
      }
      label178:
      for (i1 = 2130838206;; i1 = 2130838207)
      {
        ((PatchedButton)localObject).setBackgroundResource(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setText("");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setSelected(false);
        return;
      }
      label185:
      if (!this.jdField_d_of_type_Boolean)
      {
        paramBoolean = bool;
        this.jdField_d_of_type_Boolean = paramBoolean;
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
          this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
        if (!this.jdField_e_of_type_Boolean) {
          break label299;
        }
      }
      label299:
      for (i1 = i2;; i1 = 2130838207)
      {
        ((PatchedButton)localObject).setBackgroundResource(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setText("");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setSelected(this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onPanelIconClick(Integer.valueOf(8));
        return;
        paramBoolean = false;
        break;
      }
    }
  }
  
  public void c()
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null) && (a()) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons.setCustomHeight(0);
      int i1 = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1))
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getPaddingTop();
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getPaddingBottom();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setEnabled(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getPaddingLeft(), i1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getPaddingRight(), i1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367353));
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.gravity = 80;
        if (this.o == -1) {
          this.o = localLayoutParams.bottomMargin;
        }
        if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.p == -1)) {
          this.p = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams()).bottomMargin;
        }
        if (this.p == -1) {
          break label321;
        }
        localLayoutParams.bottomMargin = this.p;
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "setSimpleUIMode() simple mode  bottomMargin 1 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      return;
      label321:
      localLayoutParams.bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources().getDimension(2131298107));
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null) && (this.jdField_a_of_type_Int != -1) && (this.jdField_b_of_type_Int != -1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getPaddingLeft(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getPaddingRight(), this.jdField_b_of_type_Int);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isThemeDefault) {
          break label554;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.adjustInputLayout(AIOUtils.dp2px(1.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources()));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367353));
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.gravity = 80;
        if (this.o != -1) {
          localLayoutParams.bottomMargin = this.o;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "setSimpleUIMode() simple mode  bottomMargin 2 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
        label554:
        ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie), true);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "switchAnonymousChat is called! isAnonymousChat = " + paramBoolean);
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
        if (!paramBoolean) {
          break label143;
        }
        i1 = 2130838215;
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
        if (!paramBoolean) {
          break label150;
        }
        i1 = 2130838152;
        label106:
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    label143:
    label150:
    label157:
    for (int i1 = 2130838206;; i1 = 2130838207)
    {
      ((PatchedButton)localObject).setBackgroundResource(i1);
      return;
      i1 = 2130838216;
      break;
      i1 = 2130838154;
      break label106;
    }
  }
  
  boolean c()
  {
    aftj localaftj = (aftj)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(23);
    return (localaftj != null) && ((localaftj.b()) || (this.jdField_f_of_type_Boolean));
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367353));
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout  bottomMargin  = " + localLayoutParams.bottomMargin);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null) && (a()) && (this.jdField_b_of_type_Boolean))
    {
      if (this.p != -1) {}
      for (localLayoutParams.bottomMargin = this.p;; localLayoutParams.bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources().getDimension(2131298107)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 1 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
      }
    }
    localLayoutParams.gravity = 80;
    if (this.o != -1) {
      localLayoutParams.bottomMargin = this.o;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 2 = " + localLayoutParams.bottomMargin);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onCreate() called");
    }
    a();
  }
  
  void f()
  {
    View localView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getParent();
    if (((localView instanceof RedTouch)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getText())))
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((azvi)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(36)).a(10);
      ((RedTouch)localView).a(localRedTypeInfo);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onResume() called");
    }
    c();
  }
  
  public void onClick(View paramView)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() not in simple mode");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131367352: 
      default: 
        break;
      case 2131363032: 
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClick() audio_btn");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onPanelIconClick(Integer.valueOf(2));
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
        break;
      case 2131365953: 
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClick() emo_btn");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onPanelIconClick(Integer.valueOf(3));
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afss
 * JD-Core Version:    0.7.0.1
 */
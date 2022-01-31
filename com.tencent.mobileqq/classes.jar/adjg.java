import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class adjg
  implements adih, View.OnClickListener
{
  private final int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected ImageButton a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected BaseChatPie a;
  protected boolean a;
  private int jdField_b_of_type_Int = -1;
  protected ImageButton b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected boolean b;
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
  private int n = -1;
  private int o;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  
  public adjg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private void a(RedTouch paramRedTouch)
  {
    a(paramRedTouch, 10);
  }
  
  private void a(RedTouch paramRedTouch, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((avpq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramInt);
      if (localRedTypeInfo != null) {
        paramRedTouch.a(localRedTypeInfo);
      }
    }
  }
  
  private void a(RedTouch paramRedTouch, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avpq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramInt1, String.valueOf(paramInt2));
      if (localAppInfo != null) {
        paramRedTouch.a(localAppInfo);
      }
    }
  }
  
  private boolean a(View paramView)
  {
    return ((paramView.getLayoutParams() instanceof FrameLayout.LayoutParams)) && (((View)paramView.getParent() instanceof RedTouch));
  }
  
  private void h()
  {
    this.o = actn.a(4.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
    this.jdField_a_of_type_Boolean = axmt.b();
    a();
  }
  
  private void i() {}
  
  private void j() {}
  
  private void k() {}
  
  private void l() {}
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton).a(8388661).a());
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetImageButton).a(8388661).a(), 4, 130105);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetImageButton).a(8388661).a(), 4, 130101);
    }
  }
  
  private void p()
  {
    boolean bool = mye.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "reAdjustAnonyStatusBar is called! isAnony = " + bool);
      }
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c())) {
        ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow());
      }
    }
  }
  
  public int a()
  {
    return 2130838098;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 5: 
    case 9: 
    case 10: 
    default: 
      return;
    case 0: 
      h();
      return;
    case 1: 
      d();
      return;
    case 4: 
      f();
    case 6: 
      l();
      return;
    case 7: 
      k();
      return;
    case 8: 
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
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
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        if (!bool1) {
          break label114;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(ajyc.a(2131714173));
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label53;
    }
    label114:
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(ajyc.a(2131714180));
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
        if (this.r == -1) {
          this.r = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = actn.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    return;
    label70:
    if (this.r != -1) {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.r;
    }
    paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {}
    for (localObject = ((ChatFragment)localObject).a;; localObject = null)
    {
      axmt.a((SystemBarCompact)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow(), paramBoolean);
      p();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i2 = 2130838020;
    boolean bool = true;
    Object localObject = (adjr)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
    if ((localObject != null) && ((((adjr)localObject).b()) || (this.jdField_f_of_type_Boolean))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((b()) && (this.jdField_b_of_type_Boolean))
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
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
          if (!this.jdField_e_of_type_Boolean) {
            break label178;
          }
        }
      }
      label178:
      for (i1 = 2130838020;; i1 = 2130838021)
      {
        ((PatchedButton)localObject).setBackgroundResource(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(false);
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (!this.jdField_e_of_type_Boolean) {
          break label299;
        }
      }
      label299:
      for (i1 = i2;; i1 = 2130838021)
      {
        ((PatchedButton)localObject).setBackgroundResource(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(8));
        return;
        paramBoolean = false;
        break;
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 0, 1, 2, 4, 6, 7, 8, 11 };
  }
  
  protected void b()
  {
    this.jdField_f_of_type_Boolean = false;
    Object localObject1;
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(ajyc.a(2131714168));
          }
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton == null) {
          break label787;
        }
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(ajyc.a(2131714165));
          }
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366885));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
          if (this.jdField_d_of_type_Int == -1) {
            this.jdField_d_of_type_Int = ((FrameLayout.LayoutParams)localObject1).leftMargin;
          }
          ((FrameLayout.LayoutParams)localObject1).leftMargin = actn.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366884));
          localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).gravity = 80;
          if (this.p == -1) {
            this.p = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
          }
          if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.q == -1)) {
            this.q = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams()).bottomMargin;
          }
          if (this.q == -1) {
            break label840;
          }
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.q;
          if (QLog.isColorLevel()) {
            QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin 1 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
          localLayoutParams = ((View)localObject1).getLayoutParams();
          localObject2 = localLayoutParams;
          if ((localLayoutParams instanceof FrameLayout.LayoutParams))
          {
            localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
            localObject2 = ((View)localObject1).getLayoutParams();
            if ((localObject1 instanceof RedTouch)) {
              a((RedTouch)localObject1);
            }
          }
          if ((localObject2 instanceof LinearLayout.LayoutParams))
          {
            localObject2 = (LinearLayout.LayoutParams)localObject2;
            if (this.jdField_e_of_type_Int == -1) {
              this.jdField_e_of_type_Int = ((LinearLayout.LayoutParams)localObject2).width;
            }
            if (this.jdField_f_of_type_Int == -1) {
              this.jdField_f_of_type_Int = ((LinearLayout.LayoutParams)localObject2).height;
            }
            ((LinearLayout.LayoutParams)localObject2).width = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297931));
            ((LinearLayout.LayoutParams)localObject2).height = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297931));
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
            if (!this.jdField_e_of_type_Boolean) {
              break label864;
            }
            i1 = 2130838020;
            ((PatchedButton)localObject2).setBackgroundResource(i1);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
            if (AppSetting.jdField_d_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(ajyc.a(2131714175));
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
          }
          if (!(localObject1 instanceof RedTouch)) {
            m();
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
        {
          if (!a(this.jdField_a_of_type_AndroidWidgetImageButton)) {
            break label871;
          }
          localObject1 = (View)this.jdField_a_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 4, 130101);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
        {
          if (!a(this.jdField_b_of_type_AndroidWidgetImageButton)) {
            break label878;
          }
          localObject1 = (View)this.jdField_b_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 4, 130105);
        }
      }
    }
    label787:
    label840:
    label864:
    label871:
    label878:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aetp))
    {
      for (;;)
      {
        int i1;
        return;
        localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362362);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
          this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838030);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          continue;
          localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362363);
          if (localObject1 != null)
          {
            this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
            this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundResource(2130837968);
            this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
            continue;
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297930));
            continue;
            i1 = 2130838021;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_d_of_type_Int != -1))
    {
      localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).leftMargin = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          ((RedTouch)localObject1).b();
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if ((this.jdField_e_of_type_Int != -1) && (this.jdField_f_of_type_Int != -1))
        {
          ((LinearLayout.LayoutParams)localObject2).width = this.jdField_e_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).height = this.jdField_f_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject2).gravity = 85;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690745);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(ajyc.a(2131714178));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
              break label1398;
            }
          }
        }
      }
    }
    label1398:
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject1).setEnabled(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c == null) {
        break;
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366884));
      }
      localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).gravity = 80;
      if (this.p != -1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.p;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin  2 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_AndroidWidgetImageButton == null);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1 = (adjr)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
    boolean bool = paramBoolean;
    if (localObject1 != null) {
      if (!((adjr)localObject1).b())
      {
        bool = paramBoolean;
        if (!this.jdField_f_of_type_Boolean) {}
      }
      else
      {
        bool = paramBoolean;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aemf)) {
          bool = true;
        }
      }
    }
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      if (!bool) {
        break label583;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690745);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(ajyc.a(2131714176));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        if (this.k == -1) {
          this.k = ((LinearLayout.LayoutParams)localObject1).leftMargin;
        }
        if (this.l == -1) {
          this.l = ((LinearLayout.LayoutParams)localObject1).rightMargin;
        }
        ((LinearLayout.LayoutParams)localObject1).leftMargin = actn.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        ((LinearLayout.LayoutParams)localObject1).rightMargin = actn.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          ((RedTouch)localObject1).b();
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if (this.g == -1) {
          this.g = ((LinearLayout.LayoutParams)localObject2).rightMargin;
        }
        if (this.h == -1) {
          this.h = ((LinearLayout.LayoutParams)localObject2).leftMargin;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
        if ((this.g != -1) && (this.h != -1) && (!this.jdField_c_of_type_Boolean))
        {
          ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width + this.g + this.h + this.k + this.l - actn.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
          this.jdField_c_of_type_Boolean = true;
        }
        if (this.i == -1) {
          this.i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingLeft();
        }
        if (this.j == -1) {
          this.j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingRight();
        }
        if (this.m == -1) {
          this.m = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingTop();
        }
        if (this.n == -1) {
          this.n = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingBottom();
        }
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(0, this.o, 0, this.o);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    return;
    label583:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_e_of_type_Boolean) {}
    for (int i1 = 2130838020;; i1 = 2130838021)
    {
      ((PatchedButton)localObject1).setBackgroundResource(i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(ajyc.a(2131714171));
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        if (this.k != -1) {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = this.k;
        }
        if (this.l != -1) {
          ((LinearLayout.LayoutParams)localObject1).rightMargin = this.l;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          a((RedTouch)localObject1);
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if (this.g != -1) {
          ((LinearLayout.LayoutParams)localObject2).rightMargin = this.g;
        }
        if (this.h != -1) {
          ((LinearLayout.LayoutParams)localObject2).leftMargin = this.h;
        }
        if ((this.h != -1) && (this.g != -1) && (this.jdField_c_of_type_Boolean))
        {
          ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width - this.g - this.h - (this.k + this.l - actn.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources())));
          this.jdField_c_of_type_Boolean = false;
        }
        if ((this.i != -1) && (this.j != -1) && (this.n != -1) && (this.m != -1)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.i, this.m, this.j, this.n);
        }
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      return;
    }
  }
  
  protected boolean b()
  {
    return axmt.b();
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366884));
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout  bottomMargin  = " + localLayoutParams.bottomMargin);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (b()) && (this.jdField_b_of_type_Boolean))
    {
      if (this.q != -1) {}
      for (localLayoutParams.bottomMargin = this.q;; localLayoutParams.bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297930)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 1 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
      }
    }
    localLayoutParams.gravity = 80;
    if (this.p != -1) {
      localLayoutParams.bottomMargin = this.p;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 2 = " + localLayoutParams.bottomMargin);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "switchAnonymousChat is called! isAnonymousChat = " + paramBoolean);
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
        if (!paramBoolean) {
          break label143;
        }
        i1 = 2130838029;
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
        if (!paramBoolean) {
          break label150;
        }
        i1 = 2130837966;
        label106:
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    label143:
    label150:
    label157:
    for (int i1 = 2130838020;; i1 = 2130838021)
    {
      ((PatchedButton)localObject).setBackgroundResource(i1);
      return;
      i1 = 2130838030;
      break;
      i1 = 2130837968;
      break label106;
    }
  }
  
  public boolean c()
  {
    adjr localadjr = (adjr)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
    return (localadjr != null) && ((localadjr.b()) || (this.jdField_f_of_type_Boolean));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onCreate() called");
    }
    b();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  void e()
  {
    View localView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
    if (((localView instanceof RedTouch)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getText())))
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((avpq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10);
      ((RedTouch)localView).a(localRedTypeInfo);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onResume() called");
    }
    g();
  }
  
  public void g()
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (b()) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      int i1 = actn.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
      if ((this.jdField_b_of_type_Int == -1) || (this.jdField_c_of_type_Int == -1))
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop();
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), i1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), i1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366884));
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.gravity = 80;
        if (this.p == -1) {
          this.p = localLayoutParams.bottomMargin;
        }
        if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.q == -1)) {
          this.q = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams()).bottomMargin;
        }
        if (this.q == -1) {
          break label321;
        }
        localLayoutParams.bottomMargin = this.q;
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
      localLayoutParams.bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297930));
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_b_of_type_Int != -1) && (this.jdField_c_of_type_Int != -1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), this.jdField_c_of_type_Int);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.I) {
          break label554;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(actn.a(1.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131366884));
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.gravity = 80;
        if (this.p != -1) {
          localLayoutParams.bottomMargin = this.p;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "setSimpleUIMode() simple mode  bottomMargin 2 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
        label554:
        ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie), true);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() not in simple mode");
      }
      return;
    }
    switch (paramView.getId())
    {
    case 2131366883: 
    default: 
      return;
    case 2131362849: 
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() audio_btn");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(2));
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
      this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onClick() emo_btn");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(3));
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjg
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class agkd
  extends BaseChatPie
  implements Handler.Callback
{
  protected boolean T;
  protected alsi a;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  aoei jdField_a_of_type_Aoei;
  aoeq jdField_a_of_type_Aoeq = new agke(this);
  beps jdField_a_of_type_Beps;
  protected ConfessInfo a;
  private ConfessProgressView jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  MqqHandler b;
  private String g;
  private View o;
  private View jdField_p_of_type_AndroidViewView;
  private ImageView jdField_p_of_type_AndroidWidgetImageView;
  private int q = -1;
  
  public agkd(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new bhoe(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Alsi = new agki(this);
  }
  
  @NonNull
  private List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((ChatMessage)paramList.get(i)).getConfessTopicId() == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)
      {
        localArrayList.add(paramList.get(i));
        if ((((ChatMessage)paramList.get(i)).msgtype == 1032) && (QLog.isColorLevel())) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "ConfessChatPie has illegal msgType!");
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void bs()
  {
    long l1;
    if (aoeh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      t(false);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
    {
      this.jdField_a_of_type_Aoei.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      return;
    }
    this.jdField_a_of_type_Aoei.a(l1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
  }
  
  private void bt()
  {
    if ((this.o != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
    {
      String str = aoep.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
      if (aoeh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)) {
        this.o.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.o.setVisibility(8);
  }
  
  private void bu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843215);
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843215);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131376758).setVisibility(8);
    }
    for (;;)
    {
      try
      {
        aekt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843221);
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          aekt.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130843234);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
        }
        this.e.setTextColor(nav.c);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166898));
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843241);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(nav.c);
          this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
          this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          aekt.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundColor(-16777216);
            if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
          c(true);
          this.f.setText(alpo.a(2131702760) + this.g);
          this.f.setTextColor(-855638017);
          this.e.setTextColor(-855638017);
          Object localObject1 = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          ((View)localObject1).setBackgroundColor(-2013265920);
          Object localObject2 = new RelativeLayout.LayoutParams(-1, 2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = alpo.a(2131702761);
          if (this.T) {
            localObject1 = alpo.a(2131702762);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369371).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription((String)localObject1);
          localObject1 = new ConfessNewsBgView(this.jdField_a_of_type_AndroidContentContext);
          ((ConfessNewsBgView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
            break label926;
          }
          i = 858006566;
          ((ConfessNewsBgView)localObject1).setBgColor(i);
          ((ConfessNewsBgView)localObject1).setSize(2);
          if (aoeh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localObject1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560873, null);
            this.jdField_d_of_type_AndroidViewViewGroup.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
            localObject2 = ((View)localObject1).findViewById(2131380075);
            this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131367683));
            this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this);
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView = ((ConfessProgressView)((View)localObject1).findViewById(2131364680));
            float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.setSize(24.0F * f, 27.0F * f, -0.15F * f, -0.5F * f);
            this.o = ((View)localObject1).findViewById(2131367675);
            this.o.setVisibility(8);
            this.jdField_p_of_type_AndroidViewView = ((View)localObject1).findViewById(2131367673);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
            {
              localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
              ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = ((int)(9.0F * f));
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            this.jdField_p_of_type_AndroidViewView.setVisibility(4);
            bv();
            if (!aoeh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "holmes_guide"))
            {
              aoeh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "holmes_guide", true);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
                break label933;
              }
              localObject1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560872, null);
              ((View)localObject1).findViewById(2131367678).setOnClickListener(this);
              ((View)localObject1).setOnClickListener(this);
              this.jdField_d_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new agkf(this, (View)localObject1, (View)localObject2));
            }
            if ((this.L) && (this.jdField_p_of_type_AndroidWidgetImageView != null)) {
              this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(4);
            }
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "handleConfessUI error: " + localThrowable.getMessage());
        continue;
        if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          continue;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849988);
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(nav.c);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130837744);
        continue;
      }
      this.e.setText(this.g);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845118);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      continue;
      label926:
      int i = 268234225;
      continue;
      label933:
      View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560871, null);
    }
  }
  
  private void bv()
  {
    ThreadManager.excute(new ConfessChatPie.3(this), 16, null, true);
  }
  
  private void bw()
  {
    Object localObject = a();
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    localObject = (bhpy)bhql.a((Context)localObject, null);
    ((bhpy)localObject).a(2131690055, 5);
    ((bhpy)localObject).a(2131690673, 5);
    ((bhpy)localObject).c(2131690648);
    ((bhpy)localObject).a(new agkj(this, (bhpy)localObject));
    ((bhpy)localObject).show();
  }
  
  private void t(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView == null) || (this.jdField_p_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    ConfessConvInfo localConfessConvInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    if (localConfessConvInfo != null)
    {
      if ((localConfessConvInfo.holmesTolCount == 0) || (localConfessConvInfo.holmesCurCount != localConfessConvInfo.holmesTolCount)) {
        break label215;
      }
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130844520);
    }
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.a(localConfessConvInfo.holmesCurCount, localConfessConvInfo.holmesTolCount);
      this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(String.format(alpo.a(2131702770), new Object[] { Integer.valueOf(localConfessConvInfo.holmesTolCount), Integer.valueOf(localConfessConvInfo.holmesCurCount) }));
      if ((paramBoolean) && (localConfessConvInfo.holmesCurCount > this.q) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
      {
        if ((i != 0) && (this.jdField_p_of_type_AndroidWidgetImageView != null)) {
          this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        if (this.jdField_p_of_type_AndroidViewView != null) {
          this.jdField_p_of_type_AndroidViewView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
      this.q = localConfessConvInfo.holmesCurCount;
      bt();
      return;
      label215:
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130844519);
    }
  }
  
  public void H()
  {
    super.H();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoeq);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    br();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void N()
  {
    super.N();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
      a(-16777216, false);
    }
  }
  
  public void U()
  {
    ThreadManager.post(new ConfessChatPie.4(this), 8, null, true);
  }
  
  public void V()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public List<ChatMessage> a()
  {
    return a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false));
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return a(paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, paramBoolean));
  }
  
  public List<ChatMessage> a(boolean paramBoolean)
  {
    return a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "ConfessChatPie";
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Beps == null) {
      this.jdField_a_of_type_Beps = new beps(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Beps.a(paramInt1, paramString, paramInt2);
  }
  
  public void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    aoep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true, true);
  }
  
  public void a(DraftTextInfo paramDraftTextInfo) {}
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bu();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoeq);
    this.jdField_a_of_type_Aoei = ((aoei)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125));
    bs();
    return paramBoolean;
  }
  
  public void aY() {}
  
  public void aZ()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null)) {}
    while (ThemeUtil.isDefaultOrDIYTheme(false)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033)
    {
      Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
      ((FragmentManager)localObject).beginTransaction();
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = (ChatFragment)localObject;
        if (((ChatFragment)localObject).a != null) {
          ((ChatFragment)localObject).a.setStatusBarDrawable(a().getResources().getDrawable(2130845674));
        }
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.e.setTextColor(-1);
      this.f.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849477));
      this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369371).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setIsDefaultTheme(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849463));
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849400));
      aekt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, SkinEngine.getInstances().getDefaultThemeDrawable(2130849207));
      aekt.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, SkinEngine.getInstances().getDefaultThemeDrawable(2130849208));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
      localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130849356);
      Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849353);
      Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849357);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
      localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable(localStateListDrawable);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849257));
      return;
    }
    aekt.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130843234);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
  }
  
  public void aa()
  {
    Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
    ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = (ChatFragment)localObject;
      if (((ChatFragment)localObject).a != null) {
        ((ChatFragment)localObject).a.setStatusBarColor(1226741);
      }
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
  }
  
  public void as()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > jdField_p_of_type_Int))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131719765, 1);
      return;
    }
    acfe localacfe = new acfe();
    a(localacfe);
    localacfe.i = this.J;
    this.J = false;
    acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, null, localacfe);
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
    }
    ba();
    this.jdField_a_of_type_Agwa.a(1002, new Object[] { str });
  }
  
  protected void br()
  {
    if (this.jdField_a_of_type_Beps != null)
    {
      this.jdField_a_of_type_Beps.b();
      this.jdField_a_of_type_Beps = null;
    }
  }
  
  public int c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    String str1 = paramIntent.getStringExtra("key_confessor_nick");
    int i = paramIntent.getIntExtra("key_confessor_sex", 0);
    String str2 = paramIntent.getStringExtra("key_confess_desc");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    this.T = paramIntent.getBooleanExtra("open_chat_from_rec_confess", false);
    this.g = str1;
    paramIntent = (aoel)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269);
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ConfessChatPie", 1, "friend uin is null ,uintype = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
    label345:
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h = this.g;
      if (!this.L)
      {
        aoeg localaoeg = paramIntent.a();
        String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = localaoeg.a(str3, j, k, paramIntent, str1, i, str2, l);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label345;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, String.format("updateSession saveConfessItem frdUin:%s type:%s topicId:%d confessorNick:%s confessorSex:%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e), str1, Integer.valueOf(i) }));
        return;
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break;
        paramIntent = new ConfessInfo();
        paramIntent.reset();
        paramIntent.topicId = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        paramIntent.confessorNick = str1;
      }
    }
  }
  
  public int e()
  {
    int i = aftc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000 - 200;
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843215);
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void j() {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i = paramView.getId();
    if ((i == 2131368627) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034)) {
      bw();
    }
    do
    {
      do
      {
        return;
        if (i != 2131367678) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidWidgetPopupWindow == null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      return;
    } while (i == 2131367680);
    if (i == 2131367683)
    {
      int j = 2;
      i = j;
      if (this.o != null)
      {
        i = j;
        if (this.o.getVisibility() == 0)
        {
          this.o.setVisibility(8);
          paramView = aoep.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
          aoeh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, false);
          i = 1;
        }
      }
      String str;
      QQAppInterface localQQAppInterface;
      Context localContext;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localContext = this.jdField_a_of_type_AndroidContentContext;
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
          break label341;
        }
      }
      for (;;)
      {
        aoeh.a(localQQAppInterface, localContext, paramView, str, j, bool);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009573", "0X8009573", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e + "", "", paramView + "", str + "");
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        break;
        label341:
        bool = false;
      }
    }
    super.onClick(paramView);
  }
  
  public void x() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkd
 * JD-Core Version:    0.7.0.1
 */
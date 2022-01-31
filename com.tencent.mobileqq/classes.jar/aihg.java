import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.2;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.3;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.4;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.5;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController.6;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aihg
{
  private static boolean c = true;
  private int jdField_a_of_type_Int;
  public ajan a;
  public ApolloRender a;
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  public ApolloTextureView a;
  public BarrageView a;
  public boolean a;
  private ApolloTextureView jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public aihg()
  {
    this.jdField_a_of_type_Ajan = new aihh(this);
  }
  
  private void d()
  {
    ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
    if (localApolloRender != null)
    {
      String str = aivc.a(new File(aiys.av + "cm3d.js"));
      if (!TextUtils.isEmpty(str)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.3(this, localApolloRender, str));
      }
      if (!TextUtils.isEmpty(aifg.e)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.4(this, localApolloRender));
      }
    }
  }
  
  public ApolloTextureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getTop() >= paramInt) {
        break label69;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(4);
    }
    label69:
    do
    {
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
        {
          if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getBottom() - this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getTop() >= paramInt) {
            break;
          }
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
        }
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility() == 4) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
        }
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() != 4);
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    long l = System.currentTimeMillis();
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine chatPie is null");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine surfaceview is already inited, return.");
      return;
    }
    if (paramBaseChatPie.g() >= 7)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine aio is finished, not init apollo.");
      return;
    }
    if ((TextUtils.isEmpty(aifg.d)) || (TextUtils.isEmpty(aifg.e)))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine script empty");
      return;
    }
    if (!aiyr.d) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil cm3dPreLoad:" + bool);
      if (!bool) {
        break;
      }
      if (aisl.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label178;
      }
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !SpriteUtil.isProperAIO");
      return;
    }
    label178:
    if (!aifg.a(BaseApplicationImpl.getContext()))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Not in white list.");
      return;
    }
    azjn localazjn = ((azjh)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localazjn != null) && (localazjn.jdField_a_of_type_Boolean))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine isGag");
      return;
    }
    if (aisl.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Apollo func is double-hidden.");
      return;
    }
    if (!aisl.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !canUseCmShow");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine use:" + (System.currentTimeMillis() - l));
    }
    this.jdField_b_of_type_Boolean = false;
    ThreadManager.postImmediately(new ChatPieApolloViewController.2(this, paramBaseChatPie), null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged h:", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.onDrawRectHeightChanged(paramQQAppInterface, paramInt);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.onDrawRectHeightChanged(paramQQAppInterface, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, new Object[] { "onDrawRectHeightChanged show:", Boolean.valueOf(paramBoolean) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getVisibility();
      if (!paramBoolean) {
        break label104;
      }
      if (this.jdField_a_of_type_Int != 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
      }
    }
    label104:
    do
    {
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
        {
          this.jdField_a_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility();
          if (!paramBoolean) {
            break;
          }
          if (this.jdField_a_of_type_Int != 0) {
            this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          }
        }
        return;
        if (this.jdField_a_of_type_Int != 8) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
        }
      }
    } while (this.jdField_a_of_type_Int == 8);
    this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null);
  }
  
  public boolean a(BaseChatPie paramBaseChatPie)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, new Object[] { "ifApolloFunAvailThenInit, mApolloSurfaceView:", this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, ",mApolloTextureView:", this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView });
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "chatPie is null");
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "surfaceview is already inited, return.");
      return false;
    }
    if (!aisl.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (!aifg.a(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Not in white list.");
      }
      return false;
    }
    Object localObject = ((azjh)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localObject != null) && (((azjn)localObject).jdField_a_of_type_Boolean)) {
      return false;
    }
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start TraceReport_total");
    if (QLog.isColorLevel())
    {
      ajas.a("exeBase");
      ajas.a("exeCmshow0");
      ajas.a("exeCommon");
    }
    ajas.b("aio_pre");
    int i = aisl.b(0);
    aixo.a(i, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    aixo.a(i, 1);
    aixo.a(i, 10);
    aixo.a(i, null, new int[] { aixn.a(i, false, 0, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false) });
    localObject = (aisi)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    ((aisi)localObject).a(paramBaseChatPie);
    if (aisl.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
      }
      aixo.a(i, 10, 103, new Object[] { "double hidden" });
      return false;
    }
    if (!aisl.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    localObject = ((aisi)localObject).a();
    if (localObject != null) {
      ((SpriteUIHandler)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_Acka);
    }
    if (aiwi.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo switch NOT open.");
      }
      paramBaseChatPie.a().obtainMessage(62).sendToTarget();
    }
    for (;;)
    {
      return true;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        paramBaseChatPie.g();
      } else {
        paramBaseChatPie.a().obtainMessage(65).sendToTarget();
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().a(0L);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(0L);
    }
  }
  
  public void b(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.requestLayout();
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.requestLayout();
      }
    }
  }
  
  @TargetApi(14)
  public void b(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "initApolloSurfaceView");
    }
    if (paramBaseChatPie == null) {}
    int i;
    do
    {
      return;
      i = aisl.b(0);
      if (paramBaseChatPie.g() < 7) {
        break;
      }
      aixo.a(i, 10, 106, new Object[] { "aio is finished" });
    } while (!QLog.isColorLevel());
    QLog.d("sava_ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
    return;
    Object localObject = (aiga)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(227);
    ((aiga)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((aiga)localObject).a(((aiga)localObject).a);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "mApolloSurfaceView is already created");
      return;
    }
    boolean bool1;
    if ((Build.VERSION.SDK_INT >= 26) || (aifg.p))
    {
      bool1 = true;
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "initTextureViewConfig initApolloSurfaceView:" + bool1);
      }
      localObject = (aisi)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      aixo.a(i, 10, 0, new Object[] { "cmshow switch done" });
      aixo.a(i, 100);
      aixo.a(i, 101);
      ajas.a("onSurfaceCreated");
      if (!bool1) {
        break label696;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDestroyOnAsync(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.init(paramBaseChatPie.jdField_a_of_type_Ajdo, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setUseGlobalTimer(true);
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          ((aisi)localObject).a(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = null;
        if (aiyr.jdField_b_of_type_Boolean) {
          break label790;
        }
        bool2 = true;
        this.jdField_a_of_type_Boolean = bool2;
        QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil mPreloadEngine:" + this.jdField_a_of_type_Boolean);
        if (!this.jdField_a_of_type_Boolean) {
          break label796;
        }
        ajas.a("preLoadEngine");
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().preLoadDirector();
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null)) {
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().preLoadDirector();
        }
        ThreadManager.postImmediately(new ChatPieApolloViewController.5(this, i, paramBaseChatPie, (aisi)localObject), null, false);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        if (!paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isInMultiWindow()) {
          break label817;
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          if (Build.VERSION.SDK_INT < 11) {
            break label832;
          }
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
          if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
          }
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131303604);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131302567);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)((float)babp.j() * 0.171F));
        localLayoutParams.addRule(2, 2131302567);
        paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, localLayoutParams);
        i = aisl.a();
        if (!bool1) {
          break label854;
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
        paramBaseChatPie.a().addView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject);
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        localObject = (aifg)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if (localObject == null) {
          break;
        }
        ((aifg)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
        return;
      }
      catch (OutOfMemoryError paramBaseChatPie)
      {
        label696:
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = null;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        QLog.e("sava_ChatPieApolloViewController", 1, paramBaseChatPie, new Object[0]);
        return;
      }
      bool1 = false;
      break label142;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mRenderMode = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(paramBaseChatPie.jdField_a_of_type_Ajdo, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((aisi)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().setUseGlobalTimer(true);
      continue;
      label790:
      boolean bool2 = false;
      continue;
      label796:
      ThreadManager.excute(new ChatPieApolloViewController.6(this, paramBaseChatPie, (aisi)localObject), 16, null, false);
      continue;
      label817:
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
      continue;
      label832:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-aciy.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
      continue;
      label854:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setInitHeight(i);
      paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().b();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b();
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {}
    while ((!aifg.d()) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
    if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label253;
      }
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
      }
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
      if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
        ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(6, 2131303604);
      localLayoutParams.addRule(2, 2131302567);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
      ajay localajay = new ajay(paramBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(localajay);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(localajay);
      }
      Object localObject = (aisi)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      ((aisi)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      localObject = ((aisi)localObject).a();
      if (localObject != null) {
        localajay.a((aiij)localObject);
      }
      paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, 0, localLayoutParams);
      return;
      label253:
      localLayoutParams.bottomMargin = (-aciy.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
    }
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onResume");
    }
    if (paramBaseChatPie == null) {}
    do
    {
      do
      {
        return;
      } while (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      ((aifg)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(new WeakReference(paramBaseChatPie));
    } while (!a());
    ((aisi)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onPause");
    }
    if (paramBaseChatPie == null) {}
    while ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!a())) {
      return;
    }
    ((aisi)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void f(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onDestroy ");
    }
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] chatPie:", paramBaseChatPie });
      return;
    }
    ajam.b(this.jdField_a_of_type_Ajan);
    this.jdField_b_of_type_Boolean = true;
    Object localObject = new StringBuilder().append("onDestroy preLoad mApolloRender:");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" mApolloSurfaceView:");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {
        break label212;
      }
      bool = true;
      label103:
      localObject = ((StringBuilder)localObject).append(bool).append(" mApolloTextureView:");
      if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView == null) {
        break label217;
      }
      bool = true;
      label124:
      QLog.i("sava_ChatPieApolloViewController", 1, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) {
        break label222;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.queueDestroy();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = null;
    }
    for (;;)
    {
      ((aisi)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).onDestroy();
      if (a()) {
        break label271;
      }
      QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
      return;
      bool = false;
      break;
      label212:
      bool = false;
      break label103;
      label217:
      bool = false;
      break label124;
      label222:
      if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender();
        if (localObject != null) {
          ((ApolloRender)localObject).queueDestroy();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender();
        if (localObject != null) {
          ((ApolloRender)localObject).queueDestroy();
        }
      }
    }
    label271:
    localObject = (aiga)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(227);
    ((aiga)localObject).a(null);
    ((aiga)localObject).a(null);
    localObject = (aifc)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
    if (localObject != null) {
      ((aifc)localObject).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      paramBaseChatPie.a().removeView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      paramBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = null;
    }
    this.jdField_a_of_type_Int = 0;
    aiwj.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aihg
 * JD-Core Version:    0.7.0.1
 */
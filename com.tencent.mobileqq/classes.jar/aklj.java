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

public class aklj
{
  private static boolean c = true;
  private int jdField_a_of_type_Int;
  public alga a;
  public ApolloRender a;
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  public ApolloTextureView a;
  public BarrageView a;
  public boolean a;
  private ApolloTextureView jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public aklj()
  {
    this.jdField_a_of_type_Alga = new aklk(this);
  }
  
  private void d()
  {
    ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
    if (localApolloRender != null)
    {
      String str = alao.a(new File(alef.av + "cm3d.js"));
      if (!TextUtils.isEmpty(str)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.3(this, localApolloRender, str));
      }
      if (!TextUtils.isEmpty(akji.e)) {
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
    if ((TextUtils.isEmpty(akji.d)) || (TextUtils.isEmpty(akji.e)))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine script empty");
      return;
    }
    if (!alee.d) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil cm3dPreLoad:" + bool);
      if (!bool) {
        break;
      }
      if (akwt.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label178;
      }
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !SpriteUtil.isProperAIO");
      return;
    }
    label178:
    if (!akji.a(BaseApplicationImpl.getContext()))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Not in white list.");
      return;
    }
    bcjr localbcjr = ((bcjl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localbcjr != null) && (localbcjr.jdField_a_of_type_Boolean))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine isGag");
      return;
    }
    if (akwt.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Apollo func is double-hidden.");
      return;
    }
    if (!akwt.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
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
    if (!akwt.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (!akji.a(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Not in white list.");
      }
      return false;
    }
    Object localObject = ((bcjl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localObject != null) && (((bcjr)localObject).jdField_a_of_type_Boolean)) {
      return false;
    }
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start TraceReport_total");
    if (QLog.isColorLevel())
    {
      algf.a("exeBase");
      algf.a("exeCmshow0");
      algf.a("exeCommon");
    }
    algf.b("aio_pre");
    int i = akwt.b(0);
    alda.a(i, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    alda.a(i, 1);
    alda.a(i, 10);
    alda.a(i, null, new int[] { alcz.a(i, false, 0, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false) });
    localObject = (akwq)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    ((akwq)localObject).a(paramBaseChatPie);
    if (akwt.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
      }
      alda.a(i, 10, 103, new Object[] { "double hidden" });
      return false;
    }
    if (!akwt.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    localObject = ((akwq)localObject).a();
    if (localObject != null) {
      ((SpriteUIHandler)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_Aelz);
    }
    if (albu.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1)
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
        localLayoutParams.addRule(2, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.requestLayout();
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(2, paramInt);
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
      i = akwt.b(0);
      if (paramBaseChatPie.g() < 7) {
        break;
      }
      alda.a(i, 10, 106, new Object[] { "aio is finished" });
    } while (!QLog.isColorLevel());
    QLog.d("sava_ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
    return;
    Object localObject = (akkd)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(227);
    ((akkd)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((akkd)localObject).a(((akkd)localObject).a);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "mApolloSurfaceView is already created");
      return;
    }
    boolean bool1;
    if ((Build.VERSION.SDK_INT >= 26) || (akji.p))
    {
      bool1 = true;
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "initTextureViewConfig initApolloSurfaceView:" + bool1);
      }
      localObject = (akwq)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      alda.a(i, 10, 0, new Object[] { "cmshow switch done" });
      alda.a(i, 100);
      alda.a(i, 101);
      algf.a("onSurfaceCreated");
      if (!bool1) {
        break label743;
      }
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDestroyOnAsync(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.init(paramBaseChatPie.jdField_a_of_type_Aljb, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDumplicateCreateRenderThread(akji.q);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setUseGlobalTimer(true);
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          ((akwq)localObject).a(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = null;
        if (alee.jdField_b_of_type_Boolean) {
          break label837;
        }
        bool2 = true;
        this.jdField_a_of_type_Boolean = bool2;
        QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil mPreloadEngine:" + this.jdField_a_of_type_Boolean);
        if (!this.jdField_a_of_type_Boolean) {
          break label843;
        }
        algf.a("preLoadEngine");
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().preLoadDirector();
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null)) {
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().preLoadDirector();
        }
        ThreadManager.postImmediately(new ChatPieApolloViewController.5(this, i, paramBaseChatPie, (akwq)localObject), null, false);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        if (!paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isInMultiWindow()) {
          break label864;
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          if (Build.VERSION.SDK_INT < 11) {
            break label879;
          }
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
          if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
          }
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369509);
        aezp localaezp = (aezp)paramBaseChatPie.a(52);
        if ((localaezp == null) || (!localaezp.jdField_a_of_type_Boolean)) {
          break label901;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131376152);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)((float)bdcb.j() * 0.171F));
        if ((localaezp == null) || (!localaezp.jdField_a_of_type_Boolean)) {
          break label913;
        }
        localLayoutParams.addRule(2, 2131376152);
        paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, localLayoutParams);
        i = akwt.a();
        if (!bool1) {
          break label925;
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
        paramBaseChatPie.a().addView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject);
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        localObject = (akji)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if (localObject == null) {
          break;
        }
        ((akji)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
        return;
      }
      catch (OutOfMemoryError paramBaseChatPie)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = null;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        QLog.e("sava_ChatPieApolloViewController", 1, paramBaseChatPie, new Object[0]);
        return;
      }
      bool1 = false;
      break label142;
      label743:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mRenderMode = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(paramBaseChatPie.jdField_a_of_type_Aljb, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((akwq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().setUseGlobalTimer(true);
      continue;
      label837:
      boolean bool2 = false;
      continue;
      label843:
      ThreadManager.excute(new ChatPieApolloViewController.6(this, paramBaseChatPie, (akwq)localObject), 16, null, false);
      continue;
      label864:
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
      continue;
      label879:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-aekt.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
      continue;
      label901:
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368333);
      continue;
      label913:
      localLayoutParams.addRule(2, 2131368333);
      continue;
      label925:
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
  
  public void c(int paramInt)
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
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {}
    while ((!akji.e()) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
    if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label274;
      }
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener == null) {
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
      }
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener.jdField_a_of_type_Int = 0;
      if ((paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent() instanceof ViewGroup)) {
        ((ViewGroup)paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).addOnLayoutChangeListener(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
      }
    }
    localLayoutParams.addRule(6, 2131369509);
    Object localObject1 = (aezp)paramBaseChatPie.a(52);
    if ((localObject1 != null) && (((aezp)localObject1).jdField_a_of_type_Boolean)) {
      localLayoutParams.addRule(2, 2131376152);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, null);
      localObject1 = new algl(paramBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init((akmo)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback((akmm)localObject1);
      }
      Object localObject2 = (akwq)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      ((akwq)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      localObject2 = ((akwq)localObject2).a();
      if (localObject2 != null) {
        ((algl)localObject1).a((akmm)localObject2);
      }
      paramBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, 0, localLayoutParams);
      return;
      label274:
      localLayoutParams.bottomMargin = (-aekt.a(5.0F, paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getResources()));
      break;
      localLayoutParams.addRule(2, 2131368333);
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
      ((akji)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(new WeakReference(paramBaseChatPie));
    } while (!a());
    ((akwq)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    ((akwq)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    alfz.b(this.jdField_a_of_type_Alga);
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
      ((akwq)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).onDestroy();
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
    localObject = (akkd)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(227);
    ((akkd)localObject).a(null);
    ((akkd)localObject).a(null);
    localObject = (akje)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
    if (localObject != null) {
      ((akje)localObject).a();
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
    albv.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklj
 * JD-Core Version:    0.7.0.1
 */
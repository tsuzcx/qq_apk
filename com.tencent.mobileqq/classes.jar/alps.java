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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class alps
  implements afsr
{
  private static boolean jdField_c_of_type_Boolean = true;
  private int jdField_a_of_type_Int;
  public amkm a;
  public ApolloRender a;
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  public ApolloTextureView a;
  public BarrageView a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ApolloTextureView jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  
  public alps()
  {
    this.jdField_a_of_type_Amkm = new alpt(this);
  }
  
  private void d()
  {
    ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
    if (localApolloRender != null)
    {
      String str = amey.a(new File(amip.av + "cm3d.js"));
      if (!TextUtils.isEmpty(str)) {
        localApolloRender.queueRenderTask(new ChatPieApolloViewController.3(this, localApolloRender, str));
      }
      if (!TextUtils.isEmpty(alnr.e)) {
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
    int j;
    int i;
    if (paramInt == 0)
    {
      j = 1;
      if (j != 0) {
        break label94;
      }
      if (Build.VERSION.SDK_INT < 11) {
        break label80;
      }
      i = this.jdField_b_of_type_Int;
    }
    for (;;)
    {
      label23:
      QLog.d("sava_ChatPieApolloViewController", 1, new Object[] { "onVisibilityChanged, visibility=", Integer.valueOf(paramInt), ", bottomMargin=", Integer.valueOf(i) });
      if (j != 0) {}
      for (paramInt = 2131376868;; paramInt = 2131368751)
      {
        c(paramInt);
        e(i);
        return;
        j = 0;
        break;
        label80:
        i = this.jdField_c_of_type_Int;
        break label23;
      }
      label94:
      i = 0;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    long l = System.currentTimeMillis();
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.sessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine chatPie is null");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine surfaceview is already inited, return.");
      return;
    }
    if (paramBaseChatPie.getCurrentAIOState() >= 7)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine aio is finished, not init apollo.");
      return;
    }
    if ((TextUtils.isEmpty(alnr.d)) || (TextUtils.isEmpty(alnr.e)))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine script empty");
      return;
    }
    if (!amio.d) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil cm3dPreLoad:" + bool);
      if (!bool) {
        break;
      }
      if (ambc.a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin)) {
        break label178;
      }
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine !SpriteUtil.isProperAIO");
      return;
    }
    label178:
    if (!alnr.a(BaseApplicationImpl.getContext()))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Not in white list.");
      return;
    }
    bfcf localbfcf = ((bfbz)paramBaseChatPie.app.getManager(48)).a(paramBaseChatPie.sessionInfo.curFriendUin, true);
    if ((localbfcf != null) && (localbfcf.jdField_a_of_type_Boolean))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine isGag");
      return;
    }
    if (ambc.a(paramBaseChatPie.app))
    {
      QLog.d("sava_ChatPieApolloViewController", 1, "Apollo func is double-hidden.");
      return;
    }
    if (!ambc.b(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin))
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
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.sessionInfo == null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "chatPie is null");
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.i("sava_ChatPieApolloViewController", 1, "surfaceview is already inited, return.");
      return false;
    }
    if (!ambc.a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin)) {
      return false;
    }
    Object localObject = (amaz)paramBaseChatPie.app.getManager(249);
    ((amaz)localObject).a(paramBaseChatPie);
    boolean bool = ((amaz)localObject).a().g();
    if ((!alnr.a(BaseApplicationImpl.getContext())) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Not in white list.");
      }
      return false;
    }
    bfcf localbfcf = ((bfbz)paramBaseChatPie.app.getManager(48)).a(paramBaseChatPie.sessionInfo.curFriendUin, true);
    if ((localbfcf != null) && (localbfcf.jdField_a_of_type_Boolean)) {
      return false;
    }
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start TraceReport_total isNoneApolloActionPlay:" + bool);
    if (QLog.isColorLevel())
    {
      amkr.a("exeBase");
      amkr.a("exeCmshow0");
      amkr.a("exeCommon");
    }
    amkr.b("aio_pre");
    int i = ambc.b(0);
    amhk.a(i, paramBaseChatPie.sessionInfo.curFriendUin);
    amhk.a(i, 1);
    amhk.a(i, 10);
    amhk.a(i, null, new int[] { amhj.a(i, false, 0, paramBaseChatPie.sessionInfo.curType, false) });
    if (ambc.a(paramBaseChatPie.app))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo func is double-hidden.");
      }
      amhk.a(i, 10, 103, new Object[] { "double hidden" });
      return false;
    }
    if (!ambc.b(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin)) {
      return false;
    }
    localObject = ((amaz)localObject).a();
    if (localObject != null) {
      ((SpriteUIHandler)localObject).a(paramBaseChatPie.listView, paramBaseChatPie.listAdapter);
    }
    if ((amge.a(paramBaseChatPie.app.getCurrentAccountUin(), paramBaseChatPie.app) != 1) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "Apollo switch NOT open.");
      }
      paramBaseChatPie.getUIHandler().obtainMessage(62).sendToTarget();
    }
    for (;;)
    {
      return true;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        paramBaseChatPie.initApolloSurfaceView();
      } else {
        paramBaseChatPie.getUIHandler().obtainMessage(65).sendToTarget();
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
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getBottom();
      j = this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getTop();
      if ((i <= 0) || (i - j >= paramInt)) {
        break label177;
      }
      QLog.i("sava_ChatPieApolloViewController", 1, "checkApolloViewLayout invisible apolloBottom:" + i + ",apolloTop:" + j + ",titleHeight:" + paramInt);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(4);
    }
    label177:
    do
    {
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
        {
          i = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getBottom();
          j = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getTop();
          if ((i <= 0) || (i - j >= paramInt)) {
            break;
          }
          QLog.i("sava_ChatPieApolloViewController", 1, "checkApolloViewLayout invisible apolloBottom:" + i + ",apolloTop:" + j + ",titleHeight:" + paramInt);
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
  
  @TargetApi(14)
  public void b(BaseChatPie paramBaseChatPie)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "initApolloSurfaceView");
    }
    if (paramBaseChatPie == null) {}
    int j;
    do
    {
      return;
      j = ambc.b(0);
      if (paramBaseChatPie.getCurrentAIOState() < 7) {
        break;
      }
      amhk.a(j, 10, 106, new Object[] { "aio is finished" });
    } while (!QLog.isColorLevel());
    QLog.d("sava_ChatPieApolloViewController", 2, "aio is finished, not init apollo.");
    return;
    Object localObject1;
    if (paramBaseChatPie.app != null)
    {
      localObject1 = (alom)paramBaseChatPie.app.getManager(227);
      ((alom)localObject1).a(paramBaseChatPie.sessionInfo);
      ((alom)localObject1).a(((alom)localObject1).a);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      QLog.e("sava_ChatPieApolloViewController", 1, "mApolloSurfaceView is already created");
      return;
    }
    boolean bool1;
    if ((Build.VERSION.SDK_INT >= 26) || (alnr.p))
    {
      bool1 = true;
      label152:
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "initTextureViewConfig initApolloSurfaceView:" + bool1);
      }
      if (paramBaseChatPie.app == null) {
        break label768;
      }
      localObject1 = (amaz)paramBaseChatPie.app.getManager(249);
      label207:
      amhk.a(j, 10, 0, new Object[] { "cmshow switch done" });
      amhk.a(j, 100);
      amhk.a(j, 101);
      amkr.a("onSurfaceCreated");
      if (!bool1) {
        break label774;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.mContext, null);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDestroyOnAsync(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.init(paramBaseChatPie.mApolloViewObserver, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setDumplicateCreateRenderThread(alnr.q);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setUseGlobalTimer(true);
        if (paramBaseChatPie.app != null) {
          ((amaz)localObject1).a(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = null;
        if (amio.jdField_b_of_type_Boolean) {
          break label868;
        }
        bool2 = true;
        this.jdField_a_of_type_Boolean = bool2;
        QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil mPreloadEngine:" + this.jdField_a_of_type_Boolean);
        if (!this.jdField_a_of_type_Boolean) {
          break label874;
        }
        amkr.a("preLoadEngine");
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().preLoadDirector();
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null)) {
          this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().preLoadDirector();
        }
        ThreadManager.postImmediately(new ChatPieApolloViewController.5(this, j, paramBaseChatPie, (amaz)localObject1), null, false);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        if (!paramBaseChatPie.mActivity.isInMultiWindow()) {
          break label895;
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
        localObject2 = (afsn)paramBaseChatPie.getHelper(52);
        if (localObject2 != null) {
          ((afsn)localObject2).a(this);
        }
        if ((localObject2 == null) || (!((afsn)localObject2).b())) {
          break label910;
        }
        if (paramBaseChatPie.input != null)
        {
          if (Build.VERSION.SDK_INT < 11) {
            break label915;
          }
          if (paramBaseChatPie.mInputGloblLayoutListener == null) {
            paramBaseChatPie.mInputGloblLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
          }
          paramBaseChatPie.mInputGloblLayoutListener.jdField_a_of_type_Int = 0;
          if ((paramBaseChatPie.input.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramBaseChatPie.input.getParent()).addOnLayoutChangeListener(paramBaseChatPie.mInputGloblLayoutListener);
          }
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131370017);
        if (i == 0) {
          break label949;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131376868);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(paramBaseChatPie.mContext);
        localObject2 = new RelativeLayout.LayoutParams(-1, (int)((float)DeviceInfoUtil.getPortraitHeight() * 0.171F));
        if (i == 0) {
          break label960;
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131376868);
        paramBaseChatPie.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, (ViewGroup.LayoutParams)localObject2);
        i = ambc.a();
        if (!bool1) {
          break label971;
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
        paramBaseChatPie.getContent().addView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject1);
        if (paramBaseChatPie.app == null) {
          break;
        }
        localObject1 = (alnr)paramBaseChatPie.app.getManager(153);
        if (localObject1 == null) {
          break;
        }
        ((alnr)localObject1).a(paramBaseChatPie.sessionInfo, paramBaseChatPie.mContext);
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
      break label152;
      label768:
      localObject1 = null;
      break label207;
      label774:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramBaseChatPie.mContext, null, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mRenderMode = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(paramBaseChatPie.mApolloViewObserver, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      if (paramBaseChatPie.app != null) {
        ((amaz)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().setUseGlobalTimer(true);
      continue;
      label868:
      boolean bool2 = false;
      continue;
      label874:
      ThreadManager.excute(new ChatPieApolloViewController.6(this, paramBaseChatPie, (amaz)localObject1), 16, null, false);
      continue;
      label895:
      ((RelativeLayout.LayoutParams)localObject1).topMargin = paramBaseChatPie.mCustomTitleView.getHeight();
      continue;
      label910:
      i = 0;
      continue;
      label915:
      this.jdField_c_of_type_Int = AIOUtils.dp2px(5.0F, paramBaseChatPie.input.getResources());
      if (i == 0)
      {
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (-this.jdField_c_of_type_Int);
        continue;
        label949:
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131368751);
        continue;
        label960:
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131368751);
        continue;
        label971:
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setBarrageView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setInitHeight(i);
        paramBaseChatPie.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, (ViewGroup.LayoutParams)localObject1);
      }
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(2, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.requestLayout();
      }
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "addApolloBackView");
    }
    if (paramBaseChatPie == null) {}
    while ((!alnr.e()) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = paramBaseChatPie.mCustomTitleView.getHeight();
    Object localObject1 = (afsn)paramBaseChatPie.getHelper(52);
    int i;
    if ((localObject1 != null) && (((afsn)localObject1).b()))
    {
      i = 1;
      if (paramBaseChatPie.input != null)
      {
        if (Build.VERSION.SDK_INT < 11) {
          break label291;
        }
        if (paramBaseChatPie.mInputGloblLayoutListener == null) {
          paramBaseChatPie.mInputGloblLayoutListener = new InputGlobalLayoutListener(paramBaseChatPie);
        }
        paramBaseChatPie.mInputGloblLayoutListener.jdField_a_of_type_Int = 0;
        if ((paramBaseChatPie.input.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramBaseChatPie.input.getParent()).addOnLayoutChangeListener(paramBaseChatPie.mInputGloblLayoutListener);
        }
      }
      label152:
      localLayoutParams.addRule(6, 2131370017);
      if (i == 0) {
        break label324;
      }
      localLayoutParams.addRule(2, 2131376868);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramBaseChatPie.mContext, null);
      localObject1 = new amkx(paramBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init((alqx)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback((alqv)localObject1);
      }
      Object localObject2 = (amaz)paramBaseChatPie.app.getManager(249);
      ((amaz)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      localObject2 = ((amaz)localObject2).a();
      if (localObject2 != null) {
        ((amkx)localObject1).a((alqv)localObject2);
      }
      paramBaseChatPie.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, 0, localLayoutParams);
      return;
      i = 0;
      break;
      label291:
      this.jdField_c_of_type_Int = AIOUtils.dp2px(5.0F, paramBaseChatPie.input.getResources());
      if (i != 0) {
        break label152;
      }
      localLayoutParams.bottomMargin = (-this.jdField_c_of_type_Int);
      break label152;
      label324:
      localLayoutParams.addRule(2, 2131368751);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
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
      } while (paramBaseChatPie.app == null);
      ((alnr)paramBaseChatPie.app.getManager(153)).a(new WeakReference(paramBaseChatPie));
    } while (!a());
    ((amaz)paramBaseChatPie.app.getManager(249)).b(paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  public void e(int paramInt)
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = (-paramInt);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.requestLayout();
      }
    }
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onPause");
    }
    if (paramBaseChatPie == null) {}
    while ((paramBaseChatPie.app == null) || (!a())) {
      return;
    }
    ((amaz)paramBaseChatPie.app.getManager(249)).a(paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  public void f(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ChatPieApolloViewController", 2, "onDestroy ");
    }
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null)) {
      QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] chatPie:", paramBaseChatPie });
    }
    label103:
    label124:
    do
    {
      return;
      amkk.b(this.jdField_a_of_type_Amkm);
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
        localObject = ((StringBuilder)localObject).append(bool).append(" mApolloTextureView:");
        if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView == null) {
          break label217;
        }
        bool = true;
        QLog.i("sava_ChatPieApolloViewController", 1, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) {
          break label222;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.queueDestroy();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = null;
      }
      for (;;)
      {
        ((amaz)paramBaseChatPie.app.getManager(249)).onDestroy();
        if (a()) {
          break label271;
        }
        QLog.e("sava_ChatPieApolloViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
        return;
        bool = false;
        break;
        bool = false;
        break label103;
        bool = false;
        break label124;
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
      localObject = (alom)paramBaseChatPie.app.getManager(227);
      ((alom)localObject).a(null);
      ((alom)localObject).a(null);
      localObject = (alnn)paramBaseChatPie.app.getManager(211);
      if (localObject != null) {
        ((alnn)localObject).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        paramBaseChatPie.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
        paramBaseChatPie.getContent().removeView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        paramBaseChatPie.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a();
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
        paramBaseChatPie.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = null;
      }
      this.jdField_a_of_type_Int = 0;
      amgf.a().a();
      paramBaseChatPie = (afsn)paramBaseChatPie.getHelper(52);
    } while (paramBaseChatPie == null);
    label212:
    label217:
    label222:
    paramBaseChatPie.b(this);
    label271:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alps
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.initData.1;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.initTitle.1;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingTitle;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingDialog;", "Landroid/app/Dialog;", "Landroid/arch/lifecycle/LifecycleOwner;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "countDownTime", "", "hasCountDownComplete", "", "mActivity", "Landroid/app/Activity;", "mIntent", "Landroid/content/Intent;", "mLifecycleRegistry", "Landroid/arch/lifecycle/LifecycleRegistry;", "mModel", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoModel;", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mRootView", "Landroid/view/View;", "mSavedActivityIntent", "mViewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "mWebView", "Lcom/tencent/biz/ui/TouchWebView;", "mWebViewBuilder", "Lcom/tencent/gdtad/views/videoceiling/GdtWebViewBuilder;", "titleContainer", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle;", "viewModel", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingViewModel;", "dispatchLifeCycleEvent", "", "event", "Landroid/arch/lifecycle/Lifecycle$Event;", "doOnBackEvent", "fitSpecialScreen", "activity", "titlePart", "getLifecycle", "Landroid/arch/lifecycle/Lifecycle;", "getViewModelStore", "handleMotiveBrowsingData", "browsingData", "Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData;", "initData", "initTitle", "initView", "initWeb", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestory", "onDialogCancelClick", "onDialogConfirmClick", "onStart", "onStop", "sendRewardedCallback", "setDataModel", "mode", "setIntent", "intent", "watchTimeNotCompleteMention", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class acml
  extends ReportDialog
  implements LifecycleOwner, ViewModelStoreOwner
{
  public static final acmm a;
  private int jdField_a_of_type_Int;
  private acnd jdField_a_of_type_Acnd;
  private acoe jdField_a_of_type_Acoe;
  private acuc jdField_a_of_type_Acuc;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
  private final ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore = new ViewModelStore();
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  private bgpa jdField_a_of_type_Bgpa;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtMotiveBrowsingTitle jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
  private boolean jdField_a_of_type_Boolean;
  private Intent b;
  
  static
  {
    jdField_a_of_type_Acmm = new acmm(null);
  }
  
  public acml(@NotNull Context paramContext)
  {
    super(paramContext, 16973834);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
  }
  
  private final void a(acnh paramacnh)
  {
    boolean bool = true;
    QLog.i("GdtMotiveBrowsingDialog", 1, "handleMotiveBrowsingData browsingData: " + paramacnh);
    int i = paramacnh.a();
    String str = paramacnh.a();
    int j = paramacnh.b();
    switch (i)
    {
    default: 
    case 0: 
      do
      {
        return;
        paramacnh = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      } while (paramacnh == null);
      paramacnh.evaluateJavascript(str, (ValueCallback)acmn.a);
      return;
    }
    if (j <= 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramacnh = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
      if (paramacnh == null) {
        break;
      }
      paramacnh.a(j);
      return;
      bool = false;
    }
  }
  
  private final void a(Lifecycle.Event paramEvent)
  {
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(paramEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("GdtMotiveBrowsingDialog", 1, "handleLifecycleEvent fail : event -> " + paramEvent, localThrowable);
    }
  }
  
  private final void b()
  {
    Object localObject = getWindow();
    if (Build.VERSION.SDK_INT >= 28)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      ((Window)localObject).setAttributes(localLayoutParams);
    }
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((Window)localObject).setFlags(1024, 1024);
    ((Window)localObject).setVolumeControlStream(3);
    localObject = ((Window)localObject).getDecorView();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    ((ViewGroup)localObject).setSystemUiVisibility(7942);
    if (Build.VERSION.SDK_INT >= 19) {
      ((ViewGroup)localObject).setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)new acmo((ViewGroup)localObject));
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(2131559227, (ViewGroup)localObject, false);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.i("GdtMotiveBrowsingDialog", 1, "mRootView == null");
      return;
    }
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOnDismissListener((DialogInterface.OnDismissListener)new acmp(this));
    ((ViewGroup)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new acmq(this, (ViewGroup)localObject));
  }
  
  private final void c()
  {
    if (this.jdField_a_of_type_Acoe == null)
    {
      QLog.i("GdtMotiveBrowsingDialog", 1, "mModel == null");
      return;
    }
    Object localObject = axbe.a((ViewModelStoreOwner)this).get(acnd.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ofViewModelProvider(this…ingViewModel::class.java)");
    this.jdField_a_of_type_Acnd = ((acnd)localObject);
    localObject = this.jdField_a_of_type_Acoe;
    if (localObject != null)
    {
      localObject = ((acoe)localObject).a();
      if (localObject == null) {}
    }
    for (int i = ((GdtMotiveVideoPageData)localObject).getVideoCountDown();; i = 0)
    {
      int j = i;
      if (i <= 0) {
        j = 15;
      }
      this.jdField_a_of_type_Int = j;
      localObject = this.jdField_a_of_type_Acnd;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((acnd)localObject).a(this.jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_Acnd;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      axbe.a(this, (LiveData)((acnd)localObject).a(), (Function1)new GdtMotiveBrowsingDialog.initData.1((acml)this));
      this.b = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      this.jdField_a_of_type_AndroidAppActivity.setIntent(this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  private final void d()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
    localObject1 = (AppInterface)localObject1;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView((Context)this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Acuc = ((acuc)new acmr(this, (AppInterface)localObject1, (Context)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity, null, (AppInterface)localObject1));
    Object localObject2 = this.jdField_a_of_type_Acuc;
    if (localObject2 != null) {
      ((acuc)localObject2).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    }
    localObject2 = this.jdField_a_of_type_Acuc;
    if (localObject2 != null) {
      ((acuc)localObject2).a(null);
    }
    new bhmg((bhmj)this.jdField_a_of_type_Acuc).a(null, (AppInterface)localObject1, null);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null)
    {
      localObject1 = (FrameLayout)((View)localObject1).findViewById(2131381150);
      if (localObject1 != null) {
        ((FrameLayout)localObject1).addView((View)this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      }
      localObject1 = this.jdField_a_of_type_Acoe;
      if (localObject1 == null) {
        break label264;
      }
      localObject1 = ((acoe)localObject1).a();
      if (localObject1 == null) {
        break label264;
      }
      localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info;
      if (localObject1 == null) {
        break label264;
      }
      localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject1).landing_page;
      if (localObject1 == null) {
        break label264;
      }
    }
    label264:
    for (localObject1 = ((PBStringField)localObject1).get();; localObject1 = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
        if (localObject2 != null) {
          ((TouchWebView)localObject2).loadUrl((String)localObject1);
        }
      }
      QLog.i("GdtMotiveBrowsingDialog", 1, "initWebView url = " + (String)localObject1);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private final void e()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle = new GdtMotiveBrowsingTitle((Context)this.jdField_a_of_type_AndroidAppActivity);
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localObject != null) {
      ((GdtMotiveBrowsingTitle)localObject).setOnCloseClickListener((Function0)new GdtMotiveBrowsingDialog.initTitle.1((acml)this));
    }
    int i = bgtn.b(15.0F);
    localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localObject != null) {
      ((GdtMotiveBrowsingTitle)localObject).setPadding(i, i, i, i);
    }
    localObject = new FrameLayout.LayoutParams(-1, -1);
    GdtMotiveBrowsingTitle localGdtMotiveBrowsingTitle = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localGdtMotiveBrowsingTitle != null) {
      localGdtMotiveBrowsingTitle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {}
    for (localObject = (FrameLayout)((View)localObject).findViewById(2131378815);; localObject = null)
    {
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle);
      }
      ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), true);
      ImmersiveUtils.a(true, this.jdField_a_of_type_AndroidAppActivity.getWindow());
      a(this.jdField_a_of_type_AndroidAppActivity, (View)localObject);
      return;
    }
  }
  
  private final void f()
  {
    Object localObject = this.jdField_a_of_type_Bgpa;
    if (localObject != null) {
      ((bgpa)localObject).dismiss();
    }
    this.jdField_a_of_type_Bgpa = bglp.a((Context)this.jdField_a_of_type_AndroidAppActivity, 0, null, (CharSequence)this.jdField_a_of_type_AndroidAppActivity.getString(2131692592), this.jdField_a_of_type_AndroidAppActivity.getString(2131692589), this.jdField_a_of_type_AndroidAppActivity.getString(2131692590), (DialogInterface.OnClickListener)new acms(this), (DialogInterface.OnClickListener)new acmt(this));
    localObject = this.jdField_a_of_type_Bgpa;
    if (localObject != null)
    {
      ((bgpa)localObject).show();
      localObject = ((bgpa)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setSystemUiVisibility(7942);
        }
      }
      localObject = this.jdField_a_of_type_Acnd;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((acnd)localObject).a();
    }
    localObject = this.jdField_a_of_type_Bgpa;
    if (localObject != null) {
      ((bgpa)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new acmu(this));
    }
  }
  
  private final void g()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "DialogInterface onClick confirm");
    bgpa localbgpa = this.jdField_a_of_type_Bgpa;
    if (localbgpa != null) {
      localbgpa.dismiss();
    }
    this.jdField_a_of_type_Bgpa = ((bgpa)null);
  }
  
  private final void h()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "DialogInterface onClick onCancel");
    bgpa localbgpa = this.jdField_a_of_type_Bgpa;
    if (localbgpa != null) {
      localbgpa.dismiss();
    }
    this.jdField_a_of_type_Bgpa = ((bgpa)null);
    i();
    super.onBackPressed();
  }
  
  private final void i()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "sendRewardedCallback");
    Object localObject1 = this.jdField_a_of_type_Acoe;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((acoe)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((GdtMotiveVideoPageData)localObject1).motiveBrowsingKey;
        if (localObject1 != null)
        {
          localObject2 = StringsKt.split$default((CharSequence)localObject1, new String[] { "#" }, false, 0, 6, null);
          if (((Collection)localObject2).isEmpty()) {
            break label159;
          }
        }
      }
    }
    label159:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = new Intent((String)((List)localObject2).get(0));
        ((Intent)localObject2).putExtra("duration_time", this.jdField_a_of_type_Int * 1000L);
        ((Intent)localObject2).putExtra("elapsed_time", this.jdField_a_of_type_Int * 1000L);
        ((Intent)localObject2).putExtra("profitable_flag", this.jdField_a_of_type_Boolean);
        ((Intent)localObject2).putExtra("KEY_MOTIVE_BROWSING", (String)localObject1);
        this.jdField_a_of_type_AndroidAppActivity.sendBroadcast((Intent)localObject2);
      }
      return;
    }
  }
  
  private final void j()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onDestory");
    this.jdField_a_of_type_AndroidAppActivity.setIntent(this.b);
    Object localObject = this.jdField_a_of_type_Bgpa;
    if (localObject != null) {
      ((bgpa)localObject).dismiss();
    }
    this.jdField_a_of_type_Bgpa = ((bgpa)null);
    if (this.jdField_a_of_type_Acuc != null)
    {
      localObject = this.jdField_a_of_type_Acuc;
      if (localObject != null) {
        ((acuc)localObject).c();
      }
      this.jdField_a_of_type_Acuc = ((acuc)null);
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)null);
      }
    }
    else
    {
      a(Lifecycle.Event.ON_DESTROY);
      if ((this.jdField_a_of_type_AndroidAppActivity == null) || (!this.jdField_a_of_type_AndroidAppActivity.isChangingConfigurations())) {
        break label168;
      }
    }
    label168:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        QLog.i("GdtMotiveBrowsingDialog", 1, "mViewModelStore.clear()");
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
      }
      return;
      localObject = null;
      break;
    }
  }
  
  public final void a()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "doOnBackEvent");
    if (!this.jdField_a_of_type_Boolean)
    {
      f();
      return;
    }
    i();
    super.onBackPressed();
  }
  
  public final void a(@NotNull acoe paramacoe)
  {
    Intrinsics.checkParameterIsNotNull(paramacoe, "mode");
    this.jdField_a_of_type_Acoe = paramacoe;
  }
  
  public final void a(@NotNull Activity paramActivity, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (paramView != null)
    {
      bqcd.a(paramActivity);
      if (bqcd.b())
      {
        Object localObject = paramView.getLayoutParams();
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).topMargin = bqcd.b(paramActivity);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        QLog.i("GdtMotiveBrowsingDialog", 1, "fitSpecialScreen addHeight = " + ((LinearLayout.LayoutParams)localObject).topMargin);
      }
    }
  }
  
  public final void a(@NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  @NotNull
  public Lifecycle getLifecycle()
  {
    return (Lifecycle)this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry;
  }
  
  @NotNull
  public ViewModelStore getViewModelStore()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  }
  
  public void onBackPressed()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onBackPressed");
    a();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("GdtMotiveBrowsingDialog", 1, "onCreate");
    a(Lifecycle.Event.ON_CREATE);
    b();
    e();
    d();
    c();
  }
  
  protected void onStart()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onStart");
    super.onStart();
    acuc localacuc = this.jdField_a_of_type_Acuc;
    if (localacuc != null) {
      localacuc.a();
    }
    a(Lifecycle.Event.ON_START);
    a(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStop()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onStop");
    super.onStop();
    acuc localacuc = this.jdField_a_of_type_Acuc;
    if (localacuc != null) {
      localacuc.b();
    }
    a(Lifecycle.Event.ON_PAUSE);
    a(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acml
 * JD-Core Version:    0.7.0.1
 */
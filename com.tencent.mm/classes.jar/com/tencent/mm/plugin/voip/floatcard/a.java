package com.tencent.mm.plugin.voip.floatcard;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.PowerManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager;", "", "()V", "accDescription", "", "activityIntent", "Landroid/content/Intent;", "animator", "Landroid/animation/Animator;", "appForegroundDelegateListener", "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$appForegroundDelegateListener$1", "Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$appForegroundDelegateListener$1;", "cardHeight", "", "getCardHeight", "()I", "setCardHeight", "(I)V", "dynamicTextWrap", "Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$DynamicTextWrap;", "getDynamicTextWrap", "()Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$DynamicTextWrap;", "setDynamicTextWrap", "(Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$DynamicTextWrap;)V", "fingerDownY", "", "fling", "", "floatView", "Landroid/view/View;", "getFloatView", "()Landroid/view/View;", "setFloatView", "(Landroid/view/View;)V", "floatViewContainer", "floatWindowGestureDetector", "Landroid/view/GestureDetector;", "gestureDetectorListener", "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1;", "mIsShow", "getMIsShow", "()Z", "setMIsShow", "(Z)V", "processJob", "Lkotlinx/coroutines/Job;", "processScope", "Lkotlinx/coroutines/CoroutineScope;", "getProcessScope", "()Lkotlinx/coroutines/CoroutineScope;", "setProcessScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "roomKey", "", "getRoomKey", "()J", "setRoomKey", "(J)V", "scrollerState", "toUser", "viewDownY", "windowManager", "Landroid/view/ViewManager;", "createAccDesc", "dismissCard", "", "quickHide", "releaseViewAndIntent", "getAccButtonDrawable", "getBackgroundBitmap", "Landroid/graphics/Bitmap;", "avatar", "w", "h", "getNotificationText", "getRealY", "y", "hideCard", "initView", "intent", "isCardModeShow", "isMultitalk", "onAccept", "onBackground", "onDown", "e", "Landroid/view/MotionEvent;", "lp", "Landroid/view/WindowManager$LayoutParams;", "onDragFinish", "onFling", "onFullscreen", "onReject", "view", "showCard", "context", "Landroid/content/Context;", "quickShow", "updateBackground", "Companion", "DynamicTextWrap", "WindowManagerProxy", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a Uvi = new a.a((byte)0);
  private long Hnt;
  private int Mjx;
  public boolean Mxl;
  protected View RWj;
  private cb Uvj;
  private volatile aq Uvk;
  private ViewManager Uvl;
  private b Uvm;
  private int Uvn;
  private float Uvo;
  private int Uvp;
  private String Uvq = "";
  private View Uvr;
  private final f Uvs = new f(this);
  private GestureDetector Uvt;
  private final d Uvu = new d(this);
  private Animator bCA;
  private boolean nnd;
  private Intent sVM;
  private String toUser = "";
  
  private static final void a(View paramView, a parama, ValueAnimator paramValueAnimator)
  {
    s.u(paramView, "$view");
    s.u(parama, "this$0");
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof WindowManager.LayoutParams)) {
      localObject = (WindowManager.LayoutParams)localObject;
    }
    while (localObject != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        localObject = null;
      }
      else
      {
        ((WindowManager.LayoutParams)localObject).y = ((Integer)paramValueAnimator).intValue();
        parama = parama.Uvl;
        if (parama != null) {
          parama.updateViewLayout(paramView, (ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private static final void a(a parama, Intent paramIntent, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramIntent);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramIntent, "$intent");
    Log.i("VoipFloatCardManager", "initView: onAccept clicked");
    parama.bf(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(a parama, Bitmap paramBitmap, View paramView1, ImageView paramImageView, View paramView2)
  {
    s.u(parama, "this$0");
    s.u(paramView1, "$this_apply");
    aq localaq = parama.Uvk;
    if (localaq != null) {
      j.a(localaq, null, null, (m)new a.i(paramBitmap, parama, paramView1, paramImageView, paramView2, null), 3);
    }
  }
  
  private static final void a(final a parama, View paramView)
  {
    s.u(parama, "this$0");
    s.u(paramView, "$it");
    parama.Mjx = paramView.getMeasuredHeight();
    Object localObject = parama.bCA;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = ValueAnimator.ofInt(new int[] { -parama.Mjx, 0 });
    View localView = parama.RWj;
    if (localView != null) {
      ((ValueAnimator)localObject).addUpdateListener(new a..ExternalSyntheticLambda0(localView, parama));
    }
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new h(paramView, parama));
    ((ValueAnimator)localObject).setDuration(200L);
    ((ValueAnimator)localObject).start();
    paramView = ah.aiuX;
    parama.bCA = ((Animator)localObject);
  }
  
  private static final boolean a(a parama, View paramView1, View paramView2, MotionEvent paramMotionEvent)
  {
    s.u(parama, "this$0");
    s.u(paramView1, "$this_apply");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      parama = parama.Uvt;
      if (parama != null) {
        break;
      }
      return false;
      s.s(paramMotionEvent, "event");
      paramView1 = paramView1.getLayoutParams();
      if (paramView1 == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
      }
      paramView1 = (WindowManager.LayoutParams)paramView1;
      Log.i("VoipFloatCardManager", "onDown: ");
      parama.Uvo = paramMotionEvent.getRawY();
      parama.Uvn = paramView1.y;
      parama.Uvp = 0;
      continue;
      s.s(paramMotionEvent, "event");
      Log.i("VoipFloatCardManager", "onDragFinish: ");
      if ((parama.nnd) || (parama.dD(paramMotionEvent.getRawY()) > parama.Uvn))
      {
        parama.nnd = false;
      }
      else
      {
        paramView1 = ValueAnimator.ofInt(new int[] { parama.dD(paramMotionEvent.getRawY()), parama.Uvn });
        paramView2 = parama.RWj;
        if (paramView2 != null) {
          paramView1.addUpdateListener(new a..ExternalSyntheticLambda1(paramView2, parama));
        }
        paramView1.setDuration(300L);
        paramView1.start();
      }
    }
    paramView1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramView1.aYi(), "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager", "initView$lambda-15$lambda-14", "(Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager;Landroid/view/View;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    return com.tencent.mm.hellhoundlib.a.a.a(parama, parama.onTouchEvent((MotionEvent)paramView1.sb(0)), "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager", "initView$lambda-15$lambda-14", "(Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager;Landroid/view/View;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
  }
  
  private static final void b(View paramView, a parama, ValueAnimator paramValueAnimator)
  {
    s.u(paramView, "$view");
    s.u(parama, "this$0");
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof WindowManager.LayoutParams)) {
      localObject = (WindowManager.LayoutParams)localObject;
    }
    while (localObject != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        localObject = null;
      }
      else
      {
        ((WindowManager.LayoutParams)localObject).y = ((Integer)paramValueAnimator).intValue();
        parama = parama.Uvl;
        if (parama != null) {
          parama.updateViewLayout(paramView, (ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private static final void b(a parama, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    Log.i("VoipFloatCardManager", "initView: onReject clicked");
    a(parama, false, false, 3);
    parama.fvW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void c(View paramView, a parama, ValueAnimator paramValueAnimator)
  {
    s.u(paramView, "$it");
    s.u(parama, "this$0");
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof WindowManager.LayoutParams)) {
      localObject = (WindowManager.LayoutParams)localObject;
    }
    while (localObject != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        localObject = null;
      }
      else
      {
        ((WindowManager.LayoutParams)localObject).y = ((Integer)paramValueAnimator).intValue();
        parama = parama.Uvl;
        if (parama != null) {
          parama.updateViewLayout(paramView, (ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private final int dD(float paramFloat)
  {
    return this.Uvn + (int)(paramFloat - this.Uvo);
  }
  
  public final void a(Context paramContext, Intent paramIntent, long paramLong, String paramString)
  {
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    s.u(paramString, "toUser");
    Log.i("VoipFloatCardManager", "showCard() called with: context = " + paramContext + ", intent = " + paramIntent + ", roomKey = " + paramLong + ", toUser = " + paramString + ", quickShow = false");
    this.Hnt = paramLong;
    AppForegroundDelegate.heY.a((q)this.Uvu);
    Object localObject;
    if (this.Uvj == null)
    {
      localObject = cg.e(null);
      this.Uvk = ar.d(bg.kCi().plus((f)localObject));
      ah localah = ah.aiuX;
      this.Uvj = ((cb)localObject);
    }
    if (this.Uvl == null)
    {
      localObject = paramContext.getSystemService("window");
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      }
      this.Uvl = ((ViewManager)new a.c((WindowManager)localObject));
    }
    if (this.RWj == null)
    {
      this.Uvt = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)this.Uvs);
      this.RWj = LayoutInflater.from(paramContext).inflate(b.e.float_card_view, null, false);
    }
    this.sVM = paramIntent;
    g(paramIntent, paramString);
    paramIntent = new WindowManager.LayoutParams();
    if (com.tencent.mm.compatible.util.d.rb(26)) {}
    for (int i = 2038;; i = 2002)
    {
      paramIntent.type = i;
      paramIntent.flags = 552;
      paramIntent.format = 1;
      paramIntent.packageName = paramContext.getPackageName();
      paramIntent.gravity = 49;
      paramIntent.width = -1;
      paramIntent.height = -2;
      paramContext = this.RWj;
      if (paramContext != null)
      {
        paramContext.setVisibility(4);
        paramString = this.Uvl;
        if (paramString != null) {
          paramString.addView(paramContext, (ViewGroup.LayoutParams)paramIntent);
        }
        paramContext.post(new a..ExternalSyntheticLambda7(this, paramContext));
      }
      return;
    }
  }
  
  protected final void a(b paramb)
  {
    this.Uvm = paramb;
  }
  
  public void aB(boolean paramBoolean1, final boolean paramBoolean2)
  {
    Log.i("VoipFloatCardManager", "dismissCard() called with: quickHide = " + paramBoolean1 + ", releaseViewAndIntent = " + paramBoolean2);
    AppForegroundDelegate.heY.b((q)this.Uvu);
    Object localObject1 = com.tencent.mm.plugin.voip.d.d.UGN;
    com.tencent.mm.plugin.voip.d.d.hZO();
    localObject1 = this.RWj;
    Object localObject2;
    if (localObject1 != null)
    {
      if (!paramBoolean1) {
        break label163;
      }
      localObject2 = this.Uvl;
      if (localObject2 != null) {
        ((ViewManager)localObject2).removeView((View)localObject1);
      }
      localObject2 = com.tencent.mm.plugin.voip.d.d.UGN;
      com.tencent.mm.plugin.voip.d.d.hZP();
      this.Uvl = null;
      if (paramBoolean2) {
        kw((View)localObject1);
      }
    }
    for (;;)
    {
      this.nnd = false;
      localObject1 = this.Uvm;
      if (localObject1 != null) {
        ((b)localObject1).hVz();
      }
      this.Uvm = null;
      this.Uvk = null;
      localObject1 = this.Uvj;
      if (localObject1 != null) {
        ((cb)localObject1).a(null);
      }
      this.Uvj = null;
      this.toUser = "";
      return;
      label163:
      localObject2 = this.bCA;
      if (localObject2 != null) {
        ((Animator)localObject2).cancel();
      }
      localObject2 = ValueAnimator.ofInt(new int[] { 0, -this.Mjx });
      ((ValueAnimator)localObject2).addUpdateListener(new a..ExternalSyntheticLambda2((View)localObject1, this));
      ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new e(this, (View)localObject1, paramBoolean2));
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).start();
      localObject1 = ah.aiuX;
      this.bCA = ((Animator)localObject2);
    }
  }
  
  protected abstract void bf(Intent paramIntent);
  
  protected abstract void bg(Intent paramIntent);
  
  protected abstract void fvW();
  
  protected void g(Intent paramIntent, String paramString)
  {
    s.u(paramIntent, "intent");
    s.u(paramString, "toUser");
    Log.i("VoipFloatCardManager", "initView: ");
    View localView = this.RWj;
    if (localView != null)
    {
      Object localObject1 = aa.getDisplayName(((n)h.ax(n.class)).bzA().JE(paramString).field_username);
      this.toUser = paramString;
      Object localObject2 = ((n)h.ax(n.class)).bzA().JE(paramString);
      this.Uvr = localView.findViewById(b.d.float_card_view_container);
      ((TextView)localView.findViewById(b.d.notification_username)).setText((CharSequence)localObject1);
      Object localObject3 = com.tencent.mm.openim.room.a.a.X((au)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = (TextView)localView.findViewById(b.d.notification_username);
        localObject3 = new SpannableString((CharSequence)(localObject1 + ' ' + localObject3));
        ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(localView.getResources().getColor(b.a.open_im_display_name_color)), ((String)localObject1).length() + 1, ((SpannableString)localObject3).length(), 33);
        localObject1 = ah.aiuX;
        ((TextView)localObject2).setText((CharSequence)localObject3);
      }
      com.tencent.mm.pluginsdk.ui.a.b.g((ImageView)localView.findViewById(b.d.notification_avatar), paramString);
      paramString = (TextView)localView.findViewById(b.d.notification_tip);
      int i = ghc();
      paramString.setText(i);
      this.Uvq = paramString.getText().toString();
      if (this.Uvm == null) {
        this.Uvm = new b();
      }
      localObject1 = this.Uvm;
      if (localObject1 != null) {
        ((b)localObject1).hVz();
      }
      localObject1 = this.Uvm;
      if (localObject1 != null)
      {
        s.s(paramString, "it");
        localObject2 = localView.getResources().getString(i);
        s.s(localObject2, "resources.getString(text)");
        ((b)localObject1).h(paramString, (String)localObject2);
      }
      localView.findViewById(b.d.notification_reject_call).setOnClickListener(new a..ExternalSyntheticLambda3(this));
      paramString = localView.findViewById(b.d.notification_accept_call);
      paramString.setBackground(paramString.getResources().getDrawable(ghd()));
      paramString.setOnClickListener(new a..ExternalSyntheticLambda4(this, paramIntent));
      paramIntent = (ImageView)localView.findViewById(b.d.notification_mask);
      paramString = this.Uvk;
      if (paramString != null) {
        j.a(paramString, null, null, (m)new a.g(paramIntent, localView, null), 3);
      }
      hVy();
      localView.setOnTouchListener(new a..ExternalSyntheticLambda5(this, localView));
    }
  }
  
  protected abstract void gha();
  
  protected void ghb()
  {
    Log.i("VoipFloatCardManager", "hideCard() called");
    a(this, true, false, 2);
    this.Mxl = false;
  }
  
  protected abstract int ghc();
  
  protected abstract int ghd();
  
  public String ghf()
  {
    Object localObject = (n)h.ax(n.class);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      localObject = aa.getDisplayName((String)localObject);
      return localObject + this.Uvq + ',';
      localObject = ((n)localObject).bzA();
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = ((bx)localObject).JE(this.toUser);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((az)localObject).field_username;
        }
      }
    }
  }
  
  protected final long hVw()
  {
    return this.Hnt;
  }
  
  protected final b hVx()
  {
    return this.Uvm;
  }
  
  protected final void hVy()
  {
    int i;
    if (((CharSequence)this.toUser).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label27;
      }
    }
    label27:
    View localView;
    do
    {
      return;
      i = 0;
      break;
      localView = this.RWj;
    } while (localView == null);
    localView.post(new a..ExternalSyntheticLambda6(this, com.tencent.mm.modelavatar.d.a(this.toUser, false, 0, null), localView, (ImageView)localView.findViewById(b.d.notification_mask), localView.findViewById(b.d.notification_bg_container)));
  }
  
  public final void kw(View paramView)
  {
    s.u(paramView, "view");
    Log.i("VoipFloatCardManager", "releaseViewAndIntent: view: " + paramView + " floatView: " + this.RWj);
    if (s.p(this.RWj, paramView))
    {
      this.sVM = null;
      this.RWj = null;
    }
  }
  
  protected void onBackground() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$DynamicTextWrap;", "", "()V", "mBasePointStr", "", "", "[Ljava/lang/String;", "mRepeatCnt", "", "mRepeatInterval", "mShowedText", "mTextView", "Landroid/widget/TextView;", "mTimerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "startDynamicText", "", "tv", "baseStr", "interval", "stopDynamicText", "uninit", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final a.b.a Uvv;
    private String[] Uvw;
    private String[] Uvx;
    private int Uvy;
    private int Uvz;
    private MTimerHandler eln;
    private TextView sQ;
    
    static
    {
      AppMethodBeat.i(292292);
      Uvv = new a.b.a((byte)0);
      AppMethodBeat.o(292292);
    }
    
    public b()
    {
      AppMethodBeat.i(292277);
      String[] arrayOfString = new String[1];
      for (int i = 0; i <= 0; i = 1) {
        arrayOfString[0] = "";
      }
      this.Uvw = arrayOfString;
      this.Uvx = new String[] { "...", "", ".", ".." };
      this.eln = new MTimerHandler(new a.b..ExternalSyntheticLambda0(this), true);
      AppMethodBeat.o(292277);
    }
    
    private static final boolean b(b paramb)
    {
      AppMethodBeat.i(292284);
      s.u(paramb, "this$0");
      TextView localTextView = paramb.sQ;
      if (localTextView != null) {
        localTextView.setText((CharSequence)paramb.Uvw[(paramb.Uvz % paramb.Uvw.length)]);
      }
      paramb.Uvz += 1;
      AppMethodBeat.o(292284);
      return true;
    }
    
    public final void h(TextView paramTextView, String paramString)
    {
      AppMethodBeat.i(292313);
      s.u(paramTextView, "tv");
      s.u(paramString, "baseStr");
      hVz();
      this.Uvz = 0;
      this.sQ = paramTextView;
      this.Uvy = 500;
      String[] arrayOfString = this.Uvx;
      Collection localCollection = (Collection)new ArrayList(arrayOfString.length);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localCollection.add(s.X(paramString, arrayOfString[i]));
        i += 1;
      }
      paramString = ((Collection)localCollection).toArray(new String[0]);
      if (paramString == null)
      {
        paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(292313);
        throw paramTextView;
      }
      this.Uvw = ((String[])paramString);
      if (this.eln != null)
      {
        paramString = this.eln;
        s.checkNotNull(paramString);
        paramString.startTimer(this.Uvy);
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", s.X("start textview:", paramTextView), new Object[0]);
      AppMethodBeat.o(292313);
    }
    
    public final void hVz()
    {
      AppMethodBeat.i(292318);
      if (this.eln != null)
      {
        MTimerHandler localMTimerHandler = this.eln;
        s.checkNotNull(localMTimerHandler);
        localMTimerHandler.stopTimer();
      }
      Log.printDebugStack("MicroMsg.DynamicTextWrap", s.X("stop textview: ", this.sQ), new Object[0]);
      this.sQ = null;
      AppMethodBeat.o(292318);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$appForegroundDelegateListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements q
  {
    d(a parama) {}
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(292265);
      Log.i("VoipFloatCardManager", "onAppBackground: ");
      paramString = this.UvA.RWj;
      if (paramString == null)
      {
        paramString = null;
        if (!(paramString instanceof PowerManager)) {
          break label118;
        }
        paramString = (PowerManager)paramString;
        label38:
        if (paramString != null) {
          break label123;
        }
      }
      label118:
      label123:
      for (boolean bool = true;; bool = paramString.isInteractive())
      {
        if (!bool) {
          break label131;
        }
        Log.i("VoipFloatCardManager", "onAppBackground: hideCard");
        j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new a(this.UvA, null), 2);
        AppMethodBeat.o(292265);
        return;
        paramString = paramString.getContext();
        if (paramString == null)
        {
          paramString = null;
          break;
        }
        paramString = paramString.getSystemService("power");
        break;
        paramString = null;
        break label38;
      }
      label131:
      this.UvA.onBackground();
      AppMethodBeat.o(292265);
    }
    
    public final void onAppForeground(String paramString) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(a parama, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(292304);
        paramObject = (kotlin.d.d)new a(this.UvA, paramd);
        AppMethodBeat.o(292304);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(292297);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(292297);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        if (this.UvA.RWj != null) {
          this.UvA.ghb();
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(292297);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$dismissCard$1$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(a parama, View paramView, boolean paramBoolean) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(292261);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = a.c(this.UvA);
      if (paramAnimator != null) {
        paramAnimator.removeView(this.DjW);
      }
      paramAnimator = com.tencent.mm.plugin.voip.d.d.UGN;
      com.tencent.mm.plugin.voip.d.d.hZP();
      if (paramBoolean2) {
        this.UvA.kw(this.DjW);
      }
      a.d(this.UvA);
      a.a(this.UvA);
      this.UvA.Mxl = false;
      AppMethodBeat.o(292261);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "onScroll", "distanceX", "distanceY", "onSingleTapConfirmed", "e", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends GestureDetector.SimpleOnGestureListener
  {
    f(a parama) {}
    
    private static final void a(WindowManager.LayoutParams paramLayoutParams, a parama, View paramView, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(292260);
      s.u(paramLayoutParams, "$lp");
      s.u(parama, "this$0");
      s.u(paramView, "$view");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(292260);
        throw paramLayoutParams;
      }
      paramLayoutParams.y = ((Integer)paramValueAnimator).intValue();
      parama = a.c(parama);
      if (parama != null) {
        parama.updateViewLayout(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
      }
      AppMethodBeat.o(292260);
    }
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(292314);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(292314);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(292305);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(292305);
      return bool;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(292272);
      Log.i("VoipFloatCardManager", "onFling: " + a.e(this.UvA) + ' ' + a.f(this.UvA));
      if ((a.e(this.UvA) == 1) && (paramMotionEvent2 != null))
      {
        a.g(this.UvA);
        View localView = this.UvA.RWj;
        a locala;
        if (localView != null)
        {
          locala = this.UvA;
          paramMotionEvent1 = localView.getLayoutParams();
          if (!(paramMotionEvent1 instanceof WindowManager.LayoutParams)) {
            break label198;
          }
        }
        label198:
        for (paramMotionEvent1 = (WindowManager.LayoutParams)paramMotionEvent1;; paramMotionEvent1 = null)
        {
          if (paramMotionEvent1 != null)
          {
            paramMotionEvent2 = ValueAnimator.ofInt(new int[] { a.a(locala, paramMotionEvent2.getRawY()), -(int)(a.i(locala) + localView.getHeight()) });
            paramMotionEvent2.addListener((Animator.AnimatorListener)new a(locala));
            paramMotionEvent2.addUpdateListener(new a.f..ExternalSyntheticLambda0(paramMotionEvent1, locala, localView));
            paramMotionEvent2.setDuration(300L);
            paramMotionEvent2.start();
          }
          AppMethodBeat.o(292272);
          return true;
        }
      }
      AppMethodBeat.o(292272);
      return false;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(292298);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(292298);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(292276);
      if (paramMotionEvent2 == null)
      {
        AppMethodBeat.o(292276);
        return false;
      }
      Log.i("VoipFloatCardManager", s.X("onScroll: ", Integer.valueOf(a.e(this.UvA))));
      int i;
      View localView;
      a locala;
      if (a.e(this.UvA) == 0)
      {
        paramMotionEvent1 = this.UvA;
        if (paramFloat2 > 0.0F)
        {
          i = 1;
          a.a(paramMotionEvent1, i);
        }
      }
      else
      {
        if (Math.abs(paramFloat2) <= 2.0F) {
          break label180;
        }
        localView = this.UvA.RWj;
        if (localView != null)
        {
          locala = this.UvA;
          paramMotionEvent1 = localView.getLayoutParams();
          if (!(paramMotionEvent1 instanceof WindowManager.LayoutParams)) {
            break label175;
          }
        }
      }
      label175:
      for (paramMotionEvent1 = (WindowManager.LayoutParams)paramMotionEvent1;; paramMotionEvent1 = null)
      {
        if (paramMotionEvent1 != null)
        {
          paramMotionEvent1.y = Math.min(a.a(locala, paramMotionEvent2.getRawY()), a.j(locala));
          paramMotionEvent2 = a.c(locala);
          if (paramMotionEvent2 != null) {
            paramMotionEvent2.updateViewLayout(localView, (ViewGroup.LayoutParams)paramMotionEvent1);
          }
        }
        AppMethodBeat.o(292276);
        return true;
        i = 2;
        break;
      }
      label180:
      AppMethodBeat.o(292276);
      return false;
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(292283);
      Log.i("VoipFloatCardManager", "onSingleTapConfirmed: ");
      paramMotionEvent = a.h(this.UvA);
      if (paramMotionEvent != null) {
        this.UvA.bg(paramMotionEvent);
      }
      AppMethodBeat.o(292283);
      return true;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(292289);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(292289);
      return bool;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$gestureDetectorListener$1$onFling$1$1$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Animator.AnimatorListener
    {
      a(a parama) {}
      
      public final void onAnimationCancel(Animator paramAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(292290);
        a.a(this.UvA, true, false, 2);
        this.UvA.gha();
        AppMethodBeat.o(292290);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator) {}
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$showCard$2$1$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends AnimatorListenerAdapter
  {
    h(View paramView, a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(292308);
      super.onAnimationEnd(paramAnimator);
      parama.Mxl = true;
      a.a(parama);
      View localView = a.b(parama);
      String str;
      if (localView != null)
      {
        str = parama.ghf();
        paramAnimator = a.b(parama);
        if (paramAnimator != null) {
          break label100;
        }
        paramAnimator = localObject;
      }
      for (;;)
      {
        localView.setContentDescription((CharSequence)s.X(str, paramAnimator));
        paramAnimator = a.b(parama);
        if (paramAnimator != null) {
          paramAnimator.sendAccessibilityEvent(128);
        }
        AppMethodBeat.o(292308);
        return;
        label100:
        Context localContext = paramAnimator.getContext();
        paramAnimator = localObject;
        if (localContext != null) {
          paramAnimator = localContext.getString(b.g.voip_maximize_button);
        }
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(292288);
      super.onAnimationStart(paramAnimator);
      this.DjW.setVisibility(0);
      AppMethodBeat.o(292288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.floatcard.a
 * JD-Core Version:    0.7.0.1
 */
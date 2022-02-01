package com.tencent.mm.ui.widget.a;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.be;
import com.tencent.mm.ui.m;
import java.util.LinkedList;
import kotlin.ah;
import kotlin.g.b.s;

public class h
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean GwR;
  public boolean GwS;
  private LinearLayout GwU;
  private View GwV;
  private TextView GwW;
  protected int GwY;
  protected boolean GwZ;
  public ViewGroup Gxa;
  private ViewGroup Gxb;
  private LinkedList<h.b> Gxc;
  public c agfD;
  private h.a agfE;
  private be agfF;
  protected int bO;
  protected Context mContext;
  protected View mF;
  private ViewTreeObserver mP;
  private int muY;
  public View rootView;
  private boolean sRA;
  protected Dialog sRs;
  protected BottomSheetBehavior sRv;
  private boolean sRw;
  private int sRx;
  private boolean sRz;
  
  public h(Context paramContext)
  {
    this(paramContext, (byte)0);
    AppMethodBeat.i(251794);
    init(paramContext);
    AppMethodBeat.o(251794);
  }
  
  private h(Context paramContext, byte paramByte)
  {
    this(paramContext, '\000');
    AppMethodBeat.i(251798);
    init(paramContext);
    AppMethodBeat.o(251798);
  }
  
  private h(Context paramContext, char paramChar)
  {
    this(paramContext, 0, false, false);
  }
  
  public h(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(251813);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.sRA = false;
    this.agfD = null;
    this.GwY = a.j.BottomSheetDialog;
    this.Gxc = new LinkedList();
    this.mContext = paramContext;
    init(paramContext);
    this.sRA = paramBoolean2;
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.bO = 0;
    paramContext = this.mContext;
    if (this.sRA) {
      this.sRs = new b(paramContext);
    }
    for (;;)
    {
      this.rootView = View.inflate(paramContext, a.g.mm_custom_half_bottom_dialog, null);
      this.Gxa = ((ViewGroup)this.rootView.findViewById(a.f.bottom_sheet_content_container));
      this.Gxb = ((ViewGroup)this.rootView.findViewById(a.f.bottom_sheet_page_container));
      this.GwU = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_cancel));
      this.GwV = this.rootView.findViewById(a.f.cancel_space);
      this.GwW = ((TextView)this.rootView.findViewById(a.f.cancel_text));
      this.GwU.setOnClickListener(new h.1(this));
      this.sRw = isLandscape();
      this.sRs.requestWindowFeature(1);
      this.sRs.setContentView(this.rootView);
      if ((!this.sRA) && (!paramBoolean1))
      {
        this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
        fkg();
      }
      this.sRs.setOnKeyListener(new h..ExternalSyntheticLambda0(this));
      this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(251876);
          if (h.c(h.this) != null)
          {
            if (!h.c(h.this).isAlive()) {
              h.a(h.this, h.this.mF.getViewTreeObserver());
            }
            h.c(h.this).removeGlobalOnLayoutListener(h.this);
            h.a(h.this, null);
          }
          if (!h.d(h.this)) {
            h.this.sRs = null;
          }
          if (h.e(h.this) != null) {
            h.e(h.this).onDismiss();
          }
          h.f(h.this).setTranslationX(0.0F);
          h.f(h.this).setVisibility(0);
          h.g(h.this).removeAllViews();
          h.h(h.this).clear();
          AppMethodBeat.o(251876);
        }
      });
      AppMethodBeat.o(251813);
      return;
      if (paramBoolean1) {
        this.sRs = new l(paramContext, a.j.CustomSheetStyle);
      } else {
        this.sRs = new com.google.android.material.bottomsheet.a(paramContext, this.GwY);
      }
    }
  }
  
  private void a(final h.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(251829);
    final View localView = this.Gxb.getChildAt(this.Gxc.indexOf(paramb));
    if (localView == null)
    {
      AppMethodBeat.o(251829);
      return;
    }
    if (!paramBoolean)
    {
      localView.setVisibility(8);
      paramb.flD();
      paramb.JfN = null;
      this.Gxc.remove(paramb);
      this.Gxb.removeView(localView);
      AppMethodBeat.o(251829);
      return;
    }
    this.agfF.a(localView, new kotlin.g.a.a() {}, this.Gxb.getWidth());
    AppMethodBeat.o(251829);
  }
  
  private void fkg()
  {
    AppMethodBeat.i(251823);
    if (this.sRv != null)
    {
      if (this.bO > 0)
      {
        this.sRv.setState(4);
        this.sRv.setPeekHeight(this.bO);
        AppMethodBeat.o(251823);
        return;
      }
      this.sRv.setState(3);
    }
    AppMethodBeat.o(251823);
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(251817);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(251817);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(251803);
    this.agfF = new be(paramContext);
    AppMethodBeat.o(251803);
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(251832);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(251832);
      return true;
    }
    AppMethodBeat.o(251832);
    return false;
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(251904);
    if (paramb == null)
    {
      AppMethodBeat.o(251904);
      return;
    }
    if ((this.sRs != null) && (!this.sRs.isShowing())) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      localObject1 = paramb.E(this.Gxb);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(251904);
      return;
    }
    paramb.JfN = this;
    this.Gxc.add(paramb);
    ((View)localObject1).setVisibility(8);
    this.Gxb.addView((View)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).gravity = 80;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject3;
    float f;
    label188:
    Object localObject4;
    if (this.Gxc.contains(paramb))
    {
      int j = this.Gxc.indexOf(paramb);
      localObject3 = this.Gxb.getChildAt(j);
      if (localObject3 != null)
      {
        if (j <= 0) {
          break label479;
        }
        localObject1 = this.Gxb.getChildAt(j - 1);
        ((View)localObject3).setVisibility(0);
        paramb.eAM();
        if (i == 0) {
          break label488;
        }
        f = 0.0F;
        ((View)localObject3).setTranslationX(f);
        if (i == 0)
        {
          localObject4 = this.agfF;
          f = this.Gxb.getWidth();
          s.u(localObject3, "view");
          if (((be)localObject4).GCf == null) {
            break label513;
          }
          paramb = ((be)localObject4).GCf;
          if (paramb != null) {
            break label500;
          }
          paramb = null;
          label241:
          if (!(paramb instanceof View)) {
            break label508;
          }
          paramb = (View)paramb;
          label253:
          if (!s.p(paramb, localObject3)) {
            break label513;
          }
          be.hQ("WeUISlideAnimHelper", "slideFromRight view:" + ((View)localObject3).hashCode() + " reuseAnim");
          paramb = ((be)localObject4).adLd;
          if (paramb != null) {
            paramb.b((View)localObject3, null);
          }
          paramb = ((be)localObject4).GCf;
          if (paramb != null) {
            paramb.start();
          }
          if (localObject1 != null)
          {
            localObject3 = this.agfF;
            localObject4 = new h.3(this, (View)localObject1);
            f = this.Gxb.getWidth();
            s.u(localObject1, "view");
            if (((be)localObject3).adLh == null) {
              break label646;
            }
            paramb = ((be)localObject3).adLh;
            if (paramb != null) {
              break label633;
            }
            paramb = null;
            label386:
            if (!(paramb instanceof View)) {
              break label641;
            }
          }
        }
      }
    }
    label513:
    label641:
    for (paramb = (View)paramb;; paramb = null)
    {
      if (!s.p(paramb, localObject1)) {
        break label646;
      }
      be.hQ("WeUISlideAnimHelper", "slideToLeftAnim view:" + ((View)localObject1).hashCode() + " reuseAnim");
      paramb = ((be)localObject3).adLi;
      if (paramb != null) {
        paramb.b((View)localObject1, (kotlin.g.a.a)localObject4);
      }
      paramb = ((be)localObject3).adLh;
      if (paramb != null) {
        paramb.start();
      }
      AppMethodBeat.o(251904);
      return;
      label479:
      localObject1 = this.Gxa;
      break;
      label488:
      f = this.Gxb.getWidth();
      break label188;
      label500:
      paramb = paramb.getTarget();
      break label241;
      label508:
      paramb = null;
      break label253;
      if (f == 0.0F)
      {
        i = 1;
        label521:
        if (i == 0) {
          break label630;
        }
        f = ((be)localObject4).getWIDTH();
      }
      label630:
      for (;;)
      {
        ((be)localObject4).GCf = ObjectAnimator.ofFloat(localObject3, "translationX", new float[] { f, 0.0F });
        localObject2 = ((be)localObject4).adLd;
        paramb = (h.b)localObject2;
        if (localObject2 == null) {
          paramb = new m();
        }
        ((be)localObject4).adLd = paramb;
        paramb = ((be)localObject4).GCf;
        if (paramb != null) {
          paramb.addListener((Animator.AnimatorListener)((be)localObject4).adLd);
        }
        paramb = ((be)localObject4).GCf;
        if (paramb == null) {
          break;
        }
        paramb.setTarget(localObject3);
        break;
        i = 0;
        break label521;
      }
      label633:
      paramb = paramb.getTarget();
      break label386;
    }
    label646:
    if (f == 0.0F)
    {
      i = 1;
      label654:
      if (i == 0) {
        break label764;
      }
      f = ((be)localObject3).getWIDTH();
    }
    label764:
    for (;;)
    {
      ((be)localObject3).adLh = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { 0.0F, -f });
      localObject2 = ((be)localObject3).adLi;
      paramb = (h.b)localObject2;
      if (localObject2 == null) {
        paramb = new m();
      }
      ((be)localObject3).adLi = paramb;
      paramb = ((be)localObject3).adLh;
      if (paramb != null) {
        paramb.addListener((Animator.AnimatorListener)((be)localObject3).adLi);
      }
      paramb = ((be)localObject3).adLh;
      if (paramb == null) {
        break;
      }
      paramb.setTarget(localObject1);
      break;
      i = 0;
      break label654;
    }
  }
  
  public final h aFa(int paramInt)
  {
    AppMethodBeat.i(251877);
    LayoutInflater.from(this.rootView.getContext()).inflate(paramInt, this.Gxa, true);
    AppMethodBeat.o(251877);
    return this;
  }
  
  public final void b(h.b paramb)
  {
    AppMethodBeat.i(251909);
    if (!this.Gxc.contains(paramb))
    {
      AppMethodBeat.o(251909);
      return;
    }
    int i = this.Gxc.indexOf(paramb);
    Object localObject1;
    be localbe;
    float f;
    if (i > 0)
    {
      localObject1 = this.Gxb.getChildAt(i - 1);
      ((View)localObject1).setVisibility(0);
      localbe = this.agfF;
      f = this.Gxb.getWidth();
      s.u(localObject1, "view");
      if (localbe.adLf == null) {
        break label258;
      }
      localObject2 = localbe.adLf;
      if (localObject2 != null) {
        break label242;
      }
      localObject2 = null;
      label101:
      if (!(localObject2 instanceof View)) {
        break label252;
      }
    }
    int j;
    label242:
    label252:
    for (Object localObject2 = (View)localObject2;; localObject2 = null)
    {
      if (!s.p(localObject2, localObject1)) {
        break label258;
      }
      be.hQ("WeUISlideAnimHelper", "slideFromLeft view:" + ((View)localObject1).hashCode() + " reuseAnim");
      localObject2 = localbe.adLg;
      if (localObject2 != null) {
        ((m)localObject2).b((View)localObject1, null);
      }
      localObject1 = localbe.adLf;
      if (localObject1 != null) {
        ((ObjectAnimator)localObject1).start();
      }
      a((h.b)this.Gxc.peekLast(), true);
      j = this.Gxc.indexOf(paramb);
      if (j >= 0) {
        break label388;
      }
      AppMethodBeat.o(251909);
      return;
      localObject1 = this.Gxa;
      break;
      localObject2 = ((ObjectAnimator)localObject2).getTarget();
      break label101;
    }
    label258:
    if (f == 0.0F)
    {
      i = 1;
      label266:
      if (i == 0) {
        break label385;
      }
      f = localbe.getWIDTH();
    }
    label385:
    for (;;)
    {
      localbe.adLf = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { -f, 0.0F });
      m localm = localbe.adLg;
      localObject2 = localm;
      if (localm == null) {
        localObject2 = new m();
      }
      localbe.adLg = ((m)localObject2);
      localObject2 = localbe.adLf;
      if (localObject2 != null) {
        ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)localbe.adLg);
      }
      localObject2 = localbe.adLf;
      if (localObject2 == null) {
        break;
      }
      ((ObjectAnimator)localObject2).setTarget(localObject1);
      break;
      i = 0;
      break label266;
    }
    label388:
    i = this.Gxc.size() - 2;
    while (i >= j)
    {
      a((h.b)this.Gxc.get(i), false);
      i -= 1;
    }
    AppMethodBeat.o(251909);
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(251924);
    if (this.sRs != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.sRs.dismiss();
      }
      if (this.sRv != null) {
        this.sRv.dqC = true;
      }
    }
    AppMethodBeat.o(251924);
  }
  
  public final h d(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(251894);
    this.Gxa.addView(paramView, 0, paramLayoutParams);
    AppMethodBeat.o(251894);
    return this;
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(251918);
    this.sRw = isLandscape();
    this.sRx = getRotation();
    if (this.sRs != null)
    {
      ((ViewGroup)this.rootView.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
      if ((!this.sRA) && (this.sRw) && (this.mF != null))
      {
        Object localObject = new Rect();
        this.mF.getWindowVisibleDisplayFrame((Rect)localObject);
        localLayoutParams.width = Math.min(((Rect)localObject).right, ((Rect)localObject).bottom);
        localLayoutParams.gravity = 1;
        localObject = this.rootView.getParent();
        if ((localObject instanceof View)) {
          ((View)localObject).setOnTouchListener(new h.5(this, (ViewParent)localObject));
        }
        if (((localObject instanceof ViewGroup)) && ((((ViewGroup)localObject).getLayoutParams() instanceof CoordinatorLayout.d)))
        {
          localObject = (CoordinatorLayout.d)((ViewGroup)localObject).getLayoutParams();
          BottomSheetBehavior local6 = new BottomSheetBehavior() {};
          ((CoordinatorLayout.d)localObject).a(local6);
          this.sRv = local6;
          fkg();
        }
      }
      this.rootView.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.sRs.getWindow().addFlags(-2147483648);
      }
      if ((this.GwR) && (Build.VERSION.SDK_INT >= 23) && (this.sRs != null))
      {
        this.sRs.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.sRs.getWindow().setStatusBarColor(0);
      }
      if (!this.sRz) {
        break label420;
      }
      this.sRs.getWindow().setFlags(8, 8);
      this.sRs.getWindow().addFlags(131200);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.mF != null) {
        if (this.mP != null) {
          break label475;
        }
      }
    }
    label420:
    label475:
    for (int i = 1;; i = 0)
    {
      this.mP = this.mF.getViewTreeObserver();
      if (i != 0) {
        this.mP.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.sRs.show();
      }
      if (this.sRv != null) {
        this.sRv.dqC = this.GwZ;
      }
      AppMethodBeat.o(251918);
      return;
      this.sRs.getWindow().clearFlags(8);
      this.sRs.getWindow().clearFlags(131072);
      this.sRs.getWindow().clearFlags(128);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void fkh()
  {
    AppMethodBeat.i(251886);
    this.Gxa.setBackgroundColor(this.mContext.getResources().getColor(a.c.transparent));
    AppMethodBeat.o(251886);
  }
  
  public final Window getWindow()
  {
    AppMethodBeat.i(251911);
    if (this.sRs != null)
    {
      Window localWindow = this.sRs.getWindow();
      AppMethodBeat.o(251911);
      return localWindow;
    }
    AppMethodBeat.o(251911);
    return null;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(251927);
    if ((this.sRs != null) && (this.sRs.isShowing()))
    {
      AppMethodBeat.o(251927);
      return true;
    }
    AppMethodBeat.o(251927);
    return false;
  }
  
  public final void jHN()
  {
    AppMethodBeat.i(251873);
    if (this.sRs != null)
    {
      this.sRs.setCanceledOnTouchOutside(false);
      this.sRs.setCancelable(false);
    }
    AppMethodBeat.o(251873);
  }
  
  public final void jHO()
  {
    AppMethodBeat.i(251880);
    this.Gxa.setBackgroundResource(a.e.up_corner_dark_bg);
    AppMethodBeat.o(251880);
  }
  
  public final void jHP()
  {
    AppMethodBeat.i(251933);
    if (this.GwU == null)
    {
      AppMethodBeat.o(251933);
      return;
    }
    this.GwU.setVisibility(8);
    AppMethodBeat.o(251933);
  }
  
  public final h jHQ()
  {
    AppMethodBeat.i(251939);
    if (this.rootView != null)
    {
      this.Gxa.setBackgroundResource(a.e.up_corner_dark_bg);
      this.GwV.setBackgroundColor(this.mContext.getResources().getColor(a.c.Dark_1));
      this.GwW.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.GwW.setBackgroundResource(a.e.dark_list_item_selector);
    }
    AppMethodBeat.o(251939);
    return this;
  }
  
  public final h mh(View paramView)
  {
    AppMethodBeat.i(251889);
    this.Gxa.addView(paramView, 0);
    AppMethodBeat.o(251889);
    return this;
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(251869);
    if (isShowing())
    {
      Object localObject = this.mF;
      if ((localObject == null) || ((!((View)localObject).isShown()) && (((View)localObject).getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(251869);
        return;
      }
      if (isShowing())
      {
        if ((this.sRw != isLandscape()) || (this.sRx != getRotation()))
        {
          cyW();
          AppMethodBeat.o(251869);
          return;
        }
        if (this.muY != this.Gxa.getHeight())
        {
          this.muY = this.Gxa.getHeight();
          int i = this.Gxa.getWidth();
          localObject = (FrameLayout.LayoutParams)this.Gxb.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).height = this.muY;
          ((FrameLayout.LayoutParams)localObject).width = i;
          ((FrameLayout.LayoutParams)localObject).gravity = 85;
          this.Gxb.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    AppMethodBeat.o(251869);
  }
  
  public static abstract interface c
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.ar;
import java.util.Queue;

public final class a
{
  SnackContainer Ldc;
  b Ldd;
  c Lde;
  private final View.OnClickListener Ldf;
  Handler mHandler;
  View mParentView;
  
  public a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(159708);
    this.mHandler = new Handler();
    this.Ldf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((a.this.Ldd != null) && (a.this.Ldc.isShowing())) {
          a.this.Ldd.bip();
        }
        a.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(159700);
            a.this.Ldc.hide();
            AppMethodBeat.o(159700);
          }
        }, 100L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159701);
      }
    };
    View localView = paramActivity.findViewById(16908290);
    Object localObject = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    ((LayoutInflater)localObject).inflate(2131495483, (ViewGroup)localView);
    localObject = ((LayoutInflater)localObject).inflate(2131495484, (ViewGroup)localView, false);
    a((ViewGroup)localView, (View)localObject, paramInt, paramActivity);
    AppMethodBeat.o(159708);
  }
  
  public a(Context paramContext, View paramView, int paramInt)
  {
    AppMethodBeat.i(159709);
    this.mHandler = new Handler();
    this.Ldf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((a.this.Ldd != null) && (a.this.Ldc.isShowing())) {
          a.this.Ldd.bip();
        }
        a.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(159700);
            a.this.Ldc.hide();
            AppMethodBeat.o(159700);
          }
        }, 100L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159701);
      }
    };
    if ((paramView == null) && ((paramContext instanceof Activity))) {
      paramView = ((Activity)paramContext).findViewById(16908290);
    }
    for (;;)
    {
      Object localObject = (LayoutInflater)paramContext.getSystemService("layout_inflater");
      ((LayoutInflater)localObject).inflate(2131495483, (ViewGroup)paramView);
      localObject = ((LayoutInflater)localObject).inflate(2131495484, (ViewGroup)paramView, false);
      a((ViewGroup)paramView, (View)localObject, paramInt, paramContext);
      AppMethodBeat.o(159709);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(159710);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(159710);
      return;
    }
    this.Ldc = ((SnackContainer)paramViewGroup.findViewById(2131304882));
    if (this.Ldc == null) {
      this.Ldc = new SnackContainer(paramViewGroup);
    }
    this.mParentView = paramView;
    if (paramInt == 36) {
      this.Ldc.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159703);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/snackbar/SnackBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if ((b.bni()) && (a.this.Ldc.isShowing()))
          {
            b.yW(false);
            a.this.mHandler.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(159702);
                a.this.Ldc.hide();
                AppMethodBeat.o(159702);
              }
            }, 100L);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/snackbar/SnackBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(159703);
          return true;
        }
      });
    }
    ((TextView)paramView.findViewById(2131304881)).setOnClickListener(this.Ldf);
    boolean bool1 = ar.jR(paramContext);
    paramInt = ar.ej(paramContext);
    ap.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(paramInt) });
    boolean bool2 = bn((Activity)paramContext);
    ap.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[] { Boolean.valueOf(bool2) });
    if ((bool2) && (bool1))
    {
      paramViewGroup = (LinearLayout)paramView.findViewById(2131304880);
      paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      paramView.bottomMargin = paramInt;
      paramViewGroup.setLayoutParams(paramView);
    }
    AppMethodBeat.o(159710);
  }
  
  private static boolean bn(Activity paramActivity)
  {
    AppMethodBeat.i(159711);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity = paramActivity.getWindow().getAttributes();
      if (paramActivity.flags == (paramActivity.flags & 0xF7FFFFFF | 0x8000000))
      {
        AppMethodBeat.o(159711);
        return true;
      }
    }
    AppMethodBeat.o(159711);
    return false;
  }
  
  public static final class a
  {
    String LcX;
    private int LcY;
    private Parcelable LcZ;
    private short Lda;
    private a Ldj;
    private int kSU;
    private Context mContext;
    private int mTextColor;
    String uDD;
    
    public a(Activity paramActivity)
    {
      AppMethodBeat.i(159704);
      this.LcY = 0;
      this.Lda = 3500;
      this.mTextColor = -1;
      this.kSU = 0;
      this.mContext = paramActivity.getApplicationContext();
      this.Ldj = new a(paramActivity, this.kSU);
      AppMethodBeat.o(159704);
    }
    
    public a(Context paramContext, View paramView)
    {
      AppMethodBeat.i(159705);
      this.LcY = 0;
      this.Lda = 3500;
      this.mTextColor = -1;
      this.kSU = 0;
      this.mContext = paramContext;
      this.Ldj = new a(paramContext, paramView, this.kSU);
      AppMethodBeat.o(159705);
    }
    
    public final a a(a.b paramb)
    {
      this.Ldj.Ldd = paramb;
      return this;
    }
    
    public final a a(a.c paramc)
    {
      this.Ldj.Lde = paramc;
      return this;
    }
    
    public final a a(Short paramShort)
    {
      AppMethodBeat.i(159706);
      this.Lda = paramShort.shortValue();
      AppMethodBeat.o(159706);
      return this;
    }
    
    public final a fNd()
    {
      AppMethodBeat.i(159707);
      Object localObject2 = this.uDD;
      Object localObject1;
      int j;
      Object localObject3;
      short s;
      if (this.LcX != null)
      {
        localObject1 = this.LcX.toUpperCase();
        j = this.LcY;
        localObject3 = this.LcZ;
        s = this.Lda;
        if (this.mTextColor == -1) {
          break label210;
        }
      }
      label210:
      for (int i = this.mTextColor;; i = this.mContext.getResources().getColor(2131101171))
      {
        localObject2 = new Snack((String)localObject2, (String)localObject1, j, (Parcelable)localObject3, s, i);
        Object localObject4 = this.Ldj;
        if (((a)localObject4).Ldc != null)
        {
          localObject1 = ((a)localObject4).Ldc;
          localObject3 = ((a)localObject4).mParentView;
          localObject4 = ((a)localObject4).Lde;
          if ((((View)localObject3).getParent() != null) && (((View)localObject3).getParent() != localObject1)) {
            ((ViewGroup)((View)localObject3).getParent()).removeView((View)localObject3);
          }
          localObject2 = new SnackContainer.a((Snack)localObject2, (View)localObject3, (a.c)localObject4, (byte)0);
          ((SnackContainer)localObject1).Ldl.offer(localObject2);
          if (((SnackContainer)localObject1).Ldl.size() == 1) {
            ((SnackContainer)localObject1).a((SnackContainer.a)localObject2);
          }
        }
        localObject1 = this.Ldj;
        AppMethodBeat.o(159707);
        return localObject1;
        localObject1 = null;
        break;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void bip();
  }
  
  public static abstract interface c
  {
    public abstract void bio();
    
    public abstract void onHide();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a
 * JD-Core Version:    0.7.0.1
 */
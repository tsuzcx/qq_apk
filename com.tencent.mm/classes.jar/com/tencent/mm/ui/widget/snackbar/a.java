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
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.au;
import java.util.Queue;

public final class a
{
  SnackContainer QVt;
  b QVu;
  c QVv;
  private final View.OnClickListener QVw;
  Handler mHandler;
  View mParentView;
  
  public a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(159708);
    this.mHandler = new Handler();
    this.QVw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((a.this.QVu != null) && (a.this.QVt.isShowing())) {
          a.this.QVu.bDZ();
        }
        a.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(159700);
            a.this.QVt.hide();
            AppMethodBeat.o(159700);
          }
        }, 100L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159701);
      }
    };
    View localView = paramActivity.findViewById(16908290);
    Object localObject = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    ((LayoutInflater)localObject).inflate(2131496358, (ViewGroup)localView);
    localObject = ((LayoutInflater)localObject).inflate(2131496359, (ViewGroup)localView, false);
    a((ViewGroup)localView, (View)localObject, paramInt, paramActivity);
    AppMethodBeat.o(159708);
  }
  
  public a(Context paramContext, View paramView, int paramInt)
  {
    AppMethodBeat.i(159709);
    this.mHandler = new Handler();
    this.QVw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((a.this.QVu != null) && (a.this.QVt.isShowing())) {
          a.this.QVu.bDZ();
        }
        a.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(159700);
            a.this.QVt.hide();
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
      ((LayoutInflater)localObject).inflate(2131496358, (ViewGroup)paramView);
      localObject = ((LayoutInflater)localObject).inflate(2131496359, (ViewGroup)paramView, false);
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
    this.QVt = ((SnackContainer)paramViewGroup.findViewById(2131307968));
    if (this.QVt == null) {
      this.QVt = new SnackContainer(paramViewGroup);
    }
    this.mParentView = paramView;
    if (paramInt == 36) {
      this.QVt.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159703);
          if ((b.bJw()) && (a.this.QVt.isShowing()))
          {
            b.Dt(false);
            a.this.mHandler.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(159702);
                a.this.QVt.hide();
                AppMethodBeat.o(159702);
              }
            }, 100L);
          }
          AppMethodBeat.o(159703);
          return true;
        }
      });
    }
    ((TextView)paramView.findViewById(2131307967)).setOnClickListener(this.QVw);
    boolean bool1 = au.aA(paramContext);
    paramInt = au.aD(paramContext);
    as.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(paramInt) });
    boolean bool2 = bu((Activity)paramContext);
    as.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[] { Boolean.valueOf(bool2) });
    if ((bool2) && (bool1))
    {
      paramViewGroup = (LinearLayout)paramView.findViewById(2131307966);
      paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      paramView.bottomMargin = paramInt;
      paramViewGroup.setLayoutParams(paramView);
    }
    AppMethodBeat.o(159710);
  }
  
  private static boolean bu(Activity paramActivity)
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
    private int QD;
    private a QVA;
    String QVo;
    private int QVp;
    private Parcelable QVq;
    private short QVr;
    private Context mContext;
    String mMessage;
    private int mbM;
    
    public a(Activity paramActivity)
    {
      AppMethodBeat.i(159704);
      this.QVp = 0;
      this.QVr = 3500;
      this.QD = -1;
      this.mbM = 0;
      this.mContext = paramActivity.getApplicationContext();
      this.QVA = new a(paramActivity, this.mbM);
      AppMethodBeat.o(159704);
    }
    
    public a(Context paramContext, View paramView)
    {
      AppMethodBeat.i(159705);
      this.QVp = 0;
      this.QVr = 3500;
      this.QD = -1;
      this.mbM = 0;
      this.mContext = paramContext;
      this.QVA = new a(paramContext, paramView, this.mbM);
      AppMethodBeat.o(159705);
    }
    
    public final a a(a.b paramb)
    {
      this.QVA.QVu = paramb;
      return this;
    }
    
    public final a a(a.c paramc)
    {
      this.QVA.QVv = paramc;
      return this;
    }
    
    public final a a(Short paramShort)
    {
      AppMethodBeat.i(159706);
      this.QVr = paramShort.shortValue();
      AppMethodBeat.o(159706);
      return this;
    }
    
    public final a hcA()
    {
      AppMethodBeat.i(159707);
      Object localObject2 = this.mMessage;
      Object localObject1;
      int j;
      Object localObject3;
      short s;
      if (this.QVo != null)
      {
        localObject1 = this.QVo.toUpperCase();
        j = this.QVp;
        localObject3 = this.QVq;
        s = this.QVr;
        if (this.QD == -1) {
          break label210;
        }
      }
      label210:
      for (int i = this.QD;; i = this.mContext.getResources().getColor(2131101414))
      {
        localObject2 = new Snack((String)localObject2, (String)localObject1, j, (Parcelable)localObject3, s, i);
        Object localObject4 = this.QVA;
        if (((a)localObject4).QVt != null)
        {
          localObject1 = ((a)localObject4).QVt;
          localObject3 = ((a)localObject4).mParentView;
          localObject4 = ((a)localObject4).QVv;
          if ((((View)localObject3).getParent() != null) && (((View)localObject3).getParent() != localObject1)) {
            ((ViewGroup)((View)localObject3).getParent()).removeView((View)localObject3);
          }
          localObject2 = new SnackContainer.a((Snack)localObject2, (View)localObject3, (a.c)localObject4, (byte)0);
          ((SnackContainer)localObject1).QVC.offer(localObject2);
          if (((SnackContainer)localObject1).QVC.size() == 1) {
            ((SnackContainer)localObject1).a((SnackContainer.a)localObject2);
          }
        }
        localObject1 = this.QVA;
        AppMethodBeat.o(159707);
        return localObject1;
        localObject1 = null;
        break;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void bDZ();
  }
  
  public static abstract interface c
  {
    public abstract void bDY();
    
    public abstract void onHide();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a
 * JD-Core Version:    0.7.0.1
 */
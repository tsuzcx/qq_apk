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
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bf;
import java.util.Queue;

public final class a
{
  private final View.OnClickListener agmA;
  SnackContainer agmx;
  b agmy;
  c agmz;
  Handler mHandler;
  View xyY;
  
  public a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(159708);
    this.mHandler = new Handler();
    this.agmA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((a.this.agmy != null) && (a.this.agmx.isShowing())) {
          a.this.agmy.onMessageClick();
        }
        a.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(159700);
            a.this.agmx.hide();
            AppMethodBeat.o(159700);
          }
        }, 100L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159701);
      }
    };
    View localView = paramActivity.findViewById(16908290);
    Object localObject = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    ((LayoutInflater)localObject).inflate(a.g.snackbar_container, (ViewGroup)localView);
    localObject = ((LayoutInflater)localObject).inflate(a.g.snackbar_main, (ViewGroup)localView, false);
    a((ViewGroup)localView, (View)localObject, paramInt, paramActivity);
    AppMethodBeat.o(159708);
  }
  
  public a(Context paramContext, View paramView, int paramInt)
  {
    AppMethodBeat.i(159709);
    this.mHandler = new Handler();
    this.agmA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((a.this.agmy != null) && (a.this.agmx.isShowing())) {
          a.this.agmy.onMessageClick();
        }
        a.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(159700);
            a.this.agmx.hide();
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
      ((LayoutInflater)localObject).inflate(a.g.snackbar_container, (ViewGroup)paramView);
      localObject = ((LayoutInflater)localObject).inflate(a.g.snackbar_main, (ViewGroup)paramView, false);
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
    this.agmx = ((SnackContainer)paramViewGroup.findViewById(a.f.snackContainer));
    if (this.agmx == null) {
      this.agmx = new SnackContainer(paramViewGroup);
    }
    this.xyY = paramView;
    if (paramInt == 36) {
      this.agmx.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(159703);
          if ((b.cvt()) && (a.this.agmx.isShowing()))
          {
            b.NL(false);
            a.this.mHandler.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(159702);
                a.this.agmx.hide();
                AppMethodBeat.o(159702);
              }
            }, 100L);
          }
          AppMethodBeat.o(159703);
          return true;
        }
      });
    }
    ((TextView)paramView.findViewById(a.f.snackButton)).setOnClickListener(this.agmA);
    boolean bool1 = bf.bg(paramContext);
    paramInt = bf.bk(paramContext);
    bc.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(paramInt) });
    boolean bool2 = ci((Activity)paramContext);
    bc.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[] { Boolean.valueOf(bool2) });
    if ((bool2) && (bool1))
    {
      paramViewGroup = (LinearLayout)paramView.findViewById(a.f.snackBar);
      paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      paramView.bottomMargin = paramInt;
      paramViewGroup.setLayoutParams(paramView);
    }
    AppMethodBeat.o(159710);
  }
  
  private static boolean ci(Activity paramActivity)
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
    private a agmE;
    String agms;
    private int agmt;
    private Parcelable agmu;
    private short agmv;
    private int ckf;
    private Context mContext;
    String mMessage;
    private int sff;
    
    public a(Activity paramActivity)
    {
      AppMethodBeat.i(159704);
      this.agmt = 0;
      this.agmv = 3500;
      this.ckf = -1;
      this.sff = 0;
      this.mContext = paramActivity.getApplicationContext();
      this.agmE = new a(paramActivity, this.sff);
      AppMethodBeat.o(159704);
    }
    
    public a(Context paramContext, View paramView)
    {
      AppMethodBeat.i(159705);
      this.agmt = 0;
      this.agmv = 3500;
      this.ckf = -1;
      this.sff = 0;
      this.mContext = paramContext;
      this.agmE = new a(paramContext, paramView, this.sff);
      AppMethodBeat.o(159705);
    }
    
    public final a a(a.b paramb)
    {
      this.agmE.agmy = paramb;
      return this;
    }
    
    public final a a(a.c paramc)
    {
      this.agmE.agmz = paramc;
      return this;
    }
    
    public final a a(Short paramShort)
    {
      AppMethodBeat.i(159706);
      this.agmv = paramShort.shortValue();
      AppMethodBeat.o(159706);
      return this;
    }
    
    public final a jIY()
    {
      AppMethodBeat.i(159707);
      Object localObject2 = this.mMessage;
      Object localObject1;
      int j;
      Object localObject3;
      short s;
      if (this.agms != null)
      {
        localObject1 = this.agms.toUpperCase();
        j = this.agmt;
        localObject3 = this.agmu;
        s = this.agmv;
        if (this.ckf == -1) {
          break label210;
        }
      }
      label210:
      for (int i = this.ckf;; i = this.mContext.getResources().getColor(com.tencent.mm.ck.a.c.wechat_green))
      {
        localObject2 = new Snack((String)localObject2, (String)localObject1, j, (Parcelable)localObject3, s, i);
        Object localObject4 = this.agmE;
        if (((a)localObject4).agmx != null)
        {
          localObject1 = ((a)localObject4).agmx;
          localObject3 = ((a)localObject4).xyY;
          localObject4 = ((a)localObject4).agmz;
          if ((((View)localObject3).getParent() != null) && (((View)localObject3).getParent() != localObject1)) {
            ((ViewGroup)((View)localObject3).getParent()).removeView((View)localObject3);
          }
          localObject2 = new SnackContainer.a((Snack)localObject2, (View)localObject3, (a.c)localObject4, (byte)0);
          ((SnackContainer)localObject1).agmF.offer(localObject2);
          if (((SnackContainer)localObject1).agmF.size() == 1) {
            ((SnackContainer)localObject1).a((SnackContainer.a)localObject2);
          }
        }
        localObject1 = this.agmE;
        AppMethodBeat.o(159707);
        return localObject1;
        localObject1 = null;
        break;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onMessageClick();
  }
  
  public static abstract interface c
  {
    public abstract void cpT();
    
    public abstract void onHide();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a
 * JD-Core Version:    0.7.0.1
 */
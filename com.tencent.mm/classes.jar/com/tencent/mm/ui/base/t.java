package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class t
  extends Toast
{
  private View JIY;
  public final aw cYd;
  private final Context context;
  public long duration;
  private int level;
  public int oPB;
  private final TextView vcA;
  
  public t(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142239);
    this.cYd = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142230);
        if (t.a(t.this) == -1L)
        {
          t.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        t.b(t.this);
        if (t.c(t.this) >= 0)
        {
          t.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        t.this.cancel();
        AppMethodBeat.o(142230);
        return false;
      }
    }, true);
    this.context = paramContext;
    reset();
    this.JIY = View.inflate(paramContext, 2131495766, null);
    setView(this.JIY);
    setGravity(55, 0, BackwardSupportUtil.b.h(paramContext, 40.0F));
    setDuration(0);
    this.vcA = ((TextView)this.JIY.findViewById(2131305958));
    switch (this.level)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142239);
      return;
      this.vcA.setTextColor(-1);
      AppMethodBeat.o(142239);
      return;
      this.vcA.setTextColor(this.context.getResources().getColor(2131101038));
    }
  }
  
  public static o a(Activity paramActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(142242);
    Object localObject = View.inflate(paramActivity, 2131495766, null);
    ((TextView)((View)localObject).findViewById(2131305958)).setText(paramString);
    paramString = new o((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = dX(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142233);
        this.JJa.dismiss();
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(142233);
      }
    }.sendEmptyMessageDelayed(0, paramLong);
    AppMethodBeat.o(142242);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, b paramb)
  {
    AppMethodBeat.i(193733);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)paramContext.findViewById(2131305956)).setImageResource(2131690416);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    paramb.ec(paramContext);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(193733);
  }
  
  public static void cn(final Context paramContext, String paramString)
  {
    AppMethodBeat.i(142246);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, 2131493368, null);
    TextView localTextView = (TextView)localView.findViewById(2131305957);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(193728);
        if (this.kRf.getLineCount() > 1) {
          this.kRf.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165257));
        }
        this.kRf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        AppMethodBeat.o(193728);
      }
    });
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142246);
  }
  
  public static void co(final Context paramContext, String paramString)
  {
    AppMethodBeat.i(142247);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)localView.findViewById(2131305956)).setImageResource(2131690416);
    TextView localTextView = (TextView)localView.findViewById(2131305957);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(193730);
        if (this.kRf.getLineCount() > 1) {
          this.kRf.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165257));
        }
        this.kRf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        AppMethodBeat.o(193730);
      }
    });
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142247);
  }
  
  private static int dX(Context paramContext)
  {
    AppMethodBeat.i(142243);
    int i;
    if (((paramContext instanceof AppCompatActivity)) && (((AppCompatActivity)paramContext).getSupportActionBar() != null)) {
      i = ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    while (i == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(2131165252);
      AppMethodBeat.o(142243);
      return i;
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = paramContext.getResources().getDimensionPixelSize(2131165251);
      } else {
        i = paramContext.getResources().getDimensionPixelSize(2131165252);
      }
    }
    AppMethodBeat.o(142243);
    return i;
  }
  
  public static void g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(164156);
    if (((paramContext instanceof Activity)) && (android.support.v4.content.b.checkSelfPermission((Activity)paramContext, "android.permission.WRITE_EXTERNAL_STORAGE") != 0))
    {
      com.tencent.mm.ui.widget.snackbar.b.a(paramContext, paramView, paramContext.getString(2131761884), paramContext.getString(2131755889), new t.4(paramContext));
      AppMethodBeat.o(164156);
      return;
    }
    kn(paramContext);
    AppMethodBeat.o(164156);
  }
  
  public static int kd(Context paramContext)
  {
    AppMethodBeat.i(224382);
    int i = al.aL(paramContext, 25);
    AppMethodBeat.o(224382);
    return i;
  }
  
  public static void kn(Context paramContext)
  {
    AppMethodBeat.i(142248);
    if (g.getExternalStorageState().equals("mounted_ro"))
    {
      a.aO(paramContext, 3);
      AppMethodBeat.o(142248);
      return;
    }
    a.aO(paramContext, 1);
    AppMethodBeat.o(142248);
  }
  
  public static void ko(Context paramContext)
  {
    AppMethodBeat.i(142249);
    a.aO(paramContext, 2);
    AppMethodBeat.o(142249);
  }
  
  public static o m(final Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(193731);
    View localView = View.inflate(paramActivity, 2131494586, null);
    Object localObject = (TextView)localView.findViewById(2131301455);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    ((ImageView)localView.findViewById(2131301454)).setVisibility(8);
    paramString = new o(localView);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).top;
    int k = dX(paramActivity);
    int i = j;
    if (j == 0) {
      i = al.aL(paramActivity, 25);
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142237);
        this.JJa.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, this.JJc);
        AppMethodBeat.o(142237);
      }
    });
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142231);
        this.JJa.dismiss();
        AppMethodBeat.o(142231);
      }
    }, 2000L);
    paramActivity = (ImageButton)localView.findViewById(2131301453);
    paramActivity.setVisibility(8);
    paramActivity.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142232);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.JJa.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142232);
      }
    });
    AppMethodBeat.o(193731);
    return paramString;
  }
  
  public static void v(final Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(193732);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)localView.findViewById(2131305956)).setImageResource(paramInt);
    TextView localTextView = (TextView)localView.findViewById(2131305957);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(193729);
        if (this.kRf.getLineCount() > 1) {
          this.kRf.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165257));
        }
        this.kRf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        AppMethodBeat.o(193729);
      }
    });
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(193732);
  }
  
  public final void reset()
  {
    this.level = 1;
    this.duration = 2000L;
    this.oPB = ((int)(this.duration / 70L) + 1);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(142241);
    this.vcA.setText(paramInt);
    AppMethodBeat.o(142241);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142240);
    this.vcA.setText(paramCharSequence);
    AppMethodBeat.o(142240);
  }
  
  static final class a
  {
    public static int lastType = 0;
    private static Toast tOw = null;
    
    public static void aO(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(142238);
      paramContext = paramContext.getApplicationContext();
      if (lastType != paramInt)
      {
        tOw = null;
        lastType = paramInt;
      }
      if (tOw == null) {
        tOw = Toast.makeText(paramContext, "", 1);
      }
      paramContext = View.inflate(paramContext, 2131495312, null);
      if (paramInt == 1) {
        ((TextView)paramContext.findViewById(2131304383)).setText(2131761212);
      }
      for (;;)
      {
        tOw.setView(paramContext);
        tOw.show();
        AppMethodBeat.o(142238);
        return;
        if (paramInt == 3) {
          ((TextView)paramContext.findViewById(2131304383)).setText(2131761213);
        } else {
          ((TextView)paramContext.findViewById(2131304383)).setText(2131761214);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void ec(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.t
 * JD-Core Version:    0.7.0.1
 */
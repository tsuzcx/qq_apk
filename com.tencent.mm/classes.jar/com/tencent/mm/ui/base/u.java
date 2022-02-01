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
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class u
  extends Toast
{
  private View OTO;
  private final Context context;
  public long duration;
  private int level;
  private int qdp;
  public final MTimerHandler timer;
  private final TextView yva;
  
  public u(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142239);
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142230);
        if (u.a(u.this) == -1L)
        {
          u.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        u.b(u.this);
        if (u.c(u.this) >= 0)
        {
          u.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        u.this.cancel();
        AppMethodBeat.o(142230);
        return false;
      }
    }, true);
    this.context = paramContext;
    reset();
    this.OTO = View.inflate(paramContext, 2131496724, null);
    setView(this.OTO);
    setGravity(55, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 40.0F));
    setDuration(0);
    this.yva = ((TextView)this.OTO.findViewById(2131309261));
    switch (this.level)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142239);
      return;
      this.yva.setTextColor(-1);
      AppMethodBeat.o(142239);
      return;
      this.yva.setTextColor(this.context.getResources().getColor(2131101271));
    }
  }
  
  public static p a(Activity paramActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(142242);
    Object localObject = View.inflate(paramActivity, 2131496724, null);
    ((TextView)((View)localObject).findViewById(2131309261)).setText(paramString);
    paramString = new p((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = eu(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142233);
        this.OTQ.dismiss();
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(142233);
      }
    }.sendEmptyMessageDelayed(0, paramLong);
    AppMethodBeat.o(142242);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, u.b paramb)
  {
    AppMethodBeat.i(205250);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493459, null);
    ((WeImageView)paramContext.findViewById(2131309259)).setImageResource(2131690547);
    ((TextView)paramContext.findViewById(2131309260)).setText(paramString);
    paramb.dU(paramContext);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(205250);
  }
  
  public static int ay(Context paramContext)
  {
    AppMethodBeat.i(258463);
    int i = ao.jK(paramContext);
    AppMethodBeat.o(258463);
    return i;
  }
  
  public static void cE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(205247);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131496707, null);
    ((TextView)paramContext.findViewById(2131309260)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(205247);
  }
  
  public static void cF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(205248);
    Toast localToast = Toast.makeText(paramContext, "", 1);
    paramContext = View.inflate(paramContext, 2131496707, null);
    ((TextView)paramContext.findViewById(2131309260)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(205248);
  }
  
  public static void cG(final Context paramContext, String paramString)
  {
    AppMethodBeat.i(142246);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, 2131493459, null);
    TextView localTextView = (TextView)localView.findViewById(2131309260);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(205242);
        if (this.lWh.getLineCount() > 1) {
          this.lWh.setTextSize(0, com.tencent.mm.cb.a.aG(paramContext, 2131165261));
        }
        this.lWh.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        AppMethodBeat.o(205242);
      }
    });
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142246);
  }
  
  public static void cH(final Context paramContext, String paramString)
  {
    AppMethodBeat.i(142247);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, 2131493459, null);
    ((WeImageView)localView.findViewById(2131309259)).setImageResource(2131690574);
    TextView localTextView = (TextView)localView.findViewById(2131309260);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(205244);
        if (this.lWh.getLineCount() > 1) {
          this.lWh.setTextSize(0, com.tencent.mm.cb.a.aG(paramContext, 2131165261));
        }
        this.lWh.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        AppMethodBeat.o(205244);
      }
    });
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142247);
  }
  
  private static int eu(Context paramContext)
  {
    AppMethodBeat.i(142243);
    int i;
    if (((paramContext instanceof AppCompatActivity)) && (((AppCompatActivity)paramContext).getSupportActionBar() != null)) {
      i = ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    while (i == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(2131165256);
      AppMethodBeat.o(142243);
      return i;
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = paramContext.getResources().getDimensionPixelSize(2131165255);
      } else {
        i = paramContext.getResources().getDimensionPixelSize(2131165256);
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
      com.tencent.mm.ui.widget.snackbar.b.a(paramContext, paramView, paramContext.getString(2131763889), paramContext.getString(2131755981), new u.4(paramContext));
      AppMethodBeat.o(164156);
      return;
    }
    kf(paramContext);
    AppMethodBeat.o(164156);
  }
  
  public static void kf(Context paramContext)
  {
    AppMethodBeat.i(142248);
    if (g.getExternalStorageState().equals("mounted_ro"))
    {
      u.a.aP(paramContext, 3);
      AppMethodBeat.o(142248);
      return;
    }
    u.a.aP(paramContext, 1);
    AppMethodBeat.o(142248);
  }
  
  public static void kg(Context paramContext)
  {
    AppMethodBeat.i(142249);
    u.a.aP(paramContext, 2);
    AppMethodBeat.o(142249);
  }
  
  public static p q(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(205246);
    View localView = View.inflate(paramActivity, 2131495214, null);
    Object localObject = (TextView)localView.findViewById(2131303240);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    ((ImageView)localView.findViewById(2131303239)).setVisibility(8);
    paramString = new p(localView);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).top;
    int k = eu(paramActivity);
    int i = j;
    if (j == 0) {
      i = ao.jK(paramActivity);
    }
    MMHandlerThread.postToMainThread(new u.9(paramString, paramActivity, i + k));
    MMHandlerThread.postToMainThreadDelayed(new u.2(paramString), 2000L);
    paramActivity = (ImageButton)localView.findViewById(2131303238);
    paramActivity.setVisibility(8);
    paramActivity.setOnClickListener(new u.3(paramString));
    AppMethodBeat.o(205246);
    return paramString;
  }
  
  public static void u(final Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(205249);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, 2131493459, null);
    Object localObject = (WeImageView)localView.findViewById(2131309259);
    if (paramInt != 0) {
      ((WeImageView)localObject).setImageResource(paramInt);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131309260);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(205243);
          if (this.lWh.getLineCount() > 1) {
            this.lWh.setTextSize(0, com.tencent.mm.cb.a.aG(paramContext, 2131165261));
          }
          this.lWh.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          AppMethodBeat.o(205243);
        }
      });
      localToast.setGravity(17, 0, 0);
      localToast.setView(localView);
      localToast.show();
      AppMethodBeat.o(205249);
      return;
      ((WeImageView)localObject).setVisibility(8);
    }
  }
  
  public final void gLj()
  {
    AppMethodBeat.i(205245);
    cancel();
    this.timer.stopTimer();
    this.qdp = ((int)(this.duration / 70L) + 1);
    this.timer.startTimer(70L);
    AppMethodBeat.o(205245);
  }
  
  public final void reset()
  {
    this.level = 1;
    this.duration = 2000L;
    this.qdp = ((int)(this.duration / 70L) + 1);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(142241);
    this.yva.setText(com.tencent.mm.ui.e.a.kn(this.context).getString(paramInt));
    AppMethodBeat.o(142241);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142240);
    this.yva.setText(paramCharSequence);
    AppMethodBeat.o(142240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.u
 * JD-Core Version:    0.7.0.1
 */
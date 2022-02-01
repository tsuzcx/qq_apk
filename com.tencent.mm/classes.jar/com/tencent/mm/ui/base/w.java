package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.snackbar.b;

public final class w
  extends Toast
{
  private final TextView DVe;
  private View Wnb;
  private final Context context;
  public long duration;
  private int level;
  public final MTimerHandler timer;
  private int tzm;
  
  public w(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142239);
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142230);
        if (w.a(w.this) == -1L)
        {
          w.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        w.b(w.this);
        if (w.c(w.this) >= 0)
        {
          w.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        w.this.cancel();
        AppMethodBeat.o(142230);
        return false;
      }
    }, true);
    this.context = paramContext;
    this.level = 1;
    this.duration = 2000L;
    this.tzm = ((int)(this.duration / 70L) + 1);
    this.Wnb = View.inflate(paramContext, a.h.toast_view, null);
    setView(this.Wnb);
    setGravity(55, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 40.0F));
    setDuration(0);
    this.DVe = ((TextView)this.Wnb.findViewById(a.g.toast_view_text));
    switch (this.level)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142239);
      return;
      this.DVe.setTextColor(-1);
      AppMethodBeat.o(142239);
      return;
      this.DVe.setTextColor(this.context.getResources().getColor(a.d.toasterro));
    }
  }
  
  public static r a(Activity paramActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(142242);
    Object localObject = View.inflate(paramActivity, a.h.toast_view, null);
    ((TextView)((View)localObject).findViewById(a.g.toast_view_text)).setText(paramString);
    paramString = new r((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = ew(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new w.10(paramString).sendEmptyMessageDelayed(0, paramLong);
    AppMethodBeat.o(142242);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, w.b paramb)
  {
    AppMethodBeat.i(215520);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, a.h.center_toast, null);
    ((WeImageView)paramContext.findViewById(a.g.toast_img)).setImageResource(a.j.icons_filled_error);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setText(paramString);
    paramb.eu(paramContext);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(215520);
  }
  
  public static int at(Context paramContext)
  {
    AppMethodBeat.i(293215);
    int i = ar.kJ(paramContext);
    AppMethodBeat.o(293215);
    return i;
  }
  
  public static void cP(Context paramContext, String paramString)
  {
    AppMethodBeat.i(215510);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, a.h.text_toast, null);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(215510);
  }
  
  public static void cQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(215512);
    Toast localToast = Toast.makeText(paramContext, "", 1);
    paramContext = View.inflate(paramContext, a.h.text_toast, null);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(215512);
  }
  
  public static void cR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142246);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new w.5(localTextView, paramContext));
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142246);
  }
  
  public static void cS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142247);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    ((WeImageView)localView.findViewById(a.g.toast_img)).setImageResource(a.j.icons_filled_info);
    TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new w.8(localTextView, paramContext));
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142247);
  }
  
  public static Toast d(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(215518);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    ((WeImageView)localView.findViewById(a.g.toast_img)).setImageResource(a.j.icons_filled_info);
    TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
    localTextView.setText(paramCharSequence);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new w.9(localTextView, paramContext));
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(215518);
    return localToast;
  }
  
  private static int ew(Context paramContext)
  {
    AppMethodBeat.i(142243);
    int i;
    if (((paramContext instanceof AppCompatActivity)) && (((AppCompatActivity)paramContext).getSupportActionBar() != null)) {
      i = ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    while (i == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
      AppMethodBeat.o(142243);
      return i;
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);
      } else {
        i = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
      }
    }
    AppMethodBeat.o(142243);
    return i;
  }
  
  public static void g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(164156);
    if (((paramContext instanceof Activity)) && (androidx.core.content.a.checkSelfPermission((Activity)paramContext, "android.permission.WRITE_EXTERNAL_STORAGE") != 0))
    {
      b.a(paramContext, paramView, paramContext.getString(a.k.permission_storage_request_reason_msg), paramContext.getString(a.k.app_set), new w.4(paramContext));
      AppMethodBeat.o(164156);
      return;
    }
    ld(paramContext);
    AppMethodBeat.o(164156);
  }
  
  public static Toast l(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(215516);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    Object localObject = (WeImageView)localView.findViewById(a.g.toast_img);
    if (paramInt != 0) {
      ((WeImageView)localObject).setImageResource(paramInt);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(a.g.toast_text);
      ((TextView)localObject).setText(paramCharSequence);
      ((TextView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new w.7((TextView)localObject, paramContext));
      localToast.setGravity(17, 0, 0);
      localToast.setView(localView);
      localToast.show();
      AppMethodBeat.o(215516);
      return localToast;
      ((WeImageView)localObject).setVisibility(8);
    }
  }
  
  public static void ld(Context paramContext)
  {
    AppMethodBeat.i(142248);
    if (g.avJ().equals("mounted_ro"))
    {
      a.bi(paramContext, 3);
      AppMethodBeat.o(142248);
      return;
    }
    a.bi(paramContext, 1);
    AppMethodBeat.o(142248);
  }
  
  public static void le(Context paramContext)
  {
    AppMethodBeat.i(142249);
    a.bi(paramContext, 2);
    AppMethodBeat.o(142249);
  }
  
  public static r q(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(215508);
    View localView = View.inflate(paramActivity, a.h.listen_model_notify, null);
    Object localObject = (TextView)localView.findViewById(a.g.listen_model_notify_text);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    ((ImageView)localView.findViewById(a.g.listen_model_notify_imageview)).setVisibility(8);
    paramString = new r(localView);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).top;
    int k = ew(paramActivity);
    int i = j;
    if (j == 0) {
      i = ar.kJ(paramActivity);
    }
    MMHandlerThread.postToMainThread(new w.11(paramString, paramActivity, i + k));
    MMHandlerThread.postToMainThreadDelayed(new w.2(paramString), 2000L);
    paramActivity = (ImageButton)localView.findViewById(a.g.listen_model_notify_btn);
    paramActivity.setVisibility(8);
    paramActivity.setOnClickListener(new w.3(paramString));
    AppMethodBeat.o(215508);
    return paramString;
  }
  
  public static void w(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(215514);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    Object localObject = (WeImageView)localView.findViewById(a.g.toast_img);
    if (paramInt != 0) {
      ((WeImageView)localObject).setImageResource(paramInt);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(a.g.toast_text);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new w.6((TextView)localObject, paramContext));
      localToast.setGravity(17, 0, 0);
      localToast.setView(localView);
      localToast.show();
      AppMethodBeat.o(215514);
      return;
      ((WeImageView)localObject).setVisibility(8);
    }
  }
  
  public final void hKh()
  {
    AppMethodBeat.i(215500);
    cancel();
    this.timer.stopTimer();
    this.tzm = ((int)(this.duration / 70L) + 1);
    this.timer.startTimer(70L);
    AppMethodBeat.o(215500);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(142241);
    this.DVe.setText(com.tencent.mm.ui.e.a.ll(this.context).getString(paramInt));
    AppMethodBeat.o(142241);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142240);
    this.DVe.setText(paramCharSequence);
    AppMethodBeat.o(142240);
  }
  
  static final class a
  {
    private static Toast BRG = null;
    public static int lastType = 0;
    
    public static void bi(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(142238);
      paramContext = paramContext.getApplicationContext();
      if (lastType != paramInt)
      {
        BRG = null;
        lastType = paramInt;
      }
      if (BRG == null) {
        BRG = Toast.makeText(paramContext, "", 1);
      }
      paramContext = View.inflate(paramContext, a.h.sdcard_eject_toast, null);
      if (paramInt == 1) {
        ((TextView)paramContext.findViewById(a.g.sdcard_toast_text)).setText(a.k.media_ejected);
      }
      for (;;)
      {
        BRG.setView(paramContext);
        BRG.show();
        AppMethodBeat.o(142238);
        return;
        if (paramInt == 3) {
          ((TextView)paramContext.findViewById(a.g.sdcard_toast_text)).setText(a.k.media_ejected_readonly);
        } else {
          ((TextView)paramContext.findViewById(a.g.sdcard_toast_text)).setText(a.k.media_full);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.w
 * JD-Core Version:    0.7.0.1
 */
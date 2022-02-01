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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.snackbar.b;

public final class aa
  extends Toast
{
  private final TextView JMn;
  private View adUp;
  private final Context context;
  public long duration;
  private int level;
  private final MTimerHandler timer;
  private int wDI;
  
  public aa(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142239);
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142230);
        if (aa.a(aa.this) == -1L)
        {
          aa.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        aa.b(aa.this);
        if (aa.c(aa.this) >= 0)
        {
          aa.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        aa.this.cancel();
        AppMethodBeat.o(142230);
        return false;
      }
    }, true);
    this.context = paramContext;
    this.level = 1;
    this.duration = 2000L;
    this.wDI = ((int)(this.duration / 70L) + 1);
    this.adUp = View.inflate(paramContext, a.h.toast_view, null);
    setView(this.adUp);
    setGravity(55, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 40.0F));
    setDuration(0);
    this.JMn = ((TextView)this.adUp.findViewById(a.g.toast_view_text));
    switch (this.level)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142239);
      return;
      this.JMn.setTextColor(-1);
      AppMethodBeat.o(142239);
      return;
      this.JMn.setTextColor(this.context.getResources().getColor(a.d.toasterro));
    }
  }
  
  public static v a(Activity paramActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(142242);
    Object localObject = View.inflate(paramActivity, a.h.toast_view, null);
    ((TextView)((View)localObject).findViewById(a.g.toast_view_text)).setText(paramString);
    paramString = new v((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = fs(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new aa.10(paramString).sendEmptyMessageDelayed(0, paramLong);
    AppMethodBeat.o(142242);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, b paramb)
  {
    AppMethodBeat.i(251460);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, a.h.center_toast, null);
    ((WeImageView)paramContext.findViewById(a.g.toast_img)).setImageResource(a.j.icons_filled_error);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setText(paramString);
    paramb.onViewCustomize(paramContext);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(251460);
  }
  
  public static int be(Context paramContext)
  {
    AppMethodBeat.i(369638);
    int i = aw.na(paramContext);
    AppMethodBeat.o(369638);
    return i;
  }
  
  public static Toast c(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251458);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    ((WeImageView)localView.findViewById(a.g.toast_img)).setImageResource(a.j.icons_filled_info);
    TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
    localTextView.setText(paramCharSequence);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new aa.9(localTextView, paramContext));
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(251458);
    return localToast;
  }
  
  public static void dD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(369637);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, a.h.full_text_toast, null);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(369637);
  }
  
  public static void da(Context paramContext, String paramString)
  {
    AppMethodBeat.i(251450);
    Toast localToast = Toast.makeText(paramContext, "", 1);
    paramContext = View.inflate(paramContext, a.h.text_toast, null);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(251450);
  }
  
  public static void db(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142246);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new aa.5(localTextView, paramContext));
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142246);
  }
  
  public static void dc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142247);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    View localView = View.inflate(paramContext, a.h.center_toast, null);
    ((WeImageView)localView.findViewById(a.g.toast_img)).setImageResource(a.j.icons_filled_info);
    TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
    localTextView.setText(paramString);
    localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new aa.8(localTextView, paramContext));
    localToast.setGravity(17, 0, 0);
    localToast.setView(localView);
    localToast.show();
    AppMethodBeat.o(142247);
  }
  
  private static int fs(Context paramContext)
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
  
  public static void j(Context paramContext, View paramView)
  {
    AppMethodBeat.i(164156);
    if (((paramContext instanceof Activity)) && (androidx.core.content.a.checkSelfPermission((Activity)paramContext, "android.permission.WRITE_EXTERNAL_STORAGE") != 0))
    {
      b.a(paramContext, paramView, paramContext.getString(a.k.permission_storage_request_reason_msg), paramContext.getString(a.k.app_set), new aa.4(paramContext));
      AppMethodBeat.o(164156);
      return;
    }
    nh(paramContext);
    AppMethodBeat.o(164156);
  }
  
  public static Toast k(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(251454);
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
      ((TextView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new aa.7((TextView)localObject, paramContext));
      localToast.setGravity(17, 0, 0);
      localToast.setView(localView);
      localToast.show();
      AppMethodBeat.o(251454);
      return localToast;
      ((WeImageView)localObject).setVisibility(8);
    }
  }
  
  public static void nh(Context paramContext)
  {
    AppMethodBeat.i(142248);
    if (g.aQd().equals("mounted_ro"))
    {
      a.bB(paramContext, 3);
      AppMethodBeat.o(142248);
      return;
    }
    a.bB(paramContext, 1);
    AppMethodBeat.o(142248);
  }
  
  public static void ni(Context paramContext)
  {
    AppMethodBeat.i(142249);
    a.bB(paramContext, 2);
    AppMethodBeat.o(142249);
  }
  
  public static v s(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(251446);
    View localView = View.inflate(paramActivity, a.h.listen_model_notify, null);
    Object localObject = (TextView)localView.findViewById(a.g.listen_model_notify_text);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    ((ImageView)localView.findViewById(a.g.listen_model_notify_imageview)).setVisibility(8);
    paramString = new v(localView);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).top;
    int k = fs(paramActivity);
    int i = j;
    if (j == 0) {
      i = aw.na(paramActivity);
    }
    MMHandlerThread.postToMainThread(new aa.11(paramString, paramActivity, i + k));
    MMHandlerThread.postToMainThreadDelayed(new aa.2(paramString), 2000L);
    paramActivity = (ImageButton)localView.findViewById(a.g.listen_model_notify_btn);
    paramActivity.setVisibility(8);
    paramActivity.setOnClickListener(new aa.3(paramString));
    AppMethodBeat.o(251446);
    return paramString;
  }
  
  public static void showTextToast(Context paramContext, String paramString)
  {
    AppMethodBeat.i(251449);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, a.h.text_toast, null);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(251449);
  }
  
  public static void y(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(251452);
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
      ((TextView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new aa.6((TextView)localObject, paramContext));
      localToast.setGravity(17, 0, 0);
      localToast.setView(localView);
      localToast.show();
      AppMethodBeat.o(251452);
      return;
      ((WeImageView)localObject).setVisibility(8);
    }
  }
  
  public final void jmO()
  {
    AppMethodBeat.i(251473);
    cancel();
    this.timer.stopTimer();
    this.wDI = ((int)(this.duration / 70L) + 1);
    this.timer.startTimer(70L);
    AppMethodBeat.o(251473);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(142241);
    this.JMn.setText(com.tencent.mm.ui.d.a.np(this.context).getString(paramInt));
    AppMethodBeat.o(142241);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142240);
    this.JMn.setText(paramCharSequence);
    AppMethodBeat.o(142240);
  }
  
  static final class a
  {
    private static Toast HDo = null;
    public static int lastType = 0;
    
    public static void bB(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(142238);
      paramContext = paramContext.getApplicationContext();
      if (lastType != paramInt)
      {
        HDo = null;
        lastType = paramInt;
      }
      if (HDo == null) {
        HDo = Toast.makeText(paramContext, "", 1);
      }
      paramContext = View.inflate(paramContext, a.h.sdcard_eject_toast, null);
      if (paramInt == 1) {
        ((TextView)paramContext.findViewById(a.g.sdcard_toast_text)).setText(a.k.media_ejected);
      }
      for (;;)
      {
        HDo.setView(paramContext);
        HDo.show();
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
  
  public static abstract interface b
  {
    public abstract void onViewCustomize(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.aa
 * JD-Core Version:    0.7.0.1
 */
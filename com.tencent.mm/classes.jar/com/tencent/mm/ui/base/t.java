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
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class t
  extends Toast
{
  private View HAs;
  public final au cLS;
  private final Context context;
  public long duration;
  private int level;
  public int ofG;
  private final TextView tOb;
  
  public t(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142239);
    this.cLS = new au(new au.a()
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
    this.HAs = View.inflate(paramContext, 2131495766, null);
    setView(this.HAs);
    setGravity(55, 0, BackwardSupportUtil.b.g(paramContext, 40.0F));
    setDuration(0);
    this.tOb = ((TextView)this.HAs.findViewById(2131305958));
    switch (this.level)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142239);
      return;
      this.tOb.setTextColor(-1);
      AppMethodBeat.o(142239);
      return;
      this.tOb.setTextColor(this.context.getResources().getColor(2131101038));
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
    int j = dT(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142233);
        this.HAu.dismiss();
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(142233);
      }
    }.sendEmptyMessageDelayed(0, paramLong);
    AppMethodBeat.o(142242);
    return paramString;
  }
  
  public static void ch(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142246);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(142246);
  }
  
  public static void ci(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142247);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)paramContext.findViewById(2131305956)).setImageResource(2131690416);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(142247);
  }
  
  private static int dT(Context paramContext)
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
    jV(paramContext);
    AppMethodBeat.o(164156);
  }
  
  public static int jL(Context paramContext)
  {
    AppMethodBeat.i(210324);
    int i = aj.jx(paramContext);
    AppMethodBeat.o(210324);
    return i;
  }
  
  public static void jV(Context paramContext)
  {
    AppMethodBeat.i(142248);
    if (g.getExternalStorageState().equals("mounted_ro"))
    {
      a.aL(paramContext, 3);
      AppMethodBeat.o(142248);
      return;
    }
    a.aL(paramContext, 1);
    AppMethodBeat.o(142248);
  }
  
  public static void jW(Context paramContext)
  {
    AppMethodBeat.i(142249);
    a.aL(paramContext, 2);
    AppMethodBeat.o(142249);
  }
  
  public static o m(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(197190);
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
    int k = dT(paramActivity);
    int i = j;
    if (j == 0) {
      i = aj.jx(paramActivity);
    }
    ap.f(new t.6(paramString, paramActivity, i + k));
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142231);
        this.HAu.dismiss();
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
        this.HAu.dismiss();
        AppMethodBeat.o(142232);
      }
    });
    AppMethodBeat.o(197190);
    return paramString;
  }
  
  public static void w(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(197191);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)paramContext.findViewById(2131305956)).setImageResource(paramInt);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(197191);
  }
  
  public final void reset()
  {
    this.level = 1;
    this.duration = 2000L;
    this.ofG = ((int)(this.duration / 70L) + 1);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(142241);
    this.tOb.setText(paramInt);
    AppMethodBeat.o(142241);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142240);
    this.tOb.setText(paramCharSequence);
    AppMethodBeat.o(142240);
  }
  
  static final class a
  {
    public static int lastType = 0;
    private static Toast sGM = null;
    
    public static void aL(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(142238);
      paramContext = paramContext.getApplicationContext();
      if (lastType != paramInt)
      {
        sGM = null;
        lastType = paramInt;
      }
      if (sGM == null) {
        sGM = Toast.makeText(paramContext, "", 1);
      }
      paramContext = View.inflate(paramContext, 2131495312, null);
      if (paramInt == 1) {
        ((TextView)paramContext.findViewById(2131304383)).setText(2131761212);
      }
      for (;;)
      {
        sGM.setView(paramContext);
        sGM.show();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.t
 * JD-Core Version:    0.7.0.1
 */
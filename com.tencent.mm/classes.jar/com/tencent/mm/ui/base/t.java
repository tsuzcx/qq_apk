package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.af;

public final class t
  extends Toast
{
  public final ap caS;
  private final Context context;
  public long duration;
  private View hXE;
  public int kxm;
  private int level;
  private final TextView nSA;
  
  public t(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(106879);
    this.caS = new ap(new t.1(this), true);
    this.context = paramContext;
    reset();
    this.hXE = View.inflate(paramContext, 2130971004, null);
    setView(this.hXE);
    setGravity(55, 0, BackwardSupportUtil.b.b(paramContext, 40.0F));
    setDuration(0);
    this.nSA = ((TextView)this.hXE.findViewById(2131828506));
    switch (this.level)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(106879);
      return;
      this.nSA.setTextColor(-1);
      AppMethodBeat.o(106879);
      return;
      this.nSA.setTextColor(this.context.getResources().getColor(2131690591));
    }
  }
  
  public static o a(Activity paramActivity, int paramInt, String paramString)
  {
    AppMethodBeat.i(106884);
    View localView = View.inflate(paramActivity, 2130969985, null);
    Object localObject = (TextView)localView.findViewById(2131825424);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    paramString = (ImageView)localView.findViewById(2131825423);
    if (paramInt == 0) {
      paramString.setVisibility(8);
    }
    for (;;)
    {
      paramString = new o(localView);
      paramString.setWidth(-1);
      paramString.setHeight(-2);
      localObject = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      int i = ((Rect)localObject).top;
      int j = di(paramActivity);
      paramInt = i;
      if (i == 0) {
        paramInt = af.hU(paramActivity);
      }
      al.d(new t.7(paramString, paramActivity, paramInt + j));
      al.p(new t.2(paramString), 2000L);
      paramActivity = (ImageButton)localView.findViewById(2131825425);
      paramActivity.setVisibility(8);
      paramActivity.setOnClickListener(new t.3(paramString));
      AppMethodBeat.o(106884);
      return paramString;
      paramString.setImageResource(paramInt);
    }
  }
  
  public static o a(Activity paramActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(106882);
    Object localObject = View.inflate(paramActivity, 2130971004, null);
    ((TextView)((View)localObject).findViewById(2131828506)).setText(paramString);
    paramString = new o((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = di(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new t.4(paramString).sendEmptyMessageDelayed(0, paramLong);
    AppMethodBeat.o(106882);
    return paramString;
  }
  
  public static o a(Activity paramActivity, String paramString, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106885);
    View localView = View.inflate(paramActivity, 2130970999, null);
    ((LinearLayout)localView.findViewById(2131828499)).setBackgroundColor(paramActivity.getResources().getColor(2131690587));
    Object localObject = (TextView)localView.findViewById(2131828501);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    ((TextView)localObject).setTextColor(paramActivity.getResources().getColor(2131689766));
    ((ImageView)localView.findViewById(2131828500)).setImageResource(2131232095);
    paramString = new o(localView);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    Window localWindow = paramActivity.getWindow();
    localWindow.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).top;
    int k = di(paramActivity);
    int i = j;
    if (j == 0) {
      i = af.hU(paramActivity);
    }
    if (localWindow.getDecorView() != null) {
      localWindow.getDecorView().post(new t.5(paramString, localWindow, i + k));
    }
    paramActivity = (ImageView)localView.findViewById(2131828502);
    paramActivity.setImageResource(2130840589);
    paramActivity.setOnClickListener(new t.6(paramString, paramOnClickListener));
    AppMethodBeat.o(106885);
    return paramString;
  }
  
  public static void bP(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142751);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2130969018, null);
    ((TextView)paramContext.findViewById(2131822417)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(142751);
  }
  
  private static int di(Context paramContext)
  {
    AppMethodBeat.i(106883);
    int i;
    if (((paramContext instanceof AppCompatActivity)) && (((AppCompatActivity)paramContext).getSupportActionBar() != null)) {
      i = ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    while (i == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(2131427559);
      AppMethodBeat.o(106883);
      return i;
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = paramContext.getResources().getDimensionPixelSize(2131427558);
      } else {
        i = paramContext.getResources().getDimensionPixelSize(2131427559);
      }
    }
    AppMethodBeat.o(106883);
    return i;
  }
  
  public static int hY(Context paramContext)
  {
    AppMethodBeat.i(156784);
    int i = af.hU(paramContext);
    AppMethodBeat.o(156784);
    return i;
  }
  
  public static void ii(Context paramContext)
  {
    AppMethodBeat.i(106886);
    if (h.getExternalStorageState().equals("mounted_ro"))
    {
      t.a.aC(paramContext, 3);
      AppMethodBeat.o(106886);
      return;
    }
    t.a.aC(paramContext, 1);
    AppMethodBeat.o(106886);
  }
  
  public static void ij(Context paramContext)
  {
    AppMethodBeat.i(106887);
    t.a.aC(paramContext, 2);
    AppMethodBeat.o(106887);
  }
  
  public final void reset()
  {
    this.level = 1;
    this.duration = 2000L;
    this.kxm = ((int)(this.duration / 70L) + 1);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(106881);
    this.nSA.setText(paramInt);
    AppMethodBeat.o(106881);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106880);
    this.nSA.setText(paramCharSequence);
    AppMethodBeat.o(106880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.t
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.ui.ak;

public final class s
  extends Toast
{
  public final am byQ = new am(new s.1(this), true);
  private final Context context;
  public long duration;
  private View gAr;
  public int iwi;
  private int level;
  private final TextView lvk;
  
  public s(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    reset();
    this.gAr = View.inflate(paramContext, a.h.toast_view, null);
    setView(this.gAr);
    setGravity(55, 0, BackwardSupportUtil.b.b(paramContext, 40.0F));
    setDuration(0);
    this.lvk = ((TextView)this.gAr.findViewById(a.g.toast_view_text));
    switch (this.level)
    {
    default: 
      return;
    case 1: 
      this.lvk.setTextColor(-1);
      return;
    }
    this.lvk.setTextColor(this.context.getResources().getColor(a.d.toasterro));
  }
  
  public static o a(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    View localView = View.inflate(paramActivity, a.h.tipsbar_style_two, null);
    ((LinearLayout)localView.findViewById(a.g.tipsbar_item)).setBackgroundColor(paramActivity.getResources().getColor(paramInt1));
    Object localObject = (TextView)localView.findViewById(a.g.tipsbar_text);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    if ((paramInt1 == a.d.tipsbar_white_bg_color) || (paramInt1 == a.d.tipsbar_red_bg_color)) {
      ((TextView)localObject).setTextColor(paramActivity.getResources().getColor(a.d.black_text_color));
    }
    paramString = (ImageView)localView.findViewById(a.g.tipsbar_left_icon);
    if (paramInt2 == 0)
    {
      paramString.setVisibility(8);
      paramInt1 = a.fromDPToPix(paramActivity, 16);
      ((TextView)localObject).setPadding(paramInt1, 0, paramInt1, 0);
      paramString = new o(localView);
      paramString.setWidth(-1);
      paramString.setHeight(-2);
      localObject = new Rect();
      Window localWindow = paramActivity.getWindow();
      localWindow.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt2 = ((Rect)localObject).top;
      int i = cD(paramActivity);
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = ak.gA(paramActivity);
      }
      if (localWindow.getDecorView() != null) {
        localWindow.getDecorView().post(new s.5(paramString, localWindow, paramInt1 + i));
      }
      paramActivity = (ImageView)localView.findViewById(a.g.tipsbar_right_icon);
      if (paramInt3 != 0) {
        break label271;
      }
      paramActivity.setVisibility(8);
    }
    for (;;)
    {
      paramActivity.setOnClickListener(new s.6(paramString, paramOnClickListener));
      return paramString;
      paramString.setImageResource(paramInt2);
      break;
      label271:
      paramActivity.setImageResource(paramInt3);
    }
  }
  
  public static o a(Activity paramActivity, int paramInt, String paramString)
  {
    View localView = View.inflate(paramActivity, a.h.listen_model_notify, null);
    Object localObject = (TextView)localView.findViewById(a.g.listen_model_notify_text);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    paramString = (ImageView)localView.findViewById(a.g.listen_model_notify_imageview);
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
      int j = cD(paramActivity);
      paramInt = i;
      if (i == 0) {
        paramInt = ak.gA(paramActivity);
      }
      ai.d(new s.7(paramString, paramActivity, paramInt + j));
      ai.l(new s.2(paramString), 2000L);
      paramActivity = (ImageButton)localView.findViewById(a.g.listen_model_notify_btn);
      paramActivity.setVisibility(8);
      paramActivity.setOnClickListener(new s.3(paramString));
      return paramString;
      paramString.setImageResource(paramInt);
    }
  }
  
  public static o a(Activity paramActivity, String paramString, long paramLong)
  {
    Object localObject = View.inflate(paramActivity, a.h.toast_view, null);
    ((TextView)((View)localObject).findViewById(a.g.toast_view_text)).setText(paramString);
    paramString = new o((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = cD(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new s.4(paramString).sendEmptyMessageDelayed(0, paramLong);
    return paramString;
  }
  
  private static int cD(Context paramContext)
  {
    int i;
    if (((paramContext instanceof AppCompatActivity)) && (((AppCompatActivity)paramContext).getSupportActionBar() != null)) {
      i = ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
      }
      return j;
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);
      } else {
        i = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
      }
    }
  }
  
  @Deprecated
  public static int gA(Context paramContext)
  {
    return ak.gA(paramContext);
  }
  
  public static void gM(Context paramContext)
  {
    if (h.getExternalStorageState().equals("mounted_ro"))
    {
      s.a.ao(paramContext, 3);
      return;
    }
    s.a.ao(paramContext, 1);
  }
  
  public static void gN(Context paramContext)
  {
    s.a.ao(paramContext, 2);
  }
  
  public static int gO(Context paramContext)
  {
    return ak.gA(paramContext);
  }
  
  public final void reset()
  {
    this.level = 1;
    this.duration = 2000L;
    this.iwi = ((int)(this.duration / 70L) + 1);
  }
  
  public final void setText(int paramInt)
  {
    this.lvk.setText(paramInt);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.lvk.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.s
 * JD-Core Version:    0.7.0.1
 */
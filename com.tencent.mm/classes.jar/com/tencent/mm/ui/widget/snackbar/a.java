package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.am;

public final class a
{
  SnackContainer AKs;
  b AKt;
  a.c AKu;
  private final View.OnClickListener AKv;
  Handler mHandler;
  View mParentView;
  
  public a(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(112980);
    this.mHandler = new Handler();
    this.AKv = new a.1(this);
    View localView = paramActivity.findViewById(16908290);
    Object localObject = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    ((LayoutInflater)localObject).inflate(2130970768, (ViewGroup)localView);
    localObject = ((LayoutInflater)localObject).inflate(2130970769, (ViewGroup)localView, false);
    a((ViewGroup)localView, (View)localObject, paramInt, paramActivity);
    AppMethodBeat.o(112980);
  }
  
  public a(Context paramContext, View paramView, int paramInt)
  {
    AppMethodBeat.i(112981);
    this.mHandler = new Handler();
    this.AKv = new a.1(this);
    if ((paramView == null) && ((paramContext instanceof Activity))) {
      paramView = ((Activity)paramContext).findViewById(16908290);
    }
    for (;;)
    {
      Object localObject = (LayoutInflater)paramContext.getSystemService("layout_inflater");
      ((LayoutInflater)localObject).inflate(2130970768, (ViewGroup)paramView);
      localObject = ((LayoutInflater)localObject).inflate(2130970769, (ViewGroup)paramView, false);
      a((ViewGroup)paramView, (View)localObject, paramInt, paramContext);
      AppMethodBeat.o(112981);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(112982);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(112982);
      return;
    }
    this.AKs = ((SnackContainer)paramViewGroup.findViewById(2131827819));
    if (this.AKs == null) {
      this.AKs = new SnackContainer(paramViewGroup);
    }
    this.mParentView = paramView;
    if (paramInt == 36) {
      this.AKs.setOnTouchListener(new a.2(this));
    }
    ((TextView)paramView.findViewById(2131827822)).setOnClickListener(this.AKv);
    boolean bool1 = am.hO(paramContext);
    paramInt = am.fx(paramContext);
    ak.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(paramInt) });
    boolean bool2 = aI((Activity)paramContext);
    ak.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[] { Boolean.valueOf(bool2) });
    if ((bool2) && (bool1))
    {
      paramViewGroup = (LinearLayout)paramView.findViewById(2131827820);
      paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      paramView.bottomMargin = paramInt;
      paramViewGroup.setLayoutParams(paramView);
    }
    AppMethodBeat.o(112982);
  }
  
  private static boolean aI(Activity paramActivity)
  {
    AppMethodBeat.i(112983);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity = paramActivity.getWindow().getAttributes();
      if (paramActivity.flags == (paramActivity.flags & 0xF7FFFFFF | 0x8000000))
      {
        AppMethodBeat.o(112983);
        return true;
      }
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public static abstract interface b
  {
    public abstract void aVA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a
 * JD-Core Version:    0.7.0.1
 */
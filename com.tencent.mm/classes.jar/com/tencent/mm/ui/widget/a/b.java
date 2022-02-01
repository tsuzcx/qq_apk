package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.bf;

public class b
  extends e
{
  private FrameLayout PQX;
  private Context mContext;
  
  public b(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private b(Context paramContext, byte paramByte)
  {
    super(paramContext, a.j.CustomSheetStyle);
    AppMethodBeat.i(159284);
    this.mContext = paramContext;
    bU();
    AppMethodBeat.o(159284);
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(159289);
    Object localObject1 = getWindow();
    Object localObject2;
    label71:
    View localView;
    if (isLandscape())
    {
      ((Window)localObject1).setGravity(5);
      ((Window)localObject1).setWindowAnimations(a.j.RightToLeftAnimation);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      if (!isLandscape()) {
        break label227;
      }
      ((WindowManager.LayoutParams)localObject2).width = -2;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localObject2 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(a.g.menu_sheet_dialog, null);
      localView = ((ViewGroup)localObject2).findViewById(a.f.touch_outside);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, (ViewGroup)localObject2, false);
        }
      }
      if (!isLandscape()) {
        break label243;
      }
      this.PQX = ((FrameLayout)((ViewGroup)localObject2).findViewById(a.f.menu_sheet_right_container));
      label156:
      jHC();
      this.PQX.setVisibility(0);
      if (paramLayoutParams != null) {
        break label261;
      }
      this.PQX.addView((View)localObject1);
    }
    for (;;)
    {
      if (fku()) {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159283);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/ui/widget/dialog/CustomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (b.this.isShowing()) {
              b.this.cancel();
            }
            a.a(this, "com/tencent/mm/ui/widget/dialog/CustomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(159283);
          }
        });
      }
      AppMethodBeat.o(159289);
      return localObject2;
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(a.j.BottomToTopAnimation);
      break;
      label227:
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      break label71;
      label243:
      this.PQX = ((FrameLayout)((ViewGroup)localObject2).findViewById(a.f.menu_sheet_bottom_container));
      break label156;
      label261:
      this.PQX.addView((View)localObject1, paramLayoutParams);
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(159292);
    int i = getWindow().getWindowManager().getDefaultDisplay().getRotation();
    AppMethodBeat.o(159292);
    return i;
  }
  
  private void jHC()
  {
    AppMethodBeat.i(251826);
    if ((bf.bg(this.mContext)) && (Build.VERSION.SDK_INT < 30)) {}
    for (int i = bf.bk(this.mContext);; i = 0)
    {
      CoordinatorLayout.d locald;
      if (isLandscape())
      {
        if (this.PQX != null)
        {
          locald = (CoordinatorLayout.d)this.PQX.getLayoutParams();
          if (getRotation() == 1) {
            locald.setMargins(0, 0, i, 0);
          }
          for (;;)
          {
            this.PQX.setLayoutParams(locald);
            AppMethodBeat.o(251826);
            return;
            if (getRotation() == 3) {
              locald.setMargins(i, 0, 0, 0);
            }
          }
        }
      }
      else if (this.PQX != null)
      {
        locald = (CoordinatorLayout.d)this.PQX.getLayoutParams();
        locald.setMargins(0, 0, 0, i);
        this.PQX.setLayoutParams(locald);
      }
      AppMethodBeat.o(251826);
      return;
    }
  }
  
  protected boolean fku()
  {
    AppMethodBeat.i(159290);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(159290);
      return true;
    }
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(16843611, localTypedValue, true))
    {
      if (localTypedValue.data != 0)
      {
        AppMethodBeat.o(159290);
        return true;
      }
      AppMethodBeat.o(159290);
      return false;
    }
    AppMethodBeat.o(159290);
    return false;
  }
  
  protected final boolean isLandscape()
  {
    AppMethodBeat.i(159291);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(159291);
      return true;
    }
    AppMethodBeat.o(159291);
    return false;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(251842);
    super.onAttachedToWindow();
    jHC();
    AppMethodBeat.o(251842);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159288);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    AppMethodBeat.o(159288);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(159287);
    super.setContentView(b(paramInt, null, null));
    AppMethodBeat.o(159287);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(159285);
    super.setContentView(b(0, paramView, null));
    AppMethodBeat.o(159285);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(159286);
    super.setContentView(b(0, paramView, paramLayoutParams));
    AppMethodBeat.o(159286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.b
 * JD-Core Version:    0.7.0.1
 */
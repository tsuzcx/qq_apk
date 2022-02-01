package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.bf;

public final class l
  extends e
{
  private FrameLayout PQX;
  private Context mContext;
  
  public l(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    AppMethodBeat.i(251791);
    this.mContext = paramContext;
    bU();
    AppMethodBeat.o(251791);
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(251799);
    Object localObject1 = getWindow();
    Object localObject2;
    label72:
    View localView;
    if (isLandscape())
    {
      ((Window)localObject1).setGravity(1);
      ((Window)localObject1).setWindowAnimations(a.j.BottomToTopSlowAnimation);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      if (!isLandscape()) {
        break label224;
      }
      ((WindowManager.LayoutParams)localObject2).width = -2;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localObject2 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(a.g.new_menu_sheet_dialog, null);
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
        break label240;
      }
      this.PQX = ((FrameLayout)((ViewGroup)localObject2).findViewById(a.f.menu_sheet_center_container));
      label157:
      this.PQX.setVisibility(0);
      if (paramLayoutParams != null) {
        break label262;
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
            AppMethodBeat.i(251820);
            b localb = new b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (l.this.isShowing()) {
              l.this.cancel();
            }
            a.a(this, "com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(251820);
          }
        });
      }
      AppMethodBeat.o(251799);
      return localObject2;
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(a.j.BottomToTopSlowAnimation);
      break;
      label224:
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      break label72;
      label240:
      this.PQX = ((FrameLayout)((ViewGroup)localObject2).findViewById(a.f.menu_sheet_bottom_container));
      jHC();
      break label157;
      label262:
      this.PQX.addView((View)localObject1, paramLayoutParams);
    }
  }
  
  private boolean fku()
  {
    AppMethodBeat.i(251805);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(251805);
      return true;
    }
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(16843611, localTypedValue, true))
    {
      if (localTypedValue.data != 0)
      {
        AppMethodBeat.o(251805);
        return true;
      }
      AppMethodBeat.o(251805);
      return false;
    }
    AppMethodBeat.o(251805);
    return false;
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(251809);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(251809);
      return true;
    }
    AppMethodBeat.o(251809);
    return false;
  }
  
  private void jHC()
  {
    AppMethodBeat.i(251812);
    if ((this.PQX != null) && (!isLandscape())) {
      if ((!bf.bg(this.mContext)) || (Build.VERSION.SDK_INT >= 30)) {
        break label78;
      }
    }
    label78:
    for (int i = bf.bk(this.mContext);; i = 0)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)this.PQX.getLayoutParams();
      locald.setMargins(0, 0, 0, i);
      this.PQX.setLayoutParams(locald);
      AppMethodBeat.o(251812);
      return;
    }
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(251815);
    super.onAttachedToWindow();
    jHC();
    AppMethodBeat.o(251815);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251834);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    AppMethodBeat.o(251834);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(251830);
    super.setContentView(b(paramInt, null, null));
    AppMethodBeat.o(251830);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(251819);
    super.setContentView(b(0, paramView, null));
    AppMethodBeat.o(251819);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(251825);
    super.setContentView(b(0, paramView, paramLayoutParams));
    AppMethodBeat.o(251825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.l
 * JD-Core Version:    0.7.0.1
 */
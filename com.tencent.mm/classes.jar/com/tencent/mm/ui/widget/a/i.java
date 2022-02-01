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
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ax;

public final class i
  extends e
{
  private FrameLayout JMG;
  private Context mContext;
  
  public i(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    AppMethodBeat.i(250965);
    this.mContext = paramContext;
    bb();
    AppMethodBeat.o(250965);
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(250979);
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
      this.JMG = ((FrameLayout)((ViewGroup)localObject2).findViewById(a.f.menu_sheet_center_container));
      label157:
      this.JMG.setVisibility(0);
      if (paramLayoutParams != null) {
        break label262;
      }
      this.JMG.addView((View)localObject1);
    }
    for (;;)
    {
      if (haG()) {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(249767);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (i.this.isShowing()) {
              i.this.cancel();
            }
            a.a(this, "com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(249767);
          }
        });
      }
      AppMethodBeat.o(250979);
      return localObject2;
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(a.j.BottomToTopSlowAnimation);
      break;
      label224:
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      break label72;
      label240:
      this.JMG = ((FrameLayout)((ViewGroup)localObject2).findViewById(a.f.menu_sheet_bottom_container));
      ico();
      break label157;
      label262:
      this.JMG.addView((View)localObject1, paramLayoutParams);
    }
  }
  
  private boolean haG()
  {
    AppMethodBeat.i(250981);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(250981);
      return true;
    }
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(16843611, localTypedValue, true))
    {
      if (localTypedValue.data != 0)
      {
        AppMethodBeat.o(250981);
        return true;
      }
      AppMethodBeat.o(250981);
      return false;
    }
    AppMethodBeat.o(250981);
    return false;
  }
  
  private void ico()
  {
    AppMethodBeat.i(250984);
    if ((this.JMG != null) && (!isLandscape())) {
      if ((!ax.av(this.mContext)) || (Build.VERSION.SDK_INT >= 30)) {
        break label78;
      }
    }
    label78:
    for (int i = ax.aB(this.mContext);; i = 0)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)this.JMG.getLayoutParams();
      locald.setMargins(0, 0, 0, i);
      this.JMG.setLayoutParams(locald);
      AppMethodBeat.o(250984);
      return;
    }
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(250983);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(250983);
      return true;
    }
    AppMethodBeat.o(250983);
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(250967);
    super.onAttachedToWindow();
    ico();
    AppMethodBeat.o(250967);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250975);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    AppMethodBeat.o(250975);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(250973);
    super.setContentView(b(paramInt, null, null));
    AppMethodBeat.o(250973);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(250969);
    super.setContentView(b(0, paramView, null));
    AppMethodBeat.o(250969);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(250971);
    super.setContentView(b(0, paramView, paramLayoutParams));
    AppMethodBeat.o(250971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.app.e;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.au;

public final class i
  extends e
{
  private FrameLayout DAU;
  private Context mContext;
  
  public i(Context paramContext)
  {
    super(paramContext, 2131820868);
    AppMethodBeat.i(198284);
    this.mContext = paramContext;
    gR();
    AppMethodBeat.o(198284);
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(198290);
    Object localObject1 = getWindow();
    Object localObject2;
    label71:
    View localView;
    if (isLandscape())
    {
      ((Window)localObject1).setGravity(1);
      ((Window)localObject1).setWindowAnimations(2131820793);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      if (!isLandscape()) {
        break label219;
      }
      ((WindowManager.LayoutParams)localObject2).width = -2;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localObject2 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131495846, null);
      localView = ((ViewGroup)localObject2).findViewById(2131309368);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, (ViewGroup)localObject2, false);
        }
      }
      if (!isLandscape()) {
        break label235;
      }
      this.DAU = ((FrameLayout)((ViewGroup)localObject2).findViewById(2131304631));
      label153:
      this.DAU.setVisibility(0);
      if (paramLayoutParams != null) {
        break label256;
      }
      this.DAU.addView((View)localObject1);
    }
    for (;;)
    {
      if (ghl()) {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198283);
            b localb = new b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (i.this.isShowing()) {
              i.this.cancel();
            }
            a.a(this, "com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198283);
          }
        });
      }
      AppMethodBeat.o(198290);
      return localObject2;
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(2131820793);
      break;
      label219:
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      break label71;
      label235:
      this.DAU = ((FrameLayout)((ViewGroup)localObject2).findViewById(2131304630));
      hbi();
      break label153;
      label256:
      this.DAU.addView((View)localObject1, paramLayoutParams);
    }
  }
  
  private boolean ghl()
  {
    AppMethodBeat.i(198291);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(198291);
      return true;
    }
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(16843611, localTypedValue, true))
    {
      if (localTypedValue.data != 0)
      {
        AppMethodBeat.o(198291);
        return true;
      }
      AppMethodBeat.o(198291);
      return false;
    }
    AppMethodBeat.o(198291);
    return false;
  }
  
  private void hbi()
  {
    AppMethodBeat.i(198293);
    if ((this.DAU != null) && (!isLandscape())) {
      if ((!au.aA(this.mContext)) || (Build.VERSION.SDK_INT >= 30)) {
        break label78;
      }
    }
    label78:
    for (int i = au.aD(this.mContext);; i = 0)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)this.DAU.getLayoutParams();
      locald.setMargins(0, 0, 0, i);
      this.DAU.setLayoutParams(locald);
      AppMethodBeat.o(198293);
      return;
    }
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(198292);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(198292);
      return true;
    }
    AppMethodBeat.o(198292);
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(198285);
    super.onAttachedToWindow();
    hbi();
    AppMethodBeat.o(198285);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198289);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    AppMethodBeat.o(198289);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(198288);
    super.setContentView(b(paramInt, null, null));
    AppMethodBeat.o(198288);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(198286);
    super.setContentView(b(0, paramView, null));
    AppMethodBeat.o(198286);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(198287);
    super.setContentView(b(0, paramView, paramLayoutParams));
    AppMethodBeat.o(198287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.i
 * JD-Core Version:    0.7.0.1
 */
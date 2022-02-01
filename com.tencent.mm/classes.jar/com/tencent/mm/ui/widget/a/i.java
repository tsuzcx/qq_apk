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
import com.tencent.mm.ui.ar;

public final class i
  extends e
{
  private Context mContext;
  
  public i(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(192632);
    this.mContext = paramContext;
    gK();
    AppMethodBeat.o(192632);
  }
  
  private boolean aol()
  {
    AppMethodBeat.i(192639);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(192639);
      return true;
    }
    AppMethodBeat.o(192639);
    return false;
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(192637);
    Object localObject1 = getWindow();
    Object localObject2;
    label71:
    ViewGroup localViewGroup;
    View localView;
    if (aol())
    {
      ((Window)localObject1).setGravity(1);
      ((Window)localObject1).setWindowAnimations(2131820790);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      if (!aol()) {
        break label228;
      }
      ((WindowManager.LayoutParams)localObject2).width = -2;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localViewGroup = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131496482, null);
      localView = localViewGroup.findViewById(2131306045);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, localViewGroup, false);
        }
      }
      if (!ar.jR(this.mContext)) {
        break label303;
      }
    }
    label168:
    label303:
    for (paramInt = ar.ej(this.mContext);; paramInt = 0)
    {
      if (aol())
      {
        paramView = (FrameLayout)localViewGroup.findViewById(2131308358);
        paramView.setVisibility(0);
        if (paramLayoutParams != null) {
          break label293;
        }
        paramView.addView((View)localObject1);
      }
      for (;;)
      {
        if (eUt()) {
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(192631);
              b localb = new b();
              localb.bd(paramAnonymousView);
              a.b("com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (i.this.isShowing()) {
                i.this.cancel();
              }
              a.a(this, "com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(192631);
            }
          });
        }
        AppMethodBeat.o(192637);
        return localViewGroup;
        ((Window)localObject1).setGravity(80);
        ((Window)localObject1).setWindowAnimations(2131820790);
        break;
        label228:
        ((WindowManager.LayoutParams)localObject2).width = -1;
        ((WindowManager.LayoutParams)localObject2).height = -2;
        break label71;
        localObject2 = (FrameLayout)localViewGroup.findViewById(2131302249);
        paramView = (View)localObject2;
        if (localObject2 == null) {
          break label168;
        }
        paramView = (CoordinatorLayout.d)((FrameLayout)localObject2).getLayoutParams();
        paramView.setMargins(0, 0, 0, paramInt);
        ((FrameLayout)localObject2).setLayoutParams(paramView);
        paramView = (View)localObject2;
        break label168;
        paramView.addView((View)localObject1, paramLayoutParams);
      }
    }
  }
  
  private boolean eUt()
  {
    AppMethodBeat.i(192638);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(192638);
      return true;
    }
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(16843611, localTypedValue, true))
    {
      if (localTypedValue.data != 0)
      {
        AppMethodBeat.o(192638);
        return true;
      }
      AppMethodBeat.o(192638);
      return false;
    }
    AppMethodBeat.o(192638);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192636);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    AppMethodBeat.o(192636);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(192635);
    super.setContentView(b(paramInt, null, null));
    AppMethodBeat.o(192635);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(192633);
    super.setContentView(b(0, paramView, null));
    AppMethodBeat.o(192633);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(192634);
    super.setContentView(b(0, paramView, paramLayoutParams));
    AppMethodBeat.o(192634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.i
 * JD-Core Version:    0.7.0.1
 */
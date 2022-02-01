package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.app.e;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;

public final class b
  extends e
{
  private Context mContext;
  
  public b(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private b(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(159284);
    this.mContext = paramContext;
    gt();
    AppMethodBeat.o(159284);
  }
  
  private boolean aly()
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
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(159289);
    Object localObject1 = getWindow();
    Object localObject2;
    label70:
    ViewGroup localViewGroup;
    View localView;
    if (aly())
    {
      ((Window)localObject1).setGravity(5);
      ((Window)localObject1).setWindowAnimations(2131821249);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      if (!aly()) {
        break label270;
      }
      ((WindowManager.LayoutParams)localObject2).width = -2;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localViewGroup = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131494756, null);
      localView = localViewGroup.findViewById(2131306045);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, localViewGroup, false);
        }
      }
      if (!ap.jF(this.mContext)) {
        break label364;
      }
    }
    label201:
    label210:
    label354:
    label364:
    for (paramInt = ap.ej(this.mContext);; paramInt = 0)
    {
      if (aly())
      {
        localObject2 = (FrameLayout)localViewGroup.findViewById(2131302250);
        paramView = (View)localObject2;
        if (localObject2 != null)
        {
          paramView = (CoordinatorLayout.d)((FrameLayout)localObject2).getLayoutParams();
          if (getRotation() == 1)
          {
            paramView.setMargins(0, 0, paramInt, 0);
            ((FrameLayout)localObject2).setLayoutParams(paramView);
            paramView = (View)localObject2;
          }
        }
        else
        {
          paramView.setVisibility(0);
          if (paramLayoutParams != null) {
            break label354;
          }
          paramView.addView((View)localObject1);
        }
      }
      for (;;)
      {
        if (eFx()) {
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(159283);
              if (b.this.isShowing()) {
                b.this.cancel();
              }
              AppMethodBeat.o(159283);
            }
          });
        }
        AppMethodBeat.o(159289);
        return localViewGroup;
        ((Window)localObject1).setGravity(80);
        ((Window)localObject1).setWindowAnimations(2131820789);
        break;
        ((WindowManager.LayoutParams)localObject2).width = -1;
        ((WindowManager.LayoutParams)localObject2).height = -2;
        break label70;
        if (getRotation() != 3) {
          break label201;
        }
        paramView.setMargins(paramInt, 0, 0, 0);
        break label201;
        localObject2 = (FrameLayout)localViewGroup.findViewById(2131302249);
        paramView = (View)localObject2;
        if (localObject2 == null) {
          break label210;
        }
        paramView = (CoordinatorLayout.d)((FrameLayout)localObject2).getLayoutParams();
        paramView.setMargins(0, 0, 0, paramInt);
        ((FrameLayout)localObject2).setLayoutParams(paramView);
        paramView = (View)localObject2;
        break label210;
        paramView.addView((View)localObject1, paramLayoutParams);
      }
    }
  }
  
  private boolean eFx()
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
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    AppMethodBeat.i(159292);
    int i = getWindow().getWindowManager().getDefaultDisplay().getRotation();
    AppMethodBeat.o(159292);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159288);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    AppMethodBeat.o(159288);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(159287);
    super.setContentView(b(paramInt, null, null));
    AppMethodBeat.o(159287);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(159285);
    super.setContentView(b(0, paramView, null));
    AppMethodBeat.o(159285);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
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
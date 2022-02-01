package com.tencent.mm.plugin.sns.ad.j;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class l
{
  private static Typeface Qdt = null;
  
  public static void C(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(309736);
    if (paramView != null) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(309736);
      return;
    }
  }
  
  public static void F(TextView paramTextView)
  {
    AppMethodBeat.i(309794);
    if (paramTextView != null) {
      try
      {
        if (Qdt == null) {
          Qdt = Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), "fonts/WeChatSansStd-Medium.ttf");
        }
        if ((Qdt != null) && (paramTextView.getTypeface() != Qdt)) {
          paramTextView.setTypeface(Qdt);
        }
        AppMethodBeat.o(309794);
        return;
      }
      finally {}
    }
    AppMethodBeat.o(309794);
  }
  
  public static void W(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(309761);
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
    AppMethodBeat.o(309761);
  }
  
  public static boolean X(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(309770);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(309770);
      return false;
    }
    if (paramViewGroup.getChildCount() > 0)
    {
      AppMethodBeat.o(309770);
      return true;
    }
    AppMethodBeat.o(309770);
    return false;
  }
  
  public static View a(Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(309802);
    if ((paramContext == null) && (paramViewGroup == null))
    {
      AppMethodBeat.o(309802);
      return null;
    }
    Context localContext = paramContext;
    if (paramContext == null) {}
    try
    {
      localContext = paramViewGroup.getContext();
      paramContext = LayoutInflater.from(localContext).inflate(paramInt, paramViewGroup, false);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(309802);
    }
    return null;
  }
  
  public static void aW(View paramView, int paramInt)
  {
    AppMethodBeat.i(309822);
    if ((paramView instanceof TextView))
    {
      ((TextView)paramView).setMaxWidth(paramInt);
      AppMethodBeat.o(309822);
      return;
    }
    Log.w("ViewUtils", "the view is not support set max width.");
    AppMethodBeat.o(309822);
  }
  
  public static <T> T aX(View paramView, int paramInt)
  {
    AppMethodBeat.i(309829);
    if ((paramView == null) || (paramInt == 0))
    {
      AppMethodBeat.o(309829);
      return null;
    }
    try
    {
      paramView = paramView.getTag(paramInt);
      AppMethodBeat.o(309829);
      return paramView;
    }
    finally
    {
      Log.w("ViewUtils", "the is something wrong in view tag!!");
      AppMethodBeat.o(309829);
    }
    return null;
  }
  
  public static void b(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(309816);
    if (paramView == null)
    {
      AppMethodBeat.o(309816);
      return;
    }
    try
    {
      Object localObject = paramView.getBackground();
      if ((localObject instanceof GradientDrawable))
      {
        localObject = (GradientDrawable)localObject;
        ((GradientDrawable)localObject).mutate();
      }
      for (;;)
      {
        ((GradientDrawable)localObject).setShape(0);
        ((GradientDrawable)localObject).setAlpha((int)(255.0F * paramFloat2 + 0.5F));
        ((GradientDrawable)localObject).setColor(paramInt);
        ((GradientDrawable)localObject).setCornerRadius(paramFloat1);
        paramView.setBackground((Drawable)localObject);
        AppMethodBeat.o(309816);
        return;
        localObject = new GradientDrawable();
      }
      return;
    }
    finally
    {
      Log.w("ViewUtils", "setRoundBackground error.");
      AppMethodBeat.o(309816);
    }
  }
  
  public static boolean b(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(309730);
    if ((paramViewGroup == null) || (paramView == null)) {}
    try
    {
      AppMethodBeat.o(309730);
      return false;
    }
    finally
    {
      ViewParent localViewParent;
      Log.e("ViewUtils", "ViewUtils:: Add view to view group failed!");
      AppMethodBeat.o(309730);
    }
    if (paramInt > paramViewGroup.getChildCount())
    {
      AppMethodBeat.o(309730);
      return false;
    }
    localViewParent = paramView.getParent();
    if (localViewParent == paramViewGroup)
    {
      AppMethodBeat.o(309730);
      return true;
    }
    if (localViewParent == null) {
      paramViewGroup.addView(paramView, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(309730);
      return true;
      ((ViewGroup)localViewParent).removeView(paramView);
      paramViewGroup.addView(paramView);
    }
    return false;
  }
  
  public static <T extends View> T c(ViewStub paramViewStub)
  {
    AppMethodBeat.i(309808);
    if (paramViewStub == null)
    {
      AppMethodBeat.o(309808);
      return null;
    }
    try
    {
      paramViewStub = paramViewStub.inflate();
      AppMethodBeat.o(309808);
      return paramViewStub;
    }
    finally
    {
      Log.e("ViewUtils", "view stub inflate failed!");
      AppMethodBeat.o(309808);
    }
    return null;
  }
  
  public static void e(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(309799);
    if (paramTextView != null) {}
    try
    {
      if (TextUtils.isEmpty(paramCharSequence))
      {
        paramTextView.setText("");
        return;
      }
      paramTextView.setText(paramCharSequence);
      return;
    }
    finally
    {
      AppMethodBeat.o(309799);
    }
  }
  
  public static float g(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(309820);
    if ((TextUtils.isEmpty(paramString)) || (paramTextView == null))
    {
      AppMethodBeat.o(309820);
      return 0.0F;
    }
    try
    {
      paramTextView = paramTextView.getPaint();
      if (paramTextView == null)
      {
        AppMethodBeat.o(309820);
        return 0.0F;
      }
      float f = paramTextView.measureText(paramString);
      AppMethodBeat.o(309820);
      return f;
    }
    finally
    {
      Log.w("ViewUtils", "acquireTextWidth error.");
      AppMethodBeat.o(309820);
    }
    return 0.0F;
  }
  
  public static void i(View paramView, String paramString)
  {
    AppMethodBeat.i(309787);
    try
    {
      int i = Color.parseColor(paramString);
      if (paramView != null) {
        paramView.setBackgroundColor(i);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(309787);
    }
  }
  
  public static void jk(View paramView)
  {
    AppMethodBeat.i(309743);
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    AppMethodBeat.o(309743);
  }
  
  public static boolean jl(View paramView)
  {
    AppMethodBeat.i(309776);
    if (paramView != null)
    {
      if (paramView.getParent() != null)
      {
        AppMethodBeat.o(309776);
        return true;
      }
      AppMethodBeat.o(309776);
      return false;
    }
    AppMethodBeat.o(309776);
    return false;
  }
  
  public static void jm(View paramView)
  {
    AppMethodBeat.i(309780);
    if (paramView == null)
    {
      AppMethodBeat.o(309780);
      return;
    }
    try
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(309780);
    }
  }
  
  public static void z(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309753);
    if (paramView != null) {
      try
      {
        ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
        if (localLayoutParams2 != null)
        {
          if (paramInt1 != -1003) {
            localLayoutParams2.width = paramInt1;
          }
          localLayoutParams1 = localLayoutParams2;
          if (paramInt2 != -1003) {
            localLayoutParams2.height = paramInt2;
          }
        }
        int i;
        for (ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;; localLayoutParams1 = new ViewGroup.LayoutParams(i, paramInt1))
        {
          paramView.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(309753);
          return;
          i = paramInt1;
          if (paramInt1 == -1003) {
            i = 0;
          }
          paramInt1 = paramInt2;
          if (paramInt2 == -1003) {
            paramInt1 = 0;
          }
        }
        AppMethodBeat.o(309753);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ad.i;

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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class m
{
  private static Typeface DAh = null;
  
  public static void F(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202371);
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
    AppMethodBeat.o(202371);
  }
  
  public static boolean G(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202372);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(202372);
      return false;
    }
    if (paramViewGroup.getChildCount() > 0)
    {
      AppMethodBeat.o(202372);
      return true;
    }
    AppMethodBeat.o(202372);
    return false;
  }
  
  public static boolean a(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(202367);
    if ((paramViewGroup == null) || (paramView == null)) {}
    try
    {
      AppMethodBeat.o(202367);
      return false;
    }
    catch (Throwable paramViewGroup)
    {
      ViewParent localViewParent;
      Log.e("ViewUtils", "ViewUtils:: Add view to view group failed!");
      AppMethodBeat.o(202367);
    }
    if (paramInt > paramViewGroup.getChildCount())
    {
      AppMethodBeat.o(202367);
      return false;
    }
    localViewParent = paramView.getParent();
    if (localViewParent == paramViewGroup)
    {
      AppMethodBeat.o(202367);
      return true;
    }
    if (localViewParent == null) {
      paramViewGroup.addView(paramView, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(202367);
      return true;
      ((ViewGroup)localViewParent).removeView(paramView);
      paramViewGroup.addView(paramView);
    }
    return false;
  }
  
  public static void aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(202381);
    if ((paramView instanceof TextView))
    {
      ((TextView)paramView).setMaxWidth(paramInt);
      AppMethodBeat.o(202381);
      return;
    }
    Log.w("ViewUtils", "the view is not support set max width.");
    AppMethodBeat.o(202381);
  }
  
  public static void b(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(202379);
    if (paramView == null)
    {
      AppMethodBeat.o(202379);
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
        AppMethodBeat.o(202379);
        return;
        localObject = new GradientDrawable();
      }
      return;
    }
    catch (Throwable paramView)
    {
      Log.w("ViewUtils", "setRoundBackground error.");
      AppMethodBeat.o(202379);
    }
  }
  
  public static View e(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202378);
    if ((paramContext == null) && (paramViewGroup == null))
    {
      AppMethodBeat.o(202378);
      return null;
    }
    Context localContext = paramContext;
    if (paramContext == null) {}
    try
    {
      localContext = paramViewGroup.getContext();
      paramContext = LayoutInflater.from(localContext).inflate(2131496369, paramViewGroup, false);
      AppMethodBeat.o(202378);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(202378);
    }
    return null;
  }
  
  public static float f(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(202380);
    if ((TextUtils.isEmpty(paramString)) || (paramTextView == null))
    {
      AppMethodBeat.o(202380);
      return 0.0F;
    }
    try
    {
      paramTextView = paramTextView.getPaint();
      if (paramTextView == null)
      {
        AppMethodBeat.o(202380);
        return 0.0F;
      }
      float f = paramTextView.measureText(paramString);
      AppMethodBeat.o(202380);
      return f;
    }
    catch (Throwable paramTextView)
    {
      Log.w("ViewUtils", "acquireTextWidth error.");
      AppMethodBeat.o(202380);
    }
    return 0.0F;
  }
  
  public static void f(View paramView, String paramString)
  {
    AppMethodBeat.i(202375);
    try
    {
      int i = Color.parseColor(paramString);
      if (paramView != null) {
        paramView.setBackgroundColor(i);
      }
      AppMethodBeat.o(202375);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(202375);
    }
  }
  
  public static void f(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(202377);
    if (paramTextView != null) {}
    try
    {
      if (TextUtils.isEmpty(paramCharSequence))
      {
        paramTextView.setText("");
        AppMethodBeat.o(202377);
        return;
      }
      paramTextView.setText(paramCharSequence);
      AppMethodBeat.o(202377);
      return;
    }
    catch (Throwable paramTextView)
    {
      AppMethodBeat.o(202377);
    }
  }
  
  public static void fa(View paramView)
  {
    AppMethodBeat.i(202369);
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    AppMethodBeat.o(202369);
  }
  
  public static boolean fb(View paramView)
  {
    AppMethodBeat.i(202373);
    if (paramView != null)
    {
      if (paramView.getParent() != null)
      {
        AppMethodBeat.o(202373);
        return true;
      }
      AppMethodBeat.o(202373);
      return false;
    }
    AppMethodBeat.o(202373);
    return false;
  }
  
  public static void fc(View paramView)
  {
    AppMethodBeat.i(202374);
    if (paramView == null)
    {
      AppMethodBeat.o(202374);
      return;
    }
    try
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      AppMethodBeat.o(202374);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(202374);
    }
  }
  
  public static void u(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202370);
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
          AppMethodBeat.o(202370);
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
        AppMethodBeat.o(202370);
      }
      catch (Throwable paramView) {}
    }
  }
  
  public static void u(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(202368);
    if (paramView != null) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(202368);
      return;
    }
  }
  
  public static void u(TextView paramTextView)
  {
    AppMethodBeat.i(202376);
    if (paramTextView != null) {
      try
      {
        if (DAh == null) {
          DAh = Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), "fonts/WeChatSansStd-Medium.ttf");
        }
        if ((DAh != null) && (paramTextView.getTypeface() != DAh)) {
          paramTextView.setTypeface(DAh);
        }
        AppMethodBeat.o(202376);
        return;
      }
      catch (Throwable paramTextView) {}
    }
    AppMethodBeat.o(202376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.m
 * JD-Core Version:    0.7.0.1
 */
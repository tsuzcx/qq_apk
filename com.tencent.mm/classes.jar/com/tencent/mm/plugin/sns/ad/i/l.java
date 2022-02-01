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
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class l
{
  private static Typeface JLG = null;
  
  public static void C(TextView paramTextView)
  {
    AppMethodBeat.i(203662);
    if (paramTextView != null) {
      try
      {
        if (JLG == null) {
          JLG = Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), "fonts/WeChatSansStd-Medium.ttf");
        }
        if ((JLG != null) && (paramTextView.getTypeface() != JLG)) {
          paramTextView.setTypeface(JLG);
        }
        AppMethodBeat.o(203662);
        return;
      }
      catch (Throwable paramTextView) {}
    }
    AppMethodBeat.o(203662);
  }
  
  public static void M(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203655);
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
    AppMethodBeat.o(203655);
  }
  
  public static boolean N(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203657);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(203657);
      return false;
    }
    if (paramViewGroup.getChildCount() > 0)
    {
      AppMethodBeat.o(203657);
      return true;
    }
    AppMethodBeat.o(203657);
    return false;
  }
  
  public static View a(Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203664);
    if ((paramContext == null) && (paramViewGroup == null))
    {
      AppMethodBeat.o(203664);
      return null;
    }
    Context localContext = paramContext;
    if (paramContext == null) {}
    try
    {
      localContext = paramViewGroup.getContext();
      paramContext = LayoutInflater.from(localContext).inflate(paramInt, paramViewGroup, false);
      AppMethodBeat.o(203664);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(203664);
    }
    return null;
  }
  
  public static void aA(View paramView, int paramInt)
  {
    AppMethodBeat.i(203671);
    if ((paramView instanceof TextView))
    {
      ((TextView)paramView).setMaxWidth(paramInt);
      AppMethodBeat.o(203671);
      return;
    }
    Log.w("ViewUtils", "the view is not support set max width.");
    AppMethodBeat.o(203671);
  }
  
  public static <T> T aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(203673);
    if ((paramView == null) || (paramInt == 0))
    {
      AppMethodBeat.o(203673);
      return null;
    }
    try
    {
      paramView = paramView.getTag(paramInt);
      AppMethodBeat.o(203673);
      return paramView;
    }
    catch (Throwable paramView)
    {
      Log.w("ViewUtils", "the is something wrong in view tag!!");
      AppMethodBeat.o(203673);
    }
    return null;
  }
  
  public static void b(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(203667);
    if (paramView == null)
    {
      AppMethodBeat.o(203667);
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
        AppMethodBeat.o(203667);
        return;
        localObject = new GradientDrawable();
      }
      return;
    }
    catch (Throwable paramView)
    {
      Log.w("ViewUtils", "setRoundBackground error.");
      AppMethodBeat.o(203667);
    }
  }
  
  public static boolean b(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(203646);
    if ((paramViewGroup == null) || (paramView == null)) {}
    try
    {
      AppMethodBeat.o(203646);
      return false;
    }
    catch (Throwable paramViewGroup)
    {
      ViewParent localViewParent;
      Log.e("ViewUtils", "ViewUtils:: Add view to view group failed!");
      AppMethodBeat.o(203646);
    }
    if (paramInt > paramViewGroup.getChildCount())
    {
      AppMethodBeat.o(203646);
      return false;
    }
    localViewParent = paramView.getParent();
    if (localViewParent == paramViewGroup)
    {
      AppMethodBeat.o(203646);
      return true;
    }
    if (localViewParent == null) {
      paramViewGroup.addView(paramView, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(203646);
      return true;
      ((ViewGroup)localViewParent).removeView(paramView);
      paramViewGroup.addView(paramView);
    }
    return false;
  }
  
  public static <T extends View> T c(ViewStub paramViewStub)
  {
    AppMethodBeat.i(203666);
    if (paramViewStub == null)
    {
      AppMethodBeat.o(203666);
      return null;
    }
    try
    {
      paramViewStub = paramViewStub.inflate();
      AppMethodBeat.o(203666);
      return paramViewStub;
    }
    catch (Throwable paramViewStub)
    {
      Log.e("ViewUtils", "view stub inflate failed!");
      AppMethodBeat.o(203666);
    }
    return null;
  }
  
  public static void f(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(203663);
    if (paramTextView != null) {}
    try
    {
      if (TextUtils.isEmpty(paramCharSequence))
      {
        paramTextView.setText("");
        AppMethodBeat.o(203663);
        return;
      }
      paramTextView.setText(paramCharSequence);
      AppMethodBeat.o(203663);
      return;
    }
    catch (Throwable paramTextView)
    {
      AppMethodBeat.o(203663);
    }
  }
  
  public static float g(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(203670);
    if ((TextUtils.isEmpty(paramString)) || (paramTextView == null))
    {
      AppMethodBeat.o(203670);
      return 0.0F;
    }
    try
    {
      paramTextView = paramTextView.getPaint();
      if (paramTextView == null)
      {
        AppMethodBeat.o(203670);
        return 0.0F;
      }
      float f = paramTextView.measureText(paramString);
      AppMethodBeat.o(203670);
      return f;
    }
    catch (Throwable paramTextView)
    {
      Log.w("ViewUtils", "acquireTextWidth error.");
      AppMethodBeat.o(203670);
    }
    return 0.0F;
  }
  
  public static void gh(View paramView)
  {
    AppMethodBeat.i(203651);
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    AppMethodBeat.o(203651);
  }
  
  public static boolean gi(View paramView)
  {
    AppMethodBeat.i(203658);
    if (paramView != null)
    {
      if (paramView.getParent() != null)
      {
        AppMethodBeat.o(203658);
        return true;
      }
      AppMethodBeat.o(203658);
      return false;
    }
    AppMethodBeat.o(203658);
    return false;
  }
  
  public static void gj(View paramView)
  {
    AppMethodBeat.i(203659);
    if (paramView == null)
    {
      AppMethodBeat.o(203659);
      return;
    }
    try
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      AppMethodBeat.o(203659);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(203659);
    }
  }
  
  public static void i(View paramView, String paramString)
  {
    AppMethodBeat.i(203661);
    try
    {
      int i = Color.parseColor(paramString);
      if (paramView != null) {
        paramView.setBackgroundColor(i);
      }
      AppMethodBeat.o(203661);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(203661);
    }
  }
  
  public static void v(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203654);
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
          AppMethodBeat.o(203654);
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
        AppMethodBeat.o(203654);
      }
      catch (Throwable paramView) {}
    }
  }
  
  public static void w(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(203650);
    if (paramView != null) {
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(203650);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.l
 * JD-Core Version:    0.7.0.1
 */
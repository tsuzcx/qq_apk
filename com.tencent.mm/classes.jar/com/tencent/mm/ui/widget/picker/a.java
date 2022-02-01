package com.tencent.mm.ui.widget.picker;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  protected com.tencent.mm.ui.widget.picker.c.a Jja;
  boolean cBT;
  private Context context;
  protected ViewGroup isM;
  ViewGroup isN;
  private ViewGroup isO;
  boolean isP;
  private Animation isQ;
  private Animation isR;
  protected int isS;
  private boolean isT;
  private View.OnKeyListener isU;
  private final View.OnTouchListener isV;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(199715);
    this.isS = 80;
    this.isT = true;
    this.isU = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(199713);
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aMQ()) && ((paramAnonymousView.isN.getParent() != null) || (paramAnonymousView.cBT))) {}
          for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
          {
            a.this.dismiss();
            AppMethodBeat.o(199713);
            return true;
          }
        }
        AppMethodBeat.o(199713);
        return false;
      }
    };
    this.isV = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(199714);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          a.this.dismiss();
        }
        AppMethodBeat.o(199714);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(199715);
  }
  
  protected final void aMM()
  {
    AppMethodBeat.i(199716);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.isN = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.Jja.Xt, false));
    this.isN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.Jja.isI != -1) {
      this.isN.setBackgroundColor(this.Jja.isI);
    }
    this.isM = ((ViewGroup)this.isN.findViewById(2131298752));
    this.isM.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aMQ()) {}
    for (localObject = this.isO;; localObject = this.isN)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.isU);
      AppMethodBeat.o(199716);
      return;
    }
  }
  
  protected final void aMN()
  {
    AppMethodBeat.i(199717);
    int i = com.tencent.mm.ui.widget.picker.f.a.E(this.isS, true);
    this.isR = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.ui.widget.picker.f.a.E(this.isS, false);
    this.isQ = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(199717);
  }
  
  public final void aMO()
  {
    AppMethodBeat.i(199719);
    this.Jja.Xt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199712);
        a.this.Jja.Xt.removeView(a.this.isN);
        a.this.cBT = false;
        a.this.isP = false;
        AppMethodBeat.o(199712);
      }
    });
    AppMethodBeat.o(199719);
  }
  
  public final void aMP()
  {
    AppMethodBeat.i(199721);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.Jja.mz);
    }
    AppMethodBeat.o(199721);
  }
  
  public boolean aMQ()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(199718);
    if (aMQ())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(199718);
      return;
    }
    if (this.isP)
    {
      AppMethodBeat.o(199718);
      return;
    }
    if (this.isT)
    {
      this.isQ.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(199711);
          a.this.aMO();
          AppMethodBeat.o(199711);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.isM.startAnimation(this.isQ);
    }
    for (;;)
    {
      this.isP = true;
      AppMethodBeat.o(199718);
      return;
      aMO();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(199722);
    View localView = this.isM.findViewById(paramInt);
    AppMethodBeat.o(199722);
    return localView;
  }
  
  protected final a yj(boolean paramBoolean)
  {
    AppMethodBeat.i(199720);
    View localView;
    if (this.isN != null)
    {
      localView = this.isN.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.isV);
    }
    for (;;)
    {
      AppMethodBeat.o(199720);
      return this;
      label41:
      localView.setOnTouchListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */
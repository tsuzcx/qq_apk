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
import com.tencent.mm.hellhoundlib.b.b;

public class a
{
  protected com.tencent.mm.ui.widget.picker.c.a Lax;
  boolean cMS;
  private Context context;
  protected ViewGroup iLP;
  ViewGroup iLQ;
  private ViewGroup iLR;
  boolean iLS;
  private Animation iLT;
  private Animation iLU;
  protected int iLV;
  private boolean iLW;
  private View.OnKeyListener iLX;
  private final View.OnTouchListener iLY;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(192661);
    this.iLV = 80;
    this.iLW = true;
    this.iLX = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(192659);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aQb()) && ((paramAnonymousView.iLQ.getParent() != null) || (paramAnonymousView.cMS))) {}
          for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
          {
            a.this.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(192659);
            return true;
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(192659);
        return false;
      }
    };
    this.iLY = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(192660);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/BasePickerView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0) {
          a.this.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/picker/BasePickerView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(192660);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(192661);
  }
  
  protected final void aPX()
  {
    AppMethodBeat.i(192662);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.iLQ = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.Lax.Zi, false));
    this.iLQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.Lax.iLL != -1) {
      this.iLQ.setBackgroundColor(this.Lax.iLL);
    }
    this.iLP = ((ViewGroup)this.iLQ.findViewById(2131298752));
    this.iLP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aQb()) {}
    for (localObject = this.iLR;; localObject = this.iLQ)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.iLX);
      AppMethodBeat.o(192662);
      return;
    }
  }
  
  protected final void aPY()
  {
    AppMethodBeat.i(192663);
    int i = com.tencent.mm.ui.widget.picker.f.a.E(this.iLV, true);
    this.iLU = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.ui.widget.picker.f.a.E(this.iLV, false);
    this.iLT = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(192663);
  }
  
  public final void aPZ()
  {
    AppMethodBeat.i(192665);
    this.Lax.Zi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192658);
        a.this.Lax.Zi.removeView(a.this.iLQ);
        a.this.cMS = false;
        a.this.iLS = false;
        AppMethodBeat.o(192658);
      }
    });
    AppMethodBeat.o(192665);
  }
  
  public final void aQa()
  {
    AppMethodBeat.i(192667);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.Lax.ov);
    }
    AppMethodBeat.o(192667);
  }
  
  public boolean aQb()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(192664);
    if (aQb())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(192664);
      return;
    }
    if (this.iLS)
    {
      AppMethodBeat.o(192664);
      return;
    }
    if (this.iLW)
    {
      this.iLT.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(192657);
          a.this.aPZ();
          AppMethodBeat.o(192657);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.iLP.startAnimation(this.iLT);
    }
    for (;;)
    {
      this.iLS = true;
      AppMethodBeat.o(192664);
      return;
      aPZ();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(192668);
    View localView = this.iLP.findViewById(paramInt);
    AppMethodBeat.o(192668);
    return localView;
  }
  
  protected final a yV(boolean paramBoolean)
  {
    AppMethodBeat.i(192666);
    View localView;
    if (this.iLQ != null)
    {
      localView = this.iLQ.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.iLY);
    }
    for (;;)
    {
      AppMethodBeat.o(192666);
      return this;
      label41:
      localView.setOnTouchListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */
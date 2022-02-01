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
  protected com.tencent.mm.ui.widget.picker.c.a QSH;
  private Context context;
  boolean ddZ;
  boolean jLA;
  private Animation jLB;
  private Animation jLC;
  protected int jLD;
  private boolean jLE;
  private View.OnKeyListener jLF;
  private final View.OnTouchListener jLG;
  protected ViewGroup jLx;
  ViewGroup jLy;
  private ViewGroup jLz;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(198377);
    this.jLD = 80;
    this.jLE = true;
    this.jLF = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(198375);
        b localb = new b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.blf()) && ((paramAnonymousView.jLy.getParent() != null) || (paramAnonymousView.ddZ))) {}
          for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
          {
            a.this.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(198375);
            return true;
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(198375);
        return false;
      }
    };
    this.jLG = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198376);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          a.this.dismiss();
        }
        AppMethodBeat.o(198376);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(198377);
  }
  
  protected final a Ds(boolean paramBoolean)
  {
    AppMethodBeat.i(198382);
    View localView;
    if (this.jLy != null)
    {
      localView = this.jLy.findViewById(2131305747);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.jLG);
    }
    for (;;)
    {
      AppMethodBeat.o(198382);
      return this;
      label41:
      localView.setOnTouchListener(null);
    }
  }
  
  protected final void blb()
  {
    AppMethodBeat.i(198378);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.jLy = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131495165, this.QSH.Zv, false));
    this.jLy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.QSH.jLt != -1) {
      this.jLy.setBackgroundColor(this.QSH.jLt);
    }
    this.jLx = ((ViewGroup)this.jLy.findViewById(2131299195));
    this.jLx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (blf()) {}
    for (localObject = this.jLz;; localObject = this.jLy)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.jLF);
      AppMethodBeat.o(198378);
      return;
    }
  }
  
  protected final void blc()
  {
    AppMethodBeat.i(198379);
    int i = com.tencent.mm.ui.widget.picker.f.a.I(this.jLD, true);
    this.jLC = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.ui.widget.picker.f.a.I(this.jLD, false);
    this.jLB = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(198379);
  }
  
  public final void bld()
  {
    AppMethodBeat.i(198381);
    this.QSH.Zv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198374);
        a.this.QSH.Zv.removeView(a.this.jLy);
        a.this.ddZ = false;
        a.this.jLA = false;
        AppMethodBeat.o(198374);
      }
    });
    AppMethodBeat.o(198381);
  }
  
  public final void ble()
  {
    AppMethodBeat.i(198383);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.QSH.ox);
    }
    AppMethodBeat.o(198383);
  }
  
  public boolean blf()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(198380);
    if (blf())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(198380);
      return;
    }
    if (this.jLA)
    {
      AppMethodBeat.o(198380);
      return;
    }
    if (this.jLE)
    {
      this.jLB.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(198373);
          a.this.bld();
          AppMethodBeat.o(198373);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.jLx.startAnimation(this.jLB);
    }
    for (;;)
    {
      this.jLA = true;
      AppMethodBeat.o(198380);
      return;
      bld();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(198384);
    View localView = this.jLx.findViewById(paramInt);
    AppMethodBeat.o(198384);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */
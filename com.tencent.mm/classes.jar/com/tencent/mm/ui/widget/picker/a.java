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
  protected com.tencent.mm.ui.widget.picker.c.a LwV;
  boolean cNB;
  private Context context;
  protected ViewGroup iOI;
  ViewGroup iOJ;
  private ViewGroup iOK;
  boolean iOL;
  private Animation iOM;
  private Animation iON;
  protected int iOO;
  private boolean iOP;
  private View.OnKeyListener iOQ;
  private final View.OnTouchListener iOR;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(200431);
    this.iOO = 80;
    this.iOP = true;
    this.iOQ = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(200429);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aQA()) && ((paramAnonymousView.iOJ.getParent() != null) || (paramAnonymousView.cNB))) {}
          for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
          {
            a.this.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(200429);
            return true;
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(200429);
        return false;
      }
    };
    this.iOR = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(200430);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/BasePickerView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 0) {
          a.this.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/picker/BasePickerView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(200430);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(200431);
  }
  
  public boolean aQA()
  {
    return false;
  }
  
  protected final void aQw()
  {
    AppMethodBeat.i(200432);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.iOJ = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.LwV.Zi, false));
    this.iOJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.LwV.iOE != -1) {
      this.iOJ.setBackgroundColor(this.LwV.iOE);
    }
    this.iOI = ((ViewGroup)this.iOJ.findViewById(2131298752));
    this.iOI.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aQA()) {}
    for (localObject = this.iOK;; localObject = this.iOJ)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.iOQ);
      AppMethodBeat.o(200432);
      return;
    }
  }
  
  protected final void aQx()
  {
    AppMethodBeat.i(200433);
    int i = com.tencent.mm.ui.widget.picker.f.a.E(this.iOO, true);
    this.iON = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.ui.widget.picker.f.a.E(this.iOO, false);
    this.iOM = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(200433);
  }
  
  public final void aQy()
  {
    AppMethodBeat.i(200435);
    this.LwV.Zi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200428);
        a.this.LwV.Zi.removeView(a.this.iOJ);
        a.this.cNB = false;
        a.this.iOL = false;
        AppMethodBeat.o(200428);
      }
    });
    AppMethodBeat.o(200435);
  }
  
  public final void aQz()
  {
    AppMethodBeat.i(200437);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.LwV.ov);
    }
    AppMethodBeat.o(200437);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(200434);
    if (aQA())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(200434);
      return;
    }
    if (this.iOL)
    {
      AppMethodBeat.o(200434);
      return;
    }
    if (this.iOP)
    {
      this.iOM.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(200427);
          a.this.aQy();
          AppMethodBeat.o(200427);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.iOI.startAnimation(this.iOM);
    }
    for (;;)
    {
      this.iOL = true;
      AppMethodBeat.o(200434);
      return;
      aQy();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(200438);
    View localView = this.iOI.findViewById(paramInt);
    AppMethodBeat.o(200438);
    return localView;
  }
  
  protected final a zj(boolean paramBoolean)
  {
    AppMethodBeat.i(200436);
    View localView;
    if (this.iOJ != null)
    {
      localView = this.iOJ.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.iOR);
    }
    for (;;)
    {
      AppMethodBeat.o(200436);
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
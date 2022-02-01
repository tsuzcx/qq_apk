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
  protected com.tencent.mm.ui.widget.picker.c.a HID;
  boolean cEL;
  private Context context;
  protected ViewGroup hSH;
  ViewGroup hSI;
  private ViewGroup hSJ;
  boolean hSK;
  private Animation hSL;
  private Animation hSM;
  protected int hSN;
  private boolean hSO;
  private View.OnKeyListener hSP;
  private final View.OnTouchListener hSQ;
  private Dialog mDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(195245);
    this.hSN = 80;
    this.hSO = true;
    this.hSP = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(195243);
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          paramAnonymousView = a.this;
          if ((!paramAnonymousView.aGd()) && ((paramAnonymousView.hSI.getParent() != null) || (paramAnonymousView.cEL))) {}
          for (paramAnonymousInt = 1; paramAnonymousInt != 0; paramAnonymousInt = 0)
          {
            a.this.dismiss();
            AppMethodBeat.o(195243);
            return true;
          }
        }
        AppMethodBeat.o(195243);
        return false;
      }
    };
    this.hSQ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(195244);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          a.this.dismiss();
        }
        AppMethodBeat.o(195244);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(195245);
  }
  
  protected final void aFZ()
  {
    AppMethodBeat.i(195246);
    Object localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.hSI = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131494555, this.HID.Wy, false));
    this.hSI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.HID.hSD != -1) {
      this.hSI.setBackgroundColor(this.HID.hSD);
    }
    this.hSH = ((ViewGroup)this.hSI.findViewById(2131298752));
    this.hSH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (aGd()) {}
    for (localObject = this.hSJ;; localObject = this.hSI)
    {
      ((ViewGroup)localObject).setFocusable(true);
      ((ViewGroup)localObject).setFocusableInTouchMode(true);
      ((ViewGroup)localObject).setOnKeyListener(this.hSP);
      AppMethodBeat.o(195246);
      return;
    }
  }
  
  protected final void aGa()
  {
    AppMethodBeat.i(195247);
    int i = com.tencent.mm.ui.widget.picker.f.a.E(this.hSN, true);
    this.hSM = AnimationUtils.loadAnimation(this.context, i);
    i = com.tencent.mm.ui.widget.picker.f.a.E(this.hSN, false);
    this.hSL = AnimationUtils.loadAnimation(this.context, i);
    AppMethodBeat.o(195247);
  }
  
  public final void aGb()
  {
    AppMethodBeat.i(195249);
    this.HID.Wy.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195242);
        a.this.HID.Wy.removeView(a.this.hSI);
        a.this.cEL = false;
        a.this.hSK = false;
        AppMethodBeat.o(195242);
      }
    });
    AppMethodBeat.o(195249);
  }
  
  public final void aGc()
  {
    AppMethodBeat.i(195251);
    if (this.mDialog != null) {
      this.mDialog.setCancelable(this.HID.lA);
    }
    AppMethodBeat.o(195251);
  }
  
  public boolean aGd()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(195248);
    if (aGd())
    {
      if (this.mDialog != null) {
        this.mDialog.dismiss();
      }
      AppMethodBeat.o(195248);
      return;
    }
    if (this.hSK)
    {
      AppMethodBeat.o(195248);
      return;
    }
    if (this.hSO)
    {
      this.hSL.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(195241);
          a.this.aGb();
          AppMethodBeat.o(195241);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.hSH.startAnimation(this.hSL);
    }
    for (;;)
    {
      this.hSK = true;
      AppMethodBeat.o(195248);
      return;
      aGb();
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(195252);
    View localView = this.hSH.findViewById(paramInt);
    AppMethodBeat.o(195252);
    return localView;
  }
  
  protected final a xa(boolean paramBoolean)
  {
    AppMethodBeat.i(195250);
    View localView;
    if (this.hSI != null)
    {
      localView = this.hSI.findViewById(2131303115);
      if (!paramBoolean) {
        break label41;
      }
      localView.setOnTouchListener(this.hSQ);
    }
    for (;;)
    {
      AppMethodBeat.o(195250);
      return this;
      label41:
      localView.setOnTouchListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */
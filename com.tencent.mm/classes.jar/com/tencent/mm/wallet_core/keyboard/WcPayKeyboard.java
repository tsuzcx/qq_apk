package com.tencent.mm.wallet_core.keyboard;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class WcPayKeyboard
  extends LinearLayout
{
  private TextView AVD;
  private TextView AVE;
  private TextView AVF;
  private TextView AVG;
  private TextView AVH;
  private TextView AVI;
  private TextView AVJ;
  private TextView AVK;
  private TextView AVL;
  private TextView AVM;
  private TextView AVN;
  private TextView AVO;
  private View AVP;
  private ViewGroup AVQ;
  private LinearLayout AVR;
  public WcPayKeyboardAnimationActionButton AVS;
  public WcPayKeyboard.b AVT;
  private WcPayKeyboard.a AVU;
  private TextView kRB;
  public EditText mInputEditText;
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49015);
    this.AVT = WcPayKeyboard.b.AWa;
    init();
    AppMethodBeat.o(49015);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49016);
    this.AVT = WcPayKeyboard.b.AWa;
    init();
    AppMethodBeat.o(49016);
  }
  
  private void init()
  {
    AppMethodBeat.i(49017);
    LayoutInflater.from(getContext()).inflate(2130971282, this, true);
    this.AVR = ((LinearLayout)findViewById(2131829475));
    this.AVM = ((TextView)findViewById(2131829489));
    this.AVD = ((TextView)findViewById(2131829478));
    this.AVE = ((TextView)findViewById(2131829479));
    this.AVF = ((TextView)findViewById(2131829480));
    this.AVG = ((TextView)findViewById(2131829482));
    this.AVH = ((TextView)findViewById(2131829483));
    this.AVI = ((TextView)findViewById(2131829484));
    this.AVJ = ((TextView)findViewById(2131829486));
    this.AVK = ((TextView)findViewById(2131829487));
    this.AVL = ((TextView)findViewById(2131829488));
    this.AVN = ((TextView)findViewById(2131829490));
    this.AVP = findViewById(2131829481);
    this.AVO = ((TextView)findViewById(2131829485));
    this.AVS = ((WcPayKeyboardAnimationActionButton)findViewById(2131829491));
    this.kRB = ((TextView)findViewById(2131829476));
    this.AVQ = ((ViewGroup)findViewById(2131829477));
    this.AVO.setTypeface(Typeface.defaultFromStyle(1));
    WcPayKeyboard.1 local1 = new WcPayKeyboard.1(this);
    this.AVR.setOnClickListener(local1);
    this.AVM.setOnClickListener(local1);
    this.AVD.setOnClickListener(local1);
    this.AVE.setOnClickListener(local1);
    this.AVF.setOnClickListener(local1);
    this.AVG.setOnClickListener(local1);
    this.AVH.setOnClickListener(local1);
    this.AVI.setOnClickListener(local1);
    this.AVJ.setOnClickListener(local1);
    this.AVK.setOnClickListener(local1);
    this.AVL.setOnClickListener(local1);
    this.AVP.setOnClickListener(local1);
    this.AVN.setOnClickListener(local1);
    this.AVO.setOnClickListener(local1);
    this.AVS.setOnClickListener(local1);
    this.AVS.setAnimationButtonListener(new WcPayKeyboard.2(this));
    AppMethodBeat.o(49017);
  }
  
  public final void an(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(155654);
    if (paramBoolean1)
    {
      this.AVS.setVisibility(0);
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.AVO.getLocationOnScreen(arrayOfInt1);
      this.AVQ.getLocationOnScreen(arrayOfInt2);
      if (this.kRB.isShown()) {}
      for (int i = this.kRB.getHeight() + a.fromDPToPix(getContext(), 24);; i = 0)
      {
        int j = this.AVP.getHeight();
        int k = a.fromDPToPix(getContext(), 16);
        this.AVS.O(this.AVO.getWidth(), this.AVO.getHeight(), i + j + k + 1, arrayOfInt1[0]);
        this.AVS.AWr = this.AVO.getText();
        this.AVO.setVisibility(4);
        al.d(new WcPayKeyboard.3(this));
        AppMethodBeat.o(155654);
        return;
      }
    }
    if (paramBoolean2)
    {
      this.AVS.dSc();
      al.d(new WcPayKeyboard.4(this));
      AppMethodBeat.o(155654);
      return;
    }
    this.AVS.dSh();
    this.AVS.setVisibility(8);
    AppMethodBeat.o(155654);
  }
  
  public final void cLy()
  {
    AppMethodBeat.i(142627);
    this.kRB.setVisibility(8);
    AppMethodBeat.o(142627);
  }
  
  public final void dRT()
  {
    AppMethodBeat.i(142626);
    ab.d("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.AVT, bo.dtY() });
    if ((isShown()) && (dRV())) {
      an(true, false);
    }
    this.AVT = WcPayKeyboard.b.AWb;
    AppMethodBeat.o(142626);
  }
  
  public final boolean dRU()
  {
    return this.AVT == WcPayKeyboard.b.AWb;
  }
  
  public final boolean dRV()
  {
    return this.AVT == WcPayKeyboard.b.AWa;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142625);
    if ((isShown()) && (dRV()))
    {
      dRT();
      AppMethodBeat.o(142625);
      return true;
    }
    AppMethodBeat.o(142625);
    return false;
  }
  
  public final void rP(boolean paramBoolean)
  {
    AppMethodBeat.i(142628);
    this.AVO.setEnabled(paramBoolean);
    this.AVS.setEnabled(paramBoolean);
    AppMethodBeat.o(142628);
  }
  
  public final void rQ(boolean paramBoolean)
  {
    AppMethodBeat.i(142630);
    int i = this.AVR.getHeight();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.AVR, "translationY", new float[] { 0.0F, i });
    localObjectAnimator.setDuration(330L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.addListener(new WcPayKeyboard.5(this, i, paramBoolean));
    localObjectAnimator.addUpdateListener(new WcPayKeyboard.6(this, i));
    localObjectAnimator.start();
    AppMethodBeat.o(142630);
  }
  
  public final void rR(final boolean paramBoolean)
  {
    AppMethodBeat.i(155655);
    setVisibility(0);
    this.AVR.setVisibility(4);
    this.AVR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(155653);
        float f = WcPayKeyboard.d(WcPayKeyboard.this).getTranslationY();
        int i = WcPayKeyboard.d(WcPayKeyboard.this).getHeight();
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(WcPayKeyboard.d(WcPayKeyboard.this), "translationY", new float[] { i + f, f });
        localObjectAnimator.setDuration(300L);
        localObjectAnimator.setInterpolator(new LinearInterpolator());
        localObjectAnimator.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(155651);
            if (!WcPayKeyboard.8.this.AVY)
            {
              WcPayKeyboard.f(WcPayKeyboard.this).setVisibility(0);
              WcPayKeyboard.b(WcPayKeyboard.this).setVisibility(4);
            }
            AppMethodBeat.o(155651);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(155650);
            WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(0);
            if (WcPayKeyboard.8.this.AVY)
            {
              WcPayKeyboard.f(WcPayKeyboard.this).setVisibility(0);
              AppMethodBeat.o(155650);
              return;
            }
            WcPayKeyboard.f(WcPayKeyboard.this).setVisibility(4);
            AppMethodBeat.o(155650);
          }
        });
        localObjectAnimator.addUpdateListener(new WcPayKeyboard.8.2(this, i));
        localObjectAnimator.start();
        AppMethodBeat.o(155653);
      }
    });
    AppMethodBeat.o(155655);
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(49018);
    this.AVO.setText(paramString);
    AppMethodBeat.o(49018);
  }
  
  public void setHeightListener(WcPayKeyboard.a parama)
  {
    this.AVU = parama;
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    if (paramEditText != null) {
      this.mInputEditText = paramEditText;
    }
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(49019);
    this.kRB.setText(paramString);
    if (this.kRB.getVisibility() != 0) {
      this.kRB.setVisibility(0);
    }
    AppMethodBeat.o(49019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */
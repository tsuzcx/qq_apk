package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;

public class ScannerFlashSwitcher
  extends LinearLayout
{
  ImageView qBb;
  TextView qBc;
  boolean qBd;
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(81322);
    this.qBd = false;
    init();
    AppMethodBeat.o(81322);
  }
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(81323);
    this.qBd = false;
    init();
    AppMethodBeat.o(81323);
  }
  
  private void init()
  {
    AppMethodBeat.i(81324);
    w.hM(getContext()).inflate(2130970613, this, true);
    this.qBb = ((ImageView)findViewById(2131827449));
    this.qBc = ((TextView)findViewById(2131827450));
    this.qBd = true;
    AppMethodBeat.o(81324);
  }
  
  public final void cji()
  {
    AppMethodBeat.i(81326);
    ab.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
    this.qBb.setImageResource(2131231942);
    AppMethodBeat.o(81326);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(81325);
    ab.i("MicroMsg.ScannerFlashSwitcher", "hide");
    setEnabled(false);
    this.qBb.animate().alpha(0.0F).setDuration(500L);
    this.qBc.animate().alpha(0.0F).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(81321);
        ScannerFlashSwitcher.this.setVisibility(8);
        AppMethodBeat.o(81321);
      }
    });
    AppMethodBeat.o(81325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher
 * JD-Core Version:    0.7.0.1
 */
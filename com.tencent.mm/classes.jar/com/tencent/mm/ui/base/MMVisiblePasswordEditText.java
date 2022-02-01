package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public class MMVisiblePasswordEditText
  extends EditText
{
  final Drawable JoT;
  final Drawable JoU;
  private boolean JoV;
  public String niV;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142318);
    this.niV = "";
    this.JoT = getResources().getDrawable(2131690744);
    this.JoU = getResources().getDrawable(2131690745);
    this.JoV = false;
    cmL();
    AppMethodBeat.o(142318);
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142319);
    this.niV = "";
    this.JoT = getResources().getDrawable(2131690744);
    this.JoU = getResources().getDrawable(2131690745);
    this.JoV = false;
    cmL();
    AppMethodBeat.o(142319);
  }
  
  private void cmL()
  {
    AppMethodBeat.i(142320);
    this.JoT.setBounds(0, 0, this.JoT.getIntrinsicWidth(), this.JoT.getIntrinsicHeight());
    this.JoU.setBounds(0, 0, this.JoU.getIntrinsicWidth(), this.JoU.getIntrinsicHeight());
    ad.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.JoT.getIntrinsicWidth()), Integer.valueOf(this.JoT.getIntrinsicHeight()) });
    fzm();
    setHeight(this.JoT.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142317);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/base/MMVisiblePasswordEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        paramAnonymousView = MMVisiblePasswordEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMVisiblePasswordEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(142317);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMVisiblePasswordEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(142317);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMVisiblePasswordEditText.this.JoT.getIntrinsicWidth())
        {
          paramAnonymousView = MMVisiblePasswordEditText.this;
          if (MMVisiblePasswordEditText.a(MMVisiblePasswordEditText.this)) {
            break label184;
          }
        }
        label184:
        for (boolean bool = true;; bool = false)
        {
          MMVisiblePasswordEditText.a(paramAnonymousView, bool);
          MMVisiblePasswordEditText.b(MMVisiblePasswordEditText.this);
          a.a(false, this, "com/tencent/mm/ui/base/MMVisiblePasswordEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(142317);
          return false;
        }
      }
    });
    AppMethodBeat.o(142320);
  }
  
  private void fzm()
  {
    AppMethodBeat.i(142321);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.JoV)
    {
      setInputType(1);
      fzn();
    }
    for (;;)
    {
      setSelection(i, j);
      AppMethodBeat.o(142321);
      return;
      setInputType(129);
      fzo();
    }
  }
  
  private void fzn()
  {
    AppMethodBeat.i(142322);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.JoU, getCompoundDrawables()[3]);
    AppMethodBeat.o(142322);
  }
  
  private void fzo()
  {
    AppMethodBeat.i(142323);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.JoT, getCompoundDrawables()[3]);
    AppMethodBeat.o(142323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.sdk.platformtools.ae;

public class MMVisiblePasswordEditText
  extends EditText
{
  final Drawable JJI;
  final Drawable JJJ;
  private boolean JJK;
  public String nod;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142318);
    this.nod = "";
    this.JJI = getResources().getDrawable(2131690744);
    this.JJJ = getResources().getDrawable(2131690745);
    this.JJK = false;
    cob();
    AppMethodBeat.o(142318);
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142319);
    this.nod = "";
    this.JJI = getResources().getDrawable(2131690744);
    this.JJJ = getResources().getDrawable(2131690745);
    this.JJK = false;
    cob();
    AppMethodBeat.o(142319);
  }
  
  private void cob()
  {
    AppMethodBeat.i(142320);
    this.JJI.setBounds(0, 0, this.JJI.getIntrinsicWidth(), this.JJI.getIntrinsicHeight());
    this.JJJ.setBounds(0, 0, this.JJJ.getIntrinsicWidth(), this.JJJ.getIntrinsicHeight());
    ae.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.JJI.getIntrinsicWidth()), Integer.valueOf(this.JJI.getIntrinsicHeight()) });
    fDo();
    setHeight(this.JJI.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142317);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/base/MMVisiblePasswordEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMVisiblePasswordEditText.this.JJI.getIntrinsicWidth())
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
  
  private void fDo()
  {
    AppMethodBeat.i(142321);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.JJK)
    {
      setInputType(1);
      fDp();
    }
    for (;;)
    {
      setSelection(i, j);
      AppMethodBeat.o(142321);
      return;
      setInputType(129);
      fDq();
    }
  }
  
  private void fDp()
  {
    AppMethodBeat.i(142322);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.JJJ, getCompoundDrawables()[3]);
    AppMethodBeat.o(142322);
  }
  
  private void fDq()
  {
    AppMethodBeat.i(142323);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.JJI, getCompoundDrawables()[3]);
    AppMethodBeat.o(142323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.sdk.platformtools.ac;

public class MMVisiblePasswordEditText
  extends EditText
{
  final Drawable HBc;
  final Drawable HBd;
  private boolean HBe;
  public String mIy;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142318);
    this.mIy = "";
    this.HBc = getResources().getDrawable(2131690744);
    this.HBd = getResources().getDrawable(2131690745);
    this.HBe = false;
    cih();
    AppMethodBeat.o(142318);
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142319);
    this.mIy = "";
    this.HBc = getResources().getDrawable(2131690744);
    this.HBd = getResources().getDrawable(2131690745);
    this.HBe = false;
    cih();
    AppMethodBeat.o(142319);
  }
  
  private void cih()
  {
    AppMethodBeat.i(142320);
    this.HBc.setBounds(0, 0, this.HBc.getIntrinsicWidth(), this.HBc.getIntrinsicHeight());
    this.HBd.setBounds(0, 0, this.HBd.getIntrinsicWidth(), this.HBd.getIntrinsicHeight());
    ac.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.HBc.getIntrinsicWidth()), Integer.valueOf(this.HBc.getIntrinsicHeight()) });
    fiX();
    setHeight(this.HBc.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        boolean bool = true;
        AppMethodBeat.i(142317);
        paramAnonymousView = MMVisiblePasswordEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          AppMethodBeat.o(142317);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          AppMethodBeat.o(142317);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMVisiblePasswordEditText.this.HBc.getIntrinsicWidth())
        {
          paramAnonymousView = MMVisiblePasswordEditText.this;
          if (MMVisiblePasswordEditText.a(MMVisiblePasswordEditText.this)) {
            break label107;
          }
        }
        for (;;)
        {
          MMVisiblePasswordEditText.a(paramAnonymousView, bool);
          MMVisiblePasswordEditText.b(MMVisiblePasswordEditText.this);
          AppMethodBeat.o(142317);
          return false;
          label107:
          bool = false;
        }
      }
    });
    AppMethodBeat.o(142320);
  }
  
  private void fiX()
  {
    AppMethodBeat.i(142321);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.HBe)
    {
      setInputType(1);
      fiY();
    }
    for (;;)
    {
      setSelection(i, j);
      AppMethodBeat.o(142321);
      return;
      setInputType(129);
      fiZ();
    }
  }
  
  private void fiY()
  {
    AppMethodBeat.i(142322);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.HBd, getCompoundDrawables()[3]);
    AppMethodBeat.o(142322);
  }
  
  private void fiZ()
  {
    AppMethodBeat.i(142323);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.HBc, getCompoundDrawables()[3]);
    AppMethodBeat.o(142323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */
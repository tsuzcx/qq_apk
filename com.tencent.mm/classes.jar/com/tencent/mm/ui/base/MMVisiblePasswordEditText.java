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
import com.tencent.mm.sdk.platformtools.ad;

public class MMVisiblePasswordEditText
  extends EditText
{
  final Drawable Gbn;
  final Drawable Gbo;
  private boolean Gbp;
  public String mgy;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142318);
    this.mgy = "";
    this.Gbn = getResources().getDrawable(2131690744);
    this.Gbo = getResources().getDrawable(2131690745);
    this.Gbp = false;
    caY();
    AppMethodBeat.o(142318);
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142319);
    this.mgy = "";
    this.Gbn = getResources().getDrawable(2131690744);
    this.Gbo = getResources().getDrawable(2131690745);
    this.Gbp = false;
    caY();
    AppMethodBeat.o(142319);
  }
  
  private void caY()
  {
    AppMethodBeat.i(142320);
    this.Gbn.setBounds(0, 0, this.Gbn.getIntrinsicWidth(), this.Gbn.getIntrinsicHeight());
    this.Gbo.setBounds(0, 0, this.Gbo.getIntrinsicWidth(), this.Gbo.getIntrinsicHeight());
    ad.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.Gbn.getIntrinsicWidth()), Integer.valueOf(this.Gbn.getIntrinsicHeight()) });
    eTm();
    setHeight(this.Gbn.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
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
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMVisiblePasswordEditText.this.Gbn.getIntrinsicWidth())
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
  
  private void eTm()
  {
    AppMethodBeat.i(142321);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.Gbp)
    {
      setInputType(1);
      eTn();
    }
    for (;;)
    {
      setSelection(i, j);
      AppMethodBeat.o(142321);
      return;
      setInputType(129);
      eTo();
    }
  }
  
  private void eTn()
  {
    AppMethodBeat.i(142322);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Gbo, getCompoundDrawables()[3]);
    AppMethodBeat.o(142322);
  }
  
  private void eTo()
  {
    AppMethodBeat.i(142323);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Gbn, getCompoundDrawables()[3]);
    AppMethodBeat.o(142323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */
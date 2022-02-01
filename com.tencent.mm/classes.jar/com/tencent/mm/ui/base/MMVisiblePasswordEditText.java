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
import com.tencent.mm.sdk.platformtools.Log;

public class MMVisiblePasswordEditText
  extends EditText
{
  final Drawable OUB;
  final Drawable OUC;
  private boolean OUD;
  public String oxJ;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142318);
    this.oxJ = "";
    this.OUB = getResources().getDrawable(2131691027);
    this.OUC = getResources().getDrawable(2131691028);
    this.OUD = false;
    cMn();
    AppMethodBeat.o(142318);
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142319);
    this.oxJ = "";
    this.OUB = getResources().getDrawable(2131691027);
    this.OUC = getResources().getDrawable(2131691028);
    this.OUD = false;
    cMn();
    AppMethodBeat.o(142319);
  }
  
  private void cMn()
  {
    AppMethodBeat.i(142320);
    this.OUB.setBounds(0, 0, this.OUB.getIntrinsicWidth(), this.OUB.getIntrinsicHeight());
    this.OUC.setBounds(0, 0, this.OUC.getIntrinsicWidth(), this.OUC.getIntrinsicHeight());
    Log.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.OUB.getIntrinsicWidth()), Integer.valueOf(this.OUB.getIntrinsicHeight()) });
    gLn();
    setHeight(this.OUB.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165537) * 5);
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
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMVisiblePasswordEditText.this.OUB.getIntrinsicWidth())
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
  
  private void gLn()
  {
    AppMethodBeat.i(142321);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.OUD)
    {
      setInputType(1);
      gLo();
    }
    for (;;)
    {
      setSelection(i, j);
      AppMethodBeat.o(142321);
      return;
      setInputType(129);
      gLp();
    }
  }
  
  private void gLo()
  {
    AppMethodBeat.i(142322);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.OUC, getCompoundDrawables()[3]);
    AppMethodBeat.o(142322);
  }
  
  private void gLp()
  {
    AppMethodBeat.i(142323);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.OUB, getCompoundDrawables()[3]);
    AppMethodBeat.o(142323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */
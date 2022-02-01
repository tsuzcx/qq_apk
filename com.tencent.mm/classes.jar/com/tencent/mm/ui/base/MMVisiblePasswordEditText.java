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
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.sdk.platformtools.Log;

public class MMVisiblePasswordEditText
  extends EditText
{
  final Drawable WnO;
  final Drawable WnP;
  private boolean WnQ;
  public String rAi;
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142318);
    this.rAi = "";
    this.WnO = getResources().getDrawable(a.j.login_showpassword_icon);
    this.WnP = getResources().getDrawable(a.j.login_showpassword_icon_activa);
    this.WnQ = false;
    dbb();
    AppMethodBeat.o(142318);
  }
  
  public MMVisiblePasswordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142319);
    this.rAi = "";
    this.WnO = getResources().getDrawable(a.j.login_showpassword_icon);
    this.WnP = getResources().getDrawable(a.j.login_showpassword_icon_activa);
    this.WnQ = false;
    dbb();
    AppMethodBeat.o(142319);
  }
  
  private void dbb()
  {
    AppMethodBeat.i(142320);
    this.WnO.setBounds(0, 0, this.WnO.getIntrinsicWidth(), this.WnO.getIntrinsicHeight());
    this.WnP.setBounds(0, 0, this.WnP.getIntrinsicWidth(), this.WnP.getIntrinsicHeight());
    Log.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[] { Integer.valueOf(this.WnO.getIntrinsicWidth()), Integer.valueOf(this.WnO.getIntrinsicHeight()) });
    hKm();
    setHeight(this.WnO.getIntrinsicHeight() + getResources().getDimensionPixelSize(a.e.OneDPPadding) * 5);
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
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMVisiblePasswordEditText.this.WnO.getIntrinsicWidth())
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
  
  private void hKm()
  {
    AppMethodBeat.i(142321);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (this.WnQ)
    {
      setInputType(1);
      hKn();
    }
    for (;;)
    {
      setSelection(i, j);
      AppMethodBeat.o(142321);
      return;
      setInputType(129);
      hKo();
    }
  }
  
  private void hKn()
  {
    AppMethodBeat.i(142322);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.WnP, getCompoundDrawables()[3]);
    AppMethodBeat.o(142322);
  }
  
  private void hKo()
  {
    AppMethodBeat.i(142323);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.WnO, getCompoundDrawables()[3]);
    AppMethodBeat.o(142323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText
 * JD-Core Version:    0.7.0.1
 */
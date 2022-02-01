package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText
  extends MMEditText
{
  private boolean EjM;
  private boolean KRe;
  private int KRf;
  private int KRg;
  private int KRh;
  private Context context;
  private int qWs;
  private float y;
  
  public SnsEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98694);
    this.qWs = 0;
    this.KRe = false;
    this.KRf = 0;
    this.KRg = 0;
    this.EjM = false;
    this.KRh = 10;
    this.context = paramContext;
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98693);
        if (paramAnonymousCharSequence != null) {
          SnsEditText.b(SnsEditText.this, paramAnonymousCharSequence.length());
        }
        AppMethodBeat.o(98693);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98692);
        try
        {
          if (SnsEditText.a(SnsEditText.this))
          {
            if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.JPj))
            {
              SnsEditText.a(SnsEditText.this, 0);
              AppMethodBeat.o(98692);
              return;
            }
            if (paramAnonymousCharSequence.length() - SnsEditText.b(SnsEditText.this) > a.JPj) {
              SnsEditText.a(SnsEditText.this, paramAnonymousCharSequence.length() - SnsEditText.b(SnsEditText.this));
            }
          }
          AppMethodBeat.o(98692);
          return;
        }
        catch (Exception paramAnonymousCharSequence)
        {
          Log.printErrStackTrace("MicroMsg.SnsEditText", paramAnonymousCharSequence, "", new Object[0]);
          AppMethodBeat.o(98692);
        }
      }
    });
    AppMethodBeat.o(98694);
  }
  
  public int getPasterLen()
  {
    return this.qWs;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(98695);
    if (paramInt == 16908322) {
      this.KRe = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(98695);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(98696);
    if (paramMotionEvent.getAction() == 2) {
      if (Math.abs(this.y - paramMotionEvent.getY()) > this.KRh) {
        this.EjM = true;
      }
    }
    for (;;)
    {
      this.y = paramMotionEvent.getY();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(98696);
      return bool;
      if (paramMotionEvent.getAction() == 1)
      {
        if (this.EjM)
        {
          this.EjM = false;
          AppMethodBeat.o(98696);
          return true;
        }
      }
      else {
        this.EjM = false;
      }
    }
  }
  
  public void setPasterLen(int paramInt)
  {
    this.qWs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsEditText
 * JD-Core Version:    0.7.0.1
 */
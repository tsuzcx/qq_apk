package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText
  extends MMEditText
{
  private ClipboardManager AcT;
  private boolean AcU;
  private int AcV;
  private int AcW;
  private int AcX;
  private Context context;
  private int mCQ;
  private boolean uZQ;
  private float y;
  
  public SnsEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98694);
    this.AcT = null;
    this.mCQ = 0;
    this.AcU = false;
    this.AcV = 0;
    this.AcW = 0;
    this.uZQ = false;
    this.AcX = 10;
    this.context = paramContext;
    this.AcT = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
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
            if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.zbZ))
            {
              SnsEditText.a(SnsEditText.this, 0);
              AppMethodBeat.o(98692);
              return;
            }
            if (paramAnonymousCharSequence.length() - SnsEditText.b(SnsEditText.this) > a.zbZ) {
              SnsEditText.a(SnsEditText.this, paramAnonymousCharSequence.length() - SnsEditText.b(SnsEditText.this));
            }
          }
          AppMethodBeat.o(98692);
          return;
        }
        catch (Exception paramAnonymousCharSequence)
        {
          ad.printErrStackTrace("MicroMsg.SnsEditText", paramAnonymousCharSequence, "", new Object[0]);
          AppMethodBeat.o(98692);
        }
      }
    });
    AppMethodBeat.o(98694);
  }
  
  public int getPasterLen()
  {
    return this.mCQ;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(98695);
    if (paramInt == 16908322) {
      this.AcU = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(98695);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(98696);
    if (paramMotionEvent.getAction() == 2) {
      if (Math.abs(this.y - paramMotionEvent.getY()) > this.AcX) {
        this.uZQ = true;
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
        if (this.uZQ)
        {
          this.uZQ = false;
          AppMethodBeat.o(98696);
          return true;
        }
      }
      else {
        this.uZQ = false;
      }
    }
  }
  
  public void setPasterLen(int paramInt)
  {
    this.mCQ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsEditText
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText
  extends MMEditText
{
  private Context context;
  private int mcI;
  private boolean tXh;
  private float y;
  private int yLA;
  private int yLB;
  private int yLC;
  private ClipboardManager yLy;
  private boolean yLz;
  
  public SnsEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98694);
    this.yLy = null;
    this.mcI = 0;
    this.yLz = false;
    this.yLA = 0;
    this.yLB = 0;
    this.tXh = false;
    this.yLC = 10;
    this.context = paramContext;
    this.yLy = ((ClipboardManager)ai.getContext().getSystemService("clipboard"));
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
            if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.xMh))
            {
              SnsEditText.a(SnsEditText.this, 0);
              AppMethodBeat.o(98692);
              return;
            }
            if (paramAnonymousCharSequence.length() - SnsEditText.b(SnsEditText.this) > a.xMh) {
              SnsEditText.a(SnsEditText.this, paramAnonymousCharSequence.length() - SnsEditText.b(SnsEditText.this));
            }
          }
          AppMethodBeat.o(98692);
          return;
        }
        catch (Exception paramAnonymousCharSequence)
        {
          ac.printErrStackTrace("MicroMsg.SnsEditText", paramAnonymousCharSequence, "", new Object[0]);
          AppMethodBeat.o(98692);
        }
      }
    });
    AppMethodBeat.o(98694);
  }
  
  public int getPasterLen()
  {
    return this.mcI;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(98695);
    if (paramInt == 16908322) {
      this.yLz = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(98695);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(98696);
    if (paramMotionEvent.getAction() == 2) {
      if (Math.abs(this.y - paramMotionEvent.getY()) > this.yLC) {
        this.tXh = true;
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
        if (this.tXh)
        {
          this.tXh = false;
          AppMethodBeat.o(98696);
          return true;
        }
      }
      else {
        this.tXh = false;
      }
    }
  }
  
  public void setPasterLen(int paramInt)
  {
    this.mcI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsEditText
 * JD-Core Version:    0.7.0.1
 */
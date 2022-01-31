package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText
  extends MMEditText
{
  private Context context;
  private boolean lDh = false;
  private ClipboardManager oYb = null;
  private int oYc = 0;
  private int oYd = 0;
  private int oYe = 0;
  private int oYf = 10;
  private float y;
  
  public SnsEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.oYb = ((ClipboardManager)this.context.getSystemService("clipboard"));
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence != null) {
          SnsEditText.c(SnsEditText.this, paramAnonymousCharSequence.length());
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        SnsEditText.a(SnsEditText.this, paramAnonymousCharSequence.length());
        if (paramAnonymousInt2 > 0) {
          return;
        }
        for (;;)
        {
          try
          {
            if ((SnsEditText.a(SnsEditText.this) <= SnsEditText.b(SnsEditText.this)) || (paramAnonymousInt3 <= 30)) {
              break;
            }
            paramAnonymousCharSequence = paramAnonymousCharSequence.toString().substring(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3);
            if ((paramAnonymousCharSequence.indexOf("\n") >= 0) && (paramAnonymousInt3 > 30))
            {
              SnsEditText.b(SnsEditText.this, SnsEditText.c(SnsEditText.this) + paramAnonymousCharSequence.length());
              y.d("MicroMsg.SnsEditText", "parsterLen: %d %d", new Object[] { Integer.valueOf(paramAnonymousCharSequence.length()), Integer.valueOf(SnsEditText.c(SnsEditText.this)) });
              return;
            }
          }
          catch (Exception paramAnonymousCharSequence)
          {
            y.printErrStackTrace("MicroMsg.SnsEditText", paramAnonymousCharSequence, "", new Object[0]);
            return;
          }
          if (paramAnonymousInt3 <= 100) {
            break;
          }
        }
      }
    });
  }
  
  public int getPasterLen()
  {
    return this.oYc;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    return super.onTextContextMenuItem(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 2) {
      if (Math.abs(this.y - paramMotionEvent.getY()) > this.oYf) {
        this.lDh = true;
      }
    }
    for (;;)
    {
      this.y = paramMotionEvent.getY();
      return super.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 1)
      {
        if (this.lDh)
        {
          this.lDh = false;
          return true;
        }
      }
      else {
        this.lDh = false;
      }
    }
  }
  
  public void setPasterLen(int paramInt)
  {
    this.oYc = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsEditText
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText
  extends MMEditText
{
  private Context context;
  private int iNn;
  private boolean oat;
  private ClipboardManager rQu;
  private boolean rQv;
  private int rQw;
  private int rQx;
  private int rQy;
  private float y;
  
  public SnsEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38932);
    this.rQu = null;
    this.iNn = 0;
    this.rQv = false;
    this.rQw = 0;
    this.rQx = 0;
    this.oat = false;
    this.rQy = 10;
    this.context = paramContext;
    this.rQu = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    addTextChangedListener(new SnsEditText.1(this));
    AppMethodBeat.o(38932);
  }
  
  public int getPasterLen()
  {
    return this.iNn;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(38933);
    if (paramInt == 16908322) {
      this.rQv = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(38933);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38934);
    if (paramMotionEvent.getAction() == 2) {
      if (Math.abs(this.y - paramMotionEvent.getY()) > this.rQy) {
        this.oat = true;
      }
    }
    for (;;)
    {
      this.y = paramMotionEvent.getY();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38934);
      return bool;
      if (paramMotionEvent.getAction() == 1)
      {
        if (this.oat)
        {
          this.oat = false;
          AppMethodBeat.o(38934);
          return true;
        }
      }
      else {
        this.oat = false;
      }
    }
  }
  
  public void setPasterLen(int paramInt)
  {
    this.iNn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsEditText
 * JD-Core Version:    0.7.0.1
 */
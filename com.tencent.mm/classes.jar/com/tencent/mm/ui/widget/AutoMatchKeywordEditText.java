package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class AutoMatchKeywordEditText
  extends MMEditText
{
  private a QBG;
  private int QBH;
  private int QBI;
  
  public AutoMatchKeywordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143305);
    init();
    AppMethodBeat.o(143305);
  }
  
  public AutoMatchKeywordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143304);
    init();
    AppMethodBeat.o(143304);
  }
  
  private void init()
  {
    AppMethodBeat.i(143306);
    this.QBH = getSelectionStart();
    this.QBI = getSelectionEnd();
    AppMethodBeat.o(143306);
  }
  
  public void extendSelection(int paramInt)
  {
    AppMethodBeat.i(143310);
    Log.d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
    super.extendSelection(paramInt);
    this.QBH = getSelectionStart();
    this.QBI = getSelectionEnd();
    AppMethodBeat.o(143310);
  }
  
  public a getOnSelectionChangeListener()
  {
    return this.QBG;
  }
  
  public boolean moveCursorToVisibleOffset()
  {
    AppMethodBeat.i(143311);
    Log.d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
    boolean bool = super.moveCursorToVisibleOffset();
    AppMethodBeat.o(143311);
    return bool;
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    AppMethodBeat.i(143313);
    Log.d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
    boolean bool = super.onDragEvent(paramDragEvent);
    AppMethodBeat.o(143313);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143307);
    super.onDraw(paramCanvas);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if ((this.QBH != i) || (this.QBI != j))
    {
      this.QBH = i;
      this.QBI = j;
      if (this.QBG != null) {
        this.QBG.b(this, getSelectionStart(), getSelectionEnd());
      }
    }
    AppMethodBeat.o(143307);
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(143312);
    Log.d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
    boolean bool = super.performAccessibilityAction(paramInt, paramBundle);
    AppMethodBeat.o(143312);
    return bool;
  }
  
  public void setOnSelectionChangeListener(a parama)
  {
    this.QBG = parama;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(143308);
    Log.d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
    int i = getSelectionStart();
    int j = getSelectionEnd();
    super.setSelection(paramInt);
    this.QBH = getSelectionStart();
    this.QBI = getSelectionEnd();
    if (((i != getSelectionStart()) || (j != getSelectionEnd())) && (this.QBG != null)) {
      this.QBG.b(this, getSelectionStart(), getSelectionEnd());
    }
    AppMethodBeat.o(143308);
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143309);
    Log.d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
    int i = getSelectionStart();
    int j = getSelectionEnd();
    super.setSelection(paramInt1, paramInt2);
    this.QBH = getSelectionStart();
    this.QBI = getSelectionEnd();
    if (((i != getSelectionStart()) || (j != getSelectionEnd())) && (this.QBG != null)) {
      this.QBG.b(this, getSelectionStart(), getSelectionEnd());
    }
    AppMethodBeat.o(143309);
  }
  
  public static abstract interface a
  {
    public abstract void b(EditText paramEditText, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.AutoMatchKeywordEditText
 * JD-Core Version:    0.7.0.1
 */
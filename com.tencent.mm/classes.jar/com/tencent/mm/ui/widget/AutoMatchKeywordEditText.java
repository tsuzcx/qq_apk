package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.y;

public class AutoMatchKeywordEditText
  extends MMEditText
{
  private a wiY;
  private int wiZ;
  private int wja;
  
  public AutoMatchKeywordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AutoMatchKeywordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.wiZ = getSelectionStart();
    this.wja = getSelectionEnd();
  }
  
  public void extendSelection(int paramInt)
  {
    y.d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
    super.extendSelection(paramInt);
    this.wiZ = getSelectionStart();
    this.wja = getSelectionEnd();
  }
  
  public a getOnSelectionChangeListener()
  {
    return this.wiY;
  }
  
  public boolean moveCursorToVisibleOffset()
  {
    y.d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
    return super.moveCursorToVisibleOffset();
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    y.d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
    return super.onDragEvent(paramDragEvent);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if ((this.wiZ != i) || (this.wja != j))
    {
      this.wiZ = i;
      this.wja = j;
      if (this.wiY != null) {
        this.wiY.b(this, getSelectionStart(), getSelectionEnd());
      }
    }
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    y.d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
    return super.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void setOnSelectionChangeListener(a parama)
  {
    this.wiY = parama;
  }
  
  public void setSelection(int paramInt)
  {
    y.d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
    int i = getSelectionStart();
    int j = getSelectionEnd();
    super.setSelection(paramInt);
    this.wiZ = getSelectionStart();
    this.wja = getSelectionEnd();
    if (((i != getSelectionStart()) || (j != getSelectionEnd())) && (this.wiY != null)) {
      this.wiY.b(this, getSelectionStart(), getSelectionEnd());
    }
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
    int i = getSelectionStart();
    int j = getSelectionEnd();
    super.setSelection(paramInt1, paramInt2);
    this.wiZ = getSelectionStart();
    this.wja = getSelectionEnd();
    if (((i != getSelectionStart()) || (j != getSelectionEnd())) && (this.wiY != null)) {
      this.wiY.b(this, getSelectionStart(), getSelectionEnd());
    }
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
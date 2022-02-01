package com.tencent.mm.ui.widget.cedit.edit;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.b.a;
import com.tencent.mm.ui.widget.cedit.b.d;

public class CustomEditText
  extends CustomTextView
{
  public CustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 2131821095);
  }
  
  public CustomEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private CustomEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(205551);
    String str = CustomEditText.class.getName();
    AppMethodBeat.o(205551);
    return str;
  }
  
  protected boolean getDefaultEditable()
  {
    return true;
  }
  
  protected d getDefaultMovementMethod()
  {
    AppMethodBeat.i(205546);
    d locald = a.haX();
    AppMethodBeat.o(205546);
    return locald;
  }
  
  public boolean getFreezesText()
  {
    return true;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(205547);
    Object localObject = super.getText();
    if (localObject == null)
    {
      AppMethodBeat.o(205547);
      return null;
    }
    if ((localObject instanceof Editable))
    {
      localObject = (Editable)super.getText();
      AppMethodBeat.o(205547);
      return localObject;
    }
    super.setText((CharSequence)localObject, TextView.BufferType.EDITABLE);
    localObject = (Editable)super.getText();
    AppMethodBeat.o(205547);
    return localObject;
  }
  
  protected final boolean jw()
  {
    return false;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(205550);
    if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE)
    {
      paramTruncateAt = new IllegalArgumentException("EditText cannot use the ellipsize mode TextUtils.TruncateAt.MARQUEE");
      AppMethodBeat.o(205550);
      throw paramTruncateAt;
    }
    super.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(205550);
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(205549);
    Selection.setSelection(getText(), paramInt);
    AppMethodBeat.o(205549);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(205548);
    super.setText(paramCharSequence, TextView.BufferType.EDITABLE);
    AppMethodBeat.o(205548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.CustomEditText
 * JD-Core Version:    0.7.0.1
 */
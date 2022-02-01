package com.tencent.mm.ui.widget.cedit.edit;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.ui.widget.cedit.b.a;
import com.tencent.mm.ui.widget.cedit.b.d;

public class CustomEditText
  extends CustomTextView
{
  public CustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, a.l.MMNewEditTextStyle);
  }
  
  public CustomEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private CustomEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected final boolean dC()
  {
    return false;
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(187654);
    String str = CustomEditText.class.getName();
    AppMethodBeat.o(187654);
    return str;
  }
  
  protected boolean getDefaultEditable()
  {
    return true;
  }
  
  protected d getDefaultMovementMethod()
  {
    AppMethodBeat.i(187648);
    d locald = a.ibX();
    AppMethodBeat.o(187648);
    return locald;
  }
  
  public boolean getFreezesText()
  {
    return true;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(187649);
    Object localObject = super.getText();
    if (localObject == null)
    {
      AppMethodBeat.o(187649);
      return null;
    }
    if ((localObject instanceof Editable))
    {
      localObject = (Editable)super.getText();
      AppMethodBeat.o(187649);
      return localObject;
    }
    super.setText((CharSequence)localObject, TextView.BufferType.EDITABLE);
    localObject = (Editable)super.getText();
    AppMethodBeat.o(187649);
    return localObject;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(187653);
    if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE)
    {
      paramTruncateAt = new IllegalArgumentException("EditText cannot use the ellipsize mode TextUtils.TruncateAt.MARQUEE");
      AppMethodBeat.o(187653);
      throw paramTruncateAt;
    }
    super.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(187653);
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(187652);
    Selection.setSelection(getText(), paramInt);
    AppMethodBeat.o(187652);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(187650);
    super.setText(paramCharSequence, TextView.BufferType.EDITABLE);
    AppMethodBeat.o(187650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.CustomEditText
 * JD-Core Version:    0.7.0.1
 */
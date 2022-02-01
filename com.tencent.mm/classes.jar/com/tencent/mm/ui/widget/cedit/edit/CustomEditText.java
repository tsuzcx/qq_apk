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
  
  protected final boolean eB()
  {
    return false;
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(252409);
    String str = CustomEditText.class.getName();
    AppMethodBeat.o(252409);
    return str;
  }
  
  protected boolean getDefaultEditable()
  {
    return true;
  }
  
  protected d getDefaultMovementMethod()
  {
    AppMethodBeat.i(252361);
    d locald = a.jHj();
    AppMethodBeat.o(252361);
    return locald;
  }
  
  public boolean getFreezesText()
  {
    return true;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(252375);
    Object localObject = super.getText();
    if (localObject == null)
    {
      AppMethodBeat.o(252375);
      return null;
    }
    if ((localObject instanceof Editable))
    {
      localObject = (Editable)super.getText();
      AppMethodBeat.o(252375);
      return localObject;
    }
    super.setText((CharSequence)localObject, TextView.BufferType.EDITABLE);
    localObject = (Editable)super.getText();
    AppMethodBeat.o(252375);
    return localObject;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(252402);
    if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE)
    {
      paramTruncateAt = new IllegalArgumentException("EditText cannot use the ellipsize mode TextUtils.TruncateAt.MARQUEE");
      AppMethodBeat.o(252402);
      throw paramTruncateAt;
    }
    super.setEllipsize(paramTruncateAt);
    AppMethodBeat.o(252402);
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(252394);
    Selection.setSelection(getText(), paramInt);
    AppMethodBeat.o(252394);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(252383);
    super.setText(paramCharSequence, TextView.BufferType.EDITABLE);
    AppMethodBeat.o(252383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.CustomEditText
 * JD-Core Version:    0.7.0.1
 */
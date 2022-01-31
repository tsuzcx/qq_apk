package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMFormSelectorView
  extends LinearLayout
{
  private TextView gpL;
  private String hint;
  private int layout;
  private Context mContext;
  private EditText pLt;
  private String title;
  
  public MMFormSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106584);
    this.mContext = null;
    this.layout = -1;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(1, 0);
    if (paramInt != 0) {
      this.title = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(2, 0);
    if (paramInt != 0) {
      this.hint = paramContext.getString(paramInt);
    }
    this.layout = paramAttributeSet.getResourceId(0, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(106584);
  }
  
  public String getText()
  {
    AppMethodBeat.i(106591);
    if (this.pLt != null)
    {
      String str = this.pLt.getText().toString();
      AppMethodBeat.o(106591);
      return str;
    }
    ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(106591);
    return null;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(106585);
    this.gpL = ((TextView)findViewById(2131820680));
    this.pLt = ((EditText)findViewById(2131820995));
    if ((this.gpL == null) || (this.pLt == null))
    {
      ab.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[] { this.gpL, this.pLt });
      AppMethodBeat.o(106585);
      return;
    }
    if (this.title != null) {
      this.gpL.setText(this.title);
    }
    if (this.hint != null) {
      this.pLt.setHint(this.hint);
    }
    AppMethodBeat.o(106585);
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(106589);
    if (this.pLt != null)
    {
      this.pLt.setHint(paramInt);
      AppMethodBeat.o(106589);
      return;
    }
    ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(106589);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(106587);
    if (this.pLt != null)
    {
      this.pLt.setHint(paramString);
      AppMethodBeat.o(106587);
      return;
    }
    ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(106587);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(106590);
    if (this.pLt != null)
    {
      this.pLt.setText(paramString);
      AppMethodBeat.o(106590);
      return;
    }
    ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(106590);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(106588);
    if (this.gpL != null)
    {
      this.gpL.setText(paramInt);
      AppMethodBeat.o(106588);
      return;
    }
    ab.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
    AppMethodBeat.o(106588);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(106586);
    if (this.gpL != null)
    {
      this.gpL.setText(paramString);
      AppMethodBeat.o(106586);
      return;
    }
    ab.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
    AppMethodBeat.o(106586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormSelectorView
 * JD-Core Version:    0.7.0.1
 */
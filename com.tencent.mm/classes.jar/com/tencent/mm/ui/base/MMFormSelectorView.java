package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.ac;

public class MMFormSelectorView
  extends LinearLayout
{
  private String hint;
  private TextView iCg;
  private EditText lMg;
  private int layout;
  private Context mContext;
  private String title;
  
  public MMFormSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141926);
    this.mContext = null;
    this.layout = -1;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(3, 0);
    if (paramInt != 0) {
      this.title = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(1, 0);
    if (paramInt != 0) {
      this.hint = paramContext.getString(paramInt);
    }
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141926);
  }
  
  public String getText()
  {
    AppMethodBeat.i(141933);
    if (this.lMg != null)
    {
      String str = this.lMg.getText().toString();
      AppMethodBeat.o(141933);
      return str;
    }
    ac.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141933);
    return null;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141927);
    this.iCg = ((TextView)findViewById(2131305902));
    this.lMg = ((EditText)findViewById(2131299306));
    if ((this.iCg == null) || (this.lMg == null))
    {
      ac.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[] { this.iCg, this.lMg });
      AppMethodBeat.o(141927);
      return;
    }
    if (this.title != null) {
      this.iCg.setText(this.title);
    }
    if (this.hint != null) {
      this.lMg.setHint(this.hint);
    }
    AppMethodBeat.o(141927);
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(141931);
    if (this.lMg != null)
    {
      this.lMg.setHint(paramInt);
      AppMethodBeat.o(141931);
      return;
    }
    ac.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141931);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141929);
    if (this.lMg != null)
    {
      this.lMg.setHint(paramString);
      AppMethodBeat.o(141929);
      return;
    }
    ac.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141929);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141932);
    if (this.lMg != null)
    {
      this.lMg.setText(paramString);
      AppMethodBeat.o(141932);
      return;
    }
    ac.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141932);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(141930);
    if (this.iCg != null)
    {
      this.iCg.setText(paramInt);
      AppMethodBeat.o(141930);
      return;
    }
    ac.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
    AppMethodBeat.o(141930);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(141928);
    if (this.iCg != null)
    {
      this.iCg.setText(paramString);
      AppMethodBeat.o(141928);
      return;
    }
    ac.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
    AppMethodBeat.o(141928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormSelectorView
 * JD-Core Version:    0.7.0.1
 */
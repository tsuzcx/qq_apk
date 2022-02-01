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
import com.tencent.mm.sdk.platformtools.Log;

public class MMFormSelectorView
  extends LinearLayout
{
  private String hint;
  private TextView jVO;
  private int layout;
  private Context mContext;
  private EditText nBD;
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
    if (this.nBD != null)
    {
      String str = this.nBD.getText().toString();
      AppMethodBeat.o(141933);
      return str;
    }
    Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141933);
    return null;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141927);
    this.jVO = ((TextView)findViewById(2131309195));
    this.nBD = ((EditText)findViewById(2131299910));
    if ((this.jVO == null) || (this.nBD == null))
    {
      Log.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[] { this.jVO, this.nBD });
      AppMethodBeat.o(141927);
      return;
    }
    if (this.title != null) {
      this.jVO.setText(this.title);
    }
    if (this.hint != null) {
      this.nBD.setHint(this.hint);
    }
    AppMethodBeat.o(141927);
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(141931);
    if (this.nBD != null)
    {
      this.nBD.setHint(paramInt);
      AppMethodBeat.o(141931);
      return;
    }
    Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141931);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141929);
    if (this.nBD != null)
    {
      this.nBD.setHint(paramString);
      AppMethodBeat.o(141929);
      return;
    }
    Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141929);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141932);
    if (this.nBD != null)
    {
      this.nBD.setText(paramString);
      AppMethodBeat.o(141932);
      return;
    }
    Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    AppMethodBeat.o(141932);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(141930);
    if (this.jVO != null)
    {
      this.jVO.setText(paramInt);
      AppMethodBeat.o(141930);
      return;
    }
    Log.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
    AppMethodBeat.o(141930);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(141928);
    if (this.jVO != null)
    {
      this.jVO.setText(paramString);
      AppMethodBeat.o(141928);
      return;
    }
    Log.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
    AppMethodBeat.o(141928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormSelectorView
 * JD-Core Version:    0.7.0.1
 */
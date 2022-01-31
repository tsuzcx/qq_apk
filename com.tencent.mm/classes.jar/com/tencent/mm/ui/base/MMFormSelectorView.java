package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.sdk.platformtools.y;

public class MMFormSelectorView
  extends LinearLayout
{
  private TextView eXO;
  private String frh;
  private int layout = -1;
  private Context mContext = null;
  private EditText nge;
  private String title;
  
  public MMFormSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FormItemView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.m.FormItemView_form_title, 0);
    if (paramInt != 0) {
      this.title = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.m.FormItemView_form_hint, 0);
    if (paramInt != 0) {
      this.frh = paramContext.getString(paramInt);
    }
    this.layout = paramAttributeSet.getResourceId(a.m.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
  }
  
  public String getText()
  {
    if (this.nge != null) {
      return this.nge.getText().toString();
    }
    y.e("MicroMsg.MMFormSelectorView", "contentET is null!");
    return null;
  }
  
  public void onFinishInflate()
  {
    this.eXO = ((TextView)findViewById(a.g.title));
    this.nge = ((EditText)findViewById(a.g.edittext));
    if ((this.eXO == null) || (this.nge == null)) {
      y.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[] { this.eXO, this.nge });
    }
    do
    {
      return;
      if (this.title != null) {
        this.eXO.setText(this.title);
      }
    } while (this.frh == null);
    this.nge.setHint(this.frh);
  }
  
  public void setHint(int paramInt)
  {
    if (this.nge != null)
    {
      this.nge.setHint(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormSelectorView", "contentET is null!");
  }
  
  public void setHint(String paramString)
  {
    if (this.nge != null)
    {
      this.nge.setHint(paramString);
      return;
    }
    y.e("MicroMsg.MMFormSelectorView", "contentET is null!");
  }
  
  public void setText(String paramString)
  {
    if (this.nge != null)
    {
      this.nge.setText(paramString);
      return;
    }
    y.e("MicroMsg.MMFormSelectorView", "contentET is null!");
  }
  
  public void setTitle(int paramInt)
  {
    if (this.eXO != null)
    {
      this.eXO.setText(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
  }
  
  public void setTitle(String paramString)
  {
    if (this.eXO != null)
    {
      this.eXO.setText(paramString);
      return;
    }
    y.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormSelectorView
 * JD-Core Version:    0.7.0.1
 */
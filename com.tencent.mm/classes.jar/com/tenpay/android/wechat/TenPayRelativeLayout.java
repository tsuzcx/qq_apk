package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.R.styleable;

public class TenPayRelativeLayout
  extends RelativeLayout
{
  private String accessibilityClassName;
  
  public TenPayRelativeLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(208532);
    init(paramContext, null);
    AppMethodBeat.o(208532);
  }
  
  public TenPayRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208536);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(208536);
  }
  
  public TenPayRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208540);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(208540);
  }
  
  public TenPayRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(208542);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(208542);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(208547);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TenPayRelativeLayout);
      this.accessibilityClassName = paramContext.getString(R.styleable.TenPayRelativeLayout_TenPayAccessibilityClassName);
      paramContext.recycle();
    }
    AppMethodBeat.o(208547);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(208551);
    if (TextUtils.isEmpty(this.accessibilityClassName))
    {
      localObject = super.getAccessibilityClassName();
      AppMethodBeat.o(208551);
      return localObject;
    }
    Object localObject = this.accessibilityClassName;
    AppMethodBeat.o(208551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tenpay.android.wechat.TenPayRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
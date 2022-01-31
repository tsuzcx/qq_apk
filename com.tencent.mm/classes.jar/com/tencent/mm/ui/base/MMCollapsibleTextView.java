package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.y;

public class MMCollapsibleTextView
  extends LinearLayout
{
  private Context context;
  private TextView fuN;
  private boolean hasCheck = true;
  private Runnable kbl = new MMCollapsibleTextView.2(this);
  private TextView oOh;
  private String oOi;
  private String oOj;
  private int onc;
  private SparseIntArray uUA = new SparseIntArray();
  
  public MMCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.oOi = this.context.getString(a.k.spread);
    this.oOj = this.context.getString(a.k.shrinkup);
    paramContext = inflate(this.context, a.h.mm_collapsible_textview, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.fuN = ((TextView)paramContext.findViewById(a.g.desc_tv));
    this.oOh = ((TextView)paramContext.findViewById(a.g.desc_op_tv));
    this.oOh.setOnClickListener(new MMCollapsibleTextView.1(this));
  }
  
  public int getSpreadHeight()
  {
    y.e("MicroMsg.CollapsibleTextView", "count:" + this.fuN.getLineCount() + "  height:" + this.fuN.getLineHeight());
    return (this.fuN.getLineCount() - 10) * this.fuN.getLineHeight();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.hasCheck) {
      return;
    }
    this.hasCheck = true;
    if (this.fuN.getLineCount() <= 10)
    {
      this.uUA.put(this.onc, 0);
      return;
    }
    this.uUA.put(this.onc, 1);
    post(this.kbl);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    this.oOh.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */
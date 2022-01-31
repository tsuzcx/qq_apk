package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private String bMB;
  private String bRV;
  private Context context;
  private ah handler = new ah(Looper.getMainLooper());
  private boolean hasCheck = true;
  private int oNk = 0;
  protected SnsPostDescPreloadTextView oOf;
  protected SnsTextView oOg;
  protected TextView oOh;
  private String oOi;
  private String oOj;
  private HashMap<String, Integer> oOk;
  private Runnable oOl = new CollapsibleTextView.1(this);
  private boolean omL = false;
  private CharSequence text;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.oOi = this.context.getString(i.j.sns_desc_spread);
    this.oOj = this.context.getString(i.j.sns_desc_shrinkup);
    paramContext = com.tencent.mm.ui.y.gt(this.context).inflate(i.g.collapsible_textview, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.oOf = ((SnsPostDescPreloadTextView)paramContext.findViewById(i.f.desc_tv));
    this.oOh = ((TextView)paramContext.findViewById(i.f.desc_op_tv));
    this.oOg = ((SnsTextView)paramContext.findViewById(i.f.desc_tv_single));
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, au paramau, String paramString3, boolean paramBoolean)
  {
    this.context = paramau.bER;
    this.oOk = paramHashMap;
    this.text = paramCharSequence;
    this.omL = paramBoolean;
    this.bMB = paramString1;
    this.bRV = paramString2;
    this.oNk = paramInt;
    this.oOi = this.context.getString(i.j.sns_desc_spread);
    this.oOj = this.context.getString(i.j.sns_desc_shrinkup);
    this.oOg.setOriginText(paramString3);
    paramString2 = new ar(this.bRV, this.bMB, false, false, 1);
    if (paramInt == 0)
    {
      this.oOf.setText(paramString3);
      this.oOg.setVisibility(8);
      this.oOh.setVisibility(0);
      this.oOf.setVisibility(0);
      paramCharSequence = new m(this.context);
      this.oOf.setOnTouchListener(paramCharSequence);
      this.oOf.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.oOh.setVisibility(8);
        this.oOf.setMaxLines(8);
        return;
      }
      this.hasCheck = true;
      switch (((Integer)paramHashMap.get(paramString1)).intValue())
      {
      default: 
        return;
      case 0: 
        this.oOh.setVisibility(8);
        return;
      case 1: 
        this.oOf.setMaxLines(6);
        this.oOh.setVisibility(0);
        this.oOh.setText(this.oOi);
        return;
      }
      this.oOf.setMaxLines(2147483647);
      this.oOh.setVisibility(0);
      this.oOh.setText(this.oOj);
      return;
    }
    this.oOg.setText(paramCharSequence, paramBufferType);
    this.oOg.setTag(paramString2);
    this.oOg.setVisibility(0);
    this.oOh.setVisibility(8);
    this.oOf.setVisibility(8);
    this.oOg.setOnClickListener(paramau.ovx.poU);
  }
  
  public int getSpreadHeight()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CollapsibleTextView", "count:" + this.oOf.getLineCount() + "  height:" + this.oOf.getLineHeight());
    return (this.oOf.getLineCount() - 7) * this.oOf.getLineHeight();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.oNk != 0) || (this.omL) || (this.hasCheck)) {
      return;
    }
    this.hasCheck = true;
    if (this.oOf.getLineCount() <= 7)
    {
      this.oOk.put(this.bMB, Integer.valueOf(0));
      return;
    }
    this.oOk.put(this.bMB, Integer.valueOf(1));
    this.handler.post(this.oOl);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.oOh.setClickable(paramBoolean);
    this.oOg.setClickable(paramBoolean);
    this.oOf.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    this.oOh.setLongClickable(paramBoolean);
    this.oOg.setLongClickable(paramBoolean);
    this.oOf.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.oOh != null) {
      this.oOh.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */
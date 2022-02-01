package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.span.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class AsyncNormalTextView
  extends CollapsibleTextView
{
  private bk DQX;
  private BaseTimeLineItem.BaseViewHolder Eon;
  private int Eoo = 0;
  private String content;
  private Context context;
  
  public AsyncNormalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void a(String paramString, bk parambk, int paramInt, bl parambl)
  {
    AppMethodBeat.i(97761);
    this.Eoo = paramInt;
    this.content = paramString;
    this.DQX = parambk;
    this.Epq = parambl;
    if (Util.isNullOrNil(paramString)) {
      setVisibility(8);
    }
    AppMethodBeat.o(97761);
  }
  
  public final void ffl()
  {
    AppMethodBeat.i(97763);
    Object localObject1;
    if (!Util.isNullOrNil(this.content))
    {
      System.currentTimeMillis();
      setVisibility(0);
      if (this.Eoo != 1) {
        break label244;
      }
      if (this.content.length() <= 100) {
        break label236;
      }
      localObject1 = this.content.substring(0, 100) + "...";
      this.content = ((String)localObject1);
      localObject1 = new SpannableStringBuilder(l.b(this.context, this.content, this.Epk.getTextSize()));
      a(this.Eoo, (CharSequence)localObject1, TextView.BufferType.NORMAL, this.DQX.Epp, this.Epq.Eql, this.Epq.Dsr, this.DQX, this.content, this.Epq.Eoq);
    }
    for (;;)
    {
      localObject1 = new bg(this.Epq.Dsr, this.Epq.Eql, false, false, 1);
      ((bg)localObject1).userName = this.Epq.mRa;
      this.Epk.setTag(localObject1);
      if (this.Epl != null) {
        this.Epl.setTag(localObject1);
      }
      this.Epm.setTag(this.Eon);
      setTag(this.Eon);
      AppMethodBeat.o(97763);
      return;
      label236:
      localObject1 = this.content;
      break;
      label244:
      localObject1 = null;
      if (this.Epq != null) {
        localObject1 = this.Epq.ENn;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new SpannableStringBuilder(l.b(this.context, this.content, this.Epk.getTextSize()));
      }
      if (this.Epq != null) {
        a(this.Eoo, (CharSequence)localObject2, TextView.BufferType.SPANNABLE, this.DQX.Epp, this.Epq.Eql, this.Epq.Dsr, this.DQX, this.content, this.Epq.Eoq);
      }
    }
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(97767);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setText(this.content);
    AppMethodBeat.o(97767);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97764);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(97764);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97765);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(97765);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(97766);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.getText().add(this.content);
    AppMethodBeat.o(97766);
  }
  
  public final void setAdTagClickCallback(a parama, int paramInt)
  {
    AppMethodBeat.i(203228);
    super.setAdTagClickCallback(parama, paramInt);
    AppMethodBeat.o(203228);
  }
  
  public void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(97768);
    if (this.Epl != null)
    {
      this.Epk.setSpecialWidth(paramInt);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
      this.Epl.setLayoutParams(localLayoutParams);
      this.Epk.setLayoutParams(localLayoutParams);
      this.Epm.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(97768);
  }
  
  public void setShow(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(97762);
    this.Eon = paramBaseViewHolder;
    ffl();
    AppMethodBeat.o(97762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncNormalTextView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class AsyncNormalTextView
  extends CollapsibleTextView
{
  private bn QBJ;
  private BaseTimeLineItem.BaseViewHolder Rbd;
  private int Rbe = 0;
  private String content;
  private Context context;
  
  public AsyncNormalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void a(String paramString, bn parambn, int paramInt, bo parambo)
  {
    AppMethodBeat.i(97761);
    this.Rbe = paramInt;
    this.content = paramString;
    this.QBJ = parambn;
    this.Rch = parambo;
    if (Util.isNullOrNil(paramString)) {
      setVisibility(8);
    }
    AppMethodBeat.o(97761);
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public final void hlw()
  {
    AppMethodBeat.i(97763);
    Object localObject1;
    if (!Util.isNullOrNil(this.content))
    {
      System.currentTimeMillis();
      setVisibility(0);
      if (this.Rbe != 1) {
        break label260;
      }
      if (this.content.length() <= 100) {
        break label252;
      }
      localObject1 = this.content.substring(0, 100) + "...";
      this.content = ((String)localObject1);
      localObject1 = new SpannableStringBuilder(p.b(this.context, this.content, this.Rcb.getTextSize()));
      localObject1 = com.tencent.mm.plugin.sns.h.a.a(this.Rch.PJQ.field_snsId, (CharSequence)localObject1, 0);
      a(this.Rbe, (CharSequence)localObject1, TextView.BufferType.NORMAL, this.QBJ.Rcg, this.Rch.Rdg, this.Rch.PNx, this.QBJ, this.content, this.Rch.Rbg);
    }
    for (;;)
    {
      localObject1 = new bj(this.Rch.PNx, this.Rch.Rdg, false, false, 1);
      ((bj)localObject1).userName = this.Rch.sWX;
      this.Rcb.setTag(localObject1);
      if (this.Rcc != null) {
        this.Rcc.setTag(localObject1);
      }
      this.Rcd.setTag(this.Rbd);
      setTag(this.Rbd);
      AppMethodBeat.o(97763);
      return;
      label252:
      localObject1 = this.content;
      break;
      label260:
      localObject1 = null;
      if (this.Rch != null) {
        localObject1 = this.Rch.RBo;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new SpannableStringBuilder(p.b(this.context, this.content, this.Rcb.getTextSize()));
        localObject2 = com.tencent.mm.plugin.sns.h.a.a(this.Rch.PJQ.field_snsId, (CharSequence)localObject1, 0);
      }
      if (this.Rch != null) {
        a(this.Rbe, (CharSequence)localObject2, TextView.BufferType.SPANNABLE, this.QBJ.Rcg, this.Rch.Rdg, this.Rch.PNx, this.QBJ, this.content, this.Rch.Rbg);
      }
    }
  }
  
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
  
  public final void setAdTagClickCallback(com.tencent.mm.pluginsdk.ui.span.a parama, int paramInt)
  {
    AppMethodBeat.i(308569);
    super.setAdTagClickCallback(parama, paramInt);
    AppMethodBeat.o(308569);
  }
  
  public void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(97768);
    if (this.Rcc != null)
    {
      this.Rcb.setSpecialWidth(paramInt);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
      this.Rcc.setLayoutParams(localLayoutParams);
      this.Rcb.setLayoutParams(localLayoutParams);
      this.Rcd.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(97768);
  }
  
  public void setShow(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(97762);
    this.Rbd = paramBaseViewHolder;
    hlw();
    AppMethodBeat.o(97762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncNormalTextView
 * JD-Core Version:    0.7.0.1
 */
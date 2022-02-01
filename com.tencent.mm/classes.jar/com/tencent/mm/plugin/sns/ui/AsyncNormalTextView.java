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
  private BaseTimeLineItem.BaseViewHolder KBw;
  private int KBx = 0;
  private bm Kee;
  private String content;
  private Context context;
  
  public AsyncNormalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void a(String paramString, bm parambm, int paramInt, bn parambn)
  {
    AppMethodBeat.i(97761);
    this.KBx = paramInt;
    this.content = paramString;
    this.Kee = parambm;
    this.KCz = parambn;
    if (Util.isNullOrNil(paramString)) {
      setVisibility(8);
    }
    AppMethodBeat.o(97761);
  }
  
  public final void fTg()
  {
    AppMethodBeat.i(97763);
    Object localObject1;
    if (!Util.isNullOrNil(this.content))
    {
      System.currentTimeMillis();
      setVisibility(0);
      if (this.KBx != 1) {
        break label244;
      }
      if (this.content.length() <= 100) {
        break label236;
      }
      localObject1 = this.content.substring(0, 100) + "...";
      this.content = ((String)localObject1);
      localObject1 = new SpannableStringBuilder(l.b(this.context, this.content, this.KCt.getTextSize()));
      a(this.KBx, (CharSequence)localObject1, TextView.BufferType.NORMAL, this.Kee.KCy, this.KCz.KDB, this.KCz.JyZ, this.Kee, this.content, this.KCz.KBz);
    }
    for (;;)
    {
      localObject1 = new bi(this.KCz.JyZ, this.KCz.KDB, false, false, 1);
      ((bi)localObject1).userName = this.KCz.pRV;
      this.KCt.setTag(localObject1);
      if (this.KCu != null) {
        this.KCu.setTag(localObject1);
      }
      this.KCv.setTag(this.KBw);
      setTag(this.KBw);
      AppMethodBeat.o(97763);
      return;
      label236:
      localObject1 = this.content;
      break;
      label244:
      localObject1 = null;
      if (this.KCz != null) {
        localObject1 = this.KCz.Lbk;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new SpannableStringBuilder(l.b(this.context, this.content, this.KCt.getTextSize()));
      }
      if (this.KCz != null) {
        a(this.KBx, (CharSequence)localObject2, TextView.BufferType.SPANNABLE, this.Kee.KCy, this.KCz.KDB, this.KCz.JyZ, this.Kee, this.content, this.KCz.KBz);
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
    AppMethodBeat.i(218983);
    super.setAdTagClickCallback(parama, paramInt);
    AppMethodBeat.o(218983);
  }
  
  public void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(97768);
    if (this.KCu != null)
    {
      this.KCt.setSpecialWidth(paramInt);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
      this.KCu.setLayoutParams(localLayoutParams);
      this.KCt.setLayoutParams(localLayoutParams);
      this.KCv.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(97768);
  }
  
  public void setShow(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(97762);
    this.KBw = paramBaseViewHolder;
    fTg();
    AppMethodBeat.o(97762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncNormalTextView
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public class AsyncNormalTextView
  extends CollapsibleTextView
{
  private BaseTimeLineItem.BaseViewHolder AfQ;
  private int AfR = 0;
  private String content;
  private Context context;
  private bh zGX;
  
  public AsyncNormalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void a(String paramString, bh parambh, int paramInt, bi parambi)
  {
    AppMethodBeat.i(97761);
    this.AfR = paramInt;
    this.content = paramString;
    this.zGX = parambh;
    this.AgU = parambi;
    if (bu.isNullOrNil(paramString)) {
      setVisibility(8);
    }
    AppMethodBeat.o(97761);
  }
  
  public final void ecY()
  {
    AppMethodBeat.i(97763);
    Object localObject1;
    if (!bu.isNullOrNil(this.content))
    {
      System.currentTimeMillis();
      setVisibility(0);
      if (this.AfR != 1) {
        break label244;
      }
      if (this.content.length() <= 100) {
        break label236;
      }
      localObject1 = this.content.substring(0, 100) + "...";
      this.content = ((String)localObject1);
      localObject1 = new SpannableStringBuilder(k.b(this.context, this.content, this.AgO.getTextSize()));
      a(this.AfR, (CharSequence)localObject1, TextView.BufferType.NORMAL, this.zGX.AgT, this.AgU.AhK, this.AgU.ADO, this.zGX, this.content, this.AgU.AfT);
    }
    for (;;)
    {
      localObject1 = new bd(this.AgU.ADO, this.AgU.AhK, false, false, 1);
      ((bd)localObject1).userName = this.AgU.lJm;
      this.AgO.setTag(localObject1);
      if (this.AgP != null) {
        this.AgP.setTag(localObject1);
      }
      this.AgQ.setTag(this.AfQ);
      setTag(this.AfQ);
      AppMethodBeat.o(97763);
      return;
      label236:
      localObject1 = this.content;
      break;
      label244:
      localObject1 = null;
      if (this.AgU != null) {
        localObject1 = this.AgU.ADM;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new SpannableStringBuilder(k.b(this.context, this.content, this.AgO.getTextSize()));
      }
      if (this.AgU != null) {
        a(this.AfR, (CharSequence)localObject2, TextView.BufferType.SPANNABLE, this.zGX.AgT, this.AgU.AhK, this.AgU.ADO, this.zGX, this.content, this.AgU.AfT);
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
  
  public void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(97768);
    if (this.AgP != null)
    {
      this.AgO.setSpecialWidth(paramInt);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
      this.AgP.setLayoutParams(localLayoutParams);
      this.AgO.setLayoutParams(localLayoutParams);
      this.AgQ.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(97768);
  }
  
  public void setShow(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(97762);
    this.AfQ = paramBaseViewHolder;
    ecY();
    AppMethodBeat.o(97762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncNormalTextView
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public class AsyncNormalTextView
  extends CollapsibleTextView
{
  private String content;
  private Context context;
  private be wNd;
  private BaseTimeLineItem.BaseViewHolder xkF;
  private int xkG = 0;
  
  public AsyncNormalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void a(String paramString, be parambe, int paramInt, bf parambf)
  {
    AppMethodBeat.i(97761);
    this.xkG = paramInt;
    this.content = paramString;
    this.wNd = parambe;
    this.xlK = parambf;
    if (bt.isNullOrNil(paramString)) {
      setVisibility(8);
    }
    AppMethodBeat.o(97761);
  }
  
  public final void dyH()
  {
    AppMethodBeat.i(97763);
    Object localObject1;
    if (!bt.isNullOrNil(this.content))
    {
      System.currentTimeMillis();
      setVisibility(0);
      if (this.xkG != 1) {
        break label236;
      }
      if (this.content.length() <= 100) {
        break label228;
      }
      localObject1 = this.content.substring(0, 100) + "...";
      this.content = ((String)localObject1);
      localObject1 = new SpannableStringBuilder(k.b(this.context, this.content, this.xlE.getTextSize()));
      a(this.xkG, (CharSequence)localObject1, TextView.BufferType.NORMAL, this.wNd.xlJ, this.xlK.xmu, this.xlK.xIb, this.wNd, this.content, this.xlK.xkI);
    }
    for (;;)
    {
      localObject1 = new ba(this.xlK.xIb, this.xlK.xmu, false, false, 1);
      ((ba)localObject1).userName = this.xlK.kGt;
      this.xlE.setTag(localObject1);
      if (this.xlF != null) {
        this.xlF.setTag(localObject1);
      }
      this.xlG.setTag(this.xkF);
      AppMethodBeat.o(97763);
      return;
      label228:
      localObject1 = this.content;
      break;
      label236:
      if ((this.content.length() < 400) || (this.xlK.xkI))
      {
        localObject1 = null;
        if (this.xlK != null) {
          localObject1 = this.xlK.xHZ;
        }
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SpannableStringBuilder(k.b(this.context, this.content, this.xlE.getTextSize()));
        }
        if (this.xlK != null) {
          a(this.xkG, (CharSequence)localObject2, TextView.BufferType.SPANNABLE, this.wNd.xlJ, this.xlK.xmu, this.xlK.xIb, this.wNd, this.content, this.xlK.xkI);
        }
      }
      else
      {
        a(this.xkG, this.content, TextView.BufferType.NORMAL, this.wNd.xlJ, this.xlK.xmu, this.xlK.xIb, this.wNd, this.content, this.xlK.xkI);
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
    if (this.xlF != null)
    {
      this.xlE.setSpecialWidth(paramInt);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
      this.xlF.setLayoutParams(localLayoutParams);
      this.xlE.setLayoutParams(localLayoutParams);
      this.xlG.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(97768);
  }
  
  public void setShow(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(97762);
    this.xkF = paramBaseViewHolder;
    dyH();
    AppMethodBeat.o(97762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncNormalTextView
 * JD-Core Version:    0.7.0.1
 */
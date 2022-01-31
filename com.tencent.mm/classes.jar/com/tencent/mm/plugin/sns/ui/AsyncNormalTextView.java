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
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class AsyncNormalTextView
  extends CollapsibleTextView
{
  private String content;
  private Context context;
  private BaseTimeLineItem.BaseViewHolder rEU;
  private int rEV = 0;
  private av rkX;
  
  public AsyncNormalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void a(String paramString, av paramav, int paramInt, aw paramaw)
  {
    AppMethodBeat.i(38136);
    this.rEV = paramInt;
    this.content = paramString;
    this.rkX = paramav;
    this.rFU = paramaw;
    if (bo.isNullOrNil(paramString)) {
      setVisibility(8);
    }
    AppMethodBeat.o(38136);
  }
  
  public final void ctn()
  {
    AppMethodBeat.i(38138);
    Object localObject1;
    if (!bo.isNullOrNil(this.content))
    {
      System.currentTimeMillis();
      setVisibility(0);
      if (this.rEV != 1) {
        break label236;
      }
      if (this.content.length() <= 100) {
        break label228;
      }
      localObject1 = this.content.substring(0, 100) + "...";
      this.content = ((String)localObject1);
      localObject1 = new SpannableStringBuilder(j.b(this.context, this.content, this.rFO.getTextSize()));
      a(this.rEV, (CharSequence)localObject1, TextView.BufferType.NORMAL, this.rkX.rFT, this.rFU.rGx, this.rFU.rZv, this.rkX, this.content, this.rFU.rEX);
    }
    for (;;)
    {
      localObject1 = new as(this.rFU.rZv, this.rFU.rGx, false, false, 1);
      ((as)localObject1).userName = this.rFU.ikj;
      this.rFO.setTag(localObject1);
      if (this.rFP != null) {
        this.rFP.setTag(localObject1);
      }
      this.rFQ.setTag(this.rEU);
      AppMethodBeat.o(38138);
      return;
      label228:
      localObject1 = this.content;
      break;
      label236:
      if ((this.content.length() < 400) || (this.rFU.rEX))
      {
        localObject1 = null;
        if (this.rFU != null) {
          localObject1 = this.rFU.rZt;
        }
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SpannableStringBuilder(j.b(this.context, this.content, this.rFO.getTextSize()));
        }
        if (this.rFU != null) {
          a(this.rEV, (CharSequence)localObject2, TextView.BufferType.SPANNABLE, this.rkX.rFT, this.rFU.rGx, this.rFU.rZv, this.rkX, this.content, this.rFU.rEX);
        }
      }
      else
      {
        a(this.rEV, this.content, TextView.BufferType.NORMAL, this.rkX.rFT, this.rFU.rGx, this.rFU.rZv, this.rkX, this.content, this.rFU.rEX);
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
    AppMethodBeat.i(38142);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setText(this.content);
    AppMethodBeat.o(38142);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38139);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(38139);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38140);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(38140);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(38141);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.getText().add(this.content);
    AppMethodBeat.o(38141);
  }
  
  public void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(38143);
    if (this.rFP != null)
    {
      this.rFO.setSpecialWidth(paramInt);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
      this.rFP.setLayoutParams(localLayoutParams);
      this.rFO.setLayoutParams(localLayoutParams);
      this.rFQ.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(38143);
  }
  
  public void setShow(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(38137);
    this.rEU = paramBaseViewHolder;
    ctn();
    AppMethodBeat.o(38137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncNormalTextView
 * JD-Core Version:    0.7.0.1
 */
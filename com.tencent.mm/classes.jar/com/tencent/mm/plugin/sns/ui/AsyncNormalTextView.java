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
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

public class AsyncNormalTextView
  extends CollapsibleTextView
{
  public String content;
  private Context context;
  private a.c oNj;
  public int oNk = 0;
  public ax oNl;
  public au owd;
  
  public AsyncNormalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void bHj()
  {
    Object localObject1;
    if (!bk.bl(this.content))
    {
      System.currentTimeMillis();
      setVisibility(0);
      if (this.oNk != 1) {
        break label215;
      }
      if (this.content.length() <= 100) {
        break label207;
      }
      localObject1 = this.content.substring(0, 100) + "...";
      this.content = ((String)localObject1);
      localObject1 = new SpannableStringBuilder(j.a(this.context, this.content, this.oOf.getTextSize()));
      a(this.oNk, (CharSequence)localObject1, TextView.BufferType.NORMAL, this.owd.oOk, this.oNl.oOM, this.oNl.pgO, this.owd, this.content, this.oNl.oNn);
    }
    for (;;)
    {
      localObject1 = new ar(this.oNl.pgO, this.oNl.oOM, false, false, 1);
      this.oOf.setTag(localObject1);
      if (this.oOg != null) {
        this.oOg.setTag(localObject1);
      }
      this.oOh.setTag(this.oNj);
      return;
      label207:
      localObject1 = this.content;
      break;
      label215:
      if ((this.content.length() < 400) || (this.oNl.oNn))
      {
        localObject1 = null;
        if (this.oNl != null) {
          localObject1 = this.oNl.pgM;
        }
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SpannableStringBuilder(j.a(this.context, this.content, this.oOf.getTextSize()));
        }
        if (this.oNl != null) {
          a(this.oNk, (CharSequence)localObject2, TextView.BufferType.SPANNABLE, this.owd.oOk, this.oNl.oOM, this.oNl.pgO, this.owd, this.content, this.oNl.oNn);
        }
      }
      else
      {
        a(this.oNk, this.content, TextView.BufferType.NORMAL, this.owd.oOk, this.oNl.oOM, this.oNl.pgO, this.owd, this.content, this.oNl.oNn);
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
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setText(this.content);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.getText().add(this.content);
  }
  
  public void setContentWidth(int paramInt)
  {
    if (this.oOg != null)
    {
      this.oOf.setSpecialWidth(paramInt);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
      this.oOg.setLayoutParams(localLayoutParams);
      this.oOf.setLayoutParams(localLayoutParams);
      this.oOh.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setShow(a.c paramc)
  {
    this.oNj = paramc;
    bHj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncNormalTextView
 * JD-Core Version:    0.7.0.1
 */
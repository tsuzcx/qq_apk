package com.tencent.mm.ui.chatting.component;

import android.content.Context;
import android.text.TextPaint;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/LoadableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dotCounter", "getDotCounter", "()I", "setDotCounter", "(I)V", "dotStr", "", "getDotStr", "()Ljava/lang/String;", "setDotStr", "(Ljava/lang/String;)V", "doubleClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "", "expectWidth", "getExpectWidth", "setExpectWidth", "gestureDetector", "Landroid/view/GestureDetector;", "value", "isLoading", "()Z", "setLoading", "(Z)V", "originText", "scrollAnim", "Landroid/animation/ValueAnimator;", "updateDotCallback", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "getUpdateDotCallback", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getUpdateDotTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getOriginText", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "requestSetWidth", "width", "reset2OriginText", "scrollInMaxHeightMode", "scrollInMutilLineMode", "scrollInSingleLineMode", "setMaxHeight", "maxPixels", "setMaxLines", "maxLines", "setOnDoubleClickListener", "callback", "setOriginText", "text", "", "setText", "type", "Landroid/widget/TextView$BufferType;", "smoothScrollBy", "dx", "dy", "startLoading", "stopLoading", "switchToHScroll", "switchToVScroll", "updateCurTxt", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LoadableTextView
  extends AppCompatTextView
{
  public static final LoadableTextView.a aeuI;
  private String KfV;
  private String TWb;
  private int TWc;
  private final MTimerHandler TWd;
  private int aeuJ;
  private m<? super View, ? super MotionEvent, Boolean> aeuK;
  private final MTimerHandler.CallBack akmk;
  private boolean isLoading;
  private final GestureDetector nwZ;
  
  static
  {
    AppMethodBeat.i(255883);
    aeuI = new LoadableTextView.a((byte)0);
    AppMethodBeat.o(255883);
  }
  
  public LoadableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(255863);
    AppMethodBeat.o(255863);
  }
  
  public LoadableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255865);
    paramContext = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new LoadableTextView.b());
    paramContext.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new LoadableTextView.c(this));
    paramAttributeSet = ah.aiuX;
    this.nwZ = paramContext;
    this.KfV = "";
    this.TWb = "";
    this.akmk = new LoadableTextView..ExternalSyntheticLambda0(this);
    this.TWd = new MTimerHandler(this.akmk, true);
    setSingleLine();
    AppMethodBeat.o(255865);
  }
  
  private static final boolean a(LoadableTextView paramLoadableTextView)
  {
    AppMethodBeat.i(369653);
    s.u(paramLoadableTextView, "this$0");
    int i = paramLoadableTextView.getDotCounter();
    paramLoadableTextView.setDotCounter(paramLoadableTextView.getDotCounter() + 1);
    switch (i % 3)
    {
    default: 
      if (paramLoadableTextView.isLoading) {
        paramLoadableTextView.setText((CharSequence)s.X(paramLoadableTextView.KfV, paramLoadableTextView.TWb));
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(369653);
      return true;
      paramLoadableTextView.setDotStr("·");
      break;
      paramLoadableTextView.setDotStr("··");
      break;
      paramLoadableTextView.setDotStr("···");
      break;
      paramLoadableTextView.setText((CharSequence)paramLoadableTextView.KfV);
    }
  }
  
  private static final void b(LoadableTextView paramLoadableTextView)
  {
    AppMethodBeat.i(255876);
    s.u(paramLoadableTextView, "this$0");
    if (paramLoadableTextView.getText() != null)
    {
      CharSequence localCharSequence = paramLoadableTextView.getText();
      s.s(localCharSequence, "text");
      if (localCharSequence.length() != 0) {
        break label56;
      }
    }
    label56:
    for (int i = 1; i != 0; i = 0)
    {
      paramLoadableTextView.scrollTo(0, 0);
      AppMethodBeat.o(255876);
      return;
    }
    i = paramLoadableTextView.getLineCount() * paramLoadableTextView.getLineHeight() - (paramLoadableTextView.getHeight() - paramLoadableTextView.getPaddingTop() - paramLoadableTextView.getPaddingBottom());
    if (i > 0)
    {
      paramLoadableTextView.scrollBy(0, i - paramLoadableTextView.getScrollY());
      AppMethodBeat.o(255876);
      return;
    }
    paramLoadableTextView.scrollTo(paramLoadableTextView.getScrollX(), 0);
    AppMethodBeat.o(255876);
  }
  
  private final void jtd()
  {
    AppMethodBeat.i(255869);
    setMovementMethod(ScrollingMovementMethod.getInstance());
    setVerticalScrollBarEnabled(true);
    setScrollbarFadingEnabled(true);
    AppMethodBeat.o(255869);
  }
  
  public final void aCh(int paramInt)
  {
    AppMethodBeat.i(255905);
    this.aeuJ = paramInt;
    requestLayout();
    AppMethodBeat.o(255905);
  }
  
  public final int getDotCounter()
  {
    return this.TWc;
  }
  
  public final String getDotStr()
  {
    return this.TWb;
  }
  
  public final int getExpectWidth()
  {
    return this.aeuJ;
  }
  
  public final String getOriginText()
  {
    return this.KfV;
  }
  
  public final MTimerHandler.CallBack getUpdateDotCallback()
  {
    return this.akmk;
  }
  
  public final MTimerHandler getUpdateDotTimer()
  {
    return this.TWd;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255899);
    if (this.aeuJ != 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.aeuJ, 1073741824), paramInt2);
      AppMethodBeat.o(255899);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(255899);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(255949);
    GestureDetector localGestureDetector = this.nwZ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/ui/chatting/component/LoadableTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/chatting/component/LoadableTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z"))
    {
      AppMethodBeat.o(255949);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(255949);
    return bool;
  }
  
  public final void setDotCounter(int paramInt)
  {
    this.TWc = paramInt;
  }
  
  public final void setDotStr(String paramString)
  {
    AppMethodBeat.i(255923);
    s.u(paramString, "<set-?>");
    this.TWb = paramString;
    AppMethodBeat.o(255923);
  }
  
  public final void setExpectWidth(int paramInt)
  {
    this.aeuJ = paramInt;
  }
  
  public final void setLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(255911);
    this.isLoading = paramBoolean;
    if (this.isLoading)
    {
      this.TWd.setCallBack(this.akmk);
      this.TWd.startTimer(0L, 500L);
      AppMethodBeat.o(255911);
      return;
    }
    this.TWd.stopTimer();
    this.TWd.setCallBack(null);
    AppMethodBeat.o(255911);
  }
  
  public final void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(255896);
    if (paramInt != -1)
    {
      setSingleLine(false);
      jtd();
    }
    super.setMaxHeight(paramInt);
    AppMethodBeat.o(255896);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(255893);
    super.setMaxLines(paramInt);
    if (paramInt == 1)
    {
      setMovementMethod(null);
      setVerticalScrollBarEnabled(false);
      setScrollbarFadingEnabled(false);
      AppMethodBeat.o(255893);
      return;
    }
    jtd();
    AppMethodBeat.o(255893);
  }
  
  public final void setOnDoubleClickListener(m<? super View, ? super MotionEvent, Boolean> paramm)
  {
    this.aeuK = paramm;
  }
  
  public final void setOriginText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(255933);
    s.u(paramCharSequence, "text");
    this.KfV = paramCharSequence.toString();
    setText((CharSequence)this.KfV);
    AppMethodBeat.o(255933);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(255938);
    super.setText(paramCharSequence, paramBufferType);
    if (getMaxLines() == 1)
    {
      if (getText() != null)
      {
        paramCharSequence = getText();
        s.s(paramCharSequence, "text");
        if (paramCharSequence.length() != 0) {
          break label74;
        }
      }
      while (i != 0)
      {
        scrollTo(0, getScrollY());
        AppMethodBeat.o(255938);
        return;
        label74:
        i = 0;
      }
      float f = getPaint().measureText(getText().toString());
      if (f > getWidth())
      {
        scrollBy((int)(f - getWidth()) - getScrollX(), 0);
        AppMethodBeat.o(255938);
        return;
      }
      scrollTo(0, getScrollY());
      AppMethodBeat.o(255938);
      return;
    }
    if (getMaxLines() > 1)
    {
      if (getText() != null)
      {
        paramCharSequence = getText();
        s.s(paramCharSequence, "text");
        if (paramCharSequence.length() != 0) {
          break label214;
        }
      }
      label214:
      for (i = j; (i != 0) || (getLineCount() <= getMaxLines()); i = 0)
      {
        scrollTo(0, 0);
        AppMethodBeat.o(255938);
        return;
      }
      scrollBy(0, (getLineCount() - getMaxLines()) * getLineHeight() - getScrollY());
      AppMethodBeat.o(255938);
      return;
    }
    if ((getMaxLines() == -1) && (getMaxHeight() > 0))
    {
      post(new LoadableTextView..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(255938);
      return;
    }
    Log.e("MicroMsg.LoadableTextView", "LoadableTextView auto scroll error? maxLines=" + getMaxLines() + " maxHeight=" + getMaxHeight());
    AppMethodBeat.o(255938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.LoadableTextView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MMCallBackScrollView
  extends ScrollView
{
  private int Nhs;
  private a Nht;
  private MMHandler mHandler;
  private int mState;
  
  public MMCallBackScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27680);
    this.mState = 0;
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27678);
        int i = MMCallBackScrollView.this.getScrollY();
        if (i == MMCallBackScrollView.a(MMCallBackScrollView.this))
        {
          MMCallBackScrollView.a(MMCallBackScrollView.this, 0);
          AppMethodBeat.o(27678);
          return;
        }
        MMCallBackScrollView.b(MMCallBackScrollView.this, i);
        MMCallBackScrollView.b(MMCallBackScrollView.this).sendMessageDelayed(MMCallBackScrollView.b(MMCallBackScrollView.this).obtainMessage(), 5L);
        MMCallBackScrollView.a(MMCallBackScrollView.this, 1);
        AppMethodBeat.o(27678);
      }
    };
    AppMethodBeat.o(27680);
  }
  
  public MMCallBackScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27681);
    this.mState = 0;
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27678);
        int i = MMCallBackScrollView.this.getScrollY();
        if (i == MMCallBackScrollView.a(MMCallBackScrollView.this))
        {
          MMCallBackScrollView.a(MMCallBackScrollView.this, 0);
          AppMethodBeat.o(27678);
          return;
        }
        MMCallBackScrollView.b(MMCallBackScrollView.this, i);
        MMCallBackScrollView.b(MMCallBackScrollView.this).sendMessageDelayed(MMCallBackScrollView.b(MMCallBackScrollView.this).obtainMessage(), 5L);
        MMCallBackScrollView.a(MMCallBackScrollView.this, 1);
        AppMethodBeat.o(27678);
      }
    };
    AppMethodBeat.o(27681);
  }
  
  private void afY(int paramInt)
  {
    AppMethodBeat.i(27679);
    if ((this.Nht != null) && (this.mState != paramInt))
    {
      this.mState = paramInt;
      this.Nht.onScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(27679);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(27682);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.Nhs = getScrollY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27682);
      return bool;
      if (this.mHandler != null)
      {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5L);
        continue;
        afY(1);
      }
    }
  }
  
  public void setMMOnScrollListener(a parama)
  {
    this.Nht = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScrollStateChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView
 * JD-Core Version:    0.7.0.1
 */
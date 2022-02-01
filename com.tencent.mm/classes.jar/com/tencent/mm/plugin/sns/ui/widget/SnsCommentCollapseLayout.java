package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsCommentCollapseLayout
  extends RelativeLayout
{
  private SnsComment2LinePreloadTextView Ffi;
  private SnsCommentPreloadTextView Ffj;
  private TextView Ffk;
  private CharSequence Ffl;
  private CharSequence Ffm;
  private int Ffn;
  
  public SnsCommentCollapseLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100508);
    this.Ffi = null;
    this.Ffj = null;
    this.Ffk = null;
    this.Ffl = null;
    this.Ffm = null;
    this.Ffn = 0;
    init();
    AppMethodBeat.o(100508);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100509);
    this.Ffi = null;
    this.Ffj = null;
    this.Ffk = null;
    this.Ffl = null;
    this.Ffm = null;
    this.Ffn = 0;
    init();
    AppMethodBeat.o(100509);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100510);
    this.Ffi = null;
    this.Ffj = null;
    this.Ffk = null;
    this.Ffl = null;
    this.Ffm = null;
    this.Ffn = 0;
    init();
    AppMethodBeat.o(100510);
  }
  
  private void init()
  {
    AppMethodBeat.i(100511);
    LayoutInflater.from(getContext()).inflate(2131496424, this, true);
    this.Ffi = ((SnsComment2LinePreloadTextView)findViewById(2131308096));
    this.Ffj = ((SnsCommentPreloadTextView)findViewById(2131308098));
    this.Ffi.setGravity(16);
    this.Ffj.setGravity(16);
    this.Ffk = ((TextView)findViewById(2131308097));
    this.Ffn = a.fromDPToPix(getContext(), 22);
    setOnTouchListener(new SnsCommentCollapseLayout.1(this));
    AppMethodBeat.o(100511);
  }
  
  public final void a(final CharSequence paramCharSequence1, final CharSequence paramCharSequence2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(203999);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100507);
        Log.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", new Object[] { paramCharSequence1, Integer.valueOf(paramInt1) });
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = SnsCommentCollapseLayout.this;
        if (paramCharSequence1 == null)
        {
          localObject = "";
          SnsCommentCollapseLayout.a(localSnsCommentCollapseLayout, (CharSequence)localObject);
          localSnsCommentCollapseLayout = SnsCommentCollapseLayout.this;
          if (paramCharSequence2 != null) {
            break label115;
          }
        }
        label115:
        for (Object localObject = "";; localObject = paramCharSequence2)
        {
          SnsCommentCollapseLayout.b(localSnsCommentCollapseLayout, (CharSequence)localObject);
          if ((paramInt2 > 0) || (!e.iY(paramInt1, 16))) {
            break label123;
          }
          SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this);
          AppMethodBeat.o(100507);
          return;
          localObject = paramCharSequence1;
          break;
        }
        label123:
        SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this);
        AppMethodBeat.o(100507);
      }
    });
    AppMethodBeat.o(203999);
  }
  
  public SnsComment2LinePreloadTextView get2LineCommentTv()
  {
    return this.Ffi;
  }
  
  public SnsCommentPreloadTextView getNormalCommentTv()
  {
    return this.Ffj;
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(100517);
    this.Ffi.setGravity(paramInt);
    this.Ffj.setGravity(paramInt);
    AppMethodBeat.o(100517);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(100512);
    this.Ffk.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100512);
  }
  
  public void setPressTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(100513);
    this.Ffi.setOnTouchListener(paramOnTouchListener);
    this.Ffj.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(100513);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(100519);
    super.setTag(paramObject);
    if (this.Ffi != null) {
      this.Ffi.setTag(paramObject);
    }
    if (this.Ffj != null) {
      this.Ffj.setTag(paramObject);
    }
    AppMethodBeat.o(100519);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(100516);
    this.Ffi.setTextColor(paramInt);
    this.Ffj.setTextColor(paramInt);
    AppMethodBeat.o(100516);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(100514);
    this.Ffi.setTextSize(paramFloat);
    this.Ffj.setTextSize(paramFloat);
    AppMethodBeat.o(100514);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(100515);
    this.Ffi.setTextSize$255e752(paramFloat);
    this.Ffj.setTextSize$255e752(paramFloat);
    this.Ffk.setTextSize(1, paramFloat);
    AppMethodBeat.o(100515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout
 * JD-Core Version:    0.7.0.1
 */
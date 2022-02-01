package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;

public class SnsCommentCollapseLayout
  extends RelativeLayout
{
  private SnsComment2LinePreloadTextView xYb;
  private SnsCommentPreloadTextView xYc;
  private TextView xYd;
  private CharSequence xYe;
  private int xYf;
  
  public SnsCommentCollapseLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100508);
    this.xYb = null;
    this.xYc = null;
    this.xYd = null;
    this.xYe = null;
    this.xYf = 0;
    init();
    AppMethodBeat.o(100508);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100509);
    this.xYb = null;
    this.xYc = null;
    this.xYd = null;
    this.xYe = null;
    this.xYf = 0;
    init();
    AppMethodBeat.o(100509);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100510);
    this.xYb = null;
    this.xYc = null;
    this.xYd = null;
    this.xYe = null;
    this.xYf = 0;
    init();
    AppMethodBeat.o(100510);
  }
  
  private void init()
  {
    AppMethodBeat.i(100511);
    LayoutInflater.from(getContext()).inflate(2131495536, this, true);
    this.xYb = ((SnsComment2LinePreloadTextView)findViewById(2131304956));
    this.xYc = ((SnsCommentPreloadTextView)findViewById(2131304958));
    this.xYb.setGravity(16);
    this.xYc.setGravity(16);
    this.xYd = ((TextView)findViewById(2131304957));
    this.xYf = a.fromDPToPix(getContext(), 22);
    setOnTouchListener(new SnsCommentCollapseLayout.1(this));
    AppMethodBeat.o(100511);
  }
  
  public final void l(final CharSequence paramCharSequence, final int paramInt)
  {
    AppMethodBeat.i(100518);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100507);
        ad.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", new Object[] { paramCharSequence, Integer.valueOf(paramInt) });
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = SnsCommentCollapseLayout.this;
        if (paramCharSequence == null) {}
        for (Object localObject = "";; localObject = paramCharSequence)
        {
          SnsCommentCollapseLayout.a(localSnsCommentCollapseLayout, (CharSequence)localObject);
          if (!e.hA(paramInt, 16)) {
            break;
          }
          SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this);
          AppMethodBeat.o(100507);
          return;
        }
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this);
        AppMethodBeat.o(100507);
      }
    });
    AppMethodBeat.o(100518);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(100517);
    this.xYb.setGravity(paramInt);
    this.xYc.setGravity(paramInt);
    AppMethodBeat.o(100517);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(100512);
    this.xYd.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100512);
  }
  
  public void setPressTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(100513);
    this.xYb.setOnTouchListener(paramOnTouchListener);
    this.xYc.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(100513);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(100519);
    super.setTag(paramObject);
    if (this.xYb != null) {
      this.xYb.setTag(paramObject);
    }
    if (this.xYc != null) {
      this.xYc.setTag(paramObject);
    }
    AppMethodBeat.o(100519);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(100516);
    this.xYb.setTextColor(paramInt);
    this.xYc.setTextColor(paramInt);
    AppMethodBeat.o(100516);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(100514);
    this.xYb.setTextSize(paramFloat);
    this.xYc.setTextSize(paramFloat);
    AppMethodBeat.o(100514);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(100515);
    this.xYb.setTextSize$255e752(paramFloat);
    this.xYc.setTextSize$255e752(paramFloat);
    this.xYd.setTextSize(1, paramFloat);
    AppMethodBeat.o(100515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout
 * JD-Core Version:    0.7.0.1
 */
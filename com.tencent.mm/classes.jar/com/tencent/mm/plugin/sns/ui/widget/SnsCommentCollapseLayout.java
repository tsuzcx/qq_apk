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
import com.tencent.mm.sdk.platformtools.ae;

public class SnsCommentCollapseLayout
  extends RelativeLayout
{
  private SnsComment2LinePreloadTextView AUC;
  private SnsCommentPreloadTextView AUD;
  private TextView AUE;
  private CharSequence AUF;
  private CharSequence AUG;
  private int AUH;
  
  public SnsCommentCollapseLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100508);
    this.AUC = null;
    this.AUD = null;
    this.AUE = null;
    this.AUF = null;
    this.AUG = null;
    this.AUH = 0;
    init();
    AppMethodBeat.o(100508);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100509);
    this.AUC = null;
    this.AUD = null;
    this.AUE = null;
    this.AUF = null;
    this.AUG = null;
    this.AUH = 0;
    init();
    AppMethodBeat.o(100509);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100510);
    this.AUC = null;
    this.AUD = null;
    this.AUE = null;
    this.AUF = null;
    this.AUG = null;
    this.AUH = 0;
    init();
    AppMethodBeat.o(100510);
  }
  
  private void init()
  {
    AppMethodBeat.i(100511);
    LayoutInflater.from(getContext()).inflate(2131495536, this, true);
    this.AUC = ((SnsComment2LinePreloadTextView)findViewById(2131304956));
    this.AUD = ((SnsCommentPreloadTextView)findViewById(2131304958));
    this.AUC.setGravity(16);
    this.AUD.setGravity(16);
    this.AUE = ((TextView)findViewById(2131304957));
    this.AUH = a.fromDPToPix(getContext(), 22);
    setOnTouchListener(new SnsCommentCollapseLayout.1(this));
    AppMethodBeat.o(100511);
  }
  
  public final void a(final CharSequence paramCharSequence1, final CharSequence paramCharSequence2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(220154);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100507);
        ae.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", new Object[] { paramCharSequence1, Integer.valueOf(paramInt1) });
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
          if ((paramInt2 > 0) || (!e.id(paramInt1, 16))) {
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
    AppMethodBeat.o(220154);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(100517);
    this.AUC.setGravity(paramInt);
    this.AUD.setGravity(paramInt);
    AppMethodBeat.o(100517);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(100512);
    this.AUE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100512);
  }
  
  public void setPressTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(100513);
    this.AUC.setOnTouchListener(paramOnTouchListener);
    this.AUD.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(100513);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(100519);
    super.setTag(paramObject);
    if (this.AUC != null) {
      this.AUC.setTag(paramObject);
    }
    if (this.AUD != null) {
      this.AUD.setTag(paramObject);
    }
    AppMethodBeat.o(100519);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(100516);
    this.AUC.setTextColor(paramInt);
    this.AUD.setTextColor(paramInt);
    AppMethodBeat.o(100516);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(100514);
    this.AUC.setTextSize(paramFloat);
    this.AUD.setTextSize(paramFloat);
    AppMethodBeat.o(100514);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(100515);
    this.AUC.setTextSize$255e752(paramFloat);
    this.AUD.setTextSize$255e752(paramFloat);
    this.AUE.setTextSize(1, paramFloat);
    AppMethodBeat.o(100515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout
 * JD-Core Version:    0.7.0.1
 */
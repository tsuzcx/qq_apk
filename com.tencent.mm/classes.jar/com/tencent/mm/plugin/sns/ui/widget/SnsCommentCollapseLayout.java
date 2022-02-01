package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;

public class SnsCommentCollapseLayout
  extends RelativeLayout
{
  private SnsComment2LinePreloadTextView zkX;
  private SnsCommentPreloadTextView zkY;
  private TextView zkZ;
  private CharSequence zla;
  private CharSequence zlb;
  private int zlc;
  
  public SnsCommentCollapseLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100508);
    this.zkX = null;
    this.zkY = null;
    this.zkZ = null;
    this.zla = null;
    this.zlb = null;
    this.zlc = 0;
    init();
    AppMethodBeat.o(100508);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100509);
    this.zkX = null;
    this.zkY = null;
    this.zkZ = null;
    this.zla = null;
    this.zlb = null;
    this.zlc = 0;
    init();
    AppMethodBeat.o(100509);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100510);
    this.zkX = null;
    this.zkY = null;
    this.zkZ = null;
    this.zla = null;
    this.zlb = null;
    this.zlc = 0;
    init();
    AppMethodBeat.o(100510);
  }
  
  private void init()
  {
    AppMethodBeat.i(100511);
    LayoutInflater.from(getContext()).inflate(2131495536, this, true);
    this.zkX = ((SnsComment2LinePreloadTextView)findViewById(2131304956));
    this.zkY = ((SnsCommentPreloadTextView)findViewById(2131304958));
    this.zkX.setGravity(16);
    this.zkY.setGravity(16);
    this.zkZ = ((TextView)findViewById(2131304957));
    this.zlc = a.fromDPToPix(getContext(), 22);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(100506);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          paramAnonymousView.setTag(2131306044, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
        }
        AppMethodBeat.o(100506);
        return false;
      }
    });
    AppMethodBeat.o(100511);
  }
  
  public final void a(final CharSequence paramCharSequence1, final CharSequence paramCharSequence2, final int paramInt)
  {
    AppMethodBeat.i(200668);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100507);
        ac.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", new Object[] { paramCharSequence1, Integer.valueOf(paramInt) });
        SnsCommentCollapseLayout localSnsCommentCollapseLayout = SnsCommentCollapseLayout.this;
        if (paramCharSequence1 == null)
        {
          localObject = "";
          SnsCommentCollapseLayout.a(localSnsCommentCollapseLayout, (CharSequence)localObject);
          localSnsCommentCollapseLayout = SnsCommentCollapseLayout.this;
          if (paramCharSequence2 != null) {
            break label108;
          }
        }
        label108:
        for (Object localObject = "";; localObject = paramCharSequence2)
        {
          SnsCommentCollapseLayout.b(localSnsCommentCollapseLayout, (CharSequence)localObject);
          if (!e.hJ(paramInt, 16)) {
            break label116;
          }
          SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this);
          AppMethodBeat.o(100507);
          return;
          localObject = paramCharSequence1;
          break;
        }
        label116:
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this);
        AppMethodBeat.o(100507);
      }
    });
    AppMethodBeat.o(200668);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(100517);
    this.zkX.setGravity(paramInt);
    this.zkY.setGravity(paramInt);
    AppMethodBeat.o(100517);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(100512);
    this.zkZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100512);
  }
  
  public void setPressTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(100513);
    this.zkX.setOnTouchListener(paramOnTouchListener);
    this.zkY.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(100513);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(100519);
    super.setTag(paramObject);
    if (this.zkX != null) {
      this.zkX.setTag(paramObject);
    }
    if (this.zkY != null) {
      this.zkY.setTag(paramObject);
    }
    AppMethodBeat.o(100519);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(100516);
    this.zkX.setTextColor(paramInt);
    this.zkY.setTextColor(paramInt);
    AppMethodBeat.o(100516);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(100514);
    this.zkX.setTextSize(paramFloat);
    this.zkY.setTextSize(paramFloat);
    AppMethodBeat.o(100514);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(100515);
    this.zkX.setTextSize$255e752(paramFloat);
    this.zkY.setTextSize$255e752(paramFloat);
    this.zkZ.setTextSize(1, paramFloat);
    AppMethodBeat.o(100515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout
 * JD-Core Version:    0.7.0.1
 */
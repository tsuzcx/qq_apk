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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsCommentCollapseLayout
  extends RelativeLayout
  implements h
{
  private SnsComment2LinePreloadTextView RXg;
  private SnsCommentPreloadTextView RXh;
  private TextView RXi;
  private CharSequence RXj;
  private CharSequence RXk;
  private int RXl;
  
  public SnsCommentCollapseLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100508);
    this.RXg = null;
    this.RXh = null;
    this.RXi = null;
    this.RXj = null;
    this.RXk = null;
    this.RXl = 0;
    init();
    AppMethodBeat.o(100508);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100509);
    this.RXg = null;
    this.RXh = null;
    this.RXi = null;
    this.RXj = null;
    this.RXk = null;
    this.RXl = 0;
    init();
    AppMethodBeat.o(100509);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100510);
    this.RXg = null;
    this.RXh = null;
    this.RXi = null;
    this.RXj = null;
    this.RXk = null;
    this.RXl = 0;
    init();
    AppMethodBeat.o(100510);
  }
  
  private void evc()
  {
    AppMethodBeat.i(309298);
    this.RXi.setVisibility(4);
    this.RXh.setText(this.RXj);
    this.RXh.setVisibility(0);
    this.RXg.setVisibility(8);
    invalidate();
    AppMethodBeat.o(309298);
  }
  
  private void hsS()
  {
    AppMethodBeat.i(309296);
    this.RXi.setVisibility(4);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100507);
        SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this).setVisibility(0);
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).setLines(2);
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).getConfig().mHo = (SnsCommentCollapseLayout.this.getMeasuredWidth() - SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this).getMeasuredWidth() - SnsCommentCollapseLayout.d(SnsCommentCollapseLayout.this));
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).setText(SnsCommentCollapseLayout.e(SnsCommentCollapseLayout.this));
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).setVisibility(0);
        SnsCommentCollapseLayout.f(SnsCommentCollapseLayout.this).setVisibility(8);
        AppMethodBeat.o(100507);
      }
    });
    AppMethodBeat.o(309296);
  }
  
  private void init()
  {
    AppMethodBeat.i(100511);
    LayoutInflater.from(getContext()).inflate(b.g.sns_comment_collapse_layout, this, true);
    this.RXg = ((SnsComment2LinePreloadTextView)findViewById(b.f.sns_comment_collapse_layout_2line_content_tv));
    this.RXh = ((SnsCommentPreloadTextView)findViewById(b.f.sns_comment_collapse_layout_normal_content_tv));
    this.RXg.setGravity(16);
    this.RXh.setGravity(16);
    this.RXi = ((TextView)findViewById(b.f.sns_comment_collapse_layout_action_tv));
    this.RXl = a.fromDPToPix(getContext(), 22);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(100506);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          int i = (int)paramAnonymousMotionEvent.getRawX();
          int j = (int)paramAnonymousMotionEvent.getRawY();
          paramAnonymousView.setTag(b.f.touch_loc, new int[] { i, j });
        }
        AppMethodBeat.o(100506);
        return false;
      }
    });
    AppMethodBeat.o(100511);
  }
  
  public final void a(final CharSequence paramCharSequence1, final CharSequence paramCharSequence2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(309339);
    if (aj.Qur)
    {
      Log.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", new Object[] { paramCharSequence1, Integer.valueOf(paramInt1) });
      Object localObject;
      if (paramCharSequence1 == null)
      {
        localObject = "";
        this.RXj = ((CharSequence)localObject);
        if (paramCharSequence2 != null) {
          break label109;
        }
        localObject = "";
        label55:
        this.RXk = ((CharSequence)localObject);
        if ((paramInt2 > 0) || (!g.lU(paramInt1, 16))) {
          break label115;
        }
        hsS();
      }
      for (;;)
      {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309183);
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
              if ((paramInt2 > 0) || (!g.lU(paramInt1, 16))) {
                break label123;
              }
              SnsCommentCollapseLayout.h(SnsCommentCollapseLayout.this);
              AppMethodBeat.o(309183);
              return;
              localObject = paramCharSequence1;
              break;
            }
            label123:
            SnsCommentCollapseLayout.g(SnsCommentCollapseLayout.this);
            AppMethodBeat.o(309183);
          }
        });
        AppMethodBeat.o(309339);
        return;
        localObject = paramCharSequence1;
        break;
        label109:
        localObject = paramCharSequence2;
        break label55;
        label115:
        evc();
      }
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309184);
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
          if ((paramInt2 > 0) || (!g.lU(paramInt1, 16))) {
            break label123;
          }
          SnsCommentCollapseLayout.h(SnsCommentCollapseLayout.this);
          AppMethodBeat.o(309184);
          return;
          localObject = paramCharSequence1;
          break;
        }
        label123:
        SnsCommentCollapseLayout.g(SnsCommentCollapseLayout.this);
        AppMethodBeat.o(309184);
      }
    });
    AppMethodBeat.o(309339);
  }
  
  public final void bm(float paramFloat)
  {
    AppMethodBeat.i(100515);
    this.RXg.bm(paramFloat);
    this.RXh.bm(paramFloat);
    this.RXi.setTextSize(1, paramFloat);
    AppMethodBeat.o(100515);
  }
  
  public SnsComment2LinePreloadTextView get2LineCommentTv()
  {
    return this.RXg;
  }
  
  public SnsCommentPreloadTextView getNormalCommentTv()
  {
    return this.RXh;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void hsT()
  {
    AppMethodBeat.i(309342);
    this.RXg.invalidate();
    this.RXh.invalidate();
    AppMethodBeat.o(309342);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(100517);
    this.RXg.setGravity(paramInt);
    this.RXh.setGravity(paramInt);
    AppMethodBeat.o(100517);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(100512);
    this.RXi.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100512);
  }
  
  public void setPressTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(100513);
    this.RXg.setOnTouchListener(paramOnTouchListener);
    this.RXh.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(100513);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(100519);
    super.setTag(paramObject);
    if (this.RXg != null) {
      this.RXg.setTag(paramObject);
    }
    if (this.RXh != null) {
      this.RXh.setTag(paramObject);
    }
    AppMethodBeat.o(100519);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(100516);
    this.RXg.setTextColor(paramInt);
    this.RXh.setTextColor(paramInt);
    AppMethodBeat.o(100516);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(100514);
    this.RXg.setTextSize(paramFloat);
    this.RXh.setTextSize(paramFloat);
    AppMethodBeat.o(100514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout
 * JD-Core Version:    0.7.0.1
 */
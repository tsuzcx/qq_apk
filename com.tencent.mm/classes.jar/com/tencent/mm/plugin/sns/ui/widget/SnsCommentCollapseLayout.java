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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsCommentCollapseLayout
  extends RelativeLayout
  implements f
{
  private SnsComment2LinePreloadTextView LtN;
  private SnsCommentPreloadTextView LtO;
  private TextView LtP;
  private CharSequence LtQ;
  private CharSequence LtR;
  private int LtS;
  
  public SnsCommentCollapseLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100508);
    this.LtN = null;
    this.LtO = null;
    this.LtP = null;
    this.LtQ = null;
    this.LtR = null;
    this.LtS = 0;
    init();
    AppMethodBeat.o(100508);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100509);
    this.LtN = null;
    this.LtO = null;
    this.LtP = null;
    this.LtQ = null;
    this.LtR = null;
    this.LtS = 0;
    init();
    AppMethodBeat.o(100509);
  }
  
  public SnsCommentCollapseLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100510);
    this.LtN = null;
    this.LtO = null;
    this.LtP = null;
    this.LtQ = null;
    this.LtR = null;
    this.LtS = 0;
    init();
    AppMethodBeat.o(100510);
  }
  
  private void dEW()
  {
    AppMethodBeat.i(193968);
    this.LtP.setVisibility(4);
    this.LtO.setText(this.LtQ);
    this.LtO.setVisibility(0);
    this.LtN.setVisibility(8);
    invalidate();
    AppMethodBeat.o(193968);
  }
  
  private void fZB()
  {
    AppMethodBeat.i(193967);
    this.LtP.setVisibility(4);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100507);
        SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this).setVisibility(0);
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).setLines(2);
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).getConfig().kgV = (SnsCommentCollapseLayout.this.getMeasuredWidth() - SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this).getMeasuredWidth() - SnsCommentCollapseLayout.d(SnsCommentCollapseLayout.this));
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).setText(SnsCommentCollapseLayout.e(SnsCommentCollapseLayout.this));
        SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this).setVisibility(0);
        SnsCommentCollapseLayout.f(SnsCommentCollapseLayout.this).setVisibility(8);
        AppMethodBeat.o(100507);
      }
    });
    AppMethodBeat.o(193967);
  }
  
  private void init()
  {
    AppMethodBeat.i(100511);
    LayoutInflater.from(getContext()).inflate(i.g.sns_comment_collapse_layout, this, true);
    this.LtN = ((SnsComment2LinePreloadTextView)findViewById(i.f.sns_comment_collapse_layout_2line_content_tv));
    this.LtO = ((SnsCommentPreloadTextView)findViewById(i.f.sns_comment_collapse_layout_normal_content_tv));
    this.LtN.setGravity(16);
    this.LtO.setGravity(16);
    this.LtP = ((TextView)findViewById(i.f.sns_comment_collapse_layout_action_tv));
    this.LtS = a.fromDPToPix(getContext(), 22);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(100506);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          int i = (int)paramAnonymousMotionEvent.getRawX();
          int j = (int)paramAnonymousMotionEvent.getRawY();
          paramAnonymousView.setTag(i.f.touch_loc, new int[] { i, j });
        }
        AppMethodBeat.o(100506);
        return false;
      }
    });
    AppMethodBeat.o(100511);
  }
  
  public final void a(final CharSequence paramCharSequence1, final CharSequence paramCharSequence2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(193975);
    if (ah.JXj)
    {
      Log.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", new Object[] { paramCharSequence1, Integer.valueOf(paramInt1) });
      Object localObject;
      if (paramCharSequence1 == null)
      {
        localObject = "";
        this.LtQ = ((CharSequence)localObject);
        if (paramCharSequence2 != null) {
          break label109;
        }
        localObject = "";
        label55:
        this.LtR = ((CharSequence)localObject);
        if ((paramInt2 > 0) || (!e.ki(paramInt1, 16))) {
          break label115;
        }
        fZB();
      }
      for (;;)
      {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209075);
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
              if ((paramInt2 > 0) || (!e.ki(paramInt1, 16))) {
                break label123;
              }
              SnsCommentCollapseLayout.h(SnsCommentCollapseLayout.this);
              AppMethodBeat.o(209075);
              return;
              localObject = paramCharSequence1;
              break;
            }
            label123:
            SnsCommentCollapseLayout.g(SnsCommentCollapseLayout.this);
            AppMethodBeat.o(209075);
          }
        });
        AppMethodBeat.o(193975);
        return;
        localObject = paramCharSequence1;
        break;
        label109:
        localObject = paramCharSequence2;
        break label55;
        label115:
        dEW();
      }
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194226);
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
          if ((paramInt2 > 0) || (!e.ki(paramInt1, 16))) {
            break label123;
          }
          SnsCommentCollapseLayout.h(SnsCommentCollapseLayout.this);
          AppMethodBeat.o(194226);
          return;
          localObject = paramCharSequence1;
          break;
        }
        label123:
        SnsCommentCollapseLayout.g(SnsCommentCollapseLayout.this);
        AppMethodBeat.o(194226);
      }
    });
    AppMethodBeat.o(193975);
  }
  
  public final void ar(float paramFloat)
  {
    AppMethodBeat.i(100515);
    this.LtN.ar(paramFloat);
    this.LtO.ar(paramFloat);
    this.LtP.setTextSize(1, paramFloat);
    AppMethodBeat.o(100515);
  }
  
  public final void fZC()
  {
    AppMethodBeat.i(193976);
    this.LtN.invalidate();
    this.LtO.invalidate();
    AppMethodBeat.o(193976);
  }
  
  public SnsComment2LinePreloadTextView get2LineCommentTv()
  {
    return this.LtN;
  }
  
  public SnsCommentPreloadTextView getNormalCommentTv()
  {
    return this.LtO;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(100517);
    this.LtN.setGravity(paramInt);
    this.LtO.setGravity(paramInt);
    AppMethodBeat.o(100517);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(100512);
    this.LtP.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100512);
  }
  
  public void setPressTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(100513);
    this.LtN.setOnTouchListener(paramOnTouchListener);
    this.LtO.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(100513);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(100519);
    super.setTag(paramObject);
    if (this.LtN != null) {
      this.LtN.setTag(paramObject);
    }
    if (this.LtO != null) {
      this.LtO.setTag(paramObject);
    }
    AppMethodBeat.o(100519);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(100516);
    this.LtN.setTextColor(paramInt);
    this.LtO.setTextColor(paramInt);
    AppMethodBeat.o(100516);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(100514);
    this.LtN.setTextSize(paramFloat);
    this.LtO.setTextSize(paramFloat);
    AppMethodBeat.o(100514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout
 * JD-Core Version:    0.7.0.1
 */
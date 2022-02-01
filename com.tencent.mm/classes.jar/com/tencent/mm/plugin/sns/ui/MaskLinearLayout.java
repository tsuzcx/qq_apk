package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout
  extends LinearLayout
{
  private boolean enable;
  private List<MaskImageView> list;
  private ao yxu;
  private Runnable yxv;
  
  public MaskLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97968);
    this.enable = false;
    this.list = new LinkedList();
    this.yxu = new ao();
    this.yxv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97966);
        MaskLinearLayout.this.setPressed(false);
        MaskLinearLayout.a(MaskLinearLayout.this);
        MaskLinearLayout.this.invalidate();
        AppMethodBeat.o(97966);
      }
    };
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(97967);
        ac.e("test", "touch: " + paramAnonymousMotionEvent.getAction());
        if (!MaskLinearLayout.b(MaskLinearLayout.this))
        {
          AppMethodBeat.o(97967);
          return false;
        }
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while (MaskLinearLayout.e(MaskLinearLayout.this) != null)
        {
          paramAnonymousView = MaskLinearLayout.e(MaskLinearLayout.this).iterator();
          while (paramAnonymousView.hasNext())
          {
            MaskImageView localMaskImageView = (MaskImageView)paramAnonymousView.next();
            localMaskImageView.e(localMaskImageView, paramAnonymousMotionEvent);
          }
          paramAnonymousView.setPressed(true);
          MaskLinearLayout.a(MaskLinearLayout.this);
          paramAnonymousView.invalidate();
          MaskLinearLayout.d(MaskLinearLayout.this).removeCallbacks(MaskLinearLayout.c(MaskLinearLayout.this));
          continue;
          MaskLinearLayout.d(MaskLinearLayout.this).post(MaskLinearLayout.c(MaskLinearLayout.this));
        }
        AppMethodBeat.o(97967);
        return false;
      }
    });
    AppMethodBeat.o(97968);
  }
  
  public final void b(MaskImageView paramMaskImageView)
  {
    AppMethodBeat.i(97969);
    this.list.add(paramMaskImageView);
    AppMethodBeat.o(97969);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97970);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(97970);
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(97971);
    Assert.assertTrue(false);
    AppMethodBeat.o(97971);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskLinearLayout
 * JD-Core Version:    0.7.0.1
 */
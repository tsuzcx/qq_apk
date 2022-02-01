package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class TouchImageView
  extends ImageView
{
  private RectF AqG;
  private Paint AqH;
  private int a;
  private int b;
  private boolean enable;
  private int g;
  private int r;
  ap zOG;
  Runnable zOH;
  
  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(99770);
    this.AqG = new RectF();
    this.AqH = new Paint();
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    init();
    AppMethodBeat.o(99770);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99771);
    this.AqG = new RectF();
    this.AqH = new Paint();
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    init();
    AppMethodBeat.o(99771);
  }
  
  private void init()
  {
    AppMethodBeat.i(99772);
    this.zOG = new ap();
    this.zOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99768);
        TouchImageView.this.setPressed(false);
        TouchImageView.this.invalidate();
        AppMethodBeat.o(99768);
      }
    };
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(99769);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/sns/ui/TouchImageView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject).ahq());
        if (!TouchImageView.a(TouchImageView.this))
        {
          a.a(false, this, "com/tencent/mm/plugin/sns/ui/TouchImageView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(99769);
          return false;
        }
        localObject = TouchImageView.this;
        switch (paramAnonymousMotionEvent.getAction())
        {
        case 2: 
        default: 
          if ((((TouchImageView)localObject).isClickable()) || (((TouchImageView)localObject).isLongClickable())) {
            break;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          a.a(bool, this, "com/tencent/mm/plugin/sns/ui/TouchImageView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(99769);
          return bool;
          paramAnonymousView.setPressed(true);
          paramAnonymousView.invalidate();
          ((TouchImageView)localObject).zOG.removeCallbacks(((TouchImageView)localObject).zOH);
          break;
          ((TouchImageView)localObject).zOG.post(((TouchImageView)localObject).zOH);
          break;
        }
      }
    });
    AppMethodBeat.o(99772);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(99775);
    super.onAttachedToWindow();
    ad.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    AppMethodBeat.o(99775);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(99776);
    super.onDetachedFromWindow();
    ad.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    AppMethodBeat.o(99776);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99773);
    super.onDraw(paramCanvas);
    if (isPressed())
    {
      this.AqG.left = getPaddingLeft();
      this.AqG.top = getPaddingTop();
      this.AqG.right = (getWidth() - getPaddingRight());
      this.AqG.bottom = (getHeight() - getPaddingBottom());
      this.AqH.setARGB(this.a, this.r, this.g, this.b);
      paramCanvas.drawRoundRect(this.AqG, getWidth() / 10, getHeight() / 10, this.AqH);
    }
    AppMethodBeat.o(99773);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(99774);
    AppMethodBeat.o(99774);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TouchImageView
 * JD-Core Version:    0.7.0.1
 */
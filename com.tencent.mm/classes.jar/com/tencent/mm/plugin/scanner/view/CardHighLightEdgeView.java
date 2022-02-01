package com.tencent.mm.plugin.scanner.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Arrays;

public class CardHighLightEdgeView
  extends View
{
  private int sRr;
  private Paint vb;
  private boolean[] wbA;
  private Rect wbB;
  private long wbC;
  private ap wbD;
  private boolean[] wbz;
  
  public CardHighLightEdgeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118369);
    this.wbz = new boolean[4];
    this.wbA = new boolean[4];
    this.wbD = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(118368);
        CardHighLightEdgeView.a(CardHighLightEdgeView.this, System.currentTimeMillis());
        CardHighLightEdgeView.a(CardHighLightEdgeView.this, Arrays.copyOf(CardHighLightEdgeView.a(CardHighLightEdgeView.this), 4));
        CardHighLightEdgeView.this.invalidate();
        AppMethodBeat.o(118368);
      }
    };
    init();
    AppMethodBeat.o(118369);
  }
  
  public CardHighLightEdgeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118370);
    this.wbz = new boolean[4];
    this.wbA = new boolean[4];
    this.wbD = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(118368);
        CardHighLightEdgeView.a(CardHighLightEdgeView.this, System.currentTimeMillis());
        CardHighLightEdgeView.a(CardHighLightEdgeView.this, Arrays.copyOf(CardHighLightEdgeView.a(CardHighLightEdgeView.this), 4));
        CardHighLightEdgeView.this.invalidate();
        AppMethodBeat.o(118368);
      }
    };
    init();
    AppMethodBeat.o(118370);
  }
  
  public CardHighLightEdgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118371);
    this.wbz = new boolean[4];
    this.wbA = new boolean[4];
    this.wbD = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(118368);
        CardHighLightEdgeView.a(CardHighLightEdgeView.this, System.currentTimeMillis());
        CardHighLightEdgeView.a(CardHighLightEdgeView.this, Arrays.copyOf(CardHighLightEdgeView.a(CardHighLightEdgeView.this), 4));
        CardHighLightEdgeView.this.invalidate();
        AppMethodBeat.o(118368);
      }
    };
    init();
    AppMethodBeat.o(118371);
  }
  
  private void init()
  {
    AppMethodBeat.i(118372);
    this.sRr = (a.decodeResource(getResources(), 2131233910).getWidth() / 4);
    this.vb = new Paint();
    this.vb.setColor(6676738);
    this.vb.setAlpha(255);
    this.vb.setStrokeWidth(this.sRr);
    this.vb.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(118372);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(118375);
    super.onDraw(paramCanvas);
    if (this.wbB != null)
    {
      if (this.wbz[0] != 0) {
        paramCanvas.drawLine(this.wbB.left + this.sRr / 2, this.wbB.top, this.wbB.left + this.sRr / 2, this.wbB.bottom, this.vb);
      }
      if (this.wbz[1] != 0) {
        paramCanvas.drawLine(this.wbB.right - this.sRr / 2, this.wbB.top, this.wbB.right - this.sRr / 2, this.wbB.bottom, this.vb);
      }
      if (this.wbz[2] != 0) {
        paramCanvas.drawLine(this.wbB.left, this.wbB.top + this.sRr / 2, this.wbB.right, this.wbB.top + this.sRr / 2, this.vb);
      }
      if (this.wbz[3] != 0) {
        paramCanvas.drawLine(this.wbB.left, this.wbB.bottom - this.sRr / 2, this.wbB.right, this.wbB.bottom - this.sRr / 2, this.vb);
      }
    }
    AppMethodBeat.o(118375);
  }
  
  public void setCardRect(Rect paramRect)
  {
    AppMethodBeat.i(118373);
    this.wbB = new Rect(paramRect);
    AppMethodBeat.o(118373);
  }
  
  public void setHighLightEdges(boolean[] paramArrayOfBoolean)
  {
    int j = 0;
    AppMethodBeat.i(118374);
    int i;
    if (paramArrayOfBoolean.length == 4)
    {
      ad.d("MicroMsg.CardHighLightEdgeView", "%s,%s,%s,%s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
      i = 0;
      if (i >= 4) {
        break label146;
      }
      if (this.wbz[i] == 0) {
        break label139;
      }
      i = j;
      label78:
      if (i != 0) {
        break label157;
      }
    }
    label139:
    label146:
    label157:
    for (long l = 600L - (System.currentTimeMillis() - this.wbC);; l = 0L)
    {
      this.wbA = Arrays.copyOf(paramArrayOfBoolean, 4);
      this.wbD.removeMessages(1);
      paramArrayOfBoolean = this.wbD;
      if (l > 0L) {}
      for (;;)
      {
        paramArrayOfBoolean.sendEmptyMessageDelayed(1, l);
        AppMethodBeat.o(118374);
        return;
        i += 1;
        break;
        i = 1;
        break label78;
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.CardHighLightEdgeView
 * JD-Core Version:    0.7.0.1
 */
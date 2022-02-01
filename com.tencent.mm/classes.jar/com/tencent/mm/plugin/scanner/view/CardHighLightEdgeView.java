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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Arrays;

public class CardHighLightEdgeView
  extends View
{
  private int tZE;
  private Paint vZ;
  private boolean[] xmG;
  private boolean[] xmH;
  private Rect xmI;
  private long xmJ;
  private ao xmK;
  
  public CardHighLightEdgeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118369);
    this.xmG = new boolean[4];
    this.xmH = new boolean[4];
    this.xmK = new ao()
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
    this.xmG = new boolean[4];
    this.xmH = new boolean[4];
    this.xmK = new ao()
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
    this.xmG = new boolean[4];
    this.xmH = new boolean[4];
    this.xmK = new ao()
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
    this.tZE = (a.decodeResource(getResources(), 2131233910).getWidth() / 4);
    this.vZ = new Paint();
    this.vZ.setColor(6676738);
    this.vZ.setAlpha(255);
    this.vZ.setStrokeWidth(this.tZE);
    this.vZ.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(118372);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(118375);
    super.onDraw(paramCanvas);
    if (this.xmI != null)
    {
      if (this.xmG[0] != 0) {
        paramCanvas.drawLine(this.xmI.left + this.tZE / 2, this.xmI.top, this.xmI.left + this.tZE / 2, this.xmI.bottom, this.vZ);
      }
      if (this.xmG[1] != 0) {
        paramCanvas.drawLine(this.xmI.right - this.tZE / 2, this.xmI.top, this.xmI.right - this.tZE / 2, this.xmI.bottom, this.vZ);
      }
      if (this.xmG[2] != 0) {
        paramCanvas.drawLine(this.xmI.left, this.xmI.top + this.tZE / 2, this.xmI.right, this.xmI.top + this.tZE / 2, this.vZ);
      }
      if (this.xmG[3] != 0) {
        paramCanvas.drawLine(this.xmI.left, this.xmI.bottom - this.tZE / 2, this.xmI.right, this.xmI.bottom - this.tZE / 2, this.vZ);
      }
    }
    AppMethodBeat.o(118375);
  }
  
  public void setCardRect(Rect paramRect)
  {
    AppMethodBeat.i(118373);
    this.xmI = new Rect(paramRect);
    AppMethodBeat.o(118373);
  }
  
  public void setHighLightEdges(boolean[] paramArrayOfBoolean)
  {
    int j = 0;
    AppMethodBeat.i(118374);
    int i;
    if (paramArrayOfBoolean.length == 4)
    {
      ac.d("MicroMsg.CardHighLightEdgeView", "%s,%s,%s,%s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
      i = 0;
      if (i >= 4) {
        break label146;
      }
      if (this.xmG[i] == 0) {
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
    for (long l = 600L - (System.currentTimeMillis() - this.xmJ);; l = 0L)
    {
      this.xmH = Arrays.copyOf(paramArrayOfBoolean, 4);
      this.xmK.removeMessages(1);
      paramArrayOfBoolean = this.xmK;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.CardHighLightEdgeView
 * JD-Core Version:    0.7.0.1
 */
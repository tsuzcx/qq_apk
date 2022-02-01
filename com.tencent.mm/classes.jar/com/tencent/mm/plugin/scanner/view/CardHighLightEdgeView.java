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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Arrays;

public class CardHighLightEdgeView
  extends View
{
  private int voy;
  private Paint xS;
  private boolean[] yQH;
  private boolean[] yQI;
  private Rect yQJ;
  private long yQK;
  private aq yQL;
  
  public CardHighLightEdgeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118369);
    this.yQH = new boolean[4];
    this.yQI = new boolean[4];
    this.yQL = new aq()
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
    this.yQH = new boolean[4];
    this.yQI = new boolean[4];
    this.yQL = new aq()
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
    this.yQH = new boolean[4];
    this.yQI = new boolean[4];
    this.yQL = new aq()
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
    this.voy = (a.decodeResource(getResources(), 2131233910).getWidth() / 4);
    this.xS = new Paint();
    this.xS.setColor(6676738);
    this.xS.setAlpha(255);
    this.xS.setStrokeWidth(this.voy);
    this.xS.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(118372);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(118375);
    super.onDraw(paramCanvas);
    if (this.yQJ != null)
    {
      if (this.yQH[0] != 0) {
        paramCanvas.drawLine(this.yQJ.left + this.voy / 2, this.yQJ.top, this.yQJ.left + this.voy / 2, this.yQJ.bottom, this.xS);
      }
      if (this.yQH[1] != 0) {
        paramCanvas.drawLine(this.yQJ.right - this.voy / 2, this.yQJ.top, this.yQJ.right - this.voy / 2, this.yQJ.bottom, this.xS);
      }
      if (this.yQH[2] != 0) {
        paramCanvas.drawLine(this.yQJ.left, this.yQJ.top + this.voy / 2, this.yQJ.right, this.yQJ.top + this.voy / 2, this.xS);
      }
      if (this.yQH[3] != 0) {
        paramCanvas.drawLine(this.yQJ.left, this.yQJ.bottom - this.voy / 2, this.yQJ.right, this.yQJ.bottom - this.voy / 2, this.xS);
      }
    }
    AppMethodBeat.o(118375);
  }
  
  public void setCardRect(Rect paramRect)
  {
    AppMethodBeat.i(118373);
    this.yQJ = new Rect(paramRect);
    AppMethodBeat.o(118373);
  }
  
  public void setHighLightEdges(boolean[] paramArrayOfBoolean)
  {
    int j = 0;
    AppMethodBeat.i(118374);
    int i;
    if (paramArrayOfBoolean.length == 4)
    {
      ae.d("MicroMsg.CardHighLightEdgeView", "%s,%s,%s,%s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
      i = 0;
      if (i >= 4) {
        break label146;
      }
      if (this.yQH[i] == 0) {
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
    for (long l = 600L - (System.currentTimeMillis() - this.yQK);; l = 0L)
    {
      this.yQI = Arrays.copyOf(paramArrayOfBoolean, 4);
      this.yQL.removeMessages(1);
      paramArrayOfBoolean = this.yQL;
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
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
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.plugin.ak.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Arrays;

public class CardHighLightEdgeView
  extends View
{
  private int AMY;
  private boolean[] Pki;
  private boolean[] Pkj;
  private Rect Pkk;
  private long Pkl;
  private MMHandler Pkm;
  private Paint cje;
  
  public CardHighLightEdgeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118369);
    this.Pki = new boolean[4];
    this.Pkj = new boolean[4];
    this.Pkm = new MMHandler()
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
    this.Pki = new boolean[4];
    this.Pkj = new boolean[4];
    this.Pkm = new MMHandler()
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
    this.Pki = new boolean[4];
    this.Pkj = new boolean[4];
    this.Pkm = new MMHandler()
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
    this.AMY = (a.decodeResource(getResources(), a.c.scanqr1).getWidth() / 4);
    this.cje = new Paint();
    this.cje.setColor(508256);
    this.cje.setAlpha(255);
    this.cje.setStrokeWidth(this.AMY);
    this.cje.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(118372);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(118375);
    super.onDraw(paramCanvas);
    if (this.Pkk != null)
    {
      if (this.Pki[0] != 0) {
        paramCanvas.drawLine(this.Pkk.left + this.AMY / 2, this.Pkk.top, this.Pkk.left + this.AMY / 2, this.Pkk.bottom, this.cje);
      }
      if (this.Pki[1] != 0) {
        paramCanvas.drawLine(this.Pkk.right - this.AMY / 2, this.Pkk.top, this.Pkk.right - this.AMY / 2, this.Pkk.bottom, this.cje);
      }
      if (this.Pki[2] != 0) {
        paramCanvas.drawLine(this.Pkk.left, this.Pkk.top + this.AMY / 2, this.Pkk.right, this.Pkk.top + this.AMY / 2, this.cje);
      }
      if (this.Pki[3] != 0) {
        paramCanvas.drawLine(this.Pkk.left, this.Pkk.bottom - this.AMY / 2, this.Pkk.right, this.Pkk.bottom - this.AMY / 2, this.cje);
      }
    }
    AppMethodBeat.o(118375);
  }
  
  public void setCardRect(Rect paramRect)
  {
    AppMethodBeat.i(118373);
    this.Pkk = new Rect(paramRect);
    AppMethodBeat.o(118373);
  }
  
  public void setHighLightEdges(boolean[] paramArrayOfBoolean)
  {
    int j = 0;
    AppMethodBeat.i(118374);
    int i;
    if (paramArrayOfBoolean.length == 4)
    {
      Log.d("MicroMsg.CardHighLightEdgeView", "%s,%s,%s,%s", new Object[] { Boolean.valueOf(paramArrayOfBoolean[0]), Boolean.valueOf(paramArrayOfBoolean[1]), Boolean.valueOf(paramArrayOfBoolean[2]), Boolean.valueOf(paramArrayOfBoolean[3]) });
      i = 0;
      if (i >= 4) {
        break label146;
      }
      if (this.Pki[i] == 0) {
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
    for (long l = 600L - (System.currentTimeMillis() - this.Pkl);; l = 0L)
    {
      this.Pkj = Arrays.copyOf(paramArrayOfBoolean, 4);
      this.Pkm.removeMessages(1);
      paramArrayOfBoolean = this.Pkm;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.CardHighLightEdgeView
 * JD-Core Version:    0.7.0.1
 */
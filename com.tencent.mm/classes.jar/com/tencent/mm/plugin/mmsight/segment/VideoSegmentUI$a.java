package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

final class VideoSegmentUI$a
  implements Runnable
{
  private Context context;
  private ViewGroup mmr;
  private int oML;
  private int oMM;
  private int oMN;
  private VideoSegmentUI.b oMO;
  
  private VideoSegmentUI$a(VideoSegmentUI paramVideoSegmentUI, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, VideoSegmentUI.b paramb)
  {
    AppMethodBeat.i(55045);
    this.oML = paramInt1;
    this.oMM = paramInt2;
    this.oMN = paramInt3;
    this.context = paramViewGroup.getContext();
    this.mmr = paramViewGroup;
    this.oMO = paramb;
    AppMethodBeat.o(55045);
  }
  
  public final void run()
  {
    AppMethodBeat.i(55046);
    if (this.oME.isFinishing())
    {
      AppMethodBeat.o(55046);
      return;
    }
    Object localObject = new VideoSegmentUI.a.1(this, this.context);
    int i = this.mmr.getWidth();
    int j = a.ao(this.context, 2131428782);
    int k = ((View)VideoSegmentUI.j(this.oME)).getTop() - j * 2;
    int m = this.oMM;
    int n = this.oML;
    Point localPoint = new Point();
    if (n / m > k / i) {}
    for (float f = k / n;; f = i / m)
    {
      localPoint.x = ((int)(m * f));
      localPoint.y = ((int)(f * n));
      ab.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.oMM), Integer.valueOf(this.oML), Integer.valueOf(this.oMN), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
      if ((localPoint.x > 0) && (localPoint.y > 0)) {
        break;
      }
      ab.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.oMM), Integer.valueOf(this.oML), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
      if (this.oMO != null)
      {
        localObject = this.oMO;
        ab.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
        VideoSegmentUI.m(((VideoSegmentUI.b)localObject).oME);
        ((VideoSegmentUI.b)localObject).oME.finish();
        VideoSegmentUI.b(((VideoSegmentUI.b)localObject).oME);
      }
      AppMethodBeat.o(55046);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(localPoint.x, localPoint.y);
    j += (int)((k - localPoint.y) / 2.0F);
    localLayoutParams.topMargin = j;
    localLayoutParams.bottomMargin = j;
    i = (int)((i - localPoint.x) / 2.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    ((MMTextureView)localObject).setSurfaceTextureListener(this.oMO);
    this.mmr.addView((View)localObject, 0, localLayoutParams);
    AppMethodBeat.o(55046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.a
 * JD-Core Version:    0.7.0.1
 */
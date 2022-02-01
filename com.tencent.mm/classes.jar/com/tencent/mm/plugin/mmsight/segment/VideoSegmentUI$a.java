package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;

final class VideoSegmentUI$a
  implements Runnable
{
  private int Ffa;
  private int Ffb;
  private int Ffc;
  private VideoSegmentUI.b Ffd;
  private Context context;
  private ViewGroup kiF;
  
  private VideoSegmentUI$a(VideoSegmentUI paramVideoSegmentUI, ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, VideoSegmentUI.b paramb)
  {
    AppMethodBeat.i(94480);
    this.Ffa = paramInt1;
    this.Ffb = paramInt2;
    this.Ffc = paramInt3;
    this.context = paramViewGroup.getContext();
    this.kiF = paramViewGroup;
    this.Ffd = paramb;
    AppMethodBeat.o(94480);
  }
  
  public final void run()
  {
    AppMethodBeat.i(94481);
    if (this.FeT.isFinishing())
    {
      AppMethodBeat.o(94481);
      return;
    }
    Object localObject = new MMTextureView(this.context)
    {
      protected final void onMeasure(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(94479);
        Log.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.a(VideoSegmentUI.a.this)), Integer.valueOf(VideoSegmentUI.a.b(VideoSegmentUI.a.this)), Integer.valueOf(VideoSegmentUI.a.c(VideoSegmentUI.a.this)), Integer.valueOf(View.getDefaultSize(1, paramAnonymousInt1)), Integer.valueOf(View.getDefaultSize(1, paramAnonymousInt2)) });
        if ((VideoSegmentUI.a.c(VideoSegmentUI.a.this) == 90) || (VideoSegmentUI.a.c(VideoSegmentUI.a.this) == 270))
        {
          Matrix localMatrix = new Matrix();
          localMatrix.set(getMatrix());
          int i = View.getDefaultSize(1, paramAnonymousInt1);
          int j = View.getDefaultSize(1, paramAnonymousInt2);
          float f1 = i / 2.0F;
          float f2 = j / 2.0F;
          float f3 = j / i;
          localMatrix.postRotate(VideoSegmentUI.a.c(VideoSegmentUI.a.this), f1, f2);
          localMatrix.postScale(1.0F / f3, f3, f1, f2);
          setTransform(localMatrix);
          Log.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.c(VideoSegmentUI.a.this)), Integer.valueOf(i), Integer.valueOf(j) });
        }
        super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(94479);
      }
    };
    int i = this.kiF.getWidth();
    int j = a.aY(this.context, a.c.video_segment_surface_padding_vertical);
    int k = ((View)VideoSegmentUI.j(this.FeT)).getTop() - j * 2;
    int m = this.Ffb;
    int n = this.Ffa;
    Point localPoint = new Point();
    if (n / m > k / i) {}
    for (float f = k / n;; f = i / m)
    {
      localPoint.x = ((int)(m * f));
      localPoint.y = ((int)(f * n));
      Log.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.Ffb), Integer.valueOf(this.Ffa), Integer.valueOf(this.Ffc), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
      if ((localPoint.x > 0) && (localPoint.y > 0)) {
        break;
      }
      Log.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.Ffb), Integer.valueOf(this.Ffa), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
      if (this.Ffd != null)
      {
        localObject = this.Ffd;
        Log.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
        VideoSegmentUI.m(((VideoSegmentUI.b)localObject).FeT);
        ((VideoSegmentUI.b)localObject).FeT.finish();
        VideoSegmentUI.b(((VideoSegmentUI.b)localObject).FeT);
      }
      AppMethodBeat.o(94481);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(localPoint.x, localPoint.y);
    j += (int)((k - localPoint.y) / 2.0F);
    localLayoutParams.topMargin = j;
    localLayoutParams.bottomMargin = j;
    i = (int)((i - localPoint.x) / 2.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    ((MMTextureView)localObject).setSurfaceTextureListener(this.Ffd);
    this.kiF.addView((View)localObject, 0, localLayoutParams);
    AppMethodBeat.o(94481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.a
 * JD-Core Version:    0.7.0.1
 */
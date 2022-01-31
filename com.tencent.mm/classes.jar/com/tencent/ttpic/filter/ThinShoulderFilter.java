package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;

public class ThinShoulderFilter
  extends VideoFilterBase
{
  private static final int BODY_POINTS_NUM = 59;
  public static final String FRAGMENT_SHADER;
  public static final String TAG;
  public static final String VERTEX_SHADER;
  private static final int[] leftIndexs;
  private static final int[] rightIndexs;
  private PointF center;
  private int currentIdx;
  private boolean hasSeenValid;
  private float height;
  private long lastValidTime;
  private boolean mEnable;
  private ThinShoulderFilter.ThinShoulderParameters params;
  private PointF[] pointsNormalized;
  private ThinShoulderFilter.ThinShoulderParameters[] previousParams;
  private boolean[] previousValidFrames;
  private ThinShoulderFilter.ThinShoulderParameters previousValidParams;
  private float prop;
  private boolean showMark;
  private ThinShoulderFilter.ThinShoulderParameters smoothedParams;
  private int smoothedWithinFrames;
  private float strength;
  private long validDuration;
  private float width;
  
  static
  {
    AppMethodBeat.i(83003);
    TAG = ThinShoulderFilter.class.getSimpleName();
    leftIndexs = new int[] { 13, 14, 15, 16, 17 };
    rightIndexs = new int[] { 45, 44, 43, 42, 41 };
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinShoulderVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinShoulderFragmentShader.dat");
    AppMethodBeat.o(83003);
  }
  
  public ThinShoulderFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82991);
    this.showMark = false;
    this.mEnable = false;
    this.pointsNormalized = new PointF[59];
    initParams();
    this.smoothedWithinFrames = 2;
    this.currentIdx = 0;
    this.validDuration = 2000L;
    this.hasSeenValid = false;
    int i = 0;
    while (i < this.pointsNormalized.length)
    {
      this.pointsNormalized[i] = new PointF();
      i += 1;
    }
    if (this.previousValidFrames == null)
    {
      this.previousValidFrames = new boolean[this.smoothedWithinFrames];
      i = 0;
      while (i < this.smoothedWithinFrames)
      {
        this.previousValidFrames[i] = false;
        i += 1;
      }
    }
    if (this.params == null) {
      this.params = new ThinShoulderFilter.ThinShoulderParameters(this);
    }
    if (this.previousParams == null)
    {
      this.previousParams = new ThinShoulderFilter.ThinShoulderParameters[this.smoothedWithinFrames];
      i = 0;
      while (i < this.smoothedWithinFrames)
      {
        this.previousParams[i] = new ThinShoulderFilter.ThinShoulderParameters(this);
        i += 1;
      }
    }
    if (this.previousValidParams == null) {
      this.previousValidParams = new ThinShoulderFilter.ThinShoulderParameters(this);
    }
    if (this.smoothedParams == null) {
      this.smoothedParams = new ThinShoulderFilter.ThinShoulderParameters(this);
    }
    this.smoothedParams.reset();
    i = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4;
    int k;
    for (int j = 0; i < this.smoothedWithinFrames; j = k)
    {
      float f6 = f1;
      float f5 = f2;
      f4 = f3;
      k = j;
      if (this.previousValidFrames[i] != 0)
      {
        k = j + 1;
        ThinShoulderFilter.ThinShoulderParameters localThinShoulderParameters = this.previousParams[i];
        f4 = f3 + ThinShoulderFilter.ThinShoulderParameters.access$000(localThinShoulderParameters).left;
        f5 = f2 + ThinShoulderFilter.ThinShoulderParameters.access$000(localThinShoulderParameters).top;
        f6 = f1 + ThinShoulderFilter.ThinShoulderParameters.access$000(localThinShoulderParameters).right + ThinShoulderFilter.ThinShoulderParameters.access$000(localThinShoulderParameters).bottom;
      }
      i += 1;
      f1 = f6;
      f2 = f5;
      f3 = f4;
    }
    if (j > 0)
    {
      f3 /= j;
      f2 /= j;
      f1 /= j;
      f4 = 0.0F / j;
      ThinShoulderFilter.ThinShoulderParameters.access$002(this.smoothedParams, new RectF(f3, f2, f1, f4));
    }
    AppMethodBeat.o(82991);
  }
  
  private void normalizePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83002);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(83002);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      this.pointsNormalized[i].x = (((PointF)paramList.get(i)).x / paramInt1);
      this.pointsNormalized[i].y = (((PointF)paramList.get(i)).y / paramInt2);
      i += 1;
    }
    AppMethodBeat.o(83002);
  }
  
  public void calculateMiddleLineWithNormalizedPoints()
  {
    int i = 0;
    AppMethodBeat.i(83001);
    int j = leftIndexs.length;
    PointF localPointF1 = this.pointsNormalized[0];
    PointF localPointF2 = this.pointsNormalized[58];
    float f2 = 0.0F;
    float f1 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < j)
    {
      PointF localPointF3 = this.pointsNormalized[leftIndexs[i]];
      PointF localPointF4 = this.pointsNormalized[rightIndexs[i]];
      f4 += (localPointF3.x + localPointF4.x) / 2.0F;
      f3 += (localPointF3.y + localPointF4.y) / 2.0F;
      float f5 = localPointF4.x;
      float f6 = localPointF3.x;
      f2 += localPointF3.y + localPointF4.y - localPointF1.y - localPointF2.y;
      i += 1;
      f1 = f5 - f6 + f1;
    }
    setParams(new ThinShoulderFilter.ThinShoulderParameters(this, new RectF(f4 / j, f3 / j - 0.05F * f2, f1 / j * 2.0F, f2 * 0.18F)));
    AppMethodBeat.o(83001);
  }
  
  public void initParams()
  {
    int i = 0;
    AppMethodBeat.i(82999);
    this.center = new PointF();
    this.showMark = false;
    this.mEnable = false;
    this.prop = 0.5625F;
    if (this.showMark) {
      i = 1;
    }
    addParam(new m.i("showMark", i));
    addParam(new m.f("strength", 0.0F));
    addParam(new m.b("center", 0.0F, 0.0F));
    addParam(new m.f("width", 0.0F));
    addParam(new m.f("height", 0.0F));
    addParam(new m.f("prop", 0.5625F));
    AppMethodBeat.o(82999);
  }
  
  public void resetState()
  {
    this.hasSeenValid = false;
    this.previousParams = null;
  }
  
  public void setCenter(PointF paramPointF)
  {
    float f3 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(82995);
    PointF localPointF = this.center;
    if (paramPointF.x > 1.0F)
    {
      f1 = 1.0F;
      localPointF.x = f1;
      localPointF = this.center;
      if (paramPointF.x >= 0.0F) {
        break label144;
      }
      f1 = 0.0F;
      label50:
      localPointF.x = f1;
      localPointF = this.center;
      if (paramPointF.y <= 1.0F) {
        break label152;
      }
      f1 = f3;
      label74:
      localPointF.y = f1;
      localPointF = this.center;
      if (paramPointF.y >= 0.0F) {
        break label160;
      }
    }
    label144:
    label152:
    label160:
    for (float f1 = f2;; f1 = paramPointF.y)
    {
      localPointF.y = f1;
      addParam(new m.b("center", this.center.x, this.center.y));
      AppMethodBeat.o(82995);
      return;
      f1 = paramPointF.x;
      break;
      f1 = paramPointF.x;
      break label50;
      f1 = paramPointF.y;
      break label74;
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setHeight(float paramFloat)
  {
    float f = 1.0F;
    AppMethodBeat.i(82997);
    if (paramFloat > 1.0F) {}
    for (;;)
    {
      this.height = f;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      this.height = f;
      addParam(new m.f("height", this.height));
      AppMethodBeat.o(82997);
      return;
      f = paramFloat;
    }
  }
  
  public void setParams(ThinShoulderFilter.ThinShoulderParameters paramThinShoulderParameters)
  {
    AppMethodBeat.i(82994);
    setCenter(new PointF(ThinShoulderFilter.ThinShoulderParameters.access$000(paramThinShoulderParameters).left, ThinShoulderFilter.ThinShoulderParameters.access$000(paramThinShoulderParameters).top));
    setWidth(ThinShoulderFilter.ThinShoulderParameters.access$000(paramThinShoulderParameters).right);
    setHeight(ThinShoulderFilter.ThinShoulderParameters.access$000(paramThinShoulderParameters).bottom);
    AppMethodBeat.o(82994);
  }
  
  public void setProp(float paramFloat)
  {
    float f = 2.0F;
    AppMethodBeat.i(82998);
    if (paramFloat > 2.0F) {}
    for (;;)
    {
      this.prop = f;
      f = paramFloat;
      if (paramFloat < 0.5F) {
        f = 0.5F;
      }
      this.prop = f;
      addParam(new m.f("prop", this.prop));
      AppMethodBeat.o(82998);
      return;
      f = paramFloat;
    }
  }
  
  public void setShowMark(boolean paramBoolean)
  {
    AppMethodBeat.i(82993);
    if (this.showMark != paramBoolean)
    {
      this.showMark = paramBoolean;
      if (!this.showMark) {
        break label47;
      }
    }
    label47:
    for (int i = 1;; i = 0)
    {
      addParam(new m.i("showMark", i));
      AppMethodBeat.o(82993);
      return;
    }
  }
  
  public void setStrength(float paramFloat)
  {
    float f = 1.0F;
    AppMethodBeat.i(82992);
    if (paramFloat > 1.0F) {}
    for (;;)
    {
      this.strength = f;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      this.strength = f;
      addParam(new m.f("strength", this.strength));
      AppMethodBeat.o(82992);
      return;
      f = paramFloat;
    }
  }
  
  public void setWidth(float paramFloat)
  {
    float f = 1.0F;
    AppMethodBeat.i(82996);
    if (paramFloat > 1.0F) {}
    for (;;)
    {
      this.width = f;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      this.width = f;
      addParam(new m.f("width", this.width));
      AppMethodBeat.o(82996);
      return;
      f = paramFloat;
    }
  }
  
  public boolean setupBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(83000);
    if (this.mEnable)
    {
      this.currentIdx += 1;
      if (this.currentIdx >= this.smoothedWithinFrames) {
        this.currentIdx = 0;
      }
      if (paramList != null)
      {
        this.hasSeenValid = true;
        normalizePoints(paramList, paramInt1, paramInt2);
        calculateMiddleLineWithNormalizedPoints();
        this.previousValidFrames[this.currentIdx] = true;
        this.previousParams[this.currentIdx] = this.params.copy();
        paramList = this.smoothedParams;
        this.params = paramList;
        this.previousValidParams = paramList;
        this.lastValidTime = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      this.mEnable = bool;
      bool = this.mEnable;
      AppMethodBeat.o(83000);
      return bool;
      this.previousValidFrames[this.currentIdx] = false;
      if ((this.hasSeenValid) && (System.currentTimeMillis() - this.lastValidTime < this.validDuration)) {
        this.params = this.previousValidParams;
      } else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.ThinShoulderFilter
 * JD-Core Version:    0.7.0.1
 */
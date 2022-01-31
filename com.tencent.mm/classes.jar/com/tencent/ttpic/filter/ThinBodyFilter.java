package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;

public class ThinBodyFilter
  extends VideoFilterBase
{
  private static final int BODY_POINTS_NUM = 59;
  public static final String FRAGMENT_SHADER;
  public static final String TAG;
  public static final String VERTEX_SHADER;
  private static final int[] leftIndexs;
  private static final int[] rightIndexs;
  private int currentIdx;
  private boolean hasSeenValid;
  private long lastValidTime;
  private boolean mEnable;
  private ThinBodyFilter.ThinBodyParameters params;
  private PointF[] pointsNormalized;
  private ThinBodyFilter.ThinBodyParameters[] previousParams;
  private boolean[] previousValidFrames;
  private ThinBodyFilter.ThinBodyParameters previousValidParams;
  private boolean showMark;
  private ThinBodyFilter.ThinBodyParameters smoothedParams;
  private int smoothedWithinFrames;
  private float strength;
  private long validDuration;
  
  static
  {
    AppMethodBeat.i(82987);
    TAG = ThinBodyFilter.class.getSimpleName();
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinBodyVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinBodyFragmentShader.dat");
    leftIndexs = new int[] { 13, 14, 15, 16, 17 };
    rightIndexs = new int[] { 45, 44, 43, 42, 41 };
    AppMethodBeat.o(82987);
  }
  
  public ThinBodyFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82975);
    this.showMark = false;
    this.mEnable = false;
    this.pointsNormalized = new PointF[59];
    initParams();
    int i = 0;
    while (i < this.pointsNormalized.length)
    {
      this.pointsNormalized[i] = new PointF();
      i += 1;
    }
    this.smoothedWithinFrames = 2;
    this.currentIdx = 0;
    this.validDuration = 2000L;
    this.hasSeenValid = false;
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
      this.params = new ThinBodyFilter.ThinBodyParameters(this);
    }
    if (this.previousParams == null)
    {
      this.previousParams = new ThinBodyFilter.ThinBodyParameters[this.smoothedWithinFrames];
      i = 0;
      while (i < this.smoothedWithinFrames)
      {
        this.previousParams[i] = new ThinBodyFilter.ThinBodyParameters(this);
        i += 1;
      }
    }
    if (this.smoothedParams == null) {
      this.smoothedParams = new ThinBodyFilter.ThinBodyParameters(this);
    }
    this.smoothedParams.reset();
    i = 0;
    int k;
    ThinBodyFilter.ThinBodyParameters localThinBodyParameters1;
    for (int j = 0; i < this.smoothedWithinFrames; j = k)
    {
      k = j;
      if (this.previousValidFrames[i] == 1)
      {
        k = j + 1;
        localThinBodyParameters1 = this.previousParams[i];
        ThinBodyFilter.ThinBodyParameters localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.y0 += localThinBodyParameters1.y0;
        localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.y1 += localThinBodyParameters1.y1;
        localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.y2 += localThinBodyParameters1.y2;
        localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.middleLine += localThinBodyParameters1.middleLine;
        localThinBodyParameters2 = this.smoothedParams;
        float f = localThinBodyParameters2.waistWidth;
        localThinBodyParameters1.waistWidth += f;
      }
      i += 1;
    }
    if (j > 0)
    {
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.y0 /= j;
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.y1 /= j;
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.y2 /= j;
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.middleLine /= j;
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.waistWidth /= j;
    }
    AppMethodBeat.o(82975);
  }
  
  private void calculateMiddleLineWithNormalizedPoints()
  {
    AppMethodBeat.i(82985);
    int j = leftIndexs.length;
    int i = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    while (i < j)
    {
      PointF localPointF1 = this.pointsNormalized[leftIndexs[i]];
      PointF localPointF2 = this.pointsNormalized[rightIndexs[i]];
      f3 += (localPointF1.x + localPointF2.x) / 2.0F;
      f2 += (localPointF1.y + localPointF2.y) / 2.0F;
      f1 += localPointF2.x - localPointF1.x;
      i += 1;
    }
    float f4 = (this.pointsNormalized[0].y + this.pointsNormalized[58].y) / 2.0F;
    f3 /= j;
    f2 /= j;
    f1 /= j;
    setMiddleLine(f3);
    setY0(f4);
    setY1(f2 - 0.0F * f1);
    setY2(0.4F * f1 + f2);
    setWaistWidth(f1);
    AppMethodBeat.o(82985);
  }
  
  private void normalizePoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82986);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(82986);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      this.pointsNormalized[i].x = (((PointF)paramList.get(i)).x / paramInt1);
      this.pointsNormalized[i].y = (((PointF)paramList.get(i)).y / paramInt2);
      i += 1;
    }
    AppMethodBeat.o(82986);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82976);
    if (this.showMark) {}
    for (int i = 1;; i = 0)
    {
      addParam(new m.i("showMark", i));
      addParam(new m.f("y0", 0.25F));
      addParam(new m.f("y1", 0.5F));
      addParam(new m.f("y2", 0.7F));
      addParam(new m.f("middleLine", 0.0F));
      addParam(new m.f("waistWidth", 0.0F));
      addParam(new m.f("strength", 0.0F));
      addParam(new m.f("factor", 0.16F));
      AppMethodBeat.o(82976);
      return;
    }
  }
  
  public boolean isEnable()
  {
    return this.mEnable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setMiddleLine(float paramFloat)
  {
    float f = 0.1F;
    AppMethodBeat.i(82978);
    ThinBodyFilter.ThinBodyParameters localThinBodyParameters = this.params;
    if (paramFloat < 0.1F) {}
    for (;;)
    {
      localThinBodyParameters.middleLine = f;
      localThinBodyParameters = this.params;
      f = paramFloat;
      if (paramFloat > 0.9F) {
        f = 0.9F;
      }
      localThinBodyParameters.middleLine = f;
      addParam(new m.f("middleLine", this.params.middleLine));
      AppMethodBeat.o(82978);
      return;
      f = paramFloat;
    }
  }
  
  public void setShowMark(boolean paramBoolean)
  {
    AppMethodBeat.i(82983);
    if (this.showMark != paramBoolean)
    {
      this.showMark = paramBoolean;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      addParam(new m.i("showMark", i));
      AppMethodBeat.o(82983);
      return;
    }
  }
  
  public void setStrength(float paramFloat)
  {
    float f = 1.0F;
    AppMethodBeat.i(82979);
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
      AppMethodBeat.o(82979);
      return;
      f = paramFloat;
    }
  }
  
  public void setWaistWidth(float paramFloat)
  {
    float f = 0.0F;
    AppMethodBeat.i(82977);
    ThinBodyFilter.ThinBodyParameters localThinBodyParameters = this.params;
    if (paramFloat < 0.0F) {}
    for (;;)
    {
      localThinBodyParameters.waistWidth = f;
      localThinBodyParameters = this.params;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
      localThinBodyParameters.waistWidth = f;
      addParam(new m.f("waistWidth", this.params.waistWidth));
      AppMethodBeat.o(82977);
      return;
      f = paramFloat;
    }
  }
  
  public void setY0(float paramFloat)
  {
    float f = 0.0F;
    AppMethodBeat.i(82980);
    ThinBodyFilter.ThinBodyParameters localThinBodyParameters = this.params;
    if (paramFloat < 0.0F) {}
    for (;;)
    {
      localThinBodyParameters.y0 = f;
      localThinBodyParameters = this.params;
      f = paramFloat;
      if (paramFloat > this.params.y1) {
        f = this.params.y1;
      }
      localThinBodyParameters.y0 = f;
      addParam(new m.f("y0", this.params.y0));
      AppMethodBeat.o(82980);
      return;
      f = paramFloat;
    }
  }
  
  public void setY1(float paramFloat)
  {
    AppMethodBeat.i(82981);
    ThinBodyFilter.ThinBodyParameters localThinBodyParameters = this.params;
    if (paramFloat > this.params.y2) {}
    for (float f = this.params.y2;; f = paramFloat)
    {
      localThinBodyParameters.y1 = f;
      localThinBodyParameters = this.params;
      f = paramFloat;
      if (paramFloat < this.params.y0) {
        f = this.params.y0;
      }
      localThinBodyParameters.y1 = f;
      addParam(new m.f("y1", this.params.y1));
      AppMethodBeat.o(82981);
      return;
    }
  }
  
  public void setY2(float paramFloat)
  {
    float f = 1.0F;
    AppMethodBeat.i(82982);
    ThinBodyFilter.ThinBodyParameters localThinBodyParameters = this.params;
    if (paramFloat > 1.0F) {}
    for (;;)
    {
      localThinBodyParameters.y2 = f;
      localThinBodyParameters = this.params;
      f = paramFloat;
      if (paramFloat < this.params.y1) {
        f = this.params.y1;
      }
      localThinBodyParameters.y2 = f;
      addParam(new m.f("y2", this.params.y2));
      AppMethodBeat.o(82982);
      return;
      f = paramFloat;
    }
  }
  
  public boolean setupBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(82984);
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
      AppMethodBeat.o(82984);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.ThinBodyFilter
 * JD-Core Version:    0.7.0.1
 */
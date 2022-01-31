package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;

public class SlimWaistFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  public static final String VERTEX_SHADER;
  private static int[] leftIndex;
  private static int[] rightIndex;
  private final float T0;
  private int currentIdx;
  private RectF mCurrentRect;
  private boolean mHasSeenValid;
  private long mPreviousLostTime;
  private RectF mPreviousValidRect;
  private long mTimesForLostProtect;
  private final float maxX0;
  private RectF[] previousRects;
  private boolean[] previousValid;
  private int smoothedWithinFrames;
  
  static
  {
    AppMethodBeat.i(82869);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SlimWaistVertexFilter.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SlimWaistFragmentFilter.dat");
    leftIndex = new int[] { 13, 14, 15, 16, 17 };
    rightIndex = new int[] { 41, 42, 43, 44, 45 };
    AppMethodBeat.o(82869);
  }
  
  public SlimWaistFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82862);
    this.mTimesForLostProtect = 2000L;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mHasSeenValid = false;
    this.T0 = 0.6F;
    this.maxX0 = 0.68F;
    this.previousValid = new boolean[] { 0, 0, 0, 0 };
    this.previousRects = new RectF[] { new RectF(0.0F, 0.0F, 0.0F, 0.0F), new RectF(0.0F, 0.0F, 0.0F, 0.0F), new RectF(0.0F, 0.0F, 0.0F, 0.0F), new RectF(0.0F, 0.0F, 0.0F, 0.0F) };
    this.smoothedWithinFrames = 2;
    this.currentIdx = 0;
    initParams();
    this.mCurrentRect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.mPreviousValidRect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(82862);
  }
  
  private RectF calculateRectPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(82867);
    int j = leftIndex.length;
    PointF localPointF = new PointF(0.0F, 0.0F);
    int i = 0;
    while (i < j)
    {
      f2 = localPointF.x;
      f3 = ((PointF)paramList.get(rightIndex[i])).x;
      localPointF.x = ((((PointF)paramList.get(leftIndex[i])).x + f3) / 2.0F + f2);
      f2 = localPointF.y;
      f3 = ((PointF)paramList.get(rightIndex[i])).y;
      localPointF.y = ((((PointF)paramList.get(leftIndex[i])).y + f3) / 2.0F + f2);
      f1 += ((PointF)paramList.get(rightIndex[i])).x - ((PointF)paramList.get(leftIndex[i])).x;
      i += 1;
    }
    localPointF.x /= j;
    localPointF.y /= j;
    float f4 = (float)(f1 / j * 1.9D);
    f1 = (float)(f4 * 0.7D);
    float f2 = (localPointF.x - f4 / 2.0F) / paramInt1;
    float f3 = (localPointF.y - f1 / 2.0F) / paramInt2;
    float f5 = localPointF.x;
    f4 = (f4 / 2.0F + f5) / paramInt1;
    f5 = localPointF.y;
    paramList = new RectF(f2, f3, f4, (f1 / 2.0F + f5) / paramInt2);
    AppMethodBeat.o(82867);
    return paramList;
  }
  
  private RectF getSmoothedRect()
  {
    AppMethodBeat.i(82868);
    RectF localRectF1 = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    int j = 0;
    int i = 0;
    float f1;
    float f2;
    if (j < this.smoothedWithinFrames)
    {
      if (this.previousValid[j] == 0) {
        break label179;
      }
      i += 1;
      RectF localRectF2 = this.previousRects[j];
      f1 = localRectF2.left;
      f2 = localRectF1.left;
      float f3 = localRectF2.right;
      float f4 = localRectF1.right;
      localRectF1.set(f1 + f2, localRectF2.top + localRectF1.top, f3 + f4, localRectF2.bottom + localRectF1.bottom);
    }
    label179:
    for (;;)
    {
      j += 1;
      break;
      f1 = localRectF1.left / i;
      f2 = localRectF1.right / i;
      localRectF1.set(f1, localRectF1.top / i, f2, localRectF1.bottom / i);
      AppMethodBeat.o(82868);
      return localRectF1;
    }
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82863);
    addParam(new m.f("t0", 0.6F));
    addParam(new m.f("maxPoint", 0.68F));
    addParam(new m.i("showMark", 0));
    addParam(new m.f("top", 0.32F));
    addParam(new m.f("bottom", 0.61F));
    addParam(new m.f("left", 0.38F));
    addParam(new m.f("right", 0.76F));
    AppMethodBeat.o(82863);
  }
  
  public void setStatusReset()
  {
    AppMethodBeat.i(82865);
    this.mHasSeenValid = false;
    this.mPreviousValidRect = null;
    this.currentIdx = 0;
    int i = 0;
    while (i < this.smoothedWithinFrames)
    {
      this.previousValid[i] = false;
      this.previousRects[i].set(0.0F, 0.0F, 0.0F, 0.0F);
      i += 1;
    }
    AppMethodBeat.o(82865);
  }
  
  public void setStrength(float paramFloat)
  {
    AppMethodBeat.i(82864);
    addParam(new m.f("maxPoint", 0.6F * (1.0F - paramFloat) + 0.68F * paramFloat));
    AppMethodBeat.o(82864);
  }
  
  public boolean setWaistRectangle(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(82866);
    this.currentIdx = ((this.currentIdx + 1) % this.smoothedWithinFrames);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.previousValid[this.currentIdx] = false;
      if ((!this.mHasSeenValid) || (System.currentTimeMillis() - this.mPreviousLostTime >= this.mTimesForLostProtect)) {
        break label229;
      }
      this.mCurrentRect = this.mPreviousValidRect;
    }
    for (;;)
    {
      if (bool)
      {
        addParam(new m.f("top", this.mCurrentRect.top));
        addParam(new m.f("bottom", this.mCurrentRect.bottom));
        addParam(new m.f("left", this.mCurrentRect.left));
        addParam(new m.f("right", this.mCurrentRect.right));
      }
      AppMethodBeat.o(82866);
      return bool;
      this.mHasSeenValid = true;
      paramList = calculateRectPoints(paramList, paramInt1, paramInt2);
      this.previousValid[this.currentIdx] = true;
      this.previousRects[this.currentIdx] = paramList;
      this.mCurrentRect = getSmoothedRect();
      this.mPreviousValidRect = getSmoothedRect();
      this.mPreviousLostTime = System.currentTimeMillis();
      continue;
      label229:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.SlimWaistFilter
 * JD-Core Version:    0.7.0.1
 */
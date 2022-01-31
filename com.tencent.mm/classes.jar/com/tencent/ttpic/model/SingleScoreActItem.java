package com.tencent.ttpic.model;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import java.util.ArrayList;
import java.util.List;

public class SingleScoreActItem
  extends FrameSourceItem
{
  private static final String TAG;
  private SizeI bitSize;
  protected CaptureActItem captureActItem;
  
  static
  {
    AppMethodBeat.i(83523);
    TAG = SingleScoreActItem.class.getSimpleName();
    AppMethodBeat.o(83523);
  }
  
  public SingleScoreActItem(CaptureActItem paramCaptureActItem, BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
    AppMethodBeat.i(83517);
    this.bitSize = new SizeI(130, 170);
    this.captureActItem = paramCaptureActItem;
    AppMethodBeat.o(83517);
  }
  
  private List<Integer> getBitList(int paramInt)
  {
    AppMethodBeat.i(83521);
    ArrayList localArrayList = new ArrayList();
    while (paramInt > 0)
    {
      localArrayList.add(0, Integer.valueOf(paramInt % 10));
      paramInt /= 10;
    }
    if (localArrayList.isEmpty()) {
      localArrayList.add(Integer.valueOf(0));
    }
    AppMethodBeat.o(83521);
    return localArrayList;
  }
  
  private void updateNumPosition(BaseFilter paramBaseFilter, CanvasItem paramCanvasItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(83522);
    float f = paramCanvasItem.itemRect.height * 1.0F / this.bitSize.height;
    int i = (int)(this.bitSize.width * f);
    int j = (int)(f * this.bitSize.height);
    int k = (paramCanvasItem.itemRect.width - paramInt2 * i) / 2;
    paramInt2 = paramCanvasItem.itemRect.y + j;
    paramInt1 = paramCanvasItem.itemRect.x + i * paramInt1 + k;
    paramBaseFilter.setPositions(AlgoUtils.calPositions(paramInt1, paramInt2, i + paramInt1, paramInt2 - j, paramInt3, paramInt4));
    AppMethodBeat.o(83522);
  }
  
  public void clear() {}
  
  public void draw(h paramh, CanvasItem paramCanvasItem, long paramLong)
  {
    AppMethodBeat.i(83518);
    BenchUtil.benchStart(getClass().getSimpleName() + "[draw]");
    List localList = getBitList(getScore(paramCanvasItem));
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      int k = ((Integer)localList.get(i)).intValue();
      BenchUtil.benchStart(getClass().getSimpleName() + "[draw] updatePosition");
      updateNumPosition(this.filter, paramCanvasItem, i, j, paramh.width, paramh.height);
      BenchUtil.benchEnd(getClass().getSimpleName() + "[draw] updatePosition");
      BenchUtil.benchStart(getClass().getSimpleName() + "[draw] renderTexture");
      this.filter.OnDrawFrameGLSL();
      this.filter.renderTexture(getScoreTexture(paramCanvasItem)[k], paramh.width, paramh.height);
      BenchUtil.benchEnd(getClass().getSimpleName() + "[draw] renderTexture");
      i += 1;
    }
    BenchUtil.benchEnd(getClass().getSimpleName() + "[draw]");
    AppMethodBeat.o(83518);
  }
  
  public int getOrigHeight(int paramInt)
  {
    return -1;
  }
  
  public int getOrigWidth(int paramInt)
  {
    return -1;
  }
  
  protected int getScore(CanvasItem paramCanvasItem)
  {
    AppMethodBeat.i(83519);
    int i = this.captureActItem.getScore(paramCanvasItem);
    AppMethodBeat.o(83519);
    return i;
  }
  
  protected int[] getScoreTexture(CanvasItem paramCanvasItem)
  {
    AppMethodBeat.i(83520);
    paramCanvasItem = this.captureActItem.getScoreTexture(paramCanvasItem);
    AppMethodBeat.o(83520);
    return paramCanvasItem;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return -1;
  }
  
  public void init() {}
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.model.SingleScoreActItem
 * JD-Core Version:    0.7.0.1
 */
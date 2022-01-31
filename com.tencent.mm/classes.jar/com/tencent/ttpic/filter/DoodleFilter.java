package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DoodleFilter
  extends VideoFilterBase
{
  private List<List<PointF>> list = new ArrayList();
  
  public DoodleFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.DOODLE);
  }
  
  public void initAttribParams()
  {
    setPositions(null);
  }
  
  public void initParams() {}
  
  public void renderProcess()
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      setPositions(VideoMaterialUtil.toFlatArray(localList));
      OnDrawFrameGLSL();
      GLES20.glLineWidth(10.0F);
      GLES20.glDrawArrays(3, 0, localList.size());
    }
    GLES20.glFlush();
  }
  
  public void setTouchPoints(List<List<PointF>> paramList1, List<List<PointF>> paramList2, int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramList1 == null) || (paramList1.size() == 0)) {
      this.list.clear();
    }
    for (;;)
    {
      return;
      this.list = new ArrayList(paramList2.size());
      paramList1 = (PointF)((List)paramList1.get(0)).get(86);
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        Object localObject = (List)paramList2.next();
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PointF localPointF = (PointF)((Iterator)localObject).next();
          localArrayList.add(new PointF((localPointF.x + paramList1.x / paramFloat) / paramInt1 * 2.0F - 1.0F, -((localPointF.y + paramList1.y / paramFloat) / paramInt2 * 2.0F - 1.0F)));
        }
        this.list.add(localArrayList);
      }
    }
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.DoodleFilter
 * JD-Core Version:    0.7.0.1
 */
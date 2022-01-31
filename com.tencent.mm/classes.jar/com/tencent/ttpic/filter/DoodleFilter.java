package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoodleFilter
  extends VideoFilterBase
{
  private List<List<PointF>> list;
  
  public DoodleFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.DOODLE);
    AppMethodBeat.i(82154);
    this.list = new ArrayList();
    AppMethodBeat.o(82154);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82156);
    setPositions(null);
    AppMethodBeat.o(82156);
  }
  
  public void initParams() {}
  
  public void renderProcess()
  {
    AppMethodBeat.i(82157);
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
    AppMethodBeat.o(82157);
  }
  
  public void setTouchPoints(List<List<PointF>> paramList1, List<List<PointF>> paramList2, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(82155);
    if ((paramList1 == null) || (paramList1.size() == 0))
    {
      this.list.clear();
      AppMethodBeat.o(82155);
      return;
    }
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
    AppMethodBeat.o(82155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.DoodleFilter
 * JD-Core Version:    0.7.0.1
 */
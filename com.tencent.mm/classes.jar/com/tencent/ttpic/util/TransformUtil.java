package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterial;
import java.util.ArrayList;
import java.util.List;

public class TransformUtil
{
  public static List<PointF> getFullPoints(List<PointF> paramList)
  {
    AppMethodBeat.i(83977);
    if ((paramList == null) || (paramList.size() < 90))
    {
      paramList = new ArrayList();
      AppMethodBeat.o(83977);
      return paramList;
    }
    while (paramList.size() > 90) {
      paramList.remove(paramList.size() - 1);
    }
    float f1 = ((PointF)paramList.get(57)).x;
    float f2 = ((PointF)paramList.get(58)).x;
    float f3 = ((PointF)paramList.get(57)).y;
    paramList.add(new PointF((f2 + f1) * 0.5F, (((PointF)paramList.get(58)).y + f3) * 0.5F));
    f1 = ((PointF)paramList.get(60)).x;
    f2 = ((PointF)paramList.get(61)).x;
    f3 = ((PointF)paramList.get(60)).y;
    paramList.add(new PointF((f2 + f1) * 0.5F, (((PointF)paramList.get(61)).y + f3) * 0.5F));
    f1 = ((PointF)paramList.get(2)).x;
    f2 = ((PointF)paramList.get(3)).x;
    f1 = (((PointF)paramList.get(57)).x + (f1 + f2)) / 3.0F;
    f2 = ((PointF)paramList.get(2)).y;
    f3 = ((PointF)paramList.get(3)).y;
    paramList.add(new PointF(f1, (((PointF)paramList.get(57)).y + (f2 + f3)) / 3.0F));
    f1 = ((PointF)paramList.get(16)).x;
    f2 = ((PointF)paramList.get(15)).x;
    f1 = (((PointF)paramList.get(61)).x + (f1 + f2)) / 3.0F;
    f2 = ((PointF)paramList.get(16)).y;
    f3 = ((PointF)paramList.get(15)).y;
    paramList.add(new PointF(f1, (((PointF)paramList.get(61)).y + (f2 + f3)) / 3.0F));
    f1 = ((PointF)paramList.get(73)).x;
    f1 = (((PointF)paramList.get(81)).x + f1) / 2.0F;
    f2 = ((PointF)paramList.get(73)).y;
    paramList.add(new PointF(f1, (((PointF)paramList.get(81)).y + f2) / 2.0F));
    AppMethodBeat.o(83977);
    return paramList;
  }
  
  public static boolean isTransformMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83978);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(83978);
      return false;
    }
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value))
    {
      AppMethodBeat.o(83978);
      return true;
    }
    AppMethodBeat.o(83978);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.util.TransformUtil
 * JD-Core Version:    0.7.0.1
 */
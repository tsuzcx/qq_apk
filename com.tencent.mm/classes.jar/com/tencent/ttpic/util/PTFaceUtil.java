package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.PTFaceAttr.PTFace;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PTFaceUtil
{
  public static List<float[]> getAllFaceAngles(List<PTFaceAttr.PTFace> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (VideoUtil.isEmpty(paramList)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((PTFaceAttr.PTFace)paramList.next()).getFaceAngle());
    }
    return localArrayList;
  }
  
  public static List<List<PointF>> getAllFaces(List<PTFaceAttr.PTFace> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (VideoUtil.isEmpty(paramList)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((PTFaceAttr.PTFace)paramList.next()).getFacePoints());
    }
    return localArrayList;
  }
  
  public static Set<Integer> getTriggeredExpression(Map<PTFaceAttr.PTExpression, Boolean> paramMap)
  {
    HashSet localHashSet = new HashSet();
    if (paramMap == null) {
      return localHashSet;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localHashSet.add(Integer.valueOf(((PTFaceAttr.PTExpression)localEntry.getKey()).value));
      }
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.PTFaceUtil
 * JD-Core Version:    0.7.0.1
 */
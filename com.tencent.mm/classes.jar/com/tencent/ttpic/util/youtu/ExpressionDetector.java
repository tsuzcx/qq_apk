package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceInfo;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoMaterialUtil.EXPRESSION_TYPE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ExpressionDetector
{
  private static final int FACE_QUEUE_MAX_SIZE = 30;
  private static final String TAG;
  private static ThreadLocal<ExpressionDetector> mInstance;
  private List<LinkedList<FaceInfo>> mFaceQueueList;
  
  static
  {
    AppMethodBeat.i(84347);
    TAG = ExpressionDetector.class.getSimpleName();
    mInstance = new ExpressionDetector.1();
    AppMethodBeat.o(84347);
  }
  
  ExpressionDetector()
  {
    AppMethodBeat.i(84319);
    this.mFaceQueueList = new ArrayList();
    AppMethodBeat.o(84319);
  }
  
  private double calDistanceSquare(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(84328);
    double d1 = Math.pow(paramPointF1.x - paramPointF2.x, 2.0D);
    double d2 = Math.pow(paramPointF1.y - paramPointF2.y, 2.0D);
    AppMethodBeat.o(84328);
    return d1 + d2;
  }
  
  private double calcDistanceOfFeaturePoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(84344);
    double d = Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
    AppMethodBeat.o(84344);
    return d;
  }
  
  private void clearFaceQueue(int paramInt)
  {
    AppMethodBeat.i(84346);
    if (paramInt < this.mFaceQueueList.size()) {
      while (((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1) {
        ((LinkedList)this.mFaceQueueList.get(paramInt)).removeLast();
      }
    }
    AppMethodBeat.o(84346);
  }
  
  public static ExpressionDetector getInstance()
  {
    AppMethodBeat.i(84318);
    ExpressionDetector localExpressionDetector = (ExpressionDetector)mInstance.get();
    AppMethodBeat.o(84318);
    return localExpressionDetector;
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84329);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionDistanceChangeDetected(i, paramInt1, paramInt2))
      {
        AppMethodBeat.o(84329);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84329);
    return false;
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(84330);
    if ((paramInt1 < 0) || (paramInt1 >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt1)).isEmpty()))
    {
      AppMethodBeat.o(84330);
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt1)).getFirst();
    double d = calDistanceSquare((PointF)((FaceInfo)localObject).points.get(paramInt2), (PointF)((FaceInfo)localObject).points.get(paramInt3));
    localObject = ((LinkedList)this.mFaceQueueList.get(paramInt1)).iterator();
    FaceInfo localFaceInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localFaceInfo = (FaceInfo)((Iterator)localObject).next();
    } while (d / calDistanceSquare((PointF)localFaceInfo.points.get(paramInt2), (PointF)localFaceInfo.points.get(paramInt3)) >= 0.5D);
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(84330);
      return bool;
    }
  }
  
  private boolean isExpressionJumpEyebrowDetected()
  {
    AppMethodBeat.i(84324);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionJumpEyebrowDetected(i))
      {
        AppMethodBeat.o(84324);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84324);
    return false;
  }
  
  private boolean isExpressionJumpEyebrowDetected(int paramInt)
  {
    AppMethodBeat.i(84325);
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()))
    {
      AppMethodBeat.o(84325);
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    double d = AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(26), (PointF)((FaceInfo)localObject).points.get(64)) / AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(24), (PointF)((FaceInfo)localObject).points.get(64));
    localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
    ((ListIterator)localObject).next();
    FaceInfo localFaceInfo;
    do
    {
      if (!((ListIterator)localObject).hasNext()) {
        break;
      }
      localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
    } while (1.04D * d > AlgoUtils.getDistance((PointF)localFaceInfo.points.get(26), (PointF)localFaceInfo.points.get(64)) / AlgoUtils.getDistance((PointF)localFaceInfo.points.get(24), (PointF)localFaceInfo.points.get(64)));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(84325);
      return bool;
    }
  }
  
  private boolean isExpressionJumpEyebrowDetectedForAtLeastOneFace()
  {
    AppMethodBeat.i(84342);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionJumpEyebrowDetected(i))
      {
        AppMethodBeat.o(84342);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84342);
    return false;
  }
  
  private boolean isExpressionKissDetected()
  {
    AppMethodBeat.i(84339);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionKissDetected(i))
      {
        AppMethodBeat.o(84339);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84339);
    return false;
  }
  
  private boolean isExpressionKissDetected(int paramInt)
  {
    AppMethodBeat.i(84340);
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()))
    {
      AppMethodBeat.o(84340);
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    if (AlgoUtils.getDistance((PointF)localFaceInfo.points.get(77), (PointF)localFaceInfo.points.get(69)) / AlgoUtils.getDistance((PointF)localFaceInfo.points.get(65), (PointF)localFaceInfo.points.get(66)) >= 0.55F)
    {
      AppMethodBeat.o(84340);
      return true;
    }
    AppMethodBeat.o(84340);
    return false;
  }
  
  private boolean isExpressionLeftEyeWinkDetected()
  {
    AppMethodBeat.i(84332);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionDistanceChangeDetected(i, 47, 51))
      {
        AppMethodBeat.o(84332);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84332);
    return false;
  }
  
  private boolean isExpressionNodDetected()
  {
    AppMethodBeat.i(84333);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionNodDetected(i))
      {
        AppMethodBeat.o(84333);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84333);
    return false;
  }
  
  private boolean isExpressionNodDetected(int paramInt)
  {
    AppMethodBeat.i(84334);
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()))
    {
      AppMethodBeat.o(84334);
      return false;
    }
    float f1 = 100.0F;
    float f2 = (float)(((FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst()).angles[0] * 180.0F / 3.141592653589793D);
    Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
    if (localIterator.hasNext())
    {
      f1 = Math.min(f1, (float)(((FaceInfo)localIterator.next()).angles[0] * 180.0F / 3.141592653589793D));
      if (f2 - f1 <= 5.0F) {}
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(84334);
      return bool;
      break;
    }
  }
  
  private boolean isExpressionOpenMouthDetected()
  {
    AppMethodBeat.i(84322);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionOpenMouthDetected(i))
      {
        AppMethodBeat.o(84322);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84322);
    return false;
  }
  
  private boolean isExpressionOpenMouthDetected(int paramInt)
  {
    AppMethodBeat.i(84323);
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()))
    {
      AppMethodBeat.o(84323);
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    double d = AlgoUtils.getDistance((PointF)localFaceInfo.points.get(65), (PointF)localFaceInfo.points.get(66));
    if (AlgoUtils.getDistance((PointF)localFaceInfo.points.get(73), (PointF)localFaceInfo.points.get(81)) > d * 0.2D)
    {
      AppMethodBeat.o(84323);
      return true;
    }
    AppMethodBeat.o(84323);
    return false;
  }
  
  private boolean isExpressionOpenMouthDetectedForAtLeastOneFace()
  {
    AppMethodBeat.i(84341);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionOpenMouthDetected(i))
      {
        AppMethodBeat.o(84341);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84341);
    return false;
  }
  
  private boolean isExpressionRightEyeWinkDetected()
  {
    AppMethodBeat.i(84331);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionDistanceChangeDetected(i, 37, 41))
      {
        AppMethodBeat.o(84331);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84331);
    return false;
  }
  
  private boolean isExpressionShakeHeadDetected()
  {
    AppMethodBeat.i(84335);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionShakeHeadDetected(i))
      {
        AppMethodBeat.o(84335);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84335);
    return false;
  }
  
  private boolean isExpressionShakeHeadDetected(int paramInt)
  {
    AppMethodBeat.i(84336);
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()))
    {
      AppMethodBeat.o(84336);
      return false;
    }
    float f2 = 100.0F;
    float f1 = -100.0F;
    Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
    if (localIterator.hasNext())
    {
      float f3 = (float)(((FaceInfo)localIterator.next()).angles[1] * 180.0F / 3.141592653589793D);
      f2 = Math.min(f2, f3);
      f1 = Math.max(f1, f3);
      if (f1 - f2 <= 7.0F) {}
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(84336);
      return bool;
      break;
    }
  }
  
  private boolean isExpressionShookHeadDetected()
  {
    AppMethodBeat.i(84337);
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionShookHeadDetected(i))
      {
        AppMethodBeat.o(84337);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(84337);
    return false;
  }
  
  private boolean isExpressionShookHeadDetected(int paramInt)
  {
    AppMethodBeat.i(84338);
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()))
    {
      AppMethodBeat.o(84338);
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    if ((((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1) && (AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(2), (PointF)((FaceInfo)localObject).points.get(64)) * 0.7F > AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(64), (PointF)((FaceInfo)localObject).points.get(16))))
    {
      localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
      ((ListIterator)localObject).next();
      FaceInfo localFaceInfo;
      do
      {
        if (!((ListIterator)localObject).hasNext()) {
          break;
        }
        localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
      } while (AlgoUtils.getDistance((PointF)localFaceInfo.points.get(64), (PointF)localFaceInfo.points.get(16)) * 0.7F <= AlgoUtils.getDistance((PointF)localFaceInfo.points.get(2), (PointF)localFaceInfo.points.get(64)));
    }
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(84338);
      return bool;
    }
  }
  
  private boolean isFaceDetected()
  {
    AppMethodBeat.i(84343);
    if (!this.mFaceQueueList.isEmpty())
    {
      AppMethodBeat.o(84343);
      return true;
    }
    AppMethodBeat.o(84343);
    return false;
  }
  
  public static boolean needSaveDetectedExpression(int paramInt)
  {
    return (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.JUMP_EYE_BROW.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.WINK.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.SHOOK_HEAD.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.RIGHT_EYE_WINK.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.LEFT_EYE_WINK.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.NOD.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.SHAKE_HEAD.value);
  }
  
  private float pointPairToBearingDegrees(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(84326);
    paramPointF1 = new PointF(paramPointF2.x - paramPointF1.x, paramPointF2.y - paramPointF1.y);
    float f = (float)((float)Math.atan2(paramPointF1.y, paramPointF1.x) * 57.295779513082323D);
    if (f > 0.0F)
    {
      AppMethodBeat.o(84326);
      return f;
    }
    AppMethodBeat.o(84326);
    return f + 360.0F;
  }
  
  private PointF pointSub(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(84327);
    paramPointF1 = new PointF(paramPointF1.x - paramPointF2.x, paramPointF1.y - paramPointF2.y);
    AppMethodBeat.o(84327);
    return paramPointF1;
  }
  
  public void addFaces(List<FaceInfo> paramList)
  {
    AppMethodBeat.i(84320);
    if (paramList == null)
    {
      this.mFaceQueueList.clear();
      AppMethodBeat.o(84320);
      return;
    }
    if (paramList.size() != this.mFaceQueueList.size()) {
      this.mFaceQueueList.clear();
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (i == this.mFaceQueueList.size()) {
        this.mFaceQueueList.add(new LinkedList());
      }
      LinkedList localLinkedList = (LinkedList)this.mFaceQueueList.get(i);
      if (localLinkedList.size() > 30) {
        localLinkedList.removeLast();
      }
      localLinkedList.addFirst(paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(84320);
  }
  
  public void clearFaceQueue()
  {
    AppMethodBeat.i(84345);
    Iterator localIterator = this.mFaceQueueList.iterator();
    while (localIterator.hasNext())
    {
      LinkedList localLinkedList = (LinkedList)localIterator.next();
      while (localLinkedList.size() > 1) {
        localLinkedList.removeLast();
      }
    }
    AppMethodBeat.o(84345);
  }
  
  public boolean detectExpression(int paramInt)
  {
    AppMethodBeat.i(84321);
    boolean bool;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(84321);
      return false;
    case 1: 
      AppMethodBeat.o(84321);
      return true;
    case 2: 
      bool = isFaceDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 3: 
      bool = isExpressionOpenMouthDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 4: 
      bool = isExpressionJumpEyebrowDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 5: 
      bool = isExpressionRightEyeWinkDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 6: 
      bool = isExpressionShakeHeadDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 7: 
      bool = isExpressionKissDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 8: 
      bool = isExpressionLeftEyeWinkDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 9: 
      bool = isExpressionRightEyeWinkDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 10: 
      bool = isExpressionNodDetected();
      AppMethodBeat.o(84321);
      return bool;
    case 103: 
      if ((isFaceDetected()) && (!isExpressionOpenMouthDetected()))
      {
        AppMethodBeat.o(84321);
        return true;
      }
      AppMethodBeat.o(84321);
      return false;
    case 104: 
      if ((isFaceDetected()) && (!isExpressionJumpEyebrowDetected()))
      {
        AppMethodBeat.o(84321);
        return true;
      }
      AppMethodBeat.o(84321);
      return false;
    case 106: 
      if ((isFaceDetected()) && (!isExpressionShookHeadDetected()))
      {
        AppMethodBeat.o(84321);
        return true;
      }
      AppMethodBeat.o(84321);
      return false;
    case 107: 
      if ((isFaceDetected()) && (!isExpressionKissDetected()))
      {
        AppMethodBeat.o(84321);
        return true;
      }
      AppMethodBeat.o(84321);
      return false;
    case 108: 
      if ((isFaceDetected()) && (!isExpressionLeftEyeWinkDetected()))
      {
        AppMethodBeat.o(84321);
        return true;
      }
      AppMethodBeat.o(84321);
      return false;
    case 109: 
      if ((isFaceDetected()) && (!isExpressionLeftEyeWinkDetected()))
      {
        AppMethodBeat.o(84321);
        return true;
      }
      AppMethodBeat.o(84321);
      return false;
    }
    if ((isFaceDetected()) && (!isExpressionNodDetected()))
    {
      AppMethodBeat.o(84321);
      return true;
    }
    AppMethodBeat.o(84321);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.ExpressionDetector
 * JD-Core Version:    0.7.0.1
 */
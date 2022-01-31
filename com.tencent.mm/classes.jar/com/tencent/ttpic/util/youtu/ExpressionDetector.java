package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
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
  private static final String TAG = ExpressionDetector.class.getSimpleName();
  private static ExpressionDetector mInstance;
  private List<LinkedList<FaceInfo>> mFaceQueueList = new ArrayList();
  
  private double calDistanceSquare(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.pow(paramPointF1.x - paramPointF2.x, 2.0D) + Math.pow(paramPointF1.y - paramPointF2.y, 2.0D);
  }
  
  private double calcDistanceOfFeaturePoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
  }
  
  private void clearFaceQueue(int paramInt)
  {
    if (paramInt < this.mFaceQueueList.size()) {
      while (((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1) {
        ((LinkedList)this.mFaceQueueList.get(paramInt)).removeLast();
      }
    }
  }
  
  public static ExpressionDetector getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new ExpressionDetector();
      }
      ExpressionDetector localExpressionDetector = mInstance;
      return localExpressionDetector;
    }
    finally {}
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionDistanceChangeDetected(i, paramInt1, paramInt2)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt1)).isEmpty())) {
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt1)).getFirst();
    double d = calDistanceSquare((PointF)((FaceInfo)localObject).points.get(paramInt2), (PointF)((FaceInfo)localObject).points.get(paramInt3));
    localObject = ((LinkedList)this.mFaceQueueList.get(paramInt1)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)((Iterator)localObject).next();
      if (d / calDistanceSquare((PointF)localFaceInfo.points.get(paramInt2), (PointF)localFaceInfo.points.get(paramInt3)) < 0.5D) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionJumpEyebrowDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionJumpEyebrowDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionJumpEyebrowDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    double d = AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(26), (PointF)((FaceInfo)localObject).points.get(64)) / AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(24), (PointF)((FaceInfo)localObject).points.get(64));
    localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
    ((ListIterator)localObject).next();
    while (((ListIterator)localObject).hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
      if (1.04D * d <= AlgoUtils.getDistance((PointF)localFaceInfo.points.get(26), (PointF)localFaceInfo.points.get(64)) / AlgoUtils.getDistance((PointF)localFaceInfo.points.get(24), (PointF)localFaceInfo.points.get(64))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionJumpEyebrowDetectedForAtLeastOneFace()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionJumpEyebrowDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionKissDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionKissDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionKissDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    return AlgoUtils.getDistance((PointF)localFaceInfo.points.get(77), (PointF)localFaceInfo.points.get(69)) / AlgoUtils.getDistance((PointF)localFaceInfo.points.get(65), (PointF)localFaceInfo.points.get(66)) >= 0.55F;
  }
  
  private boolean isExpressionLeftEyeWinkDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionDistanceChangeDetected(i, 47, 51)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionNodDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionNodDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionNodDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    float f1 = 100.0F;
    float f2 = (float)(((FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst()).angles[0] * 180.0F / 3.141592653589793D);
    Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
    while (localIterator.hasNext())
    {
      f1 = Math.min(f1, (float)(((FaceInfo)localIterator.next()).angles[0] * 180.0F / 3.141592653589793D));
      if (f2 - f1 > 5.0F) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionOpenMouthDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionOpenMouthDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionOpenMouthDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    double d = AlgoUtils.getDistance((PointF)localFaceInfo.points.get(65), (PointF)localFaceInfo.points.get(66));
    return AlgoUtils.getDistance((PointF)localFaceInfo.points.get(73), (PointF)localFaceInfo.points.get(81)) > d * 0.2D;
  }
  
  private boolean isExpressionOpenMouthDetectedForAtLeastOneFace()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionOpenMouthDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionRightEyeWinkDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionDistanceChangeDetected(i, 37, 41)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionShakeHeadDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionShakeHeadDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionShakeHeadDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    float f2 = 100.0F;
    float f1 = -100.0F;
    Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
    while (localIterator.hasNext())
    {
      float f3 = (float)(((FaceInfo)localIterator.next()).angles[1] * 180.0F / 3.141592653589793D);
      f2 = Math.min(f2, f3);
      f1 = Math.max(f1, f3);
      if (f1 - f2 > 7.0F) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionShookHeadDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionShookHeadDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionShookHeadDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    if ((((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1) && (AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(2), (PointF)((FaceInfo)localObject).points.get(64)) * 0.7F > AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(64), (PointF)((FaceInfo)localObject).points.get(16))))
    {
      localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
      ((ListIterator)localObject).next();
      while (((ListIterator)localObject).hasNext())
      {
        FaceInfo localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
        if (AlgoUtils.getDistance((PointF)localFaceInfo.points.get(64), (PointF)localFaceInfo.points.get(16)) * 0.7F > AlgoUtils.getDistance((PointF)localFaceInfo.points.get(2), (PointF)localFaceInfo.points.get(64))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean isFaceDetected()
  {
    return !this.mFaceQueueList.isEmpty();
  }
  
  public static boolean needSaveDetectedExpression(int paramInt)
  {
    return (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.JUMP_EYE_BROW.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.WINK.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.SHOOK_HEAD.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.RIGHT_EYE_WINK.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.LEFT_EYE_WINK.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.NOD.value) || (paramInt == VideoMaterialUtil.EXPRESSION_TYPE.SHAKE_HEAD.value);
  }
  
  private float pointPairToBearingDegrees(PointF paramPointF1, PointF paramPointF2)
  {
    paramPointF1 = new PointF(paramPointF2.x - paramPointF1.x, paramPointF2.y - paramPointF1.y);
    float f = (float)((float)Math.atan2(paramPointF1.y, paramPointF1.x) * 57.295779513082323D);
    if (f > 0.0F) {
      return f;
    }
    return f + 360.0F;
  }
  
  private PointF pointSub(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x - paramPointF2.x, paramPointF1.y - paramPointF2.y);
  }
  
  public void addFaces(List<FaceInfo> paramList)
  {
    if (paramList == null) {
      this.mFaceQueueList.clear();
    }
    for (;;)
    {
      return;
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
    }
  }
  
  public void clearFaceQueue()
  {
    Iterator localIterator = this.mFaceQueueList.iterator();
    while (localIterator.hasNext())
    {
      LinkedList localLinkedList = (LinkedList)localIterator.next();
      while (localLinkedList.size() > 1) {
        localLinkedList.removeLast();
      }
    }
  }
  
  public boolean detectExpression(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  return isFaceDetected();
                  return isExpressionOpenMouthDetected();
                  return isExpressionJumpEyebrowDetected();
                  return isExpressionRightEyeWinkDetected();
                  return isExpressionShakeHeadDetected();
                  return isExpressionKissDetected();
                  return isExpressionLeftEyeWinkDetected();
                  return isExpressionRightEyeWinkDetected();
                  return isExpressionNodDetected();
                  if (!isFaceDetected()) {
                    break;
                  }
                  bool1 = bool2;
                } while (!isExpressionOpenMouthDetected());
                return false;
                if (!isFaceDetected()) {
                  break;
                }
                bool1 = bool2;
              } while (!isExpressionJumpEyebrowDetected());
              return false;
              if (!isFaceDetected()) {
                break;
              }
              bool1 = bool2;
            } while (!isExpressionShookHeadDetected());
            return false;
            if (!isFaceDetected()) {
              break;
            }
            bool1 = bool2;
          } while (!isExpressionKissDetected());
          return false;
          if (!isFaceDetected()) {
            break;
          }
          bool1 = bool2;
        } while (!isExpressionLeftEyeWinkDetected());
        return false;
        if (!isFaceDetected()) {
          break;
        }
        bool1 = bool2;
      } while (!isExpressionLeftEyeWinkDetected());
      return false;
      if (!isFaceDetected()) {
        break;
      }
      bool1 = bool2;
    } while (!isExpressionNodDetected());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.ExpressionDetector
 * JD-Core Version:    0.7.0.1
 */
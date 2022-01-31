package com.tencent.ttpic.facedetect;

import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public enum FaceDetectorManager
{
  INSTANCE;
  
  private FaceDetector mCurFaceDetector;
  private Map<FaceDetectorManager.FACE_DET_TYPE, FaceDetector> map = new HashMap();
  
  private FaceDetectorManager()
  {
    this.map.put(FaceDetectorManager.FACE_DET_TYPE.YOUTU, VideoPreviewFaceOutlineDetector.getInstance());
  }
  
  public static FaceDetectorManager getInstance()
  {
    return INSTANCE;
  }
  
  public final void destroy()
  {
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext()) {
      ((FaceDetector)localIterator.next()).destroy();
    }
    RetrieveDataManager.getInstance().clear();
  }
  
  public final FaceDetector getCurrentFaceDetector()
  {
    if (this.mCurFaceDetector == null) {
      this.mCurFaceDetector = ((FaceDetector)this.map.get(FaceDetectorManager.FACE_DET_TYPE.YOUTU));
    }
    return this.mCurFaceDetector;
  }
  
  public final FaceDetector getFaceDetector(int paramInt)
  {
    FaceDetector localFaceDetector = null;
    Iterator localIterator = this.map.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((FaceDetectorManager.FACE_DET_TYPE)localEntry.getKey()).value != paramInt) {
        break label123;
      }
      localFaceDetector = (FaceDetector)localEntry.getValue();
    }
    label123:
    for (;;)
    {
      break;
      if (localFaceDetector == null) {
        localFaceDetector = (FaceDetector)this.map.get(FaceDetectorManager.FACE_DET_TYPE.YOUTU);
      }
      for (;;)
      {
        if ((this.mCurFaceDetector != null) && (localFaceDetector != this.mCurFaceDetector)) {
          this.mCurFaceDetector.destroy();
        }
        this.mCurFaceDetector = localFaceDetector;
        return this.mCurFaceDetector;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceDetectorManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum PTFaceDetector
{
  INSTANCE;
  
  public static float MINWIDTH = 360.0F;
  private int faceDetHeight;
  private int faceDetWidth;
  private byte[] mData;
  private VideoPreviewFaceOutlineDetector mFaceDetector = VideoPreviewFaceOutlineDetector.getInstance();
  
  private PTFaceDetector() {}
  
  private PTFaceAttr genFaceAttr(float paramFloat, byte[] paramArrayOfByte, List<List<PointF>> paramList, List<float[]> paramList1, Set<Integer> paramSet, boolean paramBoolean)
  {
    PTFaceAttr localPTFaceAttr = new PTFaceAttr();
    localPTFaceAttr.setFaceScale(paramFloat);
    localPTFaceAttr.setData(paramArrayOfByte);
    paramArrayOfByte = new ArrayList();
    int i = 0;
    PTFaceAttr.PTFace localPTFace;
    while (i < paramList.size())
    {
      localPTFace = new PTFaceAttr.PTFace();
      localPTFace.setFacePoints((List)paramList.get(i));
      localPTFace.setFaceAngle((float[])paramList1.get(i));
      paramArrayOfByte.add(localPTFace);
      i += 1;
    }
    paramList = new HashMap();
    paramList1 = PTFaceAttr.PTExpression.values();
    int j = paramList1.length;
    i = 0;
    if (i < j)
    {
      localPTFace = paramList1[i];
      if (paramSet.contains(Integer.valueOf(localPTFace.value))) {
        paramList.put(localPTFace, Boolean.valueOf(true));
      }
      for (;;)
      {
        i += 1;
        break;
        paramList.put(localPTFace, Boolean.valueOf(false));
      }
    }
    localPTFaceAttr.setFaceInfos(paramArrayOfByte);
    localPTFaceAttr.setFaceExpression(paramList);
    if (paramBoolean)
    {
      localPTFaceAttr.setHandPoints(null);
      localPTFaceAttr.setHandAngles(null);
    }
    return localPTFaceAttr;
  }
  
  public static PTFaceDetector getInstance()
  {
    return INSTANCE;
  }
  
  public final void destroy()
  {
    this.mFaceDetector.destroy();
    RetrieveDataManager.getInstance().clear();
  }
  
  public final PTFaceAttr detectImageBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mFaceDetector.init() != 0) {}
    while ((paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt1 * paramInt2 * 4)) {
      return null;
    }
    this.mFaceDetector.doFaceDetect(paramArrayOfByte, paramInt1, paramInt2);
    this.mFaceDetector.doTrack(paramArrayOfByte, paramInt1, paramInt2);
    return genFaceAttr(1.0F, paramArrayOfByte, this.mFaceDetector.getAllFaces(), this.mFaceDetector.getAllFaceAngles(), this.mFaceDetector.getTriggeredExpression(), paramBoolean);
  }
  
  public final PTFaceAttr detectVideoBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mFaceDetector.init() != 0) {}
    while ((paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt1 * paramInt2 * 4)) {
      return null;
    }
    this.mFaceDetector.doTrackByRGBA(paramArrayOfByte, paramInt1, paramInt2);
    return genFaceAttr(1.0F, paramArrayOfByte, this.mFaceDetector.getAllFaces(), this.mFaceDetector.getAllFaceAngles(), this.mFaceDetector.getTriggeredExpression(), paramBoolean);
  }
  
  /* Error */
  public final PTFaceAttr detectVideoTexture(int paramInt1, int paramInt2, int paramInt3, float paramFloat, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/ttpic/PTFaceDetector:mFaceDetector	Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;
    //   6: invokevirtual 162	com/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector:init	()I
    //   9: istore 6
    //   11: iload 6
    //   13: ifeq +11 -> 24
    //   16: aconst_null
    //   17: astore 7
    //   19: aload_0
    //   20: monitorexit
    //   21: aload 7
    //   23: areturn
    //   24: iload_2
    //   25: i2f
    //   26: fload 4
    //   28: fmul
    //   29: f2i
    //   30: istore_2
    //   31: aload_0
    //   32: iload_2
    //   33: putfield 190	com/tencent/ttpic/PTFaceDetector:faceDetWidth	I
    //   36: aload_0
    //   37: iload_3
    //   38: i2f
    //   39: fload 4
    //   41: fmul
    //   42: f2i
    //   43: putfield 192	com/tencent/ttpic/PTFaceDetector:faceDetHeight	I
    //   46: ldc 194
    //   48: invokestatic 200	com/tencent/ttpic/util/BenchUtil:benchStart	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 190	com/tencent/ttpic/PTFaceDetector:faceDetWidth	I
    //   55: aload_0
    //   56: getfield 192	com/tencent/ttpic/PTFaceDetector:faceDetHeight	I
    //   59: imul
    //   60: iconst_4
    //   61: imul
    //   62: istore_2
    //   63: aload_0
    //   64: getfield 202	com/tencent/ttpic/PTFaceDetector:mData	[B
    //   67: ifnull +12 -> 79
    //   70: iload_2
    //   71: aload_0
    //   72: getfield 202	com/tencent/ttpic/PTFaceDetector:mData	[B
    //   75: arraylength
    //   76: if_icmpeq +10 -> 86
    //   79: aload_0
    //   80: iload_2
    //   81: newarray byte
    //   83: putfield 202	com/tencent/ttpic/PTFaceDetector:mData	[B
    //   86: invokestatic 154	com/tencent/ttpic/util/RetrieveDataManager:getInstance	()Lcom/tencent/ttpic/util/RetrieveDataManager;
    //   89: getstatic 208	com/tencent/ttpic/util/RetrieveDataManager$DATA_TYPE:RGBA	Lcom/tencent/ttpic/util/RetrieveDataManager$DATA_TYPE;
    //   92: getfield 209	com/tencent/ttpic/util/RetrieveDataManager$DATA_TYPE:value	I
    //   95: iload_1
    //   96: aload_0
    //   97: getfield 190	com/tencent/ttpic/PTFaceDetector:faceDetWidth	I
    //   100: aload_0
    //   101: getfield 192	com/tencent/ttpic/PTFaceDetector:faceDetHeight	I
    //   104: aload_0
    //   105: getfield 202	com/tencent/ttpic/PTFaceDetector:mData	[B
    //   108: invokevirtual 213	com/tencent/ttpic/util/RetrieveDataManager:retrieveData	(IIII[B)Z
    //   111: pop
    //   112: ldc 194
    //   114: invokestatic 217	com/tencent/ttpic/util/BenchUtil:benchEnd	(Ljava/lang/String;)J
    //   117: pop2
    //   118: aload_0
    //   119: getfield 42	com/tencent/ttpic/PTFaceDetector:mFaceDetector	Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;
    //   122: aload_0
    //   123: getfield 202	com/tencent/ttpic/PTFaceDetector:mData	[B
    //   126: aload_0
    //   127: getfield 190	com/tencent/ttpic/PTFaceDetector:faceDetWidth	I
    //   130: aload_0
    //   131: getfield 192	com/tencent/ttpic/PTFaceDetector:faceDetHeight	I
    //   134: invokevirtual 186	com/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector:doTrackByRGBA	([BII)V
    //   137: aload_0
    //   138: fload 4
    //   140: aload_0
    //   141: getfield 202	com/tencent/ttpic/PTFaceDetector:mData	[B
    //   144: aload_0
    //   145: getfield 42	com/tencent/ttpic/PTFaceDetector:mFaceDetector	Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;
    //   148: invokevirtual 173	com/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector:getAllFaces	()Ljava/util/List;
    //   151: aload_0
    //   152: getfield 42	com/tencent/ttpic/PTFaceDetector:mFaceDetector	Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;
    //   155: invokevirtual 176	com/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector:getAllFaceAngles	()Ljava/util/List;
    //   158: aload_0
    //   159: getfield 42	com/tencent/ttpic/PTFaceDetector:mFaceDetector	Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;
    //   162: invokevirtual 180	com/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector:getTriggeredExpression	()Ljava/util/Set;
    //   165: iload 5
    //   167: invokespecial 182	com/tencent/ttpic/PTFaceDetector:genFaceAttr	(F[BLjava/util/List;Ljava/util/List;Ljava/util/Set;Z)Lcom/tencent/ttpic/PTFaceAttr;
    //   170: astore 7
    //   172: goto -153 -> 19
    //   175: astore 7
    //   177: aload_0
    //   178: monitorexit
    //   179: aload 7
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	PTFaceDetector
    //   0	182	1	paramInt1	int
    //   0	182	2	paramInt2	int
    //   0	182	3	paramInt3	int
    //   0	182	4	paramFloat	float
    //   0	182	5	paramBoolean	boolean
    //   9	3	6	i	int
    //   17	154	7	localPTFaceAttr	PTFaceAttr
    //   175	5	7	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	11	175	finally
    //   31	79	175	finally
    //   79	86	175	finally
    //   86	172	175	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.PTFaceDetector
 * JD-Core Version:    0.7.0.1
 */
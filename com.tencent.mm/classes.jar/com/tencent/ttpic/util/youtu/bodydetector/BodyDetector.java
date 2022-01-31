package com.tencent.ttpic.util.youtu.bodydetector;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.thread.FaceGestureDetGLThread.OnBodyDetListener;
import java.util.ArrayList;
import java.util.List;

public class BodyDetector
{
  private static int[] leftIndex;
  private static BodyDetector mInstance;
  private static int[] rightIndex;
  private final int DETECT_INTERVAL;
  private final int KEY_POINT_NUM_17;
  private final int KEY_POINT_NUM_59;
  boolean bodyDetected;
  private final Object dataLock;
  private Handler detectHandler;
  private int detectIndex;
  private float[] detector_confidence;
  private float[] detector_xmax;
  private float[] detector_xmin;
  private float[] detector_ymax;
  private float[] detector_ymin;
  private float[] fscore;
  private float[] fscore17;
  private volatile boolean inited;
  private boolean mHasRect;
  private float mPConfidence;
  private float mPxmax;
  private float mPxmin;
  private float mPymax;
  private float mPymin;
  private float[] ptX;
  private float[] ptX17;
  private float[] ptY;
  private float[] ptY17;
  
  static
  {
    AppMethodBeat.i(84427);
    leftIndex = new int[] { 13, 14, 15, 16, 17 };
    rightIndex = new int[] { 41, 42, 43, 44, 45 };
    if (FeatureManager.isBodyDetectionReady()) {
      try
      {
        if (Build.VERSION.SDK_INT <= 17) {
          System.load("/data/data/com.tencent.xnet/lib/libxnet.so");
        }
        for (;;)
        {
          FeatureManager.loadLibrary("bodydetector");
          AppMethodBeat.o(84427);
          return;
          FeatureManager.loadLibrary("xnet");
        }
        AppMethodBeat.o(84427);
      }
      catch (Exception localException)
      {
        LogUtils.e(localException);
      }
    }
  }
  
  public BodyDetector()
  {
    AppMethodBeat.i(84420);
    this.DETECT_INTERVAL = 10;
    this.KEY_POINT_NUM_59 = 59;
    this.KEY_POINT_NUM_17 = 17;
    this.detectIndex = 0;
    this.inited = false;
    this.ptX17 = new float[17];
    this.ptY17 = new float[17];
    this.fscore17 = new float[17];
    this.bodyDetected = false;
    this.dataLock = new Object();
    this.mHasRect = false;
    this.ptX = new float[59];
    this.ptY = new float[59];
    this.fscore = new float[59];
    this.detector_xmin = new float[59];
    this.detector_ymin = new float[59];
    this.detector_xmax = new float[59];
    this.detector_ymax = new float[59];
    this.detector_confidence = new float[59];
    AppMethodBeat.o(84420);
  }
  
  public static BodyDetector getInstance()
  {
    try
    {
      AppMethodBeat.i(84421);
      if (mInstance == null) {
        mInstance = new BodyDetector();
      }
      BodyDetector localBodyDetector = mInstance;
      AppMethodBeat.o(84421);
      return localBodyDetector;
    }
    finally {}
  }
  
  private void updatePreviousRect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int j = leftIndex.length;
    int i = 0;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f1 = 0.0F;
    while (i < j)
    {
      f4 = (paramArrayOfFloat1[rightIndex[i]] + paramArrayOfFloat1[leftIndex[i]]) / 2.0F;
      f2 += (paramArrayOfFloat2[rightIndex[i]] + paramArrayOfFloat2[leftIndex[i]]) / 2.0F;
      f1 += paramArrayOfFloat1[rightIndex[i]] - paramArrayOfFloat1[leftIndex[i]];
      i += 1;
      f3 = f4 + f3;
    }
    f3 /= j;
    f2 /= j;
    f1 = (float)(f1 / j * 1.5D);
    float f4 = 4.0F * f1;
    this.mPxmin = (f3 - f1 / 2.0F);
    this.mPxmax = (f3 + f1 / 2.0F);
    this.mPymin = (f2 - f4 / 2.0F);
    this.mPymax = (f4 / 2.0F + f2);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(84423);
    if (this.inited)
    {
      nativeDestroy();
      this.inited = false;
    }
    if (this.detectHandler != null) {
      this.detectHandler.getLooper().quit();
    }
    AppMethodBeat.o(84423);
  }
  
  public List<BodyDetectResult> detectBody(byte[] arg1, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(84424);
    ArrayList localArrayList = new ArrayList();
    if (!this.inited)
    {
      AppMethodBeat.o(84424);
      return localArrayList;
    }
    if (this.detectIndex % 10 == 0) {
      this.detectHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(84418);
          Object localObject2 = new float[59];
          float[] arrayOfFloat1 = new float[59];
          float[] arrayOfFloat2 = new float[59];
          BodyDetector.this.nativeDetectBody(paramArrayOfByte, paramInt1, paramInt2, (float[])localObject2, arrayOfFloat1, arrayOfFloat2, BodyDetector.this.ptX17, BodyDetector.this.ptY17, BodyDetector.this.fscore17, 59, 17, 2);
          for (;;)
          {
            synchronized (BodyDetector.this.dataLock)
            {
              System.arraycopy(localObject2, 0, BodyDetector.this.ptX, 0, 59);
              System.arraycopy(arrayOfFloat1, 0, BodyDetector.this.ptY, 0, 59);
              System.arraycopy(arrayOfFloat2, 0, BodyDetector.this.fscore, 0, 59);
              localObject2 = BodyDetector.this;
              if ((BodyDetector.this.fscore[15] <= 0.2D) || (BodyDetector.this.fscore[20] <= 0.2D)) {
                if ((BodyDetector.this.fscore[43] > 0.2D) && (BodyDetector.this.fscore[31] > 0.2D))
                {
                  break label238;
                  ((BodyDetector)localObject2).bodyDetected = bool;
                  AppMethodBeat.o(84418);
                }
                else
                {
                  bool = false;
                }
              }
            }
            label238:
            boolean bool = true;
          }
        }
      });
    }
    synchronized (this.dataLock)
    {
      if (this.bodyDetected)
      {
        BodyDetectResult localBodyDetectResult = new BodyDetectResult();
        localBodyDetectResult.bodyPoints = new ArrayList();
        localBodyDetectResult.bodyPointScores = new ArrayList();
        paramInt1 = 0;
        while (paramInt1 < 59)
        {
          PointF localPointF = new PointF(this.ptX[paramInt1], this.ptY[paramInt1]);
          localBodyDetectResult.bodyPoints.add(localPointF);
          localBodyDetectResult.bodyPointScores.add(Float.valueOf(this.fscore[paramInt1]));
          paramInt1 += 1;
        }
        localArrayList.add(localBodyDetectResult);
      }
      this.detectIndex += 1;
      AppMethodBeat.o(84424);
      return localArrayList;
    }
  }
  
  public void detectBody(FaceGestureDetGLThread.OnBodyDetListener paramOnBodyDetListener, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84425);
    if (!this.inited)
    {
      paramOnBodyDetListener.onBodyDataReady(new ArrayList());
      AppMethodBeat.o(84425);
      return;
    }
    this.detectHandler.post(new BodyDetector.2(this, paramArrayOfByte, paramInt1, paramInt2, paramOnBodyDetListener));
    AppMethodBeat.o(84425);
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: ldc_w 266
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 63	com/tencent/ttpic/manager/FeatureManager:isBodyDetectionReady	()Z
    //   9: ifeq +10 -> 19
    //   12: aload_0
    //   13: getfield 107	com/tencent/ttpic/util/youtu/bodydetector/BodyDetector:inited	Z
    //   16: ifeq +10 -> 26
    //   19: ldc_w 266
    //   22: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: return
    //   26: ldc_w 268
    //   29: invokestatic 272	com/tencent/ttpic/manager/FeatureManager:getModelStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 278	java/io/InputStream:available	()I
    //   37: newarray byte
    //   39: astore_1
    //   40: aload_2
    //   41: aload_1
    //   42: invokevirtual 282	java/io/InputStream:read	([B)I
    //   45: pop
    //   46: aload_2
    //   47: invokevirtual 285	java/io/InputStream:close	()V
    //   50: aload_1
    //   51: astore_2
    //   52: ldc_w 287
    //   55: invokestatic 272	com/tencent/ttpic/manager/FeatureManager:getModelStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 278	java/io/InputStream:available	()I
    //   63: newarray byte
    //   65: astore_1
    //   66: aload_3
    //   67: aload_1
    //   68: invokevirtual 282	java/io/InputStream:read	([B)I
    //   71: pop
    //   72: aload_3
    //   73: invokevirtual 285	java/io/InputStream:close	()V
    //   76: aload_1
    //   77: astore_3
    //   78: ldc_w 289
    //   81: invokestatic 272	com/tencent/ttpic/manager/FeatureManager:getModelStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 278	java/io/InputStream:available	()I
    //   91: newarray byte
    //   93: astore_1
    //   94: aload 4
    //   96: aload_1
    //   97: invokevirtual 282	java/io/InputStream:read	([B)I
    //   100: pop
    //   101: aload 4
    //   103: invokevirtual 285	java/io/InputStream:close	()V
    //   106: aload_1
    //   107: astore 4
    //   109: ldc_w 291
    //   112: invokestatic 272	com/tencent/ttpic/manager/FeatureManager:getModelStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   115: astore 5
    //   117: aload 5
    //   119: invokevirtual 278	java/io/InputStream:available	()I
    //   122: newarray byte
    //   124: astore_1
    //   125: aload 5
    //   127: aload_1
    //   128: invokevirtual 282	java/io/InputStream:read	([B)I
    //   131: pop
    //   132: aload 5
    //   134: invokevirtual 285	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: astore 5
    //   140: ldc_w 293
    //   143: invokestatic 272	com/tencent/ttpic/manager/FeatureManager:getModelStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   146: astore 6
    //   148: aload 6
    //   150: invokevirtual 278	java/io/InputStream:available	()I
    //   153: newarray byte
    //   155: astore_1
    //   156: aload 6
    //   158: aload_1
    //   159: invokevirtual 282	java/io/InputStream:read	([B)I
    //   162: pop
    //   163: aload 6
    //   165: invokevirtual 285	java/io/InputStream:close	()V
    //   168: aload_1
    //   169: astore 6
    //   171: ldc_w 295
    //   174: invokestatic 272	com/tencent/ttpic/manager/FeatureManager:getModelStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   177: astore 7
    //   179: aload 7
    //   181: invokevirtual 278	java/io/InputStream:available	()I
    //   184: newarray byte
    //   186: astore_1
    //   187: aload 7
    //   189: aload_1
    //   190: invokevirtual 282	java/io/InputStream:read	([B)I
    //   193: pop
    //   194: aload 7
    //   196: invokevirtual 285	java/io/InputStream:close	()V
    //   199: new 297	android/os/HandlerThread
    //   202: dup
    //   203: ldc_w 299
    //   206: invokespecial 301	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   209: astore 7
    //   211: aload 7
    //   213: invokevirtual 304	android/os/HandlerThread:start	()V
    //   216: aload_0
    //   217: new 200	android/os/Handler
    //   220: dup
    //   221: aload 7
    //   223: invokevirtual 305	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   226: invokespecial 308	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   229: putfield 198	com/tencent/ttpic/util/youtu/bodydetector/BodyDetector:detectHandler	Landroid/os/Handler;
    //   232: aload_0
    //   233: aload_0
    //   234: aload_2
    //   235: aload_3
    //   236: aload 4
    //   238: aload 5
    //   240: aconst_null
    //   241: aconst_null
    //   242: aload 6
    //   244: aload_1
    //   245: invokevirtual 312	com/tencent/ttpic/util/youtu/bodydetector/BodyDetector:nativeInit	([B[B[B[B[B[B[B[B)Z
    //   248: putfield 107	com/tencent/ttpic/util/youtu/bodydetector/BodyDetector:inited	Z
    //   251: ldc_w 266
    //   254: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: return
    //   258: astore_2
    //   259: aconst_null
    //   260: astore_1
    //   261: aload_2
    //   262: invokestatic 92	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   265: aload_1
    //   266: astore_2
    //   267: goto -215 -> 52
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_3
    //   274: invokestatic 92	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   277: aload_1
    //   278: astore_3
    //   279: goto -201 -> 78
    //   282: astore 4
    //   284: aconst_null
    //   285: astore_1
    //   286: aload 4
    //   288: invokestatic 92	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   291: aload_1
    //   292: astore 4
    //   294: goto -185 -> 109
    //   297: astore 5
    //   299: aconst_null
    //   300: astore_1
    //   301: aload 5
    //   303: invokestatic 92	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   306: aload_1
    //   307: astore 5
    //   309: goto -169 -> 140
    //   312: astore 6
    //   314: aconst_null
    //   315: astore_1
    //   316: aload 6
    //   318: invokestatic 92	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   321: aload_1
    //   322: astore 6
    //   324: goto -153 -> 171
    //   327: astore 7
    //   329: aconst_null
    //   330: astore_1
    //   331: aload 7
    //   333: invokestatic 92	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   336: goto -137 -> 199
    //   339: astore 7
    //   341: goto -10 -> 331
    //   344: astore 6
    //   346: goto -30 -> 316
    //   349: astore 5
    //   351: goto -50 -> 301
    //   354: astore 4
    //   356: goto -70 -> 286
    //   359: astore_3
    //   360: goto -87 -> 273
    //   363: astore_2
    //   364: goto -103 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	BodyDetector
    //   39	292	1	arrayOfByte1	byte[]
    //   32	203	2	localObject1	Object
    //   258	4	2	localException1	Exception
    //   266	1	2	localObject2	Object
    //   363	1	2	localException2	Exception
    //   58	178	3	localObject3	Object
    //   270	4	3	localException3	Exception
    //   278	1	3	arrayOfByte2	byte[]
    //   359	1	3	localException4	Exception
    //   84	153	4	localObject4	Object
    //   282	5	4	localException5	Exception
    //   292	1	4	arrayOfByte3	byte[]
    //   354	1	4	localException6	Exception
    //   115	124	5	localObject5	Object
    //   297	5	5	localException7	Exception
    //   307	1	5	arrayOfByte4	byte[]
    //   349	1	5	localException8	Exception
    //   146	97	6	localObject6	Object
    //   312	5	6	localException9	Exception
    //   322	1	6	arrayOfByte5	byte[]
    //   344	1	6	localException10	Exception
    //   177	45	7	localObject7	Object
    //   327	5	7	localException11	Exception
    //   339	1	7	localException12	Exception
    // Exception table:
    //   from	to	target	type
    //   26	40	258	java/lang/Exception
    //   52	66	270	java/lang/Exception
    //   78	94	282	java/lang/Exception
    //   109	125	297	java/lang/Exception
    //   140	156	312	java/lang/Exception
    //   171	187	327	java/lang/Exception
    //   187	199	339	java/lang/Exception
    //   156	168	344	java/lang/Exception
    //   125	137	349	java/lang/Exception
    //   94	106	354	java/lang/Exception
    //   66	76	359	java/lang/Exception
    //   40	50	363	java/lang/Exception
  }
  
  public boolean isInited()
  {
    return this.inited;
  }
  
  public native boolean nativeBodyDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int[] paramArrayOfInt);
  
  public native boolean nativeBodyKeypoint(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
  
  public native boolean nativeDestroy();
  
  public native boolean nativeDetectBody(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6, int paramInt3, int paramInt4, int paramInt5);
  
  public native boolean nativeInit(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8);
  
  public void reset()
  {
    this.detectIndex = 0;
    this.bodyDetected = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.bodydetector.BodyDetector
 * JD-Core Version:    0.7.0.1
 */
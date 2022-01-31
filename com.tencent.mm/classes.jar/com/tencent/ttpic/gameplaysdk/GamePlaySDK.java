package com.tencent.ttpic.gameplaysdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.gameplaysdk.util.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

public class GamePlaySDK
{
  private static final int HEAD_MESH_UPDATE_FRAME_INTERVAL = 10;
  private static final String TAG = GamePlaySDK.class.getSimpleName();
  public static Context context;
  private static GamePlaySDK mInstance;
  private int cameraTextureId;
  private float fov = 60.0F;
  private long gameHandler;
  private int gameTextureId;
  private int headMeshUpdateFrameCount = 0;
  private boolean hideScreen;
  private boolean isSoLoaded = false;
  private int mHeight;
  private int mWidth;
  private ThreadLocal threadLocal = new ThreadLocal();
  
  private GamePlaySDK()
  {
    loadGamePlaySO();
  }
  
  private int createTexture(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(paramInt, arrayOfInt[0]);
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameteri(paramInt, 10242, 33071);
    GLES20.glTexParameteri(paramInt, 10243, 33071);
    return arrayOfInt[0];
  }
  
  public static GamePlaySDK getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GamePlaySDK();
      }
      GamePlaySDK localGamePlaySDK = mInstance;
      return localGamePlaySDK;
    }
    finally {}
  }
  
  private void initGameTexture()
  {
    if (this.gameTextureId <= 0) {
      this.gameTextureId = createTexture(3553);
    }
    if (this.cameraTextureId <= 0) {
      this.cameraTextureId = createTexture(3553);
    }
  }
  
  private void loadGamePlaySO()
  {
    if (!this.isSoLoaded) {}
    try
    {
      System.loadLibrary("gameplay");
      LogUtil.e(TAG, "loadLibrary arengine success.");
      this.isSoLoaded = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e(TAG, "loadLibrary arengine failed: " + localException.getMessage());
      }
    }
  }
  
  private void loadGamePlaySOForDebug()
  {
    File localFile;
    FileOutputStream localFileOutputStream;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      if (!this.isSoLoaded)
      {
        Object localObject = new File(Environment.getExternalStorageDirectory() + File.separator + "libgameplay.so");
        if (!((File)localObject).exists()) {
          new StringBuilder().append(((File)localObject).getAbsolutePath()).append(" is not fond!");
        }
        localObject = new FileInputStream((File)localObject);
        localFile = new File(context.getDir("libs", 0), "libgameplay.so");
        new StringBuilder("### ").append(localFile.getAbsolutePath()).append(" is not exists");
        localFileOutputStream = new FileOutputStream(localFile);
        localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = ((FileInputStream)localObject).read(arrayOfByte);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("Exception   ").append(localException.getMessage());
    }
    localFileOutputStream.write(localByteArrayOutputStream.toByteArray());
    localByteArrayOutputStream.close();
    localFileOutputStream.close();
    localException.close();
    System.load(localFile.getAbsolutePath());
    this.isSoLoaded = true;
  }
  
  public static native void nativeSetLogLevel(int paramInt);
  
  public static native void native_clearItemImage();
  
  public static native void native_destroy(long paramLong);
  
  public static native String native_getFinishAnimationNodeIds();
  
  public static native boolean native_getTipsPos(float[] paramArrayOfFloat);
  
  public static native int native_hasGame(long paramLong);
  
  public static native long native_init(Context paramContext, AssetManager paramAssetManager, String paramString, GameParams paramGameParams);
  
  public static native void native_loadItemImage(String paramString1, String paramString2);
  
  public static native void native_onContextDestroy(long paramLong);
  
  public static native void native_onDrawFrame(long paramLong);
  
  public static native long native_onOrientationChanged(int paramInt);
  
  public static native void native_onSensorChanged(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, int paramInt);
  
  public static native void native_onSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  public static native void native_onSurfaceCreated(long paramLong, int paramInt1, int paramInt2);
  
  public static native void native_onTouchBegin(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong1, long paramLong2);
  
  public static native void native_onTouchCancel(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong1, long paramLong2);
  
  public static native void native_onTouchEnd(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong1, long paramLong2);
  
  public static native void native_onTouchMove(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong1, long paramLong2);
  
  public static native void native_pause(long paramLong);
  
  public static native void native_resume(long paramLong);
  
  public static native void native_setCameraTexture(long paramLong, int paramInt);
  
  public static native void native_setFov(float paramFloat);
  
  public static native void native_setNodeAlignedHeadPointIndex(String paramString, int paramInt);
  
  public static native void native_setOutputTexture(long paramLong, int paramInt);
  
  public static native void native_setSensorSupport(int paramInt, boolean paramBoolean);
  
  public static native void native_startGame(long paramLong, String paramString, GameParams paramGameParams, NodeParameter[] paramArrayOfNodeParameter);
  
  public static native void native_stopGame(long paramLong);
  
  public static native void native_updateAccel(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static native void native_updateAzimuth(long paramLong, float paramFloat);
  
  public static native void native_updateCameraTex(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void native_updateHeadData(float[] paramArrayOfFloat);
  
  public static native void native_updateMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
  
  public static native void native_updatePitch(long paramLong, float paramFloat);
  
  public static native void native_updateQuaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public static native void native_updateRoll(long paramLong, float paramFloat);
  
  public static native void native_updateSensor(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static native void native_updateTransformMatrix(float[] paramArrayOfFloat);
  
  public static native void native_updateTriggerInfo(StickerItem3D[] paramArrayOfStickerItem3D);
  
  private void setIsInited(boolean paramBoolean)
  {
    Object localObject = this.threadLocal.get();
    if ((localObject != null) && ((localObject instanceof GamePlaySDK.State)))
    {
      ((GamePlaySDK.State)localObject).isInited = paramBoolean;
      return;
    }
    localObject = new GamePlaySDK.State(this, null);
    ((GamePlaySDK.State)localObject).isInited = paramBoolean;
    this.threadLocal.set(localObject);
  }
  
  public void clear()
  {
    if (isInited())
    {
      destroyGame();
      GLES20.glDeleteTextures(2, new int[] { this.gameTextureId, this.cameraTextureId }, 0);
      this.gameTextureId = 0;
      this.cameraTextureId = 0;
      this.gameHandler = 0L;
      this.threadLocal.remove();
      this.headMeshUpdateFrameCount = 0;
    }
  }
  
  public void clearItemImage() {}
  
  public void destroyGame()
  {
    if (this.gameHandler != 0L) {
      native_destroy(this.gameHandler);
    }
  }
  
  public int getCameraTexture()
  {
    return this.cameraTextureId;
  }
  
  public Set<String> getFinishAnimationNodeIds()
  {
    HashSet localHashSet = new HashSet();
    String[] arrayOfString = native_getFinishAnimationNodeIds().split("-");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(arrayOfString[i]);
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public float getFov()
  {
    return this.fov;
  }
  
  public int getGameTexture()
  {
    return this.gameTextureId;
  }
  
  public boolean hasGame()
  {
    return (this.gameHandler != 0L) && (this.gameTextureId > 0) && (native_hasGame(this.gameHandler) > 0);
  }
  
  public void init(Context paramContext, AssetManager paramAssetManager, String paramString, GameParams paramGameParams, int paramInt1, int paramInt2)
  {
    if (!isInited()) {}
    try
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.gameHandler = native_init(paramContext, paramAssetManager, paramString, paramGameParams);
      initGameTexture();
      native_setOutputTexture(this.gameHandler, this.gameTextureId);
      native_setCameraTexture(this.gameHandler, this.cameraTextureId);
      native_onSurfaceCreated(this.gameHandler, paramInt1, paramInt2);
      setIsInited(true);
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  public boolean isHideScreen()
  {
    return this.hideScreen;
  }
  
  public boolean isInited()
  {
    Object localObject = this.threadLocal.get();
    if ((localObject != null) && ((localObject instanceof GamePlaySDK.State))) {
      return ((GamePlaySDK.State)localObject).isInited;
    }
    return false;
  }
  
  public void loadItemImage(String paramString1, String paramString2)
  {
    native_loadItemImage(paramString1, paramString2);
  }
  
  public void onDrawFrame()
  {
    if (this.gameHandler != 0L)
    {
      GLES20.glFlush();
      LogUtil.e(TAG, "game play sdk onDrawFrame");
      native_onDrawFrame(this.gameHandler);
    }
  }
  
  public void onPause()
  {
    if (this.gameHandler != 0L) {
      native_pause(this.gameHandler);
    }
  }
  
  public void onResume()
  {
    if (this.gameHandler != 0L) {
      native_resume(this.gameHandler);
    }
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    if ((isInited()) && ((this.mWidth != paramInt1) || (this.mHeight != paramInt2)))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      native_onSurfaceChanged(this.gameHandler, paramInt1, paramInt2);
    }
  }
  
  public void setFov(float paramFloat)
  {
    this.fov = paramFloat;
  }
  
  public void setNodeAlignedHeadPointIndex(String paramString, int paramInt)
  {
    if (isInited()) {
      native_setNodeAlignedHeadPointIndex(paramString, paramInt);
    }
  }
  
  public void startGame(String paramString, GameParams paramGameParams, NodeParameter[] paramArrayOfNodeParameter)
  {
    native_startGame(this.gameHandler, paramString, paramGameParams, paramArrayOfNodeParameter);
    this.fov = paramGameParams.fov;
  }
  
  public void stopGame()
  {
    if ((this.gameHandler != 0L) && (native_hasGame(this.gameHandler) > 0))
    {
      native_stopGame(this.gameHandler);
      this.headMeshUpdateFrameCount = 0;
    }
  }
  
  public void toggleHideScreen()
  {
    if (!this.hideScreen) {}
    for (boolean bool = true;; bool = false)
    {
      this.hideScreen = bool;
      return;
    }
  }
  
  public void updateHeadData(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (isInited())
    {
      int i = this.headMeshUpdateFrameCount;
      this.headMeshUpdateFrameCount = (i + 1);
      if (i % 10 == 0) {
        native_updateHeadData(paramArrayOfFloat1);
      }
      native_updateTransformMatrix(paramArrayOfFloat2);
    }
  }
  
  public void updateTriggerInfo(StickerItem3D[] paramArrayOfStickerItem3D)
  {
    native_updateTriggerInfo(paramArrayOfStickerItem3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.GamePlaySDK
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ttpic.gameplaysdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.manager.FeatureManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

public class GamePlaySDK
{
  private static final int HEAD_MESH_UPDATE_FRAME_INTERVAL = 10;
  private static final String TAG;
  public static Context context;
  private static GamePlaySDK mInstance;
  private float fov;
  private long gameHandler;
  private int gameTextureId;
  private int headMeshUpdateFrameCount;
  private boolean hideScreen;
  private boolean isSoLoaded;
  private int mHeight;
  private int mWidth;
  private ThreadLocal threadLocal;
  
  static
  {
    AppMethodBeat.i(83221);
    TAG = GamePlaySDK.class.getSimpleName();
    AppMethodBeat.o(83221);
  }
  
  private GamePlaySDK()
  {
    AppMethodBeat.i(83196);
    this.headMeshUpdateFrameCount = 0;
    this.threadLocal = new ThreadLocal();
    this.isSoLoaded = false;
    this.fov = 60.0F;
    loadGamePlaySO();
    AppMethodBeat.o(83196);
  }
  
  private int createTexture(int paramInt)
  {
    AppMethodBeat.i(83202);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(paramInt, arrayOfInt[0]);
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameteri(paramInt, 10242, 33071);
    GLES20.glTexParameteri(paramInt, 10243, 33071);
    paramInt = arrayOfInt[0];
    AppMethodBeat.o(83202);
    return paramInt;
  }
  
  public static GamePlaySDK getInstance()
  {
    try
    {
      AppMethodBeat.i(83195);
      if (mInstance == null) {
        mInstance = new GamePlaySDK();
      }
      GamePlaySDK localGamePlaySDK = mInstance;
      AppMethodBeat.o(83195);
      return localGamePlaySDK;
    }
    finally {}
  }
  
  private void initGameTexture()
  {
    AppMethodBeat.i(83201);
    if (this.gameTextureId <= 0) {
      this.gameTextureId = createTexture(3553);
    }
    AppMethodBeat.o(83201);
  }
  
  private void loadGamePlaySO()
  {
    AppMethodBeat.i(83194);
    if ((FeatureManager.isGameplayReady()) && (!this.isSoLoaded)) {}
    try
    {
      FeatureManager.loadLibrary("gameplay");
      LogUtils.e(TAG, "loadLibrary arengine success.");
      this.isSoLoaded = true;
      AppMethodBeat.o(83194);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils.e(TAG, "loadLibrary arengine failed: " + localException.getMessage());
      }
    }
  }
  
  private void loadGamePlaySOForDebug()
  {
    AppMethodBeat.i(83193);
    File localFile;
    FileOutputStream localFileOutputStream;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      if (this.isSoLoaded) {
        break label234;
      }
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
      localFileOutputStream.write(localByteArrayOutputStream.toByteArray());
    }
    catch (Exception localException)
    {
      new StringBuilder("Exception   ").append(localException.getMessage());
      AppMethodBeat.o(83193);
      return;
    }
    localByteArrayOutputStream.close();
    localFileOutputStream.close();
    localException.close();
    System.load(localFile.getAbsolutePath());
    this.isSoLoaded = true;
    label234:
    AppMethodBeat.o(83193);
  }
  
  public static native void nativeSetLogLevel(int paramInt);
  
  public static native void native_clearItemImage();
  
  public static native void native_destroy(long paramLong);
  
  public static native String native_getFinishAnimationNodeIds();
  
  public static native int native_getReflectTextureHeight(long paramLong);
  
  public static native int native_getReflectTextureID(long paramLong);
  
  public static native int native_getReflectTextureWidth(long paramLong);
  
  public static native boolean native_getTipsPos(float[] paramArrayOfFloat);
  
  public static native int native_hasGame(long paramLong);
  
  public static native long native_init(Context paramContext, AssetManager paramAssetManager, String paramString, GameParams paramGameParams);
  
  public static native void native_loadItemImage(String paramString1, String paramString2, boolean paramBoolean);
  
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
    AppMethodBeat.i(83200);
    Object localObject = this.threadLocal.get();
    if ((localObject != null) && ((localObject instanceof GamePlaySDK.State)))
    {
      ((GamePlaySDK.State)localObject).isInited = paramBoolean;
      AppMethodBeat.o(83200);
      return;
    }
    localObject = new GamePlaySDK.State(this, null);
    ((GamePlaySDK.State)localObject).isInited = paramBoolean;
    this.threadLocal.set(localObject);
    AppMethodBeat.o(83200);
  }
  
  public void clear()
  {
    AppMethodBeat.i(83212);
    if (isInited())
    {
      destroyGame();
      GLES20.glDeleteTextures(1, new int[] { this.gameTextureId }, 0);
      this.gameTextureId = 0;
      this.gameHandler = 0L;
      this.threadLocal.remove();
      this.headMeshUpdateFrameCount = 0;
    }
    AppMethodBeat.o(83212);
  }
  
  public void clearItemImage()
  {
    AppMethodBeat.i(83220);
    native_clearItemImage();
    AppMethodBeat.o(83220);
  }
  
  public void destroyGame()
  {
    AppMethodBeat.i(83211);
    if (this.gameHandler != 0L) {
      native_destroy(this.gameHandler);
    }
    AppMethodBeat.o(83211);
  }
  
  public Set<String> getFinishAnimationNodeIds()
  {
    AppMethodBeat.i(83216);
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
    AppMethodBeat.o(83216);
    return localHashSet;
  }
  
  public float getFov()
  {
    return this.fov;
  }
  
  public int getGameRefTextureHeight()
  {
    AppMethodBeat.i(83205);
    int i = native_getReflectTextureHeight(this.gameHandler);
    AppMethodBeat.o(83205);
    return i;
  }
  
  public int getGameRefTextureID()
  {
    AppMethodBeat.i(83203);
    int i = native_getReflectTextureID(this.gameHandler);
    AppMethodBeat.o(83203);
    return i;
  }
  
  public int getGameRefTextureWidth()
  {
    AppMethodBeat.i(83204);
    int i = native_getReflectTextureWidth(this.gameHandler);
    AppMethodBeat.o(83204);
    return i;
  }
  
  public int getGameTexture()
  {
    return this.gameTextureId;
  }
  
  public boolean hasGame()
  {
    AppMethodBeat.i(83214);
    if ((this.gameHandler != 0L) && (this.gameTextureId > 0) && (native_hasGame(this.gameHandler) > 0))
    {
      AppMethodBeat.o(83214);
      return true;
    }
    AppMethodBeat.o(83214);
    return false;
  }
  
  public void init(Context paramContext, AssetManager paramAssetManager, String paramString, GameParams paramGameParams, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83197);
    if ((!isInited()) && (this.isSoLoaded)) {
      try
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        this.gameHandler = native_init(paramContext, paramAssetManager, paramString, paramGameParams);
        initGameTexture();
        native_setOutputTexture(this.gameHandler, this.gameTextureId);
        native_onSurfaceCreated(this.gameHandler, paramInt1, paramInt2);
        setIsInited(true);
        AppMethodBeat.o(83197);
        return;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
    AppMethodBeat.o(83197);
  }
  
  public boolean isHideScreen()
  {
    return this.hideScreen;
  }
  
  public boolean isInited()
  {
    AppMethodBeat.i(83199);
    Object localObject = this.threadLocal.get();
    if ((localObject != null) && ((localObject instanceof GamePlaySDK.State)))
    {
      boolean bool = ((GamePlaySDK.State)localObject).isInited;
      AppMethodBeat.o(83199);
      return bool;
    }
    AppMethodBeat.o(83199);
    return false;
  }
  
  public void loadItemImage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(83218);
    loadItemImage(paramString1, paramString2, false);
    AppMethodBeat.o(83218);
  }
  
  public void loadItemImage(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(83219);
    native_loadItemImage(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(83219);
  }
  
  public void onDrawFrame()
  {
    AppMethodBeat.i(83206);
    if (this.gameHandler != 0L)
    {
      GLES20.glFlush();
      LogUtils.e(TAG, "game play sdk onDrawFrame");
      native_onDrawFrame(this.gameHandler);
    }
    AppMethodBeat.o(83206);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(83207);
    if (this.gameHandler != 0L) {
      native_pause(this.gameHandler);
    }
    AppMethodBeat.o(83207);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(83208);
    if (this.gameHandler != 0L) {
      native_resume(this.gameHandler);
    }
    AppMethodBeat.o(83208);
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83198);
    if ((isInited()) && ((this.mWidth != paramInt1) || (this.mHeight != paramInt2)))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      native_onSurfaceChanged(this.gameHandler, paramInt1, paramInt2);
    }
    AppMethodBeat.o(83198);
  }
  
  public void setFov(float paramFloat)
  {
    this.fov = paramFloat;
  }
  
  public void setNodeAlignedHeadPointIndex(String paramString, int paramInt)
  {
    AppMethodBeat.i(83217);
    if (isInited()) {
      native_setNodeAlignedHeadPointIndex(paramString, paramInt);
    }
    AppMethodBeat.o(83217);
  }
  
  public void startGame(String paramString, GameParams paramGameParams, NodeParameter[] paramArrayOfNodeParameter)
  {
    AppMethodBeat.i(83209);
    if (!this.isSoLoaded)
    {
      AppMethodBeat.o(83209);
      return;
    }
    native_startGame(this.gameHandler, paramString, paramGameParams, paramArrayOfNodeParameter);
    this.fov = paramGameParams.fov;
    AppMethodBeat.o(83209);
  }
  
  public void stopGame()
  {
    AppMethodBeat.i(83210);
    if ((this.gameHandler != 0L) && (native_hasGame(this.gameHandler) > 0))
    {
      native_stopGame(this.gameHandler);
      this.headMeshUpdateFrameCount = 0;
    }
    AppMethodBeat.o(83210);
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
    AppMethodBeat.i(83213);
    if (isInited())
    {
      int i = this.headMeshUpdateFrameCount;
      this.headMeshUpdateFrameCount = (i + 1);
      if (i % 10 == 0) {
        native_updateHeadData(paramArrayOfFloat1);
      }
      native_updateTransformMatrix(paramArrayOfFloat2);
    }
    AppMethodBeat.o(83213);
  }
  
  public void updateTriggerInfo(StickerItem3D[] paramArrayOfStickerItem3D)
  {
    AppMethodBeat.i(83215);
    native_updateTriggerInfo(paramArrayOfStickerItem3D);
    AppMethodBeat.o(83215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.GamePlaySDK
 * JD-Core Version:    0.7.0.1
 */
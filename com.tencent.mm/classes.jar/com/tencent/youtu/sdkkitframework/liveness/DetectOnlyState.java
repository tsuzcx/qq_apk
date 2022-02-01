package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONObject;

public class DetectOnlyState
  extends YtFSMBaseState
{
  private static final String TAG;
  private boolean isLoadResourceOnline = false;
  private int minFaceSize = 80;
  private boolean needBigFaceMode = false;
  private String resourceDownloadPath = "";
  
  static
  {
    AppMethodBeat.i(218215);
    TAG = DetectOnlyState.class.getSimpleName();
    AppMethodBeat.o(218215);
  }
  
  public void enterFirst() {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(218232);
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("resource_download_path")) {
        this.resourceDownloadPath = paramJSONObject.getString("resource_download_path");
      }
      if (paramJSONObject.has("need_big_face_mode")) {
        this.needBigFaceMode = paramJSONObject.getBoolean("need_big_face_mode");
      }
      if (paramJSONObject.has("min_face_size")) {
        this.minFaceSize = paramJSONObject.getInt("min_face_size");
      }
    }
    catch (Exception paramString)
    {
      String str1;
      String str2;
      for (;;)
      {
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        YtLogger.i(TAG, "Use local path:".concat(String.valueOf(paramString)));
      }
      if (this.isLoadResourceOnline) {
        break label386;
      }
      final int i = 0;
      while (i < 5)
      {
        str1 = new String[] { "align.rpdm", "align.stb", "align_bin.rpdc", "eye.rpdm", "eye_bin.rpdc" }[i];
        str2 = paramString + "/" + str1;
        FileUtils.copyAsset(paramJSONObject.getAssets(), "FaceTrackModels/ufa/".concat(String.valueOf(str1)), str2);
        i += 1;
      }
      if (this.isLoadResourceOnline) {
        break label465;
      }
      i = 0;
      while (i <= 0)
      {
        str1 = new String[] { "rotBasis.bin" }[i];
        str2 = paramString + "/" + str1;
        FileUtils.copyAsset(paramJSONObject.getAssets(), "FaceTrackModels/poseest/".concat(String.valueOf(str1)), str2);
        i += 1;
      }
      i = YTFaceTrack.GlobalInit(paramString + "/");
      if (i == 0) {
        break label522;
      }
      YtSDKStats.getInstance().reportError(i, "failed to init face trace sdk");
      YtFSM.getInstance().sendFSMEvent(new HashMap() {});
      AppMethodBeat.o(218232);
      return;
      paramString = YTFaceTrack.getInstance().GetFaceDetectParam();
      YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
      paramString.bigger_face_mode = this.needBigFaceMode;
      paramString.min_face_size = this.minFaceSize;
      YTFaceTrack.getInstance().SetFaceDetectParam(paramString);
      paramString = YTFaceTrack.getInstance().GetFaceTrackParam();
      paramString.need_pose_estimate = false;
      paramString.single_detect_mode = true;
      paramString.detect_interval = -1;
      YTFaceTrack.getInstance().SetFaceTrackParam(paramString);
      YtLogger.i(TAG, "Detect version:" + YTFaceTrack.Version);
      AppMethodBeat.o(218232);
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTFaceTrackPro2");
    }
    paramJSONObject = YtFSM.getInstance().getContext().currentAppContext;
    paramString = paramJSONObject.getFilesDir().getAbsolutePath();
    if (this.isLoadResourceOnline)
    {
      paramString = this.resourceDownloadPath;
      YtLogger.i(TAG, "Use online path:".concat(String.valueOf(paramString)));
      if (this.isLoadResourceOnline) {
        break label286;
      }
      i = 0;
      while (i < 4)
      {
        str1 = new String[] { "net1_18.rpnmodel", "net1_18_bin.rpnproto", "net2_36.rpnmodel", "net2_36_bin.rpnproto" }[i];
        str2 = paramString + "/" + str1;
        FileUtils.copyAsset(paramJSONObject.getAssets(), "FaceTrackModels/detector/".concat(String.valueOf(str1)), str2);
        i += 1;
      }
    }
    label286:
    label465:
    return;
  }
  
  public void update(final byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(218246);
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    Object localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    Rect[] arrayOfRect = YTFaceTrack.getInstance().GetFaceRect(YTFaceTrack.getInstance().GetYTImageBitmap((Bitmap)localObject, 1));
    if (arrayOfRect == null)
    {
      YtSDKStats.getInstance().reportError(3145728, "detecet failed");
      YtFSM.getInstance().sendFSMEvent(new HashMap() {});
      AppMethodBeat.o(218246);
      return;
    }
    paramArrayOfByte = "[";
    paramInt1 = 0;
    while (paramInt1 < arrayOfRect.length)
    {
      paramInt2 = arrayOfRect[paramInt1].left;
      paramInt3 = arrayOfRect[paramInt1].top;
      int i = arrayOfRect[paramInt1].right;
      int j = arrayOfRect[paramInt1].left;
      int k = arrayOfRect[paramInt1].bottom;
      int m = arrayOfRect[paramInt1].top;
      localObject = paramArrayOfByte + "{\"rect\":{\"x\":" + paramInt2 + ",\"y\":" + paramInt3 + ",\"w\":" + (i - j) + ",\"h\":" + (k - m) + "}}";
      paramArrayOfByte = (byte[])localObject;
      if (paramInt1 < arrayOfRect.length - 1) {
        paramArrayOfByte = (String)localObject + ",";
      }
      paramInt1 += 1;
    }
    paramArrayOfByte = paramArrayOfByte + "]";
    paramArrayOfByte = "{\"errorcode\":0,\"errormsg\":\"OK\",\"face_count\":" + arrayOfRect.length + ",\"face_rects\":" + paramArrayOfByte + "}";
    YtSDKStats.getInstance().reportInfo("errorcode: 0, face_count: " + arrayOfRect.length);
    YtFSM.getInstance().sendFSMEvent(new HashMap() {});
    AppMethodBeat.o(218246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState
 * JD-Core Version:    0.7.0.1
 */
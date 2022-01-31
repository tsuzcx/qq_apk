package com.tencent.ttpic.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.model.SizeI;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class DeviceAttrs
{
  public static final String ACTION_CHECK_ONLINE_UPDATE_FINISH = "action_check_online_update_finish";
  public static final int CAMERASDK_FAILED_THRESHOLD = 4;
  public static final int DEGREE_0 = 0;
  public static final int DEGREE_180 = 180;
  public static final int DEGREE_270 = 270;
  public static final int DEGREE_90 = 90;
  public static final int DEGREE_INVALIDATE = -1;
  public static final Boolean ENABLE_LOG;
  public static final int ENABLE_PERFORMANCE_MONITOR_THRESHOLD = 604800000;
  private static final DeviceAttrs INSTANCE;
  public static final String KEY_CAMERASDK_DISABLE = "pref_camerasdk_disable";
  public static final String KEY_CAMERASDK_FAILED_TIMES = "pref_camerasdk_open_failed_times";
  public static final String KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME = "enable_performance_monitor_begin_time";
  public static final String KEY_NEED_PARSE_XML = "is_need_parse_xml";
  public static final String KEY_URL_VALUE = "black_list_url";
  public static final String KEY_VERSION = "xml_version";
  public static final Boolean PARSE_XML_DEBUG_MODE;
  private static final String TAG;
  private static final Boolean TEST_URL;
  private static final String XML_FILE_NAME = "phone_attrs_config.dat";
  private static final String ZIP_FILE_NAME = "phone_attrs_config.zip";
  private static final String backCamCannotRotateKey = "backCamCannotRotate";
  private static final String backExposureStepOneKey = "backExposureStepOne";
  private static final String backFlashModeExceptionKey = "backFlashModeException";
  private static final String backFlashNoAutoKey = "backFlashNoAuto";
  private static final String backFlashNoOnKey = "backFlashNoOn";
  private static final String backFlashNoTorchKey = "backFlashNoTorch";
  private static final String beBlurredPicAfterTakePicKey = "beBlurredPicAfterTakePic";
  private static final String beBlurredPreviewAfterTakePicKey = "beBlurredPreviewAfterTakePic";
  private static final String cannotFlashWhileAutoFocusKey = "cannotFlashWhileAutoFocus";
  private static final String cannotFlashWhileFlashOnKey = "cannotFlashWhileFlashOn";
  private static final String cannotRotatePreviewKey = "cannotRotatePreview";
  private static final String deviceJpegDisableKey = "deviceJpegDisable";
  private static final String disableAutoFocusDoubleKey = "disableAutoFocusDouble";
  private static final String disableBackExposureKey = "disableBackExposure";
  private static final String disableBackFlashModeKey = "disableBackFlashMode";
  private static final String disableCameraSDKKey = "disableCameraSDK";
  private static final String disableCameraVideoKey = "disableCameraVideo";
  private static final String disableFaceDetectionKey = "disableFaceDetection";
  private static final String disableFocusModeContinuousPictureKey = "disableFocusModeContinuousPicture";
  private static final String disableFocusModeKey = "disableFocusMode";
  private static final String disableFrontCameraKey = "disableFrontCamera";
  private static final String disableFrontExposureKey = "disableFrontExposure";
  private static final String disableGridCaptureKey = "disableGridCapture";
  private static final String disableLiteEditorKey = "disableLiteEditor";
  private static final String disableMultiPreviewKey = "disableMultiPreview";
  private static final String disableVideoTransformKey = "disableVideoTransform";
  private static final String enableFastCapture4BackCameraKey = "enableFastCapture4BackCamera";
  private static final String enableFastCapture4FrontCameraKey = "enableFastCapture4FrontCamera";
  private static final String enablePerformanceMonitorKey = "enablePerformanceMonitor";
  private static final String es_GL_EXT_shader_framebuffer_fetch_key = "es_GL_EXT_shader_framebuffer_fetch";
  private static final String frontCamCannotRotateKey = "frontCamCannotRotate";
  private static final String frontCamFlipHKey = "frontCamFlipH";
  private static final String frontExposureStepOneKey = "frontExposureStepOne";
  private static final String frontFlashModeExceptionKey = "frontFlashModeException";
  private static final String frontFlashNoAutoKey = "frontFlashNoAuto";
  private static final String int_backCamRotate0Key = "int_backCamRotate0";
  private static final String int_backCamRotate180Key = "int_backCamRotate180";
  private static final String int_backCamRotate270Key = "int_backCamRotate270";
  private static final String int_backCamRotate90Key = "int_backCamRotate90";
  private static final String int_backExifRotate0Key = "int_backExifRotate0";
  private static final String int_backExifRotate180Key = "int_backExifRotate180";
  private static final String int_backExifRotate270Key = "int_backExifRotate270";
  private static final String int_backExifRotate90Key = "int_backExifRotate90";
  private static final String int_frontCamRotate0Key = "int_frontCamRotate0";
  private static final String int_frontCamRotate180Key = "int_frontCamRotate180";
  private static final String int_frontCamRotate270Key = "int_frontCamRotate270";
  private static final String int_frontCamRotate90Key = "int_frontCamRotate90";
  private static final String int_frontExifRotate0Key = "int_frontExifRotate0";
  private static final String int_frontExifRotate180Key = "int_frontExifRotate180";
  private static final String int_frontExifRotate270Key = "int_frontExifRotate270";
  private static final String int_frontExifRotate90Key = "int_frontExifRotate90";
  private static final String readCamNumExceptionKey = "readCamNumException";
  private static final String readMaxNumFocusAreasAbnormalKey = "readMaxNumFocusAreasAbnormal";
  private static final String readMaxNumMeteringAreasAbnormalKey = "readMaxNumMeteringAreasAbnormal";
  private static final String sReleaseURL = "http://xiangji.qq.com/services/cameraCoreSvr.php";
  private static final String sTestURL = "http://test.xiangji.qq.com/services/cameraCoreSvr.php";
  private static final String str_backPictureSize43Key = "str_backPictureSize43";
  private static final String str_backPreviewSize169Key = "str_backPreviewSize169";
  private static final String str_backPreviewSize43Key = "str_backPreviewSize43";
  private static final String str_deviceSocInfoKey = "str_deviceSocInfo";
  private static final String str_frontPictureSize43Key = "str_frontPictureSize43";
  private static final String str_frontPreviewSize169Key = "str_frontPreviewSize169";
  private static final String str_frontPreviewSize43Key = "str_frontPreviewSize43";
  private static final String str_recordVideoSizeKey = "str_recordVideoSize";
  private static final String str_videoPreviewFpsKey = "str_videoPreview720Fps";
  private static final String useNewPreviewKey = "useNewPreview";
  private boolean backCamCannotRotate;
  public boolean backExposureStepOne;
  public boolean backFlashModeException;
  public boolean backFlashNoAuto;
  public boolean backFlashNoOn;
  public boolean backFlashNoTorch;
  public boolean beBlurredPicAfterTakePic;
  public boolean beBlurredPreviewAfterTakePic;
  private boolean cannotFlashWhileAutoFocus;
  private boolean cannotFlashWhileFlashOn;
  private boolean cannotRotatePreview;
  public boolean deviceJpegDisable;
  public boolean disableAutoFocusDouble;
  public boolean disableBackCamera;
  public boolean disableBackExposure;
  public boolean disableBackFlashMode;
  public boolean disableCameraSDK;
  public boolean disableCameraVideo;
  public boolean disableFaceDetection;
  public boolean disableFocusMode;
  public boolean disableFocusModeContinuousPicture;
  public boolean disableFrontCamera;
  public boolean disableFrontExposure;
  public boolean disableLiteEditor;
  public boolean enableFastCapture4BackCamera;
  public boolean enableFastCapture4FrontCamera;
  public boolean enablePerformanceMonitor;
  public boolean es_GL_EXT_shader_framebuffer_fetch;
  private boolean frontCamCannotRotate;
  public boolean frontCamFlipH;
  public boolean frontExposureStepOne;
  public boolean frontFlashModeException;
  public boolean frontFlashNoAuto;
  public int int_backCamRotate0;
  public int int_backCamRotate180;
  public int int_backCamRotate270;
  public int int_backCamRotate90;
  public int int_backExifRotate0;
  public int int_backExifRotate180;
  public int int_backExifRotate270;
  public int int_backExifRotate90;
  public int int_frontCamRotate0;
  public int int_frontCamRotate180;
  public int int_frontCamRotate270;
  public int int_frontCamRotate90;
  public int int_frontExifRotate0;
  public int int_frontExifRotate180;
  public int int_frontExifRotate270;
  public int int_frontExifRotate90;
  private String mBuildInFileDir;
  private SharedPreferences mCameraMatchPref;
  private Context mContext;
  private List<String> mFastCaptureKeys;
  private List<String> mFastCaptureOnValues;
  private String mPrevUrl;
  private String mRequestUrl;
  private String mSignature;
  public boolean readCamNumException;
  private boolean readMaxNumFocusAreasAbnormal;
  private boolean readMaxNumMeteringAreasAbnormal;
  public boolean serverJpegEnable;
  public String str_backPictureSize43;
  public String str_backPreviewSize169;
  public String str_backPreviewSize43;
  public String str_deviceSocInfo;
  public String str_frontPictureSize43;
  public String str_frontPreviewSize169;
  public String str_frontPreviewSize43;
  public String str_recordVideoSize;
  public String str_videoPreview720Fps;
  
  static
  {
    AppMethodBeat.i(49832);
    ENABLE_LOG = Boolean.FALSE;
    PARSE_XML_DEBUG_MODE = Boolean.FALSE;
    TEST_URL = Boolean.FALSE;
    TAG = DeviceAttrs.class.getSimpleName();
    INSTANCE = new DeviceAttrs();
    AppMethodBeat.o(49832);
  }
  
  private DeviceAttrs()
  {
    AppMethodBeat.i(49804);
    this.disableCameraSDK = false;
    this.disableLiteEditor = false;
    this.disableCameraVideo = false;
    this.enablePerformanceMonitor = false;
    this.readCamNumException = false;
    this.disableBackCamera = false;
    this.disableFrontCamera = false;
    this.beBlurredPreviewAfterTakePic = false;
    this.beBlurredPicAfterTakePic = false;
    this.enableFastCapture4FrontCamera = false;
    this.enableFastCapture4BackCamera = false;
    this.disableBackFlashMode = false;
    this.frontFlashModeException = false;
    this.frontFlashNoAuto = false;
    this.backFlashModeException = false;
    this.backFlashNoOn = false;
    this.backFlashNoAuto = false;
    this.backFlashNoTorch = true;
    this.disableFocusMode = false;
    this.disableAutoFocusDouble = false;
    this.disableFocusModeContinuousPicture = false;
    this.disableFaceDetection = false;
    this.int_frontCamRotate0 = -1;
    this.int_frontCamRotate90 = -1;
    this.int_frontCamRotate180 = -1;
    this.int_frontCamRotate270 = -1;
    this.int_backCamRotate0 = -1;
    this.int_backCamRotate90 = -1;
    this.int_backCamRotate180 = -1;
    this.int_backCamRotate270 = -1;
    this.int_frontExifRotate0 = -1;
    this.int_frontExifRotate90 = -1;
    this.int_frontExifRotate180 = -1;
    this.int_frontExifRotate270 = -1;
    this.int_backExifRotate0 = -1;
    this.int_backExifRotate90 = -1;
    this.int_backExifRotate180 = -1;
    this.int_backExifRotate270 = -1;
    this.frontCamFlipH = false;
    this.disableFrontExposure = false;
    this.disableBackExposure = false;
    this.frontExposureStepOne = false;
    this.backExposureStepOne = false;
    this.serverJpegEnable = true;
    this.cannotFlashWhileAutoFocus = false;
    this.cannotFlashWhileFlashOn = false;
    this.backCamCannotRotate = false;
    this.frontCamCannotRotate = false;
    this.cannotRotatePreview = false;
    this.readMaxNumMeteringAreasAbnormal = false;
    this.readMaxNumFocusAreasAbnormal = false;
    this.mPrevUrl = "";
    if (TEST_URL.booleanValue()) {}
    for (String str = "http://test.xiangji.qq.com/services/cameraCoreSvr.php";; str = "http://xiangji.qq.com/services/cameraCoreSvr.php")
    {
      this.mRequestUrl = str;
      this.mFastCaptureKeys = new ArrayList();
      this.mFastCaptureOnValues = new ArrayList();
      AppMethodBeat.o(49804);
      return;
    }
  }
  
  private String getCameraPrefName(Context paramContext)
  {
    AppMethodBeat.i(49820);
    paramContext = paramContext.getPackageName() + "_preferences_camera_adapter";
    AppMethodBeat.o(49820);
    return paramContext;
  }
  
  public static DeviceAttrs getInstance()
  {
    return INSTANCE;
  }
  
  private void initFastCaptureKeyValue()
  {
    int j = 0;
    AppMethodBeat.i(49822);
    if ((this.mFastCaptureKeys != null) && (this.mFastCaptureOnValues != null) && (this.mFastCaptureKeys.isEmpty()) && (this.mFastCaptureOnValues.isEmpty()))
    {
      this.mFastCaptureKeys.clear();
      this.mFastCaptureOnValues.clear();
      try
      {
        Object localObject = parseFastCaptureFile();
        if (localObject != null)
        {
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("key");
          int i;
          if (localJSONArray != null)
          {
            i = 0;
            while (i < localJSONArray.length())
            {
              this.mFastCaptureKeys.add(localJSONArray.getString(i));
              i += 1;
            }
          }
          localObject = ((JSONObject)localObject).getJSONArray("value");
          if (localObject != null)
          {
            i = j;
            while (i < ((JSONArray)localObject).length())
            {
              this.mFastCaptureOnValues.add(((JSONArray)localObject).getString(i));
              i += 1;
            }
          }
        }
        AppMethodBeat.o(49822);
        return;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(49822);
  }
  
  private boolean isInFastCaptureWhiteList(boolean paramBoolean)
  {
    AppMethodBeat.i(49823);
    paramBoolean = isInFastCaptureWhiteList(paramBoolean, false);
    AppMethodBeat.o(49823);
    return paramBoolean;
  }
  
  private boolean isInFastCaptureWhiteList(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(49824);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        AppMethodBeat.o(49824);
        return true;
      }
      paramBoolean1 = getInstance().enableFastCapture4FrontCamera;
      AppMethodBeat.o(49824);
      return paramBoolean1;
    }
    paramBoolean1 = getInstance().enableFastCapture4BackCamera;
    AppMethodBeat.o(49824);
    return paramBoolean1;
  }
  
  private void loadAttrsFromPref()
  {
    AppMethodBeat.i(49827);
    LogUtils.i(TAG, "[loadAttrsFromPref] + BEGIN");
    this.str_deviceSocInfo = this.mCameraMatchPref.getString("str_deviceSocInfo", "");
    this.disableCameraSDK = this.mCameraMatchPref.getBoolean("disableCameraSDK", false);
    if (this.disableCameraSDK)
    {
      this.mCameraMatchPref.edit().putBoolean("pref_camerasdk_disable", true).apply();
      LogUtils.i(TAG, "set camerasdk disable flag true");
    }
    this.disableCameraVideo = this.mCameraMatchPref.getBoolean("disableCameraVideo", false);
    this.enablePerformanceMonitor = this.mCameraMatchPref.getBoolean("enablePerformanceMonitor", false);
    this.disableLiteEditor = this.mCameraMatchPref.getBoolean("disableLiteEditor", false);
    this.readCamNumException = this.mCameraMatchPref.getBoolean("readCamNumException", false);
    this.disableFrontCamera = this.mCameraMatchPref.getBoolean("disableFrontCamera", false);
    this.str_frontPreviewSize43 = this.mCameraMatchPref.getString("str_frontPreviewSize43", null);
    this.str_frontPreviewSize169 = this.mCameraMatchPref.getString("str_frontPreviewSize169", null);
    this.str_backPreviewSize43 = this.mCameraMatchPref.getString("str_backPreviewSize43", null);
    this.str_backPreviewSize169 = this.mCameraMatchPref.getString("str_backPreviewSize169", null);
    this.str_videoPreview720Fps = this.mCameraMatchPref.getString("str_videoPreview720Fps", null);
    this.str_frontPictureSize43 = this.mCameraMatchPref.getString("str_frontPictureSize43", null);
    this.str_backPictureSize43 = this.mCameraMatchPref.getString("str_backPictureSize43", null);
    this.str_recordVideoSize = this.mCameraMatchPref.getString("str_recordVideoSize", null);
    this.beBlurredPreviewAfterTakePic = this.mCameraMatchPref.getBoolean("beBlurredPreviewAfterTakePic", false);
    this.beBlurredPicAfterTakePic = this.mCameraMatchPref.getBoolean("beBlurredPicAfterTakePic", false);
    this.enableFastCapture4FrontCamera = this.mCameraMatchPref.getBoolean("enableFastCapture4FrontCamera", false);
    this.enableFastCapture4BackCamera = this.mCameraMatchPref.getBoolean("enableFastCapture4BackCamera", false);
    this.disableBackFlashMode = this.mCameraMatchPref.getBoolean("disableBackFlashMode", false);
    this.backFlashModeException = this.mCameraMatchPref.getBoolean("backFlashModeException", false);
    this.frontFlashModeException = this.mCameraMatchPref.getBoolean("frontFlashModeException", false);
    this.backFlashNoOn = this.mCameraMatchPref.getBoolean("backFlashNoOn", false);
    this.backFlashNoAuto = this.mCameraMatchPref.getBoolean("backFlashNoAuto", false);
    this.backFlashNoTorch = this.mCameraMatchPref.getBoolean("backFlashNoTorch", true);
    this.frontFlashNoAuto = this.mCameraMatchPref.getBoolean("frontFlashNoAuto", false);
    this.disableFocusMode = this.mCameraMatchPref.getBoolean("disableFocusMode", false);
    this.disableFocusModeContinuousPicture = this.mCameraMatchPref.getBoolean("disableFocusModeContinuousPicture", false);
    this.disableAutoFocusDouble = this.mCameraMatchPref.getBoolean("disableAutoFocusDouble", false);
    this.disableFaceDetection = this.mCameraMatchPref.getBoolean("disableFaceDetection", false);
    this.int_frontCamRotate0 = this.mCameraMatchPref.getInt("int_frontCamRotate0", -1);
    this.int_frontCamRotate90 = this.mCameraMatchPref.getInt("int_frontCamRotate90", -1);
    this.int_frontCamRotate180 = this.mCameraMatchPref.getInt("int_frontCamRotate180", -1);
    this.int_frontCamRotate270 = this.mCameraMatchPref.getInt("int_frontCamRotate270", -1);
    this.int_backCamRotate0 = this.mCameraMatchPref.getInt("int_backCamRotate0", -1);
    this.int_backCamRotate90 = this.mCameraMatchPref.getInt("int_backCamRotate90", -1);
    this.int_backCamRotate180 = this.mCameraMatchPref.getInt("int_backCamRotate180", -1);
    this.int_backCamRotate270 = this.mCameraMatchPref.getInt("int_backCamRotate270", -1);
    this.int_frontExifRotate0 = this.mCameraMatchPref.getInt("int_frontExifRotate0", -1);
    this.int_frontExifRotate90 = this.mCameraMatchPref.getInt("int_frontExifRotate90", -1);
    this.int_frontExifRotate180 = this.mCameraMatchPref.getInt("int_frontExifRotate180", -1);
    this.int_frontExifRotate270 = this.mCameraMatchPref.getInt("int_frontExifRotate270", -1);
    this.int_backExifRotate0 = this.mCameraMatchPref.getInt("int_backExifRotate0", -1);
    this.int_backExifRotate90 = this.mCameraMatchPref.getInt("int_backExifRotate90", -1);
    this.int_backExifRotate180 = this.mCameraMatchPref.getInt("int_backExifRotate180", -1);
    this.int_backExifRotate270 = this.mCameraMatchPref.getInt("int_backExifRotate270", -1);
    this.frontCamFlipH = this.mCameraMatchPref.getBoolean("frontCamFlipH", false);
    this.disableFrontExposure = this.mCameraMatchPref.getBoolean("disableFrontExposure", false);
    this.disableBackExposure = this.mCameraMatchPref.getBoolean("disableBackExposure", false);
    this.frontExposureStepOne = this.mCameraMatchPref.getBoolean("frontExposureStepOne", false);
    this.backExposureStepOne = this.mCameraMatchPref.getBoolean("backExposureStepOne", false);
    this.deviceJpegDisable = this.mCameraMatchPref.getBoolean("deviceJpegDisable", false);
    this.es_GL_EXT_shader_framebuffer_fetch = this.mCameraMatchPref.getBoolean("es_GL_EXT_shader_framebuffer_fetch", true);
    this.cannotFlashWhileAutoFocus = this.mCameraMatchPref.getBoolean("cannotFlashWhileAutoFocus", false);
    this.frontCamCannotRotate = this.mCameraMatchPref.getBoolean("frontCamCannotRotate", false);
    this.readMaxNumMeteringAreasAbnormal = this.mCameraMatchPref.getBoolean("readMaxNumMeteringAreasAbnormal", false);
    this.readMaxNumFocusAreasAbnormal = this.mCameraMatchPref.getBoolean("readMaxNumFocusAreasAbnormal", false);
    this.cannotRotatePreview = this.mCameraMatchPref.getBoolean("cannotRotatePreview", false);
    this.cannotFlashWhileFlashOn = this.mCameraMatchPref.getBoolean("cannotFlashWhileFlashOn", false);
    this.backCamCannotRotate = this.mCameraMatchPref.getBoolean("backCamCannotRotate", false);
    LogUtils.i(TAG, "[loadAttrsFromPref] + END");
    AppMethodBeat.o(49827);
  }
  
  private void logAttrsValues()
  {
    AppMethodBeat.i(49828);
    LogUtils.i(TAG, "DeviceAttrs start-------------------------------------------------------------");
    LogUtils.i(TAG, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
    LogUtils.d(TAG, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
    LogUtils.i(TAG, "DeviceAttrs disableCameraSDK = " + this.disableCameraSDK);
    LogUtils.i(TAG, "DeviceAttrs disableCameraVideo = " + this.disableCameraVideo);
    LogUtils.i(TAG, "DeviceAttrs enablePerformanceMonitor = " + this.enablePerformanceMonitor);
    LogUtils.i(TAG, "DeviceAttrs disableLiteEditor = " + this.disableLiteEditor);
    LogUtils.i(TAG, "DeviceAttrs readCamNumException = " + this.readCamNumException);
    LogUtils.i(TAG, "DeviceAttrs disableFrontCamera = " + this.disableFrontCamera);
    LogUtils.i(TAG, "DeviceAttrs beBlurredPreviewAfterTakePic = " + this.beBlurredPreviewAfterTakePic);
    LogUtils.i(TAG, "DeviceAttrs beBlurredPicAfterTakePic = " + this.beBlurredPicAfterTakePic);
    LogUtils.i(TAG, "DeviceAttrs enableFastCapture4FrontCamera = " + this.enableFastCapture4FrontCamera);
    LogUtils.i(TAG, "DeviceAttrs enableFastCapture4BackCamera = " + this.enableFastCapture4BackCamera);
    LogUtils.i(TAG, "DeviceAttrs str_videoPreview720Fps = " + this.str_videoPreview720Fps);
    LogUtils.i(TAG, "DeviceAttrs str_frontPreviewSize43 = " + this.str_frontPreviewSize43);
    LogUtils.i(TAG, "DeviceAttrs str_frontPreviewSize169 = " + this.str_frontPreviewSize169);
    LogUtils.i(TAG, "DeviceAttrs str_backPreviewSize43 = " + this.str_backPreviewSize43);
    LogUtils.i(TAG, "DeviceAttrs str_backPreviewSize169 = " + this.str_backPreviewSize169);
    LogUtils.i(TAG, "DeviceAttrs str_frontPictureSize43 = " + this.str_frontPictureSize43);
    LogUtils.i(TAG, "DeviceAttrs str_backPictureSize43 = " + this.str_backPictureSize43);
    LogUtils.i(TAG, "DeviceAttrs str_recordVideoSize = " + this.str_recordVideoSize);
    LogUtils.i(TAG, "DeviceAttrs disableBackFlashMode = " + this.disableBackFlashMode);
    LogUtils.i(TAG, "DeviceAttrs frontFlashModeException = " + this.frontFlashModeException);
    LogUtils.i(TAG, "DeviceAttrs backFlashModeException = " + this.backFlashModeException);
    LogUtils.i(TAG, "DeviceAttrs backFlashNoOn = " + this.backFlashNoOn);
    LogUtils.i(TAG, "DeviceAttrs backFlashNoAuto = " + this.backFlashNoAuto);
    LogUtils.i(TAG, "DeviceAttrs backFlashNoTorch = " + this.backFlashNoTorch);
    LogUtils.i(TAG, "DeviceAttrs frontFlashNoAuto = " + this.frontFlashNoAuto);
    LogUtils.i(TAG, "DeviceAttrs disableFocusMode = " + this.disableFocusMode);
    LogUtils.i(TAG, "DeviceAttrs disableFocusModeContinuousPicture = " + this.disableFocusModeContinuousPicture);
    LogUtils.i(TAG, "DeviceAttrs disableAutoFocusDouble = " + this.disableAutoFocusDouble);
    LogUtils.i(TAG, "DeviceAttrs disableFaceDetection = " + this.disableFaceDetection);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate0 = " + this.int_frontCamRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate90 = " + this.int_frontCamRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate180 = " + this.int_frontCamRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_frontCamRotate270 = " + this.int_frontCamRotate270);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate0 = " + this.int_backCamRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate90 = " + this.int_backCamRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate180 = " + this.int_backCamRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_backCamRotate270 = " + this.int_backCamRotate270);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate0 = " + this.int_frontExifRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate90 = " + this.int_frontExifRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate180 = " + this.int_frontExifRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_frontExifRotate270 = " + this.int_frontExifRotate270);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate0 = " + this.int_backExifRotate0);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate90 = " + this.int_backExifRotate90);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate180 = " + this.int_backExifRotate180);
    LogUtils.i(TAG, "DeviceAttrs int_backExifRotate270 = " + this.int_backExifRotate270);
    LogUtils.i(TAG, "DeviceAttrs frontCamFlipH = " + this.frontCamFlipH);
    LogUtils.i(TAG, "DeviceAttrs disableFrontExposure = " + this.disableFrontExposure);
    LogUtils.i(TAG, "DeviceAttrs disableBackExposure = " + this.disableBackExposure);
    LogUtils.i(TAG, "DeviceAttrs frontExposureStepOne = " + this.frontExposureStepOne);
    LogUtils.i(TAG, "DeviceAttrs backExposureStepOne = " + this.backExposureStepOne);
    LogUtils.i(TAG, "DeviceAttrs serverJpegEnable = " + this.serverJpegEnable);
    LogUtils.i(TAG, "DeviceAttrs deviceJpegDisable = " + this.deviceJpegDisable);
    LogUtils.i(TAG, "DeviceAttrs cannotFlashWhileAutoFocus = " + this.cannotFlashWhileAutoFocus);
    LogUtils.i(TAG, "DeviceAttrs frontCamCannotRotate = " + this.frontCamCannotRotate);
    LogUtils.i(TAG, "DeviceAttrs readMaxNumMeteringAreasAbnormal = " + this.readMaxNumMeteringAreasAbnormal);
    LogUtils.i(TAG, "DeviceAttrs readMaxNumFocusAreasAbnormal = " + this.readMaxNumFocusAreasAbnormal);
    LogUtils.i(TAG, "DeviceAttrs cannotRotatePreview = " + this.cannotRotatePreview);
    LogUtils.i(TAG, "DeviceAttrs cannotFlashWhileFlashOn = " + this.cannotFlashWhileFlashOn);
    LogUtils.i(TAG, "DeviceAttrs backCamCannotRotate = " + this.backCamCannotRotate);
    LogUtils.i(TAG, "DeviceAttrs end-------------------------------------------------------------");
    AppMethodBeat.o(49828);
  }
  
  private boolean openFastCaptureMode(Camera.Parameters paramParameters)
  {
    boolean bool2 = false;
    AppMethodBeat.i(49821);
    boolean bool1 = bool2;
    if (paramParameters != null)
    {
      bool1 = bool2;
      if (this.mFastCaptureKeys != null)
      {
        bool1 = bool2;
        if (this.mFastCaptureOnValues != null)
        {
          int i = 0;
          bool1 = false;
          while ((i < this.mFastCaptureKeys.size()) && (i < this.mFastCaptureOnValues.size()))
          {
            String str = (String)this.mFastCaptureKeys.get(i);
            if (paramParameters.get(str) != null)
            {
              paramParameters.set(str, (String)this.mFastCaptureOnValues.get(i));
              bool1 = true;
            }
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(49821);
    return bool1;
  }
  
  private void parseCurrentAttrsXML(String paramString)
  {
    AppMethodBeat.i(49826);
    LogUtils.i(TAG, "[parseCurrentAttrsXML] + BEGIN");
    if (TextUtils.isEmpty(paramString))
    {
      LogUtils.e(TAG, "[parseCurrentAttrsXML] sourceString is empty");
      AppMethodBeat.o(49826);
      return;
    }
    try
    {
      localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      localEditor = this.mCameraMatchPref.edit();
      paramString = Boolean.FALSE;
    }
    catch (XmlPullParserException paramString)
    {
      for (;;)
      {
        LogUtils.e(paramString);
        LogUtils.i(TAG, "[parseCurrentAttrsXML] + END");
        AppMethodBeat.o(49826);
        return;
        localEditor.putBoolean(paramString, Boolean.valueOf(Boolean.parseBoolean((String)localObject)).booleanValue());
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        XmlPullParser localXmlPullParser;
        int i;
        SharedPreferences.Editor localEditor;
        String str1;
        String str2;
        String str3;
        int j;
        LogUtils.e(paramString);
        continue;
        Object localObject = Boolean.TRUE;
        continue;
        localObject = paramString;
        if (str3.startsWith(str1))
        {
          LogUtils.d(TAG, "parseCurrentAttrsXML myPhoneType = " + str2 + ", subTagName = " + str3);
          j = localXmlPullParser.getAttributeCount();
          i = 0;
          localObject = paramString;
          if (i < j)
          {
            localObject = localXmlPullParser.getAttributeName(i);
            str1 = localXmlPullParser.getAttributeValue(i);
            if (((String)localObject).startsWith("int_")) {
              localEditor.putInt((String)localObject, Integer.valueOf(Integer.parseInt(str1)).intValue());
            }
            for (;;)
            {
              LogUtils.i(TAG, "parseCurrentAttrsXML(subNode) item[" + (i + 1) + "] name = " + (String)localObject + ", value = " + str1);
              i += 1;
              break;
              if (((String)localObject).startsWith("str_")) {
                localEditor.putString((String)localObject, String.valueOf(str1));
              } else {
                localEditor.putBoolean((String)localObject, Boolean.valueOf(Boolean.parseBoolean(str1)).booleanValue());
              }
            }
            do
            {
              if (!paramString.booleanValue()) {
                break;
              }
              localEditor.putBoolean("is_need_parse_xml", false);
              localEditor.apply();
              break;
            } while (i == 1);
            localObject = paramString;
            switch (i)
            {
            }
            localObject = paramString;
          }
        }
      }
    }
    i = localXmlPullParser.next();
    paramString = (String)localObject;
    break label661;
    str1 = localXmlPullParser.getName();
    str2 = DeviceInstance.getInstance().getDeviceName();
    str3 = str2 + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
    if (str1.equals(str2))
    {
      LogUtils.d(TAG, "parseCurrentAttrsXML myPhoneType = " + str2 + ", subTagName = " + str3);
      j = localXmlPullParser.getAttributeCount();
      i = 0;
      if (i < j)
      {
        paramString = localXmlPullParser.getAttributeName(i);
        localObject = localXmlPullParser.getAttributeValue(i);
        if (paramString.startsWith("int_")) {
          localEditor.putInt(paramString, Integer.valueOf(Integer.parseInt((String)localObject)).intValue());
        }
        for (;;)
        {
          LogUtils.i(TAG, "parseCurrentAttrsXML item[" + (i + 1) + "] name = " + paramString + ", value = " + (String)localObject);
          i += 1;
          break;
          if (!paramString.startsWith("str_")) {
            break label369;
          }
          localEditor.putString(paramString, String.valueOf(localObject));
        }
      }
    }
  }
  
  /* Error */
  private JSONObject parseFastCaptureFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 891
    //   5: invokestatic 278	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 412
    //   11: astore 4
    //   13: getstatic 287	com/tencent/ttpic/device/DeviceAttrs:PARSE_XML_DEBUG_MODE	Ljava/lang/Boolean;
    //   16: invokevirtual 418	java/lang/Boolean:booleanValue	()Z
    //   19: ifne +58 -> 77
    //   22: aload_0
    //   23: getfield 441	com/tencent/ttpic/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   26: ldc_w 893
    //   29: aload_0
    //   30: getfield 444	com/tencent/ttpic/device/DeviceAttrs:mSignature	Ljava/lang/String;
    //   33: invokestatic 898	com/tencent/ttpic/device/DeviceParser:parseFastCaptureFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_2
    //   42: astore_3
    //   43: aload_1
    //   44: ifnull +9 -> 53
    //   47: aload_1
    //   48: invokestatic 904	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   51: aload_2
    //   52: astore_3
    //   53: aload_3
    //   54: invokestatic 761	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +90 -> 147
    //   60: new 504	org/json/JSONObject
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 905	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: ldc_w 891
    //   72: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: areturn
    //   77: aload_0
    //   78: getfield 441	com/tencent/ttpic/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   81: invokevirtual 909	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   84: ldc_w 911
    //   87: invokevirtual 917	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: aload_1
    //   94: invokestatic 920	com/tencent/ttpic/baseutils/IOUtils:toString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: goto -59 -> 41
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_2
    //   108: aload_3
    //   109: invokestatic 875	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   112: aload 4
    //   114: astore_3
    //   115: aload_1
    //   116: ifnull -63 -> 53
    //   119: aload_1
    //   120: invokestatic 904	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   123: aload 4
    //   125: astore_3
    //   126: goto -73 -> 53
    //   129: astore_1
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokestatic 904	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   138: ldc_w 891
    //   141: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -80 -> 69
    //   152: astore_1
    //   153: goto -23 -> 130
    //   156: astore_3
    //   157: goto -51 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	DeviceAttrs
    //   36	84	1	localObject1	Object
    //   129	16	1	localObject2	Object
    //   146	1	1	localJSONException	JSONException
    //   148	1	1	localObject3	Object
    //   152	1	1	localObject4	Object
    //   1	134	2	localObject5	Object
    //   42	57	3	localObject6	Object
    //   103	6	3	localException1	Exception
    //   114	12	3	str1	String
    //   156	1	3	localException2	Exception
    //   11	113	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   13	37	103	java/lang/Exception
    //   77	91	103	java/lang/Exception
    //   13	37	129	finally
    //   77	91	129	finally
    //   60	69	146	org/json/JSONException
    //   93	98	152	finally
    //   108	112	152	finally
    //   93	98	156	java/lang/Exception
  }
  
  public void checkOnlineUpdate(String paramString, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    AppMethodBeat.i(49807);
    LogUtils.i(TAG, "[checkOnlineUpdate] + BEGIN, downloadUrl = ".concat(String.valueOf(paramString)));
    Object localObject = this.mBuildInFileDir + "phone_attrs_config.zip";
    String str = this.mCameraMatchPref.getString("black_list_url", null);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase(str))) {
      if (DeviceUpdate.httpDownloadFile(paramString, (String)localObject))
      {
        str = DeviceUpdate.unZip((String)localObject, this.mBuildInFileDir);
        if (!TextUtils.isEmpty(str))
        {
          LogUtils.d(TAG, "[checkOnlineUpdate] storageName = " + (String)localObject + ", mBuildInFileDir = " + this.mBuildInFileDir);
          localObject = this.mCameraMatchPref.edit();
          ((SharedPreferences.Editor)localObject).putString("black_list_url", paramString);
          ((SharedPreferences.Editor)localObject).apply();
          localObject = DeviceParser.parseCameraAttrsFile(this.mContext, str, DeviceInstance.getInstance().getDeviceName(), this.mSignature);
          LogUtils.d(TAG, "[checkOnlineUpdate] source = ".concat(String.valueOf(localObject)));
          if (localObject != null) {
            parseCurrentAttrsXML((String)localObject);
          }
          loadAttrsFromPref();
          logAttrsValues();
          if (paramUpdateListener != null) {
            paramUpdateListener.onSuccess(paramString + ", download and parse success");
          }
          paramString = new Intent();
          paramString.setAction("action_check_online_update_finish");
          this.mContext.sendBroadcast(paramString);
        }
      }
    }
    for (;;)
    {
      LogUtils.i(TAG, "[checkOnlineUpdate] + END");
      AppMethodBeat.o(49807);
      return;
      paramUpdateListener.onFailed(paramString + ", download success, but unZip failed");
      continue;
      paramUpdateListener.onFailed(paramString + ", download failed!");
      continue;
      if (paramUpdateListener != null) {
        paramUpdateListener.onFailed(paramString + ", this url has been downloaded, no need check update!");
      }
    }
  }
  
  public void checkVersion(String paramString1, String paramString2, String paramString3, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    AppMethodBeat.i(49808);
    LogUtils.i(TAG, "[checkVersion] + BEGIN");
    new Thread(new DeviceAttrs.1(this, paramString1, paramString2, paramString3, paramUpdateListener)).start();
    LogUtils.i(TAG, "[checkVersion] + END");
    AppMethodBeat.o(49808);
  }
  
  public void clearAllPreference()
  {
    AppMethodBeat.i(49817);
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().clear().apply();
    }
    AppMethodBeat.o(49817);
  }
  
  public long getMonitorEnableTime()
  {
    long l = 0L;
    AppMethodBeat.i(49815);
    if (this.mCameraMatchPref != null) {
      l = this.mCameraMatchPref.getLong("enable_performance_monitor_begin_time", 0L);
    }
    AppMethodBeat.o(49815);
    return l;
  }
  
  public String getPreviousUrl()
  {
    AppMethodBeat.i(49812);
    String str = "";
    if (this.mCameraMatchPref != null) {
      str = this.mCameraMatchPref.getString("black_list_url", "");
    }
    AppMethodBeat.o(49812);
    return str;
  }
  
  public SizeI getRecordVideoSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49813);
    SizeI localSizeI = new SizeI(paramInt1, paramInt2);
    Object localObject = getInstance().str_recordVideoSize;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\*");
      if (localObject.length < 2)
      {
        AppMethodBeat.o(49813);
        return localSizeI;
      }
      try
      {
        paramInt1 = Integer.parseInt(localObject[0]);
        localObject = new SizeI(Integer.parseInt(localObject[1]), paramInt1);
        AppMethodBeat.o(49813);
        return localObject;
      }
      catch (Exception localException)
      {
        LogUtils.e(TAG, "Parse record size error!");
      }
    }
    AppMethodBeat.o(49813);
    return localSizeI;
  }
  
  public void init(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49805);
    LogUtils.i(TAG, "[init] + BEGIN");
    long l = System.currentTimeMillis();
    this.mContext = paramContext;
    this.mSignature = paramString;
    if (paramContext.getFilesDir() != null) {
      this.mBuildInFileDir = (paramContext.getFilesDir().toString() + "/");
    }
    this.mCameraMatchPref = this.mContext.getSharedPreferences(getCameraPrefName(this.mContext), 0);
    if (this.mCameraMatchPref != null)
    {
      boolean bool = this.mCameraMatchPref.getBoolean("is_need_parse_xml", true);
      paramContext = DeviceInstance.getInstance().getDeviceName();
      LogUtils.d(TAG, "[FastCapture][init] deviceName = ".concat(String.valueOf(paramContext)));
      if (bool)
      {
        paramContext = DeviceParser.parseCameraAttrsFile(this.mContext, "phone_attrs_config.dat", paramContext, this.mSignature);
        if (paramContext != null) {
          parseCurrentAttrsXML(paramContext);
        }
      }
      loadAttrsFromPref();
      logAttrsValues();
    }
    LogUtils.i(TAG, "[init] + END, time cost = " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(49805);
  }
  
  public boolean isCameraSDKDisable()
  {
    boolean bool = false;
    AppMethodBeat.i(49811);
    if (this.mCameraMatchPref != null) {
      bool = this.mCameraMatchPref.getBoolean("pref_camerasdk_disable", false);
    }
    AppMethodBeat.o(49811);
    return bool;
  }
  
  public boolean isEnableEXTShaderFramebufferFetch()
  {
    AppMethodBeat.i(49819);
    boolean bool = getInstance().es_GL_EXT_shader_framebuffer_fetch;
    AppMethodBeat.o(49819);
    return bool;
  }
  
  public boolean isNativeJpegCompressEnable()
  {
    AppMethodBeat.i(49818);
    if ((getInstance().serverJpegEnable) && (!getInstance().deviceJpegDisable))
    {
      AppMethodBeat.o(49818);
      return true;
    }
    AppMethodBeat.o(49818);
    return false;
  }
  
  public void setMonitorEnableTime(long paramLong)
  {
    AppMethodBeat.i(49816);
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().putLong("enable_performance_monitor_begin_time", paramLong).apply();
    }
    AppMethodBeat.o(49816);
  }
  
  public void setRecordVideoSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49814);
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().putString("str_recordVideoSize", paramInt2 + "*" + paramInt1).apply();
    }
    AppMethodBeat.o(49814);
  }
  
  public void update(String paramString, DeviceAttrs.UpdateListener paramUpdateListener)
  {
    AppMethodBeat.i(49806);
    String str = DeviceInstance.getInstance().getDeviceName();
    LogUtils.d(TAG, "[update] deviceName = ".concat(String.valueOf(str)));
    str = DeviceParser.parseCameraAttrsFile(this.mContext, paramString, str, this.mSignature);
    LogUtils.d(TAG, "[update] source: ".concat(String.valueOf(str)));
    if (str != null) {
      parseCurrentAttrsXML(str);
    }
    loadAttrsFromPref();
    logAttrsValues();
    if (paramUpdateListener != null) {
      paramUpdateListener.onSuccess(paramString + ", parse and reload success");
    }
    paramString = new Intent();
    paramString.setAction("action_check_online_update_finish");
    if (this.mContext != null) {
      this.mContext.sendBroadcast(paramString);
    }
    AppMethodBeat.o(49806);
  }
  
  public boolean updateCameraParametersFastCapture(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(49810);
    paramBoolean = updateCameraParametersFastCapture(paramParameters, paramBoolean, false);
    AppMethodBeat.o(49810);
    return paramBoolean;
  }
  
  public boolean updateCameraParametersFastCapture(Camera.Parameters paramParameters, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(49809);
    boolean bool = false;
    if (isInFastCaptureWhiteList(paramBoolean1, paramBoolean2))
    {
      initFastCaptureKeyValue();
      paramBoolean2 = openFastCaptureMode(paramParameters);
      LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list YES, OPEN fast mode, isFrontCamera = " + paramBoolean1 + ", updated = " + paramBoolean2);
    }
    for (paramBoolean1 = paramBoolean2;; paramBoolean1 = bool)
    {
      AppMethodBeat.o(49809);
      return paramBoolean1;
      LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list NO, do NOTHING, isFrontCamera = ".concat(String.valueOf(paramBoolean1)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceAttrs
 * JD-Core Version:    0.7.0.1
 */
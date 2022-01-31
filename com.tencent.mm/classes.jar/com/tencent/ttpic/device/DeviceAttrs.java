package com.tencent.ttpic.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.LogUtils;
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
  public static final Boolean ENABLE_LOG = Boolean.valueOf(false);
  public static final int ENABLE_PERFORMANCE_MONITOR_THRESHOLD = 604800000;
  private static final DeviceAttrs INSTANCE = new DeviceAttrs();
  public static final String KEY_CAMERASDK_DISABLE = "pref_camerasdk_disable";
  public static final String KEY_CAMERASDK_FAILED_TIMES = "pref_camerasdk_open_failed_times";
  public static final String KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME = "enable_performance_monitor_begin_time";
  public static final String KEY_NEED_PARSE_XML = "is_need_parse_xml";
  public static final String KEY_URL_VALUE = "black_list_url";
  public static final String KEY_VERSION = "xml_version";
  public static final Boolean PARSE_XML_DEBUG_MODE = Boolean.valueOf(false);
  private static final String TAG;
  private static final Boolean TEST_URL = Boolean.valueOf(false);
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
  private boolean backCamCannotRotate = false;
  public boolean backExposureStepOne = false;
  public boolean backFlashModeException = false;
  public boolean backFlashNoAuto = false;
  public boolean backFlashNoOn = false;
  public boolean backFlashNoTorch = true;
  public boolean beBlurredPicAfterTakePic = false;
  public boolean beBlurredPreviewAfterTakePic = false;
  private boolean cannotFlashWhileAutoFocus = false;
  private boolean cannotFlashWhileFlashOn = false;
  private boolean cannotRotatePreview = false;
  public boolean deviceJpegDisable;
  public boolean disableAutoFocusDouble = false;
  public boolean disableBackCamera = false;
  public boolean disableBackExposure = false;
  public boolean disableBackFlashMode = false;
  public boolean disableCameraSDK = false;
  public boolean disableCameraVideo = false;
  public boolean disableFaceDetection = false;
  public boolean disableFocusMode = false;
  public boolean disableFocusModeContinuousPicture = false;
  public boolean disableFrontCamera = false;
  public boolean disableFrontExposure = false;
  public boolean disableLiteEditor = false;
  public boolean enableFastCapture4BackCamera = false;
  public boolean enableFastCapture4FrontCamera = false;
  public boolean enablePerformanceMonitor = false;
  private boolean frontCamCannotRotate = false;
  public boolean frontCamFlipH = false;
  public boolean frontExposureStepOne = false;
  public boolean frontFlashModeException = false;
  public boolean frontFlashNoAuto = false;
  public int int_backCamRotate0 = -1;
  public int int_backCamRotate180 = -1;
  public int int_backCamRotate270 = -1;
  public int int_backCamRotate90 = -1;
  public int int_backExifRotate0 = -1;
  public int int_backExifRotate180 = -1;
  public int int_backExifRotate270 = -1;
  public int int_backExifRotate90 = -1;
  public int int_frontCamRotate0 = -1;
  public int int_frontCamRotate180 = -1;
  public int int_frontCamRotate270 = -1;
  public int int_frontCamRotate90 = -1;
  public int int_frontExifRotate0 = -1;
  public int int_frontExifRotate180 = -1;
  public int int_frontExifRotate270 = -1;
  public int int_frontExifRotate90 = -1;
  private String mBuildInFileDir;
  private SharedPreferences mCameraMatchPref;
  private Context mContext;
  private List<String> mFastCaptureKeys;
  private List<String> mFastCaptureOnValues;
  private String mPrevUrl = "";
  private String mRequestUrl;
  private String mSignature;
  public boolean readCamNumException = false;
  private boolean readMaxNumFocusAreasAbnormal = false;
  private boolean readMaxNumMeteringAreasAbnormal = false;
  public boolean serverJpegEnable = true;
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
    TAG = DeviceAttrs.class.getSimpleName();
  }
  
  private DeviceAttrs()
  {
    if (TEST_URL.booleanValue()) {}
    for (String str = "http://test.xiangji.qq.com/services/cameraCoreSvr.php";; str = "http://xiangji.qq.com/services/cameraCoreSvr.php")
    {
      this.mRequestUrl = str;
      this.mFastCaptureKeys = new ArrayList();
      this.mFastCaptureOnValues = new ArrayList();
      return;
    }
  }
  
  private String getCameraPrefName(Context paramContext)
  {
    return paramContext.getPackageName() + "_preferences_camera_adapter";
  }
  
  public static DeviceAttrs getInstance()
  {
    return INSTANCE;
  }
  
  private void initFastCaptureKeyValue()
  {
    int j = 0;
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
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  private boolean isInFastCaptureWhiteList(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getInstance().enableFastCapture4FrontCamera;
    }
    return getInstance().enableFastCapture4BackCamera;
  }
  
  private void loadAttrsFromPref()
  {
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
    this.cannotFlashWhileAutoFocus = this.mCameraMatchPref.getBoolean("cannotFlashWhileAutoFocus", false);
    this.frontCamCannotRotate = this.mCameraMatchPref.getBoolean("frontCamCannotRotate", false);
    this.readMaxNumMeteringAreasAbnormal = this.mCameraMatchPref.getBoolean("readMaxNumMeteringAreasAbnormal", false);
    this.readMaxNumFocusAreasAbnormal = this.mCameraMatchPref.getBoolean("readMaxNumFocusAreasAbnormal", false);
    this.cannotRotatePreview = this.mCameraMatchPref.getBoolean("cannotRotatePreview", false);
    this.cannotFlashWhileFlashOn = this.mCameraMatchPref.getBoolean("cannotFlashWhileFlashOn", false);
    this.backCamCannotRotate = this.mCameraMatchPref.getBoolean("backCamCannotRotate", false);
    LogUtils.i(TAG, "[loadAttrsFromPref] + END");
  }
  
  private void logAttrsValues()
  {
    LogUtils.i(TAG, "DeviceAttrs start-------------------------------------------------------------");
    LogUtils.i(TAG, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
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
  }
  
  private boolean openFastCaptureMode(Camera.Parameters paramParameters)
  {
    boolean bool2 = false;
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
    return bool1;
  }
  
  private void parseCurrentAttrsXML(String paramString)
  {
    LogUtils.i(TAG, "[parseCurrentAttrsXML] + BEGIN");
    if (TextUtils.isEmpty(paramString))
    {
      LogUtils.e(TAG, "[parseCurrentAttrsXML] sourceString is empty");
      return;
    }
    try
    {
      localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      localEditor = this.mCameraMatchPref.edit();
      paramString = Boolean.valueOf(false);
    }
    catch (XmlPullParserException paramString)
    {
      for (;;)
      {
        LogUtils.e(paramString);
        LogUtils.i(TAG, "[parseCurrentAttrsXML] + END");
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
        Object localObject = Boolean.valueOf(true);
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
    break label645;
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
            break label352;
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
    //   2: ldc_w 399
    //   5: astore 4
    //   7: getstatic 278	com/tencent/ttpic/device/DeviceAttrs:PARSE_XML_DEBUG_MODE	Ljava/lang/Boolean;
    //   10: invokevirtual 405	java/lang/Boolean:booleanValue	()Z
    //   13: ifne +52 -> 65
    //   16: aload_0
    //   17: getfield 428	com/tencent/ttpic/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   20: ldc_w 857
    //   23: aload_0
    //   24: getfield 431	com/tencent/ttpic/device/DeviceAttrs:mSignature	Ljava/lang/String;
    //   27: invokestatic 862	com/tencent/ttpic/device/TemplateParser:parseFastCaptureFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_2
    //   36: astore_3
    //   37: aload_1
    //   38: ifnull +9 -> 47
    //   41: aload_1
    //   42: invokestatic 868	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   45: aload_2
    //   46: astore_3
    //   47: aload_3
    //   48: invokestatic 730	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +78 -> 129
    //   54: new 486	org/json/JSONObject
    //   57: dup
    //   58: aload_3
    //   59: invokespecial 869	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: aload_1
    //   64: areturn
    //   65: aload_0
    //   66: getfield 428	com/tencent/ttpic/device/DeviceAttrs:mContext	Landroid/content/Context;
    //   69: invokevirtual 873	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   72: ldc_w 875
    //   75: invokevirtual 881	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   78: astore_1
    //   79: aload_1
    //   80: astore_2
    //   81: aload_1
    //   82: invokestatic 884	com/tencent/ttpic/device/IOUtils:toString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: astore_2
    //   88: goto -53 -> 35
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: astore_2
    //   96: aload_3
    //   97: invokestatic 846	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   100: aload 4
    //   102: astore_3
    //   103: aload_1
    //   104: ifnull -57 -> 47
    //   107: aload_1
    //   108: invokestatic 868	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   111: aload 4
    //   113: astore_3
    //   114: goto -67 -> 47
    //   117: astore_1
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokestatic 868	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aconst_null
    //   130: areturn
    //   131: astore_1
    //   132: goto -14 -> 118
    //   135: astore_3
    //   136: goto -42 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	DeviceAttrs
    //   30	78	1	localObject1	Object
    //   117	10	1	localObject2	Object
    //   128	1	1	localJSONException	JSONException
    //   131	1	1	localObject3	Object
    //   1	122	2	localObject4	Object
    //   36	51	3	localObject5	Object
    //   91	6	3	localException1	Exception
    //   102	12	3	str1	String
    //   135	1	3	localException2	Exception
    //   5	107	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   7	31	91	java/lang/Exception
    //   65	79	91	java/lang/Exception
    //   7	31	117	finally
    //   65	79	117	finally
    //   54	63	128	org/json/JSONException
    //   81	86	131	finally
    //   96	100	131	finally
    //   81	86	135	java/lang/Exception
  }
  
  public void checkOnlineUpdate(String paramString, UpdateListener paramUpdateListener)
  {
    LogUtils.i(TAG, "[checkOnlineUpdate] + BEGIN, downloadUrl = " + paramString);
    Object localObject = this.mBuildInFileDir + "phone_attrs_config.zip";
    String str = this.mCameraMatchPref.getString("black_list_url", null);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase(str))) {
      if (NetworkUtils.httpDownloadFile(paramString, (String)localObject))
      {
        str = NetworkUtils.unZip((String)localObject, this.mBuildInFileDir);
        if (!TextUtils.isEmpty(str))
        {
          LogUtils.d(TAG, "[checkOnlineUpdate] storageName = " + (String)localObject + ", mBuildInFileDir = " + this.mBuildInFileDir);
          localObject = this.mCameraMatchPref.edit();
          ((SharedPreferences.Editor)localObject).putString("black_list_url", paramString);
          ((SharedPreferences.Editor)localObject).apply();
          localObject = TemplateParser.parseCameraAttrsFile(this.mContext, str, DeviceInstance.getInstance().getDeviceName(), this.mSignature);
          LogUtils.d(TAG, "[checkOnlineUpdate] source = " + (String)localObject);
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
  
  public void checkVersion(String paramString1, String paramString2, String paramString3, UpdateListener paramUpdateListener)
  {
    LogUtils.i(TAG, "[checkVersion] + BEGIN");
    new Thread(new DeviceAttrs.1(this, paramString1, paramString2, paramString3, paramUpdateListener)).start();
    LogUtils.i(TAG, "[checkVersion] + END");
  }
  
  public void clearAllPreference()
  {
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().clear().apply();
    }
  }
  
  public long getMonitorEnableTime()
  {
    long l = 0L;
    if (this.mCameraMatchPref != null) {
      l = this.mCameraMatchPref.getLong("enable_performance_monitor_begin_time", 0L);
    }
    return l;
  }
  
  public String getPreviousUrl()
  {
    String str = "";
    if (this.mCameraMatchPref != null) {
      str = this.mCameraMatchPref.getString("black_list_url", "");
    }
    return str;
  }
  
  public DeviceAttrs.SizeI getRecordVideoSize(int paramInt1, int paramInt2)
  {
    DeviceAttrs.SizeI localSizeI = new DeviceAttrs.SizeI(paramInt1, paramInt2);
    Object localObject = getInstance().str_recordVideoSize;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\*");
      if (localObject.length >= 2) {}
    }
    else
    {
      return localSizeI;
    }
    try
    {
      paramInt1 = Integer.parseInt(localObject[0]);
      localObject = new DeviceAttrs.SizeI(Integer.parseInt(localObject[1]), paramInt1);
      return localObject;
    }
    catch (Exception localException)
    {
      LogUtils.e(TAG, "Parse record size error!");
    }
    return localSizeI;
  }
  
  public void init(Context paramContext, String paramString)
  {
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
      LogUtils.d(TAG, "[FastCapture][init] deviceName = " + paramContext);
      if (bool)
      {
        paramContext = TemplateParser.parseCameraAttrsFile(this.mContext, "phone_attrs_config.dat", paramContext, this.mSignature);
        if (paramContext != null) {
          parseCurrentAttrsXML(paramContext);
        }
      }
      loadAttrsFromPref();
      logAttrsValues();
    }
    LogUtils.i(TAG, "[init] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public boolean isCameraSDKDisable()
  {
    boolean bool = false;
    if (this.mCameraMatchPref != null) {
      bool = this.mCameraMatchPref.getBoolean("pref_camerasdk_disable", false);
    }
    return bool;
  }
  
  public boolean isNativeJpegCompressEnable()
  {
    return (getInstance().serverJpegEnable) && (!getInstance().deviceJpegDisable);
  }
  
  public void setMonitorEnableTime(long paramLong)
  {
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().putLong("enable_performance_monitor_begin_time", paramLong).apply();
    }
  }
  
  public void setRecordVideoSize(int paramInt1, int paramInt2)
  {
    if (this.mCameraMatchPref != null) {
      this.mCameraMatchPref.edit().putString("str_recordVideoSize", paramInt2 + "*" + paramInt1).apply();
    }
  }
  
  public void update(String paramString, UpdateListener paramUpdateListener)
  {
    String str = DeviceInstance.getInstance().getDeviceName();
    LogUtils.d(TAG, "[update] deviceName = " + str);
    str = TemplateParser.parseCameraAttrsFile(this.mContext, paramString, str, this.mSignature);
    LogUtils.d(TAG, "[update] source: " + str);
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
  }
  
  public boolean updateCameraParametersFastCapture(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (isInFastCaptureWhiteList(paramBoolean))
    {
      initFastCaptureKeyValue();
      boolean bool = openFastCaptureMode(paramParameters);
      LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list YES, OPEN fast mode, isFrontCamera = " + paramBoolean + ", updated = " + bool);
      return bool;
    }
    LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list NO, do NOTHING, isFrontCamera = " + paramBoolean);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceAttrs
 * JD-Core Version:    0.7.0.1
 */
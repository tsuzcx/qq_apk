import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class aklj
{
  public static int a()
  {
    int j = 1;
    int i;
    if ((DeviceInfoUtil.getSystemTotalMemory() >>> 20 < 600L) || (DeviceInfoUtil.getCpuNumber() == 1)) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "getDeviceType,DeviceInfoUtil.getSystemTotalMemory() =" + (DeviceInfoUtil.getSystemTotalMemory() >>> 20) + ",DeviceInfoUtil.getCpuNumber() = " + DeviceInfoUtil.getCpuNumber() + ",phoneType = " + i);
      }
      return i;
      i = j;
      if (DeviceInfoUtil.getSystemTotalMemory() >>> 20 >= 1536.0D)
      {
        i = j;
        if (DeviceInfoUtil.getCpuNumber() >= 4) {
          i = 2;
        }
      }
    }
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times", i + 1).commit();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatisticConstants", 2, "sendPhotoPreviewSelectRateStatistic (" + paramInt1 + " ," + paramInt2 + ")");
    }
    SharedPreferences localSharedPreferences;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = localSharedPreferences.getLong("PhotoConst.last_send_select_rate_time_preview", 0L);
      long l2 = System.currentTimeMillis();
      paramInt1 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_count", 0) + paramInt1;
      paramInt2 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0) + paramInt2;
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_count", paramInt1 + "");
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_rate", paramInt1 / paramInt2 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PhotoConst.photopreviewactivity_send", false, 0L, 0L, localHashMap, "", false);
        localSharedPreferences.edit().putLong("PhotoConst.last_send_select_rate_time_preview", l2).putInt("PhotoConst.photopreviewactivity_send_pic_count", 0).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photopreviewactivity_send_pic_count", paramInt1).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", paramInt2).commit();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "userAlbumSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + ")");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_album_source_type", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumCount", paramInt1 + "");
      localHashMap.put("param_screnshot_qq_cnt", paramInt2 + "");
      localHashMap.put("param_screnshot_other_cnt", paramInt3 + "");
      localHashMap.put("param_appCount", paramInt4 + "");
      localHashMap.put("param_otherCount", paramInt5 + "");
      localHashMap.put("param_qq_collection_cnt", paramInt6 + "");
      localHashMap.put("param_qq_filerecv_cnt", paramInt8 + "");
      localHashMap.put("param_qq_image_cnt", paramInt7 + "");
      localHashMap.put("param_qq_zebra_cnt", paramInt9 + "");
      localHashMap.put("param_qq_favorite_cnt", paramInt10 + "");
      localHashMap.put("param_weixinCnt", paramInt11 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actAlbumPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_album_source_type", l2).commit();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + "," + paramInt12 + "," + paramInt13 + "),age = " + paramInt14 + ",gender = " + paramInt15 + ",userType = " + paramInt16);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_pic_source_type", 0L);
    long l2 = System.currentTimeMillis();
    paramInt1 = localSharedPreferences.getInt("PhotoConst.photolistactivity_systemalbum_send_count", 0) + paramInt1;
    paramInt2 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0) + paramInt2;
    paramInt3 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0) + paramInt3;
    paramInt5 = localSharedPreferences.getInt("PhotoConst.photolistactivity_other_send_count", 0) + paramInt5;
    paramInt4 = localSharedPreferences.getInt("PhotoConst.photolistactivity_app_send_count", 0) + paramInt4;
    paramInt6 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_collection_send_count", 0) + paramInt6;
    paramInt7 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_image_send_count", 0) + paramInt7;
    paramInt8 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0) + paramInt8;
    paramInt9 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0) + paramInt9;
    paramInt10 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0) + paramInt10;
    paramInt11 = localSharedPreferences.getInt("PhotoConst.photolistactivity_weixin_send_count", 0) + paramInt11;
    paramInt12 = localSharedPreferences.getInt("PhotoConst.photolistactivity_sougou_send_count", 0) + paramInt12;
    paramInt13 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0) + paramInt13;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumSendCount", paramInt1 + "");
      localHashMap.put("param_screnshotQQSendCount", paramInt2 + "");
      localHashMap.put("param_screnshotOtherSendCount", paramInt3 + "");
      localHashMap.put("param_otherSendCount", paramInt5 + "");
      localHashMap.put("param_appSendCount", paramInt4 + "");
      localHashMap.put("param_qq_collection_SendCount", paramInt6 + "");
      localHashMap.put("param_qq_image_SendCount", paramInt7 + "");
      localHashMap.put("param_qq_filerecv_SendCount", paramInt8 + "");
      localHashMap.put("param_qq_zebra_SendCount", paramInt9 + "");
      localHashMap.put("param_qq_favorite_SendCount", paramInt10 + "");
      localHashMap.put("param_weixinSendCount", paramInt11 + "");
      localHashMap.put("param_sougouSendCount", paramInt12 + "");
      localHashMap.put("param_qqpinyinSendCount", paramInt13 + "");
      localHashMap.put("param_age", paramInt14 + "");
      localHashMap.put("param_gender", paramInt15 + "");
      localHashMap.put("param_userType", paramInt16 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actDaySendPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_pic_source_type", l2).putInt("PhotoConst.photolistactivity_systemalbum_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0).putInt("PhotoConst.photolistactivity_other_send_count", 0).putInt("PhotoConst.photolistactivity_app_send_count", 0).putInt("PhotoConst.photolistactivity_qq_collection_send_count", 0).putInt("PhotoConst.photolistactivity_qq_image_send_count", 0).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0).putInt("PhotoConst.photolistactivity_weixin_send_count", 0).putInt("PhotoConst.photolistactivity_sougou_send_count", 0).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photolistactivity_systemalbum_send_count", paramInt1).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", paramInt2).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", paramInt3).putInt("PhotoConst.photolistactivity_other_send_count", paramInt5).putInt("PhotoConst.photolistactivity_app_send_count", paramInt4).putInt("PhotoConst.photolistactivity_qq_collection_send_count", paramInt6).putInt("PhotoConst.photolistactivity_qq_image_send_count", paramInt7).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", paramInt8).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", paramInt9).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", paramInt10).putInt("PhotoConst.photolistactivity_weixin_send_count", paramInt11).putInt("PhotoConst.photolistactivity_sougou_send_count", paramInt12).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", paramInt13).commit();
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,size <= 0,return! size = " + paramLong);
      }
      return;
    }
    HashMap localHashMap = new HashMap();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      int k = a();
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_WasteSize", paramLong + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayWastedSize", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,WastedSize =" + paramLong);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      int k = a();
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_WasteSize", paramLong + "");
      localHashMap.put("param_cancelType", paramInt + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSWaste", false, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSWaste,size = " + paramLong + ",cancelType = " + paramInt);
      }
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong == 0L) || (paramInt == 0) || (paramLong > 86400000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,invalid arg,return!");
      }
      return;
    }
    long l = paramLong / paramInt;
    int j = a();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_phone_type", j + "");
      localHashMap.put("param_consumTime", paramLong + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_showing_progress", paramBoolean + "");
      localHashMap.put("param_averageTime", l + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdonecompressPic", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,param_consumTime =" + paramLong + ",param_selNum = " + paramInt + ",param_averageTime = " + l + ",isShowing = " + paramBoolean);
      return;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong1 > 86400000L) || (paramDouble < 0.0D) || (paramDouble > 1.0D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,invalid arg,return!");
      }
      return;
    }
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int k = a();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_aio_duration", paramLong1 + "");
      localHashMap.put("param_second_trans", paramBoolean + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_pic_filesize", paramLong2 + "");
      localHashMap.put("param_optimizePercent", paramDouble + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdoneaioduration", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,aioduration =" + paramLong1 + ",filesize = " + paramLong2 + ",isSecondTrans = " + paramBoolean + ",phoneType = " + k + ",percent = " + paramDouble);
      return;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    long l1 = paramIntent.getLongExtra("param_compressInitTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPScompressPic,initTime == 0,return!");
      }
    }
    long l2;
    int i;
    do
    {
      do
      {
        return;
        l2 = System.currentTimeMillis() - l1;
      } while (l2 > 86400000L);
      i = paramIntent.getIntExtra("param_selNum", 0);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_selNum == 0,return!");
    return;
    if (i > 0) {}
    for (l1 = l2 / i;; l1 = 0L)
    {
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", i + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPScompressPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_compressInitTime");
      paramIntent.removeExtra("param_selNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_consumTime =" + l2 + ",param_selNum = " + i + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSelectRateStatistic (" + paramInt + ")");
    }
    int i = paramIntent.getIntExtra("param_totalSelNum", 0);
    if ((paramInt > 0) && (i > 0))
    {
      paramIntent = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = paramIntent.getLong("PhotoConst.last_send_select_rate_time", 0L);
      long l2 = System.currentTimeMillis();
      paramInt = paramIntent.getInt("PhotoConst.photolistactivity_pic_count", 0) + paramInt;
      i += paramIntent.getInt("PhotoConst.photolistactivity_pic_total_count", 0);
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_sendCount", paramInt + "");
        localHashMap.put("param_selCount", i + "");
        localHashMap.put("param_sendPercent", paramInt / i + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdaySelSend", false, 0L, 0L, localHashMap, "", false);
        paramIntent.edit().putLong("PhotoConst.last_send_select_rate_time", l2).putInt("PhotoConst.photolistactivity_pic_count", 0).putInt("PhotoConst.photolistactivity_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    paramIntent.edit().putInt("PhotoConst.photolistactivity_pic_count", paramInt).putInt("PhotoConst.photolistactivity_pic_total_count", i).commit();
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    long l1 = paramIntent.getLongExtra("param_initTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,initTime == 0,return!");
      }
    }
    long l2;
    do
    {
      return;
      l2 = System.currentTimeMillis() - l1;
    } while (l2 > 86400000L);
    if (paramInt1 > 0) {}
    for (l1 = l2 / paramInt1;; l1 = 0L)
    {
      int i = paramIntent.getIntExtra("param_cancelSelNum", 0);
      HashMap localHashMap = new HashMap();
      int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_type", paramInt2 + "");
      localHashMap.put("param_cancelSelNum", i + "");
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", paramInt1 + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSselectSendPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,param_type =" + paramInt2 + ",param_cancelSelNum = " + i + ",param_consumTime = " + l2 + ",param_selNum = " + paramInt1 + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "incrementStatisticParam(" + paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra(paramString, paramIntent.getIntExtra(paramString, 0) + 1);
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getstatic 422	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   9: invokevirtual 428	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12: checkcast 430	axny
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +962 -> 979
    //   20: aload_2
    //   21: invokevirtual 431	axny:a	()I
    //   24: istore 4
    //   26: aload_2
    //   27: invokevirtual 434	axny:b	()I
    //   30: istore_3
    //   31: new 436	android/graphics/BitmapFactory$Options
    //   34: dup
    //   35: invokespecial 437	android/graphics/BitmapFactory$Options:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: iconst_1
    //   41: putfield 441	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   44: aload_0
    //   45: aload_2
    //   46: invokestatic 446	bheg:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: pop
    //   50: aload_2
    //   51: getfield 449	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: istore 7
    //   56: aload_2
    //   57: getfield 452	android/graphics/BitmapFactory$Options:outHeight	I
    //   60: istore 8
    //   62: iload 7
    //   64: i2l
    //   65: iload 8
    //   67: i2l
    //   68: invokestatic 457	bbkr:a	(JJ)I
    //   71: istore 9
    //   73: iload_1
    //   74: istore 5
    //   76: iload_1
    //   77: ifeq +24 -> 101
    //   80: iload_1
    //   81: istore 5
    //   83: iload_1
    //   84: iconst_1
    //   85: if_icmpeq +16 -> 101
    //   88: iload_1
    //   89: istore 5
    //   91: iload_1
    //   92: sipush 3000
    //   95: if_icmpeq +6 -> 101
    //   98: iconst_5
    //   99: istore 5
    //   101: aconst_null
    //   102: astore 17
    //   104: new 459	java/io/FileInputStream
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 461	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   112: astore 16
    //   114: aload 16
    //   116: new 463	java/io/File
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 464	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: invokevirtual 467	java/io/File:length	()J
    //   127: invokestatic 473	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   130: astore_2
    //   131: aload_2
    //   132: invokestatic 479	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   135: astore_2
    //   136: aload_2
    //   137: astore 17
    //   139: aload 17
    //   141: astore_2
    //   142: aload 16
    //   144: ifnull +11 -> 155
    //   147: aload 16
    //   149: invokevirtual 482	java/io/FileInputStream:close	()V
    //   152: aload 17
    //   154: astore_2
    //   155: aload_0
    //   156: invokestatic 488	com/tencent/mobileqq/utils/FileUtils:estimateFileType	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 16
    //   161: aload 16
    //   163: invokevirtual 493	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   166: ldc_w 495
    //   169: invokevirtual 499	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifeq +759 -> 931
    //   175: iconst_0
    //   176: istore_1
    //   177: invokestatic 504	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   180: bipush 11
    //   182: invokevirtual 508	java/util/Calendar:get	(I)I
    //   185: istore 10
    //   187: invokestatic 258	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   190: getstatic 264	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:picpredownload_whitelist	Lcom/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames;
    //   193: invokevirtual 267	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:name	()Ljava/lang/String;
    //   196: invokevirtual 270	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Z
    //   199: ifeq +737 -> 936
    //   202: sipush 1002
    //   205: istore 6
    //   207: invokestatic 149	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   210: ifeq +158 -> 368
    //   213: ldc 25
    //   215: iconst_4
    //   216: new 27	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 510
    //   226: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 512
    //   236: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload 5
    //   241: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 514
    //   247: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 9
    //   252: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 516
    //   258: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload 4
    //   263: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc 186
    //   268: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: iload_3
    //   272: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: ldc_w 518
    //   278: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: iload 10
    //   283: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: ldc_w 520
    //   289: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_2
    //   293: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 522
    //   299: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iload_1
    //   303: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: ldc_w 524
    //   309: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 16
    //   314: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 526
    //   320: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_0
    //   324: invokestatic 529	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   327: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 531
    //   333: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: iload 7
    //   338: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc_w 533
    //   344: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload 8
    //   349: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc 188
    //   354: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload 6
    //   359: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: new 117	java/util/HashMap
    //   371: dup
    //   372: invokespecial 118	java/util/HashMap:<init>	()V
    //   375: astore_0
    //   376: aload_0
    //   377: ldc_w 535
    //   380: new 27	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   387: iload 5
    //   389: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: ldc 120
    //   394: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: pop
    //   404: aload_0
    //   405: ldc_w 537
    //   408: new 27	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   415: iload 9
    //   417: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: ldc 120
    //   422: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   431: pop
    //   432: aload_0
    //   433: ldc 244
    //   435: new 27	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   442: iload 4
    //   444: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: ldc 120
    //   449: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   458: pop
    //   459: aload_0
    //   460: ldc 246
    //   462: new 27	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   469: iload_3
    //   470: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: ldc 120
    //   475: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload_0
    //   486: ldc 248
    //   488: new 27	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   495: iload 6
    //   497: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: ldc 120
    //   502: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   511: pop
    //   512: aload_0
    //   513: ldc_w 539
    //   516: aload_2
    //   517: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: aload_0
    //   522: ldc_w 541
    //   525: new 27	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   532: iload_1
    //   533: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc 120
    //   538: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   547: pop
    //   548: aload_0
    //   549: ldc_w 543
    //   552: new 27	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   559: iload 10
    //   561: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: ldc 120
    //   566: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   575: pop
    //   576: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   579: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   582: aconst_null
    //   583: ldc_w 545
    //   586: iconst_0
    //   587: lconst_0
    //   588: lconst_0
    //   589: aload_0
    //   590: ldc 120
    //   592: iconst_0
    //   593: invokevirtual 141	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   596: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   599: invokestatic 70	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   602: astore_0
    //   603: aload_0
    //   604: ldc_w 547
    //   607: lconst_0
    //   608: invokeinterface 104 4 0
    //   613: lstore 11
    //   615: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   618: lstore 13
    //   620: aload_0
    //   621: ldc_w 549
    //   624: iconst_0
    //   625: invokeinterface 78 3 0
    //   630: iconst_1
    //   631: iadd
    //   632: istore_1
    //   633: lload 13
    //   635: lload 11
    //   637: lsub
    //   638: ldc2_w 114
    //   641: lcmp
    //   642: ifle +302 -> 944
    //   645: new 117	java/util/HashMap
    //   648: dup
    //   649: invokespecial 118	java/util/HashMap:<init>	()V
    //   652: astore_2
    //   653: aload_2
    //   654: ldc 244
    //   656: new 27	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   663: iload 4
    //   665: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: ldc 120
    //   670: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: pop
    //   680: aload_2
    //   681: ldc 246
    //   683: new 27	java/lang/StringBuilder
    //   686: dup
    //   687: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   690: iload_3
    //   691: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: ldc 120
    //   696: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   705: pop
    //   706: aload_2
    //   707: ldc 248
    //   709: new 27	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   716: iload 6
    //   718: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   721: ldc 120
    //   723: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   732: pop
    //   733: aload_2
    //   734: ldc_w 551
    //   737: new 27	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   744: iload_1
    //   745: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: ldc 120
    //   750: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   759: pop
    //   760: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   763: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   766: aconst_null
    //   767: ldc_w 553
    //   770: iconst_0
    //   771: lconst_0
    //   772: lconst_0
    //   773: aload_2
    //   774: ldc 120
    //   776: iconst_0
    //   777: invokevirtual 141	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   780: aload_0
    //   781: invokeinterface 82 1 0
    //   786: ldc_w 547
    //   789: lload 13
    //   791: invokeinterface 145 4 0
    //   796: ldc_w 549
    //   799: iconst_0
    //   800: invokeinterface 88 3 0
    //   805: invokeinterface 91 1 0
    //   810: pop
    //   811: return
    //   812: astore_2
    //   813: new 463	java/io/File
    //   816: dup
    //   817: aload_0
    //   818: invokespecial 464	java/io/File:<init>	(Ljava/lang/String;)V
    //   821: astore_2
    //   822: aload_2
    //   823: invokevirtual 556	java/io/File:exists	()Z
    //   826: istore 15
    //   828: iload 15
    //   830: ifeq +144 -> 974
    //   833: aload_2
    //   834: invokestatic 561	bkvq:a	(Ljava/io/File;)Ljava/lang/String;
    //   837: astore_2
    //   838: aload_2
    //   839: ifnull +11 -> 850
    //   842: aload_2
    //   843: invokestatic 565	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   846: astore_2
    //   847: goto -716 -> 131
    //   850: ldc 120
    //   852: astore_2
    //   853: goto -11 -> 842
    //   856: astore_2
    //   857: aconst_null
    //   858: astore_2
    //   859: goto -728 -> 131
    //   862: astore_2
    //   863: aload_2
    //   864: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   867: aload 17
    //   869: astore_2
    //   870: goto -715 -> 155
    //   873: astore_2
    //   874: aconst_null
    //   875: astore 16
    //   877: aload 17
    //   879: astore_2
    //   880: aload 16
    //   882: ifnull -727 -> 155
    //   885: aload 16
    //   887: invokevirtual 482	java/io/FileInputStream:close	()V
    //   890: aload 17
    //   892: astore_2
    //   893: goto -738 -> 155
    //   896: astore_2
    //   897: aload_2
    //   898: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   901: aload 17
    //   903: astore_2
    //   904: goto -749 -> 155
    //   907: astore_0
    //   908: aconst_null
    //   909: astore 16
    //   911: aload 16
    //   913: ifnull +8 -> 921
    //   916: aload 16
    //   918: invokevirtual 482	java/io/FileInputStream:close	()V
    //   921: aload_0
    //   922: athrow
    //   923: astore_2
    //   924: aload_2
    //   925: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   928: goto -7 -> 921
    //   931: iconst_1
    //   932: istore_1
    //   933: goto -756 -> 177
    //   936: sipush 1001
    //   939: istore 6
    //   941: goto -734 -> 207
    //   944: aload_0
    //   945: invokeinterface 82 1 0
    //   950: ldc_w 549
    //   953: iload_1
    //   954: invokeinterface 88 3 0
    //   959: invokeinterface 91 1 0
    //   964: pop
    //   965: return
    //   966: astore_0
    //   967: goto -56 -> 911
    //   970: astore_2
    //   971: goto -94 -> 877
    //   974: aconst_null
    //   975: astore_2
    //   976: goto -845 -> 131
    //   979: iconst_m1
    //   980: istore_3
    //   981: iconst_m1
    //   982: istore 4
    //   984: goto -953 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	987	0	paramString	String
    //   0	987	1	paramInt	int
    //   0	987	2	paramQQAppInterface	QQAppInterface
    //   30	951	3	i	int
    //   24	959	4	j	int
    //   74	314	5	k	int
    //   205	735	6	m	int
    //   54	283	7	n	int
    //   60	288	8	i1	int
    //   71	345	9	i2	int
    //   185	375	10	i3	int
    //   613	23	11	l1	long
    //   618	172	13	l2	long
    //   826	3	15	bool	boolean
    //   112	805	16	localObject	Object
    //   102	800	17	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   114	131	812	java/lang/UnsatisfiedLinkError
    //   833	838	856	java/io/IOException
    //   842	847	856	java/io/IOException
    //   147	152	862	java/io/IOException
    //   104	114	873	java/io/IOException
    //   885	890	896	java/io/IOException
    //   104	114	907	finally
    //   916	921	923	java/io/IOException
    //   114	131	966	finally
    //   131	136	966	finally
    //   813	828	966	finally
    //   833	838	966	finally
    //   842	847	966	finally
    //   114	131	970	java/io/IOException
    //   131	136	970	java/io/IOException
    //   813	828	970	java/io/IOException
  }
  
  private static void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramString == null) {
      return;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    for (;;)
    {
      try
      {
        bheg.a(paramString, (BitmapFactory.Options)localObject1);
        i1 = ((BitmapFactory.Options)localObject1).outWidth;
        i2 = ((BitmapFactory.Options)localObject1).outHeight;
        j = paramInt1;
        if (paramInt1 != 0)
        {
          j = paramInt1;
          if (paramInt1 != 1)
          {
            j = paramInt1;
            if (paramInt1 != 3000) {
              j = 5;
            }
          }
        }
        k = paramInt2;
        if (paramInt2 != 0)
        {
          k = paramInt2;
          if (paramInt2 != 1)
          {
            k = paramInt2;
            if (paramInt2 != 3000) {
              k = 5;
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          int i1;
          int i2;
          int j;
          int k;
          localObject1 = Environment.getExternalStorageDirectory().toString();
          if ((localObject1 != null) && (paramString.contains((CharSequence)localObject1)))
          {
            localObject1 = paramString.replace((CharSequence)localObject1, "");
            paramInt1 = ((String)localObject1).lastIndexOf("/");
            Object localObject2 = localObject1;
            if (paramInt1 != -1) {
              localObject2 = ((String)localObject1).substring(0, paramInt1);
            }
            localObject1 = ((String)localObject2).replace("/", "//");
            int i3 = Calendar.getInstance().get(11);
            paramInt2 = -1;
            localObject2 = new File(paramString);
            paramInt1 = paramInt2;
            if (!paramBoolean2)
            {
              paramInt1 = paramInt2;
              if (((File)localObject2).exists())
              {
                paramInt2 = (int)((System.currentTimeMillis() - ((File)localObject2).lastModified()) / 60000L);
                paramInt1 = paramInt2;
                if (paramInt2 == 0) {
                  paramInt1 = 1;
                }
              }
            }
            int i;
            if (paramString.toLowerCase(Locale.US).contains("gif"))
            {
              i = 0;
              paramInt2 = i;
              int m = i2;
              int n = i1;
              if (paramString.contains(AppConstants.SDCARD_AIO_FORWARD))
              {
                paramString = paramString.split("#");
                paramInt2 = i;
                m = i2;
                n = i1;
                if (paramString.length >= 4)
                {
                  n = Integer.parseInt(paramString[1]);
                  m = Integer.parseInt(paramString[2]);
                  if (Integer.parseInt(paramString[3]) != 3) {
                    continue;
                  }
                  paramInt2 = 0;
                }
              }
              i = bbkr.a(n, m);
              i1 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
              if (QLog.isDevelopLevel()) {
                QLog.d("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic url=" + (String)localObject1 + ",uinType = " + j + ",batchCnt = " + paramInt7 + ",sizeType = " + i + ",isRAW = " + paramBoolean1 + ",isForward = " + paramBoolean2 + ",age = " + paramInt3 + ",gender = " + paramInt4 + ",reprotHour = " + i3 + ",width = " + n + ",height = " + m + ",interval = " + paramInt1 + ",suffixType = " + paramInt2 + ",nettype = " + i1 + ",forwardSourceUinType = " + k + ",urlType = " + paramInt6 + ",userType = " + paramInt5 + ",fileName = " + ((File)localObject2).getName());
              }
              paramString = new HashMap();
              paramString.put("param_sourceDetailUrl", localObject1);
              paramString.put("param_uinType", j + "");
              paramString.put("param_forwardSourceUinType", k + "");
              paramString.put("param_picSizeType", i + "");
              paramString.put("param_isForward", paramBoolean2 + "");
              paramString.put("param_age", paramInt3 + "");
              paramString.put("param_gender", paramInt4 + "");
              paramString.put("param_userType", paramInt5 + "");
              paramString.put("param_picReportHour", i3 + "");
              paramString.put("param_picInterval", paramInt1 + "");
              paramString.put("param_isRAWPic", paramBoolean1 + "");
              paramString.put("param_fileName", ((File)localObject2).getName());
              paramString.put("param_picSuffixType", paramInt2 + "");
              paramString.put("param_netType", i1 + "");
              paramString.put("param_urlType", paramInt6 + "");
              paramString.put("param_picBatchCount", paramInt7 + "");
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPhotoSourceDetailUrl", false, 0L, 0L, paramString, "", false);
              return;
              localOutOfMemoryError = localOutOfMemoryError;
              QLog.e("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic OutOfMemoryError ");
            }
            else
            {
              i = 1;
              continue;
            }
            paramInt2 = 1;
          }
          else
          {
            localObject1 = paramString;
          }
        }
        catch (Exception paramString)
        {
          return;
        }
      }
    }
  }
  
  public static void a(String[] paramArrayOfString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfString == null) {}
    label189:
    do
    {
      return;
      paramQQAppInterface = (axny)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      int i15 = paramArrayOfString.length;
      int i10 = -1;
      int i11 = -1;
      if (paramQQAppInterface != null)
      {
        i10 = paramQQAppInterface.a();
        i11 = paramQQAppInterface.b();
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
      int i;
      int j;
      int i1;
      int m;
      int n;
      int i9;
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int i8;
      String str2;
      for (int i12 = 1002;; i12 = 1001)
      {
        i = 0;
        j = 0;
        i1 = 0;
        m = 0;
        n = 0;
        i9 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        int i16 = paramArrayOfString.length;
        int i13 = 0;
        for (;;)
        {
          if (i13 >= i16) {
            break label945;
          }
          str2 = paramArrayOfString[i13];
          if (str2 != null) {
            break;
          }
          i13 += 1;
        }
      }
      String str1 = str2.toLowerCase(Locale.US);
      String str3 = FileUtil.getFileDirectoryOf(str1);
      paramQQAppInterface = null;
      try
      {
        str1 = new File(str1).getParentFile().getName();
        paramQQAppInterface = str1;
      }
      catch (Exception localException)
      {
        int k;
        int i14;
        break label189;
      }
    } while ((str3 == null) || (paramQQAppInterface == null));
    if (str3.contains("/tencent/")) {
      if (str3.contains("/qq_collection/"))
      {
        i9 += 1;
        k = j;
        i14 = 1001;
        j = i;
        i = k;
        k = i14;
      }
    }
    for (;;)
    {
      a(str2, paramInt1, paramBoolean1, paramBoolean2, paramInt2, i10, i11, i12, k, i15);
      k = j;
      j = i;
      i = k;
      break;
      if ((paramQQAppInterface.equals("qq_images")) || (str3.contains("/mobileqq/photo")) || (str3.contains("/mobileqq/diskcache")) || (str3.contains("/AIO_FORWARD/")))
      {
        i2 += 1;
        i14 = i;
        k = 1002;
        i = j;
        j = i14;
      }
      else if (paramQQAppInterface.equals("qqfile_recv"))
      {
        i3 += 1;
        i14 = i;
        k = 1003;
        i = j;
        j = i14;
      }
      else if (paramQQAppInterface.equals("qq_favorite"))
      {
        i5 += 1;
        i14 = i;
        k = 1004;
        i = j;
        j = i14;
      }
      else if (str3.contains("/zebra/cache"))
      {
        i4 += 1;
        i14 = i;
        k = 1005;
        i = j;
        j = i14;
      }
      else if ((paramQQAppInterface.equals("weixin")) || (paramQQAppInterface.equals("wechat")) || (paramQQAppInterface.equals("micromsg")))
      {
        i6 += 1;
        i14 = i;
        k = 1006;
        i = j;
        j = i14;
      }
      else if (str3.contains("/qqinput/exp/"))
      {
        i8 += 1;
        i14 = i;
        k = 1013;
        i = j;
        j = i14;
      }
      else if (a(str3))
      {
        m += 1;
        i14 = i;
        k = 1007;
        i = j;
        j = i14;
      }
      else
      {
        n += 1;
        i14 = i;
        k = 1008;
        i = j;
        j = i14;
        continue;
        if (paramQQAppInterface.equals("qq_screenshot"))
        {
          i14 = j + 1;
          j = i;
          k = 1009;
          i = i14;
        }
        else if ((str3.contains("screenshot")) || (str3.contains(anvx.a(2131713733))) || (str3.contains(anvx.a(2131713736))) || (str3.equals("screen_cap")) || (str3.equals("ScreenCapture")))
        {
          i1 += 1;
          i14 = i;
          k = 1010;
          i = j;
          j = i14;
        }
        else if ((paramQQAppInterface.contains("camera")) || (paramQQAppInterface.equals("dcim")) || (paramQQAppInterface.equals("100MEDIA")) || (paramQQAppInterface.equals("100ANDRO")) || (paramQQAppInterface.contains(anvx.a(2131713732))) || (paramQQAppInterface.contains(anvx.a(2131713735))) || (paramQQAppInterface.contains(anvx.a(2131713734))))
        {
          k = 1011;
          i14 = i + 1;
          i = j;
          j = i14;
        }
        else if (str3.contains("/sogou/.expression/"))
        {
          i7 += 1;
          i14 = i;
          k = 1012;
          i = j;
          j = i14;
        }
        else if (a(str3))
        {
          m += 1;
          i14 = i;
          k = 1007;
          i = j;
          j = i14;
        }
        else
        {
          n += 1;
          i14 = i;
          k = 1008;
          i = j;
          j = i14;
        }
      }
    }
    label945:
    a(i, j, i1, m, n, i9, i2, i3, i4, i5, i6, i7, i8, i10, i11, i12);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = new String[14];
      arrayOfString[0] = "/weibo";
      arrayOfString[1] = "/sina/news/save/";
      arrayOfString[2] = "/faceq/";
      arrayOfString[3] = "/newsreader/";
      arrayOfString[4] = "/tieba";
      arrayOfString[5] = "/baidu";
      arrayOfString[6] = "/UCDownloads";
      arrayOfString[7] = "/taobao";
      arrayOfString[8] = "/news_article/";
      arrayOfString[9] = "/sohunewsdown/";
      arrayOfString[10] = "/pitu/";
      arrayOfString[11] = "/pins/";
      arrayOfString[12] = "/tumblr/";
      arrayOfString[13] = "/download";
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (paramString.contains(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendNomalCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate", 0L);
    long l2 = System.currentTimeMillis();
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i + "");
      int j = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
      localHashMap.put("param_cameraCount", j + "");
      if (j > 0) {
        localHashMap.put("param_sendPercent", i / j + "");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayCameraSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate", l2).putInt("PhotoConst.camerapreviewactivity_send_times", 0).putInt("PhotoConst.camerapreviewactivity_enter_times", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times", i).commit();
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    if (!paramIntent.hasExtra("param_initTime")) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          l = paramIntent.getLongExtra("param_initTime", 0L);
          if (l != 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("StatisticConstants", 2, "reportActPScancelSend,initTime == 0,return!");
        return;
        l = System.currentTimeMillis() - l;
      } while (l > 86400000L);
      HashMap localHashMap = new HashMap();
      int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      localHashMap.put("param_netType", i + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_residentTime", l + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPScancelSend", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScancelSend,param_residentTime =" + l + ",param_selNum = " + paramInt);
  }
  
  public static void c()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times_fast", i + 1).commit();
  }
  
  public static void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendFastImageCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate_fast", 0L);
    long l2 = System.currentTimeMillis();
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times_fast", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i + "");
      int j = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
      localHashMap.put("param_browseCount", j + "");
      if (j > 0) {
        localHashMap.put("param_sendPercent", i / j + "");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayQuickSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate_fast", l2).putInt("PhotoConst.camerapreviewactivity_send_times_fast", 0).putInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times_fast", i).commit();
  }
  
  public static void e()
  {
    HashMap localHashMap = new HashMap();
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      int k = a();
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_userType", i + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSCompressTimeOut", false, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportPresendCompressTimeOut");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklj
 * JD-Core Version:    0.7.0.1
 */
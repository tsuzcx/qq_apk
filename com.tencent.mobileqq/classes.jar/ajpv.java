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

public class ajpv
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
    //   6: bipush 106
    //   8: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11: checkcast 424	awhw
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +962 -> 978
    //   19: aload_2
    //   20: invokevirtual 425	awhw:a	()I
    //   23: istore 4
    //   25: aload_2
    //   26: invokevirtual 428	awhw:b	()I
    //   29: istore_3
    //   30: new 430	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 431	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: iconst_1
    //   40: putfield 435	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   43: aload_0
    //   44: aload_2
    //   45: invokestatic 440	bfvo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload_2
    //   50: getfield 444	android/graphics/BitmapFactory$Options:outWidth	I
    //   53: istore 7
    //   55: aload_2
    //   56: getfield 447	android/graphics/BitmapFactory$Options:outHeight	I
    //   59: istore 8
    //   61: iload 7
    //   63: i2l
    //   64: iload 8
    //   66: i2l
    //   67: invokestatic 452	baec:a	(JJ)I
    //   70: istore 9
    //   72: iload_1
    //   73: istore 5
    //   75: iload_1
    //   76: ifeq +24 -> 100
    //   79: iload_1
    //   80: istore 5
    //   82: iload_1
    //   83: iconst_1
    //   84: if_icmpeq +16 -> 100
    //   87: iload_1
    //   88: istore 5
    //   90: iload_1
    //   91: sipush 3000
    //   94: if_icmpeq +6 -> 100
    //   97: iconst_5
    //   98: istore 5
    //   100: aconst_null
    //   101: astore 17
    //   103: new 454	java/io/FileInputStream
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 456	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: astore 16
    //   113: aload 16
    //   115: new 458	java/io/File
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 459	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: invokevirtual 462	java/io/File:length	()J
    //   126: invokestatic 468	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   129: astore_2
    //   130: aload_2
    //   131: invokestatic 474	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   134: astore_2
    //   135: aload_2
    //   136: astore 17
    //   138: aload 17
    //   140: astore_2
    //   141: aload 16
    //   143: ifnull +11 -> 154
    //   146: aload 16
    //   148: invokevirtual 477	java/io/FileInputStream:close	()V
    //   151: aload 17
    //   153: astore_2
    //   154: aload_0
    //   155: invokestatic 483	com/tencent/mobileqq/utils/FileUtils:estimateFileType	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 16
    //   160: aload 16
    //   162: invokevirtual 488	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   165: ldc_w 490
    //   168: invokevirtual 494	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +759 -> 930
    //   174: iconst_0
    //   175: istore_1
    //   176: invokestatic 499	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   179: bipush 11
    //   181: invokevirtual 503	java/util/Calendar:get	(I)I
    //   184: istore 10
    //   186: invokestatic 258	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   189: getstatic 264	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:picpredownload_whitelist	Lcom/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames;
    //   192: invokevirtual 267	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:name	()Ljava/lang/String;
    //   195: invokevirtual 270	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Z
    //   198: ifeq +737 -> 935
    //   201: sipush 1002
    //   204: istore 6
    //   206: invokestatic 149	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   209: ifeq +158 -> 367
    //   212: ldc 25
    //   214: iconst_4
    //   215: new 27	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 505
    //   225: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 507
    //   235: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload 5
    //   240: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc_w 509
    //   246: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: iload 9
    //   251: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: ldc_w 511
    //   257: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iload 4
    //   262: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: ldc 186
    //   267: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: iload_3
    //   271: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: ldc_w 513
    //   277: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iload 10
    //   282: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   285: ldc_w 515
    //   288: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_2
    //   292: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 517
    //   298: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: iload_1
    //   302: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: ldc_w 519
    //   308: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 16
    //   313: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 521
    //   319: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_0
    //   323: invokestatic 524	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   326: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 526
    //   332: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 7
    //   337: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc_w 528
    //   343: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload 8
    //   348: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: ldc 188
    //   353: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: iload 6
    //   358: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: new 117	java/util/HashMap
    //   370: dup
    //   371: invokespecial 118	java/util/HashMap:<init>	()V
    //   374: astore_0
    //   375: aload_0
    //   376: ldc_w 530
    //   379: new 27	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   386: iload 5
    //   388: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: ldc 120
    //   393: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: aload_0
    //   404: ldc_w 532
    //   407: new 27	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   414: iload 9
    //   416: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: ldc 120
    //   421: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: pop
    //   431: aload_0
    //   432: ldc 244
    //   434: new 27	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   441: iload 4
    //   443: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   446: ldc 120
    //   448: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: pop
    //   458: aload_0
    //   459: ldc 246
    //   461: new 27	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   468: iload_3
    //   469: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: ldc 120
    //   474: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   483: pop
    //   484: aload_0
    //   485: ldc 248
    //   487: new 27	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   494: iload 6
    //   496: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: ldc 120
    //   501: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   510: pop
    //   511: aload_0
    //   512: ldc_w 534
    //   515: aload_2
    //   516: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   519: pop
    //   520: aload_0
    //   521: ldc_w 536
    //   524: new 27	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   531: iload_1
    //   532: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: ldc 120
    //   537: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   546: pop
    //   547: aload_0
    //   548: ldc_w 538
    //   551: new 27	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   558: iload 10
    //   560: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: ldc 120
    //   565: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   574: pop
    //   575: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   578: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   581: aconst_null
    //   582: ldc_w 540
    //   585: iconst_0
    //   586: lconst_0
    //   587: lconst_0
    //   588: aload_0
    //   589: ldc 120
    //   591: iconst_0
    //   592: invokevirtual 141	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   595: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   598: invokestatic 70	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   601: astore_0
    //   602: aload_0
    //   603: ldc_w 542
    //   606: lconst_0
    //   607: invokeinterface 104 4 0
    //   612: lstore 11
    //   614: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   617: lstore 13
    //   619: aload_0
    //   620: ldc_w 544
    //   623: iconst_0
    //   624: invokeinterface 78 3 0
    //   629: iconst_1
    //   630: iadd
    //   631: istore_1
    //   632: lload 13
    //   634: lload 11
    //   636: lsub
    //   637: ldc2_w 114
    //   640: lcmp
    //   641: ifle +302 -> 943
    //   644: new 117	java/util/HashMap
    //   647: dup
    //   648: invokespecial 118	java/util/HashMap:<init>	()V
    //   651: astore_2
    //   652: aload_2
    //   653: ldc 244
    //   655: new 27	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   662: iload 4
    //   664: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: ldc 120
    //   669: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   678: pop
    //   679: aload_2
    //   680: ldc 246
    //   682: new 27	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   689: iload_3
    //   690: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: ldc 120
    //   695: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   704: pop
    //   705: aload_2
    //   706: ldc 248
    //   708: new 27	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   715: iload 6
    //   717: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   720: ldc 120
    //   722: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   731: pop
    //   732: aload_2
    //   733: ldc_w 546
    //   736: new 27	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   743: iload_1
    //   744: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   747: ldc 120
    //   749: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   758: pop
    //   759: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   762: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   765: aconst_null
    //   766: ldc_w 548
    //   769: iconst_0
    //   770: lconst_0
    //   771: lconst_0
    //   772: aload_2
    //   773: ldc 120
    //   775: iconst_0
    //   776: invokevirtual 141	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   779: aload_0
    //   780: invokeinterface 82 1 0
    //   785: ldc_w 542
    //   788: lload 13
    //   790: invokeinterface 145 4 0
    //   795: ldc_w 544
    //   798: iconst_0
    //   799: invokeinterface 88 3 0
    //   804: invokeinterface 91 1 0
    //   809: pop
    //   810: return
    //   811: astore_2
    //   812: new 458	java/io/File
    //   815: dup
    //   816: aload_0
    //   817: invokespecial 459	java/io/File:<init>	(Ljava/lang/String;)V
    //   820: astore_2
    //   821: aload_2
    //   822: invokevirtual 551	java/io/File:exists	()Z
    //   825: istore 15
    //   827: iload 15
    //   829: ifeq +144 -> 973
    //   832: aload_2
    //   833: invokestatic 556	bjkf:a	(Ljava/io/File;)Ljava/lang/String;
    //   836: astore_2
    //   837: aload_2
    //   838: ifnull +11 -> 849
    //   841: aload_2
    //   842: invokestatic 560	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   845: astore_2
    //   846: goto -716 -> 130
    //   849: ldc 120
    //   851: astore_2
    //   852: goto -11 -> 841
    //   855: astore_2
    //   856: aconst_null
    //   857: astore_2
    //   858: goto -728 -> 130
    //   861: astore_2
    //   862: aload_2
    //   863: invokevirtual 563	java/io/IOException:printStackTrace	()V
    //   866: aload 17
    //   868: astore_2
    //   869: goto -715 -> 154
    //   872: astore_2
    //   873: aconst_null
    //   874: astore 16
    //   876: aload 17
    //   878: astore_2
    //   879: aload 16
    //   881: ifnull -727 -> 154
    //   884: aload 16
    //   886: invokevirtual 477	java/io/FileInputStream:close	()V
    //   889: aload 17
    //   891: astore_2
    //   892: goto -738 -> 154
    //   895: astore_2
    //   896: aload_2
    //   897: invokevirtual 563	java/io/IOException:printStackTrace	()V
    //   900: aload 17
    //   902: astore_2
    //   903: goto -749 -> 154
    //   906: astore_0
    //   907: aconst_null
    //   908: astore 16
    //   910: aload 16
    //   912: ifnull +8 -> 920
    //   915: aload 16
    //   917: invokevirtual 477	java/io/FileInputStream:close	()V
    //   920: aload_0
    //   921: athrow
    //   922: astore_2
    //   923: aload_2
    //   924: invokevirtual 563	java/io/IOException:printStackTrace	()V
    //   927: goto -7 -> 920
    //   930: iconst_1
    //   931: istore_1
    //   932: goto -756 -> 176
    //   935: sipush 1001
    //   938: istore 6
    //   940: goto -734 -> 206
    //   943: aload_0
    //   944: invokeinterface 82 1 0
    //   949: ldc_w 544
    //   952: iload_1
    //   953: invokeinterface 88 3 0
    //   958: invokeinterface 91 1 0
    //   963: pop
    //   964: return
    //   965: astore_0
    //   966: goto -56 -> 910
    //   969: astore_2
    //   970: goto -94 -> 876
    //   973: aconst_null
    //   974: astore_2
    //   975: goto -845 -> 130
    //   978: iconst_m1
    //   979: istore_3
    //   980: iconst_m1
    //   981: istore 4
    //   983: goto -953 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	986	0	paramString	String
    //   0	986	1	paramInt	int
    //   0	986	2	paramQQAppInterface	QQAppInterface
    //   29	951	3	i	int
    //   23	959	4	j	int
    //   73	314	5	k	int
    //   204	735	6	m	int
    //   53	283	7	n	int
    //   59	288	8	i1	int
    //   70	345	9	i2	int
    //   184	375	10	i3	int
    //   612	23	11	l1	long
    //   617	172	13	l2	long
    //   825	3	15	bool	boolean
    //   111	805	16	localObject	Object
    //   101	800	17	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   113	130	811	java/lang/UnsatisfiedLinkError
    //   832	837	855	java/io/IOException
    //   841	846	855	java/io/IOException
    //   146	151	861	java/io/IOException
    //   103	113	872	java/io/IOException
    //   884	889	895	java/io/IOException
    //   103	113	906	finally
    //   915	920	922	java/io/IOException
    //   113	130	965	finally
    //   130	135	965	finally
    //   812	827	965	finally
    //   832	837	965	finally
    //   841	846	965	finally
    //   113	130	969	java/io/IOException
    //   130	135	969	java/io/IOException
    //   812	827	969	java/io/IOException
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
        bfvo.a(paramString, (BitmapFactory.Options)localObject1);
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
              i = baec.a(n, m);
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
    label188:
    do
    {
      return;
      paramQQAppInterface = (awhw)paramQQAppInterface.getManager(106);
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
            break label944;
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
        break label188;
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
        else if ((str3.contains("screenshot")) || (str3.contains(amtj.a(2131713386))) || (str3.contains(amtj.a(2131713389))) || (str3.equals("screen_cap")) || (str3.equals("ScreenCapture")))
        {
          i1 += 1;
          i14 = i;
          k = 1010;
          i = j;
          j = i14;
        }
        else if ((paramQQAppInterface.contains("camera")) || (paramQQAppInterface.equals("dcim")) || (paramQQAppInterface.equals("100MEDIA")) || (paramQQAppInterface.equals("100ANDRO")) || (paramQQAppInterface.contains(amtj.a(2131713385))) || (paramQQAppInterface.contains(amtj.a(2131713388))) || (paramQQAppInterface.contains(amtj.a(2131713387))))
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
    label944:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpv
 * JD-Core Version:    0.7.0.1
 */
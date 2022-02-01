import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager.1;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletLockScreenActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66.MsgBody;

public class akyb
{
  public static long a;
  private static ArrayList<akyc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap(16);
  private static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 200L, 200L, 100L };
  private static long b;
  
  public static int a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      akyc localakyc = (akyc)jdField_a_of_type_JavaUtilArrayList.get(i);
      k = j;
      if (localakyc != null)
      {
        k = j;
        if (localakyc.jdField_c_of_type_Int == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 9;
    case 2: 
      return 4;
    case 3: 
      return 11;
    case 4: 
      return 8;
    case 5: 
      return 7;
    case 6: 
      return 6;
    case 8: 
      return 14;
    }
    return 5;
  }
  
  private static akyc a()
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilArrayList.size()) {
        break label54;
      }
      akyc localakyc = (akyc)jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localakyc != null)
      {
        localObject = localakyc;
        if (localakyc.jdField_c_of_type_Int == 1) {
          break;
        }
      }
      i += 1;
    }
    label54:
    return null;
  }
  
  public static akyc a(boolean paramBoolean)
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    akyc localakyc;
    if (paramBoolean)
    {
      i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label101;
        }
        localakyc = (akyc)jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localakyc != null)
        {
          localObject = localakyc;
          if (localakyc.jdField_c_of_type_Int == 0) {
            break;
          }
        }
        i -= 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilArrayList.size()) {
        break label101;
      }
      localakyc = (akyc)jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localakyc != null)
      {
        localObject = localakyc;
        if (localakyc.jdField_c_of_type_Int == 0) {
          break;
        }
      }
      i += 1;
    }
    label101:
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      int i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        akyc localakyc = (akyc)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localakyc == null) || (localakyc.jdField_c_of_type_Int == 1)) {
          jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, akyc paramakyc)
  {
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilArrayList == null) || (paramakyc == null) || (paramakyc.jdField_b_of_type_Int < 1) || (paramakyc.jdField_b_of_type_Int > 7) || (TextUtils.isEmpty(paramakyc.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "params error, pcPayDatas=" + jdField_a_of_type_JavaUtilArrayList + ",app=" + paramQQAppInterface + ",pcPayData=" + paramakyc);
      }
      return;
    }
    if (paramakyc.jdField_b_of_type_Int == 1) {
      jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "pay-pcpush", "payinvoke", null, 0, null);
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        jdField_a_of_type_JavaUtilArrayList.add(paramakyc);
        if (b(paramQQAppInterface))
        {
          if (jdField_a_of_type_Long != 0L) {
            VACDReportUtil.a(jdField_a_of_type_Long, null, "startForegroundPay", null, 0, null);
          }
          b(paramQQAppInterface);
          jdField_a_of_type_Long = 0L;
          b(paramQQAppInterface, paramakyc);
          return;
        }
      }
      if (jdField_a_of_type_Long != 0L) {
        VACDReportUtil.a(jdField_a_of_type_Long, null, "startBackgroundPay", null, 0, null);
      }
      c(paramQQAppInterface, paramakyc);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 4;
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qwallet.push", 2, "PCPayData is empty.");
        break label25;
      }
    }
    label25:
    while (paramQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      int k;
      int m;
      try
      {
        paramString = new JSONObject(paramString);
        k = paramString.optInt("module", 0);
        m = paramString.optInt("action", 0);
        if ((k < 1) || (k > 8) || (m < 1) || (m > 2)) {
          break label25;
        }
        if ((k != 1) || (m != 1)) {
          break label196;
        }
        paramString = paramQQAppInterface.getApp();
        if (Build.VERSION.SDK_INT <= 10) {
          break label191;
        }
        paramString = paramString.getSharedPreferences("qwallet_multi", i);
        if (paramString == null) {
          break label452;
        }
        paramString.edit().putBoolean("is_refresh_home", true).commit();
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if ((i == 0) || (!QWalletHelper.isQWalletProcessExist(paramQQAppInterface.getApp()))) {
        break;
      }
      if (k == 1)
      {
        paramString = "com.qwallet.refresh.home";
        b(paramQQAppInterface, paramString);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qwallet.push", 2, "Parsing PCPAYDATA throws JSONException.");
        return;
        label191:
        i = 0;
        continue;
        label196:
        if ((k == 1) && (m == 2))
        {
          bhmi.d(paramQQAppInterface.getApp().getFilesDir() + "/" + QWalletHelper.getRecommendFileName(paramQQAppInterface.getCurrentAccountUin()));
          bhmi.d(paramQQAppInterface.getApp().getFilesDir() + "/" + QWalletHelper.getRecommendFileName(paramQQAppInterface.getCurrentAccountUin()) + "_");
          i = 1;
          continue;
        }
        if ((k == 2) && (m == 1))
        {
          paramString = paramQQAppInterface.getApp();
          i = j;
          if (Build.VERSION.SDK_INT > 10) {
            i = 4;
          }
          paramString = paramString.getSharedPreferences("qwallet_multi", i);
          if (paramString == null) {
            break label457;
          }
          paramString.edit().putBoolean("is_refresh_center", true).commit();
          break label457;
        }
        if ((k == 2) && (m == 2))
        {
          bhmi.d(paramQQAppInterface.getApp().getFilesDir() + "/" + QWalletHelper.getPersonalInfoFileName(paramQQAppInterface.getCurrentAccountUin()));
          i = 1;
          continue;
        }
        if ((k != 8) || (m != 1)) {
          break label462;
        }
        ((alao)paramQQAppInterface.getManager(245)).b(0);
        break label462;
      }
      paramString = "com.qwallet.refresh.center";
      continue;
      label452:
      i = 1;
      continue;
      label457:
      i = 1;
      continue;
      label462:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "onQQForeground isFromGestureLock=" + paramBoolean);
    }
    if (paramQQAppInterface == null) {
      break label35;
    }
    label35:
    while (a(false) == null) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 1000)
    {
      MqqHandler localMqqHandler = ThreadManager.getSubThreadHandler();
      if (localMqqHandler == null) {
        break;
      }
      localMqqHandler.postDelayed(new QWalletPushManager.1(paramQQAppInterface), i);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (a(paramLong1, paramInt1, paramLong2, paramInt2))) {
      label17:
      return;
    }
    int i = -1;
    Object localObject = null;
    paramInt2 = i;
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramArrayOfByte = (submsgtype0x66.MsgBody)new submsgtype0x66.MsgBody().mergeFrom(paramArrayOfByte);
            paramInt1 = i;
            paramInt2 = i;
            if (paramArrayOfByte.uint32_type.has())
            {
              paramInt2 = i;
              paramInt1 = paramArrayOfByte.uint32_type.get();
            }
            paramInt2 = paramInt1;
            if (!paramArrayOfByte.bytes_push_data.has()) {
              break label708;
            }
            paramInt2 = paramInt1;
            paramArrayOfByte = paramArrayOfByte.bytes_push_data.get();
            if (paramArrayOfByte == null) {
              break label708;
            }
            paramInt2 = paramInt1;
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            if (QLog.isColorLevel()) {
              QLog.d("Q.qwallet.push", 2, "pushType = " + paramInt1);
            }
            if ((paramInt1 == -1) || (paramArrayOfByte == null)) {
              break;
            }
            switch (paramInt1)
            {
            case 4: 
            case 3: 
            case 6: 
            case 7: 
            default: 
              if (!QLog.isColorLevel()) {
                break label17;
              }
              QLog.w("Q.qwallet.push", 2, "Unknow pushType.");
              return;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            for (;;)
            {
              paramArrayOfByte.printStackTrace();
              paramInt1 = paramInt2;
              paramArrayOfByte = (byte[])localObject;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.qwallet.push", 2, "Parsing Msg0x210Sub0x66 data throws Exception.");
                paramInt1 = paramInt2;
                paramArrayOfByte = (byte[])localObject;
                continue;
                try
                {
                  localObject = new String(paramArrayOfByte, "UTF-8");
                  if (TextUtils.isEmpty((CharSequence)localObject)) {
                    break;
                  }
                  paramArrayOfByte = new akyc();
                  paramArrayOfByte.jdField_b_of_type_Long = System.currentTimeMillis();
                  localObject = new JSONObject((String)localObject);
                  paramArrayOfByte.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("tradeTime", 0L);
                  paramArrayOfByte.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("expTime", 0);
                  paramArrayOfByte.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("payType", 0);
                  paramArrayOfByte.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("notifyText");
                  localObject = ((JSONObject)localObject).optJSONObject("payData");
                  if (localObject != null) {
                    paramArrayOfByte.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
                  }
                  a(paramQQAppInterface, paramArrayOfByte);
                  return;
                }
                catch (Exception paramQQAppInterface) {}
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramQQAppInterface);
          return;
          try
          {
            a(paramQQAppInterface, new String(paramArrayOfByte, "UTF-8"));
            return;
          }
          catch (Exception paramQQAppInterface) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramQQAppInterface);
          return;
          try
          {
            localObject = new String(paramArrayOfByte, "UTF-8");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            paramArrayOfByte = new akyc();
            paramArrayOfByte.jdField_b_of_type_Long = System.currentTimeMillis();
            localObject = new JSONObject((String)localObject);
            paramArrayOfByte.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("tradeTime", 0L);
            paramArrayOfByte.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("expTime", 0);
            paramArrayOfByte.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("payType", 0);
            paramArrayOfByte.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("notifyText");
            JSONObject localJSONObject1 = new JSONObject();
            localJSONObject1.put("viewTag", "hbPackConfirm");
            localJSONObject1.put("comeForm", 2);
            localJSONObject1.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#pc@0001");
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.putOpt("push_data", ((JSONObject)localObject).optString("key", ""));
            localJSONObject1.put("extra_data", localJSONObject2.toString());
            paramArrayOfByte.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
            a(paramQQAppInterface, paramArrayOfByte);
            return;
          }
          catch (Exception paramQQAppInterface) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramQQAppInterface);
        return;
        try
        {
          paramQQAppInterface = new TroopTips0x857.GoldMsgTipsElem();
          paramQQAppInterface.mergeFrom(paramArrayOfByte);
          if ((!paramQQAppInterface.type.has()) || (paramQQAppInterface.type.get() != 3)) {
            break;
          }
          alda.a(0, paramQQAppInterface, null);
          return;
        }
        catch (Exception paramQQAppInterface) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramQQAppInterface.printStackTrace();
      return;
      label708:
      paramArrayOfByte = null;
    }
  }
  
  protected static boolean a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ??? = new StringBuilder(32);
    ((StringBuilder)???).append(paramLong1);
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(paramLong2);
    ((StringBuilder)???).append(paramInt2);
    String str = ((StringBuilder)???).toString();
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    paramLong1 = System.currentTimeMillis();
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      if (Math.abs(paramLong1 - jdField_b_of_type_Long) > 1800000L) {
        jdField_a_of_type_JavaUtilHashMap.clear();
      }
      while (!jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        jdField_a_of_type_JavaUtilHashMap.put(str, null);
        jdField_b_of_type_Long = paramLong1;
        return false;
      }
      return true;
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilArrayList == null)) {}
    label355:
    label358:
    for (;;)
    {
      return;
      boolean bool2 = bhrl.a(paramQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "startForegroundPay isScreenLock=" + bool2);
      }
      if (!bool2)
      {
        akyc localakyc = a();
        int i;
        if (localakyc == null)
        {
          if (jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            continue;
          }
          localakyc = (akyc)jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localakyc == null)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramQQAppInterface);
            return;
          }
          i = a(localakyc.jdField_b_of_type_Int);
          if (i == 0)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramQQAppInterface);
            return;
          }
          bool2 = PayBridgeActivity.a();
          if ((!bool2) || (QWalletHelper.isQWalletProcessExist(paramQQAppInterface.getApplication().getApplicationContext()))) {
            break label355;
          }
        }
        for (;;)
        {
          if (bool1) {
            break label358;
          }
          localakyc.jdField_c_of_type_Int = 1;
          try
          {
            paramQQAppInterface = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
            paramQQAppInterface.addFlags(872415232);
            paramQQAppInterface.putExtra("json", localakyc.jdField_a_of_type_JavaLangString);
            paramQQAppInterface.putExtra("callbackSn", "0");
            paramQQAppInterface.putExtra("payparmas_from_pcpush", true);
            paramQQAppInterface.putExtra("pay_requestcode", i);
            paramQQAppInterface.putExtra("payparmas_paytype", 2);
            paramQQAppInterface.putExtra("vacreport_key_seq", jdField_a_of_type_Long);
            BaseApplication.getContext().startActivity(paramQQAppInterface);
            return;
          }
          catch (Exception paramQQAppInterface)
          {
            localakyc.jdField_c_of_type_Int = 2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qwallet.push", 2, "Starting pay throws Exception.", paramQQAppInterface);
          return;
          bool2 = PayBridgeActivity.a();
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (!QWalletHelper.isQWalletProcessExist(paramQQAppInterface.getApplication().getApplicationContext())) {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (bool1)
          {
            long l = System.currentTimeMillis();
            bool2 = bool1;
            if (43200L * 1000L + localakyc.jdField_c_of_type_Long > l) {
              bool2 = false;
            }
          }
          if (bool2) {
            break;
          }
          localakyc.jdField_c_of_type_Int = 2;
          b(paramQQAppInterface);
          return;
          bool1 = bool2;
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, akyc paramakyc)
  {
    String str1;
    boolean bool1;
    if (bhrl.a(paramQQAppInterface.getApp()))
    {
      ((PowerManager)paramQQAppInterface.getApp().getSystemService("power")).newWakeLock(268435462, "Q.qwallet.push").acquire(10000L);
      String str2 = String.format(BaseApplication.getContext().getString(2131716108), new Object[] { Integer.valueOf(a()) });
      if (!TextUtils.isEmpty(paramakyc.jdField_b_of_type_JavaLangString))
      {
        str1 = paramakyc.jdField_b_of_type_JavaLangString;
        Intent localIntent = new Intent(paramQQAppInterface.getApp(), QWalletLockScreenActivity.class);
        localIntent.addFlags(67108864);
        localIntent.addFlags(268435456);
        localIntent.addFlags(262144);
        localIntent.addFlags(1073741824);
        localIntent.putExtra("title", str2);
        localIntent.putExtra("content", str1);
        localIntent.putExtra("time", bhsw.b(BaseApplication.getContext(), paramakyc.jdField_b_of_type_Long));
        paramQQAppInterface.getApp().startActivity(localIntent);
      }
    }
    else
    {
      bool1 = paramQQAppInterface.n();
      bool2 = mtd.d(paramQQAppInterface.getApp());
      boolean bool3 = paramQQAppInterface.d();
      boolean bool4 = paramQQAppInterface.w();
      boolean bool5 = bhhv.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "isRingerSilent=" + bool1 + ",isCalling=" + bool2 + ",isVideoChatting=" + bool3 + ",isRecordingPtt=" + bool4 + ",canDisturb=" + bool5);
      }
      if ((bool5) && (!bool2) && (!bool1) && (!bool3) && (!bool4))
      {
        if (paramQQAppInterface.c() != 0) {
          break label485;
        }
        bool1 = false;
        label327:
        if (paramQQAppInterface.d() != 0) {
          break label490;
        }
      }
    }
    label485:
    label490:
    for (boolean bool2 = false;; bool2 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "canPlaySound=" + bool1 + ",canVibrator=" + bool2);
      }
      if (bool2)
      {
        paramQQAppInterface = (Vibrator)paramQQAppInterface.getApp().getSystemService("vibrator");
        if (paramQQAppInterface != null) {
          paramQQAppInterface.vibrate(jdField_a_of_type_ArrayOfLong, -1);
        }
      }
      if (bool1)
      {
        paramQQAppInterface = ThemeUtil.getThemeVoiceRootPath();
        if (paramQQAppInterface == null) {
          break label495;
        }
        paramQQAppInterface = new File(paramQQAppInterface + File.separatorChar + "message.mp3");
        if (!paramQQAppInterface.exists()) {
          break label495;
        }
        bhkm.a(Uri.fromFile(paramQQAppInterface), false, true);
      }
      return;
      str1 = BaseApplication.getContext().getString(2131716107);
      break;
      bool1 = true;
      break label327;
    }
    label495:
    bhkm.a(2131230759, false);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new Intent(paramString);
    paramQQAppInterface.getApp().sendBroadcast(paramString);
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 78
    //   12: iconst_2
    //   13: ldc_w 650
    //   16: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: return
    //   20: lload_2
    //   21: iload 4
    //   23: lload 5
    //   25: iload 7
    //   27: invokestatic 267	akyb:a	(JIJI)Z
    //   30: ifeq +19 -> 49
    //   33: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -17 -> 19
    //   39: ldc 78
    //   41: iconst_2
    //   42: ldc_w 652
    //   45: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: return
    //   49: new 654	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody
    //   52: dup
    //   53: invokespecial 655	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:<init>	()V
    //   56: aload_1
    //   57: invokevirtual 656	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: checkcast 654	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody
    //   63: astore_1
    //   64: aload_1
    //   65: getfield 660	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:msg_online_push	Ltencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush;
    //   68: invokevirtual 663	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:has	()Z
    //   71: ifeq -52 -> 19
    //   74: aload_1
    //   75: getfield 660	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$MsgBody:msg_online_push	Ltencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush;
    //   78: invokevirtual 666	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   81: checkcast 662	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush
    //   84: astore 12
    //   86: aload 12
    //   88: ifnull -69 -> 19
    //   91: iconst_m1
    //   92: istore 4
    //   94: iconst_m1
    //   95: istore 7
    //   97: ldc_w 391
    //   100: astore 11
    //   102: ldc_w 391
    //   105: astore_1
    //   106: iconst_m1
    //   107: istore 8
    //   109: aload 12
    //   111: getfield 669	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_action	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 283	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   117: ifeq +13 -> 130
    //   120: aload 12
    //   122: getfield 669	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_action	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 285	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: istore 4
    //   130: aload 12
    //   132: getfield 672	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   135: invokevirtual 283	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   138: ifeq +13 -> 151
    //   141: aload 12
    //   143: getfield 672	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   146: invokevirtual 285	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   149: istore 7
    //   151: aload 11
    //   153: astore 10
    //   155: aload 12
    //   157: getfield 675	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:bytes_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   160: invokevirtual 292	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   163: ifeq +39 -> 202
    //   166: aload 12
    //   168: getfield 675	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:bytes_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   171: invokevirtual 295	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   174: astore 13
    //   176: aload 11
    //   178: astore 10
    //   180: aload 13
    //   182: ifnull +20 -> 202
    //   185: new 316	java/lang/String
    //   188: dup
    //   189: aload 13
    //   191: invokevirtual 301	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   194: ldc_w 318
    //   197: invokespecial 321	java/lang/String:<init>	([BLjava/lang/String;)V
    //   200: astore 10
    //   202: aload 12
    //   204: getfield 679	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_serialno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   207: invokevirtual 682	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   210: ifeq +12 -> 222
    //   213: aload 12
    //   215: getfield 679	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_serialno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   218: invokevirtual 684	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   221: astore_1
    //   222: aload 12
    //   224: getfield 687	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_billno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   227: invokevirtual 682	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   230: ifeq +12 -> 242
    //   233: aload 12
    //   235: getfield 687	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_billno	Lcom/tencent/mobileqq/pb/PBStringField;
    //   238: invokevirtual 684	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   241: astore_1
    //   242: aload 12
    //   244: getfield 690	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_appinfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   247: invokevirtual 682	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   250: ifeq +12 -> 262
    //   253: aload 12
    //   255: getfield 690	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_appinfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   258: invokevirtual 684	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   261: astore_1
    //   262: aload 12
    //   264: getfield 693	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_amount	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   267: invokevirtual 283	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   270: ifeq +13 -> 283
    //   273: aload 12
    //   275: getfield 693	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:uint32_amount	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   278: invokevirtual 285	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   281: istore 8
    //   283: aload 12
    //   285: getfield 696	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_jumpurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   288: invokevirtual 682	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   291: ifeq +12 -> 303
    //   294: aload 12
    //   296: getfield 696	tencent/im/s2c/msgtype0x210/submsgtype0x7e/submsgtype0x7e$WalletMsgPush:str_jumpurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   299: invokevirtual 684	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   302: astore_1
    //   303: new 140	org/json/JSONObject
    //   306: dup
    //   307: invokespecial 368	org/json/JSONObject:<init>	()V
    //   310: astore 11
    //   312: new 140	org/json/JSONObject
    //   315: dup
    //   316: invokespecial 368	org/json/JSONObject:<init>	()V
    //   319: astore 12
    //   321: new 140	org/json/JSONObject
    //   324: dup
    //   325: aload 10
    //   327: invokespecial 143	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   330: astore 13
    //   332: aload 12
    //   334: ldc 151
    //   336: iload 4
    //   338: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   341: pop
    //   342: aload 12
    //   344: ldc_w 698
    //   347: aload 13
    //   349: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   352: pop
    //   353: aload 11
    //   355: ldc_w 700
    //   358: aload_0
    //   359: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   362: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   365: pop
    //   366: aload 11
    //   368: ldc_w 370
    //   371: ldc_w 702
    //   374: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   377: pop
    //   378: aload 11
    //   380: ldc_w 383
    //   383: ldc_w 704
    //   386: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   389: pop
    //   390: aload 11
    //   392: ldc_w 399
    //   395: aload 12
    //   397: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   400: pop
    //   401: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +30 -> 434
    //   407: ldc 78
    //   409: iconst_2
    //   410: new 80	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 706
    //   420: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 11
    //   425: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload_0
    //   435: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   438: astore 13
    //   440: getstatic 162	android/os/Build$VERSION:SDK_INT	I
    //   443: bipush 10
    //   445: if_icmple +462 -> 907
    //   448: iconst_4
    //   449: istore 9
    //   451: aload 13
    //   453: ldc 164
    //   455: iload 9
    //   457: invokevirtual 170	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   460: astore 13
    //   462: aload 13
    //   464: ifnull +87 -> 551
    //   467: aload_0
    //   468: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   471: astore_0
    //   472: aload 13
    //   474: new 80	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 708
    //   484: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload_0
    //   488: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: lconst_0
    //   495: invokeinterface 711 4 0
    //   500: lstore_2
    //   501: invokestatic 716	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   504: ldc2_w 507
    //   507: ldiv
    //   508: lstore 5
    //   510: lload 5
    //   512: lload_2
    //   513: lcmp
    //   514: ifge +295 -> 809
    //   517: aload 13
    //   519: invokeinterface 176 1 0
    //   524: new 80	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   531: ldc_w 708
    //   534: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_0
    //   538: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: lconst_0
    //   545: invokeinterface 720 4 0
    //   550: pop
    //   551: new 722	android/os/Bundle
    //   554: dup
    //   555: invokespecial 723	android/os/Bundle:<init>	()V
    //   558: astore_0
    //   559: aload_0
    //   560: ldc_w 473
    //   563: aload 11
    //   565: invokevirtual 357	org/json/JSONObject:toString	()Ljava/lang/String;
    //   568: invokevirtual 727	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: aload_0
    //   572: ldc_w 479
    //   575: ldc_w 481
    //   578: invokevirtual 727	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: new 460	android/content/Intent
    //   584: dup
    //   585: invokestatic 463	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   588: ldc_w 446
    //   591: invokespecial 466	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   594: astore 12
    //   596: aload 12
    //   598: ldc_w 552
    //   601: invokevirtual 471	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   604: pop
    //   605: aload 12
    //   607: aload_0
    //   608: invokevirtual 731	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   611: pop
    //   612: aload 12
    //   614: ldc_w 488
    //   617: iconst_5
    //   618: invokevirtual 491	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   621: pop
    //   622: invokestatic 463	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   625: aload 12
    //   627: invokevirtual 502	com/tencent/qphone/base/util/BaseApplication:startActivity	(Landroid/content/Intent;)V
    //   630: invokestatic 734	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   633: ifeq -614 -> 19
    //   636: ldc 78
    //   638: iconst_4
    //   639: new 80	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 736
    //   649: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: iload 4
    //   654: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: ldc_w 738
    //   660: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: iload 7
    //   665: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: ldc_w 740
    //   671: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 10
    //   676: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc_w 742
    //   682: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_1
    //   686: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 744
    //   692: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc_w 391
    //   698: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc_w 746
    //   704: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc_w 391
    //   710: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: ldc_w 748
    //   716: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: iload 8
    //   721: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   724: ldc_w 750
    //   727: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: ldc_w 391
    //   733: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: ldc_w 752
    //   739: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 11
    //   744: invokevirtual 357	org/json/JSONObject:toString	()Ljava/lang/String;
    //   747: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 755	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: return
    //   757: astore_0
    //   758: aload_0
    //   759: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   762: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   765: ifeq -746 -> 19
    //   768: ldc 78
    //   770: iconst_2
    //   771: ldc_w 757
    //   774: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: return
    //   778: astore 13
    //   780: invokestatic 734	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   783: ifeq +8 -> 791
    //   786: aload 13
    //   788: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   791: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   794: ifeq -360 -> 434
    //   797: ldc 78
    //   799: iconst_2
    //   800: ldc_w 757
    //   803: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: goto -372 -> 434
    //   809: lload 5
    //   811: lload_2
    //   812: lsub
    //   813: ldc2_w 758
    //   816: lcmp
    //   817: ifge -266 -> 551
    //   820: new 140	org/json/JSONObject
    //   823: dup
    //   824: invokespecial 368	org/json/JSONObject:<init>	()V
    //   827: astore_0
    //   828: aload_0
    //   829: ldc_w 761
    //   832: iconst_0
    //   833: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   836: pop
    //   837: aload_0
    //   838: ldc_w 763
    //   841: ldc_w 391
    //   844: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   847: pop
    //   848: aload_0
    //   849: ldc_w 765
    //   852: iconst_4
    //   853: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   856: pop
    //   857: aload_0
    //   858: ldc_w 767
    //   861: aload 12
    //   863: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   866: pop
    //   867: new 769	aznf
    //   870: dup
    //   871: iconst_4
    //   872: iconst_0
    //   873: aload_0
    //   874: invokevirtual 357	org/json/JSONObject:toString	()Ljava/lang/String;
    //   877: invokespecial 772	aznf:<init>	(IILjava/lang/String;)V
    //   880: astore_0
    //   881: invokestatic 778	com/tencent/mobileqq/openapi/OpenApiManager:getInstance	()Lcom/tencent/mobileqq/openapi/OpenApiManager;
    //   884: aload_0
    //   885: invokevirtual 782	com/tencent/mobileqq/openapi/OpenApiManager:onPayMsgRsp	(Laznf;)V
    //   888: goto -337 -> 551
    //   891: astore 12
    //   893: invokestatic 734	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   896: ifeq -29 -> 867
    //   899: aload 12
    //   901: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   904: goto -37 -> 867
    //   907: iconst_0
    //   908: istore 9
    //   910: goto -459 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	913	0	paramQQAppInterface	QQAppInterface
    //   0	913	1	paramArrayOfByte	byte[]
    //   0	913	2	paramLong1	long
    //   0	913	4	paramInt1	int
    //   0	913	5	paramLong2	long
    //   0	913	7	paramInt2	int
    //   107	613	8	i	int
    //   449	460	9	j	int
    //   153	522	10	localObject1	Object
    //   100	643	11	localObject2	Object
    //   84	778	12	localObject3	Object
    //   891	9	12	localException1	Exception
    //   174	344	13	localObject4	Object
    //   778	9	13	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   49	86	757	java/lang/Exception
    //   109	130	757	java/lang/Exception
    //   130	151	757	java/lang/Exception
    //   155	176	757	java/lang/Exception
    //   185	202	757	java/lang/Exception
    //   202	222	757	java/lang/Exception
    //   222	242	757	java/lang/Exception
    //   242	262	757	java/lang/Exception
    //   262	283	757	java/lang/Exception
    //   283	303	757	java/lang/Exception
    //   303	321	757	java/lang/Exception
    //   434	448	757	java/lang/Exception
    //   451	462	757	java/lang/Exception
    //   467	510	757	java/lang/Exception
    //   517	551	757	java/lang/Exception
    //   551	756	757	java/lang/Exception
    //   780	791	757	java/lang/Exception
    //   791	806	757	java/lang/Exception
    //   820	828	757	java/lang/Exception
    //   867	888	757	java/lang/Exception
    //   893	904	757	java/lang/Exception
    //   321	434	778	java/lang/Exception
    //   828	867	891	java/lang/Exception
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 == null) {
      return false;
    }
    boolean bool = GesturePWDUtils.getGestureLocking((Context)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "isQQForeground isQQLock=" + bool);
    }
    if ((paramQQAppInterface == null) || (bool)) {
      return false;
    }
    if (!paramQQAppInterface.isBackgroundPause) {
      return true;
    }
    try
    {
      Object localObject2 = (ActivityManager)((Context)localObject1).getApplicationContext().getSystemService("activity");
      if (localObject2 == null) {
        return false;
      }
      paramQQAppInterface = ((Context)localObject1).getApplicationContext().getPackageName();
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return false;
      }
      localObject1 = ((ActivityManager)localObject2).getRunningAppProcesses();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null))
        {
          if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface + ":video")) {
            return false;
          }
          if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface))
          {
            bool = ((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(paramQQAppInterface + ":");
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return false;
    }
    return false;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, akyc paramakyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "startBackgroundPay");
    }
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramakyc == null)) {}
    for (;;)
    {
      return;
      String str = String.format(BaseApplication.getContext().getString(2131716108), new Object[] { Integer.valueOf(a()) });
      Object localObject = paramakyc.jdField_b_of_type_JavaLangString;
      paramakyc = (akyc)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramakyc = BaseApplication.getContext().getString(2131716107);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("callbackSn", "0");
      ((Bundle)localObject).putBoolean("payparmas_from_pcpush", true);
      ((Bundle)localObject).putInt("pay_requestcode", 12);
      ((Bundle)localObject).putInt("payparmas_paytype", 2);
      ((Bundle)localObject).putLong("vacreport_key_seq", jdField_a_of_type_Long);
      Intent localIntent = new Intent(paramQQAppInterface.getApp(), PayBridgeActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("param_notifyid", 238);
      paramQQAppInterface = PendingIntent.getActivity(paramQQAppInterface.getApp(), 12, localIntent, 1073741824);
      try
      {
        paramQQAppInterface = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_SHOW_BADGE").setSmallIcon(2130841402).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(str).setContentText(paramakyc).setContentIntent(paramQQAppInterface).build();
        paramakyc = QQNotificationManager.getInstance();
        if (paramakyc != null)
        {
          paramakyc.cancel("Q.qwallet.push", 238);
          paramakyc.notify("Q.qwallet.push", 238, paramQQAppInterface);
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("QWalletPushManager", 1, paramQQAppInterface, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyb
 * JD-Core Version:    0.7.0.1
 */
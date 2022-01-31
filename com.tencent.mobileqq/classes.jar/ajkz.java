import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager.1;
import com.tencent.mobileqq.app.IndividualRedPacketManager.2;
import com.tencent.mobileqq.app.IndividualRedPacketManager.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class ajkz
  implements Manager
{
  public static int a;
  public static String a;
  public static String c;
  private static String jdField_d_of_type_JavaLangString = "IndividualRedPacketManager";
  public static int k;
  public static int l = -1;
  public static int m;
  public static int n = -1;
  float jdField_a_of_type_Float = 0.0F;
  ajlc jdField_a_of_type_Ajlc;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public bani a;
  ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  public Comparator<File> a;
  public LinkedList<String> a;
  public ConcurrentHashMap<String, CustomizeStrategyFactory.RedPacketInfo> a;
  public AtomicBoolean a;
  float jdField_b_of_type_Float;
  public int b;
  SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  public String b;
  public AtomicBoolean b;
  int c;
  public AtomicBoolean c;
  int jdField_d_of_type_Int = 0;
  AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int jdField_e_of_type_Int = 0;
  AtomicBoolean jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int f = 0;
  int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aU + "RedPacket/";
    jdField_a_of_type_Int = 10029;
    jdField_c_of_type_JavaLangString = "0";
  }
  
  public ajkz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilComparator = new ajla(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    SharedPreferences localSharedPreferences = a();
    a(localSharedPreferences.getInt("sp_vip_info_can_use_packet", 0), localSharedPreferences.getInt("sp_vip_info_red_packet_disable", 0), false);
    a(localSharedPreferences.getInt("sp_vip_info_red_packet_id", -1), localSharedPreferences.getString("sp_vip_info_red_packet_text", null));
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForRedPacket();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_Float = paramQQAppInterface.getApp().getApplicationContext().getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(138.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_c_of_type_Int = ((int)(115.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_e_of_type_Int = ((int)(this.jdField_b_of_type_Float * 280.0F + 0.5D));
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Float * 280.0F + 0.5D));
    this.g = ((int)(this.jdField_b_of_type_Float * 104.0F + 0.5D));
    this.f = ((int)(320.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_a_of_type_Float = ((int)(this.jdField_b_of_type_Float * 104.0F + 0.5D));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ThreadManager.post(new IndividualRedPacketManager.1(this), 8, null, true);
  }
  
  private Bitmap a(ajlb paramajlb, String paramString1, String paramString2, int paramInt)
  {
    Object localObject3 = a().a(paramString1, true);
    if ((localObject3 == null) || (((bano)localObject3).jdField_a_of_type_Banl == null) || (((bano)localObject3).jdField_b_of_type_Banl == null) || (((bano)localObject3).jdField_c_of_type_Banl == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "combineFinalImage init json fail, templateId:" + paramString1);
      }
      return null;
    }
    Object localObject2 = null;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    Object localObject1 = "#ffe589";
    Point localPoint = null;
    if (paramInt == 6)
    {
      localObject2 = a(paramString1, "", 2, ((bano)localObject3).jdField_d_of_type_Int, ((bano)localObject3).jdField_a_of_type_Int);
      i1 = azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_a_of_type_Banl.jdField_a_of_type_Int / 2);
      i3 = this.jdField_b_of_type_Int;
      i2 = this.jdField_c_of_type_Int;
      localPoint = new Point(azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_a_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect.left / 2), azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_a_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect.top / 2));
      localObject1 = "#ffe589";
    }
    for (;;)
    {
      localObject2 = a((String)localObject2, null);
      localObject3 = paramajlb.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject2 != null) {
        break;
      }
      return null;
      if (paramInt == 7)
      {
        localObject2 = a(paramString1, "", 3, ((bano)localObject3).jdField_d_of_type_Int, ((bano)localObject3).jdField_a_of_type_Int);
        i1 = azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_b_of_type_Banl.jdField_a_of_type_Int / 2);
        i3 = this.jdField_d_of_type_Int;
        i2 = this.jdField_e_of_type_Int;
        localPoint = new Point(azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_b_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect.left / 2), azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_b_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect.top / 2));
        localObject1 = "#d13d4b";
      }
      else if (paramInt == 15)
      {
        localObject2 = a(paramString1, "", 14, ((bano)localObject3).jdField_d_of_type_Int, ((bano)localObject3).jdField_a_of_type_Int);
        i1 = azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_c_of_type_Banl.jdField_a_of_type_Int / 2);
        i3 = this.f;
        i2 = this.g;
        localPoint = new Point(azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_c_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect.left / 2), azvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((bano)localObject3).jdField_c_of_type_Banl.jdField_a_of_type_AndroidGraphicsRect.top / 2));
        localObject1 = "#edd4d8";
      }
    }
    try
    {
      paramString1 = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
      if (paramString1 == null) {
        return paramString1;
      }
    }
    catch (OutOfMemoryError paramajlb)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "combineFinalImage Bitmap.createBitmap OutOfMemoryError: " + paramajlb.getMessage());
      }
    }
    catch (Exception paramString1)
    {
      try
      {
        for (;;)
        {
          paramajlb = new HashMap();
          paramajlb.put("param_FailCode", "combineFinalImage");
          awrn.a(BaseApplicationImpl.sApplication.getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, paramajlb, "", false);
          label630:
          return null;
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "combineFinalImage Bitmap.createBitmap Error: " + paramString1.getMessage());
          }
          paramString1 = null;
        }
        RectF localRectF = new RectF();
        Rect localRect = new Rect();
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        Canvas localCanvas = new Canvas(paramString1);
        localRect.set(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
        localRectF.set(0.0F, 0.0F, i3, i2);
        localCanvas.drawBitmap((Bitmap)localObject2, localRect, localRectF, localPaint);
        if (localObject3 != null) {
          if ((paramInt == 7) && (!paramajlb.jdField_a_of_type_Boolean))
          {
            localPaint.setColorFilter(new LightingColorFilter(0, 13712715));
            localRect.set(0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            localRectF.set(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i1);
            localCanvas.drawBitmap((Bitmap)localObject3, localRect, localRectF, localPaint);
          }
        }
        for (;;)
        {
          return paramString1;
          if ((paramInt != 15) || (paramajlb.jdField_a_of_type_Boolean)) {
            break;
          }
          localPaint.setColorFilter(new LightingColorFilter(0, 15586520));
          break;
          localPaint.setColor(Color.parseColor((String)localObject1));
          localPaint.setTextSize(i1 * 0.7F);
          paramajlb = new float[1];
          localObject1 = localPaint.getFontMetricsInt();
          localPaint.getTextWidths(paramString2, paramajlb);
          float f1 = localPoint.x;
          paramInt = (int)((i1 - paramajlb[0]) / 2.0F + f1);
          i2 = localPoint.y;
          i3 = ((Paint.FontMetricsInt)localObject1).ascent;
          i1 = (i1 - (((Paint.FontMetricsInt)localObject1).descent - ((Paint.FontMetricsInt)localObject1).ascent)) / 2;
          localCanvas.drawText(paramString2, paramInt, i2 - i3 + i1, localPaint);
        }
      }
      catch (Exception paramajlb)
      {
        break label630;
      }
    }
  }
  
  /* Error */
  static Bitmap a(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload 6
    //   11: astore 4
    //   13: getstatic 461	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   16: aload_0
    //   17: invokevirtual 467	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +375 -> 395
    //   23: aload 5
    //   25: astore_3
    //   26: aload 6
    //   28: astore 4
    //   30: getstatic 461	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   33: aload_0
    //   34: invokevirtual 467	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 317	android/graphics/Bitmap
    //   40: astore 5
    //   42: aload 5
    //   44: astore_3
    //   45: aload_3
    //   46: astore 4
    //   48: aload_3
    //   49: ifnonnull +343 -> 392
    //   52: aload_1
    //   53: astore 6
    //   55: aload_1
    //   56: ifnonnull +32 -> 88
    //   59: aload_3
    //   60: astore 4
    //   62: aload_3
    //   63: astore 5
    //   65: new 469	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 470	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 6
    //   74: aload_3
    //   75: astore 4
    //   77: aload_3
    //   78: astore 5
    //   80: aload 6
    //   82: getstatic 473	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   85: putfield 476	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   88: aload_3
    //   89: astore 4
    //   91: aload_3
    //   92: astore 5
    //   94: aload_0
    //   95: aload 6
    //   97: invokestatic 481	azvq:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lazvr;
    //   100: astore 7
    //   102: aload_3
    //   103: astore 4
    //   105: aload_3
    //   106: astore 5
    //   108: aload 7
    //   110: getfield 484	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   113: astore_1
    //   114: aload_1
    //   115: astore 4
    //   117: aload_1
    //   118: astore 5
    //   120: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +50 -> 173
    //   126: aload_1
    //   127: astore 4
    //   129: aload_1
    //   130: astore 5
    //   132: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   135: iconst_2
    //   136: new 47	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 486
    //   146: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 488
    //   156: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: getfield 489	azvr:jdField_a_of_type_Int	I
    //   164: invokevirtual 492	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_1
    //   174: astore 4
    //   176: aload_1
    //   177: astore 5
    //   179: aload 7
    //   181: getfield 489	azvr:jdField_a_of_type_Int	I
    //   184: istore_2
    //   185: aload_1
    //   186: astore 4
    //   188: iload_2
    //   189: iconst_1
    //   190: if_icmpne +202 -> 392
    //   193: iconst_2
    //   194: istore_2
    //   195: aload_1
    //   196: astore 4
    //   198: iload_2
    //   199: iconst_4
    //   200: if_icmpgt +130 -> 330
    //   203: aload_1
    //   204: astore_3
    //   205: aload_1
    //   206: astore 4
    //   208: aload 6
    //   210: iload_2
    //   211: putfield 495	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: astore 4
    //   219: aload_0
    //   220: aload 6
    //   222: invokestatic 481	azvq:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lazvr;
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload_1
    //   230: astore 4
    //   232: aload 5
    //   234: getfield 484	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   237: astore_1
    //   238: aload_1
    //   239: astore_3
    //   240: aload_1
    //   241: astore 4
    //   243: aload 5
    //   245: getfield 489	azvr:jdField_a_of_type_Int	I
    //   248: iconst_1
    //   249: if_icmpeq +151 -> 400
    //   252: aload_1
    //   253: astore_3
    //   254: aload_1
    //   255: astore 4
    //   257: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +18 -> 278
    //   263: aload_1
    //   264: astore_3
    //   265: aload_1
    //   266: astore 4
    //   268: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   271: iconst_2
    //   272: ldc_w 497
    //   275: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_1
    //   279: astore_3
    //   280: new 330	java/util/HashMap
    //   283: dup
    //   284: invokespecial 331	java/util/HashMap:<init>	()V
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   294: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   297: invokestatic 351	awrn:a	(Landroid/content/Context;)Lawrn;
    //   300: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   303: invokevirtual 355	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   306: checkcast 178	com/tencent/mobileqq/app/QQAppInterface
    //   309: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   312: ldc_w 499
    //   315: iconst_0
    //   316: lconst_1
    //   317: lconst_0
    //   318: aload 4
    //   320: ldc_w 268
    //   323: iconst_0
    //   324: invokevirtual 363	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   327: aload_1
    //   328: astore 4
    //   330: aload 4
    //   332: astore_3
    //   333: new 330	java/util/HashMap
    //   336: dup
    //   337: invokespecial 331	java/util/HashMap:<init>	()V
    //   340: astore_1
    //   341: aload 4
    //   343: astore_3
    //   344: aload_1
    //   345: ldc_w 333
    //   348: ldc 71
    //   350: invokevirtual 339	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload 4
    //   356: astore_3
    //   357: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   360: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   363: invokestatic 351	awrn:a	(Landroid/content/Context;)Lawrn;
    //   366: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   369: invokevirtual 355	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   372: checkcast 178	com/tencent/mobileqq/app/QQAppInterface
    //   375: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   378: ldc_w 501
    //   381: iconst_0
    //   382: lconst_1
    //   383: lconst_0
    //   384: aload_1
    //   385: ldc_w 268
    //   388: iconst_0
    //   389: invokevirtual 363	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   392: aload 4
    //   394: areturn
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -352 -> 45
    //   400: iload_2
    //   401: iconst_2
    //   402: imul
    //   403: istore_2
    //   404: goto -209 -> 195
    //   407: astore_0
    //   408: aload 4
    //   410: areturn
    //   411: astore_1
    //   412: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +43 -> 458
    //   418: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   421: iconst_2
    //   422: new 47	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 486
    //   432: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 503
    //   442: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_1
    //   446: invokevirtual 326	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: new 330	java/util/HashMap
    //   461: dup
    //   462: invokespecial 331	java/util/HashMap:<init>	()V
    //   465: astore_0
    //   466: aload_0
    //   467: ldc_w 333
    //   470: ldc_w 505
    //   473: invokevirtual 339	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   480: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   483: invokestatic 351	awrn:a	(Landroid/content/Context;)Lawrn;
    //   486: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   489: invokevirtual 355	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   492: checkcast 178	com/tencent/mobileqq/app/QQAppInterface
    //   495: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   498: ldc_w 501
    //   501: iconst_0
    //   502: lconst_1
    //   503: lconst_0
    //   504: aload_0
    //   505: ldc_w 268
    //   508: iconst_0
    //   509: invokevirtual 363	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   512: aload_3
    //   513: areturn
    //   514: astore_1
    //   515: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +43 -> 561
    //   521: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   524: iconst_2
    //   525: new 47	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 486
    //   535: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc_w 507
    //   545: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokevirtual 366	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   552: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: new 330	java/util/HashMap
    //   564: dup
    //   565: invokespecial 331	java/util/HashMap:<init>	()V
    //   568: astore_0
    //   569: aload_0
    //   570: ldc_w 333
    //   573: ldc_w 505
    //   576: invokevirtual 339	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   583: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   586: invokestatic 351	awrn:a	(Landroid/content/Context;)Lawrn;
    //   589: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   592: invokevirtual 355	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   595: checkcast 178	com/tencent/mobileqq/app/QQAppInterface
    //   598: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   601: ldc_w 509
    //   604: iconst_0
    //   605: lconst_1
    //   606: lconst_0
    //   607: aload_0
    //   608: ldc_w 268
    //   611: iconst_0
    //   612: invokevirtual 363	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   615: aload 4
    //   617: areturn
    //   618: astore_0
    //   619: aload 4
    //   621: areturn
    //   622: astore_1
    //   623: goto -108 -> 515
    //   626: astore_0
    //   627: goto -115 -> 512
    //   630: astore_1
    //   631: aload 5
    //   633: astore_3
    //   634: goto -222 -> 412
    //   637: astore_3
    //   638: aload_1
    //   639: astore 4
    //   641: goto -311 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	paramString	String
    //   0	644	1	paramOptions	android.graphics.BitmapFactory.Options
    //   184	220	2	i1	int
    //   8	626	3	localObject1	Object
    //   637	1	3	localException	Exception
    //   11	629	4	localObject2	Object
    //   4	628	5	localObject3	Object
    //   1	220	6	localOptions	android.graphics.BitmapFactory.Options
    //   100	80	7	localazvr	azvr
    // Exception table:
    //   from	to	target	type
    //   333	341	407	java/lang/Exception
    //   344	354	407	java/lang/Exception
    //   357	392	407	java/lang/Exception
    //   13	23	411	java/lang/OutOfMemoryError
    //   30	42	411	java/lang/OutOfMemoryError
    //   208	214	411	java/lang/OutOfMemoryError
    //   219	227	411	java/lang/OutOfMemoryError
    //   232	238	411	java/lang/OutOfMemoryError
    //   243	252	411	java/lang/OutOfMemoryError
    //   257	263	411	java/lang/OutOfMemoryError
    //   268	278	411	java/lang/OutOfMemoryError
    //   280	289	411	java/lang/OutOfMemoryError
    //   291	327	411	java/lang/OutOfMemoryError
    //   333	341	411	java/lang/OutOfMemoryError
    //   344	354	411	java/lang/OutOfMemoryError
    //   357	392	411	java/lang/OutOfMemoryError
    //   13	23	514	java/lang/Exception
    //   30	42	514	java/lang/Exception
    //   208	214	514	java/lang/Exception
    //   219	227	514	java/lang/Exception
    //   232	238	514	java/lang/Exception
    //   243	252	514	java/lang/Exception
    //   257	263	514	java/lang/Exception
    //   268	278	514	java/lang/Exception
    //   561	615	618	java/lang/Exception
    //   65	74	622	java/lang/Exception
    //   80	88	622	java/lang/Exception
    //   94	102	622	java/lang/Exception
    //   108	114	622	java/lang/Exception
    //   120	126	622	java/lang/Exception
    //   132	173	622	java/lang/Exception
    //   179	185	622	java/lang/Exception
    //   458	512	626	java/lang/Exception
    //   65	74	630	java/lang/OutOfMemoryError
    //   80	88	630	java/lang/OutOfMemoryError
    //   94	102	630	java/lang/OutOfMemoryError
    //   108	114	630	java/lang/OutOfMemoryError
    //   120	126	630	java/lang/OutOfMemoryError
    //   132	173	630	java/lang/OutOfMemoryError
    //   179	185	630	java/lang/OutOfMemoryError
    //   280	289	637	java/lang/Exception
    //   291	327	637	java/lang/Exception
  }
  
  public static String a(int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    switch (paramInt)
    {
    case 0: 
    default: 
      return str;
    case 1: 
      return ajed.aU + "pddata/vas/RedPacket/packets/";
    case 2: 
      return ajed.aU + "pddata/vas/RedPacket/specialFont/";
    case 3: 
      return ajed.aU + "pddata/vas/RedPacket/font/";
    case 4: 
      return str + "fontimgprecreate/";
    case 5: 
      return str + "personalfontimg/";
    case 6: 
      return str + "AIOfinalimg/";
    case 7: 
      return str + "TENPAYfinalimg/";
    }
    return str + "SENDfinalimg/";
  }
  
  public static String a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();; localObject = paramQQAppInterface)
    {
      if (localObject == null)
      {
        localObject = "";
        return localObject;
      }
      ajkz localajkz;
      if (localObject == null)
      {
        localajkz = null;
        label43:
        if (localajkz == null) {
          break label343;
        }
        if (!localajkz.a()) {
          break label205;
        }
        paramQQAppInterface = "1";
      }
      label60:
      label205:
      label337:
      label340:
      label343:
      for (QQAppInterface localQQAppInterface = paramQQAppInterface;; localQQAppInterface = null)
      {
        paramQQAppInterface = bant.a(((QQAppInterface)localObject).getApp().getApplicationContext(), "hongbao", "");
        if (1 == paramInt)
        {
          if (TextUtils.isEmpty(paramQQAppInterface)) {
            break label340;
          }
          paramQQAppInterface = paramQQAppInterface.replace("[from]", "1");
        }
        for (;;)
        {
          awqx.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006134", "0X8006134", 0, 0, localQQAppInterface, "1", "", "");
          localObject = paramQQAppInterface;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, "IndividualRedPacketManager.getMallURL=" + null + ", type:" + paramInt + ", url:" + paramQQAppInterface);
          return paramQQAppInterface;
          localajkz = (ajkz)((QQAppInterface)localObject).getManager(131);
          break label43;
          paramQQAppInterface = "0";
          break label60;
          if (3 == paramInt) {
            if ((localajkz != null) && (localajkz.b()) && (localajkz.a().jdField_b_of_type_Boolean))
            {
              if (TextUtils.isEmpty(paramQQAppInterface)) {
                break label337;
              }
              paramQQAppInterface = paramQQAppInterface.replace("[from]", "3");
            }
          }
          for (;;)
          {
            awqx.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006136", "0X8006136", 0, 0, localQQAppInterface, "1", "", "");
            break;
            paramQQAppInterface = null;
            break;
            localObject = bant.a(((QQAppInterface)localObject).getApp().getApplicationContext(), "hongbao", "");
            paramQQAppInterface = (QQAppInterface)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            paramQQAppInterface = ((String)localObject).replace("[from]", "2");
            break;
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(jdField_d_of_type_JavaLangString, 1, "getIDFromSCID error null: zipName=" + paramString);
      localObject2 = localObject1;
    }
    do
    {
      return localObject2;
      localObject1 = localObject2;
      if (paramString.length() > "luckyMoney.item.".length())
      {
        localObject1 = localObject2;
        if (paramString.indexOf("luckyMoney.item.") >= 0) {
          localObject1 = paramString.substring("luckyMoney.item.".length());
        }
      }
      if (QLog.isColorLevel()) {
        break;
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    QLog.d(jdField_d_of_type_JavaLangString, 2, "getIDFromSCID ok, scid = " + paramString + ", redPacketid=" + (String)localObject1);
    return localObject1;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    String str5 = "";
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str1 = str5;
    switch (paramInt1)
    {
    default: 
      str1 = str5;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImgAddress Error templateId: " + paramString1 + ", name:" + paramString2 + ", type:" + paramInt1 + ", filename:" + str1);
      }
      return str1;
      str1 = a(3) + "font.ttf";
      continue;
      str1 = a(3) + "config.json";
      continue;
      str1 = str5;
      if (!TextUtils.isEmpty(paramString2))
      {
        str1 = a(5) + Integer.toHexString(paramString2.charAt(0));
        continue;
        str1 = str5;
        if (!TextUtils.isEmpty(paramString2))
        {
          str1 = a(4) + Integer.toHexString(paramString2.charAt(0));
          continue;
          str1 = a(0) + "specialzip";
          continue;
          str1 = a(2) + "specialCharItem.zip";
          continue;
          str1 = a(2) + "config.json";
          continue;
          str1 = str5;
          if (!TextUtils.isEmpty(paramString2))
          {
            str1 = a(2) + "images" + File.separator + "aio" + File.separator + Integer.toHexString(paramString2.charAt(0));
            continue;
            str1 = str5;
            if (!TextUtils.isEmpty(paramString2))
            {
              str1 = a(2) + "images" + File.separator + "tp" + File.separator + Integer.toHexString(paramString2.charAt(0));
              continue;
              str1 = str5;
              if (!TextUtils.isEmpty(paramString2))
              {
                str1 = a(2) + "images" + File.separator + "send" + File.separator + Integer.toHexString(paramString2.charAt(0));
                continue;
                str2 = "_s";
                if (paramInt3 == bano.jdField_c_of_type_Int)
                {
                  str1 = a(1) + paramString1 + File.separator + "aioimg";
                }
                else
                {
                  str1 = str5;
                  if (!TextUtils.isEmpty(paramString2))
                  {
                    str1 = str5;
                    if (paramInt3 == bano.jdField_b_of_type_Int)
                    {
                      str3 = a(6) + paramString1 + "_aio_" + Integer.toHexString(paramString2.charAt(0));
                      str1 = str3;
                      if (str2 != null)
                      {
                        str1 = str3 + str2;
                        continue;
                        str3 = "_s";
                        if (paramInt3 == bano.jdField_c_of_type_Int)
                        {
                          str1 = a(1) + paramString1 + File.separator + "redenvelopeimg";
                        }
                        else
                        {
                          str1 = str5;
                          if (!TextUtils.isEmpty(paramString2))
                          {
                            str1 = str5;
                            if (paramInt3 == bano.jdField_b_of_type_Int)
                            {
                              str2 = a(7) + paramString1 + "_tp_" + Integer.toHexString(paramString2.charAt(0));
                              str1 = str2;
                              if (str3 != null)
                              {
                                str1 = str2 + str3;
                                continue;
                                str4 = "_s";
                                if (paramInt3 == bano.jdField_c_of_type_Int)
                                {
                                  str1 = a(1) + paramString1 + File.separator + "sendimg";
                                }
                                else
                                {
                                  str1 = str5;
                                  if (!TextUtils.isEmpty(paramString2))
                                  {
                                    str1 = str5;
                                    if (paramInt3 == bano.jdField_b_of_type_Int)
                                    {
                                      str2 = a(8) + paramString1 + "_send_" + Integer.toHexString(paramString2.charAt(0));
                                      str1 = str2;
                                      if (str4 != null)
                                      {
                                        str1 = str2 + str4;
                                        continue;
                                        str1 = a(1) + paramString1;
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "aioimg";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "redenvelopeimg";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "sendimg";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "aiopng.zip";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "config.json";
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(com.tencent.common.app.AppInterface arg0, ajkz paramajkz, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore_0
    //   5: aconst_null
    //   6: astore 8
    //   8: ldc 2
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnull +7 -> 19
    //   15: aload_2
    //   16: ifnonnull +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: aload_2
    //   24: getfield 659	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:templateId	Ljava/lang/String;
    //   27: astore 10
    //   29: aload_2
    //   30: getfield 660	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: astore 11
    //   35: aload_1
    //   36: invokevirtual 239	ajkz:a	()Lbani;
    //   39: astore 5
    //   41: aload 5
    //   43: aload 10
    //   45: iconst_1
    //   46: invokevirtual 244	bani:a	(Ljava/lang/String;Z)Lbano;
    //   49: astore 12
    //   51: aload 12
    //   53: ifnull +27 -> 80
    //   56: aload 12
    //   58: getfield 249	bano:jdField_a_of_type_Banl	Lbanl;
    //   61: ifnull +19 -> 80
    //   64: aload 12
    //   66: getfield 251	bano:jdField_b_of_type_Banl	Lbanl;
    //   69: ifnull +11 -> 80
    //   72: aload 12
    //   74: getfield 253	bano:jdField_c_of_type_Banl	Lbanl;
    //   77: ifnonnull +222 -> 299
    //   80: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +59 -> 142
    //   86: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   89: iconst_2
    //   90: new 47	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 662
    //   100: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 10
    //   105: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 664
    //   111: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 11
    //   116: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 666
    //   122: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: getfield 669	bani:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   130: invokevirtual 674	com/tencent/commonsdk/cache/QQLruCache:size	()I
    //   133: invokevirtual 492	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_1
    //   143: getfield 219	ajkz:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   146: aload_2
    //   147: getfield 676	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   150: aload_2
    //   151: invokevirtual 679	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: pop
    //   155: aload_1
    //   156: getfield 219	ajkz:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   159: new 47	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   166: aload_2
    //   167: getfield 676	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 681
    //   176: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aload_2
    //   183: invokevirtual 679	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: aload 5
    //   189: getfield 684	bani:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   192: astore_0
    //   193: aload_0
    //   194: monitorenter
    //   195: aload 5
    //   197: getfield 684	bani:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   200: aload 10
    //   202: invokeinterface 690 2 0
    //   207: ifne +59 -> 266
    //   210: new 692	java/util/ArrayList
    //   213: dup
    //   214: invokespecial 693	java/util/ArrayList:<init>	()V
    //   217: astore_1
    //   218: aload_1
    //   219: aload_2
    //   220: getfield 676	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   223: invokevirtual 696	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload 5
    //   229: getfield 684	bani:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   232: aload 10
    //   234: aload_1
    //   235: invokeinterface 697 3 0
    //   240: pop
    //   241: aload_0
    //   242: monitorexit
    //   243: aload 5
    //   245: ldc2_w 698
    //   248: aload 10
    //   250: aload_2
    //   251: getfield 676	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   254: invokevirtual 702	bani:a	(JLjava/lang/String;Ljava/lang/String;)V
    //   257: goto -238 -> 19
    //   260: astore_0
    //   261: ldc 2
    //   263: monitorexit
    //   264: aload_0
    //   265: athrow
    //   266: aload 5
    //   268: getfield 684	bani:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   271: aload 10
    //   273: invokeinterface 703 2 0
    //   278: checkcast 705	java/util/List
    //   281: aload_2
    //   282: getfield 676	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   285: invokeinterface 706 2 0
    //   290: pop
    //   291: goto -50 -> 241
    //   294: astore_1
    //   295: aload_0
    //   296: monitorexit
    //   297: aload_1
    //   298: athrow
    //   299: aload 11
    //   301: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne +850 -> 1154
    //   307: aload 5
    //   309: getfield 709	bani:jdField_b_of_type_Bank	Lbank;
    //   312: invokevirtual 713	bank:a	()Ljava/lang/String;
    //   315: aload 11
    //   317: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +834 -> 1154
    //   323: iconst_1
    //   324: istore_3
    //   325: aload 12
    //   327: getfield 270	bano:jdField_a_of_type_Int	I
    //   330: getstatic 641	bano:jdField_b_of_type_Int	I
    //   333: if_icmpne +424 -> 757
    //   336: iload_3
    //   337: ifeq +812 -> 1149
    //   340: aload_1
    //   341: aload 10
    //   343: aload 11
    //   345: bipush 12
    //   347: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   350: astore_0
    //   351: aload_0
    //   352: astore 5
    //   354: aload_0
    //   355: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   358: ifeq +43 -> 401
    //   361: aload 11
    //   363: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +23 -> 389
    //   369: aload_0
    //   370: astore 5
    //   372: aload_1
    //   373: ldc_w 268
    //   376: aload 11
    //   378: bipush 9
    //   380: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   383: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +15 -> 401
    //   389: aload_1
    //   390: aload 10
    //   392: aload 11
    //   394: bipush 6
    //   396: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   399: astore 5
    //   401: aload 5
    //   403: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifeq +659 -> 1065
    //   409: aload 12
    //   411: getfield 720	bano:jdField_e_of_type_Int	I
    //   414: iconst_1
    //   415: if_icmpeq +634 -> 1049
    //   418: aload_1
    //   419: aload 11
    //   421: bipush 6
    //   423: invokevirtual 723	ajkz:a	(Ljava/lang/String;I)Lajlb;
    //   426: astore_0
    //   427: aload_1
    //   428: aload_0
    //   429: aload_2
    //   430: bipush 6
    //   432: invokevirtual 726	ajkz:a	(Lajlb;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   435: astore 6
    //   437: aload_0
    //   438: astore 7
    //   440: aload 12
    //   442: getfield 270	bano:jdField_a_of_type_Int	I
    //   445: getstatic 641	bano:jdField_b_of_type_Int	I
    //   448: if_icmpne +690 -> 1138
    //   451: iload_3
    //   452: ifeq +686 -> 1138
    //   455: aload_1
    //   456: aload 10
    //   458: aload 11
    //   460: bipush 13
    //   462: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   465: astore_0
    //   466: aload_0
    //   467: astore 5
    //   469: aload_0
    //   470: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifeq +43 -> 516
    //   476: aload 11
    //   478: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +23 -> 504
    //   484: aload_0
    //   485: astore 5
    //   487: aload_1
    //   488: ldc_w 268
    //   491: aload 11
    //   493: bipush 10
    //   495: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   498: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   501: ifeq +15 -> 516
    //   504: aload_1
    //   505: aload 10
    //   507: aload 11
    //   509: bipush 7
    //   511: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   514: astore 5
    //   516: aload 5
    //   518: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   521: ifeq +30 -> 551
    //   524: aload 12
    //   526: getfield 720	bano:jdField_e_of_type_Int	I
    //   529: iconst_1
    //   530: if_icmpeq +561 -> 1091
    //   533: aload_1
    //   534: aload 11
    //   536: bipush 7
    //   538: invokevirtual 723	ajkz:a	(Ljava/lang/String;I)Lajlb;
    //   541: astore_0
    //   542: aload_1
    //   543: aload_0
    //   544: aload_2
    //   545: bipush 7
    //   547: invokevirtual 726	ajkz:a	(Lajlb;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   550: pop
    //   551: aload 9
    //   553: astore_0
    //   554: aload 12
    //   556: getfield 270	bano:jdField_a_of_type_Int	I
    //   559: getstatic 641	bano:jdField_b_of_type_Int	I
    //   562: if_icmpne +73 -> 635
    //   565: aload 8
    //   567: astore 5
    //   569: iload_3
    //   570: ifeq +15 -> 585
    //   573: aload_1
    //   574: aload 10
    //   576: aload 11
    //   578: bipush 18
    //   580: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   583: astore 5
    //   585: aload 5
    //   587: astore_0
    //   588: aload 5
    //   590: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   593: ifeq +42 -> 635
    //   596: aload 11
    //   598: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   601: ifne +23 -> 624
    //   604: aload 5
    //   606: astore_0
    //   607: aload_1
    //   608: ldc_w 268
    //   611: aload 11
    //   613: bipush 16
    //   615: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   618: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   621: ifeq +14 -> 635
    //   624: aload_1
    //   625: aload 10
    //   627: aload 11
    //   629: bipush 15
    //   631: invokevirtual 719	ajkz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   634: astore_0
    //   635: aload_0
    //   636: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   639: ifeq +30 -> 669
    //   642: aload 12
    //   644: getfield 720	bano:jdField_e_of_type_Int	I
    //   647: iconst_1
    //   648: if_icmpeq +459 -> 1107
    //   651: aload_1
    //   652: aload 11
    //   654: bipush 15
    //   656: invokevirtual 723	ajkz:a	(Ljava/lang/String;I)Lajlb;
    //   659: astore_0
    //   660: aload_1
    //   661: aload_0
    //   662: aload_2
    //   663: bipush 15
    //   665: invokevirtual 726	ajkz:a	(Lajlb;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   668: pop
    //   669: aload 7
    //   671: ifnull +42 -> 713
    //   674: aload 7
    //   676: getfield 305	ajlb:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   679: ifnull +34 -> 713
    //   682: aload 7
    //   684: getfield 407	ajlb:jdField_a_of_type_Boolean	Z
    //   687: ifne +26 -> 713
    //   690: aload 7
    //   692: getfield 728	ajlb:c	Z
    //   695: ifne +18 -> 713
    //   698: aload_1
    //   699: aload 7
    //   701: getfield 305	ajlb:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   704: ldc_w 268
    //   707: aload 11
    //   709: iconst_5
    //   710: invokevirtual 731	ajkz:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   713: aload 6
    //   715: ifnull -696 -> 19
    //   718: aload 7
    //   720: getfield 305	ajlb:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   723: ifnonnull +11 -> 734
    //   726: aload 7
    //   728: getfield 728	ajlb:c	Z
    //   731: ifeq -712 -> 19
    //   734: aload 7
    //   736: getfield 732	ajlb:jdField_b_of_type_Boolean	Z
    //   739: ifeq +384 -> 1123
    //   742: aload_1
    //   743: aload 6
    //   745: aload 10
    //   747: aload 11
    //   749: bipush 12
    //   751: invokevirtual 731	ajkz:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   754: goto -735 -> 19
    //   757: aload 12
    //   759: getfield 249	bano:jdField_a_of_type_Banl	Lbanl;
    //   762: astore 6
    //   764: aload 6
    //   766: ifnull +383 -> 1149
    //   769: aload 6
    //   771: getfield 735	banl:jdField_a_of_type_Acko	Lacko;
    //   774: ifnull +375 -> 1149
    //   777: aload_2
    //   778: getfield 736	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_Acko	Lacko;
    //   781: ifnull +26 -> 807
    //   784: aload_2
    //   785: getfield 736	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_Acko	Lacko;
    //   788: getfield 739	acko:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   791: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   794: ifne +13 -> 807
    //   797: invokestatic 744	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   800: aload_2
    //   801: invokevirtual 747	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	(Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   804: goto -785 -> 19
    //   807: aload 6
    //   809: getfield 748	banl:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   812: aconst_null
    //   813: aload 6
    //   815: getfield 749	banl:f	I
    //   818: aload 6
    //   820: getfield 750	banl:jdField_d_of_type_Int	I
    //   823: iconst_0
    //   824: invokestatic 273	ajkz:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   827: astore 7
    //   829: aload 7
    //   831: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   834: ifne +13 -> 847
    //   837: new 626	java/io/File
    //   840: dup
    //   841: aload 7
    //   843: invokespecial 753	java/io/File:<init>	(Ljava/lang/String;)V
    //   846: astore_0
    //   847: aload_0
    //   848: ifnonnull +34 -> 882
    //   851: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   854: iconst_2
    //   855: new 47	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 755
    //   865: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 7
    //   870: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: goto -860 -> 19
    //   882: aload_0
    //   883: invokevirtual 758	java/io/File:exists	()Z
    //   886: ifeq +257 -> 1143
    //   889: aload_0
    //   890: invokevirtual 761	java/io/File:isFile	()Z
    //   893: ifeq +250 -> 1143
    //   896: aload 12
    //   898: aload_2
    //   899: aload 7
    //   901: iconst_0
    //   902: invokestatic 764	ajkz:a	(Lbano;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;Ljava/lang/String;Z)Z
    //   905: istore 4
    //   907: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   910: ifne +8 -> 918
    //   913: iload 4
    //   915: ifne +244 -> 1159
    //   918: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   921: iconst_2
    //   922: new 47	java/lang/StringBuilder
    //   925: dup
    //   926: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   929: ldc_w 766
    //   932: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: iload 4
    //   937: invokevirtual 769	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   940: ldc_w 771
    //   943: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload 7
    //   948: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: goto +202 -> 1159
    //   960: aload_1
    //   961: getfield 219	ajkz:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   964: aload_2
    //   965: getfield 676	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   968: aload_2
    //   969: invokevirtual 679	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   972: pop
    //   973: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   976: ifeq +56 -> 1032
    //   979: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   982: iconst_2
    //   983: new 47	java/lang/StringBuilder
    //   986: dup
    //   987: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   990: ldc_w 773
    //   993: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: aload 10
    //   998: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: ldc_w 775
    //   1004: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: iload 4
    //   1009: invokevirtual 769	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1012: ldc_w 777
    //   1015: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: aload 6
    //   1020: getfield 778	banl:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1023: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1032: aload 5
    //   1034: ldc2_w 698
    //   1037: aload 10
    //   1039: aload_2
    //   1040: getfield 676	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1043: invokevirtual 702	bani:a	(JLjava/lang/String;Ljava/lang/String;)V
    //   1046: goto -1027 -> 19
    //   1049: new 302	ajlb
    //   1052: dup
    //   1053: invokespecial 779	ajlb:<init>	()V
    //   1056: astore_0
    //   1057: aload_0
    //   1058: iconst_1
    //   1059: putfield 728	ajlb:c	Z
    //   1062: goto -635 -> 427
    //   1065: aload_2
    //   1066: aload 5
    //   1068: aconst_null
    //   1069: invokestatic 300	ajkz:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1072: putfield 780	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1075: invokestatic 744	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   1078: aload_2
    //   1079: invokevirtual 747	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	(Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   1082: aconst_null
    //   1083: astore 6
    //   1085: aconst_null
    //   1086: astore 7
    //   1088: goto -648 -> 440
    //   1091: new 302	ajlb
    //   1094: dup
    //   1095: invokespecial 779	ajlb:<init>	()V
    //   1098: astore_0
    //   1099: aload_0
    //   1100: iconst_1
    //   1101: putfield 728	ajlb:c	Z
    //   1104: goto -562 -> 542
    //   1107: new 302	ajlb
    //   1110: dup
    //   1111: invokespecial 779	ajlb:<init>	()V
    //   1114: astore_0
    //   1115: aload_0
    //   1116: iconst_1
    //   1117: putfield 728	ajlb:c	Z
    //   1120: goto -460 -> 660
    //   1123: aload_1
    //   1124: aload 6
    //   1126: aload 10
    //   1128: aload 11
    //   1130: bipush 6
    //   1132: invokevirtual 731	ajkz:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   1135: goto -1116 -> 19
    //   1138: aconst_null
    //   1139: astore_0
    //   1140: goto -674 -> 466
    //   1143: iconst_0
    //   1144: istore 4
    //   1146: goto -186 -> 960
    //   1149: aconst_null
    //   1150: astore_0
    //   1151: goto -800 -> 351
    //   1154: iconst_0
    //   1155: istore_3
    //   1156: goto -831 -> 325
    //   1159: iload 4
    //   1161: ifne -1142 -> 19
    //   1164: iconst_1
    //   1165: istore 4
    //   1167: goto -207 -> 960
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1170	1	paramajkz	ajkz
    //   0	1170	2	paramRedPacketInfo	CustomizeStrategyFactory.RedPacketInfo
    //   324	832	3	i1	int
    //   905	261	4	bool	boolean
    //   39	1028	5	localObject1	Object
    //   435	690	6	localObject2	Object
    //   438	649	7	localObject3	Object
    //   6	560	8	localObject4	Object
    //   1	551	9	localObject5	Object
    //   27	1100	10	str1	String
    //   33	1096	11	str2	String
    //   49	848	12	localbano	bano
    // Exception table:
    //   from	to	target	type
    //   23	51	260	finally
    //   56	80	260	finally
    //   80	142	260	finally
    //   142	195	260	finally
    //   243	257	260	finally
    //   297	299	260	finally
    //   299	323	260	finally
    //   325	336	260	finally
    //   340	351	260	finally
    //   354	369	260	finally
    //   372	389	260	finally
    //   389	401	260	finally
    //   401	427	260	finally
    //   427	437	260	finally
    //   440	451	260	finally
    //   455	466	260	finally
    //   469	484	260	finally
    //   487	504	260	finally
    //   504	516	260	finally
    //   516	542	260	finally
    //   542	551	260	finally
    //   554	565	260	finally
    //   573	585	260	finally
    //   588	604	260	finally
    //   607	624	260	finally
    //   624	635	260	finally
    //   635	660	260	finally
    //   660	669	260	finally
    //   674	713	260	finally
    //   718	734	260	finally
    //   734	754	260	finally
    //   757	764	260	finally
    //   769	804	260	finally
    //   807	829	260	finally
    //   829	847	260	finally
    //   851	879	260	finally
    //   882	913	260	finally
    //   918	957	260	finally
    //   960	1032	260	finally
    //   1032	1046	260	finally
    //   1049	1062	260	finally
    //   1065	1082	260	finally
    //   1091	1104	260	finally
    //   1107	1120	260	finally
    //   1123	1135	260	finally
    //   195	241	294	finally
    //   241	243	294	finally
    //   266	291	294	finally
    //   295	297	294	finally
  }
  
  static boolean a(bano parambano, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString, boolean paramBoolean)
  {
    if ((parambano == null) || (parambano.jdField_a_of_type_Banl == null) || (paramRedPacketInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e(jdField_d_of_type_JavaLangString, 2, "getAnimatePath Exception 0.zipPath=" + paramString);
      paramBoolean = false;
      return paramBoolean;
    }
    banl localbanl = parambano.jdField_a_of_type_Banl;
    for (;;)
    {
      Object localObject1;
      String[] arrayOfString;
      boolean bool1;
      int i1;
      String str;
      try
      {
        localObject1 = paramString + "_dir2";
        File localFile = new File((String)localObject1);
        if ((!localFile.exists()) || (!localFile.isDirectory())) {
          break label744;
        }
        arrayOfString = localFile.list();
        if (arrayOfString.length <= 0) {
          break label735;
        }
        bool1 = true;
        i1 = 0;
        if (i1 >= arrayOfString.length) {
          break label729;
        }
        str = localFile.getAbsolutePath() + File.separator + arrayOfString[i1];
        Object localObject2 = new File(str);
        if (!((File)localObject2).exists()) {
          break label756;
        }
        if (!((File)localObject2).isDirectory()) {
          break label590;
        }
        localObject2 = ((File)localObject2).list();
        if (localObject2.length <= 0) {
          break label526;
        }
        i1 = localObject2.length;
        localObject1 = str;
        if ((QLog.isColorLevel()) || (i1 == 0)) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getAnimatePath picNum Err id:" + paramRedPacketInfo.templateId + ", fileNames=" + arrayOfString + ", unZipDir=" + (String)localObject1 + ", picNum=" + i1 + ", size=" + localbanl.jdField_a_of_type_Acko.jdField_a_of_type_Int);
        }
        if ((!paramBoolean) || ((i1 == localbanl.jdField_a_of_type_Acko.jdField_a_of_type_Int) && (i1 != 0))) {
          break label753;
        }
        bapf.a(null, "individual_v2_redpacket_json_err", "animConfig_size_err", "animConfig_size_err, id=" + paramRedPacketInfo.templateId, null, 0.0F);
      }
      catch (Exception parambano)
      {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "getAnimatePath Exception id:" + paramRedPacketInfo.templateId + ", name=" + localbanl.jdField_c_of_type_JavaLangString);
        return false;
      }
      boolean bool2 = bool1;
      if (!paramBoolean)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool1 = bani.a(paramString, (String)localObject1);
          bool2 = bool1;
          if (bool1)
          {
            bool1 = a(parambano, paramRedPacketInfo, paramString, true);
            paramBoolean = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_d_of_type_JavaLangString, 2, "set animConfig id:" + paramRedPacketInfo.templateId + ", name=" + localbanl.jdField_c_of_type_JavaLangString + " isRegetOk=" + bool1);
            return bool1;
            label526:
            if (!QLog.isColorLevel()) {
              break label756;
            }
            QLog.d(jdField_d_of_type_JavaLangString, 2, "getAnimatePath Err_path id:" + paramRedPacketInfo.templateId + ", path=" + str + ", name=" + localbanl.jdField_c_of_type_JavaLangString);
            break label756;
            label590:
            i1 = arrayOfString.length;
            continue;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "set animConfig end name=" + localbanl.jdField_c_of_type_JavaLangString + ", id=" + paramRedPacketInfo.templateId + ", picNum=" + i1 + ", fileExist=" + bool2 + ", isUnZipBack=" + paramBoolean + ", unZipDir = " + (String)localObject1);
      }
      if (bool2)
      {
        localbanl.jdField_a_of_type_Acko.jdField_a_of_type_JavaLangString = ((String)localObject1);
        paramRedPacketInfo.jdField_a_of_type_Acko = localbanl.jdField_a_of_type_Acko;
        paramRedPacketInfo.jdField_b_of_type_Boolean = true;
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return true;
        label729:
        i1 = 0;
        continue;
        label735:
        i1 = 0;
        bool1 = false;
        continue;
        label744:
        bool1 = false;
        i1 = 0;
        continue;
        label753:
        continue;
        label756:
        i1 += 1;
      }
    }
  }
  
  public ajlb a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    ajlb localajlb = new ajlb();
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (a().jdField_b_of_type_Bank.a().contains(paramString)))
    {
      localajlb.jdField_a_of_type_Boolean = true;
      if ((TextUtils.isEmpty(a().jdField_b_of_type_Bank.jdField_b_of_type_JavaLangString)) || (!a().jdField_b_of_type_Bank.jdField_b_of_type_JavaLangString.contains(paramString))) {
        break label499;
      }
      int i1 = 16;
      if (6 == paramInt) {
        i1 = 9;
      }
      for (;;)
      {
        localObject1 = a(null, paramString, i1, 0, 0);
        a("", paramString, i1);
        if (!new File((String)localObject1).exists()) {
          break;
        }
        localajlb.jdField_a_of_type_AndroidGraphicsBitmap = a((String)localObject1, null);
        localajlb.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg success! Special char = " + paramString);
        }
        return localajlb;
        if (7 == paramInt) {
          i1 = 10;
        }
      }
      if (!TextUtils.isEmpty(b().getString("special_unzip_version_key", ""))) {
        b().edit().putString("special_unzip_version_key", "").commit();
      }
    }
    Object localObject4 = a("", paramString, 4, 0, 0);
    for (Object localObject3 = new File((String)localObject4);; localObject3 = localObject4)
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          for (;;)
          {
            if (((File)localObject3).exists())
            {
              localObject1 = localObject4;
              if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(localObject4)) {}
            }
            else
            {
              String str = a("", paramString, 5, 0, 0);
              localObject4 = new File(str);
              if (!((File)localObject4).exists()) {
                break label863;
              }
              localObject3 = localObject4;
              localObject1 = str;
              if (this.jdField_a_of_type_JavaUtilLinkedList.contains(str)) {
                break label863;
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label801;
            }
            ((File)localObject3).setLastModified(System.currentTimeMillis());
            localajlb.jdField_a_of_type_AndroidGraphicsBitmap = a((String)localObject1, null);
            l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg from file success time-consuming = " + (l2 - l1) + "ms");
            }
            localajlb.jdField_b_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg fontImage = " + localajlb.jdField_a_of_type_AndroidGraphicsBitmap + "Special Char = " + localajlb.jdField_a_of_type_Boolean + "Special image = " + localajlb.jdField_b_of_type_Boolean);
            }
            return localajlb;
            label499:
            if ((!TextUtils.isEmpty("")) || (!"".contains(paramString))) {
              break;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getResources().getAssets();
            if (6 == paramInt) {}
            try
            {
              localObject1 = ((AssetManager)localObject1).open("specialFont/aio/" + Integer.toHexString(paramString.charAt(0)));
              for (;;)
              {
                localajlb.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeStream((InputStream)localObject1);
                localajlb.jdField_b_of_type_Boolean = true;
                ((InputStream)localObject1).close();
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg success! Special char = " + paramString);
                break;
                if (7 == paramInt) {
                  localObject1 = ((AssetManager)localObject1).open("specialFont/tp/" + Integer.toHexString(paramString.charAt(0)));
                } else {
                  localObject1 = ((AssetManager)localObject1).open("specialFont/send/" + Integer.toHexString(paramString.charAt(0)));
                }
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg assets oom:" + localOutOfMemoryError.getMessage());
            }
            catch (IOException localIOException)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(jdField_d_of_type_JavaLangString, 2, localIOException.getMessage());
            }
            catch (Exception localException) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, localException.getMessage());
        }
        label801:
        localajlb.jdField_a_of_type_AndroidGraphicsBitmap = a(paramString, false);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg create success time-consuming = " + (l2 - l1) + "ms");
        }
      }
      label863:
      Object localObject2 = null;
    }
    return localajlb;
  }
  
  public SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences("individRedPacket_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  public Bitmap a(ajlb paramajlb, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = "0X800612F";
      str2 = paramRedPacketInfo.jdField_a_of_type_JavaLangString;
    }
    String str3;
    long l1;
    bano localbano;
    for (;;)
    {
      str3 = "0";
      if (a()) {
        str3 = "1";
      }
      l1 = System.currentTimeMillis();
      localbano = a().a(paramRedPacketInfo.templateId, true);
      if (localbano != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg init json fail");
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      paramajlb = null;
      return paramajlb;
      if (paramInt == 7)
      {
        str1 = "0X800613F";
        str2 = "";
      }
      else
      {
        str1 = "0X800613F";
        str2 = "";
      }
    }
    Object localObject;
    if (6 == paramInt) {
      localObject = localbano.jdField_a_of_type_Banl;
    }
    while (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg decorateInfo = null");
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      return null;
      if (7 == paramInt) {
        localObject = localbano.jdField_b_of_type_Banl;
      } else {
        localObject = localbano.jdField_c_of_type_Banl;
      }
    }
    if (!bani.a((bann)localObject))
    {
      if (((banl)localObject).f == 2) {
        paramajlb = paramRedPacketInfo.jdField_b_of_type_JavaLangString;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramajlb, paramRedPacketInfo);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg id = " + paramRedPacketInfo.templateId + " content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString + " not exists!");
        }
        a().a(16L, ((banl)localObject).jdField_d_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg BG not found,start download url : " + ((banl)localObject).f + ", id=" + ((banl)localObject).jdField_d_of_type_JavaLangString);
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
        return null;
        if (((banl)localObject).f == 3) {
          paramajlb = paramRedPacketInfo.jdField_b_of_type_JavaLangString + "_tp";
        } else {
          paramajlb = paramRedPacketInfo.jdField_b_of_type_JavaLangString + "_send";
        }
      }
    }
    label513:
    long l2;
    if (localbano.jdField_a_of_type_Int == bano.jdField_b_of_type_Int)
    {
      localObject = a(paramajlb, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramInt);
      l2 = System.currentTimeMillis();
      if (localObject == null) {
        break label724;
      }
      if (paramInt != 6) {
        break label622;
      }
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      label535:
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "1", String.valueOf(l2 - l1), str2);
    }
    for (;;)
    {
      paramajlb = (ajlb)localObject;
      if (paramInt != 6) {
        break;
      }
      CustomizeStrategyFactory.a().a(paramRedPacketInfo);
      return localObject;
      localObject = a(a(paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramInt, localbano.jdField_d_of_type_Int, localbano.jdField_a_of_type_Int), null);
      break label513;
      label622:
      if (paramInt == 7)
      {
        if (paramajlb.jdField_b_of_type_Boolean)
        {
          a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 13);
          break label535;
        }
        a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 7);
        break label535;
      }
      if (paramInt != 15) {
        break label535;
      }
      if (paramajlb.jdField_b_of_type_Boolean)
      {
        a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 18);
        break label535;
      }
      a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 15);
      break label535;
      label724:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg BG combine == null, templateinfo.type = " + localbano.jdField_a_of_type_Int);
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", String.valueOf(l2 - l1), str2);
    }
  }
  
  /* Error */
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 163	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   12: astore 11
    //   14: aload 11
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 171	ajkz:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   21: invokevirtual 970	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   24: ifne +118 -> 142
    //   27: aload_0
    //   28: getfield 171	ajkz:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   31: iconst_1
    //   32: invokevirtual 169	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   35: invokestatic 851	java/lang/System:currentTimeMillis	()J
    //   38: lstore_3
    //   39: aload_0
    //   40: getfield 163	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   43: iconst_1
    //   44: ldc_w 971
    //   47: invokevirtual 975	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   50: ifeq +161 -> 211
    //   53: aload_0
    //   54: invokevirtual 239	ajkz:a	()Lbani;
    //   57: getfield 978	bani:jdField_a_of_type_Bann	Lbann;
    //   60: invokestatic 951	bani:a	(Lbann;)Z
    //   63: ifeq +24 -> 87
    //   66: aload_0
    //   67: getfield 163	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   70: aconst_null
    //   71: aconst_null
    //   72: bipush 8
    //   74: iconst_0
    //   75: iconst_0
    //   76: invokestatic 273	ajkz:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   79: getstatic 69	ajkz:jdField_a_of_type_Int	I
    //   82: iconst_1
    //   83: invokevirtual 982	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 166	ajkz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   91: iconst_1
    //   92: invokevirtual 169	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   95: invokestatic 851	java/lang/System:currentTimeMillis	()J
    //   98: lstore 5
    //   100: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +39 -> 142
    //   106: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   109: iconst_2
    //   110: new 47	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 984
    //   120: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: lload 5
    //   125: lload_3
    //   126: lsub
    //   127: invokevirtual 882	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: ldc_w 884
    //   133: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: getfield 166	ajkz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   146: invokevirtual 970	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   149: ifeq +10 -> 159
    //   152: aload_1
    //   153: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +150 -> 306
    //   159: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_1
    //   163: new 47	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 986
    //   173: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 166	ajkz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   180: invokevirtual 970	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   183: invokevirtual 769	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: ldc_w 988
    //   189: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload 11
    //   204: monitorexit
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: areturn
    //   211: aload_0
    //   212: getfield 163	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   215: getfield 991	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   218: iconst_0
    //   219: iconst_1
    //   220: invokevirtual 995	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   223: ifeq +7 -> 230
    //   226: invokestatic 999	gd:c	()Z
    //   229: pop
    //   230: aload_0
    //   231: getfield 166	ajkz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: iconst_0
    //   235: invokevirtual 169	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   238: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   241: iconst_1
    //   242: ldc_w 1001
    //   245: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto -106 -> 142
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 166	ajkz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   257: iconst_0
    //   258: invokevirtual 169	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   261: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   264: iconst_1
    //   265: new 47	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 1003
    //   275: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 7
    //   280: invokevirtual 1004	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   283: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -150 -> 142
    //   295: astore_1
    //   296: aload 11
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload_0
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    //   306: aload_0
    //   307: invokevirtual 239	ajkz:a	()Lbani;
    //   310: getfield 978	bani:jdField_a_of_type_Bann	Lbann;
    //   313: invokestatic 951	bani:a	(Lbann;)Z
    //   316: ifne +21 -> 337
    //   319: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_1
    //   323: ldc_w 1006
    //   326: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 11
    //   331: monitorexit
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -127 -> 207
    //   337: aload_0
    //   338: getfield 1008	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   341: ifnonnull +32 -> 373
    //   344: aload_0
    //   345: new 1010	com/etrump/mixlayout/ETFont
    //   348: dup
    //   349: getstatic 69	ajkz:jdField_a_of_type_Int	I
    //   352: aconst_null
    //   353: ldc_w 268
    //   356: bipush 8
    //   358: iconst_0
    //   359: iconst_0
    //   360: invokestatic 273	ajkz:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 82	ajkz:jdField_a_of_type_Float	F
    //   367: invokespecial 1013	com/etrump/mixlayout/ETFont:<init>	(ILjava/lang/String;F)V
    //   370: putfield 1008	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   373: aload_0
    //   374: getfield 1008	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   377: ldc_w 1015
    //   380: invokestatic 428	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   383: invokevirtual 1016	com/etrump/mixlayout/ETFont:setColor	(I)V
    //   386: iload_2
    //   387: ifeq +41 -> 428
    //   390: ldc_w 268
    //   393: aload_1
    //   394: iconst_4
    //   395: iconst_0
    //   396: iconst_0
    //   397: invokestatic 273	ajkz:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   400: astore 7
    //   402: aload 7
    //   404: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifeq +36 -> 443
    //   410: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   413: iconst_1
    //   414: ldc_w 1018
    //   417: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 11
    //   422: monitorexit
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -218 -> 207
    //   428: ldc_w 268
    //   431: aload_1
    //   432: iconst_5
    //   433: iconst_0
    //   434: iconst_0
    //   435: invokestatic 273	ajkz:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   438: astore 7
    //   440: goto -38 -> 402
    //   443: new 626	java/io/File
    //   446: dup
    //   447: aload 7
    //   449: invokespecial 753	java/io/File:<init>	(Ljava/lang/String;)V
    //   452: astore 7
    //   454: aload_0
    //   455: getfield 82	ajkz:jdField_a_of_type_Float	F
    //   458: f2i
    //   459: aload_0
    //   460: getfield 82	ajkz:jdField_a_of_type_Float	F
    //   463: f2i
    //   464: getstatic 315	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   467: invokestatic 321	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   470: astore 8
    //   472: aload_0
    //   473: getfield 163	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   476: aload_1
    //   477: iconst_0
    //   478: invokevirtual 613	java/lang/String:charAt	(I)C
    //   481: aload_0
    //   482: getfield 1008	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   485: invokevirtual 1022	com/etrump/mixlayout/ETEngine:native_isPaintableChar	(CLcom/etrump/mixlayout/ETFont;)Z
    //   488: ifeq +22 -> 510
    //   491: aload_0
    //   492: getfield 163	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   495: aload_1
    //   496: aload 8
    //   498: iconst_0
    //   499: iconst_0
    //   500: aload_0
    //   501: getfield 1008	ajkz:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   504: invokevirtual 1026	com/etrump/mixlayout/ETEngine:native_drawText	(Ljava/lang/String;Landroid/graphics/Bitmap;IILcom/etrump/mixlayout/ETFont;)Z
    //   507: ifne +135 -> 642
    //   510: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   513: iconst_1
    //   514: new 47	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 1028
    //   524: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_1
    //   528: iconst_0
    //   529: invokevirtual 613	java/lang/String:charAt	(I)C
    //   532: invokevirtual 1031	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   535: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload 11
    //   543: monitorexit
    //   544: aconst_null
    //   545: astore_1
    //   546: goto -339 -> 207
    //   549: astore_1
    //   550: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: iconst_1
    //   554: new 47	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 1033
    //   564: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: invokevirtual 326	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   571: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: new 330	java/util/HashMap
    //   583: dup
    //   584: invokespecial 331	java/util/HashMap:<init>	()V
    //   587: astore_1
    //   588: aload_1
    //   589: ldc_w 333
    //   592: ldc_w 1035
    //   595: invokevirtual 339	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   602: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   605: invokestatic 351	awrn:a	(Landroid/content/Context;)Lawrn;
    //   608: getstatic 345	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   611: invokevirtual 355	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   614: checkcast 178	com/tencent/mobileqq/app/QQAppInterface
    //   617: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   620: ldc_w 360
    //   623: iconst_0
    //   624: lconst_1
    //   625: lconst_0
    //   626: aload_1
    //   627: ldc_w 268
    //   630: iconst_0
    //   631: invokevirtual 363	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   634: aload 11
    //   636: monitorexit
    //   637: aconst_null
    //   638: astore_1
    //   639: goto -432 -> 207
    //   642: iload_2
    //   643: ifeq +57 -> 700
    //   646: aload 8
    //   648: ifnull +52 -> 700
    //   651: aload 10
    //   653: astore_1
    //   654: new 1037	java/io/BufferedOutputStream
    //   657: dup
    //   658: new 1039	java/io/FileOutputStream
    //   661: dup
    //   662: aload 7
    //   664: invokespecial 1042	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   667: invokespecial 1045	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   670: astore 7
    //   672: aload 8
    //   674: getstatic 1051	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   677: bipush 90
    //   679: aload 7
    //   681: invokevirtual 1055	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   684: pop
    //   685: aload 7
    //   687: invokevirtual 1058	java/io/BufferedOutputStream:flush	()V
    //   690: aload 7
    //   692: ifnull +8 -> 700
    //   695: aload 7
    //   697: invokevirtual 1059	java/io/BufferedOutputStream:close	()V
    //   700: aload 11
    //   702: monitorexit
    //   703: aload 8
    //   705: astore_1
    //   706: goto -499 -> 207
    //   709: astore_1
    //   710: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   713: iconst_1
    //   714: ldc_w 1061
    //   717: aload_1
    //   718: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: goto -21 -> 700
    //   724: astore_1
    //   725: aload 9
    //   727: astore 7
    //   729: aload_1
    //   730: astore 9
    //   732: aload 7
    //   734: astore_1
    //   735: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +37 -> 775
    //   741: aload 7
    //   743: astore_1
    //   744: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   747: iconst_2
    //   748: new 47	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 1066
    //   758: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 9
    //   763: invokevirtual 366	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   766: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 7
    //   777: ifnull -77 -> 700
    //   780: aload 7
    //   782: invokevirtual 1059	java/io/BufferedOutputStream:close	()V
    //   785: goto -85 -> 700
    //   788: astore_1
    //   789: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   792: iconst_1
    //   793: ldc_w 1061
    //   796: aload_1
    //   797: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: goto -100 -> 700
    //   803: astore 8
    //   805: aload_1
    //   806: astore 7
    //   808: aload 8
    //   810: astore_1
    //   811: aload 7
    //   813: ifnull +8 -> 821
    //   816: aload 7
    //   818: invokevirtual 1059	java/io/BufferedOutputStream:close	()V
    //   821: aload_1
    //   822: athrow
    //   823: astore 7
    //   825: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   828: iconst_1
    //   829: ldc_w 1061
    //   832: aload 7
    //   834: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   837: goto -16 -> 821
    //   840: astore_1
    //   841: goto -30 -> 811
    //   844: astore 9
    //   846: goto -114 -> 732
    //   849: astore_1
    //   850: goto -216 -> 634
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	853	0	this	ajkz
    //   0	853	1	paramString	String
    //   0	853	2	paramBoolean	boolean
    //   38	88	3	l1	long
    //   98	26	5	l2	long
    //   251	28	7	localThrowable	java.lang.Throwable
    //   400	417	7	localObject1	Object
    //   823	10	7	localException1	Exception
    //   470	234	8	localBitmap	Bitmap
    //   803	6	8	localObject2	Object
    //   4	758	9	str	String
    //   844	1	9	localException2	Exception
    //   1	651	10	localObject3	Object
    //   12	689	11	localETEngine	ETEngine
    // Exception table:
    //   from	to	target	type
    //   39	87	251	java/lang/Throwable
    //   87	142	251	java/lang/Throwable
    //   211	230	251	java/lang/Throwable
    //   230	248	251	java/lang/Throwable
    //   17	39	295	finally
    //   39	87	295	finally
    //   87	142	295	finally
    //   142	159	295	finally
    //   159	205	295	finally
    //   211	230	295	finally
    //   230	248	295	finally
    //   253	292	295	finally
    //   296	299	295	finally
    //   306	332	295	finally
    //   337	373	295	finally
    //   373	386	295	finally
    //   390	402	295	finally
    //   402	423	295	finally
    //   428	440	295	finally
    //   443	454	295	finally
    //   454	472	295	finally
    //   472	510	295	finally
    //   510	544	295	finally
    //   550	580	295	finally
    //   580	634	295	finally
    //   634	637	295	finally
    //   695	700	295	finally
    //   700	703	295	finally
    //   710	721	295	finally
    //   780	785	295	finally
    //   789	800	295	finally
    //   816	821	295	finally
    //   821	823	295	finally
    //   825	837	295	finally
    //   8	17	301	finally
    //   299	301	301	finally
    //   454	472	549	java/lang/OutOfMemoryError
    //   695	700	709	java/lang/Exception
    //   654	672	724	java/lang/Exception
    //   780	785	788	java/lang/Exception
    //   654	672	803	finally
    //   735	741	803	finally
    //   744	775	803	finally
    //   816	821	823	java/lang/Exception
    //   672	690	840	finally
    //   672	690	844	java/lang/Exception
    //   580	634	849	java/lang/Exception
  }
  
  public bani a()
  {
    if (this.jdField_a_of_type_Bani == null) {
      this.jdField_a_of_type_Bani = new bani(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
    return this.jdField_a_of_type_Bani;
  }
  
  public String a()
  {
    String str2 = String.valueOf(this.j);
    String str3 = this.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg: templateId = " + str2 + ";name = " + str3);
    }
    if (c())
    {
      String str1 = a(str2, str3, 15);
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
        }
        localObject2 = str1;
        return localObject2;
      }
      Object localObject1 = a().a(str2, true);
      if ((localObject1 == null) || (((bano)localObject1).jdField_c_of_type_Banl == null))
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg info = null ; templateId = " + str2 + "; name = " + str3);
        a().a(16L, str2, null);
        return null;
      }
      Object localObject2 = a(str2, "", 14, ((bano)localObject1).jdField_d_of_type_Int, ((bano)localObject1).jdField_a_of_type_Int);
      Object localObject3 = new File((String)localObject2);
      if (!((File)localObject3).exists())
      {
        Object localObject4 = ((bano)localObject1).jdField_c_of_type_Banl;
        if (localObject4 == null)
        {
          QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists senddecorate = null; templateId = " + str2 + ";name = " + str3);
          return null;
        }
        localObject4 = ((banl)localObject4).e;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists url is empty; templateId = " + str2 + ";name = " + str3);
          return null;
        }
        int i1 = bato.a(new batm((String)localObject4, (File)localObject3), null);
        if (i1 != 0)
        {
          QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists download bg faile; templateId = " + str2 + ";name = " + str3 + "; downloadresult = " + i1);
          return null;
        }
      }
      if (!((File)localObject3).exists())
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists file not exists 2222; templateId = " + str2 + ";name = " + str3);
        return null;
      }
      if ((((bano)localObject1).jdField_a_of_type_Int == bano.jdField_c_of_type_Int) || (TextUtils.isEmpty(str3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg1 templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
        }
        return localObject2;
      }
      localObject2 = a(str3, 15);
      if (localObject2 == null)
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg fontImg = null ; templateId = " + str2 + "; name = " + str3);
        return null;
      }
      if (((ajlb)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg savefontimg");
        }
        a(((ajlb)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, str2, str3, 4);
      }
      localObject3 = a((ajlb)localObject2, str2, str3, 15);
      if (localObject3 != null)
      {
        if (((ajlb)localObject2).jdField_b_of_type_Boolean) {
          a((Bitmap)localObject3, str2, str3, 18);
        }
        for (localObject1 = a(str2, str3, 18, ((bano)localObject1).jdField_d_of_type_Int, bano.jdField_b_of_type_Int);; localObject1 = a(str2, str3, 15, ((bano)localObject1).jdField_d_of_type_Int, bano.jdField_b_of_type_Int))
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg2 templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
          return localObject1;
          a((Bitmap)localObject3, str2, str3, 15);
        }
      }
      QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg3 null allowshowredpacket templateId =" + str2 + ";name = " + str3);
      return null;
    }
    QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg not allowshowredpacket templateId =" + str2 + ";name = " + str3);
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (!c())
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "getTenpayCombineImg: isAllowShowRedpacket = false templateId = " + paramString1 + ";name = " + paramString2);
        localObject1 = localObject2;
      }
    }
    do
    {
      return localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject1 = localObject3;
        if (a().jdField_b_of_type_Bank.a().contains(paramString2)) {
          localObject1 = a(paramString1, paramString2, 13);
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = a(paramString1, paramString2, 7);
      }
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_d_of_type_JavaLangString, 2, "getTenpayCombineImg: templateId = " + paramString1 + ";name = " + paramString2 + ", path = " + (String)localObject2);
    return localObject2;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = a().a(paramString1, true);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg fail! can't find template templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      return localObject2;
      localObject1 = a(paramString1, paramString2, paramInt, ((bano)localObject1).jdField_d_of_type_Int, ((bano)localObject1).jdField_a_of_type_Int);
      label100:
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedList;
      if (localObject1 != null) {}
      try
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.contains(localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg fail! file Saving! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          }
          return null;
          localObject1 = a("", paramString2, paramInt, 0, 0);
          break label100;
        }
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ((File)localObject2).setLastModified(NetConnInfoCenter.getServerTimeMillis());
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg success! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          return localObject1;
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg fail! file not exists! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.post(new IndividualRedPacketManager.2(this), 2, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "IndividualRedPacketManager.setRedPacketFlags iCanUseRed:" + paramInt1 + ", iRedDisable:" + paramInt2 + ", isUpdate:" + paramBoolean + ", this.iCanUseRed:" + this.h + ", this.iRedDisable:" + this.i);
    }
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = this.h;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = this.i;
    }
    if ((this.h != i1) || (this.i != paramInt1))
    {
      this.h = i1;
      this.i = paramInt1;
      if (paramBoolean)
      {
        SharedPreferences localSharedPreferences = a();
        localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", i1);
        localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramInt1);
        localSharedPreferences.edit().commit();
      }
      if ((i1 == 1) && (paramInt1 == 0)) {
        jdField_c_of_type_JavaLangString = "1";
      }
    }
    else
    {
      return;
    }
    jdField_c_of_type_JavaLangString = "0";
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "setRedpacketInfo redpacketId = " + paramInt + "; redpacketText = " + paramString);
    }
    this.j = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
    SharedPreferences localSharedPreferences = a();
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramInt);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramString);
    localSharedPreferences.edit().commit();
  }
  
  /* Error */
  public void a(Bitmap arg1, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnonnull +20 -> 24
    //   7: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   16: iconst_2
    //   17: ldc_w 1169
    //   20: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_2
    //   25: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +445 -> 473
    //   31: aload_0
    //   32: invokevirtual 239	ajkz:a	()Lbani;
    //   35: aload_2
    //   36: iconst_1
    //   37: invokevirtual 244	bani:a	(Ljava/lang/String;Z)Lbano;
    //   40: astore 7
    //   42: aload 7
    //   44: ifnull +429 -> 473
    //   47: aload 7
    //   49: getfield 269	bano:jdField_d_of_type_Int	I
    //   52: istore 6
    //   54: aload 7
    //   56: getfield 270	bano:jdField_a_of_type_Int	I
    //   59: istore 5
    //   61: iload 4
    //   63: iconst_5
    //   64: if_icmpne +27 -> 91
    //   67: aload_3
    //   68: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +20 -> 91
    //   74: aload_0
    //   75: invokevirtual 239	ajkz:a	()Lbani;
    //   78: getfield 709	bani:jdField_b_of_type_Bank	Lbank;
    //   81: invokevirtual 713	bank:a	()Ljava/lang/String;
    //   84: aload_3
    //   85: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifne -65 -> 23
    //   91: aload_2
    //   92: aload_3
    //   93: iload 4
    //   95: iload 6
    //   97: iload 5
    //   99: invokestatic 273	ajkz:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   102: astore 8
    //   104: aload 8
    //   106: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +19 -> 128
    //   112: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   121: iconst_2
    //   122: ldc_w 1171
    //   125: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: new 626	java/io/File
    //   131: dup
    //   132: aload 8
    //   134: invokespecial 753	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 758	java/io/File:exists	()Z
    //   142: ifeq +38 -> 180
    //   145: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -125 -> 23
    //   151: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_2
    //   155: new 47	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 1173
    //   165: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 8
    //   170: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: return
    //   180: aload_0
    //   181: getfield 176	ajkz:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   184: astore_3
    //   185: aload_3
    //   186: monitorenter
    //   187: aload_0
    //   188: getfield 176	ajkz:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   191: aload 8
    //   193: invokevirtual 1174	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: aload_3
    //   198: monitorexit
    //   199: aconst_null
    //   200: astore_3
    //   201: aconst_null
    //   202: astore 7
    //   204: new 1037	java/io/BufferedOutputStream
    //   207: dup
    //   208: new 1039	java/io/FileOutputStream
    //   211: dup
    //   212: aload_2
    //   213: invokespecial 1042	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: invokespecial 1045	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   219: astore_2
    //   220: aload_2
    //   221: astore_3
    //   222: aload_1
    //   223: getstatic 1051	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   226: bipush 90
    //   228: aload_2
    //   229: invokevirtual 1055	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   232: pop
    //   233: aload_2
    //   234: astore_3
    //   235: aload_2
    //   236: invokevirtual 1058	java/io/BufferedOutputStream:flush	()V
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 1059	java/io/BufferedOutputStream:close	()V
    //   247: aload_0
    //   248: getfield 176	ajkz:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   251: astore_1
    //   252: aload_1
    //   253: monitorenter
    //   254: aload_0
    //   255: getfield 176	ajkz:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   258: aload 8
    //   260: invokevirtual 1177	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_1
    //   265: monitorexit
    //   266: return
    //   267: astore_2
    //   268: aload_1
    //   269: monitorexit
    //   270: aload_2
    //   271: athrow
    //   272: astore_1
    //   273: aload_3
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   281: iconst_1
    //   282: ldc_w 1179
    //   285: aload_1
    //   286: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -42 -> 247
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_2
    //   295: aload_2
    //   296: astore_3
    //   297: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +35 -> 335
    //   303: aload_2
    //   304: astore_3
    //   305: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   308: iconst_2
    //   309: new 47	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 1181
    //   319: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 1182	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_2
    //   336: ifnull -89 -> 247
    //   339: aload_2
    //   340: invokevirtual 1059	java/io/BufferedOutputStream:close	()V
    //   343: goto -96 -> 247
    //   346: astore_1
    //   347: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   350: iconst_1
    //   351: ldc_w 1179
    //   354: aload_1
    //   355: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -111 -> 247
    //   361: astore_2
    //   362: aload 7
    //   364: astore_1
    //   365: aload_1
    //   366: astore_3
    //   367: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +35 -> 405
    //   373: aload_1
    //   374: astore_3
    //   375: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   378: iconst_2
    //   379: new 47	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 1181
    //   389: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_2
    //   393: invokevirtual 927	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload_1
    //   406: ifnull -159 -> 247
    //   409: aload_1
    //   410: invokevirtual 1059	java/io/BufferedOutputStream:close	()V
    //   413: goto -166 -> 247
    //   416: astore_1
    //   417: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   420: iconst_1
    //   421: ldc_w 1179
    //   424: aload_1
    //   425: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: goto -181 -> 247
    //   431: astore_1
    //   432: aload_3
    //   433: ifnull +7 -> 440
    //   436: aload_3
    //   437: invokevirtual 1059	java/io/BufferedOutputStream:close	()V
    //   440: aload_1
    //   441: athrow
    //   442: astore_2
    //   443: getstatic 45	ajkz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   446: iconst_1
    //   447: ldc_w 1179
    //   450: aload_2
    //   451: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   454: goto -14 -> 440
    //   457: astore_1
    //   458: goto -26 -> 432
    //   461: astore_3
    //   462: aload_2
    //   463: astore_1
    //   464: aload_3
    //   465: astore_2
    //   466: goto -101 -> 365
    //   469: astore_1
    //   470: goto -175 -> 295
    //   473: iconst_0
    //   474: istore 6
    //   476: goto -415 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	ajkz
    //   0	479	2	paramString1	String
    //   0	479	3	paramString2	String
    //   0	479	4	paramInt	int
    //   1	97	5	i1	int
    //   52	423	6	i2	int
    //   40	323	7	localbano	bano
    //   102	157	8	str	String
    // Exception table:
    //   from	to	target	type
    //   254	266	267	finally
    //   268	270	267	finally
    //   187	199	272	finally
    //   273	275	272	finally
    //   243	247	277	java/lang/Exception
    //   204	220	292	java/io/FileNotFoundException
    //   339	343	346	java/lang/Exception
    //   204	220	361	java/io/IOException
    //   409	413	416	java/lang/Exception
    //   204	220	431	finally
    //   367	373	431	finally
    //   375	405	431	finally
    //   436	440	442	java/lang/Exception
    //   222	233	457	finally
    //   235	239	457	finally
    //   297	303	457	finally
    //   305	335	457	finally
    //   222	233	461	java/io/IOException
    //   235	239	461	java/io/IOException
    //   222	233	469	java/io/FileNotFoundException
    //   235	239	469	java/io/FileNotFoundException
  }
  
  public void a(bank parambank)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      QLog.e(jdField_d_of_type_JavaLangString, 1, "preCreatePersonalFontImg mIsSDCardError:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) || (parambank.jdField_a_of_type_Int == 0) || (TextUtils.isEmpty(parambank.a())) || (!bani.a(a().jdField_a_of_type_Bann)));
      if (b().getInt("font_precreate_count", 0) >= parambank.jdField_c_of_type_Int)
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "preCreatePersonalFontImg count >= " + parambank.jdField_c_of_type_Int);
        return;
      }
    } while ((!b()) || (!this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)));
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("RedPacketPrecreate", 19);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Ajlc = new ajlc(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambank);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_Ajlc);
    this.jdField_a_of_type_Ajlc.a();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = b().getString("cach_font_id", "");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(a().jdField_a_of_type_Bann.jdField_d_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "Clear SDCard Cache Start!");
      }
      localObject = new String[5];
      localObject[0] = a(4);
      localObject[1] = a(5);
      localObject[2] = a(6);
      localObject[3] = a(7);
      localObject[4] = a(8);
      int i1 = 0;
      while (i1 < localObject.length)
      {
        File localFile1 = new File(localObject[i1]);
        if ((localFile1.exists()) && (localFile1.isDirectory()))
        {
          File[] arrayOfFile = localFile1.listFiles();
          int i2 = 0;
          while (i2 < arrayOfFile.length)
          {
            File localFile2 = new File(arrayOfFile[i2].getParent() + File.separator + System.currentTimeMillis());
            arrayOfFile[i2].renameTo(localFile2);
            localFile2.delete();
            i2 += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "Clear " + localFile1.getAbsolutePath() + " done!");
          }
        }
        i1 += 1;
      }
    }
    b().edit().putString("cach_font_id", paramString).commit();
  }
  
  public void a(String paramString, int paramInt)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo;
    Object localObject1;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "onDoneDownloadBG id = " + paramString + ", resType:" + paramInt);
        }
        localRedPacketInfo = (CustomizeStrategyFactory.RedPacketInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      } while (localRedPacketInfo == null);
      localObject1 = a().a(localRedPacketInfo.templateId, true);
    } while (localObject1 == null);
    label111:
    Object localObject2;
    if (((bano)localObject1).jdField_a_of_type_Int == bano.jdField_b_of_type_Int)
    {
      int i1;
      if (paramInt == 2)
      {
        i1 = 6;
        localObject1 = a(localRedPacketInfo.jdField_a_of_type_JavaLangString, i1);
        localObject2 = a((ajlb)localObject1, localRedPacketInfo, i1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "onDoneDownloadBG type = " + i1);
        }
        if ((((ajlb)localObject1).jdField_a_of_type_AndroidGraphicsBitmap != null) && (!((ajlb)localObject1).jdField_a_of_type_Boolean)) {
          a(((ajlb)localObject1).jdField_a_of_type_AndroidGraphicsBitmap, "", localRedPacketInfo.jdField_a_of_type_JavaLangString, 5);
        }
        paramInt = i2;
        if (6 == i1)
        {
          paramInt = i2;
          if (((ajlb)localObject1).jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            paramInt = i2;
            if (localObject2 != null)
            {
              if (((ajlb)localObject1).jdField_b_of_type_Boolean) {
                break label305;
              }
              a((Bitmap)localObject2, localRedPacketInfo.templateId, localRedPacketInfo.jdField_a_of_type_JavaLangString, 6);
            }
          }
        }
      }
      for (paramInt = i2;; paramInt = i2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (paramInt == 0) {
          break;
        }
        CustomizeStrategyFactory.a().a(localRedPacketInfo);
        return;
        if (paramInt == 3)
        {
          i1 = 7;
          break label111;
        }
        i1 = paramInt;
        if (paramInt != 14) {
          break label111;
        }
        i1 = 15;
        break label111;
        label305:
        a((Bitmap)localObject2, localRedPacketInfo.templateId, localRedPacketInfo.jdField_a_of_type_JavaLangString, 12);
      }
    }
    if (paramInt == 19)
    {
      localObject2 = ((bano)localObject1).jdField_a_of_type_Banl;
      if ((localObject2 == null) || (((banl)localObject2).jdField_a_of_type_Acko == null)) {
        break label466;
      }
      localObject2 = a(((banl)localObject2).jdField_d_of_type_JavaLangString, null, ((banl)localObject2).f, ((banl)localObject2).jdField_d_of_type_Int, 0);
      File localFile = new File((String)localObject2);
      if ((localFile != null) && (localFile.exists()) && (localFile.isFile())) {
        a((bano)localObject1, localRedPacketInfo, (String)localObject2, false);
      }
      if (localRedPacketInfo.jdField_a_of_type_Acko == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = 1;; paramInt = 0)
    {
      break;
      if (paramInt == 2) {
        localRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = a(a(((bano)localObject1).jdField_a_of_type_JavaLangString, "", 6), null);
      }
      paramInt = 1;
      break;
    }
  }
  
  public void a(String paramString, Bundle paramBundle, MessengerService paramMessengerService)
  {
    bano localbano = a().a(paramString, true);
    int i2 = n;
    int i1 = i2;
    if (localbano != null)
    {
      i1 = i2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (localbano.jdField_a_of_type_Banl != null) {
          i1 = localbano.jdField_a_of_type_Banl.f;
        }
        if (!new File(a(paramString, "", 2, localbano.jdField_d_of_type_Int, localbano.jdField_a_of_type_Int)).exists()) {
          break label141;
        }
      }
    }
    label141:
    for (i1 = m;; i1 = n)
    {
      if (i1 != m) {
        a().a(16L, paramString, null);
      }
      paramString = new Bundle();
      paramString.putInt("result", i1);
      paramBundle.putBundle("response", paramString);
      paramMessengerService.a(paramBundle);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService)
  {
    ThreadManager.post(new IndividualRedPacketManager.4(this, paramString1, paramString2, paramBundle, paramMessengerService), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new String[9];
    localObject[0] = a(1);
    localObject[1] = a(3);
    localObject[2] = a(1);
    localObject[3] = a(5);
    localObject[4] = a(4);
    localObject[5] = a(6);
    localObject[6] = a(7);
    localObject[7] = a(8);
    localObject[8] = a(2);
    int i3 = 0;
    int i4;
    int i2;
    for (int i1 = 0; i3 < localObject.length; i1 = i4)
    {
      File localFile = new File(localObject[i3]);
      if (localFile.exists())
      {
        i4 = i1;
        if (localFile.isDirectory()) {}
      }
      else
      {
        bool1 = localFile.mkdirs();
        i2 = i1;
        if (!bool1) {
          i2 = i1 + 1;
        }
        i4 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "initDir path:" + localObject[i3] + ", mkdirs:" + bool1 + ", errCode:" + i2);
          i4 = i2;
        }
      }
      i3 += 1;
    }
    boolean bool2;
    if (i1 <= 0)
    {
      i2 = 1;
      if (i2 == 0)
      {
        bool2 = bavz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), jdField_d_of_type_JavaLangString, false);
        localObject = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (bool2) {
          break label389;
        }
      }
    }
    label389:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((AtomicBoolean)localObject).set(bool1);
      QLog.e(jdField_d_of_type_JavaLangString, 2, "initDir Err haveSDCard:" + bool2 + ", mIsSDCardError:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", errCode:" + i1);
      if ((this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramBoolean))
      {
        jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + File.separator + "dRedPacket/";
        a(false);
      }
      return;
      i2 = 0;
      break;
    }
  }
  
  public boolean a()
  {
    return (this.h == 1) && (this.i == 0);
  }
  
  public SharedPreferences b()
  {
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject = localQQAppInterface;
      if (localQQAppInterface == null) {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
      }
      this.jdField_b_of_type_AndroidContentSharedPreferences = ((AppRuntime)localObject).getApplication().getApplicationContext().getSharedPreferences("individRedPacket_common", 0);
    }
    return this.jdField_b_of_type_AndroidContentSharedPreferences;
  }
  
  public boolean b()
  {
    return this.i == 0;
  }
  
  public boolean c()
  {
    return (b()) && (a().jdField_a_of_type_Boolean);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_Ajlc != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Bani != null)
    {
      this.jdField_a_of_type_Bani.b();
      this.jdField_a_of_type_Bani = null;
    }
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajkz
 * JD-Core Version:    0.7.0.1
 */
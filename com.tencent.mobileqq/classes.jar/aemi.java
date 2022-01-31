import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.2;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.3;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.4;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.5;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.6;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.8;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.9;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.emosm.PicSearchSvr.ImgInfo;
import com.tencent.pb.emosm.PicSearchSvr.ReqBody;
import com.tencent.pb.emosm.PicSearchSvr.RspBody;
import com.tencent.pb.emosm.PicSearchWordsSvr.RspBody;
import com.tencent.pb.emosm.PicSearchWordsSvr.WordsMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Laemo;>;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aemi
  implements Manager
{
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static Integer jdField_a_of_type_JavaLangInteger;
  private int jdField_a_of_type_Int = 6;
  private aely jdField_a_of_type_Aely;
  private aemf jdField_a_of_type_Aemf;
  private aeml jdField_a_of_type_Aeml;
  private arnz jdField_a_of_type_Arnz;
  private atmp jdField_a_of_type_Atmp;
  private BloomFilter jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private File jdField_a_of_type_JavaIoFile;
  private volatile String jdField_a_of_type_JavaLangString = "";
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private List<aeln> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getFileThreadHandler();
  private volatile boolean jdField_a_of_type_Boolean;
  private final aeml jdField_b_of_type_Aeml = new aemj(this);
  private File jdField_b_of_type_JavaIoFile;
  private List<aelm> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private File c;
  private File d;
  
  public aemi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_b_of_type_Boolean = baig.D(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Arnz = ((arnz)paramQQAppInterface.getManager(14));
    d();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    a(new aemh(paramQQAppInterface));
    this.jdField_a_of_type_Aely = new aely(paramQQAppInterface);
    a(this.jdField_a_of_type_Aely);
    this.jdField_a_of_type_Aemf = new aemf(paramQQAppInterface);
    a(this.jdField_a_of_type_Aemf);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    if (jdField_a_of_type_JavaLangInteger == null) {
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + paramString, paramInt));
    }
    return 6;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_VERSION" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static aemi a(QQAppInterface paramQQAppInterface)
  {
    return (aemi)paramQQAppInterface.getManager(314);
  }
  
  public static File a(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = new File(aemb.jdField_a_of_type_JavaLangString + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 5
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: new 215	java/io/ObjectInputStream
    //   18: dup
    //   19: new 217	java/io/BufferedInputStream
    //   22: dup
    //   23: new 219	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 223	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 224	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: invokevirtual 228	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: ifnull -39 -> 13
    //   55: aload_3
    //   56: invokevirtual 231	java/io/ObjectInputStream:close	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_1
    //   62: aload_2
    //   63: areturn
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +43 -> 116
    //   76: aload_3
    //   77: astore_2
    //   78: ldc 239
    //   80: iconst_2
    //   81: new 145	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   88: ldc 241
    //   90: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 243
    //   99: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 4
    //   104: invokevirtual 244	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 248	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 5
    //   118: astore_1
    //   119: aload_3
    //   120: ifnull -107 -> 13
    //   123: aload_3
    //   124: invokevirtual 231	java/io/ObjectInputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_1
    //   130: aconst_null
    //   131: areturn
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_3
    //   135: aload_3
    //   136: astore_2
    //   137: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +13 -> 153
    //   143: aload_3
    //   144: astore_2
    //   145: ldc 239
    //   147: iconst_2
    //   148: ldc 250
    //   150: invokestatic 248	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload 5
    //   155: astore_1
    //   156: aload_3
    //   157: ifnull -144 -> 13
    //   160: aload_3
    //   161: invokevirtual 231	java/io/ObjectInputStream:close	()V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_1
    //   167: aconst_null
    //   168: areturn
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 231	java/io/ObjectInputStream:close	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_2
    //   183: goto -3 -> 180
    //   186: astore_1
    //   187: goto -15 -> 172
    //   190: astore_1
    //   191: goto -56 -> 135
    //   194: astore 4
    //   196: goto -128 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	aemi
    //   0	199	1	paramString	String
    //   39	138	2	localObject1	Object
    //   182	1	2	localIOException	java.io.IOException
    //   37	124	3	localObjectInputStream	java.io.ObjectInputStream
    //   44	3	4	localObject2	Object
    //   64	39	4	localException1	Exception
    //   194	1	4	localException2	Exception
    //   1	153	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	59	61	java/io/IOException
    //   15	38	64	java/lang/Exception
    //   123	127	129	java/io/IOException
    //   15	38	132	java/lang/OutOfMemoryError
    //   160	164	166	java/io/IOException
    //   15	38	169	finally
    //   176	180	182	java/io/IOException
    //   40	46	186	finally
    //   70	76	186	finally
    //   78	116	186	finally
    //   137	143	186	finally
    //   145	153	186	finally
    //   40	46	190	java/lang/OutOfMemoryError
    //   40	46	194	java/lang/Exception
  }
  
  private List<aelm> a(List<aelm> paramList, StickerRecommendSortEntity paramStickerRecommendSortEntity)
  {
    int i2 = 0;
    int j;
    int m;
    label104:
    int k;
    label122:
    int i;
    int n;
    label203:
    int i1;
    if (paramStickerRecommendSortEntity != null)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort clicked=" + paramStickerRecommendSortEntity.clicked + " exposed=" + paramStickerRecommendSortEntity.exposed + " noExpose=" + paramStickerRecommendSortEntity.noExpose);
        }
        if (paramStickerRecommendSortEntity.clickedList == null) {
          break label438;
        }
        j = paramStickerRecommendSortEntity.clickedList.size();
        if (paramStickerRecommendSortEntity.noExposeList == null) {
          break label432;
        }
        m = paramStickerRecommendSortEntity.noExposeList.size();
        if (paramStickerRecommendSortEntity.exposedList == null) {
          break label426;
        }
        k = paramStickerRecommendSortEntity.exposedList.size();
        i3 = paramList.size();
        i = j + m + k;
        if (i3 != i)
        {
          if (!QLog.isColorLevel()) {
            break label444;
          }
          QLog.i("StickerRecManager", 2, "sort data:length is not equals. size=" + i3 + " sortSize=" + i);
          break label444;
        }
        arrayOfaelm = new aelm[i3];
        n = 0;
        i = 0;
        if (n >= j) {
          break label455;
        }
        i1 = ((Integer)paramStickerRecommendSortEntity.clickedList.get(n)).intValue();
        if ((i1 >= i3) || (i >= i3)) {
          break label423;
        }
        arrayOfaelm[i] = ((aelm)paramList.get(i1));
        i += 1;
      }
      catch (Throwable paramList)
      {
        int i3;
        aelm[] arrayOfaelm;
        label264:
        QLog.e("StickerRecManager", 1, "sortData:", paramList);
      }
      j = i;
      i1 = i2;
      if (n < m)
      {
        j = ((Integer)paramStickerRecommendSortEntity.noExposeList.get(n)).intValue();
        if ((j >= i3) || (i >= i3)) {
          break label420;
        }
        arrayOfaelm[i] = ((aelm)paramList.get(j));
        i += 1;
        break label461;
      }
    }
    for (;;)
    {
      if (i1 < k)
      {
        i = ((Integer)paramStickerRecommendSortEntity.exposedList.get(i1)).intValue();
        if ((i < i3) && (j < i3))
        {
          arrayOfaelm[j] = ((aelm)paramList.get(i));
          i = j + 1;
          break label470;
        }
      }
      else
      {
        paramList = Arrays.asList(arrayOfaelm);
        return paramList;
        return null;
      }
      i = j;
      break label470;
      label420:
      break label461;
      label423:
      break label446;
      label426:
      k = 0;
      break label122;
      label432:
      m = 0;
      break label104;
      label438:
      j = 0;
      break;
      label444:
      return null;
      label446:
      n += 1;
      break label203;
      label455:
      n = 0;
      break label264;
      label461:
      n += 1;
      break label264;
      label470:
      i1 += 1;
      j = i;
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + paramString, paramInt).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_VERSION" + paramQQAppInterface.getCurrentAccountUin(), paramInt).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.c();
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
    if (jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      a(paramQQAppInterface).c();
    }
    localBaseApplication.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putBoolean("RECOMMENDED_STICKER_SWITCH" + str, paramBoolean).apply();
  }
  
  private void a(File paramFile1, File paramFile2)
  {
    if (paramFile2.exists()) {
      paramFile2.delete();
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      bace.a(paramFile1, paramFile2);
      paramFile1.delete();
    }
  }
  
  /* Error */
  private void a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 382	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 384	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 386	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 390	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 391	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 4
    //   37: aload_2
    //   38: invokevirtual 395	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokevirtual 398	java/io/ObjectOutputStream:flush	()V
    //   49: aload 4
    //   51: ifnull -44 -> 7
    //   54: aload 4
    //   56: invokevirtual 399	java/io/ObjectOutputStream:close	()V
    //   59: return
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 400	java/io/IOException:printStackTrace	()V
    //   65: return
    //   66: astore 5
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +44 -> 119
    //   78: aload_2
    //   79: astore_3
    //   80: ldc 239
    //   82: iconst_2
    //   83: new 145	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 402
    //   93: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 243
    //   102: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 5
    //   107: invokevirtual 244	java/lang/Exception:toString	()Ljava/lang/String;
    //   110: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 248	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_2
    //   120: ifnull -113 -> 7
    //   123: aload_2
    //   124: invokevirtual 399	java/io/ObjectOutputStream:close	()V
    //   127: return
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 400	java/io/IOException:printStackTrace	()V
    //   133: return
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_3
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 399	java/io/ObjectOutputStream:close	()V
    //   145: aload_1
    //   146: athrow
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 400	java/io/IOException:printStackTrace	()V
    //   152: goto -7 -> 145
    //   155: astore_1
    //   156: goto -19 -> 137
    //   159: astore 5
    //   161: aload 4
    //   163: astore_2
    //   164: goto -94 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	aemi
    //   0	167	1	paramString	String
    //   0	167	2	paramObject	Object
    //   34	108	3	localObject	Object
    //   30	132	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   66	40	5	localException1	Exception
    //   159	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   54	59	60	java/io/IOException
    //   8	32	66	java/lang/Exception
    //   123	127	128	java/io/IOException
    //   8	32	134	finally
    //   141	145	147	java/io/IOException
    //   35	41	155	finally
    //   44	49	155	finally
    //   72	78	155	finally
    //   80	119	155	finally
    //   35	41	159	java/lang/Exception
    //   44	49	159	java/lang/Exception
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "updateWords fail: url is null.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "start download words");
    }
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_JavaIoFile.getParentFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = new axro();
        ((axro)localObject).jdField_a_of_type_Axrt = new aemk(this, paramString2, bool, paramString3);
        ((axro)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((axro)localObject).jdField_a_of_type_Int = 0;
        ((axro)localObject).jdField_c_of_type_JavaLangString = this.d.getAbsolutePath();
        ((axro)localObject).jdField_c_of_type_Int = badq.a(axsr.a().a());
        try
        {
          paramString2 = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramString2)) {
            break;
          }
          ((QQAppInterface)paramString2).getNetEngine(0).a((axsp)localObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("StickerRecManager", 2, "start download words, url: " + paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("StickerRecManager", 1, "download follow words error", paramString1);
          return;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      localHashMap.put("initTimeCost", paramLong + "");
      awrn.a(BaseApplication.getContext()).a(null, "StickerRecInitCost", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aeln)localIterator.next();
        if (((aeln)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
        {
          localObject = ((aeln)localObject).a(paramString);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            localArrayList.addAll((Collection)localObject);
          }
        }
      }
      paramString = aelo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if ((paramString != null) && (!paramString.isEmpty())) {
        this.jdField_b_of_type_JavaUtilList.addAll(paramString);
      }
      paramString = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramString.hasNext()) {
        ((aelm)paramString.next()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "handleLocalEmoticon time = " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new PicSearchWordsSvr.RspBody();
      ((PicSearchWordsSvr.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((PicSearchWordsSvr.RspBody)localObject).int32_result.get() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "handlePullWords response code error,result:" + ((PicSearchWordsSvr.RspBody)localObject).int32_result.get() + " message : " + ((PicSearchWordsSvr.RspBody)localObject).bytes_fail_msg.get());
        }
      }
      else
      {
        paramArrayOfByte = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_version.get().toStringUtf8();
        String str1 = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_md5.get().toStringUtf8();
        String str2 = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_url.get().toStringUtf8();
        int i = ((PicSearchWordsSvr.RspBody)localObject).words_msg.uint32_words_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "pull words resp:version=" + paramArrayOfByte + " wordsMd5=" + str1 + " wordsUrl=" + str2 + " wordsType=" + i);
        }
        localObject = baig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "words_version_key805_gray_one", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if ((!((String)localObject).equals(paramArrayOfByte)) || (!this.c.exists()))
        {
          a(str2, str1, i, paramArrayOfByte);
          return;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("StickerRecManager", 2, befj.a(paramArrayOfByte));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "not need pull words: localVersion=" + (String)localObject + " server version=" + paramArrayOfByte);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "cache pics in DB");
    }
    if (this.jdField_a_of_type_Atmp != null)
    {
      StickerRecommendEntity localStickerRecommendEntity = new StickerRecommendEntity();
      localStickerRecommendEntity.usrMessage = paramString;
      localStickerRecommendEntity.recList = Base64.encodeToString(paramArrayOfByte, 0);
      localStickerRecommendEntity.cachedTime = System.currentTimeMillis();
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.5(this, localStickerRecommendEntity));
    }
  }
  
  private void a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean, StickerRecommendSortEntity paramStickerRecommendSortEntity)
  {
    PicSearchSvr.RspBody localRspBody;
    List localList;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "handlePullPics from : " + paramString2);
      }
      localRspBody = new PicSearchSvr.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.int32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          break label646;
        }
        QLog.d("StickerRecManager", 2, "handleResponse response code error,result:" + localRspBody.int32_result.get() + " message : " + localRspBody.bytes_fail_msg.get());
        return;
      }
      localList = localRspBody.rpt_msg_img_info.get();
      if ((localList != null) && (!localList.isEmpty())) {
        break label213;
      }
      if ("network".equals(paramString2)) {
        i();
      }
      if (this.jdField_a_of_type_Atmp != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.6(this, paramString1));
      }
      if (!QLog.isColorLevel()) {
        break label646;
      }
      QLog.d("StickerRecManager", 2, "handleResponse imgInfos is null or empty");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (!QLog.isColorLevel()) {
        break label646;
      }
    }
    QLog.d("StickerRecManager", 2, befj.a(paramArrayOfByte));
    return;
    label213:
    paramArrayOfByte = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      PicSearchSvr.ImgInfo localImgInfo = (PicSearchSvr.ImgInfo)localList.get(i);
      aemc localaemc = new aemc();
      localaemc.e(i);
      localaemc.a(localImgInfo.uint64_img_size.get());
      localaemc.a(localImgInfo.uint32_img_width.get());
      localaemc.b(localImgInfo.uint32_img_height.get());
      localaemc.d(localImgInfo.bytes_img_md5.get().toStringUtf8());
      localaemc.b(localImgInfo.bytes_img_down_url.get().toStringUtf8());
      localaemc.b(localImgInfo.uint64_thumb_size.get());
      localaemc.d(localImgInfo.uint32_thumb_img_height.get());
      localaemc.c(localImgInfo.uint32_thumb_img_width.get());
      localaemc.c(localImgInfo.bytes_thumb_down_url.get().toStringUtf8());
      localaemc.e(localImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
      localaemc.f(localImgInfo.uint32_src_type.get());
      localaemc.f(localImgInfo.bytes_src_desc.get().toStringUtf8());
      localaemc.g(localImgInfo.bytes_web_url.get().toStringUtf8());
      localaemc.h("");
      localaemc.i(localImgInfo.bytes_pack_name.get().toStringUtf8());
      localaemc.g(localImgInfo.uint32_pack_id.get());
      paramArrayOfByte.add(localaemc);
      i += 1;
    }
    paramStickerRecommendSortEntity = a(paramArrayOfByte, paramStickerRecommendSortEntity);
    if (paramStickerRecommendSortEntity != null)
    {
      paramArrayOfByte = paramStickerRecommendSortEntity;
      paramStickerRecommendSortEntity = paramArrayOfByte;
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        paramStickerRecommendSortEntity = paramArrayOfByte;
        if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
        {
          paramStickerRecommendSortEntity = new ArrayList(paramArrayOfByte);
          paramStickerRecommendSortEntity.addAll(0, this.jdField_b_of_type_JavaUtilList);
          this.jdField_b_of_type_JavaUtilList.clear();
        }
      }
      if (!"network".equals(paramString2)) {
        break label647;
      }
    }
    label646:
    label647:
    for (paramArrayOfByte = localRspBody.bytes_rsp_other.get().toStringUtf8();; paramArrayOfByte = "999")
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Aeml.a(paramStickerRecommendSortEntity, paramString1, paramArrayOfByte);
        return;
      }
      if (this.jdField_a_of_type_Aeml != null)
      {
        this.jdField_a_of_type_Aeml.a(paramStickerRecommendSortEntity, paramString1, paramArrayOfByte);
        return;
        break;
      }
      return;
    }
  }
  
  public static boolean a(aelm paramaelm)
  {
    return paramaelm.a();
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getBoolean("RECOMMENDED_STICKER_SWITCH" + paramString, paramBoolean));
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isStickerPics());
  }
  
  private boolean a(File paramFile1, File paramFile2)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(paramFile2.getParent() + File.separator + "temp");
      mpx.a(paramFile1, localFile.getAbsolutePath() + File.separator);
      paramFile1 = localFile.listFiles();
      int j = paramFile1.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramFile1[i];
        String str = localFile.getName();
        if ((localFile.isFile()) && (str.endsWith("json"))) {
          a(localFile, paramFile2);
        }
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramFile1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StickerRecManager", 2, "uncompress template zip file error", paramFile1);
    }
    return bool;
    return false;
  }
  
  private boolean a(File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
  {
    if (a(paramFile1, paramString))
    {
      if (paramBoolean)
      {
        if (a(paramFile1, paramFile2))
        {
          paramFile1.delete();
          return true;
        }
      }
      else
      {
        a(paramFile1, paramFile2);
        return true;
      }
    }
    else
    {
      paramFile1.delete();
      if (QLog.isColorLevel()) {
        QLog.e("StickerRecManager", 2, "downloadFile zip md5 is wrong");
      }
    }
    return false;
  }
  
  private boolean a(File paramFile, String paramString)
  {
    boolean bool = true;
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("StickerRecManager", 2, "downloadFile zip file not exists");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramFile = bace.c(paramFile.getPath());
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramFile))) {
          break label70;
        }
        return bool;
      }
      catch (UnsatisfiedLinkError paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("StickerRecManager", 1, "calculate follow capture template zip md5 error", paramFile);
      return false;
      label70:
      bool = false;
    }
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir().getAbsolutePath() + File.separator + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + File.separator + "qstorage" + File.separator + "objs" + File.separator + "sticker_recommend";
  }
  
  public static boolean b(aelm paramaelm)
  {
    return !a(paramaelm);
  }
  
  public static String c(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      localStringBuffer.append("\\u" + Integer.toHexString(j));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String d(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = aemb.jdField_a_of_type_JavaLangString + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void f()
  {
    Object localObject = new File(aemb.jdField_a_of_type_JavaLangString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private void i()
  {
    awrn.a(BaseApplication.getContext()).a(null, "StickerRecEmptyImg", false, 0L, 0L, null, "");
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a(String paramString)
  {
    return axku.a(axku.i(baip.c(paramString).toLowerCase()));
  }
  
  public Collection<String> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = ((anbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (!TextUtils.isEmpty(localCameraEmotionData.strContext))) {
          localHashSet.add(b(localCameraEmotionData.strContext));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "loadKeywordForCameraEmotion size: " + localHashSet.size());
    }
    return localHashSet;
  }
  
  public void a()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "init has executed");
      }
      return;
    }
    try
    {
      l1 = SystemClock.elapsedRealtime();
      try
      {
        if (bace.a(this.c.getAbsolutePath())) {
          break label116;
        }
        throw new IllegalStateException("words file not exist");
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        long l2;
        Object localObject1;
        Object localObject2;
        List localList;
        long l1 = 0L;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      QLog.d("StickerRecManager", 2, befj.a(localException1));
      QLog.d("StickerRecManager", 2, "StickerRecManager error init time cost : " + (SystemClock.elapsedRealtime() - l1));
    }
    a(false, SystemClock.elapsedRealtime() - l1);
    return;
    label116:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = ((BloomFilter)a(this.c.getAbsolutePath()));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter == null) {
      throw new IllegalStateException("words file read error");
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "init bloomFilter, version : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.version);
    }
    l2 = baig.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if ((!bace.a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath())) || ((l2 != 0L) && (System.currentTimeMillis() - l2 >= 86400000L)))
    {
      baig.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0L);
      localObject1 = new HashSet();
      localObject2 = this.jdField_a_of_type_Arnz.b();
      localList = this.jdField_a_of_type_Arnz.jdField_a_of_type_JavaUtilList;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Emoticon localEmoticon = (Emoticon)((Iterator)localObject2).next();
          if (localList.isEmpty()) {
            ((HashSet)localObject1).add(localEmoticon.name);
          } else if (localList.contains(localEmoticon.epId)) {
            ((HashSet)localObject1).add(localEmoticon.name);
          }
        }
      }
      if (!((HashSet)localObject1).isEmpty())
      {
        apdh.c(this.jdField_b_of_type_JavaIoFile.getAbsolutePath());
        a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath(), localObject1);
      }
      this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    }
    for (;;)
    {
      g();
      h();
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 6);
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataCard = ((ajjj)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      this.jdField_a_of_type_Boolean = true;
      l2 = SystemClock.elapsedRealtime() - l1;
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "StickerRecManager init time cost : " + l2);
      }
      a(true, l2);
      return;
      this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath()));
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        apdh.c(this.jdField_b_of_type_JavaIoFile.getAbsolutePath());
      }
    }
  }
  
  public void a(aeln paramaeln)
  {
    if (paramaeln == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramaeln));
    this.jdField_a_of_type_JavaUtilList.add(paramaeln);
  }
  
  public void a(aeml paramaeml)
  {
    this.jdField_a_of_type_Aeml = paramaeml;
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    label193:
    for (;;)
    {
      return;
      Object localObject;
      String str;
      try
      {
        if (paramFromServiceMsg.getResultCode() != 1000) {
          break label193;
        }
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        bakz.a((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramFromServiceMsg.putWupBuffer((byte[])localObject);
        localObject = paramFromServiceMsg.getServiceCmd();
        str = paramIntent.getStringExtra("USER_KEYWORD");
        try
        {
          paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
          if (paramFromServiceMsg == null) {
            continue;
          }
          if (!"PicSearchWordsSvr.PullWords".equals(localObject)) {
            break label122;
          }
          a(paramFromServiceMsg);
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StickerRecManager", 2, befj.a(paramIntent));
        continue;
      }
      finally {}
      label122:
      if ("PicSearchSvr.PullPics".equals(localObject))
      {
        a(paramFromServiceMsg, str);
        a(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null);
      }
      else if ("BreakIceSvr.Pull".equals(localObject))
      {
        ((ajzj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285)).a(paramFromServiceMsg);
        continue;
        QLog.d("StickerRecManager", 1, String.format("result_code = %s, cmd = %s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()), paramFromServiceMsg.getServiceCmd() }));
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	aemi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 1114	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody
    //   19: dup
    //   20: invokespecial 1115	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: iconst_1
    //   28: invokevirtual 1119	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:setHasFlag	(Z)V
    //   31: new 145	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 1122	android/os/SystemClock:uptimeMillis	()J
    //   45: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 6
    //   53: invokestatic 1125	com/tencent/common/config/AppSetting:a	()I
    //   56: invokestatic 1127	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   59: astore 7
    //   61: aload_0
    //   62: getfield 65	aemi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 83	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   68: invokestatic 1132	amom:a	(Landroid/content/Context;)Ljava/lang/String;
    //   71: astore 8
    //   73: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +82 -> 158
    //   79: ldc 239
    //   81: iconst_2
    //   82: new 145	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 1134
    //   92: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 6
    //   97: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 1136
    //   103: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc_w 1138
    //   113: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_2
    //   117: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc_w 1140
    //   123: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 7
    //   128: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 1142
    //   134: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 8
    //   139: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 1144
    //   145: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload_3
    //   149: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 407	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 5
    //   160: getfield 1147	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_session_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   163: aload 6
    //   165: invokestatic 1151	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 1155	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   171: aload 5
    //   173: getfield 1158	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   176: aload_1
    //   177: invokestatic 1164	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   180: invokevirtual 1166	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   183: aload 5
    //   185: getfield 1169	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_src_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: iload_2
    //   189: invokevirtual 1171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   192: aload 5
    //   194: getfield 1174	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   197: aload 7
    //   199: invokestatic 1151	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 1155	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   205: aload 5
    //   207: getfield 1177	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_version	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   210: aload 8
    //   212: invokestatic 1151	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   215: invokevirtual 1155	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   218: aload 5
    //   220: getfield 1180	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uin32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   223: iload_3
    //   224: invokevirtual 1171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   227: aload 5
    //   229: getfield 1183	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: iload 4
    //   234: invokevirtual 1171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   237: aload 5
    //   239: invokevirtual 1186	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:toByteArray	()[B
    //   242: astore_1
    //   243: aload_1
    //   244: arraylength
    //   245: iconst_4
    //   246: iadd
    //   247: invokestatic 1192	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   250: astore 5
    //   252: aload 5
    //   254: aload_1
    //   255: arraylength
    //   256: iconst_4
    //   257: iadd
    //   258: invokevirtual 1194	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   261: aload_1
    //   262: invokevirtual 1197	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   265: pop
    //   266: aload 5
    //   268: invokevirtual 1200	java/nio/ByteBuffer:array	()[B
    //   271: astore_1
    //   272: new 1202	mqq/app/NewIntent
    //   275: dup
    //   276: aload_0
    //   277: getfield 65	aemi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   280: invokevirtual 83	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   283: ldc_w 1204
    //   286: invokespecial 1207	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   289: astore 5
    //   291: aload 5
    //   293: ldc_w 1209
    //   296: aload_1
    //   297: invokevirtual 1213	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   300: pop
    //   301: aload 5
    //   303: ldc_w 1215
    //   306: ldc_w 1089
    //   309: invokevirtual 1218	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   312: pop
    //   313: aload_0
    //   314: getfield 65	aemi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   317: aload 5
    //   319: invokevirtual 1222	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   322: goto -309 -> 13
    //   325: astore_1
    //   326: aload_0
    //   327: monitorexit
    //   328: aload_1
    //   329: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	aemi
    //   0	330	1	paramString	String
    //   0	330	2	paramInt1	int
    //   0	330	3	paramInt2	int
    //   0	330	4	paramInt3	int
    //   6	312	5	localObject	Object
    //   51	113	6	str1	String
    //   59	139	7	str2	String
    //   71	140	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   2	8	325	finally
    //   16	158	325	finally
    //   158	322	325	finally
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        Object localObject1 = new PicSearchSvr.ReqBody();
        ((PicSearchSvr.ReqBody)localObject1).setHasFlag(true);
        String str = paramString1 + SystemClock.uptimeMillis();
        ((PicSearchSvr.ReqBody)localObject1).bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
        ((PicSearchSvr.ReqBody)localObject1).uint64_src_uin.set(Long.parseLong(paramString1));
        ((PicSearchSvr.ReqBody)localObject1).uint32_src_term.set(paramInt1);
        ((PicSearchSvr.ReqBody)localObject1).uint32_aio_type.set(paramInt2);
        ((PicSearchSvr.ReqBody)localObject1).uint64_to_uin.set(Long.parseLong(paramString2));
        Object localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(ByteStringMicro.copyFromUtf8(paramString3));
        ((PicSearchSvr.ReqBody)localObject1).bytes_key_word.set((List)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
        {
          ((PicSearchSvr.ReqBody)localObject1).uint32_age.set(this.jdField_a_of_type_ComTencentMobileqqDataCard.age);
          localObject1 = ((PicSearchSvr.ReqBody)localObject1).toByteArray();
          localObject2 = ByteBuffer.allocate(localObject1.length + 4);
          ((ByteBuffer)localObject2).putInt(localObject1.length + 4).put((byte[])localObject1);
          localObject1 = ((ByteBuffer)localObject2).array();
          localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), aemn.class);
          ((NewIntent)localObject2).putExtra("key_body", (byte[])localObject1);
          ((NewIntent)localObject2).putExtra("key_cmd", "PicSearchSvr.PullPics");
          ((NewIntent)localObject2).putExtra("USER_KEYWORD", paramString3);
          if (paramInt1 == 4)
          {
            ((NewIntent)localObject2).putExtra("fromQzone", bool);
            if (QLog.isColorLevel()) {
              QLog.d("StickerRecManager", 2, "send pull pics args:sessionId = " + str + " uin=" + paramString1 + " termType=" + paramInt1 + " aioType : " + paramInt2 + " toUin : " + paramString2 + "  keyword: " + c(paramString3));
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
          }
        }
        else
        {
          ((PicSearchSvr.ReqBody)localObject1).uint32_age.set(0);
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
  
  public void a(Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()) || (this.jdField_a_of_type_JavaUtilHashSet == null)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaUtilHashSet.addAll(paramCollection);
      a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_JavaUtilHashSet);
      return;
    }
    finally {}
  }
  
  public void a(List<StickerRecCacheEntity> paramList)
  {
    if (this.jdField_a_of_type_Atmp == null) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.8(this, paramList));
  }
  
  public void a(List<aemo> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    label22:
    Object localObject2;
    String str1;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    while (localIterator.hasNext())
    {
      localObject2 = (aemo)localIterator.next();
      if (localObject2 != null)
      {
        str1 = ((aemo)localObject2).jdField_a_of_type_JavaLangString;
        localObject1 = ((aemo)localObject2).jdField_a_of_type_JavaUtilList;
        localObject4 = new StringBuilder();
        localObject3 = new StringBuilder();
        paramList = null;
        localObject5 = ((List)localObject1).iterator();
        label92:
        while (((Iterator)localObject5).hasNext())
        {
          localObject1 = (aelm)((Iterator)localObject5).next();
          if (((aelm)localObject1).b() != null)
          {
            String str2 = ((aelm)localObject1).c();
            if (!TextUtils.isEmpty(str2)) {
              ((StringBuilder)localObject4).append(str2);
            }
            ((StringBuilder)localObject4).append(((aelm)localObject1).b());
            ((StringBuilder)localObject4).append(";");
            if (((aelm)localObject1).a() != null)
            {
              ((StringBuilder)localObject3).append(((aelm)localObject1).a());
              ((StringBuilder)localObject3).append(";");
            }
            if (!((aelm)localObject1).b()) {
              break label599;
            }
            paramList = (List<aemo>)localObject1;
          }
        }
      }
    }
    label536:
    label599:
    for (;;)
    {
      break label92;
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = ((StringBuilder)localObject3).toString();
      localObject3 = new aemm();
      ((aemm)localObject3).l = "dc04577";
      ((aemm)localObject3).jdField_b_of_type_JavaLangString = str1;
      ((aemm)localObject3).k = ((aemo)localObject2).jdField_b_of_type_JavaLangString;
      ((aemm)localObject3).jdField_c_of_type_JavaLangString = String.valueOf(AppSetting.a());
      ((aemm)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
      if (paramList != null)
      {
        localObject2 = paramList.b();
        str1 = paramList.c();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str1)) {
          localObject1 = str1 + (String)localObject2;
        }
        ((aemm)localObject3).f = ((String)localObject1);
        ((aemm)localObject3).g = paramList.a();
      }
      ((aemm)localObject3).d = ((String)localObject4);
      ((aemm)localObject3).e = ((String)localObject5);
      if (paramBoolean)
      {
        if (paramInt != 0) {
          break label536;
        }
        ((aemm)localObject3).h = "c2c";
      }
      for (;;)
      {
        ((aemm)localObject3).j = paramString;
        ((aemm)localObject3).i = "android";
        paramList = ((aemm)localObject3).a();
        localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), aemn.class);
        ((NewIntent)localObject1).putExtra("key_cmd", "MQInference.CommonReport");
        ((NewIntent)localObject1).putExtra("key_body", bakc.a(paramList.toString().getBytes()));
        if (QLog.isColorLevel())
        {
          ((aemm)localObject3).jdField_b_of_type_JavaLangString = c(((aemm)localObject3).jdField_b_of_type_JavaLangString);
          QLog.d("StickerRecManager", 2, "report content:" + ((aemm)localObject3).a().toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
        break label22;
        break;
        if (paramInt == 1) {
          ((aemm)localObject3).h = "group";
        } else if (paramInt == 3000) {
          ((aemm)localObject3).h = "discuss";
        } else if (paramInt == 11000) {
          ((aemm)localObject3).h = "qzone";
        } else {
          ((aemm)localObject3).h = "other";
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    baig.u(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramBoolean);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_JavaUtilHashSet == null)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilHashSet.contains(paramString);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt, paramString2, false, true);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    return a(paramString1, paramInt, paramString2, paramBoolean, false);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "can't analyze, has not init");
      }
      return false;
    }
    try
    {
      String str1 = a(paramString1);
      if ((TextUtils.isEmpty(str1)) || (str1.length() > this.jdField_a_of_type_Int))
      {
        if (!QLog.isColorLevel()) {
          break label249;
        }
        QLog.d("StickerRecManager", 2, "userTxt over maxMatchLength or empty");
        break label249;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.contains(str1);
      String str2 = c(str1);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "word : " + str2 + " miss dict");
        }
        if ((!paramBoolean2) || (this.jdField_a_of_type_Aeml == null)) {
          break label251;
        }
        ThreadManager.getSubThreadHandler().post(new StickerRecManager.2(this, paramString1, paramBoolean2));
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "word : " + str2 + " in dict");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.3(this, paramBoolean2, paramString1, str1, paramBoolean1, paramInt, paramString2));
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, befj.a(paramString1));
        }
      }
    }
    return true;
    label249:
    return false;
    label251:
    return false;
  }
  
  public String b(String paramString)
  {
    return axku.a(axku.i(baip.c(paramString)));
  }
  
  public Collection<String> b()
  {
    HashSet localHashSet = new HashSet();
    arnz localarnz = (arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    Object localObject1 = ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        if (("isUpdate".equals(((CustomEmotionData)localObject2).RomaingType)) || ("needDownload".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow_downloaded".equals(((CustomEmotionData)localObject2).RomaingType))) {
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).modifyWord))
          {
            localHashSet.add(b(((CustomEmotionData)localObject2).modifyWord));
          }
          else if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).ocrWord))
          {
            localHashSet.add(b(((CustomEmotionData)localObject2).ocrWord));
          }
          else if (((CustomEmotionData)localObject2).isMarkFace)
          {
            localObject2 = localarnz.a(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((Emoticon)localObject2).name))) {
              localHashSet.add(((Emoticon)localObject2).name);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "loadKeywordForFavEmotion size: " + localHashSet.size());
    }
    return localHashSet;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "unInit executed");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = null;
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentMobileqqDataCard = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = null;
  }
  
  public void b(List<aemo> paramList)
  {
    paramList = new ArrayList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (aemo)paramList.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((aemo)localObject1).jdField_a_of_type_JavaLangString;
        StickerRecommendSortEntity localStickerRecommendSortEntity = (StickerRecommendSortEntity)this.jdField_a_of_type_Atmp.a(StickerRecommendSortEntity.class, "usrMessage=?", new String[] { localObject2 });
        Object localObject3;
        if (localStickerRecommendSortEntity != null)
        {
          localStickerRecommendSortEntity.convertToList();
          localObject1 = ((aemo)localObject1).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aelm)((Iterator)localObject1).next();
            if (!((aelm)localObject2).a())
            {
              localObject2 = (aemc)localObject2;
              localObject3 = Integer.valueOf(((aemc)localObject2).d());
              if (((aemc)localObject2).b())
              {
                if (localStickerRecommendSortEntity.clickedList.contains(localObject3)) {
                  localStickerRecommendSortEntity.removeClicked((Integer)localObject3);
                }
                localStickerRecommendSortEntity.addClicked((Integer)localObject3);
              }
              for (;;)
              {
                localStickerRecommendSortEntity.removeNoExpose((Integer)localObject3);
                break;
                if (!localStickerRecommendSortEntity.exposedList.contains(localObject3)) {
                  localStickerRecommendSortEntity.addExposed((Integer)localObject3);
                }
              }
            }
          }
          localStickerRecommendSortEntity.exposedList.removeAll(localStickerRecommendSortEntity.clickedList);
          if ((localStickerRecommendSortEntity.noExposeList != null) && (localStickerRecommendSortEntity.noExposeList.size() == 0))
          {
            localObject1 = localStickerRecommendSortEntity.noExposeList;
            localStickerRecommendSortEntity.noExposeList = localStickerRecommendSortEntity.exposedList;
            localStickerRecommendSortEntity.exposedList = ((List)localObject1);
          }
          localStickerRecommendSortEntity.convertToString();
          if (QLog.isColorLevel()) {
            QLog.i("StickerRecManager", 2, "updateSort clicked=" + localStickerRecommendSortEntity.clicked + " exposed=" + localStickerRecommendSortEntity.exposed + " noExpose=" + localStickerRecommendSortEntity.noExpose);
          }
          this.jdField_a_of_type_Atmp.a(localStickerRecommendSortEntity);
        }
        else
        {
          localStickerRecommendSortEntity = new StickerRecommendSortEntity((String)localObject2);
          localObject2 = ((aemo)localObject1).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (aelm)((Iterator)localObject2).next();
            if (!((aelm)localObject3).a())
            {
              localObject3 = (aemc)localObject3;
              if (((aemc)localObject3).b()) {
                localStickerRecommendSortEntity.addClicked(Integer.valueOf(((aemc)localObject3).d()));
              } else {
                localStickerRecommendSortEntity.addExposed(Integer.valueOf(((aemc)localObject3).d()));
              }
            }
          }
          localObject1 = ((aemo)localObject1).jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aelm)((Iterator)localObject1).next();
            if (!((aelm)localObject2).a()) {
              localStickerRecommendSortEntity.addNoExpose(Integer.valueOf(((aemc)localObject2).d()));
            }
          }
          if ((localStickerRecommendSortEntity.noExposeList != null) && (localStickerRecommendSortEntity.noExposeList.size() == 0))
          {
            localObject1 = localStickerRecommendSortEntity.noExposeList;
            localStickerRecommendSortEntity.noExposeList = localStickerRecommendSortEntity.exposedList;
            localStickerRecommendSortEntity.exposedList = ((List)localObject1);
          }
          localStickerRecommendSortEntity.convertToString();
          if (QLog.isColorLevel()) {
            QLog.i("StickerRecManager", 2, "updateSort new SortEntity clicked=" + localStickerRecommendSortEntity.clicked + " exposed=" + localStickerRecommendSortEntity.exposed + " noExpose=" + localStickerRecommendSortEntity.noExpose);
          }
          this.jdField_a_of_type_Atmp.b(localStickerRecommendSortEntity);
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false)) {
      return;
    }
    d();
    ThreadManager.excute(new StickerRecManager.4(this), 128, null, true);
  }
  
  public void d()
  {
    File localFile = new File(b(), "words");
    this.d = new File(b(), "words.zip");
    this.jdField_a_of_type_JavaIoFile = new File(localFile, "words.json");
    this.c = new File(localFile, "encodedBloom.bin");
    this.jdField_b_of_type_JavaIoFile = new File(localFile, "local_words.bin");
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Atmp == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "clearOverdueStickerCache");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.9(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aely == null) {
      return;
    }
    this.jdField_a_of_type_Aely.a();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Aemf == null) {
      return;
    }
    this.jdField_a_of_type_Aemf.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemi
 * JD-Core Version:    0.7.0.1
 */
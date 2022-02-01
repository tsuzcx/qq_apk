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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.10;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.2;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.3;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.4;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.5;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.6;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.7;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.9;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
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
import java.util.List<Laitp;>;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aiti
  implements Manager
{
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static Integer jdField_a_of_type_JavaLangInteger;
  private int jdField_a_of_type_Int = 6;
  private aisy jdField_a_of_type_Aisy;
  private aitf jdField_a_of_type_Aitf;
  private aitl jdField_a_of_type_Aitl;
  private axfj jdField_a_of_type_Axfj;
  private BloomFilter jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private File jdField_a_of_type_JavaIoFile;
  private volatile String jdField_a_of_type_JavaLangString = "";
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  public List<aism> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getFileThreadHandler();
  private volatile boolean jdField_a_of_type_Boolean;
  private final aitl jdField_b_of_type_Aitl = new aitj(this);
  private File jdField_b_of_type_JavaIoFile;
  private List<aisn> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = true;
  private File c;
  private File d;
  
  public aiti(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_Axfj = ((axfj)paramQQAppInterface.getManager(14));
    a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    d();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    a(new aith(paramQQAppInterface));
    this.jdField_a_of_type_Aisy = new aisy(paramQQAppInterface);
    a(this.jdField_a_of_type_Aisy);
    this.jdField_a_of_type_Aitf = new aitf(paramQQAppInterface);
    a(this.jdField_a_of_type_Aitf);
    a(new aity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
  
  public static aiti a(QQAppInterface paramQQAppInterface)
  {
    return (aiti)paramQQAppInterface.getManager(314);
  }
  
  private PicSearchSvr.ReqBody a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, List<String> paramList)
  {
    PicSearchSvr.ReqBody localReqBody;
    try
    {
      localReqBody = new PicSearchSvr.ReqBody();
      localReqBody.setHasFlag(true);
      localReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(paramString1));
      localReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
      localReqBody.uint32_src_term.set(paramInt1);
      localReqBody.uint32_aio_type.set(paramInt2);
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString3));
      if (paramList != null)
      {
        paramString1 = new ArrayList();
        paramString2 = paramList.iterator();
        while (paramString2.hasNext()) {
          paramString1.add(ByteStringMicro.copyFromUtf8((String)paramString2.next()));
        }
        localReqBody.bytes_key_word.set(paramString1);
      }
    }
    finally {}
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      localReqBody.uint32_age.set(this.jdField_a_of_type_ComTencentMobileqqDataCard.age);
    }
    for (;;)
    {
      return localReqBody;
      localReqBody.uint32_age.set(0);
    }
  }
  
  public static File a(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = new File(aitb.jdField_a_of_type_JavaLangString + paramString);
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
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 6
    //   12: astore_3
    //   13: aload_3
    //   14: areturn
    //   15: new 310	java/io/ObjectInputStream
    //   18: dup
    //   19: new 312	java/io/BufferedInputStream
    //   22: dup
    //   23: new 314	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 315	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 318	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 319	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokevirtual 322	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   47: astore 5
    //   49: aload 5
    //   51: astore_1
    //   52: aload_1
    //   53: astore_3
    //   54: aload 4
    //   56: ifnull -43 -> 13
    //   59: aload 4
    //   61: invokevirtual 325	java/io/ObjectInputStream:close	()V
    //   64: aload_1
    //   65: areturn
    //   66: astore_3
    //   67: aload_1
    //   68: areturn
    //   69: astore 5
    //   71: aconst_null
    //   72: astore 4
    //   74: aload 4
    //   76: astore_3
    //   77: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +47 -> 127
    //   83: aload 4
    //   85: astore_3
    //   86: ldc_w 332
    //   89: iconst_2
    //   90: new 144	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 334
    //   100: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 336
    //   110: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 5
    //   115: invokevirtual 337	java/lang/Exception:toString	()Ljava/lang/String;
    //   118: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload 4
    //   129: astore_3
    //   130: aload 5
    //   132: instanceof 343
    //   135: istore_2
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 325	java/io/ObjectInputStream:close	()V
    //   146: aload 6
    //   148: astore_3
    //   149: iload_2
    //   150: ifeq -137 -> 13
    //   153: aload_1
    //   154: invokestatic 348	bhmi:d	(Ljava/lang/String;)Z
    //   157: pop
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore 4
    //   164: aload 4
    //   166: astore_3
    //   167: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +16 -> 186
    //   173: aload 4
    //   175: astore_3
    //   176: ldc_w 332
    //   179: iconst_2
    //   180: ldc_w 350
    //   183: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload 6
    //   188: astore_3
    //   189: aload 4
    //   191: ifnull -178 -> 13
    //   194: aload 4
    //   196: invokevirtual 325	java/io/ObjectInputStream:close	()V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_1
    //   202: aconst_null
    //   203: areturn
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_3
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 325	java/io/ObjectInputStream:close	()V
    //   215: aload_1
    //   216: athrow
    //   217: astore_3
    //   218: goto -72 -> 146
    //   221: astore_3
    //   222: goto -7 -> 215
    //   225: astore_1
    //   226: goto -19 -> 207
    //   229: astore_1
    //   230: goto -66 -> 164
    //   233: astore 5
    //   235: goto -161 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	aiti
    //   0	238	1	paramString	String
    //   135	15	2	bool	boolean
    //   12	42	3	localObject1	Object
    //   66	1	3	localIOException1	java.io.IOException
    //   76	136	3	localObject2	Object
    //   217	1	3	localIOException2	java.io.IOException
    //   221	1	3	localIOException3	java.io.IOException
    //   37	158	4	localObjectInputStream	java.io.ObjectInputStream
    //   47	3	5	localObject3	Object
    //   69	62	5	localException1	Exception
    //   233	1	5	localException2	Exception
    //   1	186	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   59	64	66	java/io/IOException
    //   15	39	69	java/lang/Exception
    //   15	39	160	java/lang/OutOfMemoryError
    //   194	199	201	java/io/IOException
    //   15	39	204	finally
    //   141	146	217	java/io/IOException
    //   211	215	221	java/io/IOException
    //   42	49	225	finally
    //   77	83	225	finally
    //   86	127	225	finally
    //   130	136	225	finally
    //   167	173	225	finally
    //   176	186	225	finally
    //   42	49	229	java/lang/OutOfMemoryError
    //   42	49	233	java/lang/Exception
  }
  
  private List<aism> a(List<aism> paramList, StickerRecommendSortEntity paramStickerRecommendSortEntity)
  {
    int i2 = 0;
    int j;
    int m;
    label105:
    int k;
    label123:
    int i;
    int n;
    label205:
    int i1;
    if (paramStickerRecommendSortEntity != null)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort clicked=" + paramStickerRecommendSortEntity.clicked + " exposed=" + paramStickerRecommendSortEntity.exposed + " noExpose=" + paramStickerRecommendSortEntity.noExpose);
        }
        if (paramStickerRecommendSortEntity.clickedList == null) {
          break label441;
        }
        j = paramStickerRecommendSortEntity.clickedList.size();
        if (paramStickerRecommendSortEntity.noExposeList == null) {
          break label435;
        }
        m = paramStickerRecommendSortEntity.noExposeList.size();
        if (paramStickerRecommendSortEntity.exposedList == null) {
          break label429;
        }
        k = paramStickerRecommendSortEntity.exposedList.size();
        i3 = paramList.size();
        i = j + m + k;
        if (i3 != i)
        {
          if (!QLog.isColorLevel()) {
            break label447;
          }
          QLog.i("StickerRecManager", 2, "sort data:length is not equals. size=" + i3 + " sortSize=" + i);
          break label447;
        }
        arrayOfaism = new aism[i3];
        n = 0;
        i = 0;
        if (n >= j) {
          break label458;
        }
        i1 = ((Integer)paramStickerRecommendSortEntity.clickedList.get(n)).intValue();
        if ((i1 >= i3) || (i >= i3)) {
          break label426;
        }
        arrayOfaism[i] = ((aism)paramList.get(i1));
        i += 1;
      }
      catch (Throwable paramList)
      {
        int i3;
        aism[] arrayOfaism;
        label266:
        QLog.e("StickerRecManager", 1, "sortData:", paramList);
      }
      j = i;
      i1 = i2;
      if (n < m)
      {
        j = ((Integer)paramStickerRecommendSortEntity.noExposeList.get(n)).intValue();
        if ((j >= i3) || (i >= i3)) {
          break label423;
        }
        arrayOfaism[i] = ((aism)paramList.get(j));
        i += 1;
        break label464;
      }
    }
    for (;;)
    {
      if (i1 < k)
      {
        i = ((Integer)paramStickerRecommendSortEntity.exposedList.get(i1)).intValue();
        if ((i < i3) && (j < i3))
        {
          arrayOfaism[j] = ((aism)paramList.get(i));
          i = j + 1;
          break label473;
        }
      }
      else
      {
        paramList = Arrays.asList(arrayOfaism);
        return paramList;
        return null;
      }
      i = j;
      break label473;
      label423:
      break label464;
      label426:
      break label449;
      label429:
      k = 0;
      break label123;
      label435:
      m = 0;
      break label105;
      label441:
      j = 0;
      break;
      label447:
      return null;
      label449:
      n += 1;
      break label205;
      label458:
      n = 0;
      break label266;
      label464:
      n += 1;
      break label266;
      label473:
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
      bhmi.a(paramFile1, paramFile2);
      paramFile1.delete();
    }
  }
  
  /* Error */
  private void a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 474	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 476	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 478	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 479	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 482	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 483	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 4
    //   37: aload_2
    //   38: invokevirtual 487	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokevirtual 490	java/io/ObjectOutputStream:flush	()V
    //   49: aload 4
    //   51: ifnull -44 -> 7
    //   54: aload 4
    //   56: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   59: return
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 492	java/io/IOException:printStackTrace	()V
    //   65: return
    //   66: astore 5
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +46 -> 121
    //   78: aload_2
    //   79: astore_3
    //   80: ldc_w 332
    //   83: iconst_2
    //   84: new 144	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 494
    //   94: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 336
    //   104: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: invokevirtual 337	java/lang/Exception:toString	()Ljava/lang/String;
    //   112: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_2
    //   122: ifnull -115 -> 7
    //   125: aload_2
    //   126: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   129: return
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 492	java/io/IOException:printStackTrace	()V
    //   135: return
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   147: aload_1
    //   148: athrow
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 492	java/io/IOException:printStackTrace	()V
    //   154: goto -7 -> 147
    //   157: astore_1
    //   158: goto -19 -> 139
    //   161: astore 5
    //   163: aload 4
    //   165: astore_2
    //   166: goto -96 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	aiti
    //   0	169	1	paramString	String
    //   0	169	2	paramObject	Object
    //   34	110	3	localObject	Object
    //   30	134	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   66	42	5	localException1	Exception
    //   161	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   54	59	60	java/io/IOException
    //   8	32	66	java/lang/Exception
    //   125	129	130	java/io/IOException
    //   8	32	136	finally
    //   143	147	149	java/io/IOException
    //   35	41	157	finally
    //   44	49	157	finally
    //   72	78	157	finally
    //   80	121	157	finally
    //   35	41	161	java/lang/Exception
    //   44	49	161	java/lang/Exception
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
        localObject = new beum();
        ((beum)localObject).jdField_a_of_type_Beuq = new aitk(this, paramString2, bool, paramString3);
        ((beum)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((beum)localObject).jdField_a_of_type_Int = 0;
        ((beum)localObject).c = this.d.getAbsolutePath();
        ((beum)localObject).b = bhnv.a(bevn.a().a());
        try
        {
          paramString2 = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramString2)) {
            break;
          }
          ((QQAppInterface)paramString2).getNetEngine(0).a((bevl)localObject);
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
      bdmc.a(BaseApplication.getContext()).a(null, "StickerRecInitCost", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aisn)localIterator.next();
        if (((aisn)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
        {
          localObject = ((aisn)localObject).a(paramString, paramSessionInfo);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            localArrayList.addAll((Collection)localObject);
          }
        }
      }
      paramString = aiso.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if ((paramString != null) && (!paramString.isEmpty())) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramString);
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((aism)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
        i += 1;
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
        localObject = bhsi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "words_version_key805_gray_one", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
        QLog.d("StickerRecManager", 2, blhk.a(paramArrayOfByte));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "not need pull words: localVersion=" + (String)localObject + " server version=" + paramArrayOfByte);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "cache pics in DB");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
    {
      StickerRecommendEntity localStickerRecommendEntity = new StickerRecommendEntity();
      localStickerRecommendEntity.usrMessage = paramString;
      localStickerRecommendEntity.recList = Base64.encodeToString(paramArrayOfByte, 0);
      localStickerRecommendEntity.cachedTime = System.currentTimeMillis();
      localStickerRecommendEntity.recommendType = paramInt;
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.6(this, localStickerRecommendEntity));
    }
  }
  
  private void a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean, StickerRecommendSortEntity paramStickerRecommendSortEntity, int paramInt)
  {
    PicSearchSvr.RspBody localRspBody;
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "handlePullPics from : " + paramString2 + " | RecType=" + paramInt);
      }
      localRspBody = new PicSearchSvr.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.int32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          break label722;
        }
        QLog.d("StickerRecManager", 2, "handleResponse response code error,result:" + localRspBody.int32_result.get() + " message : " + localRspBody.bytes_fail_msg.get());
        return;
      }
      localObject = localRspBody.rpt_msg_img_info.get();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label230;
      }
      if ("network".equals(paramString2)) {
        i();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.7(this, paramInt, paramString1));
      }
      if (!QLog.isColorLevel()) {
        break label722;
      }
      QLog.d("StickerRecManager", 2, "handleResponse imgInfos is null or empty");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (!QLog.isColorLevel()) {
        break label722;
      }
    }
    QLog.d("StickerRecManager", 2, blhk.a(paramArrayOfByte));
    return;
    label230:
    paramArrayOfByte = new ArrayList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      PicSearchSvr.ImgInfo localImgInfo = (PicSearchSvr.ImgInfo)((List)localObject).get(i);
      aitc localaitc = new aitc();
      localaitc.f(i);
      localaitc.a(localImgInfo.uint64_img_size.get());
      localaitc.a(localImgInfo.uint32_img_width.get());
      localaitc.b(localImgInfo.uint32_img_height.get());
      localaitc.d(localImgInfo.bytes_img_md5.get().toStringUtf8());
      localaitc.b(localImgInfo.bytes_img_down_url.get().toStringUtf8());
      localaitc.b(localImgInfo.uint64_thumb_size.get());
      localaitc.d(localImgInfo.uint32_thumb_img_height.get());
      localaitc.c(localImgInfo.uint32_thumb_img_width.get());
      localaitc.c(localImgInfo.bytes_thumb_down_url.get().toStringUtf8());
      localaitc.e(localImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
      localaitc.g(localImgInfo.uint32_src_type.get());
      localaitc.f(localImgInfo.bytes_src_desc.get().toStringUtf8());
      localaitc.g(localImgInfo.bytes_web_url.get().toStringUtf8());
      localaitc.h("");
      localaitc.i(localImgInfo.bytes_pack_name.get().toStringUtf8());
      localaitc.h(localImgInfo.uint32_pack_id.get());
      localaitc.e(paramInt);
      paramArrayOfByte.add(localaitc);
      i += 1;
    }
    paramStickerRecommendSortEntity = a(paramArrayOfByte, paramStickerRecommendSortEntity);
    if (paramStickerRecommendSortEntity != null)
    {
      paramArrayOfByte = paramStickerRecommendSortEntity;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramArrayOfByte = new ArrayList(paramArrayOfByte);
        paramArrayOfByte.addAll(0, this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_JavaUtilList.clear();
        label597:
        if (!"network".equals(paramString2)) {
          break label723;
        }
      }
    }
    label722:
    label723:
    for (paramString2 = localRspBody.bytes_rsp_other.get().toStringUtf8();; paramString2 = "999")
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Aitl.a(paramArrayOfByte, paramString1, paramString2, 0, null);
        return;
      }
      if (this.jdField_a_of_type_Aitl != null)
      {
        localRspBody = null;
        paramStickerRecommendSortEntity = localRspBody;
        if (paramInt == 1)
        {
          paramStickerRecommendSortEntity = localRspBody;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localObject = ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString1);
            paramStickerRecommendSortEntity = localRspBody;
            if (localObject != null) {
              paramStickerRecommendSortEntity = ((aiub)localObject).b();
            }
          }
        }
        this.jdField_a_of_type_Aitl.a(paramArrayOfByte, paramString1, paramString2, paramInt, paramStickerRecommendSortEntity);
        return;
        break label597;
        break;
      }
      return;
    }
  }
  
  public static boolean a(aism paramaism)
  {
    return paramaism.a();
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
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isStickerPics()) || (paramMessageForPic.picExtraData.isStickerAdPic()));
  }
  
  private boolean a(File paramFile1, File paramFile2)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(paramFile2.getParent() + File.separator + "temp");
      nof.a(paramFile1, localFile.getAbsolutePath() + File.separator);
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
        paramFile = bhmi.c(paramFile.getPath());
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramFile))) {
          break label72;
        }
        return bool;
      }
      catch (UnsatisfiedLinkError paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("StickerRecManager", 1, "calculate follow capture template zip md5 error", paramFile);
      return false;
      label72:
      bool = false;
    }
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir().getAbsolutePath() + File.separator + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + File.separator + "qstorage" + File.separator + "objs" + File.separator + "sticker_recommend";
  }
  
  public static boolean b(aism paramaism)
  {
    return !a(paramaism);
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
      paramString = aitb.jdField_a_of_type_JavaLangString + paramString;
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
    Object localObject = new File(aitb.jdField_a_of_type_JavaLangString);
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
    bdmc.a(BaseApplication.getContext()).a(null, "StickerRecEmptyImg", false, 0L, 0L, null, "");
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
    return behh.i(bhsr.c(behh.a(paramString)).toLowerCase());
  }
  
  public Collection<String> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = ((asgf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
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
        if (bhmi.a(this.c.getAbsolutePath())) {
          break label119;
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
      QLog.d("StickerRecManager", 2, blhk.a(localException1));
      QLog.d("StickerRecManager", 2, "StickerRecManager error init time cost : " + (SystemClock.elapsedRealtime() - l1));
    }
    a(false, SystemClock.elapsedRealtime() - l1);
    return;
    label119:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = ((BloomFilter)a(this.c.getAbsolutePath()));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter == null) {
      throw new IllegalStateException("words file read error");
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "init bloomFilter, version : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.version);
    }
    l2 = bhsi.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if ((!bhmi.a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath())) || ((l2 != 0L) && (System.currentTimeMillis() - l2 >= 86400000L)))
    {
      bhsi.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0L);
      localObject1 = new HashSet();
      localObject2 = this.jdField_a_of_type_Axfj.b();
      localList = this.jdField_a_of_type_Axfj.jdField_a_of_type_JavaUtilList;
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
        auog.c(this.jdField_b_of_type_JavaIoFile.getAbsolutePath());
        a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath(), localObject1);
      }
      this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    }
    for (;;)
    {
      g();
      h();
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 6);
      localObject1 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataCard = ((anyw)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
        auog.c(this.jdField_b_of_type_JavaIoFile.getAbsolutePath());
      }
    }
  }
  
  public void a(aisn paramaisn)
  {
    if (paramaisn == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
    } while (this.jdField_b_of_type_JavaUtilList.contains(paramaisn));
    this.jdField_b_of_type_JavaUtilList.add(paramaisn);
  }
  
  public void a(aitl paramaitl)
  {
    this.jdField_a_of_type_Aitl = paramaitl;
  }
  
  protected void a(Context paramContext, String paramString)
  {
    try
    {
      this.jdField_b_of_type_Boolean = bhsi.C(paramContext, paramString);
      return;
    }
    catch (NullPointerException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    label238:
    for (;;)
    {
      return;
      Object localObject;
      String str;
      try
      {
        if (paramFromServiceMsg.getResultCode() != 1000) {
          break label238;
        }
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        bhvd.a((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
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
            break label123;
          }
          a(paramFromServiceMsg);
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StickerRecManager", 2, blhk.a(paramIntent));
        continue;
      }
      finally {}
      label123:
      if ("PicSearchSvr.PullPics".equals(localObject))
      {
        a(paramFromServiceMsg, str, 0);
        a(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 0);
      }
      else if ("BreakIceSvr.Pull".equals(localObject))
      {
        ((bbcd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285)).a(paramFromServiceMsg);
      }
      else if ("SceneFaceRec.PullFaces".equals(localObject))
      {
        a(paramFromServiceMsg, str, 1);
        a(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 1);
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
    //   3: getfield 65	aiti:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 1206	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody
    //   19: dup
    //   20: invokespecial 1207	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: iconst_1
    //   28: invokevirtual 1208	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:setHasFlag	(Z)V
    //   31: new 144	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 1211	android/os/SystemClock:uptimeMillis	()J
    //   45: invokevirtual 585	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 6
    //   53: invokestatic 1214	com/tencent/common/config/AppSetting:a	()I
    //   56: invokestatic 1216	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   59: astore 7
    //   61: aload_0
    //   62: getfield 65	aiti:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 90	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   68: invokestatic 1221	arta:a	(Landroid/content/Context;)Ljava/lang/String;
    //   71: astore 8
    //   73: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +83 -> 159
    //   79: ldc_w 332
    //   82: iconst_2
    //   83: new 144	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 1223
    //   93: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 6
    //   98: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 1225
    //   104: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 1227
    //   114: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload_2
    //   118: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc_w 1229
    //   124: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 7
    //   129: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 1231
    //   135: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 8
    //   140: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 1233
    //   146: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload_3
    //   150: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 5
    //   161: getfield 1234	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_session_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   164: aload 6
    //   166: invokestatic 193	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   169: invokevirtual 199	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   172: aload 5
    //   174: getfield 1235	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   177: aload_1
    //   178: invokestatic 209	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   181: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   184: aload 5
    //   186: getfield 1236	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_src_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: iload_2
    //   190: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   193: aload 5
    //   195: getfield 1239	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: aload 7
    //   200: invokestatic 193	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   203: invokevirtual 199	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   206: aload 5
    //   208: getfield 1242	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_version	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: aload 8
    //   213: invokestatic 193	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   216: invokevirtual 199	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   219: aload 5
    //   221: getfield 1245	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uin32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   224: iload_3
    //   225: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   228: aload 5
    //   230: getfield 1246	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   233: iload 4
    //   235: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   238: aload 5
    //   240: invokevirtual 1249	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:toByteArray	()[B
    //   243: astore_1
    //   244: aload_1
    //   245: arraylength
    //   246: iconst_4
    //   247: iadd
    //   248: invokestatic 1255	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   251: astore 5
    //   253: aload 5
    //   255: aload_1
    //   256: arraylength
    //   257: iconst_4
    //   258: iadd
    //   259: invokevirtual 1257	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   262: aload_1
    //   263: invokevirtual 1260	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   266: pop
    //   267: aload 5
    //   269: invokevirtual 1263	java/nio/ByteBuffer:array	()[B
    //   272: astore_1
    //   273: new 1265	mqq/app/NewIntent
    //   276: dup
    //   277: aload_0
    //   278: getfield 65	aiti:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   281: invokevirtual 90	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: ldc_w 1267
    //   287: invokespecial 1270	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   290: astore 5
    //   292: aload 5
    //   294: ldc_w 1272
    //   297: aload_1
    //   298: invokevirtual 1276	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   301: pop
    //   302: aload 5
    //   304: ldc_w 1278
    //   307: ldc_w 1179
    //   310: invokevirtual 1281	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   313: pop
    //   314: aload_0
    //   315: getfield 65	aiti:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: aload 5
    //   320: invokevirtual 1285	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   323: goto -310 -> 13
    //   326: astore_1
    //   327: aload_0
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	aiti
    //   0	331	1	paramString	String
    //   0	331	2	paramInt1	int
    //   0	331	3	paramInt2	int
    //   0	331	4	paramInt3	int
    //   6	313	5	localObject	Object
    //   51	114	6	str1	String
    //   59	140	7	str2	String
    //   71	141	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   2	8	326	finally
    //   16	159	326	finally
    //   159	323	326	finally
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, aiub paramaiub)
  {
    if (paramaiub != null) {}
    for (;;)
    {
      try
      {
        String str = paramaiub.a();
        if (str == null) {
          return;
        }
        str = paramString1 + SystemClock.uptimeMillis();
        Object localObject1 = a(str, paramString1, paramInt1, paramInt2, paramString2, paramaiub.a()).toByteArray();
        Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
        ((ByteBuffer)localObject2).putInt(localObject1.length + 4).put((byte[])localObject1);
        localObject2 = ((ByteBuffer)localObject2).array();
        localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), aito.class);
        ((NewIntent)localObject1).putExtra("key_body", (byte[])localObject2);
        ((NewIntent)localObject1).putExtra("key_cmd", "SceneFaceRec.PullFaces");
        paramaiub = paramaiub.a();
        ((NewIntent)localObject1).putExtra("REQUEST_SCENES_ID", paramaiub);
        ((NewIntent)localObject1).putExtra("USER_KEYWORD", paramaiub);
        boolean bool;
        if (paramInt1 == 4)
        {
          bool = true;
          ((NewIntent)localObject1).putExtra("fromQzone", bool);
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "send pull pics args:sessionId = " + str + " uin=" + paramString1 + " termType=" + paramInt1 + " aioType : " + paramInt2 + " toUin : " + paramString2 + "  scenesID: " + paramaiub);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 144	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 1211	android/os/SystemClock:uptimeMillis	()J
    //   16: invokevirtual 585	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 7
    //   24: aload_0
    //   25: aload 7
    //   27: aload_1
    //   28: iload_2
    //   29: iload_3
    //   30: aload 4
    //   32: aload 5
    //   34: invokespecial 1291	aiti:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)Lcom/tencent/pb/emosm/PicSearchSvr$ReqBody;
    //   37: invokevirtual 1292	com/tencent/pb/emosm/PicSearchSvr$ReqBody:toByteArray	()[B
    //   40: astore 8
    //   42: aload 8
    //   44: arraylength
    //   45: iconst_4
    //   46: iadd
    //   47: invokestatic 1255	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   50: astore 9
    //   52: aload 9
    //   54: aload 8
    //   56: arraylength
    //   57: iconst_4
    //   58: iadd
    //   59: invokevirtual 1257	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   62: aload 8
    //   64: invokevirtual 1260	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   67: pop
    //   68: aload 9
    //   70: invokevirtual 1263	java/nio/ByteBuffer:array	()[B
    //   73: astore 9
    //   75: new 1265	mqq/app/NewIntent
    //   78: dup
    //   79: aload_0
    //   80: getfield 65	aiti:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   83: invokevirtual 90	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   86: ldc_w 1267
    //   89: invokespecial 1270	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   92: astore 8
    //   94: aload 8
    //   96: ldc_w 1272
    //   99: aload 9
    //   101: invokevirtual 1276	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   104: pop
    //   105: aload 8
    //   107: ldc_w 1278
    //   110: ldc_w 1183
    //   113: invokevirtual 1281	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   116: pop
    //   117: aload 5
    //   119: iconst_0
    //   120: invokeinterface 396 2 0
    //   125: checkcast 248	java/lang/String
    //   128: astore 5
    //   130: aload 8
    //   132: ldc_w 1172
    //   135: aload 5
    //   137: invokevirtual 1281	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   140: pop
    //   141: iload_2
    //   142: iconst_4
    //   143: if_icmpne +118 -> 261
    //   146: iconst_1
    //   147: istore 6
    //   149: aload 8
    //   151: ldc_w 1187
    //   154: iload 6
    //   156: invokevirtual 1297	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   159: pop
    //   160: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +86 -> 249
    //   166: ldc_w 332
    //   169: iconst_2
    //   170: new 144	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 1299
    //   180: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 7
    //   185: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 1225
    //   191: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 1227
    //   201: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload_2
    //   205: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 1301
    //   211: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_3
    //   215: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc_w 1303
    //   221: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 4
    //   226: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 1308
    //   232: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 5
    //   237: invokestatic 1309	aiti:c	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: getfield 65	aiti:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   253: aload 8
    //   255: invokevirtual 1285	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   258: aload_0
    //   259: monitorexit
    //   260: return
    //   261: iconst_0
    //   262: istore 6
    //   264: goto -115 -> 149
    //   267: astore_1
    //   268: aload_0
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	aiti
    //   0	272	1	paramString1	String
    //   0	272	2	paramInt1	int
    //   0	272	3	paramInt2	int
    //   0	272	4	paramString2	String
    //   0	272	5	paramList	List<String>
    //   147	116	6	bool	boolean
    //   22	162	7	str	String
    //   40	214	8	localObject1	Object
    //   50	50	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	141	267	finally
    //   149	249	267	finally
    //   249	258	267	finally
  }
  
  public void a(String paramString, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    paramString = b(paramString);
    a(paramBoolean, paramString, paramSessionInfo);
    if ((this.jdField_a_of_type_Aitl != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_Aitl.a(this.jdField_a_of_type_JavaUtilList, paramString, "999", 0, null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.9(this, paramList));
  }
  
  public void a(List<aitp> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    label22:
    Object localObject3;
    String str1;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    Object localObject5;
    while (localIterator.hasNext())
    {
      localObject3 = (aitp)localIterator.next();
      if (localObject3 != null)
      {
        str1 = ((aitp)localObject3).jdField_a_of_type_JavaLangString;
        paramList = ((aitp)localObject3).jdField_a_of_type_JavaUtilList;
        localObject4 = new StringBuilder();
        localObject2 = new StringBuilder();
        localObject1 = null;
        localObject5 = paramList.iterator();
        label91:
        while (((Iterator)localObject5).hasNext())
        {
          paramList = (aism)((Iterator)localObject5).next();
          if (paramList.c() != null)
          {
            String str2 = paramList.d();
            if (!TextUtils.isEmpty(str2)) {
              ((StringBuilder)localObject4).append(str2);
            }
            ((StringBuilder)localObject4).append(paramList.c());
            ((StringBuilder)localObject4).append(";");
            if (paramList.a() != null)
            {
              ((StringBuilder)localObject2).append(paramList.a());
              ((StringBuilder)localObject2).append(";");
            }
            if (!paramList.b()) {
              break label653;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramList;
      break label91;
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = ((StringBuilder)localObject2).toString();
      paramList = "";
      label240:
      long l;
      if (paramBoolean)
      {
        if (paramInt == 0) {
          paramList = "c2c";
        }
      }
      else
      {
        l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
        if (((aitp)localObject3).jdField_a_of_type_Int != 1) {
          break label581;
        }
        localObject2 = new aiua();
        ((aiua)localObject2).l = "dc05550";
        ((aiua)localObject2).c = str1;
        ((aiua)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l);
        ((aiua)localObject2).jdField_b_of_type_JavaLangString = paramString;
        ((aiua)localObject2).d = paramList;
      }
      for (paramList = (List<aitp>)localObject2;; paramList = (List<aitp>)localObject2)
      {
        paramList.k = ((aitp)localObject3).jdField_b_of_type_JavaLangString;
        paramList.e = String.valueOf(AppSetting.a());
        if (localObject1 != null)
        {
          localObject3 = ((aism)localObject1).c();
          str1 = ((aism)localObject1).d();
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str1)) {
            localObject2 = str1 + (String)localObject3;
          }
          paramList.h = ((String)localObject2);
          paramList.i = ((aism)localObject1).a();
        }
        paramList.f = ((String)localObject4);
        paramList.g = ((String)localObject5);
        paramList.j = "android";
        localObject1 = paramList.a();
        localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), aito.class);
        ((NewIntent)localObject2).putExtra("key_cmd", "MQInference.CommonReport");
        ((NewIntent)localObject2).putExtra("key_body", bhuf.a(((JSONObject)localObject1).toString().getBytes()));
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "report StickerRecReport content:" + paramList.a().toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
        break label22;
        break;
        if (paramInt == 1)
        {
          paramList = "group";
          break label240;
        }
        if (paramInt == 3000)
        {
          paramList = "discuss";
          break label240;
        }
        if (paramInt == 11000)
        {
          paramList = "qzone";
          break label240;
        }
        paramList = "other";
        break label240;
        label581:
        localObject2 = new aitm();
        ((aitm)localObject2).l = "dc04577";
        ((aitm)localObject2).jdField_b_of_type_JavaLangString = str1;
        if (QLog.isColorLevel()) {
          ((aitm)localObject2).jdField_b_of_type_JavaLangString = c(((aitm)localObject2).jdField_b_of_type_JavaLangString);
        }
        ((aitm)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l);
        ((aitm)localObject2).d = paramString;
        ((aitm)localObject2).c = paramList;
      }
      label653:
      paramList = (List<aitp>)localObject1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    bhsi.u(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramBoolean);
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
  
  public boolean a(aiub paramaiub, int paramInt, String paramString)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "can't analyze, has not init");
      }
    }
    for (;;)
    {
      return false;
      if (paramaiub != null) {}
      try
      {
        if ((paramaiub.a() == null) || (bhsr.a(paramaiub.a())))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StickerRecManager", 2, "analyzeForScenesMode data is empty");
          return false;
        }
      }
      catch (Exception paramaiub)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, blhk.a(paramaiub));
        }
      }
    }
    for (;;)
    {
      return true;
      String str = paramaiub.a();
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.4(this, str, paramInt, paramString, paramaiub));
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
    return a(paramString1, paramInt, paramString2, true, false, null);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2, SessionInfo paramSessionInfo)
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
          break label258;
        }
        QLog.d("StickerRecManager", 2, "userTxt over maxMatchLength or empty");
        break label258;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.contains(str1);
      String str2 = c(str1);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "word : " + str2 + " miss dict");
        }
        if ((!paramBoolean2) || (this.jdField_a_of_type_Aitl == null)) {
          break label260;
        }
        ThreadManager.getSubThreadHandler().post(new StickerRecManager.2(this, paramString1, paramBoolean2, paramSessionInfo));
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "word : " + str2 + " in dict");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.3(this, paramString1, paramBoolean2, paramSessionInfo, str1, paramBoolean1, paramInt, paramString2));
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, blhk.a(paramString1));
        }
      }
    }
    return true;
    label258:
    return false;
    label260:
    return false;
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    if (paramSessionInfo != null) {
      bool = a(paramString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, false, true, paramSessionInfo);
    }
    return bool;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return behh.i(bhsr.c(behh.a(paramString)));
  }
  
  public Collection<String> b()
  {
    HashSet localHashSet = new HashSet();
    axfj localaxfj = (axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    Object localObject1 = ((ashc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
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
            localObject2 = localaxfj.a(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
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
  
  public void b(List<aitp> paramList)
  {
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (aitp)localIterator.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((aitp)localObject1).jdField_a_of_type_JavaLangString;
        int i = ((aitp)localObject1).jdField_a_of_type_Int;
        label103:
        Object localObject3;
        if (i == 1)
        {
          paramList = (StickerRecommendSortEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { localObject2 });
          if (paramList == null) {
            break label383;
          }
          paramList.convertToList();
          localObject1 = ((aitp)localObject1).jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (aism)((Iterator)localObject1).next();
          } while (((aism)localObject2).a());
          localObject2 = (aitc)localObject2;
          localObject3 = Integer.valueOf(((aitc)localObject2).d());
          if (!((aitc)localObject2).b()) {
            break label224;
          }
          if (paramList.clickedList.contains(localObject3)) {
            paramList.removeClicked((Integer)localObject3);
          }
          paramList.addClicked((Integer)localObject3);
        }
        for (;;)
        {
          paramList.removeNoExpose((Integer)localObject3);
          break label103;
          paramList = (StickerRecommendSortEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { localObject2 });
          break;
          label224:
          if (!paramList.exposedList.contains(localObject3)) {
            paramList.addExposed((Integer)localObject3);
          }
        }
        paramList.exposedList.removeAll(paramList.clickedList);
        if ((paramList.noExposeList != null) && (paramList.noExposeList.size() == 0))
        {
          localObject1 = paramList.noExposeList;
          paramList.noExposeList = paramList.exposedList;
          paramList.exposedList = ((List)localObject1);
        }
        paramList.convertToString();
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort clicked=" + paramList.clicked + " exposed=" + paramList.exposed + " noExpose=" + paramList.noExpose);
        }
        paramList.recommendType = i;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramList);
        continue;
        label383:
        paramList = new StickerRecommendSortEntity((String)localObject2);
        localObject2 = ((aitp)localObject1).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aism)((Iterator)localObject2).next();
          if (!((aism)localObject3).a())
          {
            localObject3 = (aitc)localObject3;
            if (((aitc)localObject3).b()) {
              paramList.addClicked(Integer.valueOf(((aitc)localObject3).d()));
            } else {
              paramList.addExposed(Integer.valueOf(((aitc)localObject3).d()));
            }
          }
        }
        localObject1 = ((aitp)localObject1).jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (aism)((Iterator)localObject1).next();
          if (!((aism)localObject2).a()) {
            paramList.addNoExpose(Integer.valueOf(((aitc)localObject2).d()));
          }
        }
        if ((paramList.noExposeList != null) && (paramList.noExposeList.size() == 0))
        {
          localObject1 = paramList.noExposeList;
          paramList.noExposeList = paramList.exposedList;
          paramList.exposedList = ((List)localObject1);
        }
        paramList.convertToString();
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort new SortEntity clicked=" + paramList.clicked + " exposed=" + paramList.exposed + " noExpose=" + paramList.noExpose);
        }
        paramList.recommendType = i;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramList);
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
    ThreadManager.excute(new StickerRecManager.5(this), 128, null, true);
  }
  
  public void d()
  {
    try
    {
      File localFile = new File(b(), "words");
      this.d = new File(b(), "words.zip");
      this.jdField_a_of_type_JavaIoFile = new File(localFile, "words.json");
      this.c = new File(localFile, "encodedBloom.bin");
      this.jdField_b_of_type_JavaIoFile = new File(localFile, "local_words.bin");
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "clearOverdueStickerCache");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.10(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aisy == null) {
      return;
    }
    this.jdField_a_of_type_Aisy.a();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Aitf == null) {
      return;
    }
    this.jdField_a_of_type_Aitf.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiti
 * JD-Core Version:    0.7.0.1
 */
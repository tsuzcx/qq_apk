import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.1;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class akzp
{
  private static volatile akzp jdField_a_of_type_Akzp;
  private static boolean jdField_b_of_type_Boolean;
  public float a;
  private int jdField_a_of_type_Int = 5;
  private alan jdField_a_of_type_Alan;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.75F;
  private String jdField_b_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip";
  private String c = "https://i.gtimg.cn/drawrp/aModel_";
  private String d;
  
  private akzp()
  {
    this.jdField_a_of_type_Float = 0.2F;
  }
  
  public static akzp a()
  {
    if (jdField_a_of_type_Akzp == null) {}
    try
    {
      if (jdField_a_of_type_Akzp == null) {
        jdField_a_of_type_Akzp = new akzp();
      }
      return jdField_a_of_type_Akzp;
    }
    finally {}
  }
  
  public static void a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramMessageForQQWalletMsg == null) || (paramMessageForQQWalletMsg.messageType != 26) || (jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.executeOnFileThread(new DrawClassifier.1(paramMessageForQQWalletMsg));
  }
  
  private void a(String paramString1, akzt paramakzt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DrawClassifier", 2, "init modelUrl=" + paramString1);
    }
    Object localObject = albw.a();
    if (localObject == null)
    {
      paramakzt.a(false);
      return;
    }
    if ((PreloadManager)((QQAppInterface)localObject).getManager(QQManagerFactory.PRELOAD_MANAGER) == null)
    {
      paramakzt.a(false);
      return;
    }
    localObject = new DownloadParam();
    ((DownloadParam)localObject).filePos = 1;
    ((DownloadParam)localObject).url = paramString1;
    ((DownloadParam)localObject).md5 = paramString2;
    ((DownloadParam)localObject).useQWalletConfig = true;
    PreloadManager.a().a((DownloadParam)localObject, new akzs(this, paramakzt));
  }
  
  private static JSONObject b(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray("modelList");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if ((localJSONObject != null) && (TextUtils.equals(localJSONObject.optString("id"), paramString))) {
          return localJSONObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void b(agcb paramagcb, akzu paramakzu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "recognize called");
    }
    if ((!this.jdField_a_of_type_Boolean) || (paramagcb == null))
    {
      if (paramakzu != null) {
        paramakzu.a(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier", 2, "recognize has not init");
      }
    }
    ThreadManager.excute(new DrawClassifier.4(this, paramakzu, paramagcb), 16, null, true);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Alan == null) {
      return null;
    }
    return this.jdField_a_of_type_Alan.a();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 79
    //   10: iconst_2
    //   11: new 81	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: ldc 213
    //   20: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 150	akzp:jdField_a_of_type_Boolean	Z
    //   27: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 150	akzp:jdField_a_of_type_Boolean	Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifne +6 -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 150	akzp:jdField_a_of_type_Boolean	Z
    //   53: aload_0
    //   54: getfield 44	akzp:jdField_a_of_type_Alan	Lalan;
    //   57: ifnull -12 -> 45
    //   60: aload_0
    //   61: getfield 44	akzp:jdField_a_of_type_Alan	Lalan;
    //   64: invokevirtual 218	alan:a	()V
    //   67: goto -22 -> 45
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	akzp
    //   40	2	1	bool	boolean
    //   70	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	70	finally
    //   36	41	70	finally
    //   48	67	70	finally
  }
  
  public void a(agcb paramagcb, akzu paramakzu)
  {
    b(paramagcb, paramakzu);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, akzt paramakzt)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.jdField_a_of_type_JavaLangString = paramString2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "init recogtitle:" + this.jdField_a_of_type_JavaLangString + ",mIsInit" + this.jdField_a_of_type_Boolean + ",modelId:" + paramString1);
        }
        try
        {
          if (TextUtils.isEmpty(paramString1)) {
            continue;
          }
          this.jdField_b_of_type_Float = 1.0F;
          paramContext = BaseHbFragment.getHbPannelConfig(10);
          if (QLog.isColorLevel()) {
            QLog.d("DrawClassifier", 2, "init configObj:" + paramContext);
          }
          if (paramContext != null)
          {
            if (TextUtils.isEmpty(paramString1)) {
              break label390;
            }
            this.c = paramContext.optString("aModelPrefix", "https://i.gtimg.cn/drawrp/aModel_");
            paramContext = b(paramContext, paramString1);
            if (paramContext != null)
            {
              this.jdField_a_of_type_Float = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
              this.jdField_a_of_type_Int = paramContext.optInt("topN", 5);
              this.jdField_b_of_type_Float = ((float)paramContext.optDouble("lineWidth", 1.0D));
              this.d = paramContext.optString("aMd5");
            }
            if (this.jdField_b_of_type_Float <= 0.0F) {
              this.jdField_b_of_type_Float = 1.0F;
            }
          }
          if (!TextUtils.isEmpty(paramString1))
          {
            if (TextUtils.isEmpty(this.c.trim())) {
              this.c = "https://i.gtimg.cn/drawrp/aModel_";
            }
            this.jdField_b_of_type_JavaLangString = (this.c + paramString1 + ".zip");
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "init modelUrl=" + this.jdField_b_of_type_JavaLangString + ",threshold=" + this.jdField_a_of_type_Float + ",topN=" + this.jdField_a_of_type_Int + ",lineWidth=" + this.jdField_b_of_type_Float);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label432;
        }
        if (paramakzt != null) {
          paramakzt.a(true);
        }
        return;
      }
      finally {}
      this.jdField_b_of_type_Float = 1.75F;
      continue;
      label390:
      this.jdField_b_of_type_JavaLangString = paramContext.optString("aModel", "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip");
      this.jdField_a_of_type_Float = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
      this.jdField_a_of_type_Int = paramContext.optInt("topN", 5);
      continue;
      label432:
      alar.a().a(new akzr(this, paramakzt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzp
 * JD-Core Version:    0.7.0.1
 */
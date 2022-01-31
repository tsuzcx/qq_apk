import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ahec
{
  private static volatile ahec jdField_a_of_type_Ahec;
  public float a;
  private int jdField_a_of_type_Int = 5;
  private ahfa jdField_a_of_type_Ahfa;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b = "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip";
  
  private ahec()
  {
    this.jdField_a_of_type_Float = 0.2F;
  }
  
  public static ahec a()
  {
    if (jdField_a_of_type_Ahec == null) {}
    try
    {
      if (jdField_a_of_type_Ahec == null) {
        jdField_a_of_type_Ahec = new ahec();
      }
      return jdField_a_of_type_Ahec;
    }
    finally {}
  }
  
  private void a(String paramString, ahef paramahef, boolean paramBoolean)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("DrawClassifier", 2, "init modelUrl=" + paramString + ",isRetryLastAfterFail=" + paramBoolean);
    }
    PreloadManager.a().a(localDownloadParam, new ahee(this, paramBoolean, paramahef));
  }
  
  private void b(addc paramaddc, aheg paramaheg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "recognize called");
    }
    if ((!this.jdField_a_of_type_Boolean) || (paramaddc == null))
    {
      if (paramaheg != null) {
        paramaheg.a(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier", 2, "recognize has not init");
      }
    }
    ThreadManager.excute(new DrawClassifier.3(this, paramaheg, paramaddc), 16, null, true);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Ahfa == null) {
      return null;
    }
    return this.jdField_a_of_type_Ahfa.a();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 57
    //   10: iconst_2
    //   11: new 59	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   18: ldc 130
    //   20: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 97	ahec:jdField_a_of_type_Boolean	Z
    //   27: invokevirtual 71	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 97	ahec:jdField_a_of_type_Boolean	Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifne +6 -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 97	ahec:jdField_a_of_type_Boolean	Z
    //   53: aload_0
    //   54: getfield 34	ahec:jdField_a_of_type_Ahfa	Lahfa;
    //   57: ifnull -12 -> 45
    //   60: aload_0
    //   61: getfield 34	ahec:jdField_a_of_type_Ahfa	Lahfa;
    //   64: invokevirtual 132	ahfa:a	()V
    //   67: goto -22 -> 45
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ahec
    //   40	2	1	bool	boolean
    //   70	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	70	finally
    //   36	41	70	finally
    //   48	67	70	finally
  }
  
  public void a(addc paramaddc, aheg paramaheg)
  {
    b(paramaddc, paramaheg);
  }
  
  public void a(Context paramContext, String paramString, ahef paramahef)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          this.jdField_a_of_type_JavaLangString = paramString;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "init recogtitle:" + this.jdField_a_of_type_JavaLangString + ",mIsInit" + this.jdField_a_of_type_Boolean);
        }
        try
        {
          paramContext = BaseHbFragment.getHbPannelConfig(10);
          if (QLog.isColorLevel()) {
            QLog.d("DrawClassifier", 2, "init configObj:" + paramContext);
          }
          if (paramContext != null)
          {
            this.b = paramContext.optString("aModel", "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip");
            this.jdField_a_of_type_Float = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
            this.jdField_a_of_type_Int = paramContext.optInt("topN", 5);
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "init modelUrl=" + this.b + ",threshold=" + this.jdField_a_of_type_Float + ",topN" + this.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if (paramahef != null) {
            paramahef.a(true);
          }
          return;
        }
      }
      finally {}
      ahfe.a().a(new ahed(this, paramahef));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahec
 * JD-Core Version:    0.7.0.1
 */
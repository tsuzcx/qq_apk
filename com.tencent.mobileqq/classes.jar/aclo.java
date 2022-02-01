import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aclo
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, Manager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, NetReq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public aclo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  }
  
  /* Error */
  private void a(aclx paramaclx)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 54	aclx:b	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 57	aclx:b	()Ljava/lang/String;
    //   12: invokestatic 63	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_3
    //   16: new 65	com/tencent/commonsdk/zip/QZipFile
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 68	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: new 70	java/io/File
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 74	java/io/File:getParent	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: ldc 76
    //   44: invokevirtual 80	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   47: astore 4
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: ldc 82
    //   54: invokevirtual 80	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   57: astore 5
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: ldc 84
    //   64: invokevirtual 80	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   67: astore 6
    //   69: aload 4
    //   71: ifnull +86 -> 157
    //   74: aload 5
    //   76: ifnull +81 -> 157
    //   79: aload 6
    //   81: ifnull +76 -> 157
    //   84: aload_2
    //   85: astore_1
    //   86: ldc 86
    //   88: iconst_1
    //   89: ldc 88
    //   91: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_2
    //   95: astore_1
    //   96: aload_2
    //   97: aload 4
    //   99: invokevirtual 98	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   102: new 70	java/io/File
    //   105: dup
    //   106: aload_3
    //   107: ldc 76
    //   109: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: invokestatic 106	acln:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   115: aload_2
    //   116: astore_1
    //   117: aload_2
    //   118: aload 5
    //   120: invokevirtual 98	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   123: new 70	java/io/File
    //   126: dup
    //   127: aload_3
    //   128: ldc 82
    //   130: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: invokestatic 106	acln:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   136: aload_2
    //   137: astore_1
    //   138: aload_2
    //   139: aload 6
    //   141: invokevirtual 98	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   144: new 70	java/io/File
    //   147: dup
    //   148: aload_3
    //   149: ldc 84
    //   151: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: invokestatic 106	acln:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   157: aload_2
    //   158: astore_1
    //   159: aload_2
    //   160: ldc 108
    //   162: invokevirtual 80	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   165: astore 4
    //   167: aload 4
    //   169: ifnull +50 -> 219
    //   172: aload_2
    //   173: astore_1
    //   174: ldc 86
    //   176: iconst_1
    //   177: ldc 110
    //   179: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_2
    //   183: astore_1
    //   184: new 70	java/io/File
    //   187: dup
    //   188: aload_3
    //   189: ldc 108
    //   191: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: astore 5
    //   196: aload_2
    //   197: astore_1
    //   198: aload 5
    //   200: invokevirtual 113	java/io/File:exists	()Z
    //   203: ifne +31 -> 234
    //   206: aload_2
    //   207: astore_1
    //   208: aload_2
    //   209: aload 4
    //   211: invokevirtual 98	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   214: aload 5
    //   216: invokestatic 106	acln:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   219: aload_2
    //   220: ifnull -213 -> 7
    //   223: aload_2
    //   224: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   227: return
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   233: return
    //   234: aload_2
    //   235: astore_1
    //   236: aload_2
    //   237: aload 4
    //   239: invokevirtual 98	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   242: new 70	java/io/File
    //   245: dup
    //   246: aload_3
    //   247: ldc 121
    //   249: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: invokestatic 106	acln:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   255: goto -36 -> 219
    //   258: astore_3
    //   259: aload_2
    //   260: astore_1
    //   261: aload_3
    //   262: invokevirtual 122	java/lang/Throwable:printStackTrace	()V
    //   265: aload_2
    //   266: ifnull -259 -> 7
    //   269: aload_2
    //   270: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   273: return
    //   274: astore_1
    //   275: aload_1
    //   276: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   279: return
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull +7 -> 291
    //   287: aload_1
    //   288: invokevirtual 116	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   291: aload_2
    //   292: athrow
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   298: goto -7 -> 291
    //   301: astore_2
    //   302: goto -19 -> 283
    //   305: astore_3
    //   306: aconst_null
    //   307: astore_2
    //   308: goto -49 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	aclo
    //   0	311	1	paramaclx	aclx
    //   24	246	2	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   280	12	2	localObject1	Object
    //   301	1	2	localObject2	Object
    //   307	1	2	localObject3	Object
    //   15	232	3	str	String
    //   258	4	3	localThrowable1	Throwable
    //   305	1	3	localThrowable2	Throwable
    //   47	191	4	localZipEntry1	java.util.zip.ZipEntry
    //   57	158	5	localObject4	Object
    //   67	73	6	localZipEntry2	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   223	227	228	java/io/IOException
    //   27	39	258	java/lang/Throwable
    //   41	49	258	java/lang/Throwable
    //   51	59	258	java/lang/Throwable
    //   61	69	258	java/lang/Throwable
    //   86	94	258	java/lang/Throwable
    //   96	115	258	java/lang/Throwable
    //   117	136	258	java/lang/Throwable
    //   138	157	258	java/lang/Throwable
    //   159	167	258	java/lang/Throwable
    //   174	182	258	java/lang/Throwable
    //   184	196	258	java/lang/Throwable
    //   198	206	258	java/lang/Throwable
    //   208	219	258	java/lang/Throwable
    //   236	255	258	java/lang/Throwable
    //   269	273	274	java/io/IOException
    //   8	25	280	finally
    //   287	291	293	java/io/IOException
    //   27	39	301	finally
    //   41	49	301	finally
    //   51	59	301	finally
    //   61	69	301	finally
    //   86	94	301	finally
    //   96	115	301	finally
    //   117	136	301	finally
    //   138	157	301	finally
    //   159	167	301	finally
    //   174	182	301	finally
    //   184	196	301	finally
    //   198	206	301	finally
    //   208	219	301	finally
    //   236	255	301	finally
    //   261	265	301	finally
    //   8	25	305	java/lang/Throwable
  }
  
  private void a(NetResp paramNetResp)
  {
    aclp localaclp = (aclp)paramNetResp.mReq.getUserData();
    if ((localaclp == null) || (localaclp.jdField_a_of_type_Aclx == null))
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp requestData is null");
      return;
    }
    if (paramNetResp.mResult == 3)
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp is downloading");
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = localaclp.jdField_a_of_type_Long;
    String str3 = localaclp.jdField_a_of_type_Aclx.b();
    String str1 = localaclp.jdField_a_of_type_Aclx.c();
    int i = localaclp.jdField_a_of_type_Aclx.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp reslut=" + paramNetResp.mResult + ", mTotalFileLen=" + paramNetResp.mTotalFileLen + ", downloadPatchSize=" + i + ", cost time=" + (l1 - l2));
    String str2 = PatchCommonUtil.getPatchPath(str1);
    Object localObject = PatchCommonUtil.getPatchPath(str3);
    for (;;)
    {
      try
      {
        if ((paramNetResp.mResult != 0) || (paramNetResp.mTotalFileLen != i)) {
          break label398;
        }
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!localaclp.jdField_a_of_type_Aclx.b())
        {
          bool1 = bool2;
          if (PatchCommonUtil.isArtGeN()) {
            bool1 = aclq.a(localaclp.jdField_a_of_type_Aclx);
          }
        }
        bool2 = bool1;
        if (bool1) {
          bool2 = PatchChecker.checkPatchValid(localaclp.jdField_a_of_type_JavaLangString, str3);
        }
        if (bool2)
        {
          a(localaclp.jdField_a_of_type_Aclx);
          aauu.c();
          aauu.a(anvx.a(2131707359));
          new DexClassLoader((String)localObject, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), (String)localObject, BaseApplicationImpl.sApplication.getClassLoader());
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 200, str1);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
          return;
        }
      }
      catch (Throwable paramNetResp)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp throwable=" + paramNetResp);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 202, str1);
        return;
      }
      paramNetResp = new File((String)localObject);
      if (paramNetResp.exists())
      {
        paramNetResp.delete();
        continue;
        label398:
        if (paramNetResp.mResult != 0)
        {
          str3 = "PatchDownloadManager doOnResp NOT ResultOk mErrCode=" + paramNetResp.mErrCode + ", mErrDesc=" + paramNetResp.mErrDesc;
          QLog.d("PatchLogTag", 1, str3);
          localObject = BaseApplicationImpl.sApplication.getSharedPreferences("hotpatch_preference", 4);
          l1 = ((SharedPreferences)localObject).getLong("patch_download_fail_report_time", 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > 21600000L)
          {
            bdjw.a(new RuntimeException(), str3);
            ((SharedPreferences)localObject).edit().putLong("patch_download_fail_report_time", l2).commit();
          }
          if ((paramNetResp.mErrCode == 9039) || (paramNetResp.mErrCode == 9301))
          {
            paramNetResp = new File(paramNetResp.mReq.mTempPath);
            QLog.d("PatchLogTag", 1, "write temp patch fail path=" + paramNetResp.getAbsolutePath() + ", isExist=" + paramNetResp.exists() + ", canWrite=" + paramNetResp.canWrite());
          }
        }
        if (localaclp.jdField_a_of_type_Int < 3)
        {
          a(localaclp.jdField_a_of_type_Int, localaclp.jdField_a_of_type_JavaLangString, localaclp.jdField_a_of_type_Aclx);
          return;
        }
        aauu.c();
        paramNetResp = new File(str2);
        if (paramNetResp.exists()) {
          paramNetResp.delete();
        }
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 201, str1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, aclx paramaclx)
  {
    String str1 = paramaclx.d();
    String str2 = paramaclx.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager tryDownloadPatch retryCount=" + paramInt + ", downloadPatchName=" + str2 + ", downloadUrl=" + str1);
    if ((paramInt < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(str2))) {
      return;
    }
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mBreakDownFix = this;
    localHttpNetReq.mReqUrl = str1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = PatchCommonUtil.getPatchPath(str2);
    localHttpNetReq.setUserData(new aclp(this, paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramaclx));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, localHttpNetReq);
    localINetEngine.sendReq(localHttpNetReq);
  }
  
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
    paramNetResp.mWrittenBlockLen = 0L;
    paramNetReq.mReqProperties.put("Range", "bytes=" + paramNetReq.mStartDownOffset + "-");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((NetResp)paramMessage.obj);
      continue;
      QLog.d("PatchLogTag", 1, "PatchDownloadManager patch download on progress curOffset=" + paramMessage.arg1 + ", totalLen=" + paramMessage.arg2);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramNetResp).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclo
 * JD-Core Version:    0.7.0.1
 */
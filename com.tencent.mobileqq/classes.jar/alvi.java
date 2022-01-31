import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.ims.safecheckPB.ReportItem;
import com.tencent.ims.safecheckPB.ReqMQScanRequest;
import com.tencent.ims.safecheckPB.RspMQScanReport;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class alvi
  extends alko
{
  private static boolean jdField_a_of_type_Boolean;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    int i;
    switch (baqx.a().a())
    {
    default: 
      i = 0;
    }
    while ((i & paramInt) == 0)
    {
      return false;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 8;
      continue;
      i = 16;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramString1.length() == 0) || (paramString2.length() == 0)) {
      return false;
    }
    try
    {
      boolean bool = Pattern.compile(paramString1, 2).matcher(paramString2).find();
      return bool;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  public void a(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 1);
      Object localObject2 = SecUtil.getSign(BaseApplication.getContext());
      new String();
      localObject2 = SecUtil.getSignatureHash((byte[])localObject2);
      new String();
      if (paramReqMQScanRequest.string_check_target.get().equalsIgnoreCase((String)localObject2)) {
        return;
      }
    }
    catch (RuntimeException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
      return;
    }
    catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
      return;
    }
    paramReqMQScanRequest = new safecheckPB.ReportItem();
    paramReqMQScanRequest.string_target_packname.set(((PackageInfo)localObject1).packageName);
    paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((PackageInfo)localObject1).applicationInfo.sourceDir));
    paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
    paramRspMQScanReport.uint32_check_count.set(1);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (true == jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    Object localObject = new safecheckPB.ReqMQScanRequest();
    safecheckPB.RspMQScanReport localRspMQScanReport = new safecheckPB.RspMQScanReport();
    try
    {
      ((safecheckPB.ReqMQScanRequest)localObject).mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("QPSafeCheck", 2, "Check Item" + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_uid.get() + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.get() + ((safecheckPB.ReqMQScanRequest)localObject).string_check_target.get() + ((safecheckPB.ReqMQScanRequest)localObject).string_check_parameters.get() + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get());
      }
      if (!a(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get()))
      {
        alxp.b();
        jdField_a_of_type_Boolean = false;
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QPSafeCheck", 2, "RspBody parseFrom byte InvalidProtocolBufferMicroException");
      }
      jdField_a_of_type_Boolean = false;
      paramArrayOfByte.printStackTrace();
    }
    for (;;)
    {
      if (!a(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get()))
      {
        alxp.b();
        jdField_a_of_type_Boolean = false;
        return;
        if (!((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.has()) {
          break label606;
        }
      }
      label606:
      for (int i = ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.get();; i = 0)
      {
        localRspMQScanReport.uint32_check_uid.set(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_uid.get());
        localRspMQScanReport.uint32_check_count.set(0);
        switch (i)
        {
        case 1001: 
          a((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1002: 
          b((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1007: 
          c((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1004: 
          e((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1005: 
          f((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1006: 
          d((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
          i = 0;
          paramArrayOfByte = new safecheckPB.RspMQScanReport();
          if (localRspMQScanReport.uint32_check_count.get() > 48)
          {
            paramArrayOfByte.uint32_check_count.set(48);
            paramArrayOfByte.uint32_check_uid.set(localRspMQScanReport.uint32_check_uid.get());
            localObject = new ArrayList();
            j = 0;
            while (j < 48)
            {
              ((List)localObject).add(localRspMQScanReport.rpt_check_item.get(0));
              localRspMQScanReport.rpt_check_item.remove(0);
              j += 1;
            }
            paramArrayOfByte.rpt_check_item.set((List)localObject);
            j = localRspMQScanReport.uint32_check_count.get();
            localRspMQScanReport.uint32_check_count.set(j - 48);
            localObject = createToServiceMsg("SecSafeChkSvc.MainCmd");
            ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
            sendPbReq((ToServiceMsg)localObject);
          }
          for (int j = i;; j = 1)
          {
            i = j;
            if (j == 0) {
              break;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("QPSafeCheck", 2, "check uid = " + localRspMQScanReport.uint32_check_uid.get());
              QLog.d("QPSafeCheck", 2, "check count = " + localRspMQScanReport.uint32_check_count.get());
            }
            alxp.b();
            jdField_a_of_type_Boolean = false;
            return;
            paramArrayOfByte = createToServiceMsg("SecSafeChkSvc.MainCmd");
            paramArrayOfByte.putWupBuffer(localRspMQScanReport.toByteArray());
            sendPbReq(paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void b(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    paramReqMQScanRequest = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    List localList = paramReqMQScanRequest.getInstalledApplications(8192);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < localList.size()) {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ApplicationInfo)localList.get(j)).packageName, 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            i += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(i);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      } else {
        return;
      }
      j += 1;
    }
  }
  
  public void c(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    for (;;)
    {
      int i;
      try
      {
        localObject = ((PackageManager)localObject).getInstalledApplications(8192);
        i = 0;
        if (i >= ((List)localObject).size()) {
          break;
        }
        if ((ApplicationInfo)((List)localObject).get(i) == null)
        {
          i += 1;
          continue;
        }
        str = ((ApplicationInfo)((List)localObject).get(i)).processName;
      }
      catch (RuntimeException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
        return;
      }
      String str;
      if ((str != null) && (a(paramReqMQScanRequest.string_check_target.get(), str)))
      {
        paramReqMQScanRequest = new safecheckPB.ReportItem();
        paramReqMQScanRequest.string_target_packname.set(((ApplicationInfo)((List)localObject).get(i)).packageName);
        paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((ApplicationInfo)((List)localObject).get(i)).sourceDir));
        paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
        paramRspMQScanReport.uint32_check_count.set(1);
      }
    }
    alxp.b();
  }
  
  /* Error */
  public void d(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 14
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 13
    //   21: aconst_null
    //   22: astore 7
    //   24: aload_0
    //   25: getfield 48	alvi:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   28: invokevirtual 54	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   31: astore 6
    //   33: aload 6
    //   35: aload_0
    //   36: getfield 48	alvi:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   39: invokevirtual 58	android/content/Context:getPackageName	()Ljava/lang/String;
    //   42: iconst_1
    //   43: invokevirtual 64	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   46: astore 15
    //   48: new 298	com/tencent/commonsdk/zip/QZipFile
    //   51: dup
    //   52: aload 15
    //   54: getfield 126	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   57: getfield 131	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   60: invokespecial 300	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   63: astore 8
    //   65: aload 7
    //   67: astore 11
    //   69: aload 14
    //   71: astore 10
    //   73: aload 12
    //   75: astore 5
    //   77: aload 8
    //   79: astore 6
    //   81: aload 13
    //   83: astore 9
    //   85: aload 8
    //   87: ldc_w 302
    //   90: invokevirtual 306	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   93: astore 16
    //   95: aload 16
    //   97: ifnonnull +83 -> 180
    //   100: iconst_0
    //   101: ifeq +11 -> 112
    //   104: new 308	java/lang/NullPointerException
    //   107: dup
    //   108: invokespecial 309	java/lang/NullPointerException:<init>	()V
    //   111: athrow
    //   112: aload 8
    //   114: ifnull +8 -> 122
    //   117: aload 8
    //   119: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   122: return
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 102	java/lang/RuntimeException:printStackTrace	()V
    //   128: iconst_0
    //   129: ifeq +11 -> 140
    //   132: new 308	java/lang/NullPointerException
    //   135: dup
    //   136: invokespecial 309	java/lang/NullPointerException:<init>	()V
    //   139: athrow
    //   140: iconst_0
    //   141: ifeq -19 -> 122
    //   144: new 308	java/lang/NullPointerException
    //   147: dup
    //   148: invokespecial 309	java/lang/NullPointerException:<init>	()V
    //   151: athrow
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   157: return
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   163: goto -23 -> 140
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   171: goto -59 -> 112
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   179: return
    //   180: aload 7
    //   182: astore 11
    //   184: aload 14
    //   186: astore 10
    //   188: aload 12
    //   190: astore 5
    //   192: aload 8
    //   194: astore 6
    //   196: aload 13
    //   198: astore 9
    //   200: aload 8
    //   202: aload 16
    //   204: invokevirtual 317	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   207: astore 7
    //   209: aload 7
    //   211: ifnonnull +38 -> 249
    //   214: aload 7
    //   216: ifnull +8 -> 224
    //   219: aload 7
    //   221: invokevirtual 320	java/io/InputStream:close	()V
    //   224: aload 8
    //   226: ifnull -104 -> 122
    //   229: aload 8
    //   231: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   234: return
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   240: return
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   246: goto -22 -> 224
    //   249: aload 7
    //   251: astore 11
    //   253: aload 7
    //   255: astore 10
    //   257: aload 7
    //   259: astore 5
    //   261: aload 8
    //   263: astore 6
    //   265: aload 7
    //   267: astore 9
    //   269: sipush 8192
    //   272: newarray byte
    //   274: astore 12
    //   276: aload 7
    //   278: astore 11
    //   280: aload 7
    //   282: astore 10
    //   284: aload 7
    //   286: astore 5
    //   288: aload 8
    //   290: astore 6
    //   292: aload 7
    //   294: astore 9
    //   296: ldc_w 322
    //   299: invokestatic 328	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   302: astore 13
    //   304: aload 7
    //   306: astore 11
    //   308: aload 7
    //   310: astore 10
    //   312: aload 7
    //   314: astore 5
    //   316: aload 8
    //   318: astore 6
    //   320: aload 7
    //   322: astore 9
    //   324: aload 7
    //   326: aload 12
    //   328: invokevirtual 332	java/io/InputStream:read	([B)I
    //   331: istore_3
    //   332: iload_3
    //   333: ifle +75 -> 408
    //   336: aload 7
    //   338: astore 11
    //   340: aload 7
    //   342: astore 10
    //   344: aload 7
    //   346: astore 5
    //   348: aload 8
    //   350: astore 6
    //   352: aload 7
    //   354: astore 9
    //   356: aload 13
    //   358: aload 12
    //   360: iconst_0
    //   361: iload_3
    //   362: invokevirtual 336	java/security/MessageDigest:update	([BII)V
    //   365: goto -61 -> 304
    //   368: astore_1
    //   369: aload 11
    //   371: astore 5
    //   373: aload 8
    //   375: astore 6
    //   377: aload_1
    //   378: invokevirtual 103	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   381: aload 11
    //   383: ifnull +8 -> 391
    //   386: aload 11
    //   388: invokevirtual 320	java/io/InputStream:close	()V
    //   391: aload 8
    //   393: ifnull -271 -> 122
    //   396: aload 8
    //   398: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   401: return
    //   402: astore_1
    //   403: aload_1
    //   404: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   407: return
    //   408: aload 7
    //   410: astore 11
    //   412: aload 7
    //   414: astore 10
    //   416: aload 7
    //   418: astore 5
    //   420: aload 8
    //   422: astore 6
    //   424: aload 7
    //   426: astore 9
    //   428: aload 13
    //   430: invokevirtual 339	java/security/MessageDigest:digest	()[B
    //   433: invokestatic 342	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   436: astore 12
    //   438: aload 7
    //   440: astore 11
    //   442: aload 7
    //   444: astore 10
    //   446: aload 7
    //   448: astore 5
    //   450: aload 8
    //   452: astore 6
    //   454: aload 7
    //   456: astore 9
    //   458: new 22	java/lang/String
    //   461: dup
    //   462: invokespecial 80	java/lang/String:<init>	()V
    //   465: pop
    //   466: aload 7
    //   468: astore 11
    //   470: aload 7
    //   472: astore 10
    //   474: aload 7
    //   476: astore 5
    //   478: aload 8
    //   480: astore 6
    //   482: aload 7
    //   484: astore 9
    //   486: aload_1
    //   487: getfield 90	com/tencent/ims/safecheckPB$ReqMQScanRequest:string_check_target	Lcom/tencent/mobileqq/pb/PBStringField;
    //   490: invokevirtual 95	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   493: aload 12
    //   495: invokevirtual 99	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   498: istore 4
    //   500: iload 4
    //   502: ifeq +132 -> 634
    //   505: aload 7
    //   507: ifnull +24 -> 531
    //   510: aload 7
    //   512: astore 11
    //   514: aload 7
    //   516: astore 10
    //   518: aload 7
    //   520: astore 5
    //   522: aload 8
    //   524: astore 6
    //   526: aload 7
    //   528: invokevirtual 320	java/io/InputStream:close	()V
    //   531: aload 7
    //   533: ifnull +8 -> 541
    //   536: aload 7
    //   538: invokevirtual 320	java/io/InputStream:close	()V
    //   541: aload 8
    //   543: ifnull -421 -> 122
    //   546: aload 8
    //   548: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   551: return
    //   552: astore_1
    //   553: aload_1
    //   554: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   557: return
    //   558: astore_1
    //   559: aload 7
    //   561: astore 11
    //   563: aload 7
    //   565: astore 10
    //   567: aload 7
    //   569: astore 5
    //   571: aload 8
    //   573: astore 6
    //   575: aload 7
    //   577: astore 9
    //   579: aload_1
    //   580: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   583: goto -52 -> 531
    //   586: astore_1
    //   587: aload 10
    //   589: astore 5
    //   591: aload 8
    //   593: astore 6
    //   595: aload_1
    //   596: invokevirtual 343	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   599: aload 10
    //   601: ifnull +8 -> 609
    //   604: aload 10
    //   606: invokevirtual 320	java/io/InputStream:close	()V
    //   609: aload 8
    //   611: ifnull -489 -> 122
    //   614: aload 8
    //   616: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   619: return
    //   620: astore_1
    //   621: aload_1
    //   622: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   625: return
    //   626: astore_1
    //   627: aload_1
    //   628: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   631: goto -90 -> 541
    //   634: aload 7
    //   636: astore 11
    //   638: aload 7
    //   640: astore 10
    //   642: aload 7
    //   644: astore 5
    //   646: aload 8
    //   648: astore 6
    //   650: aload 7
    //   652: astore 9
    //   654: aload_2
    //   655: getfield 221	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   658: aload_1
    //   659: getfield 186	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   662: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   665: invokevirtual 156	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   668: aload 7
    //   670: astore 11
    //   672: aload 7
    //   674: astore 10
    //   676: aload 7
    //   678: astore 5
    //   680: aload 8
    //   682: astore 6
    //   684: aload 7
    //   686: astore 9
    //   688: aload_2
    //   689: getfield 151	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   692: iconst_1
    //   693: invokevirtual 156	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   696: aload 7
    //   698: astore 11
    //   700: aload 7
    //   702: astore 10
    //   704: aload 7
    //   706: astore 5
    //   708: aload 8
    //   710: astore 6
    //   712: aload 7
    //   714: astore 9
    //   716: new 105	com/tencent/ims/safecheckPB$ReportItem
    //   719: dup
    //   720: invokespecial 106	com/tencent/ims/safecheckPB$ReportItem:<init>	()V
    //   723: astore_1
    //   724: aload 7
    //   726: astore 11
    //   728: aload 7
    //   730: astore 10
    //   732: aload 7
    //   734: astore 5
    //   736: aload 8
    //   738: astore 6
    //   740: aload 7
    //   742: astore 9
    //   744: aload_1
    //   745: getfield 109	com/tencent/ims/safecheckPB$ReportItem:string_target_packname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   748: aload 15
    //   750: getfield 115	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   753: invokevirtual 119	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   756: aload 7
    //   758: astore 11
    //   760: aload 7
    //   762: astore 10
    //   764: aload 7
    //   766: astore 5
    //   768: aload 8
    //   770: astore 6
    //   772: aload 7
    //   774: astore 9
    //   776: aload_1
    //   777: getfield 122	com/tencent/ims/safecheckPB$ReportItem:string_target_md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   780: aload 12
    //   782: invokevirtual 119	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   785: aload 7
    //   787: astore 11
    //   789: aload 7
    //   791: astore 10
    //   793: aload 7
    //   795: astore 5
    //   797: aload 8
    //   799: astore 6
    //   801: aload 7
    //   803: astore 9
    //   805: aload_2
    //   806: getfield 141	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   809: aload_1
    //   810: invokevirtual 147	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   813: aload 7
    //   815: ifnull +8 -> 823
    //   818: aload 7
    //   820: invokevirtual 320	java/io/InputStream:close	()V
    //   823: aload 8
    //   825: ifnull -703 -> 122
    //   828: aload 8
    //   830: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   833: return
    //   834: astore_1
    //   835: aload_1
    //   836: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   839: return
    //   840: astore_1
    //   841: aload_1
    //   842: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   845: goto -22 -> 823
    //   848: astore_1
    //   849: aload_1
    //   850: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   853: goto -462 -> 391
    //   856: astore_1
    //   857: aload_1
    //   858: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   861: goto -252 -> 609
    //   864: astore_1
    //   865: aconst_null
    //   866: astore 8
    //   868: aload 9
    //   870: astore 5
    //   872: aload 8
    //   874: astore 6
    //   876: aload_1
    //   877: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   880: aload 9
    //   882: ifnull +8 -> 890
    //   885: aload 9
    //   887: invokevirtual 320	java/io/InputStream:close	()V
    //   890: aload 8
    //   892: ifnull -770 -> 122
    //   895: aload 8
    //   897: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   900: return
    //   901: astore_1
    //   902: aload_1
    //   903: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   906: return
    //   907: astore_1
    //   908: aload_1
    //   909: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   912: goto -22 -> 890
    //   915: astore_1
    //   916: aconst_null
    //   917: astore 6
    //   919: aload 5
    //   921: ifnull +8 -> 929
    //   924: aload 5
    //   926: invokevirtual 320	java/io/InputStream:close	()V
    //   929: aload 6
    //   931: ifnull +8 -> 939
    //   934: aload 6
    //   936: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   939: aload_1
    //   940: athrow
    //   941: astore_2
    //   942: aload_2
    //   943: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   946: goto -17 -> 929
    //   949: astore_2
    //   950: aload_2
    //   951: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   954: goto -15 -> 939
    //   957: astore_1
    //   958: goto -39 -> 919
    //   961: astore_1
    //   962: goto -94 -> 868
    //   965: astore_1
    //   966: aconst_null
    //   967: astore 8
    //   969: goto -382 -> 587
    //   972: astore_1
    //   973: aconst_null
    //   974: astore 8
    //   976: goto -607 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	this	alvi
    //   0	979	1	paramReqMQScanRequest	safecheckPB.ReqMQScanRequest
    //   0	979	2	paramRspMQScanReport	safecheckPB.RspMQScanReport
    //   331	31	3	i	int
    //   498	3	4	bool	boolean
    //   13	912	5	localObject1	Object
    //   31	904	6	localObject2	Object
    //   22	797	7	localInputStream	java.io.InputStream
    //   63	912	8	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   10	876	9	localObject3	Object
    //   7	785	10	localObject4	Object
    //   1	787	11	localObject5	Object
    //   16	765	12	localObject6	Object
    //   19	410	13	localMessageDigest	java.security.MessageDigest
    //   4	181	14	localObject7	Object
    //   46	703	15	localPackageInfo	PackageInfo
    //   93	110	16	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   33	48	123	java/lang/RuntimeException
    //   144	152	152	java/io/IOException
    //   132	140	158	java/io/IOException
    //   104	112	166	java/io/IOException
    //   117	122	174	java/io/IOException
    //   229	234	235	java/io/IOException
    //   219	224	241	java/io/IOException
    //   85	95	368	android/content/pm/PackageManager$NameNotFoundException
    //   200	209	368	android/content/pm/PackageManager$NameNotFoundException
    //   269	276	368	android/content/pm/PackageManager$NameNotFoundException
    //   296	304	368	android/content/pm/PackageManager$NameNotFoundException
    //   324	332	368	android/content/pm/PackageManager$NameNotFoundException
    //   356	365	368	android/content/pm/PackageManager$NameNotFoundException
    //   428	438	368	android/content/pm/PackageManager$NameNotFoundException
    //   458	466	368	android/content/pm/PackageManager$NameNotFoundException
    //   486	500	368	android/content/pm/PackageManager$NameNotFoundException
    //   526	531	368	android/content/pm/PackageManager$NameNotFoundException
    //   579	583	368	android/content/pm/PackageManager$NameNotFoundException
    //   654	668	368	android/content/pm/PackageManager$NameNotFoundException
    //   688	696	368	android/content/pm/PackageManager$NameNotFoundException
    //   716	724	368	android/content/pm/PackageManager$NameNotFoundException
    //   744	756	368	android/content/pm/PackageManager$NameNotFoundException
    //   776	785	368	android/content/pm/PackageManager$NameNotFoundException
    //   805	813	368	android/content/pm/PackageManager$NameNotFoundException
    //   396	401	402	java/io/IOException
    //   546	551	552	java/io/IOException
    //   526	531	558	java/io/IOException
    //   85	95	586	java/security/NoSuchAlgorithmException
    //   200	209	586	java/security/NoSuchAlgorithmException
    //   269	276	586	java/security/NoSuchAlgorithmException
    //   296	304	586	java/security/NoSuchAlgorithmException
    //   324	332	586	java/security/NoSuchAlgorithmException
    //   356	365	586	java/security/NoSuchAlgorithmException
    //   428	438	586	java/security/NoSuchAlgorithmException
    //   458	466	586	java/security/NoSuchAlgorithmException
    //   486	500	586	java/security/NoSuchAlgorithmException
    //   526	531	586	java/security/NoSuchAlgorithmException
    //   579	583	586	java/security/NoSuchAlgorithmException
    //   654	668	586	java/security/NoSuchAlgorithmException
    //   688	696	586	java/security/NoSuchAlgorithmException
    //   716	724	586	java/security/NoSuchAlgorithmException
    //   744	756	586	java/security/NoSuchAlgorithmException
    //   776	785	586	java/security/NoSuchAlgorithmException
    //   805	813	586	java/security/NoSuchAlgorithmException
    //   614	619	620	java/io/IOException
    //   536	541	626	java/io/IOException
    //   828	833	834	java/io/IOException
    //   818	823	840	java/io/IOException
    //   386	391	848	java/io/IOException
    //   604	609	856	java/io/IOException
    //   33	48	864	java/io/IOException
    //   48	65	864	java/io/IOException
    //   124	128	864	java/io/IOException
    //   895	900	901	java/io/IOException
    //   885	890	907	java/io/IOException
    //   33	48	915	finally
    //   48	65	915	finally
    //   124	128	915	finally
    //   924	929	941	java/io/IOException
    //   934	939	949	java/io/IOException
    //   85	95	957	finally
    //   200	209	957	finally
    //   269	276	957	finally
    //   296	304	957	finally
    //   324	332	957	finally
    //   356	365	957	finally
    //   377	381	957	finally
    //   428	438	957	finally
    //   458	466	957	finally
    //   486	500	957	finally
    //   526	531	957	finally
    //   579	583	957	finally
    //   595	599	957	finally
    //   654	668	957	finally
    //   688	696	957	finally
    //   716	724	957	finally
    //   744	756	957	finally
    //   776	785	957	finally
    //   805	813	957	finally
    //   876	880	957	finally
    //   85	95	961	java/io/IOException
    //   200	209	961	java/io/IOException
    //   269	276	961	java/io/IOException
    //   296	304	961	java/io/IOException
    //   324	332	961	java/io/IOException
    //   356	365	961	java/io/IOException
    //   428	438	961	java/io/IOException
    //   458	466	961	java/io/IOException
    //   486	500	961	java/io/IOException
    //   579	583	961	java/io/IOException
    //   654	668	961	java/io/IOException
    //   688	696	961	java/io/IOException
    //   716	724	961	java/io/IOException
    //   744	756	961	java/io/IOException
    //   776	785	961	java/io/IOException
    //   805	813	961	java/io/IOException
    //   33	48	965	java/security/NoSuchAlgorithmException
    //   48	65	965	java/security/NoSuchAlgorithmException
    //   124	128	965	java/security/NoSuchAlgorithmException
    //   33	48	972	android/content/pm/PackageManager$NameNotFoundException
    //   48	65	972	android/content/pm/PackageManager$NameNotFoundException
    //   124	128	972	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void e(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    QLog.d("QPSafeCheck", 2, "IsAppRunning");
    Object localObject2 = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
    while (i < ((List)localObject2).size())
    {
      if (a(paramReqMQScanRequest.string_check_target.get(), ((ActivityManager.RunningAppProcessInfo)((List)localObject2).get(i)).processName)) {
        try
        {
          paramReqMQScanRequest = ((PackageManager)localObject1).getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject2.get(i)).pkgList[0], 1);
          localObject1 = new safecheckPB.ReportItem();
          ((safecheckPB.ReportItem)localObject1).string_target_packname.set(paramReqMQScanRequest.packageName);
          ((safecheckPB.ReportItem)localObject1).string_target_md5.set(SecUtil.getFileMd5(paramReqMQScanRequest.applicationInfo.sourceDir));
          paramRspMQScanReport.rpt_check_item.add((MessageMicro)localObject1);
          paramRspMQScanReport.uint32_check_count.set(1);
          return;
        }
        catch (RuntimeException paramReqMQScanRequest)
        {
          paramReqMQScanRequest.printStackTrace();
          return;
        }
        catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
        {
          paramReqMQScanRequest.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public void f(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    Object localObject = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
    paramReqMQScanRequest = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    int j = 0;
    for (;;)
    {
      if (j < ((List)localObject).size()) {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject.get(j)).pkgList[0], 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            i += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(i);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      } else {
        return;
      }
      j += 1;
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alvi
 * JD-Core Version:    0.7.0.1
 */
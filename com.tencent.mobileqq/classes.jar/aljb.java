import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class aljb
  implements axrt, Manager
{
  static axrs jdField_a_of_type_Axrs = new aljc();
  aliy jdField_a_of_type_Aliy;
  private axrr jdField_a_of_type_Axrr;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<alje> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public aljb(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Axrr = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Aliy = new aliy();
  }
  
  private String a(aljd paramaljd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramaljd);
    }
    String str = this.jdField_a_of_type_Aliy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaljd.jdField_a_of_type_Int).a(paramaljd);
    if (!bace.a(str)) {}
    try
    {
      bace.a(this.jdField_a_of_type_Aliy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaljd.jdField_a_of_type_Int).b(paramaljd), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      bace.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramaljd + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(aljd paramaljd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramaljd);
    }
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = this;
    localaxro.jdField_a_of_type_JavaLangString = paramaljd.jdField_a_of_type_JavaLangString;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.c = this.jdField_a_of_type_Aliy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaljd.jdField_a_of_type_Int).b(paramaljd);
    localaxro.e = 1;
    localaxro.a(paramaljd);
    localaxro.jdField_a_of_type_Axrs = jdField_a_of_type_Axrs;
    this.jdField_a_of_type_Axrr.a(localaxro);
  }
  
  private boolean b(aljd paramaljd)
  {
    return this.jdField_a_of_type_Aliy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaljd.jdField_a_of_type_Int).a(paramaljd);
  }
  
  public void a(alje paramalje)
  {
    if (paramalje == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramalje)) {
        this.jdField_a_of_type_JavaUtilList.add(paramalje);
      }
      return;
    }
  }
  
  public boolean a(aljd paramaljd)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramaljd);
    }
    Object localObject2 = this.jdField_a_of_type_Aliy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramaljd.jdField_a_of_type_Int);
    if ((!TextUtils.isEmpty(paramaljd.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramaljd.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + paramaljd);
      }
      return false;
    }
    Object localObject1;
    if (!b(paramaljd))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + paramaljd);
      }
      if (paramaljd.jdField_a_of_type_Boolean)
      {
        localObject1 = ((alja)localObject2).a(paramaljd);
        if ((bace.a((String)localObject1)) && (!((alja)localObject2).a(paramaljd, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + paramaljd);
          }
          bace.a((String)localObject1);
        }
        localObject1 = a(paramaljd);
        if (new File((String)localObject1).exists()) {
          break label633;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        int j = 0;
        try
        {
          for (;;)
          {
            if (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              alje localalje = (alje)this.jdField_a_of_type_JavaUtilList.get(j);
              if (localalje != null) {
                localalje.a(paramaljd.jdField_a_of_type_JavaLangString, paramaljd.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramaljd.jdField_a_of_type_JavaLangObject);
              }
              j += 1;
              continue;
              localObject1 = ((alja)localObject2).b(paramaljd);
              break;
            }
          }
          if (paramaljd.jdField_a_of_type_Alje != null) {
            paramaljd.jdField_a_of_type_Alje.a(paramaljd.jdField_a_of_type_JavaLangString, paramaljd.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramaljd.jdField_a_of_type_JavaLangObject);
          }
          return true;
        }
        finally {}
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramaljd.jdField_b_of_type_JavaLangString);
      for (;;)
      {
        try
        {
          localObject1 = (attv)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(179);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool = ((attx)localObject1).a(paramaljd.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ResDownloadManager", 2, "downloading by precover=" + bool + ", md5=" + paramaljd.jdField_b_of_type_JavaLangString);
            }
            if (bool) {
              ((attx)localObject1).a(paramaljd.jdField_b_of_type_JavaLangString);
            }
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ResDownloadManager", 2, "download send request ,url = " + paramaljd.jdField_a_of_type_JavaLangString);
        }
        if (paramaljd.jdField_a_of_type_Int == 4) {
          ljg.a(paramaljd.jdField_b_of_type_JavaLangString);
        }
        localObject1 = new axro();
        ((axro)localObject1).jdField_a_of_type_Axrt = this;
        ((axro)localObject1).jdField_a_of_type_JavaLangString = paramaljd.jdField_a_of_type_JavaLangString;
        ((axro)localObject1).jdField_a_of_type_Int = 0;
        ((axro)localObject1).c = ((alja)localObject2).b(paramaljd);
        ((axro)localObject1).e = 1;
        ((axro)localObject1).a(paramaljd);
        ((axro)localObject1).jdField_a_of_type_Axrs = jdField_a_of_type_Axrs;
        this.jdField_a_of_type_Axrr.a((axsp)localObject1);
        return true;
        localObject1 = ((attv)localObject1).a();
      }
      label633:
      i = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, alje paramalje)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    aljd localaljd = new aljd();
    localaljd.jdField_a_of_type_Int = paramInt;
    localaljd.jdField_a_of_type_JavaLangString = paramString1;
    localaljd.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localaljd.c = str;
    localaljd.jdField_a_of_type_Boolean = paramBoolean;
    localaljd.jdField_a_of_type_JavaLangObject = paramObject;
    localaljd.jdField_a_of_type_Alje = paramalje;
    if (TextUtils.isEmpty(paramString2)) {
      localaljd.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localaljd.jdField_b_of_type_Boolean = false;; localaljd.jdField_b_of_type_Boolean = true)
    {
      return a(localaljd);
      localaljd.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(alje paramalje)
  {
    if (paramalje == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramalje);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(axsq paramaxsq)
  {
    boolean bool1;
    axro localaxro;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    Object localObject3;
    boolean bool2;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localaxro = (axro)paramaxsq.jdField_a_of_type_Axsp;
      localObject1 = new File(localaxro.c);
      localObject2 = localaxro.a();
      i = paramaxsq.jdField_b_of_type_Int;
      if (paramaxsq.jdField_a_of_type_JavaLangString != null) {
        break label446;
      }
      str = "0";
      j = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof aljd))) {
        break label603;
      }
      localObject2 = (aljd)localObject2;
      localObject3 = this.jdField_a_of_type_Aliy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((aljd)localObject2).jdField_a_of_type_Int);
      localObject4 = ((aljd)localObject2).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label455;
      }
      if (!((aljd)localObject2).jdField_b_of_type_Boolean) {
        break label1193;
      }
      if (((alja)localObject3).b((aljd)localObject2)) {
        break label1188;
      }
      j = -6103066;
      ((File)localObject1).delete();
      bool1 = false;
      i = j;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 1, "onResp.md5 verify suc|" + bool1 + "|" + localObject2);
        bool2 = bool1;
        i = j;
      }
      label198:
      localObject3 = ((alja)localObject3).a((aljd)localObject2);
      if ((!bool2) || (!((aljd)localObject2).jdField_a_of_type_Boolean)) {
        break label1179;
      }
      bace.a((String)localObject3);
      a((aljd)localObject2);
      localObject3 = new File((String)localObject3);
      bool2 = ((File)localObject3).exists();
      if (!bool2) {
        i = 2;
      }
      j = i;
      localObject1 = localObject3;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 2, "onResp.unCompressZipFile suc|" + bool2 + "|" + localObject2);
        bool1 = bool2;
        localObject1 = localObject3;
        j = i;
      }
      label323:
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
      }
      i = j;
      j = 0;
      label353:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp url:" + localaxro.jdField_a_of_type_JavaLangString + " result:" + paramaxsq.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (j == 0) {
        break label655;
      }
      label439:
      return;
      bool1 = false;
      break;
      label446:
      str = paramaxsq.jdField_a_of_type_JavaLangString;
      break label57;
      label455:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + paramaxsq.jdField_a_of_type_Int + "|errCode:" + i + "|errDesc:" + str + "|params:" + localObject2);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((aljd)localObject2).jdField_b_of_type_Int > 0)
      {
        ((aljd)localObject2).jdField_b_of_type_Int -= 1;
        a((aljd)localObject2);
        j = 1;
        break label353;
      }
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
      }
      j = 0;
      break label353;
      label603:
      ((File)localObject1).delete();
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp userdata|" + localObject2);
      }
      localObject3 = localObject1;
      localObject2 = null;
      localObject1 = null;
    }
    label655:
    Object localObject4 = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          alje localalje = (alje)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localalje == null) || (localObject1 == null)) {
            break label1200;
          }
          localalje.a(localaxro.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aljd)localObject1).jdField_a_of_type_JavaLangObject);
          break label1200;
        }
        if ((localObject1 != null) && (((aljd)localObject1).jdField_a_of_type_Alje != null)) {
          ((aljd)localObject1).jdField_a_of_type_Alje.a(localaxro.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aljd)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label439;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + paramaxsq.c);
        if ((paramaxsq.jdField_a_of_type_JavaUtilHashMap != null) && (paramaxsq.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", atub.b(((aljd)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((aljd)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((aljd)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((aljd)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((aljd)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((aljd)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((aljd)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", paramaxsq.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          awrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
          return;
        }
      }
      finally {}
      localObject2 = "0";
      continue;
      label1179:
      bool1 = bool2;
      j = i;
      break label323;
      label1188:
      j = i;
      break;
      label1193:
      bool2 = bool1;
      break label198;
      label1200:
      j += 1;
    }
  }
  
  public void onUpdateProgeress(axsp arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof axro))) {}
    String str1;
    do
    {
      return;
      str1 = ((axro)???).jdField_a_of_type_JavaLangString;
      ??? = ???.a();
    } while ((??? == null) || (!(??? instanceof aljd)));
    aljd localaljd = (aljd)???;
    String str2 = localaljd.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localaljd);
    }
    if (localaljd.jdField_a_of_type_Boolean) {}
    for (int i = 90;; i = 100)
    {
      if (paramLong2 > 0L) {
        i = (int)(i * paramLong1 / paramLong2);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            alje localalje = (alje)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localalje == null) {
              break label235;
            }
            localalje.a(str1, str2, i);
            break label235;
          }
          if (localaljd.jdField_a_of_type_Alje == null) {
            break;
          }
          localaljd.jdField_a_of_type_Alje.a(str1, str2, i);
          return;
        }
        i = 0;
        continue;
        label235:
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aljb
 * JD-Core Version:    0.7.0.1
 */
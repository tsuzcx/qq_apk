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

public class alxp
  implements aysa, Manager
{
  static ayrz jdField_a_of_type_Ayrz = new alxq();
  alxm jdField_a_of_type_Alxm;
  private ayry jdField_a_of_type_Ayry;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<alxs> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public alxp(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ayry = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Alxm = new alxm();
  }
  
  private String a(alxr paramalxr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramalxr);
    }
    String str = this.jdField_a_of_type_Alxm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxr.jdField_a_of_type_Int).a(paramalxr);
    if (!bbdj.a(str)) {}
    try
    {
      bbdj.a(this.jdField_a_of_type_Alxm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxr.jdField_a_of_type_Int).b(paramalxr), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      bbdj.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramalxr + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(alxr paramalxr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramalxr);
    }
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this;
    localayrv.jdField_a_of_type_JavaLangString = paramalxr.jdField_a_of_type_JavaLangString;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = this.jdField_a_of_type_Alxm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxr.jdField_a_of_type_Int).b(paramalxr);
    localayrv.e = 1;
    localayrv.a(paramalxr);
    localayrv.jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
    this.jdField_a_of_type_Ayry.a(localayrv);
  }
  
  private boolean b(alxr paramalxr)
  {
    return this.jdField_a_of_type_Alxm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxr.jdField_a_of_type_Int).a(paramalxr);
  }
  
  public void a(alxs paramalxs)
  {
    if (paramalxs == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramalxs)) {
        this.jdField_a_of_type_JavaUtilList.add(paramalxs);
      }
      return;
    }
  }
  
  public boolean a(alxr paramalxr)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramalxr);
    }
    Object localObject2 = this.jdField_a_of_type_Alxm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxr.jdField_a_of_type_Int);
    if ((!TextUtils.isEmpty(paramalxr.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramalxr.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + paramalxr);
      }
      return false;
    }
    Object localObject1;
    if (!b(paramalxr))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + paramalxr);
      }
      if (paramalxr.jdField_a_of_type_Boolean)
      {
        localObject1 = ((alxo)localObject2).a(paramalxr);
        if ((bbdj.a((String)localObject1)) && (!((alxo)localObject2).a(paramalxr, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + paramalxr);
          }
          bbdj.a((String)localObject1);
        }
        localObject1 = a(paramalxr);
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
              alxs localalxs = (alxs)this.jdField_a_of_type_JavaUtilList.get(j);
              if (localalxs != null) {
                localalxs.a(paramalxr.jdField_a_of_type_JavaLangString, paramalxr.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramalxr.jdField_a_of_type_JavaLangObject);
              }
              j += 1;
              continue;
              localObject1 = ((alxo)localObject2).b(paramalxr);
              break;
            }
          }
          if (paramalxr.jdField_a_of_type_Alxs != null) {
            paramalxr.jdField_a_of_type_Alxs.a(paramalxr.jdField_a_of_type_JavaLangString, paramalxr.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramalxr.jdField_a_of_type_JavaLangObject);
          }
          return true;
        }
        finally {}
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramalxr.jdField_b_of_type_JavaLangString);
      for (;;)
      {
        try
        {
          localObject1 = (aurt)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(179);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool = ((aurv)localObject1).a(paramalxr.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ResDownloadManager", 2, "downloading by precover=" + bool + ", md5=" + paramalxr.jdField_b_of_type_JavaLangString);
            }
            if (bool) {
              ((aurv)localObject1).a(paramalxr.jdField_b_of_type_JavaLangString);
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
          QLog.i("ResDownloadManager", 2, "download send request ,url = " + paramalxr.jdField_a_of_type_JavaLangString);
        }
        if (paramalxr.jdField_a_of_type_Int == 4) {
          ltx.a(paramalxr.jdField_b_of_type_JavaLangString);
        }
        localObject1 = new ayrv();
        ((ayrv)localObject1).jdField_a_of_type_Aysa = this;
        ((ayrv)localObject1).jdField_a_of_type_JavaLangString = paramalxr.jdField_a_of_type_JavaLangString;
        ((ayrv)localObject1).jdField_a_of_type_Int = 0;
        ((ayrv)localObject1).c = ((alxo)localObject2).b(paramalxr);
        ((ayrv)localObject1).e = 1;
        ((ayrv)localObject1).a(paramalxr);
        ((ayrv)localObject1).jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
        this.jdField_a_of_type_Ayry.a((aysw)localObject1);
        return true;
        localObject1 = ((aurt)localObject1).a();
      }
      label633:
      i = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, alxs paramalxs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    alxr localalxr = new alxr();
    localalxr.jdField_a_of_type_Int = paramInt;
    localalxr.jdField_a_of_type_JavaLangString = paramString1;
    localalxr.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localalxr.c = str;
    localalxr.jdField_a_of_type_Boolean = paramBoolean;
    localalxr.jdField_a_of_type_JavaLangObject = paramObject;
    localalxr.jdField_a_of_type_Alxs = paramalxs;
    if (TextUtils.isEmpty(paramString2)) {
      localalxr.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localalxr.jdField_b_of_type_Boolean = false;; localalxr.jdField_b_of_type_Boolean = true)
    {
      return a(localalxr);
      localalxr.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(alxs paramalxs)
  {
    if (paramalxs == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramalxs);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(aysx paramaysx)
  {
    boolean bool1;
    ayrv localayrv;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    Object localObject3;
    boolean bool2;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localayrv = (ayrv)paramaysx.jdField_a_of_type_Aysw;
      localObject1 = new File(localayrv.c);
      localObject2 = localayrv.a();
      i = paramaysx.jdField_b_of_type_Int;
      if (paramaysx.jdField_a_of_type_JavaLangString != null) {
        break label446;
      }
      str = "0";
      j = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof alxr))) {
        break label603;
      }
      localObject2 = (alxr)localObject2;
      localObject3 = this.jdField_a_of_type_Alxm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((alxr)localObject2).jdField_a_of_type_Int);
      localObject4 = ((alxr)localObject2).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label455;
      }
      if (!((alxr)localObject2).jdField_b_of_type_Boolean) {
        break label1193;
      }
      if (((alxo)localObject3).b((alxr)localObject2)) {
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
      localObject3 = ((alxo)localObject3).a((alxr)localObject2);
      if ((!bool2) || (!((alxr)localObject2).jdField_a_of_type_Boolean)) {
        break label1179;
      }
      bbdj.a((String)localObject3);
      a((alxr)localObject2);
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
        QLog.i("ResDownloadManager", 2, "onResp url:" + localayrv.jdField_a_of_type_JavaLangString + " result:" + paramaysx.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (j == 0) {
        break label655;
      }
      label439:
      return;
      bool1 = false;
      break;
      label446:
      str = paramaysx.jdField_a_of_type_JavaLangString;
      break label57;
      label455:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + paramaysx.jdField_a_of_type_Int + "|errCode:" + i + "|errDesc:" + str + "|params:" + localObject2);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((alxr)localObject2).jdField_b_of_type_Int > 0)
      {
        ((alxr)localObject2).jdField_b_of_type_Int -= 1;
        a((alxr)localObject2);
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
          alxs localalxs = (alxs)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localalxs == null) || (localObject1 == null)) {
            break label1200;
          }
          localalxs.a(localayrv.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((alxr)localObject1).jdField_a_of_type_JavaLangObject);
          break label1200;
        }
        if ((localObject1 != null) && (((alxr)localObject1).jdField_a_of_type_Alxs != null)) {
          ((alxr)localObject1).jdField_a_of_type_Alxs.a(localayrv.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((alxr)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label439;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + paramaysx.c);
        if ((paramaysx.jdField_a_of_type_JavaUtilHashMap != null) && (paramaysx.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", aurz.b(((alxr)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((alxr)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((alxr)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((alxr)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((alxr)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((alxr)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((alxr)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", paramaysx.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          axrl.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
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
  
  public void onUpdateProgeress(aysw arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof ayrv))) {}
    String str1;
    do
    {
      return;
      str1 = ((ayrv)???).jdField_a_of_type_JavaLangString;
      ??? = ???.a();
    } while ((??? == null) || (!(??? instanceof alxr)));
    alxr localalxr = (alxr)???;
    String str2 = localalxr.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localalxr);
    }
    if (localalxr.jdField_a_of_type_Boolean) {}
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
            alxs localalxs = (alxs)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localalxs == null) {
              break label235;
            }
            localalxs.a(str1, str2, i);
            break label235;
          }
          if (localalxr.jdField_a_of_type_Alxs == null) {
            break;
          }
          localalxr.jdField_a_of_type_Alxs.a(str1, str2, i);
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
 * Qualified Name:     alxp
 * JD-Core Version:    0.7.0.1
 */
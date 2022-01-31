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

public class alxo
  implements aysc, Manager
{
  static aysb jdField_a_of_type_Aysb = new alxp();
  alxl jdField_a_of_type_Alxl;
  private aysa jdField_a_of_type_Aysa;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<alxr> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public alxo(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aysa = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Alxl = new alxl();
  }
  
  private String a(alxq paramalxq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramalxq);
    }
    String str = this.jdField_a_of_type_Alxl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxq.jdField_a_of_type_Int).a(paramalxq);
    if (!bbdx.a(str)) {}
    try
    {
      bbdx.a(this.jdField_a_of_type_Alxl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxq.jdField_a_of_type_Int).b(paramalxq), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      bbdx.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramalxq + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(alxq paramalxq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramalxq);
    }
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = this;
    localayrx.jdField_a_of_type_JavaLangString = paramalxq.jdField_a_of_type_JavaLangString;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.c = this.jdField_a_of_type_Alxl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxq.jdField_a_of_type_Int).b(paramalxq);
    localayrx.e = 1;
    localayrx.a(paramalxq);
    localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
    this.jdField_a_of_type_Aysa.a(localayrx);
  }
  
  private boolean b(alxq paramalxq)
  {
    return this.jdField_a_of_type_Alxl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxq.jdField_a_of_type_Int).a(paramalxq);
  }
  
  public void a(alxr paramalxr)
  {
    if (paramalxr == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramalxr)) {
        this.jdField_a_of_type_JavaUtilList.add(paramalxr);
      }
      return;
    }
  }
  
  public boolean a(alxq paramalxq)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramalxq);
    }
    Object localObject2 = this.jdField_a_of_type_Alxl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramalxq.jdField_a_of_type_Int);
    if ((!TextUtils.isEmpty(paramalxq.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramalxq.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + paramalxq);
      }
      return false;
    }
    Object localObject1;
    if (!b(paramalxq))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + paramalxq);
      }
      if (paramalxq.jdField_a_of_type_Boolean)
      {
        localObject1 = ((alxn)localObject2).a(paramalxq);
        if ((bbdx.a((String)localObject1)) && (!((alxn)localObject2).a(paramalxq, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + paramalxq);
          }
          bbdx.a((String)localObject1);
        }
        localObject1 = a(paramalxq);
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
              alxr localalxr = (alxr)this.jdField_a_of_type_JavaUtilList.get(j);
              if (localalxr != null) {
                localalxr.a(paramalxq.jdField_a_of_type_JavaLangString, paramalxq.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramalxq.jdField_a_of_type_JavaLangObject);
              }
              j += 1;
              continue;
              localObject1 = ((alxn)localObject2).b(paramalxq);
              break;
            }
          }
          if (paramalxq.jdField_a_of_type_Alxr != null) {
            paramalxq.jdField_a_of_type_Alxr.a(paramalxq.jdField_a_of_type_JavaLangString, paramalxq.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramalxq.jdField_a_of_type_JavaLangObject);
          }
          return true;
        }
        finally {}
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramalxq.jdField_b_of_type_JavaLangString);
      for (;;)
      {
        try
        {
          localObject1 = (aurv)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(179);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool = ((aurx)localObject1).a(paramalxq.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ResDownloadManager", 2, "downloading by precover=" + bool + ", md5=" + paramalxq.jdField_b_of_type_JavaLangString);
            }
            if (bool) {
              ((aurx)localObject1).a(paramalxq.jdField_b_of_type_JavaLangString);
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
          QLog.i("ResDownloadManager", 2, "download send request ,url = " + paramalxq.jdField_a_of_type_JavaLangString);
        }
        if (paramalxq.jdField_a_of_type_Int == 4) {
          lts.a(paramalxq.jdField_b_of_type_JavaLangString);
        }
        localObject1 = new ayrx();
        ((ayrx)localObject1).jdField_a_of_type_Aysc = this;
        ((ayrx)localObject1).jdField_a_of_type_JavaLangString = paramalxq.jdField_a_of_type_JavaLangString;
        ((ayrx)localObject1).jdField_a_of_type_Int = 0;
        ((ayrx)localObject1).c = ((alxn)localObject2).b(paramalxq);
        ((ayrx)localObject1).e = 1;
        ((ayrx)localObject1).a(paramalxq);
        ((ayrx)localObject1).jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
        this.jdField_a_of_type_Aysa.a((aysy)localObject1);
        return true;
        localObject1 = ((aurv)localObject1).a();
      }
      label633:
      i = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, alxr paramalxr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    alxq localalxq = new alxq();
    localalxq.jdField_a_of_type_Int = paramInt;
    localalxq.jdField_a_of_type_JavaLangString = paramString1;
    localalxq.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localalxq.c = str;
    localalxq.jdField_a_of_type_Boolean = paramBoolean;
    localalxq.jdField_a_of_type_JavaLangObject = paramObject;
    localalxq.jdField_a_of_type_Alxr = paramalxr;
    if (TextUtils.isEmpty(paramString2)) {
      localalxq.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localalxq.jdField_b_of_type_Boolean = false;; localalxq.jdField_b_of_type_Boolean = true)
    {
      return a(localalxq);
      localalxq.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(alxr paramalxr)
  {
    if (paramalxr == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramalxr);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(aysz paramaysz)
  {
    boolean bool1;
    ayrx localayrx;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    Object localObject3;
    boolean bool2;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localayrx = (ayrx)paramaysz.jdField_a_of_type_Aysy;
      localObject1 = new File(localayrx.c);
      localObject2 = localayrx.a();
      i = paramaysz.jdField_b_of_type_Int;
      if (paramaysz.jdField_a_of_type_JavaLangString != null) {
        break label446;
      }
      str = "0";
      j = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof alxq))) {
        break label603;
      }
      localObject2 = (alxq)localObject2;
      localObject3 = this.jdField_a_of_type_Alxl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((alxq)localObject2).jdField_a_of_type_Int);
      localObject4 = ((alxq)localObject2).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label455;
      }
      if (!((alxq)localObject2).jdField_b_of_type_Boolean) {
        break label1193;
      }
      if (((alxn)localObject3).b((alxq)localObject2)) {
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
      localObject3 = ((alxn)localObject3).a((alxq)localObject2);
      if ((!bool2) || (!((alxq)localObject2).jdField_a_of_type_Boolean)) {
        break label1179;
      }
      bbdx.a((String)localObject3);
      a((alxq)localObject2);
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
        QLog.i("ResDownloadManager", 2, "onResp url:" + localayrx.jdField_a_of_type_JavaLangString + " result:" + paramaysz.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (j == 0) {
        break label655;
      }
      label439:
      return;
      bool1 = false;
      break;
      label446:
      str = paramaysz.jdField_a_of_type_JavaLangString;
      break label57;
      label455:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + paramaysz.jdField_a_of_type_Int + "|errCode:" + i + "|errDesc:" + str + "|params:" + localObject2);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((alxq)localObject2).jdField_b_of_type_Int > 0)
      {
        ((alxq)localObject2).jdField_b_of_type_Int -= 1;
        a((alxq)localObject2);
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
          alxr localalxr = (alxr)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localalxr == null) || (localObject1 == null)) {
            break label1200;
          }
          localalxr.a(localayrx.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((alxq)localObject1).jdField_a_of_type_JavaLangObject);
          break label1200;
        }
        if ((localObject1 != null) && (((alxq)localObject1).jdField_a_of_type_Alxr != null)) {
          ((alxq)localObject1).jdField_a_of_type_Alxr.a(localayrx.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((alxq)localObject1).jdField_a_of_type_JavaLangObject);
        }
        if ((bool1) || (localObject1 == null)) {
          break label439;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + paramaysz.c);
        if ((paramaysz.jdField_a_of_type_JavaUtilHashMap != null) && (paramaysz.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)paramaysz.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", ausb.b(((alxq)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((alxq)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((alxq)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((alxq)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((alxq)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((alxq)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((alxq)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", paramaysz.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          axrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
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
  
  public void onUpdateProgeress(aysy arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof ayrx))) {}
    String str1;
    do
    {
      return;
      str1 = ((ayrx)???).jdField_a_of_type_JavaLangString;
      ??? = ???.a();
    } while ((??? == null) || (!(??? instanceof alxq)));
    alxq localalxq = (alxq)???;
    String str2 = localalxq.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + localalxq);
    }
    if (localalxq.jdField_a_of_type_Boolean) {}
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
            alxr localalxr = (alxr)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localalxr == null) {
              break label235;
            }
            localalxr.a(str1, str2, i);
            break label235;
          }
          if (localalxq.jdField_a_of_type_Alxr == null) {
            break;
          }
          localalxq.jdField_a_of_type_Alxr.a(str1, str2, i);
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
 * Qualified Name:     alxo
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class aiub
{
  public static void a(AppInterface paramAppInterface, String paramString1, aiud paramaiud, List<aiua> paramList, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes");
    }
    if (paramAppInterface == null) {}
    label191:
    do
    {
      aiua localaiua;
      do
      {
        ArrayList localArrayList;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localaiua = null;
              if (!TextUtils.isEmpty(paramString2))
              {
                localaiua = new aiua();
                localaiua.jdField_a_of_type_JavaLangString = paramString2;
                localaiua.jdField_a_of_type_Int = 6;
                localArrayList.add(localaiua);
              }
              if (paramList != null) {
                localArrayList.addAll(paramList);
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
              QLog.e("rscContent_CmShowRscDownloader", 1, "downloadApolloRes tasks is empty ");
            } while (paramaiud == null);
            paramaiud.a(false, paramString1, paramList, "");
            return;
            paramAppInterface = (bbww)paramAppInterface.getManager(47);
          } while (paramAppInterface == null);
          paramAppInterface = paramAppInterface.a(3);
        } while (paramAppInterface == null);
        paramString2 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        int k = localArrayList.size();
        int i = 0;
        if (i < k)
        {
          Object localObject = (aiua)localArrayList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscDownloader", 2, "IdolRscItem:" + localObject);
          }
          int m = ((aiua)localObject).jdField_a_of_type_Int;
          int n = ((aiua)localObject).b;
          String str = ((aiua)localObject).a();
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes url is empty resType->" + m + " id->" + n);
            }
            paramString2.decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break label191;
            File localFile = new File(((aiua)localObject).b());
            if (!paramBoolean)
            {
              if ((localFile.exists()) && (((aiua)localObject).b())) {}
              for (int j = 1;; j = 0)
              {
                if (j == 0) {
                  break label430;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscDownloader", 2, "file exsit resType->" + m + " id->" + n);
                }
                paramString2.decrementAndGet();
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscDownloader", 2, "file not exsit resType->" + m + " id->" + n);
              }
            }
            if (!bbfj.g(BaseApplicationImpl.getContext()))
            {
              if (paramaiud != null) {
                paramaiud.a(false, paramString1, paramList, "");
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localFile.getParentFile().mkdirs();
            localObject = new bbwu(str, localFile);
            ((bbwu)localObject).p = true;
            ((bbwu)localObject).n = true;
            ((bbwu)localObject).f = "apollo_res";
            ((bbwu)localObject).b = 1;
            ((bbwu)localObject).q = true;
            ((bbwu)localObject).r = true;
            paramAppInterface.a((bbwu)localObject, new aiuc(str, localFile, localAtomicInteger2, m, n, localAtomicInteger1, paramString2, paramaiud, localaiua, paramString1, paramList), null);
          }
        }
      } while (paramString2.get() != 0);
      if (paramaiud != null)
      {
        paramAppInterface = "";
        if (localaiua != null) {
          paramAppInterface = localaiua.c();
        }
        paramaiud.a(true, paramString1, paramList, paramAppInterface);
      }
    } while (!QLog.isColorLevel());
    label430:
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString1 + ", all cnt: " + paramString2.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiub
 * JD-Core Version:    0.7.0.1
 */
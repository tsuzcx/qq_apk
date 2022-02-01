import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class alpw
{
  public static void a(AppInterface paramAppInterface, String paramString1, alpy paramalpy, List<alpv> paramList, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes");
    }
    if (paramAppInterface == null) {}
    label191:
    do
    {
      alpv localalpv;
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
              localalpv = null;
              if (!TextUtils.isEmpty(paramString2))
              {
                localalpv = new alpv();
                localalpv.jdField_a_of_type_JavaLangString = paramString2;
                localalpv.jdField_a_of_type_Int = 6;
                localArrayList.add(localalpv);
              }
              if (paramList != null) {
                localArrayList.addAll(paramList);
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
              QLog.e("rscContent_CmShowRscDownloader", 1, "downloadApolloRes tasks is empty ");
            } while (paramalpy == null);
            paramalpy.a(false, paramString1, paramList, "");
            return;
            paramAppInterface = (bgog)paramAppInterface.getManager(47);
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
          Object localObject = (alpv)localArrayList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscDownloader", 2, "IdolRscItem:" + localObject);
          }
          int m = ((alpv)localObject).jdField_a_of_type_Int;
          int n = ((alpv)localObject).b;
          String str = ((alpv)localObject).a();
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
            File localFile = new File(((alpv)localObject).b());
            if (!paramBoolean)
            {
              if ((localFile.exists()) && (((alpv)localObject).b())) {}
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
            if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
            {
              if (paramalpy != null) {
                paramalpy.a(false, paramString1, paramList, "");
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localFile.getParentFile().mkdirs();
            localObject = new bgoe(str, localFile);
            ((bgoe)localObject).p = true;
            ((bgoe)localObject).n = true;
            ((bgoe)localObject).f = "apollo_res";
            ((bgoe)localObject).b = 1;
            ((bgoe)localObject).q = true;
            ((bgoe)localObject).r = true;
            paramAppInterface.a((bgoe)localObject, new alpx(str, localFile, localAtomicInteger2, m, n, localAtomicInteger1, paramString2, paramalpy, localalpv, paramString1, paramList), null);
          }
        }
      } while (paramString2.get() != 0);
      if (paramalpy != null)
      {
        paramAppInterface = "";
        if (localalpv != null) {
          paramAppInterface = localalpv.c();
        }
        paramalpy.a(true, paramString1, paramList, paramAppInterface);
      }
    } while (!QLog.isColorLevel());
    label430:
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString1 + ", all cnt: " + paramString2.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpw
 * JD-Core Version:    0.7.0.1
 */
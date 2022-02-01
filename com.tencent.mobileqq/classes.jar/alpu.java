import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.CmShowRscCacheManager.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import org.json.JSONObject;

public class alpu
{
  private static alpu jdField_a_of_type_Alpu;
  private final SparseArray<alpv> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private alpu()
  {
    a();
  }
  
  public static alpu a()
  {
    try
    {
      if (jdField_a_of_type_Alpu == null) {
        jdField_a_of_type_Alpu = new alpu();
      }
      alpu localalpu = jdField_a_of_type_Alpu;
      return localalpu;
    }
    finally {}
  }
  
  private void b()
  {
    Object localObject1 = new alqc();
    ((alqc)localObject1).jdField_a_of_type_Int = 100;
    ((alqc)localObject1).jdField_a_of_type_Long = 1L;
    ((alqc)localObject1).jdField_a_of_type_JavaLangString = "all_room3D";
    localObject1 = ((alqc)localObject1).b() + "all_room3D.json";
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      try
      {
        localObject2 = new JSONObject(FileUtils.readFileToString((File)localObject2)).optJSONObject("data");
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("downloadUrl");
          localObject2 = ((JSONObject)localObject2).optJSONObject("list");
          Iterator localIterator = ((JSONObject)localObject2).keys();
          while (localIterator.hasNext())
          {
            Object localObject3 = (String)localIterator.next();
            int i = ApolloUtil.b((String)localObject3);
            if (i > -2147483648)
            {
              localObject3 = ((JSONObject)localObject2).optJSONObject((String)localObject3);
              if (localObject3 != null)
              {
                localObject3 = ((JSONObject)localObject3).optString("source_qq");
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  alpv localalpv = new alpv();
                  localalpv.c = "all_room3D.json";
                  localalpv.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localalpv.jdField_b_of_type_Int = i;
                  localalpv.jdField_a_of_type_Int = 8;
                  localalpv.jdField_a_of_type_JavaLangString = ((String)localObject3);
                  this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localalpv);
                }
              }
            }
          }
        }
        ApolloUtil.b("小窝json不存在");
      }
      catch (Exception localException)
      {
        QLog.e("rscContent_CmShowRscCacheManager", 1, "initRoomJson e:", localException);
        if (QLog.isColorLevel()) {
          QLog.d("rscContent_CmShowRscCacheManager", 2, "initRoomJson mRoomRscMap:" + this.jdField_a_of_type_AndroidUtilSparseArray);
        }
        return;
      }
    }
    QLog.e("rscContent_CmShowRscCacheManager", 1, "initRoomJson file is no exsit path:" + localException);
  }
  
  public alpv a(int paramInt1, int paramInt2)
  {
    alpv localalpv = null;
    if (paramInt1 == 8) {
      localalpv = (alpv)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    }
    if (localalpv == null) {
      ApolloUtil.b("未获取资源getRscItem type:" + paramInt1 + " id:" + paramInt2);
    }
    return localalpv;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscCacheManager", 2, "onRoomZipUpdated");
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    ThreadManager.executeOnSubThread(new CmShowRscCacheManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpu
 * JD-Core Version:    0.7.0.1
 */
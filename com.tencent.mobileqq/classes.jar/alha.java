import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class alha
{
  static alha a;
  public int a;
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public static alha a()
  {
    try
    {
      if (jdField_a_of_type_Alha == null) {
        jdField_a_of_type_Alha = new alha();
      }
      return jdField_a_of_type_Alha;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARFaceInit,initCost  = " + paramLong + ",devType = " + ARMapTracer.a());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    axrn.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceInit", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARTrackStablity,duration  = " + paramLong + ",count = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    localHashMap.put("recoverCount", String.valueOf(paramInt));
    axrn.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceTrackStability", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void a(algs paramalgs, algp paramalgp)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorcode_mq", String.valueOf(paramalgp.jdField_a_of_type_Int));
    localHashMap.put("errorcode_yt", String.valueOf(paramalgp.b));
    if ((paramalgp.jdField_a_of_type_Int == 0) && (paramalgp.b == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      int i = 0;
      int m = 0;
      int j = 0;
      int k = 0;
      if (bool)
      {
        i = m;
        if (paramalgs.a.a != null) {
          i = paramalgs.a.a.length;
        }
        j = k;
        if (paramalgp.jdField_a_of_type_JavaUtilArrayList != null) {
          j = paramalgp.jdField_a_of_type_JavaUtilArrayList.size();
        }
        localHashMap.put("send_person_count", String.valueOf(i));
        localHashMap.put("receive_star_count", String.valueOf(j));
      }
      long l = System.currentTimeMillis() - paramalgs.c;
      localHashMap.put("upload_cost", String.valueOf(l));
      axrn.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceCloudResult", bool, 0L, 0L, localHashMap, "", true);
      if (QLog.isColorLevel()) {
        QLog.d("ARFaceDataCollector", 2, "reportARFaceCloudResult,sendPersonCount  = " + i + ",starCount = " + j + ",uploadCost = " + l);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARSoLoadResult,libName  = " + paramString + ",result = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("libName", paramString);
    localHashMap.put("loadResult", String.valueOf(paramInt));
    axrn.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceSoLoadResult", true, 0L, 0L, localHashMap, "", true);
  }
  
  public static void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARFaceDetect,cost  = " + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    axrn.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceDetect", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void c()
  {
    alha localalha = a();
    localalha.b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    localHashMap.put("ppTotalCost", String.valueOf(localalha.b));
    localHashMap.put("ppFaceDectectCost", String.valueOf(localalha.c));
    localHashMap.put("upload_cost", String.valueOf(localalha.d));
    localHashMap.put("ppExtractCost", String.valueOf(localalha.e));
    localHashMap.put("ppExtractFaceCount", String.valueOf(localalha.jdField_a_of_type_Int));
    localHashMap.put("firstDrawUICost", String.valueOf(localalha.f));
    long l2 = localalha.b;
    if (localalha.e > localalha.d) {}
    for (long l1 = localalha.e;; l1 = localalha.d)
    {
      localHashMap.put("totalCost", String.valueOf(l1 + l2 + localalha.f));
      axrn.a(BaseApplicationImpl.getApplication()).a(null, "actFaceStepDuration", true, 0L, 0L, localHashMap, "", true);
      localalha.a();
      return;
    }
  }
  
  public static void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARExtracFaceFeatrue,cost  = " + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    axrn.a(BaseApplicationImpl.getApplication()).a(null, "actARExtractFaceFeatrue", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
  }
  
  public void b()
  {
    long l2 = this.b;
    if (this.e > this.d) {}
    for (long l1 = this.e;; l1 = this.d)
    {
      long l3 = this.f;
      long l4 = System.currentTimeMillis();
      long l5 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("ARFaceDataCollector", 2, "printStepDuration preprocessTotalCost  = " + this.b + ",preprocessFaceDetectCost = " + this.c + ",picUploadCost = " + this.d + ",preprocessFeatureExtrctCost = " + this.e + ",preprocessFaceCount = " + this.jdField_a_of_type_Int + ",firstDrawUICost = " + this.f + ",totalCost = " + (l1 + l2 + l3) + ",starTime = " + this.jdField_a_of_type_Long + ",realCost = " + (l4 - l5));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alha
 * JD-Core Version:    0.7.0.1
 */
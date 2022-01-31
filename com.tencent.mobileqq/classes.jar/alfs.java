import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class alfs
  extends akup
{
  alfs(alfo paramalfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    alfo.f(this.a, false);
    if (alfo.a(this.a) != null) {
      alfo.a(this.a).removeMessages(2);
    }
    if (alfo.a(this.a)) {
      return;
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      paramInt = (int)(paramSosoLbsInfo.jdField_a_of_type_Double * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.jdField_b_of_type_Double * 1000000.0D);
      QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info. Lat_02 = " + paramSosoLbsInfo.jdField_a_of_type_Double + ", Lon_02 = " + paramSosoLbsInfo.jdField_b_of_type_Double + ", latitude = " + paramInt + ", longitude = " + i + ", altitude = " + paramSosoLbsInfo.e + ", accuracy = " + paramSosoLbsInfo.jdField_a_of_type_Float + ", name = " + paramSosoLbsInfo.jdField_a_of_type_JavaLangString + ", address = " + paramSosoLbsInfo.jdField_b_of_type_JavaLangString);
      paramSosoLbsInfo = algo.a(this.a.a.recognitions, alfo.a(this.a));
      alfo.a(this.a, paramSosoLbsInfo, paramInt, i);
      return;
    }
    QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info failed. errCode = " + paramInt);
    paramSosoLbsInfo = new alfw();
    paramSosoLbsInfo.a = 2;
    algo.a(this.a.a.recognitions, alfo.a(this.a), paramSosoLbsInfo);
    if (alfo.a(this.a) != null) {
      alfo.a(this.a).a(0, alfo.a(this.a));
    }
    alfo.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfs
 * JD-Core Version:    0.7.0.1
 */
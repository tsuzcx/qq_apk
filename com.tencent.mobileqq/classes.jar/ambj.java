import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

class ambj
  extends ampt
{
  ambj(ambh paramambh, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "onLocationFinish errCode: " + paramInt + ", info: " + paramSosoLbsInfo);
    }
    if (!bdin.d(BaseApplication.getContext())) {
      return;
    }
    if (paramInt != 0)
    {
      this.a.a(2L, null);
      return;
    }
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      double d3 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
      double d4 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      double d1 = paramSosoLbsInfo.a.e;
      int j = (int)paramSosoLbsInfo.a.jdField_a_of_type_Float;
      String str1 = paramSosoLbsInfo.a.m;
      String str2 = paramSosoLbsInfo.a.l;
      int k = paramSosoLbsInfo.a.jdField_a_of_type_Int;
      double d2 = paramSosoLbsInfo.a.jdField_a_of_type_Long;
      float f = paramSosoLbsInfo.a.jdField_b_of_type_Float;
      String str3 = paramSosoLbsInfo.a.f;
      paramInt = 0;
      try
      {
        int i = Integer.parseInt(str3);
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("RecommendTroopManagerImp", 1, "parse cityCode error");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendTroopManagerImp", 2, "onLocationFinish longitude=" + d3 + ", latitude=" + d4 + ", accuracy=" + j + ", verifyKey=" + str2 + ", source=" + str1 + ", fakeReason=" + k + ", speed=" + f + ", locationTime=" + d2);
      }
      d3 = Double.valueOf(paramSosoLbsInfo.a.jdField_a_of_type_Double * 1000000.0D).intValue();
      d4 = Double.valueOf(paramSosoLbsInfo.a.jdField_b_of_type_Double * 1000000.0D).intValue();
      paramSosoLbsInfo = new oidb_0x935.GPS();
      paramSosoLbsInfo.uint32_latitude.set((int)d3);
      paramSosoLbsInfo.uint32_longitude.set((int)d4);
      paramSosoLbsInfo.uint32_altitude.set((int)d1);
      paramSosoLbsInfo.uint32_accuracy.set(j);
      paramSosoLbsInfo.uint32_time.set((int)d2);
      paramSosoLbsInfo.uint32_cityid.set(paramInt);
      paramSosoLbsInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.3.5"));
      paramSosoLbsInfo.uint32_client.set(2);
      this.a.a(2L, paramSosoLbsInfo);
      return;
    }
    this.a.a(2L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambj
 * JD-Core Version:    0.7.0.1
 */
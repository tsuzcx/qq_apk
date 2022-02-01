import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class aebd
  extends SosoInterface.OnLocationListener
{
  public aebd(QQSettingMe paramQQSettingMe, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "onLocationFinish errCode:" + paramInt + ",info:" + paramSosoLbsInfo);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramInt = (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onLocationFinish latitude:" + paramInt + ",longtitude:" + i);
      }
      algk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, i, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebd
 * JD-Core Version:    0.7.0.1
 */
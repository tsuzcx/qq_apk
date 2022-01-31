import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public final class akka
  extends SosoInterface.OnLocationListener
{
  public akka(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, SharedPreferences paramSharedPreferences, long paramLong2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      d1 = paramSosoLbsInfo.a.a;
      d2 = paramSosoLbsInfo.a.b;
      paramSosoLbsInfo = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramSosoLbsInfo.putFloat("search_lbs_logitude", (float)d2);
      paramSosoLbsInfo.putFloat("search_lbs_latitude", (float)d1);
      paramSosoLbsInfo.putLong("search_lbs_timestamp", this.jdField_a_of_type_Long);
      paramSosoLbsInfo.commit();
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "Soso location info lat: " + d1 + ",lon:" + d2);
      }
    }
    while (!QLog.isColorLevel())
    {
      double d1;
      double d2;
      return;
    }
    QLog.i("SSOHttpUtils", 2, "Soso location failed error = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akka
 * JD-Core Version:    0.7.0.1
 */
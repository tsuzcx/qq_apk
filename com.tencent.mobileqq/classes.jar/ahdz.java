import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class ahdz
  extends SosoInterface.OnLocationListener
{
  ahdz(ahdy paramahdy, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
      return;
    }
    com.tencent.mobileqq.search.activity.UniteSearchActivity.a = paramSosoLbsInfo.a.a;
    com.tencent.mobileqq.search.activity.UniteSearchActivity.b = paramSosoLbsInfo.a.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahdz
 * JD-Core Version:    0.7.0.1
 */
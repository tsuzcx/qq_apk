import com.tencent.mobileqq.ar.aidl.IArSoCallback.Stub;
import com.tencent.mobileqq.ar.config.DownloadDependRes;
import com.tencent.qphone.base.util.QLog;

public class aapn
  extends IArSoCallback.Stub
{
  public aapn(DownloadDependRes paramDownloadDependRes) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WorldCupMgr", 2, "onArSoDownloadSuccess");
    }
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WorldCupMgr", 2, "onArSoDownloadProcess process=" + paramInt);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WorldCupMgr", 2, "onArSoDownloadFail");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapn
 * JD-Core Version:    0.7.0.1
 */
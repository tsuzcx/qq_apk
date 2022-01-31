import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimPluginLoadRunnable.IPluginLoadListener;
import cooperation.qqpim.QQPimPluginProxyService;

public class amai
  implements QQPimPluginLoadRunnable.IPluginLoadListener
{
  public amai(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.hasInstalled() ");
    }
    QQPimPluginProxyService.a(QQPimGetTipsInfoIPC.a(this.a));
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.downloading() " + paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.downloadError() " + paramInt);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.downloadBegin()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amai
 * JD-Core Version:    0.7.0.1
 */
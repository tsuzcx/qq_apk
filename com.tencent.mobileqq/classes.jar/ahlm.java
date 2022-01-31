import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class ahlm
  implements INetInfoHandler
{
  ahlm(ahll paramahll) {}
  
  public void onNetMobile2None()
  {
    boolean bool = true;
    synchronized (this.a)
    {
      if (ahll.a(this.a) == null) {
        return;
      }
      if (ahll.a(this.a).a == null) {
        return;
      }
    }
    ahll localahll2 = this.a;
    if (!ahll.a(this.a).c) {}
    for (;;)
    {
      localahll2.a(bool, true);
      return;
      bool = false;
    }
  }
  
  public void onNetMobile2Wifi(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahll.a(), 2, "onNetMobile2Wifi, AutoTranslate:  ");
    }
    synchronized (this.a)
    {
      if (ahll.a(this.a) == null) {
        return;
      }
      if (ahll.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    ahll.a(this.a);
  }
  
  public void onNetNone2Mobile(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahll.a(), 2, "onNetNone2Mobile ");
    }
    synchronized (this.a)
    {
      if (ahll.a(this.a) == null) {
        return;
      }
      if (ahll.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    ahll.a(this.a);
  }
  
  public void onNetNone2Wifi(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahll.a(), 2, "onNetNone2Wifi, AutoTranslate:  ");
    }
    synchronized (this.a)
    {
      if (ahll.a(this.a) == null) {
        return;
      }
      if (ahll.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    ahll.a(this.a);
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ahll.a(), 2, "onNetWifi2Mobile, need restore:  ");
    }
    synchronized (this.a)
    {
      if (ahll.a(this.a) == null) {
        return;
      }
      if (ahll.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    ahll.a(this.a);
  }
  
  public void onNetWifi2None()
  {
    boolean bool = true;
    synchronized (this.a)
    {
      if (ahll.a(this.a) == null) {
        return;
      }
      if (ahll.a(this.a).a == null) {
        return;
      }
    }
    ahll localahll2 = this.a;
    if (!ahll.a(this.a).c) {}
    for (;;)
    {
      localahll2.a(bool, true);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahlm
 * JD-Core Version:    0.7.0.1
 */
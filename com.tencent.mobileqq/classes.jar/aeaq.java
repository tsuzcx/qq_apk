import com.tencent.mobileqq.leba.QZoneEntryController;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;

public class aeaq
  extends QZoneObserver
{
  public aeaq(QZoneEntryController paramQZoneEntryController) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneObserver", 2, "on Get QZone Count:" + paramBoolean1 + ",HasNew:" + paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      if ((paramLong >>> 17 & 1L) != 0L) {
        QLog.d("UndealCount.QZoneObserver", 2, "Leba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
      }
      QLog.d("UndealCount.QZoneObserver", 2, "Leba onGetQZoneFeedCountFin type: " + paramLong + " and then call Leba freshEntryItemUI");
    }
    if (paramBoolean1)
    {
      this.a.a();
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver", 2, "onGetQZoneFeedCountFin. notifyData.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaq
 * JD-Core Version:    0.7.0.1
 */
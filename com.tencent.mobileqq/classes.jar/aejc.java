import com.tencent.mobileqq.leba.QZoneEntryController;
import com.tencent.qphone.base.util.QLog;

public class aejc
  implements Runnable
{
  public aejc(QZoneEntryController paramQZoneEntryController) {}
  
  public void run()
  {
    if (QZoneEntryController.a(this.a))
    {
      QZoneEntryController.a(this.a, 1);
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneEntryController", 2, "显示被动");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!QZoneEntryController.b(this.a)) {
            break;
          }
          QZoneEntryController.a(this.a, 2);
        } while (!QLog.isColorLevel());
        QLog.i("UndealCount.QZoneEntryController", 2, "显示主动");
        return;
        if (!QZoneEntryController.c(this.a)) {
          break;
        }
        QZoneEntryController.a(this.a, 3);
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneEntryController", 2, "显示访客");
      return;
      if (!QZoneEntryController.d(this.a)) {
        break;
      }
      QZoneEntryController.a(this.a, 4);
    } while (!QLog.isColorLevel());
    QLog.i("UndealCount.QZoneEntryController", 2, "显示运营内容");
    return;
    QZoneEntryController.a(this.a, 0);
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneEntryController", 2, "显示默认布局");
    }
    QZoneEntryController.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejc
 * JD-Core Version:    0.7.0.1
 */
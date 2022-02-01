import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

class aimp
  implements aqon
{
  aimp(aimn paramaimn) {}
  
  public void a(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aqoq.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note add." + paramColorNote);
    }
    aimn.a(this.a, paramColorNote, 1001);
    bdla.b(null, "dc00898", "", "", "0X800AE81", "0X800AE81", aimq.a(paramColorNote).reportType, 0, "", "", "", "");
  }
  
  public void b(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aqoq.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note del." + paramColorNote);
    }
    aimn.a(this.a, paramColorNote, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimp
 * JD-Core Version:    0.7.0.1
 */
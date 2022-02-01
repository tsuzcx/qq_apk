import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

class ahrq
  implements aplj
{
  ahrq(ahro paramahro) {}
  
  public void a(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aplm.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note add." + paramColorNote);
    }
    ahro.a(this.a, paramColorNote, 1001);
    bcef.b(null, "dc00898", "", "", "0X800AE81", "0X800AE81", ahrr.a(paramColorNote).reportType, 0, "", "", "", "");
  }
  
  public void b(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aplm.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note del." + paramColorNote);
    }
    ahro.a(this.a, paramColorNote, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrq
 * JD-Core Version:    0.7.0.1
 */
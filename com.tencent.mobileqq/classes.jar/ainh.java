import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

class ainh
  implements aqcx
{
  ainh(ainf paramainf) {}
  
  public void a(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aqda.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note add." + paramColorNote);
    }
    ainf.a(this.a, paramColorNote, 1001);
    bcst.b(null, "dc00898", "", "", "0X800AE81", "0X800AE81", aini.a(paramColorNote).reportType, 0, "", "", "", "");
  }
  
  public void b(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (!aqda.d(paramColorNote))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note del." + paramColorNote);
    }
    ainf.a(this.a, paramColorNote, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainh
 * JD-Core Version:    0.7.0.1
 */
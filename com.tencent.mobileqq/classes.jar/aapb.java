import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class aapb
  extends aapz
{
  public aapb(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(aapy paramaapy)
  {
    if ((paramaapy instanceof aapt)) {
      this.a.jdField_a_of_type_Aapi.a("", false, "download failed! msg = " + paramaapy.d);
    }
    do
    {
      return;
      if ((paramaapy instanceof aapl))
      {
        this.a.jdField_a_of_type_Aapi.a("", false, "combine failed! msg = " + paramaapy.d);
        return;
      }
    } while (!(paramaapy instanceof aapw));
    this.a.jdField_a_of_type_Aapi.a("", false, "sending failed! msg = " + paramaapy.d);
  }
  
  public void b(aapy paramaapy)
  {
    if ((paramaapy instanceof aapw))
    {
      paramaapy = paramaapy.a();
      this.a.jdField_a_of_type_Aapi.a(paramaapy.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapb
 * JD-Core Version:    0.7.0.1
 */
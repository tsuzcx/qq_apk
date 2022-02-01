import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class aafc
  extends aaga
{
  public aafc(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(aafz paramaafz)
  {
    if ((paramaafz instanceof aafu)) {
      this.a.jdField_a_of_type_Aafj.a("", false, "download failed! msg = " + paramaafz.d);
    }
    do
    {
      return;
      if ((paramaafz instanceof aafm))
      {
        this.a.jdField_a_of_type_Aafj.a("", false, "combine failed! msg = " + paramaafz.d);
        return;
      }
    } while (!(paramaafz instanceof aafx));
    this.a.jdField_a_of_type_Aafj.a("", false, "sending failed! msg = " + paramaafz.d);
  }
  
  public void b(aafz paramaafz)
  {
    if ((paramaafz instanceof aafx))
    {
      paramaafz = paramaafz.a();
      this.a.jdField_a_of_type_Aafj.a(paramaafz.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafc
 * JD-Core Version:    0.7.0.1
 */
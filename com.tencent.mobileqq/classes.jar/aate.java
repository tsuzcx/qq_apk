import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class aate
  extends aauc
{
  public aate(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(aaub paramaaub)
  {
    if ((paramaaub instanceof aatw)) {
      this.a.jdField_a_of_type_Aatl.a("", false, "download failed! msg = " + paramaaub.d);
    }
    do
    {
      return;
      if ((paramaaub instanceof aato))
      {
        this.a.jdField_a_of_type_Aatl.a("", false, "combine failed! msg = " + paramaaub.d);
        return;
      }
    } while (!(paramaaub instanceof aatz));
    this.a.jdField_a_of_type_Aatl.a("", false, "sending failed! msg = " + paramaaub.d);
  }
  
  public void b(aaub paramaaub)
  {
    if ((paramaaub instanceof aatz))
    {
      paramaaub = paramaaub.a();
      this.a.jdField_a_of_type_Aatl.a(paramaaub.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aate
 * JD-Core Version:    0.7.0.1
 */
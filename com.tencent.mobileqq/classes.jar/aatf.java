import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aatf
  extends aauc
{
  public aatf(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(aaub paramaaub)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramaaub.c);
        if ((paramaaub instanceof aatw))
        {
          this.a.jdField_a_of_type_Aatl.a("", false, "download failed! msg = " + paramaaub.d);
          return;
        }
      }
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
    aatn localaatn = paramaaub.a();
    if (((paramaaub instanceof aato)) || (localaatn.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramaaub.c);
      this.a.jdField_a_of_type_Aatl.a(localaatn.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatf
 * JD-Core Version:    0.7.0.1
 */
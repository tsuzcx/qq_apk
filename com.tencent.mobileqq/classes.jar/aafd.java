import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aafd
  extends aaga
{
  public aafd(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(aafz paramaafz)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramaafz.c);
        if ((paramaafz instanceof aafu))
        {
          this.a.jdField_a_of_type_Aafj.a("", false, "download failed! msg = " + paramaafz.d);
          return;
        }
      }
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
    aafl localaafl = paramaafz.a();
    if (((paramaafz instanceof aafm)) || (localaafl.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramaafz.c);
      this.a.jdField_a_of_type_Aafj.a(localaafl.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafd
 * JD-Core Version:    0.7.0.1
 */
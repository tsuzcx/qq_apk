import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aapc
  extends aapz
{
  public aapc(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(aapy paramaapy)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramaapy.c);
        if ((paramaapy instanceof aapt))
        {
          this.a.jdField_a_of_type_Aapi.a("", false, "download failed! msg = " + paramaapy.d);
          return;
        }
      }
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
    aapk localaapk = paramaapy.a();
    if (((paramaapy instanceof aapl)) || (localaapk.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramaapy.c);
      this.a.jdField_a_of_type_Aapi.a(localaapk.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapc
 * JD-Core Version:    0.7.0.1
 */
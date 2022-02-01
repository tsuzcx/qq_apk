import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class allo
  implements bdvw
{
  allo(alll paramalll) {}
  
  public void onResp(bdwt parambdwt)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambdwt.jdField_a_of_type_Bdws.a();
    if (parambdwt.jdField_a_of_type_Int != 0)
    {
      lbc.c("VideoFilterTools", "download IconFile failed. errorCode: " + parambdwt.b + ", errorMsg: " + parambdwt.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((alll.a(this.a).decrementAndGet() == 0) && (alll.a(this.a) != null)) {
      alll.a(this.a).a(true);
    }
    lbc.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allo
 * JD-Core Version:    0.7.0.1
 */
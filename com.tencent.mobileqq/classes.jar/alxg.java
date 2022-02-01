import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class alxg
  implements beuq
{
  alxg(alxd paramalxd) {}
  
  public void onResp(bevm parambevm)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambevm.jdField_a_of_type_Bevl.a();
    if (parambevm.jdField_a_of_type_Int != 0)
    {
      lbj.c("VideoFilterTools", "download IconFile failed. errorCode: " + parambevm.b + ", errorMsg: " + parambevm.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((alxd.a(this.a).decrementAndGet() == 0) && (alxd.a(this.a) != null)) {
      alxd.a(this.a).a(true);
    }
    lbj.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxg
 * JD-Core Version:    0.7.0.1
 */
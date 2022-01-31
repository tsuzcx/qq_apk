import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class ahkj
  implements axrt
{
  ahkj(ahkg paramahkg) {}
  
  public void onResp(axsq paramaxsq)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramaxsq.jdField_a_of_type_Axsp.a();
    if (paramaxsq.jdField_a_of_type_Int != 0)
    {
      krx.c("VideoFilterTools", "download IconFile failed. errorCode: " + paramaxsq.b + ", errorMsg: " + paramaxsq.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((ahkg.a(this.a).decrementAndGet() == 0) && (ahkg.a(this.a) != null)) {
      ahkg.a(this.a).a(true);
    }
    krx.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahkj
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class ahxb
  implements aysa
{
  ahxb(ahwy paramahwy) {}
  
  public void onResp(aysx paramaysx)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramaysx.jdField_a_of_type_Aysw.a();
    if (paramaysx.jdField_a_of_type_Int != 0)
    {
      lcl.c("VideoFilterTools", "download IconFile failed. errorCode: " + paramaysx.b + ", errorMsg: " + paramaysx.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((ahwy.a(this.a).decrementAndGet() == 0) && (ahwy.a(this.a) != null)) {
      ahwy.a(this.a).a(true);
    }
    lcl.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxb
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class ahwz
  implements aysc
{
  ahwz(ahww paramahww) {}
  
  public void onResp(aysz paramaysz)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramaysz.jdField_a_of_type_Aysy.a();
    if (paramaysz.jdField_a_of_type_Int != 0)
    {
      lcg.c("VideoFilterTools", "download IconFile failed. errorCode: " + paramaysz.b + ", errorMsg: " + paramaysz.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((ahww.a(this.a).decrementAndGet() == 0) && (ahww.a(this.a) != null)) {
      ahww.a(this.a).a(true);
    }
    lcg.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwz
 * JD-Core Version:    0.7.0.1
 */
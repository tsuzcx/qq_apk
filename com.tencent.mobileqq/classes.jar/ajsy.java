import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class ajsy
  implements baug
{
  ajsy(ajsv paramajsv) {}
  
  public void onResp(bavf parambavf)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambavf.jdField_a_of_type_Bave.a();
    if (parambavf.jdField_a_of_type_Int != 0)
    {
      lek.c("VideoFilterTools", "download IconFile failed. errorCode: " + parambavf.b + ", errorMsg: " + parambavf.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((ajsv.a(this.a).decrementAndGet() == 0) && (ajsv.a(this.a) != null)) {
      ajsv.a(this.a).a(true);
    }
    lek.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsy
 * JD-Core Version:    0.7.0.1
 */
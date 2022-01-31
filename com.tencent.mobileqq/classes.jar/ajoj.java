import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class ajoj
  implements bapx
{
  ajoj(ajog paramajog) {}
  
  public void onResp(baqw parambaqw)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambaqw.jdField_a_of_type_Baqv.a();
    if (parambaqw.jdField_a_of_type_Int != 0)
    {
      lek.c("VideoFilterTools", "download IconFile failed. errorCode: " + parambaqw.b + ", errorMsg: " + parambaqw.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((ajog.a(this.a).decrementAndGet() == 0) && (ajog.a(this.a) != null)) {
      ajog.a(this.a).a(true);
    }
    lek.c("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoj
 * JD-Core Version:    0.7.0.1
 */
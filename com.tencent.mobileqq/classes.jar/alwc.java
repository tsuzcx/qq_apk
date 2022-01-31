import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class alwc
  implements aliw
{
  alwc(alwb paramalwb) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)alwb.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        alwf localalwf = (alwf)paramString2.next();
        if ((localalwf != null) && (localalwf.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localalwf.jdField_a_of_type_Ampw != null))
        {
          localalwf.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localalwf.jdField_a_of_type_Ampw.c(true);
        }
      }
    }
    alwb.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alwc
 * JD-Core Version:    0.7.0.1
 */
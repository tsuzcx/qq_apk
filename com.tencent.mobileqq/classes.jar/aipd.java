import android.graphics.Bitmap;
import com.tencent.mobileqq.transfile.DataLineDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class aipd
  implements BitmapDecoder
{
  public aipc a;
  
  public aipd(DataLineDownloader paramDataLineDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    this.jdField_a_of_type_Aipc = this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader.a(paramURL);
    return DataLineDownloader.a(this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader, this.jdField_a_of_type_Aipc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipd
 * JD-Core Version:    0.7.0.1
 */
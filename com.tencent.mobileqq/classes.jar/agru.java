import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class agru
{
  public URL a;
  public boolean a;
  public boolean b;
  
  public agru(MessageForPic paramMessageForPic)
  {
    paramMessageForPic.checkType();
    if (((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000)) && (agrq.h))
    {
      this.jdField_a_of_type_Boolean = true;
      URL localURL = bdzx.a(paramMessageForPic, 1, null);
      if (bdsh.a(localURL.toString()) != null)
      {
        this.jdField_a_of_type_JavaNetURL = localURL;
        this.b = true;
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + paramMessageForPic.uniseq + " url:" + this.jdField_a_of_type_JavaNetURL);
        }
      }
    }
    if (this.jdField_a_of_type_JavaNetURL == null)
    {
      this.jdField_a_of_type_JavaNetURL = bdzx.a(paramMessageForPic, 65537, null);
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + this.jdField_a_of_type_JavaNetURL);
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    if (this.jdField_a_of_type_JavaNetURL != null) {
      return this.jdField_a_of_type_JavaNetURL.toString();
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agru
 * JD-Core Version:    0.7.0.1
 */
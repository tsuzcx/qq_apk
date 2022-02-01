import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ahbi
{
  public URL a;
  public boolean a;
  public boolean b;
  
  public ahbi(MessageForPic paramMessageForPic)
  {
    paramMessageForPic.checkType();
    if (((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000)) && (ahbe.h))
    {
      this.jdField_a_of_type_Boolean = true;
      URL localURL = beyq.a(paramMessageForPic, 1, null);
      if (beqz.a(localURL.toString()) != null)
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
      this.jdField_a_of_type_JavaNetURL = beyq.a(paramMessageForPic, 65537, null);
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
 * Qualified Name:     ahbi
 * JD-Core Version:    0.7.0.1
 */
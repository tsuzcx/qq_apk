import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import java.util.ArrayList;

public class ambu
  implements DialogInterface.OnClickListener
{
  public ambu(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambu
 * JD-Core Version:    0.7.0.1
 */
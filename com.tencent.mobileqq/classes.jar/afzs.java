import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class afzs
  implements Runnable
{
  public afzs(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(9);
    int i = PersonalityLabelGalleryActivity.a(this.a).size() - 1;
    if (i >= 0)
    {
      Object localObject = (String)PersonalityLabelGalleryActivity.a(this.a).get(i);
      if (this.a.e)
      {
        this.a.runOnUiThread(new afzt(this));
        return;
      }
      localObject = new CompressInfo((String)localObject, 0);
      ((CompressInfo)localObject).f = 0;
      CompressOperator.b((CompressInfo)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label uploadPhoto(), thumb_path = " + ((CompressInfo)localObject).e);
      }
      if (!TextUtils.isEmpty(((CompressInfo)localObject).e))
      {
        localArrayList.add(localObject);
        localObject = new File(((CompressInfo)localObject).e);
      }
      for (;;)
      {
        try
        {
          localObject = new URL("file:///" + ((File)localObject).getAbsolutePath());
          int j = (int)(120.0F * PersonalityLabelGalleryActivity.a(this.a));
          URLDrawable.getDrawable((URL)localObject, j, j, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).startDownload();
          i -= 1;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          continue;
        }
        this.a.runOnUiThread(new afzu(this, i));
      }
    }
    if (localArrayList.size() > 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(localArrayList, PersonalityLabelGalleryActivity.a(this.a));
    }
    this.a.runOnUiThread(new afzv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afzs
 * JD-Core Version:    0.7.0.1
 */
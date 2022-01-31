import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class aiev
  implements Runnable
{
  public aiev(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
      Object localObject2 = Environment.getExternalStorageDirectory() + "/tencent/QQfile_recv/" + ((File)localObject1).getName();
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("mp4.tmp.mp4")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 11) + "_" + System.currentTimeMillis() + ".mp4";
      }
      FileUtils.d(this.jdField_a_of_type_JavaLangString, (String)localObject1);
      localObject2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject2).setData(Uri.parse("file://" + (String)localObject1));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity().runOnUiThread(new aiew(this));
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity().runOnUiThread(new aiex(this));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity().runOnUiThread(new aiey(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiev
 * JD-Core Version:    0.7.0.1
 */
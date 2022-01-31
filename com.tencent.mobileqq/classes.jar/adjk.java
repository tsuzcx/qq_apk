import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.CheckListener;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class adjk
  implements GroupVideoManager.CheckListener
{
  public adjk(GVideoWebPlugin paramGVideoWebPlugin, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (TextUtils.equals("download", this.jdField_a_of_type_JavaLangString)))
    {
      GVideoWebPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoWebPlugin).c(2131429504);
      GVideoWebPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoWebPlugin).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjk
 * JD-Core Version:    0.7.0.1
 */
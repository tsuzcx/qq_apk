import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.CheckListener;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class adtj
  implements GroupVideoManager.CheckListener
{
  public adtj(GVideoWebPlugin paramGVideoWebPlugin, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (TextUtils.equals("download", this.jdField_a_of_type_JavaLangString)))
    {
      GVideoWebPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoWebPlugin).c(2131429510);
      GVideoWebPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoWebPlugin).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtj
 * JD-Core Version:    0.7.0.1
 */
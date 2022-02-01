import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;

public class aidj
  implements atvt
{
  public aidj(AIOImageProviderService paramAIOImageProviderService, aufc paramaufc, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, "I:E", new String[] { String.valueOf(paramInt), paramString }, null, null, -1, null);
    }
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a != null)
    {
      ArrayList localArrayList = paramSuperPlayerVideoInfo.getCookie();
      Bundle localBundle = new Bundle();
      localBundle.putString("savepath", paramSuperPlayerVideoInfo.getLocalSavePath());
      localBundle.putStringArrayList("cookies", localArrayList);
      localBundle.putString("contextid", this.jdField_a_of_type_Aufc.a());
      localBundle.putString("fileid", paramSuperPlayerVideoInfo.getFileId());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Aufc.b(), paramSuperPlayerVideoInfo.getPlayUrls(), null, null, -1, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidj
 * JD-Core Version:    0.7.0.1
 */
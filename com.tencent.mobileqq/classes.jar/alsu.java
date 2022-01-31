import android.view.View;
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.qidian.PhotoWallViewForQiDianProfile.PhotoWallCallback;
import com.tencent.qidian.data.CompanyShowCaseInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class alsu
  implements AdapterView.OnItemClickListener
{
  public alsu(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (CompanyShowCaseInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.a.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$PhotoWallCallback == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$PhotoWallCallback.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsu
 * JD-Core Version:    0.7.0.1
 */
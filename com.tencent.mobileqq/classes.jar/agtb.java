import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class agtb
  implements ActionSheet.OnButtonClickListener
{
  agtb(agta paramagta, agrx paramagrx) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Agta.a.jdField_a_of_type_ComTencentWidgetActionSheet.d();
        return;
        this.jdField_a_of_type_Agta.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(agta.a(this.jdField_a_of_type_Agta), this.jdField_a_of_type_Agrx.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Agta.a).get(Long.valueOf(agta.a(this.jdField_a_of_type_Agta)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Agta.a.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Agrx.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Agta.a.jdField_a_of_type_ComTencentWidgetActionSheet.d();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Agta.a, agta.a(this.jdField_a_of_type_Agta), paramView);
      this.jdField_a_of_type_Agta.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.b(agta.a(this.jdField_a_of_type_Agta), this.jdField_a_of_type_Agrx.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agtb
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener;

class akof
  implements XMPCoreUtil.XMPCoreJarLoadListener
{
  akof(akod paramakod, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void loadState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 90) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = i;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.setPanoramaType();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.setPanoramaType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akof
 * JD-Core Version:    0.7.0.1
 */
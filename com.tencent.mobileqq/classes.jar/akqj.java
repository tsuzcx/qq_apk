import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class akqj
{
  PhotoCropActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public akqj(PhotoCropActivity paramPhotoCropActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity = paramPhotoCropActivity;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      blir localblir = (blir)blji.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, null);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localblir.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], 1);
        i += 1;
      }
      localblir.c(2131690580);
      localblir.a(new akqk(this, localblir));
      localblir.show();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqj
 * JD-Core Version:    0.7.0.1
 */
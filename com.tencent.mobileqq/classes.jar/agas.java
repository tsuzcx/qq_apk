import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class agas
{
  PhotoCropActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public agas(PhotoCropActivity paramPhotoCropActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity = paramPhotoCropActivity;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, null);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localbegr.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], 1);
        i += 1;
      }
      localbegr.c(2131625035);
      localbegr.a(new agat(this, localbegr));
      localbegr.show();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agas
 * JD-Core Version:    0.7.0.1
 */
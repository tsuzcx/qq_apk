import com.tencent.mobileqq.customviews.PicProgressView;

public class acbe
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  public acbe(PicProgressView paramPicProgressView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Acbe = null;
    if (!this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int += this.b;
      PicProgressView.a(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbe
 * JD-Core Version:    0.7.0.1
 */
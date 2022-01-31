import com.tencent.mobileqq.customviews.MessageProgressTextView;

public class abmp
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  public abmp(MessageProgressTextView paramMessageProgressTextView, int paramInt1, int paramInt2)
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
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a = null;
    if (!this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.b)
    {
      this.jdField_a_of_type_Int += this.b;
      MessageProgressTextView.a(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abmp
 * JD-Core Version:    0.7.0.1
 */
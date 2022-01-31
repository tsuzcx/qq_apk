import com.tencent.mobileqq.businessCard.views.BusinessCardView;
import com.tencent.mobileqq.businessCard.views.BusinessCardViewScroller;

public class abvv
  implements Runnable
{
  public abvv(BusinessCardView paramBusinessCardView) {}
  
  public void run()
  {
    Float localFloat = Float.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a() - this.a.jdField_a_of_type_Float);
    if (Math.abs(localFloat.floatValue()) < 0.05F)
    {
      BusinessCardViewScroller localBusinessCardViewScroller = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller;
      if (localFloat.floatValue() > 0.0F) {}
      for (int i = BusinessCardViewScroller.a;; i = BusinessCardViewScroller.b)
      {
        localBusinessCardViewScroller.a(i);
        this.a.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        return;
      }
    }
    this.a.jdField_a_of_type_Float = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardViewScroller.a();
    this.a.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvv
 * JD-Core Version:    0.7.0.1
 */
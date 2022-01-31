import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;

public class aguv
  implements PraiseManager.OnPraiseLoadListener
{
  public int a;
  public PraiseManager.OnPraiseLoadListener a;
  public int b;
  
  public aguv(PraiseManager paramPraiseManager) {}
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    paramInt1 = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = paramInt1;
    if (paramInt1 == this.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.b(this);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseLoadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseLoadListener.a(0, null, 0, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aguv
 * JD-Core Version:    0.7.0.1
 */
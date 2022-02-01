import android.view.View;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class alvq
  extends alvy
{
  protected final BaseChatPie a;
  private int[] a;
  
  public alvq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  void a(bhjq parambhjq, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    Integer localInteger = null;
    if ((parambhjq != null) && (parambhjq.a() > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        break label107;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentAIOState() < 8)
      {
        if ((this.jdField_a_of_type_ArrayOfInt == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null))
        {
          this.jdField_a_of_type_ArrayOfInt = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        }
        if (this.jdField_a_of_type_ArrayOfInt != null) {
          break label93;
        }
      }
    }
    for (;;)
    {
      a(paramView, paramInt1, paramInt2, parambhjq, paramInt3, false, localInteger);
      return;
      label93:
      localInteger = Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]);
    }
    label107:
    a(paramView, paramInt1, paramInt2, parambhjq, paramInt3, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvq
 * JD-Core Version:    0.7.0.1
 */
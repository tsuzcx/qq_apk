import android.app.Activity;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/helper/QQLiveImageHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "getTag", "", "interestedIn", "", "onMoveToState", "", "state", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class afsb
  implements afrc
{
  public static final afsc a;
  private final BaseChatPie a;
  
  static
  {
    jdField_a_of_type_Afsc = new afsc(null);
  }
  
  public afsb(@NotNull BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveImagehelper", 2, "onMoveToState: state=" + paramInt);
    }
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 11: 
    case 12: 
    default: 
      return;
    case 8: 
      QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
      return;
    case 5: 
      QQLiveImage.onForeground((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
      return;
    case 9: 
      QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
      return;
    case 10: 
      QQLiveImage.onBackground((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
      return;
    case 13: 
      QQLiveImage.releaseAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
      return;
    case 16: 
      QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
      return;
    }
    QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
  }
  
  @NotNull
  public int[] a()
  {
    return new int[] { 8, 5, 9, 10, 13, 16, 15, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsb
 * JD-Core Version:    0.7.0.1
 */
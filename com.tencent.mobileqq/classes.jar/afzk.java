import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.IScroll;
import mqq.util.WeakReference;

public class afzk
  implements Runnable
{
  public afzk(PersonalityLabelBoard paramPersonalityLabelBoard) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.isCloseByUser == 0)) {
      if (this.a.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label62;
      }
    }
    label62:
    for (PersonalityLabelBoard.IScroll localIScroll = null;; localIScroll = (PersonalityLabelBoard.IScroll)this.a.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (localIScroll != null)
      {
        int i = this.a.jdField_a_of_type_AndroidViewView.getTop();
        if (i >= 0) {
          localIScroll.c(i);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afzk
 * JD-Core Version:    0.7.0.1
 */
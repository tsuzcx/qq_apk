import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder;

public class ajpt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ajpt(ReciteEvaluateViewHolder paramReciteEvaluateViewHolder, String paramString) {}
  
  public void onGlobalLayout()
  {
    ReciteEvaluateViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ReciteEvaluateViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpt
 * JD-Core Version:    0.7.0.1
 */
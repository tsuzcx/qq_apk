import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder;

public class ajih
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ajih(ReciteEvaluateViewHolder paramReciteEvaluateViewHolder, String paramString) {}
  
  public void onGlobalLayout()
  {
    ReciteEvaluateViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ReciteEvaluateViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajih
 * JD-Core Version:    0.7.0.1
 */
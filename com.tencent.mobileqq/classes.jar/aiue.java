import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder;

public class aiue
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aiue(ReciteEvaluateViewHolder paramReciteEvaluateViewHolder, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    ReciteEvaluateViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ReciteEvaluateViewHolder.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder).setVisibility(4);
    ReciteEvaluateViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder, this.jdField_a_of_type_Boolean, ReciteEvaluateViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder), ReciteEvaluateViewHolder.c(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteEvaluateViewHolder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiue
 * JD-Core Version:    0.7.0.1
 */
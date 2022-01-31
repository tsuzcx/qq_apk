import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.SingleItemViewHolder;

public class ajfy
  implements View.OnTouchListener
{
  public ajfy(CateListAdapter.SingleItemViewHolder paramSingleItemViewHolder) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.15F);
      this.a.c.setAlpha(0.5F);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      if ((i == 3) || (i == 1))
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        this.a.c.setAlpha(1.0F);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfy
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class absg
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  
  public absg(abry paramabry, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.right = this.jdField_a_of_type_Int;
    paramRect.bottom = this.jdField_a_of_type_Int;
    paramRect.left = this.jdField_a_of_type_Int;
    if (paramRecyclerView.getChildPosition(paramView) != 0) {
      paramRect.right = this.jdField_a_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     absg
 * JD-Core Version:    0.7.0.1
 */
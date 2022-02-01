import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.biz.richframework.part.block.BlockContainer;

public class aabi
  extends RecyclerView.ItemDecoration
{
  public aabi(BlockContainer paramBlockContainer, aabj paramaabj) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    if ((this.a.a != null) && (this.a.a.a(i) != null)) {
      this.a.a.a(i).getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((this.a.a != null) && (this.a.a.a(i) != null))
      {
        View localView = paramRecyclerView.getChildAt(i);
        this.a.a.a(i).onDrawItemDecoration(paramCanvas, paramRecyclerView, localView, paramState);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabi
 * JD-Core Version:    0.7.0.1
 */
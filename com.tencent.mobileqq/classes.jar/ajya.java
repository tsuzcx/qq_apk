import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class ajya
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  
  private ajya(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildPosition(paramView);
    if (i == 0)
    {
      paramRect.left = this.a;
      return;
    }
    if (i == paramRecyclerView.getAdapter().getItemCount() - 1)
    {
      paramRect.left = this.b;
      paramRect.right = this.a;
      return;
    }
    paramRect.left = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajya
 * JD-Core Version:    0.7.0.1
 */
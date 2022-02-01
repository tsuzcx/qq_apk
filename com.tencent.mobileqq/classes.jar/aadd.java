import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class aadd
  extends RecyclerView.ItemDecoration
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16843284 };
  private int jdField_a_of_type_Int = 2;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  public aadd(Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getResources().getColor(paramInt2));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      return ((GridLayoutManager)paramRecyclerView).getSpanCount();
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
      return ((StaggeredGridLayoutManager)paramRecyclerView).getSpanCount();
    }
    return -1;
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      if ((paramInt1 + 1) % paramInt2 == 0) {
        bool = true;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool;
          bool = false;
        }
        if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
          break label76;
        }
        if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() != 1) {
          break;
        }
      } while ((paramInt1 + 1) % paramInt2 == 0);
      return false;
    } while (paramInt1 >= paramInt3 - paramInt3 % paramInt2);
    return false;
    label76:
    return false;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        bool = true;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool;
          bool = false;
        }
        if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
          break label79;
        }
        if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() != 1) {
          break;
        }
      } while (paramInt1 >= paramInt3 - paramInt3 % paramInt2);
      return false;
    } while ((paramInt1 + 1) % paramInt2 == 0);
    return false;
    label79:
    return false;
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int k = localView.getLeft() - localLayoutParams.leftMargin;
      int m = localView.getRight() + localLayoutParams.rightMargin + this.jdField_a_of_type_Int;
      int n = localView.getBottom();
      n = localLayoutParams.bottomMargin + n;
      int i1 = n + this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, n, m, i1);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
        paramCanvas.drawRect(k, n, m, i1, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
  }
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int k = localView.getTop() - localLayoutParams.topMargin;
      int m = localView.getBottom();
      m = localLayoutParams.bottomMargin + m;
      int n = localView.getRight();
      n = localLayoutParams.rightMargin + n;
      int i1 = n + this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(n, k, i1, m);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
        paramCanvas.drawRect(n, k, i1, m, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    int i = a(paramRecyclerView);
    int j = paramRecyclerView.getAdapter().getItemCount();
    if (b(paramRecyclerView, paramInt, i, j))
    {
      paramRect.set(0, 0, this.jdField_a_of_type_Int, 0);
      return;
    }
    if (a(paramRecyclerView, paramInt, i, j))
    {
      paramRect.set(0, 0, 0, this.jdField_a_of_type_Int);
      return;
    }
    paramRect.set(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    a(paramCanvas, paramRecyclerView);
    b(paramCanvas, paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadd
 * JD-Core Version:    0.7.0.1
 */
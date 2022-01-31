import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class acrp
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  
  public acrp(ExtendFriendSquareFragment paramExtendFriendSquareFragment)
  {
    this.jdField_a_of_type_Int = AIOUtils.a(11.0F, paramExtendFriendSquareFragment.getResources());
    this.b = AIOUtils.a(11.0F, paramExtendFriendSquareFragment.getResources());
    this.c = AIOUtils.a(8.0F, paramExtendFriendSquareFragment.getResources());
    this.d = AIOUtils.a(8.0F, paramExtendFriendSquareFragment.getResources());
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    if (paramInt == paramRecyclerView.getAdapter().getItemCount() - 1)
    {
      paramRect.set(this.c, this.jdField_a_of_type_Int, this.d, this.b);
      return;
    }
    paramRect.set(this.c, this.jdField_a_of_type_Int, this.d, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrp
 * JD-Core Version:    0.7.0.1
 */
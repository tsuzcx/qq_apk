import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ahkz
  extends RecyclerView.ViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  
  public ahkz(Context paramContext, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static ahkz a(Context paramContext, View paramView)
  {
    return new ahkz(paramContext, paramView);
  }
  
  public static ahkz a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new ahkz(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public <T extends View> T a(int paramInt)
  {
    View localView2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView1);
    }
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkz
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class aexr
  extends RecyclerView.ViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  
  public aexr(Context paramContext, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static aexr a(Context paramContext, View paramView)
  {
    return new aexr(paramContext, paramView);
  }
  
  public static aexr a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new aexr(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexr
 * JD-Core Version:    0.7.0.1
 */
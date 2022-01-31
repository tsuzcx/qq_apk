import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class aktd
  extends RecyclerView.Adapter<akte>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private List<aktc> jdField_a_of_type_JavaUtilList;
  
  public aktd(Context paramContext, List<aktc> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public akte a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 1)) {
      return new akte(this, this.jdField_a_of_type_AndroidViewView);
    }
    return new akte(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558831, paramViewGroup, false));
  }
  
  public void a(akte paramakte, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      aktc localaktc = (aktc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramakte.a.setText(localaktc.jdField_a_of_type_JavaLangString);
      paramakte.a.setTextColor(Color.parseColor(akst.c[localaktc.jdField_a_of_type_Int]));
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(List<aktc> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == getItemCount() - 1)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktd
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class aixc
  extends RecyclerView.Adapter<aixd>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private List<aixb> jdField_a_of_type_JavaUtilList;
  
  public aixc(Context paramContext, List<aixb> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public aixd a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 1)) {
      return new aixd(this, this.jdField_a_of_type_AndroidViewView);
    }
    return new aixd(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558796, paramViewGroup, false));
  }
  
  public void a(aixd paramaixd, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      aixb localaixb = (aixb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramaixd.a.setText(localaixb.jdField_a_of_type_JavaLangString);
      paramaixd.a.setTextColor(Color.parseColor(aiws.c[localaixb.jdField_a_of_type_Int]));
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(List<aixb> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixc
 * JD-Core Version:    0.7.0.1
 */
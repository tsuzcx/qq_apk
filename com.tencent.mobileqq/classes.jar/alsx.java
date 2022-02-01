import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class alsx
  extends RecyclerView.Adapter<alsy>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private List<alsw> jdField_a_of_type_JavaUtilList;
  
  public alsx(Context paramContext, List<alsw> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public alsy a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 1)) {
      return new alsy(this, this.jdField_a_of_type_AndroidViewView);
    }
    return new alsy(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558910, paramViewGroup, false));
  }
  
  public void a(alsy paramalsy, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      alsw localalsw = (alsw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramalsy.a.setText(localalsw.jdField_a_of_type_JavaLangString);
      paramalsy.a.setTextColor(Color.parseColor(alsn.c[localalsw.jdField_a_of_type_Int]));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramalsy, paramInt, getItemId(paramInt));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(List<alsw> paramList)
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
 * Qualified Name:     alsx
 * JD-Core Version:    0.7.0.1
 */
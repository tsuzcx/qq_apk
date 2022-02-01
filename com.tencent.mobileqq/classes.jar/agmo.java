import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

public class agmo
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<agme> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private agmo(IntimateContentItemLoverAchievementView paramIntimateContentItemLoverAchievementView) {}
  
  public void a(List<agme> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (agmp)paramViewHolder;
    Object localObject = (agme)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewHolder.itemView.setTag(localObject);
    if (!TextUtils.isEmpty(((agme)localObject).a))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramViewHolder.a.getHeight();
      localURLDrawableOptions.mRequestWidth = paramViewHolder.a.getWidth();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
      localObject = URLDrawable.getDrawable(((agme)localObject).a, localURLDrawableOptions);
      paramViewHolder.a.setImageDrawable((Drawable)localObject);
      paramViewHolder.a.setCornerRadiusAndMode(ViewUtils.dpToPx(7.0F), 1);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new agmp(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView.a).inflate(2131559321, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmo
 * JD-Core Version:    0.7.0.1
 */
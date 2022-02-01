import WEISHI_USER_GROWTH.WEISHI.stMetaFeed;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aauz
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private aaym jdField_a_of_type_Aaym;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private List<aavc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public aauz(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, WEISHI.stMetaFeed paramstMetaFeed, int paramInt)
  {
    paramViewHolder = (aavb)paramViewHolder;
    paramstMetaFeed = paramstMetaFeed.material_thumburl.get();
    a(paramViewHolder.a, paramstMetaFeed);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = zlu.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      zlx.a(paramImageView, paramString, 68, 90, 4, zlx.b, "QQStoryMemory");
    }
  }
  
  public void a(aaym paramaaym)
  {
    this.jdField_a_of_type_Aaym = paramaaym;
  }
  
  public void a(List<WEISHI.stMetaFeed> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    aavc localaavc;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 3;
      if (paramBoolean)
      {
        i = 2;
        localaavc = new aavc(null, 100);
        this.jdField_a_of_type_JavaUtilList.add(localaavc);
      }
      j = paramList.size();
      if (j >= i) {
        break label133;
      }
      i = j;
    }
    label133:
    for (;;)
    {
      j = 0;
      while (j < i)
      {
        localaavc = new aavc((WEISHI.stMetaFeed)paramList.get(j), 101);
        this.jdField_a_of_type_JavaUtilList.add(localaavc);
        j += 1;
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
        return 3;
      }
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((aavc)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramViewHolder.getAdapterPosition();
    aavc localaavc = (aavc)this.jdField_a_of_type_JavaUtilList.get(i);
    int j = localaavc.jdField_a_of_type_Int;
    WEISHI.stMetaFeed localstMetaFeed = localaavc.jdField_a_of_type_WEISHI_USER_GROWTHWEISHI$stMetaFeed;
    switch (j)
    {
    }
    for (;;)
    {
      paramViewHolder.itemView.setOnClickListener(new aava(this, localaavc));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (j == 101)
      {
        a(paramViewHolder, localstMetaFeed, i);
        continue;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          ((aavb)paramViewHolder).a.setImageResource(2130850277);
        } else {
          ((aavb)paramViewHolder).a.setImageResource(2130845877);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new aavb(localLayoutInflater.inflate(2131561455, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauz
 * JD-Core Version:    0.7.0.1
 */
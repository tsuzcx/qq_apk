import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;
import java.util.List;

public class ahtg
  extends RecyclerView.Adapter
{
  public List<String> a = new ArrayList();
  
  public ahtg(List<String> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    if (this.a != null) {
      return this.a.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = ((ahth)paramViewHolder).a;
    if (!TextUtils.isEmpty((String)this.a.get(paramInt)))
    {
      if (paramInt != 0) {
        break label92;
      }
      String str = (String)this.a.get(paramInt);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = baul.a;
      localURLDrawableOptions.mLoadingDrawable = baul.a;
      localURLDrawableOptions.mPlayGifImage = awgi.a(str);
      localURLDrawableOptions.mUseAutoScaleParams = true;
      paramViewHolder.setImageDrawable(URLDrawable.getFileDrawable(str, localURLDrawableOptions));
    }
    label92:
    do
    {
      return;
      if (paramInt == 1)
      {
        paramViewHolder.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramViewHolder.setPadding(0, 0, 0, 0);
        paramViewHolder.setImageDrawable(null);
        paramViewHolder.setBackgroundColor(Color.parseColor("#9A989EB4"));
        return;
      }
    } while (paramInt != 2);
    paramViewHolder.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramViewHolder.setPadding(0, 0, 0, 0);
    paramViewHolder.setImageDrawable(null);
    paramViewHolder.setBackgroundColor(Color.parseColor("#48989EB4"));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ahth(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559060, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtg
 * JD-Core Version:    0.7.0.1
 */
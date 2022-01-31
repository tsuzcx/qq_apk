import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.List;

public class ajdl
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<ApolloActionPackage> jdField_a_of_type_JavaUtilList;
  private int b = -1;
  
  public ajdl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131099964);
  }
  
  public Drawable a(ApolloActionPackage paramApolloActionPackage)
  {
    ApolloActionPackage localApolloActionPackage = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable2;
    if (!TextUtils.isEmpty(paramApolloActionPackage.mIconSelectedUrl))
    {
      localURLDrawable2 = aitu.a("" + paramApolloActionPackage.mIconSelectedUrl.hashCode(), null, paramApolloActionPackage.mIconSelectedUrl, true);
      localURLDrawable1 = localURLDrawable2;
      if (localURLDrawable2 != null) {
        localURLDrawable2.startDownload();
      }
    }
    for (URLDrawable localURLDrawable1 = localURLDrawable2;; localURLDrawable1 = null)
    {
      if (!TextUtils.isEmpty(paramApolloActionPackage.mIconUnselectedUrl))
      {
        paramApolloActionPackage = aitu.a("" + paramApolloActionPackage.mIconUnselectedUrl.hashCode(), null, paramApolloActionPackage.mIconUnselectedUrl, true);
        localApolloActionPackage = paramApolloActionPackage;
        if (paramApolloActionPackage != null)
        {
          paramApolloActionPackage.startDownload();
          localApolloActionPackage = paramApolloActionPackage;
        }
      }
      if (localURLDrawable1 != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, localURLDrawable1);
      }
      if (localApolloActionPackage != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, localApolloActionPackage);
      }
      return localStateListDrawable;
    }
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (ApolloActionPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<ApolloActionPackage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(14)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493071, paramViewGroup, false);
      paramViewGroup = new ajdm(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131310978));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setActivated(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setEnabled(true);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131310975);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310976));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt == getCount() - 1) {
        break label227;
      }
    }
    label227:
    for (int i = 0;; i = 4)
    {
      ((View)localObject).setVisibility(i);
      localObject = a(paramInt);
      if (localObject != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a((ApolloActionPackage)localObject));
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(((ApolloActionPackage)localObject).name);
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      if (paramInt != this.b) {
        break label233;
      }
      paramView.setSelected(true);
      return paramView;
      paramViewGroup = (ajdm)paramView.getTag();
      break;
    }
    label233:
    paramView.setSelected(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdl
 * JD-Core Version:    0.7.0.1
 */
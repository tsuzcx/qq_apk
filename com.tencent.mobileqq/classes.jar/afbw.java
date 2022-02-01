import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afbw
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<IntimateInfo.MutualMarkInfo> jdField_a_of_type_JavaUtilList;
  
  private afbw(afbj paramafbj) {}
  
  public IntimateInfo.MutualMarkInfo a(int paramInt)
  {
    return (IntimateInfo.MutualMarkInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<IntimateInfo.MutualMarkInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(40.0F) - 80) / ViewUtils.dip2px(50.0F));
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "friend mark max count: " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = 6;
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @RequiresApi(api=16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Afbj.jdField_a_of_type_AndroidContentContext).inflate(2131559279, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131367269);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
      Object localObject = a(paramInt);
      if ((localObject instanceof IntimateInfo.PrefetchMutualMarkInfo))
      {
        localObject = (IntimateInfo.PrefetchMutualMarkInfo)localObject;
        afbj.a(this.jdField_a_of_type_Afbj, (IntimateInfo.PrefetchMutualMarkInfo)localObject);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (TextUtils.isEmpty(((IntimateInfo.MutualMarkInfo)localObject).iconStaticUrl)) {
          break;
        }
        ColorDrawable localColorDrawable = new ColorDrawable(0);
        String str = awgj.a(this.jdField_a_of_type_Afbj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Afbj.jdField_a_of_type_JavaLangString, ((IntimateInfo.MutualMarkInfo)localObject).type, ((IntimateInfo.MutualMarkInfo)localObject).level, ((IntimateInfo.MutualMarkInfo)localObject).subLevel, ((IntimateInfo.MutualMarkInfo)localObject).iconStaticUrl);
        this.jdField_a_of_type_Afbj.a(localImageView, str, localColorDrawable, ((IntimateInfo.MutualMarkInfo)localObject).type);
        localRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_Afbj.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130840468));
      }
      int i = awfn.a(this.jdField_a_of_type_Afbj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Afbj.jdField_a_of_type_JavaLangString, ((IntimateInfo.MutualMarkInfo)localObject).type, ((IntimateInfo.MutualMarkInfo)localObject).level);
      if (i != 0) {}
      for (localObject = new awfv(this.jdField_a_of_type_Afbj.jdField_a_of_type_AndroidContentContext, i);; localObject = null)
      {
        localImageView.setImageDrawable((Drawable)localObject);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbw
 * JD-Core Version:    0.7.0.1
 */
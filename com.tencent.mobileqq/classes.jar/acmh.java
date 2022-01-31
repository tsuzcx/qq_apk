import android.content.res.Resources;
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
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acmh
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<IntimateInfo.MutualMarkInfo> jdField_a_of_type_JavaUtilList;
  
  private acmh(aclw paramaclw) {}
  
  public IntimateInfo.MutualMarkInfo a(int paramInt)
  {
    return (IntimateInfo.MutualMarkInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<IntimateInfo.MutualMarkInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ((bajq.a() - bajq.a(40.0F) - 80) / bajq.a(50.0F));
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
    if (paramView == null) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_Aclw.jdField_a_of_type_AndroidContentContext).inflate(2131493583, null);; paramViewGroup = paramView)
    {
      ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131301188);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramViewGroup;
      paramView = a(paramInt);
      if ((paramView instanceof IntimateInfo.PrefetchMutualMarkInfo))
      {
        paramView = (IntimateInfo.PrefetchMutualMarkInfo)paramView;
        aclw.a(this.jdField_a_of_type_Aclw, paramView);
        return paramViewGroup;
      }
      if (!TextUtils.isEmpty(paramView.icon_static_url)) {
        paramView = new asbd(this.jdField_a_of_type_Aclw.jdField_a_of_type_AndroidContentContext, paramView.icon_static_url);
      }
      for (;;)
      {
        localImageView.setImageDrawable(paramView);
        localRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_Aclw.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130840090));
        return paramViewGroup;
        paramInt = asav.a(this.jdField_a_of_type_Aclw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aclw.jdField_a_of_type_JavaLangString, paramView.type, paramView.level);
        if (paramInt != 0) {
          paramView = new asbd(this.jdField_a_of_type_Aclw.jdField_a_of_type_AndroidContentContext, paramInt);
        } else {
          paramView = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acmh
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class acsl
  extends BaseAdapter
  implements bcwt
{
  private ajfa jdField_a_of_type_Ajfa;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public acsl(FontSettingActivity paramFontSettingActivity, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramFontSettingActivity.getLayoutInflater();
    this.jdField_a_of_type_Ajfa = new ajfa(paramQQAppInterface, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ajfa.a();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562523, paramViewGroup, false);
    paramViewGroup = (acsk)this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    ImageView localImageView = (ImageView)paramView.findViewById(2131367808);
    localImageView.setImageDrawable(this.jdField_a_of_type_Ajfa.a(paramViewGroup.jdField_b_of_type_Int, paramViewGroup.d));
    ((TextView)paramView.findViewById(16908308)).setText(paramViewGroup.jdField_a_of_type_JavaLangString);
    ((TextView)paramView.findViewById(16908309)).setText(paramViewGroup.jdField_b_of_type_JavaLangString);
    ((TextView)paramView.findViewById(2131369115)).setText(paramViewGroup.c);
    acsm localacsm = new acsm(this);
    localacsm.jdField_a_of_type_JavaLangString = paramViewGroup.d;
    localacsm.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    localacsm.jdField_a_of_type_Acsk = paramViewGroup;
    paramView.setTag(localacsm);
    if ((FontSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity)) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_JavaUtilArrayList.size() - 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.a();
    }
    return paramView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject1 = null;
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_ComTencentWidgetListView.getChildCount();
    Object localObject2;
    if (paramBitmap != null)
    {
      paramInt1 = 0;
      if (paramInt1 >= paramInt2) {
        break label105;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.jdField_b_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag();
      if ((localObject2 == null) || (!(localObject2 instanceof acsm))) {
        break label98;
      }
      localObject2 = (acsm)localObject2;
      localObject1 = localObject2;
      if (!((acsm)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label98;
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        ((acsm)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        notifyDataSetChanged();
      }
      return;
      label98:
      paramInt1 += 1;
      break;
      label105:
      localObject2 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsl
 * JD-Core Version:    0.7.0.1
 */
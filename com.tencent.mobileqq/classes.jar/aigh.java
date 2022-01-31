import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aigh
  extends ailz
{
  public aigh(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    super(paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
  }
  
  public int a()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559194;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.a.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label65;
      }
      if (!this.a.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.a.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label65:
      i = -1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int b()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((List)this.a.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size() + i) {}
    return i;
  }
  
  public int getCount()
  {
    if ((this.a.jdField_a_of_type_ArrayOfInt == null) || (this.a.jdField_a_of_type_JavaUtilMap == null)) {}
    while (this.a.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.a.jdField_a_of_type_ArrayOfInt[(this.a.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[(this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562407, paramViewGroup, false);
      paramView = new aigi(this.a, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131375398));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378223));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364192));
      paramView.c = ((ImageView)localView.findViewById(2131367679));
      paramView.b = ((TextView)localView.findViewById(2131370647));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131378332);
    }
    paramViewGroup = (aigi)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
      String str;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(localTroopMemberInfo.memberuin))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.c.setImageBitmap(a(localTroopMemberInfo.memberuin));
        str = bbcz.h(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin);
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d != 21) {
          break label707;
        }
        if ((TroopMemberListInnerFrame.a(this.a) == null) || (!TroopMemberListInnerFrame.a(this.a).isTroopOwner(localTroopMemberInfo.memberuin)) || (this.a.c == null) || (this.a.c.getTag() == null)) {
          break label603;
        }
        paramView = new SpannableString("[tag]" + " " + str);
        paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (Bitmap)this.a.c.getTag()), 0, "[tag]".length(), 18);
        label430:
        paramViewGroup.b.setText(paramView);
        label438:
        paramViewGroup.jdField_a_of_type_JavaLangString = localTroopMemberInfo.memberuin;
        if (paramViewGroup.jdField_a_of_type_AndroidViewView != null)
        {
          if (!bail.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, localTroopMemberInfo.memberuin)) {
            break label737;
          }
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        label483:
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localTroopMemberInfo.memberuin))) {
          break label749;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        label525:
        if ((!AppSetting.d) || (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label792;
        }
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label760;
        }
        localView.setContentDescription(str + ajya.a(2131715557));
      }
      for (;;)
      {
        localView.setOnClickListener(this.a);
        return localView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label603:
        paramView = localObject;
        if (this.a.b == null) {
          break label430;
        }
        paramView = localObject;
        if (this.a.b.getTag() == null) {
          break label430;
        }
        paramView = new SpannableString("[tag]" + " " + str);
        paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (Bitmap)this.a.b.getTag()), 0, "[tag]".length(), 18);
        break label430;
        label707:
        paramViewGroup.b.setText(bbcz.h(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin));
        break label438;
        label737:
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label483;
        label749:
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label525;
        label760:
        localView.setContentDescription(str + ajya.a(2131715581));
        continue;
        label792:
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d == 14) && (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          localView.setContentDescription(str + ajya.a(2131715570));
        }
      }
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramView = String.valueOf(this.a.jdField_a_of_type_ArrayOfJavaLangString[i]);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691898), new Object[] { paramView.toLowerCase() }));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aigh
 * JD-Core Version:    0.7.0.1
 */
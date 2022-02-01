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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aluw
  extends ambr
{
  public aluw(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    super(paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
  }
  
  public int a()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559317;
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
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562867, paramViewGroup, false);
      paramView = new alux(this.a, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376678));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379723));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364466));
      paramView.c = ((ImageView)localView.findViewById(2131368138));
      paramView.b = ((TextView)localView.findViewById(2131371539));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131379878);
    }
    for (;;)
    {
      alux localalux = (alux)localView.getTag();
      TroopMemberInfo localTroopMemberInfo;
      String str;
      Object localObject;
      if (i < 0)
      {
        i = -(i + 1) - 1;
        localTroopMemberInfo = (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(localTroopMemberInfo.memberuin))
        {
          localalux.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          localalux.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localalux.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localalux.c.setImageBitmap(a(localTroopMemberInfo.memberuin));
          str = bglf.h(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin);
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d != 21) {
            break label732;
          }
          localObject = null;
          if ((TroopMemberListInnerFrame.a(this.a) == null) || (!TroopMemberListInnerFrame.a(this.a).isTroopOwner(localTroopMemberInfo.memberuin)) || (this.a.c == null) || (this.a.c.getTag() == null)) {
            break label628;
          }
          paramView = new SpannableString("[tag]" + " " + str);
          paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (Bitmap)this.a.c.getTag()), 0, "[tag]".length(), 18);
          label432:
          localalux.b.setText(paramView);
          label441:
          localalux.jdField_a_of_type_JavaLangString = localTroopMemberInfo.memberuin;
          if (localalux.jdField_a_of_type_AndroidViewView != null)
          {
            if (!bfpx.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, localTroopMemberInfo.memberuin)) {
              break label763;
            }
            localalux.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
          label489:
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localTroopMemberInfo.memberuin))) {
            break label776;
          }
          localalux.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          label532:
          if ((!AppSetting.c) || (!localalux.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
            break label820;
          }
          if (!localalux.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label788;
          }
          localView.setContentDescription(str + anni.a(2131714222));
          label589:
          localView.setOnClickListener(this.a);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localalux.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label628:
        paramView = localObject;
        if (this.a.b == null) {
          break label432;
        }
        paramView = localObject;
        if (this.a.b.getTag() == null) {
          break label432;
        }
        paramView = new SpannableString("[tag]" + " " + str);
        paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (Bitmap)this.a.b.getTag()), 0, "[tag]".length(), 18);
        break label432;
        label732:
        localalux.b.setText(bglf.h(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin));
        break label441;
        label763:
        localalux.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label489;
        label776:
        localalux.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label532;
        label788:
        localView.setContentDescription(str + anni.a(2131714246));
        break label589;
        label820:
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d != 14) || (localalux.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label589;
        }
        localView.setContentDescription(str + anni.a(2131714235));
        break label589;
        localalux.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localalux.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = String.valueOf(this.a.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localalux.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        localalux.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691635), new Object[] { paramView.toLowerCase() }));
      }
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aluw
 * JD-Core Version:    0.7.0.1
 */
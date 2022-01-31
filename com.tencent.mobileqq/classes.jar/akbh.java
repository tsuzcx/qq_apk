import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.widget.IndexView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class akbh
  extends akhz
  implements View.OnClickListener
{
  alto jdField_a_of_type_Alto = (alto)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
  public List<ResultRecord> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public akbh(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame)
  {
    super(paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramTroopAddFrdsInnerFrame.b = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131297983);
    paramTroopAddFrdsInnerFrame.c = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131297984);
  }
  
  private boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(i);
        if (TextUtils.equals(paramTroopMemberInfo.memberuin, localResultRecord.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559236;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label65;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i];
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
    Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.equals(paramResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (paramBoolean) {
        if (i == -1)
        {
          this.jdField_a_of_type_JavaUtilList.add(paramResultRecord);
          notifyDataSetChanged();
        }
      }
      while (i == -1)
      {
        return;
        i += 1;
        break;
      }
      this.jdField_a_of_type_JavaUtilList.remove(i);
      notifyDataSetChanged();
      return;
      i = -1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    boolean bool = true;
    int i = 0;
    int j = Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    Object localObject2;
    akbg localakbg;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560898, paramViewGroup, false);
      paramView = new akbg();
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131375722);
      paramView.jdField_a_of_type_AndroidViewView.setId(2131378346);
      paramViewGroup = localView.findViewById(2131377343);
      localObject2 = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131378346);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = aepi.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources());
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361795));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131375729));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371161));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376899));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131375716));
      paramView.d = ((TextView)localView.findViewById(2131375726));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364254));
      paramView.e = ((TextView)localView.findViewById(2131378845));
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131373496);
      paramView.e.setFocusableInTouchMode(false);
      paramView.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(false);
      paramView.e.setFocusable(false);
      paramView.jdField_b_of_type_AndroidViewView.setFocusable(false);
      paramView.jdField_a_of_type_AndroidViewView.setDuplicateParentStateEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetButton.setDuplicateParentStateEnabled(true);
      paramView.d.setDuplicateParentStateEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, aepi.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources()), 0, 0);
      if ((TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame) != null) && (TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame).getVisibility() == 0))
      {
        localView.findViewById(2131378346).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.b, 0);
        localView.setTag(paramView);
      }
    }
    else
    {
      localakbg = (akbg)localView.getTag();
      if (j >= 0) {
        break label1325;
      }
      j = -(j + 1) - 1;
      localObject2 = (TroopMemberInfo)((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[j])).get(paramInt - this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[j] - 1);
      localakbg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = ((TroopMemberInfo)localObject2);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(((TroopMemberInfo)localObject2).memberuin)) {
        break label1055;
      }
      localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label485:
      if (!AppSetting.c) {
        break label1442;
      }
      paramView = new StringBuilder(256);
      paramView.append("群成员");
    }
    for (;;)
    {
      localakbg.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localakbg.e.setVisibility(8);
      localakbg.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((TroopMemberInfo)localObject2).memberuin));
      Object localObject3 = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      paramViewGroup = (ViewGroup)localObject3;
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).recommendRemark))
      {
        paramViewGroup = (ViewGroup)localObject3;
        if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, ((TroopMemberInfo)localObject2).memberuin))
        {
          paramViewGroup = (ViewGroup)localObject3;
          if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, (CharSequence)localObject3))
          {
            paramViewGroup = (ViewGroup)localObject3;
            if (!this.jdField_a_of_type_Alto.b(((TroopMemberInfo)localObject2).memberuin)) {
              paramViewGroup = (String)localObject3 + " (" + ((TroopMemberInfo)localObject2).recommendRemark + ")";
            }
          }
        }
      }
      localakbg.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
      localakbg.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
      localakbg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.c) {
        paramView.append(paramViewGroup);
      }
      if (((TroopMemberInfo)localObject2).commonFrdCnt > 0)
      {
        localakbg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources().getString(2131689759, new Object[] { Integer.valueOf(((TroopMemberInfo)localObject2).commonFrdCnt) }));
        localakbg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.c) {
          paramView.append(localakbg.jdField_b_of_type_AndroidWidgetTextView.getText());
        }
        label784:
        if (!this.jdField_a_of_type_Boolean) {
          localakbg.jdField_b_of_type_AndroidViewView.setEnabled(true);
        }
        if (((TroopMemberInfo)localObject2).addState != 1) {
          break label1080;
        }
        paramInt = TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame, ((TroopMemberInfo)localObject2).memberuin);
        label822:
        if (paramInt != 4) {
          break label1089;
        }
        localakbg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localakbg.d.setVisibility(0);
        localakbg.d.setText(alud.a(2131715546));
        if (this.jdField_a_of_type_Boolean)
        {
          localakbg.jdField_b_of_type_AndroidViewView.setEnabled(false);
          localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (!AppSetting.c) {
          break label1437;
        }
        localakbg.d.setContentDescription(alud.a(2131715548));
        paramInt = 0;
      }
      for (;;)
      {
        label916:
        localObject3 = localakbg.jdField_a_of_type_AndroidViewView;
        if (paramInt != 0)
        {
          paramViewGroup = (ViewGroup)localObject2;
          label930:
          ((View)localObject3).setTag(paramViewGroup);
          localObject2 = localakbg.jdField_a_of_type_AndroidViewView;
          paramViewGroup = localObject1;
          if (paramInt != 0) {
            paramViewGroup = this;
          }
          ((View)localObject2).setOnClickListener(paramViewGroup);
          paramViewGroup = localakbg.jdField_a_of_type_AndroidViewView;
          if (paramInt == 0) {
            break label1313;
          }
          label968:
          paramViewGroup.setClickable(bool);
          paramViewGroup = localakbg.jdField_a_of_type_AndroidWidgetCheckBox;
          if (!this.jdField_a_of_type_Boolean) {
            break label1319;
          }
        }
        label1055:
        label1313:
        label1319:
        for (paramInt = i;; paramInt = 8)
        {
          paramViewGroup.setVisibility(paramInt);
          localakbg.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          localakbg.jdField_b_of_type_AndroidViewView.setTag(localakbg);
          if (AppSetting.c) {
            localView.setContentDescription(paramView.toString());
          }
          return localView;
          localView.findViewById(2131378346).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.c, 0);
          break;
          localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label485;
          localakbg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label784;
          label1080:
          paramInt = ((TroopMemberInfo)localObject2).addState;
          break label822;
          label1089:
          if (paramInt == 3)
          {
            localakbg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            localakbg.d.setVisibility(0);
            localakbg.d.setText(alud.a(2131715544));
            if (this.jdField_a_of_type_Boolean)
            {
              localakbg.jdField_b_of_type_AndroidViewView.setEnabled(false);
              localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
              localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            }
            if (!AppSetting.c) {
              break label1437;
            }
            localakbg.d.setContentDescription(alud.a(2131715543));
            paramInt = 0;
            break label916;
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localakbg.jdField_b_of_type_AndroidViewView.setEnabled(true);
            localakbg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
            localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a((TroopMemberInfo)localObject2));
            localakbg.jdField_a_of_type_AndroidWidgetCheckBox.setTag(localakbg);
          }
          for (paramInt = 0;; paramInt = 1)
          {
            localakbg.d.setVisibility(8);
            break;
            localakbg.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localakbg.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131689628));
            if (AppSetting.c) {
              localakbg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(alud.a(2131689628));
            }
          }
          paramViewGroup = null;
          break label930;
          bool = false;
          break label968;
        }
        label1325:
        localakbg.jdField_b_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.f == TroopAddFrdsInnerFrame.d)
        {
          localakbg.e.setVisibility(0);
          paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[j]);
          localakbg.e.setText(paramView);
          localakbg.e.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691954), new Object[] { paramView.toLowerCase() }));
          return localView;
        }
        localakbg.e.setVisibility(8);
        localView.setBackgroundResource(0);
        return localView;
        label1437:
        paramInt = 0;
      }
      label1442:
      paramView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131373496: 
      if (!this.jdField_a_of_type_Boolean) {
        break label204;
      }
      paramView = (akbg)localObject;
      boolean bool = a(paramView.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
      localObject = new ResultRecord();
      ((ResultRecord)localObject).jdField_a_of_type_JavaLangString = paramView.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localArrayList, false);
      }
      break;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramView = (TroopMemberInfo)localObject;
      TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramView, TroopAddFrdsInnerFrame.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e(paramView.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a((ResultRecord)localObject, false);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k();
    }
    label204:
    paramView = ((akbg)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
    localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, FriendProfileCardActivity.class);
    ((Intent)localObject).putExtra("troopUin", paramView.troopuin);
    ((Intent)localObject).putExtra("memberUin", paramView.memberuin);
    ((Intent)localObject).putExtra("fromFlag", 1);
    ((Intent)localObject).putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131721076));
    ((Intent)localObject).putExtra("custom_leftbackbutton_name", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131690623));
    awrt.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Intent)localObject, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbh
 * JD-Core Version:    0.7.0.1
 */
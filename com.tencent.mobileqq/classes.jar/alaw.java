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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class alaw
  extends alif
  implements View.OnClickListener
{
  amsw jdField_a_of_type_Amsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
  public List<ResultRecord> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public alaw(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame)
  {
    super(paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramTroopAddFrdsInnerFrame.b = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131298141);
    paramTroopAddFrdsInnerFrame.c = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131298142);
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
        if (TextUtils.equals(paramTroopMemberInfo.memberuin, localResultRecord.uin)) {
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
      return 2131559319;
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
      if (!TextUtils.equals(paramResultRecord.uin, localResultRecord.uin)) {}
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
    int i = Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561014, paramViewGroup, false);
      localObject1 = new alav();
      ((alav)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376347);
      ((alav)localObject1).jdField_a_of_type_AndroidViewView.setId(2131379132);
      localObject2 = paramView.findViewById(2131378093);
      localObject3 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131379132);
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources());
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((alav)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      ((alav)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376354));
      ((alav)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371791));
      ((alav)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377631));
      ((alav)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376341));
      ((alav)localObject1).d = ((TextView)paramView.findViewById(2131376351));
      ((alav)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364526));
      ((alav)localObject1).e = ((TextView)paramView.findViewById(2131379673));
      ((alav)localObject1).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131374108);
      ((alav)localObject1).e.setFocusableInTouchMode(false);
      ((alav)localObject1).jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(false);
      ((alav)localObject1).e.setFocusable(false);
      ((alav)localObject1).jdField_b_of_type_AndroidViewView.setFocusable(false);
      ((alav)localObject1).jdField_a_of_type_AndroidViewView.setDuplicateParentStateEnabled(false);
      ((alav)localObject1).jdField_a_of_type_AndroidWidgetButton.setDuplicateParentStateEnabled(true);
      ((alav)localObject1).d.setDuplicateParentStateEnabled(false);
      ((alav)localObject1).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      ((alav)localObject1).jdField_b_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.dp2px(2.0F, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources()), 0, 0);
      if ((TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame) != null) && (TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame).getVisibility() == 0))
      {
        paramView.findViewById(2131379132).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.b, 0);
        paramView.setTag(localObject1);
      }
    }
    for (;;)
    {
      alav localalav = (alav)paramView.getTag();
      label483:
      int k;
      label796:
      int j;
      label841:
      label980:
      boolean bool;
      if (i < 0)
      {
        i = -(i + 1) - 1;
        localObject3 = (TroopMemberInfo)((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i] - 1);
        localalav.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = ((TroopMemberInfo)localObject3);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.isResultListContainFriend(((TroopMemberInfo)localObject3).memberuin))
        {
          localalav.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          localObject1 = null;
          if (AppSetting.c)
          {
            localObject1 = new StringBuilder(256);
            ((StringBuilder)localObject1).append("群成员");
          }
          localalav.jdField_b_of_type_AndroidViewView.setVisibility(0);
          localalav.e.setVisibility(8);
          localalav.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((TroopMemberInfo)localObject3).memberuin));
          Object localObject4 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopMemberInfo)localObject3).troopuin, ((TroopMemberInfo)localObject3).memberuin);
          localObject2 = localObject4;
          if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).recommendRemark))
          {
            localObject2 = localObject4;
            if (!TextUtils.equals(((TroopMemberInfo)localObject3).recommendRemark, ((TroopMemberInfo)localObject3).memberuin))
            {
              localObject2 = localObject4;
              if (!TextUtils.equals(((TroopMemberInfo)localObject3).recommendRemark, (CharSequence)localObject4))
              {
                localObject2 = localObject4;
                if (!this.jdField_a_of_type_Amsw.b(((TroopMemberInfo)localObject3).memberuin)) {
                  localObject2 = (String)localObject4 + " (" + ((TroopMemberInfo)localObject3).recommendRemark + ")";
                }
              }
            }
          }
          localalav.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          localalav.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject3).memberuin;
          localalav.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (AppSetting.c) {
            ((StringBuilder)localObject1).append((String)localObject2);
          }
          if (((TroopMemberInfo)localObject3).commonFrdCnt <= 0) {
            break label1117;
          }
          localalav.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources().getString(2131689652, new Object[] { Integer.valueOf(((TroopMemberInfo)localObject3).commonFrdCnt) }));
          localalav.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if (AppSetting.c) {
            ((StringBuilder)localObject1).append(localalav.jdField_b_of_type_AndroidWidgetTextView.getText());
          }
          if (!this.jdField_a_of_type_Boolean) {
            localalav.jdField_b_of_type_AndroidViewView.setEnabled(true);
          }
          k = 0;
          j = 0;
          if (((TroopMemberInfo)localObject3).addState != 1) {
            break label1130;
          }
          i = TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame, ((TroopMemberInfo)localObject3).memberuin);
          if (i != 4) {
            break label1140;
          }
          localalav.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          localalav.d.setVisibility(0);
          localalav.d.setText(amtj.a(2131714168));
          if (this.jdField_a_of_type_Boolean)
          {
            localalav.jdField_b_of_type_AndroidViewView.setEnabled(false);
            localalav.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
            localalav.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          }
          i = j;
          if (AppSetting.c)
          {
            localalav.d.setContentDescription(amtj.a(2131714170));
            i = j;
          }
          label942:
          localObject4 = localalav.jdField_a_of_type_AndroidViewView;
          if (i == 0) {
            break label1377;
          }
          localObject2 = localObject3;
          label958:
          ((View)localObject4).setTag(localObject2);
          localObject3 = localalav.jdField_a_of_type_AndroidViewView;
          if (i == 0) {
            break label1383;
          }
          localObject2 = this;
          ((View)localObject3).setOnClickListener((View.OnClickListener)localObject2);
          localObject2 = localalav.jdField_a_of_type_AndroidViewView;
          if (i == 0) {
            break label1389;
          }
          bool = true;
          label1002:
          ((View)localObject2).setClickable(bool);
          localObject2 = localalav.jdField_a_of_type_AndroidWidgetCheckBox;
          if (!this.jdField_a_of_type_Boolean) {
            break label1395;
          }
          i = 0;
          label1026:
          ((CheckBox)localObject2).setVisibility(i);
          localalav.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          localalav.jdField_b_of_type_AndroidViewView.setTag(localalav);
          if (AppSetting.c) {
            paramView.setContentDescription(((StringBuilder)localObject1).toString());
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView.findViewById(2131379132).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.c, 0);
        break;
        localalav.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break label483;
        label1117:
        localalav.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label796;
        label1130:
        i = ((TroopMemberInfo)localObject3).addState;
        break label841;
        label1140:
        if (i == 3)
        {
          localalav.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          localalav.d.setVisibility(0);
          localalav.d.setText(amtj.a(2131714166));
          if (this.jdField_a_of_type_Boolean)
          {
            localalav.jdField_b_of_type_AndroidViewView.setEnabled(false);
            localalav.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
            localalav.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          }
          i = j;
          if (!AppSetting.c) {
            break label942;
          }
          localalav.d.setContentDescription(amtj.a(2131714165));
          i = j;
          break label942;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localalav.jdField_b_of_type_AndroidViewView.setEnabled(true);
          localalav.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          localalav.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          localalav.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a((TroopMemberInfo)localObject3));
          localalav.jdField_a_of_type_AndroidWidgetCheckBox.setTag(localalav);
          i = k;
        }
        for (;;)
        {
          localalav.d.setVisibility(8);
          break;
          localalav.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          localalav.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131689550));
          j = 1;
          i = j;
          if (AppSetting.c)
          {
            localalav.jdField_a_of_type_AndroidWidgetButton.setContentDescription(amtj.a(2131689550));
            i = j;
          }
        }
        label1377:
        localObject2 = null;
        break label958;
        label1383:
        localObject2 = null;
        break label980;
        label1389:
        bool = false;
        break label1002;
        label1395:
        i = 8;
        break label1026;
        localalav.jdField_b_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.f == TroopAddFrdsInnerFrame.d)
        {
          localalav.e.setVisibility(0);
          localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i]);
          localalav.e.setText((CharSequence)localObject1);
          localalav.e.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691682), new Object[] { ((String)localObject1).toLowerCase() }));
        }
        else
        {
          localalav.e.setVisibility(8);
          paramView.setBackgroundResource(0);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131374108: 
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = (alav)localObject1;
          boolean bool = a(((alav)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
          localObject2 = new ResultRecord();
          ((ResultRecord)localObject2).uin = ((alav)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(localObject2);
          if (!bool) {
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addFriendResults(localArrayList, false);
          }
        }
      case 2131379132: 
        for (;;)
        {
          notifyDataSetChanged();
          break;
          localObject1 = (TroopMemberInfo)localObject1;
          TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (TroopMemberInfo)localObject1, TroopAddFrdsInnerFrame.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame), false);
          break;
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeFriendFromResultList(((alav)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.updateMultiAddState((ResultRecord)localObject2, false);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSelectedAndSearchBar.a(false);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.setupDoneBtn();
        }
        localObject1 = ((alav)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, FriendProfileCardActivity.class);
        ((Intent)localObject2).putExtra("troopUin", ((TroopMemberInfo)localObject1).troopuin);
        ((Intent)localObject2).putExtra("memberUin", ((TroopMemberInfo)localObject1).memberuin);
        ((Intent)localObject2).putExtra("fromFlag", 1);
        ((Intent)localObject2).putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719220));
        ((Intent)localObject2).putExtra("custom_leftbackbutton_name", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131690599));
        aynd.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Intent)localObject2, 9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alaw
 * JD-Core Version:    0.7.0.1
 */
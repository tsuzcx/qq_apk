import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class akzk
  extends alif
{
  private LinkedHashMap<String, List<DiscussionMemberInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public akzk(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame)
  {
    super(paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    b();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    bily localbily = (bily)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(165);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject3;
    label168:
    int i;
    while (localIterator.hasNext())
    {
      localObject3 = (DiscussionMemberInfo)localIterator.next();
      if ((localObject3 != null) && ((localObject3 == null) || (!localbily.f(((DiscussionMemberInfo)localObject3).memberUin)))) {
        if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mIsPutMySelfFirst) && (str != null) && (str.equals(((DiscussionMemberInfo)localObject3).memberUin)))
        {
          localObject1 = localObject3;
        }
        else
        {
          if ((((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst == null) || (((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst.length() == 0))
          {
            localObject2 = "#";
            i = ((String)localObject2).charAt(0);
            if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
              break label273;
            }
          }
          label273:
          for (localObject2 = ((String)localObject2).toUpperCase();; localObject2 = "#")
          {
            if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2) == null) {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject2, new ArrayList());
            }
            ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).add(localObject3);
            break;
            localObject2 = ((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst.substring(0, 1);
            break label168;
          }
        }
      }
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mIsPutMySelfFirst) && (localObject1 != null))
    {
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(localObject1);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(amtj.a(2131702490), localObject3);
    }
    for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
      if (((LinkedHashMap)localObject2).get(String.valueOf(c)) != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject2).get(String.valueOf(c)));
      }
    }
    if (((LinkedHashMap)localObject2).get("#") != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject2).get("#"));
    }
    ((LinkedHashMap)localObject2).clear();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      i = 1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfInt;
        int j = localObject2[i];
        int k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
        localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + 1 + j);
        i += 1;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
        i += 1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559319;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public void a()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localIterator.next())).size() + i) {}
    return i;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (DiscussionMemberInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    akzl localakzl;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562780, paramViewGroup, false);
      localakzl = new akzl(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame, null);
      paramView.setTag(localakzl);
      localakzl.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376577));
      localakzl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379673));
      localakzl.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364530));
      localakzl.c = ((ImageView)paramView.findViewById(2131368236));
      localakzl.b = ((TextView)paramView.findViewById(2131371615));
    }
    for (;;)
    {
      localakzl = (akzl)paramView.getTag();
      Object localObject;
      if (i < 0)
      {
        i = -(i + 1) - 1;
        localObject = (DiscussionMemberInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.isResultListContainFriend(((DiscussionMemberInfo)localObject).memberUin))
        {
          localakzl.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          localakzl.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localakzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localakzl.c.setImageBitmap(a(((DiscussionMemberInfo)localObject).memberUin));
          localakzl.b.setText(ContactUtils.getDiscussionMemberName((DiscussionMemberInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          localakzl.jdField_a_of_type_JavaLangString = ((DiscussionMemberInfo)localObject).memberUin;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mUinsSelectedDefault == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(((DiscussionMemberInfo)localObject).memberUin))) {
            break label418;
          }
          localakzl.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          label316:
          if ((AppSetting.c) && (localakzl.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
          {
            if (!localakzl.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label430;
            }
            paramView.setContentDescription(ContactUtils.getDiscussionMemberName((DiscussionMemberInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + amtj.a(2131702496));
          }
          label382:
          paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localakzl.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label418:
        localakzl.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label316;
        label430:
        paramView.setContentDescription(ContactUtils.getDiscussionMemberName((DiscussionMemberInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + amtj.a(2131702479));
        break label382;
        localakzl.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localakzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localakzl.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localakzl.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691682), new Object[] { ((String)localObject).toLowerCase() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzk
 * JD-Core Version:    0.7.0.1
 */
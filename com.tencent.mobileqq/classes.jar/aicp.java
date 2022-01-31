import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class aicp
  extends ailz
{
  private LinkedHashMap<String, List<PhoneContact>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public aicp(ContactsInnerFrame paramContactsInnerFrame, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramBoolean);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame.jdField_a_of_type_JavaUtilList.iterator();
      label77:
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if ((localPhoneContact.pinyinFirst == null) || (localPhoneContact.pinyinFirst.length() == 0))
        {
          localObject1 = "#";
          i = ((String)localObject1).charAt(0);
          if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
            break label182;
          }
        }
        label182:
        for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
        {
          if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localPhoneContact);
          break;
          localObject1 = localPhoneContact.pinyinFirst.substring(0, 1);
          break label77;
        }
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject1).get(String.valueOf(c)));
        }
      }
      if (((LinkedHashMap)localObject1).get("#") != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject1).get("#"));
      }
      ((LinkedHashMap)localObject1).clear();
      this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (this.jdField_a_of_type_ArrayOfInt.length != 0)
      {
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
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559194;
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
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1);
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  protected boolean a(aimt paramaimt)
  {
    boolean bool2 = super.a(paramaimt);
    boolean bool1 = bool2;
    if ((paramaimt instanceof aidz))
    {
      paramaimt = (aidz)paramaimt;
      if ((bool2) && (!paramaimt.jdField_a_of_type_Boolean)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
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
    return (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = aidz.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater, 2131562407);
    }
    aidz localaidz = (aidz)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramViewGroup = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      paramInt = paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1;
      PhoneContact localPhoneContact = (PhoneContact)paramViewGroup.get(paramInt);
      aidz.a(this, localaidz, localPhoneContact);
      if (paramInt - 1 < 0)
      {
        paramView = null;
        if (paramInt + 1 <= paramViewGroup.size() - 1) {
          break label365;
        }
        paramViewGroup = localObject;
        label134:
        if (((paramView == null) || (paramView.contactID != localPhoneContact.contactID)) && ((paramViewGroup == null) || (paramViewGroup.contactID != localPhoneContact.contactID))) {
          break label381;
        }
        localaidz.d.setVisibility(0);
        localaidz.d.setText(localPhoneContact.mobileNo);
        label188:
        localaidz.b.setText(localPhoneContact.name);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(localaidz.jdField_a_of_type_JavaLangString)) {
          break label394;
        }
        localaidz.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        label228:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localPhoneContact.uin))) {
          break label406;
        }
        localaidz.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        label271:
        if ((AppSetting.d) && (localaidz.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
        {
          if (!localaidz.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label418;
          }
          localView.setContentDescription(localPhoneContact.name + ajya.a(2131702565));
        }
      }
      for (;;)
      {
        localaidz.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = localPhoneContact;
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame);
        return localView;
        paramView = (PhoneContact)paramViewGroup.get(paramInt - 1);
        break;
        label365:
        paramViewGroup = (PhoneContact)paramViewGroup.get(paramInt + 1);
        break label134;
        label381:
        localaidz.d.setVisibility(8);
        break label188;
        label394:
        localaidz.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break label228;
        label406:
        localaidz.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label271;
        label418:
        localView.setContentDescription(localPhoneContact.name + ajya.a(2131702537));
      }
    }
    localaidz.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    localaidz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramView = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    localaidz.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    localaidz.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691898), new Object[] { paramView.toLowerCase() }));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aicp
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class aimf
  extends ailz
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public aimj a;
  private ajxl jdField_a_of_type_Ajxl;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PhoneContact jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
  public IndexView a;
  private LinkedHashMap<String, List<PhoneContact>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public List<PhoneContact> a;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  int jdField_b_of_type_Int = 0;
  private List<PhoneContact> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<PhoneContact> c = new ArrayList();
  
  public aimf(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<PhoneContact> paramList)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131297962);
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131297963);
    a(paramList);
  }
  
  public static aimi a(List<PhoneContact> paramList, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    aimi localaimi = new aimi();
    localaimi.jdField_a_of_type_JavaUtilList = ((List)localObject);
    label52:
    label53:
    PhoneContact localPhoneContact;
    if (paramArrayList != null)
    {
      paramList = (List)paramArrayList.clone();
      Iterator localIterator = ((List)localObject).iterator();
      break label193;
      if (!localIterator.hasNext()) {
        break label307;
      }
      localPhoneContact = (PhoneContact)localIterator.next();
      if (!TextUtils.isEmpty(localPhoneContact.pinyinFirst)) {
        break label285;
      }
      paramArrayList = "#";
      label89:
      i = paramArrayList.charAt(0);
      if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
        break label301;
      }
    }
    label285:
    label301:
    for (paramArrayList = paramArrayList.toUpperCase();; paramArrayList = "#")
    {
      if (localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList) == null) {
        localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramArrayList, new ArrayList());
      }
      ((List)localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList)).add(localPhoneContact);
      if ((paramList == null) || (!paramBoolean)) {
        break label53;
      }
      paramArrayList = paramList.iterator();
      label193:
      if (!paramArrayList.hasNext()) {
        break label53;
      }
      if (!TextUtils.equals(((PhoneContact)paramArrayList.next()).unifiedCode, localPhoneContact.unifiedCode)) {
        break label52;
      }
      if (localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
        localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
      }
      ((List)localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).add(localPhoneContact);
      break label53;
      paramList = null;
      break;
      paramArrayList = String.valueOf(localPhoneContact.pinyinFirst.charAt(0));
      break label89;
    }
    label307:
    if (paramList != null)
    {
      localaimi.jdField_b_of_type_JavaUtilList = paramList;
      if (!paramBoolean)
      {
        if (localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
          localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
        }
        ((List)localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).addAll(paramList);
      }
    }
    paramArrayList = localaimi.jdField_a_of_type_JavaUtilLinkedHashMap;
    localaimi.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (paramArrayList.get(String.valueOf(c1)) != null) {
        localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c1), paramArrayList.get(String.valueOf(c1)));
      }
    }
    if (paramArrayList.get("#") != null) {
      localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", paramArrayList.get("#"));
    }
    if ((paramList != null) && ((((List)localObject).size() > 10) || (!paramBoolean)) && (paramArrayList.get("★") != null)) {
      localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", paramList);
    }
    paramArrayList.clear();
    localaimi.jdField_a_of_type_ArrayOfInt = new int[localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    localaimi.jdField_a_of_type_ArrayOfJavaLangString = new String[localaimi.jdField_a_of_type_ArrayOfInt.length];
    paramList = new ArrayList(localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.keySet());
    Collections.sort(paramList, new aimg());
    paramArrayList = paramList.iterator();
    if (localaimi.jdField_a_of_type_ArrayOfInt.length == 0) {
      return localaimi;
    }
    localaimi.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < localaimi.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject = localaimi.jdField_a_of_type_ArrayOfInt;
      int j = localObject[i];
      int k = localaimi.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject[i] = (((List)localaimi.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList.next())).size() + k + 1 + j);
      i += 1;
    }
    paramList = paramList.iterator();
    i = 0;
    while (paramList.hasNext())
    {
      localaimi.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)paramList.next());
      i += 1;
    }
    return localaimi;
  }
  
  private boolean a(PhoneContact paramPhoneContact)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
        if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
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
  
  public void a(aimi paramaimi)
  {
    this.jdField_b_of_type_JavaUtilList = paramaimi.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = paramaimi.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramaimi.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramaimi.jdField_a_of_type_ArrayOfJavaLangString;
    this.c = paramaimi.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length) && (paramInt >= 0)) {
      ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {}
    }
    for (;;)
    {
      if (paramBoolean) {
        if (i == -1)
        {
          this.jdField_a_of_type_JavaUtilList.add(paramPhoneContact);
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
  
  public void a(List<PhoneContact> paramList)
  {
    a(a(paramList, null, true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    Object localObject1;
    Object localObject2;
    label262:
    label368:
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new aimh();
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560704, null);
      ((aimh)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131370832));
      ((aimh)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131361795));
      ((aimh)localObject1).b = ((TextView)((View)localObject2).findViewById(2131375196));
      ((aimh)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131376341));
      ((aimh)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131375183));
      ((aimh)localObject1).d = ((TextView)((View)localObject2).findViewById(2131375193));
      ((aimh)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject2).findViewById(2131364190));
      ((aimh)localObject1).e = ((TextView)((View)localObject2).findViewById(2131378223));
      ((aimh)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2).findViewById(2131373006);
      ((View)localObject2).setBackgroundDrawable(null);
      ((View)localObject2).setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      paramView = (View)localObject2;
      if ((((aimh)localObject1).jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView))
      {
        ((ThemeImageView)((aimh)localObject1).jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        paramView = (View)localObject2;
        paramViewGroup = (ViewGroup)localObject1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0)) {
        break label749;
      }
      paramView.findViewById(2131375189).setPadding(0, 0, this.jdField_a_of_type_Int, 0);
      if (i >= 0) {
        break label1039;
      }
      i = -(i + 1) - 1;
      localObject1 = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject1);
      if ((this.c.isEmpty()) || ("★".equals(this.jdField_a_of_type_ArrayOfJavaLangString[i])) || (!((PhoneContact)localObject1).isNewRecommend)) {
        break label769;
      }
      afjt.a(paramView, true);
      afjt.b(paramViewGroup.jdField_a_of_type_AndroidViewView, true);
      localObject2 = new StringBuilder(256);
      if (TextUtils.isEmpty(((PhoneContact)localObject1).name)) {
        break label785;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
      if (AppSetting.d)
      {
        baww.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, false);
        ((StringBuilder)localObject2).append(((PhoneContact)localObject1).name);
      }
      label436:
      paramViewGroup.b.setVisibility(8);
      if (((PhoneContact)localObject1).samFriend <= 0) {
        break label797;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject3 = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691075), new Object[] { Integer.valueOf(((PhoneContact)localObject1).samFriend) });
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (AppSetting.d) {
        ((StringBuilder)localObject2).append(",").append((String)localObject3);
      }
      label534:
      if ((TextUtils.isEmpty(((PhoneContact)localObject1).uin)) || (((PhoneContact)localObject1).uin.equals("0"))) {
        break label809;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText(ajya.a(2131702473));
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(false);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if (AppSetting.d) {
        paramViewGroup.d.setContentDescription(ajya.a(2131702468));
      }
      label639:
      localObject3 = paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox;
      if (!this.jdField_a_of_type_Boolean) {
        break label1033;
      }
    }
    label769:
    label1033:
    for (paramInt = 0;; paramInt = 8)
    {
      ((CheckBox)localObject3).setVisibility(paramInt);
      if (AppSetting.d) {
        paramView.setContentDescription(((StringBuilder)localObject2).toString());
      }
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((PhoneContact)localObject1).unifiedCode, 11, (byte)0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
      return paramView;
      paramViewGroup = (aimh)paramView.getTag();
      break;
      label749:
      paramView.findViewById(2131375189).setPadding(0, 0, this.jdField_b_of_type_Int, 0);
      break label262;
      afjt.a(paramView, false);
      afjt.b(paramViewGroup.jdField_a_of_type_AndroidViewView, false);
      break label368;
      label785:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label436;
      label797:
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label534;
      label809:
      if (this.jdField_a_of_type_Ajxl.a(((PhoneContact)localObject1).unifiedCode, true))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(ajya.a(2131702471));
        if (this.jdField_a_of_type_Boolean)
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (!AppSetting.d) {
          break label639;
        }
        paramViewGroup.d.setContentDescription(ajya.a(2131702477));
        break label639;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a((PhoneContact)localObject1));
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(true);
        paramViewGroup.d.setVisibility(8);
        break;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131689628));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        if (AppSetting.d) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajya.a(2131689628));
        }
      }
    }
    label1039:
    paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(null);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.e.setVisibility(0);
    paramViewGroup.e.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof ContactBindedActivity)) {
        ((ContactBindedActivity)this.jdField_a_of_type_AndroidContentContext).d();
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131373006: 
        if (!this.jdField_a_of_type_Boolean) {
          break label717;
        }
        paramView = (aimh)localObject;
        bool2 = a(paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact);
        localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (bool2) {
          break label705;
        }
        bool1 = true;
        a((PhoneContact)localObject, bool1);
      }
    } while (this.jdField_a_of_type_Aimj == null);
    localObject = this.jdField_a_of_type_Aimj;
    paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    label136:
    int j;
    if (!bool2)
    {
      bool1 = true;
      ((aimj)localObject).a(paramView, bool1);
      return;
      localObject = (PhoneContact)localObject;
      paramView = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (!((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false)) {
        break label953;
      }
      j = 1;
    }
    for (int i = 3084;; i = 3006)
    {
      label295:
      ContactBindedActivity localContactBindedActivity;
      if (!paramView.h()) {
        if (this.c.contains(localObject))
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
          j = 16;
          i = 3006;
          ((PhoneContact)localObject).isNewRecommend = false;
          if ((this.jdField_a_of_type_AndroidContentContext instanceof ContactBindedActivity))
          {
            localContactBindedActivity = (ContactBindedActivity)this.jdField_a_of_type_AndroidContentContext;
            if (!TextUtils.isEmpty(((PhoneContact)localObject).pinyinFirst)) {
              break label686;
            }
          }
        }
      }
      label686:
      for (paramView = "#";; paramView = String.valueOf(((PhoneContact)localObject).pinyinFirst.charAt(0)).toUpperCase())
      {
        paramView = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramView);
        if ((paramView != null) && (!paramView.isEmpty()))
        {
          localContactBindedActivity.jdField_a_of_type_Int = paramView.indexOf(localObject);
          if (localContactBindedActivity.jdField_a_of_type_Int != -1) {
            localContactBindedActivity.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject);
          }
        }
        paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((PhoneContact)localObject).unifiedCode, null, i, j, ((PhoneContact)localObject).name, null, null, ajya.a(2131702474), null);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
        notifyDataSetChanged();
        return;
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
        break;
        if (this.c.isEmpty())
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
          break label295;
        }
        if (this.c.contains(localObject)) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
          break;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
        }
      }
      label705:
      bool1 = false;
      break;
      bool1 = false;
      break label136;
      label717:
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((aimh)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.isNewRecommend = false;
        localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) || ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))) {
          break label865;
        }
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin, 30);
        paramView.k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
        paramView.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
        if ((!((PhoneContactManagerImp)localObject).h()) || (!this.c.isEmpty())) {
          break label919;
        }
        paramView.jdField_h_of_type_Int = 104;
      }
      for (;;)
      {
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, paramView);
        notifyDataSetChanged();
        return;
        label865:
        if (((PhoneContactManagerImp)localObject).h())
        {
          paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 34);
          break;
        }
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 29);
        paramView.l = 16;
        break;
        label919:
        if (this.c.contains(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact)) {
          paramView.jdField_h_of_type_Int = 101;
        } else {
          paramView.jdField_h_of_type_Int = 102;
        }
      }
      label953:
      j = 13;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aimf
 * JD-Core Version:    0.7.0.1
 */
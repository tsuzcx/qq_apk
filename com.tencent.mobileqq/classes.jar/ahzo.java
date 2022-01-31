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

public class ahzo
  extends ahzi
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public ahzs a;
  private ajjj jdField_a_of_type_Ajjj;
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
  
  public ahzo(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<PhoneContact> paramList)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajjj = ((ajjj)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131166872);
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131166873);
    a(paramList);
  }
  
  public static ahzr a(List<PhoneContact> paramList, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ahzr localahzr = new ahzr();
    localahzr.jdField_a_of_type_JavaUtilList = ((List)localObject);
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
      if (localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList) == null) {
        localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramArrayList, new ArrayList());
      }
      ((List)localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList)).add(localPhoneContact);
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
      if (localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
        localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
      }
      ((List)localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).add(localPhoneContact);
      break label53;
      paramList = null;
      break;
      paramArrayList = String.valueOf(localPhoneContact.pinyinFirst.charAt(0));
      break label89;
    }
    label307:
    if (paramList != null)
    {
      localahzr.jdField_b_of_type_JavaUtilList = paramList;
      if (!paramBoolean)
      {
        if (localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
          localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
        }
        ((List)localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).addAll(paramList);
      }
    }
    paramArrayList = localahzr.jdField_a_of_type_JavaUtilLinkedHashMap;
    localahzr.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (paramArrayList.get(String.valueOf(c1)) != null) {
        localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c1), paramArrayList.get(String.valueOf(c1)));
      }
    }
    if (paramArrayList.get("#") != null) {
      localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", paramArrayList.get("#"));
    }
    if ((paramList != null) && ((((List)localObject).size() > 10) || (!paramBoolean)) && (paramArrayList.get("★") != null)) {
      localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", paramList);
    }
    paramArrayList.clear();
    localahzr.jdField_a_of_type_ArrayOfInt = new int[localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    localahzr.jdField_a_of_type_ArrayOfJavaLangString = new String[localahzr.jdField_a_of_type_ArrayOfInt.length];
    paramList = new ArrayList(localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.keySet());
    Collections.sort(paramList, new ahzp());
    paramArrayList = paramList.iterator();
    if (localahzr.jdField_a_of_type_ArrayOfInt.length == 0) {
      return localahzr;
    }
    localahzr.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < localahzr.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject = localahzr.jdField_a_of_type_ArrayOfInt;
      int j = localObject[i];
      int k = localahzr.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject[i] = (((List)localahzr.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList.next())).size() + k + 1 + j);
      i += 1;
    }
    paramList = paramList.iterator();
    i = 0;
    while (paramList.hasNext())
    {
      localahzr.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)paramList.next());
      i += 1;
    }
    return localahzr;
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
      return 2131493625;
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
  
  public void a(ahzr paramahzr)
  {
    this.jdField_b_of_type_JavaUtilList = paramahzr.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = paramahzr.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramahzr.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramahzr.jdField_a_of_type_ArrayOfJavaLangString;
    this.c = paramahzr.jdField_b_of_type_JavaUtilList;
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
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
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
      localObject1 = new ahzq();
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495130, null);
      ((ahzq)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131305159));
      ((ahzq)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131296259));
      ((ahzq)localObject1).b = ((TextView)((View)localObject2).findViewById(2131309446));
      ((ahzq)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131310547));
      ((ahzq)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131309433));
      ((ahzq)localObject1).d = ((TextView)((View)localObject2).findViewById(2131309443));
      ((ahzq)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject2).findViewById(2131298633));
      ((ahzq)localObject1).e = ((TextView)((View)localObject2).findViewById(2131312394));
      ((ahzq)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2).findViewById(2131307294);
      ((View)localObject2).setBackgroundDrawable(null);
      ((View)localObject2).setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      paramView = (View)localObject2;
      if ((((ahzq)localObject1).jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView))
      {
        ((ThemeImageView)((ahzq)localObject1).jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        paramView = (View)localObject2;
        paramViewGroup = (ViewGroup)localObject1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0)) {
        break label749;
      }
      paramView.findViewById(2131309439).setPadding(0, 0, this.jdField_a_of_type_Int, 0);
      if (i >= 0) {
        break label1039;
      }
      i = -(i + 1) - 1;
      localObject1 = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject1);
      if ((this.c.isEmpty()) || ("★".equals(this.jdField_a_of_type_ArrayOfJavaLangString[i])) || (!((PhoneContact)localObject1).isNewRecommend)) {
        break label769;
      }
      aeyf.a(paramView, true);
      aeyf.b(paramViewGroup.jdField_a_of_type_AndroidViewView, true);
      localObject2 = new StringBuilder(256);
      if (TextUtils.isEmpty(((PhoneContact)localObject1).name)) {
        break label785;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
      if (AppSetting.c)
      {
        azve.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, false);
        ((StringBuilder)localObject2).append(((PhoneContact)localObject1).name);
      }
      label436:
      paramViewGroup.b.setVisibility(8);
      if (((PhoneContact)localObject1).samFriend <= 0) {
        break label797;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject3 = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131625503), new Object[] { Integer.valueOf(((PhoneContact)localObject1).samFriend) });
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (AppSetting.c) {
        ((StringBuilder)localObject2).append(",").append((String)localObject3);
      }
      label534:
      if ((TextUtils.isEmpty(((PhoneContact)localObject1).uin)) || (((PhoneContact)localObject1).uin.equals("0"))) {
        break label809;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText(ajjy.a(2131636678));
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(false);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if (AppSetting.c) {
        paramViewGroup.d.setContentDescription(ajjy.a(2131636673));
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
      if (AppSetting.c) {
        paramView.setContentDescription(((StringBuilder)localObject2).toString());
      }
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((PhoneContact)localObject1).unifiedCode, 11, (byte)0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(paramViewGroup);
      return paramView;
      paramViewGroup = (ahzq)paramView.getTag();
      break;
      label749:
      paramView.findViewById(2131309439).setPadding(0, 0, this.jdField_b_of_type_Int, 0);
      break label262;
      aeyf.a(paramView, false);
      aeyf.b(paramViewGroup.jdField_a_of_type_AndroidViewView, false);
      break label368;
      label785:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label436;
      label797:
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label534;
      label809:
      if (this.jdField_a_of_type_Ajjj.a(((PhoneContact)localObject1).unifiedCode, true))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(ajjy.a(2131636676));
        if (this.jdField_a_of_type_Boolean)
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (!AppSetting.c) {
          break label639;
        }
        paramViewGroup.d.setContentDescription(ajjy.a(2131636682));
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
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131624088));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        if (AppSetting.c) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajjy.a(2131624088));
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
      case 2131307294: 
        if (!this.jdField_a_of_type_Boolean) {
          break label717;
        }
        paramView = (ahzq)localObject;
        bool2 = a(paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact);
        localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (bool2) {
          break label705;
        }
        bool1 = true;
        a((PhoneContact)localObject, bool1);
      }
    } while (this.jdField_a_of_type_Ahzs == null);
    localObject = this.jdField_a_of_type_Ahzs;
    paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    label136:
    int j;
    if (!bool2)
    {
      bool1 = true;
      ((ahzs)localObject).a(paramView, bool1);
      return;
      localObject = (PhoneContact)localObject;
      paramView = (aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
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
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
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
        paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((PhoneContact)localObject).unifiedCode, null, i, j, ((PhoneContact)localObject).name, null, null, ajjy.a(2131636679), null);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
        notifyDataSetChanged();
        return;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
        break;
        if (this.c.isEmpty())
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
          break label295;
        }
        if (this.c.contains(localObject)) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
          break;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
        }
      }
      label705:
      bool1 = false;
      break;
      bool1 = false;
      break label136;
      label717:
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((ahzq)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
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
 * Qualified Name:     ahzo
 * JD-Core Version:    0.7.0.1
 */